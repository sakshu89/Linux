package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f33 implements fg0 {
    public final int a;
    public final tg0 b;

    public f33(int i, tg0 tg0Var) {
        this.a = i;
        this.b = tg0Var;
    }

    @Override // defpackage.pd
    public final s63 a(g33 g33Var) {
        return new c10(this.a, this.b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f33)) {
            return false;
        }
        f33 f33Var = (f33) obj;
        return f33Var.a == this.a && g31.a(f33Var.b, this.b);
    }

    public final int hashCode() {
        return (this.b.hashCode() + (this.a * 31)) * 31;
    }

    @Override // defpackage.fg0, defpackage.pd
    public final u63 a(g33 g33Var) {
        return new c10(this.a, this.b);
    }
}
