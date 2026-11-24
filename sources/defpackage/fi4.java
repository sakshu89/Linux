package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class fi4 {
    public static final void a(Closeable closeable, Throwable th) throws IllegalAccessException, IOException, InvocationTargetException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                gn4.a(th, th2);
            }
        }
    }

    public static void b(int i, int i2) {
        String strB;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                strB = hi4.b("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i2 < 0) {
                    og.i(ky0.h(i2, "negative size: "));
                    return;
                }
                strB = hi4.b("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(strB);
        }
    }

    public static void c(int i, int i2, int i3) {
        String strD;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strD = d(i, i3, "start index");
            } else {
                strD = (i2 < 0 || i2 > i3) ? d(i2, i3, "end index") : hi4.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strD);
        }
    }

    public static String d(int i, int i2, String str) {
        if (i < 0) {
            return hi4.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return hi4.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        og.i(ky0.h(i2, "negative size: "));
        return null;
    }
}
