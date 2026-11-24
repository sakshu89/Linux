package defpackage;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qy2 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ jc0 b;
    public final /* synthetic */ mm1 c;

    public /* synthetic */ qy2(jc0 jc0Var, mm1 mm1Var, int i) {
        this.a = i;
        this.b = jc0Var;
        this.c = mm1Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        mm1 mm1Var = this.c;
        jc0 jc0Var = this.b;
        switch (i) {
            case 0:
                rm2 rm2Var = new rm2(8, (fq0) obj);
                qy2 qy2Var = new qy2(jc0Var, mm1Var, 1);
                if (yf1.a()) {
                    return yf1.a() ? new vf1(rm2Var, qy2Var, Build.VERSION.SDK_INT == 28 ? kx1.b : kx1.c) : bk1.a;
                }
                dk0.r("Magnifier is only supported on API level 28 and higher.");
                return null;
            default:
                ge0 ge0Var = (ge0) obj;
                mm1Var.setValue(new l21((((long) jc0Var.R(Float.intBitsToFloat((int) (ge0Var.a & 4294967295L)))) & 4294967295L) | (((long) jc0Var.R(Float.intBitsToFloat((int) (ge0Var.a >> 32)))) << 32)));
                return q43.a;
        }
    }
}
