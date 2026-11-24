package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jx2 extends bx2 {
    public final String b;
    public final int c;
    public final hq0 d;

    public jx2(Object obj, String str, int i, hq0 hq0Var) {
        super(obj);
        this.b = str;
        this.c = i;
        this.d = hq0Var;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TextContextMenuItem(key=");
        sb.append(this.a);
        sb.append(", label=\"");
        sb.append(this.b);
        sb.append("\", leadingIcon=");
        return ky0.m(sb, this.c, ')');
    }
}
