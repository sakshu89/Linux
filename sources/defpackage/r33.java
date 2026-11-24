package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r33 extends ReplacementSpan {
    public final q33 b;
    public TextPaint f;
    public final Paint.FontMetricsInt a = new Paint.FontMetricsInt();
    public short c = -1;
    public float e = 1.0f;

    public r33(q33 q33Var) {
        hh1.d(q33Var, "rasterizer cannot be null");
        this.b = q33Var;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0046  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        TextPaint textPaint = null;
        if (charSequence instanceof Spanned) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i, i2, CharacterStyle.class);
            if (characterStyleArr.length != 0) {
                if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                    TextPaint textPaint2 = this.f;
                    if (textPaint2 == null) {
                        textPaint2 = new TextPaint();
                        this.f = textPaint2;
                    }
                    textPaint = textPaint2;
                    textPaint.set(paint);
                    for (CharacterStyle characterStyle : characterStyleArr) {
                        if (!(characterStyle instanceof MetricAffectingSpan)) {
                            characterStyle.updateDrawState(textPaint);
                        }
                    }
                } else if (paint instanceof TextPaint) {
                    textPaint = (TextPaint) paint;
                }
            } else if (paint instanceof TextPaint) {
                textPaint = (TextPaint) paint;
            }
        } else if (paint instanceof TextPaint) {
            textPaint = (TextPaint) paint;
        }
        TextPaint textPaint3 = textPaint;
        if (textPaint3 != null && textPaint3.bgColor != 0) {
            int color = textPaint3.getColor();
            Paint.Style style = textPaint3.getStyle();
            textPaint3.setColor(textPaint3.bgColor);
            textPaint3.setStyle(Paint.Style.FILL);
            canvas.drawRect(f, i3, f + this.c, i5, textPaint3);
            textPaint3.setStyle(style);
            textPaint3.setColor(color);
        }
        oh0.a().getClass();
        float f2 = i4;
        Paint paint2 = textPaint3;
        if (textPaint3 == null) {
            paint2 = paint;
        }
        q33 q33Var = this.b;
        p6 p6Var = q33Var.b;
        Typeface typeface = (Typeface) p6Var.e;
        Typeface typeface2 = paint2.getTypeface();
        paint2.setTypeface(typeface);
        canvas.drawText((char[]) p6Var.b, q33Var.a * 2, 2, f, f2, paint2);
        paint2.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        q33 q33Var = this.b;
        gj1 gj1VarB = q33Var.b();
        int iA = gj1VarB.a(14);
        this.e = fAbs / (iA != 0 ? ((ByteBuffer) gj1VarB.e).getShort(iA + gj1VarB.a) : (short) 0);
        gj1 gj1VarB2 = q33Var.b();
        int iA2 = gj1VarB2.a(14);
        if (iA2 != 0) {
            ((ByteBuffer) gj1VarB2.e).getShort(iA2 + gj1VarB2.a);
        }
        gj1 gj1VarB3 = q33Var.b();
        int iA3 = gj1VarB3.a(12);
        short s = (short) ((iA3 != 0 ? ((ByteBuffer) gj1VarB3.e).getShort(iA3 + gj1VarB3.a) : (short) 0) * this.e);
        this.c = s;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s;
    }
}
