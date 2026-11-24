package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ox3 {
    public final Object a;
    public final Object b;
    public final Object c;

    public ox3(Object obj, Object obj2, Object obj3) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.a;
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(this.b);
        String strValueOf3 = String.valueOf(obj);
        String strValueOf4 = String.valueOf(this.c);
        StringBuilder sbQ = cq.q("Multiple entries with same key: ", strValueOf, "=", strValueOf2, " and ");
        sbQ.append(strValueOf3);
        sbQ.append("=");
        sbQ.append(strValueOf4);
        return new IllegalArgumentException(sbQ.toString());
    }
}
