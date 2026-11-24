package defpackage;

import com.ibm.icu.impl.coll.CollationFastLatin;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class aa2 implements y92 {
    public static final q91 f = new q91(26, new ag(10), new va1(10));
    public final Map a;
    public final gm1 b;
    public ba2 c;
    public final x0 e;

    public aa2(Map map) {
        this.a = map;
        long[] jArr = ya2.a;
        this.b = new gm1();
        this.e = new x0(24, this);
    }

    @Override // defpackage.y92
    public final void b(Object obj, w10 w10Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(533563200);
        if ((i & 6) == 0) {
            i2 = (x20Var.h(obj) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.h(w10Var) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.h(this) ? 256 : 128;
        }
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            x20Var.Y(obj);
            Object objL = x20Var.L();
            xy xyVar = r20.a;
            if (objL == xyVar) {
                x0 x0Var = this.e;
                if (!((Boolean) x0Var.j(obj)).booleanValue()) {
                    dk0.s("Type of the key ", obj, " is not supported. On Android you can only use types which can be stored inside the Bundle.");
                    return;
                }
                Map map = (Map) this.a.get(obj);
                sr2 sr2Var = da2.a;
                ea2 ea2Var = new ea2(new ca2(map, x0Var));
                x20Var.g0(ea2Var);
                objL = ea2Var;
            }
            ea2 ea2Var2 = (ea2) objL;
            kj4.b(new a22[]{da2.a.a(ea2Var2), le1.a.a(ea2Var2)}, w10Var, x20Var, (i2 & 112) | 8);
            boolean zH = x20Var.h(this) | x20Var.h(obj) | x20Var.h(ea2Var2);
            Object objL2 = x20Var.L();
            if (zH || objL2 == xyVar) {
                objL2 = new e2(this, obj, ea2Var2, 9);
                x20Var.g0(objL2);
            }
            bz3.a(q43.a, (hq0) objL2, x20Var);
            if (x20Var.y && x20Var.G.i == x20Var.z) {
                x20Var.z = -1;
                x20Var.y = false;
            }
            x20Var.p(false);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new mb(this, obj, w10Var, i, 8);
        }
    }
}
