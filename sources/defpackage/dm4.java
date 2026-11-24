package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dm4 {
    public static final View a(xb0 xb0Var) {
        if (!((dk1) xb0Var).a.w) {
            z01.b("Cannot get View because the Modifier node is not currently attached.");
        }
        return (View) q71.a(cm4.g(xb0Var));
    }
}
