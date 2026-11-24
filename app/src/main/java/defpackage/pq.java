package defpackage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pq implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;

    public /* synthetic */ pq(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
        this.f = obj4;
        this.i = obj5;
        this.j = obj6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                yq yqVar = (yq) this.b;
                String str = (String) this.c;
                kh2 kh2Var = (kh2) this.e;
                r53 r53Var = (r53) this.f;
                fj fjVar = (fj) this.i;
                List list = (List) this.j;
                yqVar.t("Use case " + str + " RESET");
                yqVar.a.f(str, kh2Var, r53Var, fjVar, list);
                yqVar.p();
                yqVar.D();
                yqVar.K();
                if (yqVar.q0 == 9) {
                    yqVar.B();
                }
                break;
            case 1:
                yq yqVar2 = (yq) this.b;
                String str2 = (String) this.c;
                kh2 kh2Var2 = (kh2) this.e;
                r53 r53Var2 = (r53) this.f;
                fj fjVar2 = (fj) this.i;
                List list2 = (List) this.j;
                yqVar2.t("Use case " + str2 + " UPDATED");
                yqVar2.a.f(str2, kh2Var2, r53Var2, fjVar2, list2);
                yqVar2.K();
                break;
            case 2:
                yq yqVar3 = (yq) this.b;
                String str3 = (String) this.c;
                kh2 kh2Var3 = (kh2) this.e;
                r53 r53Var3 = (r53) this.f;
                fj fjVar3 = (fj) this.i;
                List list3 = (List) this.j;
                yqVar3.t("Use case " + str3 + " ACTIVE");
                LinkedHashMap linkedHashMap = yqVar3.a.a;
                p53 p53Var = (p53) linkedHashMap.get(str3);
                if (p53Var == null) {
                    p53Var = new p53(kh2Var3, r53Var3, fjVar3, list3);
                    linkedHashMap.put(str3, p53Var);
                }
                p53Var.f = true;
                yqVar3.a.f(str3, kh2Var3, r53Var3, fjVar3, list3);
                yqVar3.K();
                break;
            default:
                ((cj) this.b).l((wt) this.c, (wt) this.e, (st2) this.f, (st2) this.i, (Map.Entry) this.j);
                break;
        }
    }
}
