package defpackage;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oa3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ xa3 a;
    public final /* synthetic */ pb3 b;
    public final /* synthetic */ pb3 c;
    public final /* synthetic */ int d;
    public final /* synthetic */ View e;

    public oa3(xa3 xa3Var, pb3 pb3Var, pb3 pb3Var2, int i, View view) {
        this.a = xa3Var;
        this.b = pb3Var;
        this.c = pb3Var2;
        this.d = i;
        this.e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        db3 za3Var;
        float animatedFraction = valueAnimator.getAnimatedFraction();
        xa3 xa3Var = this.a;
        wa3 wa3Var = xa3Var.a;
        wa3Var.e(animatedFraction);
        float fC = wa3Var.c();
        PathInterpolator pathInterpolator = sa3.e;
        int i = Build.VERSION.SDK_INT;
        pb3 pb3Var = this.b;
        if (i >= 34) {
            za3Var = new cb3(pb3Var);
        } else if (i >= 31) {
            za3Var = new bb3(pb3Var);
        } else if (i >= 30) {
            za3Var = new ab3(pb3Var);
        } else {
            za3Var = i >= 29 ? new za3(pb3Var) : new ya3(pb3Var);
        }
        int i2 = 1;
        while (i2 <= 512) {
            int i3 = this.d & i2;
            lb3 lb3Var = pb3Var.a;
            if (i3 == 0) {
                za3Var.c(i2, lb3Var.f(i2));
            } else {
                q11 q11VarF = lb3Var.f(i2);
                q11 q11VarF2 = this.c.a.f(i2);
                int i4 = q11VarF.a;
                int i5 = q11VarF.d;
                int i6 = q11VarF.c;
                int i7 = q11VarF.b;
                float f = 1.0f - fC;
                int i8 = (int) (((double) ((i4 - q11VarF2.a) * f)) + 0.5d);
                int i9 = (int) (((double) ((i7 - q11VarF2.b) * f)) + 0.5d);
                int i10 = (int) (((double) ((i6 - q11VarF2.c) * f)) + 0.5d);
                int i11 = (int) (((double) ((i5 - q11VarF2.d) * f)) + 0.5d);
                int iMax = Math.max(0, i4 - i8);
                int iMax2 = Math.max(0, i7 - i9);
                int iMax3 = Math.max(0, i6 - i10);
                int iMax4 = Math.max(0, i5 - i11);
                za3Var.c(i2, (iMax == i8 && iMax2 == i9 && iMax3 == i10 && iMax4 == i11) ? q11VarF : q11.b(iMax, iMax2, iMax3, iMax4));
            }
            i2 <<= 1;
            xa3Var = xa3Var;
            pb3Var = pb3Var;
            fC = fC;
        }
        sa3.h(this.e, za3Var.b(), Collections.singletonList(xa3Var));
    }
}
