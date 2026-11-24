package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d10 {
    public final Set a;
    public final Set b;
    public final int c;
    public final p10 d;
    public final Set e;

    public d10(HashSet hashSet, HashSet hashSet2, int i, p10 p10Var, HashSet hashSet3) {
        this.a = Collections.unmodifiableSet(hashSet);
        this.b = Collections.unmodifiableSet(hashSet2);
        this.c = i;
        this.d = p10Var;
        this.e = Collections.unmodifiableSet(hashSet3);
    }

    public static lq a(Class cls) {
        return new lq(cls, new Class[0]);
    }

    public static d10 b(Object obj, Class cls, Class... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(cls);
        for (Class cls2 : clsArr) {
            kg1.b(cls2, "Null interface");
        }
        Collections.addAll(hashSet, clsArr);
        return new d10(new HashSet(hashSet), new HashSet(hashSet2), 0, new c4(obj), hashSet3);
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.a.toArray()) + ">{0, type=" + this.c + ", deps=" + Arrays.toString(this.b.toArray()) + "}";
    }
}
