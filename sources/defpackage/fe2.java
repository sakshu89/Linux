package defpackage;

import android.widget.EdgeEffect;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fe2 {
    public final /* synthetic */ he2 a;

    public fe2(he2 he2Var) {
        this.a = he2Var;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x020f  */
    /* JADX WARN: Code duplicated, block: B:107:0x021e  */
    /* JADX WARN: Code duplicated, block: B:109:0x0223  */
    /* JADX WARN: Code duplicated, block: B:111:0x022b  */
    /* JADX WARN: Code duplicated, block: B:112:0x022f  */
    /* JADX WARN: Code duplicated, block: B:115:0x023b  */
    /* JADX WARN: Code duplicated, block: B:117:0x0240  */
    /* JADX WARN: Code duplicated, block: B:119:0x0248  */
    /* JADX WARN: Code duplicated, block: B:120:0x024c  */
    /* JADX WARN: Code duplicated, block: B:122:0x024f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:125:0x0255  */
    /* JADX WARN: Code duplicated, block: B:128:0x025d  */
    /* JADX WARN: Code duplicated, block: B:139:0x0298  */
    /* JADX WARN: Code duplicated, block: B:146:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:148:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:149:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:155:0x02da  */
    /* JADX WARN: Code duplicated, block: B:162:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:164:0x0308  */
    /* JADX WARN: Code duplicated, block: B:165:0x030c  */
    /* JADX WARN: Code duplicated, block: B:171:0x031c  */
    /* JADX WARN: Code duplicated, block: B:178:0x0339  */
    /* JADX WARN: Code duplicated, block: B:180:0x034a  */
    /* JADX WARN: Code duplicated, block: B:181:0x034e  */
    /* JADX WARN: Code duplicated, block: B:187:0x035e  */
    /* JADX WARN: Code duplicated, block: B:192:0x0366  */
    /* JADX WARN: Code duplicated, block: B:195:0x036a  */
    /* JADX WARN: Code duplicated, block: B:59:0x0116  */
    /* JADX WARN: Code duplicated, block: B:60:0x0119  */
    /* JADX WARN: Code duplicated, block: B:70:0x014b A[PHI: r8
      0x014b: PHI (r8v9 float) = (r8v8 float), (r8v12 float) binds: [B:79:0x0179, B:68:0x0144] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:71:0x014e  */
    /* JADX WARN: Code duplicated, block: B:73:0x0156  */
    /* JADX WARN: Code duplicated, block: B:83:0x0197  */
    public final long a(int i, long j) {
        long j2;
        float fIntBitsToFloat;
        int i2;
        float fG;
        float fIntBitsToFloat2;
        long jFloatToRawIntBits;
        long jD;
        long jD2;
        boolean z;
        boolean zF;
        boolean z2;
        EdgeEffect edgeEffectB;
        float fIntBitsToFloat3;
        ju0 ju0Var;
        float f;
        EdgeEffect edgeEffectE;
        float fIntBitsToFloat4;
        ju0 ju0Var2;
        float f2;
        EdgeEffect edgeEffectD;
        float fIntBitsToFloat5;
        ju0 ju0Var3;
        float f3;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        he2 he2Var = this.a;
        he2Var.j = i;
        f9 f9Var = he2Var.b;
        if (f9Var == null || !(he2Var.a.c() || he2Var.a.a())) {
            return he2Var.c(he2Var.k, j, i);
        }
        int i5 = he2Var.j;
        x0 x0Var = he2Var.m;
        xg0 xg0Var = f9Var.c;
        if (xk2.c(f9Var.g)) {
            he2 he2Var2 = (he2) x0Var.b;
            return new jp1(he2Var2.c(he2Var2.k, j, he2Var2.j)).a;
        }
        if (!f9Var.f) {
            if (xg0.g(xg0Var.f)) {
                f9Var.f(0L);
            }
            if (xg0.g(xg0Var.g)) {
                f9Var.g(0L);
            }
            if (xg0.g(xg0Var.d)) {
                f9Var.h(0L);
            }
            if (xg0.g(xg0Var.e)) {
                f9Var.e(0L);
            }
            f9Var.f = true;
        }
        int i6 = ea.a;
        float f4 = i5 == 2 ? 4.0f : 1.0f;
        long jF = jp1.f(f4, j);
        int i7 = (int) (j & 4294967295L);
        if (Float.intBitsToFloat(i7) != 0.0f) {
            if (!xg0.g(xg0Var.d) || Float.intBitsToFloat(i7) >= 0.0f) {
                j2 = 4294967295L;
                if (xg0.g(xg0Var.e) && Float.intBitsToFloat(i7) > 0.0f) {
                    float fE = f9Var.e(jF);
                    if (!xg0.g(xg0Var.e)) {
                        xg0Var.b().finish();
                    }
                    fIntBitsToFloat = fE == Float.intBitsToFloat((int) (jF & 4294967295L)) ? Float.intBitsToFloat(i7) : fE / f4;
                }
            } else {
                float fH = f9Var.h(jF);
                j2 = 4294967295L;
                if (!xg0.g(xg0Var.d)) {
                    xg0Var.e().finish();
                }
                fIntBitsToFloat = fH == Float.intBitsToFloat((int) (jF & 4294967295L)) ? Float.intBitsToFloat(i7) : fH / f4;
            }
            i2 = (int) (j >> 32);
            if (Float.intBitsToFloat(i2) != 0.0f) {
                fIntBitsToFloat2 = 0.0f;
            } else if (!xg0.g(xg0Var.f) && Float.intBitsToFloat(i2) < 0.0f) {
                fG = f9Var.f(jF);
                if (!xg0.g(xg0Var.f)) {
                    xg0Var.c().finish();
                }
                if (fG == Float.intBitsToFloat((int) (jF >> 32))) {
                    fIntBitsToFloat2 = Float.intBitsToFloat(i2);
                } else {
                    fIntBitsToFloat2 = fG / f4;
                }
            } else if (xg0.g(xg0Var.g) || Float.intBitsToFloat(i2) <= 0.0f) {
                fIntBitsToFloat2 = 0.0f;
            } else {
                fG = f9Var.g(jF);
                if (!xg0.g(xg0Var.g)) {
                    xg0Var.d().finish();
                }
                if (fG == Float.intBitsToFloat((int) (jF >> 32))) {
                    fIntBitsToFloat2 = Float.intBitsToFloat(i2);
                } else {
                    fIntBitsToFloat2 = fG / f4;
                }
            }
            jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & j2);
            if (!jp1.b(jFloatToRawIntBits, 0L)) {
                f9Var.d();
            }
            jD = jp1.d(j, jFloatToRawIntBits);
            he2 he2Var3 = (he2) x0Var.b;
            long j3 = new jp1(he2Var3.c(he2Var3.k, jD, he2Var3.j)).a;
            jD2 = jp1.d(jD, j3);
            if ((Float.intBitsToFloat((int) (jD >> 32)) == 0.0f || Float.intBitsToFloat((int) (jD & j2)) != 0.0f) && ((Float.intBitsToFloat((int) (j3 >> 32)) != 0.0f || Float.intBitsToFloat((int) (j3 & j2)) != 0.0f) && (xg0.g(xg0Var.f) || xg0.g(xg0Var.d) || xg0.g(xg0Var.g) || xg0.g(xg0Var.e)))) {
                f9Var.a();
            }
            if (i5 == 1) {
                i3 = (int) (jD2 >> 32);
                if (Float.intBitsToFloat(i3) > 0.5f) {
                    f9Var.f(jD2);
                } else {
                    if (Float.intBitsToFloat(i3) < -0.5f) {
                        f9Var.g(jD2);
                    } else {
                        z3 = false;
                    }
                    i4 = (int) (jD2 & j2);
                    if (Float.intBitsToFloat(i4) > 0.5f) {
                        f9Var.h(jD2);
                    } else {
                        if (Float.intBitsToFloat(i4) < -0.5f) {
                            f9Var.e(jD2);
                        } else {
                            z4 = false;
                        }
                        if (!z3 || z4) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    z4 = true;
                    if (z3) {
                    }
                    z = true;
                }
                z3 = true;
                i4 = (int) (jD2 & j2);
                if (Float.intBitsToFloat(i4) > 0.5f) {
                    f9Var.h(jD2);
                } else {
                    if (Float.intBitsToFloat(i4) < -0.5f) {
                        f9Var.e(jD2);
                    } else {
                        z4 = false;
                    }
                    if (z3) {
                    }
                    z = true;
                }
                z4 = true;
                if (z3) {
                }
                z = true;
            } else {
                z = false;
            }
            if (!jp1.b(jD, 0L)) {
                if (xg0.f(xg0Var.f) || Float.intBitsToFloat(i2) >= 0.0f) {
                    zF = false;
                } else {
                    EdgeEffect edgeEffectC = xg0Var.c();
                    float fIntBitsToFloat6 = Float.intBitsToFloat(i2);
                    if (edgeEffectC instanceof ju0) {
                        ju0 ju0Var4 = (ju0) edgeEffectC;
                        float f5 = ju0Var4.b + fIntBitsToFloat6;
                        ju0Var4.b = f5;
                        if (Math.abs(f5) > ju0Var4.a) {
                            ju0Var4.onRelease();
                        }
                    } else {
                        edgeEffectC.onRelease();
                    }
                    zF = xg0.f(xg0Var.f);
                }
                if (xg0.f(xg0Var.g) && Float.intBitsToFloat(i2) > 0.0f) {
                    edgeEffectD = xg0Var.d();
                    fIntBitsToFloat5 = Float.intBitsToFloat(i2);
                    if (edgeEffectD instanceof ju0) {
                        ju0Var3 = (ju0) edgeEffectD;
                        f3 = ju0Var3.b + fIntBitsToFloat5;
                        ju0Var3.b = f3;
                        if (Math.abs(f3) > ju0Var3.a) {
                            ju0Var3.onRelease();
                        }
                    } else {
                        edgeEffectD.onRelease();
                    }
                    if (!zF || xg0.f(xg0Var.g)) {
                        zF = true;
                    } else {
                        zF = false;
                    }
                }
                if (xg0.f(xg0Var.d) && Float.intBitsToFloat(i7) < 0.0f) {
                    edgeEffectE = xg0Var.e();
                    fIntBitsToFloat4 = Float.intBitsToFloat(i7);
                    if (edgeEffectE instanceof ju0) {
                        ju0Var2 = (ju0) edgeEffectE;
                        f2 = ju0Var2.b + fIntBitsToFloat4;
                        ju0Var2.b = f2;
                        if (Math.abs(f2) > ju0Var2.a) {
                            ju0Var2.onRelease();
                        }
                    } else {
                        edgeEffectE.onRelease();
                    }
                    if (!zF || xg0.f(xg0Var.d)) {
                        zF = true;
                    } else {
                        zF = false;
                    }
                }
                if (xg0.f(xg0Var.e) && Float.intBitsToFloat(i7) > 0.0f) {
                    edgeEffectB = xg0Var.b();
                    fIntBitsToFloat3 = Float.intBitsToFloat(i7);
                    if (edgeEffectB instanceof ju0) {
                        ju0Var = (ju0) edgeEffectB;
                        f = ju0Var.b + fIntBitsToFloat3;
                        ju0Var.b = f;
                        if (Math.abs(f) > ju0Var.a) {
                            ju0Var.onRelease();
                        }
                    } else {
                        edgeEffectB.onRelease();
                    }
                    if (!zF || xg0.f(xg0Var.e)) {
                        zF = true;
                    } else {
                        zF = false;
                    }
                }
                if (!zF || z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = z2;
            }
            if (z) {
                f9Var.d();
            }
            return jp1.e(jFloatToRawIntBits, j3);
        }
        j2 = 4294967295L;
        fIntBitsToFloat = 0.0f;
        i2 = (int) (j >> 32);
        if (Float.intBitsToFloat(i2) != 0.0f) {
            fIntBitsToFloat2 = 0.0f;
        } else if (!xg0.g(xg0Var.f)) {
            if (xg0.g(xg0Var.g)) {
                fIntBitsToFloat2 = 0.0f;
            } else {
                fIntBitsToFloat2 = 0.0f;
            }
        } else if (xg0.g(xg0Var.g)) {
            fIntBitsToFloat2 = 0.0f;
        } else {
            fIntBitsToFloat2 = 0.0f;
        }
        jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & j2);
        if (!jp1.b(jFloatToRawIntBits, 0L)) {
            f9Var.d();
        }
        jD = jp1.d(j, jFloatToRawIntBits);
        he2 he2Var4 = (he2) x0Var.b;
        long j4 = new jp1(he2Var4.c(he2Var4.k, jD, he2Var4.j)).a;
        jD2 = jp1.d(jD, j4);
        if (Float.intBitsToFloat((int) (jD >> 32)) == 0.0f) {
            f9Var.a();
        } else {
            f9Var.a();
        }
        if (i5 == 1) {
            i3 = (int) (jD2 >> 32);
            if (Float.intBitsToFloat(i3) > 0.5f) {
                f9Var.f(jD2);
            } else {
                if (Float.intBitsToFloat(i3) < -0.5f) {
                    f9Var.g(jD2);
                } else {
                    z3 = false;
                }
                i4 = (int) (jD2 & j2);
                if (Float.intBitsToFloat(i4) > 0.5f) {
                    f9Var.h(jD2);
                } else {
                    if (Float.intBitsToFloat(i4) < -0.5f) {
                        f9Var.e(jD2);
                    } else {
                        z4 = false;
                    }
                    if (z3) {
                    }
                    z = true;
                }
                z4 = true;
                if (z3) {
                }
                z = true;
            }
            z3 = true;
            i4 = (int) (jD2 & j2);
            if (Float.intBitsToFloat(i4) > 0.5f) {
                f9Var.h(jD2);
            } else {
                if (Float.intBitsToFloat(i4) < -0.5f) {
                    f9Var.e(jD2);
                } else {
                    z4 = false;
                }
                if (z3) {
                }
                z = true;
            }
            z4 = true;
            if (z3) {
            }
            z = true;
        } else {
            z = false;
        }
        if (!jp1.b(jD, 0L)) {
            if (xg0.f(xg0Var.f)) {
                zF = false;
            } else {
                zF = false;
            }
            if (xg0.f(xg0Var.g)) {
                edgeEffectD = xg0Var.d();
                fIntBitsToFloat5 = Float.intBitsToFloat(i2);
                if (edgeEffectD instanceof ju0) {
                    ju0Var3 = (ju0) edgeEffectD;
                    f3 = ju0Var3.b + fIntBitsToFloat5;
                    ju0Var3.b = f3;
                    if (Math.abs(f3) > ju0Var3.a) {
                        ju0Var3.onRelease();
                    }
                } else {
                    edgeEffectD.onRelease();
                }
                if (zF) {
                    zF = true;
                } else {
                    zF = true;
                }
            }
            if (xg0.f(xg0Var.d)) {
                edgeEffectE = xg0Var.e();
                fIntBitsToFloat4 = Float.intBitsToFloat(i7);
                if (edgeEffectE instanceof ju0) {
                    ju0Var2 = (ju0) edgeEffectE;
                    f2 = ju0Var2.b + fIntBitsToFloat4;
                    ju0Var2.b = f2;
                    if (Math.abs(f2) > ju0Var2.a) {
                        ju0Var2.onRelease();
                    }
                } else {
                    edgeEffectE.onRelease();
                }
                if (zF) {
                    zF = true;
                } else {
                    zF = true;
                }
            }
            if (xg0.f(xg0Var.e)) {
                edgeEffectB = xg0Var.b();
                fIntBitsToFloat3 = Float.intBitsToFloat(i7);
                if (edgeEffectB instanceof ju0) {
                    ju0Var = (ju0) edgeEffectB;
                    f = ju0Var.b + fIntBitsToFloat3;
                    ju0Var.b = f;
                    if (Math.abs(f) > ju0Var.a) {
                        ju0Var.onRelease();
                    }
                } else {
                    edgeEffectB.onRelease();
                }
                if (zF) {
                    zF = true;
                } else {
                    zF = true;
                }
            }
            if (zF) {
                z2 = true;
            } else {
                z2 = true;
            }
            z = z2;
        }
        if (z) {
            f9Var.d();
        }
        return jp1.e(jFloatToRawIntBits, j4);
    }
}
