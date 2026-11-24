package defpackage;

import com.ibm.icu.text.PluralRules;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a63 implements o21 {
    public static final x42 a = new x42("^(copy|share)(?:\\s+(.*))?$");
    public static final x42 b = new x42("^(ise|isko|iska|yeh|ye|usko|uska)\\s+(copy|share)$");
    public static final x42 c = new x42("\\s*\\b(?:to|on|in|into)\\s+(?:the\\s+)?clip\\s?board$");
    public static final x42 d = new x42("\\s*\\b(?:to|on|in|into)\\s+(?:the\\s+)?clip\\s?board\\b[.!?]*\\s*$", y42.IGNORE_CASE);
    public static final x42 e = new x42("^(?:that|this|these|those|it|ise|isko|yeh|ye|usko)\\b\\s*");
    public static final Set f = wh2.c("", "link", "links", "url", "text", "message", "answer", "reply", "result", "address", "number", PluralRules.KEYWORD_ONE, "thing", "that", "this", "it");
    public static final x42 g = new x42("^(?:price|prices|market|markets|value|holder|holders|capital)\\b");
    public static final x42 h = new x42("\\bwith\\s+\\S+");
    public static final x42 i = new x42("\\s+\\b(?:with|to|for)$");

    @Override // defpackage.o21
    public final int a() {
        return 800;
    }

    @Override // defpackage.o21
    public final String b() {
        return "utility";
    }

    @Override // defpackage.o21
    public final f5 c(b63 b63Var, i60 i60Var) {
        i60Var.getClass();
        String str = b63Var.c;
        fh1 fh1VarD = b.d(str);
        String str2 = null;
        if (fh1VarD != null) {
            return dp4.d(b63Var, g31.a((String) ((dh1) fh1VarD.a()).get(2), "share") ? "message.share.text" : "util.clipboard.copy", null, 0.6f, 10);
        }
        fh1 fh1VarD2 = a.d(str);
        if (fh1VarD2 != null) {
            String str3 = (String) ((dh1) fh1VarD2.a()).get(1);
            String strB = dp4.b(c.f((CharSequence) ((dh1) fh1VarD2.a()).get(2), ""));
            if ((!g31.a(str3, "share") || !g.a(strB)) && (!g31.a(str3, "share") || !h.a(strB))) {
                String strF = i.f(strB, "");
                Set set = f;
                if (!set.contains(strF)) {
                    String strF2 = e.f(strF, "");
                    if (strF2.equals(strF) || !set.contains(strF2)) {
                        String str4 = g31.a(str3, "share") ? "message.share.text" : "util.clipboard.copy";
                        String str5 = b63Var.a;
                        int iY = cs2.y(str5, str3, 0, true, 2);
                        if (iY >= 0) {
                            String string = cs2.V(d.f(str5.substring(str3.length() + iY), "")).toString();
                            if (!cs2.A(string)) {
                                str2 = string;
                            }
                        }
                        if (str2 != null) {
                            strF = str2;
                        }
                        Map mapSingletonMap = Collections.singletonMap("text", strF);
                        mapSingletonMap.getClass();
                        return dp4.d(b63Var, str4, mapSingletonMap, 0.9f, 8);
                    }
                }
                return dp4.d(b63Var, g31.a(str3, "share") ? "message.share.text" : "util.clipboard.copy", null, 0.6f, 10);
            }
        }
        return null;
    }
}
