package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class vn4 {
    public static final void a(ek1 ek1Var, final dg dgVar, final fg fgVar, kl klVar, int i, int i2, final w10 w10Var, x20 x20Var, final int i3) {
        final ek1 ek1Var2;
        final kl klVar2;
        final int i4;
        final int i5;
        x20Var.X(-1303174015);
        int i6 = i3 | 224262;
        if (x20Var.O(i6 & 1, (599187 & i6) != 599186)) {
            kl klVar3 = xy.t;
            su0 su0Var = su0.f;
            bk1 bk1Var = bk1.a;
            b(bk1Var, dgVar, fgVar, su0Var, w10Var, x20Var, 14380470);
            ek1Var2 = bk1Var;
            i4 = Integer.MAX_VALUE;
            i5 = Integer.MAX_VALUE;
            klVar2 = klVar3;
        } else {
            x20Var.R();
            ek1Var2 = ek1Var;
            klVar2 = klVar;
            i4 = i;
            i5 = i2;
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0(dgVar, fgVar, klVar2, i4, i5, w10Var, i3) { // from class: fn0
                public final /* synthetic */ dg b;
                public final /* synthetic */ fg c;
                public final /* synthetic */ kl e;
                public final /* synthetic */ int f;
                public final /* synthetic */ int i;
                public final /* synthetic */ w10 j;

                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iC = ny3.c(1573297);
                    vn4.a(this.a, this.b, this.c, this.e, this.f, this.i, this.j, (x20) obj, iC);
                    return q43.a;
                }
            };
        }
    }

    public static final void b(ek1 ek1Var, dg dgVar, fg fgVar, su0 su0Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        Object obj;
        boolean z;
        Object obj2;
        Object obj3 = xy.t;
        x20Var.X(-1956591841);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.f(dgVar) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.f(fgVar) ? 256 : 128;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i2 |= x20Var.f(obj3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= x20Var.d(Integer.MAX_VALUE) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= x20Var.d(Integer.MAX_VALUE) ? Normalizer.INPUT_IS_FCD : 65536;
        }
        if ((1572864 & i) == 0) {
            obj = su0Var;
            i2 |= x20Var.f(obj) ? 1048576 : ArabicShaping.TASHKEEL_RESIZE;
        } else {
            obj = su0Var;
        }
        if ((i & 12582912) == 0) {
            i2 |= x20Var.h(w10Var) ? 8388608 : 4194304;
        }
        int i3 = i2;
        if (x20Var.O(i3 & 1, (i3 & 4793491) != 4793490)) {
            int i4 = i3 & 3670016;
            boolean z2 = i4 == 1048576;
            Object objL = x20Var.L();
            Object obj4 = r20.a;
            if (z2 || objL == obj4) {
                obj.getClass();
                objL = new kn0();
                x20Var.g0(objL);
            }
            kn0 kn0Var = (kn0) objL;
            int i5 = i3 >> 3;
            boolean zF = ((((i5 & 896) ^ CollationFastLatin.LATIN_LIMIT) > 256 && x20Var.f(obj3)) || (i5 & CollationFastLatin.LATIN_LIMIT) == 256) | ((((i5 & 14) ^ 6) > 4 && x20Var.f(dgVar)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && x20Var.f(fgVar)) || (i5 & 48) == 32) | ((((i5 & 7168) ^ UCharacterProperty.SCRIPT_X_WITH_OTHER) > 2048 && x20Var.d(Integer.MAX_VALUE)) || (i5 & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 2048) | ((((57344 & i5) ^ 24576) > 16384 && x20Var.d(Integer.MAX_VALUE)) || (i5 & 24576) == 16384) | x20Var.f(kn0Var);
            Object objL2 = x20Var.L();
            if (zF || objL2 == obj4) {
                Object mn0Var = new mn0(dgVar, fgVar, dgVar.a(), new c80(), fgVar.a(), kn0Var);
                x20Var.g0(mn0Var);
                objL2 = mn0Var;
            }
            mn0 mn0Var2 = (mn0) objL2;
            boolean z3 = (i4 == 1048576) | ((i3 & 29360128) == 8388608) | ((i3 & 458752) == 131072);
            Object objL3 = x20Var.L();
            if (z3 || objL3 == obj4) {
                ArrayList arrayList = new ArrayList();
                z = true;
                arrayList.add(new w10(-1192950673, true, new gn0(w10Var)));
                su0Var.getClass();
                x20Var.g0(arrayList);
                obj2 = arrayList;
            } else {
                z = true;
                obj2 = objL3;
            }
            w10 w10Var2 = new w10(1271844412, z, new z0(3, (List) obj2));
            boolean zF2 = x20Var.f(mn0Var2);
            Object objL4 = x20Var.L();
            if (zF2 || objL4 == obj4) {
                objL4 = new cl1(mn0Var2);
                x20Var.g0(objL4);
            }
            oh1 oh1Var = (oh1) objL4;
            int iHashCode = Long.hashCode(x20Var.T);
            gw1 gw1VarL = x20Var.l();
            ek1 ek1VarC = gj4.c(x20Var, ek1Var);
            o20.p.getClass();
            fq0 fq0Var = n20.b;
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(fq0Var);
            } else {
                x20Var.j0();
            }
            ie4.c(x20Var, n20.f, oh1Var);
            ie4.c(x20Var, n20.e, gw1VarL);
            ie4.a(x20Var, Integer.valueOf(iHashCode), n20.g);
            ie4.b(x20Var, n20.h);
            ie4.c(x20Var, n20.d, ek1VarC);
            w10Var2.e(x20Var, 0);
            x20Var.p(true);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new hn0(ek1Var, dgVar, fgVar, su0Var, w10Var, i, 0);
        }
    }

    public static final void c(jh1 jh1Var, mn0 mn0Var, long j, hq0 hq0Var) {
        if (fz3.b(fz3.a(jh1Var)) != 0.0f) {
            mn0Var.getClass();
            jh1Var.e0(jh1Var.V(Integer.MAX_VALUE));
            return;
        }
        fz3.a(jh1Var);
        zw1 zw1VarE = jh1Var.e(j);
        hq0Var.j(zw1VarE);
        mn0Var.getClass();
        zw1VarE.i0();
        zw1VarE.h0();
    }
}
