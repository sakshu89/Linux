package defpackage;

import android.view.MotionEvent;
import com.ibm.icu.impl.UCharacterProperty;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t9 implements wu2 {
    public final /* synthetic */ int a;
    public int b;
    public Object c;
    public Object e;

    public t9(h21 h21Var, r91 r91Var) {
        this.a = 3;
        t9 t9Var = r91Var.a;
        int i = h21Var.a;
        if (i < 0) {
            c11.c("negative nearestRange.first");
        }
        int iMin = Math.min(h21Var.b, t9Var.b - 1);
        if (iMin < i) {
            ul1 ul1Var = xo1.a;
            ul1Var.getClass();
            this.c = ul1Var;
            this.e = new Object[0];
            this.b = 0;
            return;
        }
        int i2 = (iMin - i) + 1;
        this.e = new Object[i2];
        this.b = i;
        ul1 ul1Var2 = new ul1(i2);
        pm1 pm1Var = (pm1) t9Var.c;
        if (i < 0 || i >= t9Var.b) {
            StringBuilder sbP = ky0.p("Index ", i, ", size ");
            sbP.append(t9Var.b);
            c11.e(sbP.toString());
        }
        if (iMin < 0 || iMin >= t9Var.b) {
            StringBuilder sbP2 = ky0.p("Index ", iMin, ", size ");
            sbP2.append(t9Var.b);
            c11.e(sbP2.toString());
        }
        if (iMin < i) {
            c11.a("toIndex (" + iMin + ") should be not smaller than fromIndex (" + i + ')');
        }
        int iA = ep4.a(i, pm1Var);
        int i3 = ((y21) pm1Var.a[iA]).a;
        while (i3 <= iMin) {
            y21 y21Var = (y21) pm1Var.a[iA];
            q91 q91Var = y21Var.c;
            int i4 = y21Var.a;
            int iMax = Math.max(i, i4);
            int iMin2 = Math.min(iMin, (i4 + y21Var.b) - 1);
            if (iMax <= iMin2) {
                while (true) {
                    ra0 ra0Var = new ra0(iMax);
                    ul1Var2.g(iMax, ra0Var);
                    ((Object[]) this.e)[iMax - this.b] = ra0Var;
                    iMax = iMax != iMin2 ? iMax + 1 : iMax;
                }
            }
            i3 += y21Var.b;
            iA++;
        }
        this.c = ul1Var2;
    }

    public y21 a(int i) {
        if (i < 0 || i >= this.b) {
            StringBuilder sbP = ky0.p("Index ", i, ", size ");
            sbP.append(this.b);
            c11.e(sbP.toString());
        }
        y21 y21Var = (y21) this.e;
        if (y21Var != null) {
            int i2 = y21Var.a;
            if (i < y21Var.b + i2 && i2 <= i) {
                return y21Var;
            }
        }
        pm1 pm1Var = (pm1) this.c;
        y21 y21Var2 = (y21) pm1Var.a[ep4.a(i, pm1Var)];
        this.e = y21Var2;
        return y21Var2;
    }

    @Override // defpackage.wu2
    public Object b() {
        pi piVar = (pi) this.c;
        ((kf) piVar.d).B((pj) this.e, this.b + 1, false);
        return null;
    }

    public int c(Object obj) {
        ul1 ul1Var = (ul1) this.c;
        int iD = ul1Var.d(obj);
        if (iD >= 0) {
            return ul1Var.c[iD];
        }
        return -1;
    }

    public void d(int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3, int i7) {
        long[] jArr = (long[]) this.c;
        int i8 = this.b;
        int i9 = i8 + 3;
        this.b = i9;
        int length = jArr.length;
        if (length <= i9) {
            int iMax = Math.max(length * 2, i9);
            this.c = Arrays.copyOf(jArr, iMax);
            this.e = Arrays.copyOf((long[]) this.e, iMax);
        }
        long[] jArr2 = (long[]) this.c;
        jArr2[i8] = (((long) i2) << 32) | (((long) i3) & 4294967295L);
        jArr2[i8 + 1] = (((long) i4) << 32) | (((long) i5) & 4294967295L);
        int i10 = i6 & 33554431;
        jArr2[i8 + 2] = ((z3 ? 1L : 0L) << 63) | ((z2 ? 1L : 0L) << 62) | ((z ? 1L : 0L) << 61) | 1152921504606846976L | (((long) Math.min(0, UCharacterProperty.MAX_SCRIPT)) << 50) | (((long) i10) << 25) | ((long) (i & 33554431));
        if (i6 < 0) {
            return;
        }
        for (int i11 = i7 != -1 ? i7 : i8 - 3; i11 >= 0; i11 -= 3) {
            int i12 = i11 + 2;
            long j = jArr2[i12];
            if ((((int) j) & 33554431) == i10) {
                int i13 = (i8 - i11) / 3;
                int i14 = m42.b;
                jArr2[i12] = (((long) Math.min(i13, UCharacterProperty.MAX_SCRIPT)) << 50) | (j & (-1151795604700004353L));
                return;
            }
        }
    }

    public void f(int i, boolean z) {
        int i2 = i & 33554431;
        long[] jArr = (long[]) this.c;
        int i3 = this.b;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            int i5 = i4 + 2;
            long j = jArr[i5];
            if ((((int) j) & 33554431) == i2) {
                long j2 = 8070450532247928831L & j;
                long j3 = z ? 1L : 0L;
                jArr[i5] = j2 | (1152921504606846976L * j3) | (j3 * Long.MIN_VALUE);
                return;
            }
        }
    }

    public void g(int i, int i2, long j) {
        int i3;
        char c;
        char c2;
        long[] jArr = (long[]) this.c;
        long[] jArr2 = (long[]) this.e;
        jArr2[0] = j;
        int i4 = 1;
        while (i4 > 0) {
            i4--;
            long j2 = jArr2[i4];
            int i5 = 33554431;
            int i6 = ((int) j2) & 33554431;
            char c3 = 25;
            int i7 = ((int) (j2 >> 25)) & 33554431;
            char c4 = '2';
            int i8 = ((int) (j2 >> 50)) & UCharacterProperty.MAX_SCRIPT;
            int i9 = i8 == 1023 ? this.b : (i8 * 3) + i7;
            if (i7 < 0) {
                return;
            }
            while (i7 < jArr.length - 2 && i7 < i9) {
                int i10 = i7 + 2;
                long j3 = jArr[i10];
                if ((((int) (j3 >> c3)) & i5) == i6) {
                    long j4 = jArr[i7];
                    int i11 = i7 + 1;
                    i3 = i5;
                    c = c3;
                    long j5 = jArr[i11];
                    c2 = c4;
                    jArr[i7] = (((long) (((int) j4) + i2)) & 4294967295L) | (((long) (((int) (j4 >> 32)) + i)) << 32);
                    jArr[i11] = (((long) (((int) j5) + i2)) & 4294967295L) | (((long) (((int) (j5 >> 32)) + i)) << 32);
                    jArr[i10] = (((j3 >> 63) & 1) << 60) | j3;
                    if ((((int) (j3 >> c2)) & UCharacterProperty.MAX_SCRIPT) > 0) {
                        int i12 = m42.b;
                        jArr2[i4] = ((-1125899873288193L) & j3) | (((long) ((i7 + 3) & i3)) << c);
                        i4++;
                    }
                } else {
                    i3 = i5;
                    c = c3;
                    c2 = c4;
                }
                i7 += 3;
                i5 = i3;
                c3 = c;
                c4 = c2;
            }
        }
    }

    public void h(int i, xq0 xq0Var) {
        int i2 = i & 33554431;
        long[] jArr = (long[]) this.c;
        int i3 = this.b;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            if ((((int) jArr[i4 + 2]) & 33554431) == i2) {
                long j = jArr[i4];
                long j2 = jArr[i4 + 1];
                xq0Var.o(Integer.valueOf((int) (j >> 32)), Integer.valueOf((int) j), Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2));
                return;
            }
        }
    }

    public void i(String str, el0 el0Var) {
        int i = this.b + 1;
        Object[] objArr = (Object[]) this.c;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            if (i2 < 0) {
                og.m("cannot store more than MAX_VALUE elements");
                return;
            }
            int i3 = length + (length >> 1) + 1;
            if (i3 < i2) {
                int iHighestOneBit = Integer.highestOneBit(i2 - 1);
                i3 = iHighestOneBit + iHighestOneBit;
            }
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            this.c = Arrays.copyOf(objArr, i3);
        }
        Object[] objArr2 = (Object[]) this.c;
        int i4 = this.b;
        int i5 = i4 + i4;
        objArr2[i5] = str;
        objArr2[i5 + 1] = el0Var;
        this.b = i4 + 1;
    }

    public byte[] j() {
        qs4 qs4Var = qs4.n;
        lj1 lj1Var = (lj1) this.c;
        ((i52) this.e).i = false;
        i52 i52Var = (i52) this.e;
        i52Var.g = Boolean.FALSE;
        lj1Var.b = new jr4(i52Var);
        try {
            qs4.t();
            kn4 kn4Var = new kn4(lj1Var);
            kf kfVar = new kf(1);
            qs4Var.m(kfVar);
            HashMap map = new HashMap((HashMap) kfVar.b);
            HashMap map2 = new HashMap((HashMap) kfVar.c);
            r41 r41Var = (r41) kfVar.e;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                x14 x14Var = new x14(byteArrayOutputStream, map, map2, r41Var);
                vo1 vo1Var = (vo1) map.get(kn4.class);
                if (vo1Var == null) {
                    throw new ri0("No encoder for ".concat(String.valueOf(kn4.class)));
                }
                vo1Var.a(kn4Var, x14Var);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
            }
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    public String toString() {
        switch (this.a) {
            case 7:
                StringBuilder sb = new StringBuilder();
                if (((y12) this.c) == y12.HTTP_1_0) {
                    sb.append("HTTP/1.0");
                } else {
                    sb.append("HTTP/1.1");
                }
                sb.append(' ');
                sb.append(this.b);
                sb.append(' ');
                sb.append((String) this.e);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public t9(pi piVar, pj pjVar, int i) {
        this.a = 8;
        this.c = piVar;
        this.e = pjVar;
        this.b = i;
    }

    public /* synthetic */ t9(Object obj, int i, Serializable serializable, int i2) {
        this.a = i2;
        this.c = obj;
        this.b = i;
        this.e = serializable;
    }

    public t9(lj1 lj1Var, int i) {
        this.a = 10;
        this.e = new i52();
        this.c = lj1Var;
        qs4.t();
        this.b = i;
    }

    public t9(ArrayList arrayList, int i, MotionEvent motionEvent) {
        this.a = 0;
        this.c = arrayList;
        this.b = i;
        this.e = motionEvent;
        if (arrayList.isEmpty()) {
            og.i("changes cannot be empty");
            throw null;
        }
    }

    public /* synthetic */ t9(int i, boolean z) {
        this.a = i;
    }

    public t9(int i) {
        this.a = i;
        switch (i) {
            case 9:
                this.c = new Object[8];
                this.b = 0;
                break;
            default:
                this.c = new pm1(new y21[16]);
                break;
        }
    }

    public t9(w73 w73Var) {
        this.a = 1;
        this.c = w73Var;
    }
}
