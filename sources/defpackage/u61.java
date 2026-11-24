package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u61 implements j52, m70 {
    public final j70 a;
    public final vq0 b;
    public final w50 c;
    public yq2 e;

    public u61(j70 j70Var, vq0 vq0Var) {
        this.a = j70Var;
        this.b = vq0Var;
        this.c = tl4.a(j70Var.r(this));
    }

    @Override // defpackage.j70
    public final j70 D(i70 i70Var) {
        return pl4.b(this, i70Var);
    }

    @Override // defpackage.j52
    public final void a() throws IllegalAccessException, InvocationTargetException {
        yq2 yq2Var = this.e;
        if (yq2Var != null) {
            CancellationException cancellationException = new CancellationException("Old job was still running!");
            cancellationException.initCause(null);
            yq2Var.e(cancellationException);
        }
        this.e = uf4.b(this.c, null, this.b, 3);
    }

    @Override // defpackage.j52
    public final void b() throws IllegalAccessException, InvocationTargetException {
        yq2 yq2Var = this.e;
        if (yq2Var != null) {
            yq2Var.B(new tp0(1));
        }
        this.e = null;
    }

    @Override // defpackage.j52
    public final void d() throws IllegalAccessException, InvocationTargetException {
        yq2 yq2Var = this.e;
        if (yq2Var != null) {
            yq2Var.B(new tp0(1));
        }
        this.e = null;
    }

    @Override // defpackage.h70
    public final i70 getKey() {
        return ak1.c;
    }

    @Override // defpackage.j70
    public final j70 r(j70 j70Var) {
        return pl4.c(this, j70Var);
    }

    @Override // defpackage.j70
    public final h70 v(i70 i70Var) {
        return pl4.a(this, i70Var);
    }

    @Override // defpackage.m70
    public final void w(j70 j70Var, Throwable th) throws Throwable {
        e30 e30Var = (e30) j70Var.v(e30.b);
        if (e30Var != null) {
            ej4.b(th, new zb(4, e30Var, this));
        }
        m70 m70Var = (m70) this.a.v(ak1.c);
        if (m70Var == null) {
            throw th;
        }
        m70Var.w(j70Var, th);
    }

    @Override // defpackage.j70
    public final Object y(vq0 vq0Var, Object obj) {
        return vq0Var.e(obj, this);
    }
}
