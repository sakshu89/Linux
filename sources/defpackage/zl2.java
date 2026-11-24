package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zl2 {
    public static final Map b;
    public final r2 a;

    static {
        xl2 xl2Var = new xl2(wh2.b("compose_message_text"), wh2.c("conversation_title", "conversation_subtitle", "recipient_text_view", "recipient_number", "recipients_editor"), wh2.c("send_message_button", "send_message_button_icon", "send_message_button_container"), wh2.c("message_text", "message_text_view"));
        b = bh1.c(new wt1("com.google.android.apps.messaging", xl2Var), new wt1("com.android.messaging", xl2Var), new wt1("com.android.mms", new xl2(wh2.b("embedded_text_editor"), wh2.c("recipients_editor", "recipient_number", "conversation_title"), wh2.b("send_button_sms"), wh2.b("text_view"))), new wt1("com.samsung.android.messaging", new xl2(wh2.b("editor_body"), wh2.c("recipients_editor_to", "recipient_number", "conversation_title"), wh2.c("send_button", "send_button1"), wh2.c("message_text", "body_text_view"))));
    }

    public zl2(r2 r2Var) {
        r2Var.getClass();
        this.a = r2Var;
    }

    public static final String a(String str, wl2 wl2Var) {
        String viewIdResourceName = wl2Var.a.getViewIdResourceName();
        String strR = null;
        if (viewIdResourceName != null) {
            if (!js2.k(viewIdResourceName, str.concat(":id/"), false)) {
                viewIdResourceName = null;
            }
            if (viewIdResourceName != null) {
                strR = cs2.R(viewIdResourceName, ":id/");
            }
        }
        return strR == null ? "" : strR;
    }
}
