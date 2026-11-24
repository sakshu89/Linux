package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z00 implements x50 {
    public static final z00 b = new z00(0);
    public static final z00 c = new z00(1);
    public final /* synthetic */ int a;

    public /* synthetic */ z00(int i) {
        this.a = i;
    }

    @Override // defpackage.x50
    public final j70 f() {
        switch (this.a) {
            case 0:
                throw new IllegalStateException("This continuation is already complete");
            default:
                return gi0.a;
        }
    }

    @Override // defpackage.x50
    public final void h(Object obj) {
        switch (this.a) {
            case 0:
                throw new IllegalStateException("This continuation is already complete");
            default:
                return;
        }
    }

    public String toString() {
        switch (this.a) {
            case 0:
                return "This continuation is already complete";
            default:
                return super.toString();
        }
    }

    private final void a(Object obj) {
    }
}
