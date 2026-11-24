package defpackage;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gx3 extends AbstractMap {
    public transient cx3 a;
    public transient sy3 b;
    public final transient Map c;
    public final /* synthetic */ by3 e;

    public gx3(by3 by3Var, Map map) {
        this.e = by3Var;
        this.c = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zy3 zy3Var = this.e.c;
        if (this.c == zy3Var) {
            Iterator it = zy3Var.values().iterator();
            while (it.hasNext()) {
                ((Collection) it.next()).clear();
            }
            zy3Var.clear();
            return;
        }
        dx3 dx3Var = new dx3(this);
        while (dx3Var.hasNext()) {
            dx3Var.next();
            dx3Var.remove();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map map = this.c;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        cx3 cx3Var = this.a;
        if (cx3Var != null) {
            return cx3Var;
        }
        cx3 cx3Var2 = new cx3(this);
        this.a = cx3Var2;
        return cx3Var2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.c.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        Map map = this.c;
        map.getClass();
        try {
            obj2 = map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection == null) {
            return null;
        }
        by3 by3Var = this.e;
        by3Var.getClass();
        List list = (List) collection;
        return list instanceof RandomAccess ? new nx3(by3Var, obj, list, null) : new ux3(by3Var, obj, list, null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.c.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        by3 by3Var = this.e;
        cx3 cx3Var = by3Var.a;
        if (cx3Var != null) {
            return cx3Var;
        }
        cx3 cx3Var2 = new cx3(by3Var, by3Var.c);
        by3Var.a = cx3Var2;
        return cx3Var2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.c.remove(obj);
        if (collection == null) {
            return null;
        }
        this.e.getClass();
        ArrayList arrayList = new ArrayList(3);
        arrayList.addAll(collection);
        collection.size();
        collection.clear();
        return arrayList;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.c.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.c.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        sy3 sy3Var = this.b;
        if (sy3Var != null) {
            return sy3Var;
        }
        sy3 sy3Var2 = new sy3(this);
        this.b = sy3Var2;
        return sy3Var2;
    }
}
