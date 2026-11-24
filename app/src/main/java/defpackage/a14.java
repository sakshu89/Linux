package defpackage;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a14 implements Map, Serializable {
    public final /* synthetic */ int a;
    public final transient Object[] b;
    public transient AbstractCollection c;
    public transient AbstractCollection e;
    public transient AbstractCollection f;

    public /* synthetic */ a14(int i, Object[] objArr) {
        this.a = i;
        this.b = objArr;
    }

    @Override // java.util.Map
    public final void clear() {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        switch (this.a) {
            case 0:
                return get(obj) != null;
            default:
                return get(obj) != null;
        }
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        switch (this.a) {
            case 0:
                y04 y04Var = (y04) this.f;
                if (y04Var == null) {
                    y04Var = new y04(1, this.b);
                    this.f = y04Var;
                }
                return y04Var.contains(obj);
            default:
                ht4 ht4Var = (ht4) this.f;
                if (ht4Var == null) {
                    ht4Var = new ht4(1, this.b);
                    this.f = ht4Var;
                }
                return ht4Var.contains(obj);
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        switch (this.a) {
            case 0:
                u04 u04Var = (u04) this.c;
                if (u04Var != null) {
                    return u04Var;
                }
                u04 u04Var2 = new u04(this, this.b);
                this.c = u04Var2;
                return u04Var2;
            default:
                dt4 dt4Var = (dt4) this.c;
                if (dt4Var != null) {
                    return dt4Var;
                }
                dt4 dt4Var2 = new dt4(this, this.b);
                this.c = dt4Var2;
                return dt4Var2;
        }
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        switch (this.a) {
            case 0:
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Map) {
                    return entrySet().equals(((Map) obj).entrySet());
                }
                return false;
            default:
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Map) {
                    return entrySet().equals(((Map) obj).entrySet());
                }
                return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0025  */
    /* JADX WARN: Code duplicated, block: B:5:0x000c  */
    @Override // java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        Object obj3;
        int i = this.a;
        Object[] objArr = this.b;
        switch (i) {
            case 0:
                if (obj == null) {
                    obj2 = null;
                } else {
                    Object obj4 = objArr[0];
                    Objects.requireNonNull(obj4);
                    if (obj4.equals(obj)) {
                        obj2 = objArr[1];
                        Objects.requireNonNull(obj2);
                    } else {
                        obj2 = null;
                    }
                }
                if (obj2 == null) {
                    return null;
                }
                return obj2;
            default:
                if (obj == null) {
                    obj3 = null;
                } else {
                    Object obj5 = objArr[0];
                    obj5.getClass();
                    if (obj5.equals(obj)) {
                        obj3 = objArr[1];
                        obj3.getClass();
                    } else {
                        obj3 = null;
                    }
                }
                if (obj3 == null) {
                    return null;
                }
                return obj3;
        }
    }

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                Object obj3 = get(obj);
                return obj3 != null ? obj3 : obj2;
            default:
                Object obj4 = get(obj);
                return obj4 != null ? obj4 : obj2;
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        switch (this.a) {
            case 0:
                u04 u04Var = (u04) this.c;
                if (u04Var == null) {
                    u04Var = new u04(this, this.b);
                    this.c = u04Var;
                }
                Iterator it = u04Var.iterator();
                int iHashCode = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    iHashCode += next != null ? next.hashCode() : 0;
                }
                return iHashCode;
            default:
                dt4 dt4Var = (dt4) this.c;
                if (dt4Var == null) {
                    dt4Var = new dt4(this, this.b);
                    this.c = dt4Var;
                }
                Iterator it2 = dt4Var.iterator();
                int iHashCode2 = 0;
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    iHashCode2 += next2 != null ? next2.hashCode() : 0;
                }
                return iHashCode2;
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        switch (this.a) {
        }
        return false;
    }

    @Override // java.util.Map
    public final Set keySet() {
        switch (this.a) {
            case 0:
                w04 w04Var = (w04) this.e;
                if (w04Var != null) {
                    return w04Var;
                }
                w04 w04Var2 = new w04(this, new y04(0, this.b));
                this.e = w04Var2;
                return w04Var2;
            default:
                gt4 gt4Var = (gt4) this.e;
                if (gt4Var != null) {
                    return gt4Var;
                }
                gt4 gt4Var2 = new gt4(this, new ht4(0, this.b));
                this.e = gt4Var2;
                return gt4Var2;
        }
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final int size() {
        switch (this.a) {
        }
        return 1;
    }

    public final String toString() {
        boolean z = true;
        switch (this.a) {
            case 0:
                StringBuilder sb = new StringBuilder((int) Math.min(8L, 1073741824L));
                sb.append('{');
                for (Map.Entry entry : (u04) entrySet()) {
                    if (!z) {
                        sb.append(", ");
                    }
                    sb.append(entry.getKey());
                    sb.append('=');
                    sb.append(entry.getValue());
                    z = false;
                }
                sb.append('}');
                return sb.toString();
            default:
                StringBuilder sb2 = new StringBuilder((int) Math.min(8L, 1073741824L));
                sb2.append('{');
                for (Map.Entry entry2 : (dt4) entrySet()) {
                    if (!z) {
                        sb2.append(", ");
                    }
                    sb2.append(entry2.getKey());
                    sb2.append('=');
                    sb2.append(entry2.getValue());
                    z = false;
                }
                sb2.append('}');
                return sb2.toString();
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        switch (this.a) {
            case 0:
                y04 y04Var = (y04) this.f;
                if (y04Var != null) {
                    return y04Var;
                }
                y04 y04Var2 = new y04(1, this.b);
                this.f = y04Var2;
                return y04Var2;
            default:
                ht4 ht4Var = (ht4) this.f;
                if (ht4Var != null) {
                    return ht4Var;
                }
                ht4 ht4Var2 = new ht4(1, this.b);
                this.f = ht4Var2;
                return ht4Var2;
        }
    }
}
