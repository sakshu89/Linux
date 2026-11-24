package defpackage;

import android.media.MediaCodec;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w00 implements Comparator {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ w00(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = this.a;
        int i2 = 0;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                for (hq0 hq0Var : (hq0[]) obj3) {
                    int iA = si4.a((Comparable) hq0Var.j(obj), (Comparable) hq0Var.j(obj2));
                    if (iA != 0) {
                        return iA;
                    }
                }
                return 0;
            case 1:
                return ((Number) ((ag) obj3).e(obj, obj2)).intValue();
            case 2:
                return ((Number) ((vq0) obj3).e(obj, obj2)).intValue();
            default:
                dj djVar = (dj) obj2;
                ((rh2) obj3).getClass();
                Class cls = ((dj) obj).a.j;
                int i3 = cls == MediaCodec.class ? 2 : cls == g02.class ? 0 : 1;
                Class cls2 = djVar.a.j;
                if (cls2 == MediaCodec.class) {
                    i2 = 2;
                } else if (cls2 != g02.class) {
                    i2 = 1;
                }
                return i3 - i2;
        }
    }
}
