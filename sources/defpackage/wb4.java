package defpackage;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import com.ibm.icu.impl.coll.CollationFastLatin;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wb4 {
    public static final void a(boolean z, p62 p62Var, ny2 ny2Var, x20 x20Var, int i) {
        int i2;
        hz2 hz2VarD;
        x20Var.X(-1344558920);
        if ((i & 6) == 0) {
            i2 = (x20Var.g(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.d(p62Var.ordinal()) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.h(ny2Var) ? 256 : 128;
        }
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            int i3 = i2 & 14;
            boolean zF = (i3 == 4) | x20Var.f(ny2Var);
            Object objL = x20Var.L();
            xy xyVar = r20.a;
            if (zF || objL == xyVar) {
                objL = new ky2(ny2Var, z);
                x20Var.g0(objL);
            }
            wx2 wx2Var = (wx2) objL;
            boolean zH = (i3 == 4) | x20Var.h(ny2Var);
            Object objL2 = x20Var.L();
            if (zH || objL2 == xyVar) {
                objL2 = new oy2(ny2Var, z);
                x20Var.g0(objL2);
            }
            op1 op1Var = (op1) objL2;
            boolean zG = oz2.g(ny2Var.n().b);
            int i4 = (int) (z ? ny2Var.n().b >> 32 : ny2Var.n().b & 4294967295L);
            ua1 ua1Var = ny2Var.d;
            float fE = 0.0f;
            if (ua1Var != null && (hz2VarD = ua1Var.d()) != null) {
                gz2 gz2Var = hz2VarD.a;
                if (i4 >= 0) {
                    fz2 fz2Var = gz2Var.a;
                    fl1 fl1Var = gz2Var.b;
                    if (fz2Var.a.b.length() != 0) {
                        int iMin = Math.min(fl1Var.d(i4), Math.min(fl1Var.b - 1, fl1Var.f - 1));
                        if (i4 <= fl1Var.c(iMin, false)) {
                            fl1Var.l(iMin);
                            ArrayList arrayList = fl1Var.h;
                            au1 au1Var = (au1) arrayList.get(qr4.b(iMin, arrayList));
                            ia iaVar = au1Var.a;
                            int i5 = iMin - au1Var.d;
                            ez2 ez2Var = iaVar.d;
                            fE = ez2Var.e(i5) - ez2Var.g(i5);
                        }
                    }
                }
            }
            float f = fE;
            boolean zH2 = x20Var.h(wx2Var);
            Object objL3 = x20Var.L();
            if (zH2 || objL3 == xyVar) {
                objL3 = new e9(5, wx2Var);
                x20Var.g0(objL3);
            }
            vd4.b(op1Var, z, p62Var, zG, 0L, f, pu2.a(bk1.a, wx2Var, (PointerInputEventHandler) objL3), x20Var, (i2 << 3) & 1008);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new tb(z, p62Var, ny2Var, i);
        }
    }

    public Object b(Class cls) {
        d22 d22VarC = c(cls);
        if (d22VarC == null) {
            return null;
        }
        return d22VarC.get();
    }

    public abstract d22 c(Class cls);

    public Set d(Class cls) {
        return (Set) e(cls).get();
    }

    public abstract d22 e(Class cls);
}
