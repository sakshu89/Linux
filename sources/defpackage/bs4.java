package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.lang.UCharacter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class bs4 {
    public static final void a(rn2 rn2Var, float f, boolean z, ek1 ek1Var, x20 x20Var, int i) {
        int i2;
        rn2 rn2Var2;
        float f2;
        rn2Var.getClass();
        x20Var.X(-317669062);
        if ((i & 6) == 0) {
            i2 = (x20Var.d(rn2Var.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.c(f) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.g(z) ? 256 : 128;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i2 |= x20Var.f(ek1Var) ? 2048 : 1024;
        }
        if (x20Var.O(i2 & 1, (i2 & 1171) != 1170)) {
            Object objL = x20Var.L();
            xy xyVar = r20.a;
            if (objL == xyVar) {
                objL = new lp2();
                x20Var.g0(objL);
            }
            lp2 lp2Var = (lp2) objL;
            gu1 gu1VarA = sz3.a(x20Var);
            if (z) {
                rn2Var2 = rn2Var;
                f2 = 1.0f;
            } else {
                rn2Var2 = rn2Var;
                f2 = rn2Var2 == rn2.c ? 0.72f : 0.0f;
            }
            gr2 gr2VarA = dd.a(f2, ie4.e(UCharacter.UnicodeBlock.ZNAMENNY_MUSICAL_NOTATION_ID, null, 6), "sparkActivity", x20Var);
            gr2 gr2VarA2 = dd.a(ky3.b(f, 0.0f, 1.0f), ie4.e(90, null, 6), "sparkVoice", x20Var);
            gr2 gr2VarA3 = vk2.a(z ? ki4.c(4280468830L) : uz.a(rn2Var2).c, ie4.e(UCharacter.UnicodeBlock.ZNAMENNY_MUSICAL_NOTATION_ID, null, 6), "sparkTint", x20Var);
            gr2 gr2VarA4 = vk2.a(z ? ki4.c(4287033260L) : uz.a(rn2Var2).b, ie4.e(UCharacter.UnicodeBlock.ZNAMENNY_MUSICAL_NOTATION_ID, null, 6), "sparkHighlight", x20Var);
            boolean zF = x20Var.f(gr2VarA) | x20Var.f(gu1VarA) | x20Var.f(gr2VarA2) | x20Var.f(gr2VarA3) | x20Var.f(gr2VarA4) | x20Var.h(lp2Var);
            Object objL2 = x20Var.L();
            if (zF || objL2 == xyVar) {
                im imVar = new im(gr2VarA, gu1VarA, gr2VarA2, gr2VarA3, gr2VarA4, lp2Var, 1);
                x20Var.g0(imVar);
                objL2 = imVar;
            }
            dh4.a(ek1Var, (hq0) objL2, x20Var, (i2 >> 9) & 14);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new hs1(rn2Var, f, z, ek1Var, i, 0);
        }
    }
}
