package defpackage;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class va0 implements lb1 {
    public final /* synthetic */ int a = 2;
    public final Object b;
    public final Object c;

    public va0(nb1 nb1Var) {
        this.b = nb1Var;
        gy gyVar = gy.c;
        Class<?> cls = nb1Var.getClass();
        ey eyVar = (ey) gyVar.a.get(cls);
        this.c = eyVar == null ? gyVar.a(cls, null) : eyVar;
    }

    @Override // defpackage.lb1
    public final void j(ob1 ob1Var, db1 db1Var) {
        int i = this.a;
        Object obj = this.b;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                ta0 ta0Var = (ta0) obj;
                switch (ua0.a[db1Var.ordinal()]) {
                    case 1:
                        ta0Var.getClass();
                        break;
                    case 2:
                        ta0Var.onStart(ob1Var);
                        break;
                    case 3:
                        ta0Var.onResume(ob1Var);
                        break;
                    case 4:
                        ta0Var.getClass();
                        break;
                    case 5:
                        ta0Var.onStop(ob1Var);
                        break;
                    case 6:
                        ta0Var.getClass();
                        break;
                    case 7:
                        og.i("ON_ANY must not been send by anybody");
                        break;
                    default:
                        dk0.l();
                        break;
                }
                lb1 lb1Var = (lb1) obj2;
                if (lb1Var != null) {
                    lb1Var.j(ob1Var, db1Var);
                }
                break;
            case 1:
                if (db1Var == db1.ON_START) {
                    ((qb1) obj).f(this);
                    ((q91) obj2).G();
                }
                break;
            default:
                HashMap map = ((ey) obj2).a;
                ey.a((List) map.get(db1Var), ob1Var, db1Var, obj);
                ey.a((List) map.get(db1.ON_ANY), ob1Var, db1Var, obj);
                break;
        }
    }

    public va0(ta0 ta0Var, lb1 lb1Var) {
        ta0Var.getClass();
        this.b = ta0Var;
        this.c = lb1Var;
    }

    public va0(q91 q91Var, qb1 qb1Var) {
        this.b = qb1Var;
        this.c = q91Var;
    }
}
