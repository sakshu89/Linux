package defpackage;

import android.graphics.RectF;
import android.text.Layout;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gz2 {
    public final fz2 a;
    public final fl1 b;
    public final long c;
    public final float d;
    public final float e;
    public final ArrayList f;

    public gz2(fz2 fz2Var, fl1 fl1Var, long j) {
        this.a = fz2Var;
        this.b = fl1Var;
        this.c = j;
        ArrayList arrayList = fl1Var.h;
        float fD = 0.0f;
        this.d = arrayList.isEmpty() ? 0.0f : ((au1) arrayList.get(0)).a.d.d(0);
        if (!arrayList.isEmpty()) {
            au1 au1Var = (au1) mz.D(arrayList);
            ez2 ez2Var = au1Var.a.d;
            fD = ez2Var.d(ez2Var.g - 1) + au1Var.f;
        }
        this.e = fD;
        this.f = fl1Var.g;
    }

    public final p62 a(int i) {
        fl1 fl1Var = this.b;
        fl1Var.k(i);
        int length = ((be) fl1Var.a.b).b.length();
        ArrayList arrayList = fl1Var.h;
        au1 au1Var = (au1) arrayList.get(i == length ? nz.g(arrayList) : qr4.a(i, arrayList));
        return au1Var.a.d.f.isRtlCharAt(au1Var.d(i)) ? p62.b : p62.a;
    }

    public final l42 b(int i) {
        float fI;
        float fI2;
        float fH;
        float fH2;
        fl1 fl1Var = this.b;
        fl1Var.j(i);
        ArrayList arrayList = fl1Var.h;
        au1 au1Var = (au1) arrayList.get(qr4.a(i, arrayList));
        ia iaVar = au1Var.a;
        int iD = au1Var.d(i);
        CharSequence charSequence = iaVar.e;
        if (iD < 0 || iD >= charSequence.length()) {
            StringBuilder sbP = ky0.p("offset(", iD, ") is out of bounds [0,");
            sbP.append(charSequence.length());
            sbP.append(')');
            a11.a(sbP.toString());
        }
        ez2 ez2Var = iaVar.d;
        Layout layout = ez2Var.f;
        int lineForOffset = layout.getLineForOffset(iD);
        float fG = ez2Var.g(lineForOffset);
        float fE = ez2Var.e(lineForOffset);
        boolean z = layout.getParagraphDirection(lineForOffset) == 1;
        boolean zIsRtlCharAt = layout.isRtlCharAt(iD);
        if (!z || zIsRtlCharAt) {
            if (z && zIsRtlCharAt) {
                fH = ez2Var.i(iD, false);
                fH2 = ez2Var.i(iD + 1, true);
            } else if (zIsRtlCharAt) {
                fH = ez2Var.h(iD, false);
                fH2 = ez2Var.h(iD + 1, true);
            } else {
                fI = ez2Var.i(iD, false);
                fI2 = ez2Var.i(iD + 1, true);
            }
            float f = fH;
            fI = fH2;
            fI2 = f;
        } else {
            fI = ez2Var.h(iD, false);
            fI2 = ez2Var.h(iD + 1, true);
        }
        RectF rectF = new RectF(fI, fG, fI2, fE);
        return au1Var.a(new l42(rectF.left, rectF.top, rectF.right, rectF.bottom));
    }

    public final l42 c(int i) {
        fl1 fl1Var = this.b;
        fl1Var.k(i);
        int length = ((be) fl1Var.a.b).b.length();
        ArrayList arrayList = fl1Var.h;
        au1 au1Var = (au1) arrayList.get(i == length ? nz.g(arrayList) : qr4.a(i, arrayList));
        ia iaVar = au1Var.a;
        int iD = au1Var.d(i);
        CharSequence charSequence = iaVar.e;
        ez2 ez2Var = iaVar.d;
        if (iD < 0 || iD > charSequence.length()) {
            StringBuilder sbP = ky0.p("offset(", iD, ") is out of bounds [0,");
            sbP.append(charSequence.length());
            sbP.append(']');
            a11.a(sbP.toString());
        }
        float fH = ez2Var.h(iD, false);
        int lineForOffset = ez2Var.f.getLineForOffset(iD);
        return au1Var.a(new l42(fH, ez2Var.g(lineForOffset), fH, ez2Var.e(lineForOffset)));
    }

    public final float d(int i) {
        fl1 fl1Var = this.b;
        fl1Var.l(i);
        ArrayList arrayList = fl1Var.h;
        au1 au1Var = (au1) arrayList.get(qr4.b(i, arrayList));
        ia iaVar = au1Var.a;
        int i2 = i - au1Var.d;
        ez2 ez2Var = iaVar.d;
        return ez2Var.f.getLineLeft(i2) + (i2 == ez2Var.g + (-1) ? ez2Var.j : 0.0f);
    }

    public final float e(int i) {
        fl1 fl1Var = this.b;
        fl1Var.l(i);
        ArrayList arrayList = fl1Var.h;
        au1 au1Var = (au1) arrayList.get(qr4.b(i, arrayList));
        ia iaVar = au1Var.a;
        int i2 = i - au1Var.d;
        ez2 ez2Var = iaVar.d;
        return ez2Var.f.getLineRight(i2) + (i2 == ez2Var.g + (-1) ? ez2Var.k : 0.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof gz2) {
            gz2 gz2Var = (gz2) obj;
            if (g31.a(this.a, gz2Var.a) && this.b == gz2Var.b && l21.a(this.c, gz2Var.c) && this.d == gz2Var.d && this.e == gz2Var.e && g31.a(this.f, gz2Var.f)) {
                return true;
            }
        }
        return false;
    }

    public final int f(int i) {
        fl1 fl1Var = this.b;
        fl1Var.l(i);
        ArrayList arrayList = fl1Var.h;
        au1 au1Var = (au1) arrayList.get(qr4.b(i, arrayList));
        ia iaVar = au1Var.a;
        return iaVar.d.f.getLineStart(i - au1Var.d) + au1Var.b;
    }

    public final p62 g(int i) {
        fl1 fl1Var = this.b;
        fl1Var.k(i);
        int length = ((be) fl1Var.a.b).b.length();
        ArrayList arrayList = fl1Var.h;
        au1 au1Var = (au1) arrayList.get(i == length ? nz.g(arrayList) : qr4.a(i, arrayList));
        ia iaVar = au1Var.a;
        int iD = au1Var.d(i);
        ez2 ez2Var = iaVar.d;
        return ez2Var.f.getParagraphDirection(ez2Var.f.getLineForOffset(iD)) == 1 ? p62.a : p62.b;
    }

    public final na h(int i, int i2) {
        fl1 fl1Var = this.b;
        be beVar = (be) fl1Var.a.b;
        if (i < 0 || i > i2 || i2 > beVar.b.length()) {
            StringBuilder sbP = cq.p("Start(", i, ") or End(", i2, ") is out of range [0..");
            sbP.append(beVar.b.length());
            sbP.append("), or start > end!");
            a11.a(sbP.toString());
        }
        if (i == i2) {
            return pa.a();
        }
        na naVarA = pa.a();
        qr4.d(fl1Var.h, hc4.a(i, i2), new u11(naVarA, i, i2, 3));
        return naVarA;
    }

    public final int hashCode() {
        return this.f.hashCode() + cq.b(cq.b(cq.c((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, this.c), this.d, 31), this.e, 31);
    }

    public final long i(int i) {
        int iL;
        int iJ;
        int iJ2;
        fl1 fl1Var = this.b;
        fl1Var.k(i);
        int length = ((be) fl1Var.a.b).b.length();
        ArrayList arrayList = fl1Var.h;
        au1 au1Var = (au1) arrayList.get(i == length ? nz.g(arrayList) : qr4.a(i, arrayList));
        ia iaVar = au1Var.a;
        int iD = au1Var.d(i);
        ye yeVarJ = iaVar.d.j();
        if (yeVarJ.i(yeVarJ.l(iD))) {
            yeVarJ.b(iD);
            iL = iD;
            while (iL != -1 && (!yeVarJ.i(iL) || yeVarJ.e(iL))) {
                iL = yeVarJ.l(iL);
            }
        } else {
            yeVarJ.b(iD);
            if (yeVarJ.h(iD)) {
                iL = (!yeVarJ.f(iD) || yeVarJ.d(iD)) ? yeVarJ.l(iD) : iD;
            } else {
                iL = yeVarJ.d(iD) ? yeVarJ.l(iD) : -1;
            }
        }
        if (iL == -1) {
            iL = iD;
        }
        if (yeVarJ.e(yeVarJ.j(iD))) {
            yeVarJ.b(iD);
            iJ = iD;
            while (iJ != -1 && (yeVarJ.i(iJ) || !yeVarJ.e(iJ))) {
                iJ = yeVarJ.j(iJ);
            }
        } else {
            yeVarJ.b(iD);
            if (yeVarJ.d(iD)) {
                if (!yeVarJ.f(iD) || yeVarJ.h(iD)) {
                    iJ2 = yeVarJ.j(iD);
                    iJ = iJ2;
                } else {
                    iJ = iD;
                }
            } else if (yeVarJ.h(iD)) {
                iJ2 = yeVarJ.j(iD);
                iJ = iJ2;
            } else {
                iJ = -1;
            }
        }
        if (iJ != -1) {
            iD = iJ;
        }
        return au1Var.b(hc4.a(iL, iD), false);
    }

    public final String toString() {
        return "TextLayoutResult(layoutInput=" + this.a + ", multiParagraph=" + this.b + ", size=" + ((Object) l21.b(this.c)) + ", firstBaseline=" + this.d + ", lastBaseline=" + this.e + ", placeholderRects=" + this.f + ')';
    }
}
