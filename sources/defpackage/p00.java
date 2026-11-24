package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p00 implements j70, Serializable {
    public final j70 a;
    public final h70 b;

    public p00(h70 h70Var, j70 j70Var) {
        j70Var.getClass();
        h70Var.getClass();
        this.a = j70Var;
        this.b = h70Var;
    }

    @Override // defpackage.j70
    public final j70 D(i70 i70Var) {
        i70Var.getClass();
        h70 h70Var = this.b;
        h70 h70VarV = h70Var.v(i70Var);
        j70 j70Var = this.a;
        if (h70VarV != null) {
            return j70Var;
        }
        j70 j70VarD = j70Var.D(i70Var);
        if (j70VarD == j70Var) {
            return this;
        }
        return j70VarD == gi0.a ? h70Var : new p00(h70Var, j70VarD);
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof p00) {
            p00 p00Var = (p00) obj;
            int i = 2;
            p00 p00Var2 = p00Var;
            int i2 = 2;
            while (true) {
                j70 j70Var = p00Var2.a;
                p00Var2 = j70Var instanceof p00 ? (p00) j70Var : null;
                if (p00Var2 == null) {
                    break;
                }
                i2++;
            }
            p00 p00Var3 = this;
            while (true) {
                j70 j70Var2 = p00Var3.a;
                p00Var3 = j70Var2 instanceof p00 ? (p00) j70Var2 : null;
                if (p00Var3 == null) {
                    break;
                }
                i++;
            }
            if (i2 == i) {
                while (true) {
                    h70 h70Var = this.b;
                    if (!g31.a(p00Var.v(h70Var.getKey()), h70Var)) {
                        zA = false;
                        break;
                    }
                    j70 j70Var3 = this.a;
                    if (!(j70Var3 instanceof p00)) {
                        j70Var3.getClass();
                        h70 h70Var2 = (h70) j70Var3;
                        zA = g31.a(p00Var.v(h70Var2.getKey()), h70Var2);
                        break;
                    }
                    this = (p00) j70Var3;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode();
    }

    @Override // defpackage.j70
    public final j70 r(j70 j70Var) {
        j70Var.getClass();
        return j70Var == gi0.a ? this : (j70) j70Var.y(new ag(2), this);
    }

    public final String toString() {
        return ky0.n(new StringBuilder("["), (String) y(new ag(1), ""), ']');
    }

    @Override // defpackage.j70
    public final h70 v(i70 i70Var) {
        i70Var.getClass();
        while (true) {
            h70 h70VarV = this.b.v(i70Var);
            if (h70VarV != null) {
                return h70VarV;
            }
            j70 j70Var = this.a;
            if (!(j70Var instanceof p00)) {
                return j70Var.v(i70Var);
            }
            this = (p00) j70Var;
        }
    }

    @Override // defpackage.j70
    public final Object y(vq0 vq0Var, Object obj) {
        return vq0Var.e(this.a.y(vq0Var, obj), this.b);
    }
}
