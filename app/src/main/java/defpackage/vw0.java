package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vw0 implements yj2 {
    public static final vw0 b = new vw0(0);
    public static final vw0 c = new vw0(1);
    public final /* synthetic */ int a;

    public /* synthetic */ vw0(int i) {
        this.a = i;
    }

    @Override // defpackage.yj2
    public final es4 a(long j, z61 z61Var, jc0 jc0Var) {
        switch (this.a) {
            case 0:
                float fR = jc0Var.R(30.0f);
                return new us1(new l42(0.0f, -fR, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)) + fR));
            case 1:
                float fR2 = jc0Var.R(30.0f);
                return new us1(new l42(-fR2, 0.0f, Float.intBitsToFloat((int) (j >> 32)) + fR2, Float.intBitsToFloat((int) (j & 4294967295L))));
            default:
                return new us1(ry3.a(0L, j));
        }
    }

    public String toString() {
        switch (this.a) {
            case 2:
                return "RectangleShape";
            default:
                return super.toString();
        }
    }
}
