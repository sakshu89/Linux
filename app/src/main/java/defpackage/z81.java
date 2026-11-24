package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z81 implements gr2 {
    public final ku1 a;
    public int b;

    public z81(int i) {
        int i2 = (i / 30) * 30;
        this.a = new ku1(ky3.f(Math.max(i2 - 100, 0), i2 + 130), su0.k);
        this.b = i;
    }

    @Override // defpackage.gr2
    public final Object getValue() {
        return (h21) this.a.getValue();
    }
}
