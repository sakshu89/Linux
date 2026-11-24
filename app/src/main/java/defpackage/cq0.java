package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cq0 {
    public final ArrayList a;

    public cq0() {
        this.a = new ArrayList();
        new HashMap();
        new HashMap();
    }

    public static void f(cq0 cq0Var) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = cq0Var.a;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList.add(((h22) obj).getClass().getSimpleName());
        }
        String.join(" | ", arrayList);
    }

    public void a(Object obj) {
        if (obj != null) {
            this.a.add(obj);
        } else {
            dk0.n("Set contributions cannot be null");
        }
    }

    public Set b() {
        ArrayList arrayList = this.a;
        if (arrayList.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        return arrayList.size() == 1 ? Collections.singleton(arrayList.get(0)) : Collections.unmodifiableSet(new HashSet(arrayList));
    }

    public boolean c(Class cls) {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (cls.isAssignableFrom(((h22) obj).getClass())) {
                return true;
            }
        }
        return false;
    }

    public h22 d(Class cls) {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            h22 h22Var = (h22) obj;
            if (h22Var.getClass() == cls) {
                return h22Var;
            }
        }
        return null;
    }

    public List e() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    public cq0(List list) {
        this.a = new ArrayList(list);
    }

    public cq0(int i) {
        this.a = new ArrayList(i);
    }
}
