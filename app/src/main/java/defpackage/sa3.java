package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import com.project.sonic.R;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sa3 extends wa3 {
    public static final PathInterpolator e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
    public static final cl0 f = new cl0();
    public static final DecelerateInterpolator g = new DecelerateInterpolator(1.5f);
    public static final AccelerateInterpolator h = new AccelerateInterpolator(1.5f);

    public static void f(xa3 xa3Var, View view) {
        hz hzVarJ = j(view);
        if (hzVarJ != null) {
            hzVarJ.e(xa3Var);
            if (hzVarJ.a == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                f(xa3Var, viewGroup.getChildAt(i));
            }
        }
    }

    public static void g(View view, xa3 xa3Var, pb3 pb3Var, boolean z) {
        hz hzVarJ = j(view);
        if (hzVarJ != null) {
            hzVarJ.b = pb3Var;
            if (!z) {
                hzVarJ.f();
                z = hzVarJ.a == 0;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                g(viewGroup.getChildAt(i), xa3Var, pb3Var, z);
            }
        }
    }

    public static void h(View view, pb3 pb3Var, List list) {
        hz hzVarJ = j(view);
        if (hzVarJ != null) {
            pb3Var = hzVarJ.g(pb3Var, list);
            if (hzVarJ.a == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                h(viewGroup.getChildAt(i), pb3Var, list);
            }
        }
    }

    public static void i(View view, xa3 xa3Var, cu2 cu2Var) {
        hz hzVarJ = j(view);
        if (hzVarJ != null) {
            hzVarJ.h(xa3Var, cu2Var);
            if (hzVarJ.a == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                i(viewGroup.getChildAt(i), xa3Var, cu2Var);
            }
        }
    }

    public static hz j(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof ra3) {
            return ((ra3) tag).a;
        }
        return null;
    }
}
