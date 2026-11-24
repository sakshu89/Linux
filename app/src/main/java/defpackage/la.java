package defpackage;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class la implements xq0 {
    public final /* synthetic */ ma a;

    public /* synthetic */ la(ma maVar) {
        this.a = maVar;
    }

    @Override // defpackage.xq0
    public final Object o(Object obj, Object obj2, Object obj3, Object obj4) {
        ma maVar = this.a;
        t33 t33VarB = ((ro0) maVar.f).b((ev2) obj, (np0) obj2, ((lp0) obj3).a, ((mp0) obj4).a);
        if (t33VarB instanceof t33) {
            Object obj5 = t33VarB.a;
            obj5.getClass();
            return (Typeface) obj5;
        }
        b13 b13Var = new b13(t33VarB, maVar.s);
        maVar.s = b13Var;
        Object obj6 = b13Var.c;
        obj6.getClass();
        return (Typeface) obj6;
    }
}
