package defpackage;

import android.os.Build;
import android.view.DisplayCutout;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class md0 {
    public final DisplayCutout a;

    public md0(DisplayCutout displayCutout) {
        this.a = displayCutout;
    }

    public final q11 a() {
        return Build.VERSION.SDK_INT >= 30 ? q11.c(e3.e(this.a)) : q11.e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || md0.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((md0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.a + "}";
    }
}
