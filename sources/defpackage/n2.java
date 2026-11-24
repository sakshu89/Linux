package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n2 implements wq0 {
    public static final n2 b = new n2(0);
    public static final n2 c = new n2(1);
    public static final n2 e = new n2(2);
    public final /* synthetic */ int a;

    public /* synthetic */ n2(int i) {
        this.a = i;
    }

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        int i = this.a;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                Bitmap bitmap = (Bitmap) obj2;
                ((Throwable) obj).getClass();
                ((j70) obj3).getClass();
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return q43Var;
            case 1:
                ad2 ad2Var = (ad2) obj2;
                ((Throwable) obj).getClass();
                ad2Var.getClass();
                ((j70) obj3).getClass();
                zc2 zc2Var = ad2Var instanceof zc2 ? (zc2) ad2Var : null;
                if (zc2Var != null) {
                    zc2Var.a.recycle();
                }
                return q43Var;
            default:
                return null;
        }
    }
}
