package defpackage;

import android.hardware.camera2.CameraDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mt extends CameraDevice.StateCallback {
    public final /* synthetic */ int a;
    public final Object b;

    public mt(ArrayList arrayList) {
        int i = 0;
        this.a = 0;
        this.b = new ArrayList();
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            CameraDevice.StateCallback stateCallback = (CameraDevice.StateCallback) obj;
            if (!(stateCallback instanceof nt)) {
                ((ArrayList) this.b).add(stateCallback);
            }
        }
    }

    public void a() {
        ArrayList arrayListI;
        synchronized (((lj1) this.b).c) {
            arrayListI = ((lj1) this.b).i();
            ((LinkedHashSet) ((lj1) this.b).f).clear();
            ((LinkedHashSet) ((lj1) this.b).d).clear();
            ((LinkedHashSet) ((lj1) this.b).e).clear();
        }
        int size = arrayListI.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListI.get(i);
            i++;
            bv2 bv2Var = (bv2) obj;
            synchronized (bv2Var.a) {
                try {
                    List list = bv2Var.k;
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((ob0) it.next()).b();
                        }
                        bv2Var.k = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            bv2Var.u.i();
        }
    }

    public void b() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (((lj1) this.b).c) {
            linkedHashSet.addAll((LinkedHashSet) ((lj1) this.b).f);
            linkedHashSet.addAll((LinkedHashSet) ((lj1) this.b).d);
        }
        ((ch2) ((lj1) this.b).b).execute(new s7(14, linkedHashSet));
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((CameraDevice.StateCallback) obj).onClosed(cameraDevice);
                }
                break;
            default:
                b();
                a();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((CameraDevice.StateCallback) obj).onDisconnected(cameraDevice);
                }
                break;
            default:
                b();
                a();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((CameraDevice.StateCallback) obj).onError(cameraDevice, i);
                }
                return;
            default:
                b();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                synchronized (((lj1) this.b).c) {
                    linkedHashSet.addAll((LinkedHashSet) ((lj1) this.b).f);
                    linkedHashSet.addAll((LinkedHashSet) ((lj1) this.b).d);
                    break;
                }
                ((ch2) ((lj1) this.b).b).execute(new ne(linkedHashSet, i, 2));
                a();
                return;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((CameraDevice.StateCallback) obj).onOpened(cameraDevice);
                }
                break;
        }
    }

    private final void c(CameraDevice cameraDevice) {
    }

    public mt(lj1 lj1Var) {
        this.a = 1;
        this.b = lj1Var;
    }
}
