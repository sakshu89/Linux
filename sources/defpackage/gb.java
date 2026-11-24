package defpackage;

import android.util.Size;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gb implements Comparator {
    public final /* synthetic */ int a;

    public /* synthetic */ gb(int i) {
        this.a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                return g31.b(((x02) obj2).a, ((x02) obj).a);
            case 1:
                return g31.b(((r31) obj).b, ((r31) obj2).b);
            case 2:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i = 0; i < bArr.length; i++) {
                    byte b = bArr[i];
                    byte b2 = bArr2[i];
                    if (b != b2) {
                        return b - b2;
                    }
                }
                return 0;
            case 3:
                wt1 wt1Var = (wt1) obj;
                wt1 wt1Var2 = (wt1) obj2;
                return (((Number) wt1Var.b).intValue() - ((Number) wt1Var.a).intValue()) - (((Number) wt1Var2.b).intValue() - ((Number) wt1Var2.a).intValue());
            case 4:
                n71 n71Var = (n71) obj;
                n71 n71Var2 = (n71) obj2;
                float f = n71Var.p0.p.m0;
                float f2 = n71Var2.p0.p.m0;
                return f == f2 ? g31.b(n71Var.v(), n71Var2.v()) : Float.compare(f, f2);
            case 5:
                return g31.b(((y91) obj).a, ((y91) obj2).a);
            case 6:
                Size size = (Size) obj;
                Size size2 = (Size) obj2;
                return Long.signum((((long) size.getWidth()) * ((long) size.getHeight())) - (((long) size2.getWidth()) * ((long) size2.getHeight())));
            case 7:
                return ((bi) obj).a.compareTo(((bi) obj2).a);
            default:
                return ((String) obj).compareTo((String) obj2);
        }
    }
}
