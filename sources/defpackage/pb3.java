package defpackage;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pb3 {
    public static final pb3 b;
    public final lb3 a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            b = kb3.s;
        } else if (i >= 30) {
            b = ib3.r;
        } else {
            b = lb3.b;
        }
    }

    public pb3(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            this.a = new kb3(this, windowInsets);
            return;
        }
        if (i >= 31) {
            this.a = new jb3(this, windowInsets);
            return;
        }
        if (i >= 30) {
            this.a = new ib3(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.a = new hb3(this, windowInsets);
        } else if (i >= 28) {
            this.a = new gb3(this, windowInsets);
        } else {
            this.a = new fb3(this, windowInsets);
        }
    }

    public static pb3 b(WindowInsets windowInsets, View view) {
        windowInsets.getClass();
        pb3 pb3Var = new pb3(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            int i = u73.a;
            pb3 pb3VarA = p73.a(view);
            lb3 lb3Var = pb3Var.a;
            lb3Var.q(pb3VarA);
            lb3Var.d(view.getRootView());
            lb3Var.s(view.getWindowSystemUiVisibility());
        }
        return pb3Var;
    }

    public final WindowInsets a() {
        lb3 lb3Var = this.a;
        if (lb3Var instanceof eb3) {
            return ((eb3) lb3Var).c;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof pb3) {
            return Objects.equals(this.a, ((pb3) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        lb3 lb3Var = this.a;
        if (lb3Var == null) {
            return 0;
        }
        return lb3Var.hashCode();
    }

    public pb3() {
        this.a = new lb3(this);
    }
}
