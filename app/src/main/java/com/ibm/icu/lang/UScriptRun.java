package com.ibm.icu.lang;

import com.ibm.icu.text.UTF16;
import defpackage.dk0;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class UScriptRun {
    private static final int PAREN_STACK_DEPTH = 32;
    private static int pairedCharExtra;
    private static int pairedCharPower;
    private static int[] pairedChars;
    private char[] emptyCharArray;
    private int fixupCount;
    private int parenSP;
    private ParenStackEntry[] parenStack;
    private int pushCount;
    private int scriptCode;
    private int scriptLimit;
    private int scriptStart;
    private char[] text;
    private int textIndex;
    private int textLimit;
    private int textStart;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ParenStackEntry {
        int pairIndex;
        int scriptCode;

        public ParenStackEntry(int i, int i2) {
            this.pairIndex = i;
            this.scriptCode = i2;
        }
    }

    static {
        int[] iArr = {40, 41, 60, 62, 91, 93, 123, 125, 171, 187, 8216, 8217, 8220, 8221, 8249, 8250, 12296, 12297, 12298, 12299, 12300, 12301, 12302, 12303, 12304, 12305, 12308, 12309, 12310, 12311, 12312, 12313, 12314, 12315};
        pairedChars = iArr;
        int iHighBit = 1 << highBit(iArr.length);
        pairedCharPower = iHighBit;
        pairedCharExtra = pairedChars.length - iHighBit;
    }

    @Deprecated
    public UScriptRun() {
        this.emptyCharArray = new char[0];
        this.parenStack = new ParenStackEntry[32];
        this.parenSP = -1;
        this.pushCount = 0;
        this.fixupCount = 0;
        reset((char[]) null, 0, 0);
    }

    private static final int dec(int i, int i2) {
        return mod((i + 32) - i2);
    }

    private final void fixup(int i) {
        int iDec = dec(this.parenSP, this.fixupCount);
        while (true) {
            int i2 = this.fixupCount;
            this.fixupCount = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            iDec = inc(iDec);
            this.parenStack[iDec].scriptCode = i;
        }
    }

    private static int getPairIndex(int i) {
        int i2 = pairedCharPower;
        int[] iArr = pairedChars;
        int i3 = pairedCharExtra;
        if (i < iArr[i3]) {
            i3 = 0;
        }
        while (i2 > 1) {
            i2 >>= 1;
            int i4 = i3 + i2;
            if (i >= pairedChars[i4]) {
                i3 = i4;
            }
        }
        if (pairedChars[i3] != i) {
            return -1;
        }
        return i3;
    }

    private static final byte highBit(int i) {
        byte b;
        if (i <= 0) {
            return (byte) -32;
        }
        if (i >= 65536) {
            i >>= 16;
            b = 16;
        } else {
            b = 0;
        }
        if (i >= 256) {
            i >>= 8;
            b = (byte) (b + 8);
        }
        if (i >= 16) {
            i >>= 4;
            b = (byte) (b + 4);
        }
        if (i >= 4) {
            i >>= 2;
            b = (byte) (b + 2);
        }
        return i >= 2 ? (byte) (b + 1) : b;
    }

    private static final int inc(int i, int i2) {
        return mod(i + i2);
    }

    private static final int limitInc(int i) {
        return i < 32 ? i + 1 : i;
    }

    private static final int mod(int i) {
        return i % 32;
    }

    private final void pop() {
        if (stackIsEmpty()) {
            return;
        }
        ParenStackEntry[] parenStackEntryArr = this.parenStack;
        int i = this.parenSP;
        parenStackEntryArr[i] = null;
        int i2 = this.fixupCount;
        if (i2 > 0) {
            this.fixupCount = i2 - 1;
        }
        this.pushCount--;
        this.parenSP = dec(i);
        if (stackIsEmpty()) {
            this.parenSP = -1;
        }
    }

    private final void push(int i, int i2) {
        this.pushCount = limitInc(this.pushCount);
        this.fixupCount = limitInc(this.fixupCount);
        int iInc = inc(this.parenSP);
        this.parenSP = iInc;
        this.parenStack[iInc] = new ParenStackEntry(i, i2);
    }

    private static boolean sameScript(int i, int i2) {
        return i <= 1 || i2 <= 1 || i == i2;
    }

    private final boolean stackIsEmpty() {
        return this.pushCount <= 0;
    }

    private final boolean stackIsNotEmpty() {
        return !stackIsEmpty();
    }

    private final void syncFixup() {
        this.fixupCount = 0;
    }

    private final ParenStackEntry top() {
        return this.parenStack[this.parenSP];
    }

    @Deprecated
    public final int getScriptCode() {
        return this.scriptCode;
    }

    @Deprecated
    public final int getScriptLimit() {
        return this.scriptLimit;
    }

    @Deprecated
    public final int getScriptStart() {
        return this.scriptStart;
    }

    @Deprecated
    public final boolean next() {
        int i = this.scriptLimit;
        if (i >= this.textLimit) {
            return false;
        }
        this.scriptCode = 0;
        this.scriptStart = i;
        syncFixup();
        while (true) {
            int i2 = this.textIndex;
            int i3 = this.textLimit;
            if (i2 >= i3) {
                break;
            }
            char[] cArr = this.text;
            int i4 = this.textStart;
            int iCharAt = UTF16.charAt(cArr, i4, i3, i2 - i4);
            int charCount = UTF16.getCharCount(iCharAt);
            int script = UScript.getScript(iCharAt);
            int pairIndex = getPairIndex(iCharAt);
            this.textIndex += charCount;
            if (pairIndex >= 0) {
                if ((pairIndex & 1) == 0) {
                    push(pairIndex, this.scriptCode);
                } else {
                    int i5 = pairIndex & (-2);
                    while (stackIsNotEmpty() && top().pairIndex != i5) {
                        pop();
                    }
                    if (stackIsNotEmpty()) {
                        script = top().scriptCode;
                    }
                }
            }
            if (!sameScript(this.scriptCode, script)) {
                this.textIndex -= charCount;
                break;
            }
            if (this.scriptCode <= 1 && script > 1) {
                this.scriptCode = script;
                fixup(script);
            }
            if (pairIndex >= 0 && (pairIndex & 1) != 0) {
                pop();
            }
        }
        this.scriptLimit = this.textIndex;
        return true;
    }

    @Deprecated
    public final void reset() {
        while (stackIsNotEmpty()) {
            pop();
        }
        int i = this.textStart;
        this.scriptStart = i;
        this.scriptLimit = i;
        this.scriptCode = -1;
        this.parenSP = -1;
        this.pushCount = 0;
        this.fixupCount = 0;
        this.textIndex = i;
    }

    private static final int inc(int i) {
        return inc(i, 1);
    }

    private static final int dec(int i) {
        return dec(i, 1);
    }

    @Deprecated
    public UScriptRun(String str) {
        this.emptyCharArray = new char[0];
        this.parenStack = new ParenStackEntry[32];
        this.parenSP = -1;
        this.pushCount = 0;
        this.fixupCount = 0;
        reset(str);
    }

    @Deprecated
    public final void reset(int i, int i2) {
        char[] cArr = this.text;
        int length = cArr != null ? cArr.length : 0;
        if (i >= 0 && i2 >= 0 && i <= length - i2) {
            this.textStart = i;
            this.textLimit = i + i2;
            reset();
            return;
        }
        dk0.v();
    }

    @Deprecated
    public UScriptRun(String str, int i, int i2) {
        this.emptyCharArray = new char[0];
        this.parenStack = new ParenStackEntry[32];
        this.parenSP = -1;
        this.pushCount = 0;
        this.fixupCount = 0;
        reset(str, i, i2);
    }

    @Deprecated
    public final void reset(char[] cArr, int i, int i2) {
        if (cArr == null) {
            cArr = this.emptyCharArray;
        }
        this.text = cArr;
        reset(i, i2);
    }

    @Deprecated
    public final void reset(char[] cArr) {
        reset(cArr, 0, cArr != null ? cArr.length : 0);
    }

    @Deprecated
    public UScriptRun(char[] cArr) {
        this.emptyCharArray = new char[0];
        this.parenStack = new ParenStackEntry[32];
        this.parenSP = -1;
        this.pushCount = 0;
        this.fixupCount = 0;
        reset(cArr);
    }

    @Deprecated
    public final void reset(String str, int i, int i2) {
        reset(str != null ? str.toCharArray() : null, i, i2);
    }

    @Deprecated
    public final void reset(String str) {
        reset(str, 0, str != null ? str.length() : 0);
    }

    @Deprecated
    public UScriptRun(char[] cArr, int i, int i2) {
        this.emptyCharArray = new char[0];
        this.parenStack = new ParenStackEntry[32];
        this.parenSP = -1;
        this.pushCount = 0;
        this.fixupCount = 0;
        reset(cArr, i, i2);
    }
}
