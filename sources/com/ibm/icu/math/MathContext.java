package com.ibm.icu.math;

import defpackage.ky0;
import defpackage.og;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class MathContext implements Serializable {
    private static final int DEFAULT_DIGITS = 9;
    private static final int DEFAULT_FORM = 1;
    private static final boolean DEFAULT_LOSTDIGITS = false;
    private static final int DEFAULT_ROUNDINGMODE = 4;
    public static final int ENGINEERING = 2;
    private static final int MAX_DIGITS = 999999999;
    private static final int MIN_DIGITS = 0;
    public static final int PLAIN = 0;
    public static final int ROUND_CEILING = 2;
    public static final int ROUND_DOWN = 1;
    public static final int ROUND_FLOOR = 3;
    public static final int ROUND_HALF_DOWN = 5;
    public static final int ROUND_HALF_EVEN = 6;
    public static final int ROUND_HALF_UP = 4;
    public static final int ROUND_UNNECESSARY = 7;
    public static final int ROUND_UP = 0;
    public static final int SCIENTIFIC = 1;
    private static final long serialVersionUID = 7163376998892515376L;
    int digits;
    int form;
    boolean lostDigits;
    int roundingMode;
    private static final int[] ROUNDS = {4, 7, 2, 1, 3, 5, 6, 0};
    private static final String[] ROUNDWORDS = {"ROUND_HALF_UP", "ROUND_UNNECESSARY", "ROUND_CEILING", "ROUND_DOWN", "ROUND_FLOOR", "ROUND_HALF_DOWN", "ROUND_HALF_EVEN", "ROUND_UP"};
    public static final MathContext DEFAULT = new MathContext(9, 1, false, 4);

    public MathContext(int i, int i2, boolean z, int i3) {
        if (i != 9) {
            if (i < 0) {
                og.i(ky0.h(i, "Digits too small: "));
                throw null;
            }
            if (i > MAX_DIGITS) {
                og.i(ky0.h(i, "Digits too large: "));
                throw null;
            }
        }
        if (i2 != 1 && i2 != 2 && i2 != 0) {
            og.i(ky0.h(i2, "Bad form value: "));
            throw null;
        }
        if (!isValidRound(i3)) {
            og.i(ky0.h(i3, "Bad roundingMode value: "));
            throw null;
        }
        this.digits = i;
        this.form = i2;
        this.lostDigits = z;
        this.roundingMode = i3;
    }

    private static boolean isValidRound(int i) {
        int length = ROUNDS.length;
        int i2 = 0;
        while (length > 0) {
            if (i == ROUNDS[i2]) {
                return true;
            }
            length--;
            i2++;
        }
        return false;
    }

    public int getDigits() {
        return this.digits;
    }

    public int getForm() {
        return this.form;
    }

    public boolean getLostDigits() {
        return this.lostDigits;
    }

    public int getRoundingMode() {
        return this.roundingMode;
    }

    public String toString() {
        String str;
        String str2;
        int i = this.form;
        if (i == 1) {
            str = "SCIENTIFIC";
        } else {
            str = i == 2 ? "ENGINEERING" : "PLAIN";
        }
        int length = ROUNDS.length;
        int i2 = 0;
        while (true) {
            if (length <= 0) {
                str2 = null;
                break;
            }
            if (this.roundingMode == ROUNDS[i2]) {
                str2 = ROUNDWORDS[i2];
                break;
            }
            length--;
            i2++;
        }
        return "digits=" + this.digits + " form=" + str + " lostDigits=" + (this.lostDigits ? "1" : "0") + " roundingMode=" + str2;
    }

    public MathContext(int i, int i2) {
        this(i, i2, false, 4);
    }

    public MathContext(int i, int i2, boolean z) {
        this(i, i2, z, 4);
    }

    public MathContext(int i) {
        this(i, 1, false, 4);
    }
}
