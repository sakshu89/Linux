package defpackage;

import com.project.sonic.MainActivity;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bg1 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object i;

    public /* synthetic */ bg1(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
        this.f = obj4;
        this.i = obj5;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        xy xyVar = r20.a;
        q43 q43Var = q43.a;
        Object obj3 = this.i;
        Object obj4 = this.f;
        Object obj5 = this.e;
        Object obj6 = this.c;
        Object obj7 = this.b;
        int i2 = 1;
        switch (i) {
            case 0:
                MainActivity mainActivity = (MainActivity) obj7;
                gr2 gr2Var = (gr2) obj6;
                gr2 gr2Var2 = (gr2) obj5;
                gr2 gr2Var3 = (gr2) obj4;
                gr2 gr2Var4 = (gr2) obj3;
                x20 x20Var = (x20) obj;
                int iIntValue = ((Integer) obj2).intValue();
                Set set = MainActivity.m0;
                if (!x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x20Var.R();
                    return q43Var;
                }
                Boolean bool = (Boolean) gr2Var.getValue();
                vw0 vw0Var = y34.a;
                rl0 rl0Var = w44.b;
                if (bool == null) {
                    x20Var.W(1171930211);
                    gm.a(kg1.a(rl0Var, uz.a, vw0Var), x20Var, 6);
                    x20Var.p(false);
                    return q43Var;
                }
                if (bool.equals(Boolean.TRUE)) {
                    x20Var.W(1970215231);
                    qj2 qj2Var = (qj2) gr2Var2.getValue();
                    boolean zH = x20Var.h(mainActivity);
                    Object objL = x20Var.L();
                    if (zH || objL == xyVar) {
                        g7 g7Var = new g7(0, mainActivity, MainActivity.class, "requestAssistantRole", "requestAssistantRole()V", 0, 0, 4);
                        x20Var.g0(g7Var);
                        objL = g7Var;
                    }
                    rq0 rq0Var = (gr0) objL;
                    boolean zH2 = x20Var.h(mainActivity);
                    Object objL2 = x20Var.L();
                    if (zH2 || objL2 == xyVar) {
                        g7 g7Var2 = new g7(0, mainActivity, MainActivity.class, "requestPowerShortcut", "requestPowerShortcut()V", 0, 0, 11);
                        x20Var.g0(g7Var2);
                        objL2 = g7Var2;
                    }
                    rq0 rq0Var2 = (gr0) objL2;
                    sj2 sj2VarS = mainActivity.s();
                    boolean zH3 = x20Var.h(sj2VarS);
                    Object objL3 = x20Var.L();
                    if (zH3 || objL3 == xyVar) {
                        q0 q0Var = new q0(1, sj2VarS, sj2.class, "setLanguage", "setLanguage(Lcom/project/sonic/core/agent/Language;)V", 0, 0, 12);
                        x20Var.g0(q0Var);
                        objL3 = q0Var;
                    }
                    rq0 rq0Var3 = (gr0) objL3;
                    sj2 sj2VarS2 = mainActivity.s();
                    boolean zH4 = x20Var.h(sj2VarS2);
                    Object objL4 = x20Var.L();
                    if (zH4 || objL4 == xyVar) {
                        g7 g7Var3 = new g7(0, sj2VarS2, sj2.class, "finish", "finish()V", 0, 0, 12);
                        x20Var.g0(g7Var3);
                        objL4 = g7Var3;
                    }
                    rq0 rq0Var4 = (gr0) objL4;
                    sj2 sj2VarS3 = mainActivity.s();
                    boolean zH5 = x20Var.h(sj2VarS3);
                    Object objL5 = x20Var.L();
                    if (zH5 || objL5 == xyVar) {
                        objL5 = new g7(0, sj2VarS3, sj2.class, "finish", "finish()V", 0, 0, 13);
                        x20Var.g0(objL5);
                    }
                    rq0 rq0Var5 = (gr0) objL5;
                    ek1 ek1VarB = kb4.b(kb4.b(kg1.a(rl0Var, uz.a, vw0Var), new l63(10)), new l63(9));
                    boolean zH6 = x20Var.h(mainActivity);
                    Object objL6 = x20Var.L();
                    if (zH6 || objL6 == xyVar) {
                        objL6 = new kb(12, mainActivity);
                        x20Var.g0(objL6);
                    }
                    fq0 fq0Var = (fq0) objL6;
                    boolean zH7 = x20Var.h(mainActivity);
                    Object objL7 = x20Var.L();
                    if (zH7 || objL7 == xyVar) {
                        objL7 = new zf1(mainActivity, i2);
                        x20Var.g0(objL7);
                    }
                    q44.f(qj2Var, fq0Var, (hq0) objL7, (fq0) rq0Var, (hq0) rq0Var3, (fq0) rq0Var4, (fq0) rq0Var5, (fq0) rq0Var2, ek1VarB, x20Var, 0);
                    x20Var.p(false);
                    return q43Var;
                }
                if (!bool.equals(Boolean.FALSE)) {
                    x20Var.W(1171932536);
                    x20Var.p(false);
                    dk0.l();
                    return null;
                }
                x20Var.W(1171979634);
                eo2 eo2Var = (eo2) gr2Var3.getValue();
                g32 g32Var = new g32(mainActivity.q().o);
                so2 so2VarQ = mainActivity.q();
                boolean zH8 = x20Var.h(so2VarQ);
                Object objL8 = x20Var.L();
                if (zH8 || objL8 == xyVar) {
                    objL8 = new g7(0, so2VarQ, so2.class, "onMicTap", "onMicTap()V", 0, 0, 14);
                    x20Var.g0(objL8);
                }
                fq0 fq0Var2 = (fq0) ((gr0) objL8);
                so2 so2VarQ2 = mainActivity.q();
                boolean zH9 = x20Var.h(so2VarQ2);
                Object objL9 = x20Var.L();
                if (zH9 || objL9 == xyVar) {
                    objL9 = new q0(1, so2VarQ2, so2.class, "setAmbient", "setAmbient(Z)V", 0, 0, 13);
                    x20Var.g0(objL9);
                }
                hq0 hq0Var = (hq0) ((gr0) objL9);
                so2 so2VarQ3 = mainActivity.q();
                boolean zH10 = x20Var.h(so2VarQ3);
                Object objL10 = x20Var.L();
                if (zH10 || objL10 == xyVar) {
                    objL10 = new q0(1, so2VarQ3, so2.class, "setMuted", "setMuted(Z)V", 0, 0, 2);
                    x20Var.g0(objL10);
                }
                hq0 hq0Var2 = (hq0) ((gr0) objL10);
                so2 so2VarQ4 = mainActivity.q();
                boolean zH11 = x20Var.h(so2VarQ4);
                Object objL11 = x20Var.L();
                if (zH11 || objL11 == xyVar) {
                    objL11 = new q0(1, so2VarQ4, so2.class, "onSubmitText", "onSubmitText(Ljava/lang/String;)V", 0, 0, 3);
                    x20Var.g0(objL11);
                }
                hq0 hq0Var3 = (hq0) ((gr0) objL11);
                so2 so2VarQ5 = mainActivity.q();
                boolean zH12 = x20Var.h(so2VarQ5);
                Object objL12 = x20Var.L();
                if (zH12 || objL12 == xyVar) {
                    objL12 = new eg1(0, so2VarQ5, so2.class, "onConfirm", "onConfirm()Lkotlinx/coroutines/Job;", 8, 0);
                    x20Var.g0(objL12);
                }
                fq0 fq0Var3 = (fq0) objL12;
                so2 so2VarQ6 = mainActivity.q();
                boolean zH13 = x20Var.h(so2VarQ6);
                Object objL13 = x20Var.L();
                if (zH13 || objL13 == xyVar) {
                    objL13 = new eg1(0, so2VarQ6, so2.class, "onDecline", "onDecline()Lkotlinx/coroutines/Job;", 8, 1);
                    x20Var.g0(objL13);
                }
                fq0 fq0Var4 = (fq0) objL13;
                so2 so2VarQ7 = mainActivity.q();
                boolean zH14 = x20Var.h(so2VarQ7);
                Object objL14 = x20Var.L();
                if (zH14 || objL14 == xyVar) {
                    objL14 = new fg1(1, so2VarQ7, so2.class, "onChoose", "onChoose(Ljava/lang/String;)Lkotlinx/coroutines/Job;", 8, 0);
                    x20Var.g0(objL14);
                }
                hq0 hq0Var4 = (hq0) objL14;
                so2 so2VarQ8 = mainActivity.q();
                boolean zH15 = x20Var.h(so2VarQ8);
                Object objL15 = x20Var.L();
                if (zH15 || objL15 == xyVar) {
                    objL15 = new q0(1, so2VarQ8, so2.class, "onRemedy", "onRemedy(Lcom/project/sonic/core/skill/Remedy;)V", 0, 0, 4);
                    x20Var.g0(objL15);
                }
                k54.g(eo2Var, g32Var, fq0Var2, hq0Var, hq0Var2, hq0Var3, fq0Var3, fq0Var4, hq0Var4, (hq0) ((gr0) objL15), yi4.b(312986308, new t50(i2, mainActivity, gr2Var4), x20Var), null, x20Var, 0);
                x20Var.p(false);
                return q43Var;
            case 1:
                ek1 ek1Var = (ek1) obj7;
                mm1 mm1Var = (mm1) obj6;
                w10 w10Var = (w10) obj5;
                wk wkVar = (wk) obj4;
                fq0 fq0Var5 = (fq0) obj3;
                x20 x20Var2 = (x20) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (x20Var2.O(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    Object objL16 = x20Var2.L();
                    if (objL16 == xyVar) {
                        objL16 = new jc(mm1Var, 2);
                        x20Var2.g0(objL16);
                    }
                    ek1 ek1VarA = w24.a(ek1Var, (hq0) objL16);
                    oh1 oh1VarD = gm.d(xy.b, true);
                    int iHashCode = Long.hashCode(x20Var2.T);
                    gw1 gw1VarL = x20Var2.l();
                    ek1 ek1VarC = gj4.c(x20Var2, ek1VarA);
                    o20.p.getClass();
                    k30 k30Var = n20.b;
                    x20Var2.Z();
                    if (x20Var2.S) {
                        x20Var2.k(k30Var);
                    } else {
                        x20Var2.j0();
                    }
                    ie4.c(x20Var2, n20.f, oh1VarD);
                    ie4.c(x20Var2, n20.e, gw1VarL);
                    ie4.a(x20Var2, Integer.valueOf(iHashCode), n20.g);
                    ie4.b(x20Var2, n20.h);
                    ie4.c(x20Var2, n20.d, ek1VarC);
                    w10Var.e(x20Var2, 0);
                    wkVar.b(fq0Var5, x20Var2, 6);
                    x20Var2.p(true);
                } else {
                    x20Var2.R();
                }
                return q43Var;
            default:
                gj2 gj2Var = (gj2) obj7;
                hq0 hq0Var5 = (hq0) obj6;
                hq0 hq0Var6 = (hq0) obj5;
                fq0 fq0Var6 = (fq0) obj4;
                fq0 fq0Var7 = (fq0) obj3;
                x20 x20Var3 = (x20) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                if (x20Var3.O(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    k34.b("Put API key", x20Var3, 6);
                    bk1 bk1Var = bk1.a;
                    k54.h(x20Var3, w44.c(bk1Var, 12.0f));
                    k34.k("Cloud AI", gj2Var.a, hq0Var5, x20Var3, 6);
                    if (gj2Var.a) {
                        x20Var3.W(1281819376);
                        k54.h(x20Var3, w44.c(bk1Var, 12.0f));
                        k34.e(gj2Var, hq0Var6, fq0Var6, fq0Var7, x20Var3, 0);
                    } else {
                        x20Var3.W(1276437497);
                    }
                    x20Var3.p(false);
                } else {
                    x20Var3.R();
                }
                return q43Var;
        }
    }
}
