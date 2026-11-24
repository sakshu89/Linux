package defpackage;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.animation.AnimationUtils;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h82 extends View {
    public static final int[] i = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] j = new int[0];
    public w43 a;
    public Boolean b;
    public Long c;
    public s7 e;
    public kb f;

    private final void setRippleState(boolean z) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable runnable = this.e;
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable.run();
        }
        Long l = this.c;
        long jLongValue = jCurrentAnimationTimeMillis - (l != null ? l.longValue() : 0L);
        if (z || jLongValue >= 5) {
            int[] iArr = z ? i : j;
            w43 w43Var = this.a;
            if (w43Var != null) {
                w43Var.setState(iArr);
            }
        } else {
            s7 s7Var = new s7(24, this);
            this.e = s7Var;
            postDelayed(s7Var, 50L);
        }
        this.c = Long.valueOf(jCurrentAnimationTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRippleState$lambda$1(h82 h82Var) {
        w43 w43Var = h82Var.a;
        if (w43Var != null) {
            w43Var.setState(j);
        }
        h82Var.e = null;
    }

    public final void b(b02 b02Var, boolean z, long j2, int i2, long j3, kb kbVar) {
        if (this.a == null || !Boolean.valueOf(z).equals(this.b)) {
            w43 w43Var = new w43(z);
            setBackground(w43Var);
            this.a = w43Var;
            this.b = Boolean.valueOf(z);
        }
        w43 w43Var2 = this.a;
        w43Var2.getClass();
        this.f = kbVar;
        e(i2, j2, j3);
        if (z) {
            w43Var2.setHotspot(Float.intBitsToFloat((int) (b02Var.a >> 32)), Float.intBitsToFloat((int) (b02Var.a & 4294967295L)));
        } else {
            w43Var2.setHotspot(w43Var2.getBounds().centerX(), w43Var2.getBounds().centerY());
        }
        setRippleState(true);
    }

    public final void c() {
        this.f = null;
        s7 s7Var = this.e;
        if (s7Var != null) {
            removeCallbacks(s7Var);
            s7 s7Var2 = this.e;
            s7Var2.getClass();
            s7Var2.run();
        } else {
            w43 w43Var = this.a;
            if (w43Var != null) {
                w43Var.setState(j);
            }
        }
        w43 w43Var2 = this.a;
        if (w43Var2 == null) {
            return;
        }
        w43Var2.setVisible(false, false);
        unscheduleDrawable(w43Var2);
    }

    public final void d() {
        setRippleState(false);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        if (isAttachedToWindow()) {
            super.draw(canvas);
        } else {
            c();
        }
    }

    public final void e(int i2, long j2, long j3) {
        w43 w43Var = this.a;
        if (w43Var == null) {
            return;
        }
        Integer num = w43Var.c;
        if (num == null || num.intValue() != i2) {
            w43Var.c = Integer.valueOf(i2);
            w43Var.setRadius(i2);
        }
        float f = Build.VERSION.SDK_INT < 28 ? 0.2f : 0.1f;
        if (f > 1.0f) {
            f = 1.0f;
        }
        long jB = sz.b(f, j3);
        sz szVar = w43Var.b;
        if (!(szVar == null ? false : sz.c(szVar.a, jB))) {
            w43Var.b = new sz(jB);
            w43Var.setColor(ColorStateList.valueOf(ki4.g(jB)));
        }
        Rect rect = new Rect(0, 0, hh1.f(Float.intBitsToFloat((int) (j2 >> 32))), hh1.f(Float.intBitsToFloat((int) (j2 & 4294967295L))));
        setLeft(rect.left);
        setTop(rect.top);
        setRight(rect.right);
        setBottom(rect.bottom);
        w43Var.setBounds(rect);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        kb kbVar = this.f;
        if (kbVar != null) {
            kbVar.a();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }
}
