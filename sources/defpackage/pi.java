package defpackage;

import android.util.Log;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pi {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;

    public void a(pj pjVar, int i) {
        Iterable iterable;
        sh shVar;
        String str;
        gu guVarV;
        String str2;
        Integer numValueOf;
        pi piVar;
        p23 p23VarA = ((dj1) this.b).a(pjVar.a);
        l92 l92Var = (l92) this.f;
        Iterable iterable2 = (Iterable) l92Var.o(new cu2(6, this, pjVar));
        if (iterable2.iterator().hasNext()) {
            if (p23VarA == null) {
                yq4.a("Uploader");
                new StringBuilder("Unknown backend for ").append(pjVar);
                shVar = new sh(3, -1L);
                iterable = iterable2;
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((xi) it.next()).c);
                }
                byte[] bArr = pjVar.b;
                vw vwVar = (vw) p23VarA;
                HashMap map = new HashMap();
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    hi hiVar = (hi) obj;
                    String str3 = hiVar.a;
                    if (map.containsKey(str3)) {
                        ((List) map.get(str3)).add(hiVar);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(hiVar);
                        map.put(str3, arrayList2);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    hi hiVar2 = (hi) ((List) entry.getValue()).get(i2);
                    g22 g22Var = g22.a;
                    long jH = vwVar.f.h();
                    long jH2 = vwVar.e.h();
                    ai aiVar = new ai(new qh(Integer.valueOf(hiVar2.b("sdk-version")), hiVar2.a("model"), hiVar2.a("hardware"), hiVar2.a("device"), hiVar2.a("product"), hiVar2.a("os-uild"), hiVar2.a("manufacturer"), hiVar2.a("fingerprint"), hiVar2.a("locale"), hiVar2.a("country"), hiVar2.a("mcc_mnc"), hiVar2.a("application_build")));
                    try {
                        numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                        str2 = null;
                    } catch (NumberFormatException unused) {
                        str2 = (String) entry.getKey();
                        numValueOf = null;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (hi hiVar3 : (List) entry.getValue()) {
                        ni0 ni0Var = hiVar3.c;
                        qi0 qi0Var = ni0Var.a;
                        byte[] bArr2 = ni0Var.b;
                        Iterable iterable3 = iterable2;
                        if (qi0Var.equals(new qi0("proto"))) {
                            piVar = new pi();
                            piVar.e = bArr2;
                        } else {
                            if (qi0Var.equals(new qi0("json"))) {
                                String str4 = new String(bArr2, Charset.forName("UTF-8"));
                                pi piVar2 = new pi();
                                piVar2.f = str4;
                                piVar = piVar2;
                            } else {
                                Log.w("TransportRuntime.".concat("CctTransportBackend"), "Received event of unsupported encoding " + qi0Var + ". Skipping...");
                            }
                            iterable2 = iterable3;
                        }
                        piVar.a = Long.valueOf(hiVar3.d);
                        piVar.b = Long.valueOf(hiVar3.e);
                        String str5 = (String) hiVar3.f.get("tz-offset");
                        piVar.c = Long.valueOf(str5 == null ? 0L : Long.valueOf(str5).longValue());
                        piVar.g = new ti((ln1) ln1.a.get(hiVar3.b("net-type")), (kn1) kn1.a.get(hiVar3.b("mobile-subtype")));
                        Integer num = hiVar3.b;
                        if (num != null) {
                            piVar.d = num;
                        }
                        String strConcat = ((Long) piVar.a) == null ? " eventTimeMs" : "";
                        if (((Long) piVar.b) == null) {
                            strConcat = strConcat.concat(" eventUptimeMs");
                        }
                        if (((Long) piVar.c) == null) {
                            strConcat = strConcat.concat(" timezoneOffsetSeconds");
                        }
                        if (!strConcat.isEmpty()) {
                            og.n("Missing required properties:".concat(strConcat));
                            return;
                        } else {
                            arrayList4.add(new qi(((Long) piVar.a).longValue(), (Integer) piVar.d, ((Long) piVar.b).longValue(), (byte[]) piVar.e, (String) piVar.f, ((Long) piVar.c).longValue(), (ti) piVar.g));
                            iterable2 = iterable3;
                        }
                    }
                    arrayList3.add(new ri(jH, jH2, aiVar, numValueOf, str2, arrayList4));
                    i2 = 0;
                }
                iterable = iterable2;
                th thVar = new th(arrayList3);
                URL urlB = vwVar.d;
                if (bArr != null) {
                    try {
                        po poVarA = po.a(bArr);
                        str = poVarA.b;
                        if (str == null) {
                            str = null;
                        }
                        urlB = vw.b(poVarA.a);
                    } catch (IllegalArgumentException unused2) {
                        shVar = new sh(3, -1L);
                    }
                } else {
                    str = null;
                }
                try {
                    kf kfVar = new kf(urlB, thVar, str, 6);
                    q82 q82Var = new q82(vwVar);
                    int i4 = 5;
                    do {
                        guVarV = q82Var.v(kfVar);
                        URL url = (URL) guVarV.c;
                        if (url != null) {
                            yq4.a("CctTransportBackend");
                            StringBuilder sb = new StringBuilder();
                            sb.append("Following redirect to: ");
                            sb.append(url);
                            kfVar = new kf(url, (th) kfVar.c, (String) kfVar.e, 6);
                        } else {
                            kfVar = null;
                        }
                        if (kfVar == null) {
                            break;
                        } else {
                            i4--;
                        }
                    } while (i4 >= 1);
                    int i5 = guVarV.a;
                    if (i5 == 200) {
                        shVar = new sh(1, guVarV.b);
                    } else if (i5 >= 500 || i5 == 404) {
                        shVar = new sh(2, -1L);
                    } else {
                        try {
                            shVar = new sh(3, -1L);
                        } catch (IOException e) {
                            e = e;
                            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Could not make request to the backend", e);
                            shVar = new sh(2, -1L);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            }
            l92Var.o(new lq(this, shVar, iterable, pjVar, i));
        }
    }
}
