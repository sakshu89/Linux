package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n00 extends nu2 implements vq0 {
    public int f;
    public final /* synthetic */ mm0[] i;
    public final /* synthetic */ int j;
    public final /* synthetic */ AtomicInteger k;
    public final /* synthetic */ un n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n00(mm0[] mm0VarArr, int i, AtomicInteger atomicInteger, un unVar, x50 x50Var) {
        super(2, x50Var);
        this.i = mm0VarArr;
        this.j = i;
        this.k = atomicInteger;
        this.n = unVar;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((n00) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new n00(this.i, this.j, this.k, this.n, x50Var);
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        AtomicInteger atomicInteger = this.k;
        un unVar = this.n;
        try {
            if (i == 0) {
                bz3.g(obj);
                mm0[] mm0VarArr = this.i;
                int i2 = this.j;
                mm0 mm0Var = mm0VarArr[i2];
                m00 m00Var = new m00(unVar, i2);
                this.f = 1;
                Object objA = mm0Var.a(m00Var, this);
                t70 t70Var = t70.a;
                if (objA == t70Var) {
                    return t70Var;
                }
            } else {
                if (i != 1) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
            }
            if (atomicInteger.decrementAndGet() == 0) {
                unVar.b(null);
            }
            return q43.a;
        } catch (Throwable th) {
            if (atomicInteger.decrementAndGet() == 0) {
                unVar.b(null);
            }
            throw th;
        }
    }
}
