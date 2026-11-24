package defpackage;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yg0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ View b;

    public /* synthetic */ yg0(View view, int i) {
        this.a = i;
        this.b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.a;
        View view = this.b;
        switch (i) {
            case 0:
                zg0 zg0Var = (zg0) view;
                valueAnimator.getClass();
                Object animatedValue = valueAnimator.getAnimatedValue();
                animatedValue.getClass();
                zg0Var.c = ((Float) animatedValue).floatValue();
                zg0Var.invalidate();
                break;
            default:
                ((Float) valueAnimator.getAnimatedValue()).getClass();
                xq4.c(3, "ScreenFlashView");
                ((rb2) view).setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
