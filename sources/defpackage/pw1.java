package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pw1 extends y1 implements Set, Collection, x41 {
    public static final pw1 e;
    public final Object a;
    public final Object b;
    public final hw1 c;

    static {
        xy xyVar = xy.H;
        e = new pw1(xyVar, xyVar, hw1.c);
    }

    public pw1(Object obj, Object obj2, hw1 hw1Var) {
        this.a = obj;
        this.b = obj2;
        this.c = hw1Var;
    }

    @Override // defpackage.y0
    public final int a() {
        return this.c.b;
    }

    @Override // defpackage.y0, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.c.containsKey(obj);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zt0(this.a, this.c);
    }
}
