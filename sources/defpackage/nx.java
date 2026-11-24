package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nx extends af2 {
    public final un j;
    public final /* synthetic */ AtomicReferenceArray k;

    public nx(long j, nx nxVar, un unVar, int i) {
        super(j, nxVar, i);
        this.j = unVar;
        this.k = new AtomicReferenceArray(wn.b * 2);
    }

    @Override // defpackage.af2
    public final int l() {
        return wn.b;
    }

    @Override // defpackage.af2
    public final void m(int i, j70 j70Var) {
        un unVar;
        int i2 = wn.b;
        boolean z = i >= i2;
        if (z) {
            i -= i2;
        }
        this.k.get(i * 2);
        while (true) {
            Object objQ = q(i);
            boolean z2 = objQ instanceof j93;
            unVar = this.j;
            if (z2 || (objQ instanceof k93)) {
                if (p(i, objQ, z ? wn.j : wn.k)) {
                    s(i, null);
                    r(i, !z);
                    if (z) {
                        unVar.getClass();
                        return;
                    }
                    return;
                }
            } else {
                if (objQ == wn.j || objQ == wn.k) {
                    break;
                }
                if (objQ != wn.g && objQ != wn.f) {
                    if (objQ == wn.i || objQ == wn.d || objQ == wn.l) {
                        return;
                    }
                    og.h(objQ, "unexpected state: ");
                    return;
                }
            }
        }
        s(i, null);
        if (z) {
            unVar.getClass();
        }
    }

    public final boolean p(int i, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i2 = (i * 2) + 1;
        do {
            atomicReferenceArray = this.k;
            if (atomicReferenceArray.compareAndSet(i2, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i2) == obj);
        return false;
    }

    public final Object q(int i) {
        return this.k.get((i * 2) + 1);
    }

    public final void r(int i, boolean z) {
        if (z) {
            un unVar = this.j;
            unVar.getClass();
            unVar.T((this.f * ((long) wn.b)) + ((long) i));
        }
        n();
    }

    public final void s(int i, Object obj) {
        this.k.set(i * 2, obj);
    }

    public final void t(int i, Object obj) {
        this.k.set((i * 2) + 1, obj);
    }
}
