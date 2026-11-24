package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j5 {
    public static final iz1 c = new iz1("conversation_mode");
    public static final iz1 d = new iz1("live_model");
    public static final iz1 e = new iz1("confirmation_threshold");
    public static final iz1 f = new iz1("tier");
    public static final iz1 g = new iz1("ambient_listening");
    public static final iz1 h = new iz1("setup_complete");
    public static final iz1 i = new iz1("language");
    public static final iz1 j = new iz1("screen_reading_enabled");
    public static final iz1 k = new iz1("direct_whatsapp_messages");
    public static final iz1 l = new iz1("honorific_enabled");
    public final Context a;
    public final i5 b;

    public j5(Context context) {
        this.a = context;
        this.b = new i5(((c90) ((py0) k5.a(context)).b).d(), this, 0);
    }

    public final Object a(ic2 ic2Var) {
        return rn4.c(this.b, ic2Var);
    }

    public final Object b(boolean z, y50 y50Var) {
        Object objA = rq1.a(k5.a(this.a), new d0(z, (x50) null, 1), y50Var);
        return objA == t70.a ? objA : q43.a;
    }
}
