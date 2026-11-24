package com.ibm.icu.text;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UProperty;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import defpackage.og;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class SpoofChecker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ALL_CHECKS = -1;

    @Deprecated
    public static final int ANY_CASE = 8;
    public static final int CHAR_LIMIT = 64;
    public static final int CONFUSABLE = 7;
    public static final int HIDDEN_OVERLAY = 256;
    public static final int INVISIBLE = 32;
    public static final int MIXED_NUMBERS = 128;
    public static final int MIXED_SCRIPT_CONFUSABLE = 2;
    public static final int RESTRICTION_LEVEL = 16;

    @Deprecated
    public static final int SINGLE_SCRIPT = 16;
    public static final int SINGLE_SCRIPT_CONFUSABLE = 1;
    public static final int WHOLE_SCRIPT_CONFUSABLE = 4;
    private UnicodeSet fAllowedCharsSet;
    private Set<ULocale> fAllowedLocales;
    private int fChecks;
    private RestrictionLevel fRestrictionLevel;
    private SpoofData fSpoofData;
    public static final UnicodeSet INCLUSION = new UnicodeSet().applyIntPropertyValue(UProperty.IDENTIFIER_TYPE, UCharacter.IdentifierType.INCLUSION.ordinal()).freeze();
    public static final UnicodeSet RECOMMENDED = new UnicodeSet().applyIntPropertyValue(UProperty.IDENTIFIER_TYPE, UCharacter.IdentifierType.RECOMMENDED.ordinal()).freeze();
    static final UnicodeSet ASCII = new UnicodeSet(0, 127).freeze();
    private static Normalizer2 nfdNormalizer = Normalizer2.getNFDInstance();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CheckResult {
        public UnicodeSet numerics;
        public RestrictionLevel restrictionLevel;
        public int checks = 0;

        @Deprecated
        public int position = 0;

        public String toString() {
            StringBuilder sb = new StringBuilder("checks:");
            int i = this.checks;
            if (i == 0) {
                sb.append(" none");
            } else if (i == -1) {
                sb.append(" all");
            } else {
                if ((i & 1) != 0) {
                    sb.append(" SINGLE_SCRIPT_CONFUSABLE");
                }
                if ((this.checks & 2) != 0) {
                    sb.append(" MIXED_SCRIPT_CONFUSABLE");
                }
                if ((this.checks & 4) != 0) {
                    sb.append(" WHOLE_SCRIPT_CONFUSABLE");
                }
                if ((this.checks & 8) != 0) {
                    sb.append(" ANY_CASE");
                }
                if ((this.checks & 16) != 0) {
                    sb.append(" RESTRICTION_LEVEL");
                }
                if ((this.checks & 32) != 0) {
                    sb.append(" INVISIBLE");
                }
                if ((this.checks & 64) != 0) {
                    sb.append(" CHAR_LIMIT");
                }
                if ((this.checks & 128) != 0) {
                    sb.append(" MIXED_NUMBERS");
                }
            }
            sb.append(", numerics: ");
            sb.append(this.numerics.toPattern(false));
            sb.append(", position: ");
            sb.append(this.position);
            sb.append(", restrictionLevel: ");
            sb.append(this.restrictionLevel);
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ConfusableDataUtils {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int FORMAT_VERSION = 2;

        private ConfusableDataUtils() {
        }

        public static final int codePointAndLengthToKey(int i, int i2) {
            return i | ((i2 - 1) << 24);
        }

        public static final int keyToCodePoint(int i) {
            return i & 16777215;
        }

        public static final int keyToLength(int i) {
            return ((i & (-16777216)) >> 24) + 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum RestrictionLevel {
        ASCII,
        SINGLE_SCRIPT_RESTRICTIVE,
        HIGHLY_RESTRICTIVE,
        MODERATELY_RESTRICTIVE,
        MINIMALLY_RESTRICTIVE,
        UNRESTRICTIVE
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ScriptSet extends BitSet {
        private static final long serialVersionUID = 1;

        public void and(int i) {
            clear(0, i);
            clear(i + 1, 215);
        }

        public void appendStringTo(StringBuilder sb) {
            sb.append("{ ");
            if (isEmpty()) {
                sb.append("- ");
            } else if (isFull()) {
                sb.append("* ");
            } else {
                for (int i = 0; i < 215; i++) {
                    if (get(i)) {
                        sb.append(UScript.getShortName(i));
                        sb.append(Padder.FALLBACK_PADDING_STRING);
                    }
                }
            }
            sb.append("}");
        }

        public boolean isFull() {
            return cardinality() == 215;
        }

        public void setAll() {
            set(0, 215);
        }

        @Override // java.util.BitSet
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("<ScriptSet ");
            appendStringTo(sb);
            sb.append(">");
            return sb.toString();
        }
    }

    public /* synthetic */ SpoofChecker(int i) {
        this();
    }

    private static void getAugmentedScriptSet(int i, ScriptSet scriptSet) {
        scriptSet.clear();
        UScript.getScriptExtensions(i, scriptSet);
        if (scriptSet.get(17)) {
            scriptSet.set(172);
            scriptSet.set(105);
            scriptSet.set(119);
        }
        if (scriptSet.get(20)) {
            scriptSet.set(105);
        }
        if (scriptSet.get(22)) {
            scriptSet.set(105);
        }
        if (scriptSet.get(18)) {
            scriptSet.set(119);
        }
        if (scriptSet.get(5)) {
            scriptSet.set(172);
        }
        if (scriptSet.get(0) || scriptSet.get(1)) {
            scriptSet.setAll();
        }
    }

    private void getNumerics(String str, UnicodeSet unicodeSet) {
        unicodeSet.clear();
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = Character.codePointAt(str, iCharCount);
            iCharCount += Character.charCount(iCodePointAt);
            if (UCharacter.getType(iCodePointAt) == 9) {
                unicodeSet.add(iCodePointAt - UCharacter.getNumericValue(iCodePointAt));
            }
        }
    }

    private void getResolvedScriptSet(CharSequence charSequence, ScriptSet scriptSet) {
        getResolvedScriptSetWithout(charSequence, 215, scriptSet);
    }

    private void getResolvedScriptSetWithout(CharSequence charSequence, int i, ScriptSet scriptSet) {
        scriptSet.setAll();
        ScriptSet scriptSet2 = new ScriptSet();
        int iCharCount = 0;
        while (iCharCount < charSequence.length()) {
            int iCodePointAt = Character.codePointAt(charSequence, iCharCount);
            iCharCount += Character.charCount(iCodePointAt);
            getAugmentedScriptSet(iCodePointAt, scriptSet2);
            if (i == 215 || !scriptSet2.get(i)) {
                scriptSet.and(scriptSet2);
            }
        }
    }

    private RestrictionLevel getRestrictionLevel(String str) {
        if (!this.fAllowedCharsSet.containsAll(str)) {
            return RestrictionLevel.UNRESTRICTIVE;
        }
        if (ASCII.containsAll(str)) {
            return RestrictionLevel.ASCII;
        }
        ScriptSet scriptSet = new ScriptSet();
        getResolvedScriptSet(str, scriptSet);
        if (!scriptSet.isEmpty()) {
            return RestrictionLevel.SINGLE_SCRIPT_RESTRICTIVE;
        }
        ScriptSet scriptSet2 = new ScriptSet();
        getResolvedScriptSetWithout(str, 25, scriptSet2);
        if (scriptSet2.get(172) || scriptSet2.get(105) || scriptSet2.get(119)) {
            return RestrictionLevel.HIGHLY_RESTRICTIVE;
        }
        return (scriptSet2.isEmpty() || scriptSet2.get(8) || scriptSet2.get(14) || scriptSet2.get(6)) ? RestrictionLevel.MINIMALLY_RESTRICTIVE : RestrictionLevel.MODERATELY_RESTRICTIVE;
    }

    public int areConfusable(String str, String str2) {
        int i;
        if ((this.fChecks & 7) == 0) {
            og.i("No confusable checks are enabled.");
            return 0;
        }
        if (!getSkeleton(str).equals(getSkeleton(str2))) {
            return 0;
        }
        ScriptSet scriptSet = new ScriptSet();
        getResolvedScriptSet(str, scriptSet);
        ScriptSet scriptSet2 = new ScriptSet();
        getResolvedScriptSet(str2, scriptSet2);
        if (scriptSet.intersects(scriptSet2)) {
            i = 1;
        } else {
            i = (scriptSet.isEmpty() || scriptSet2.isEmpty()) ? 2 : 6;
        }
        return this.fChecks & i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SpoofChecker)) {
            return false;
        }
        SpoofChecker spoofChecker = (SpoofChecker) obj;
        SpoofData spoofData = this.fSpoofData;
        if ((spoofData != null && !spoofData.equals(spoofChecker.fSpoofData)) || this.fChecks != spoofChecker.fChecks) {
            return false;
        }
        Set<ULocale> set = this.fAllowedLocales;
        if (set != null && !set.equals(spoofChecker.fAllowedLocales)) {
            return false;
        }
        UnicodeSet unicodeSet = this.fAllowedCharsSet;
        return (unicodeSet == null || unicodeSet.equals(spoofChecker.fAllowedCharsSet)) && this.fRestrictionLevel == spoofChecker.fRestrictionLevel;
    }

    public boolean failsChecks(String str, CheckResult checkResult) {
        int i;
        int length = str.length();
        if (checkResult != null) {
            checkResult.position = 0;
            checkResult.numerics = null;
            checkResult.restrictionLevel = null;
        }
        if ((this.fChecks & 16) != 0) {
            RestrictionLevel restrictionLevel = getRestrictionLevel(str);
            i = restrictionLevel.compareTo(this.fRestrictionLevel) <= 0 ? 0 : 16;
            if (checkResult != null) {
                checkResult.restrictionLevel = restrictionLevel;
            }
        } else {
            i = 0;
        }
        if ((this.fChecks & 128) != 0) {
            UnicodeSet unicodeSet = new UnicodeSet();
            getNumerics(str, unicodeSet);
            if (unicodeSet.size() > 1) {
                i |= 128;
            }
            if (checkResult != null) {
                checkResult.numerics = unicodeSet;
            }
        }
        if ((this.fChecks & 256) != 0 && findHiddenOverlay(str) != -1) {
            i |= 256;
        }
        if ((this.fChecks & 64) != 0) {
            int iOffsetByCodePoints = 0;
            while (iOffsetByCodePoints < length) {
                int iCodePointAt = Character.codePointAt(str, iOffsetByCodePoints);
                iOffsetByCodePoints = Character.offsetByCodePoints(str, iOffsetByCodePoints, 1);
                if (!this.fAllowedCharsSet.contains(iCodePointAt)) {
                    i |= 64;
                    break;
                }
            }
        }
        if ((this.fChecks & 32) != 0) {
            String strNormalize = nfdNormalizer.normalize(str);
            UnicodeSet unicodeSet2 = new UnicodeSet();
            int iOffsetByCodePoints2 = 0;
            int i2 = 0;
            loop1: while (true) {
                int i3 = i2;
                while (true) {
                    if (iOffsetByCodePoints2 >= length) {
                        break loop1;
                    }
                    int iCodePointAt2 = Character.codePointAt(strNormalize, iOffsetByCodePoints2);
                    iOffsetByCodePoints2 = Character.offsetByCodePoints(strNormalize, iOffsetByCodePoints2, 1);
                    if (Character.getType(iCodePointAt2) != 6) {
                        if (i3 != 0) {
                            break;
                        }
                        i2 = 0;
                    } else if (i2 == 0) {
                        i2 = iCodePointAt2;
                    } else {
                        if (i3 == 0) {
                            unicodeSet2.add(i2);
                            i3 = 1;
                        }
                        if (unicodeSet2.contains(iCodePointAt2)) {
                            i |= 32;
                            break loop1;
                        }
                        unicodeSet2.add(iCodePointAt2);
                    }
                }
                unicodeSet2.clear();
                i2 = 0;
            }
        }
        if (checkResult != null) {
            checkResult.checks = i;
        }
        return i != 0;
    }

    public int findHiddenOverlay(String str) {
        StringBuilder sb = new StringBuilder();
        int iCharCount = 0;
        boolean zIsIllegalCombiningDotLeadCharacter = false;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (zIsIllegalCombiningDotLeadCharacter && iCodePointAt == 775) {
                return iCharCount;
            }
            int combiningClass = UCharacter.getCombiningClass(iCodePointAt);
            if (combiningClass == 0 || combiningClass == 230) {
                zIsIllegalCombiningDotLeadCharacter = isIllegalCombiningDotLeadCharacter(iCodePointAt, sb);
            }
            iCharCount += UCharacter.charCount(iCodePointAt);
        }
        return -1;
    }

    public UnicodeSet getAllowedChars() {
        return this.fAllowedCharsSet;
    }

    public Set<Locale> getAllowedJavaLocales() {
        HashSet hashSet = new HashSet(this.fAllowedLocales.size());
        Iterator<ULocale> it = this.fAllowedLocales.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().toLocale());
        }
        return hashSet;
    }

    public Set<ULocale> getAllowedLocales() {
        return Collections.unmodifiableSet(this.fAllowedLocales);
    }

    public String getBidiSkeleton(int i, CharSequence charSequence) {
        if (i == 0 || i == 1) {
            return getSkeleton(new Bidi(charSequence.toString(), i).writeReordered(3));
        }
        og.i("direction should be DIRECTION_LEFT_TO_RIGHT or DIRECTION_RIGHT_TO_LEFT");
        return null;
    }

    public int getChecks() {
        return this.fChecks;
    }

    public String getSkeleton(CharSequence charSequence) {
        String strNormalize = nfdNormalizer.normalize(charSequence);
        int length = strNormalize.length();
        StringBuilder sb = new StringBuilder();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = Character.codePointAt(strNormalize, iCharCount);
            iCharCount += Character.charCount(iCodePointAt);
            if (!UCharacter.hasBinaryProperty(iCodePointAt, 5)) {
                this.fSpoofData.confusableLookup(iCodePointAt, sb);
            }
        }
        return nfdNormalizer.normalize(sb.toString());
    }

    public int hashCode() {
        return this.fRestrictionLevel.ordinal() ^ (((this.fChecks ^ this.fSpoofData.hashCode()) ^ this.fAllowedLocales.hashCode()) ^ this.fAllowedCharsSet.hashCode());
    }

    public boolean isIllegalCombiningDotLeadCharacter(int i, StringBuilder sb) {
        if (isIllegalCombiningDotLeadCharacterNoLookup(i)) {
            return true;
        }
        sb.setLength(0);
        this.fSpoofData.confusableLookup(i, sb);
        int iCodePointBefore = UCharacter.codePointBefore(sb, sb.length());
        return iCodePointBefore != i && isIllegalCombiningDotLeadCharacterNoLookup(iCodePointBefore);
    }

    public boolean isIllegalCombiningDotLeadCharacterNoLookup(int i) {
        return i == 105 || i == 106 || i == 305 || i == 567 || i == 108 || UCharacter.hasBinaryProperty(i, 27);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SpoofData {
        private static final int DATA_FORMAT = 1130788128;
        private static final IsAcceptable IS_ACCEPTABLE = new IsAcceptable(0);
        int[] fCFUKeys;
        String fCFUStrings;
        short[] fCFUValues;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static final class DefaultData {
            private static IOException EXCEPTION;
            private static SpoofData INSTANCE;

            static {
                try {
                    INSTANCE = new SpoofData(ICUBinary.getRequiredData("confusables.cfu"), 0);
                } catch (IOException e) {
                    EXCEPTION = e;
                }
            }

            private DefaultData() {
            }
        }

        private SpoofData(ByteBuffer byteBuffer) throws IOException {
            ICUBinary.readHeader(byteBuffer, DATA_FORMAT, IS_ACCEPTABLE);
            readData(byteBuffer);
        }

        public static SpoofData getDefault() {
            if (DefaultData.EXCEPTION == null) {
                return DefaultData.INSTANCE;
            }
            throw new MissingResourceException(cq.j("Could not load default confusables data: ", DefaultData.EXCEPTION.getMessage()), "SpoofChecker", "");
        }

        private void readData(ByteBuffer byteBuffer) {
            if (byteBuffer.getInt() != 944111087) {
                og.i("Bad Spoof Check Data.");
                return;
            }
            byteBuffer.getInt();
            byteBuffer.getInt();
            int i = byteBuffer.getInt();
            int i2 = byteBuffer.getInt();
            int i3 = byteBuffer.getInt();
            int i4 = byteBuffer.getInt();
            int i5 = byteBuffer.getInt();
            int i6 = byteBuffer.getInt();
            ICUBinary.skipBytes(byteBuffer, i);
            this.fCFUKeys = ICUBinary.getInts(byteBuffer, i2, 0);
            ICUBinary.skipBytes(byteBuffer, i3);
            this.fCFUValues = ICUBinary.getShorts(byteBuffer, i4, 0);
            ICUBinary.skipBytes(byteBuffer, i5);
            this.fCFUStrings = ICUBinary.getString(byteBuffer, i6, 0);
        }

        public void appendValueTo(int i, StringBuilder sb) {
            int iKeyToLength = ConfusableDataUtils.keyToLength(this.fCFUKeys[i]);
            short s = this.fCFUValues[i];
            if (iKeyToLength == 1) {
                sb.append((char) s);
            } else {
                sb.append((CharSequence) this.fCFUStrings, (int) s, iKeyToLength + s);
            }
        }

        public int codePointAt(int i) {
            return ConfusableDataUtils.keyToCodePoint(this.fCFUKeys[i]);
        }

        public void confusableLookup(int i, StringBuilder sb) {
            int i2;
            int length = length();
            int i3 = 0;
            while (true) {
                i2 = (i3 + length) / 2;
                if (codePointAt(i2) <= i) {
                    if (codePointAt(i2) >= i) {
                        break;
                    } else {
                        i3 = i2;
                    }
                } else {
                    length = i2;
                }
                if (length - i3 <= 1) {
                    i2 = i3;
                    break;
                }
            }
            if (codePointAt(i2) != i) {
                sb.appendCodePoint(i);
            } else {
                appendValueTo(i2, sb);
            }
        }

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof SpoofData)) {
                return false;
            }
            SpoofData spoofData = (SpoofData) obj;
            if (Arrays.equals(this.fCFUKeys, spoofData.fCFUKeys) && Arrays.equals(this.fCFUValues, spoofData.fCFUValues)) {
                return Utility.sameObjects(this.fCFUStrings, spoofData.fCFUStrings) || (str = this.fCFUStrings) == null || str.equals(spoofData.fCFUStrings);
            }
            return false;
        }

        public int hashCode() {
            return this.fCFUStrings.hashCode() ^ (Arrays.hashCode(this.fCFUKeys) ^ Arrays.hashCode(this.fCFUValues));
        }

        public int length() {
            return this.fCFUKeys.length;
        }

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static final class IsAcceptable implements ICUBinary.Authenticate {
            public /* synthetic */ IsAcceptable(int i) {
                this();
            }

            @Override // com.ibm.icu.impl.ICUBinary.Authenticate
            public boolean isDataVersionAcceptable(byte[] bArr) {
                return (bArr[0] != 2 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 0) ? false : true;
            }

            private IsAcceptable() {
            }
        }

        public /* synthetic */ SpoofData(ByteBuffer byteBuffer, int i) {
            this(byteBuffer);
        }

        private SpoofData() {
        }

        public /* synthetic */ SpoofData(int i) {
            this();
        }
    }

    private SpoofChecker() {
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Builder {
        final UnicodeSet fAllowedCharsSet;
        final Set<ULocale> fAllowedLocales;
        int fChecks;
        private RestrictionLevel fRestrictionLevel;
        SpoofData fSpoofData;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public static class ConfusabledataBuilder {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private int fLineNum;
            private Pattern fParseHexNum;
            private Pattern fParseLine;
            private StringBuffer fStringTable;
            private Hashtable<Integer, SPUString> fTable = new Hashtable<>();
            private UnicodeSet fKeySet = new UnicodeSet();
            private ArrayList<Integer> fKeyVec = new ArrayList<>();
            private ArrayList<Integer> fValueVec = new ArrayList<>();
            private SPUStringPool stringPool = new SPUStringPool();

            /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
            public static class SPUString {
                int fCharOrStrTableIndex = 0;
                String fStr;

                public SPUString(String str) {
                    this.fStr = str;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
            public static class SPUStringComparator implements Comparator<SPUString> {
                static final SPUStringComparator INSTANCE = new SPUStringComparator();

                private SPUStringComparator() {
                }

                @Override // java.util.Comparator
                public int compare(SPUString sPUString, SPUString sPUString2) {
                    int length = sPUString.fStr.length();
                    int length2 = sPUString2.fStr.length();
                    if (length < length2) {
                        return -1;
                    }
                    if (length > length2) {
                        return 1;
                    }
                    return sPUString.fStr.compareTo(sPUString2.fStr);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
            public static class SPUStringPool {
                private Vector<SPUString> fVec = new Vector<>();
                private Hashtable<String, SPUString> fHash = new Hashtable<>();

                public SPUString addString(String str) {
                    SPUString sPUString = this.fHash.get(str);
                    if (sPUString != null) {
                        return sPUString;
                    }
                    SPUString sPUString2 = new SPUString(str);
                    this.fHash.put(str, sPUString2);
                    this.fVec.addElement(sPUString2);
                    return sPUString2;
                }

                public SPUString getByIndex(int i) {
                    return this.fVec.elementAt(i);
                }

                public int size() {
                    return this.fVec.size();
                }

                public void sort() {
                    Collections.sort(this.fVec, SPUStringComparator.INSTANCE);
                }
            }

            public static void buildConfusableData(Reader reader, SpoofData spoofData) throws IOException, ParseException {
                new ConfusabledataBuilder().build(reader, spoofData);
            }

            public void build(Reader reader, SpoofData spoofData) throws IOException, ParseException {
                StringBuffer stringBuffer = new StringBuffer();
                LineNumberReader lineNumberReader = new LineNumberReader(reader);
                while (true) {
                    String line = lineNumberReader.readLine();
                    if (line == null) {
                        break;
                    }
                    stringBuffer.append(line);
                    stringBuffer.append('\n');
                }
                this.fParseLine = Pattern.compile("(?m)^[ \\t]*([0-9A-Fa-f]+)[ \\t]+;[ \\t]*([0-9A-Fa-f]+(?:[ \\t]+[0-9A-Fa-f]+)*)[ \\t]*;\\s*(?:(SL)|(SA)|(ML)|(MA))[ \\t]*(?:#.*?)?$|^([ \\t]*(?:#.*?)?)$|^(.*?)$");
                this.fParseHexNum = Pattern.compile("\\s*([0-9A-F]+)");
                int i = 0;
                if (stringBuffer.charAt(0) == 65279) {
                    stringBuffer.setCharAt(0, ' ');
                }
                Matcher matcher = this.fParseLine.matcher(stringBuffer);
                while (matcher.find()) {
                    this.fLineNum++;
                    if (matcher.start(7) < 0) {
                        if (matcher.start(8) >= 0) {
                            throw new ParseException("Confusables, line " + this.fLineNum + ": Unrecognized Line: " + matcher.group(8), matcher.start(8));
                        }
                        int i2 = Integer.parseInt(matcher.group(1), 16);
                        if (i2 > 1114111) {
                            throw new ParseException("Confusables, line " + this.fLineNum + ": Bad code point: " + matcher.group(1), matcher.start(1));
                        }
                        Matcher matcher2 = this.fParseHexNum.matcher(matcher.group(2));
                        StringBuilder sb = new StringBuilder();
                        while (matcher2.find()) {
                            int i3 = Integer.parseInt(matcher2.group(1), 16);
                            if (i3 > 1114111) {
                                throw new ParseException("Confusables, line " + this.fLineNum + ": Bad code point: " + Integer.toString(i3, 16), matcher.start(2));
                            }
                            sb.appendCodePoint(i3);
                        }
                        this.fTable.put(Integer.valueOf(i2), this.stringPool.addString(sb.toString()));
                        this.fKeySet.add(i2);
                    }
                }
                this.stringPool.sort();
                this.fStringTable = new StringBuffer();
                int size = this.stringPool.size();
                for (int i4 = 0; i4 < size; i4++) {
                    SPUString byIndex = this.stringPool.getByIndex(i4);
                    int length = byIndex.fStr.length();
                    int length2 = this.fStringTable.length();
                    if (length == 1) {
                        byIndex.fCharOrStrTableIndex = byIndex.fStr.charAt(0);
                    } else {
                        byIndex.fCharOrStrTableIndex = length2;
                        this.fStringTable.append(byIndex.fStr);
                    }
                }
                Iterator<String> it = this.fKeySet.iterator();
                while (it.hasNext()) {
                    int iCodePointAt = it.next().codePointAt(0);
                    SPUString sPUString = this.fTable.get(Integer.valueOf(iCodePointAt));
                    if (sPUString.fStr.length() > 256) {
                        og.i("Confusable prototypes cannot be longer than 256 entries.");
                        return;
                    }
                    int iCodePointAndLengthToKey = ConfusableDataUtils.codePointAndLengthToKey(iCodePointAt, sPUString.fStr.length());
                    int i5 = sPUString.fCharOrStrTableIndex;
                    this.fKeyVec.add(Integer.valueOf(iCodePointAndLengthToKey));
                    this.fValueVec.add(Integer.valueOf(i5));
                }
                int size2 = this.fKeyVec.size();
                spoofData.fCFUKeys = new int[size2];
                for (int i6 = 0; i6 < size2; i6++) {
                    int iIntValue = this.fKeyVec.get(i6).intValue();
                    ConfusableDataUtils.keyToCodePoint(iIntValue);
                    spoofData.fCFUKeys[i6] = iIntValue;
                }
                spoofData.fCFUValues = new short[this.fValueVec.size()];
                ArrayList<Integer> arrayList = this.fValueVec;
                int size3 = arrayList.size();
                int i7 = 0;
                while (i7 < size3) {
                    Integer num = arrayList.get(i7);
                    i7++;
                    spoofData.fCFUValues[i] = (short) num.intValue();
                    i++;
                }
                spoofData.fCFUStrings = this.fStringTable.toString();
            }
        }

        public Builder(SpoofChecker spoofChecker) {
            UnicodeSet unicodeSet = new UnicodeSet(0, 1114111);
            this.fAllowedCharsSet = unicodeSet;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            this.fAllowedLocales = linkedHashSet;
            this.fChecks = spoofChecker.fChecks;
            this.fSpoofData = spoofChecker.fSpoofData;
            unicodeSet.set(spoofChecker.fAllowedCharsSet);
            linkedHashSet.addAll(spoofChecker.fAllowedLocales);
            this.fRestrictionLevel = spoofChecker.fRestrictionLevel;
        }

        private void addScriptChars(ULocale uLocale, UnicodeSet unicodeSet) {
            int[] code = UScript.getCode(uLocale);
            if (code != null) {
                UnicodeSet unicodeSet2 = new UnicodeSet();
                for (int i : code) {
                    unicodeSet2.applyIntPropertyValue(UProperty.SCRIPT, i);
                    unicodeSet.addAll(unicodeSet2);
                }
            }
        }

        public SpoofChecker build() {
            if (this.fSpoofData == null) {
                this.fSpoofData = SpoofData.getDefault();
            }
            SpoofChecker spoofChecker = new SpoofChecker(0);
            spoofChecker.fChecks = this.fChecks;
            spoofChecker.fSpoofData = this.fSpoofData;
            spoofChecker.fAllowedCharsSet = this.fAllowedCharsSet.m20clone();
            spoofChecker.fAllowedCharsSet.freeze();
            spoofChecker.fAllowedLocales = new HashSet(this.fAllowedLocales);
            spoofChecker.fRestrictionLevel = this.fRestrictionLevel;
            return spoofChecker;
        }

        public Builder setAllowedChars(UnicodeSet unicodeSet) {
            this.fAllowedCharsSet.set(unicodeSet);
            this.fAllowedLocales.clear();
            this.fChecks |= 64;
            return this;
        }

        public Builder setAllowedJavaLocales(Set<Locale> set) {
            HashSet hashSet = new HashSet(set.size());
            Iterator<Locale> it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(ULocale.forLocale(it.next()));
            }
            return setAllowedLocales(hashSet);
        }

        public Builder setAllowedLocales(Set<ULocale> set) {
            this.fAllowedCharsSet.clear();
            Iterator<ULocale> it = set.iterator();
            while (it.hasNext()) {
                addScriptChars(it.next(), this.fAllowedCharsSet);
            }
            this.fAllowedLocales.clear();
            if (set.size() == 0) {
                this.fAllowedCharsSet.add(0, 1114111);
                this.fChecks &= -65;
                return this;
            }
            UnicodeSet unicodeSet = new UnicodeSet();
            unicodeSet.applyIntPropertyValue(UProperty.SCRIPT, 0);
            this.fAllowedCharsSet.addAll(unicodeSet);
            unicodeSet.applyIntPropertyValue(UProperty.SCRIPT, 1);
            this.fAllowedCharsSet.addAll(unicodeSet);
            this.fAllowedLocales.clear();
            this.fAllowedLocales.addAll(set);
            this.fChecks |= 64;
            return this;
        }

        public Builder setChecks(int i) {
            this.fChecks = i;
            return this;
        }

        public Builder setData(Reader reader) throws IOException, ParseException {
            SpoofData spoofData = new SpoofData(0);
            this.fSpoofData = spoofData;
            ConfusabledataBuilder.buildConfusableData(reader, spoofData);
            return this;
        }

        public Builder setRestrictionLevel(RestrictionLevel restrictionLevel) {
            this.fRestrictionLevel = restrictionLevel;
            this.fChecks |= 144;
            return this;
        }

        @Deprecated
        public Builder setData(Reader reader, Reader reader2) throws IOException, ParseException {
            setData(reader);
            return this;
        }

        public Builder() {
            this.fAllowedCharsSet = new UnicodeSet(0, 1114111);
            this.fAllowedLocales = new LinkedHashSet();
            this.fChecks = -1;
            this.fSpoofData = null;
            this.fRestrictionLevel = RestrictionLevel.HIGHLY_RESTRICTIVE;
        }
    }

    @Deprecated
    public String getSkeleton(int i, String str) {
        return getSkeleton(str);
    }

    public int areConfusable(int i, CharSequence charSequence, CharSequence charSequence2) {
        int i2;
        if ((this.fChecks & 7) != 0) {
            if (!getBidiSkeleton(i, charSequence).equals(getBidiSkeleton(i, charSequence2))) {
                return 0;
            }
            ScriptSet scriptSet = new ScriptSet();
            getResolvedScriptSet(charSequence, scriptSet);
            ScriptSet scriptSet2 = new ScriptSet();
            getResolvedScriptSet(charSequence2, scriptSet2);
            if (scriptSet.intersects(scriptSet2)) {
                i2 = 1;
            } else {
                i2 = (scriptSet.isEmpty() || scriptSet2.isEmpty()) ? 2 : 6;
            }
            return this.fChecks & i2;
        }
        og.i("No confusable checks are enabled.");
        return 0;
    }

    @Deprecated
    public RestrictionLevel getRestrictionLevel() {
        return this.fRestrictionLevel;
    }

    public boolean failsChecks(String str) {
        return failsChecks(str, null);
    }
}
