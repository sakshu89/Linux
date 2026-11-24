package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ws2 {
    public final zs2 a;
    public b81 b;
    public final vs2 c = new vs2(this, 2);
    public final vs2 d = new vs2(this, 0);
    public final vs2 e = new vs2(this, 1);

    public ws2(zs2 zs2Var) {
        this.a = zs2Var;
    }

    public final b81 a() {
        b81 b81Var = this.b;
        if (b81Var != null) {
            return b81Var;
        }
        og.i("SubcomposeLayoutState is not attached to SubcomposeLayout");
        return null;
    }
}
