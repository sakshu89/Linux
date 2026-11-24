package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ow extends es {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ow(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.es
    public void b(int i, ls lsVar) {
        switch (this.a) {
            case 1:
                fj1 fj1Var = (fj1) this.b;
                synchronized (fj1Var.a) {
                    try {
                        if (fj1Var.f) {
                            return;
                        }
                        fj1Var.n.put(lsVar.d(), new ms(lsVar));
                        fj1Var.i();
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            case 2:
                Iterator it = ((m83) this.b).a.iterator();
                while (it.hasNext()) {
                    kh2 kh2Var = ((o53) it.next()).m;
                    Iterator it2 = kh2Var.g.e.iterator();
                    while (it2.hasNext()) {
                        ((es) it2.next()).b(i, new kb0(lsVar, kh2Var.g.g, -1L));
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // defpackage.es
    public void d(int i) {
        switch (this.a) {
            case 0:
                xg4.c().execute(new s7(12, this));
                break;
        }
    }
}
