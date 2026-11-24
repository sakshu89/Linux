package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wb3 implements vb3 {
    public final String b;
    public final g11 c;
    public final g11 d;

    public wb3(String str) {
        this.b = str;
        this.c = new g11(str);
        this.d = new g11(str.concat(" maximum"));
    }

    public final String toString() {
        return this.b;
    }
}
