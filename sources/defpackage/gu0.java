package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gu0 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ hq0 b;

    public /* synthetic */ gu0(hq0 hq0Var, int i) {
        this.a = i;
        this.b = hq0Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        long j;
        switch (this.a) {
            case 0:
                gm2 gm2Var = (gm2) obj;
                synchronized (im2.c) {
                    j = im2.e;
                    im2.e = 1 + j;
                }
                return new f32(j, gm2Var, this.b);
            default:
                return this.b.j(Long.valueOf(((Number) obj).longValue() / 1000000));
        }
    }
}
