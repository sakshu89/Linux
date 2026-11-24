package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class tp4 {
    public static final int a(mf1 mf1Var, d6 d6Var) {
        mf1 mf1VarZ0 = mf1Var.z0();
        if (mf1VarZ0 == null) {
            z01.b("Child of " + mf1Var + " cannot be null when calculating alignment line");
        }
        if (mf1Var.D0().d().containsKey(d6Var)) {
            Integer num = (Integer) mf1Var.D0().d().get(d6Var);
            if (num != null) {
                return num.intValue();
            }
        } else {
            int iY0 = mf1VarZ0.y0(d6Var);
            if (iY0 != Integer.MIN_VALUE) {
                mf1VarZ0.s = true;
                mf1Var.t = true;
                mf1Var.J0();
                mf1VarZ0.s = false;
                mf1Var.t = false;
                return iY0 + ((int) (d6Var instanceof qw0 ? mf1VarZ0.F0() & 4294967295L : mf1VarZ0.F0() >> 32));
            }
        }
        return Integer.MIN_VALUE;
    }
}
