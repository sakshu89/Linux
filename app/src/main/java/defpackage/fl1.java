package defpackage;

import android.graphics.Matrix;
import android.graphics.Shader;
import android.text.Layout;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fl1 {
    public final cj a;
    public final int b;
    public final boolean c;
    public final float d;
    public final float e;
    public final int f;
    public final ArrayList g;
    public final ArrayList h;

    public fl1(cj cjVar, long j, int i, int i2) {
        boolean z;
        int i3;
        int iG;
        int i4;
        this.a = cjVar;
        this.b = i;
        if (q40.j(j) != 0 || q40.i(j) != 0) {
            a11.a("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) cjVar.a;
        int size = arrayList2.size();
        float f = 0.0f;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= size) {
                z = false;
                break;
            }
            bu1 bu1Var = (bu1) arrayList2.get(i5);
            ma maVar = bu1Var.a;
            int iH = q40.h(j);
            if (q40.c(j)) {
                i3 = i5;
                iG = q40.g(j) - ((int) Math.ceil(f));
                if (iG < 0) {
                    iG = 0;
                }
            } else {
                i3 = i5;
                iG = q40.g(j);
            }
            ia iaVar = new ia(maVar, this.b - i6, i2, r40.b(iH, iG, 5));
            float fB = iaVar.b() + f;
            ez2 ez2Var = iaVar.d;
            int i7 = i6 + ez2Var.g;
            arrayList.add(new au1(iaVar, bu1Var.b, bu1Var.c, i6, i7, f, fB));
            if (!ez2Var.d) {
                if (i7 == this.b) {
                    i4 = i3;
                    if (i4 != nz.g((ArrayList) this.a.a)) {
                    }
                } else {
                    i4 = i3;
                }
                i5 = i4 + 1;
                i6 = i7;
                f = fB;
            }
            z = true;
            i6 = i7;
            f = fB;
            break;
        }
        this.e = f;
        this.f = i6;
        this.c = z;
        this.h = arrayList;
        this.d = q40.h(j);
        ArrayList arrayList3 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i8 = 0; i8 < size2; i8++) {
            au1 au1Var = (au1) arrayList.get(i8);
            List list = au1Var.a.f;
            ArrayList arrayList4 = new ArrayList(list.size());
            int size3 = list.size();
            for (int i9 = 0; i9 < size3; i9++) {
                l42 l42Var = (l42) list.get(i9);
                arrayList4.add(l42Var != null ? au1Var.a(l42Var) : null);
            }
            rz.q(arrayList4, arrayList3);
        }
        if (arrayList3.size() < ((List) this.a.c).size()) {
            int size4 = ((List) this.a.c).size() - arrayList3.size();
            ArrayList arrayList5 = new ArrayList(size4);
            for (int i10 = 0; i10 < size4; i10++) {
                arrayList5.add(null);
            }
            arrayList3 = mz.G(arrayList3, arrayList5);
        }
        this.g = arrayList3;
    }

    public static void i(fl1 fl1Var, cw cwVar, hn hnVar, float f, vj2 vj2Var, sx2 sx2Var, wm4 wm4Var) {
        cwVar.m();
        ArrayList arrayList = fl1Var.h;
        if (arrayList.size() <= 1 || (hnVar instanceof cn2)) {
            jd4.a(fl1Var, cwVar, hnVar, f, vj2Var, sx2Var, wm4Var);
        } else {
            if (!(hnVar instanceof tj2)) {
                dk0.l();
                return;
            }
            int size = arrayList.size();
            float fMax = 0.0f;
            float fB = 0.0f;
            for (int i = 0; i < size; i++) {
                au1 au1Var = (au1) arrayList.get(i);
                fB += au1Var.a.b();
                fMax = Math.max(fMax, au1Var.a.d());
            }
            Shader shaderB = ((tj2) hnVar).b((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fB)) & 4294967295L));
            Matrix matrix = new Matrix();
            shaderB.getLocalMatrix(matrix);
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ia iaVar = ((au1) arrayList.get(i2)).a;
                iaVar.g(cwVar, new in(shaderB), f, vj2Var, sx2Var, wm4Var);
                cwVar.g(0.0f, iaVar.b());
                matrix.setTranslate(0.0f, -iaVar.b());
                shaderB.setLocalMatrix(matrix);
            }
        }
        cwVar.j();
    }

    public final void a(long j, float[] fArr) {
        j(oz2.f(j));
        k(oz2.e(j));
        r42 r42Var = new r42();
        r42Var.a = 0;
        qr4.d(this.h, j, new vl(j, fArr, r42Var, new q42()));
    }

    public final float b(int i) {
        l(i);
        ArrayList arrayList = this.h;
        au1 au1Var = (au1) arrayList.get(qr4.b(i, arrayList));
        ia iaVar = au1Var.a;
        return iaVar.d.e(i - au1Var.d) + au1Var.f;
    }

    public final int c(int i, boolean z) {
        int iF;
        l(i);
        ArrayList arrayList = this.h;
        au1 au1Var = (au1) arrayList.get(qr4.b(i, arrayList));
        ia iaVar = au1Var.a;
        int i2 = i - au1Var.d;
        ez2 ez2Var = iaVar.d;
        if (z) {
            Layout layout = ez2Var.f;
            ThreadLocal threadLocal = iz2.a;
            if (layout.getEllipsisCount(i2) <= 0 || ez2Var.b != TextUtils.TruncateAt.END) {
                cj cjVarC = ez2Var.c();
                Layout layout2 = (Layout) cjVarC.b;
                iF = cjVarC.w(layout2.getLineEnd(i2), layout2.getLineStart(i2));
            } else {
                iF = layout.getEllipsisStart(i2) + layout.getLineStart(i2);
            }
        } else {
            iF = ez2Var.f(i2);
        }
        return iF + au1Var.b;
    }

    public final int d(int i) {
        int iA;
        int length = ((be) this.a.b).b.length();
        ArrayList arrayList = this.h;
        if (i >= length) {
            iA = nz.g(arrayList);
        } else {
            iA = i < 0 ? 0 : qr4.a(i, arrayList);
        }
        au1 au1Var = (au1) arrayList.get(iA);
        return au1Var.a.d.f.getLineForOffset(au1Var.d(i)) + au1Var.d;
    }

    public final int e(float f) {
        ArrayList arrayList = this.h;
        au1 au1Var = (au1) arrayList.get(qr4.c(arrayList, f));
        int i = au1Var.c - au1Var.b;
        int i2 = au1Var.d;
        if (i == 0) {
            return i2;
        }
        ia iaVar = au1Var.a;
        float f2 = f - au1Var.f;
        ez2 ez2Var = iaVar.d;
        return ez2Var.f.getLineForVertical(((int) f2) - ez2Var.h) + i2;
    }

    public final float f(int i) {
        l(i);
        ArrayList arrayList = this.h;
        au1 au1Var = (au1) arrayList.get(qr4.b(i, arrayList));
        ia iaVar = au1Var.a;
        return iaVar.d.g(i - au1Var.d) + au1Var.f;
    }

    public final int g(long j) {
        int i = (int) (j & 4294967295L);
        float fIntBitsToFloat = Float.intBitsToFloat(i);
        ArrayList arrayList = this.h;
        au1 au1Var = (au1) arrayList.get(qr4.c(arrayList, fIntBitsToFloat));
        int i2 = au1Var.c;
        int i3 = au1Var.b;
        if (i2 - i3 == 0) {
            return i3;
        }
        ia iaVar = au1Var.a;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat(i) - au1Var.f;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) & 4294967295L);
        ez2 ez2Var = iaVar.d;
        int lineForVertical = ez2Var.f.getLineForVertical(((int) Float.intBitsToFloat((int) (4294967295L & jFloatToRawIntBits))) - ez2Var.h);
        return ez2Var.f.getOffsetForHorizontal(lineForVertical, (ez2Var.b(lineForVertical) * (-1.0f)) + Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32))) + i3;
    }

    public final long h(l42 l42Var, int i, kf2 kf2Var) {
        long jB;
        long j;
        float f = l42Var.b;
        ArrayList arrayList = this.h;
        int iC = qr4.c(arrayList, f);
        float f2 = ((au1) arrayList.get(iC)).g;
        float f3 = l42Var.d;
        if (f2 >= f3 || iC == nz.g(arrayList)) {
            au1 au1Var = (au1) arrayList.get(iC);
            return au1Var.b(au1Var.a.c(au1Var.c(l42Var), i, kf2Var), true);
        }
        int iC2 = qr4.c(arrayList, f3);
        long jB2 = oz2.b;
        while (true) {
            jB = oz2.b;
            if (!oz2.b(jB2, jB) || iC > iC2) {
                break;
            }
            au1 au1Var2 = (au1) arrayList.get(iC);
            jB2 = au1Var2.b(au1Var2.a.c(au1Var2.c(l42Var), i, kf2Var), true);
            iC++;
        }
        if (oz2.b(jB2, jB)) {
            return jB;
        }
        while (true) {
            j = oz2.b;
            if (!oz2.b(jB, j) || iC > iC2) {
                break;
            }
            au1 au1Var3 = (au1) arrayList.get(iC2);
            jB = au1Var3.b(au1Var3.a.c(au1Var3.c(l42Var), i, kf2Var), true);
            iC2--;
        }
        return oz2.b(jB, j) ? jB2 : hc4.a((int) (jB2 >> 32), (int) (4294967295L & jB));
    }

    public final void j(int i) {
        be beVar = (be) this.a.b;
        if (i < 0 || i >= beVar.b.length()) {
            StringBuilder sbP = ky0.p("offset(", i, ") is out of bounds [0, ");
            sbP.append(beVar.b.length());
            sbP.append(')');
            a11.a(sbP.toString());
        }
    }

    public final void k(int i) {
        be beVar = (be) this.a.b;
        if (i < 0 || i > beVar.b.length()) {
            StringBuilder sbP = ky0.p("offset(", i, ") is out of bounds [0, ");
            sbP.append(beVar.b.length());
            sbP.append(']');
            a11.a(sbP.toString());
        }
    }

    public final void l(int i) {
        boolean z = false;
        int i2 = this.f;
        if (i >= 0 && i < i2) {
            z = true;
        }
        if (z) {
            return;
        }
        a11.a("lineIndex(" + i + ") is out of bounds [0, " + i2 + ')');
    }
}
