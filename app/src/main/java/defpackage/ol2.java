package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ol2 implements c30, Iterable, x41 {
    public int b;
    public int e;
    public int f;
    public boolean j;
    public int k;
    public HashMap s;
    public ml1 t;
    public int[] a = new int[0];
    public Object[] c = new Object[0];
    public final Object i = new Object();
    public ArrayList n = new ArrayList();

    public final int a(j6 j6Var) {
        if (this.j) {
            y20.a("Use active SlotWriter to determine anchor location instead");
        }
        if (!j6Var.a()) {
            dz1.a("Anchor refers to a group that was removed");
        }
        return j6Var.a;
    }

    public final void b() {
        this.s = new HashMap();
    }

    public final nl2 d() {
        if (this.j) {
            og.n("Cannot read while a writer is pending");
            return null;
        }
        this.f++;
        return new nl2(this);
    }

    public final rl2 f() {
        if (this.j) {
            y20.a("Cannot start a writer when another writer is pending");
        }
        if (this.f > 0) {
            y20.a("Cannot start a writer when a reader is pending");
        }
        this.j = true;
        this.k++;
        return new rl2(this);
    }

    public final boolean g(j6 j6Var) {
        int iD;
        return j6Var.a() && (iD = ql2.d(this.n, j6Var.a, this.b)) >= 0 && g31.a(this.n.get(iD), j6Var);
    }

    public final nv0 h(int i) {
        int i2;
        ArrayList arrayList;
        int iD;
        HashMap map = this.s;
        if (map != null) {
            if (this.j) {
                y20.a("use active SlotWriter to crate an anchor for location instead");
            }
            j6 j6Var = (i < 0 || i >= (i2 = this.b) || (iD = ql2.d((arrayList = this.n), i, i2)) < 0) ? null : (j6) arrayList.get(iD);
            if (j6Var != null) {
                return (nv0) map.get(j6Var);
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new mv0(this, 0, this.b);
    }
}
