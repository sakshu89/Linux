package defpackage;

import com.ibm.icu.impl.UCharacterProperty;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t91 {
    public final ea1 a;
    public final r91 b;
    public final k81 c;
    public final t9 d;

    public t91(ea1 ea1Var, r91 r91Var, k81 k81Var, t9 t9Var) {
        this.a = ea1Var;
        this.b = r91Var;
        this.c = k81Var;
        this.d = t9Var;
    }

    public final void a(int i, Object obj, x20 x20Var, int i2) {
        int i3;
        Object obj2;
        x20 x20Var2;
        x20Var.X(-462424778);
        int i4 = (x20Var.d(i) ? 4 : 2) | i2 | (x20Var.h(obj) ? 32 : 16) | (x20Var.f(this) ? 256 : 128);
        int i5 = 0;
        if (x20Var.O(i4 & 1, (i4 & 147) != 146)) {
            i3 = i;
            obj2 = obj;
            x20Var2 = x20Var;
            cq4.a(obj2, i3, this.a.r, yi4.b(-824725566, new s91(this, i, i5), x20Var), x20Var2, ((i4 >> 3) & 14) | UCharacterProperty.SCRIPT_X_WITH_OTHER | ((i4 << 3) & 112));
        } else {
            i3 = i;
            obj2 = obj;
            x20Var2 = x20Var;
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new w81(this, i3, obj2, i2);
        }
    }

    public final Object b(int i) {
        r91 r91Var = this.b;
        r91Var.getClass();
        y21 y21VarA = r91Var.a.a(i);
        ((gn) y21VarA.c.b).j(Integer.valueOf(i - y21VarA.a));
        return null;
    }

    public final int c() {
        r91 r91Var = this.b;
        r91Var.getClass();
        return r91Var.a.b;
    }

    public final Object d(int i) {
        t9 t9Var = this.d;
        Object[] objArr = (Object[]) t9Var.e;
        int i2 = i - t9Var.b;
        Object obj = (i2 < 0 || i2 >= objArr.length) ? null : objArr[i2];
        if (obj != null) {
            return obj;
        }
        r91 r91Var = this.b;
        r91Var.getClass();
        int i3 = r91Var.a.a(i).a;
        return new ra0(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t91)) {
            return false;
        }
        return g31.a(this.b, ((t91) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }
}
