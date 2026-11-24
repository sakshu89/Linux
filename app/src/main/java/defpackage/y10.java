package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.text.Normalizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y10 implements br0 {
    @Override // defpackage.br0
    public final Object p(Object obj, Boolean bool, Object obj2, Object obj3, Object obj4, x20 x20Var, Integer num) {
        int i;
        String str = (String) obj;
        boolean zBooleanValue = bool.booleanValue();
        q50 q50Var = (q50) obj2;
        wq0 wq0Var = (wq0) obj3;
        fq0 fq0Var = (fq0) obj4;
        int iIntValue = num.intValue();
        int i2 = iIntValue & 6;
        bk1 bk1Var = bk1.a;
        if (i2 == 0) {
            i = (x20Var.f(bk1Var) ? 4 : 2) | iIntValue;
        } else {
            i = iIntValue;
        }
        if ((iIntValue & 48) == 0) {
            i |= x20Var.f(str) ? 32 : 16;
        }
        if ((iIntValue & CollationFastLatin.LATIN_LIMIT) == 0) {
            i |= x20Var.g(zBooleanValue) ? 256 : 128;
        }
        if ((iIntValue & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i |= x20Var.f(q50Var) ? 2048 : 1024;
        }
        if ((iIntValue & 24576) == 0) {
            i |= x20Var.h(wq0Var) ? 16384 : 8192;
        }
        if ((iIntValue & 196608) == 0) {
            i |= x20Var.h(fq0Var) ? Normalizer.INPUT_IS_FCD : 65536;
        }
        if (x20Var.O(i & 1, (599187 & i) != 599186)) {
            v50.c(str, zBooleanValue, q50Var, bk1Var, wq0Var, fq0Var, x20Var, (i & 458752) | ((i >> 3) & 1022) | ((i << 9) & 7168) | (57344 & i));
        } else {
            x20Var.R();
        }
        return q43.a;
    }
}
