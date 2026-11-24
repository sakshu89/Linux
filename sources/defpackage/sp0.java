package defpackage;

import androidx.camera.camera2.internal.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.internal.compat.quirk.TextureViewIsClosedQuirk;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sp0 {
    public final boolean a;
    public final boolean b;
    public final boolean c;

    public sp0(cq0 cq0Var, cq0 cq0Var2) {
        this.a = cq0Var2.c(TextureViewIsClosedQuirk.class);
        this.b = cq0Var.c(PreviewOrientationIncorrectQuirk.class);
        this.c = cq0Var.c(ConfigureSurfaceToSecondarySessionFailQuirk.class);
    }

    public final void a(ArrayList arrayList) {
        if ((this.a || this.b || this.c) && arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((ob0) obj).a();
            }
            xq4.c(3, "ForceCloseDeferrableSurface");
        }
    }
}
