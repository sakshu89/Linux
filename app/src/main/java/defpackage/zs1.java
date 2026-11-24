package defpackage;

import android.hardware.camera2.params.OutputConfiguration;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zs1 {
    public final OutputConfiguration a;
    public long b = 1;

    public zs1(OutputConfiguration outputConfiguration) {
        this.a = outputConfiguration;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zs1)) {
            return false;
        }
        zs1 zs1Var = (zs1) obj;
        return this.a.equals(zs1Var.a) && this.b == zs1Var.b;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 31;
        return Long.hashCode(this.b) ^ ((iHashCode << 5) - iHashCode);
    }
}
