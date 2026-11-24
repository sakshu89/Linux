package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w13 implements xq0 {
    public final /* synthetic */ List a;
    public final /* synthetic */ boolean b;

    public w13(List list, boolean z) {
        this.a = list;
        this.b = z;
    }

    @Override // defpackage.xq0
    public final Object o(Object obj, Object obj2, Object obj3, Object obj4) {
        int i;
        k81 k81Var = (k81) obj;
        int iIntValue = ((Number) obj2).intValue();
        x20 x20Var = (x20) obj3;
        int iIntValue2 = ((Number) obj4).intValue();
        if ((iIntValue2 & 6) == 0) {
            i = (x20Var.f(k81Var) ? 4 : 2) | iIntValue2;
        } else {
            i = iIntValue2;
        }
        if ((iIntValue2 & 48) == 0) {
            i |= x20Var.d(iIntValue) ? 32 : 16;
        }
        if (x20Var.O(i & 1, (i & 147) != 146)) {
            l5 l5Var = (l5) this.a.get(iIntValue);
            x20Var.W(227497887);
            if (this.b) {
                x20Var.W(227515494);
                cb4.a(l5Var, x20Var, 0);
                x20Var.p(false);
            } else {
                x20Var.W(227570922);
                cb4.d(l5Var, x20Var, 0);
                x20Var.p(false);
            }
            x20Var.p(false);
        } else {
            x20Var.R();
        }
        return q43.a;
    }
}
