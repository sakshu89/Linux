package defpackage;

import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zk {
    public static final /* synthetic */ int a = 0;

    static {
        im4.a(40.0f, 40.0f);
    }

    public static final void a(final String str, final hq0 hq0Var, final ek1 ek1Var, boolean z, final yz2 yz2Var, final u51 u51Var, t51 t51Var, final boolean z2, int i, int i2, final q83 q83Var, hq0 hq0Var2, final cn2 cn2Var, final w10 w10Var, x20 x20Var, final int i3) {
        final boolean z3;
        final t51 t51Var2;
        final int i4;
        final int i5;
        final hq0 hq0Var3;
        hq0 hq0Var4;
        int i6;
        boolean z4;
        int i7;
        int i8;
        t51 t51Var3;
        x20Var.X(2026950908);
        int i9 = i3 | (x20Var.f(str) ? 4 : 2) | 27648 | (x20Var.f(yz2Var) ? Normalizer.INPUT_IS_FCD : 65536) | (x20Var.f(u51Var) ? 1048576 : ArabicShaping.TASHKEEL_RESIZE) | 281018368;
        int i10 = (x20Var.f(q83Var) ? 32 : 16) | 224646;
        if (x20Var.O(i9 & 1, ((306783379 & i9) == 306783378 && (74899 & i10) == 74898) ? false : true)) {
            x20Var.T();
            int i11 = i3 & 1;
            Object obj = r20.a;
            if (i11 == 0 || x20Var.y()) {
                int i12 = z2 ? 1 : Integer.MAX_VALUE;
                int i13 = i9 & (-1879048193);
                Object objL = x20Var.L();
                if (objL == obj) {
                    objL = new j(5);
                    x20Var.g0(objL);
                }
                hq0Var4 = (hq0) objL;
                i6 = i12;
                z4 = true;
                i7 = 1;
                i8 = i13;
                t51Var3 = t51.a;
            } else {
                x20Var.R();
                z4 = z;
                i6 = i;
                i7 = i2;
                hq0Var4 = hq0Var2;
                i8 = i9 & (-1879048193);
                t51Var3 = t51Var;
            }
            x20Var.q();
            Object objL2 = x20Var.L();
            if (objL2 == obj) {
                objL2 = o44.g(new ty2(6, 0L, str));
                x20Var.g0(objL2);
            }
            mm1 mm1Var = (mm1) objL2;
            ty2 ty2Var = (ty2) mm1Var.getValue();
            int i14 = i8;
            ty2 ty2Var2 = new ty2(new be(str), ty2Var.b, ty2Var.c);
            boolean zF = x20Var.f(ty2Var2);
            Object objL3 = x20Var.L();
            int i15 = 3;
            if (zF || objL3 == obj) {
                objL3 = new zb(i15, ty2Var2, mm1Var);
                x20Var.g0(objL3);
            }
            bz3.d((fq0) objL3, x20Var);
            boolean z5 = (i14 & 14) == 4;
            Object objL4 = x20Var.L();
            if (z5 || objL4 == obj) {
                objL4 = o44.g(str);
                x20Var.g0(objL4);
            }
            Object obj2 = (mm1) objL4;
            Boolean bool = u51Var.a;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
            int i16 = u51Var.b;
            v51 v51Var = new v51(i16);
            if (i16 == 0) {
                v51Var = null;
            }
            int i17 = v51Var != null ? v51Var.a : 1;
            int i18 = u51Var.c;
            jz0 jz0Var = new jz0(i18);
            if (i18 == -1) {
                jz0Var = null;
            }
            int i19 = i17;
            int i20 = 3;
            kz0 kz0Var = new kz0(z2, 0, zBooleanValue, i19, jz0Var != null ? jz0Var.a : 1, ne1.c);
            boolean z6 = !z2;
            int i21 = z2 ? 1 : i7;
            int i22 = z2 ? 1 : i6;
            boolean zF2 = x20Var.f(obj2);
            Object objL5 = x20Var.L();
            if (zF2 || objL5 == obj) {
                objL5 = new e2(hq0Var, mm1Var, obj2, i20);
                x20Var.g0(objL5);
            }
            hq0Var3 = hq0Var4;
            t51 t51Var4 = t51Var3;
            hl4.a(ty2Var2, (hq0) objL5, ek1Var, yz2Var, q83Var, hq0Var3, cn2Var, z6, i22, i21, kz0Var, t51Var4, z4, w10Var, x20Var, ((i14 >> 6) & 7168) | CollationFastLatin.LATIN_LIMIT | ((i10 << 9) & 57344) | 14352384, 224640);
            t51Var2 = t51Var4;
            z3 = z4;
            i4 = i6;
            i5 = i7;
        } else {
            x20Var.R();
            z3 = z;
            t51Var2 = t51Var;
            i4 = i;
            i5 = i2;
            hq0Var3 = hq0Var2;
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0(str, hq0Var, ek1Var, z3, yz2Var, u51Var, t51Var2, z2, i4, i5, q83Var, hq0Var3, cn2Var, w10Var, i3) { // from class: yk
                public final /* synthetic */ String a;
                public final /* synthetic */ hq0 b;
                public final /* synthetic */ ek1 c;
                public final /* synthetic */ boolean e;
                public final /* synthetic */ yz2 f;
                public final /* synthetic */ u51 i;
                public final /* synthetic */ t51 j;
                public final /* synthetic */ boolean k;
                public final /* synthetic */ int n;
                public final /* synthetic */ int s;
                public final /* synthetic */ q83 t;
                public final /* synthetic */ hq0 u;
                public final /* synthetic */ cn2 v;
                public final /* synthetic */ w10 w;

                @Override // defpackage.vq0
                public final Object e(Object obj3, Object obj4) {
                    ((Integer) obj4).getClass();
                    int iC = ny3.c(100663729);
                    zk.a(this.a, this.b, this.c, this.e, this.f, this.i, this.j, this.k, this.n, this.s, this.t, this.u, this.v, this.w, (x20) obj3, iC);
                    return q43.a;
                }
            };
        }
    }
}
