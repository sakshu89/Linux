package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tm4 {
    public final sm4 a;
    public final Integer b;

    public /* synthetic */ tm4(cu2 cu2Var) {
        this.a = (sm4) cu2Var.b;
        this.b = (Integer) cu2Var.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof tm4)) {
            return false;
        }
        tm4 tm4Var = (tm4) obj;
        return sr4.a(this.a, tm4Var.a) && sr4.a(this.b, tm4Var.b) && sr4.a(null, null) && sr4.a(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, null, null});
    }
}
