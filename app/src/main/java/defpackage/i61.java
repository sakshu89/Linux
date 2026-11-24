package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class i61 {
    public static final /* synthetic */ c51[] a;
    public static final hz1 b;

    static {
        u12 u12Var = new u12("secretDataStore", i61.class, "getSecretDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;");
        u42.a.getClass();
        a = new c51[]{u12Var};
        b = dl1.a("sonic_secrets");
    }

    public static final c90 a(Context context) {
        return b.a(context, a[0]);
    }
}
