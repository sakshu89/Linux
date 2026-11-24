package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xt implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ yt b;
    public final /* synthetic */ String c;

    public /* synthetic */ xt(yt ytVar, String str, int i) {
        this.a = i;
        this.b = ytVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        String str = this.c;
        yt ytVar = this.b;
        switch (i) {
            case 0:
                ytVar.b.onCameraAvailable(str);
                break;
            default:
                ytVar.b.onCameraUnavailable(str);
                break;
        }
    }
}
