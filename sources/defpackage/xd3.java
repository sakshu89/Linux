package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xd3 {
    public final se a;
    public final el0 b;

    public /* synthetic */ xd3(se seVar, el0 el0Var) {
        this.a = seVar;
        this.b = el0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof xd3)) {
            return false;
        }
        xd3 xd3Var = (xd3) obj;
        return sr4.a(this.a, xd3Var.a) && sr4.a(this.b, xd3Var.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        q91 q91Var = new q91(14, this);
        q91Var.u(this.a, "key");
        q91Var.u(this.b, "feature");
        return q91Var.toString();
    }
}
