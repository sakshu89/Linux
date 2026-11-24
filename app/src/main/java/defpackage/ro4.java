package defpackage;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import android.util.DisplayMetrics;
import java.util.function.DoubleUnaryOperator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ro4 {
    /* JADX WARN: Code duplicated, block: B:62:0x012e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x0130  */
    /* JADX WARN: Code duplicated, block: B:65:0x013c  */
    /* JADX WARN: Code duplicated, block: B:67:0x015a  */
    /* JADX WARN: Code duplicated, block: B:68:0x0162  */
    /* JADX WARN: Code duplicated, block: B:69:0x017f  */
    public static p9 a(int i, int i2, int i3) {
        ColorSpace colorSpace;
        String str;
        float[] fArrA;
        ColorSpace.Rgb.TransferParameters transferParameters;
        ColorSpace rgb;
        ColorSpace rgb2;
        y72 y72Var = d00.e;
        zc4.c(i3);
        Bitmap.Config configC = zc4.c(i3);
        if (g31.a(y72Var, y72Var)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        } else if (g31.a(y72Var, d00.q)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.ACES);
        } else if (g31.a(y72Var, d00.r)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.ACESCG);
        } else if (g31.a(y72Var, d00.o)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.ADOBE_RGB);
        } else if (g31.a(y72Var, d00.j)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.BT2020);
        } else if (g31.a(y72Var, d00.i)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.BT709);
        } else if (g31.a(y72Var, d00.t)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.CIE_LAB);
        } else if (g31.a(y72Var, d00.s)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.CIE_XYZ);
        } else if (g31.a(y72Var, d00.k)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.DCI_P3);
        } else if (g31.a(y72Var, d00.l)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
        } else if (g31.a(y72Var, d00.g)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB);
        } else if (g31.a(y72Var, d00.h)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
        } else if (g31.a(y72Var, d00.f)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.LINEAR_SRGB);
        } else if (g31.a(y72Var, d00.m)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.NTSC_1953);
        } else if (g31.a(y72Var, d00.p)) {
            colorSpace = ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB);
        } else {
            if (!g31.a(y72Var, d00.n)) {
                if (Build.VERSION.SDK_INT >= 34) {
                    if (g31.a(y72Var, d00.v)) {
                        rgb2 = ColorSpace.get(ColorSpace.Named.BT2020_HLG);
                    } else {
                        rgb2 = g31.a(y72Var, d00.w) ? ColorSpace.get(ColorSpace.Named.BT2020_PQ) : null;
                    }
                    if (rgb2 != null) {
                        rgb = rgb2;
                    } else if (y72Var != null) {
                        str = y72Var.a;
                        fArrA = y72Var.d.a();
                        x13 x13Var = y72Var.g;
                        if (x13Var != null) {
                        }
                        if (transferParameters != null) {
                            rgb2 = new ColorSpace.Rgb(str, y72Var.h, fArrA, transferParameters);
                            rgb = rgb2;
                        } else {
                            float[] fArr = y72Var.h;
                            final x72 x72Var = y72Var.l;
                            final int i4 = 0;
                            DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() { // from class: c00
                                @Override // java.util.function.DoubleUnaryOperator
                                public final double applyAsDouble(double d) {
                                    int i5 = i4;
                                    hq0 hq0Var = x72Var;
                                    switch (i5) {
                                        case 0:
                                            break;
                                    }
                                    return ((Number) hq0Var.j(Double.valueOf(d))).doubleValue();
                                }
                            };
                            final x72 x72Var2 = y72Var.o;
                            final int i5 = 1;
                            rgb = new ColorSpace.Rgb(str, fArr, fArrA, doubleUnaryOperator, new DoubleUnaryOperator() { // from class: c00
                                @Override // java.util.function.DoubleUnaryOperator
                                public final double applyAsDouble(double d) {
                                    int i6 = i5;
                                    hq0 hq0Var = x72Var2;
                                    switch (i6) {
                                        case 0:
                                            break;
                                    }
                                    return ((Number) hq0Var.j(Double.valueOf(d))).doubleValue();
                                }
                            }, y72Var.e, y72Var.f);
                        }
                    } else {
                        colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                    }
                } else if (y72Var != null) {
                    str = y72Var.a;
                    fArrA = y72Var.d.a();
                    x13 x13Var2 = y72Var.g;
                    transferParameters = x13Var2 != null ? new ColorSpace.Rgb.TransferParameters(x13Var2.b, x13Var2.c, x13Var2.d, x13Var2.e, x13Var2.f, x13Var2.g, x13Var2.a) : null;
                    if (transferParameters != null) {
                        rgb2 = new ColorSpace.Rgb(str, y72Var.h, fArrA, transferParameters);
                        rgb = rgb2;
                    } else {
                        float[] fArr2 = y72Var.h;
                        final hq0 x72Var3 = y72Var.l;
                        final int i6 = 0;
                        DoubleUnaryOperator doubleUnaryOperator2 = new DoubleUnaryOperator() { // from class: c00
                            @Override // java.util.function.DoubleUnaryOperator
                            public final double applyAsDouble(double d) {
                                int i7 = i6;
                                hq0 hq0Var = x72Var3;
                                switch (i7) {
                                    case 0:
                                        break;
                                }
                                return ((Number) hq0Var.j(Double.valueOf(d))).doubleValue();
                            }
                        };
                        final hq0 x72Var4 = y72Var.o;
                        final int i7 = 1;
                        rgb = new ColorSpace.Rgb(str, fArr2, fArrA, doubleUnaryOperator2, new DoubleUnaryOperator() { // from class: c00
                            @Override // java.util.function.DoubleUnaryOperator
                            public final double applyAsDouble(double d) {
                                int i8 = i7;
                                hq0 hq0Var = x72Var4;
                                switch (i8) {
                                    case 0:
                                        break;
                                }
                                return ((Number) hq0Var.j(Double.valueOf(d))).doubleValue();
                            }
                        }, y72Var.e, y72Var.f);
                    }
                } else {
                    colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                }
                return new p9(Bitmap.createBitmap((DisplayMetrics) null, i, i2, configC, true, rgb));
            }
            colorSpace = ColorSpace.get(ColorSpace.Named.SMPTE_C);
        }
        rgb = colorSpace;
        return new p9(Bitmap.createBitmap((DisplayMetrics) null, i, i2, configC, true, rgb));
    }
}
