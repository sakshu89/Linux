package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class aa3 {
    public final y93 a;
    public final Set b;

    public aa3(y93 y93Var, Set set) {
        y93Var.getClass();
        this.a = y93Var;
        this.b = set;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aa3)) {
            return false;
        }
        aa3 aa3Var = (aa3) obj;
        return g31.a(this.a, aa3Var.a) && this.b.equals(aa3Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Submission(snapshot=" + this.a + ", recipientLabels=" + this.b + ")";
    }
}
