package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface zs extends x22 {
    public static final bi d = new bi("camerax.core.camera.useCaseConfigFactory", u53.class, null);
    public static final bi g = new bi("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class, null);
    public static final bi h = new bi("camerax.core.camera.SessionProcessor", qh2.class, null);
    public static final bi l = new bi("camerax.core.camera.isPostviewSupported", Boolean.class, null);
    public static final bi m = new bi("camerax.core.camera.isCaptureProcessProgressSupported", Boolean.class, null);

    default void k() {
        if (d(h, null) == null) {
            return;
        }
        dk0.t();
    }
}
