package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zc4 {
    public static final Bitmap a(p9 p9Var) {
        if (p9Var instanceof p9) {
            return p9Var.a;
        }
        dk0.r("Unable to obtain android.graphics.Bitmap");
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static c13 b(String str) {
        str.getClass();
        int iHashCode = str.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            return c13.TLS_1_1;
                        }
                        break;
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            return c13.TLS_1_2;
                        }
                        break;
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            return c13.TLS_1_3;
                        }
                        break;
                }
            } else if (str.equals("TLSv1")) {
                return c13.TLS_1_0;
            }
        } else if (str.equals("SSLv3")) {
            return c13.SSL_3_0;
        }
        og.i("Unexpected TLS version: ".concat(str));
        return null;
    }

    public static final Bitmap.Config c(int i) {
        if (i == 0) {
            return Bitmap.Config.ARGB_8888;
        }
        if (i == 1) {
            return Bitmap.Config.ALPHA_8;
        }
        if (i == 2) {
            return Bitmap.Config.RGB_565;
        }
        if (i == 3) {
            return Bitmap.Config.RGBA_F16;
        }
        return i == 4 ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
    }
}
