package defpackage;

import android.widget.Magnifier;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class jx1 implements hx1 {
    public final Magnifier a;

    public jx1(Magnifier magnifier) {
        this.a = magnifier;
    }

    @Override // defpackage.hx1
    public void a(long j, long j2) {
        this.a.show(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    public final void b() {
        this.a.dismiss();
    }

    public final long c() {
        return (((long) this.a.getWidth()) << 32) | (((long) this.a.getHeight()) & 4294967295L);
    }

    public final void d() {
        this.a.update();
    }
}
