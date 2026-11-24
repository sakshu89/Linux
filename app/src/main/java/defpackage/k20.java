package defpackage;

import android.os.CancellationSignal;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k20 implements CancellationSignal.OnCancelListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ k20(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public final void onCancel() throws IllegalAccessException, InvocationTargetException {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((yq2) obj).e(null);
                break;
            default:
                ny2 ny2Var = (ny2) obj;
                if (ny2Var != null) {
                    ua1 ua1Var = ny2Var.d;
                    if (ua1Var != null) {
                        ua1Var.e(oz2.b);
                    }
                    ua1 ua1Var2 = ny2Var.d;
                    if (ua1Var2 != null) {
                        ua1Var2.f(oz2.b);
                    }
                }
                break;
        }
    }
}
