package defpackage;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class bx0 {
    public static final dw0[] a;
    public static final Map b;

    static {
        dw0 dw0Var = new dw0(dw0.i, "");
        oo ooVar = dw0.f;
        dw0 dw0Var2 = new dw0(ooVar, "GET");
        dw0 dw0Var3 = new dw0(ooVar, "POST");
        oo ooVar2 = dw0.g;
        dw0 dw0Var4 = new dw0(ooVar2, "/");
        dw0 dw0Var5 = new dw0(ooVar2, "/index.html");
        oo ooVar3 = dw0.h;
        dw0 dw0Var6 = new dw0(ooVar3, "http");
        dw0 dw0Var7 = new dw0(ooVar3, "https");
        oo ooVar4 = dw0.e;
        dw0[] dw0VarArr = {dw0Var, dw0Var2, dw0Var3, dw0Var4, dw0Var5, dw0Var6, dw0Var7, new dw0(ooVar4, "200"), new dw0(ooVar4, "204"), new dw0(ooVar4, "206"), new dw0(ooVar4, "304"), new dw0(ooVar4, "400"), new dw0(ooVar4, "404"), new dw0(ooVar4, "500"), new dw0("accept-charset", ""), new dw0("accept-encoding", "gzip, deflate"), new dw0("accept-language", ""), new dw0("accept-ranges", ""), new dw0("accept", ""), new dw0("access-control-allow-origin", ""), new dw0("age", ""), new dw0("allow", ""), new dw0("authorization", ""), new dw0("cache-control", ""), new dw0("content-disposition", ""), new dw0("content-encoding", ""), new dw0("content-language", ""), new dw0("content-length", ""), new dw0("content-location", ""), new dw0("content-range", ""), new dw0("content-type", ""), new dw0("cookie", ""), new dw0("date", ""), new dw0("etag", ""), new dw0("expect", ""), new dw0("expires", ""), new dw0("from", ""), new dw0("host", ""), new dw0("if-match", ""), new dw0("if-modified-since", ""), new dw0("if-none-match", ""), new dw0("if-range", ""), new dw0("if-unmodified-since", ""), new dw0("last-modified", ""), new dw0("link", ""), new dw0("location", ""), new dw0("max-forwards", ""), new dw0("proxy-authenticate", ""), new dw0("proxy-authorization", ""), new dw0("range", ""), new dw0("referer", ""), new dw0("refresh", ""), new dw0("retry-after", ""), new dw0("server", ""), new dw0("set-cookie", ""), new dw0("strict-transport-security", ""), new dw0("transfer-encoding", ""), new dw0("user-agent", ""), new dw0("vary", ""), new dw0("via", ""), new dw0("www-authenticate", "")};
        a = dw0VarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i = 0; i < 61; i++) {
            if (!linkedHashMap.containsKey(dw0VarArr[i].a)) {
                linkedHashMap.put(dw0VarArr[i].a, Integer.valueOf(i));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        mapUnmodifiableMap.getClass();
        b = mapUnmodifiableMap;
    }

    public static void a(oo ooVar) throws IOException {
        ooVar.getClass();
        int iC = ooVar.c();
        for (int i = 0; i < iC; i++) {
            byte bF = ooVar.f(i);
            if (65 <= bF && bF < 91) {
                dk0.h("PROTOCOL_ERROR response malformed: mixed case name: ".concat(ooVar.j()));
                return;
            }
        }
    }
}
