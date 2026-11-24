package defpackage;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class hh1 {
    public static void a(String str, boolean z) {
        if (z) {
            return;
        }
        og.i(str);
    }

    public static void b(boolean z) {
        if (z) {
            return;
        }
        dk0.v();
    }

    public static void c(int i, int i2, int i3, String str) {
        if (i < i2) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(str + " is out of range of [" + i2 + ", " + i3 + "] (too low)");
        }
        if (i <= i3) {
            return;
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException(str + " is out of range of [" + i2 + ", " + i3 + "] (too high)");
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        dk0.n(str);
    }

    public static void e(String str, boolean z) {
        if (z) {
            return;
        }
        og.n(str);
    }

    public static int f(float f) {
        if (!Float.isNaN(f)) {
            return Math.round(f);
        }
        og.i("Cannot round NaN value.");
        return 0;
    }
}
