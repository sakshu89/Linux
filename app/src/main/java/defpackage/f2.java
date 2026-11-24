package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f2 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ hq0 b;

    public /* synthetic */ f2(hq0 hq0Var, int i) {
        this.a = i;
        this.b = hq0Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        hq0 hq0Var = this.b;
        switch (i) {
            case 0:
                ad2 ad2Var = (ad2) obj;
                ad2Var.getClass();
                zc2 zc2Var = ad2Var instanceof zc2 ? (zc2) ad2Var : null;
                hq0Var.j(zc2Var != null ? zc2Var.a : null);
                return q43.a;
            case 1:
                bm2 bm2Var = (bm2) hq0Var.j((gm2) obj);
                synchronized (im2.c) {
                    im2.d = im2.d.g(bm2Var.g());
                }
                return bm2Var;
            default:
                Long l = (Long) obj;
                l.getClass();
                return hq0Var.j(l);
        }
    }
}
