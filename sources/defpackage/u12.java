package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class u12 extends v12 implements b51 {
    public u12(String str, Class cls, String str2) {
        super(op.a, cls, str, str2, 1);
    }

    @Override // defpackage.pp
    public final w41 d() {
        u42.a.getClass();
        return this;
    }

    @Override // defpackage.b51
    public final void g() {
        if (this.j) {
            dk0.r("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
            return;
        }
        w41 w41VarH = h();
        if (w41VarH == this) {
            throw new w70("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
        }
        ((b51) ((c51) w41VarH)).g();
    }

    public Object get(Object obj) {
        g();
        throw null;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        return get(obj);
    }
}
