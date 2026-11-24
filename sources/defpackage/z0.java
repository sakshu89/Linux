package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends k61 implements vq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z0(int i, Object obj) {
        super(2);
        this.b = i;
        this.c = obj;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.b;
        q43 q43Var = q43.a;
        Object obj3 = this.c;
        switch (i) {
            case 0:
                x20 x20Var = (x20) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    ((a1) obj3).a(x20Var, 0);
                } else {
                    x20Var.R();
                }
                return q43Var;
            case 1:
                ((Number) obj2).intValue();
                ((p20) obj3).a((x20) obj, ny3.c(1));
                return q43Var;
            case 2:
                ek1 ek1Var = (ek1) obj;
                ek1 ek1VarB = (ck1) obj2;
                x20 x20Var2 = (x20) obj3;
                if (ek1VarB instanceof q20) {
                    wq0 wq0Var = ((q20) ek1VarB).a;
                    h33.c(3, wq0Var);
                    ek1VarB = gj4.b(x20Var2, (ek1) wq0Var.c(bk1.a, x20Var2, 0));
                }
                return ek1Var.c(ek1VarB);
            case 3:
                x20 x20Var3 = (x20) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                if (x20Var3.O(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    List list = (List) obj3;
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        vq0 vq0Var = (vq0) list.get(i2);
                        int iHashCode = Long.hashCode(x20Var3.T);
                        o20.p.getClass();
                        f8 f8Var = n20.c;
                        x20Var3.Z();
                        if (x20Var3.S) {
                            x20Var3.k(f8Var);
                        } else {
                            x20Var3.j0();
                        }
                        ie4.a(x20Var3, Integer.valueOf(iHashCode), n20.g);
                        vq0Var.e(x20Var3, 0);
                        x20Var3.p(true);
                    }
                } else {
                    x20Var3.R();
                }
                return q43Var;
            default:
                ((Number) obj2).intValue();
                ((yy1) obj3).a((x20) obj, ny3.c(1));
                return q43Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z0(a1 a1Var, int i, int i2) {
        super(2);
        this.b = i2;
        this.c = a1Var;
    }
}
