package defpackage;

import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wp2 implements Comparator {
    public final /* synthetic */ int a;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i;
        switch (this.a) {
            case 0:
                return si4.a(Integer.valueOf(((gp1) obj).b.top), Integer.valueOf(((gp1) obj2).b.top));
            case 1:
                return si4.a(Integer.valueOf(((vp2) obj).b.top), Integer.valueOf(((vp2) obj2).b.top));
            case 2:
                return si4.a(Integer.valueOf(((gp1) obj).b.left), Integer.valueOf(((gp1) obj2).b.left));
            case 3:
                return si4.a(Integer.valueOf(((hp1) obj).d.top), Integer.valueOf(((hp1) obj2).d.top));
            case 4:
                return si4.a(Integer.valueOf(((hp1) obj).d.top), Integer.valueOf(((hp1) obj2).d.top));
            case 5:
                String str = ((zp2) obj).f;
                int i2 = 0;
                if (!cs2.n(str, "artist", false) || bq2.n.contains(str)) {
                    i = bq2.c0.a(str) ? 1 : 2;
                } else {
                    i = 0;
                }
                Integer numValueOf = Integer.valueOf(i);
                String str2 = ((zp2) obj2).f;
                if (!cs2.n(str2, "artist", false) || bq2.n.contains(str2)) {
                    i2 = bq2.c0.a(str2) ? 1 : 2;
                }
                return si4.a(numValueOf, Integer.valueOf(i2));
            case 6:
                return si4.a(Integer.valueOf(((aq2) obj).a.c.top), Integer.valueOf(((aq2) obj2).a.c.top));
            case 7:
                return si4.a(Integer.valueOf(((cd3) obj).b), Integer.valueOf(((cd3) obj2).b));
            default:
                return ((Integer) ((Map.Entry) obj).getValue()).compareTo((Integer) ((Map.Entry) obj2).getValue());
        }
    }
}
