package defpackage;

import android.graphics.PathMeasure;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k30 extends k61 implements fq0 {
    public static final k30 c;
    public static final k30 e;
    public static final k30 f;
    public static final k30 i;
    public static final k30 j;
    public static final k30 k;
    public static final k30 n;
    public static final k30 s;
    public static final k30 t;
    public static final k30 u;
    public final /* synthetic */ int b;

    static {
        int i2 = 0;
        c = new k30(i2, 0);
        e = new k30(i2, 1);
        f = new k30(i2, 2);
        i = new k30(i2, 3);
        j = new k30(i2, 4);
        k = new k30(i2, 5);
        n = new k30(i2, 6);
        s = new k30(i2, 7);
        t = new k30(i2, 8);
        u = new k30(i2, 9);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k30(int i2, int i3) {
        super(i2);
        this.b = i3;
    }

    @Override // defpackage.fq0
    public final Object a() {
        switch (this.b) {
            case 0:
                l30.b("LocalUriHandler");
                throw null;
            case 1:
                l30.b("LocalViewConfiguration");
                throw null;
            case 2:
                l30.b("LocalWindowInfo");
                throw null;
            case 3:
                return Boolean.TRUE;
            case 4:
                return Boolean.FALSE;
            case 5:
                return new n71(3);
            case 6:
                return new oa(new PathMeasure());
            case 7:
            case 8:
                return null;
            default:
                return q43.a;
        }
    }
}
