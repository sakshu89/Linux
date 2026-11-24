package defpackage;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class un0 {
    public static final int[] a = new int[2];
    public static final Rect b = new Rect();

    public static final l42 a(View view, r7 r7Var) {
        int[] iArr = a;
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        r7Var.getLocationInWindow(iArr);
        int i3 = iArr[0];
        float f = i2 - iArr[1];
        Rect rect = b;
        view.getFocusedRect(rect);
        float f2 = (i - i3) + rect.left;
        return new l42(f2, rect.top + f, rect.width() + f2, f + rect.top + rect.height());
    }

    public static final qn0 b(int i) {
        if (i == 1) {
            return new qn0(2);
        }
        if (i == 2) {
            return new qn0(1);
        }
        if (i == 17) {
            return new qn0(3);
        }
        if (i == 33) {
            return new qn0(5);
        }
        if (i == 66) {
            return new qn0(4);
        }
        if (i != 130) {
            return null;
        }
        return new qn0(6);
    }
}
