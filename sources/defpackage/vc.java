package defpackage;

import android.os.Build;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vc implements w73 {
    public final ViewConfiguration a;

    public vc(ViewConfiguration viewConfiguration) {
        this.a = viewConfiguration;
    }

    @Override // defpackage.w73
    public final float a() {
        return this.a.getScaledMaximumFlingVelocity();
    }

    @Override // defpackage.w73
    public final long b() {
        return ViewConfiguration.getDoubleTapTimeout();
    }

    @Override // defpackage.w73
    public final long c() {
        return ViewConfiguration.getLongPressTimeout();
    }

    @Override // defpackage.w73
    public final float d() {
        return this.a.getScaledTouchSlop();
    }

    @Override // defpackage.w73
    public final float e() {
        if (Build.VERSION.SDK_INT >= 34) {
            return this.a.getScaledHandwritingSlop();
        }
        return 2.0f;
    }

    @Override // defpackage.w73
    public final float f() {
        if (Build.VERSION.SDK_INT >= 34) {
            return this.a.getScaledHandwritingGestureLineMargin();
        }
        return 16.0f;
    }
}
