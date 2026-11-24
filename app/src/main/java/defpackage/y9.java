package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y9 extends gr0 implements hq0 {
    public final /* synthetic */ pa1 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y9(pa1 pa1Var) {
        super(1, f31.class, "localToScreen", "startInput$localToScreen(Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter$LegacyPlatformTextInputNode;[F)V", 0);
        this.k = pa1Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        float[] fArr = ((ih1) obj).a;
        y61 y61Var = (y61) this.k.Y.getValue();
        if (y61Var != null) {
            if (!y61Var.B()) {
                y61Var = null;
            }
            if (y61Var != null) {
                y61Var.D(fArr);
            }
        }
        return q43.a;
    }
}
