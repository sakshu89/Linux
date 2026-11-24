package defpackage;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tv1 implements fq0 {
    public final /* synthetic */ int a;

    public /* synthetic */ tv1(int i) {
        this.a = i;
    }

    @Override // defpackage.fq0
    public final Object a() {
        switch (this.a) {
            case 0:
                return Long.valueOf(System.currentTimeMillis());
            case 1:
                return Long.valueOf(System.nanoTime() / 1000000);
            case 2:
                return Long.valueOf(System.nanoTime() / 1000000);
            case 3:
                xa0 xa0Var = ld0.a;
                return qa0.c;
            case 4:
                return new f82();
            case 5:
                return new aa2(new LinkedHashMap());
            case 6:
                sr2 sr2Var = da2.a;
                return null;
            case 7:
                return new md2(0);
            case 8:
                m30 m30Var = ag2.a;
                return null;
            case 9:
                return new ck2();
            case 10:
                return o44.g(zt1.a);
            case 11:
                return o44.g(Boolean.FALSE);
            case 12:
                return q43.a;
            case 13:
                return new de0(0.0f);
            case 14:
                m30 m30Var2 = mx2.a;
                return null;
            case 15:
                return y33.a;
            case 16:
                return tz2.b;
            case 17:
                wm2 wm2Var = new wm2(new xn2(18));
                wm2Var.d();
                return wm2Var;
            case 18:
                return new v33(null, null, null, null, null, null, 32767);
            default:
                return Long.valueOf(System.nanoTime() / 1000000);
        }
    }
}
