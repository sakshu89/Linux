package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sg1 {
    public final LinkedHashMap a;

    public sg1(int i) {
        this.a = new LinkedHashMap(i < 3 ? i + 1 : i < 1073741824 ? (int) ((i / 0.75f) + 1.0f) : Integer.MAX_VALUE);
    }

    public jh2 a() {
        jh2 jh2Var = new jh2();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.a.entrySet()) {
            p53 p53Var = (p53) entry.getValue();
            if (p53Var.e) {
                jh2Var.a(p53Var.a);
                arrayList.add((String) entry.getKey());
            }
        }
        arrayList.toString();
        xq4.c(3, "UseCaseAttachState");
        return jh2Var;
    }

    public Collection b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.a.entrySet()) {
            if (((p53) entry.getValue()).e) {
                arrayList.add(((p53) entry.getValue()).a);
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public Collection c() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.a.entrySet()) {
            if (((p53) entry.getValue()).e) {
                arrayList.add(((p53) entry.getValue()).b);
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public boolean d(String str) {
        LinkedHashMap linkedHashMap = this.a;
        if (linkedHashMap.containsKey(str)) {
            return ((p53) linkedHashMap.get(str)).e;
        }
        return false;
    }

    public void e(Object obj, String str) {
        this.a.put(str, obj);
    }

    public void f(String str, kh2 kh2Var, r53 r53Var, fj fjVar, List list) {
        LinkedHashMap linkedHashMap = this.a;
        if (linkedHashMap.containsKey(str)) {
            p53 p53Var = new p53(kh2Var, r53Var, fjVar, list);
            p53 p53Var2 = (p53) linkedHashMap.get(str);
            p53Var.e = p53Var2.e;
            p53Var.f = p53Var2.f;
            linkedHashMap.put(str, p53Var);
        }
    }

    public sg1(String str) {
        this.a = new LinkedHashMap();
    }
}
