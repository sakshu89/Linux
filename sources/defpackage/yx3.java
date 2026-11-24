package defpackage;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yx3 {
    public transient cx3 a;
    public transient gx3 b;

    public final Map a() {
        gx3 gx3Var = this.b;
        if (gx3Var != null) {
            return gx3Var;
        }
        by3 by3Var = (by3) this;
        gx3 gx3Var2 = new gx3(by3Var, by3Var.c);
        this.b = gx3Var2;
        return gx3Var2;
    }

    public final Set b() {
        cx3 cx3Var = this.a;
        if (cx3Var != null) {
            return cx3Var;
        }
        by3 by3Var = (by3) this;
        cx3 cx3Var2 = new cx3(by3Var, by3Var.c);
        this.a = cx3Var2;
        return cx3Var2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof yx3) {
            return a().equals(((yx3) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return ((gx3) a()).c.hashCode();
    }

    public final String toString() {
        return ((gx3) a()).c.toString();
    }
}
