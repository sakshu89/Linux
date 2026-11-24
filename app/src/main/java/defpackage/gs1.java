package defpackage;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class gs1 implements s30 {
    public static final gb b;
    public static final gs1 c;
    public final TreeMap a;

    static {
        gb gbVar = new gb(7);
        b = gbVar;
        c = new gs1(new TreeMap(gbVar));
    }

    public gs1(TreeMap treeMap) {
        this.a = treeMap;
    }

    public static gs1 l(s30 s30Var) {
        if (gs1.class.equals(s30Var.getClass())) {
            return (gs1) s30Var;
        }
        TreeMap treeMap = new TreeMap(b);
        for (bi biVar : s30Var.e()) {
            Set<r30> setG = s30Var.g(biVar);
            ArrayMap arrayMap = new ArrayMap();
            for (r30 r30Var : setG) {
                arrayMap.put(r30Var, s30Var.h(biVar, r30Var));
            }
            treeMap.put(biVar, arrayMap);
        }
        return new gs1(treeMap);
    }

    @Override // defpackage.s30
    public final boolean a(bi biVar) {
        return this.a.containsKey(biVar);
    }

    @Override // defpackage.s30
    public final r30 b(bi biVar) {
        Map map = (Map) this.a.get(biVar);
        if (map != null) {
            return (r30) Collections.min(map.keySet());
        }
        dk0.y(biVar, "Option does not exist: ");
        return null;
    }

    @Override // defpackage.s30
    public final void c(qq qqVar) {
        for (Map.Entry entry : this.a.tailMap(new bi("camera2.captureRequest.option.", Void.class, null)).entrySet()) {
            if (!((bi) entry.getKey()).a.startsWith("camera2.captureRequest.option.")) {
                return;
            }
            bi biVar = (bi) entry.getKey();
            yr yrVar = (yr) qqVar.b;
            s30 s30Var = (s30) qqVar.c;
            yrVar.b.u(biVar, s30Var.b(biVar), s30Var.f(biVar));
        }
    }

    @Override // defpackage.s30
    public final Object d(bi biVar, Object obj) {
        try {
            return f(biVar);
        } catch (IllegalArgumentException unused) {
            return obj;
        }
    }

    @Override // defpackage.s30
    public final Set e() {
        return Collections.unmodifiableSet(this.a.keySet());
    }

    @Override // defpackage.s30
    public final Object f(bi biVar) {
        Map map = (Map) this.a.get(biVar);
        if (map != null) {
            return map.get((r30) Collections.min(map.keySet()));
        }
        dk0.y(biVar, "Option does not exist: ");
        return null;
    }

    @Override // defpackage.s30
    public final Set g(bi biVar) {
        Map map = (Map) this.a.get(biVar);
        return map == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(map.keySet());
    }

    @Override // defpackage.s30
    public final Object h(bi biVar, r30 r30Var) {
        Map map = (Map) this.a.get(biVar);
        if (map == null) {
            dk0.y(biVar, "Option does not exist: ");
            return null;
        }
        if (map.containsKey(r30Var)) {
            return map.get(r30Var);
        }
        dk0.j("Option does not exist: ", biVar, " with priority=", r30Var);
        return null;
    }
}
