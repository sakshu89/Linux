package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cl1 implements oh1 {
    public final mn0 a;

    public cl1(mn0 mn0Var) {
        this.a = mn0Var;
    }

    @Override // defpackage.oh1
    public final int a(z21 z21Var, List list, int i) {
        ArrayList arrayListA = er4.a(z21Var);
        mn0 mn0Var = this.a;
        kn0 kn0Var = mn0Var.f;
        List list2 = (List) mz.z(1, arrayListA);
        jh1 jh1Var = list2 != null ? (jh1) mz.y(list2) : null;
        List list3 = (List) mz.z(2, arrayListA);
        kn0Var.a(jh1Var, list3 != null ? (jh1) mz.y(list3) : null, r40.b(i, 0, 13));
        List list4 = (List) mz.y(arrayListA);
        if (list4 == null) {
            list4 = ii0.a;
        }
        return mn0.a(list4, i, z21Var.R(mn0Var.c), z21Var.R(mn0Var.e), mn0Var.f);
    }

    @Override // defpackage.oh1
    public final int c(z21 z21Var, List list, int i) {
        ArrayList arrayListA = er4.a(z21Var);
        mn0 mn0Var = this.a;
        kn0 kn0Var = mn0Var.f;
        List list2 = (List) mz.z(1, arrayListA);
        jh1 jh1Var = list2 != null ? (jh1) mz.y(list2) : null;
        List list3 = (List) mz.z(2, arrayListA);
        kn0Var.a(jh1Var, list3 != null ? (jh1) mz.y(list3) : null, r40.b(0, i, 7));
        List list4 = (List) mz.y(arrayListA);
        if (list4 == null) {
            list4 = ii0.a;
        }
        int iR = z21Var.R(mn0Var.c);
        int size = list4.size();
        int i2 = 0;
        int iMax = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            int iC0 = ((jh1) list4.get(i2)).c0(i) + iR;
            int i5 = i2 + 1;
            if (i5 - i3 == Integer.MAX_VALUE || i5 == list4.size()) {
                iMax = Math.max(iMax, (i4 + iC0) - iR);
                i3 = i2;
                i4 = 0;
            } else {
                i4 += iC0;
            }
            i2 = i5;
        }
        return iMax;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof cl1) && g31.a(this.a, ((cl1) obj).a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [zw1[]] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r8v6, types: [zw1[]] */
    @Override // defpackage.oh1
    public final ph1 f(qh1 qh1Var, List list, long j) {
        jh1 jh1Var;
        jh1 jh1Var2;
        zw1 zw1Var;
        a21 a21Var;
        ph phVar;
        int i;
        char c;
        jh1 jh1Var3;
        a21 a21Var2;
        zw1 zw1Var2;
        a21 a21Var3;
        ph phVar2;
        Integer numValueOf;
        long jA;
        long jA2;
        zw1 zw1VarE;
        ArrayList arrayListA = er4.a(qh1Var);
        final mn0 mn0Var = this.a;
        final kn0 kn0Var = mn0Var.f;
        boolean zIsEmpty = arrayListA.isEmpty();
        ji0 ji0Var = ji0.a;
        final int i2 = 0;
        if (!zIsEmpty) {
            if (q40.g(j) != 0) {
                List list2 = (List) mz.x(arrayListA);
                if (list2.isEmpty()) {
                    return qh1Var.j0(0, 0, ji0Var, new j(7));
                }
                final int i3 = 1;
                List list3 = (List) mz.z(1, arrayListA);
                jh1 jh1Var4 = list3 != null ? (jh1) mz.y(list3) : null;
                List list4 = (List) mz.z(2, arrayListA);
                jh1 jh1Var5 = list4 != null ? (jh1) mz.y(list4) : null;
                list2.size();
                kn0Var.getClass();
                c81 c81Var = c81.a;
                long jC = cs4.c(cs4.b(10, cs4.a(j, c81Var)));
                if (jh1Var4 != null) {
                    vn4.c(jh1Var4, mn0Var, jC, new hq0() { // from class: jn0
                        @Override // defpackage.hq0
                        public final Object j(Object obj) {
                            int iH0;
                            int iH1;
                            int i4 = i2;
                            q43 q43Var = q43.a;
                            int iI0 = 0;
                            mn0 mn0Var2 = mn0Var;
                            kn0 kn0Var2 = kn0Var;
                            zw1 zw1Var3 = (zw1) obj;
                            switch (i4) {
                                case 0:
                                    if (zw1Var3 != null) {
                                        mn0Var2.getClass();
                                        iI0 = zw1Var3.i0();
                                        iH0 = zw1Var3.h0();
                                    } else {
                                        iH0 = 0;
                                    }
                                    new a21(a21.a(iI0, iH0));
                                    kn0Var2.getClass();
                                    break;
                                default:
                                    if (zw1Var3 != null) {
                                        mn0Var2.getClass();
                                        iI0 = zw1Var3.i0();
                                        iH1 = zw1Var3.h0();
                                    } else {
                                        iH1 = 0;
                                    }
                                    new a21(a21.a(iI0, iH1));
                                    kn0Var2.getClass();
                                    break;
                            }
                            return q43Var;
                        }
                    });
                }
                if (jh1Var5 != null) {
                    vn4.c(jh1Var5, mn0Var, jC, new hq0() { // from class: jn0
                        @Override // defpackage.hq0
                        public final Object j(Object obj) {
                            int iH0;
                            int iH1;
                            int i4 = i3;
                            q43 q43Var = q43.a;
                            int iI0 = 0;
                            mn0 mn0Var2 = mn0Var;
                            kn0 kn0Var2 = kn0Var;
                            zw1 zw1Var3 = (zw1) obj;
                            switch (i4) {
                                case 0:
                                    if (zw1Var3 != null) {
                                        mn0Var2.getClass();
                                        iI0 = zw1Var3.i0();
                                        iH0 = zw1Var3.h0();
                                    } else {
                                        iH0 = 0;
                                    }
                                    new a21(a21.a(iI0, iH0));
                                    kn0Var2.getClass();
                                    break;
                                default:
                                    if (zw1Var3 != null) {
                                        mn0Var2.getClass();
                                        iI0 = zw1Var3.i0();
                                        iH1 = zw1Var3.h0();
                                    } else {
                                        iH1 = 0;
                                    }
                                    new a21(a21.a(iI0, iH1));
                                    kn0Var2.getClass();
                                    break;
                            }
                            return q43Var;
                        }
                    });
                }
                Iterator it = list2.iterator();
                float f = mn0Var.c;
                float f2 = mn0Var.e;
                long jA3 = cs4.a(j, c81Var);
                kn0 kn0Var2 = mn0Var.f;
                pm1 pm1Var = new pm1(new ph1[16]);
                int iH = q40.h(jA3);
                int iJ = q40.j(jA3);
                int iG = q40.g(jA3);
                ml1 ml1Var = d21.a;
                ml1 ml1Var2 = new ml1();
                ArrayList arrayList = new ArrayList();
                int iCeil = (int) Math.ceil(qh1Var.x(f));
                int iCeil2 = (int) Math.ceil(qh1Var.x(f2));
                long jA4 = r40.a(0, iH, 0, iG);
                long jC2 = cs4.c(cs4.b(14, jA4));
                if (it.hasNext()) {
                    try {
                        jh1Var = (jh1) it.next();
                    } catch (IndexOutOfBoundsException unused) {
                        jh1Var = null;
                    }
                    jh1Var2 = jh1Var;
                } else {
                    jh1Var2 = null;
                }
                if (jh1Var2 != null) {
                    if (fz3.b(fz3.a(jh1Var2)) == 0.0f) {
                        fz3.a(jh1Var2);
                        zw1VarE = jh1Var2.e(jC2);
                        jA2 = a21.a(zw1VarE.i0(), zw1VarE.h0());
                    } else {
                        int iV = jh1Var2.V(Integer.MAX_VALUE);
                        jA2 = a21.a(iV, jh1Var2.e0(iV));
                        zw1VarE = null;
                    }
                    a21Var = new a21(jA2);
                    zw1Var = zw1VarE;
                } else {
                    pm1Var = pm1Var;
                    zw1Var = null;
                    a21Var = null;
                }
                zw1 zw1Var3 = zw1Var;
                Integer numValueOf2 = a21Var != null ? Integer.valueOf((int) (a21Var.a >> 32)) : null;
                Integer numValueOf3 = a21Var != null ? Integer.valueOf((int) (a21Var.a & 4294967295L)) : null;
                int[] iArr = new int[16];
                int[] iArrCopyOf = new int[16];
                jh1 jh1Var6 = jh1Var2;
                nl1 nl1Var = new nl1();
                en0 en0Var = new en0(kn0Var2, jA3, iCeil, iCeil2);
                a21 a21Var4 = a21Var;
                ph phVarB = en0Var.b(it.hasNext(), 0, a21.a(iH, iG), a21Var4, 0, 0, 0, false, false);
                if (phVarB.b) {
                    phVar = phVarB;
                    en0Var.a(phVar, a21Var4 != null, -1, 0, iH, 0);
                } else {
                    phVar = phVarB;
                }
                int i4 = iH;
                int i5 = iG;
                zw1 zw1Var4 = zw1Var3;
                jh1 jh1Var7 = jh1Var6;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                int i12 = iJ;
                int[] iArrCopyOf2 = iArr;
                int i13 = 0;
                mn0 mn0Var2 = mn0Var;
                ph phVar3 = phVar;
                int i14 = 0;
                while (!phVar3.b && jh1Var7 != null) {
                    numValueOf2.getClass();
                    int iIntValue = numValueOf2.intValue();
                    numValueOf3.getClass();
                    int iIntValue2 = numValueOf3.intValue();
                    nl1 nl1Var2 = nl1Var;
                    int i15 = i14 + iIntValue;
                    int iMax = Math.max(i13, iIntValue2);
                    int i16 = i4 - iIntValue;
                    int i17 = i6 + 1;
                    kn0Var2.getClass();
                    arrayList = arrayList;
                    arrayList.add(jh1Var7);
                    ml1Var2.h(i6, zw1Var4);
                    jh1Var7.k();
                    int i18 = i17 - i9;
                    if (it.hasNext()) {
                        try {
                            jh1Var3 = (jh1) it.next();
                        } catch (IndexOutOfBoundsException unused2) {
                            jh1Var3 = null;
                        }
                    } else {
                        jh1Var3 = null;
                    }
                    if (jh1Var3 != null) {
                        if (fz3.b(fz3.a(jh1Var3)) == 0.0f) {
                            fz3.a(jh1Var3);
                            zw1 zw1VarE2 = jh1Var3.e(jC2);
                            jA = a21.a(zw1VarE2.i0(), zw1VarE2.h0());
                            zw1Var2 = zw1VarE2;
                        } else {
                            int iV2 = jh1Var3.V(Integer.MAX_VALUE);
                            jA = a21.a(iV2, jh1Var3.e0(iV2));
                            zw1Var2 = null;
                        }
                        a21Var2 = new a21(jA);
                    } else {
                        a21Var2 = null;
                        zw1Var2 = null;
                    }
                    Integer numValueOf4 = a21Var2 != null ? Integer.valueOf(((int) (a21Var2.a >> 32)) + iCeil) : null;
                    Integer numValueOf5 = a21Var2 != null ? Integer.valueOf((int) (a21Var2.a & 4294967295L)) : null;
                    boolean zHasNext = it.hasNext();
                    long jA5 = a21.a(i16, i5);
                    if (a21Var2 == null) {
                        a21Var3 = null;
                    } else {
                        numValueOf4.getClass();
                        int iIntValue3 = numValueOf4.intValue();
                        numValueOf5.getClass();
                        a21Var3 = new a21(a21.a(iIntValue3, numValueOf5.intValue()));
                    }
                    ph phVarB2 = en0Var.b(zHasNext, i18, jA5, a21Var3, i10, i11, iMax, false, false);
                    if (phVarB2.a) {
                        int iMin = Math.min(Math.max(i12, i15), iH);
                        int i19 = i11 + iMax;
                        phVar2 = phVarB2;
                        en0 en0Var2 = en0Var;
                        int i20 = i10;
                        en0Var2.a(phVar2, a21Var2 != null, i20, i19, i16, i18);
                        en0Var = en0Var2;
                        int i21 = i8 + 1;
                        if (iArrCopyOf.length < i21) {
                            iArrCopyOf = Arrays.copyOf(iArrCopyOf, Math.max(i21, (iArrCopyOf.length * 3) / 2));
                        }
                        iArrCopyOf[i8] = iMax;
                        i8++;
                        i5 = (i5 - i19) - iCeil2;
                        int i22 = i7 + 1;
                        if (iArrCopyOf2.length < i22) {
                            iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, Math.max(i22, (iArrCopyOf2.length * 3) / 2));
                        }
                        iArrCopyOf2[i7] = i17;
                        i7++;
                        numValueOf = numValueOf4 != null ? Integer.valueOf(numValueOf4.intValue() - iCeil) : null;
                        i10 = i20 + 1;
                        i11 = i19 + iCeil2;
                        i12 = iMin;
                        i4 = iH;
                        i9 = i17;
                        i15 = 0;
                        iMax = 0;
                    } else {
                        phVar2 = phVarB2;
                        i4 = i16;
                        numValueOf = numValueOf4;
                    }
                    phVar3 = phVar2;
                    i6 = i17;
                    zw1Var4 = zw1Var2;
                    numValueOf2 = numValueOf;
                    i14 = i15;
                    jh1Var7 = jh1Var3;
                    nl1Var = nl1Var2;
                    numValueOf3 = numValueOf5;
                    i13 = iMax;
                }
                nl1 nl1Var3 = nl1Var;
                int size = arrayList.size();
                var r2 = new zw1[size];
                for (int i23 = 0; i23 < size; i23++) {
                    r2[i23] = ml1Var2.b(i23);
                }
                int[] iArr2 = new int[i7];
                int[] iArr3 = new int[i7];
                int i24 = 0;
                int i25 = 0;
                int i26 = 0;
                var r3 = r2;
                while (i25 < i7) {
                    int[] iArr4 = iArrCopyOf2;
                    int i27 = iArr4[i25];
                    if (i25 < 0 || i25 >= i8) {
                        og.o("Index must be between 0 and size");
                        return null;
                    }
                    int iG2 = iArrCopyOf[i25];
                    nl1 nl1Var4 = nl1Var3;
                    if (nl1Var4.b(i25)) {
                        c = 65535;
                    } else {
                        c = 65535;
                        iG2 = q40.g(jA4) == Integer.MAX_VALUE ? Integer.MAX_VALUE : q40.g(jA4) - i26;
                    }
                    var r8 = r3;
                    int[] iArr5 = iArrCopyOf;
                    int i28 = i12;
                    int i29 = i8;
                    int[] iArr6 = iArr2;
                    mn0 mn0Var3 = mn0Var2;
                    ArrayList arrayList2 = arrayList;
                    ph1 ph1VarA = hz3.a(mn0Var3, i28, q40.i(jA4), q40.h(jA4), iG2, iCeil, qh1Var, arrayList2, r8, i24, i27, iArr6, i25);
                    int iB = ph1VarA.b();
                    int iA = ph1VarA.a();
                    iArr3[i25] = iA;
                    int iMax2 = Math.max(i28, iB);
                    pm1Var.b(ph1VarA);
                    i25++;
                    arrayList = arrayList2;
                    r3 = r8;
                    i24 = i27;
                    nl1Var3 = nl1Var4;
                    i7 = i7;
                    iArrCopyOf2 = iArr4;
                    mn0Var2 = mn0Var3;
                    i26 += iA;
                    iArr2 = iArr6;
                    i8 = i29;
                    i12 = iMax2;
                    iArrCopyOf = iArr5;
                }
                int[] iArr7 = iArr2;
                int i30 = i12;
                int i31 = i26;
                mn0 mn0Var4 = mn0Var2;
                pm1 pm1Var2 = pm1Var;
                if (pm1Var2.c == 0) {
                    i30 = 0;
                    i = 0;
                } else {
                    i = i31;
                }
                fg fgVar = mn0Var4.b;
                int iR = ((pm1Var2.c - 1) * qh1Var.R(fgVar.a())) + i;
                int i32 = q40.i(jA3);
                int iG3 = q40.g(jA3);
                if (iR < i32) {
                    iR = i32;
                }
                if (iR <= iG3) {
                    iG3 = iR;
                }
                fgVar.i(iG3, qh1Var, iArr3, iArr7);
                int iJ2 = q40.j(jA3);
                int iH2 = q40.h(jA3);
                if (i30 < iJ2) {
                    i30 = iJ2;
                }
                if (i30 <= iH2) {
                    iH2 = i30;
                }
                return qh1Var.j0(iH2, iG3, ji0Var, new x0(11, pm1Var2));
            }
            kn0Var.getClass();
        }
        return qh1Var.j0(0, 0, ji0Var, new j(7));
    }

    @Override // defpackage.oh1
    public final int g(z21 z21Var, List list, int i) {
        ArrayList arrayListA = er4.a(z21Var);
        mn0 mn0Var = this.a;
        kn0 kn0Var = mn0Var.f;
        List list2 = (List) mz.z(1, arrayListA);
        jh1 jh1Var = list2 != null ? (jh1) mz.y(list2) : null;
        List list3 = (List) mz.z(2, arrayListA);
        kn0Var.a(jh1Var, list3 != null ? (jh1) mz.y(list3) : null, r40.b(i, 0, 13));
        List list4 = (List) mz.y(arrayListA);
        if (list4 == null) {
            list4 = ii0.a;
        }
        return mn0.a(list4, i, z21Var.R(mn0Var.c), z21Var.R(mn0Var.e), mn0Var.f);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    /* JADX WARN: Code duplicated, block: B:114:0x0228  */
    /* JADX WARN: Code duplicated, block: B:129:0x022c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x0218 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.oh1
    public final int i(z21 z21Var, List list, int i) {
        int[] iArr;
        long jA;
        ArrayList arrayListA = er4.a(z21Var);
        mn0 mn0Var = this.a;
        kn0 kn0Var = mn0Var.f;
        int i2 = 1;
        List list2 = (List) mz.z(1, arrayListA);
        jh1 jh1Var = list2 != null ? (jh1) mz.y(list2) : null;
        List list3 = (List) mz.z(2, arrayListA);
        kn0Var.a(jh1Var, list3 != null ? (jh1) mz.y(list3) : null, r40.b(0, i, 7));
        List list4 = (List) mz.y(arrayListA);
        if (list4 == null) {
            list4 = ii0.a;
        }
        int iR = z21Var.R(mn0Var.c);
        int iR2 = z21Var.R(mn0Var.e);
        kn0 kn0Var2 = mn0Var.f;
        long jA2 = a21.a(0, 0);
        if (list4.isEmpty()) {
            return 0;
        }
        int size = list4.size();
        int[] iArr2 = new int[size];
        int size2 = list4.size();
        int[] iArr3 = new int[size2];
        int size3 = list4.size();
        for (int i3 = 0; i3 < size3; i3++) {
            jh1 jh1Var2 = (jh1) list4.get(i3);
            int iV = jh1Var2.V(i);
            iArr2[i3] = iV;
            iArr3[i3] = jh1Var2.e0(iV);
        }
        int i4 = Integer.MAX_VALUE;
        if (Integer.MAX_VALUE < list4.size()) {
            kn0Var2.getClass();
        }
        if (Integer.MAX_VALUE >= list4.size()) {
            kn0Var2.getClass();
        }
        int iMin = Math.min(Integer.MAX_VALUE, list4.size());
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += iArr2[i6];
        }
        int size4 = ((list4.size() - 1) * iR) + i5;
        if (size2 == 0) {
            dk0.d();
            return 0;
        }
        int i7 = iArr3[0];
        int i8 = size2 - 1;
        int i9 = 0;
        if (1 <= i8) {
            int i10 = 1;
            while (true) {
                int i11 = iArr3[i10];
                if (i7 < i11) {
                    i7 = i11;
                }
                if (i10 == i8) {
                    break;
                }
                i10++;
            }
        }
        if (size == 0) {
            dk0.d();
            return 0;
        }
        int i12 = iArr2[0];
        int i13 = size - 1;
        if (1 <= i13) {
            int i14 = 1;
            while (true) {
                int i15 = iArr2[i14];
                if (i12 < i15) {
                    i12 = i15;
                }
                if (i14 == i13) {
                    break;
                }
                i14++;
            }
        }
        int i16 = size4;
        while (i12 <= i16 && i7 != i) {
            int i17 = (i12 + i16) / 2;
            if (list4.isEmpty()) {
                iArr = iArr2;
            } else {
                int i18 = i9;
                en0 en0Var = new en0(kn0Var2, r40.a(i18, i17, i18, i4), iR, iR2);
                jh1 jh1Var3 = (jh1) mz.z(i18, list4);
                int i19 = jh1Var3 != null ? iArr3[i18] : i18;
                int i20 = jh1Var3 != null ? iArr2[i18] : 0;
                iArr = iArr2;
                int i21 = 0;
                if (en0Var.b(list4.size() > i2 ? i2 : 0, 0, a21.a(i17, Integer.MAX_VALUE), jh1Var3 == null ? null : new a21(a21.a(i20, i19)), 0, 0, 0, false, false).b) {
                    kn0Var2.getClass();
                } else {
                    int size5 = list4.size();
                    jA2 = jA2;
                    int i22 = i17;
                    int i23 = i20;
                    int i24 = i19;
                    int i25 = 0;
                    int i26 = 0;
                    int i27 = 0;
                    int i28 = 0;
                    int i29 = 0;
                    while (true) {
                        if (i27 >= size5) {
                            list4 = list4;
                            break;
                        }
                        int i30 = i22 - i23;
                        i29 = i27 + 1;
                        int iMax = Math.max(i26, i24);
                        jh1 jh1Var4 = (jh1) mz.z(i29, list4);
                        i24 = jh1Var4 != null ? iArr3[i29] : 0;
                        i23 = jh1Var4 != null ? iArr[i29] + iR : 0;
                        list4 = list4;
                        int i31 = i29 - i28;
                        int i32 = i25;
                        ph phVarB = en0Var.b(i27 + 2 < list4.size(), i31, a21.a(i30, Integer.MAX_VALUE), jh1Var4 == null ? null : new a21(a21.a(i23, i24)), i32, i21, iMax, false, false);
                        if (phVarB.a) {
                            int i33 = iMax + iR2 + i21;
                            en0Var.a(phVarB, jh1Var4 != null, i32, i33, i30, i31);
                            i23 -= iR;
                            i25 = i32 + 1;
                            if (phVarB.b) {
                                i21 = i33;
                                break;
                            }
                            i22 = i17;
                            i28 = i29;
                            i21 = i33;
                            i26 = 0;
                        } else {
                            i25 = i32;
                            i26 = iMax;
                            i22 = i30;
                        }
                        i27 = i29;
                        list4 = list4;
                    }
                    jA = a21.a(i21 - iR2, i29);
                }
                i7 = (int) (jA >> 32);
                int i34 = (int) (jA & 4294967295L);
                if (i7 <= i || i34 < iMin) {
                    i12 = i17 + 1;
                    if (i12 > i16) {
                        return i12;
                    }
                } else {
                    if (i7 >= i) {
                        return i17;
                    }
                    i16 = i17 - 1;
                }
                size4 = i17;
                iArr2 = iArr;
                jA2 = jA2;
                list4 = list4;
                i2 = 1;
                i4 = Integer.MAX_VALUE;
                i9 = 0;
            }
            jA = jA2;
            i7 = (int) (jA >> 32);
            int i35 = (int) (jA & 4294967295L);
            if (i7 <= i) {
                i12 = i17 + 1;
                if (i12 > i16) {
                    return i12;
                }
            } else {
                i12 = i17 + 1;
                if (i12 > i16) {
                    return i12;
                }
            }
            size4 = i17;
            iArr2 = iArr;
            jA2 = jA2;
            list4 = list4;
            i2 = 1;
            i4 = Integer.MAX_VALUE;
            i9 = 0;
        }
        return size4;
    }

    public final String toString() {
        return "MultiContentMeasurePolicyImpl(measurePolicy=" + this.a + ')';
    }
}
