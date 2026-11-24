package defpackage;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class p73 {
    public static pb3 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        pb3 pb3VarB = pb3.b(rootWindowInsets, null);
        lb3 lb3Var = pb3VarB.a;
        lb3Var.q(pb3VarB);
        lb3Var.d(view.getRootView());
        return pb3VarB;
    }
}
