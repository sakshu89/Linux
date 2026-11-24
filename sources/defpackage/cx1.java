package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cx1 extends ReplacementSpan {
    public Paint.FontMetricsInt a;
    public int b;
    public int c;
    public boolean e;

    public final Paint.FontMetricsInt a() {
        Paint.FontMetricsInt fontMetricsInt = this.a;
        if (fontMetricsInt != null) {
            return fontMetricsInt;
        }
        g31.f("fontMetrics");
        throw null;
    }

    public final int b() {
        if (!this.e) {
            a11.b("PlaceholderSpan is not laid out yet.");
        }
        return this.c;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        this.e = true;
        paint.getTextSize();
        this.a = paint.getFontMetricsInt();
        if (a().descent <= a().ascent) {
            a11.a("Invalid fontMetrics: line height can not be negative.");
        }
        this.b = (int) Math.ceil(0.0d);
        this.c = (int) Math.ceil(0.0d);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = a().ascent;
            fontMetricsInt.descent = a().descent;
            fontMetricsInt.leading = a().leading;
            if (fontMetricsInt.ascent > (-b())) {
                fontMetricsInt.ascent = -b();
            }
            fontMetricsInt.top = Math.min(a().top, fontMetricsInt.ascent);
            fontMetricsInt.bottom = Math.max(a().bottom, fontMetricsInt.descent);
        }
        if (!this.e) {
            a11.b("PlaceholderSpan is not laid out yet.");
        }
        return this.b;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
    }
}
