package defpackage;

import android.graphics.Bitmap;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ss0 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ x00 b;

    public /* synthetic */ ss0(x00 x00Var, int i) {
        this.a = i;
        this.b = x00Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) throws IllegalAccessException, InvocationTargetException {
        int i = this.a;
        q43 q43Var = q43.a;
        x00 x00Var = this.b;
        switch (i) {
            case 0:
                x00Var.t0((Exception) obj);
                break;
            case 1:
                x00Var.t0((Exception) obj);
                break;
            default:
                x00Var.b0((Bitmap) obj);
                break;
        }
        return q43Var;
    }
}
