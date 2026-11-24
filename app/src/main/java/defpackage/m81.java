package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class m81 extends ik1 {
    public final p91 a;
    public final tm b;
    public final js1 c;

    public m81(p91 p91Var, tm tmVar, js1 js1Var) {
        this.a = p91Var;
        this.b = tmVar;
        this.c = js1Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        p81 p81Var = new p81();
        p81Var.x = this.a;
        p81Var.H = this.b;
        p81Var.X = this.c;
        return p81Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m81)) {
            return false;
        }
        m81 m81Var = (m81) obj;
        return g31.a(this.a, m81Var.a) && g31.a(this.b, m81Var.b) && this.c == m81Var.c;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        p81 p81Var = (p81) dk1Var;
        p81Var.x = this.a;
        p81Var.H = this.b;
        p81Var.X = this.c;
    }

    public final int hashCode() {
        return this.c.hashCode() + ky0.e((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, false);
    }
}
