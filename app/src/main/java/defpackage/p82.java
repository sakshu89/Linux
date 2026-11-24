package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p82 extends k71 {
    public static final p82 c = new p82("Undefined intrinsics block and it is required", 0);
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p82(String str, int i) {
        super(str);
        this.b = i;
    }

    @Override // defpackage.oh1
    public final ph1 f(qh1 qh1Var, List list, long j) {
        switch (this.b) {
            case 0:
                int size = list.size();
                ji0 ji0Var = ji0.a;
                if (size == 0) {
                    return qh1Var.j0(q40.j(j), q40.i(j), ji0Var, kt1.u);
                }
                if (size == 1) {
                    zw1 zw1VarE = ((jh1) list.get(0)).e(j);
                    return qh1Var.j0(r40.g(zw1VarE.a, j), r40.f(zw1VarE.b, j), ji0Var, new d7(zw1VarE, 6));
                }
                ArrayList arrayList = new ArrayList(list.size());
                int size2 = list.size();
                int iMax = 0;
                int iMax2 = 0;
                for (int i = 0; i < size2; i++) {
                    zw1 zw1VarE2 = ((jh1) list.get(i)).e(j);
                    iMax = Math.max(zw1VarE2.a, iMax);
                    iMax2 = Math.max(zw1VarE2.b, iMax2);
                    arrayList.add(zw1VarE2);
                }
                return qh1Var.j0(r40.g(iMax, j), r40.f(iMax2, j), ji0Var, new db(2, arrayList));
            default:
                throw new IllegalStateException("Undefined measure and it is required");
        }
    }
}
