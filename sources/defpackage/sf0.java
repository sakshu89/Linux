package defpackage;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sf0 extends CharacterStyle implements UpdateAppearance {
    public final wm4 a;

    public sf0(wm4 wm4Var) {
        this.a = wm4Var;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        Paint.Join join;
        Paint.Cap cap;
        if (textPaint != null) {
            ql0 ql0Var = ql0.a;
            wm4 wm4Var = this.a;
            if (g31.a(wm4Var, ql0Var)) {
                textPaint.setStyle(Paint.Style.FILL);
                return;
            }
            if (!(wm4Var instanceof ks2)) {
                dk0.l();
                return;
            }
            textPaint.setStyle(Paint.Style.STROKE);
            ks2 ks2Var = (ks2) wm4Var;
            textPaint.setStrokeWidth(ks2Var.a);
            textPaint.setStrokeMiter(ks2Var.b);
            int i = ks2Var.d;
            if (i == 0) {
                join = Paint.Join.MITER;
            } else if (i == 1) {
                join = Paint.Join.ROUND;
            } else {
                join = i == 2 ? Paint.Join.BEVEL : Paint.Join.MITER;
            }
            textPaint.setStrokeJoin(join);
            int i2 = ks2Var.c;
            if (i2 == 0) {
                cap = Paint.Cap.BUTT;
            } else if (i2 == 1) {
                cap = Paint.Cap.ROUND;
            } else {
                cap = i2 == 2 ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
            }
            textPaint.setStrokeCap(cap);
            textPaint.setPathEffect(null);
        }
    }
}
