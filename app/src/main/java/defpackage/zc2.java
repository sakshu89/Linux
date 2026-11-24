package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zc2 implements ad2 {
    public final Bitmap a;

    public zc2(Bitmap bitmap) {
        this.a = bitmap;
    }

    public final Bitmap a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zc2) && this.a.equals(((zc2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Success(bitmap=" + this.a + ")";
    }
}
