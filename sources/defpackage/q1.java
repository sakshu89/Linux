package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q1 extends Throwable {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q1(String str, int i) {
        super(str);
        this.a = i;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        int i = this.a;
        synchronized (this) {
            switch (i) {
                case 0:
                    break;
                default:
                    break;
            }
            return this;
        }
    }
}
