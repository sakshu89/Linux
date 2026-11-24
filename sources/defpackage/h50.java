package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h50 {
    public final ym a;
    public final yv b;

    public h50(ym ymVar, yv yvVar) {
        this.a = ymVar;
        this.b = yvVar;
    }

    public final String toString() {
        yv yvVar = this.b;
        if (yvVar.f.v(o70.b) != null) {
            dk0.t();
            return null;
        }
        StringBuilder sb = new StringBuilder("Request@");
        int iHashCode = hashCode();
        ph4.a(16);
        String string = Integer.toString(iHashCode, 16);
        string.getClass();
        sb.append(string);
        sb.append("(currentBounds()=");
        sb.append(this.a.a());
        sb.append(", continuation=");
        sb.append(yvVar);
        sb.append(')');
        return sb.toString();
    }
}
