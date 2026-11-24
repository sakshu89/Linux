package defpackage;

import com.project.sonic.background.SonicVoiceService;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o0 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ o0(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) throws IllegalAccessException, InvocationTargetException {
        int i = 2;
        switch (this.a) {
            case 0:
                ((ol1) this.b).b((a02) this.c);
                return q43.a;
            case 1:
                r2 r2Var = (r2) this.b;
                String str = (String) this.c;
                List list = (List) obj;
                list.getClass();
                r2Var.getClass();
                return Integer.valueOf(r2.m(str, list));
            case 2:
                ck ckVar = (ck) this.b;
                dk dkVar = (dk) this.c;
                q43 q43Var = q43.a;
                n03 n03Var = ckVar.x;
                if (n03Var != null) {
                    n03Var.b();
                }
                ckVar.x = null;
                x00 x00Var = dkVar.b;
                if (x00Var != null) {
                    x00Var.b0(q43Var);
                }
                dkVar.b = null;
                return q43Var;
            case 3:
                na naVar = (na) this.b;
                hn hnVar = (hn) this.c;
                p71 p71Var = (p71) obj;
                p71Var.a();
                rf0.t(p71Var, naVar, hnVar, 0.0f, null, 60);
                return q43.a;
            case 4:
                ts1 ts1Var = (ts1) this.b;
                hn hnVar2 = (hn) this.c;
                p71 p71Var2 = (p71) obj;
                p71Var2.a();
                rf0.t(p71Var2, ts1Var.a, hnVar2, 0.0f, null, 60);
                return q43.a;
            case 5:
                ((tm) this.b).a.k((h50) this.c);
                return q43.a;
            case 6:
                ua1 ua1Var = (ua1) this.b;
                hn hnVar3 = (hn) this.c;
                p71 p71Var3 = (p71) obj;
                p71Var3.a();
                if (((Boolean) ua1Var.s.getValue()).booleanValue() || ((Boolean) ua1Var.t.getValue()).booleanValue()) {
                    rf0.W(p71Var3, hnVar3, 0L, 0L, 0.0f, null, 126);
                }
                return q43.a;
            case 7:
                ((ol1) this.b).b((r21) this.c);
                return q43.a;
            case 8:
                ((tv0) this.b).c.removeCallbacks((o8) this.c);
                return q43.a;
            case 9:
                r42 r42Var = (r42) this.b;
                r42 r42Var2 = (r42) this.c;
                fh1 fh1Var = (fh1) obj;
                if (r42Var.a == -1) {
                    r42Var.a = fh1Var.b().a;
                }
                r42Var2.a = fh1Var.b().b + 1;
                return "";
            case 10:
                s01 s01Var = (s01) this.b;
                q01 q01Var = (q01) this.c;
                s01Var.a.b(q01Var);
                s01Var.b.setValue(Boolean.TRUE);
                return new j8(i, s01Var, q01Var);
            case 11:
                ha1 ha1Var = (ha1) this.b;
                Object obj2 = this.c;
                ha1Var.c.i(obj2);
                return new j8(3, ha1Var, obj2);
            case 12:
                return new ha1((ba2) this.b, (Map) obj, (aa2) this.c);
            case 13:
                np1 np1Var = (np1) this.b;
                zw1 zw1Var = (zw1) this.c;
                yw1 yw1Var = (yw1) obj;
                if (np1Var.H) {
                    yw1.k(yw1Var, zw1Var, yw1Var.R(0.0f), yw1Var.R(np1Var.x));
                } else {
                    yw1.h(yw1Var, zw1Var, yw1Var.R(0.0f), yw1Var.R(np1Var.x));
                }
                return q43.a;
            case 14:
                ot1 ot1Var = (ot1) this.b;
                zw1 zw1Var2 = (zw1) this.c;
                yw1 yw1Var2 = (yw1) obj;
                boolean z = ot1Var.Z;
                float f = ot1Var.x;
                if (z) {
                    yw1.k(yw1Var2, zw1Var2, yw1Var2.R(f), yw1Var2.R(ot1Var.H));
                } else {
                    yw1.h(yw1Var2, zw1Var2, yw1Var2.R(f), yw1Var2.R(ot1Var.H));
                }
                return q43.a;
            case 15:
                g30 g30Var = (g30) this.b;
                hm1 hm1Var = (hm1) this.c;
                g30Var.A(obj);
                if (hm1Var != null) {
                    hm1Var.a(obj);
                }
                return q43.a;
            case 16:
                f42 f42Var = (f42) this.b;
                Throwable th = (Throwable) this.c;
                Throwable th2 = (Throwable) obj;
                synchronized (f42Var.c) {
                    if (th == null) {
                        th = null;
                    } else if (th2 != null) {
                        try {
                            if (th2 instanceof CancellationException) {
                                th2 = null;
                            }
                            if (th2 != null) {
                                gn4.a(th, th2);
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    f42Var.e = th;
                    jr2 jr2Var = f42Var.u;
                    c42 c42Var = c42.a;
                    jr2Var.getClass();
                    jr2Var.j(null, c42Var);
                }
                return q43.a;
            case 17:
                fe2 fe2Var = (fe2) this.b;
                he2 he2Var = (he2) this.c;
                se0 se0Var = (se0) obj;
                float f2 = se0Var.b ? -1.0f : 1.0f;
                long j = se0Var.a;
                fe2Var.a(1, jp1.f(f2, he2Var.d == js1.b ? jp1.a(j, 0.0f, 1) : jp1.a(j, 0.0f, 2)));
                return q43.a;
            case 18:
                SonicVoiceService sonicVoiceService = (SonicVoiceService) this.b;
                o42 o42Var = (o42) this.c;
                e5 e5Var = (e5) obj;
                dt1 dt1VarF = sonicVoiceService.f();
                rn2.a.getClass();
                dt1VarF.d(el1.p(e5Var));
                if (e5Var instanceof z4) {
                    o42Var.a = true;
                    sonicVoiceService.X.c();
                }
                return q43.a;
            case 19:
                fq0 fq0Var = (fq0) this.b;
                fq0 fq0Var2 = (fq0) this.c;
                ox2 ox2Var = (ox2) obj;
                fq0Var.a();
                if (fq0Var2 != null ? ((Boolean) fq0Var2.a()).booleanValue() : true) {
                    ox2Var.close();
                }
                return q43.a;
            case 20:
                uf4.b((s70) this.b, null, new lr2((j23) this.c, null), 1);
                return new ya(2);
            case 21:
                j23 j23Var = (j23) this.b;
                j23 j23Var2 = (j23) this.c;
                j23Var.j.add(j23Var2);
                return new j8(4, j23Var, j23Var2);
            case 22:
                return new j8(5, (j23) this.b, (f23) this.c);
            default:
                i53 i53Var = (i53) this.b;
                hq0 hq0Var = (hq0) this.c;
                ((Long) obj).getClass();
                float f3 = i53Var.e;
                i53Var.e = 0.0f;
                hq0Var.j(Float.valueOf(f3));
                return q43.a;
        }
    }
}
