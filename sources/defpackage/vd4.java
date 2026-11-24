package defpackage;

import android.graphics.Bitmap;
import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.text.ArabicShaping;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class vd4 {
    public static final void a(op1 op1Var, c6 c6Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(-1090171650);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? x20Var.f(op1Var) : x20Var.h(op1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.f(c6Var) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.h(w10Var) ? 256 : 128;
        }
        boolean z = true;
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            boolean z2 = (i2 & 112) == 32;
            if ((i2 & 14) != 4 && ((i2 & 8) == 0 || !x20Var.f(op1Var))) {
                z = false;
            }
            boolean z3 = z2 | z;
            Object objL = x20Var.L();
            if (z3 || objL == r20.a) {
                objL = new qv0(c6Var, op1Var);
                x20Var.g0(objL);
            }
            fb.a((qv0) objL, null, new bz1(false, xe2.a, false), w10Var, x20Var, ((i2 << 3) & 7168) | CollationFastLatin.LATIN_LIMIT, 2);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new mb(op1Var, c6Var, w10Var, i, 0);
        }
    }

    public static final void b(final op1 op1Var, final boolean z, final p62 p62Var, final boolean z2, long j, final float f, final ek1 ek1Var, x20 x20Var, final int i) {
        int i2;
        final long j2;
        int i3;
        long j3;
        final boolean z3;
        x20Var.X(-466280168);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? x20Var.f(op1Var) : x20Var.h(op1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.g(z) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.d(p62Var.ordinal()) ? 256 : 128;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i2 |= x20Var.g(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= 8192;
        }
        if ((1572864 & i) == 0) {
            i2 |= x20Var.f(ek1Var) ? 1048576 : ArabicShaping.TASHKEEL_RESIZE;
        }
        if (x20Var.O(i2 & 1, (533651 & i2) != 533650)) {
            x20Var.T();
            if ((i & 1) == 0 || x20Var.y()) {
                i3 = i2 & (-57345);
                j3 = 9205357640488583168L;
            } else {
                x20Var.R();
                i3 = i2 & (-57345);
                j3 = j;
            }
            x20Var.q();
            p62 p62Var2 = p62.b;
            p62 p62Var3 = p62.a;
            if (z) {
                ng2 ng2Var = wf2.a;
                z3 = (p62Var == p62Var3 && !z2) || (p62Var == p62Var2 && z2);
            } else {
                ng2 ng2Var2 = wf2.a;
                z3 = (p62Var != p62Var3 || z2) && !(p62Var == p62Var2 && z2);
            }
            il ilVar = z3 ? zl.b : zl.a;
            int i4 = i3 & 14;
            boolean zG = (i4 == 4 || ((i3 & 8) != 0 && x20Var.h(op1Var))) | ((i3 & 112) == 32) | x20Var.g(z3);
            Object objL = x20Var.L();
            if (zG || objL == r20.a) {
                objL = new ob(op1Var, z, z3);
                x20Var.g0(objL);
            }
            final ek1 ek1VarA = dg2.a(ek1Var, (hq0) objL);
            final w73 w73Var = (w73) x20Var.j(l30.s);
            long j4 = j3;
            il ilVar2 = ilVar;
            j2 = j4;
            a(op1Var, ilVar2, yi4.b(1365123137, new vq0() { // from class: pb
                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    x20 x20Var2 = (x20) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    if (x20Var2.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                        a22 a22VarA = l30.s.a(w73Var);
                        final long j5 = j2;
                        final boolean z4 = z3;
                        final ek1 ek1Var2 = ek1VarA;
                        final op1 op1Var2 = op1Var;
                        kj4.a(a22VarA, yi4.b(1260045569, new vq0() { // from class: rb
                            @Override // defpackage.vq0
                            public final Object e(Object obj3, Object obj4) {
                                x20 x20Var3 = (x20) obj3;
                                int iIntValue2 = ((Integer) obj4).intValue();
                                final int i5 = 1;
                                final int i6 = 0;
                                if (x20Var3.O(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                    long j6 = j5;
                                    boolean z5 = z4;
                                    ek1 ek1Var3 = ek1Var2;
                                    final op1 op1Var3 = op1Var2;
                                    xy xyVar = r20.a;
                                    if (j6 != 9205357640488583168L) {
                                        x20Var3.W(3458246);
                                        bg bgVar = z5 ? h51.b : h51.a;
                                        ek1 ek1VarF = w44.f(ek1Var3, Float.intBitsToFloat((int) (j6 >> 32)), Float.intBitsToFloat((int) (j6 & 4294967295L)), 0.0f, 0.0f, 12);
                                        e92 e92VarA = d92.a(bgVar, xy.t, x20Var3, 0);
                                        int iHashCode = Long.hashCode(x20Var3.T);
                                        gw1 gw1VarL = x20Var3.l();
                                        ek1 ek1VarC = gj4.c(x20Var3, ek1VarF);
                                        o20.p.getClass();
                                        k30 k30Var = n20.b;
                                        x20Var3.Z();
                                        if (x20Var3.S) {
                                            x20Var3.k(k30Var);
                                        } else {
                                            x20Var3.j0();
                                        }
                                        ie4.c(x20Var3, n20.f, e92VarA);
                                        ie4.c(x20Var3, n20.e, gw1VarL);
                                        ie4.a(x20Var3, Integer.valueOf(iHashCode), n20.g);
                                        ie4.b(x20Var3, n20.h);
                                        ie4.c(x20Var3, n20.d, ek1VarC);
                                        boolean zH = x20Var3.h(op1Var3);
                                        Object objL2 = x20Var3.L();
                                        if (zH || objL2 == xyVar) {
                                            objL2 = new fq0() { // from class: sb
                                                @Override // defpackage.fq0
                                                public final Object a() {
                                                    int i7 = i6;
                                                    op1 op1Var4 = op1Var3;
                                                    switch (i7) {
                                                        case 0:
                                                            return Boolean.valueOf((9223372034707292159L & op1Var4.a()) != 9205357640488583168L);
                                                        default:
                                                            return Boolean.valueOf((9223372034707292159L & op1Var4.a()) != 9205357640488583168L);
                                                    }
                                                }
                                            };
                                            x20Var3.g0(objL2);
                                        }
                                        vd4.c(bk1.a, (fq0) objL2, z5, x20Var3, 6);
                                        x20Var3.p(true);
                                        x20Var3.p(false);
                                    } else {
                                        x20Var3.W(4389176);
                                        boolean zH2 = x20Var3.h(op1Var3);
                                        Object objL3 = x20Var3.L();
                                        if (zH2 || objL3 == xyVar) {
                                            objL3 = new fq0() { // from class: sb
                                                @Override // defpackage.fq0
                                                public final Object a() {
                                                    int i7 = i5;
                                                    op1 op1Var4 = op1Var3;
                                                    switch (i7) {
                                                        case 0:
                                                            return Boolean.valueOf((9223372034707292159L & op1Var4.a()) != 9205357640488583168L);
                                                        default:
                                                            return Boolean.valueOf((9223372034707292159L & op1Var4.a()) != 9205357640488583168L);
                                                    }
                                                }
                                            };
                                            x20Var3.g0(objL3);
                                        }
                                        vd4.c(ek1Var3, (fq0) objL3, z5, x20Var3, 0);
                                        x20Var3.p(false);
                                    }
                                } else {
                                    x20Var3.R();
                                }
                                return q43.a;
                            }
                        }, x20Var2), x20Var2, 56);
                    } else {
                        x20Var2.R();
                    }
                    return q43.a;
                }
            }, x20Var), x20Var, i4 | CollationFastLatin.LATIN_LIMIT);
        } else {
            x20Var.R();
            j2 = j;
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            final long j5 = j2;
            a42VarR.d = new vq0() { // from class: qb
                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    vd4.b(op1Var, z, p62Var, z2, j5, f, ek1Var, (x20) obj, ny3.c(i | 1));
                    return q43.a;
                }
            };
        }
    }

    public static final void c(ek1 ek1Var, fq0 fq0Var, boolean z, x20 x20Var, int i) {
        int i2;
        x20Var.X(2111672474);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i3 = i2 | (x20Var.h(fq0Var) ? 32 : 16) | (x20Var.g(z) ? 256 : 128);
        int i4 = 0;
        if (x20Var.O(i3 & 1, (i3 & 147) != 146)) {
            ng2 ng2Var = wf2.a;
            k54.h(x20Var, gj4.a(w44.h(ek1Var, 25.0f, 25.0f), new ub(fq0Var, z, i4)));
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new tb(ek1Var, fq0Var, z, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    public static final p9 d(so soVar, float f) {
        int iCeil = ((int) Math.ceil(f)) * 2;
        p9 p9VarA = fo4.a;
        u6 u6VarA = fo4.b;
        ew ewVar = fo4.c;
        if (p9VarA == null || u6VarA == null) {
            p9VarA = ro4.a(iCeil, iCeil, 1);
            fo4.a = p9VarA;
            u6VarA = bh4.a(p9VarA);
            fo4.b = u6VarA;
        } else {
            Bitmap bitmap = p9VarA.a;
            if (iCeil > bitmap.getWidth() || iCeil > bitmap.getHeight()) {
                p9VarA = ro4.a(iCeil, iCeil, 1);
                fo4.a = p9VarA;
                u6VarA = bh4.a(p9VarA);
                fo4.b = u6VarA;
            }
        }
        p9 p9Var = p9VarA;
        u6 u6Var = u6VarA;
        if (ewVar == null) {
            ewVar = new ew();
            fo4.c = ewVar;
        }
        ew ewVar2 = ewVar;
        dw dwVar = ewVar2.a;
        z61 layoutDirection = soVar.a.getLayoutDirection();
        Bitmap bitmap2 = p9Var.a;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(bitmap2.getWidth())) << 32) | (((long) Float.floatToRawIntBits(bitmap2.getHeight())) & 4294967295L);
        jc0 jc0Var = dwVar.a;
        z61 z61Var = dwVar.b;
        cw cwVar = dwVar.c;
        long j = dwVar.d;
        dwVar.a = soVar;
        dwVar.b = layoutDirection;
        dwVar.c = u6Var;
        dwVar.d = jFloatToRawIntBits;
        u6Var.m();
        rf0.E(ewVar2, sz.b, ewVar2.c(), 58);
        rf0.E(ewVar2, ki4.c(4278190080L), (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L), 120);
        rf0.P(ewVar2, ki4.c(4278190080L), f, (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L), 0.0f, 120);
        u6Var.j();
        dwVar.a = jc0Var;
        dwVar.b = z61Var;
        dwVar.c = cwVar;
        dwVar.d = j;
        return p9Var;
    }

    public static boolean e(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }
}
