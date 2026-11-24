package defpackage;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import com.project.sonic.MainActivity;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class o10 {
    public static final ViewGroup.LayoutParams a = new ViewGroup.LayoutParams(-2, -2);

    public static void a(MainActivity mainActivity, w10 w10Var) {
        View childAt = ((ViewGroup) mainActivity.getWindow().getDecorView().findViewById(R.id.content)).getChildAt(0);
        p20 p20Var = childAt instanceof p20 ? (p20) childAt : null;
        if (p20Var != null) {
            p20Var.setParentCompositionContext(null);
            p20Var.setContent(w10Var);
            return;
        }
        p20 p20Var2 = new p20(mainActivity);
        p20Var2.setParentCompositionContext(null);
        p20Var2.setContent(w10Var);
        View decorView = mainActivity.getWindow().getDecorView();
        if (af4.a(decorView) == null) {
            decorView.setTag(com.project.sonic.R.id.view_tree_lifecycle_owner, mainActivity);
        }
        if (ef4.b(decorView) == null) {
            decorView.setTag(com.project.sonic.R.id.view_tree_view_model_store_owner, mainActivity);
        }
        if (cf4.c(decorView) == null) {
            decorView.setTag(com.project.sonic.R.id.view_tree_saved_state_registry_owner, mainActivity);
        }
        mainActivity.setContentView(p20Var2, a);
    }
}
