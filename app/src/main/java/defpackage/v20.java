package defpackage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v20 extends a30 {
    public final long a;
    public final boolean b;
    public final boolean c;
    public HashSet d;
    public final LinkedHashSet e = new LinkedHashSet();
    public final ku1 f = new ku1(gw1.e, ak1.i);
    public final /* synthetic */ x20 g;

    public v20(x20 x20Var, long j, boolean z, boolean z2, q82 q82Var) {
        this.g = x20Var;
        this.a = j;
        this.b = z;
        this.c = z2;
    }

    @Override // defpackage.a30
    public final void a(g30 g30Var, vq0 vq0Var) {
        this.g.b.a(g30Var, vq0Var);
    }

    @Override // defpackage.a30
    public final hm1 b(g30 g30Var, mk2 mk2Var, vq0 vq0Var) {
        return this.g.b.b(g30Var, mk2Var, vq0Var);
    }

    @Override // defpackage.a30
    public final void c() {
        this.g.A--;
    }

    @Override // defpackage.a30
    public final boolean d() {
        return this.g.b.d();
    }

    @Override // defpackage.a30
    public final boolean e() {
        return this.b;
    }

    @Override // defpackage.a30
    public final boolean f() {
        return this.c;
    }

    @Override // defpackage.a30
    public final long g() {
        return this.a;
    }

    @Override // defpackage.a30
    public final z20 h() {
        return this.g.h;
    }

    @Override // defpackage.a30
    public final gw1 i() {
        return (gw1) this.f.getValue();
    }

    @Override // defpackage.a30
    public final j70 j() {
        return this.g.b.j();
    }

    @Override // defpackage.a30
    public final boolean k() {
        return this.g.b.k();
    }

    @Override // defpackage.a30
    public final void l(g30 g30Var) {
        x20 x20Var = this.g;
        x20Var.b.l(x20Var.h);
        x20Var.b.l(g30Var);
    }

    @Override // defpackage.a30
    public final al1 m(bl1 bl1Var) {
        return this.g.b.m(bl1Var);
    }

    @Override // defpackage.a30
    public final hm1 n(g30 g30Var, mk2 mk2Var, hm1 hm1Var) {
        return this.g.b.n(g30Var, mk2Var, hm1Var);
    }

    @Override // defpackage.a30
    public final void o(Set set) {
        HashSet hashSet = this.d;
        if (hashSet == null) {
            hashSet = new HashSet();
            this.d = hashSet;
        }
        hashSet.add(set);
    }

    @Override // defpackage.a30
    public final void p(x20 x20Var) {
        this.e.add(x20Var);
    }

    @Override // defpackage.a30
    public final void q(a42 a42Var) {
        this.g.b.q(a42Var);
    }

    @Override // defpackage.a30
    public final void r(g30 g30Var) {
        this.g.b.r(g30Var);
    }

    @Override // defpackage.a30
    public final zv s(ta taVar) {
        return this.g.b.s(taVar);
    }

    @Override // defpackage.a30
    public final void t() {
        this.g.A++;
    }

    @Override // defpackage.a30
    public final void u(x20 x20Var) {
        HashSet<Set> hashSet = this.d;
        if (hashSet != null) {
            for (Set set : hashSet) {
                x20Var.getClass();
                set.remove(x20Var.w());
            }
        }
        LinkedHashSet linkedHashSet = this.e;
        if ((linkedHashSet instanceof x41) && !(linkedHashSet instanceof y41)) {
            h33.f(linkedHashSet, "kotlin.collections.MutableCollection");
            throw null;
        }
        linkedHashSet.remove(x20Var);
    }

    @Override // defpackage.a30
    public final void v(g30 g30Var) {
        this.g.b.v(g30Var);
    }

    public final void w() {
        LinkedHashSet<x20> linkedHashSet = this.e;
        if (linkedHashSet.isEmpty()) {
            return;
        }
        HashSet hashSet = this.d;
        if (hashSet != null) {
            for (x20 x20Var : linkedHashSet) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((Set) it.next()).remove(x20Var.w());
                }
            }
        }
        linkedHashSet.clear();
    }
}
