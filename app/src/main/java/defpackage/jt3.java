package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jt3 {
    protected int zba;

    public abstract int a(ev3 ev3Var);

    public final byte[] b() {
        try {
            gu3 gu3Var = (gu3) this;
            int iJ = gu3Var.j();
            byte[] bArr = new byte[iJ];
            st3 st3Var = new st3(bArr, iJ);
            gu3Var.h(st3Var);
            if (iJ - st3Var.d == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(cq.v("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }
}
