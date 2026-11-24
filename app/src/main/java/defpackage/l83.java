package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l83 implements wt {
    public final wt a;
    public final n83 b;
    public final o83 c;
    public final m83 e;

    public l83(wt wtVar, m83 m83Var, zq zqVar) {
        this.a = wtVar;
        this.e = m83Var;
        this.b = new n83(wtVar.l(), zqVar);
        this.c = new o83(wtVar.i());
    }

    @Override // defpackage.n53
    public final void c(o53 o53Var) {
        vc4.b();
        this.e.c(o53Var);
    }

    @Override // defpackage.wt
    public final void d(ArrayList arrayList) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // defpackage.wt
    public final void f(ArrayList arrayList) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // defpackage.wt
    public final boolean g() {
        return false;
    }

    @Override // defpackage.wt
    public final ut i() {
        return this.c;
    }

    @Override // defpackage.n53
    public final void j(o53 o53Var) {
        vc4.b();
        this.e.j(o53Var);
    }

    @Override // defpackage.wt
    public final cp1 k() {
        return this.a.k();
    }

    @Override // defpackage.wt
    public final gt l() {
        return this.b;
    }

    @Override // defpackage.n53
    public final void m(o53 o53Var) {
        vc4.b();
        this.e.m(o53Var);
    }

    @Override // defpackage.n53
    public final void o(o53 o53Var) {
        vc4.b();
        this.e.o(o53Var);
    }
}
