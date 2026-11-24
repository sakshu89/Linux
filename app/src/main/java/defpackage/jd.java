package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jd extends k61 implements vq0 {
    public static final jd H;
    public static final jd X;
    public static final jd Y;
    public static final jd Z;
    public static final jd c;
    public static final jd c0;
    public static final jd d0;
    public static final jd e;
    public static final jd e0;
    public static final jd f;
    public static final jd f0;
    public static final jd g0;
    public static final jd h0;
    public static final jd i;
    public static final jd i0;
    public static final jd j;
    public static final jd j0;
    public static final jd k;
    public static final jd k0;
    public static final jd l0;
    public static final jd m0;
    public static final jd n;
    public static final jd n0;
    public static final jd s;
    public static final jd t;
    public static final jd u;
    public static final jd v;
    public static final jd w;
    public static final jd x;
    public final /* synthetic */ int b;

    static {
        int i2 = 2;
        c = new jd(i2, 0);
        e = new jd(i2, 1);
        f = new jd(i2, 2);
        i = new jd(i2, 3);
        j = new jd(i2, 4);
        k = new jd(i2, 5);
        n = new jd(i2, 6);
        s = new jd(i2, 7);
        t = new jd(i2, 8);
        u = new jd(i2, 9);
        v = new jd(i2, 10);
        w = new jd(i2, 11);
        x = new jd(i2, 12);
        H = new jd(i2, 13);
        X = new jd(i2, 14);
        Y = new jd(i2, 15);
        Z = new jd(i2, 16);
        c0 = new jd(i2, 17);
        d0 = new jd(i2, 18);
        e0 = new jd(i2, 19);
        f0 = new jd(i2, 20);
        g0 = new jd(i2, 21);
        h0 = new jd(i2, 22);
        i0 = new jd(i2, 23);
        j0 = new jd(i2, 24);
        k0 = new jd(i2, 25);
        l0 = new jd(i2, 26);
        m0 = new jd(i2, 27);
        n0 = new jd(i2, 28);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ jd(int i2, int i3) {
        super(i2);
        this.b = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14, types: [dk1] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [dk1] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v5 */
    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        String str;
        rq0 rq0Var;
        int i2 = this.b;
        q43 q43Var = q43.a;
        switch (i2) {
            case 0:
                si0 si0Var = (si0) obj2;
                return Boolean.valueOf(((si0) obj) == si0Var && si0Var == si0.c);
            case 1:
                String str2 = (String) obj;
                ck1 ck1Var = (ck1) obj2;
                if (str2.length() == 0) {
                    return ck1Var.toString();
                }
                return str2 + ", " + ck1Var;
            case 2:
                x20 x20Var = (x20) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (!x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x20Var.R();
                }
                return q43Var;
            case 3:
                x20 x20Var2 = (x20) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                if (!x20Var2.O(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    x20Var2.R();
                }
                return q43Var;
            case 4:
                x20 x20Var3 = (x20) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                if (!x20Var3.O(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    x20Var3.R();
                }
                return q43Var;
            case 5:
                ((Number) obj2).intValue();
                ((o20) obj).getClass();
                return q43Var;
            case 6:
                ((n71) ((o20) obj)).c0((oh1) obj2);
                return q43Var;
            case 7:
                ((n71) ((o20) obj)).d0((ek1) obj2);
                return q43Var;
            case 8:
                j30 j30Var = (j30) obj2;
                n71 n71Var = (n71) ((o20) obj);
                n71Var.k0 = j30Var;
                zn1 zn1Var = n71Var.o0;
                sr2 sr2Var = l30.h;
                gw1 gw1Var = (gw1) j30Var;
                gw1Var.getClass();
                n71Var.Z((jc0) mj4.a(gw1Var, sr2Var));
                gw1 gw1Var2 = (gw1) j30Var;
                z61 z61Var = (z61) mj4.a(gw1Var2, l30.n);
                if (n71Var.i0 != z61Var) {
                    n71Var.i0 = z61Var;
                    n71Var.E();
                    n71 n71VarU = n71Var.u();
                    if (n71VarU != null) {
                        n71VarU.C();
                    }
                    n71Var.D();
                    for (dk1 dk1Var = zn1Var.f; dk1Var != null; dk1Var = dk1Var.i) {
                        dk1Var.t0();
                    }
                }
                n71Var.e0((w73) mj4.a(gw1Var2, l30.s));
                dk1 dk1Var2 = zn1Var.f;
                if ((dk1Var2.e & 32768) != 0) {
                    while (dk1Var2 != null) {
                        if ((dk1Var2.c & 32768) != 0) {
                            ?? B = dk1Var2;
                            ?? pm1Var = 0;
                            while (B != 0) {
                                if (B instanceof h30) {
                                    dk1 dk1Var3 = ((dk1) ((h30) B)).a;
                                    if (dk1Var3.w) {
                                        do1.c(dk1Var3);
                                    } else {
                                        dk1Var3.s = true;
                                    }
                                } else if ((B.c & 32768) != 0 && (B instanceof zb0)) {
                                    dk1 dk1Var4 = ((zb0) B).H;
                                    int i3 = 0;
                                    B = B;
                                    pm1Var = pm1Var;
                                    while (dk1Var4 != null) {
                                        if ((dk1Var4.c & 32768) != 0) {
                                            i3++;
                                            pm1Var = pm1Var;
                                            if (i3 == 1) {
                                                B = dk1Var4;
                                            } else {
                                                if (pm1Var == 0) {
                                                    pm1Var = new pm1(new dk1[16]);
                                                }
                                                if (B != 0) {
                                                    pm1Var.b(B);
                                                    B = 0;
                                                }
                                                pm1Var.b(dk1Var4);
                                            }
                                        }
                                        dk1Var4 = dk1Var4.i;
                                        B = B;
                                        pm1Var = pm1Var;
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                                B = cm4.b(pm1Var);
                            }
                        }
                        if ((dk1Var2.e & 32768) != 0) {
                            dk1Var2 = dk1Var2.i;
                        }
                    }
                }
                return q43Var;
            case 9:
                Collection collection = (List) obj;
                List list = (List) obj2;
                if (collection == null) {
                    collection = ii0.a;
                }
                return mz.G(collection, list);
            case 10:
                return (r8) obj;
            case 11:
                List list2 = (List) obj;
                List list3 = (List) obj2;
                if (list2 == null) {
                    return list3;
                }
                ArrayList arrayList = new ArrayList(list2);
                arrayList.addAll(list3);
                return arrayList;
            case 12:
                return (n50) obj;
            case 13:
                return (i9) obj;
            case 14:
                return (q43) obj;
            case 15:
                return (q43) obj;
            case 16:
                throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
            case 17:
                return (q43) obj;
            case 18:
                throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
            case 19:
                m82 m82Var = (m82) obj;
                ((m82) obj2).getClass();
                return m82Var;
            case 20:
                return (yj2) obj;
            case 21:
                return (String) obj;
            case 22:
                List list4 = (List) obj;
                List list5 = (List) obj2;
                if (list4 == null) {
                    return list5;
                }
                ArrayList arrayList2 = new ArrayList(list4);
                arrayList2.addAll(list5);
                return arrayList2;
            case 23:
                Float f2 = (Float) obj;
                ((Number) obj2).floatValue();
                return f2;
            case 24:
                return (String) obj;
            case 25:
                Boolean bool = (Boolean) obj;
                ((Boolean) obj2).booleanValue();
                return bool;
            case 26:
                b2 b2Var = (b2) obj;
                b2 b2Var2 = (b2) obj2;
                if (b2Var == null || (str = b2Var.a) == null) {
                    str = b2Var2.a;
                }
                if (b2Var == null || (rq0Var = b2Var.b) == null) {
                    rq0Var = b2Var2.b;
                }
                return new b2(str, rq0Var);
            case 27:
                return obj == null ? obj2 : obj;
            default:
                gg2 gg2Var = (gg2) obj2;
                Object objValueOf = Float.valueOf(0.0f);
                cg2 cg2Var = ((gg2) obj).d;
                ng2 ng2Var = kg2.t;
                Object objG = cg2Var.a.g(ng2Var);
                if (objG == null) {
                    objG = objValueOf;
                }
                float fFloatValue = ((Number) objG).floatValue();
                Object objG2 = gg2Var.d.a.g(ng2Var);
                if (objG2 != null) {
                    objValueOf = objG2;
                }
                return Integer.valueOf(Float.compare(fFloatValue, ((Number) objValueOf).floatValue()));
        }
    }
}
