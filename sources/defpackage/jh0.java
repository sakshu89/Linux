package defpackage;

import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jh0 extends cn4 {
    public final /* synthetic */ kh0 a;

    public jh0(kh0 kh0Var) {
        this.a = kh0Var;
    }

    @Override // defpackage.cn4
    public final void a(Throwable th) {
        this.a.a.f(th);
    }

    @Override // defpackage.cn4
    public final void b(p6 p6Var) {
        kh0 kh0Var = this.a;
        kh0Var.c = p6Var;
        p6 p6Var2 = kh0Var.c;
        oh0 oh0Var = kh0Var.a;
        kh0Var.b = new kf(p6Var2, oh0Var.g, oh0Var.i, Build.VERSION.SDK_INT >= 34 ? th0.a() : dn4.a());
        oh0 oh0Var2 = kh0Var.a;
        ArrayList arrayList = new ArrayList();
        oh0Var2.a.writeLock().lock();
        try {
            oh0Var2.c = 1;
            arrayList.addAll(oh0Var2.b);
            oh0Var2.b.clear();
            oh0Var2.a.writeLock().unlock();
            oh0Var2.d.post(new mh0(arrayList, oh0Var2.c, null));
        } catch (Throwable th) {
            oh0Var2.a.writeLock().unlock();
            throw th;
        }
    }
}
