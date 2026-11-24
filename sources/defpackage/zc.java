package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zc extends nu2 implements hq0 {
    public qd f;
    public o42 i;
    public int j;
    public final /* synthetic */ bd k;
    public final /* synthetic */ Object n;
    public final /* synthetic */ wv2 s;
    public final /* synthetic */ long t;
    public final /* synthetic */ hq0 u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zc(bd bdVar, Object obj, wv2 wv2Var, long j, hq0 hq0Var, x50 x50Var) {
        super(1, x50Var);
        this.k = bdVar;
        this.n = obj;
        this.s = wv2Var;
        this.t = j;
        this.u = hq0Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        long j = this.t;
        hq0 hq0Var = this.u;
        return new zc(this.k, this.n, this.s, j, hq0Var, (x50) obj).s(q43.a);
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        bd bdVar;
        qd qdVar;
        o42 o42Var;
        CancellationException cancellationException;
        wv2 wv2Var = this.s;
        int i = this.j;
        bd bdVar2 = this.k;
        if (i == 0) {
            bz3.g(obj);
            try {
                bdVar2.c.c = (vd) bdVar2.a.a.j(this.n);
                bdVar2.e.setValue(wv2Var.c);
                bdVar2.d.setValue(Boolean.TRUE);
                qd qdVar2 = bdVar2.c;
                qd qdVar3 = new qd(qdVar2.a, qdVar2.b.getValue(), v53.a(qdVar2.c), qdVar2.e, Long.MIN_VALUE, qdVar2.i);
                o42 o42Var2 = new o42();
                long j = this.t;
                g2 g2Var = new g2(bdVar2, qdVar3, this.u, o42Var2, 1);
                bdVar = bdVar2;
                try {
                    this.f = qdVar3;
                    this.i = o42Var2;
                    this.j = 1;
                    Object objA = ya4.a(qdVar3, wv2Var, j, g2Var, this);
                    t70 t70Var = t70.a;
                    if (objA == t70Var) {
                        return t70Var;
                    }
                    qdVar = qdVar3;
                    o42Var = o42Var2;
                } catch (CancellationException e) {
                    e = e;
                    cancellationException = e;
                    bd.b(bdVar);
                    throw cancellationException;
                }
            } catch (CancellationException e2) {
                e = e2;
                bdVar = bdVar2;
                cancellationException = e;
                bd.b(bdVar);
                throw cancellationException;
            }
        } else {
            if (i != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            o42Var = this.i;
            qdVar = this.f;
            try {
                bz3.g(obj);
                bdVar = bdVar2;
            } catch (CancellationException e3) {
                cancellationException = e3;
                bdVar = bdVar2;
                bd.b(bdVar);
                throw cancellationException;
            }
        }
        nd ndVar = o42Var.a ? nd.a : nd.b;
        bd.b(bdVar);
        return new l11(3, qdVar, ndVar);
    }
}
