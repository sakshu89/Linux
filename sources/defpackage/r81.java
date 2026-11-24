package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r81 extends dk1 implements qf0 {
    public t81 x;

    @Override // defpackage.dk1
    public final void A0() {
        this.x.getClass();
    }

    @Override // defpackage.dk1
    public final void B0() {
        t81 t81Var = this.x;
        t81Var.c();
        t81Var.b = null;
    }

    @Override // defpackage.qf0
    public final void N(p71 p71Var) {
        ArrayList arrayList = this.x.h;
        if (arrayList.size() <= 0) {
            p71Var.a();
        } else {
            ky0.x(arrayList.get(0));
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r81) && g31.a(this.x, ((r81) obj).x);
    }

    public final int hashCode() {
        return this.x.hashCode();
    }

    public final String toString() {
        return "DisplayingDisappearingItemsNode(animator=" + this.x + ')';
    }
}
