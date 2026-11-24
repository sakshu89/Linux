package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gm2 implements Iterable, x41 {
    public static final gm2 f = new gm2(0, 0, 0, null);
    public final long a;
    public final long b;
    public final long c;
    public final long[] e;

    public gm2(long j, long j2, long j3, long[] jArr) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.e = jArr;
    }

    public final gm2 a(gm2 gm2Var) {
        long[] jArr;
        gm2 gm2VarB = this;
        gm2 gm2Var2 = f;
        if (gm2Var == gm2Var2) {
            return gm2VarB;
        }
        if (gm2VarB == gm2Var2) {
            return gm2Var2;
        }
        long j = gm2Var.c;
        long j2 = gm2Var.c;
        long[] jArr2 = gm2Var.e;
        long j3 = gm2Var.b;
        long j4 = gm2Var.a;
        long j5 = gm2VarB.c;
        if (j == j5 && jArr2 == (jArr = gm2VarB.e)) {
            return new gm2(gm2VarB.a & (~j4), gm2VarB.b & (~j3), j5, jArr);
        }
        if (jArr2 != null) {
            for (long j6 : jArr2) {
                gm2VarB = gm2VarB.b(j6);
            }
        }
        if (j3 != 0) {
            for (int i = 0; i < 64; i++) {
                if (((1 << i) & j3) != 0) {
                    gm2VarB = gm2VarB.b(((long) i) + j2);
                }
            }
        }
        if (j4 != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if (((1 << i2) & j4) != 0) {
                    gm2VarB = gm2VarB.b(((long) i2) + j2 + 64);
                }
            }
        }
        return gm2VarB;
    }

    public final gm2 b(long j) {
        long[] jArr;
        int iA;
        long[] jArr2;
        long j2 = j - this.c;
        if (g31.c(j2, 0L) >= 0 && g31.c(j2, 64L) < 0) {
            long j3 = 1 << ((int) j2);
            long j4 = this.b;
            if ((j4 & j3) != 0) {
                return new gm2(this.a, j4 & (~j3), this.c, this.e);
            }
        } else if (g31.c(j2, 64L) >= 0 && g31.c(j2, 128L) < 0) {
            long j5 = 1 << (((int) j2) - 64);
            long j6 = this.a;
            if ((j6 & j5) != 0) {
                return new gm2(j6 & (~j5), this.b, this.c, this.e);
            }
        } else if (g31.c(j2, 0L) < 0 && (jArr = this.e) != null && (iA = m44.a(jArr, j)) >= 0) {
            int length = jArr.length;
            int i = length - 1;
            if (i == 0) {
                jArr2 = null;
            } else {
                long[] jArr3 = new long[i];
                if (iA > 0) {
                    qg.f(jArr, jArr3, 0, 0, iA);
                }
                if (iA < i) {
                    qg.f(jArr, jArr3, iA, iA + 1, length);
                }
                jArr2 = jArr3;
            }
            return new gm2(this.a, this.b, this.c, jArr2);
        }
        return this;
    }

    public final boolean d(long j) {
        long[] jArr;
        long j2 = j - this.c;
        if (g31.c(j2, 0L) >= 0 && g31.c(j2, 64L) < 0) {
            return ((1 << ((int) j2)) & this.b) != 0;
        }
        if (g31.c(j2, 64L) < 0 || g31.c(j2, 128L) >= 0) {
            return g31.c(j2, 0L) <= 0 && (jArr = this.e) != null && m44.a(jArr, j) >= 0;
        }
        return ((1 << (((int) j2) + (-64))) & this.a) != 0;
    }

    public final gm2 f(gm2 gm2Var) {
        gm2 gm2VarG;
        long[] jArr;
        gm2 gm2VarG2 = this;
        gm2 gm2Var2 = f;
        if (gm2Var == gm2Var2) {
            return gm2VarG2;
        }
        if (gm2VarG2 == gm2Var2) {
            return gm2Var;
        }
        long j = gm2Var.c;
        long j2 = gm2Var.c;
        long[] jArr2 = gm2Var.e;
        long j3 = gm2Var.b;
        long j4 = gm2Var.a;
        long j5 = gm2VarG2.c;
        long j6 = gm2VarG2.b;
        long j7 = gm2VarG2.a;
        if (j == j5 && jArr2 == (jArr = gm2VarG2.e)) {
            return new gm2(j7 | j4, j6 | j3, j5, jArr);
        }
        int i = 0;
        long[] jArr3 = gm2VarG2.e;
        if (jArr3 != null) {
            if (jArr2 != null) {
                for (long j8 : jArr2) {
                    gm2VarG2 = gm2VarG2.g(j8);
                }
            }
            if (j3 != 0) {
                for (int i2 = 0; i2 < 64; i2++) {
                    if (((1 << i2) & j3) != 0) {
                        gm2VarG2 = gm2VarG2.g(((long) i2) + j2);
                    }
                }
            }
            if (j4 != 0) {
                while (i < 64) {
                    if (((1 << i) & j4) != 0) {
                        gm2VarG2 = gm2VarG2.g(((long) i) + j2 + 64);
                    }
                    i++;
                }
            }
            return gm2VarG2;
        }
        if (jArr3 != null) {
            gm2VarG = gm2Var;
            for (long j9 : jArr3) {
                gm2VarG = gm2VarG.g(j9);
            }
        } else {
            gm2VarG = gm2Var;
        }
        long j10 = gm2VarG2.c;
        if (j6 != 0) {
            for (int i3 = 0; i3 < 64; i3++) {
                if (((1 << i3) & j6) != 0) {
                    gm2VarG = gm2VarG.g(((long) i3) + j10);
                }
            }
        }
        if (j7 != 0) {
            while (i < 64) {
                if (((1 << i) & j7) != 0) {
                    gm2VarG = gm2VarG.g(((long) i) + j10 + 64);
                }
                i++;
            }
        }
        return gm2VarG;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00fa  */
    public final gm2 g(long j) {
        long j2;
        long j3;
        long[] jArr;
        long[] jArr2;
        int i;
        long j4 = this.c;
        long j5 = j - j4;
        long j6 = 0;
        int iC = g31.c(j5, 0L);
        long j7 = this.b;
        if (iC < 0 || g31.c(j5, 64L) >= 0) {
            int iC2 = g31.c(j5, 64L);
            long j8 = this.a;
            int i2 = 64;
            if (iC2 < 0 || g31.c(j5, 128L) >= 0) {
                int iC3 = g31.c(j5, 128L);
                long[] jArr3 = this.e;
                if (iC3 < 0) {
                    if (jArr3 == null) {
                        return new gm2(this.a, this.b, this.c, new long[]{j});
                    }
                    int iA = m44.a(jArr3, j);
                    if (iA < 0) {
                        int i3 = -(iA + 1);
                        int length = jArr3.length;
                        long[] jArr4 = new long[length + 1];
                        qg.f(jArr3, jArr4, 0, 0, i3);
                        qg.f(jArr3, jArr4, i3 + 1, i3, length);
                        jArr4[i3] = j;
                        return new gm2(this.a, this.b, this.c, jArr4);
                    }
                } else if (!d(j)) {
                    long j9 = ((j + 1) / 64) * 64;
                    if (g31.c(j9, 0L) < 0) {
                        j9 = 9223372036854775680L;
                    }
                    long j10 = j8;
                    wj1 wj1Var = null;
                    while (true) {
                        if (g31.c(j4, j9) >= 0) {
                            j2 = j4;
                            j3 = j7;
                            break;
                        }
                        if (j7 != j6) {
                            if (wj1Var == null) {
                                wj1Var = new wj1(jArr3);
                            }
                            int i4 = 0;
                            i = i2;
                            while (i4 < i) {
                                if ((j7 & (1 << i4)) != j6) {
                                    ((ql1) wj1Var.b).a(((long) i4) + j4);
                                }
                                i4++;
                                j6 = j6;
                            }
                        } else {
                            i = i2;
                        }
                        long j11 = j6;
                        if (j10 == j11) {
                            j2 = j9;
                            j3 = j11;
                            break;
                        }
                        j4 += 64;
                        j6 = j11;
                        j7 = j10;
                        i2 = i;
                        j10 = j6;
                    }
                    if (wj1Var == null) {
                        jArr = jArr3;
                    } else {
                        ql1 ql1Var = (ql1) wj1Var.b;
                        int i5 = ql1Var.b;
                        if (i5 == 0) {
                            jArr2 = null;
                        } else {
                            long[] jArr5 = new long[i5];
                            long[] jArr6 = ql1Var.a;
                            for (int i6 = 0; i6 < i5; i6++) {
                                jArr5[i6] = jArr6[i6];
                            }
                            jArr2 = jArr5;
                        }
                        if (jArr2 == null) {
                            jArr = jArr3;
                        } else {
                            jArr = jArr2;
                        }
                    }
                    return new gm2(j10, j3, j2, jArr).g(j);
                }
            } else {
                long j12 = 1 << (((int) j5) - 64);
                if ((j8 & j12) == 0) {
                    return new gm2(j8 | j12, this.b, this.c, this.e);
                }
            }
        } else {
            long j13 = 1 << ((int) j5);
            if ((j7 & j13) == 0) {
                return new gm2(this.a, j7 | j13, this.c, this.e);
            }
        }
        return this;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return ah2.a(new fm2(this, null));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        ArrayList arrayList = new ArrayList(nz.d(this));
        Iterator it = iterator();
        while (true) {
            yg2 yg2Var = (yg2) it;
            if (!yg2Var.hasNext()) {
                break;
            }
            arrayList.add(String.valueOf(((Number) yg2Var.next()).longValue()));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = arrayList.get(i2);
            i++;
            if (i > 1) {
                sb2.append((CharSequence) ", ");
            }
            if (obj != null ? obj instanceof CharSequence : true) {
                sb2.append((CharSequence) obj);
            } else if (obj instanceof Character) {
                sb2.append(((Character) obj).charValue());
            } else {
                sb2.append((CharSequence) obj.toString());
            }
        }
        sb2.append((CharSequence) "");
        sb.append(sb2.toString());
        sb.append(']');
        return sb.toString();
    }
}
