package defpackage;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fw1 extends AbstractMap implements Map, z41 {
    public y74 a = new y74(15);
    public x23 b;
    public Object c;
    public int e;
    public int f;
    public gw1 i;

    public fw1(gw1 gw1Var) {
        this.b = gw1Var.a;
        this.f = gw1Var.b;
        this.i = gw1Var;
    }

    public final gw1 a() {
        x23 x23Var = this.b;
        gw1 gw1Var = this.i;
        if (x23Var != gw1Var.a) {
            this.a = new y74(15);
            gw1Var = new gw1(this.b, this.f);
        }
        this.i = gw1Var;
        return gw1Var;
    }

    public final boolean b(Object obj) {
        return this.b.d(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    public final Object c(Object obj) {
        return this.b.g(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.b = x23.e;
        e(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof z12) {
            return b((z12) obj);
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof h63) {
            return super.containsValue((h63) obj);
        }
        return false;
    }

    public final Object d(Object obj) {
        this.c = null;
        x23 x23VarN = this.b.n(obj != null ? obj.hashCode() : 0, obj, 0, this);
        if (x23VarN == null) {
            x23VarN = x23.e;
        }
        this.b = x23VarN;
        return this.c;
    }

    public final void e(int i) {
        this.f = i;
        this.e++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return new kw1(0, this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof z12) {
            return (h63) c((z12) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof z12) ? obj2 : (h63) super.getOrDefault((z12) obj, (h63) obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return new kw1(1, this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        this.c = null;
        this.b = this.b.l(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        return this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        hw1 hw1VarA = null;
        hw1 hw1Var = map instanceof hw1 ? (hw1) map : null;
        if (hw1Var == null) {
            fw1 fw1Var = map instanceof fw1 ? (fw1) map : null;
            if (fw1Var != null) {
                hw1VarA = fw1Var.a();
            }
        } else {
            hw1VarA = hw1Var;
        }
        if (hw1VarA == null) {
            super.putAll(map);
            return;
        }
        ic0 ic0Var = new ic0();
        ic0Var.a = 0;
        int i = this.f;
        x23 x23Var = this.b;
        x23 x23Var2 = hw1VarA.a;
        x23Var2.getClass();
        this.b = x23Var.m(x23Var2, 0, ic0Var, this);
        int i2 = (hw1VarA.b + i) - ic0Var.a;
        if (i != i2) {
            e(i2);
        }
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        int i = this.f;
        x23 x23VarO = this.b.o(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        if (x23VarO == null) {
            x23VarO = x23.e;
        }
        this.b = x23VarO;
        return i != this.f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        return new ug1(1, this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        if (obj instanceof z12) {
            return (h63) d((z12) obj);
        }
        return null;
    }
}
