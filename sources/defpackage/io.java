package defpackage;

import com.ibm.icu.impl.coll.CollationFastLatin;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class io implements vq0 {
    public final /* synthetic */ long a;
    public final /* synthetic */ qt1 b;
    public final /* synthetic */ w10 c;

    public io(long j, qt1 qt1Var, w10 w10Var) {
        this.a = j;
        this.b = qt1Var;
        this.c = w10Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        x20 x20Var = (x20) obj;
        int iIntValue = ((Number) obj2).intValue();
        if (x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
            iy3.a(this.a, ((v33) x20Var.j(w33.a)).m, yi4.b(417635459, new ho(0, this.c, this.b), x20Var), x20Var, CollationFastLatin.LATIN_LIMIT);
        } else {
            x20Var.R();
        }
        return q43.a;
    }
}
