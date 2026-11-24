package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f54 {
    public final in4 a;
    public final Boolean b;
    public final uq4 c;

    public /* synthetic */ f54(b13 b13Var) {
        this.a = (in4) b13Var.a;
        this.b = (Boolean) b13Var.b;
        this.c = (uq4) b13Var.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f54)) {
            return false;
        }
        f54 f54Var = (f54) obj;
        return sr4.a(this.a, f54Var.a) && sr4.a(null, null) && sr4.a(this.b, f54Var.b) && sr4.a(null, null) && sr4.a(this.c, f54Var.c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, null, this.b, null, this.c});
    }
}
