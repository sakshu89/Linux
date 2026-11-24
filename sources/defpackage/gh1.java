package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class gh1 {
    public static final sr2 a;

    static {
        yp4.b(new e4(27));
        a = new sr2(new e4(28));
    }

    public static final void a(yz yzVar, tk1 tk1Var, ck2 ck2Var, v33 v33Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(904511636);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(yzVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.f(tk1Var) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.f(ck2Var) ? 256 : 128;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i2 |= x20Var.f(v33Var) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= x20Var.h(w10Var) ? 16384 : 8192;
        }
        int i3 = 1;
        if (x20Var.O(i2 & 1, (i2 & 9363) != 9362)) {
            x20Var.T();
            if ((i & 1) != 0 && !x20Var.y()) {
                x20Var.R();
            }
            x20Var.q();
            k82 k82VarA = i82.a();
            long j = yzVar.a;
            boolean zE = x20Var.e(j);
            Object objL = x20Var.L();
            if (zE || objL == r20.a) {
                objL = new sz2(j, sz.b(0.4f, j));
                x20Var.g0(objL);
            }
            kj4.b(new a22[]{a00.a.a(yzVar), a.a(tk1Var), zz0.a.a(k82VarA), dk2.a.a(ck2Var), tz2.a.a((sz2) objL), w33.a.a(v33Var)}, yi4.b(-1750539308, new ho(i3, w10Var, v33Var), x20Var), x20Var, 56);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new hn0(yzVar, tk1Var, ck2Var, v33Var, w10Var, i, 1);
        }
    }

    public static final void b(yz yzVar, ck2 ck2Var, v33 v33Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        yz yzVar2;
        x20 x20Var2;
        w10 w10Var2;
        v33 v33Var2;
        ck2 ck2Var2;
        x20Var.X(-449719819);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(yzVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.f(v33Var) ? 256 : 128;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i2 |= x20Var.h(w10Var) ? 2048 : 1024;
        }
        if (x20Var.O(i2 & 1, (i2 & 1171) != 1170)) {
            x20Var.T();
            if ((i & 1) == 0 || x20Var.y()) {
                ck2Var = (ck2) x20Var.j(dk2.a);
            } else {
                x20Var.R();
            }
            int i3 = i2 & (-113);
            ck2 ck2Var3 = ck2Var;
            x20Var.q();
            int i4 = i3 & 14;
            int i5 = i3 << 3;
            yzVar2 = yzVar;
            x20Var2 = x20Var;
            a(yzVar2, (tk1) x20Var.j(a), ck2Var3, v33Var, w10Var, x20Var2, i4 | (i5 & 7168) | (i5 & 57344));
            v33Var2 = v33Var;
            w10Var2 = w10Var;
            ck2Var2 = ck2Var3;
        } else {
            yzVar2 = yzVar;
            x20Var2 = x20Var;
            w10Var2 = w10Var;
            v33Var2 = v33Var;
            x20Var2.R();
            ck2Var2 = ck2Var;
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new t10(yzVar2, ck2Var2, v33Var2, w10Var2, i);
        }
    }
}
