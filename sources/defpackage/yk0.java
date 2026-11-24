package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yk0 {
    public static final xk0 a = new xk0();
    public static final xk0 b;

    static {
        w12 w12Var = w12.c;
        xk0 xk0Var = null;
        try {
            xk0Var = (xk0) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        b = xk0Var;
    }
}
