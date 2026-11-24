package defpackage;

import androidx.camera.camera2.internal.compat.quirk.AutoFlashUnderExposedQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk;
import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedForVideoSnapshotQuirk;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ph {
    public final boolean a;
    public boolean b;

    public ph(cq0 cq0Var, int i) {
        boolean z = true;
        switch (i) {
            case 2:
                this.b = false;
                this.a = cq0Var.d(AutoFlashUnderExposedQuirk.class) != null;
                break;
            case 3:
                cq0Var.getClass();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = cq0Var.a;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    h22 h22Var = (h22) obj;
                    if (CaptureIntentPreviewQuirk.class.isAssignableFrom(h22Var.getClass())) {
                        arrayList.add(h22Var);
                    }
                }
                int size2 = arrayList.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList.get(i3);
                    i3++;
                    if (((CaptureIntentPreviewQuirk) obj2).a()) {
                        this.a = z;
                        this.b = cq0Var.c(ImageCaptureFailedForVideoSnapshotQuirk.class);
                        break;
                    }
                }
                z = false;
                this.a = z;
                this.b = cq0Var.c(ImageCaptureFailedForVideoSnapshotQuirk.class);
                break;
            default:
                this.a = cq0Var.c(ImageCaptureFailWithAutoFlashQuirk.class);
                this.b = wc0.a.d(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class) != null;
                break;
        }
    }

    public ph(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }
}
