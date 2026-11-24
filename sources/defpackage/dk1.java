package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dk1 implements xb0 {
    public w50 b;
    public int c;
    public dk1 f;
    public dk1 i;
    public fp1 j;
    public co1 k;
    public boolean n;
    public boolean s;
    public boolean t;
    public boolean u;
    public h7 v;
    public boolean w;
    public dk1 a = this;
    public int e = -1;

    public void D0() {
        if (!this.w) {
            z01.b("reset() called on an unattached node");
        }
        C0();
    }

    public void E0() {
        if (!this.w) {
            z01.b("Must run markAsAttached() prior to runAttachLifecycle");
        }
        if (!this.t) {
            z01.b("Must run runAttachLifecycle() only once after markAsAttached()");
        }
        this.t = false;
        A0();
        this.u = true;
    }

    public void F0() {
        if (!this.w) {
            z01.b("node detached multiple times");
        }
        if (this.k == null) {
            z01.b("detach invoked on a node without a coordinator");
        }
        if (!this.u) {
            z01.b("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
        }
        this.u = false;
        h7 h7Var = this.v;
        if (h7Var != null) {
            h7Var.a();
        }
        B0();
    }

    public void G0(dk1 dk1Var) {
        this.a = dk1Var;
    }

    public void H0(co1 co1Var) {
        this.k = co1Var;
    }

    public final s70 w0() {
        w50 w50Var = this.b;
        if (w50Var != null) {
            return w50Var;
        }
        w50 w50VarA = tl4.a(((r7) cm4.h(this)).getCoroutineContext().r(new h41((f41) ((r7) cm4.h(this)).getCoroutineContext().v(nr4.k))));
        this.b = w50VarA;
        return w50VarA;
    }

    public boolean x0() {
        return !(this instanceof nk);
    }

    public void y0() {
        if (this.w) {
            z01.b("node attached multiple times");
        }
        if (this.k == null) {
            z01.b("attach invoked on a node without a coordinator");
        }
        this.w = true;
        this.t = true;
    }

    public void z0() {
        if (!this.w) {
            z01.b("Cannot detach a node that is not attached");
        }
        if (this.t) {
            z01.b("Must run runAttachLifecycle() before markAsDetached()");
        }
        if (this.u) {
            z01.b("Must run runDetachLifecycle() before markAsDetached()");
        }
        this.w = false;
        w50 w50Var = this.b;
        if (w50Var != null) {
            tl4.b(w50Var, new hk1("The Modifier.Node was detached", 2));
            this.b = null;
        }
    }

    public void A0() {
    }

    public void B0() {
    }

    public void C0() {
    }
}
