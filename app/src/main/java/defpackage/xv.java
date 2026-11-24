package defpackage;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import com.ibm.icu.text.DateTimePatternGenerator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xv implements wq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ xv(an1 an1Var, zm1 zm1Var) {
        this.a = 3;
        this.b = an1Var;
    }

    /* JADX WARN: Code duplicated, block: B:122:0x03c9  */
    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        x20 x20Var;
        int i = this.a;
        int i2 = 2;
        bk1 bk1Var = bk1.a;
        boolean z = true;
        xy xyVar = r20.a;
        q43 q43Var = q43.a;
        boolean z2 = false;
        Object obj4 = this.b;
        switch (i) {
            case 0:
                ((x0) obj4).j((Throwable) obj);
                return q43Var;
            case 1:
                f70 f70Var = (f70) obj4;
                int iIntValue = ((Integer) obj).intValue();
                int iIntValue2 = ((Integer) obj2).intValue();
                boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                if (!zBooleanValue) {
                    iIntValue = f70Var.e0.k(iIntValue);
                }
                if (!zBooleanValue) {
                    iIntValue2 = f70Var.e0.k(iIntValue2);
                }
                if (f70Var.c0) {
                    long j = f70Var.Y.b;
                    int i3 = oz2.c;
                    if (iIntValue == ((int) (j >> 32)) && iIntValue2 == ((int) (j & 4294967295L))) {
                        z = false;
                    } else {
                        int iMin = Math.min(iIntValue, iIntValue2);
                        rv0 rv0Var = rv0.a;
                        if (iMin < 0 || Math.max(iIntValue, iIntValue2) > f70Var.Y.a.b.length()) {
                            ny2 ny2Var = f70Var.f0;
                            ny2Var.t(false);
                            ny2Var.q(rv0Var);
                            z = false;
                        } else {
                            if (zBooleanValue || iIntValue == iIntValue2) {
                                ny2 ny2Var2 = f70Var.f0;
                                ny2Var2.t(false);
                                ny2Var2.q(rv0Var);
                            } else {
                                f70Var.f0.h(true);
                            }
                            f70Var.Z.v.j(new ty2(f70Var.Y.a, hc4.a(iIntValue, iIntValue2), (oz2) null));
                        }
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                ((ef1) obj4).b.b(((ny1) obj2).c, xy.Y);
                return q43Var;
            case 3:
                an1 an1Var = (an1) obj4;
                an1.i.set(an1Var, null);
                an1Var.h(null);
                return q43Var;
            case 4:
                h52 h52Var = (h52) obj4;
                x20 x20Var2 = (x20) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((f92) obj).getClass();
                if (x20Var2.O(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    dz2.b(h52Var.a(), null, 0L, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).m, x20Var2, 0, 0, 131070);
                } else {
                    x20Var2.R();
                }
                return q43Var;
            case 5:
                ((sg2) obj4).b();
                return q43Var;
            case 6:
                mm1 mm1Var = (mm1) obj4;
                vq0 vq0Var = (vq0) obj;
                x20 x20Var3 = (x20) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                vq0Var.getClass();
                if ((iIntValue4 & 6) == 0) {
                    iIntValue4 |= x20Var3.h(vq0Var) ? 4 : 2;
                }
                if (x20Var3.O(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                    if (((String) mm1Var.getValue()).length() == 0) {
                        x20Var3.W(1868464189);
                        dz2.b("Paste API key", null, uz.g, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var3.j(w33.a)).k, x20Var3, 390, 0, 131066);
                        x20Var = x20Var3;
                    } else {
                        x20 x20Var4 = x20Var3;
                        x20Var4.W(1857343156);
                        x20Var = x20Var4;
                    }
                    x20Var.p(false);
                    vq0Var.e(x20Var, Integer.valueOf(iIntValue4 & 14));
                } else {
                    x20Var3.R();
                }
                return q43Var;
            case 7:
                hq0 hq0Var = (hq0) obj4;
                x20 x20Var5 = (x20) obj2;
                ((Integer) obj3).getClass();
                x20Var5.W(-102778667);
                Object objL = x20Var5.L();
                Object obj5 = objL;
                if (objL == xyVar) {
                    s70 s70VarE = bz3.e(x20Var5);
                    x20Var5.g0(s70VarE);
                    obj5 = s70VarE;
                }
                s70 s70Var = (s70) obj5;
                Object objL2 = x20Var5.L();
                Object obj6 = objL2;
                if (objL2 == xyVar) {
                    ku1 ku1VarG = o44.g(null);
                    x20Var5.g0(ku1VarG);
                    obj6 = ku1VarG;
                }
                mm1 mm1Var2 = (mm1) obj6;
                mm1 mm1VarH = o44.h(hq0Var, x20Var5);
                boolean zF = x20Var5.f(null);
                Object objL3 = x20Var5.L();
                Object obj7 = objL3;
                if (zF || objL3 == xyVar) {
                    jc jcVar = new jc(mm1Var2, 6);
                    x20Var5.g0(jcVar);
                    obj7 = jcVar;
                }
                bz3.a(null, (hq0) obj7, x20Var5);
                boolean zH = x20Var5.h(s70Var) | x20Var5.f(null) | x20Var5.f(mm1VarH);
                Object objL4 = x20Var5.L();
                Object obj8 = objL4;
                if (zH || objL4 == xyVar) {
                    cy2 cy2Var = new cy2(s70Var, mm1Var2, mm1VarH);
                    x20Var5.g0(cy2Var);
                    obj8 = cy2Var;
                }
                ek1 ek1VarA = pu2.a(bk1Var, null, (PointerInputEventHandler) obj8);
                x20Var5.p(false);
                return ek1VarA;
            case 8:
                ny2 ny2Var3 = (ny2) obj4;
                ek1 ek1Var = (ek1) obj;
                x20 x20Var6 = (x20) obj2;
                ((Integer) obj3).getClass();
                x20Var6.W(1980580247);
                jc0 jc0Var = (jc0) x20Var6.j(l30.h);
                Object objL5 = x20Var6.L();
                Object obj9 = objL5;
                if (objL5 == xyVar) {
                    ku1 ku1VarG2 = o44.g(new l21(0L));
                    x20Var6.g0(ku1VarG2);
                    obj9 = ku1VarG2;
                }
                mm1 mm1Var3 = (mm1) obj9;
                boolean zH2 = x20Var6.h(ny2Var3);
                Object objL6 = x20Var6.L();
                Object obj10 = objL6;
                if (zH2 || objL6 == xyVar) {
                    zb zbVar = new zb(22, ny2Var3, mm1Var3);
                    x20Var6.g0(zbVar);
                    obj10 = zbVar;
                }
                fq0 fq0Var = (fq0) obj10;
                boolean zF2 = x20Var6.f(jc0Var);
                Object objL7 = x20Var6.L();
                Object obj11 = objL7;
                if (zF2 || objL7 == xyVar) {
                    qy2 qy2Var = new qy2(jc0Var, mm1Var3, z2 ? 1 : 0);
                    x20Var6.g0(qy2Var);
                    obj11 = qy2Var;
                }
                sd sdVar = zf2.a;
                ek1 ek1VarA2 = gj4.a(ek1Var, new t50(fq0Var, (hq0) obj11, i2));
                x20Var6.p(false);
                return ek1VarA2;
            case 9:
                yz2 yz2Var = (yz2) obj4;
                x20 x20Var7 = (x20) obj2;
                ((Integer) obj3).getClass();
                x20Var7.W(1582736677);
                jc0 jc0Var2 = (jc0) x20Var7.j(l30.h);
                qo0 qo0Var = (qo0) x20Var7.j(l30.k);
                z61 z61Var = (z61) x20Var7.j(l30.n);
                boolean zF3 = x20Var7.f(yz2Var) | x20Var7.d(z61Var.ordinal());
                Object objL8 = x20Var7.L();
                Object obj12 = objL8;
                if (zF3 || objL8 == xyVar) {
                    yz2 yz2VarB = lc4.b(yz2Var, z61Var);
                    x20Var7.g0(yz2VarB);
                    obj12 = yz2VarB;
                }
                yz2 yz2Var2 = (yz2) obj12;
                boolean zF4 = x20Var7.f(qo0Var) | x20Var7.f(yz2Var2);
                Object objL9 = x20Var7.L();
                Object obj13 = objL9;
                if (zF4 || objL9 == xyVar) {
                    hp2 hp2Var = yz2Var2.a;
                    ev2 ev2Var = hp2Var.f;
                    np0 np0Var = hp2Var.c;
                    if (np0Var == null) {
                        np0Var = np0.c;
                    }
                    lp0 lp0Var = hp2Var.d;
                    int i4 = lp0Var != null ? lp0Var.a : 0;
                    mp0 mp0Var = hp2Var.e;
                    t33 t33VarB = ((ro0) qo0Var).b(ev2Var, np0Var, i4, mp0Var != null ? mp0Var.a : DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH);
                    x20Var7.g0(t33VarB);
                    obj13 = t33VarB;
                }
                gr2 gr2Var = (gr2) obj13;
                Object objL10 = x20Var7.L();
                Object obj14 = objL10;
                if (objL10 == xyVar) {
                    Object value = gr2Var.getValue();
                    sy2 sy2Var = new sy2();
                    sy2Var.a = z61Var;
                    sy2Var.b = jc0Var2;
                    sy2Var.c = qo0Var;
                    sy2Var.d = yz2Var;
                    sy2Var.e = value;
                    sy2Var.f = xx2.a(yz2Var, jc0Var2, qo0Var, xx2.a, 1);
                    x20Var7.g0(sy2Var);
                    obj14 = sy2Var;
                }
                sy2 sy2Var2 = (sy2) obj14;
                Object value2 = gr2Var.getValue();
                if (z61Var != sy2Var2.a || !g31.a(jc0Var2, sy2Var2.b) || !g31.a(qo0Var, sy2Var2.c) || !g31.a(yz2Var2, sy2Var2.d) || !g31.a(value2, sy2Var2.e)) {
                    sy2Var2.a = z61Var;
                    sy2Var2.b = jc0Var2;
                    sy2Var2.c = qo0Var;
                    sy2Var2.d = yz2Var2;
                    sy2Var2.e = value2;
                    sy2Var2.f = xx2.a(yz2Var2, jc0Var2, qo0Var, xx2.a, 1);
                }
                boolean zH3 = x20Var7.h(sy2Var2);
                Object objL11 = x20Var7.L();
                Object obj15 = objL11;
                if (zH3 || objL11 == xyVar) {
                    xv xvVar = new xv(10, sy2Var2);
                    x20Var7.g0(xvVar);
                    obj15 = xvVar;
                }
                ek1 ek1VarA3 = xz3.a(bk1Var, (wq0) obj15);
                x20Var7.p(false);
                return ek1VarA3;
            default:
                q40 q40Var = (q40) obj3;
                long j2 = ((sy2) obj4).f;
                long j3 = q40Var.a;
                int iJ = q40.j(j3);
                long j4 = q40Var.a;
                zw1 zw1VarE = ((jh1) obj2).e(q40.a(j3, ky3.c((int) (j2 >> 32), iJ, q40.h(j4)), 0, ky3.c((int) (4294967295L & j2), q40.i(j4), q40.g(j4)), 0, 10));
                return ((qh1) obj).j0(zw1VarE.a, zw1VarE.b, ji0.a, new sl0(zw1VarE, 4));
        }
    }

    public /* synthetic */ xv(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
