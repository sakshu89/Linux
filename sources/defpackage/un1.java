package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class un1 {
    public static final tn1 a;
    public static final tn1 b;

    static {
        w12 w12Var = w12.c;
        tn1 tn1Var = null;
        try {
            tn1Var = (tn1) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = tn1Var;
        b = new tn1();
    }
}
