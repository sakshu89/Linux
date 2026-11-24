package defpackage;

import java.io.IOException;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dk0 implements dr0, mk2, ae0, lf2 {
    public final /* synthetic */ int a;

    public /* synthetic */ dk0(int i) {
        this.a = i;
    }

    public static /* synthetic */ void d() {
        throw new NoSuchElementException();
    }

    public static /* synthetic */ void e(int i, String str) {
        throw new IllegalStateException((str + i).toString());
    }

    public static /* synthetic */ void f(int i, StringBuilder sb) {
        sb.append(i);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static /* synthetic */ void g(Object obj, String str) throws IOException {
        throw new IOException(str + obj);
    }

    public static /* synthetic */ void h(String str) throws IOException {
        throw new IOException(str);
    }

    public static /* synthetic */ void i(String str, Object obj, Object obj2) {
        throw new IllegalStateException((str + obj + obj2).toString());
    }

    public static /* synthetic */ void j(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void k(String str, Object obj, Throwable th) {
        throw new RuntimeException(str + obj, th);
    }

    public static /* synthetic */ void l() {
        throw new b10();
    }

    public static /* synthetic */ void m(Object obj, String str) {
        throw new IllegalArgumentException((str + obj + '\"').toString());
    }

    public static /* synthetic */ void n(String str) {
        throw new NullPointerException(str);
    }

    public static /* synthetic */ void o(String str, Object obj, Object obj2) {
        throw new b10(str + obj + obj2);
    }

    public static /* synthetic */ void p() {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ void q(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void r(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static /* synthetic */ void s(String str, Object obj, Object obj2) {
        throw new IllegalArgumentException((str + obj + obj2).toString());
    }

    public static /* synthetic */ void t() {
        throw new ClassCastException();
    }

    public static /* synthetic */ void u(Object obj, String str) {
        throw new IllegalStateException((str + obj).toString());
    }

    public static /* synthetic */ void v() {
        throw new IllegalArgumentException();
    }

    public static /* synthetic */ void w(Object obj, String str) {
        throw new IllegalArgumentException((str + obj).toString());
    }

    public static /* synthetic */ void x(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void y(Object obj, String str) {
        throw new IllegalArgumentException(str + obj);
    }

    @Override // defpackage.mk2
    public boolean a() {
        return false;
    }

    @Override // defpackage.dr0
    public Object apply(Object obj) {
        switch (this.a) {
            case 4:
                oy0 oy0Var = ry0.z;
                break;
        }
        return null;
    }

    @Override // defpackage.lf2
    public jf2 b(s9 s9Var) {
        switch (this.a) {
            case 27:
                iz izVar = (iz) s9Var.e;
                return new jf2(izVar.a(izVar.b), izVar.a(izVar.c), s9Var.g() == e80.a);
            case 28:
                return o24.a(s9Var, qs4.j);
            default:
                return o24.a(s9Var, nr4.s);
        }
    }

    @Override // defpackage.ae0
    public double c(double d) {
        return d;
    }
}
