package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class cj4 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [ov3, y22] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [j6] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Integer] */
    public static final List a(rl2 rl2Var, Integer num, int i, Integer num2) {
        int iE;
        int iS;
        yl1 yl1Var;
        if (rl2Var.w || rl2Var.p() == 0) {
            return ii0.a;
        }
        ?? y22Var = new y22(rl2Var);
        if (num2 != null) {
            iE = num2.intValue();
        } else {
            iE = rl2Var.v;
            if (iE < 0) {
                iE = rl2Var.E(i, rl2Var.b);
            }
        }
        if (num == 0) {
            int iN = rl2Var.i - rl2Var.N(rl2Var.r(i), rl2Var.b);
            ml1 ml1Var = rl2Var.s;
            num = Integer.valueOf(iN + ((ml1Var == null || (yl1Var = (yl1) ml1Var.b(i)) == null) ? 0 : yl1Var.b));
        }
        int iR = rl2Var.r(i) * 5;
        int[] iArr = rl2Var.b;
        if (iR < iArr.length) {
            iS = rl2Var.s(i);
        } else {
            int iE2 = iE >= 0 ? rl2Var.E(iE, iArr) : iE;
            iS = rl2Var.s(iE);
            int i2 = iE;
            iE = iE2;
            i = i2;
        }
        while (i >= 0) {
            y22Var.e(iS, (rl2Var.b[(rl2Var.r(i) * 5) + 1] & 536870912) != 0 ? rl2Var.t(i) : r20.a, rl2Var.O(i), num);
            num = rl2Var.b(i);
            if (iE >= 0) {
                int iE3 = rl2Var.E(iE, rl2Var.b);
                iS = rl2Var.s(iE);
                int i3 = iE;
                iE = iE3;
                i = i3;
            } else {
                i = iE;
            }
        }
        return (ArrayList) y22Var.a;
    }

    public static final Integer b(nl2 nl2Var, a30 a30Var, int i, int i2) {
        Integer numB;
        int[] iArr = nl2Var.b;
        while (true) {
            if (i >= i2) {
                return null;
            }
            int i3 = iArr[(i * 5) + 3] + i;
            if (nl2Var.j(i) && nl2Var.i(i) == 206 && g31.a(nl2Var.p(i, iArr), y20.e)) {
                Object objH = nl2Var.h(i, 0);
                k52 k52Var = objH instanceof k52 ? (k52) objH : null;
                j52 j52Var = k52Var != null ? k52Var.a : null;
                u20 u20Var = j52Var instanceof u20 ? (u20) j52Var : null;
                if (u20Var != null && u20Var.a == a30Var) {
                    return Integer.valueOf(i);
                }
            }
            if (nl2Var.d(i) && (numB = b(nl2Var, a30Var, i + 1, i3)) != null) {
                return Integer.valueOf(numB.intValue());
            }
            i = i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [ov3, y22] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    public static final ArrayList c(nl2 nl2Var, int i, Integer num) {
        ?? y22Var = new y22(nl2Var);
        i = nl2Var.q(i);
        j6 j6VarA = nl2Var.a(i);
        while (i >= 0) {
            y22Var.e(nl2Var.i(i), nl2Var.k(i) ? nl2Var.p(i, nl2Var.b) : r20.a, nl2Var.a.h(i), num);
            if (i >= 0) {
                j6 j6Var = j6VarA;
                j6VarA = nl2Var.a(i);
                i = nl2Var.q(i);
                num = j6Var;
            } else {
                num = j6VarA;
            }
        }
        return (ArrayList) y22Var.a;
    }
}
