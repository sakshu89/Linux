package defpackage;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.Preview3AThreadCrashQuirk;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import androidx.camera.camera2.internal.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.camera2.internal.compat.quirk.UseTorchAsFlashQuirk;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rh2 {
    public final boolean a;

    public rh2(int i) {
        switch (i) {
            case 2:
                this.a = uc0.a.d(SurfaceOrderQuirk.class) != null;
                break;
            case 3:
                this.a = wc0.a.d(TorchIsClosedAfterImageCapturingQuirk.class) != null;
                break;
            default:
                this.a = ((StillCaptureFlashStopRepeatingQuirk) wc0.a.d(StillCaptureFlashStopRepeatingQuirk.class)) != null;
                break;
        }
    }

    public static lw a(lw lwVar) {
        ur urVar = new ur();
        urVar.a = lwVar.c;
        Iterator it = Collections.unmodifiableList(lwVar.a).iterator();
        while (it.hasNext()) {
            ((HashSet) urVar.d).add((ob0) it.next());
        }
        urVar.c(lwVar.b);
        zl1 zl1VarM = zl1.m();
        zl1VarM.v(zr.M(CaptureRequest.FLASH_MODE), 0);
        urVar.c(new zr(gs1.l(zl1VarM)));
        return urVar.d();
    }

    public boolean b(ArrayList arrayList, boolean z) {
        if (this.a && z) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Integer num = (Integer) ((CaptureRequest) obj).get(CaptureRequest.FLASH_MODE);
                if (num != null && num.intValue() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean c(ArrayList arrayList, boolean z) {
        if (this.a && z) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                int iIntValue = ((Integer) ((CaptureRequest) obj).get(CaptureRequest.CONTROL_AE_MODE)).intValue();
                if (iIntValue == 2 || iIntValue == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public rh2(cq0 cq0Var, int i) {
        switch (i) {
            case 4:
                this.a = cq0Var.c(UseTorchAsFlashQuirk.class);
                break;
            default:
                this.a = cq0Var.c(Preview3AThreadCrashQuirk.class);
                break;
        }
    }
}
