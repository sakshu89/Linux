package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.CancellationSignal;
import com.ibm.icu.text.ArabicShaping;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h6 extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h6(int i, Object obj) {
        super(1);
        this.b = i;
        this.c = obj;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = 0;
        Object obj2 = null;
        switch (this.b) {
            case 0:
                i6 i6Var = (i6) obj;
                o71 o71Var = (o71) this.c;
                if (i6Var.Y() != Integer.MAX_VALUE) {
                    if (i6Var.d().b) {
                        i6Var.r();
                    }
                    for (Map.Entry entry : i6Var.d().g.entrySet()) {
                        o71.a(o71Var, (d6) entry.getKey(), ((Number) entry.getValue()).intValue(), i6Var.p());
                    }
                    co1 co1Var = i6Var.p().X;
                    co1Var.getClass();
                    while (!co1Var.equals(o71Var.a.p())) {
                        for (d6 d6Var : o71Var.b(co1Var).keySet()) {
                            o71.a(o71Var, d6Var, o71Var.c(co1Var, d6Var), co1Var);
                        }
                        co1Var = co1Var.X;
                        co1Var.getClass();
                    }
                }
                return q43.a;
            case 1:
                return Boolean.valueOf(((ko0) obj).P0(((qn0) this.c).a));
            case 2:
                jf1 jf1Var = (jf1) obj;
                r7 r7Var = ((e7) this.c).H;
                if (r7Var.getInsetsListener().j.g() > 0) {
                    ml1 ml1Var = xb3.a;
                    jf1Var.a = true;
                    mf1 mf1Var = jf1Var.e;
                    y61 y61VarA0 = mf1Var.A0();
                    if (e21.a(jf1Var.b, 9223372034707292159L)) {
                        jf1Var.b = ap4.b(y61VarA0.a(0L));
                        jf1Var.c = y61VarA0.S();
                    }
                    mf1Var.C0().p0.b();
                    long jS = y61VarA0.S();
                    gm1 gm1Var = r7Var.getInsetsListener().i;
                    int i2 = (int) (jS >> 32);
                    int i3 = (int) (jS & 4294967295L);
                    vb3[] vb3VarArr = xb3.b;
                    int length = vb3VarArr.length;
                    int i4 = 0;
                    while (i4 < length) {
                        vb3 vb3Var = vb3VarArr[i4];
                        Object objG = gm1Var.g(vb3Var);
                        objG.getClass();
                        ec3 ec3Var = (ec3) objG;
                        jf1 jf1Var2 = jf1Var;
                        xb3.a(jf1Var2, ((wb3) vb3Var).c, ec3Var.h, i2, i3);
                        if (((Boolean) ec3Var.b.getValue()).booleanValue()) {
                            xb3.a(jf1Var2, ec3Var.f, ec3Var.j, i2, i3);
                            xb3.a(jf1Var2, ec3Var.g, ec3Var.k, i2, i3);
                        }
                        xb3.a(jf1Var2, ((wb3) vb3Var).d, ec3Var.i, i2, i3);
                        i4++;
                        jf1Var = jf1Var2;
                    }
                    jf1 jf1Var3 = jf1Var;
                    yl1 yl1Var = r7Var.getInsetsListener().k;
                    if (yl1Var.i()) {
                        um2 um2Var = r7Var.getInsetsListener().n;
                        Object[] objArr = yl1Var.a;
                        int i5 = yl1Var.b;
                        while (i < i5) {
                            mm1 mm1Var = (mm1) objArr[i];
                            g11 g11Var = (g11) um2Var.get(i);
                            Rect rect = (Rect) mm1Var.getValue();
                            jf1Var3.a(g11Var.b(), rect.left);
                            jf1Var3.a(g11Var.d(), rect.top);
                            jf1Var3.a(g11Var.c(), rect.right);
                            jf1Var3.a(g11Var.a(), rect.bottom);
                            i++;
                        }
                    }
                }
                return q43.a;
            case 3:
                return Boolean.valueOf(((c21) this.c).a(((gg2) obj).g));
            case 4:
                return Boolean.valueOf(pc4.b((gg2) obj, (Resources) this.c));
            case 5:
                return new g8(i, (sd0) this.c);
            case 6:
                p71 p71Var = (p71) obj;
                ((cp2) this.c).j(p71Var);
                p71Var.a();
                return q43.a;
            case 7:
                ud udVar = (ud) obj;
                float f = udVar.b;
                if (f < 0.0f) {
                    f = 0.0f;
                }
                if (f > 1.0f) {
                    f = 1.0f;
                }
                float f2 = udVar.c;
                if (f2 < -0.5f) {
                    f2 = -0.5f;
                }
                if (f2 > 0.5f) {
                    f2 = 0.5f;
                }
                float f3 = udVar.d;
                float f4 = f3 >= -0.5f ? f3 : -0.5f;
                float f5 = f4 <= 0.5f ? f4 : 0.5f;
                float f6 = udVar.a;
                float f7 = f6 >= 0.0f ? f6 : 0.0f;
                return new sz(sz.a(ki4.a(f, f2, f5, f7 <= 1.0f ? f7 : 1.0f, d00.x), (b00) this.c));
            case 8:
                if (((Throwable) obj) != null) {
                    ((CancellationSignal) this.c).cancel();
                }
                return q43.a;
            case 9:
                Throwable th = (Throwable) obj;
                w90 w90Var = (w90) this.c;
                if (th != null) {
                    w90Var.k.K(new wl0(th));
                }
                if (w90Var.s.b != fl4.n) {
                    ((nl0) w90Var.s.getValue()).close();
                }
                return q43.a;
            case 10:
                s23 s23Var = s23.a;
                le0 le0Var = (le0) obj;
                if (!le0Var.a.w) {
                    return s23.b;
                }
                le0 le0Var2 = le0Var.H;
                if (le0Var2 != null) {
                    h6 h6Var = new h6(10, (q82) this.c);
                    if (h6Var.j(le0Var2) == s23Var) {
                        jd4.e(le0Var2, h6Var);
                    }
                }
                le0Var.H = null;
                le0Var.x = null;
                return s23Var;
            case 11:
                g23 g23Var = (g23) obj;
                bj0 bj0Var = (bj0) this.c;
                si0 si0Var = si0.a;
                si0 si0Var2 = si0.b;
                if (g23Var.a(si0Var, si0Var2)) {
                    zw zwVar = bj0Var.Y.a.b;
                    if (zwVar != null) {
                        obj2 = zwVar.c;
                    }
                } else if (g23Var.a(si0Var2, si0.c)) {
                    zw zwVar2 = bj0Var.Z.a.b;
                    if (zwVar2 != null) {
                        obj2 = zwVar2.c;
                    }
                } else {
                    obj2 = yi0.c;
                }
                return obj2 == null ? yi0.c : obj2;
            case 12:
                q43 q43Var = q43.a;
                if (iu0.b.compareAndSet(false, true)) {
                    ((un) this.c).s(q43Var);
                }
                return q43Var;
            case 13:
                rf0 rf0Var = (rf0) obj;
                vu0 vu0Var = (vu0) this.c;
                na naVar = vu0Var.l;
                if (vu0Var.n && vu0Var.w && naVar != null) {
                    kf kfVarC = rf0Var.C();
                    long jR = kfVarC.r();
                    kfVarC.m().m();
                    try {
                        ((kf) ((q82) kfVarC.b).a).m().t(naVar);
                        vu0Var.c(rf0Var);
                    } finally {
                        cq.t(kfVarC, jR);
                    }
                } else {
                    vu0Var.c(rf0Var);
                }
                return q43.a;
            case 14:
                rf0 rf0Var2 = (rf0) obj;
                yu0 yu0Var = (yu0) this.c;
                cw cwVarM = rf0Var2.C().m();
                vq0 vq0Var = yu0Var.e;
                if (vq0Var != null) {
                    vq0Var.e(cwVarM, (vu0) rf0Var2.C().c);
                }
                return q43.a;
            case 15:
                d63 d63Var = (d63) obj;
                kv0 kv0Var = (kv0) this.c;
                kv0Var.g(d63Var);
                hq0 hq0Var = kv0Var.i;
                if (hq0Var != null) {
                    hq0Var.j(d63Var);
                }
                return q43.a;
            case 16:
                to1 to1Var = (to1) obj;
                i42 i42Var = to1Var.b;
                if (i42Var != null) {
                    i42Var.closeConnection();
                    to1Var.b = null;
                }
                m11 m11Var = (m11) this.c;
                pm1 pm1Var = m11Var.d;
                Object[] objArr2 = pm1Var.a;
                int i6 = pm1Var.c;
                while (true) {
                    if (i >= i6) {
                        i = -1;
                    } else if (!g31.a((m93) objArr2[i], to1Var)) {
                        i++;
                    }
                }
                if (i >= 0) {
                    pm1Var.l(i);
                }
                if (pm1Var.c == 0) {
                    m11Var.b.a();
                }
                return q43.a;
            case 17:
                ((pm1) this.c).b((ck1) obj);
                return Boolean.TRUE;
            case 18:
                ov ovVar = (ov) obj;
                y02 y02Var = y02.g;
                ovVar.getClass();
                y02Var.d = ovVar;
                Context contextA = el4.a((Context) this.c);
                contextA.getClass();
                y02Var.e = contextA;
                return y02Var;
            case 19:
                return ((ov) this.c).j;
            case 20:
                mg2.b((og2) obj, (String) this.c);
                return q43.a;
            case 21:
                ((List) obj).add((Float) ((m91) this.c).a());
                return true;
            case 22:
                r72 r72Var = (r72) obj;
                wj2 wj2Var = (wj2) this.c;
                r72Var.k(r72Var.v.b() * 3.0f);
                r72Var.m(wj2Var.a);
                r72Var.f(wj2Var.b);
                r72Var.e(wj2Var.c);
                r72Var.n(wj2Var.d);
                return q43.a;
            case 23:
                r72 r72Var2 = (r72) obj;
                qk2 qk2Var = (qk2) this.c;
                r72Var2.h(qk2Var.x);
                r72Var2.i(qk2Var.H);
                r72Var2.d(qk2Var.X);
                r72Var2.k(qk2Var.Y);
                float f8 = qk2Var.Z;
                if (r72Var2.k != f8) {
                    r72Var2.a |= 2048;
                    r72Var2.k = f8;
                }
                r72Var2.o(qk2Var.c0);
                r72Var2.m(qk2Var.d0);
                r72Var2.f(qk2Var.e0);
                r72Var2.e(qk2Var.f0);
                r72Var2.n(qk2Var.g0);
                int i7 = qk2Var.h0;
                if (r72Var2.x != i7) {
                    r72Var2.a |= ArabicShaping.TASHKEEL_RESIZE;
                    r72Var2.x = i7;
                }
                return q43.a;
            default:
                Throwable th2 = (Throwable) obj;
                su2 su2Var = (su2) this.c;
                yv yvVar = su2Var.c;
                if (yvVar != null) {
                    yvVar.m(th2);
                }
                su2Var.c = null;
                return q43.a;
        }
    }
}
