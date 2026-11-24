package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u8 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    public /* synthetic */ u8(op1 op1Var, ek1 ek1Var, long j, int i) {
        this.a = 0;
        this.c = op1Var;
        this.e = ek1Var;
        this.b = j;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        Object obj3 = this.e;
        Object obj4 = this.c;
        switch (i) {
            case 0:
                ((Integer) obj2).getClass();
                int iC = ny3.c(1);
                z8.a((op1) obj4, (ek1) obj3, this.b, (x20) obj, iC);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iC2 = ny3.c(1);
                ds4.b(this.b, (fq0) obj4, (fq0) obj3, (x20) obj, iC2);
                break;
            case 2:
                ((Integer) obj2).getClass();
                int iC3 = ny3.c(1);
                ds4.a((List) obj4, this.b, (hq0) obj3, (x20) obj, iC3);
                break;
            case 3:
                ((Integer) obj2).getClass();
                int iC4 = ny3.c(1);
                ds4.e((h52) obj4, this.b, (hq0) obj3, (x20) obj, iC4);
                break;
            default:
                ((Integer) obj2).getClass();
                int iC5 = ny3.c(385);
                iy3.a(this.b, (yz2) obj4, (w10) obj3, (x20) obj, iC5);
                break;
        }
        return q43Var;
    }

    public /* synthetic */ u8(long j, Object obj, rq0 rq0Var, int i, int i2) {
        this.a = i2;
        this.b = j;
        this.c = obj;
        this.e = rq0Var;
    }

    public /* synthetic */ u8(Object obj, long j, hq0 hq0Var, int i, int i2) {
        this.a = i2;
        this.c = obj;
        this.b = j;
        this.e = hq0Var;
    }
}
