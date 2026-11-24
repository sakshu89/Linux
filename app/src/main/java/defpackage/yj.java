package defpackage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yj extends i41 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater t = AtomicReferenceFieldUpdater.newUpdater(yj.class, Object.class, "_disposer$volatile");
    public static final /* synthetic */ long u = zj.a.objectFieldOffset(yj.class.getDeclaredField("_disposer$volatile"));
    private volatile /* synthetic */ Object _disposer$volatile;
    public final yv k;
    public rd0 n;
    public final /* synthetic */ bk s;

    public yj(bk bkVar, yv yvVar) {
        this.s = bkVar;
        this.k = yvVar;
    }

    @Override // defpackage.i41
    public final boolean q() {
        return false;
    }

    @Override // defpackage.i41
    public final void r(Throwable th) {
        yv yvVar = this.k;
        if (th != null) {
            py0 py0VarJ = yvVar.J(new a10(th, false), null);
            if (py0VarJ != null) {
                yvVar.u(py0VarJ);
                ak akVarS = s();
                if (akVarS != null) {
                    akVarS.a();
                    return;
                }
                return;
            }
            return;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = bk.b;
        bk bkVar = this.s;
        if (atomicIntegerFieldUpdater.decrementAndGet(bkVar) == 0) {
            qb0[] qb0VarArr = bkVar.a;
            ArrayList arrayList = new ArrayList(qb0VarArr.length);
            for (qb0 qb0Var : qb0VarArr) {
                arrayList.add(qb0Var.j());
            }
            yvVar.h(arrayList);
        }
    }

    public final ak s() {
        t.getClass();
        return (ak) zj.a.getObjectVolatile(this, u);
    }

    public final void t(ak akVar) {
        t.getClass();
        zj.a.putObjectVolatile(this, u, akVar);
    }
}
