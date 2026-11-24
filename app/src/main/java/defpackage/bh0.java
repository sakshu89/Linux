package defpackage;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class bh0 {
    public void b(dv2 dv2Var, dv2 dv2Var2, Window window, View view, boolean z, boolean z2) {
        sf4 rb3Var;
        dv2Var.getClass();
        dv2Var2.getClass();
        window.getClass();
        view.getClass();
        of4.b(window);
        window.setStatusBarColor(z ? dv2Var.b : dv2Var.a);
        window.setNavigationBarColor(z2 ? dv2Var2.b : dv2Var2.a);
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            rb3Var = new sb3(window);
        } else {
            rb3Var = i >= 30 ? new rb3(window) : new qb3(window);
        }
        rb3Var.c(!z);
        rb3Var.b(!z2);
    }

    public void a(Window window) {
    }
}
