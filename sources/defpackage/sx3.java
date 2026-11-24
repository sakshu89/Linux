package defpackage;

import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sx3 extends dx3 implements ListIterator {
    public final /* synthetic */ ux3 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sx3(ux3 ux3Var, int i) {
        super(ux3Var, ((List) ux3Var.b).listIterator(i));
        this.f = ux3Var;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        ux3 ux3Var = this.f;
        boolean zIsEmpty = ux3Var.isEmpty();
        a();
        ((ListIterator) this.b).add(obj);
        if (zIsEmpty) {
            ux3Var.a();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        a();
        return ((ListIterator) this.b).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        a();
        return ((ListIterator) this.b).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        a();
        return ((ListIterator) this.b).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        a();
        return ((ListIterator) this.b).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        a();
        ((ListIterator) this.b).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sx3(ux3 ux3Var) {
        super(ux3Var);
        this.f = ux3Var;
    }
}
