package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jg4 {
    public static void a(CaptureRequest.Builder builder, gs1 gs1Var) {
        q82 q82VarD = yr.e(gs1Var).d();
        for (bi biVar : q82VarD.e()) {
            CaptureRequest.Key key = (CaptureRequest.Key) biVar.c;
            try {
                builder.set(key, q82VarD.f(biVar));
            } catch (IllegalArgumentException unused) {
                xq4.a("Camera2CaptureRequestBuilder", "CaptureRequest.Key is not supported: " + key);
            }
        }
    }

    public static void b(CaptureRequest.Builder builder, int i, ph phVar) {
        Map mapUnmodifiableMap;
        if (i == 3 && phVar.a) {
            HashMap map = new HashMap();
            map.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 1);
            mapUnmodifiableMap = Collections.unmodifiableMap(map);
        } else {
            if (i != 4) {
                phVar.getClass();
            } else if (phVar.b) {
                HashMap map2 = new HashMap();
                map2.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 2);
                mapUnmodifiableMap = Collections.unmodifiableMap(map2);
            }
            mapUnmodifiableMap = Collections.EMPTY_MAP;
        }
        for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
            builder.set((CaptureRequest.Key) entry.getKey(), entry.getValue());
        }
    }

    public static CaptureRequest c(lw lwVar, CameraDevice cameraDevice, HashMap map, boolean z, ph phVar) throws CameraAccessException {
        CaptureRequest.Builder builderCreateCaptureRequest;
        if (cameraDevice != null) {
            ArrayList arrayList = lwVar.a;
            gs1 gs1Var = lwVar.b;
            int i = lwVar.c;
            TreeMap treeMap = gs1Var.a;
            List listUnmodifiableList = Collections.unmodifiableList(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = listUnmodifiableList.iterator();
            while (it.hasNext()) {
                Surface surface = (Surface) map.get((ob0) it.next());
                if (surface == null) {
                    og.i("DeferrableSurface not in configuredSurfaceMap");
                    return null;
                }
                arrayList2.add(surface);
            }
            if (!arrayList2.isEmpty()) {
                ls lsVar = lwVar.h;
                if (i == 5 && lsVar != null && (lsVar.n() instanceof TotalCaptureResult)) {
                    xq4.c(3, "Camera2CaptureRequestBuilder");
                    builderCreateCaptureRequest = cameraDevice.createReprocessCaptureRequest((TotalCaptureResult) lsVar.n());
                } else {
                    xq4.c(3, "Camera2CaptureRequestBuilder");
                    if (i == 5) {
                        builderCreateCaptureRequest = cameraDevice.createCaptureRequest(z ? 1 : 2);
                    } else {
                        builderCreateCaptureRequest = cameraDevice.createCaptureRequest(i);
                    }
                }
                b(builderCreateCaptureRequest, i, phVar);
                bi biVar = lw.k;
                Object objF = fj.f;
                try {
                    objF = gs1Var.f(biVar);
                } catch (IllegalArgumentException unused) {
                }
                Range range = (Range) objF;
                Objects.requireNonNull(range);
                Object objF2 = fj.f;
                if (!range.equals(objF2)) {
                    CaptureRequest.Key key = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
                    try {
                        objF2 = gs1Var.f(lw.k);
                    } catch (IllegalArgumentException unused2) {
                    }
                    Range range2 = (Range) objF2;
                    Objects.requireNonNull(range2);
                    builderCreateCaptureRequest.set(key, range2);
                }
                int i2 = 0;
                if (lwVar.b() == 1 || lwVar.c() == 1) {
                    builderCreateCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
                } else if (lwVar.b() == 2) {
                    builderCreateCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 2);
                } else if (lwVar.c() == 2) {
                    builderCreateCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
                }
                bi biVar2 = lw.i;
                if (treeMap.containsKey(biVar2)) {
                    builderCreateCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, (Integer) gs1Var.f(biVar2));
                }
                bi biVar3 = lw.j;
                if (treeMap.containsKey(biVar3)) {
                    builderCreateCaptureRequest.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) gs1Var.f(biVar3)).byteValue()));
                }
                a(builderCreateCaptureRequest, gs1Var);
                int size = arrayList2.size();
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    builderCreateCaptureRequest.addTarget((Surface) obj);
                }
                builderCreateCaptureRequest.setTag(lwVar.g);
                return builderCreateCaptureRequest.build();
            }
        }
        return null;
    }

    public static CaptureRequest d(lw lwVar, CameraDevice cameraDevice, ph phVar) throws CameraAccessException {
        if (cameraDevice == null) {
            return null;
        }
        int i = lwVar.c;
        xq4.c(3, "Camera2CaptureRequestBuilder");
        CaptureRequest.Builder builderCreateCaptureRequest = cameraDevice.createCaptureRequest(i);
        b(builderCreateCaptureRequest, i, phVar);
        a(builderCreateCaptureRequest, lwVar.b);
        return builderCreateCaptureRequest.build();
    }

    public static String e(mu3 mu3Var) {
        Iterator it = mu3Var.iterator();
        float fO = 0.0f;
        String strP = "und";
        while (it.hasNext()) {
            of3 of3Var = (of3) it.next();
            if (fO < of3Var.o()) {
                fO = of3Var.o();
                strP = of3Var.p();
            }
        }
        return strP;
    }
}
