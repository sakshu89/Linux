package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class tc1 {
    public static final sc1 a;
    public static final sc1 b;

    static {
        w12 w12Var = w12.c;
        sc1 sc1Var = null;
        try {
            sc1Var = (sc1) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = sc1Var;
        b = new sc1();
    }
}
