package defpackage;

import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ky extends zb0 implements qy1, k51, eg2, t23, h30, ep1, n01 {
    public static final xy u0 = new xy(8);
    public ol1 X;
    public c01 Y;
    public boolean Z;
    public String c0;
    public m82 d0;
    public boolean e0;
    public fq0 f0;
    public final no0 g0;
    public c01 h0;
    public xb0 i0;
    public b02 j0;
    public xw0 k0;
    public final rl1 l0;
    public long m0;
    public b02 n0;
    public ol1 o0;
    public boolean p0;
    public l11 q0;
    public yq2 r0;
    public final xy s0;
    public ny1 t0;

    public ky(ol1 ol1Var, c01 c01Var, boolean z, boolean z2, String str, m82 m82Var, fq0 fq0Var) {
        this.X = ol1Var;
        this.Y = c01Var;
        this.Z = z;
        this.c0 = str;
        this.d0 = m82Var;
        this.e0 = z2;
        this.f0 = fq0Var;
        this.g0 = new no0(ol1Var, 0, new q0(1, this, ky.class, "onFocusChange", "onFocusChange(Z)V", 0, 0, 0));
        int i = ze1.a;
        this.l0 = new rl1(6);
        this.m0 = 0L;
        ol1 ol1Var2 = this.X;
        this.o0 = ol1Var2;
        this.p0 = ol1Var2 == null;
        this.s0 = u0;
    }

    @Override // defpackage.n01
    public final void A() {
        l11 l11Var = this.q0;
        if (l11Var != null) {
            l11Var.F();
        }
    }

    @Override // defpackage.dk1
    public final void A0() {
        J();
        if (!this.p0) {
            P0();
        }
        if (this.e0) {
            I0(this.g0);
        }
    }

    @Override // defpackage.dk1
    public final void B0() {
        L0();
        if (this.o0 == null) {
            this.X = null;
        }
        xb0 xb0Var = this.i0;
        if (xb0Var != null) {
            J0(xb0Var);
        }
        this.i0 = null;
    }

    @Override // defpackage.n01
    public final void D(t9 t9Var, hy1 hy1Var) throws IllegalAccessException, InvocationTargetException {
        ArrayList arrayList = (ArrayList) t9Var.c;
        P0();
        if (this.e0) {
            if (this.q0 == null) {
                this.q0 = new l11(this);
            }
            l11 l11Var = this.q0;
            if (l11Var != null) {
                fq0 fq0Var = this.f0;
                ky kyVar = (ky) l11Var.b;
                int i = 0;
                if (hy1Var != hy1.b) {
                    if (hy1Var != hy1.c || ((e01) l11Var.c) == null) {
                        return;
                    }
                    int size = arrayList.size();
                    while (i < size) {
                        e01 e01Var = (e01) arrayList.get(i);
                        if (e01Var.i && e01Var != ((e01) l11Var.c)) {
                            l11Var.F();
                            return;
                        }
                        i++;
                    }
                    return;
                }
                e01 e01Var2 = (e01) l11Var.c;
                if (e01Var2 == null) {
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        e01 e01Var3 = (e01) arrayList.get(i2);
                        if (!e01Var3.h && e01Var3.d) {
                            e01 e01Var4 = (e01) arrayList.get(0);
                            l11Var.c = e01Var4;
                            kyVar.O0(e01Var4.c, true);
                            e01Var4.i = true;
                            return;
                        }
                    }
                    return;
                }
                long j = e01Var2.c;
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    e01 e01Var5 = (e01) arrayList.get(i3);
                    if (e01Var5.h && e01Var5.d) {
                        if (Math.abs(jp1.c(jp1.d(((e01) arrayList.get(0)).c, j))) > ((w73) ij4.a(kyVar, l30.s)).d()) {
                            l11Var.F();
                            return;
                        }
                        return;
                    }
                }
                int size4 = arrayList.size();
                for (int i4 = 0; i4 < size4; i4++) {
                    e01 e01Var6 = (e01) arrayList.get(i4);
                    if (e01Var6.i || !e01Var6.h || e01Var6.d) {
                        int size5 = arrayList.size();
                        while (i < size5) {
                            if (((e01) arrayList.get(i)).i) {
                                l11Var.F();
                                return;
                            }
                            i++;
                        }
                        return;
                    }
                }
                ((e01) arrayList.get(0)).i = true;
                kyVar.N0(j, true);
                fq0Var.a();
                l11Var.c = null;
            }
        }
    }

    @Override // defpackage.qy1
    public final void H(gy1 gy1Var, hy1 hy1Var, long j) throws IllegalAccessException, InvocationTargetException {
        long j2 = ((j >> 33) << 32) | (((j << 32) >> 33) & 4294967295L);
        this.m0 = (((long) Float.floatToRawIntBits((int) (j2 >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (j2 & 4294967295L))) & 4294967295L);
        P0();
        boolean z = this.e0;
        hy1 hy1Var2 = hy1.b;
        x50 x50Var = null;
        int i = 1;
        int i2 = 0;
        if (z && hy1Var == hy1Var2) {
            int i3 = gy1Var.f;
            if (i3 == 4) {
                uf4.b(w0(), null, new w0(this, x50Var, i2), 3);
            } else if (i3 == 5) {
                uf4.b(w0(), null, new w0(this, x50Var, i), 3);
            }
        }
        if (hy1Var != hy1Var2) {
            if (hy1Var != hy1.c || this.t0 == null) {
                return;
            }
            List list = gy1Var.a;
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                ny1 ny1Var = (ny1) list.get(i4);
                if (ny1Var.b() && ny1Var != this.t0) {
                    this.t0 = null;
                    M0(false);
                    return;
                }
            }
            return;
        }
        ny1 ny1Var2 = this.t0;
        if (ny1Var2 == null) {
            if (vv2.c(gy1Var, true)) {
                ny1 ny1Var3 = (ny1) gy1Var.a.get(0);
                ny1Var3.a();
                this.t0 = ny1Var3;
                if (this.e0) {
                    O0(ny1Var3.c, false);
                    return;
                }
                return;
            }
            return;
        }
        List list2 = gy1Var.a;
        int size2 = list2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            if (!y11.c((ny1) list2.get(i5))) {
                long jA0 = cm4.g(this).h0.a0(((w73) ij4.a(this, l30.s)).g());
                float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (jA0 >> 32)) - ((int) (j >> 32))) / 2.0f;
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (jA0 & 4294967295L)) - ((int) (j & 4294967295L))) / 2.0f)) & 4294967295L) | (Float.floatToRawIntBits(fMax) << 32);
                int size3 = list2.size();
                for (int i6 = 0; i6 < size3; i6++) {
                    ny1 ny1Var4 = (ny1) list2.get(i6);
                    if (ny1Var4.b() || y11.e(ny1Var4, j, jFloatToRawIntBits)) {
                        this.t0 = null;
                        M0(false);
                        return;
                    }
                }
                return;
            }
        }
        ((ny1) list2.get(0)).a();
        if (this.e0) {
            N0(ny1Var2.c, false);
            this.f0.a();
        }
        this.t0 = null;
    }

    @Override // defpackage.ep1
    public final void J() {
        if (this.Z) {
            tr4.a(this, new n0(this, 0));
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0073 A[LOOP:0: B:16:0x0037->B:26:0x0073, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0076 A[EDGE_INSN: B:30:0x0076->B:27:0x0076 BREAK  A[LOOP:0: B:16:0x0037->B:26:0x0073], SYNTHETIC] */
    public final void L0() {
        ol1 ol1Var = this.X;
        rl1 rl1Var = this.l0;
        if (ol1Var != null) {
            b02 b02Var = this.j0;
            if (b02Var != null) {
                ol1Var.b(new a02(b02Var));
            }
            b02 b02Var2 = this.n0;
            if (b02Var2 != null) {
                ol1Var.b(new a02(b02Var2));
            }
            xw0 xw0Var = this.k0;
            if (xw0Var != null) {
                ol1Var.b(new yw0(xw0Var));
            }
            Object[] objArr = rl1Var.c;
            long[] jArr = rl1Var.a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                ol1Var.b(new a02((b02) objArr[(i << 3) + i3]));
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        this.j0 = null;
        this.n0 = null;
        this.k0 = null;
        rl1Var.a();
    }

    public final void M0(boolean z) {
        ol1 ol1Var = this.X;
        if (ol1Var != null) {
            yq2 yq2Var = this.r0;
            x50 x50Var = null;
            if (yq2Var == null || !yq2Var.c()) {
                b02 b02Var = z ? this.n0 : this.j0;
                if (b02Var != null) {
                    a02 a02Var = new a02(b02Var);
                    f41 f41Var = (f41) ((w50) w0()).a.v(nr4.k);
                    uf4.b(w0(), null, new r0(ol1Var, a02Var, f41Var != null ? f41Var.C(new o0(0, ol1Var, a02Var)) : null, x50Var, 0), 3);
                }
            } else {
                yq2 yq2Var2 = this.r0;
                if (yq2Var2 != null) {
                    yq2Var2.e(null);
                }
            }
            if (z) {
                this.n0 = null;
            } else {
                this.j0 = null;
            }
        }
    }

    public final void N0(long j, boolean z) throws IllegalAccessException, InvocationTargetException {
        ol1 ol1Var = this.X;
        if (ol1Var != null) {
            yq2 yq2Var = this.r0;
            if (yq2Var == null || !yq2Var.c()) {
                b02 b02Var = z ? this.n0 : this.j0;
                if (b02Var != null) {
                    uf4.b(w0(), null, new t0(b02Var, ol1Var, (x50) null), 3);
                }
            } else {
                yq2Var.e(null);
                uf4.b(w0(), null, new s0(yq2Var, j, ol1Var, (x50) null, 0), 3);
            }
            if (z) {
                this.n0 = null;
            } else {
                this.j0 = null;
            }
        }
    }

    public final void O0(long j, boolean z) {
        ol1 ol1Var = this.X;
        if (ol1Var != null) {
            b02 b02Var = new b02(j);
            o42 o42Var = new o42();
            jd4.b(this, pd2.H, new x0(7, o42Var));
            if (!o42Var.a) {
                int i = ly.b;
                ViewParent parent = dm4.a(this).getParent();
                while (parent != null && (parent instanceof ViewGroup)) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    if (!viewGroup.shouldDelayChildPressedState()) {
                        parent = viewGroup.getParent();
                    }
                }
                if (z) {
                    this.n0 = b02Var;
                } else {
                    this.j0 = b02Var;
                }
                uf4.b(w0(), null, new t0(ol1Var, b02Var, (x50) null), 3);
                return;
            }
            this.r0 = uf4.b(w0(), null, new u0(ol1Var, b02Var, z, this, (x50) null), 3);
        }
    }

    public final void P0() {
        if (this.i0 != null) {
            return;
        }
        c01 c01Var = this.Z ? this.h0 : this.Y;
        if (c01Var != null) {
            if (this.X == null) {
                this.X = new ol1();
            }
            this.g0.N0(this.X);
            ol1 ol1Var = this.X;
            ol1Var.getClass();
            xb0 xb0VarA = c01Var.a(ol1Var);
            I0(xb0VarA);
            this.i0 = xb0VarA;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.k51
    public final boolean U(KeyEvent keyEvent) {
        boolean z;
        int iNumberOfTrailingZeros;
        Object obj;
        P0();
        long jA = h51.a(keyEvent);
        boolean z2 = this.e0;
        rl1 rl1Var = this.l0;
        int i = 1;
        if (z2 && h51.b(keyEvent) == 2 && pd3.d(keyEvent)) {
            if (!rl1Var.b(jA)) {
                b02 b02Var = new b02(this.m0);
                rl1Var.f(jA, b02Var);
                if (this.X == null) {
                    return true;
                }
                uf4.b(w0(), null, new v0(this, b02Var, null, 2), 3);
                return true;
            }
        } else if (this.e0 && h51.b(keyEvent) == 1 && pd3.d(keyEvent)) {
            rl1Var.getClass();
            int iHashCode = Long.hashCode(jA) * (-862048943);
            int i2 = iHashCode ^ (iHashCode << 16);
            int i3 = i2 & 127;
            int i4 = rl1Var.d;
            int i5 = (i2 >>> 7) & i4;
            int i6 = 0;
            loop0: while (true) {
                long[] jArr = rl1Var.a;
                int i7 = i5 >> 3;
                int i8 = (i5 & 7) << 3;
                z = i;
                long j = (((-i8) >> 63) & (jArr[i7 + i] << (64 - i8))) | (jArr[i7] >>> i8);
                long j2 = (((long) i3) * 72340172838076673L) ^ j;
                long j3 = -9187201950435737472L;
                long j4 = (~j2) & (j2 - 72340172838076673L) & (-9187201950435737472L);
                while (j4 != 0) {
                    iNumberOfTrailingZeros = (i5 + (Long.numberOfTrailingZeros(j4) >> 3)) & i4;
                    long j5 = j3;
                    if (rl1Var.b[iNumberOfTrailingZeros] == jA) {
                        break loop0;
                    }
                    j4 &= j4 - 1;
                    j3 = j5;
                }
                if ((j & ((~j) << 6) & j3) != 0) {
                    iNumberOfTrailingZeros = -1;
                    break;
                }
                i6 += 8;
                i5 = (i5 + i6) & i4;
                i = z ? 1 : 0;
            }
            if (iNumberOfTrailingZeros >= 0) {
                rl1Var.e--;
                long[] jArr2 = rl1Var.a;
                int i9 = rl1Var.d;
                int i10 = iNumberOfTrailingZeros >> 3;
                int i11 = (iNumberOfTrailingZeros & 7) << 3;
                long j6 = (jArr2[i10] & (~(255 << i11))) | (254 << i11);
                jArr2[i10] = j6;
                jArr2[(((iNumberOfTrailingZeros - 7) & i9) + (i9 & 7)) >> 3] = j6;
                Object[] objArr = rl1Var.c;
                obj = objArr[iNumberOfTrailingZeros];
                objArr[iNumberOfTrailingZeros] = null;
            } else {
                obj = null;
            }
            b02 b02Var2 = (b02) obj;
            if (b02Var2 != null) {
                if (this.X != null) {
                    uf4.b(w0(), null, new v0(this, b02Var2, null, 3), 3);
                }
                this.f0.a();
            }
            if (b02Var2 != null) {
                return z;
            }
            return false;
        }
        return false;
    }

    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
        if (this.d0 != null) {
            mg2.c(og2Var);
        }
        String str = this.c0;
        n0 n0Var = new n0(this, 1);
        c51[] c51VarArr = mg2.a;
        og2Var.a(bg2.b, new b2(str, n0Var));
        if (this.e0) {
            this.g0.e0(og2Var);
        } else {
            og2Var.a(kg2.i, q43.a);
        }
    }

    @Override // defpackage.qy1
    public final void h0() {
        xw0 xw0Var;
        ol1 ol1Var = this.X;
        if (ol1Var != null && (xw0Var = this.k0) != null) {
            ol1Var.b(new yw0(xw0Var));
        }
        this.k0 = null;
        if (this.t0 != null) {
            this.t0 = null;
            M0(false);
        }
    }

    @Override // defpackage.k51
    public final boolean k(KeyEvent keyEvent) {
        return false;
    }

    @Override // defpackage.eg2
    public final boolean k0() {
        return true;
    }

    @Override // defpackage.t23
    public final Object p() {
        return this.s0;
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }
}
