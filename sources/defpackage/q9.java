package defpackage;

import android.graphics.Matrix;
import android.media.Image;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q9 implements zy0 {
    public final Image a;
    public final uf1[] b;
    public final mi c;

    public q9(Image image) {
        this.a = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.b = new uf1[planes.length];
            for (int i = 0; i < planes.length; i++) {
                this.b[i] = new uf1(4, planes[i]);
            }
        } else {
            this.b = new uf1[0];
        }
        this.c = new mi(iv2.b, image.getTimestamp(), 0, new Matrix());
    }

    @Override // defpackage.zy0
    public final int a() {
        return this.a.getHeight();
    }

    @Override // defpackage.zy0
    public final int b() {
        return this.a.getWidth();
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.a.close();
    }

    @Override // defpackage.zy0
    public final uf1[] g() {
        return this.b;
    }

    @Override // defpackage.zy0
    public final int getFormat() {
        return this.a.getFormat();
    }

    @Override // defpackage.zy0
    public final vy0 m() {
        return this.c;
    }

    @Override // defpackage.zy0
    public final Image t() {
        return this.a;
    }
}
