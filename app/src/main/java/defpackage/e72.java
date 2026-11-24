package defpackage;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e72 extends wb4 {
    public final Set a;
    public final Set b;
    public final Set c;
    public final Set d;
    public final wb4 e;

    public e72(d10 d10Var, wb4 wb4Var) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        Set<mc0> set = d10Var.b;
        Set set2 = d10Var.e;
        for (mc0 mc0Var : set) {
            int i = mc0Var.c;
            int i2 = mc0Var.b;
            boolean z = i == 0;
            Class cls = mc0Var.a;
            if (z) {
                if (i2 == 2) {
                    hashSet4.add(cls);
                } else {
                    hashSet.add(cls);
                }
            } else if (i == 2) {
                hashSet3.add(cls);
            } else if (i2 == 2) {
                hashSet5.add(cls);
            } else {
                hashSet2.add(cls);
            }
        }
        if (!set2.isEmpty()) {
            hashSet.add(f22.class);
        }
        this.a = Collections.unmodifiableSet(hashSet);
        this.b = Collections.unmodifiableSet(hashSet2);
        Collections.unmodifiableSet(hashSet3);
        this.c = Collections.unmodifiableSet(hashSet4);
        this.d = Collections.unmodifiableSet(hashSet5);
        this.e = wb4Var;
    }

    @Override // defpackage.wb4
    public final Object b(Class cls) {
        if (!this.a.contains(cls)) {
            dk0.o("Attempting to request an undeclared dependency ", cls, ".");
            return null;
        }
        Object objB = this.e.b(cls);
        if (!cls.equals(f22.class)) {
            return objB;
        }
        return new d72();
    }

    @Override // defpackage.wb4
    public final d22 c(Class cls) {
        if (this.b.contains(cls)) {
            return this.e.c(cls);
        }
        dk0.o("Attempting to request an undeclared dependency Provider<", cls, ">.");
        return null;
    }

    @Override // defpackage.wb4
    public final Set d(Class cls) {
        if (this.c.contains(cls)) {
            return this.e.d(cls);
        }
        dk0.o("Attempting to request an undeclared dependency Set<", cls, ">.");
        return null;
    }

    @Override // defpackage.wb4
    public final d22 e(Class cls) {
        if (this.d.contains(cls)) {
            return this.e.e(cls);
        }
        dk0.o("Attempting to request an undeclared dependency Provider<Set<", cls, ">>.");
        return null;
    }
}
