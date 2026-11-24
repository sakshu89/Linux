package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class vq4 {
    public static dd1 a(Integer num) {
        if (num != null && num.intValue() == 429) {
            return dd1.c;
        }
        return ((num != null && num.intValue() == 400) || (num != null && num.intValue() == 401) || ((num != null && num.intValue() == 403) || ((num != null && num.intValue() == 404) || ((num != null && num.intValue() == 405) || ((num != null && num.intValue() == 410) || (num != null && num.intValue() == 422)))))) ? dd1.b : dd1.a;
    }

    public static String b(dd1 dd1Var) {
        int iOrdinal = dd1Var.ordinal();
        if (iOrdinal == 0) {
            return "Live connection was interrupted. Reconnecting automatically.";
        }
        if (iOrdinal == 1) {
            return "Gemini Live rejected this connection. SONIC selects compatible models automatically; check this key's Live access in Google AI Studio if it persists.";
        }
        if (iOrdinal == 2) {
            return "Live reached the provider's rate or quota limit. It will retry automatically.";
        }
        if (iOrdinal == 3) {
            return "Microphone permission is required for Live audio.";
        }
        dk0.l();
        return null;
    }
}
