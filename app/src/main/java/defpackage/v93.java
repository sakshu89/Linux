package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v93 {
    public final boolean a;
    public final Integer b;
    public final boolean c;
    public final Integer d;
    public final boolean e;
    public final boolean f;

    public v93(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        this.a = z;
        this.b = num;
        this.c = z2;
        this.d = num2;
        this.e = z3;
        this.f = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v93)) {
            return false;
        }
        v93 v93Var = (v93) obj;
        return this.a == v93Var.a && g31.a(this.b, v93Var.b) && this.c == v93Var.c && g31.a(this.d, v93Var.d) && this.e == v93Var.e && this.f == v93Var.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public final int hashCode() {
        boolean z = this.a;
        var r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = r1 * 31;
        Integer num = this.b;
        int iHashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        boolean z2 = this.c;
        var r3 = z2;
        if (z2) {
            r3 = 1;
        }
        int i2 = (iHashCode + r3) * 31;
        Integer num2 = this.d;
        int iHashCode2 = (i2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z3 = this.e;
        var r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i3 = (iHashCode2 + r2) * 31;
        boolean z4 = this.f;
        return i3 + (z4 ? 1 : z4);
    }

    public final String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.a + ", clientMaxWindowBits=" + this.b + ", clientNoContextTakeover=" + this.c + ", serverMaxWindowBits=" + this.d + ", serverNoContextTakeover=" + this.e + ", unknownValues=" + this.f + ')';
    }
}
