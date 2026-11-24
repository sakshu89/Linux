package defpackage;

import android.hardware.camera2.params.OutputConfiguration;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class at1 extends ys1 {
    @Override // defpackage.ys1
    public Object a() {
        Object obj = this.a;
        hh1.b(obj instanceof zs1);
        return ((zs1) obj).a;
    }

    @Override // defpackage.ys1
    public final String b() {
        return null;
    }

    @Override // defpackage.ys1
    public void c(long j) {
        ((zs1) this.a).b = j;
    }

    @Override // defpackage.ys1
    public final void e(String str) {
        ((OutputConfiguration) a()).setPhysicalCameraId(str);
    }
}
