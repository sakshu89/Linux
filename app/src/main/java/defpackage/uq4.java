package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uq4 {
    public final tq4 a;

    public /* synthetic */ uq4(wj1 wj1Var) {
        this.a = (tq4) wj1Var.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof uq4) && sr4.a(this.a, ((uq4) obj).a) && sr4.a(null, null) && sr4.a(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, null, null});
    }
}
