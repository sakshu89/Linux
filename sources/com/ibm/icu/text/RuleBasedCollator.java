package com.ibm.icu.text;

import com.ibm.icu.impl.ClassLoaderUtil;
import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.coll.BOCSU;
import com.ibm.icu.impl.coll.Collation;
import com.ibm.icu.impl.coll.CollationCompare;
import com.ibm.icu.impl.coll.CollationData;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.impl.coll.CollationIterator;
import com.ibm.icu.impl.coll.CollationKeys;
import com.ibm.icu.impl.coll.CollationLoader;
import com.ibm.icu.impl.coll.CollationRoot;
import com.ibm.icu.impl.coll.CollationSettings;
import com.ibm.icu.impl.coll.CollationTailoring;
import com.ibm.icu.impl.coll.ContractionsAndExpansions;
import com.ibm.icu.impl.coll.FCDUTF16CollationIterator;
import com.ibm.icu.impl.coll.SharedObject;
import com.ibm.icu.impl.coll.TailoredSet;
import com.ibm.icu.impl.coll.UTF16CollationIterator;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.VersionInfo;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.lang.reflect.InvocationTargetException;
import java.text.CharacterIterator;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class RuleBasedCollator extends Collator implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean actualLocaleIsSameAsValid;
    private CollationBuffer collationBuffer;
    CollationData data;
    private Lock frozenLock;
    SharedObject.Reference<CollationSettings> settings;
    CollationTailoring tailoring;
    private ULocale validLocale;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CollationKeyByteSink extends CollationKeys.SortKeyByteSink {
        private RawCollationKey key_;

        public CollationKeyByteSink(RawCollationKey rawCollationKey) {
            super(rawCollationKey.bytes);
            this.key_ = rawCollationKey;
        }

        @Override // com.ibm.icu.impl.coll.CollationKeys.SortKeyByteSink
        public void AppendBeyondCapacity(byte[] bArr, int i, int i2, int i3) {
            if (Resize(i2, i3)) {
                System.arraycopy(bArr, i, this.buffer_, i3, i2);
            }
        }

        @Override // com.ibm.icu.impl.coll.CollationKeys.SortKeyByteSink
        public boolean Resize(int i, int i2) {
            byte[] bArr = this.buffer_;
            int length = bArr.length * 2;
            int i3 = (i * 2) + i2;
            if (length < i3) {
                length = i3;
            }
            if (length < 200) {
                length = 200;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.key_.bytes = bArr2;
            this.buffer_ = bArr2;
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class FCDUTF16NFDIterator extends UTF16NFDIterator {
        private StringBuilder str;

        public void setText(Normalizer2Impl normalizer2Impl, CharSequence charSequence, int i) {
            reset();
            int iMakeFCD = normalizer2Impl.makeFCD(charSequence, i, charSequence.length(), null);
            if (iMakeFCD == charSequence.length()) {
                this.s = charSequence;
                this.pos = i;
                return;
            }
            StringBuilder sb = this.str;
            if (sb == null) {
                this.str = new StringBuilder();
            } else {
                sb.setLength(0);
            }
            this.str.append(charSequence, i, iMakeFCD);
            normalizer2Impl.makeFCD(charSequence, iMakeFCD, charSequence.length(), new Normalizer2Impl.ReorderingBuffer(normalizer2Impl, this.str, charSequence.length() - i));
            this.s = this.str;
            this.pos = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class NFDIterator {
        private String decomp;
        private int index;

        public final int nextCodePoint() {
            int i = this.index;
            if (i >= 0) {
                if (i != this.decomp.length()) {
                    int iCodePointAt = Character.codePointAt(this.decomp, this.index);
                    this.index = Character.charCount(iCodePointAt) + this.index;
                    return iCodePointAt;
                }
                this.index = -1;
            }
            return nextRawCodePoint();
        }

        public final int nextDecomposedCodePoint(Normalizer2Impl normalizer2Impl, int i) {
            if (this.index < 0) {
                String decomposition = normalizer2Impl.getDecomposition(i);
                this.decomp = decomposition;
                if (decomposition != null) {
                    int iCodePointAt = Character.codePointAt(decomposition, 0);
                    this.index = Character.charCount(iCodePointAt);
                    return iCodePointAt;
                }
            }
            return i;
        }

        public abstract int nextRawCodePoint();

        public final void reset() {
            this.index = -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class UTF16NFDIterator extends NFDIterator {
        protected int pos;
        protected CharSequence s;

        @Override // com.ibm.icu.text.RuleBasedCollator.NFDIterator
        public int nextRawCodePoint() {
            if (this.pos == this.s.length()) {
                return -1;
            }
            int iCodePointAt = Character.codePointAt(this.s, this.pos);
            this.pos = Character.charCount(iCodePointAt) + this.pos;
            return iCodePointAt;
        }

        public void setText(CharSequence charSequence, int i) {
            reset();
            this.s = charSequence;
            this.pos = i;
        }
    }

    public RuleBasedCollator(CollationTailoring collationTailoring, ULocale uLocale) {
        this.data = collationTailoring.data;
        this.settings = new SharedObject.Reference<>(collationTailoring.settings);
        this.tailoring = collationTailoring;
        this.validLocale = uLocale;
        this.actualLocaleIsSameAsValid = false;
    }

    private void adoptTailoring(CollationTailoring collationTailoring) {
        this.data = collationTailoring.data;
        this.settings = new SharedObject.Reference<>(collationTailoring.settings);
        this.tailoring = collationTailoring;
        this.validLocale = collationTailoring.actualLocale;
        this.actualLocaleIsSameAsValid = false;
    }

    private void checkNotFrozen() {
        if (isFrozen()) {
            dk0.r("Attempt to modify frozen RuleBasedCollator");
        }
    }

    private static final int compareNFDIter(Normalizer2Impl normalizer2Impl, NFDIterator nFDIterator, NFDIterator nFDIterator2) {
        int iNextDecomposedCodePoint;
        while (true) {
            int iNextCodePoint = nFDIterator.nextCodePoint();
            int iNextCodePoint2 = nFDIterator2.nextCodePoint();
            if (iNextCodePoint != iNextCodePoint2) {
                int iNextDecomposedCodePoint2 = -2;
                if (iNextCodePoint < 0) {
                    iNextDecomposedCodePoint = -2;
                } else {
                    iNextDecomposedCodePoint = iNextCodePoint == 65534 ? -1 : nFDIterator.nextDecomposedCodePoint(normalizer2Impl, iNextCodePoint);
                }
                if (iNextCodePoint2 >= 0) {
                    iNextDecomposedCodePoint2 = iNextCodePoint2 == 65534 ? -1 : nFDIterator2.nextDecomposedCodePoint(normalizer2Impl, iNextCodePoint2);
                }
                if (iNextDecomposedCodePoint < iNextDecomposedCodePoint2) {
                    return -1;
                }
                if (iNextDecomposedCodePoint > iNextDecomposedCodePoint2) {
                    return 1;
                }
            } else if (iNextCodePoint < 0) {
                return 0;
            }
        }
    }

    private final CollationBuffer getCollationBuffer() {
        if (isFrozen()) {
            this.frozenLock.lock();
        } else if (this.collationBuffer == null) {
            this.collationBuffer = new CollationBuffer(this.data, 0);
        }
        return this.collationBuffer;
    }

    private final CollationSettings getDefaultSettings() {
        return (CollationSettings) this.tailoring.settings.readOnly();
    }

    private final CollationSettings getOwnedSettings() {
        return (CollationSettings) this.settings.copyOnWrite();
    }

    private RawCollationKey getRawCollationKey(CharSequence charSequence, RawCollationKey rawCollationKey, CollationBuffer collationBuffer) {
        if (rawCollationKey == null) {
            rawCollationKey = new RawCollationKey(simpleKeyLengthEstimate(charSequence));
        } else if (rawCollationKey.bytes == null) {
            rawCollationKey.bytes = new byte[simpleKeyLengthEstimate(charSequence)];
        }
        CollationKeyByteSink collationKeyByteSink = new CollationKeyByteSink(rawCollationKey);
        writeSortKey(charSequence, collationKeyByteSink, collationBuffer);
        rawCollationKey.size = collationKeyByteSink.NumberOfBytesAppended();
        return rawCollationKey;
    }

    private final void initMaxExpansions() {
        if (this.tailoring.maxExpansions != null) {
            return;
        }
        synchronized (this.tailoring) {
            try {
                if (this.tailoring.maxExpansions == null) {
                    CollationTailoring collationTailoring = this.tailoring;
                    collationTailoring.maxExpansions = CollationElementIterator.computeMaxExpansions(collationTailoring.data);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void internalBuildTailoring(String str) throws Exception {
        CollationTailoring root = CollationRoot.getRoot();
        try {
            Class<?> clsLoadClass = ClassLoaderUtil.getClassLoader(RuleBasedCollator.class).loadClass("com.ibm.icu.impl.coll.CollationBuilder");
            CollationTailoring collationTailoring = (CollationTailoring) clsLoadClass.getMethod("parseAndBuild", String.class).invoke(clsLoadClass.getConstructor(CollationTailoring.class).newInstance(root), str);
            collationTailoring.actualLocale = null;
            adoptTailoring(collationTailoring);
        } catch (InvocationTargetException e) {
            throw ((Exception) e.getTargetException());
        }
    }

    private void internalSetVariableTop(long j) {
        if (j != ((CollationSettings) this.settings.readOnly()).variableTop) {
            int groupForPrimary = this.data.getGroupForPrimary(j);
            if (groupForPrimary < 4096 || 4099 < groupForPrimary) {
                og.i("The variable top must be a primary weight in the space/punctuation/symbols/currency symbols range");
                return;
            }
            long lastPrimaryForGroup = this.data.getLastPrimaryForGroup(groupForPrimary);
            if (lastPrimaryForGroup != ((CollationSettings) this.settings.readOnly()).variableTop) {
                CollationSettings ownedSettings = getOwnedSettings();
                ownedSettings.setMaxVariable(groupForPrimary - 4096, getDefaultSettings().options);
                ownedSettings.variableTop = lastPrimaryForGroup;
                setFastLatinOptions(ownedSettings);
            }
        }
    }

    private final void releaseCollationBuffer(CollationBuffer collationBuffer) {
        if (isFrozen()) {
            this.frozenLock.unlock();
        }
    }

    private void setFastLatinOptions(CollationSettings collationSettings) {
        collationSettings.fastLatinOptions = CollationFastLatin.getOptions(this.data, collationSettings, collationSettings.fastLatinPrimaries);
    }

    private int simpleKeyLengthEstimate(CharSequence charSequence) {
        return (charSequence.length() * 2) + 10;
    }

    private void writeIdenticalLevel(CharSequence charSequence, CollationKeyByteSink collationKeyByteSink) {
        int iDecompose = this.data.nfcImpl.decompose(charSequence, 0, charSequence.length(), null);
        collationKeyByteSink.Append(1);
        collationKeyByteSink.key_.size = collationKeyByteSink.NumberOfBytesAppended();
        int iWriteIdenticalLevelRun = iDecompose != 0 ? BOCSU.writeIdenticalLevelRun(0, charSequence, 0, iDecompose, collationKeyByteSink.key_) : 0;
        if (iDecompose < charSequence.length()) {
            int length = charSequence.length() - iDecompose;
            StringBuilder sb = new StringBuilder();
            this.data.nfcImpl.decompose(charSequence, iDecompose, charSequence.length(), sb, length);
            BOCSU.writeIdenticalLevelRun(iWriteIdenticalLevelRun, sb, 0, sb.length(), collationKeyByteSink.key_);
        }
        collationKeyByteSink.setBufferAndAppended(collationKeyByteSink.key_.bytes, collationKeyByteSink.key_.size);
    }

    private void writeSortKey(CharSequence charSequence, CollationKeyByteSink collationKeyByteSink, CollationBuffer collationBuffer) {
        boolean zIsNumeric = ((CollationSettings) this.settings.readOnly()).isNumeric();
        if (((CollationSettings) this.settings.readOnly()).dontCheckFCD()) {
            collationBuffer.leftUTF16CollIter.setText(zIsNumeric, charSequence, 0);
            CollationKeys.writeSortKeyUpToQuaternary(collationBuffer.leftUTF16CollIter, this.data.compressibleBytes, (CollationSettings) this.settings.readOnly(), collationKeyByteSink, 1, CollationKeys.SIMPLE_LEVEL_FALLBACK, true);
        } else {
            collationBuffer.leftFCDUTF16Iter.setText(zIsNumeric, charSequence, 0);
            CollationKeys.writeSortKeyUpToQuaternary(collationBuffer.leftFCDUTF16Iter, this.data.compressibleBytes, (CollationSettings) this.settings.readOnly(), collationKeyByteSink, 1, CollationKeys.SIMPLE_LEVEL_FALLBACK, true);
        }
        if (((CollationSettings) this.settings.readOnly()).getStrength() == 15) {
            writeIdenticalLevel(charSequence, collationKeyByteSink);
        }
        collationKeyByteSink.Append(0);
    }

    @Override // com.ibm.icu.text.Collator
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RuleBasedCollator mo12clone() {
        return isFrozen() ? this : cloneAsThawed();
    }

    @Override // com.ibm.icu.text.Collator, com.ibm.icu.util.Freezable
    public RuleBasedCollator cloneAsThawed() {
        try {
            RuleBasedCollator ruleBasedCollator = (RuleBasedCollator) super.mo12clone();
            ruleBasedCollator.settings = new SharedObject.Reference<>(this.settings);
            ruleBasedCollator.collationBuffer = null;
            ruleBasedCollator.frozenLock = null;
            return ruleBasedCollator;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.ibm.icu.text.Collator
    public int compare(String str, String str2) {
        return doCompare(str, str2);
    }

    @Override // com.ibm.icu.text.Collator
    @Deprecated
    public int doCompare(CharSequence charSequence, CharSequence charSequence2) throws Throwable {
        CharSequence charSequence3;
        CharSequence charSequence4;
        int iCompareUTF16;
        Throwable th;
        CollationBuffer collationBuffer;
        int iCompareUpToQuaternary;
        if (charSequence == charSequence2) {
            return 0;
        }
        int i = 0;
        while (true) {
            if (i == charSequence.length()) {
                if (i != charSequence2.length()) {
                    break;
                }
                return 0;
            }
            if (i == charSequence2.length() || charSequence.charAt(i) != charSequence2.charAt(i)) {
                break;
            }
            i++;
        }
        CollationSettings collationSettings = (CollationSettings) this.settings.readOnly();
        boolean zIsNumeric = collationSettings.isNumeric();
        if (i > 0 && ((i != charSequence.length() && this.data.isUnsafeBackward(charSequence.charAt(i), zIsNumeric)) || (i != charSequence2.length() && this.data.isUnsafeBackward(charSequence2.charAt(i), zIsNumeric)))) {
            do {
                i--;
                if (i <= 0) {
                    break;
                }
            } while (this.data.isUnsafeBackward(charSequence.charAt(i), zIsNumeric));
        }
        int i2 = i;
        int i3 = collationSettings.fastLatinOptions;
        if (i3 < 0 || ((i2 != charSequence.length() && charSequence.charAt(i2) > 383) || (i2 != charSequence2.length() && charSequence2.charAt(i2) > 383))) {
            charSequence3 = charSequence;
            charSequence4 = charSequence2;
            iCompareUTF16 = -2;
        } else {
            charSequence3 = charSequence;
            charSequence4 = charSequence2;
            iCompareUTF16 = CollationFastLatin.compareUTF16(this.data.fastLatinTable, collationSettings.fastLatinPrimaries, i3, charSequence3, charSequence4, i2);
        }
        if (iCompareUTF16 == -2) {
            try {
                collationBuffer = getCollationBuffer();
                try {
                    if (collationSettings.dontCheckFCD()) {
                        collationBuffer.leftUTF16CollIter.setText(zIsNumeric, charSequence3, i2);
                        collationBuffer.rightUTF16CollIter.setText(zIsNumeric, charSequence4, i2);
                        iCompareUpToQuaternary = CollationCompare.compareUpToQuaternary(collationBuffer.leftUTF16CollIter, collationBuffer.rightUTF16CollIter, collationSettings);
                    } else {
                        collationBuffer.leftFCDUTF16Iter.setText(zIsNumeric, charSequence3, i2);
                        collationBuffer.rightFCDUTF16Iter.setText(zIsNumeric, charSequence4, i2);
                        iCompareUpToQuaternary = CollationCompare.compareUpToQuaternary(collationBuffer.leftFCDUTF16Iter, collationBuffer.rightFCDUTF16Iter, collationSettings);
                    }
                    releaseCollationBuffer(collationBuffer);
                    iCompareUTF16 = iCompareUpToQuaternary;
                } catch (Throwable th2) {
                    th = th2;
                    releaseCollationBuffer(collationBuffer);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                collationBuffer = null;
            }
        }
        if (iCompareUTF16 != 0 || collationSettings.getStrength() < 15) {
            return iCompareUTF16;
        }
        try {
            CollationBuffer collationBuffer2 = getCollationBuffer();
            Normalizer2Impl normalizer2Impl = this.data.nfcImpl;
            if (collationSettings.dontCheckFCD()) {
                collationBuffer2.leftUTF16NFDIter.setText(charSequence3, i2);
                collationBuffer2.rightUTF16NFDIter.setText(charSequence4, i2);
                int iCompareNFDIter = compareNFDIter(normalizer2Impl, collationBuffer2.leftUTF16NFDIter, collationBuffer2.rightUTF16NFDIter);
                releaseCollationBuffer(collationBuffer2);
                return iCompareNFDIter;
            }
            collationBuffer2.leftFCDUTF16NFDIter.setText(normalizer2Impl, charSequence3, i2);
            collationBuffer2.rightFCDUTF16NFDIter.setText(normalizer2Impl, charSequence4, i2);
            int iCompareNFDIter2 = compareNFDIter(normalizer2Impl, collationBuffer2.leftFCDUTF16NFDIter, collationBuffer2.rightFCDUTF16NFDIter);
            releaseCollationBuffer(collationBuffer2);
            return iCompareNFDIter2;
        } catch (Throwable th4) {
            releaseCollationBuffer(null);
            throw th4;
        }
    }

    @Override // com.ibm.icu.text.Collator, java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        RuleBasedCollator ruleBasedCollator = (RuleBasedCollator) obj;
        if (!((CollationSettings) this.settings.readOnly()).equals(ruleBasedCollator.settings.readOnly())) {
            return false;
        }
        CollationData collationData = this.data;
        CollationData collationData2 = ruleBasedCollator.data;
        if (collationData == collationData2) {
            return true;
        }
        boolean z = collationData.base == null;
        boolean z2 = collationData2.base == null;
        if (z != z2) {
            return false;
        }
        String rules = this.tailoring.getRules();
        String rules2 = ruleBasedCollator.tailoring.getRules();
        return ((z || rules.length() != 0) && ((z2 || rules2.length() != 0) && rules.equals(rules2))) || getTailoredSet().equals(ruleBasedCollator.getTailoredSet());
    }

    @Override // com.ibm.icu.text.Collator, com.ibm.icu.util.Freezable
    public Collator freeze() {
        if (!isFrozen()) {
            this.frozenLock = new ReentrantLock();
            if (this.collationBuffer == null) {
                this.collationBuffer = new CollationBuffer(this.data, 0);
            }
        }
        return this;
    }

    public CollationElementIterator getCollationElementIterator(CharacterIterator characterIterator) {
        initMaxExpansions();
        return new CollationElementIterator((CharacterIterator) characterIterator.clone(), this);
    }

    @Override // com.ibm.icu.text.Collator
    public CollationKey getCollationKey(String str) {
        CollationBuffer collationBuffer = null;
        if (str == null) {
            return null;
        }
        try {
            collationBuffer = getCollationBuffer();
            return getCollationKey(str, collationBuffer);
        } finally {
            releaseCollationBuffer(collationBuffer);
        }
    }

    public void getContractionsAndExpansions(UnicodeSet unicodeSet, UnicodeSet unicodeSet2, boolean z) {
        if (unicodeSet != null) {
            unicodeSet.clear();
        }
        if (unicodeSet2 != null) {
            unicodeSet2.clear();
        }
        new ContractionsAndExpansions(unicodeSet, unicodeSet2, null, z).forData(this.data);
    }

    @Override // com.ibm.icu.text.Collator
    public int getDecomposition() {
        return (((CollationSettings) this.settings.readOnly()).options & 1) != 0 ? 17 : 16;
    }

    @Override // com.ibm.icu.text.Collator
    public ULocale getLocale(ULocale.Type type) {
        if (type == ULocale.ACTUAL_LOCALE) {
            return this.actualLocaleIsSameAsValid ? this.validLocale : this.tailoring.actualLocale;
        }
        if (type == ULocale.VALID_LOCALE) {
            return this.validLocale;
        }
        og.i("unknown ULocale.Type ".concat(String.valueOf(type)));
        return null;
    }

    @Override // com.ibm.icu.text.Collator
    public int getMaxVariable() {
        return ((CollationSettings) this.settings.readOnly()).getMaxVariable() + 4096;
    }

    public boolean getNumericCollation() {
        return (((CollationSettings) this.settings.readOnly()).options & 2) != 0;
    }

    @Override // com.ibm.icu.text.Collator
    public int[] getReorderCodes() {
        return (int[]) ((CollationSettings) this.settings.readOnly()).reorderCodes.clone();
    }

    public String getRules(boolean z) {
        return !z ? this.tailoring.getRules() : ky0.j(CollationLoader.getRootRules(), this.tailoring.getRules());
    }

    @Override // com.ibm.icu.text.Collator
    public int getStrength() {
        return ((CollationSettings) this.settings.readOnly()).getStrength();
    }

    @Override // com.ibm.icu.text.Collator
    public UnicodeSet getTailoredSet() {
        UnicodeSet unicodeSet = new UnicodeSet();
        if (this.data.base != null) {
            new TailoredSet(unicodeSet).forData(this.data);
        }
        return unicodeSet;
    }

    @Override // com.ibm.icu.text.Collator
    public VersionInfo getUCAVersion() {
        VersionInfo version = getVersion();
        return VersionInfo.getInstance(version.getMinor() >> 3, version.getMinor() & 7, version.getMilli() >> 6, 0);
    }

    @Override // com.ibm.icu.text.Collator
    public int getVariableTop() {
        return (int) ((CollationSettings) this.settings.readOnly()).variableTop;
    }

    @Override // com.ibm.icu.text.Collator
    public VersionInfo getVersion() {
        int i = this.tailoring.version;
        int major = VersionInfo.UCOL_RUNTIME_VERSION.getMajor();
        return VersionInfo.getInstance((i >>> 24) + (major << 4) + (major >> 4), (i >> 16) & 255, (i >> 8) & 255, i & 255);
    }

    @Override // com.ibm.icu.text.Collator
    public int hashCode() {
        int i;
        int iHashCode = ((CollationSettings) this.settings.readOnly()).hashCode();
        if (this.data.base == null) {
            return iHashCode;
        }
        UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(getTailoredSet());
        while (unicodeSetIterator.next() && (i = unicodeSetIterator.codepoint) != -1) {
            iHashCode ^= this.data.getCE32(i);
        }
        return iHashCode;
    }

    @Deprecated
    public void internalAddContractions(int i, UnicodeSet unicodeSet) {
        new ContractionsAndExpansions(unicodeSet, null, null, false).forCodePoint(this.data, i);
    }

    @Deprecated
    public long[] internalGetCEs(CharSequence charSequence) throws Throwable {
        CollationBuffer collationBuffer;
        CollationIterator collationIterator;
        try {
            collationBuffer = getCollationBuffer();
            try {
                boolean zIsNumeric = ((CollationSettings) this.settings.readOnly()).isNumeric();
                if (((CollationSettings) this.settings.readOnly()).dontCheckFCD()) {
                    collationBuffer.leftUTF16CollIter.setText(zIsNumeric, charSequence, 0);
                    collationIterator = collationBuffer.leftUTF16CollIter;
                } else {
                    collationBuffer.leftFCDUTF16Iter.setText(zIsNumeric, charSequence, 0);
                    collationIterator = collationBuffer.leftFCDUTF16Iter;
                }
                int iFetchCEs = collationIterator.fetchCEs() - 1;
                long[] jArr = new long[iFetchCEs];
                System.arraycopy(collationIterator.getCEs(), 0, jArr, 0, iFetchCEs);
                releaseCollationBuffer(collationBuffer);
                return jArr;
            } catch (Throwable th) {
                th = th;
                releaseCollationBuffer(collationBuffer);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            collationBuffer = null;
        }
    }

    public boolean isAlternateHandlingShifted() {
        return ((CollationSettings) this.settings.readOnly()).getAlternateHandling();
    }

    public boolean isCaseLevel() {
        return (((CollationSettings) this.settings.readOnly()).options & 1024) != 0;
    }

    public boolean isFrenchCollation() {
        return (((CollationSettings) this.settings.readOnly()).options & 2048) != 0;
    }

    @Override // com.ibm.icu.text.Collator, com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return this.frozenLock != null;
    }

    @Deprecated
    public boolean isHiraganaQuaternary() {
        return false;
    }

    public boolean isLowerCaseFirst() {
        return ((CollationSettings) this.settings.readOnly()).getCaseFirst() == 512;
    }

    public final boolean isUnsafe(int i) {
        return this.data.isUnsafeBackward(i, ((CollationSettings) this.settings.readOnly()).isNumeric());
    }

    public boolean isUpperCaseFirst() {
        return ((CollationSettings) this.settings.readOnly()).getCaseFirst() == 768;
    }

    public void setAlternateHandlingDefault() {
        checkNotFrozen();
        CollationSettings defaultSettings = getDefaultSettings();
        if (this.settings.readOnly() == defaultSettings) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setAlternateHandlingDefault(defaultSettings.options);
        setFastLatinOptions(ownedSettings);
    }

    public void setAlternateHandlingShifted(boolean z) {
        checkNotFrozen();
        if (z == isAlternateHandlingShifted()) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setAlternateHandlingShifted(z);
        setFastLatinOptions(ownedSettings);
    }

    public final void setCaseFirstDefault() {
        checkNotFrozen();
        CollationSettings defaultSettings = getDefaultSettings();
        if (this.settings.readOnly() == defaultSettings) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setCaseFirstDefault(defaultSettings.options);
        setFastLatinOptions(ownedSettings);
    }

    public void setCaseLevel(boolean z) {
        checkNotFrozen();
        if (z == isCaseLevel()) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setFlag(1024, z);
        setFastLatinOptions(ownedSettings);
    }

    public void setCaseLevelDefault() {
        checkNotFrozen();
        CollationSettings defaultSettings = getDefaultSettings();
        if (this.settings.readOnly() == defaultSettings) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setFlagDefault(1024, defaultSettings.options);
        setFastLatinOptions(ownedSettings);
    }

    @Override // com.ibm.icu.text.Collator
    public void setDecomposition(int i) {
        boolean z;
        checkNotFrozen();
        if (i == 16) {
            z = false;
        } else {
            if (i != 17) {
                og.i("Wrong decomposition mode.");
                return;
            }
            z = true;
        }
        if (z == ((CollationSettings) this.settings.readOnly()).getFlag(1)) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setFlag(1, z);
        setFastLatinOptions(ownedSettings);
    }

    public void setDecompositionDefault() {
        checkNotFrozen();
        CollationSettings defaultSettings = getDefaultSettings();
        if (this.settings.readOnly() == defaultSettings) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setFlagDefault(1, defaultSettings.options);
        setFastLatinOptions(ownedSettings);
    }

    public void setFrenchCollation(boolean z) {
        checkNotFrozen();
        if (z == isFrenchCollation()) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setFlag(2048, z);
        setFastLatinOptions(ownedSettings);
    }

    public void setFrenchCollationDefault() {
        checkNotFrozen();
        CollationSettings defaultSettings = getDefaultSettings();
        if (this.settings.readOnly() == defaultSettings) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setFlagDefault(2048, defaultSettings.options);
        setFastLatinOptions(ownedSettings);
    }

    @Deprecated
    public void setHiraganaQuaternary(boolean z) {
        checkNotFrozen();
    }

    @Deprecated
    public void setHiraganaQuaternaryDefault() {
        checkNotFrozen();
    }

    @Override // com.ibm.icu.text.Collator
    public void setLocale(ULocale uLocale, ULocale uLocale2) {
        if (Objects.equals(uLocale2, this.tailoring.actualLocale)) {
            this.actualLocaleIsSameAsValid = false;
        } else {
            this.actualLocaleIsSameAsValid = true;
        }
        this.validLocale = uLocale;
    }

    public void setLowerCaseFirst(boolean z) {
        checkNotFrozen();
        if (z == isLowerCaseFirst()) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setCaseFirst(z ? 512 : 0);
        setFastLatinOptions(ownedSettings);
    }

    @Override // com.ibm.icu.text.Collator
    public RuleBasedCollator setMaxVariable(int i) {
        int i2;
        CollationSettings defaultSettings;
        if (i == -1) {
            i2 = -1;
        } else {
            if (4096 > i || i > 4099) {
                og.i(ky0.h(i, "illegal max variable group "));
                return null;
            }
            i2 = i - 4096;
        }
        if (i2 == ((CollationSettings) this.settings.readOnly()).getMaxVariable() || (this.settings.readOnly() == (defaultSettings = getDefaultSettings()) && i2 < 0)) {
            return this;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        if (i == -1) {
            i = defaultSettings.getMaxVariable() + 4096;
        }
        long lastPrimaryForGroup = this.data.getLastPrimaryForGroup(i);
        ownedSettings.setMaxVariable(i2, defaultSettings.options);
        ownedSettings.variableTop = lastPrimaryForGroup;
        setFastLatinOptions(ownedSettings);
        return this;
    }

    public void setNumericCollation(boolean z) {
        checkNotFrozen();
        if (z == getNumericCollation()) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setFlag(2, z);
        setFastLatinOptions(ownedSettings);
    }

    public void setNumericCollationDefault() {
        checkNotFrozen();
        CollationSettings defaultSettings = getDefaultSettings();
        if (this.settings.readOnly() == defaultSettings) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setFlagDefault(2, defaultSettings.options);
        setFastLatinOptions(ownedSettings);
    }

    @Override // com.ibm.icu.text.Collator
    public void setReorderCodes(int... iArr) {
        checkNotFrozen();
        int length = iArr != null ? iArr.length : 0;
        if (length == 1 && iArr[0] == 103) {
            length = 0;
        }
        SharedObject.Reference<CollationSettings> reference = this.settings;
        if (length == 0) {
            if (((CollationSettings) reference.readOnly()).reorderCodes.length == 0) {
                return;
            }
        } else if (Arrays.equals(iArr, ((CollationSettings) reference.readOnly()).reorderCodes)) {
            return;
        }
        CollationSettings defaultSettings = getDefaultSettings();
        if (length == 1 && iArr[0] == -1) {
            if (this.settings.readOnly() != defaultSettings) {
                CollationSettings ownedSettings = getOwnedSettings();
                ownedSettings.copyReorderingFrom(defaultSettings);
                setFastLatinOptions(ownedSettings);
                return;
            }
            return;
        }
        CollationSettings ownedSettings2 = getOwnedSettings();
        if (length == 0) {
            ownedSettings2.resetReordering();
        } else {
            ownedSettings2.setReordering(this.data, (int[]) iArr.clone());
        }
        setFastLatinOptions(ownedSettings2);
    }

    @Override // com.ibm.icu.text.Collator
    public void setStrength(int i) {
        checkNotFrozen();
        if (i == getStrength()) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setStrength(i);
        setFastLatinOptions(ownedSettings);
    }

    public void setStrengthDefault() {
        checkNotFrozen();
        CollationSettings defaultSettings = getDefaultSettings();
        if (this.settings.readOnly() == defaultSettings) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setStrengthDefault(defaultSettings.options);
        setFastLatinOptions(ownedSettings);
    }

    public void setUpperCaseFirst(boolean z) {
        checkNotFrozen();
        if (z == isUpperCaseFirst()) {
            return;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        ownedSettings.setCaseFirst(z ? 768 : 0);
        setFastLatinOptions(ownedSettings);
    }

    @Override // com.ibm.icu.text.Collator
    @Deprecated
    public int setVariableTop(String str) {
        long jNextCE;
        long jNextCE2;
        checkNotFrozen();
        if (str == null || str.length() == 0) {
            og.i("Variable top argument string can not be null or zero in length.");
            return 0;
        }
        boolean zIsNumeric = ((CollationSettings) this.settings.readOnly()).isNumeric();
        boolean zDontCheckFCD = ((CollationSettings) this.settings.readOnly()).dontCheckFCD();
        CollationData collationData = this.data;
        if (zDontCheckFCD) {
            UTF16CollationIterator uTF16CollationIterator = new UTF16CollationIterator(collationData, zIsNumeric, str, 0);
            jNextCE = uTF16CollationIterator.nextCE();
            jNextCE2 = uTF16CollationIterator.nextCE();
        } else {
            FCDUTF16CollationIterator fCDUTF16CollationIterator = new FCDUTF16CollationIterator(collationData, zIsNumeric, str, 0);
            jNextCE = fCDUTF16CollationIterator.nextCE();
            jNextCE2 = fCDUTF16CollationIterator.nextCE();
        }
        if (jNextCE == Collation.NO_CE || jNextCE2 != Collation.NO_CE) {
            og.i("Variable top argument string must map to exactly one collation element");
            return 0;
        }
        internalSetVariableTop(jNextCE >>> 32);
        return (int) ((CollationSettings) this.settings.readOnly()).variableTop;
    }

    public CollationElementIterator getCollationElementIterator(String str) {
        initMaxExpansions();
        return new CollationElementIterator(str, this);
    }

    public CollationElementIterator getCollationElementIterator(UCharacterIterator uCharacterIterator) {
        initMaxExpansions();
        return new CollationElementIterator(uCharacterIterator, this);
    }

    private CollationKey getCollationKey(String str, CollationBuffer collationBuffer) {
        RawCollationKey rawCollationKey = getRawCollationKey(str, collationBuffer.rawCollationKey, collationBuffer);
        collationBuffer.rawCollationKey = rawCollationKey;
        return new CollationKey(str, rawCollationKey);
    }

    public RuleBasedCollator(String str) throws Exception {
        if (str != null) {
            this.validLocale = ULocale.ROOT;
            internalBuildTailoring(str);
        } else {
            og.i("Collation rules can not be null");
            throw null;
        }
    }

    public String getRules() {
        return this.tailoring.getRules();
    }

    @Override // com.ibm.icu.text.Collator
    public RawCollationKey getRawCollationKey(String str, RawCollationKey rawCollationKey) {
        CollationBuffer collationBuffer = null;
        if (str == null) {
            return null;
        }
        try {
            collationBuffer = getCollationBuffer();
            return getRawCollationKey(str, rawCollationKey, collationBuffer);
        } finally {
            releaseCollationBuffer(collationBuffer);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CollationBuffer {
        FCDUTF16CollationIterator leftFCDUTF16Iter;
        FCDUTF16NFDIterator leftFCDUTF16NFDIter;
        UTF16CollationIterator leftUTF16CollIter;
        UTF16NFDIterator leftUTF16NFDIter;
        RawCollationKey rawCollationKey;
        FCDUTF16CollationIterator rightFCDUTF16Iter;
        FCDUTF16NFDIterator rightFCDUTF16NFDIter;
        UTF16CollationIterator rightUTF16CollIter;
        UTF16NFDIterator rightUTF16NFDIter;

        private CollationBuffer(CollationData collationData) {
            this.leftUTF16CollIter = new UTF16CollationIterator(collationData);
            this.rightUTF16CollIter = new UTF16CollationIterator(collationData);
            this.leftFCDUTF16Iter = new FCDUTF16CollationIterator(collationData);
            this.rightFCDUTF16Iter = new FCDUTF16CollationIterator(collationData);
            this.leftUTF16NFDIter = new UTF16NFDIterator();
            this.rightUTF16NFDIter = new UTF16NFDIterator();
            this.leftFCDUTF16NFDIter = new FCDUTF16NFDIterator();
            this.rightFCDUTF16NFDIter = new FCDUTF16NFDIterator();
        }

        public /* synthetic */ CollationBuffer(CollationData collationData, int i) {
            this(collationData);
        }
    }

    @Override // com.ibm.icu.text.Collator
    @Deprecated
    public void setVariableTop(int i) {
        checkNotFrozen();
        internalSetVariableTop(((long) i) & 4294967295L);
    }
}
