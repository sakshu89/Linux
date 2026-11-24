package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zg1 {
    public static final yg1 a;
    public static final yg1 b;

    static {
        w12 w12Var = w12.c;
        yg1 yg1Var = null;
        try {
            yg1Var = (yg1) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = yg1Var;
        b = new yg1();
    }
}
