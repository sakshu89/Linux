package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xs1 {
    public final OutputConfiguration a;
    public String b;
    public long c = 1;

    public xs1(OutputConfiguration outputConfiguration) {
        this.a = outputConfiguration;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof xs1)) {
            return false;
        }
        xs1 xs1Var = (xs1) obj;
        return this.a.equals(xs1Var.a) && this.c == xs1Var.c && Objects.equals(this.b, xs1Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 31;
        int i = (iHashCode << 5) - iHashCode;
        String str = this.b;
        int iHashCode2 = (str == null ? 0 : str.hashCode()) ^ i;
        return Long.hashCode(this.c) ^ ((iHashCode2 << 5) - iHashCode2);
    }
}
