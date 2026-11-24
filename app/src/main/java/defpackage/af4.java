package defpackage;

import android.view.View;
import com.project.sonic.R;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class af4 {
    public static final float a = 24.0f;
    public static final float b = 24.0f;

    public static final ob1 a(View view) {
        view.getClass();
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_lifecycle_owner);
            ob1 ob1Var = tag instanceof ob1 ? (ob1) tag : null;
            if (ob1Var != null) {
                return ob1Var;
            }
            Object objB = ye4.b(view);
            view = objB instanceof View ? (View) objB : null;
        }
        return null;
    }
}
