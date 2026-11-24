package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class oa1 extends ik1 {
    public final ba a;
    public final ua1 b;
    public final ny2 c;

    public oa1(ba baVar, ua1 ua1Var, ny2 ny2Var) {
        this.a = baVar;
        this.b = ua1Var;
        this.c = ny2Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new pa1(this.a, this.b, this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof oa1) {
            oa1 oa1Var = (oa1) obj;
            return g31.a(this.a, oa1Var.a) && this.b == oa1Var.b && this.c == oa1Var.c;
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) throws IllegalAccessException, InvocationTargetException {
        pa1 pa1Var = (pa1) dk1Var;
        if (pa1Var.w) {
            pa1Var.x.f();
            pa1Var.x.k(pa1Var);
        }
        ba baVar = this.a;
        pa1Var.x = baVar;
        if (pa1Var.w) {
            if (baVar.a != null) {
                c11.c("Expected textInputModifierNode to be null");
            }
            baVar.a = pa1Var;
        }
        pa1Var.H = this.b;
        pa1Var.X = this.c;
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "LegacyAdaptingPlatformTextInputModifier(serviceAdapter=" + this.a + ", legacyTextFieldState=" + this.b + ", textFieldSelectionManager=" + this.c + ')';
    }
}
