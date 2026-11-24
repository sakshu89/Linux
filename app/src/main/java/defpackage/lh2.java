package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lh2 implements nh2 {
    public final SessionConfiguration a;
    public final List b;

    public lh2(ArrayList arrayList, ch2 ch2Var, vs vsVar) {
        ws1 ws1Var;
        SessionConfiguration sessionConfiguration = new SessionConfiguration(0, oh2.a(arrayList), ch2Var, vsVar);
        this.a = sessionConfiguration;
        List<OutputConfiguration> outputConfigurations = sessionConfiguration.getOutputConfigurations();
        ArrayList arrayList2 = new ArrayList(outputConfigurations.size());
        for (OutputConfiguration outputConfiguration : outputConfigurations) {
            if (outputConfiguration == null) {
                ws1Var = null;
            } else {
                int i = Build.VERSION.SDK_INT;
                ws1Var = new ws1(i >= 33 ? new bt1(outputConfiguration) : i >= 28 ? new at1(new zs1(outputConfiguration)) : new ys1(new xs1(outputConfiguration)));
            }
            arrayList2.add(ws1Var);
        }
        this.b = Collections.unmodifiableList(arrayList2);
    }

    @Override // defpackage.nh2
    public final Object a() {
        return this.a;
    }

    @Override // defpackage.nh2
    public final int b() {
        return this.a.getSessionType();
    }

    @Override // defpackage.nh2
    public final CameraCaptureSession.StateCallback c() {
        return this.a.getStateCallback();
    }

    @Override // defpackage.nh2
    public final List d() {
        return this.b;
    }

    @Override // defpackage.nh2
    public final j11 e() {
        return j11.a(this.a.getInputConfiguration());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof lh2) {
            return Objects.equals(this.a, ((lh2) obj).a);
        }
        return false;
    }

    @Override // defpackage.nh2
    public final Executor f() {
        return this.a.getExecutor();
    }

    @Override // defpackage.nh2
    public final void g(CaptureRequest captureRequest) {
        this.a.setSessionParameters(captureRequest);
    }

    @Override // defpackage.nh2
    public final void h(j11 j11Var) {
        this.a.setInputConfiguration(j11Var.a.a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
