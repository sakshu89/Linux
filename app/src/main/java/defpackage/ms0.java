package defpackage;

import com.ibm.icu.impl.number.Padder;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ms0 implements c {
    public static final ji1 g;
    public final h61 a;
    public final f0 b;
    public final f40 c;
    public final c22 d;
    public final rp1 e;
    public final u22 f;

    static {
        Pattern pattern = ji1.c;
        g = gr4.a("application/json; charset=utf-8");
    }

    public ms0(h61 h61Var, f0 f0Var, f40 f40Var, c22 c22Var) {
        h61Var.getClass();
        f0Var.getClass();
        f40Var.getClass();
        c22Var.getClass();
        this.a = h61Var;
        this.b = f0Var;
        this.c = f40Var;
        this.d = c22Var;
        qp1 qp1Var = new qp1();
        qp1Var.h = false;
        qp1Var.i = false;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        timeUnit.getClass();
        qp1Var.w = z53.b("timeout", 8L, timeUnit);
        qp1Var.x = z53.b("timeout", 15L, timeUnit);
        qp1Var.v = z53.b("timeout", 20L, timeUnit);
        qp1Var.f = true;
        this.e = new rp1(qp1Var);
        this.f = new u22(30, 8, 60000L);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r12v5, types: [byte[], java.io.Serializable, java.lang.Object] */
    public static final Object f(ms0 ms0Var, String str, String str2, String str3, y50 y50Var) {
        is0 is0Var;
        if (y50Var instanceof is0) {
            is0Var = (is0) y50Var;
            int i = is0Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                is0Var.j = i - Integer.MIN_VALUE;
            } else {
                is0Var = new is0(ms0Var, y50Var);
            }
        } else {
            is0Var = new is0(ms0Var, y50Var);
        }
        Object objJ = is0Var.f;
        int i2 = is0Var.j;
        if (i2 == 0) {
            bz3.g(objJ);
            dy0 dy0Var = new dy0();
            dy0Var.d(null, "https://generativelanguage.googleapis.com/v1beta/models");
            dy0 dy0VarF = dy0Var.b().f();
            String strJ = ky0.j(str, ":generateContent");
            dy0VarF.e(strJ, 0, strJ.length(), false, false);
            ey0 ey0VarB = dy0VarF.b();
            cj cjVar = new cj(10);
            cjVar.b = ey0VarB;
            cjVar.v("x-goog-api-key", str2);
            str3.getClass();
            Charset charset = px.a;
            ji1 ji1VarA = g;
            if (ji1VarA != null) {
                Pattern pattern = ji1.c;
                Charset charsetA = ji1VarA.a(null);
                if (charsetA == null) {
                    try {
                        ji1VarA = gr4.a(ji1VarA + "; charset=utf-8");
                    } catch (IllegalArgumentException unused) {
                        ji1VarA = null;
                    }
                } else {
                    charset = charsetA;
                }
            }
            var bytes = str3.getBytes(charset);
            bytes.getClass();
            int length = bytes.length;
            z53.c(bytes.length, 0L, length);
            cjVar.x("POST", new t9(ji1VarA, length, bytes, 5));
            lj1 lj1VarJ = cjVar.j();
            is0Var.e = str2;
            is0Var.j = 1;
            objJ = ms0Var.j(lj1VarJ, is0Var);
            Object obj = t70.a;
            if (objJ == obj) {
                return obj;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str2 = is0Var.e;
            bz3.g(objJ);
        }
        yr0 yr0Var = (yr0) objJ;
        int i3 = yr0Var.a;
        String str4 = yr0Var.b;
        return (200 > i3 || i3 >= 300) ? new wr0(i3, h(str4, str2), null) : new vr0(str4);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:31:0x0088  */
    /* JADX WARN: Code duplicated, block: B:35:0x0090  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static final Object g(ms0 ms0Var, long j, String str, y50 y50Var) throws Throwable {
        ks0 ks0Var;
        String str2;
        f0 f0Var = ms0Var.b;
        if (y50Var instanceof ks0) {
            ks0Var = (ks0) y50Var;
            int i = ks0Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                ks0Var.k = i - Integer.MIN_VALUE;
            } else {
                ks0Var = new ks0(ms0Var, y50Var);
            }
        } else {
            ks0Var = new ks0(ms0Var, y50Var);
        }
        Object objI = ks0Var.i;
        int i2 = ks0Var.k;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(objI);
            ks0Var.f = str;
            ks0Var.e = j;
            ks0Var.k = 1;
            objI = f0Var.i(ks0Var);
            if (objI != t70Var) {
            }
            return t70Var;
        }
        if (i2 == 1) {
            j = ks0Var.e;
            str = ks0Var.f;
            bz3.g(objI);
        } else {
            if (i2 == 2) {
                j = ks0Var.e;
                str = ks0Var.f;
                bz3.g(objI);
                if (((o) objI).a) {
                    h61 h61Var = ms0Var.a;
                    ks0Var.f = str;
                    ks0Var.e = j;
                    ks0Var.k = 3;
                    objI = h61Var.e("gemini_api_key", ks0Var);
                    if (objI != t70Var) {
                        str2 = str;
                    }
                    return t70Var;
                }
                return Boolean.valueOf(z);
            }
            if (i2 != 3) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str2 = ks0Var.f;
            bz3.g(objI);
        }
        boolean z = g31.a(objI, str2);
        return Boolean.valueOf(z);
        if (((Number) objI).longValue() == j) {
            ks0Var.f = str;
            ks0Var.e = j;
            ks0Var.k = 2;
            objI = rn4.c(f0Var.b, ks0Var);
            if (objI != t70Var) {
                if (((o) objI).a) {
                    h61 h61Var2 = ms0Var.a;
                    ks0Var.f = str;
                    ks0Var.e = j;
                    ks0Var.k = 3;
                    objI = h61Var2.e("gemini_api_key", ks0Var);
                    if (objI != t70Var) {
                        str2 = str;
                        if (g31.a(objI, str2)) {
                        }
                    }
                }
            }
            return t70Var;
        }
        return Boolean.valueOf(z);
    }

    public static String h(String str, String str2) {
        String string;
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("error");
            if (jSONObjectOptJSONObject == null || (string = jSONObjectOptJSONObject.toString()) == null) {
                string = "Unreadable Gemini error response";
            }
            return js2.i(string, str2, "[redacted]");
        } catch (JSONException unused) {
            return "Unreadable Gemini error response";
        }
    }

    public static String i(d dVar, String str) throws JSONException {
        dVar.getClass();
        str.getClass();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("system_instruction", new JSONObject().put("parts", new JSONArray().put(new JSONObject().put("text", dVar.b.concat("\nYou are SONIC, a professional female AI assistant. Speak naturally in concise, clear sentences. Use feminine self-reference in languages that grammaticalize gender (e.g. Hindi 'main kar sakti hoon'). Respond naturally in the user's spoken language.")))));
        JSONArray jSONArray = new JSONArray();
        Iterator it = dVar.c.iterator();
        while (true) {
            String str2 = "user";
            if (!it.hasNext()) {
                break;
            }
            h0 h0Var = (h0) it.next();
            JSONObject jSONObject2 = new JSONObject();
            if (h0Var.a != i.a) {
                str2 = "model";
            }
            jSONArray.put(jSONObject2.put("role", str2).put("parts", new JSONArray().put(new JSONObject().put("text", h0Var.b))));
        }
        jSONArray.put(new JSONObject().put("role", "user").put("parts", new JSONArray().put(new JSONObject().put("text", dVar.a))));
        jSONObject.put("contents", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        int i = dVar.d;
        if (i < 1024) {
            i = 1024;
        }
        jSONObject3.put("maxOutputTokens", i);
        if (js2.k(str, "gemini-2.5-flash", false)) {
            jSONObject3.put("thinkingConfig", new JSONObject().put("thinkingBudget", 0));
        }
        jSONObject.put("generationConfig", jSONObject3);
        String string = jSONObject.toString();
        string.getClass();
        return string;
    }

    public static e k(String str, Throwable th) {
        w30 w30VarB = oj4.b(th);
        String strK = cq.k(th.getClass().getSimpleName(), ": ", th.getMessage());
        String strD = oj4.d(w30VarB);
        if (str != null && str.length() != 0) {
            strK = js2.i(strK, str, "[redacted]");
        }
        String strE = oj4.e(w30VarB, strK);
        w30 w30Var = w30.s;
        w30 w30Var2 = w30.k;
        w30 w30Var3 = w30.c;
        return new e(strD, strE, wh2.c(w30Var3, w30Var, w30Var2).contains(w30VarB), !wh2.c(w30.a, w30.b, w30Var3).contains(w30VarB));
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00ab  */
    public static h o(xr0 xr0Var) {
        Object h72Var;
        String str;
        String strOptString;
        JSONObject jSONObjectOptJSONObject;
        xr0Var.getClass();
        if (xr0Var instanceof wr0) {
            wr0 wr0Var = (wr0) xr0Var;
            Throwable iOException = wr0Var.c;
            if (iOException == null) {
                int i = wr0Var.a;
                String str2 = wr0Var.b;
                iOException = i == -1 ? new IOException(str2) : new e22(i, str2);
            }
            return k(null, iOException);
        }
        if (!(xr0Var instanceof vr0)) {
            dk0.l();
            return null;
        }
        JSONObject jSONObject = new JSONObject(((vr0) xr0Var).a);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("promptFeedback");
        String strOptString2 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("blockReason") : null;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("candidates");
        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.optJSONObject(0) : null;
        String strOptString3 = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optString("finishReason") : null;
        String string = "";
        if (strOptString3 == null) {
            strOptString3 = "";
        }
        JSONArray jSONArrayOptJSONArray2 = (jSONObjectOptJSONObject3 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("content")) == null) ? null : jSONObjectOptJSONObject.optJSONArray("parts");
        if (jSONArrayOptJSONArray2 != null) {
            h21 h21VarF = ky3.f(0, jSONArrayOptJSONArray2.length());
            ArrayList arrayList = new ArrayList();
            Iterator it = h21VarF.iterator();
            while (true) {
                g21 g21Var = (g21) it;
                if (!g21Var.c) {
                    break;
                }
                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(g21Var.nextInt());
                if (jSONObjectOptJSONObject4 == null) {
                    strOptString = null;
                } else {
                    if (jSONObjectOptJSONObject4.optBoolean("thought")) {
                        jSONObjectOptJSONObject4 = null;
                    }
                    if (jSONObjectOptJSONObject4 != null) {
                        strOptString = jSONObjectOptJSONObject4.optString("text");
                    } else {
                        strOptString = null;
                    }
                }
                if (strOptString != null) {
                    arrayList.add(strOptString);
                }
            }
            string = cs2.V(mz.C(arrayList, Padder.FALLBACK_PADDING_STRING, null, null, null, 62)).toString();
        }
        if ((strOptString2 != null && strOptString2.length() != 0) || wh2.c("SAFETY", "PROHIBITED_CONTENT").contains(strOptString3)) {
            if (strOptString2 == null) {
                strOptString2 = strOptString3;
            }
            return new e("Gemini could not answer that request.", "Response blocked: ".concat(strOptString2), false, true);
        }
        if (string.length() <= 0) {
            return new e("Gemini returned no answer. Please try again.", "Empty Gemini response; finishReason=".concat(strOptString3), true, true);
        }
        String string2 = cs2.V(cs2.I(cs2.G(cs2.G(string, "```json"), "```"), "```")).toString();
        if (js2.k(string2, "{", false)) {
            try {
                h72Var = new JSONObject(string2).optString("reply", string);
            } catch (Throwable th) {
                h72Var = new h72(th);
            }
            if (h72Var instanceof h72) {
                h72Var = string;
            }
            str = (String) h72Var;
        } else {
            str = string;
        }
        if (!cs2.A(str)) {
            string = str;
        }
        return new f(string, "gemini");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:45:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00df A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    @Override // defpackage.c
    public final Object a(d dVar, x50 x50Var) throws Throwable {
        ds0 ds0Var;
        Object objC;
        d dVar2;
        d dVar3;
        long jLongValue;
        long j;
        String str;
        Object objH;
        String str2;
        long j2;
        d dVar4;
        String str3;
        Object objC2;
        if (x50Var instanceof ds0) {
            ds0Var = (ds0) x50Var;
            int i = ds0Var.n;
            if ((i & Integer.MIN_VALUE) != 0) {
                ds0Var.n = i - Integer.MIN_VALUE;
            } else {
                ds0Var = new ds0(this, (y50) x50Var);
            }
        } else {
            ds0Var = new ds0(this, (y50) x50Var);
        }
        ds0 ds0Var2 = ds0Var;
        Object objE = ds0Var2.j;
        int i2 = ds0Var2.n;
        f0 f0Var = this.b;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(objE);
            ds0Var2.e = dVar;
            ds0Var2.n = 1;
            objC = rn4.c(f0Var.b, ds0Var2);
            if (objC != t70Var) {
                dVar2 = dVar;
            }
            return t70Var;
        }
        if (i2 == 1) {
            d dVar5 = ds0Var2.e;
            bz3.g(objE);
            objC = objE;
            dVar2 = dVar5;
        } else {
            if (i2 == 2) {
                dVar3 = ds0Var2.e;
                bz3.g(objE);
                jLongValue = ((Number) objE).longValue();
                ds0Var2.e = dVar3;
                ds0Var2.i = jLongValue;
                ds0Var2.n = 3;
                objE = this.a.e("gemini_api_key", ds0Var2);
                if (objE != t70Var) {
                    j = jLongValue;
                    str = (String) objE;
                    if (str != null) {
                        ds0Var2.e = dVar3;
                        ds0Var2.f = str;
                        ds0Var2.i = j;
                        ds0Var2.n = 4;
                        objH = f0Var.h("gemini", ds0Var2);
                        if (objH != t70Var) {
                            str2 = str;
                            objE = objH;
                            j2 = j;
                            dVar4 = dVar3;
                        }
                    }
                    return null;
                }
                return t70Var;
            }
            if (i2 == 3) {
                j = ds0Var2.i;
                dVar3 = ds0Var2.e;
                bz3.g(objE);
                str = (String) objE;
                if (str != null) {
                    ds0Var2.e = dVar3;
                    ds0Var2.f = str;
                    ds0Var2.i = j;
                    ds0Var2.n = 4;
                    objH = f0Var.h("gemini", ds0Var2);
                    if (objH != t70Var) {
                        str2 = str;
                        objE = objH;
                        j2 = j;
                        dVar4 = dVar3;
                    }
                    return t70Var;
                }
                return null;
            }
            if (i2 != 4) {
                if (i2 == 5) {
                    bz3.g(objE);
                    return objE;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            long j3 = ds0Var2.i;
            String str4 = ds0Var2.f;
            d dVar6 = ds0Var2.e;
            bz3.g(objE);
            dVar4 = dVar6;
            str2 = str4;
            j2 = j3;
        }
        str3 = (String) objE;
        if (str3 != null) {
            es0 es0Var = new es0(this, str3, j2, str2, dVar4, null);
            ds0Var2.e = null;
            ds0Var2.f = null;
            ds0Var2.i = j2;
            ds0Var2.n = 5;
            objC2 = xc4.c(20000L, es0Var, ds0Var2);
            if (objC2 != t70Var) {
                return t70Var;
            }
            return objC2;
        }
        return null;
        if (((o) objC).a) {
            ds0Var2.e = dVar2;
            ds0Var2.n = 2;
            Object objI = f0Var.i(ds0Var2);
            if (objI != t70Var) {
                dVar3 = dVar2;
                objE = objI;
                jLongValue = ((Number) objE).longValue();
                ds0Var2.e = dVar3;
                ds0Var2.i = jLongValue;
                ds0Var2.n = 3;
                objE = this.a.e("gemini_api_key", ds0Var2);
                if (objE != t70Var) {
                    j = jLongValue;
                    str = (String) objE;
                    if (str != null) {
                        ds0Var2.e = dVar3;
                        ds0Var2.f = str;
                        ds0Var2.i = j;
                        ds0Var2.n = 4;
                        objH = f0Var.h("gemini", ds0Var2);
                        if (objH != t70Var) {
                            str2 = str;
                            objE = objH;
                            j2 = j;
                            dVar4 = dVar3;
                            str3 = (String) objE;
                            if (str3 != null) {
                                es0 es0Var2 = new es0(this, str3, j2, str2, dVar4, null);
                                ds0Var2.e = null;
                                ds0Var2.f = null;
                                ds0Var2.i = j2;
                                ds0Var2.n = 5;
                                objC2 = xc4.c(20000L, es0Var2, ds0Var2);
                                if (objC2 != t70Var) {
                                    return objC2;
                                }
                            }
                        }
                    }
                }
            }
            return t70Var;
        }
        return null;
    }

    @Override // defpackage.c
    public final boolean b() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:41:0x00be  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:56:0x0118  */
    /* JADX WARN: Code duplicated, block: B:59:0x0123 A[Catch: all -> 0x0116, TryCatch #0 {all -> 0x0116, blocks: (B:49:0x00df, B:51:0x00f8, B:53:0x0102, B:57:0x0119, B:59:0x0123, B:61:0x0133), top: B:74:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0132  */
    /* JADX WARN: Code duplicated, block: B:65:0x0145  */
    /* JADX WARN: Code duplicated, block: B:70:0x0162  */
    /* JADX WARN: Code duplicated, block: B:73:0x017c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    @Override // defpackage.c
    public final Object c(d dVar, x50 x50Var) throws Throwable {
        zr0 zr0Var;
        d dVar2;
        d dVar3;
        long jLongValue;
        long j;
        String str;
        Object objD;
        u22 u22Var;
        long jLongValue2;
        long jLongValue3;
        hg hgVar;
        long jLongValue4;
        long j2;
        if (x50Var instanceof zr0) {
            zr0Var = (zr0) x50Var;
            int i = zr0Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                zr0Var.k = i - Integer.MIN_VALUE;
            } else {
                zr0Var = new zr0(this, (y50) x50Var);
            }
        } else {
            zr0Var = new zr0(this, (y50) x50Var);
        }
        zr0 zr0Var2 = zr0Var;
        Object objC = zr0Var2.i;
        t70 t70Var = t70.a;
        int i2 = zr0Var2.k;
        if (i2 == 0) {
            bz3.g(objC);
            f0 f0Var = this.b;
            dVar2 = dVar;
            zr0Var2.e = dVar2;
            zr0Var2.k = 1;
            objC = rn4.c(f0Var.b, zr0Var2);
            if (objC != t70Var) {
            }
            return t70Var;
        }
        if (i2 == 1) {
            dVar2 = zr0Var2.e;
            bz3.g(objC);
        } else {
            if (i2 == 2) {
                dVar2 = zr0Var2.e;
                bz3.g(objC);
                dVar3 = dVar2;
                jLongValue = ((Number) objC).longValue();
                h61 h61Var = this.a;
                zr0Var2.e = dVar3;
                zr0Var2.f = jLongValue;
                zr0Var2.k = 3;
                objC = h61Var.e("gemini_api_key", zr0Var2);
                if (objC != t70Var) {
                    j = jLongValue;
                }
                return t70Var;
            }
            if (i2 != 3) {
                if (i2 == 4) {
                    bz3.g(objC);
                    return objC;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = zr0Var2.f;
            dVar3 = zr0Var2.e;
            bz3.g(objC);
        }
        str = (String) objC;
        if (str == null) {
            return new g("Save your Gemini API key in Setup.", new d52("cloud_ai", "Set up Gemini", "Enable cloud AI and save a Google AI Studio API key."));
        }
        if (!this.c.a()) {
            return new g("You're offline. Device commands still work.", null);
        }
        if (this.f.b()) {
            xa0 xa0Var = ld0.a;
            qa0 qa0Var = qa0.c;
            as0 as0Var = new as0(this, j, str, dVar3, null);
            zr0Var2.e = null;
            zr0Var2.f = j;
            zr0Var2.k = 4;
            objD = uf4.d(qa0Var, as0Var, zr0Var2);
            if (objD != t70Var) {
                return t70Var;
            }
            return objD;
        }
        u22Var = this.f;
        synchronized (((hg) u22Var.f)) {
            try {
                jLongValue2 = ((Number) ((fq0) u22Var.e).a()).longValue();
                u22Var.a(jLongValue2);
                if (u22Var.c > 0 || ((hg) u22Var.f).isEmpty()) {
                    jLongValue3 = 0;
                } else {
                    jLongValue3 = u22Var.c - (jLongValue2 - ((Number) ((hg) u22Var.f).last()).longValue());
                }
                hgVar = (hg) u22Var.f;
                if (hgVar.c >= u22Var.a) {
                    jLongValue4 = u22Var.b - (jLongValue2 - ((Number) hgVar.first()).longValue());
                } else {
                    jLongValue4 = 0;
                }
                long jMax = Math.max(0L, Math.max(jLongValue3, jLongValue4));
            } catch (Throwable th) {
                throw th;
            }
        }
        j2 = jMax / 1000;
        if (j2 < 1) {
            j2 = 1;
        }
        return new e("Give me " + j2 + " seconds before asking again.", "Local rate limit reached", true, false);
        if (!((o) objC).a) {
            return new g("Cloud AI is off.", new d52("cloud_ai", "Set up Gemini", "Enable cloud AI and save a Google AI Studio API key."));
        }
        f0 f0Var2 = this.b;
        zr0Var2.e = dVar2;
        zr0Var2.k = 2;
        objC = f0Var2.i(zr0Var2);
        if (objC != t70Var) {
            dVar3 = dVar2;
            jLongValue = ((Number) objC).longValue();
            h61 h61Var2 = this.a;
            zr0Var2.e = dVar3;
            zr0Var2.f = jLongValue;
            zr0Var2.k = 3;
            objC = h61Var2.e("gemini_api_key", zr0Var2);
            if (objC != t70Var) {
                j = jLongValue;
                str = (String) objC;
                if (str == null) {
                    return new g("Save your Gemini API key in Setup.", new d52("cloud_ai", "Set up Gemini", "Enable cloud AI and save a Google AI Studio API key."));
                }
                if (!this.c.a()) {
                    return new g("You're offline. Device commands still work.", null);
                }
                if (this.f.b()) {
                    u22Var = this.f;
                    synchronized (((hg) u22Var.f)) {
                        jLongValue2 = ((Number) ((fq0) u22Var.e).a()).longValue();
                        u22Var.a(jLongValue2);
                        if (u22Var.c > 0) {
                            jLongValue3 = 0;
                        } else {
                            jLongValue3 = 0;
                        }
                        hgVar = (hg) u22Var.f;
                        if (hgVar.c >= u22Var.a) {
                            jLongValue4 = u22Var.b - (jLongValue2 - ((Number) hgVar.first()).longValue());
                        } else {
                            jLongValue4 = 0;
                        }
                        long jMax2 = Math.max(0L, Math.max(jLongValue3, jLongValue4));
                        j2 = jMax2 / 1000;
                        if (j2 < 1) {
                            j2 = 1;
                        }
                        return new e("Give me " + j2 + " seconds before asking again.", "Local rate limit reached", true, false);
                    }
                }
                xa0 xa0Var2 = ld0.a;
                qa0 qa0Var2 = qa0.c;
                as0 as0Var2 = new as0(this, j, str, dVar3, null);
                zr0Var2.e = null;
                zr0Var2.f = j;
                zr0Var2.k = 4;
                objD = uf4.d(qa0Var2, as0Var2, zr0Var2);
                if (objD != t70Var) {
                    return objD;
                }
            }
        }
        return t70Var;
    }

    @Override // defpackage.c
    public final /* bridge */ /* synthetic */ String d() {
        return "gemini_api_key";
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        if (r10 == r8) goto L25;
     */
    @Override // defpackage.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(defpackage.x50 r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof defpackage.js0
            if (r0 == 0) goto L13
            r0 = r10
            js0 r0 = (defpackage.js0) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L1a
        L13:
            js0 r0 = new js0
            y50 r10 = (defpackage.y50) r10
            r0.<init>(r9, r10)
        L1a:
            java.lang.Object r10 = r0.e
            int r1 = r0.i
            r2 = 0
            java.lang.String r3 = "Enable cloud AI and save a Google AI Studio API key."
            java.lang.String r4 = "Set up Gemini"
            java.lang.String r5 = "cloud_ai"
            r6 = 2
            r7 = 1
            t70 r8 = defpackage.t70.a
            if (r1 == 0) goto L3d
            if (r1 == r7) goto L39
            if (r1 != r6) goto L33
            defpackage.bz3.g(r10)
            goto L6d
        L33:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r9)
            return r2
        L39:
            defpackage.bz3.g(r10)
            goto L4d
        L3d:
            defpackage.bz3.g(r10)
            r0.i = r7
            f0 r10 = r9.b
            x r10 = r10.b
            java.lang.Object r10 = defpackage.rn4.c(r10, r0)
            if (r10 != r8) goto L4d
            goto L6c
        L4d:
            o r10 = (defpackage.o) r10
            boolean r10 = r10.a
            if (r10 != 0) goto L60
            c32 r9 = new c32
            d52 r10 = new d52
            r10.<init>(r5, r4, r3)
            java.lang.String r0 = "Cloud AI is switched off"
            r9.<init>(r0, r10)
            return r9
        L60:
            r0.i = r6
            h61 r10 = r9.a
            java.lang.String r1 = "gemini_api_key"
            java.lang.Object r10 = r10.f(r1, r0)
            if (r10 != r8) goto L6d
        L6c:
            return r8
        L6d:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L82
            c32 r9 = new c32
            d52 r10 = new d52
            r10.<init>(r5, r4, r3)
            java.lang.String r0 = "No Gemini API key saved"
            r9.<init>(r0, r10)
            return r9
        L82:
            f40 r9 = r9.c
            boolean r9 = r9.a()
            if (r9 != 0) goto L92
            c32 r9 = new c32
            java.lang.String r10 = "You're offline"
            r9.<init>(r10, r2)
            return r9
        L92:
            a32 r9 = defpackage.a32.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ms0.e(x50):java.lang.Object");
    }

    @Override // defpackage.c
    public final String getId() {
        return "gemini";
    }

    public final Object j(lj1 lj1Var, y50 y50Var) {
        yv yvVar = new yv(1, fp4.b(y50Var));
        yvVar.x();
        rp1 rp1Var = this.e;
        rp1Var.getClass();
        m32 m32Var = new m32(rp1Var, lj1Var, false);
        yvVar.z(new bs0(m32Var, 0));
        m32Var.e(new cs0(yvVar, 0));
        return yvVar.v();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object l(y50 y50Var) {
        fs0 fs0Var;
        if (y50Var instanceof fs0) {
            fs0Var = (fs0) y50Var;
            int i = fs0Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                fs0Var.i = i - Integer.MIN_VALUE;
            } else {
                fs0Var = new fs0(this, y50Var);
            }
        } else {
            fs0Var = new fs0(this, y50Var);
        }
        Object obj = fs0Var.e;
        int i2 = fs0Var.i;
        if (i2 != 0) {
            if (i2 == 1) {
                bz3.g(obj);
                return ((i72) obj).a;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        bz3.g(obj);
        fs0Var.i = 1;
        Object objN = n("bidiGenerateContent", fs0Var);
        Object obj2 = t70.a;
        return objN == obj2 ? obj2 : objN;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object m(y50 y50Var) throws Throwable {
        gs0 gs0Var;
        if (y50Var instanceof gs0) {
            gs0Var = (gs0) y50Var;
            int i = gs0Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                gs0Var.i = i - Integer.MIN_VALUE;
            } else {
                gs0Var = new gs0(this, y50Var);
            }
        } else {
            gs0Var = new gs0(this, y50Var);
        }
        Object obj = gs0Var.e;
        int i2 = gs0Var.i;
        if (i2 != 0) {
            if (i2 == 1) {
                bz3.g(obj);
                return ((i72) obj).a;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        bz3.g(obj);
        gs0Var.i = 1;
        Object objN = n("generateContent", gs0Var);
        Object obj2 = t70.a;
        return objN == obj2 ? obj2 : objN;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object n(String str, y50 y50Var) throws Throwable {
        hs0 hs0Var;
        if (y50Var instanceof hs0) {
            hs0Var = (hs0) y50Var;
            int i = hs0Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                hs0Var.i = i - Integer.MIN_VALUE;
            } else {
                hs0Var = new hs0(this, y50Var);
            }
        } else {
            hs0Var = new hs0(this, y50Var);
        }
        Object objD = hs0Var.e;
        int i2 = hs0Var.i;
        x50 x50Var = null;
        int i3 = 1;
        if (i2 == 0) {
            bz3.g(objD);
            xa0 xa0Var = ld0.a;
            qa0 qa0Var = qa0.c;
            cd cdVar = new cd(this, str, x50Var, i3);
            hs0Var.i = 1;
            objD = uf4.d(qa0Var, cdVar, hs0Var);
            t70 t70Var = t70.a;
            if (objD == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(objD);
        }
        return ((i72) objD).a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
    
        if (r6 == r5) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(defpackage.y50 r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof defpackage.ls0
            if (r0 == 0) goto L13
            r0 = r7
            ls0 r0 = (defpackage.ls0) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            ls0 r0 = new ls0
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.e
            int r1 = r0.i
            r2 = 1
            r3 = 2
            r4 = 0
            t70 r5 = defpackage.t70.a
            if (r1 == 0) goto L39
            if (r1 == r2) goto L35
            if (r1 != r3) goto L2f
            defpackage.bz3.g(r7)
            i72 r7 = (defpackage.i72) r7
            java.lang.Object r6 = r7.a
            goto L7a
        L2f:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r6)
            return r4
        L35:
            defpackage.bz3.g(r7)
            goto L49
        L39:
            defpackage.bz3.g(r7)
            r0.i = r2
            h61 r7 = r6.a
            java.lang.String r1 = "gemini_api_key"
            java.lang.Object r7 = r7.f(r1, r0)
            if (r7 != r5) goto L49
            goto L79
        L49:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L59
            g r6 = new g
            java.lang.String r7 = "No Gemini API key saved."
            r6.<init>(r7, r4)
            return r6
        L59:
            f40 r7 = r6.c
            boolean r7 = r7.a()
            if (r7 != 0) goto L69
            g r6 = new g
            java.lang.String r7 = "You're offline."
            r6.<init>(r7, r4)
            return r6
        L69:
            c22 r6 = r6.d
            java.lang.Object r6 = r6.get()
            tt0 r6 = (defpackage.tt0) r6
            r0.i = r3
            java.lang.Object r6 = r6.f(r0)
            if (r6 != r5) goto L7a
        L79:
            return r5
        L7a:
            boolean r7 = r6 instanceof defpackage.h72
            if (r7 != 0) goto L88
            f r6 = new f
            java.lang.String r7 = "ready"
            java.lang.String r0 = "gemini"
            r6.<init>(r7, r0)
            return r6
        L88:
            java.lang.Throwable r6 = defpackage.i72.a(r6)
            r6.getClass()
            e r6 = k(r4, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ms0.p(y50):java.lang.Object");
    }
}
