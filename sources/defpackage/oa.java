package defpackage;

import android.graphics.PathMeasure;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oa {
    public final PathMeasure a;

    public oa(PathMeasure pathMeasure) {
        this.a = pathMeasure;
    }

    public final void a(float f, float f2, na naVar) {
        if (naVar == null) {
            dk0.r("Unable to obtain android.graphics.Path");
        } else {
            this.a.getSegment(f, f2, naVar.a, true);
        }
    }
}
