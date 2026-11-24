package defpackage;

import android.graphics.Path;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class sg {
    public static final kn a = new kn();

    public static final void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static final void b(na naVar, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9;
        double d10 = d5;
        double d11 = (d7 / 180.0d) * 3.141592653589793d;
        double dCos = Math.cos(d11);
        double dSin = Math.sin(d11);
        double d12 = ((d2 * dSin) + (d * dCos)) / d10;
        double d13 = ((d2 * dCos) + ((-d) * dSin)) / d6;
        double d14 = ((d4 * dSin) + (d3 * dCos)) / d10;
        double d15 = ((d4 * dCos) + ((-d3) * dSin)) / d6;
        double d16 = d12 - d14;
        double d17 = d13 - d15;
        double d18 = (d12 + d14) / 2.0d;
        double d19 = (d13 + d15) / 2.0d;
        double d20 = (d17 * d17) + (d16 * d16);
        if (d20 == 0.0d) {
            return;
        }
        double d21 = (1.0d / d20) - 0.25d;
        if (d21 < 0.0d) {
            double dSqrt = (float) (Math.sqrt(d20) / 1.99999d);
            b(naVar, d, d2, d3, d4, d10 * dSqrt, d6 * dSqrt, d7, z, z2);
            return;
        }
        double dSqrt2 = Math.sqrt(d21);
        double d22 = d16 * dSqrt2;
        double d23 = dSqrt2 * d17;
        if (z == z2) {
            d8 = d18 - d23;
            d9 = d19 + d22;
        } else {
            d8 = d18 + d23;
            d9 = d19 - d22;
        }
        double dAtan2 = Math.atan2(d13 - d9, d12 - d8);
        double dAtan3 = Math.atan2(d15 - d9, d14 - d8) - dAtan2;
        if (z2 != (dAtan3 >= 0.0d)) {
            dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
        }
        double d24 = d8 * d10;
        double d25 = d9 * d6;
        double d26 = (d24 * dCos) - (d25 * dSin);
        double d27 = (d25 * dCos) + (d24 * dSin);
        int iCeil = (int) Math.ceil(Math.abs((dAtan3 * 4.0d) / 3.141592653589793d));
        double dCos2 = Math.cos(d11);
        double dSin2 = Math.sin(d11);
        double dCos3 = Math.cos(dAtan2);
        double dSin3 = Math.sin(dAtan2);
        double d28 = -d10;
        double d29 = d28 * dCos2;
        double d30 = d6 * dSin2;
        double d31 = (d29 * dSin3) - (d30 * dCos3);
        double d32 = d28 * dSin2;
        double d33 = d6 * dCos2;
        double d34 = (dCos3 * d33) + (dSin3 * d32);
        double d35 = dAtan3 / ((double) iCeil);
        double d36 = dAtan2;
        double d37 = d31;
        int i = 0;
        double d38 = d34;
        double d39 = d2;
        while (i < iCeil) {
            double d40 = d36 + d35;
            double dSin4 = Math.sin(d40);
            double dCos4 = Math.cos(d40);
            int i2 = iCeil;
            double d41 = (((d10 * dCos2) * dCos4) + d26) - (d30 * dSin4);
            double d42 = (d33 * dSin4) + (d10 * dSin2 * dCos4) + d27;
            double d43 = (d29 * dSin4) - (d30 * dCos4);
            double d44 = (dCos4 * d33) + (dSin4 * d32);
            double d45 = d40 - d36;
            double dTan = Math.tan(d45 / 2.0d);
            double dSqrt3 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d45)) / 3.0d;
            naVar.a.cubicTo((float) ((d37 * dSqrt3) + d), (float) ((d38 * dSqrt3) + d39), (float) (d41 - (dSqrt3 * d43)), (float) (d42 - (dSqrt3 * d44)), (float) d41, (float) d42);
            d35 = d35;
            dSin2 = dSin2;
            d26 = d26;
            d = d41;
            i++;
            d32 = d32;
            d36 = d40;
            d38 = d44;
            d37 = d43;
            iCeil = i2;
            d39 = d42;
            d10 = d5;
        }
    }

    public static final void c(List list, na naVar) {
        iv1 iv1Var;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        List list2 = list;
        na naVar2 = naVar;
        Path path = naVar2.a;
        Path path2 = naVar2.a;
        Path.FillType fillType = path.getFillType();
        Path.FillType fillType2 = Path.FillType.EVEN_ODD;
        boolean z = fillType == fillType2;
        path2.rewind();
        if (!z) {
            fillType2 = Path.FillType.WINDING;
        }
        path2.setFillType(fillType2);
        iv1 iv1Var2 = list2.isEmpty() ? qu1.c : (iv1) list2.get(0);
        int size = list2.size();
        float f9 = 0.0f;
        int i = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        while (i < size) {
            iv1 iv1Var3 = (iv1) list2.get(i);
            if (iv1Var3 instanceof qu1) {
                path2.close();
                path2 = path2;
                size = size;
                f9 = f9;
                i = i;
                iv1Var = iv1Var3;
                f10 = f14;
                f12 = f10;
                f11 = f15;
                f13 = f11;
            } else {
                if (iv1Var3 instanceof cv1) {
                    cv1 cv1Var = (cv1) iv1Var3;
                    float f16 = cv1Var.c;
                    f12 += f16;
                    float f17 = cv1Var.d;
                    f13 += f17;
                    path2.rMoveTo(f16, f17);
                    path2 = path2;
                    f14 = f12;
                    f15 = f13;
                } else if (iv1Var3 instanceof uu1) {
                    uu1 uu1Var = (uu1) iv1Var3;
                    float f18 = uu1Var.c;
                    float f19 = uu1Var.d;
                    path2.moveTo(f18, f19);
                    f13 = f19;
                    f15 = f13;
                    f12 = f18;
                    f14 = f12;
                } else if (iv1Var3 instanceof bv1) {
                    bv1 bv1Var = (bv1) iv1Var3;
                    float f20 = bv1Var.d;
                    float f21 = bv1Var.c;
                    path2.rLineTo(f21, f20);
                    f12 += f21;
                    f13 += f20;
                } else if (iv1Var3 instanceof tu1) {
                    tu1 tu1Var = (tu1) iv1Var3;
                    float f22 = tu1Var.d;
                    float f23 = tu1Var.c;
                    naVar2.d(f23, f22);
                    f12 = f23;
                    f13 = f22;
                } else if (iv1Var3 instanceof av1) {
                    float f24 = ((av1) iv1Var3).c;
                    path2.rLineTo(f24, f9);
                    f12 += f24;
                } else if (iv1Var3 instanceof su1) {
                    float f25 = ((su1) iv1Var3).c;
                    naVar2.d(f25, f13);
                    f12 = f25;
                } else {
                    if (iv1Var3 instanceof gv1) {
                        f8 = ((gv1) iv1Var3).c;
                        path2.rLineTo(f9, f8);
                    } else if (iv1Var3 instanceof hv1) {
                        float f26 = ((hv1) iv1Var3).c;
                        naVar2.d(f12, f26);
                        f13 = f26;
                    } else if (iv1Var3 instanceof zu1) {
                        zu1 zu1Var = (zu1) iv1Var3;
                        path2.rCubicTo(zu1Var.c, zu1Var.d, zu1Var.e, zu1Var.f, zu1Var.g, zu1Var.h);
                        f10 = zu1Var.e + f12;
                        f11 = zu1Var.f + f13;
                        f12 += zu1Var.g;
                        f8 = zu1Var.h;
                    } else {
                        if (iv1Var3 instanceof ru1) {
                            ru1 ru1Var = (ru1) iv1Var3;
                            path2.cubicTo(ru1Var.c, ru1Var.d, ru1Var.e, ru1Var.f, ru1Var.g, ru1Var.h);
                            f10 = ru1Var.e;
                            f11 = ru1Var.f;
                            f4 = ru1Var.g;
                            f5 = ru1Var.h;
                        } else if (iv1Var3 instanceof ev1) {
                            if (iv1Var2.a) {
                                f7 = f13 - f11;
                                f6 = f12 - f10;
                            } else {
                                f6 = f9;
                                f7 = f6;
                            }
                            ev1 ev1Var = (ev1) iv1Var3;
                            path2.rCubicTo(f6, f7, ev1Var.c, ev1Var.d, ev1Var.e, ev1Var.f);
                            f10 = ev1Var.c + f12;
                            f11 = ev1Var.d + f13;
                            f12 += ev1Var.e;
                            f8 = ev1Var.f;
                        } else if (iv1Var3 instanceof wu1) {
                            if (iv1Var2.a) {
                                f12 = (f12 * 2.0f) - f10;
                                f13 = (2.0f * f13) - f11;
                            }
                            wu1 wu1Var = (wu1) iv1Var3;
                            path2.cubicTo(f12, f13, wu1Var.c, wu1Var.d, wu1Var.e, wu1Var.f);
                            f10 = wu1Var.c;
                            f11 = wu1Var.d;
                            f4 = wu1Var.e;
                            f5 = wu1Var.f;
                        } else if (iv1Var3 instanceof dv1) {
                            dv1 dv1Var = (dv1) iv1Var3;
                            float f27 = dv1Var.f;
                            float f28 = dv1Var.e;
                            float f29 = dv1Var.d;
                            float f30 = dv1Var.c;
                            path2.rQuadTo(f30, f29, f28, f27);
                            float f31 = f30 + f12;
                            float f32 = f29 + f13;
                            f12 += f28;
                            f13 += f27;
                            f10 = f31;
                            f11 = f32;
                        } else {
                            if (iv1Var3 instanceof vu1) {
                                vu1 vu1Var = (vu1) iv1Var3;
                                float f33 = vu1Var.f;
                                float f34 = vu1Var.e;
                                float f35 = vu1Var.d;
                                f3 = vu1Var.c;
                                path2.quadTo(f3, f35, f34, f33);
                                f13 = f33;
                                f12 = f34;
                                f11 = f35;
                            } else if (iv1Var3 instanceof fv1) {
                                if (iv1Var2.b) {
                                    f = f12 - f10;
                                    f2 = f13 - f11;
                                } else {
                                    f = f9;
                                    f2 = f;
                                }
                                fv1 fv1Var = (fv1) iv1Var3;
                                float f36 = fv1Var.d;
                                float f37 = fv1Var.c;
                                path2.rQuadTo(f, f2, f37, f36);
                                f3 = f + f12;
                                float f38 = f2 + f13;
                                f12 += f37;
                                f13 += f36;
                                f11 = f38;
                            } else if (iv1Var3 instanceof xu1) {
                                if (iv1Var2.b) {
                                    f12 = (f12 * 2.0f) - f10;
                                    f13 = (2.0f * f13) - f11;
                                }
                                xu1 xu1Var = (xu1) iv1Var3;
                                float f39 = xu1Var.d;
                                float f40 = xu1Var.c;
                                path2.quadTo(f12, f13, f40, f39);
                                path2 = path2;
                                size = size;
                                f9 = f9;
                                i = i;
                                f11 = f13;
                                iv1Var = iv1Var3;
                                f13 = f39;
                                f10 = f12;
                                f12 = f40;
                            } else if (iv1Var3 instanceof yu1) {
                                yu1 yu1Var = (yu1) iv1Var3;
                                float f41 = yu1Var.h + f12;
                                float f42 = yu1Var.i + f13;
                                size = size;
                                f9 = 0.0f;
                                path2 = path2;
                                i = i;
                                b(naVar, f12, f13, f41, f42, yu1Var.c, yu1Var.d, yu1Var.e, yu1Var.f, yu1Var.g);
                                f10 = f41;
                                f12 = f10;
                                f11 = f42;
                                f13 = f11;
                                iv1Var = iv1Var3;
                            } else {
                                path2 = path2;
                                size = size;
                                f9 = f9;
                                i = i;
                                if (!(iv1Var3 instanceof pu1)) {
                                    dk0.l();
                                    return;
                                }
                                pu1 pu1Var = (pu1) iv1Var3;
                                float f43 = pu1Var.i;
                                float f44 = pu1Var.h;
                                iv1Var = iv1Var3;
                                b(naVar, f12, f13, f44, f43, pu1Var.c, pu1Var.d, pu1Var.e, pu1Var.f, pu1Var.g);
                                f11 = f43;
                                f13 = f11;
                                f10 = f44;
                                f12 = f10;
                            }
                            size = size;
                            f9 = f9;
                            i = i;
                            iv1Var = iv1Var3;
                            f10 = f3;
                        }
                        f13 = f5;
                        f12 = f4;
                    }
                    f13 += f8;
                }
                iv1Var = iv1Var3;
            }
            i++;
            list2 = list;
            naVar2 = naVar;
            size = size;
            path2 = path2;
            iv1Var2 = iv1Var;
            f9 = f9;
        }
    }
}
