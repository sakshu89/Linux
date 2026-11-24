package defpackage;

import android.hardware.camera2.CameraDevice;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class lg4 {
    public static CameraDevice.StateCallback a(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return new nt();
        }
        return arrayList.size() == 1 ? (CameraDevice.StateCallback) arrayList.get(0) : new mt(arrayList);
    }

    public static ge b(ByteBuffer byteBuffer, er3 er3Var) {
        int i;
        byte[] bArrArray = byteBuffer.array();
        int i2 = er3Var.e;
        int i3 = 1;
        if (i2 != 1) {
            if (i2 == 2) {
                i = 3;
            } else if (i2 == 3) {
                i = 2;
            }
            return new ge(bArrArray, 1000 * er3Var.f, new ul3(er3Var.b, er3Var.c), i);
        }
        i3 = 4;
        i = i3;
        return new ge(bArrArray, 1000 * er3Var.f, new ul3(er3Var.b, er3Var.c), i);
    }
}
