package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class oj4 {
    public static boolean a(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        List listI = nz.i("no credit", "insufficient credit", "billing required", "billing is required", "billing disabled", "billing is disabled", "billing not enabled", "billing is not enabled", "billing_not_enabled", "billing_disabled", "billing account");
        if (!listI.isEmpty()) {
            Iterator it = listI.iterator();
            while (it.hasNext()) {
                if (cs2.n(lowerCase, (String) it.next(), false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static w30 b(Throwable th) {
        w30 w30Var;
        String name;
        w30 w30Var2 = w30.t;
        if (th == null) {
            return w30Var2;
        }
        List listH = zg2.h(new au0(2, zg2.c(th, new j(16)), new x0(8, new LinkedHashSet())));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listH) {
            if (obj instanceof e22) {
                arrayList.add(obj);
            }
        }
        e22 e22Var = (e22) mz.y(arrayList);
        w30 w30Var3 = w30.e;
        w30 w30Var4 = w30.i;
        w30 w30Var5 = w30.n;
        w30 w30Var6 = w30.s;
        w30 w30Var7 = w30.k;
        w30 w30Var8 = w30.j;
        w30 w30Var9 = w30.f;
        if (e22Var != null) {
            int i = e22Var.a;
            String message = e22Var.getMessage();
            if (message == null) {
                message = "";
            }
            String lowerCase = message.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            if (i == 401 || (wh2.c(400, 403).contains(Integer.valueOf(i)) && c(lowerCase))) {
                return w30Var3;
            }
            if (i == 403) {
                return w30Var9;
            }
            if (i == 402 || (i == 429 && a(lowerCase))) {
                return w30Var4;
            }
            if (i == 404 || i == 410) {
                return w30Var5;
            }
            if (i == 429) {
                Pattern patternCompile = Pattern.compile("limit\\s*:\\s*0(?:\\D|$)");
                patternCompile.getClass();
                if (patternCompile.matcher(lowerCase).find()) {
                    return w30Var8;
                }
            }
            if (i == 429) {
                return w30Var7;
            }
            return (500 > i || i >= 600) ? w30Var2 : w30Var6;
        }
        Iterator it = listH.iterator();
        do {
            boolean zHasNext = it.hasNext();
            w30 w30Var10 = w30.a;
            w30 w30Var11 = w30.b;
            w30Var = w30.c;
            if (!zHasNext) {
                String lowerCase2 = mz.C(listH, " | ", null, null, new j(17), 30).toLowerCase(Locale.ROOT);
                lowerCase2.getClass();
                List listI = nz.i("trust anchor", "certpath", "certificate", "ssl", "handshake");
                if (!listI.isEmpty()) {
                    Iterator it2 = listI.iterator();
                    while (it2.hasNext()) {
                        if (cs2.n(lowerCase2, (String) it2.next(), false)) {
                            return w30Var10;
                        }
                    }
                }
                List listI2 = nz.i("unable to resolve host", "unknownhost", "no address associated", "connection refused");
                if (!listI2.isEmpty()) {
                    Iterator it3 = listI2.iterator();
                    while (it3.hasNext()) {
                        if (cs2.n(lowerCase2, (String) it3.next(), false)) {
                            return w30Var11;
                        }
                    }
                }
                List listI3 = nz.i("timeout", "timed out", "respond in time", "didn't respond");
                if (!listI3.isEmpty()) {
                    Iterator it4 = listI3.iterator();
                    while (it4.hasNext()) {
                        if (cs2.n(lowerCase2, (String) it4.next(), false)) {
                            return w30Var;
                        }
                    }
                }
                if (c(lowerCase2) || cs2.n(lowerCase2, "http 401", false) || cs2.n(lowerCase2, "was rejected", false) || cs2.n(lowerCase2, "unauthorized", false)) {
                    return w30Var3;
                }
                if (cs2.n(lowerCase2, "http 403", false) || cs2.n(lowerCase2, "permission denied", false) || cs2.n(lowerCase2, "permission_denied", false)) {
                    return w30Var9;
                }
                if (cs2.n(lowerCase2, "http 402", false) || a(lowerCase2) || cs2.n(lowerCase2, "balance", false) || (cs2.n(lowerCase2, "insufficient", false) && (cs2.n(lowerCase2, "quota", false) || cs2.n(lowerCase2, "credit", false)))) {
                    return w30Var4;
                }
                Pattern patternCompile2 = Pattern.compile("limit\\s*:\\s*0(?:\\D|$)");
                patternCompile2.getClass();
                if (patternCompile2.matcher(lowerCase2).find() || (cs2.n(lowerCase2, "quota", false) && cs2.n(lowerCase2, "exceeded", false))) {
                    return w30Var8;
                }
                if (cs2.n(lowerCase2, "http 429", false)) {
                    return w30Var7;
                }
                List listI4 = nz.i("no chat models", "no compatible", "no free-tier access", "no usable", "survived allowlist", "can't use any of the models");
                if (!listI4.isEmpty()) {
                    Iterator it5 = listI4.iterator();
                    while (it5.hasNext()) {
                        if (cs2.n(lowerCase2, (String) it5.next(), false)) {
                            return w30Var5;
                        }
                    }
                }
                return (cs2.n(lowerCase2, "http 5", false) || cs2.n(lowerCase2, "server error", false)) ? w30Var6 : w30Var2;
            }
            name = ((Throwable) it.next()).getClass().getName();
            if (cs2.n(name, "SSL", false) || cs2.n(name, "CertPath", false) || cs2.n(name, "Certificate", false) || cs2.n(name, "TrustManager", false)) {
                return w30Var10;
            }
            if (!cs2.n(name, "UnknownHost", false) && !cs2.n(name, "ConnectException", false) && !cs2.n(name, "NoRouteToHost", false)) {
                if (cs2.n(name, "SocketTimeout", false)) {
                    break;
                }
            } else {
                return w30Var11;
            }
        } while (!cs2.n(name, "InterruptedIOException", false));
        return w30Var;
    }

    public static boolean c(String str) {
        List listI = nz.i("api_key_invalid", "api key not valid", "invalid api key", "incorrect api key", "invalid key", "api_key_expired", "api key expired", "api_key_leaked", "reported as leaked");
        if (!listI.isEmpty()) {
            Iterator it = listI.iterator();
            while (it.hasNext()) {
                if (cs2.n(str, (String) it.next(), false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String d(w30 w30Var) {
        switch (w30Var.ordinal()) {
            case 0:
                return "SONIC could not verify Google Gemini's secure connection. The API key has not been tested. Update SONIC to the fixed build. If this persists, try another network and check the technical details.";
            case 1:
                return "SONIC can't reach Google Gemini. Check internet access or try another network.";
            case 2:
                return "Google Gemini".concat(" took too long to respond. Device commands still work. Please try this request again shortly.");
            case 3:
                return "Google Gemini".concat(" rejected this API key. Copy it again from Google AI Studio and save it.");
            case 4:
                return "Google Gemini".concat(" denied this request. Check the API key's restrictions, enabled API and regional availability in Google AI Studio.");
            case 5:
                return "Google reports a billing or credit problem. Check billing for this API key's project.";
            case 6:
                return "Google reports zero quota for the model tried. Check this project's model limits and billing in Google AI Studio.";
            case 7:
                return "Google has limited requests for this key. Check its quota and retry time in the technical details.";
            case 8:
                return "No compatible Gemini model answered. SONIC will recheck availability on your next request.";
            case 9:
                return "Google Gemini".concat(" is temporarily unavailable. Please try again shortly.");
            case 10:
                return "SONIC couldn't complete the Gemini request. See the technical details below.";
            default:
                dk0.l();
                return null;
        }
    }

    public static String e(w30 w30Var, String str) {
        String str2;
        switch (w30Var.ordinal()) {
            case 0:
                str2 = "TLS certificate verification failed";
                break;
            case 1:
                str2 = "Host unreachable";
                break;
            case 2:
                str2 = "Request timed out";
                break;
            case 3:
                str2 = "API key rejected";
                break;
            case 4:
                str2 = "API access denied";
                break;
            case 5:
                str2 = "Billing or credit problem";
                break;
            case 6:
                str2 = "Zero model quota";
                break;
            case 7:
                str2 = "Rate or quota limit";
                break;
            case 8:
                str2 = "No usable chat model";
                break;
            case 9:
                str2 = "Google service error";
                break;
            case 10:
                str2 = "Request failed";
                break;
            default:
                dk0.l();
                return null;
        }
        return cq.k(str2, ": ", str);
    }
}
