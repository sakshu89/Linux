package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tp {
    public Object a;
    public wp b;
    public o62 c;
    public boolean d;

    /* JADX WARN: Code duplicated, block: B:10:0x001d  */
    public final boolean a(Object obj) {
        boolean z = true;
        this.d = true;
        wp wpVar = this.b;
        if (wpVar != null) {
            vp vpVar = wpVar.b;
            vpVar.getClass();
            if (obj == null) {
                obj = w1.j;
            }
            if (w1.i.b(vpVar, null, obj)) {
                w1.c(vpVar);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (z) {
            this.a = null;
            this.b = null;
            this.c = null;
        }
        return z;
    }

    public final boolean b(Throwable th) {
        this.d = true;
        wp wpVar = this.b;
        boolean z = wpVar != null && wpVar.b.i(th);
        if (z) {
            this.a = null;
            this.b = null;
            this.c = null;
        }
        return z;
    }

    public final void finalize() {
        o62 o62Var;
        wp wpVar = this.b;
        if (wpVar != null && !wpVar.b.isDone()) {
            wpVar.b(new q1("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.a, 1));
        }
        if (this.d || (o62Var = this.c) == null) {
            return;
        }
        o62Var.j(null);
    }
}
