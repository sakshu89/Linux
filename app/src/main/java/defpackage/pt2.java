package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pt2 implements Runnable {
    public final /* synthetic */ st2 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ pt2(st2 st2Var, int i, int i2) {
        this.a = st2Var;
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        st2 st2Var = this.a;
        int i = st2Var.i;
        int i2 = this.b;
        boolean z2 = true;
        if (i != i2) {
            st2Var.i = i2;
            z = true;
        } else {
            z = false;
        }
        int i3 = st2Var.h;
        int i4 = this.c;
        if (i3 != i4) {
            st2Var.h = i4;
        } else {
            z2 = z;
        }
        if (z2) {
            st2Var.e();
        }
    }
}
