package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class wh2 {
    public static final StackTraceElement[] a = new StackTraceElement[0];

    public static LinkedHashSet a(Set set, Iterable iterable) {
        int size;
        set.getClass();
        iterable.getClass();
        Integer numValueOf = iterable instanceof Collection ? Integer.valueOf(((Collection) iterable).size()) : null;
        if (numValueOf != null) {
            size = set.size() + numValueOf.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(bh1.b(size));
        linkedHashSet.addAll(set);
        rz.q(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static Set b(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        setSingleton.getClass();
        return setSingleton;
    }

    public static Set c(Object... objArr) {
        int length = objArr.length;
        if (length == 0) {
            return mi0.a;
        }
        if (length == 1) {
            return b(objArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(bh1.b(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }
}
