package defpackage;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class gb3 extends fb3 {
    public gb3(pb3 pb3Var, WindowInsets windowInsets) {
        super(pb3Var, windowInsets);
    }

    @Override // defpackage.lb3
    public pb3 a() {
        return pb3.b(this.c.consumeDisplayCutout(), null);
    }

    @Override // defpackage.lb3
    public md0 e() {
        DisplayCutout displayCutout = this.c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new md0(displayCutout);
    }

    @Override // defpackage.eb3, defpackage.lb3
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gb3)) {
            return false;
        }
        gb3 gb3Var = (gb3) obj;
        return Objects.equals(this.c, gb3Var.c) && Objects.equals(this.g, gb3Var.g) && eb3.A(this.h, gb3Var.h);
    }

    @Override // defpackage.lb3
    public int hashCode() {
        return this.c.hashCode();
    }
}
