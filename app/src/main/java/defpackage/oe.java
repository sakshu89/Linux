package defpackage;

import android.text.SegmentFinder;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oe extends SegmentFinder {
    public final /* synthetic */ cu2 a;

    public oe(cu2 cu2Var) {
        this.a = cu2Var;
    }

    public final int nextEndBoundary(int i) {
        return this.a.d(i);
    }

    public final int nextStartBoundary(int i) {
        return this.a.e(i);
    }

    public final int previousEndBoundary(int i) {
        return this.a.f(i);
    }

    public final int previousStartBoundary(int i) {
        return this.a.a(i);
    }
}
