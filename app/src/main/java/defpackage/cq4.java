package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class cq4 {
    public static final void a(final Object obj, final int i, final c91 c91Var, final w10 w10Var, x20 x20Var, final int i2) {
        int i3;
        x20Var.X(872548579);
        if ((i2 & 6) == 0) {
            i3 = (x20Var.h(obj) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= x20Var.d(i) ? 32 : 16;
        }
        if ((i2 & CollationFastLatin.LATIN_LIMIT) == 0) {
            i3 |= x20Var.h(c91Var) ? 256 : 128;
        }
        if ((i2 & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i3 |= x20Var.h(w10Var) ? 2048 : 1024;
        }
        if (x20Var.O(i3 & 1, (i3 & 1171) != 1170)) {
            boolean zF = x20Var.f(obj) | x20Var.f(c91Var);
            Object objL = x20Var.L();
            Object obj2 = r20.a;
            if (zF || objL == obj2) {
                objL = new a91(obj, c91Var);
                x20Var.g0(objL);
            }
            a91 a91Var = (a91) objL;
            a91Var.c = i;
            ku1 ku1Var = a91Var.g;
            z12 z12Var = xw1.a;
            a91 a91Var2 = (a91) x20Var.j(z12Var);
            bm2 bm2VarA = i44.a();
            hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
            bm2 bm2VarB = i44.b(bm2VarA);
            try {
                if (a91Var2 != ((a91) ku1Var.getValue())) {
                    ku1Var.setValue(a91Var2);
                    if (a91Var.d > 0) {
                        a91 a91Var3 = a91Var.e;
                        if (a91Var3 != null) {
                            a91Var3.b();
                        }
                        if (a91Var2 != null) {
                            a91Var2.a();
                        } else {
                            a91Var2 = null;
                        }
                        a91Var.e = a91Var2;
                    }
                }
                i44.e(bm2VarA, bm2VarB, hq0VarE);
                boolean zF2 = x20Var.f(a91Var);
                Object objL2 = x20Var.L();
                if (zF2 || objL2 == obj2) {
                    objL2 = new x0(15, a91Var);
                    x20Var.g0(objL2);
                }
                bz3.a(a91Var, (hq0) objL2, x20Var);
                kj4.a(z12Var.a(a91Var), w10Var, x20Var, ((i3 >> 6) & 112) | 8);
            } catch (Throwable th) {
                i44.e(bm2VarA, bm2VarB, hq0VarE);
                throw th;
            }
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0() { // from class: b91
                @Override // defpackage.vq0
                public final Object e(Object obj3, Object obj4) {
                    ((Integer) obj4).getClass();
                    cq4.a(obj, i, c91Var, w10Var, (x20) obj3, ny3.c(i2 | 1));
                    return q43.a;
                }
            };
        }
    }
}
