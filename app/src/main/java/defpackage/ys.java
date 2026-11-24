package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ys {
    public final uf1 b;
    public final String c;
    public final HashMap a = new HashMap();
    public p6 d = null;

    public ys(CameraCharacteristics cameraCharacteristics, String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = new xs(8, cameraCharacteristics);
        } else {
            this.b = new uf1(8, cameraCharacteristics);
        }
        this.c = str;
    }

    public final Object a(CameraCharacteristics.Key key) {
        if (key.equals(CameraCharacteristics.SENSOR_ORIENTATION)) {
            return ((CameraCharacteristics) this.b.b).get(key);
        }
        synchronized (this) {
            try {
                Object obj = this.a.get(key);
                if (obj != null) {
                    return obj;
                }
                Object obj2 = ((CameraCharacteristics) this.b.b).get(key);
                if (obj2 != null) {
                    this.a.put(key, obj2);
                }
                return obj2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final p6 b() {
        if (this.d == null) {
            try {
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (streamConfigurationMap == null) {
                    og.i("StreamConfigurationMap is null!");
                    return null;
                }
                q91 q91Var = new q91(this.c);
                p6 p6Var = new p6();
                p6Var.c = new HashMap();
                p6Var.e = new HashMap();
                new HashMap();
                p6Var.a = new wj1(10, streamConfigurationMap);
                p6Var.b = q91Var;
                this.d = p6Var;
            } catch (AssertionError | NullPointerException e) {
                og.i(e.getMessage());
                return null;
            }
        }
        return this.d;
    }
}
