package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jf1 implements jc0 {
    public boolean a;
    public long b = 9223372034707292159L;
    public long c = 0;
    public final /* synthetic */ mf1 e;

    public jf1(mf1 mf1Var) {
        this.e = mf1Var;
    }

    public final void a(tw0 tw0Var, float f) {
        mf1 mf1Var = this.e;
        we weVar = mf1Var.v;
        if (weVar == null) {
            weVar = new we();
            mf1Var.v = weVar;
        }
        int iQ = qg.q((tw0[]) weVar.b, tw0Var);
        if (iQ >= 0) {
            float[] fArr = (float[]) weVar.c;
            if (fArr[iQ] != f) {
                fArr[iQ] = f;
                ((byte[]) weVar.d)[iQ] = 1;
                return;
            } else {
                byte[] bArr = (byte[]) weVar.d;
                if (bArr[iQ] == 2) {
                    bArr[iQ] = 0;
                    return;
                }
                return;
            }
        }
        int i = weVar.a;
        tw0[] tw0VarArr = (tw0[]) weVar.b;
        if (i == tw0VarArr.length) {
            int i2 = i * 2;
            weVar.b = (tw0[]) Arrays.copyOf(tw0VarArr, i2);
            weVar.c = Arrays.copyOf((float[]) weVar.c, i2);
            weVar.d = Arrays.copyOf((byte[]) weVar.d, i2);
        }
        ((tw0[]) weVar.b)[i] = tw0Var;
        ((byte[]) weVar.d)[i] = 3;
        ((float[]) weVar.c)[i] = f;
        weVar.a++;
    }

    @Override // defpackage.jc0
    public final float b() {
        return this.e.b();
    }

    @Override // defpackage.jc0
    public final float l() {
        return this.e.l();
    }
}
