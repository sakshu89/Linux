package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class aj {
    public final wy a;
    public final HashMap b;

    public aj(wy wyVar, HashMap map) {
        this.a = wyVar;
        this.b = map;
    }

    public final long a(v02 v02Var, long j, int i) {
        long jH = j - this.a.h();
        bj bjVar = (bj) this.b.get(v02Var);
        long j2 = bjVar.a;
        int i2 = i - 1;
        return Math.min(Math.max((long) (Math.pow(3.0d, i2) * j2 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j2 > 1 ? j2 : 2L) * ((long) i2)))), jH), bjVar.b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aj)) {
            return false;
        }
        aj ajVar = (aj) obj;
        return this.a.equals(ajVar.a) && this.b.equals(ajVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ ((this.a.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.a + ", values=" + this.b + "}";
    }
}
