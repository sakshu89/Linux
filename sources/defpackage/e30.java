package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e30 implements as1, h70 {
    public static final su0 b = new su0(11);
    public final x20 a;

    public e30(x20 x20Var) {
        this.a = x20Var;
    }

    @Override // defpackage.j70
    public final /* bridge */ j70 D(i70 i70Var) {
        return pl4.b(this, i70Var);
    }

    @Override // defpackage.as1
    public final List g(Integer num) {
        return this.a.E();
    }

    @Override // defpackage.h70
    public final i70 getKey() {
        return b;
    }

    @Override // defpackage.j70
    public final /* bridge */ j70 r(j70 j70Var) {
        return pl4.c(this, j70Var);
    }

    @Override // defpackage.j70
    public final /* bridge */ h70 v(i70 i70Var) {
        return pl4.a(this, i70Var);
    }

    @Override // defpackage.j70
    public final Object y(vq0 vq0Var, Object obj) {
        return vq0Var.e(obj, this);
    }
}
