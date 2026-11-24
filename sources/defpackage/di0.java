package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class di0 implements rz0 {
    public final boolean a;

    public di0(boolean z) {
        this.a = z;
    }

    @Override // defpackage.rz0
    public final boolean c() {
        return this.a;
    }

    @Override // defpackage.rz0
    public final eo1 getList() {
        return null;
    }

    public final String toString() {
        return ky0.n(new StringBuilder("Empty{"), this.a ? "Active" : "New", '}');
    }
}
