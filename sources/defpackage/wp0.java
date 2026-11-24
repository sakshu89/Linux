package defpackage;

import android.media.Image;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wp0 implements zy0 {
    public final zy0 b;
    public final Object a = new Object();
    public final HashSet c = new HashSet();

    public wp0(zy0 zy0Var) {
        this.b = zy0Var;
    }

    @Override // defpackage.zy0
    public int a() {
        return this.b.a();
    }

    @Override // defpackage.zy0
    public int b() {
        return this.b.b();
    }

    public final void c(vp0 vp0Var) {
        synchronized (this.a) {
            this.c.add(vp0Var);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        HashSet hashSet;
        this.b.close();
        synchronized (this.a) {
            hashSet = new HashSet(this.c);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((vp0) it.next()).c(this);
        }
    }

    @Override // defpackage.zy0
    public final uf1[] g() {
        return this.b.g();
    }

    @Override // defpackage.zy0
    public final int getFormat() {
        return this.b.getFormat();
    }

    @Override // defpackage.zy0
    public vy0 m() {
        return this.b.m();
    }

    @Override // defpackage.zy0
    public final Image t() {
        return this.b.t();
    }
}
