package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class iz3 {
    /* JADX WARN: Code duplicated, block: B:11:0x001c  */
    public static final float a(yw1 yw1Var, boolean z, tw0[] tw0VarArr, float f) {
        float f2 = Float.NaN;
        for (tw0 tw0Var : tw0VarArr) {
            float fD = yw1Var.d(tw0Var);
            if (Float.isNaN(f2)) {
                f2 = fD;
            } else if (z == (fD > f2)) {
                f2 = fD;
            }
        }
        return Float.isNaN(f2) ? f : f2;
    }
}
