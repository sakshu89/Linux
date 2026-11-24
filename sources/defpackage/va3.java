package defpackage;

import android.view.WindowInsetsAnimation;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class va3 extends wa3 {
    public final WindowInsetsAnimation e;

    public va3(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.e = windowInsetsAnimation;
    }

    @Override // defpackage.wa3
    public final float a() {
        return this.e.getAlpha();
    }

    @Override // defpackage.wa3
    public final long b() {
        return this.e.getDurationMillis();
    }

    @Override // defpackage.wa3
    public final float c() {
        return this.e.getInterpolatedFraction();
    }

    @Override // defpackage.wa3
    public final int d() {
        return this.e.getTypeMask();
    }

    @Override // defpackage.wa3
    public final void e(float f) {
        this.e.setFraction(f);
    }
}
