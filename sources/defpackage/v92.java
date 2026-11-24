package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class v92 implements Iterable {
    public s92 a;
    public s92 b;
    public final WeakHashMap c = new WeakHashMap();
    public int e = 0;

    public s92 a(Object obj) {
        s92 s92Var = this.a;
        while (s92Var != null && !s92Var.a.equals(obj)) {
            s92Var = s92Var.c;
        }
        return s92Var;
    }

    public Object b(Object obj) {
        s92 s92VarA = a(obj);
        if (s92VarA == null) {
            return null;
        }
        this.e--;
        WeakHashMap weakHashMap = this.c;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((u92) it.next()).a(s92VarA);
            }
        }
        s92 s92Var = s92VarA.e;
        s92 s92Var2 = s92VarA.c;
        if (s92Var != null) {
            s92Var.c = s92Var2;
        } else {
            this.a = s92Var2;
        }
        s92 s92Var3 = s92VarA.c;
        if (s92Var3 != null) {
            s92Var3.e = s92Var;
        } else {
            this.b = s92Var;
        }
        s92VarA.c = null;
        s92VarA.e = null;
        return s92VarA.b;
    }

    public final boolean equals(Object obj) {
        r92 r92Var;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v92)) {
            return false;
        }
        v92 v92Var = (v92) obj;
        if (this.e != v92Var.e) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = v92Var.iterator();
        while (true) {
            r92Var = (r92) it;
            if (!r92Var.hasNext()) {
                break;
            }
            r92 r92Var2 = (r92) it2;
            if (!r92Var2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) r92Var.next();
            Object next = r92Var2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (r92Var.hasNext() || ((r92) it2).hasNext()) ? false : true;
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            r92 r92Var = (r92) it;
            if (!r92Var.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) r92Var.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        r92 r92Var = new r92(this.a, this.b, 0);
        this.c.put(r92Var, Boolean.FALSE);
        return r92Var;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            r92 r92Var = (r92) it;
            if (!r92Var.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) r92Var.next()).toString());
            if (r92Var.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
