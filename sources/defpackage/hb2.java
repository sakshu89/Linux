package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class hb2 extends b1 implements u70 {
    public final x50 i;

    public hb2(x50 x50Var, j70 j70Var) {
        super(j70Var, true);
        this.i = x50Var;
    }

    @Override // defpackage.p41
    public final boolean a0() {
        return true;
    }

    @Override // defpackage.u70
    public final u70 d() {
        x50 x50Var = this.i;
        if (x50Var instanceof u70) {
            return (u70) x50Var;
        }
        return null;
    }

    @Override // defpackage.p41
    public void t(Object obj) {
        ry3.b(fp4.b(this.i), wi4.a(obj));
    }

    @Override // defpackage.p41
    public void z(Object obj) {
        this.i.h(wi4.a(obj));
    }

    public void v0() {
    }
}
