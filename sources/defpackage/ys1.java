package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ys1 {
    public final Object a;

    public ys1(Object obj) {
        this.a = obj;
    }

    public Object a() {
        Object obj = this.a;
        hh1.b(obj instanceof xs1);
        return ((xs1) obj).a;
    }

    public String b() {
        return ((xs1) this.a).b;
    }

    public void c(long j) {
        ((xs1) this.a).c = j;
    }

    public void e(String str) {
        ((xs1) this.a).b = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ys1)) {
            return false;
        }
        return this.a.equals(((ys1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public void d(int i) {
    }

    public void f(long j) {
    }
}
