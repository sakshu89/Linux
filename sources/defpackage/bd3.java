package defpackage;

import com.ibm.icu.impl.CalendarAstronomer;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bd3 {
    public final h61 a;
    public final f40 b;
    public final rp1 c;
    public final u22 d;
    public final ConcurrentHashMap e;

    public bd3(h61 h61Var, f40 f40Var) {
        h61Var.getClass();
        f40Var.getClass();
        this.a = h61Var;
        this.b = f40Var;
        qp1 qp1Var = new qp1();
        qp1Var.h = false;
        qp1Var.i = false;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.getClass();
        qp1Var.v = z53.b("timeout", 4000L, timeUnit);
        qp1Var.w = z53.b("timeout", 4000L, timeUnit);
        qp1Var.x = z53.b("timeout", 4000L, timeUnit);
        qp1Var.f = false;
        this.c = new rp1(qp1Var);
        this.d = new u22(90, 12, CalendarAstronomer.DAY_MS);
        this.e = new ConcurrentHashMap();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0051  */
    public static hd3 a(String str) {
        Object h72Var;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        String strOptString;
        String strOptString2;
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("items");
            if (jSONArrayOptJSONArray == null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("id")) == null || (strOptString = jSONObjectOptJSONObject2.optString("videoId")) == null) {
                h72Var = null;
            } else {
                if (cs2.A(strOptString)) {
                    strOptString = null;
                }
                if (strOptString != null) {
                    JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("snippet");
                    if (jSONObjectOptJSONObject3 == null || (strOptString2 = jSONObjectOptJSONObject3.optString("title")) == null || cs2.A(strOptString2)) {
                        strOptString2 = null;
                    }
                    h72Var = new hd3(strOptString, strOptString2);
                } else {
                    h72Var = null;
                }
            }
        } catch (Throwable th) {
            h72Var = new h72(th);
        }
        return (hd3) (h72Var instanceof h72 ? null : h72Var);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(String str, y50 y50Var) throws Throwable {
        ad3 ad3Var;
        String str2;
        String str3;
        if (y50Var instanceof ad3) {
            ad3Var = (ad3) y50Var;
            int i = ad3Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                ad3Var.k = i - Integer.MIN_VALUE;
            } else {
                ad3Var = new ad3(this, y50Var);
            }
        } else {
            ad3Var = new ad3(this, y50Var);
        }
        Object obj = ad3Var.i;
        int i2 = ad3Var.k;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(obj);
            String string = cs2.V(str).toString();
            Locale locale = Locale.ROOT;
            String strO = cq.o(locale, string, locale);
            if (cs2.A(strO)) {
                return new fd3("No video title was provided.");
            }
            hd3 hd3Var = (hd3) this.e.get(strO);
            if (hd3Var != null) {
                return hd3Var;
            }
            if (!this.b.a()) {
                return new gd3("I'm offline, so I can't resolve a video.");
            }
            ad3Var.e = str;
            ad3Var.f = strO;
            ad3Var.k = 1;
            Object objE = this.a.e("youtube_api_key", ad3Var);
            if (objE != t70Var) {
                str2 = str;
                str3 = strO;
                obj = objE;
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                bz3.g(obj);
                return obj;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        String str4 = ad3Var.f;
        String str5 = ad3Var.e;
        bz3.g(obj);
        str3 = str4;
        str2 = str5;
        String str6 = (String) obj;
        if (str6 == null) {
            return new gd3("No YouTube Data API key is configured; using the app's search.");
        }
        if (!this.d.b()) {
            return new gd3("The YouTube lookup allowance is used up for today.");
        }
        xa0 xa0Var = ld0.a;
        qa0 qa0Var = qa0.c;
        aa aaVar = new aa(str2, str6, this, str3, null, 17);
        ad3Var.e = null;
        ad3Var.f = null;
        ad3Var.k = 2;
        Object objD = uf4.d(qa0Var, aaVar, ad3Var);
        return objD == t70Var ? t70Var : objD;
    }
}
