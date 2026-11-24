package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pa3 extends AnimatorListenerAdapter {
    public final /* synthetic */ xa3 a;
    public final /* synthetic */ View b;

    public pa3(xa3 xa3Var, View view) {
        this.a = xa3Var;
        this.b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        xa3 xa3Var = this.a;
        xa3Var.a.e(1.0f);
        sa3.f(xa3Var, this.b);
    }
}
