package defpackage;

import com.ibm.icu.impl.coll.CollationFastLatin;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u13 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ l5 b;

    public /* synthetic */ u13(l5 l5Var) {
        this.a = 0;
        this.b = l5Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        l5 l5Var = this.b;
        switch (i) {
            case 0:
                x20 x20Var = (x20) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (!x20Var.O(1 & iIntValue, (iIntValue & 3) != 2)) {
                    x20Var.R();
                } else {
                    dz2.b(l5Var.a, null, uz.e, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(w33.a)).k, x20Var, CollationFastLatin.LATIN_LIMIT, 0, 131066);
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                cb4.d(l5Var, (x20) obj, ny3.c(1));
                break;
            default:
                ((Integer) obj2).getClass();
                cb4.a(l5Var, (x20) obj, ny3.c(1));
                break;
        }
        return q43Var;
    }

    public /* synthetic */ u13(l5 l5Var, int i, int i2) {
        this.a = i2;
        this.b = l5Var;
    }
}
