package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.project.sonic.R;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class u73 {
    public static final /* synthetic */ int a = 0;

    static {
        new WeakHashMap();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x002d  */
    /* JADX WARN: Code duplicated, block: B:25:0x002f  */
    /* JADX WARN: Code duplicated, block: B:4:0x0003  */
    public static void a(View view, int i) {
        int i2;
        if (i == -1) {
            i2 = -1;
        } else {
            int i3 = Build.VERSION.SDK_INT;
            i2 = 6;
            if (i3 < 34) {
                switch (i) {
                    case 21:
                    case 23:
                    case 26:
                        i = 6;
                        break;
                    case 22:
                    case 24:
                    case 27:
                        i = 4;
                        break;
                    case 25:
                        i = 0;
                        break;
                }
            }
            if (i3 >= 30) {
                i2 = i;
            } else if (i == 12) {
                i2 = 1;
            } else if (i != 13) {
                if (i == 16) {
                    i2 = 1;
                } else if (i != 17) {
                    i2 = i;
                } else {
                    i2 = 0;
                }
            }
            if (i3 < 27 && (i2 == 7 || i2 == 8 || i2 == 9)) {
                i2 = -1;
            }
        }
        if (i2 == -1) {
            return;
        }
        view.performHapticFeedback(i2);
    }

    public static void b(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            r73.a(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void c(View view, hz hzVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            view.setWindowInsetsAnimationCallback(hzVar != null ? new ua3(hzVar) : null);
            return;
        }
        PathInterpolator pathInterpolator = sa3.e;
        View.OnApplyWindowInsetsListener ra3Var = hzVar != null ? new ra3(view, hzVar) : null;
        view.setTag(R.id.tag_window_insets_animation_callback, ra3Var);
        if (view.getTag(R.id.tag_compat_insets_dispatch) == null && view.getTag(R.id.tag_on_apply_window_listener) == null) {
            view.setOnApplyWindowInsetsListener(ra3Var);
        }
    }
}
