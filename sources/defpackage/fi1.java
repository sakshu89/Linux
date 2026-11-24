package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fi1 extends nu2 implements vq0 {
    public final /* synthetic */ xv2 f;
    public final /* synthetic */ gi1 i;
    public final /* synthetic */ wv1 j;
    public final /* synthetic */ Integer k;
    public final /* synthetic */ boolean n;
    public final /* synthetic */ String s;
    public final /* synthetic */ String t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fi1(xv2 xv2Var, gi1 gi1Var, wv1 wv1Var, Integer num, boolean z, String str, String str2, x50 x50Var) {
        super(2, x50Var);
        this.f = xv2Var;
        this.i = gi1Var;
        this.j = wv1Var;
        this.k = num;
        this.n = z;
        this.s = str;
        this.t = str2;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((fi1) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new fi1(this.f, this.i, this.j, this.k, this.n, this.s, this.t, x50Var);
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        bz3.g(obj);
        Integer num = this.k;
        gi1 gi1Var = this.i;
        xv2 xv2Var = this.f;
        if (xv2Var == null) {
            nb2 nb2Var = gi1Var.c;
            ii0 ii0Var = ii0.a;
            if (!this.n) {
                return nb2Var.g(this.s, this.t, 0, false, ii0Var);
            }
            num.getClass();
            return nb2Var.g(null, null, num.intValue(), false, ii0Var);
        }
        nb2 nb2Var2 = gi1Var.c;
        String str = xv2Var.a;
        String str2 = xv2Var.b;
        wv1 wv1Var = this.j;
        wv1Var.getClass();
        List list = wv1Var.c;
        num.getClass();
        int iIntValue = num.intValue();
        nb2Var2.getClass();
        str.getClass();
        list.getClass();
        return nb2Var2.g(str, str2, iIntValue, true, list);
    }
}
