package defpackage;

import android.util.Range;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface r53 extends yv2, wy0 {
    public static final bi O = new bi("camerax.core.useCase.defaultSessionConfig", kh2.class, null);
    public static final bi P = new bi("camerax.core.useCase.defaultCaptureConfig", lw.class, null);
    public static final bi Q = new bi("camerax.core.useCase.sessionConfigUnpacker", as.class, null);
    public static final bi R = new bi("camerax.core.useCase.captureConfigUnpacker", er.class, null);
    public static final bi S;
    public static final bi T;
    public static final bi U;
    public static final bi V;
    public static final bi W;
    public static final bi a0;
    public static final bi b0;

    static {
        Class cls = Integer.TYPE;
        S = new bi("camerax.core.useCase.surfaceOccupancyPriority", cls, null);
        T = new bi("camerax.core.useCase.targetFrameRate", Range.class, null);
        Class cls2 = Boolean.TYPE;
        U = new bi("camerax.core.useCase.zslDisabled", cls2, null);
        V = new bi("camerax.core.useCase.highResolutionDisabled", cls2, null);
        W = new bi("camerax.core.useCase.captureType", t53.class, null);
        a0 = new bi("camerax.core.useCase.previewStabilizationMode", cls, null);
        b0 = new bi("camerax.core.useCase.videoStabilizationMode", cls, null);
    }

    default t53 j() {
        return (t53) f(W);
    }

    default int q() {
        return ((Integer) d(a0, 0)).intValue();
    }
}
