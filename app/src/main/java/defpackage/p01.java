package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p01 implements pd {
    public final fg0 a;

    public p01(fg0 fg0Var) {
        this.a = fg0Var;
    }

    @Override // defpackage.pd
    public final s63 a(g33 g33Var) {
        return new vq(this.a.a(g33Var));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof p01) && ((p01) obj).a.equals(this.a);
    }

    public final int hashCode() {
        return Long.hashCode(0L) + ((u52.a.hashCode() + (this.a.hashCode() * 31)) * 31);
    }
}
