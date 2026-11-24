package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w20 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ w20(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final void a() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((x20) obj).A--;
                break;
            default:
                ((vm2) obj).k--;
                break;
        }
    }

    public final void b() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((x20) obj).A++;
                break;
            default:
                ((vm2) obj).k++;
                break;
        }
    }
}
