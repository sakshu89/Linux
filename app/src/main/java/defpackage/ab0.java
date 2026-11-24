package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ab0 implements kd2 {
    public final /* synthetic */ bb0 a;

    public ab0(bb0 bb0Var) {
        this.a = bb0Var;
    }

    @Override // defpackage.kd2
    public final float a(float f) {
        if (Float.isNaN(f)) {
            return 0.0f;
        }
        bb0 bb0Var = this.a;
        float fFloatValue = ((Number) bb0Var.a.j(Float.valueOf(f))).floatValue();
        bb0Var.e.setValue(Boolean.valueOf(fFloatValue > 0.0f));
        bb0Var.f.setValue(Boolean.valueOf(fFloatValue < 0.0f));
        return fFloatValue;
    }
}
