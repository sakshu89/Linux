package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tl1 extends vg1 {
    public final lw1 e;
    public Object f;

    public tl1(lw1 lw1Var, Object obj, Object obj2) {
        super(0, obj, obj2);
        this.e = lw1Var;
        this.f = obj2;
    }

    @Override // defpackage.vg1, java.util.Map.Entry
    public final Object getValue() {
        return this.f;
    }

    @Override // defpackage.vg1, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.f;
        this.f = obj;
        jw1 jw1Var = (jw1) this.e.b;
        fw1 fw1Var = jw1Var.e;
        Object obj3 = this.b;
        if (!fw1Var.containsKey(obj3)) {
            return obj2;
        }
        boolean z = jw1Var.c;
        if (!z) {
            fw1Var.put(obj3, obj);
        } else {
            if (!z) {
                dk0.d();
                return null;
            }
            y23 y23Var = jw1Var.a[jw1Var.b];
            Object obj4 = y23Var.a[y23Var.c];
            fw1Var.put(obj3, obj);
            jw1Var.c(obj4 != null ? obj4.hashCode() : 0, fw1Var.b, obj4, 0);
        }
        jw1Var.j = fw1Var.e;
        return obj2;
    }
}
