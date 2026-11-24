package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class fb {
    public static final m30 a = new m30(f8.n);
    public static final m30 b = new m30(f8.k);

    /* JADX WARN: Code duplicated, block: B:102:0x021b  */
    /* JADX WARN: Code duplicated, block: B:103:0x021f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0245  */
    /* JADX WARN: Code duplicated, block: B:108:0x024f  */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x003b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0043  */
    /* JADX WARN: Code duplicated, block: B:26:0x0046  */
    /* JADX WARN: Code duplicated, block: B:28:0x004a  */
    /* JADX WARN: Code duplicated, block: B:31:0x0052  */
    /* JADX WARN: Code duplicated, block: B:33:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x005b  */
    /* JADX WARN: Code duplicated, block: B:38:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x0068  */
    /* JADX WARN: Code duplicated, block: B:42:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x0076  */
    /* JADX WARN: Code duplicated, block: B:47:0x00af  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:54:0x0106  */
    /* JADX WARN: Code duplicated, block: B:55:0x0108  */
    /* JADX WARN: Code duplicated, block: B:58:0x0110  */
    /* JADX WARN: Code duplicated, block: B:59:0x0112  */
    /* JADX WARN: Code duplicated, block: B:65:0x012e  */
    /* JADX WARN: Code duplicated, block: B:68:0x014a  */
    /* JADX WARN: Code duplicated, block: B:69:0x014c  */
    /* JADX WARN: Code duplicated, block: B:72:0x0153  */
    /* JADX WARN: Code duplicated, block: B:73:0x0155  */
    /* JADX WARN: Code duplicated, block: B:79:0x0171  */
    /* JADX WARN: Code duplicated, block: B:82:0x018e  */
    /* JADX WARN: Code duplicated, block: B:83:0x0190  */
    /* JADX WARN: Code duplicated, block: B:87:0x019b  */
    /* JADX WARN: Code duplicated, block: B:91:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:95:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:99:0x01f5  */
    public static final void a(az1 az1Var, fq0 fq0Var, bz1 bz1Var, w10 w10Var, x20 x20Var, int i, int i2) {
        int i3;
        fq0 fq0Var2;
        bz1 bz1Var2;
        int i4;
        boolean z;
        fq0 fq0Var3;
        a42 a42VarR;
        fq0 fq0Var4;
        View view;
        jc0 jc0Var;
        String str;
        z61 z61Var;
        v20 v20VarA;
        mm1 mm1VarH;
        Object objL;
        Object obj;
        Object obj2;
        UUID uuid;
        boolean zBooleanValue;
        Object objL2;
        String str2;
        boolean z2;
        yy1 yy1Var;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        boolean zF;
        Object objL3;
        yy1 yy1Var2;
        boolean z5;
        boolean z6;
        boolean zF2;
        Object objL4;
        int i7;
        boolean z7;
        boolean z8;
        Object obj3;
        boolean zH;
        Object obj4;
        boolean zH2;
        Object obj5;
        boolean zH3;
        Object obj6;
        fq0 fq0Var5;
        int i8;
        int i9;
        az1 az1Var2 = az1Var;
        x20Var.X(-1772091631);
        if ((i & 6) == 0) {
            i3 = (x20Var.f(az1Var2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                fq0Var2 = fq0Var;
                i3 |= x20Var.h(fq0Var2) ? 32 : 16;
            }
            if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
                bz1Var2 = bz1Var;
                if (x20Var.f(bz1Var2)) {
                    i9 = 256;
                } else {
                    i9 = 128;
                }
                i3 |= i9;
            } else {
                bz1Var2 = bz1Var;
            }
            if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
                if (x20Var.h(w10Var)) {
                    i8 = 2048;
                } else {
                    i8 = 1024;
                }
                i3 |= i8;
            }
            i4 = i3;
            if ((i4 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (x20Var.O(i4 & 1, z)) {
                if (i10 != 0) {
                    fq0Var4 = null;
                } else {
                    fq0Var4 = fq0Var2;
                }
                view = (View) x20Var.j(AndroidCompositionLocals_androidKt.f);
                jc0Var = (jc0) x20Var.j(l30.h);
                str = (String) x20Var.j(a);
                z61Var = (z61) x20Var.j(l30.n);
                v20VarA = aj4.a(x20Var);
                mm1VarH = o44.h(w10Var, x20Var);
                Object[] objArr = new Object[0];
                objL = x20Var.L();
                obj = r20.a;
                obj2 = objL;
                if (objL == obj) {
                    Object obj7 = f8.s;
                    x20Var.g0(obj7);
                    obj2 = obj7;
                }
                uuid = (UUID) yy3.b(objArr, (fq0) obj2, x20Var);
                zBooleanValue = ((Boolean) x20Var.j(b)).booleanValue();
                objL2 = x20Var.L();
                if (objL2 == obj) {
                    str2 = str;
                    z2 = true;
                    yy1 yy1Var3 = new yy1(fq0Var4, bz1Var2, str2, view, jc0Var, az1Var2, uuid, zBooleanValue);
                    az1Var2 = az1Var2;
                    yy1Var3.h(v20VarA, new w10(-297523940, true, new cb(yy1Var3, mm1VarH, true ? 1 : 0)));
                    x20Var.g0(yy1Var3);
                    objL2 = yy1Var3;
                } else {
                    str2 = str;
                    z2 = true;
                }
                yy1Var = (yy1) objL2;
                boolean zH4 = x20Var.h(yy1Var);
                i5 = i4 & 112;
                if (i5 == 32) {
                    z3 = z2;
                } else {
                    z3 = false;
                }
                boolean z9 = zH4 | z3;
                i6 = i4 & 896;
                if (i6 == 256) {
                    z4 = z2;
                } else {
                    z4 = false;
                }
                zF = z9 | z4 | x20Var.f(str2) | x20Var.d(z61Var.ordinal());
                objL3 = x20Var.L();
                if (!zF || objL3 == obj) {
                    yy1Var2 = yy1Var;
                    Object waVar = new wa(yy1Var2, fq0Var4, bz1Var, str2, z61Var);
                    x20Var.g0(waVar);
                    objL3 = waVar;
                } else {
                    yy1Var2 = yy1Var;
                }
                bz3.a(yy1Var2, (hq0) objL3, x20Var);
                boolean zH5 = x20Var.h(yy1Var2);
                if (i5 == 32) {
                    z5 = z2;
                } else {
                    z5 = false;
                }
                boolean z10 = zH5 | z5;
                if (i6 == 256) {
                    z6 = z2;
                } else {
                    z6 = false;
                }
                zF2 = z10 | z6 | x20Var.f(str2) | x20Var.d(z61Var.ordinal());
                objL4 = x20Var.L();
                if (zF2 || objL4 == obj) {
                    Object xaVar = new xa(yy1Var2, fq0Var4, bz1Var, str2, z61Var);
                    x20Var.g0(xaVar);
                    objL4 = xaVar;
                }
                bz3.d((fq0) objL4, x20Var);
                boolean zH6 = x20Var.h(yy1Var2);
                i7 = 4;
                if ((i4 & 14) == 4) {
                    z7 = z2;
                } else {
                    z7 = false;
                }
                z8 = zH6 | z7;
                Object objL5 = x20Var.L();
                obj3 = objL5;
                if (z8 == 0 || objL5 == obj) {
                    Object k8Var = new k8(i7, yy1Var2, az1Var2);
                    x20Var.g0(k8Var);
                    obj3 = k8Var;
                }
                bz3.a(az1Var2, (hq0) obj3, x20Var);
                zH = x20Var.h(yy1Var2);
                Object objL6 = x20Var.L();
                obj4 = objL6;
                if (zH || objL6 == obj) {
                    Object p0Var = new p0(yy1Var2, null, 4);
                    x20Var.g0(p0Var);
                    obj4 = p0Var;
                }
                bz3.c(x20Var, (vq0) obj4, yy1Var2);
                zH2 = x20Var.h(yy1Var2);
                Object objL7 = x20Var.L();
                obj5 = objL7;
                if (zH2 || objL7 == obj) {
                    Object zaVar = new za(yy1Var2, 0);
                    x20Var.g0(zaVar);
                    obj5 = zaVar;
                }
                ek1 ek1VarA = w24.a(bk1.a, (hq0) obj5);
                zH3 = x20Var.h(yy1Var2) | x20Var.d(z61Var.ordinal());
                Object objL8 = x20Var.L();
                obj6 = objL8;
                if (zH3 || objL8 == obj) {
                    Object abVar = new ab(yy1Var2, z61Var);
                    x20Var.g0(abVar);
                    obj6 = abVar;
                }
                oh1 oh1Var = (oh1) obj6;
                int iHashCode = Long.hashCode(x20Var.T);
                gw1 gw1VarL = x20Var.l();
                ek1 ek1VarC = gj4.c(x20Var, ek1VarA);
                o20.p.getClass();
                fq0Var5 = n20.b;
                x20Var.Z();
                if (x20Var.S) {
                    x20Var.k(fq0Var5);
                } else {
                    x20Var.j0();
                }
                ie4.c(x20Var, n20.f, oh1Var);
                ie4.c(x20Var, n20.e, gw1VarL);
                ie4.a(x20Var, Integer.valueOf(iHashCode), n20.g);
                ie4.b(x20Var, n20.h);
                ie4.c(x20Var, n20.d, ek1VarC);
                x20Var.p(z2);
                fq0Var3 = fq0Var4;
            } else {
                x20Var.R();
                fq0Var3 = fq0Var2;
            }
            a42VarR = x20Var.r();
            if (a42VarR != null) {
                a42VarR.d = new bb(az1Var2, fq0Var3, bz1Var, w10Var, i, i2);
            }
        }
        i3 |= 48;
        fq0Var2 = fq0Var;
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            bz1Var2 = bz1Var;
            if (x20Var.f(bz1Var2)) {
                i9 = 256;
            } else {
                i9 = 128;
            }
            i3 |= i9;
        } else {
            bz1Var2 = bz1Var;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            if (x20Var.h(w10Var)) {
                i8 = 2048;
            } else {
                i8 = 1024;
            }
            i3 |= i8;
        }
        i4 = i3;
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (x20Var.O(i4 & 1, z)) {
            if (i10 != 0) {
                fq0Var4 = null;
            } else {
                fq0Var4 = fq0Var2;
            }
            view = (View) x20Var.j(AndroidCompositionLocals_androidKt.f);
            jc0Var = (jc0) x20Var.j(l30.h);
            str = (String) x20Var.j(a);
            z61Var = (z61) x20Var.j(l30.n);
            v20VarA = aj4.a(x20Var);
            mm1VarH = o44.h(w10Var, x20Var);
            Object[] objArr2 = new Object[0];
            objL = x20Var.L();
            obj = r20.a;
            obj2 = objL;
            if (objL == obj) {
                Object obj8 = f8.s;
                x20Var.g0(obj8);
                obj2 = obj8;
            }
            uuid = (UUID) yy3.b(objArr2, (fq0) obj2, x20Var);
            zBooleanValue = ((Boolean) x20Var.j(b)).booleanValue();
            objL2 = x20Var.L();
            if (objL2 == obj) {
                str2 = str;
                z2 = true;
                yy1 yy1Var4 = new yy1(fq0Var4, bz1Var2, str2, view, jc0Var, az1Var2, uuid, zBooleanValue);
                az1Var2 = az1Var2;
                yy1Var4.h(v20VarA, new w10(-297523940, true, new cb(yy1Var4, mm1VarH, true ? 1 : 0)));
                x20Var.g0(yy1Var4);
                objL2 = yy1Var4;
            } else {
                str2 = str;
                z2 = true;
            }
            yy1Var = (yy1) objL2;
            boolean zH7 = x20Var.h(yy1Var);
            i5 = i4 & 112;
            if (i5 == 32) {
                z3 = z2;
            } else {
                z3 = false;
            }
            boolean z11 = zH7 | z3;
            i6 = i4 & 896;
            if (i6 == 256) {
                z4 = z2;
            } else {
                z4 = false;
            }
            zF = z11 | z4 | x20Var.f(str2) | x20Var.d(z61Var.ordinal());
            objL3 = x20Var.L();
            if (zF) {
                yy1Var2 = yy1Var;
                Object waVar2 = new wa(yy1Var2, fq0Var4, bz1Var, str2, z61Var);
                x20Var.g0(waVar2);
                objL3 = waVar2;
            } else {
                yy1Var2 = yy1Var;
                Object waVar3 = new wa(yy1Var2, fq0Var4, bz1Var, str2, z61Var);
                x20Var.g0(waVar3);
                objL3 = waVar3;
            }
            bz3.a(yy1Var2, (hq0) objL3, x20Var);
            boolean zH8 = x20Var.h(yy1Var2);
            if (i5 == 32) {
                z5 = z2;
            } else {
                z5 = false;
            }
            boolean z12 = zH8 | z5;
            if (i6 == 256) {
                z6 = z2;
            } else {
                z6 = false;
            }
            zF2 = z12 | z6 | x20Var.f(str2) | x20Var.d(z61Var.ordinal());
            objL4 = x20Var.L();
            if (zF2) {
                Object xaVar2 = new xa(yy1Var2, fq0Var4, bz1Var, str2, z61Var);
                x20Var.g0(xaVar2);
                objL4 = xaVar2;
            } else {
                Object xaVar3 = new xa(yy1Var2, fq0Var4, bz1Var, str2, z61Var);
                x20Var.g0(xaVar3);
                objL4 = xaVar3;
            }
            bz3.d((fq0) objL4, x20Var);
            boolean zH9 = x20Var.h(yy1Var2);
            i7 = 4;
            if ((i4 & 14) == 4) {
                z7 = z2;
            } else {
                z7 = false;
            }
            z8 = zH9 | z7;
            Object objL9 = x20Var.L();
            obj3 = objL9;
            if (z8 == 0) {
                Object k8Var2 = new k8(i7, yy1Var2, az1Var2);
                x20Var.g0(k8Var2);
                obj3 = k8Var2;
            } else {
                Object k8Var3 = new k8(i7, yy1Var2, az1Var2);
                x20Var.g0(k8Var3);
                obj3 = k8Var3;
            }
            bz3.a(az1Var2, (hq0) obj3, x20Var);
            zH = x20Var.h(yy1Var2);
            Object objL10 = x20Var.L();
            obj4 = objL10;
            if (zH) {
                Object p0Var2 = new p0(yy1Var2, null, 4);
                x20Var.g0(p0Var2);
                obj4 = p0Var2;
            } else {
                Object p0Var3 = new p0(yy1Var2, null, 4);
                x20Var.g0(p0Var3);
                obj4 = p0Var3;
            }
            bz3.c(x20Var, (vq0) obj4, yy1Var2);
            zH2 = x20Var.h(yy1Var2);
            Object objL11 = x20Var.L();
            obj5 = objL11;
            if (zH2) {
                Object zaVar2 = new za(yy1Var2, 0);
                x20Var.g0(zaVar2);
                obj5 = zaVar2;
            } else {
                Object zaVar3 = new za(yy1Var2, 0);
                x20Var.g0(zaVar3);
                obj5 = zaVar3;
            }
            ek1 ek1VarA2 = w24.a(bk1.a, (hq0) obj5);
            zH3 = x20Var.h(yy1Var2) | x20Var.d(z61Var.ordinal());
            Object objL12 = x20Var.L();
            obj6 = objL12;
            if (zH3) {
                Object abVar2 = new ab(yy1Var2, z61Var);
                x20Var.g0(abVar2);
                obj6 = abVar2;
            } else {
                Object abVar3 = new ab(yy1Var2, z61Var);
                x20Var.g0(abVar3);
                obj6 = abVar3;
            }
            oh1 oh1Var2 = (oh1) obj6;
            int iHashCode2 = Long.hashCode(x20Var.T);
            gw1 gw1VarL2 = x20Var.l();
            ek1 ek1VarC2 = gj4.c(x20Var, ek1VarA2);
            o20.p.getClass();
            fq0Var5 = n20.b;
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(fq0Var5);
            } else {
                x20Var.j0();
            }
            ie4.c(x20Var, n20.f, oh1Var2);
            ie4.c(x20Var, n20.e, gw1VarL2);
            ie4.a(x20Var, Integer.valueOf(iHashCode2), n20.g);
            ie4.b(x20Var, n20.h);
            ie4.c(x20Var, n20.d, ek1VarC2);
            x20Var.p(z2);
            fq0Var3 = fq0Var4;
        } else {
            x20Var.R();
            fq0Var3 = fq0Var2;
        }
        a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new bb(az1Var2, fq0Var3, bz1Var, w10Var, i, i2);
        }
    }

    public static final boolean b(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }
}
