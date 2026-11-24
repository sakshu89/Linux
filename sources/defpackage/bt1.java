package defpackage;

import android.hardware.camera2.params.OutputConfiguration;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bt1 extends at1 {
    @Override // defpackage.at1, defpackage.ys1
    public final Object a() {
        Object obj = this.a;
        hh1.b(obj instanceof OutputConfiguration);
        return obj;
    }

    @Override // defpackage.at1, defpackage.ys1
    public final void c(long j) {
        ((OutputConfiguration) a()).setDynamicRangeProfile(j);
    }

    @Override // defpackage.ys1
    public final void d(int i) {
        ((OutputConfiguration) a()).setMirrorMode(i);
    }

    @Override // defpackage.ys1
    public final void f(long j) {
        if (j == -1) {
            return;
        }
        ((OutputConfiguration) a()).setStreamUseCase(j);
    }
}
