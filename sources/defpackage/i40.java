package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class i40 {
    public final b00 a;
    public final b00 b;
    public final b00 c;
    public final float[] d;

    /* JADX WARN: Code duplicated, block: B:28:0x006c  */
    /* JADX WARN: Illegal instructions before constructor call */
    public i40(b00 b00Var, b00 b00Var2, int i) {
        float[] fArr;
        b00 b00VarA = mi4.a(b00Var.b, 12884901888L) ? oi4.a(b00Var) : b00Var;
        b00 b00VarA2 = mi4.a(b00Var2.b, 12884901888L) ? oi4.a(b00Var2) : b00Var2;
        if (i == 3) {
            boolean zA = mi4.a(b00Var.b, 12884901888L);
            boolean zA2 = mi4.a(b00Var2.b, 12884901888L);
            if (!(zA && zA2) && (zA || zA2)) {
                ka3 ka3Var = ((y72) (zA ? b00Var : b00Var2)).d;
                float[] fArrA = qz3.e;
                float[] fArrA2 = zA ? ka3Var.a() : fArrA;
                fArrA = zA2 ? ka3Var.a() : fArrA;
                fArr = new float[]{fArrA2[0] / fArrA[0], fArrA2[1] / fArrA[1], fArrA2[2] / fArrA[2]};
            } else {
                fArr = null;
            }
        } else {
            fArr = null;
        }
        this(b00Var2, b00VarA, b00VarA2, fArr);
    }

    public long a(long j) {
        float fH = sz.h(j);
        float fG = sz.g(j);
        float fE = sz.e(j);
        float fD = sz.d(j);
        b00 b00Var = this.b;
        long jD = b00Var.d(fH, fG, fE);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jD >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jD & 4294967295L));
        float fE2 = b00Var.e(fH, fG, fE);
        float[] fArr = this.d;
        if (fArr != null) {
            fIntBitsToFloat *= fArr[0];
            fIntBitsToFloat2 *= fArr[1];
            fE2 *= fArr[2];
        }
        float f = fIntBitsToFloat;
        float f2 = fIntBitsToFloat2;
        return this.c.f(f, f2, fE2, fD, this.a);
    }

    public i40(b00 b00Var, b00 b00Var2, b00 b00Var3, float[] fArr) {
        this.a = b00Var;
        this.b = b00Var2;
        this.c = b00Var3;
        this.d = fArr;
    }
}
