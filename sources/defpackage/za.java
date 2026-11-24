package defpackage;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class za extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ yy1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ za(yy1 yy1Var, int i) {
        super(1);
        this.b = i;
        this.c = yy1Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.b;
        q43 q43Var = q43.a;
        yy1 yy1Var = this.c;
        switch (i) {
            case 0:
                y61 y61VarM = ((y61) obj).m();
                y61VarM.getClass();
                yy1Var.k(y61VarM);
                break;
            case 1:
                yy1Var.m39setPopupContentSizefhxjrPA(new l21(((l21) obj).a));
                yy1Var.l();
                break;
            default:
                fq0 fq0Var = (fq0) obj;
                Handler handler = yy1Var.getHandler();
                if ((handler != null ? handler.getLooper() : null) != Looper.myLooper()) {
                    Handler handler2 = yy1Var.getHandler();
                    if (handler2 != null) {
                        handler2.post(new m4(fq0Var, 3));
                    }
                } else {
                    fq0Var.a();
                }
                break;
        }
        return q43Var;
    }
}
