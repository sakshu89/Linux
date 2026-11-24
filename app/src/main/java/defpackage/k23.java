package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k23 {
    public final al0 a;
    public final zw b;
    public final boolean c;
    public final Map d;

    public /* synthetic */ k23(al0 al0Var, zw zwVar, LinkedHashMap linkedHashMap, int i) {
        this((i & 1) != 0 ? null : al0Var, (i & 4) != 0 ? null : zwVar, (i & 32) == 0, (i & 64) != 0 ? ji0.a : linkedHashMap);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k23)) {
            return false;
        }
        k23 k23Var = (k23) obj;
        return g31.a(this.a, k23Var.a) && g31.a(this.b, k23Var.b) && this.c == k23Var.c && g31.a(this.d, k23Var.d);
    }

    public final int hashCode() {
        al0 al0Var = this.a;
        int iHashCode = (al0Var == null ? 0 : al0Var.hashCode()) * 961;
        zw zwVar = this.b;
        return this.d.hashCode() + ky0.e((iHashCode + (zwVar != null ? zwVar.hashCode() : 0)) * 29791, 31, this.c);
    }

    public final String toString() {
        return "TransitionData(fade=" + this.a + ", slide=null, changeSize=" + this.b + ", scale=null, veil=null, hold=" + this.c + ", effectsMap=" + this.d + ')';
    }

    public k23(al0 al0Var, zw zwVar, boolean z, Map map) {
        this.a = al0Var;
        this.b = zwVar;
        this.c = z;
        this.d = map;
    }
}
