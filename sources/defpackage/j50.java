package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j50 extends nu2 implements vq0 {
    public int f;
    public /* synthetic */ Object i;
    public final /* synthetic */ k50 j;
    public final /* synthetic */ i53 k;
    public final /* synthetic */ cn n;
    public final /* synthetic */ long s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j50(k50 k50Var, i53 i53Var, cn cnVar, long j, x50 x50Var) {
        super(2, x50Var);
        this.j = k50Var;
        this.k = i53Var;
        this.n = cnVar;
        this.s = j;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((j50) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        j50 j50Var = new j50(this.j, this.k, this.n, this.s, x50Var);
        j50Var.i = obj;
        return j50Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        k50 k50Var = this.j;
        tm tmVar = k50Var.Z;
        int i = this.f;
        try {
            try {
                if (i == 0) {
                    bz3.g(obj);
                    f41 f41VarC = hp4.c(((s70) this.i).o());
                    k50Var.e0 = true;
                    he2 he2Var = k50Var.H;
                    rm1 rm1Var = rm1.a;
                    i50 i50Var = new i50(this.k, k50Var, this.n, this.s, f41VarC, null);
                    this.f = 1;
                    Object objF = he2Var.f(rm1Var, i50Var, this);
                    t70 t70Var = t70.a;
                    if (objF == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                tmVar.b();
                k50Var.e0 = false;
                tmVar.a(null);
                k50Var.c0 = false;
                return q43.a;
            } catch (CancellationException e) {
                throw e;
            }
        } catch (Throwable th) {
            k50Var.e0 = false;
            tmVar.a(null);
            k50Var.c0 = false;
            throw th;
        }
    }
}
