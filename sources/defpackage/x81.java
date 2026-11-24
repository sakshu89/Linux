package defpackage;

import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.project.sonic.R;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x81 implements wq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ x81(vq0 vq0Var, r50 r50Var, wq0 wq0Var, fq0 fq0Var) {
        this.a = 1;
        this.b = vq0Var;
        this.c = r50Var;
        this.e = wq0Var;
        this.f = fq0Var;
    }

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        f91 f91Var;
        ek1 ek1VarC;
        Object g2Var;
        Object objC;
        int i = this.a;
        q43 q43Var = q43.a;
        xy xyVar = r20.a;
        Object obj4 = this.f;
        Object obj5 = this.e;
        Object obj6 = this.c;
        Object obj7 = this.b;
        switch (i) {
            case 0:
                f91 f91Var2 = (f91) obj7;
                ek1 ek1Var = (ek1) obj6;
                w91 w91Var = (w91) obj5;
                mm1 mm1Var = (mm1) obj4;
                y92 y92Var = (y92) obj;
                x20 x20Var = (x20) obj2;
                ((Integer) obj3).getClass();
                Object objL = x20Var.L();
                Object obj8 = objL;
                if (objL == xyVar) {
                    v81 v81Var = new v81(y92Var, new hc(mm1Var, 3));
                    x20Var.g0(v81Var);
                    obj8 = v81Var;
                }
                v81 v81Var2 = (v81) obj8;
                Object objL2 = x20Var.L();
                Object obj9 = objL2;
                if (objL2 == xyVar) {
                    ws2 ws2Var = new ws2(new l11(v81Var2));
                    x20Var.g0(ws2Var);
                    obj9 = ws2Var;
                }
                ws2 ws2Var2 = (ws2) obj9;
                if (f91Var2 != null) {
                    x20Var.W(1743490539);
                    x20Var.W(887527095);
                    Object obj10 = wz1.a;
                    if (obj10 != null) {
                        x20Var.W(1345554384);
                        x20Var.p(false);
                    } else {
                        x20Var.W(1345603457);
                        View view = (View) x20Var.j(AndroidCompositionLocals_androidKt.f);
                        boolean zF = x20Var.f(view);
                        Object objL3 = x20Var.L();
                        if (zF || objL3 == xyVar) {
                            Object tag = view.getTag(R.id.compose_prefetch_scheduler);
                            uz1 ibVar = tag instanceof uz1 ? (uz1) tag : null;
                            if (ibVar == null) {
                                ibVar = new ib(view);
                                view.setTag(R.id.compose_prefetch_scheduler, ibVar);
                            }
                            objL3 = ibVar;
                            x20Var.g0(objL3);
                        }
                        obj10 = (uz1) objL3;
                        x20Var.p(false);
                    }
                    Object obj11 = obj10;
                    x20Var.p(false);
                    Object[] objArr = {f91Var2, v81Var2, ws2Var2, obj11};
                    boolean zF2 = x20Var.f(f91Var2) | x20Var.h(v81Var2) | x20Var.h(ws2Var2) | x20Var.h(obj11);
                    Object objL4 = x20Var.L();
                    if (zF2 || objL4 == xyVar) {
                        f91Var = f91Var2;
                        g2Var = new g2(f91Var, v81Var2, ws2Var2, obj11, 6);
                        x20Var.g0(g2Var);
                    } else {
                        g2Var = objL4;
                        f91Var = f91Var2;
                    }
                    hq0 hq0Var = (hq0) g2Var;
                    Object[] objArrCopyOf = Arrays.copyOf(objArr, 4);
                    boolean zF3 = false;
                    for (Object obj12 : objArrCopyOf) {
                        zF3 |= x20Var.f(obj12);
                    }
                    Object objL5 = x20Var.L();
                    if (zF3 || objL5 == xyVar) {
                        x20Var.g0(new od0(hq0Var));
                    }
                } else {
                    f91Var = f91Var2;
                    x20Var.W(1737291469);
                }
                x20Var.p(false);
                int i2 = g91.a;
                if (f91Var != null && (ek1VarC = ek1Var.c(new u23(f91Var))) != null) {
                    ek1Var = ek1VarC;
                }
                boolean zF4 = x20Var.f(v81Var2) | x20Var.f(w91Var);
                Object objL6 = x20Var.L();
                Object obj13 = objL6;
                if (zF4 || objL6 == xyVar) {
                    km kmVar = new km(7, v81Var2, w91Var);
                    x20Var.g0(kmVar);
                    obj13 = kmVar;
                }
                na4.b(ws2Var2, ek1Var, (vq0) obj13, x20Var, 8);
                return q43Var;
            case 1:
                vq0 vq0Var = (vq0) obj7;
                r50 r50Var = (r50) obj6;
                wq0 wq0Var = (wq0) obj5;
                fq0 fq0Var = (fq0) obj4;
                q50 q50Var = (q50) obj;
                x20 x20Var2 = (x20) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= x20Var2.f(q50Var) ? 4 : 2;
                }
                if (x20Var2.O(iIntValue & 1, (iIntValue & 19) != 18)) {
                    String str = (String) vq0Var.e(x20Var2, 0);
                    if (cs2.A(str)) {
                        c11.c("Label must not be blank");
                    }
                    r50Var.getClass();
                    dy3.a.p(str, Boolean.TRUE, q50Var, wq0Var, fq0Var, x20Var2, Integer.valueOf((iIntValue << 9) & 7168));
                } else {
                    x20Var2.R();
                }
                return q43Var;
            default:
                cn2 cn2Var = (cn2) obj7;
                ua1 ua1Var = (ua1) obj6;
                ty2 ty2Var = (ty2) obj5;
                long j = ty2Var.b;
                mp1 mp1Var = (mp1) obj4;
                ek1 ek1Var2 = (ek1) obj;
                x20 x20Var3 = (x20) obj2;
                ((Integer) obj3).getClass();
                x20Var3.W(-84507373);
                boolean zBooleanValue = ((Boolean) x20Var3.j(l30.w)).booleanValue();
                boolean zG = x20Var3.g(zBooleanValue);
                Object objL7 = x20Var3.L();
                Object obj14 = objL7;
                if (zG || objL7 == xyVar) {
                    k80 k80Var = new k80(zBooleanValue);
                    x20Var3.g0(k80Var);
                    obj14 = k80Var;
                }
                k80 k80Var2 = (k80) obj14;
                boolean z = cn2Var.a != 16;
                if (((Boolean) ((na1) ((la3) x20Var3.j(l30.t))).a.getValue()).booleanValue() && ua1Var.b() && oz2.c(j) && z) {
                    x20Var3.W(-707487962);
                    be beVar = ty2Var.a;
                    oz2 oz2Var = new oz2(j);
                    boolean zH = x20Var3.h(k80Var2);
                    Object objL8 = x20Var3.L();
                    Object obj15 = objL8;
                    if (zH || objL8 == xyVar) {
                        l2 l2Var = new l2((Object) k80Var2, (x50) (false ? 1 : 0), 17);
                        x20Var3.g0(l2Var);
                        obj15 = l2Var;
                    }
                    vq0 vq0Var2 = (vq0) obj15;
                    j70 j70Var = x20Var3.R;
                    boolean zF5 = x20Var3.f(beVar) | x20Var3.f(oz2Var);
                    Object objL9 = x20Var3.L();
                    Object obj16 = objL9;
                    if (zF5 || objL9 == xyVar) {
                        u61 u61Var = new u61(j70Var, vq0Var2);
                        x20Var3.g0(u61Var);
                        obj16 = u61Var;
                    }
                    boolean zH2 = x20Var3.h(k80Var2) | x20Var3.h(mp1Var) | x20Var3.f(ty2Var) | x20Var3.h(ua1Var) | x20Var3.f(cn2Var);
                    Object objL10 = x20Var3.L();
                    if (zH2 || objL10 == xyVar) {
                        w9 w9Var = new w9(k80Var2, mp1Var, ty2Var, ua1Var, cn2Var);
                        x20Var3.g0(w9Var);
                        objL10 = w9Var;
                    }
                    objC = az3.c(ek1Var2, (hq0) objL10);
                    x20Var3.p(false);
                } else {
                    x20Var3.W(-705473241);
                    x20Var3.p(false);
                    objC = bk1.a;
                }
                x20Var3.p(false);
                return objC;
        }
    }

    public /* synthetic */ x81(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
        this.f = obj4;
    }
}
