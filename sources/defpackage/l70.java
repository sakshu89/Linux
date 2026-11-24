package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class l70 extends c1 implements h70 {
    public static final k70 b = new k70(qs4.c, new j(21));

    public l70() {
        super(qs4.c);
    }

    @Override // defpackage.c1, defpackage.j70
    public final j70 D(i70 i70Var) {
        i70Var.getClass();
        if (i70Var instanceof k70) {
            k70 k70Var = (k70) i70Var;
            i70 i70Var2 = this.a;
            if ((i70Var2 != k70Var && k70Var.b != i70Var2) || ((h70) k70Var.a.j(this)) == null) {
                return this;
            }
        } else if (qs4.c != i70Var) {
            return this;
        }
        return gi0.a;
    }

    public abstract void L(j70 j70Var, Runnable runnable);

    public void M(j70 j70Var, Runnable runnable) {
        ry3.c(this, j70Var, runnable);
    }

    public boolean N(j70 j70Var) {
        return !(this instanceof k43);
    }

    public l70 O(int i) {
        lq4.a(i);
        return new vb1(this, i);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + ba0.c(this);
    }

    @Override // defpackage.c1, defpackage.j70
    public final h70 v(i70 i70Var) {
        h70 h70Var;
        i70Var.getClass();
        if (i70Var instanceof k70) {
            k70 k70Var = (k70) i70Var;
            i70 i70Var2 = this.a;
            if ((i70Var2 == k70Var || k70Var.b == i70Var2) && (h70Var = (h70) k70Var.a.j(this)) != null) {
                return h70Var;
            }
        } else if (qs4.c == i70Var) {
            return this;
        }
        return null;
    }
}
