package defpackage;

import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wp1 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ bq1 b;

    public /* synthetic */ wp1(bq1 bq1Var, int i) {
        this.a = i;
        this.b = bq1Var;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057  */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        q43 q43Var = q43.a;
        Object obj2 = null;
        bq1 bq1Var = this.b;
        gk gkVar = (gk) obj;
        switch (i) {
            case 0:
                gkVar.getClass();
                hg hgVar = bq1Var.b;
                ListIterator listIterator = hgVar.listIterator(hgVar.a());
                while (listIterator.hasPrevious()) {
                    Object objPrevious = listIterator.previous();
                    if (((vp1) objPrevious).a) {
                        obj2 = objPrevious;
                        vp1 vp1Var = (vp1) obj2;
                        if (bq1Var.c != null) {
                            bq1Var.a();
                        }
                        bq1Var.c = vp1Var;
                        break;
                    }
                }
                vp1 vp1Var2 = (vp1) obj2;
                if (bq1Var.c != null) {
                    bq1Var.a();
                }
                bq1Var.c = vp1Var2;
                break;
            default:
                gkVar.getClass();
                if (bq1Var.c == null) {
                    hg hgVar2 = bq1Var.b;
                    ListIterator listIterator2 = hgVar2.listIterator(hgVar2.a());
                    while (listIterator2.hasPrevious()) {
                        Object objPrevious2 = listIterator2.previous();
                        if (((vp1) objPrevious2).a) {
                            obj2 = objPrevious2;
                            break;
                        }
                    }
                }
                break;
        }
        return q43Var;
    }
}
