package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qv implements yv2 {
    public static final bi b = new bi("camerax.core.appConfig.cameraFactoryProvider", vr.class, null);
    public static final bi c = new bi("camerax.core.appConfig.deviceSurfaceManagerProvider", wr.class, null);
    public static final bi e = new bi("camerax.core.appConfig.useCaseConfigFactoryProvider", xr.class, null);
    public static final bi f = new bi("camerax.core.appConfig.cameraExecutor", Executor.class, null);
    public static final bi i = new bi("camerax.core.appConfig.schedulerHandler", Handler.class, null);
    public static final bi j = new bi("camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE, null);
    public static final bi k = new bi("camerax.core.appConfig.availableCamerasLimiter", ju.class, null);
    public static final bi n = new bi("camerax.core.appConfig.cameraOpenRetryMaxTimeoutInMillisWhileResuming", Long.TYPE, null);
    public static final bi s = new bi("camerax.core.appConfig.cameraProviderInitRetryPolicy", q72.class, null);
    public static final bi t = new bi("camerax.core.appConfig.quirksSettings", i22.class, null);
    public final gs1 a;

    public qv(gs1 gs1Var) {
        this.a = gs1Var;
    }

    public final ju l() {
        Object objF;
        try {
            objF = this.a.f(k);
        } catch (IllegalArgumentException unused) {
            objF = null;
        }
        return (ju) objF;
    }

    public final vr m() {
        Object objF;
        try {
            objF = this.a.f(b);
        } catch (IllegalArgumentException unused) {
            objF = null;
        }
        return (vr) objF;
    }

    @Override // defpackage.x22
    public final s30 n() {
        return this.a;
    }

    public final long o() {
        Object objF = -1L;
        try {
            objF = this.a.f(n);
        } catch (IllegalArgumentException unused) {
        }
        return ((Long) objF).longValue();
    }

    public final wr u() {
        Object objF;
        try {
            objF = this.a.f(c);
        } catch (IllegalArgumentException unused) {
            objF = null;
        }
        return (wr) objF;
    }

    public final xr v() {
        Object objF;
        try {
            objF = this.a.f(e);
        } catch (IllegalArgumentException unused) {
            objF = null;
        }
        return (xr) objF;
    }
}
