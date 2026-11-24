package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vt0 implements pi1 {
    public static final vt0 b = new vt0(0);
    public final /* synthetic */ int a;

    public /* synthetic */ vt0(int i) {
        this.a = i;
    }

    @Override // defpackage.pi1
    public final v22 a(Class cls) {
        switch (this.a) {
            case 0:
                if (!yt0.class.isAssignableFrom(cls)) {
                    og.i("Unsupported message type: ".concat(cls.getName()));
                    return null;
                }
                try {
                    return (v22) yt0.d(cls.asSubclass(yt0.class)).c(3);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // defpackage.pi1
    public final boolean b(Class cls) {
        switch (this.a) {
            case 0:
                return yt0.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
