package defpackage;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ou2 extends ik1 {
    public final Object a;
    public final Object b;
    public final PointerInputEventHandler c;

    public ou2(Object obj, Object obj2, PointerInputEventHandler pointerInputEventHandler, int i) {
        obj2 = (i & 2) != 0 ? null : obj2;
        this.a = obj;
        this.b = obj2;
        this.c = pointerInputEventHandler;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new tu2(this.a, this.b, this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ou2)) {
            return false;
        }
        ou2 ou2Var = (ou2) obj;
        return g31.a(this.a, ou2Var.a) && g31.a(this.b, ou2Var.b) && this.c == ou2Var.c;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        tu2 tu2Var = (tu2) dk1Var;
        Object obj = tu2Var.x;
        Object obj2 = this.a;
        boolean z = !g31.a(obj, obj2);
        tu2Var.x = obj2;
        Object obj3 = tu2Var.H;
        Object obj4 = this.b;
        if (!g31.a(obj3, obj4)) {
            z = true;
        }
        tu2Var.H = obj4;
        Class<?> cls = tu2Var.X.getClass();
        PointerInputEventHandler pointerInputEventHandler = this.c;
        if (cls == pointerInputEventHandler.getClass() ? z : true) {
            tu2Var.K0();
        }
        tu2Var.X = pointerInputEventHandler;
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.b;
        return this.c.hashCode() + ((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 961);
    }
}
