package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jg1 {
    public static volatile Handler a;
    public static final bg b = new bg(3);
    public static final bg c = new bg(2);
    public static final cg d = new cg();
    public static final xy e;
    public static final su0 f;

    static {
        int i = 9;
        e = new xy(i);
        f = new su0(i);
    }

    public static void a(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            og.n(ky0.l("Must be called on ", handler.getLooper().getThread().getName(), " thread, but got ", looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper", "."));
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            og.i("Given String is empty or null");
        }
    }

    public static void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            og.i(str2);
        }
    }

    public static void d(Object obj) {
        if (obj != null) {
            return;
        }
        dk0.n("null reference");
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        dk0.n(str);
    }

    public static void f(String str, boolean z) {
        if (z) {
            return;
        }
        og.n(str);
    }

    public static Handler g() {
        if (a != null) {
            return a;
        }
        synchronized (jg1.class) {
            try {
                if (a == null) {
                    a = go4.a(Looper.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a;
    }

    public static void h(int i, int[] iArr, int[] iArr2, boolean z) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float f2 = (i - i3) / 2.0f;
        if (!z) {
            int length = iArr.length;
            int i5 = 0;
            while (i2 < length) {
                int i6 = iArr[i2];
                iArr2[i5] = Math.round(f2);
                f2 += i6;
                i2++;
                i5++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i7 = iArr[length2];
            iArr2[length2] = Math.round(f2);
            f2 += i7;
        }
    }

    public static void i(int i, int[] iArr, int[] iArr2, boolean z) {
        if (iArr.length == 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float fMax = (i - i3) / Math.max(iArr.length - 1, 1);
        float f2 = (z && iArr.length == 1) ? fMax : 0.0f;
        if (z) {
            for (int length = iArr.length - 1; -1 < length; length--) {
                int i5 = iArr[length];
                iArr2[length] = Math.round(f2);
                f2 += i5 + fMax;
            }
            return;
        }
        int length2 = iArr.length;
        int i6 = 0;
        while (i2 < length2) {
            int i7 = iArr[i2];
            iArr2[i6] = Math.round(f2);
            f2 += i7 + fMax;
            i2++;
            i6++;
        }
    }
}
