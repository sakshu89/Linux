package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sy0 implements r53, xy0, v31 {
    public static final bi b;
    public static final bi c;
    public static final bi e;
    public static final bi f;
    public static final bi i;
    public static final bi j;
    public static final bi k;
    public static final bi n;
    public static final bi s;
    public static final bi t;
    public static final bi u;
    public final gs1 a;

    static {
        Class cls = Integer.TYPE;
        b = new bi("camerax.core.imageCapture.captureMode", cls, null);
        c = new bi("camerax.core.imageCapture.flashMode", cls, null);
        e = new bi("camerax.core.imageCapture.captureBundle", jw.class, null);
        f = new bi("camerax.core.imageCapture.bufferFormat", Integer.class, null);
        i = new bi("camerax.core.imageCapture.outputFormat", Integer.class, null);
        j = new bi("camerax.core.imageCapture.imageReaderProxyProvider", cz0.class, null);
        k = new bi("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE, null);
        n = new bi("camerax.core.imageCapture.flashType", cls, null);
        s = new bi("camerax.core.imageCapture.jpegCompressionQuality", cls, null);
        t = new bi("camerax.core.imageCapture.screenFlash", qy0.class, null);
        u = new bi("camerax.core.useCase.isPostviewEnabled", Boolean.class, null);
    }

    public sy0(gs1 gs1Var) {
        this.a = gs1Var;
    }

    @Override // defpackage.x22
    public final s30 n() {
        return this.a;
    }

    @Override // defpackage.wy0
    public final int p() {
        return ((Integer) f(wy0.r)).intValue();
    }
}
