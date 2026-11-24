package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yr4 {
    public static final void a(bs1 bs1Var, int i, Object obj) {
        bs1Var.e[(bs1Var.f - bs1Var.a[bs1Var.b - 1].b) + i] = obj;
    }

    public static final void b(bs1 bs1Var, int i, Object obj, int i2, Object obj2) {
        int i3 = bs1Var.f - bs1Var.a[bs1Var.b - 1].b;
        Object[] objArr = bs1Var.e;
        objArr[i + i3] = obj;
        objArr[i3 + i2] = obj2;
    }
}
