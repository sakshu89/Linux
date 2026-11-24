package defpackage;

import android.util.Size;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v00 implements Comparator {
    public final boolean a;

    public v00(boolean z) {
        this.a = z;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Size size = (Size) obj;
        Size size2 = (Size) obj2;
        int iSignum = Long.signum((((long) size.getWidth()) * ((long) size.getHeight())) - (((long) size2.getWidth()) * ((long) size2.getHeight())));
        return this.a ? iSignum * (-1) : iSignum;
    }
}
