package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xr2 implements ih2 {
    public final /* synthetic */ yr2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ r53 d;
    public final /* synthetic */ fj e;
    public final /* synthetic */ fj f;

    public /* synthetic */ xr2(yr2 yr2Var, String str, String str2, r53 r53Var, fj fjVar, fj fjVar2) {
        this.a = yr2Var;
        this.b = str;
        this.c = str2;
        this.d = r53Var;
        this.e = fjVar;
        this.f = fjVar2;
    }

    @Override // defpackage.ih2
    public final void a(kh2 kh2Var) {
        yr2 yr2Var = this.a;
        if (yr2Var.b() == null) {
            return;
        }
        yr2Var.A();
        yr2Var.z(yr2Var.B(this.b, this.c, this.d, this.e, this.f));
        yr2Var.n();
        m83 m83Var = yr2Var.p;
        m83Var.getClass();
        vc4.b();
        Iterator it = m83Var.a.iterator();
        while (it.hasNext()) {
            m83Var.c((o53) it.next());
        }
    }
}
