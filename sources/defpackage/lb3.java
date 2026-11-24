package defpackage;

import android.os.Build;
import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class lb3 {
    public static final pb3 b;
    public final pb3 a;

    static {
        db3 za3Var;
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            za3Var = new cb3();
        } else if (i >= 31) {
            za3Var = new bb3();
        } else if (i >= 30) {
            za3Var = new ab3();
        } else {
            za3Var = i >= 29 ? new za3() : new ya3();
        }
        b = za3Var.b().a.a().a.b().a.c();
    }

    public lb3(pb3 pb3Var) {
        this.a = pb3Var;
    }

    public pb3 a() {
        return this.a;
    }

    public pb3 b() {
        return this.a;
    }

    public pb3 c() {
        return this.a;
    }

    public md0 e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lb3)) {
            return false;
        }
        lb3 lb3Var = (lb3) obj;
        return n() == lb3Var.n() && m() == lb3Var.m() && Objects.equals(k(), lb3Var.k()) && Objects.equals(i(), lb3Var.i()) && Objects.equals(e(), lb3Var.e());
    }

    public q11 f(int i) {
        return q11.e;
    }

    public q11 g(int i) {
        if ((i & 8) == 0) {
            return q11.e;
        }
        og.i("Unable to query the maximum insets for IME");
        return null;
    }

    public q11 h() {
        return k();
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(n()), Boolean.valueOf(m()), k(), i(), e());
    }

    public q11 i() {
        return q11.e;
    }

    public q11 j() {
        return k();
    }

    public q11 k() {
        return q11.e;
    }

    public q11 l() {
        return k();
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public boolean o(int i) {
        return true;
    }

    public void d(View view) {
    }

    public void p(q11[] q11VarArr) {
    }

    public void q(pb3 pb3Var) {
    }

    public void r(q11 q11Var) {
    }

    public void s(int i) {
    }
}
