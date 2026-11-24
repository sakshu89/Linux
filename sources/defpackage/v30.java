package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v30 extends un {
    public final nn H;

    public v30(int i, nn nnVar) {
        super(i);
        this.H = nnVar;
        if (nnVar == nn.a) {
            dk0.s("This implementation does not support suspension for senders, use ", u42.a(un.class).b(), " instead");
            throw null;
        }
        if (i >= 1) {
            return;
        }
        og.g(cq.h("Buffered channel capacity must be at least 1, but ", i, " was specified"));
        throw null;
    }

    @Override // defpackage.un
    public final boolean E() {
        return this.H == nn.b;
    }

    public final Object U(Object obj, boolean z) {
        if (this.H != nn.c) {
            return Q(obj);
        }
        Object objS = super.s(obj);
        return (!(objS instanceof lx) || (objS instanceof kx)) ? objS : q43.a;
    }

    @Override // defpackage.un, defpackage.vg2
    public final Object a(x50 x50Var, Object obj) throws Throwable {
        if (U(obj, true) instanceof kx) {
            throw v();
        }
        return q43.a;
    }

    @Override // defpackage.un, defpackage.vg2
    public final Object s(Object obj) {
        return U(obj, false);
    }
}
