package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y00 {
    public final Object a;
    public final sv b;
    public final wq0 c;
    public final Object d;
    public final Throwable e;

    public /* synthetic */ y00(Object obj, sv svVar, wq0 wq0Var, Throwable th, int i) {
        this(obj, (i & 2) != 0 ? null : svVar, (i & 4) != 0 ? null : wq0Var, (Object) null, (i & 16) != 0 ? null : th);
    }

    public static y00 a(y00 y00Var, sv svVar, Throwable th, int i) {
        Object obj = y00Var.a;
        if ((i & 2) != 0) {
            svVar = y00Var.b;
        }
        sv svVar2 = svVar;
        wq0 wq0Var = y00Var.c;
        Object obj2 = y00Var.d;
        if ((i & 16) != 0) {
            th = y00Var.e;
        }
        return new y00(obj, svVar2, wq0Var, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y00)) {
            return false;
        }
        y00 y00Var = (y00) obj;
        return g31.a(this.a, y00Var.a) && g31.a(this.b, y00Var.b) && g31.a(this.c, y00Var.c) && g31.a(this.d, y00Var.d) && g31.a(this.e, y00Var.e);
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        sv svVar = this.b;
        int iHashCode2 = (iHashCode + (svVar == null ? 0 : svVar.hashCode())) * 31;
        wq0 wq0Var = this.c;
        int iHashCode3 = (iHashCode2 + (wq0Var == null ? 0 : wq0Var.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public y00(Object obj, sv svVar, wq0 wq0Var, Object obj2, Throwable th) {
        this.a = obj;
        this.b = svVar;
        this.c = wq0Var;
        this.d = obj2;
        this.e = th;
    }
}
