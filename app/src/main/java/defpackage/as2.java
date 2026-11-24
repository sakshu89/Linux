package defpackage;

import android.os.Build;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class as2 {
    public static final bi a = new bi("camera2.streamSpec.streamUseCase", Long.TYPE, null);
    public static final HashMap b;
    public static final HashMap c;

    static {
        HashMap map = new HashMap();
        b = map;
        HashMap map2 = new HashMap();
        c = map2;
        if (Build.VERSION.SDK_INT >= 33) {
            HashSet hashSet = new HashSet();
            t53 t53Var = t53.b;
            hashSet.add(t53Var);
            t53 t53Var2 = t53.i;
            hashSet.add(t53Var2);
            map.put(4L, hashSet);
            HashSet hashSet2 = new HashSet();
            hashSet2.add(t53Var);
            hashSet2.add(t53Var2);
            hashSet2.add(t53.c);
            map.put(1L, hashSet2);
            HashSet hashSet3 = new HashSet();
            t53 t53Var3 = t53.a;
            hashSet3.add(t53Var3);
            map.put(2L, hashSet3);
            HashSet hashSet4 = new HashSet();
            t53 t53Var4 = t53.e;
            hashSet4.add(t53Var4);
            map.put(3L, hashSet4);
            HashSet hashSet5 = new HashSet();
            hashSet5.add(t53Var);
            hashSet5.add(t53Var3);
            hashSet5.add(t53Var4);
            map2.put(4L, hashSet5);
            HashSet hashSet6 = new HashSet();
            hashSet6.add(t53Var);
            hashSet6.add(t53Var4);
            map2.put(3L, hashSet6);
        }
    }

    public static zr a(s30 s30Var, long j) {
        bi biVar = a;
        if (s30Var.a(biVar) && ((Long) s30Var.f(biVar)).longValue() == j) {
            return null;
        }
        zl1 zl1VarO = zl1.o(s30Var);
        zl1VarO.v(biVar, Long.valueOf(j));
        return new zr(zl1VarO);
    }

    public static boolean b(t53 t53Var, long j, List list) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        if (t53Var != t53.f) {
            Long lValueOf = Long.valueOf(j);
            HashMap map = b;
            return map.containsKey(lValueOf) && ((Set) map.get(Long.valueOf(j))).contains(t53Var);
        }
        Long lValueOf2 = Long.valueOf(j);
        HashMap map2 = c;
        if (!map2.containsKey(lValueOf2)) {
            return false;
        }
        Set set = (Set) map2.get(Long.valueOf(j));
        if (list.size() != set.size()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!set.contains((t53) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(s30 s30Var, t53 t53Var) {
        if (((Boolean) s30Var.d(r53.U, Boolean.FALSE)).booleanValue()) {
            return false;
        }
        bi biVar = sy0.b;
        if (s30Var.a(biVar)) {
            return t53Var.ordinal() == 0 && ((Integer) s30Var.f(biVar)).intValue() == 2;
        }
        return false;
    }
}
