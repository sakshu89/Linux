package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ws1 {
    public final ys1 a;

    public ws1(int i, Surface surface) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            this.a = new bt1(new OutputConfiguration(i, surface));
        } else if (i2 >= 28) {
            this.a = new at1(new zs1(new OutputConfiguration(i, surface)));
        } else {
            this.a = new ys1(new xs1(new OutputConfiguration(i, surface)));
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ws1)) {
            return false;
        }
        return this.a.equals(((ws1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public ws1(ys1 ys1Var) {
        this.a = ys1Var;
    }
}
