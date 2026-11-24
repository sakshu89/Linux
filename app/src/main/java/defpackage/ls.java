package defpackage;

import android.hardware.camera2.CaptureResult;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface ls {
    default void a(bk0 bk0Var) {
        int i;
        String str;
        ArrayList arrayList = bk0Var.a;
        int iM = m();
        if (iM == 1) {
            return;
        }
        int iX = cq.x(iM);
        if (iX == 1) {
            i = 32;
        } else if (iX == 2) {
            i = 0;
        } else {
            if (iX != 3) {
                if (iM == 1) {
                    str = "UNKNOWN";
                } else if (iM == 2) {
                    str = "NONE";
                } else if (iM != 3) {
                    str = iM != 4 ? "null" : "FIRED";
                } else {
                    str = "READY";
                }
                xq4.d("ExifData", "Unknown flash state: ".concat(str));
                return;
            }
            i = 1;
        }
        if ((i & 1) == 1) {
            bk0Var.c("LightSource", String.valueOf(4), arrayList);
        }
        bk0Var.c("Flash", String.valueOf(i), arrayList);
    }

    iv2 b();

    long d();

    hs j();

    js k();

    int m();

    default CaptureResult n() {
        return null;
    }

    is o();
}
