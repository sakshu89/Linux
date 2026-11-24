package defpackage;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s10 extends wb4 {
    public final ij0 d;
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final AtomicReference e = new AtomicReference();

    public s10(ArrayList arrayList, ArrayList arrayList2) {
        ij0 ij0Var = new ij0();
        new HashMap();
        ij0Var.a = new ArrayDeque();
        this.d = ij0Var;
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(d10.b(ij0Var, ij0.class, at2.class, f22.class));
        int i = 0;
        arrayList3.add(d10.b(this, s10.class, new Class[0]));
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            d10 d10Var = (d10) obj;
            if (d10Var != null) {
                arrayList3.add(d10Var);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList4.add(obj2);
        }
        ArrayList arrayList5 = new ArrayList();
        synchronized (this) {
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((d22) it.next()).get();
                    if (componentRegistrar != null) {
                        arrayList3.addAll(componentRegistrar.a());
                        it.remove();
                    }
                } catch (p31 e) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            if (this.a.isEmpty()) {
                wl4.a(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.a.keySet());
                arrayList6.addAll(arrayList3);
                wl4.a(arrayList6);
            }
            int size3 = arrayList3.size();
            int i4 = 0;
            while (i4 < size3) {
                Object obj3 = arrayList3.get(i4);
                i4++;
                final d10 d10Var2 = (d10) obj3;
                this.a.put(d10Var2, new g81(new d22(this, d10Var2) { // from class: q10
                    public final s10 a;
                    public final d10 b;

                    {
                        this.a = this;
                        this.b = d10Var2;
                    }

                    @Override // defpackage.d22
                    public final Object get() {
                        d10 d10Var3 = this.b;
                        return d10Var3.d.g(new e72(d10Var3, this.a));
                    }
                }));
            }
            arrayList5.addAll(h(arrayList3));
            arrayList5.addAll(i());
            g();
        }
        int size4 = arrayList5.size();
        while (i < size4) {
            Object obj4 = arrayList5.get(i);
            i++;
            ((Runnable) obj4).run();
        }
        Boolean bool = (Boolean) this.e.get();
        if (bool != null) {
            f(this.a, bool.booleanValue());
        }
    }

    @Override // defpackage.wb4
    public final synchronized d22 c(Class cls) {
        return (d22) this.b.get(cls);
    }

    @Override // defpackage.wb4
    public final synchronized d22 e(Class cls) {
        ia1 ia1Var = (ia1) this.c.get(cls);
        if (ia1Var != null) {
            return ia1Var;
        }
        return r10.b;
    }

    public final void f(HashMap map, boolean z) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : map.entrySet()) {
            d10 d10Var = (d10) entry.getKey();
            d10Var.getClass();
        }
        ij0 ij0Var = this.d;
        synchronized (ij0Var) {
            try {
                arrayDeque = ij0Var.a;
                if (arrayDeque != null) {
                    ij0Var.a = null;
                } else {
                    arrayDeque = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                dk0.t();
            }
        }
    }

    public final void g() {
        for (d10 d10Var : this.a.keySet()) {
            for (mc0 mc0Var : d10Var.b) {
                if (mc0Var.b == 2 && !this.c.containsKey(mc0Var.a)) {
                    HashMap map = this.c;
                    Class cls = mc0Var.a;
                    Set set = Collections.EMPTY_SET;
                    ia1 ia1Var = new ia1();
                    ia1Var.b = null;
                    ia1Var.a = Collections.newSetFromMap(new ConcurrentHashMap());
                    ia1Var.a.addAll(set);
                    map.put(cls, ia1Var);
                } else if (this.b.containsKey(mc0Var.a)) {
                    continue;
                } else {
                    int i = mc0Var.b;
                    if (i == 1) {
                        throw new nc0("Unsatisfied dependency for component " + d10Var + ": " + mc0Var.a);
                    }
                    if (i != 2) {
                        HashMap map2 = this.b;
                        Class cls2 = mc0Var.a;
                        fl4 fl4Var = fl4.j;
                        r10 r10Var = r10.c;
                        es1 es1Var = new es1();
                        es1Var.a = fl4Var;
                        es1Var.b = r10Var;
                        map2.put(cls2, es1Var);
                    }
                }
            }
        }
    }

    public final ArrayList h(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            d10 d10Var = (d10) obj;
            if (d10Var.c == 0) {
                d22 d22Var = (d22) this.a.get(d10Var);
                for (Class cls : d10Var.a) {
                    HashMap map = this.b;
                    if (map.containsKey(cls)) {
                        arrayList2.add(new or0(4, (es1) ((d22) map.get(cls)), d22Var));
                    } else {
                        map.put(cls, d22Var);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList i() {
        HashMap map = this.c;
        ArrayList arrayList = new ArrayList();
        HashMap map2 = new HashMap();
        for (Map.Entry entry : this.a.entrySet()) {
            d10 d10Var = (d10) entry.getKey();
            if (d10Var.c != 0) {
                d22 d22Var = (d22) entry.getValue();
                for (Class cls : d10Var.a) {
                    if (!map2.containsKey(cls)) {
                        map2.put(cls, new HashSet());
                    }
                    ((Set) map2.get(cls)).add(d22Var);
                }
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (map.containsKey(entry2.getKey())) {
                ia1 ia1Var = (ia1) map.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new or0(5, ia1Var, (d22) it.next()));
                }
            } else {
                Class cls2 = (Class) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                ia1 ia1Var2 = new ia1();
                ia1Var2.b = null;
                ia1Var2.a = Collections.newSetFromMap(new ConcurrentHashMap());
                ia1Var2.a.addAll(set);
                map.put(cls2, ia1Var2);
            }
        }
        return arrayList;
    }
}
