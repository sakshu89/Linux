package defpackage;

import android.hardware.camera2.CameraAccessException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ds extends Exception {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList(4, 5, 1, 2, 3)));
    public final int a;

    static {
        Collections.unmodifiableSet(new HashSet(Arrays.asList(10001, 10002)));
    }

    public ds(String str, AssertionError assertionError) {
        super(String.format("%s (%d): %s", "CAMERA_CHARACTERISTICS_CREATION_ERROR", 10002, str), assertionError);
        this.a = 10002;
        if (b.contains(10002)) {
            new CameraAccessException(10002, str, assertionError);
        }
    }

    public ds(RuntimeException runtimeException) {
        super("Some API 28 devices cannot access the camera when the device is in \"Do Not Disturb\" mode. The camera will not be accessible until \"Do Not Disturb\" mode is disabled.", runtimeException);
        this.a = 10001;
        if (b.contains(10001)) {
            new CameraAccessException(10001, null, runtimeException);
        }
    }

    public ds(CameraAccessException cameraAccessException) {
        super(cameraAccessException.getMessage(), cameraAccessException.getCause());
        this.a = cameraAccessException.getReason();
    }
}
