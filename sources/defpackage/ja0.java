package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ja0 extends nu2 implements vq0 {
    public q42 f;
    public qd i;
    public int j;
    public final /* synthetic */ float k;
    public final /* synthetic */ ka0 n;
    public final /* synthetic */ z91 s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ja0(float f, ka0 ka0Var, z91 z91Var, x50 x50Var) {
        super(2, x50Var);
        this.k = f;
        this.n = ka0Var;
        this.s = z91Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((ja0) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new ja0(this.k, this.n, this.s, x50Var);
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        float f;
        qd qdVar;
        q42 q42Var;
        qd qdVar2;
        int i = this.j;
        if (i == 0) {
            bz3.g(obj);
            f = this.k;
            if (Math.abs(f) > 1.0f) {
                q42 q42Var2 = new q42();
                q42Var2.a = f;
                q42 q42Var3 = new q42();
                qd qdVarA = ke4.a(f, 28);
                try {
                    ka0 ka0Var = this.n;
                    da0 da0Var = ka0Var.a;
                    g2 g2Var = new g2(q42Var3, this.s, q42Var2, ka0Var, 3);
                    this.f = q42Var2;
                    this.i = qdVarA;
                    this.j = 1;
                    qdVar = qdVarA;
                    try {
                        Object objA = ya4.a(qdVar, new ca0(da0Var, eb4.a, qdVarA.b.getValue(), qdVarA.c), Long.MIN_VALUE, g2Var, this);
                        Object obj2 = t70.a;
                        if (objA != obj2) {
                            objA = q43.a;
                        }
                        if (objA == obj2) {
                            return obj2;
                        }
                        q42Var = q42Var2;
                        f = q42Var.a;
                    } catch (CancellationException unused) {
                        q42Var = q42Var2;
                        qdVar2 = qdVar;
                        q42Var.a = ((Number) qdVar2.a.b.j(qdVar2.c)).floatValue();
                    }
                } catch (CancellationException unused2) {
                    qdVar = qdVarA;
                }
            }
        } else {
            if (i != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            qdVar2 = this.i;
            q42Var = this.f;
            try {
                bz3.g(obj);
            } catch (CancellationException unused3) {
                q42Var.a = ((Number) qdVar2.a.b.j(qdVar2.c)).floatValue();
            }
            f = q42Var.a;
        }
        return new Float(f);
    }
}
