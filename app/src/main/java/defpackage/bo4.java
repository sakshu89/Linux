package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class bo4 {
    public static List a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray;
        str.getClass();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("models");
        if (jSONArrayOptJSONArray2 == null) {
            return ii0.a;
        }
        h21 h21VarF = ky3.f(0, jSONArrayOptJSONArray2.length());
        ArrayList arrayList = new ArrayList();
        Iterator it = h21VarF.iterator();
        while (true) {
            g21 g21Var = (g21) it;
            if (!g21Var.c) {
                return mz.t(arrayList);
            }
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(g21Var.nextInt());
            String str2 = null;
            if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("supportedGenerationMethods")) != null) {
                Iterable iterableF = ky3.f(0, jSONArrayOptJSONArray.length());
                if (!(iterableF instanceof Collection) || !((Collection) iterableF).isEmpty()) {
                    Iterator it2 = iterableF.iterator();
                    while (true) {
                        g21 g21Var2 = (g21) it2;
                        if (!g21Var2.c) {
                            break;
                        }
                        if (g31.a(jSONArrayOptJSONArray.optString(g21Var2.nextInt()), str)) {
                            String strOptString = jSONObjectOptJSONObject.optString("name");
                            strOptString.getClass();
                            String strG = cs2.G(strOptString, "models/");
                            if (!cs2.A(strG)) {
                                str2 = strG;
                                break;
                            }
                            break;
                        }
                    }
                }
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
        }
    }
}
