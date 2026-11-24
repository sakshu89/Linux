package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qj2 {
    public final List a;
    public final List b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final l61 f;

    public qj2(List list, List list2, boolean z, boolean z2, boolean z3, l61 l61Var) {
        list.getClass();
        list2.getClass();
        l61Var.getClass();
        this.a = list;
        this.b = list2;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = l61Var;
    }

    public static qj2 a(qj2 qj2Var, ArrayList arrayList, ArrayList arrayList2, boolean z, boolean z2, boolean z3, l61 l61Var, int i) {
        List list = arrayList;
        if ((i & 1) != 0) {
            list = qj2Var.a;
        }
        List list2 = list;
        List list3 = arrayList2;
        if ((i & 2) != 0) {
            list3 = qj2Var.b;
        }
        List list4 = list3;
        if ((i & 4) != 0) {
            z = qj2Var.c;
        }
        boolean z4 = z;
        if ((i & 8) != 0) {
            z2 = qj2Var.d;
        }
        boolean z5 = z2;
        if ((i & 16) != 0) {
            z3 = qj2Var.e;
        }
        boolean z6 = z3;
        if ((i & 32) != 0) {
            l61Var = qj2Var.f;
        }
        l61 l61Var2 = l61Var;
        qj2Var.getClass();
        list2.getClass();
        list4.getClass();
        l61Var2.getClass();
        return new qj2(list2, list4, z4, z5, z6, l61Var2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qj2)) {
            return false;
        }
        qj2 qj2Var = (qj2) obj;
        return g31.a(this.a, qj2Var.a) && g31.a(this.b, qj2Var.b) && this.c == qj2Var.c && this.d == qj2Var.d && this.e == qj2Var.e && this.f == qj2Var.f;
    }

    public final int hashCode() {
        return this.f.hashCode() + ky0.e(ky0.e(ky0.e((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, this.c), 31, this.d), 31, this.e);
    }

    public final String toString() {
        return "SetupUiState(runtime=" + this.a + ", special=" + this.b + ", isAssistantRoleHeld=" + this.c + ", allRuntimeGranted=" + this.d + ", refusedSomething=" + this.e + ", language=" + this.f + ")";
    }
}
