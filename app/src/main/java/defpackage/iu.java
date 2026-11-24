package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class iu implements q72 {
    public final /* synthetic */ int b;
    public final q72 c;

    public iu(int i, long j) {
        this.b = i;
        switch (i) {
            case 1:
                this.c = new y03(j, new hu(j));
                break;
            default:
                this.c = new iu(1, j);
                break;
        }
    }

    @Override // defpackage.q72
    public final p72 a(gu guVar) {
        int i = this.b;
        q72 q72Var = this.c;
        switch (i) {
            case 0:
                if (((y03) ((iu) q72Var).c).a(guVar).b) {
                    return p72.e;
                }
                Throwable th = (Throwable) guVar.c;
                if (th instanceof xu) {
                    xq4.a("CameraX", "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
                    if (((xu) th).a > 0) {
                        return p72.f;
                    }
                }
                return p72.d;
            default:
                return ((y03) q72Var).a(guVar);
        }
    }

    @Override // defpackage.q72
    public final long b() {
        switch (this.b) {
            case 0:
                return ((y03) ((iu) this.c).c).b;
            default:
                return ((y03) this.c).b;
        }
    }
}
