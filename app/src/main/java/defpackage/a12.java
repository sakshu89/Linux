package defpackage;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a12 implements ob1 {
    public static final a12 n = new a12();
    public int a;
    public int b;
    public Handler f;
    public boolean c = true;
    public boolean e = true;
    public final qb1 i = new qb1(this, true);
    public final s7 j = new s7(23, this);
    public final wj1 k = new wj1(3, this);

    public final void a() {
        int i = this.b + 1;
        this.b = i;
        if (i == 1) {
            if (this.c) {
                this.i.d(db1.ON_RESUME);
                this.c = false;
            } else {
                Handler handler = this.f;
                handler.getClass();
                handler.removeCallbacks(this.j);
            }
        }
    }

    @Override // defpackage.ob1
    public final qb1 f() {
        return this.i;
    }
}
