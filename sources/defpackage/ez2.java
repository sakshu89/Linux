package defpackage;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Trace;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ez2 {
    public final TextPaint a;
    public final TextUtils.TruncateAt b;
    public final boolean c;
    public final boolean d;
    public ye e;
    public final Layout f;
    public final int g;
    public final int h;
    public final int i;
    public final float j;
    public final float k;
    public final boolean l;
    public final Paint.FontMetricsInt m;
    public final int n;
    public final cc1[] o;
    public final Rect p = new Rect();
    public cj q;

    /* JADX WARN: Code duplicated, block: B:57:0x012a  */
    /* JADX WARN: Code duplicated, block: B:74:0x0161  */
    /* JADX WARN: Code duplicated, block: B:86:0x0178  */
    /* JADX WARN: Code duplicated, block: B:97:0x01a3 A[PHI: r14
      0x01a3: PHI (r14v7 int) = (r14v6 int), (r14v9 int) binds: [B:102:0x01b5, B:95:0x019c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r25v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18, types: [android.graphics.Paint$FontMetricsInt] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    public ez2(CharSequence charSequence, float f, TextPaint textPaint, int i, TextUtils.TruncateAt truncateAt, int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, c71 c71Var) throws Throwable {
        int i9;
        TextDirectionHeuristic textDirectionHeuristic;
        Layout layoutA;
        cc1[] cc1VarArr;
        int i10;
        int i11;
        int i12;
        int i13;
        Throwable th;
        char c;
        long j;
        int i14;
        int i15;
        long jA;
        ?? IsFallbackLineSpacingEnabled;
        long jA2;
        int i16;
        ?? r6;
        int i17;
        this.a = textPaint;
        this.b = truncateAt;
        this.c = z;
        int length = charSequence.length();
        TextDirectionHeuristic textDirectionHeuristicB = iz2.b(i2);
        Layout.Alignment alignment = ww2.a;
        Layout.Alignment alignment2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? Layout.Alignment.ALIGN_NORMAL : ww2.b : ww2.a : Layout.Alignment.ALIGN_CENTER : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        boolean z2 = (charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(-1, length, sk.class) < length;
        Trace.beginSection("TextLayout:initLayout");
        try {
            BoringLayout.Metrics metricsA = c71Var.a();
            double d = f;
            int iCeil = (int) Math.ceil(d);
            if (metricsA == null || c71Var.c() > f || z2) {
                this.l = false;
                i9 = i3;
                textDirectionHeuristic = textDirectionHeuristicB;
                layoutA = la4.a(charSequence, textPaint, iCeil, charSequence.length(), textDirectionHeuristic, alignment2, i9, truncateAt, (int) Math.ceil(d), i8, z, i4, i5, i6, i7);
            } else {
                this.l = true;
                if (iCeil < 0) {
                    a11.a("negative width");
                }
                if (iCeil < 0) {
                    a11.a("negative ellipsized width");
                }
                layoutA = Build.VERSION.SDK_INT >= 33 ? c3.i(charSequence, textPaint, iCeil, alignment2, metricsA, z, truncateAt, iCeil) : new BoringLayout(charSequence, textPaint, iCeil, alignment2, 1.0f, 0.0f, metricsA, z, truncateAt, iCeil);
                i9 = i3;
                textDirectionHeuristic = textDirectionHeuristicB;
            }
            this.f = layoutA;
            Trace.endSection();
            int iMin = Math.min(layoutA.getLineCount(), i9);
            this.g = iMin;
            int i18 = iMin - 1;
            this.d = iMin >= i9 && (layoutA.getEllipsisCount(i18) > 0 || layoutA.getLineEnd(i18) != charSequence.length());
            if (layoutA.getText() instanceof Spanned) {
                CharSequence text = layoutA.getText();
                text.getClass();
                if (o54.b((Spanned) text, cc1.class) || layoutA.getText().length() <= 0) {
                    CharSequence text2 = layoutA.getText();
                    text2.getClass();
                    i10 = 0;
                    cc1VarArr = (cc1[]) ((Spanned) text2).getSpans(0, layoutA.getText().length(), cc1.class);
                } else {
                    cc1VarArr = null;
                    i10 = 0;
                }
            } else {
                cc1VarArr = null;
                i10 = 0;
            }
            this.o = cc1VarArr;
            if (cc1VarArr == null) {
                i11 = 2;
                i12 = i10;
            } else {
                cc1 cc1Var = cc1VarArr.length == 0 ? null : cc1VarArr[i10];
                if (cc1Var != null) {
                    if (cc1Var.c) {
                        i11 = 2;
                        i17 = cc1Var.i == 2 ? 1 : i17;
                        i12 = i17;
                    } else {
                        i11 = 2;
                    }
                    i17 = i10;
                    i12 = i17;
                } else {
                    i11 = 2;
                    i12 = i10;
                }
            }
            if (cc1VarArr == null) {
                i13 = i10;
            } else {
                cc1 cc1Var2 = cc1VarArr.length == 0 ? null : cc1VarArr[i10];
                if (cc1Var2 != null && cc1Var2.e && cc1Var2.i == i11) {
                    i13 = 1;
                } else {
                    i13 = i10;
                }
            }
            if (i12 == 0 || i13 == 0) {
                long jA3 = iz2.b;
                if (z) {
                    th = null;
                    c = ' ';
                    j = 4294967295L;
                    i14 = 1;
                    i15 = 33;
                } else {
                    if (this.l) {
                        BoringLayout boringLayout = (BoringLayout) layoutA;
                        i15 = 33;
                        if (Build.VERSION.SDK_INT >= 33) {
                            IsFallbackLineSpacingEnabled = boringLayout.isFallbackLineSpacingEnabled();
                        } else {
                            IsFallbackLineSpacingEnabled = i10;
                        }
                    } else {
                        i15 = 33;
                        StaticLayout staticLayout = (StaticLayout) layoutA;
                        int i19 = Build.VERSION.SDK_INT;
                        if (i19 >= 33) {
                            IsFallbackLineSpacingEnabled = staticLayout.isFallbackLineSpacingEnabled();
                        } else if (i19 >= 28) {
                            IsFallbackLineSpacingEnabled = 1;
                        } else {
                            IsFallbackLineSpacingEnabled = i10;
                        }
                    }
                    if (IsFallbackLineSpacingEnabled != 0) {
                        th = null;
                        c = ' ';
                        j = 4294967295L;
                        i14 = 1;
                    } else {
                        TextPaint paint = layoutA.getPaint();
                        CharSequence text3 = layoutA.getText();
                        th = null;
                        c = ' ';
                        Rect rectA = ps4.a(paint, text3, layoutA.getLineStart(i10), layoutA.getLineEnd(i10));
                        int lineAscent = layoutA.getLineAscent(i10);
                        j = 4294967295L;
                        int i20 = rectA.top;
                        int topPadding = i20 < lineAscent ? lineAscent - i20 : layoutA.getTopPadding();
                        i14 = 1;
                        rectA = iMin != 1 ? ps4.a(paint, text3, layoutA.getLineStart(i18), layoutA.getLineEnd(i18)) : rectA;
                        int lineDescent = layoutA.getLineDescent(i18);
                        int i21 = rectA.bottom;
                        int bottomPadding = i21 > lineDescent ? i21 - lineDescent : layoutA.getBottomPadding();
                        if (topPadding != 0 || bottomPadding != 0) {
                            jA3 = iz2.a(topPadding, bottomPadding);
                        }
                    }
                }
                jA = iz2.a(i12 != 0 ? i10 : (int) (jA3 >> c), i13 != 0 ? i10 : (int) (jA3 & j));
            } else {
                jA = iz2.b;
                th = null;
                c = ' ';
                j = 4294967295L;
                i14 = 1;
                i15 = 33;
            }
            if (cc1VarArr != null) {
                int length2 = cc1VarArr.length;
                int iMax = i10;
                int iMax2 = iMax;
                for (int i22 = iMax2; i22 < length2; i22++) {
                    cc1 cc1Var3 = cc1VarArr[i22];
                    int i23 = cc1Var3.t;
                    iMax = i23 < 0 ? Math.max(iMax, Math.abs(i23)) : iMax;
                    int i24 = cc1Var3.u;
                    if (i24 < 0) {
                        iMax2 = Math.max(iMax, Math.abs(i24));
                    }
                }
                jA2 = (iMax == 0 && iMax2 == 0) ? iz2.b : iz2.a(iMax, iMax2);
            } else {
                jA2 = iz2.b;
            }
            this.h = Math.max((int) (jA >> c), (int) (jA2 >> c));
            this.i = Math.max((int) (jA & j), (int) (jA2 & j));
            TextPaint textPaint2 = this.a;
            cc1[] cc1VarArr2 = this.o;
            int i25 = this.g - i14;
            Layout layout = this.f;
            if (layout.getLineStart(i25) != layout.getLineEnd(i25) || cc1VarArr2 == null || cc1VarArr2.length == 0) {
                i16 = i10;
                r6 = th;
            } else {
                SpannableString spannableString = new SpannableString("\u200b");
                if (cc1VarArr2.length == 0) {
                    kf2.g("Array is empty.");
                    throw th;
                }
                cc1 cc1Var4 = cc1VarArr2[i10];
                spannableString.setSpan(new cc1(cc1Var4.a, spannableString.length(), (i25 == 0 || !cc1Var4.e) ? cc1Var4.e : i10, cc1Var4.e, cc1Var4.f, cc1Var4.i), i10, spannableString.length(), i15);
                i16 = i10;
                StaticLayout staticLayoutA = la4.a(spannableString, textPaint2, Integer.MAX_VALUE, spannableString.length(), textDirectionHeuristic, x61.a, Integer.MAX_VALUE, null, Integer.MAX_VALUE, 0, this.c, 0, 0, 0, 0);
                Paint.FontMetricsInt fontMetricsInt = new Paint.FontMetricsInt();
                fontMetricsInt.ascent = staticLayoutA.getLineAscent(i16);
                fontMetricsInt.descent = staticLayoutA.getLineDescent(i16);
                fontMetricsInt.top = staticLayoutA.getLineTop(i16);
                fontMetricsInt.bottom = staticLayoutA.getLineBottom(i16);
                r6 = fontMetricsInt;
            }
            this.n = r6 != 0 ? ((Paint.FontMetricsInt) r6).bottom - ((int) (e(i18) - g(i18))) : i16;
            this.m = r6;
            Layout layout2 = this.f;
            this.j = to4.a(layout2, i18, layout2.getPaint());
            Layout layout3 = this.f;
            this.k = to4.b(layout3, i18, layout3.getPaint());
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    public final int a() {
        boolean z = this.d;
        Layout layout = this.f;
        return (z ? layout.getLineBottom(this.g - 1) : layout.getHeight()) + this.h + this.i + this.n;
    }

    public final float b(int i) {
        if (i == this.g - 1) {
            return this.j + this.k;
        }
        return 0.0f;
    }

    public final cj c() {
        cj cjVar = this.q;
        if (cjVar != null) {
            return cjVar;
        }
        cj cjVar2 = new cj();
        cjVar2.b = this.f;
        ArrayList arrayList = new ArrayList();
        int length = 0;
        do {
            int iX = cs2.x(((Layout) cjVar2.b).getText(), '\n', length, 4);
            length = iX < 0 ? ((Layout) cjVar2.b).getText().length() : iX + 1;
            arrayList.add(Integer.valueOf(length));
        } while (length < ((Layout) cjVar2.b).getText().length());
        cjVar2.c = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList2.add(null);
        }
        cjVar2.e = arrayList2;
        cjVar2.f = new boolean[((ArrayList) cjVar2.c).size()];
        ((ArrayList) cjVar2.c).size();
        this.q = cjVar2;
        return cjVar2;
    }

    public final float d(int i) {
        Paint.FontMetricsInt fontMetricsInt;
        return this.h + ((i != this.g + (-1) || (fontMetricsInt = this.m) == null) ? this.f.getLineBaseline(i) : g(i) - fontMetricsInt.ascent);
    }

    public final float e(int i) {
        Paint.FontMetricsInt fontMetricsInt;
        int i2 = this.g;
        int i3 = i2 - 1;
        Layout layout = this.f;
        if (i != i3 || (fontMetricsInt = this.m) == null) {
            return this.h + layout.getLineBottom(i) + (i == i2 + (-1) ? this.i : 0);
        }
        return layout.getLineBottom(i - 1) + fontMetricsInt.bottom;
    }

    public final int f(int i) {
        ThreadLocal threadLocal = iz2.a;
        Layout layout = this.f;
        return (layout.getEllipsisCount(i) <= 0 || this.b != TextUtils.TruncateAt.END) ? layout.getLineEnd(i) : layout.getText().length();
    }

    public final float g(int i) {
        return this.f.getLineTop(i) + (i == 0 ? 0 : this.h);
    }

    public final float h(int i, boolean z) {
        return b(this.f.getLineForOffset(i)) + c().q(true, z, i);
    }

    public final float i(int i, boolean z) {
        return b(this.f.getLineForOffset(i)) + c().q(false, z, i);
    }

    public final ye j() {
        ye yeVar = this.e;
        if (yeVar != null) {
            return yeVar;
        }
        Layout layout = this.f;
        ye yeVar2 = new ye(layout.getText(), layout.getText().length(), this.a.getTextLocale());
        this.e = yeVar2;
        return yeVar2;
    }
}
