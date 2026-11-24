package defpackage;

import com.project.sonic.MainActivity;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gg1 implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ gg1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [i51, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r8v3, types: [yl1] */
    /* JADX WARN: Type inference failed for: r9v2, types: [yl1] */
    @Override // defpackage.fq0
    public final Object a() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((MainActivity) obj).p();
            case 1:
                return ((MainActivity) obj).c();
            case 2:
                return ((MainActivity) obj).a();
            case 3:
                return ((MainActivity) obj).p();
            case 4:
                return ((MainActivity) obj).c();
            case 5:
                return ((MainActivity) obj).a();
            case 6:
                return ((MainActivity) obj).p();
            case 7:
                return ((MainActivity) obj).c();
            case 8:
                return ((MainActivity) obj).a();
            default:
                ArrayList arrayList = ((nv1) obj).a;
                gm1 gm1Var = new gm1(arrayList.size());
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    var r4 = (i51) arrayList.get(i2);
                    Object obj2 = r4.b;
                    int i3 = r4.a;
                    Object q41Var = obj2 != null ? new q41(Integer.valueOf(i3), r4.b) : Integer.valueOf(i3);
                    int iF = gm1Var.f(q41Var);
                    boolean z = iF < 0;
                    Object obj3 = z ? null : gm1Var.c[iF];
                    if (obj3 != null) {
                        if (obj3 instanceof yl1) {
                            var r8 = (yl1) obj3;
                            r8.a(r4);
                            r4 = r8;
                        } else {
                            Object[] objArr = yo1.a;
                            var yl1Var = new yl1(2);
                            yl1Var.a(obj3);
                            yl1Var.a(r4);
                            r4 = yl1Var;
                        }
                    }
                    if (z) {
                        int i4 = ~iF;
                        gm1Var.b[i4] = q41Var;
                        gm1Var.c[i4] = r4;
                    } else {
                        gm1Var.c[iF] = r4;
                    }
                }
                return new hl1(gm1Var);
        }
    }
}
