package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x92 implements j52 {
    public qa2 a;
    public ba2 b;
    public String c;
    public Object e;
    public Object[] f;
    public kf i;
    public final kb j = new kb(14, this);

    public x92(qa2 qa2Var, ba2 ba2Var, String str, Object obj, Object[] objArr) {
        this.a = qa2Var;
        this.b = ba2Var;
        this.c = str;
        this.e = obj;
        this.f = objArr;
    }

    @Override // defpackage.j52
    public final void a() {
        c();
    }

    @Override // defpackage.j52
    public final void b() {
        kf kfVar = this.i;
        if (kfVar != null) {
            kfVar.I();
        }
    }

    public final void c() {
        String strA;
        ba2 ba2Var = this.b;
        if (this.i != null) {
            dk0.s("entry(", this.i, ") is not null");
            return;
        }
        if (ba2Var != null) {
            kb kbVar = this.j;
            Object objA = kbVar.a();
            if (objA == null || ba2Var.c(objA)) {
                this.i = ba2Var.a(this.c, kbVar);
                return;
            }
            if (objA instanceof mm2) {
                mm2 mm2Var = (mm2) objA;
                if (mm2Var.c() == el1.f || mm2Var.c() == su0.k || mm2Var.c() == ak1.i) {
                    strA = "MutableState containing " + mm2Var.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
                } else {
                    strA = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
                }
            } else {
                strA = yy3.a(objA);
            }
            throw new IllegalArgumentException(strA);
        }
    }

    @Override // defpackage.j52
    public final void d() {
        kf kfVar = this.i;
        if (kfVar != null) {
            kfVar.I();
        }
    }
}
