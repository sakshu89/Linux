package defpackage;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.SegmentFinder;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ia {
    public final ma a;
    public final int b;
    public final long c;
    public final ez2 d;
    public final CharSequence e;
    public final List f;

    /* JADX WARN: Code duplicated, block: B:100:0x012c  */
    /* JADX WARN: Code duplicated, block: B:101:0x012f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0143  */
    /* JADX WARN: Code duplicated, block: B:106:0x014e  */
    /* JADX WARN: Code duplicated, block: B:118:0x019a  */
    /* JADX WARN: Code duplicated, block: B:138:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:141:0x020d  */
    /* JADX WARN: Code duplicated, block: B:142:0x0210  */
    /* JADX WARN: Code duplicated, block: B:144:0x022a  */
    /* JADX WARN: Code duplicated, block: B:146:0x0244  */
    /* JADX WARN: Code duplicated, block: B:148:0x0248 A[LOOP:1: B:147:0x0246->B:148:0x0248, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:151:0x0273  */
    /* JADX WARN: Code duplicated, block: B:152:0x0277  */
    /* JADX WARN: Code duplicated, block: B:154:0x028f  */
    /* JADX WARN: Code duplicated, block: B:156:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:157:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:160:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:163:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:166:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:167:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:169:0x02d7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:171:0x02db  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:84:0x0101  */
    /* JADX WARN: Code duplicated, block: B:93:0x011a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0123  */
    /* JADX WARN: Code duplicated, block: B:97:0x0126  */
    /* JADX WARN: Code duplicated, block: B:98:0x0129  */
    /* JADX WARN: Instruction removed from duplicated block: B:146:0x0244, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:152:0x0277, please report this as an issue */
    public ia(ma maVar, int i, int i2, long j) {
        int i3;
        int i4;
        int i5;
        int i6;
        char c;
        TextUtils.TruncateAt truncateAt;
        TextUtils.TruncateAt truncateAt2;
        ez2 ez2VarA;
        int i7;
        ia iaVar;
        int i8;
        int i9;
        int i10;
        Layout layout;
        Spanned spanned;
        uj2[] uj2VarArr;
        CharSequence charSequence;
        Spanned spanned2;
        ArrayList arrayList;
        int i11;
        List list;
        int spanEnd;
        int lineForOffset;
        boolean z;
        boolean z2;
        boolean z3;
        l42 l42Var;
        float fH;
        int i12;
        int i13;
        this.a = maVar;
        this.b = i;
        this.c = j;
        if (q40.i(j) != 0 || q40.j(j) != 0) {
            a11.a("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        if (i < 1) {
            a11.a("maxLines should be greater than 0");
        }
        yz2 yz2Var = maVar.b;
        CharSequence charSequence2 = maVar.k;
        if (i2 == 2) {
            i3 = 0;
            if (!b03.a(yz2Var.a.h, nc4.c(0)) && !b03.a(yz2Var.a.h, b03.c) && (i13 = yz2Var.b.a) != 0 && i13 != 5 && i13 != 4 && charSequence2.length() != 0) {
                Spannable spannableString = charSequence2 instanceof Spannable ? (Spannable) charSequence2 : null;
                spannableString = spannableString == null ? new SpannableString(charSequence2) : spannableString;
                if (!o54.b(spannableString, tz0.class)) {
                    spannableString.setSpan(new tz0(), spannableString.length() - 1, spannableString.length() - 1, 33);
                }
                charSequence2 = spannableString;
            }
        } else {
            i3 = 0;
        }
        CharSequence charSequence3 = charSequence2;
        this.e = charSequence3;
        eu1 eu1Var = yz2Var.b;
        hp2 hp2Var = yz2Var.a;
        int i14 = eu1Var.a;
        int i15 = 3;
        int i16 = i14 == 1 ? 3 : i14 == 2 ? 4 : i14 == 3 ? 2 : (i14 != 5 && i14 == 6) ? 1 : i3;
        int i17 = i14 == 4 ? 1 : i3;
        int i18 = eu1Var.h == 2 ? Build.VERSION.SDK_INT <= 32 ? 2 : 4 : i3;
        int i19 = eu1Var.g;
        int i20 = i19 & 255;
        if (i20 == 1) {
            i4 = i3;
        } else if (i20 == 2) {
            i4 = 1;
        } else if (i20 == 3) {
            i4 = 2;
        } else {
            i4 = i3;
        }
        int i21 = (i19 >> 8) & 255;
        if (i21 == 1) {
            i15 = i3;
        } else if (i21 == 2) {
            i15 = 1;
        } else if (i21 == 3) {
            i15 = 2;
        } else if (i21 != 4) {
            i15 = i3;
        }
        int i22 = (i19 >> 16) & 255;
        if (i22 != 1) {
            i5 = 2;
            i6 = i22 == 2 ? 1 : i6;
            if (i2 == i5) {
                truncateAt2 = TextUtils.TruncateAt.END;
            } else {
                if (i2 == 5) {
                    if (i2 == 4) {
                        truncateAt2 = TextUtils.TruncateAt.START;
                    } else {
                        c = ' ';
                        truncateAt = null;
                    }
                    ez2VarA = a(i16, i17, truncateAt, i, i18, i4, i15, i6, charSequence3);
                    Layout layout2 = ez2VarA.f;
                    i7 = i16;
                    if (Build.VERSION.SDK_INT < 35 || maVar.j.getLetterSpacing() == 0.0f || (!(i2 == 4 || i2 == 5) || layout2.getEllipsisCount(0) <= 0)) {
                        iaVar = this;
                        i8 = i;
                        i9 = i7;
                        i10 = 2;
                    } else {
                        int ellipsisStart = layout2.getEllipsisStart(0);
                        i10 = 2;
                        CharSequence[] charSequenceArr = {charSequence3.subSequence(0, ellipsisStart), "…", charSequence3.subSequence(layout2.getEllipsisCount(0) + ellipsisStart, charSequence3.length())};
                        iaVar = this;
                        i8 = i;
                        i9 = i7;
                        ez2VarA = iaVar.a(i9, i17, truncateAt, i8, i18, i4, i15, i6, TextUtils.concat(charSequenceArr));
                    }
                    int i23 = ez2VarA.g;
                    if (i2 == i10 || ez2VarA.a() <= q40.g(j) || i8 <= 1) {
                        iaVar.d = ez2VarA;
                    } else {
                        int iG = q40.g(j);
                        int i24 = 0;
                        while (true) {
                            if (i24 >= i23) {
                                i24 = i23;
                                break;
                            } else if (ez2VarA.e(i24) > iG) {
                                break;
                            } else {
                                i24++;
                            }
                        }
                        if (i24 >= 0 && i24 != iaVar.b) {
                            ez2VarA = iaVar.a(i9, i17, truncateAt, i24 < 1 ? 1 : i24, i18, i4, i15, i6, iaVar.e);
                        }
                        iaVar.d = ez2VarA;
                    }
                    iaVar.a.j.c(hp2Var.a.d(), (((long) Float.floatToRawIntBits(iaVar.b())) & 4294967295L) | (((long) Float.floatToRawIntBits(iaVar.d())) << c), hp2Var.a.a());
                    layout = iaVar.d.f;
                    if (layout.getText() instanceof Spanned) {
                        CharSequence text = layout.getText();
                        text.getClass();
                        spanned = (Spanned) text;
                        if (spanned.nextSpanTransition(-1, spanned.length(), uj2.class) != spanned.length()) {
                            CharSequence text2 = layout.getText();
                            text2.getClass();
                            uj2VarArr = (uj2[]) ((Spanned) text2).getSpans(0, layout.getText().length(), uj2.class);
                        } else {
                            uj2VarArr = null;
                        }
                    } else {
                        uj2VarArr = null;
                    }
                    if (uj2VarArr != null) {
                        for (uj2 uj2Var : uj2VarArr) {
                            uj2Var.c.setValue(new xk2((((long) Float.floatToRawIntBits(iaVar.b())) & 4294967295L) | (((long) Float.floatToRawIntBits(iaVar.d())) << c)));
                        }
                    }
                    charSequence = iaVar.e;
                    if (charSequence instanceof Spanned) {
                        spanned2 = (Spanned) charSequence;
                        Object[] spans = spanned2.getSpans(0, charSequence.length(), cx1.class);
                        arrayList = new ArrayList(spans.length);
                        for (Object obj : spans) {
                            cx1 cx1Var = (cx1) obj;
                            int spanStart = spanned2.getSpanStart(cx1Var);
                            spanEnd = spanned2.getSpanEnd(cx1Var);
                            lineForOffset = iaVar.d.f.getLineForOffset(spanStart);
                            if (lineForOffset >= iaVar.b) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (iaVar.d.f.getEllipsisCount(lineForOffset) > 0 || spanEnd <= iaVar.d.f.getEllipsisStart(lineForOffset) + iaVar.d.f.getLineStart(lineForOffset)) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (spanEnd > iaVar.d.f(lineForOffset)) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z2 && !z3 && !z) {
                                int iOrdinal = (iaVar.d.f.isRtlCharAt(spanStart) ? p62.b : p62.a).ordinal();
                                if (iOrdinal == 0) {
                                    fH = iaVar.d.h(spanStart, false);
                                } else {
                                    if (iOrdinal != 1) {
                                        dk0.l();
                                        throw null;
                                    }
                                    float fH2 = iaVar.d.h(spanStart, false);
                                    if (!cx1Var.e) {
                                        a11.b("PlaceholderSpan is not laid out yet.");
                                    }
                                    fH = fH2 - cx1Var.b;
                                }
                                if (!cx1Var.e) {
                                    a11.b("PlaceholderSpan is not laid out yet.");
                                }
                                float f = cx1Var.b + fH;
                                float fD = iaVar.d.d(lineForOffset) - cx1Var.b();
                                l42Var = new l42(fH, fD, f, cx1Var.b() + fD);
                            }
                            arrayList.add(l42Var);
                        }
                        list = arrayList;
                    } else {
                        list = ii0.a;
                    }
                    iaVar.f = list;
                }
                truncateAt2 = TextUtils.TruncateAt.MIDDLE;
            }
            c = ' ';
            truncateAt = truncateAt2;
            ez2VarA = a(i16, i17, truncateAt, i, i18, i4, i15, i6, charSequence3);
            Layout layout3 = ez2VarA.f;
            i7 = i16;
            if (Build.VERSION.SDK_INT < 35) {
                iaVar = this;
                i8 = i;
                i9 = i7;
                i10 = 2;
            } else {
                iaVar = this;
                i8 = i;
                i9 = i7;
                i10 = 2;
            }
            int i25 = ez2VarA.g;
            if (i2 == i10) {
                iaVar.d = ez2VarA;
            } else {
                iaVar.d = ez2VarA;
            }
            iaVar.a.j.c(hp2Var.a.d(), (((long) Float.floatToRawIntBits(iaVar.b())) & 4294967295L) | (((long) Float.floatToRawIntBits(iaVar.d())) << c), hp2Var.a.a());
            layout = iaVar.d.f;
            if (layout.getText() instanceof Spanned) {
                uj2VarArr = null;
            } else {
                CharSequence text3 = layout.getText();
                text3.getClass();
                spanned = (Spanned) text3;
                if (spanned.nextSpanTransition(-1, spanned.length(), uj2.class) != spanned.length()) {
                    CharSequence text4 = layout.getText();
                    text4.getClass();
                    uj2VarArr = (uj2[]) ((Spanned) text4).getSpans(0, layout.getText().length(), uj2.class);
                } else {
                    uj2VarArr = null;
                }
            }
            if (uj2VarArr != null) {
                while (i12 < r2) {
                    uj2Var.c.setValue(new xk2((((long) Float.floatToRawIntBits(iaVar.b())) & 4294967295L) | (((long) Float.floatToRawIntBits(iaVar.d())) << c)));
                }
            }
            charSequence = iaVar.e;
            if (charSequence instanceof Spanned) {
                list = ii0.a;
            } else {
                spanned2 = (Spanned) charSequence;
                Object[] spans2 = spanned2.getSpans(0, charSequence.length(), cx1.class);
                arrayList = new ArrayList(spans2.length);
                while (i11 < r4) {
                    cx1 cx1Var2 = (cx1) obj;
                    int spanStart2 = spanned2.getSpanStart(cx1Var2);
                    spanEnd = spanned2.getSpanEnd(cx1Var2);
                    lineForOffset = iaVar.d.f.getLineForOffset(spanStart2);
                    if (lineForOffset >= iaVar.b) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (iaVar.d.f.getEllipsisCount(lineForOffset) > 0) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (spanEnd > iaVar.d.f(lineForOffset)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    l42Var = z2 ? null : null;
                    arrayList.add(l42Var);
                }
                list = arrayList;
            }
            iaVar.f = list;
        }
        i5 = 2;
        i6 = i3;
        if (i2 == i5) {
            truncateAt2 = TextUtils.TruncateAt.END;
        } else {
            if (i2 == 5) {
                if (i2 == 4) {
                    truncateAt2 = TextUtils.TruncateAt.START;
                } else {
                    c = ' ';
                    truncateAt = null;
                }
                ez2VarA = a(i16, i17, truncateAt, i, i18, i4, i15, i6, charSequence3);
                Layout layout4 = ez2VarA.f;
                i7 = i16;
                if (Build.VERSION.SDK_INT < 35) {
                    iaVar = this;
                    i8 = i;
                    i9 = i7;
                    i10 = 2;
                } else {
                    iaVar = this;
                    i8 = i;
                    i9 = i7;
                    i10 = 2;
                }
                int i26 = ez2VarA.g;
                if (i2 == i10) {
                    iaVar.d = ez2VarA;
                } else {
                    iaVar.d = ez2VarA;
                }
                iaVar.a.j.c(hp2Var.a.d(), (((long) Float.floatToRawIntBits(iaVar.b())) & 4294967295L) | (((long) Float.floatToRawIntBits(iaVar.d())) << c), hp2Var.a.a());
                layout = iaVar.d.f;
                if (layout.getText() instanceof Spanned) {
                    uj2VarArr = null;
                } else {
                    CharSequence text5 = layout.getText();
                    text5.getClass();
                    spanned = (Spanned) text5;
                    if (spanned.nextSpanTransition(-1, spanned.length(), uj2.class) != spanned.length()) {
                        CharSequence text6 = layout.getText();
                        text6.getClass();
                        uj2VarArr = (uj2[]) ((Spanned) text6).getSpans(0, layout.getText().length(), uj2.class);
                    } else {
                        uj2VarArr = null;
                    }
                }
                if (uj2VarArr != null) {
                    while (i12 < r2) {
                        uj2Var.c.setValue(new xk2((((long) Float.floatToRawIntBits(iaVar.b())) & 4294967295L) | (((long) Float.floatToRawIntBits(iaVar.d())) << c)));
                    }
                }
                charSequence = iaVar.e;
                if (charSequence instanceof Spanned) {
                    list = ii0.a;
                } else {
                    spanned2 = (Spanned) charSequence;
                    Object[] spans3 = spanned2.getSpans(0, charSequence.length(), cx1.class);
                    arrayList = new ArrayList(spans3.length);
                    while (i11 < r4) {
                        cx1 cx1Var3 = (cx1) obj;
                        int spanStart3 = spanned2.getSpanStart(cx1Var3);
                        spanEnd = spanned2.getSpanEnd(cx1Var3);
                        lineForOffset = iaVar.d.f.getLineForOffset(spanStart3);
                        if (lineForOffset >= iaVar.b) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (iaVar.d.f.getEllipsisCount(lineForOffset) > 0) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (spanEnd > iaVar.d.f(lineForOffset)) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z2) {
                        }
                        arrayList.add(l42Var);
                    }
                    list = arrayList;
                }
                iaVar.f = list;
            }
            truncateAt2 = TextUtils.TruncateAt.MIDDLE;
        }
        c = ' ';
        truncateAt = truncateAt2;
        ez2VarA = a(i16, i17, truncateAt, i, i18, i4, i15, i6, charSequence3);
        Layout layout5 = ez2VarA.f;
        i7 = i16;
        if (Build.VERSION.SDK_INT < 35) {
            iaVar = this;
            i8 = i;
            i9 = i7;
            i10 = 2;
        } else {
            iaVar = this;
            i8 = i;
            i9 = i7;
            i10 = 2;
        }
        int i27 = ez2VarA.g;
        if (i2 == i10) {
            iaVar.d = ez2VarA;
        } else {
            iaVar.d = ez2VarA;
        }
        iaVar.a.j.c(hp2Var.a.d(), (((long) Float.floatToRawIntBits(iaVar.b())) & 4294967295L) | (((long) Float.floatToRawIntBits(iaVar.d())) << c), hp2Var.a.a());
        layout = iaVar.d.f;
        if (layout.getText() instanceof Spanned) {
            uj2VarArr = null;
        } else {
            CharSequence text7 = layout.getText();
            text7.getClass();
            spanned = (Spanned) text7;
            if (spanned.nextSpanTransition(-1, spanned.length(), uj2.class) != spanned.length()) {
                CharSequence text8 = layout.getText();
                text8.getClass();
                uj2VarArr = (uj2[]) ((Spanned) text8).getSpans(0, layout.getText().length(), uj2.class);
            } else {
                uj2VarArr = null;
            }
        }
        if (uj2VarArr != null) {
            while (i12 < r2) {
                uj2Var.c.setValue(new xk2((((long) Float.floatToRawIntBits(iaVar.b())) & 4294967295L) | (((long) Float.floatToRawIntBits(iaVar.d())) << c)));
            }
        }
        charSequence = iaVar.e;
        if (charSequence instanceof Spanned) {
            list = ii0.a;
        } else {
            spanned2 = (Spanned) charSequence;
            Object[] spans4 = spanned2.getSpans(0, charSequence.length(), cx1.class);
            arrayList = new ArrayList(spans4.length);
            while (i11 < r4) {
                cx1 cx1Var4 = (cx1) obj;
                int spanStart4 = spanned2.getSpanStart(cx1Var4);
                spanEnd = spanned2.getSpanEnd(cx1Var4);
                lineForOffset = iaVar.d.f.getLineForOffset(spanStart4);
                if (lineForOffset >= iaVar.b) {
                    z = true;
                } else {
                    z = false;
                }
                if (iaVar.d.f.getEllipsisCount(lineForOffset) > 0) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                if (spanEnd > iaVar.d.f(lineForOffset)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z2) {
                }
                arrayList.add(l42Var);
            }
            list = arrayList;
        }
        iaVar.f = list;
    }

    public final ez2 a(int i, int i2, TextUtils.TruncateAt truncateAt, int i3, int i4, int i5, int i6, int i7, CharSequence charSequence) {
        nx1 nx1Var;
        float fD = d();
        ma maVar = this.a;
        lc lcVar = maVar.j;
        int i8 = maVar.u;
        c71 c71Var = maVar.n;
        yz2 yz2Var = maVar.b;
        ja jaVar = ka.a;
        cy1 cy1Var = yz2Var.c;
        return new ez2(charSequence, fD, lcVar, i, truncateAt, i8, (cy1Var == null || (nx1Var = cy1Var.a) == null) ? false : nx1Var.a, i3, i5, i6, i7, i4, i2, c71Var);
    }

    public final float b() {
        return this.d.a();
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00d1  */
    /* JADX WARN: Type inference failed for: r10v26, types: [v9] */
    public final long c(l42 l42Var, int i, kf2 kf2Var) {
        bf2 tu0Var;
        int i2;
        int[] rangeForRect;
        SegmentFinder segmentFinderM;
        RectF rectFB = py3.b(l42Var);
        int i3 = 0;
        boolean z = i != 0 && i == 1;
        final ha haVar = new ha(i3, kf2Var);
        ez2 ez2Var = this.d;
        TextPaint textPaint = ez2Var.a;
        Layout layout = ez2Var.f;
        int i4 = Build.VERSION.SDK_INT;
        int i5 = 9;
        if (i4 >= 34) {
            if (z) {
                segmentFinderM = new oe(new cu2(i5, layout.getText(), ez2Var.j()));
            } else {
                u9.o();
                segmentFinderM = u9.m(u9.l(layout.getText(), textPaint));
            }
            rangeForRect = layout.getRangeForRect(rectFB, segmentFinderM, new Layout.TextInclusionStrategy() { // from class: v9
                @Override // android.text.Layout.TextInclusionStrategy
                public final boolean isSegmentInside(RectF rectF, RectF rectF2) {
                    return ((Boolean) haVar.e(rectF, rectF2)).booleanValue();
                }
            });
        } else {
            cj cjVarC = ez2Var.c();
            if (z) {
                tu0Var = new cu2(i5, layout.getText(), ez2Var.j());
            } else {
                CharSequence text = layout.getText();
                tu0Var = i4 >= 29 ? new tu0(text, textPaint) : new tu0(text);
            }
            bf2 bf2Var = tu0Var;
            int lineForVertical = layout.getLineForVertical((int) rectFB.top);
            if (rectFB.top <= ez2Var.e(lineForVertical) || (lineForVertical = lineForVertical + 1) < ez2Var.g) {
                int i6 = lineForVertical;
                int lineForVertical2 = layout.getLineForVertical((int) rectFB.bottom);
                if (lineForVertical2 != 0 || rectFB.bottom >= ez2Var.g(0)) {
                    int iB = fc4.b(ez2Var, layout, cjVarC, i6, rectFB, bf2Var, haVar, true);
                    while (true) {
                        i2 = i6;
                        if (iB != -1 || i2 >= lineForVertical2) {
                            break;
                        }
                        i6 = i2 + 1;
                        iB = fc4.b(ez2Var, layout, cjVarC, i6, rectFB, bf2Var, haVar, true);
                    }
                    if (iB == -1) {
                        rangeForRect = null;
                    } else {
                        int i7 = lineForVertical2;
                        int iB2 = fc4.b(ez2Var, layout, cjVarC, i7, rectFB, bf2Var, haVar, false);
                        while (iB2 == -1 && i2 < i7) {
                            i7--;
                            iB2 = fc4.b(ez2Var, layout, cjVarC, i7, rectFB, bf2Var, haVar, false);
                        }
                        if (iB2 == -1) {
                            rangeForRect = null;
                        } else {
                            rangeForRect = new int[]{bf2Var.a(iB + 1), bf2Var.d(iB2 - 1)};
                        }
                    }
                } else {
                    rangeForRect = null;
                }
            } else {
                rangeForRect = null;
            }
        }
        return rangeForRect == null ? oz2.b : hc4.a(rangeForRect[0], rangeForRect[1]);
    }

    public final float d() {
        return q40.h(this.c);
    }

    public final void e(cw cwVar) {
        Canvas canvasA = v6.a(cwVar);
        ez2 ez2Var = this.d;
        if (ez2Var.d) {
            canvasA.save();
            canvasA.clipRect(0.0f, 0.0f, d(), b());
        }
        int i = ez2Var.h;
        if (canvasA.getClipBounds(ez2Var.p)) {
            if (i != 0) {
                canvasA.translate(0.0f, i);
            }
            ThreadLocal threadLocal = iz2.a;
            Object xw2Var = threadLocal.get();
            if (xw2Var == null) {
                xw2Var = new xw2();
                threadLocal.set(xw2Var);
            }
            xw2 xw2Var2 = (xw2) xw2Var;
            xw2Var2.a = canvasA;
            try {
                ez2Var.f.draw(xw2Var2);
                xw2Var2.a = null;
                if (i != 0) {
                    canvasA.translate(0.0f, (-1.0f) * i);
                }
            } catch (Throwable th) {
                xw2Var2.a = null;
                throw th;
            }
        }
        if (ez2Var.d) {
            canvasA.restore();
        }
    }

    public final void f(cw cwVar, long j, vj2 vj2Var, sx2 sx2Var, wm4 wm4Var) {
        lc lcVar = this.a.j;
        int i = lcVar.c;
        lcVar.d(j);
        lcVar.f(vj2Var);
        lcVar.g(sx2Var);
        lcVar.e(wm4Var);
        lcVar.b(3);
        e(cwVar);
        lcVar.b(i);
    }

    public final void g(cw cwVar, hn hnVar, float f, vj2 vj2Var, sx2 sx2Var, wm4 wm4Var) {
        lc lcVar = this.a.j;
        int i = lcVar.c;
        float fD = d();
        lcVar.c(hnVar, (((long) Float.floatToRawIntBits(b())) & 4294967295L) | (Float.floatToRawIntBits(fD) << 32), f);
        lcVar.f(vj2Var);
        lcVar.g(sx2Var);
        lcVar.e(wm4Var);
        lcVar.b(3);
        e(cwVar);
        lcVar.b(i);
    }
}
