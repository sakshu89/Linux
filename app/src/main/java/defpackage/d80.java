package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d80 extends gr0 implements vq0 {
    public final /* synthetic */ int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d80(int i, Object obj, Class cls, String str, String str2, int i2, int i3, int i4) {
        super(i, obj, cls, str, str2, i2, i3);
        this.k = i4;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        boolean zA;
        int i = this.k;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                return Integer.valueOf(((Bitmap) obj3).getPixel(((Number) obj).intValue(), ((Number) obj2).intValue()));
            default:
                jo0 jo0Var = (jo0) obj;
                jo0 jo0Var2 = (jo0) obj2;
                no0 no0Var = (no0) obj3;
                if (no0Var.w && (zA = jo0Var2.a()) != jo0Var.a()) {
                    hq0 hq0Var = no0Var.Y;
                    if (hq0Var != null) {
                        hq0Var.j(Boolean.valueOf(zA));
                    }
                    x50 x50Var = null;
                    if (zA) {
                        uf4.b(no0Var.w0(), null, new l2(no0Var, x50Var, 2), 3);
                        t42 t42Var = new t42();
                        tr4.a(no0Var, new zb(7, t42Var, no0Var));
                        a91 a91Var = (a91) t42Var.a;
                        if (a91Var != null) {
                            a91Var.a();
                        } else {
                            a91Var = null;
                        }
                        no0Var.c0 = a91Var;
                        co1 co1Var = no0Var.d0;
                        if (co1Var != null && co1Var.V0().w) {
                            no0Var.M0();
                        }
                    } else {
                        a91 a91Var2 = no0Var.c0;
                        if (a91Var2 != null) {
                            a91Var2.b();
                        }
                        no0Var.c0 = null;
                        no0Var.M0();
                    }
                    a34.a(no0Var);
                    ol1 ol1Var = no0Var.X;
                    if (ol1Var != null) {
                        sn0 sn0Var = no0Var.Z;
                        if (zA) {
                            if (sn0Var != null) {
                                no0Var.L0(ol1Var, new tn0(sn0Var));
                                no0Var.Z = null;
                            }
                            sn0 sn0Var2 = new sn0();
                            no0Var.L0(ol1Var, sn0Var2);
                            no0Var.Z = sn0Var2;
                        } else if (sn0Var != null) {
                            no0Var.L0(ol1Var, new tn0(sn0Var));
                            no0Var.Z = null;
                        }
                    }
                }
                return q43.a;
        }
    }
}
