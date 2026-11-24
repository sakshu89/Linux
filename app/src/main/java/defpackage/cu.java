package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cu extends bu {
    @Override // defpackage.l11
    public final Set x() throws ds {
        try {
            return ((CameraManager) this.b).getConcurrentCameraIds();
        } catch (CameraAccessException e) {
            throw new ds(e);
        }
    }
}
