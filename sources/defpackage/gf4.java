package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.lang.UCharacter;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class gf4 {
    public static final void a(rn2 rn2Var, float f, boolean z, ek1 ek1Var, x20 x20Var, int i) {
        int i2;
        long jC;
        rn2Var.getClass();
        x20Var.X(823534834);
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
        int i3 = i2;
        if (x20Var.O(i3 & 1, (i3 & 1171) != 1170)) {
            gu1 gu1VarA = sz3.a(x20Var);
            gr2 gr2VarA = dd.a(ky3.b(f, 0.0f, 1.0f), ie4.e(90, null, 6), "equalizerLevel", x20Var);
            gr2 gr2VarA2 = dd.a(z ? 1.0f : 0.0f, ie4.e(240, null, 6), "equalizerSpeech", x20Var);
            if (z) {
                jC = ki4.c(4284672963L);
            } else {
                jC = (rn2Var == rn2.b || rn2Var == rn2.c) ? ki4.c(4278570495L) : uz.a(rn2Var).b;
            }
            gr2 gr2VarA3 = vk2.a(jC, ie4.e(UCharacter.UnicodeBlock.JURCHEN_RADICALS_ID, null, 6), "equalizerTint", x20Var);
            boolean zF = x20Var.f(gu1VarA) | ((i3 & 14) == 4) | x20Var.f(gr2VarA) | x20Var.f(gr2VarA2) | x20Var.f(gr2VarA3);
            Object objL = x20Var.L();
            if (zF || objL == r20.a) {
                w9 w9Var = new w9(gu1VarA, rn2Var, gr2VarA, gr2VarA2, gr2VarA3, 5);
                x20Var.g0(w9Var);
                objL = w9Var;
            }
            dh4.a(ek1Var, (hq0) objL, x20Var, (i3 >> 9) & 14);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new hs1(rn2Var, f, z, ek1Var, i, 2);
        }
    }

    public static boolean b(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : fileArrListFiles) {
            z = b(file2) && z;
        }
        return z;
    }
}
