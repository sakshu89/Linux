package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j23 {
    public final q91 a;
    public final j23 b;
    public final String c;
    public final ku1 d = o44.g(c());
    public final ku1 e = o44.g(new g23(c(), c()));
    public final iu1 f = new iu1(0);
    public final iu1 g = new iu1(Long.MIN_VALUE);
    public final ku1 h;
    public final um2 i;
    public final um2 j;
    public final ku1 k;

    public j23(q91 q91Var, j23 j23Var, String str) {
        this.a = q91Var;
        this.b = j23Var;
        this.c = str;
        Boolean bool = Boolean.FALSE;
        this.h = o44.g(bool);
        this.i = new um2();
        this.j = new um2();
        this.k = o44.g(bool);
        o44.b(new d23(this, 1));
    }

    public final void a(Boolean bool, x20 x20Var, int i) {
        int i2;
        x20Var.X(-1493585151);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? x20Var.f(bool) : x20Var.h(bool) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.f(this) ? 32 : 16;
        }
        int i3 = 0;
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            if (g()) {
                x20Var.W(416369985);
            } else {
                x20Var.W(466062241);
                k(bool);
                int i4 = i2 & 112;
                boolean z = i4 == 32;
                Object objL = x20Var.L();
                xy xyVar = r20.a;
                if (z || objL == xyVar) {
                    objL = o44.b(new d23(this, i3));
                    x20Var.g0(objL);
                }
                if (((Boolean) ((gr2) objL).getValue()).booleanValue()) {
                    x20Var.W(466470356);
                    Object objL2 = x20Var.L();
                    if (objL2 == xyVar) {
                        objL2 = bz3.e(x20Var);
                        x20Var.g0(objL2);
                    }
                    s70 s70Var = (s70) objL2;
                    boolean zH = x20Var.h(s70Var) | (i4 == 32);
                    Object objL3 = x20Var.L();
                    if (zH || objL3 == xyVar) {
                        objL3 = new o0(20, s70Var, this);
                        x20Var.g0(objL3);
                    }
                    bz3.b(s70Var, this, (hq0) objL3, x20Var);
                } else {
                    x20Var.W(416369985);
                }
                x20Var.p(false);
            }
            x20Var.p(false);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new gw(i, 5, this, bool);
        }
    }

    public final long b() {
        um2 um2Var = this.i;
        int size = um2Var.size();
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            jMax = Math.max(jMax, ((h23) um2Var.get(i)).s.g());
        }
        um2 um2Var2 = this.j;
        int size2 = um2Var2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            jMax = Math.max(jMax, ((j23) um2Var2.get(i2)).b());
        }
        return jMax;
    }

    public final Object c() {
        return ((ku1) this.a.c).getValue();
    }

    public final boolean d() {
        um2 um2Var = this.i;
        int size = um2Var.size();
        for (int i = 0; i < size; i++) {
            ((h23) um2Var.get(i)).getClass();
        }
        um2 um2Var2 = this.j;
        int size2 = um2Var2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (((j23) um2Var2.get(i2)).d()) {
                return true;
            }
        }
        return false;
    }

    public final long e() {
        j23 j23Var = this.b;
        return j23Var != null ? j23Var.e() : this.f.g();
    }

    public final g23 f() {
        return (g23) this.e.getValue();
    }

    public final boolean g() {
        return ((Boolean) this.k.getValue()).booleanValue();
    }

    public final void h(long j, boolean z) {
        q91 q91Var = this.a;
        ku1 ku1Var = (ku1) q91Var.b;
        iu1 iu1Var = this.g;
        if (iu1Var.g() == Long.MIN_VALUE) {
            iu1Var.h(j);
            ((ku1) q91Var.b).setValue(Boolean.TRUE);
        } else if (!((Boolean) ku1Var.getValue()).booleanValue()) {
            ku1Var.setValue(Boolean.TRUE);
        }
        this.h.setValue(Boolean.FALSE);
        um2 um2Var = this.i;
        int size = um2Var.size();
        boolean z2 = true;
        for (int i = 0; i < size; i++) {
            h23 h23Var = (h23) um2Var.get(i);
            ku1 ku1Var2 = h23Var.f;
            ku1 ku1Var3 = h23Var.f;
            if (!((Boolean) ku1Var2.getValue()).booleanValue()) {
                long jB = z ? h23Var.a().b() : j;
                h23Var.k.setValue(h23Var.a().a(jB));
                h23Var.n = h23Var.a().e(jB);
                if (h23Var.a().f(jB)) {
                    ku1Var3.setValue(Boolean.TRUE);
                }
            }
            if (!((Boolean) ku1Var3.getValue()).booleanValue()) {
                z2 = false;
            }
        }
        um2 um2Var2 = this.j;
        int size2 = um2Var2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            j23 j23Var = (j23) um2Var2.get(i2);
            if (!g31.a(j23Var.d.getValue(), j23Var.c())) {
                j23Var.h(j, z);
            }
            if (!g31.a(j23Var.d.getValue(), j23Var.c())) {
                z2 = false;
            }
        }
        if (z2) {
            i();
        }
    }

    public final void i() {
        this.g.h(Long.MIN_VALUE);
        Object value = this.d.getValue();
        q91 q91Var = this.a;
        ((ku1) q91Var.c).setValue(value);
        if (this.b == null) {
            this.f.h(0L);
        }
        ((ku1) q91Var.b).setValue(Boolean.FALSE);
        um2 um2Var = this.j;
        int size = um2Var.size();
        for (int i = 0; i < size; i++) {
            ((j23) um2Var.get(i)).i();
        }
    }

    public final void j(Object obj, Object obj2) {
        this.g.h(Long.MIN_VALUE);
        q91 q91Var = this.a;
        ((ku1) q91Var.b).setValue(Boolean.FALSE);
        boolean zG = g();
        ku1 ku1Var = this.d;
        if (!zG || !g31.a(c(), obj) || !g31.a(ku1Var.getValue(), obj2)) {
            if (!g31.a(c(), obj)) {
                ((ku1) q91Var.c).setValue(obj);
            }
            ku1Var.setValue(obj2);
            this.k.setValue(Boolean.TRUE);
            this.e.setValue(new g23(obj, obj2));
        }
        um2 um2Var = this.j;
        int size = um2Var.size();
        for (int i = 0; i < size; i++) {
            j23 j23Var = (j23) um2Var.get(i);
            j23Var.getClass();
            if (j23Var.g()) {
                j23Var.j(j23Var.c(), j23Var.d.getValue());
            }
        }
        um2 um2Var2 = this.i;
        int size2 = um2Var2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((h23) um2Var2.get(i2)).d();
        }
    }

    public final void k(Object obj) {
        ku1 ku1Var = this.d;
        if (g31.a(ku1Var.getValue(), obj)) {
            return;
        }
        this.e.setValue(new g23(ku1Var.getValue(), obj));
        if (!g31.a(c(), ku1Var.getValue())) {
            ((ku1) this.a.c).setValue(ku1Var.getValue());
        }
        ku1Var.setValue(obj);
        if (this.g.g() == Long.MIN_VALUE) {
            this.h.setValue(Boolean.TRUE);
        }
        um2 um2Var = this.i;
        int size = um2Var.size();
        for (int i = 0; i < size; i++) {
            ((h23) um2Var.get(i)).i.h(-2.0f);
        }
    }

    public final String toString() {
        um2 um2Var = this.i;
        int size = um2Var.size();
        String str = "Transition animation values: ";
        for (int i = 0; i < size; i++) {
            str = str + ((h23) um2Var.get(i)) + ", ";
        }
        return str;
    }
}
