package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zg0 extends View {
    public final Paint a;
    public rn2 b;
    public float c;
    public final ValueAnimator e;

    public zg0(Context context) {
        super(context);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(14.0f);
        this.a = paint;
        this.b = rn2.b;
        this.c = 0.45f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.35f, 0.85f);
        valueAnimatorOfFloat.setDuration(1000L);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(2);
        valueAnimatorOfFloat.addUpdateListener(new yg0(this, 0));
        this.e = valueAnimatorOfFloat;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.getClass();
        qn2 qn2VarA = uz.a(this.b);
        int iG = ki4.g(qn2VarA.c);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), new int[]{iG, ki4.g(qn2VarA.b), iG}, (float[]) null, Shader.TileMode.CLAMP);
        Paint paint = this.a;
        paint.setShader(linearGradient);
        paint.setAlpha((int) (255.0f * this.c));
        float strokeWidth = paint.getStrokeWidth() / 2.0f;
        canvas.drawRect(strokeWidth, strokeWidth, getWidth() - strokeWidth, getHeight() - strokeWidth, paint);
    }
}
