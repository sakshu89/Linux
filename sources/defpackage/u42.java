package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class u42 {
    public static final v42 a;

    static {
        v42 v42Var = null;
        try {
            v42Var = (v42) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (v42Var == null) {
            v42Var = new v42();
        }
        a = v42Var;
    }

    public static dy a(Class cls) {
        a.getClass();
        return new dy(cls);
    }
}
