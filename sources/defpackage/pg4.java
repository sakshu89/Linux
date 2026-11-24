package defpackage;

import com.ibm.icu.lang.UCharacter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class pg4 {
    public static int a(int i, int i2, boolean z) {
        int i3 = z ? ((i2 - i) + 360) % 360 : (i2 + i) % 360;
        if (xq4.c(2, "CameraOrientationUtil")) {
            StringBuilder sbP = cq.p("getRelativeImageRotation: destRotationDegrees=", i, ", sourceRotationDegrees=", i2, ", isOppositeFacing=");
            sbP.append(z);
            sbP.append(", result=");
            sbP.append(i3);
            xq4.c(3, "CameraOrientationUtil");
        }
        return i3;
    }

    public static int b(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 90;
        }
        if (i == 2) {
            return 180;
        }
        if (i == 3) {
            return UCharacter.UnicodeBlock.NEWA_ID;
        }
        og.i(ky0.h(i, "Unsupported surface rotation: "));
        return 0;
    }

    public static void c(int i, int i2) {
        String strB;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                strB = rg4.b("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i2 < 0) {
                    og.i(ky0.h(i2, "negative size: "));
                    return;
                }
                strB = rg4.b("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(strB);
        }
    }

    public static void d(int i, int i2, int i3) {
        String strE;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strE = e(i, i3, "start index");
            } else {
                strE = (i2 < 0 || i2 > i3) ? e(i2, i3, "end index") : rg4.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strE);
        }
    }

    public static String e(int i, int i2, String str) {
        if (i < 0) {
            return rg4.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return rg4.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        og.i(ky0.h(i2, "negative size: "));
        return null;
    }
}
