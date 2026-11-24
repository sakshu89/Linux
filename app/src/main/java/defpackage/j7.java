package defpackage;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j7 extends k61 implements hq0 {
    public static final j7 H;
    public static final j7 X;
    public static final j7 Y;
    public static final j7 Z;
    public static final j7 c;
    public static final j7 c0;
    public static final j7 d0;
    public static final j7 e;
    public static final j7 e0;
    public static final j7 f;
    public static final j7 f0;
    public static final j7 g0;
    public static final j7 h0;
    public static final j7 i;
    public static final j7 i0;
    public static final j7 j;
    public static final j7 j0;
    public static final j7 k;
    public static final j7 k0;
    public static final j7 l0;
    public static final j7 m0;
    public static final j7 n;
    public static final j7 n0;
    public static final j7 o0;
    public static final j7 s;
    public static final j7 t;
    public static final j7 u;
    public static final j7 v;
    public static final j7 w;
    public static final j7 x;
    public final /* synthetic */ int b;

    static {
        int i2 = 1;
        c = new j7(i2, 0);
        e = new j7(i2, 1);
        f = new j7(i2, 2);
        i = new j7(i2, 3);
        j = new j7(i2, 4);
        k = new j7(i2, 5);
        n = new j7(i2, 6);
        s = new j7(i2, 7);
        t = new j7(i2, 8);
        u = new j7(i2, 9);
        v = new j7(i2, 10);
        w = new j7(i2, 11);
        x = new j7(i2, 12);
        H = new j7(i2, 13);
        X = new j7(i2, 14);
        Y = new j7(i2, 15);
        Z = new j7(i2, 16);
        c0 = new j7(i2, 17);
        d0 = new j7(i2, 18);
        e0 = new j7(i2, 19);
        f0 = new j7(i2, 20);
        g0 = new j7(i2, 21);
        h0 = new j7(i2, 22);
        i0 = new j7(i2, 23);
        j0 = new j7(i2, 24);
        k0 = new j7(i2, 25);
        l0 = new j7(i2, 26);
        m0 = new j7(i2, 27);
        n0 = new j7(i2, 28);
        o0 = new j7(i2, 29);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j7(int i2, int i3) {
        super(i2);
        this.b = i3;
    }

    /* JADX WARN: Code duplicated, block: B:117:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00ec A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00ee A[LOOP:0: B:43:0x00b7->B:53:0x00ee, LOOP_END] */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i2 = this.b;
        q43 q43Var = q43.a;
        switch (i2) {
            case 0:
                return Boolean.TRUE;
            case 1:
                return Boolean.valueOf(((gg2) obj).k().a.c(kg2.z));
            case 2:
                gw1 gw1Var = (gw1) obj;
                m30 m30Var = AndroidCompositionLocals_androidKt.a;
                gw1Var.getClass();
                mj4.a(gw1Var, m30Var);
                return ((Context) mj4.a(gw1Var, AndroidCompositionLocals_androidKt.b)).getResources();
            case 3:
                return Boolean.valueOf(((gg2) obj).k().a.c(kg2.z));
            case 4:
                ((Number) obj).longValue();
                return q43Var;
            case 5:
                return q43Var;
            case 6:
                c51[] c51VarArr = mg2.a;
                ((og2) obj).a(kg2.w, q43Var);
                return q43Var;
            case 7:
                return q43Var;
            case 8:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 9:
                long jA = sz.a(((sz) obj).a, d00.x);
                return new ud(sz.d(jA), sz.h(jA), sz.g(jA), sz.e(jA));
            case 10:
                ((Number) obj).longValue();
                return q43Var;
            case 11:
                o20 o20Var = (o20) obj;
                n71 n71Var = o20Var instanceof n71 ? (n71) o20Var : null;
                if (n71Var == null || !n71Var.x0) {
                    return q43Var;
                }
                dk0.q(o20Var, "Apply is called on deactivated node ");
                return null;
            case 12:
                return Boolean.valueOf(!(((ck1) obj) instanceof q20));
            case 13:
                float[] fArr = ((ih1) obj).a;
                return q43Var;
            case 14:
                float[] fArr2 = ((ih1) obj).a;
                return q43Var;
            case 15:
                return Boolean.valueOf(ty3.b(obj));
            case 16:
                ((Number) obj).intValue();
                return 0;
            case 17:
                ((Number) obj).intValue();
                return 0;
            case 18:
                return yi0.b;
            case 19:
                File file = (File) obj;
                file.getClass();
                String absolutePath = file.getCanonicalFile().getAbsolutePath();
                absolutePath.getClass();
                return new uk2(absolutePath);
            case 20:
                return q43Var;
            case 21:
                return q43Var;
            case 22:
                return q43Var;
            case 23:
                rf0.E((rf0) obj, sz.f, 0L, 126);
                return q43Var;
            case 24:
                bx1 bx1Var = (bx1) obj;
                if (bx1Var.y()) {
                    mf1 mf1Var = bx1Var.b;
                    if (!mf1Var.t) {
                        hq0 hq0VarE = bx1Var.a.e();
                        gm1 gm1Var = mf1Var.w;
                        if (hq0VarE != null) {
                            mf1Var.w0(bx1Var, 9223372034707292159L, 0L);
                            mf1Var.j = hq0VarE;
                        } else if (gm1Var != null) {
                            Object[] objArr = gm1Var.c;
                            long[] jArr = gm1Var.a;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i3 = 0;
                                while (true) {
                                    long j2 = jArr[i3];
                                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i4 = 8 - ((~(i3 - length)) >>> 31);
                                        for (int i5 = 0; i5 < i4; i5++) {
                                            if ((255 & j2) < 128) {
                                                mf1Var.I0((hm1) objArr[(i3 << 3) + i5]);
                                            }
                                            j2 >>= 8;
                                        }
                                        if (i4 == 8) {
                                            if (i3 != length) {
                                                i3++;
                                            }
                                        }
                                    } else if (i3 != length) {
                                        i3++;
                                    }
                                }
                            }
                            gm1Var.a();
                        }
                    }
                }
                return q43Var;
            case 25:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                Object value = entry.getValue();
                return "  " + ((iz1) entry.getKey()).a + " = " + (value instanceof byte[] ? qg.r((byte[]) value, ", ", null, 56) : String.valueOf(entry.getValue()));
            case 26:
                ht1 ht1Var = ((co1) obj).u0;
                if (ht1Var != null) {
                    ((yu0) ht1Var).c();
                }
                return q43Var;
            case 27:
                co1 co1Var = (co1) obj;
                n71 n71Var2 = co1Var.x;
                try {
                    if (co1Var.y()) {
                        co1Var.u1(true);
                        break;
                    }
                    return q43Var;
                } catch (Throwable th) {
                    n71Var2.Y(th);
                    throw null;
                }
            case 28:
                fp1 fp1Var = (fp1) obj;
                if (fp1Var.y()) {
                    fp1Var.a.J();
                }
                return q43Var;
            default:
                n71 n71Var3 = (n71) obj;
                if (n71Var3.H()) {
                    n71Var3.U(false);
                }
                return q43Var;
        }
    }
}
