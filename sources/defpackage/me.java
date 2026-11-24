package defpackage;

import android.window.OnBackInvokedCallback;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class me implements OnBackInvokedCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ fq0 b;

    public /* synthetic */ me(fq0 fq0Var, int i) {
        this.a = i;
        this.b = fq0Var;
    }

    public final void onBackInvoked() {
        int i = this.a;
        fq0 fq0Var = this.b;
        switch (i) {
            case 0:
                if (fq0Var != null) {
                    fq0Var.a();
                }
                break;
            default:
                ((xp1) fq0Var).a();
                break;
        }
    }
}
