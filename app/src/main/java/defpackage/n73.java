package defpackage;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n73 implements View.OnApplyWindowInsetsListener {
    public pb3 a = null;
    public final /* synthetic */ View b;
    public final /* synthetic */ up1 c;

    public n73(View view, up1 up1Var) {
        this.b = view;
        this.c = up1Var;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        pb3 pb3VarB = pb3.b(windowInsets, view);
        int i = Build.VERSION.SDK_INT;
        up1 up1Var = this.c;
        if (i < 30) {
            o73.a(windowInsets, this.b);
            if (pb3VarB.equals(this.a)) {
                return up1Var.a(view, pb3VarB).a();
            }
        }
        this.a = pb3VarB;
        pb3 pb3VarA = up1Var.a(view, pb3VarB);
        if (i >= 30) {
            return pb3VarA.a();
        }
        int i2 = u73.a;
        m73.a(view);
        return pb3VarA.a();
    }
}
