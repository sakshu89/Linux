package defpackage;

import android.os.Build;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xa3 {
    public wa3 a;

    public xa3(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new va3(d2.k(i, interpolator, j));
        } else {
            this.a = new sa3(i, interpolator, j);
        }
    }
}
