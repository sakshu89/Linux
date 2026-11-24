package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class m61 {
    public static final Set a = wh2.c(new w3("message.compose.choose_channel"), new w3("message.sms.send"), new w3("message.sms.confirm_send"), new w3("message.draft"), new w3("message.whatsapp.draft"), new w3("message.whatsapp.send"), new w3("message.share.text"), new w3("screen.type"));

    public static f5 a(f5 f5Var) {
        Set setB;
        f5Var.getClass();
        Map map = f5Var.b;
        String str = f5Var.a;
        if (a.contains(new w3(str))) {
            setB = wh2.c("message_body", "text");
        } else {
            if (!g31.a(str, "util.clipboard.copy")) {
                return f5Var;
            }
            setB = wh2.b("text");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(bh1.b(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            String str2 = (String) entry.getKey();
            String strD = (String) entry.getValue();
            if (setB.contains(str2)) {
                strD = n61.a.d(strD);
            }
            linkedHashMap.put(key, strD);
        }
        return linkedHashMap.equals(map) ? f5Var : f5.a(f5Var, null, linkedHashMap, 29);
    }
}
