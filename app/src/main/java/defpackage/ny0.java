package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ny0 implements ih2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ny0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.ih2
    public final void a(kh2 kh2Var) {
        int i = this.a;
        int i2 = 0;
        Object obj = this.b;
        switch (i) {
            case 0:
                ry0 ry0Var = (ry0) obj;
                if (ry0Var.b() == null) {
                    return;
                }
                lv2 lv2Var = ry0Var.w;
                lv2Var.getClass();
                vc4.b();
                lv2Var.i = true;
                j62 j62Var = lv2Var.e;
                if (j62Var != null) {
                    vc4.b();
                    if (!j62Var.d.b.isDone()) {
                        ty0 ty0Var = new ty0("The request is aborted silently and retried.", null);
                        vc4.b();
                        j62Var.g = true;
                        xw xwVar = j62Var.i;
                        Objects.requireNonNull(xwVar);
                        xwVar.cancel(true);
                        j62Var.e.b(ty0Var);
                        j62Var.f.a(null);
                        j62Var.b.d(j62Var.a);
                    }
                }
                ry0Var.A(true);
                String strD = ry0Var.d();
                sy0 sy0Var = (sy0) ry0Var.f;
                fj fjVar = ry0Var.g;
                fjVar.getClass();
                gh2 gh2VarB = ry0Var.B(strD, sy0Var, fjVar);
                ry0Var.u = gh2VarB;
                Object[] objArr = {gh2VarB.c()};
                ArrayList arrayList = new ArrayList(1);
                Object obj2 = objArr[0];
                Objects.requireNonNull(obj2);
                arrayList.add(obj2);
                ry0Var.z(Collections.unmodifiableList(arrayList));
                ry0Var.n();
                lv2 lv2Var2 = ry0Var.w;
                lv2Var2.getClass();
                vc4.b();
                lv2Var2.i = false;
                lv2Var2.b();
                return;
            case 1:
                lj1 lj1Var = (lj1) obj;
                lj1Var.c = lj1Var.e();
                nq nqVar = (nq) lj1Var.f;
                if (nqVar == null) {
                    return;
                }
                yq yqVar = nqVar.b;
                try {
                    try {
                        if (((Boolean) hg4.a(new nq(yqVar, i2)).b.get()).booleanValue()) {
                            lj1 lj1Var2 = yqVar.f0;
                            kh2 kh2Var2 = (kh2) lj1Var2.c;
                            kj1 kj1Var = (kj1) lj1Var2.d;
                            Object obj3 = null;
                            yqVar.c.execute(new pq(yqVar, yq.w(lj1Var2), kh2Var2, kj1Var, obj3, Collections.singletonList(t53.i), 0));
                            return;
                        }
                        return;
                    } catch (ExecutionException e) {
                        e = e;
                        throw new RuntimeException("Unable to check if MeteringRepeating is attached.", e);
                    }
                } catch (InterruptedException | ExecutionException e2) {
                    e = e2;
                }
                break;
            case 2:
                g02 g02Var = (g02) obj;
                if (g02Var.b() == null) {
                    return;
                }
                g02Var.C((h02) g02Var.f, g02Var.g);
                g02Var.n();
                return;
            default:
                ArrayList arrayList2 = ((jh2) obj).l;
                int size = arrayList2.size();
                while (i2 < size) {
                    Object obj4 = arrayList2.get(i2);
                    i2++;
                    ((ih2) obj4).a(kh2Var);
                }
                return;
        }
    }
}
