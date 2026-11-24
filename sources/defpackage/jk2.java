package defpackage;

import android.content.Context;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jk2 {
    public static final d10 b;
    public final Context a;

    static {
        lq lqVarA = d10.a(jk2.class);
        lqVarA.a(new mc0(1, 0, tj1.class));
        lqVarA.a(new mc0(1, 0, Context.class));
        lqVarA.f = new xy(25);
        b = lqVarA.c();
    }

    public jk2(Context context) {
        this.a = context;
    }

    public final synchronized String a() {
        String string = this.a.getSharedPreferences("com.google.mlkit.internal", 0).getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        this.a.getSharedPreferences("com.google.mlkit.internal", 0).edit().putString("ml_sdk_instance_id", string2).apply();
        return string2;
    }
}
