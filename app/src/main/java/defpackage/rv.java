package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rv implements sv {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ rv(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.sv
    public final void b(Throwable th) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((hq0) obj).j(th);
                break;
            default:
                ((rd0) obj).a();
                break;
        }
    }

    public final String toString() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return "CancelHandler.UserSupplied[" + ((hq0) obj).getClass().getSimpleName() + '@' + ba0.c(this) + ']';
            default:
                return "DisposeOnCancel[" + ((rd0) obj) + ']';
        }
    }
}
