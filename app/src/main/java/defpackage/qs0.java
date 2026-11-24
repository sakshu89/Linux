package defpackage;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qs0 {
    public final long a;
    public final JSONObject b;

    public qs0(long j, JSONObject jSONObject) {
        this.a = j;
        this.b = jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qs0)) {
            return false;
        }
        qs0 qs0Var = (qs0) obj;
        return this.a == qs0Var.a && this.b.equals(qs0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Long.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "IncomingMessage(outputEpoch=" + this.a + ", json=" + this.b + ")";
    }
}
