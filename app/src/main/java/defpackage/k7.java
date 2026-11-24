package defpackage;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k7 extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ r7 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k7(r7 r7Var, int i) {
        super(1);
        this.b = i;
        this.c = r7Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.b;
        q43 q43Var = q43.a;
        r7 r7Var = this.c;
        switch (i) {
            case 0:
                ((do0) r7Var.getFocusOwner()).g(((qn0) obj).a, false);
                return q43Var;
            case 1:
                fq0 fq0Var = (fq0) obj;
                r7Var.getUncaughtExceptionHandler$ui();
                Handler handler = r7Var.getHandler();
                if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
                    fq0Var.a();
                } else {
                    Handler handler2 = r7Var.getHandler();
                    if (handler2 != null) {
                        handler2.post(new m4(fq0Var, 1));
                    }
                }
                return q43Var;
            default:
                return new ua(r7Var, r7Var.getTextInputService(), (s70) obj);
        }
    }
}
