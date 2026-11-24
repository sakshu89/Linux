package defpackage;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v71 implements xs2 {
    public z61 a = z61.b;
    public float b;
    public float c;
    public final /* synthetic */ b81 e;

    public v71(b81 b81Var) {
        this.e = b81Var;
    }

    @Override // defpackage.xs2
    public final List F(vq0 vq0Var, Object obj) {
        b81 b81Var = this.e;
        b81Var.h();
        n71 n71Var = b81Var.a;
        j71 j71Var = n71Var.p0.d;
        j71 j71Var2 = j71.c;
        j71 j71Var3 = j71.a;
        if (j71Var != j71Var3 && j71Var != j71Var2 && j71Var != j71.b && j71Var != j71.e) {
            z01.b("subcompose can only be used inside the measure or layout blocks");
        }
        gm1 gm1Var = b81Var.j;
        Object objG = gm1Var.g(obj);
        if (objG == null) {
            objG = (n71) b81Var.s.k(obj);
            if (objG != null) {
                if (b81Var.x <= 0) {
                    z01.b("Check failed.");
                }
                b81Var.x--;
            } else {
                objG = b81Var.n(obj);
                if (objG == null) {
                    int i = b81Var.e;
                    n71 n71Var2 = new n71(2);
                    n71Var.X = true;
                    n71Var.B(i, n71Var2);
                    n71Var.X = false;
                    objG = n71Var2;
                }
            }
            gm1Var.m(obj, objG);
        }
        n71 n71Var3 = (n71) objG;
        if (mz.z(b81Var.e, n71Var.o()) != n71Var3) {
            int iJ = ((pm1) ((wl1) n71Var.o()).b).j(n71Var3);
            if (iJ < b81Var.e) {
                z01.a("Key \"" + obj + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.");
            }
            int i2 = b81Var.e;
            if (i2 != iJ) {
                b81Var.j(iJ, i2);
            }
        }
        b81Var.e++;
        b81Var.m(n71Var3, obj, false, vq0Var);
        return (j71Var == j71Var3 || j71Var == j71Var2) ? n71Var3.m() : n71Var3.l();
    }

    @Override // defpackage.qh1
    public final ph1 O(int i, int i2, Map map, hq0 hq0Var, hq0 hq0Var2) {
        if ((i & (-16777216)) != 0 || ((-16777216) & i2) != 0) {
            z01.b("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new u71(i, i2, map, hq0Var, this, this.e, hq0Var2);
    }

    @Override // defpackage.jc0
    public final float b() {
        return this.b;
    }

    @Override // defpackage.z21
    public final z61 getLayoutDirection() {
        return this.a;
    }

    @Override // defpackage.jc0
    public final float l() {
        return this.c;
    }

    @Override // defpackage.z21
    public final boolean s() {
        j71 j71Var = this.e.a.p0.d;
        return j71Var == j71.e || j71Var == j71.b;
    }
}
