package defpackage;

import android.graphics.Typeface;
import android.text.Spannable;
import com.ibm.icu.text.DateTimePatternGenerator;
import com.project.sonic.MainActivity;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t50 implements wq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ t50(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        Typeface typeface;
        int i = this.a;
        int i2 = 16;
        xy xyVar = r20.a;
        q43 q43Var = q43.a;
        Object obj4 = this.c;
        Object obj5 = this.b;
        int i3 = 0;
        switch (i) {
            case 0:
                hq0 hq0Var = (hq0) obj5;
                q50 q50Var = (q50) obj4;
                x20 x20Var = (x20) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                if (x20Var.O(1 & iIntValue, (iIntValue & 17) != 16)) {
                    Object objL = x20Var.L();
                    if (objL == xyVar) {
                        objL = new r50();
                        x20Var.g0(objL);
                    }
                    r50 r50Var = (r50) objL;
                    r50Var.a.clear();
                    hq0Var.j(r50Var);
                    r50Var.a(q50Var, x20Var, 0);
                } else {
                    x20Var.R();
                }
                return q43Var;
            case 1:
                MainActivity mainActivity = (MainActivity) obj5;
                gr2 gr2Var = (gr2) obj4;
                fq0 fq0Var = (fq0) obj;
                x20 x20Var2 = (x20) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                Set set = MainActivity.m0;
                fq0Var.getClass();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= x20Var2.h(fq0Var) ? 4 : 2;
                }
                if (x20Var2.O(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    gj2 gj2Var = (gj2) gr2Var.getValue();
                    oj2 oj2VarR = mainActivity.r();
                    boolean zH = x20Var2.h(oj2VarR);
                    Object objL2 = x20Var2.L();
                    if (zH || objL2 == xyVar) {
                        q0 q0Var = new q0(1, oj2VarR, oj2.class, "setCloudEnabled", "setCloudEnabled(Z)V", 0, 0, 5);
                        x20Var2.g0(q0Var);
                        objL2 = q0Var;
                    }
                    hq0 hq0Var2 = (hq0) ((gr0) objL2);
                    oj2 oj2VarR2 = mainActivity.r();
                    boolean zH2 = x20Var2.h(oj2VarR2);
                    Object objL3 = x20Var2.L();
                    if (zH2 || objL3 == xyVar) {
                        q0 q0Var2 = new q0(1, oj2VarR2, oj2.class, "save", "save(Ljava/lang/String;)V", 0, 0, 7);
                        x20Var2.g0(q0Var2);
                        objL3 = q0Var2;
                    }
                    hq0 hq0Var3 = (hq0) ((gr0) objL3);
                    oj2 oj2VarR3 = mainActivity.r();
                    boolean zH3 = x20Var2.h(oj2VarR3);
                    Object objL4 = x20Var2.L();
                    if (zH3 || objL4 == xyVar) {
                        objL4 = new g7(0, oj2VarR3, oj2.class, "clearKey", "clearKey()V", 0, 0, 9);
                        x20Var2.g0(objL4);
                    }
                    fq0 fq0Var2 = (fq0) ((gr0) objL4);
                    oj2 oj2VarR4 = mainActivity.r();
                    boolean zH4 = x20Var2.h(oj2VarR4);
                    Object objL5 = x20Var2.L();
                    if (zH4 || objL5 == xyVar) {
                        objL5 = new g7(0, oj2VarR4, oj2.class, "test", "test()V", 0, 0, 10);
                        x20Var2.g0(objL5);
                    }
                    fq0 fq0Var3 = (fq0) ((gr0) objL5);
                    boolean zH5 = x20Var2.h(mainActivity);
                    Object objL6 = x20Var2.L();
                    if (zH5 || objL6 == xyVar) {
                        objL6 = new zf1(mainActivity, 3);
                        x20Var2.g0(objL6);
                    }
                    hq0 hq0Var4 = (hq0) objL6;
                    oj2 oj2VarR5 = mainActivity.r();
                    boolean zH6 = x20Var2.h(oj2VarR5);
                    Object objL7 = x20Var2.L();
                    if (zH6 || objL7 == xyVar) {
                        objL7 = new q0(1, oj2VarR5, oj2.class, "setConfirmationThreshold", "setConfirmationThreshold(Lcom/project/sonic/core/skill/RiskLevel;)V", 0, 0, 8);
                        x20Var2.g0(objL7);
                    }
                    hq0 hq0Var5 = (hq0) ((gr0) objL7);
                    so2 so2VarQ = mainActivity.q();
                    boolean zH7 = x20Var2.h(so2VarQ);
                    Object objL8 = x20Var2.L();
                    if (zH7 || objL8 == xyVar) {
                        objL8 = new q0(1, so2VarQ, so2.class, "setAmbient", "setAmbient(Z)V", 0, 0, 9);
                        x20Var2.g0(objL8);
                    }
                    hq0 hq0Var6 = (hq0) ((gr0) objL8);
                    oj2 oj2VarR6 = mainActivity.r();
                    boolean zH8 = x20Var2.h(oj2VarR6);
                    Object objL9 = x20Var2.L();
                    if (zH8 || objL9 == xyVar) {
                        objL9 = new q0(1, oj2VarR6, oj2.class, "setScreenReadingEnabled", "setScreenReadingEnabled(Z)V", 0, 0, 10);
                        x20Var2.g0(objL9);
                    }
                    hq0 hq0Var7 = (hq0) ((gr0) objL9);
                    oj2 oj2VarR7 = mainActivity.r();
                    boolean zH9 = x20Var2.h(oj2VarR7);
                    Object objL10 = x20Var2.L();
                    if (zH9 || objL10 == xyVar) {
                        objL10 = new q0(1, oj2VarR7, oj2.class, "setHonorificEnabled", "setHonorificEnabled(Z)V", 0, 0, 11);
                        x20Var2.g0(objL10);
                    }
                    hq0 hq0Var8 = (hq0) ((gr0) objL10);
                    oj2 oj2VarR8 = mainActivity.r();
                    boolean zH10 = x20Var2.h(oj2VarR8);
                    Object objL11 = x20Var2.L();
                    if (zH10 || objL11 == xyVar) {
                        objL11 = new q0(1, oj2VarR8, oj2.class, "setDirectWhatsAppMessages", "setDirectWhatsAppMessages(Z)V", 0, 0, 6);
                        x20Var2.g0(objL11);
                    }
                    hq0 hq0Var9 = (hq0) ((gr0) objL11);
                    boolean zH11 = x20Var2.h(mainActivity);
                    Object objL12 = x20Var2.L();
                    if (zH11 || objL12 == xyVar) {
                        g7 g7Var = new g7(0, mainActivity, MainActivity.class, "requestAssistantRole", "requestAssistantRole()V", 0, 0, 5);
                        x20Var2.g0(g7Var);
                        objL12 = g7Var;
                    }
                    fq0 fq0Var4 = (fq0) ((gr0) objL12);
                    boolean zH12 = x20Var2.h(mainActivity);
                    Object objL13 = x20Var2.L();
                    if (zH12 || objL13 == xyVar) {
                        g7 g7Var2 = new g7(0, mainActivity, MainActivity.class, "requestPowerShortcut", "requestPowerShortcut()V", 0, 0, 6);
                        x20Var2.g0(g7Var2);
                        objL13 = g7Var2;
                    }
                    fq0 fq0Var5 = (fq0) ((gr0) objL13);
                    boolean zH13 = x20Var2.h(mainActivity);
                    Object objL14 = x20Var2.L();
                    if (zH13 || objL14 == xyVar) {
                        objL14 = new zf1(mainActivity, i3);
                        x20Var2.g0(objL14);
                    }
                    hq0 hq0Var10 = (hq0) objL14;
                    sj2 sj2VarS = mainActivity.s();
                    boolean zH14 = x20Var2.h(sj2VarS);
                    Object objL15 = x20Var2.L();
                    if (zH14 || objL15 == xyVar) {
                        objL15 = new g7(0, sj2VarS, sj2.class, "reopen", "reopen()V", 0, 0, 7);
                        x20Var2.g0(objL15);
                    }
                    fq0 fq0Var6 = (fq0) ((gr0) objL15);
                    oj2 oj2VarR9 = mainActivity.r();
                    boolean zH15 = x20Var2.h(oj2VarR9);
                    Object objL16 = x20Var2.L();
                    if (zH15 || objL16 == xyVar) {
                        objL16 = new g7(0, oj2VarR9, oj2.class, "forgetEverything", "forgetEverything()V", 0, 0, 8);
                        x20Var2.g0(objL16);
                    }
                    k34.i(gj2Var, hq0Var2, hq0Var3, fq0Var2, fq0Var3, hq0Var4, hq0Var5, hq0Var6, hq0Var7, hq0Var8, hq0Var9, fq0Var4, fq0Var5, hq0Var10, fq0Var, fq0Var6, (fq0) ((gr0) objL16), null, x20Var2, 0, (iIntValue2 << 12) & 57344);
                } else {
                    x20Var2.R();
                }
                return q43Var;
            case 2:
                fq0 fq0Var7 = (fq0) obj4;
                hq0 hq0Var11 = (hq0) obj5;
                x20 x20Var3 = (x20) obj2;
                ((Integer) obj3).getClass();
                x20Var3.W(759876635);
                Object objL17 = x20Var3.L();
                if (objL17 == xyVar) {
                    objL17 = o44.b(fq0Var7);
                    x20Var3.g0(objL17);
                }
                gr2 gr2Var2 = (gr2) objL17;
                Object objL18 = x20Var3.L();
                if (objL18 == xyVar) {
                    objL18 = new bd(new jp1(((jp1) gr2Var2.getValue()).a), zf2.b, new jp1(zf2.c), 8);
                    x20Var3.g0(objL18);
                }
                bd bdVar = (bd) objL18;
                boolean zH16 = x20Var3.h(bdVar);
                Object objL19 = x20Var3.L();
                if (zH16 || objL19 == xyVar) {
                    objL19 = new r0(gr2Var2, bdVar, null, 17);
                    x20Var3.g0(objL19);
                }
                bz3.c(x20Var3, (vq0) objL19, q43Var);
                qd qdVar = bdVar.c;
                boolean zF = x20Var3.f(qdVar);
                Object objL20 = x20Var3.L();
                if (zF || objL20 == xyVar) {
                    objL20 = new xf2(qdVar, 0);
                    x20Var3.g0(objL20);
                }
                ek1 ek1Var = (ek1) hq0Var11.j((fq0) objL20);
                x20Var3.p(false);
                return ek1Var;
            case 3:
                gj2 gj2Var2 = (gj2) obj4;
                hq0 hq0Var12 = (hq0) obj5;
                x20 x20Var4 = (x20) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((nn0) obj).getClass();
                if (x20Var4.O(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gj0 gj0Var = b60.j;
                    gj0Var.getClass();
                    e1 e1Var = new e1(gj0Var);
                    while (e1Var.hasNext()) {
                        b60 b60Var = (b60) e1Var.next();
                        String str = b60Var.a;
                        boolean z = b60Var == gj2Var2.j;
                        boolean zF2 = x20Var4.f(hq0Var12) | x20Var4.d(b60Var.ordinal());
                        Object objL21 = x20Var4.L();
                        if (zF2 || objL21 == xyVar) {
                            objL21 = new zb(i2, hq0Var12, b60Var);
                            x20Var4.g0(objL21);
                        }
                        k34.g(str, z, (fq0) objL21, x20Var4, 0);
                    }
                } else {
                    x20Var4.R();
                }
                return q43Var;
            default:
                Spannable spannable = (Spannable) obj5;
                la laVar = (la) obj4;
                hp2 hp2Var = (hp2) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                int iIntValue5 = ((Integer) obj3).intValue();
                ev2 ev2Var = hp2Var.f;
                np0 np0Var = hp2Var.c;
                if (np0Var == null) {
                    np0Var = np0.c;
                }
                lp0 lp0Var = hp2Var.d;
                i3 = lp0Var != null ? lp0Var.a : 0;
                mp0 mp0Var = hp2Var.e;
                int i4 = mp0Var != null ? mp0Var.a : DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
                ma maVar = laVar.a;
                t33 t33VarB = ((ro0) maVar.f).b(ev2Var, np0Var, i3, i4);
                if (t33VarB instanceof t33) {
                    Object obj6 = t33VarB.a;
                    obj6.getClass();
                    typeface = (Typeface) obj6;
                } else {
                    b13 b13Var = new b13(t33VarB, maVar.s);
                    maVar.s = b13Var;
                    Object obj7 = b13Var.c;
                    obj7.getClass();
                    typeface = (Typeface) obj7;
                }
                spannable.setSpan(new to0(1, typeface), iIntValue4, iIntValue5, 33);
                return q43Var;
        }
    }

    public /* synthetic */ t50(Object obj, hq0 hq0Var, int i) {
        this.a = i;
        this.c = obj;
        this.b = hq0Var;
    }
}
