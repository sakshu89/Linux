package defpackage;

import android.os.Build;
import android.view.KeyEvent;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class h51 {
    public static final bg a = new bg(0);
    public static final bg b = new bg(1);

    public static final long a(KeyEvent keyEvent) {
        return mp4.a(keyEvent.getKeyCode());
    }

    public static final int b(KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        if (action != 0) {
            return action != 1 ? 0 : 1;
        }
        return 2;
    }

    /* JADX WARN: Code duplicated, block: B:116:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:199:0x0197 A[EDGE_INSN: B:199:0x0197->B:70:0x0197 BREAK  A[LOOP:0: B:9:0x003e->B:68:0x0175], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0173 A[DONT_INVERT, PHI: r6 r20 r21 r22 r23 r24 r25 r26 r27 r28 r29
      0x0173: PHI (r6v6 r8) = (r6v5 r8), (r6v7 r8) binds: [B:10:0x004d, B:66:0x0171] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r20v6 boolean) = (r20v5 boolean), (r20v7 boolean) binds: [B:10:0x004d, B:66:0x0171] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r21v5 d13) = (r21v4 d13), (r21v6 d13) binds: [B:10:0x004d, B:66:0x0171] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r22v9 be) = (r22v8 be), (r22v10 be) binds: [B:10:0x004d, B:66:0x0171] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r23v15 i9) = (r23v14 i9), (r23v16 i9) binds: [B:10:0x004d, B:66:0x0171] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r24v6 n50) = (r24v5 n50), (r24v7 n50) binds: [B:10:0x004d, B:66:0x0171] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r25v6 java.lang.Boolean) = (r25v5 java.lang.Boolean), (r25v7 java.lang.Boolean) binds: [B:10:0x004d, B:66:0x0171] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r26v6 m82) = (r26v5 m82), (r26v7 m82) binds: [B:10:0x004d, B:66:0x0171] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r27v6 boolean) = (r27v5 boolean), (r27v7 boolean) binds: [B:10:0x004d, B:66:0x0171] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r28v6 boolean) = (r28v5 boolean), (r28v7 boolean) binds: [B:10:0x004d, B:66:0x0171] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r29v6 java.lang.Integer) = (r29v5 java.lang.Integer), (r29v7 java.lang.Integer) binds: [B:10:0x004d, B:66:0x0171] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x0175 A[LOOP:0: B:9:0x003e->B:68:0x0175, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v44 */
    /* JADX WARN: Type inference failed for: r13v45 */
    /* JADX WARN: Type inference failed for: r13v46 */
    /* JADX WARN: Type inference failed for: r13v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r23v6 */
    /* JADX WARN: Type inference failed for: r23v7 */
    /* JADX WARN: Type inference failed for: r38v0, types: [android.view.ViewStructure] */
    public static final void c(ViewStructure viewStructure, n71 n71Var, AutofillId autofillId, String str, n42 n42Var) {
        long j;
        long j2;
        char c;
        long j3;
        boolean zBooleanValue;
        d13 d13Var;
        be beVar;
        i9 i9Var;
        r8 r8Var;
        boolean z;
        n50 n50Var;
        Boolean bool;
        m82 m82Var;
        boolean z2;
        Integer num;
        int i;
        List list;
        Integer numValueOf;
        Object r13;
        String[] strArrB;
        String[] strArrB2;
        gm1 gm1Var;
        long[] jArr;
        Object[] objArr;
        int i2;
        long[] jArr2;
        Object[] objArr2;
        gm1 gm1Var2;
        d13 d13Var2;
        be beVar2;
        i9 i9Var2;
        ng2 ng2Var = kg2.a;
        ng2 ng2Var2 = bg2.a;
        cg2 cg2VarW = n71Var.w();
        int i3 = 8;
        if (cg2VarW == null || (gm1Var2 = cg2VarW.a) == null) {
            j = 128;
            j2 = 255;
            c = 7;
            j3 = -9187201950435737472L;
            zBooleanValue = true;
            d13Var = null;
            beVar = null;
            i9Var = null;
            r8Var = null;
            z = false;
            n50Var = null;
            bool = null;
            m82Var = null;
            z2 = false;
            num = null;
        } else {
            Object[] objArr3 = gm1Var2.b;
            j = 128;
            Object[] objArr4 = gm1Var2.c;
            long[] jArr3 = gm1Var2.a;
            int length = jArr3.length - 2;
            if (length >= 0) {
                zBooleanValue = true;
                int i4 = 0;
                r8Var = null;
                j2 = 255;
                z = false;
                d13Var2 = null;
                beVar2 = null;
                i9Var2 = null;
                n50Var = null;
                bool = null;
                m82Var = null;
                z2 = false;
                num = null;
                c = 7;
                while (true) {
                    long j4 = jArr3[i4];
                    j3 = -9187201950435737472L;
                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i4 != length) {
                            break;
                            break;
                        }
                        i4++;
                    } else {
                        int i5 = 8 - ((~(i4 - length)) >>> 31);
                        for (int i6 = 0; i6 < i5; i6++) {
                            if ((j4 & 255) < 128) {
                                int i7 = (i4 << 3) + i6;
                                Object obj = objArr3[i7];
                                Object obj2 = objArr4[i7];
                                ng2 ng2Var3 = (ng2) obj;
                                if (g31.a(ng2Var3, kg2.r)) {
                                    obj2.getClass();
                                    r8Var = (r8) obj2;
                                } else if (g31.a(ng2Var3, kg2.a)) {
                                    obj2.getClass();
                                    String str2 = (String) mz.y((List) obj2);
                                    if (str2 != null) {
                                        viewStructure.setContentDescription(str2);
                                    }
                                } else if (g31.a(ng2Var3, kg2.q)) {
                                    obj2.getClass();
                                    n50Var = (n50) obj2;
                                } else if (g31.a(ng2Var3, kg2.s)) {
                                    obj2.getClass();
                                    i9Var2 = (i9) obj2;
                                } else if (g31.a(ng2Var3, kg2.E)) {
                                    obj2.getClass();
                                    beVar2 = (be) obj2;
                                } else if (g31.a(ng2Var3, kg2.k)) {
                                    obj2.getClass();
                                    viewStructure.setFocused(((Boolean) obj2).booleanValue());
                                } else if (g31.a(ng2Var3, kg2.N)) {
                                    obj2.getClass();
                                    num = (Integer) obj2;
                                } else if (g31.a(ng2Var3, kg2.J)) {
                                    z2 = true;
                                } else if (g31.a(ng2Var3, kg2.n)) {
                                    obj2.getClass();
                                    zBooleanValue = ((Boolean) obj2).booleanValue();
                                } else if (g31.a(ng2Var3, kg2.x)) {
                                    obj2.getClass();
                                    m82Var = (m82) obj2;
                                } else if (g31.a(ng2Var3, kg2.H)) {
                                    obj2.getClass();
                                    bool = (Boolean) obj2;
                                } else if (g31.a(ng2Var3, kg2.I)) {
                                    obj2.getClass();
                                    d13Var2 = (d13) obj2;
                                } else if (g31.a(ng2Var3, bg2.b)) {
                                    viewStructure.setClickable(true);
                                } else if (g31.a(ng2Var3, bg2.c)) {
                                    viewStructure.setLongClickable(true);
                                } else if (g31.a(ng2Var3, bg2.w)) {
                                    viewStructure.setFocusable(true);
                                } else if (g31.a(ng2Var3, bg2.k)) {
                                    z = true;
                                }
                            }
                            j4 >>= 8;
                        }
                        if (i5 != 8) {
                            break;
                        } else if (i4 != length) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
            } else {
                j2 = 255;
                c = 7;
                j3 = -9187201950435737472L;
                zBooleanValue = true;
                r8Var = null;
                z = false;
                d13Var2 = null;
                beVar2 = null;
                i9Var2 = null;
                n50Var = null;
                bool = null;
                m82Var = null;
                z2 = false;
                num = null;
            }
            d13Var = d13Var2;
            beVar = beVar2;
            i9Var = i9Var2;
        }
        cg2 cg2VarW2 = n71Var.w();
        if (cg2VarW2 != null && cg2VarW2.c && !cg2VarW2.e) {
            cg2VarW2 = cg2VarW2.b();
            yl1 yl1Var = new yl1(((pm1) ((wl1) n71Var.n()).b).c);
            yl1Var.c(n71Var.n());
            while (yl1Var.i()) {
                n71 n71Var2 = (n71) yl1Var.k(yl1Var.b - 1);
                cg2 cg2VarW3 = n71Var2.w();
                if (cg2VarW3 != null && !cg2VarW3.c) {
                    cg2VarW2.f(cg2VarW3);
                    if (!cg2VarW3.e) {
                        yl1Var.c(n71Var2.n());
                    }
                }
            }
        }
        if (cg2VarW2 == null || (gm1Var = cg2VarW2.a) == null) {
            i = 1;
            list = null;
        } else {
            Object[] objArr5 = gm1Var.b;
            Object[] objArr6 = gm1Var.c;
            long[] jArr4 = gm1Var.a;
            int length2 = jArr4.length - 2;
            if (length2 >= 0) {
                int i8 = 1;
                int i9 = 0;
                list = null;
                while (true) {
                    long j5 = jArr4[i9];
                    int i10 = i3;
                    List list2 = list;
                    if ((((~j5) << c) & j5 & j3) != j3) {
                        int i11 = 8 - ((~(i9 - length2)) >>> 31);
                        i = i8;
                        list = list2;
                        int i12 = 0;
                        while (i12 < i11) {
                            if ((j5 & j2) < j) {
                                int i13 = (i9 << 3) + i12;
                                Object obj3 = objArr5[i13];
                                Object obj4 = objArr6[i13];
                                jArr2 = jArr4;
                                ng2 ng2Var4 = (ng2) obj3;
                                objArr2 = objArr5;
                                if (g31.a(ng2Var4, kg2.i)) {
                                    viewStructure.setEnabled(false);
                                } else if (g31.a(ng2Var4, kg2.A)) {
                                    obj4.getClass();
                                    list = (List) obj4;
                                }
                            } else {
                                jArr2 = jArr4;
                                objArr2 = objArr5;
                            }
                            j5 >>= i10;
                            i12++;
                            objArr5 = objArr2;
                            jArr4 = jArr2;
                        }
                        jArr = jArr4;
                        objArr = objArr5;
                        i2 = i10;
                        if (i11 != i2) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                        objArr = objArr5;
                        i = i8;
                        i2 = i10;
                        list = list2;
                    }
                    if (i9 == length2) {
                        break;
                    }
                    i9++;
                    i3 = i2;
                    i8 = i;
                    objArr5 = objArr;
                    jArr4 = jArr;
                }
            } else {
                i = 1;
                list = null;
            }
        }
        Integer numValueOf2 = Integer.valueOf(n71Var.b);
        if (n71Var.u() == null) {
            numValueOf2 = null;
        }
        int iIntValue = numValueOf2 != null ? numValueOf2.intValue() : -1;
        viewStructure.setAutofillId(autofillId, iIntValue);
        viewStructure.setId(iIntValue, str, null, null);
        if (r8Var != null) {
            numValueOf = Integer.valueOf(r8Var.a);
        } else if (z) {
            numValueOf = Integer.valueOf(i);
        } else {
            numValueOf = d13Var != null ? 2 : null;
        }
        if (numValueOf != null) {
            viewStructure.setAutofillType(numValueOf.intValue());
        }
        if (beVar != null) {
            viewStructure.setAutofillValue(AutofillValue.forText(beVar.b));
        }
        if (i9Var != null) {
            viewStructure.setAutofillValue(i9Var.a);
        }
        if (n50Var != null && (strArrB2 = zk4.b(n50Var)) != null) {
            viewStructure.setAutofillHints(strArrB2);
        }
        n42Var.a.h(n71Var.b, new vy1(viewStructure));
        if (bool != null) {
            viewStructure.setSelected(bool.booleanValue());
        }
        if (d13Var != null) {
            var r14 = i;
            viewStructure.setCheckable(r14);
            viewStructure.setChecked(d13Var == d13.a ? r14 == true ? 1 : 0 : false);
            r13 = r14;
        } else {
            var r15 = i;
            r13 = r15;
            if (bool != null) {
                viewStructure.setCheckable(r15);
                viewStructure.setChecked(bool.booleanValue());
                r13 = r15;
            }
        }
        n50.a.getClass();
        String[] strArrB3 = zk4.b(m50.b);
        strArrB3.getClass();
        if (strArrB3.length == 0) {
            kf2.g("Array is empty.");
            return;
        }
        var r23 = (z2 || ((n50Var == null || (strArrB = zk4.b(n50Var)) == null || qg.q(strArrB, strArrB3[0]) < 0) ? 0 : r13) != 0) ? r13 : 0;
        viewStructure.setDataIsSensitive((r23 != 0 || zBooleanValue) ? r13 : 0);
        viewStructure.setVisibility(n71Var.o0.d.d1() ? 4 : 0);
        if (list != null) {
            int size = list.size();
            String strN = "";
            for (int i14 = 0; i14 < size; i14++) {
                be beVar3 = (be) list.get(i14);
                StringBuilder sb = new StringBuilder();
                sb.append(strN);
                strN = ky0.n(sb, beVar3.b, '\n');
            }
            viewStructure.setText(strN);
            viewStructure.setClassName("android.widget.TextView");
        }
        if (((wl1) n71Var.n()).isEmpty() && m82Var != null) {
            viewStructure.setClassName("android.widget.Button");
        }
        if (z) {
            viewStructure.setClassName("android.widget.EditText");
            if (Build.VERSION.SDK_INT >= 28 && num != null) {
                viewStructure.setMaxTextLength(num.intValue());
            }
            if (r23 != 0) {
                viewStructure.setInputType(129);
            }
        }
    }
}
