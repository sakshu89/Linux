package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class eb implements oh1 {
    public static final eb b = new eb(0);
    public static final eb c = new eb(1);
    public static final eb d = new eb(2);
    public static final j e = new j(7);
    public static final eb f = new eb(3);
    public static final eb g = new eb(4);
    public final /* synthetic */ int a;

    public /* synthetic */ eb(int i) {
        this.a = i;
    }

    @Override // defpackage.oh1
    public final ph1 f(qh1 qh1Var, List list, long j) {
        int i = this.a;
        ji0 ji0Var = ji0.a;
        switch (i) {
            case 0:
                int size = list.size();
                if (size == 0) {
                    return qh1Var.j0(0, 0, ji0Var, j7.s);
                }
                if (size == 1) {
                    zw1 zw1VarE = ((jh1) list.get(0)).e(j);
                    return qh1Var.j0(zw1VarE.a, zw1VarE.b, ji0Var, new d7(zw1VarE, 1));
                }
                ArrayList arrayList = new ArrayList(list.size());
                int size2 = list.size();
                int iMax = 0;
                int iMax2 = 0;
                for (int i2 = 0; i2 < size2; i2++) {
                    zw1 zw1VarE2 = ((jh1) list.get(i2)).e(j);
                    iMax = Math.max(iMax, zw1VarE2.a);
                    iMax2 = Math.max(iMax2, zw1VarE2.b);
                    arrayList.add(zw1VarE2);
                }
                return qh1Var.j0(iMax, iMax2, ji0Var, new db(0, arrayList));
            case 1:
                return qh1Var.j0(q40.j(j), q40.i(j), ji0Var, new j(7));
            case 2:
                return qh1Var.j0(q40.h(j), q40.g(j), ji0Var, e);
            case 3:
                ArrayList arrayList2 = new ArrayList(list.size());
                int size3 = list.size();
                int iMax3 = 0;
                int iMax4 = 0;
                for (int i3 = 0; i3 < size3; i3++) {
                    zw1 zw1VarE3 = ((jh1) list.get(i3)).e(j);
                    iMax3 = Math.max(iMax3, zw1VarE3.a);
                    iMax4 = Math.max(iMax4, zw1VarE3.b);
                    arrayList2.add(zw1VarE3);
                }
                return qh1Var.j0(iMax3, iMax4, ji0Var, new x0(29, arrayList2));
            default:
                return qh1Var.j0(q40.f(j) ? q40.h(j) : 0, q40.e(j) ? q40.g(j) : 0, ji0Var, new j(7));
        }
    }
}
