package defpackage;

import android.animation.ValueAnimator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pb2 implements qy0 {
    public float a;
    public ValueAnimator b;
    public final /* synthetic */ rb2 c;

    public pb2(rb2 rb2Var) {
        this.c = rb2Var;
    }

    @Override // defpackage.qy0
    public final void a(long j, pr prVar) {
        xq4.c(3, "ScreenFlashView");
        rb2 rb2Var = this.c;
        this.a = rb2Var.getBrightness();
        rb2Var.setBrightness(1.0f);
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        Objects.requireNonNull(prVar);
        s7 s7Var = new s7(25, prVar);
        xq4.c(3, "ScreenFlashView");
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(rb2Var.getVisibilityRampUpAnimationDurationMillis());
        valueAnimatorOfFloat.addUpdateListener(new yg0(rb2Var, 1));
        valueAnimatorOfFloat.addListener(new qb2(s7Var));
        valueAnimatorOfFloat.start();
        this.b = valueAnimatorOfFloat;
    }

    @Override // defpackage.qy0
    public final void clear() {
        xq4.c(3, "ScreenFlashView");
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.b = null;
        }
        rb2 rb2Var = this.c;
        rb2Var.setAlpha(0.0f);
        rb2Var.setBrightness(this.a);
    }
}
