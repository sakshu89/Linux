package com.ibm.icu.text;

import com.ibm.icu.impl.CharacterIteration;
import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.impl.RBBIDataWrapper;
import com.ibm.icu.impl.breakiter.BurmeseBreakEngine;
import com.ibm.icu.impl.breakiter.CjkBreakEngine;
import com.ibm.icu.impl.breakiter.DictionaryBreakEngine;
import com.ibm.icu.impl.breakiter.KhmerBreakEngine;
import com.ibm.icu.impl.breakiter.LSTMBreakEngine;
import com.ibm.icu.impl.breakiter.LanguageBreakEngine;
import com.ibm.icu.impl.breakiter.LaoBreakEngine;
import com.ibm.icu.impl.breakiter.ThaiBreakEngine;
import com.ibm.icu.impl.breakiter.UnhandledBreakEngine;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UProperty;
import com.ibm.icu.util.CodePointTrie;
import defpackage.c3;
import defpackage.cq;
import defpackage.og;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.text.CharacterIterator;
import java.util.MissingResourceException;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class RuleBasedBreakIterator extends BreakIterator implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String RBBI_DEBUG_ARG = "rbbi";
    private static final int RBBI_END = 2;
    private static final int RBBI_RUN = 1;
    private static final int RBBI_START = 0;
    private static final int START_STATE = 1;
    private static final int STOP_STATE = 0;
    private static final boolean TRACE;

    @Deprecated
    public static final String fDebugEnv;
    private static final ConcurrentLinkedQueue<LanguageBreakEngine> gAllBreakEngines;
    private static final UnhandledBreakEngine gUnhandledBreakEngine;
    private BreakCache fBreakCache;
    private DictionaryCache fDictionaryCache;
    private int fDictionaryCharCount;
    private boolean fDone;
    private int[] fLookAheadMatches;
    private boolean fPhraseBreaking;
    private int fPosition;

    @Deprecated
    public RBBIDataWrapper fRData;
    private int fRuleStatusIndex;
    private CharacterIterator fText;

    static {
        TRACE = ICUDebug.enabled(RBBI_DEBUG_ARG) && ICUDebug.value(RBBI_DEBUG_ARG).indexOf("trace") >= 0;
        UnhandledBreakEngine unhandledBreakEngine = new UnhandledBreakEngine();
        gUnhandledBreakEngine = unhandledBreakEngine;
        ConcurrentLinkedQueue<LanguageBreakEngine> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        gAllBreakEngines = concurrentLinkedQueue;
        concurrentLinkedQueue.add(unhandledBreakEngine);
        fDebugEnv = ICUDebug.enabled(RBBI_DEBUG_ARG) ? ICUDebug.value(RBBI_DEBUG_ARG) : null;
    }

    @Deprecated
    public RuleBasedBreakIterator(String str, UnicodeSet.XSymbolTable xSymbolTable) {
        this();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            RBBIRuleBuilder.compileRules(str, byteArrayOutputStream, xSymbolTable);
            RBBIDataWrapper rBBIDataWrapper = RBBIDataWrapper.get(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));
            this.fRData = rBBIDataWrapper;
            this.fLookAheadMatches = new int[rBBIDataWrapper.fFTable.fLookAheadResultsSize];
        } catch (IOException e) {
            og.p(cq.j("RuleBasedBreakIterator rule compilation internal error: ", e.getMessage()));
            throw null;
        }
    }

    private static int CISetIndex32(CharacterIterator characterIterator, int i) {
        if (i <= characterIterator.getBeginIndex()) {
            characterIterator.first();
        } else if (i >= characterIterator.getEndIndex()) {
            characterIterator.setIndex(characterIterator.getEndIndex());
        } else if (Character.isLowSurrogate(characterIterator.setIndex(i)) && !Character.isHighSurrogate(characterIterator.previous())) {
            characterIterator.next();
        }
        return characterIterator.getIndex();
    }

    public static final void checkOffset(int i, CharacterIterator characterIterator) {
        if (i < characterIterator.getBeginIndex() || i > characterIterator.getEndIndex()) {
            throw c3.o(i);
        }
    }

    public static void compileRules(String str, OutputStream outputStream) throws IOException {
        RBBIRuleBuilder.compileRules(str, outputStream, null);
    }

    public static RuleBasedBreakIterator getInstanceFromCompiledRules(InputStream inputStream) {
        RuleBasedBreakIterator ruleBasedBreakIterator = new RuleBasedBreakIterator();
        RBBIDataWrapper rBBIDataWrapper = RBBIDataWrapper.get(ICUBinary.getByteBufferFromInputStreamAndCloseStream(inputStream));
        ruleBasedBreakIterator.fRData = rBBIDataWrapper;
        ruleBasedBreakIterator.fLookAheadMatches = new int[rBBIDataWrapper.fFTable.fLookAheadResultsSize];
        return ruleBasedBreakIterator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public LanguageBreakEngine getLanguageBreakEngine(int i) {
        LanguageBreakEngine cjkBreakEngine;
        for (LanguageBreakEngine languageBreakEngine : gAllBreakEngines) {
            if (languageBreakEngine.handles(i)) {
                return languageBreakEngine;
            }
        }
        ConcurrentLinkedQueue<LanguageBreakEngine> concurrentLinkedQueue = gAllBreakEngines;
        synchronized (concurrentLinkedQueue) {
            try {
                for (LanguageBreakEngine languageBreakEngine2 : concurrentLinkedQueue) {
                    if (languageBreakEngine2.handles(i)) {
                        return languageBreakEngine2;
                    }
                }
                int intPropertyValue = UCharacter.getIntPropertyValue(i, UProperty.SCRIPT);
                if (intPropertyValue == 22 || intPropertyValue == 20) {
                    intPropertyValue = 17;
                }
                try {
                    if (intPropertyValue == 17) {
                        cjkBreakEngine = new CjkBreakEngine(false);
                    } else if (intPropertyValue == 18) {
                        cjkBreakEngine = new CjkBreakEngine(true);
                    } else if (intPropertyValue == 23) {
                        cjkBreakEngine = new KhmerBreakEngine();
                    } else if (intPropertyValue == 24) {
                        cjkBreakEngine = new LaoBreakEngine();
                    } else if (intPropertyValue == 28) {
                        try {
                            cjkBreakEngine = LSTMBreakEngine.create(intPropertyValue, LSTMBreakEngine.createData(intPropertyValue));
                        } catch (MissingResourceException unused) {
                            cjkBreakEngine = new BurmeseBreakEngine();
                        }
                    } else if (intPropertyValue != 38) {
                        UnhandledBreakEngine unhandledBreakEngine = gUnhandledBreakEngine;
                        unhandledBreakEngine.handleChar(i);
                        cjkBreakEngine = unhandledBreakEngine;
                    } else {
                        try {
                            cjkBreakEngine = LSTMBreakEngine.create(intPropertyValue, LSTMBreakEngine.createData(intPropertyValue));
                        } catch (MissingResourceException unused2) {
                            cjkBreakEngine = new ThaiBreakEngine();
                        }
                    }
                } catch (IOException unused3) {
                    cjkBreakEngine = null;
                }
                if (cjkBreakEngine != null && cjkBreakEngine != gUnhandledBreakEngine) {
                    gAllBreakEngines.add(cjkBreakEngine);
                }
                return cjkBreakEngine;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int handleNext() {
        int i;
        if (TRACE) {
            System.out.println("Handle Next   pos      char  state category");
        }
        this.fRuleStatusIndex = 0;
        this.fDictionaryCharCount = 0;
        CharacterIterator characterIterator = this.fText;
        RBBIDataWrapper rBBIDataWrapper = this.fRData;
        CodePointTrie codePointTrie = rBBIDataWrapper.fTrie;
        char[] cArr = rBBIDataWrapper.fFTable.fTable;
        int i2 = this.fPosition;
        characterIterator.setIndex(i2);
        int iCurrent = characterIterator.current();
        int i3 = Integer.MAX_VALUE;
        short s = 1;
        if (iCurrent >= 55296 && (iCurrent = CharacterIteration.nextTrail32(characterIterator, iCurrent)) == Integer.MAX_VALUE) {
            this.fDone = true;
            return -1;
        }
        int rowIndex = this.fRData.getRowIndex(1);
        int i4 = this.fRData.fFTable.fDictCategoriesStart;
        int index = i2;
        char c = 1;
        short s2 = 1;
        short s3 = 3;
        while (c != 0) {
            if (iCurrent == i3) {
                if (s2 == 2) {
                    break;
                }
                s3 = s;
                s2 = 2;
            } else if (s2 == s) {
                short s4 = (short) codePointTrie.get(iCurrent);
                if (s4 >= i4) {
                    this.fDictionaryCharCount += s;
                }
                if (TRACE) {
                    System.out.print("            " + RBBIDataWrapper.intToString(characterIterator.getIndex(), 5));
                    System.out.print(RBBIDataWrapper.intToHexString(iCurrent, 10));
                    System.out.println(RBBIDataWrapper.intToString(c, 7) + RBBIDataWrapper.intToString(s4, 6));
                }
                int next = characterIterator.next();
                if (next >= 55296) {
                    next = CharacterIteration.nextTrail32(characterIterator, next);
                }
                iCurrent = next;
                s3 = s4;
            } else {
                s2 = 1;
            }
            c = cArr[rowIndex + 3 + s3];
            rowIndex = this.fRData.getRowIndex(c);
            char c2 = cArr[rowIndex];
            short s5 = 1;
            if (c2 == 1) {
                int index2 = characterIterator.getIndex();
                if (iCurrent >= 65536 && iCurrent <= 1114111) {
                    index2--;
                }
                index = index2;
                this.fRuleStatusIndex = cArr[rowIndex + 2];
                s5 = 1;
            } else if (c2 > 1 && (i = this.fLookAheadMatches[c2]) >= 0) {
                this.fRuleStatusIndex = cArr[rowIndex + 2];
                this.fPosition = i;
                return i;
            }
            char c3 = cArr[rowIndex + 1];
            if (c3 != 0) {
                int index3 = characterIterator.getIndex();
                if (iCurrent >= 65536 && iCurrent <= 1114111) {
                    index3--;
                }
                this.fLookAheadMatches[c3] = index3;
            }
            s = s5;
            i3 = Integer.MAX_VALUE;
        }
        if (index == i2) {
            if (TRACE) {
                System.out.println("Iterator did not move. Advancing by 1.");
            }
            characterIterator.setIndex(i2);
            CharacterIteration.next32(characterIterator);
            index = characterIterator.getIndex();
            this.fRuleStatusIndex = 0;
        }
        this.fPosition = index;
        if (TRACE) {
            System.out.println("result = " + index);
        }
        return index;
    }

    @Override // com.ibm.icu.text.BreakIterator
    /* JADX INFO: renamed from: clone */
    public RuleBasedBreakIterator mo5clone() {
        RuleBasedBreakIterator ruleBasedBreakIterator = (RuleBasedBreakIterator) super.mo5clone();
        CharacterIterator characterIterator = this.fText;
        if (characterIterator != null) {
            ruleBasedBreakIterator.fText = (CharacterIterator) characterIterator.clone();
        }
        ruleBasedBreakIterator.fLookAheadMatches = new int[this.fRData.fFTable.fLookAheadResultsSize];
        ruleBasedBreakIterator.fBreakCache = ruleBasedBreakIterator.new BreakCache(this.fBreakCache);
        ruleBasedBreakIterator.fDictionaryCache = ruleBasedBreakIterator.new DictionaryCache(this.fDictionaryCache);
        return ruleBasedBreakIterator;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int current() {
        if (this.fText != null) {
            return this.fPosition;
        }
        return -1;
    }

    @Deprecated
    public void dump(PrintStream printStream) {
        if (printStream == null) {
            printStream = System.out;
        }
        this.fRData.dump(printStream);
    }

    public boolean equals(Object obj) {
        CharacterIterator characterIterator;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        try {
            RuleBasedBreakIterator ruleBasedBreakIterator = (RuleBasedBreakIterator) obj;
            RBBIDataWrapper rBBIDataWrapper = this.fRData;
            RBBIDataWrapper rBBIDataWrapper2 = ruleBasedBreakIterator.fRData;
            if (rBBIDataWrapper != rBBIDataWrapper2 && (rBBIDataWrapper == null || rBBIDataWrapper2 == null)) {
                return false;
            }
            if (rBBIDataWrapper != null && rBBIDataWrapper2 != null && !rBBIDataWrapper.fRuleSource.equals(rBBIDataWrapper2.fRuleSource)) {
                return false;
            }
            CharacterIterator characterIterator2 = this.fText;
            if (characterIterator2 == null && ruleBasedBreakIterator.fText == null) {
                return true;
            }
            if (characterIterator2 != null && (characterIterator = ruleBasedBreakIterator.fText) != null && characterIterator2.equals(characterIterator) && this.fPosition == ruleBasedBreakIterator.fPosition) {
                return true;
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int first() {
        CharacterIterator characterIterator = this.fText;
        if (characterIterator == null) {
            return -1;
        }
        characterIterator.first();
        int index = this.fText.getIndex();
        if (!this.fBreakCache.seek(index)) {
            this.fBreakCache.populateNear(index);
        }
        this.fBreakCache.current();
        return this.fPosition;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int following(int i) {
        if (i < this.fText.getBeginIndex()) {
            return first();
        }
        this.fBreakCache.following(CISetIndex32(this.fText, i));
        if (this.fDone) {
            return -1;
        }
        return this.fPosition;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int getRuleStatus() {
        int i = this.fRuleStatusIndex;
        int[] iArr = this.fRData.fStatusTable;
        return iArr[i + iArr[i]];
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int getRuleStatusVec(int[] iArr) {
        int i = this.fRData.fStatusTable[this.fRuleStatusIndex];
        if (iArr != null) {
            int iMin = Math.min(i, iArr.length);
            for (int i2 = 0; i2 < iMin; i2++) {
                iArr[i2] = this.fRData.fStatusTable[this.fRuleStatusIndex + i2 + 1];
            }
        }
        return i;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public CharacterIterator getText() {
        return this.fText;
    }

    @Deprecated
    public int handleSafePrevious(int i) {
        CharacterIterator characterIterator = this.fText;
        RBBIDataWrapper rBBIDataWrapper = this.fRData;
        CodePointTrie codePointTrie = rBBIDataWrapper.fTrie;
        char[] cArr = rBBIDataWrapper.fRTable.fTable;
        CISetIndex32(characterIterator, i);
        if (TRACE) {
            System.out.print("Handle Previous   pos   char  state category");
        }
        if (characterIterator.getIndex() == characterIterator.getBeginIndex()) {
            return -1;
        }
        char c = 1;
        int rowIndex = this.fRData.getRowIndex(1);
        for (int iPrevious32 = CharacterIteration.previous32(characterIterator); iPrevious32 != Integer.MAX_VALUE; iPrevious32 = CharacterIteration.previous32(characterIterator)) {
            short s = (short) codePointTrie.get(iPrevious32);
            if (TRACE) {
                System.out.print("            " + RBBIDataWrapper.intToString(characterIterator.getIndex(), 5));
                System.out.print(RBBIDataWrapper.intToHexString(iPrevious32, 10));
                System.out.println(RBBIDataWrapper.intToString(c, 7) + RBBIDataWrapper.intToString(s, 6));
            }
            c = cArr[rowIndex + 3 + s];
            rowIndex = this.fRData.getRowIndex(c);
            if (c == 0) {
                break;
            }
        }
        int index = characterIterator.getIndex();
        if (TRACE) {
            System.out.println("result = " + index);
        }
        return index;
    }

    public int hashCode() {
        return this.fRData.fRuleSource.hashCode();
    }

    @Override // com.ibm.icu.text.BreakIterator
    public boolean isBoundary(int i) {
        checkOffset(i, this.fText);
        int iCISetIndex32 = CISetIndex32(this.fText, i);
        boolean z = false;
        if ((this.fBreakCache.seek(iCISetIndex32) || this.fBreakCache.populateNear(iCISetIndex32)) && this.fBreakCache.current() == i) {
            z = true;
        }
        if (!z) {
            next();
        }
        return z;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int last() {
        CharacterIterator characterIterator = this.fText;
        if (characterIterator == null) {
            return -1;
        }
        int endIndex = characterIterator.getEndIndex();
        isBoundary(endIndex);
        return endIndex;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int next(int i) {
        int iPrevious = 0;
        if (i > 0) {
            while (i > 0 && iPrevious != -1) {
                iPrevious = next();
                i--;
            }
            return iPrevious;
        }
        if (i >= 0) {
            return current();
        }
        while (i < 0 && iPrevious != -1) {
            iPrevious = previous();
            i++;
        }
        return iPrevious;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int preceding(int i) {
        CharacterIterator characterIterator = this.fText;
        if (characterIterator == null || i > characterIterator.getEndIndex()) {
            return last();
        }
        if (i < this.fText.getBeginIndex()) {
            return -1;
        }
        this.fBreakCache.preceding(i);
        if (this.fDone) {
            return -1;
        }
        return this.fPosition;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int previous() {
        this.fBreakCache.previous();
        if (this.fDone) {
            return -1;
        }
        return this.fPosition;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public void setText(CharacterIterator characterIterator) {
        BreakCache breakCache = this.fBreakCache;
        if (characterIterator != null) {
            breakCache.reset(characterIterator.getBeginIndex(), 0);
        } else {
            breakCache.reset();
        }
        this.fDictionaryCache.reset();
        this.fText = characterIterator;
        first();
    }

    public String toString() {
        RBBIDataWrapper rBBIDataWrapper = this.fRData;
        return rBBIDataWrapper != null ? rBBIDataWrapper.fRuleSource : "";
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class BreakCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int CACHE_SIZE = 128;
        static final boolean RetainCachePosition = false;
        static final boolean UpdateCachePosition = true;
        int[] fBoundaries;
        int fBufIdx;
        int fEndBufIdx;
        DictionaryBreakEngine.DequeI fSideBuffer;
        int fStartBufIdx;
        short[] fStatuses;
        int fTextIdx;

        public BreakCache(BreakCache breakCache) {
            this.fBoundaries = new int[128];
            this.fStatuses = new short[128];
            this.fSideBuffer = new DictionaryBreakEngine.DequeI();
            this.fStartBufIdx = breakCache.fStartBufIdx;
            this.fEndBufIdx = breakCache.fEndBufIdx;
            this.fTextIdx = breakCache.fTextIdx;
            this.fBufIdx = breakCache.fBufIdx;
            this.fBoundaries = (int[]) breakCache.fBoundaries.clone();
            this.fStatuses = (short[]) breakCache.fStatuses.clone();
            this.fSideBuffer = new DictionaryBreakEngine.DequeI();
        }

        private final int modChunkSize(int i) {
            return i & 127;
        }

        public void addFollowing(int i, int i2, boolean z) {
            int iModChunkSize = modChunkSize(this.fEndBufIdx + 1);
            int i3 = this.fStartBufIdx;
            if (iModChunkSize == i3) {
                this.fStartBufIdx = modChunkSize(i3 + 6);
            }
            this.fBoundaries[iModChunkSize] = i;
            this.fStatuses[iModChunkSize] = (short) i2;
            this.fEndBufIdx = iModChunkSize;
            if (z) {
                this.fBufIdx = iModChunkSize;
                this.fTextIdx = i;
            }
        }

        public boolean addPreceding(int i, int i2, boolean z) {
            int iModChunkSize = modChunkSize(this.fStartBufIdx - 1);
            int i3 = this.fEndBufIdx;
            if (iModChunkSize == i3) {
                if (this.fBufIdx == i3 && !z) {
                    return false;
                }
                this.fEndBufIdx = modChunkSize(i3 - 1);
            }
            this.fBoundaries[iModChunkSize] = i;
            this.fStatuses[iModChunkSize] = (short) i2;
            this.fStartBufIdx = iModChunkSize;
            if (z) {
                this.fBufIdx = iModChunkSize;
                this.fTextIdx = i;
            }
            return true;
        }

        public int current() {
            RuleBasedBreakIterator.this.fPosition = this.fTextIdx;
            RuleBasedBreakIterator.this.fRuleStatusIndex = this.fStatuses[this.fBufIdx];
            RuleBasedBreakIterator.this.fDone = false;
            return this.fTextIdx;
        }

        public void dumpCache() {
            System.out.printf("fTextIdx:%d   fBufIdx:%d%n", Integer.valueOf(this.fTextIdx), Integer.valueOf(this.fBufIdx));
            int iModChunkSize = this.fStartBufIdx;
            while (true) {
                System.out.printf("%d  %d%n", Integer.valueOf(iModChunkSize), Integer.valueOf(this.fBoundaries[iModChunkSize]));
                if (iModChunkSize == this.fEndBufIdx) {
                    return;
                } else {
                    iModChunkSize = modChunkSize(iModChunkSize + 1);
                }
            }
        }

        public void following(int i) {
            if (i == this.fTextIdx || seek(i) || populateNear(i)) {
                RuleBasedBreakIterator.this.fDone = false;
                next();
            }
        }

        public void next() {
            int i = this.fBufIdx;
            if (i == this.fEndBufIdx) {
                RuleBasedBreakIterator.this.fDone = !populateFollowing();
                RuleBasedBreakIterator.this.fPosition = this.fTextIdx;
                RuleBasedBreakIterator.this.fRuleStatusIndex = this.fStatuses[this.fBufIdx];
                return;
            }
            int iModChunkSize = modChunkSize(i + 1);
            this.fBufIdx = iModChunkSize;
            RuleBasedBreakIterator ruleBasedBreakIterator = RuleBasedBreakIterator.this;
            int i2 = this.fBoundaries[iModChunkSize];
            ruleBasedBreakIterator.fPosition = i2;
            this.fTextIdx = i2;
            RuleBasedBreakIterator.this.fRuleStatusIndex = this.fStatuses[this.fBufIdx];
        }

        public boolean populateFollowing() {
            int iHandleNext;
            int[] iArr = this.fBoundaries;
            int i = this.fEndBufIdx;
            int i2 = iArr[i];
            short s = this.fStatuses[i];
            boolean zFollowing = RuleBasedBreakIterator.this.fDictionaryCache.following(i2);
            RuleBasedBreakIterator ruleBasedBreakIterator = RuleBasedBreakIterator.this;
            if (zFollowing) {
                addFollowing(ruleBasedBreakIterator.fDictionaryCache.fBoundary, RuleBasedBreakIterator.this.fDictionaryCache.fStatusIndex, true);
                return true;
            }
            ruleBasedBreakIterator.fPosition = i2;
            int iHandleNext2 = RuleBasedBreakIterator.this.handleNext();
            if (iHandleNext2 == -1) {
                return false;
            }
            int i3 = RuleBasedBreakIterator.this.fRuleStatusIndex;
            if (RuleBasedBreakIterator.this.fDictionaryCharCount > 0) {
                RuleBasedBreakIterator.this.fDictionaryCache.populateDictionary(i2, iHandleNext2, s, i3);
                if (RuleBasedBreakIterator.this.fDictionaryCache.following(i2)) {
                    addFollowing(RuleBasedBreakIterator.this.fDictionaryCache.fBoundary, RuleBasedBreakIterator.this.fDictionaryCache.fStatusIndex, true);
                    return true;
                }
            }
            addFollowing(iHandleNext2, i3, true);
            for (int i4 = 0; i4 < 6 && (iHandleNext = RuleBasedBreakIterator.this.handleNext()) != -1 && RuleBasedBreakIterator.this.fDictionaryCharCount <= 0; i4++) {
                addFollowing(iHandleNext, RuleBasedBreakIterator.this.fRuleStatusIndex, false);
            }
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:6:0x001f  */
        public boolean populateNear(int i) {
            int i2;
            boolean z;
            int i3;
            int i4;
            int i5;
            int beginIndex = RuleBasedBreakIterator.this.fText.getBeginIndex();
            int[] iArr = this.fBoundaries;
            if (i <= iArr[this.fStartBufIdx] - 15 || i >= iArr[this.fEndBufIdx] + 15) {
                int i6 = beginIndex + 15;
                if (i <= i6) {
                    z = false;
                    i2 = 0;
                } else {
                    int iHandleSafePrevious = RuleBasedBreakIterator.this.handleSafePrevious(i);
                    int[] iArr2 = this.fBoundaries;
                    int i7 = iArr2[this.fEndBufIdx];
                    if (i7 < i && i7 >= iHandleSafePrevious - 15) {
                        z = true;
                        beginIndex = -1;
                    } else if (iHandleSafePrevious < i6) {
                        z = iArr2[this.fStartBufIdx] <= i + 15;
                    } else {
                        RuleBasedBreakIterator.this.fPosition = iHandleSafePrevious;
                        beginIndex = RuleBasedBreakIterator.this.handleNext();
                        if (beginIndex == iHandleSafePrevious + 1 || (beginIndex == iHandleSafePrevious + 2 && Character.isHighSurrogate(RuleBasedBreakIterator.this.fText.setIndex(iHandleSafePrevious)) && Character.isLowSurrogate(RuleBasedBreakIterator.this.fText.next()))) {
                            beginIndex = RuleBasedBreakIterator.this.handleNext();
                        }
                        if (beginIndex == -1) {
                            beginIndex = RuleBasedBreakIterator.this.fText.getEndIndex();
                        }
                        i2 = RuleBasedBreakIterator.this.fRuleStatusIndex;
                        z = false;
                    }
                    i2 = 0;
                }
            } else {
                z = true;
                beginIndex = -1;
                i2 = 0;
            }
            if (!z) {
                reset(beginIndex, i2);
            }
            int[] iArr3 = this.fBoundaries;
            if (iArr3[this.fEndBufIdx] < i) {
                do {
                    int[] iArr4 = this.fBoundaries;
                    int i8 = this.fEndBufIdx;
                    int i9 = iArr4[i8];
                    if (i9 >= i) {
                        this.fBufIdx = i8;
                        this.fTextIdx = i9;
                        while (this.fTextIdx > i) {
                            previous();
                        }
                        return true;
                    }
                } while (populateFollowing());
                return false;
            }
            if (iArr3[this.fStartBufIdx] > i) {
                while (true) {
                    int[] iArr5 = this.fBoundaries;
                    i3 = this.fStartBufIdx;
                    i4 = iArr5[i3];
                    if (i4 <= i) {
                        break;
                    }
                    populatePreceding();
                }
                this.fBufIdx = i3;
                this.fTextIdx = i4;
                while (true) {
                    i5 = this.fTextIdx;
                    if (i5 >= i) {
                        break;
                    }
                    next();
                }
                if (i5 > i) {
                    previous();
                }
            }
            return true;
        }

        public boolean populatePreceding() {
            int iHandleNext;
            int i;
            boolean z;
            int beginIndex = RuleBasedBreakIterator.this.fText.getBeginIndex();
            int i2 = this.fBoundaries[this.fStartBufIdx];
            if (i2 == beginIndex) {
                return false;
            }
            boolean z2 = true;
            if (RuleBasedBreakIterator.this.fDictionaryCache.preceding(i2)) {
                addPreceding(RuleBasedBreakIterator.this.fDictionaryCache.fBoundary, RuleBasedBreakIterator.this.fDictionaryCache.fStatusIndex, true);
                return true;
            }
            int iHandleSafePrevious = i2;
            do {
                int i3 = iHandleSafePrevious - 30;
                iHandleSafePrevious = i3 <= beginIndex ? beginIndex : RuleBasedBreakIterator.this.handleSafePrevious(i3);
                if (iHandleSafePrevious == -1 || iHandleSafePrevious == beginIndex) {
                    iHandleNext = beginIndex;
                    i = 0;
                } else {
                    RuleBasedBreakIterator.this.fPosition = iHandleSafePrevious;
                    iHandleNext = RuleBasedBreakIterator.this.handleNext();
                    if (iHandleNext == iHandleSafePrevious + 1 || (iHandleNext == iHandleSafePrevious + 2 && Character.isHighSurrogate(RuleBasedBreakIterator.this.fText.setIndex(iHandleSafePrevious)) && Character.isLowSurrogate(RuleBasedBreakIterator.this.fText.next()))) {
                        iHandleNext = RuleBasedBreakIterator.this.handleNext();
                    }
                    i = RuleBasedBreakIterator.this.fRuleStatusIndex;
                }
            } while (iHandleNext >= i2);
            this.fSideBuffer.removeAllElements();
            this.fSideBuffer.push(iHandleNext);
            this.fSideBuffer.push(i);
            while (true) {
                RuleBasedBreakIterator.this.fPosition = iHandleNext;
                int iHandleNext2 = RuleBasedBreakIterator.this.handleNext();
                int i4 = RuleBasedBreakIterator.this.fRuleStatusIndex;
                if (iHandleNext2 == -1) {
                    break;
                }
                if (RuleBasedBreakIterator.this.fDictionaryCharCount != 0) {
                    RuleBasedBreakIterator.this.fDictionaryCache.populateDictionary(iHandleNext, iHandleNext2, i, i4);
                    z = false;
                    while (RuleBasedBreakIterator.this.fDictionaryCache.following(iHandleNext)) {
                        iHandleNext = RuleBasedBreakIterator.this.fDictionaryCache.fBoundary;
                        i4 = RuleBasedBreakIterator.this.fDictionaryCache.fStatusIndex;
                        if (iHandleNext >= i2) {
                            z = true;
                            iHandleNext2 = iHandleNext;
                            break;
                        }
                        this.fSideBuffer.push(iHandleNext);
                        this.fSideBuffer.push(i4);
                        z = true;
                        iHandleNext2 = iHandleNext;
                    }
                } else {
                    z = false;
                }
                iHandleNext = iHandleNext2;
                if (!z && iHandleNext < i2) {
                    this.fSideBuffer.push(iHandleNext);
                    this.fSideBuffer.push(i4);
                }
                if (iHandleNext >= i2) {
                    break;
                }
                i = i4;
            }
            if (this.fSideBuffer.isEmpty()) {
                z2 = false;
            } else {
                addPreceding(this.fSideBuffer.pop(), this.fSideBuffer.pop(), true);
            }
            while (!this.fSideBuffer.isEmpty()) {
                if (!addPreceding(this.fSideBuffer.pop(), this.fSideBuffer.pop(), false)) {
                    break;
                }
            }
            return z2;
        }

        public void preceding(int i) {
            if (i == this.fTextIdx || seek(i) || populateNear(i)) {
                if (i == this.fTextIdx) {
                    previous();
                } else {
                    current();
                }
            }
        }

        public void previous() {
            int i = this.fBufIdx;
            if (i == this.fStartBufIdx) {
                populatePreceding();
            } else {
                int iModChunkSize = modChunkSize(i - 1);
                this.fBufIdx = iModChunkSize;
                this.fTextIdx = this.fBoundaries[iModChunkSize];
            }
            RuleBasedBreakIterator.this.fDone = this.fBufIdx == i;
            RuleBasedBreakIterator.this.fPosition = this.fTextIdx;
            RuleBasedBreakIterator.this.fRuleStatusIndex = this.fStatuses[this.fBufIdx];
        }

        public void reset(int i, int i2) {
            this.fStartBufIdx = 0;
            this.fEndBufIdx = 0;
            this.fTextIdx = i;
            this.fBufIdx = 0;
            this.fBoundaries[0] = i;
            this.fStatuses[0] = (short) i2;
        }

        public boolean seek(int i) {
            int i2;
            int i3;
            int[] iArr = this.fBoundaries;
            int iModChunkSize = this.fStartBufIdx;
            int i4 = iArr[iModChunkSize];
            if (i < i4 || i > (i3 = iArr[(i2 = this.fEndBufIdx)])) {
                return false;
            }
            if (i == i4) {
                this.fBufIdx = iModChunkSize;
                this.fTextIdx = i4;
                return true;
            }
            if (i == i3) {
                this.fBufIdx = i2;
                this.fTextIdx = i3;
                return true;
            }
            while (iModChunkSize != i2) {
                int iModChunkSize2 = modChunkSize(((iModChunkSize + i2) + (iModChunkSize > i2 ? 128 : 0)) / 2);
                if (this.fBoundaries[iModChunkSize2] > i) {
                    i2 = iModChunkSize2;
                } else {
                    iModChunkSize = modChunkSize(iModChunkSize2 + 1);
                }
            }
            int iModChunkSize3 = modChunkSize(i2 - 1);
            this.fBufIdx = iModChunkSize3;
            this.fTextIdx = this.fBoundaries[iModChunkSize3];
            return true;
        }

        public void reset() {
            reset(0, 0);
        }

        public BreakCache() {
            this.fBoundaries = new int[128];
            this.fStatuses = new short[128];
            this.fSideBuffer = new DictionaryBreakEngine.DequeI();
            reset();
        }
    }

    public static RuleBasedBreakIterator getInstanceFromCompiledRules(ByteBuffer byteBuffer, boolean z) {
        RuleBasedBreakIterator instanceFromCompiledRules = getInstanceFromCompiledRules(byteBuffer);
        instanceFromCompiledRules.fPhraseBreaking = z;
        return instanceFromCompiledRules;
    }

    @Deprecated
    public static RuleBasedBreakIterator getInstanceFromCompiledRules(ByteBuffer byteBuffer) {
        RuleBasedBreakIterator ruleBasedBreakIterator = new RuleBasedBreakIterator();
        RBBIDataWrapper rBBIDataWrapper = RBBIDataWrapper.get(byteBuffer);
        ruleBasedBreakIterator.fRData = rBBIDataWrapper;
        ruleBasedBreakIterator.fLookAheadMatches = new int[rBBIDataWrapper.fFTable.fLookAheadResultsSize];
        return ruleBasedBreakIterator;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int next() {
        this.fBreakCache.next();
        if (this.fDone) {
            return -1;
        }
        return this.fPosition;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class DictionaryCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        int fBoundary;
        DictionaryBreakEngine.DequeI fBreaks;
        int fFirstRuleStatusIndex;
        int fLimit;
        int fOtherRuleStatusIndex;
        int fPositionInCache;
        int fStart;
        int fStatusIndex;
        private boolean isWordLike;

        public DictionaryCache(DictionaryCache dictionaryCache) {
            try {
                this.fBreaks = dictionaryCache.fBreaks.m7clone();
                this.fPositionInCache = dictionaryCache.fPositionInCache;
                this.fStart = dictionaryCache.fStart;
                this.fLimit = dictionaryCache.fLimit;
                this.fFirstRuleStatusIndex = dictionaryCache.fFirstRuleStatusIndex;
                this.fOtherRuleStatusIndex = dictionaryCache.fOtherRuleStatusIndex;
                this.fBoundary = dictionaryCache.fBoundary;
                this.fStatusIndex = dictionaryCache.fStatusIndex;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean following(int i) {
            if (i >= this.fLimit || i < this.fStart) {
                this.fPositionInCache = -1;
                return false;
            }
            int i2 = this.fPositionInCache;
            if (i2 >= 0 && i2 < this.fBreaks.size() && this.fBreaks.elementAt(this.fPositionInCache) == i) {
                int i3 = this.fPositionInCache + 1;
                this.fPositionInCache = i3;
                if (i3 >= this.fBreaks.size()) {
                    this.fPositionInCache = -1;
                    return false;
                }
                int iElementAt = this.fBreaks.elementAt(this.fPositionInCache);
                this.fBoundary = iElementAt;
                this.fStatusIndex = (this.isWordLike || iElementAt == this.fLimit) ? this.fOtherRuleStatusIndex : 0;
                return true;
            }
            this.fPositionInCache = 0;
            while (this.fPositionInCache < this.fBreaks.size()) {
                int iElementAt2 = this.fBreaks.elementAt(this.fPositionInCache);
                if (iElementAt2 > i) {
                    this.fBoundary = iElementAt2;
                    this.fStatusIndex = (this.isWordLike || iElementAt2 == this.fLimit) ? this.fOtherRuleStatusIndex : 0;
                    return true;
                }
                this.fPositionInCache++;
            }
            this.fPositionInCache = -1;
            return false;
        }

        public void populateDictionary(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            if (i2 - i <= 1) {
                return;
            }
            reset();
            this.fFirstRuleStatusIndex = i3;
            this.fOtherRuleStatusIndex = i4;
            RuleBasedBreakIterator.this.fText.setIndex(i);
            int iCurrent32 = CharacterIteration.current32(RuleBasedBreakIterator.this.fText);
            short s = (short) RuleBasedBreakIterator.this.fRData.fTrie.get(iCurrent32);
            int i7 = RuleBasedBreakIterator.this.fRData.fFTable.fDictCategoriesStart;
            int iFindBreaks = 0;
            while (true) {
                int index = RuleBasedBreakIterator.this.fText.getIndex();
                if (index < i2 && s < i7) {
                    iCurrent32 = CharacterIteration.next32(RuleBasedBreakIterator.this.fText);
                    s = (short) RuleBasedBreakIterator.this.fRData.fTrie.get(iCurrent32);
                } else {
                    if (index >= i2) {
                        break;
                    }
                    LanguageBreakEngine languageBreakEngine = RuleBasedBreakIterator.this.getLanguageBreakEngine(iCurrent32);
                    if (languageBreakEngine != null) {
                        i5 = i;
                        i6 = i2;
                        iFindBreaks += languageBreakEngine.findBreaks(RuleBasedBreakIterator.this.fText, i5, i6, this.fBreaks, RuleBasedBreakIterator.this.fPhraseBreaking);
                    } else {
                        i5 = i;
                        i6 = i2;
                    }
                    iCurrent32 = CharacterIteration.current32(RuleBasedBreakIterator.this.fText);
                    s = (short) RuleBasedBreakIterator.this.fRData.fTrie.get(iCurrent32);
                    i = i5;
                    i2 = i6;
                }
            }
            if (iFindBreaks > 0) {
                if (i < this.fBreaks.elementAt(0)) {
                    this.fBreaks.offer(i);
                }
                if (i2 > this.fBreaks.peek()) {
                    this.fBreaks.push(i2);
                }
                this.fPositionInCache = 0;
                this.fStart = this.fBreaks.elementAt(0);
                this.fLimit = this.fBreaks.peek();
            }
        }

        public boolean preceding(int i) {
            int i2;
            int i3 = 0;
            if (i <= this.fStart || i > (i2 = this.fLimit)) {
                this.fPositionInCache = -1;
                return false;
            }
            if (i == i2) {
                this.fPositionInCache = this.fBreaks.size() - 1;
            }
            int i4 = this.fPositionInCache;
            if (i4 > 0 && i4 < this.fBreaks.size() && this.fBreaks.elementAt(this.fPositionInCache) == i) {
                int i5 = this.fPositionInCache - 1;
                this.fPositionInCache = i5;
                int iElementAt = this.fBreaks.elementAt(i5);
                this.fBoundary = iElementAt;
                if (iElementAt == this.fStart) {
                    i3 = this.fFirstRuleStatusIndex;
                } else if (this.isWordLike) {
                    i3 = this.fOtherRuleStatusIndex;
                }
                this.fStatusIndex = i3;
                return true;
            }
            if (this.fPositionInCache == 0) {
                this.fPositionInCache = -1;
                return false;
            }
            int size = this.fBreaks.size();
            while (true) {
                this.fPositionInCache = size - 1;
                int i6 = this.fPositionInCache;
                if (i6 < 0) {
                    this.fPositionInCache = -1;
                    return false;
                }
                int iElementAt2 = this.fBreaks.elementAt(i6);
                if (iElementAt2 < i) {
                    this.fBoundary = iElementAt2;
                    if (iElementAt2 == this.fStart) {
                        i3 = this.fFirstRuleStatusIndex;
                    } else if (this.isWordLike) {
                        i3 = this.fOtherRuleStatusIndex;
                    }
                    this.fStatusIndex = i3;
                    return true;
                }
                size = this.fPositionInCache;
            }
        }

        public void reset() {
            this.fPositionInCache = -1;
            this.fStart = 0;
            this.fLimit = 0;
            this.fFirstRuleStatusIndex = 0;
            this.fOtherRuleStatusIndex = 0;
            this.fBreaks.removeAllElements();
            int iMax = 0;
            for (int i : RuleBasedBreakIterator.this.fRData.fStatusTable) {
                iMax = Math.max(i, iMax);
            }
            this.isWordLike = iMax > 100;
        }

        public DictionaryCache() {
            this.fPositionInCache = -1;
            this.fBreaks = new DictionaryBreakEngine.DequeI();
        }
    }

    public RuleBasedBreakIterator(String str) {
        this(str, null);
    }

    private RuleBasedBreakIterator() {
        this.fText = new java.text.StringCharacterIterator("");
        this.fBreakCache = new BreakCache();
        this.fPhraseBreaking = false;
        this.fDictionaryCache = new DictionaryCache();
        this.fDictionaryCharCount = 0;
    }
}
