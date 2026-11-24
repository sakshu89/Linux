package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sw extends xu2 {
    public final /* synthetic */ int a;
    public final Object b;

    public sw(List list, int i) {
        this.a = i;
        switch (i) {
            case 2:
                ArrayList arrayList = new ArrayList();
                this.b = arrayList;
                arrayList.addAll(list);
                break;
            default:
                this.b = list.isEmpty() ? new ws() : list.size() == 1 ? (CameraCaptureSession.StateCallback) list.get(0) : new vs(list);
                break;
        }
    }

    @Override // defpackage.xu2
    public void a(bv2 bv2Var) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 1:
                ((CameraCaptureSession.StateCallback) obj).onActive((CameraCaptureSession) ((l11) bv2Var.r().a).b);
                break;
            case 2:
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    ((xu2) obj2).a(bv2Var);
                }
                break;
        }
    }

    @Override // defpackage.xu2
    public void b(bv2 bv2Var) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 1:
                ((CameraCaptureSession.StateCallback) obj).onCaptureQueueEmpty((CameraCaptureSession) ((l11) bv2Var.r().a).b);
                break;
            case 2:
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    ((xu2) obj2).b(bv2Var);
                }
                break;
        }
    }

    @Override // defpackage.xu2
    public void c(bv2 bv2Var) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 1:
                ((CameraCaptureSession.StateCallback) obj).onClosed((CameraCaptureSession) ((l11) bv2Var.r().a).b);
                break;
            case 2:
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    ((xu2) obj2).c(bv2Var);
                }
                break;
        }
    }

    @Override // defpackage.xu2
    public final void d(bv2 bv2Var) {
        switch (this.a) {
            case 0:
                synchronized (((tw) this.b).a) {
                    try {
                        switch (cq.x(((tw) this.b).i)) {
                            case 0:
                            case 1:
                            case 2:
                            case 4:
                                throw new IllegalStateException("onConfigureFailed() should not be possible in state: ".concat(cq.z(((tw) this.b).i)));
                            case 3:
                            case 5:
                            case 6:
                                ((tw) this.b).d();
                                break;
                            case 7:
                                xq4.c(3, "CaptureSession");
                                break;
                        }
                        xq4.a("CaptureSession", "CameraCaptureSession.onConfigureFailed() ".concat(cq.z(((tw) this.b).i)));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
                ((CameraCaptureSession.StateCallback) this.b).onConfigureFailed((CameraCaptureSession) ((l11) bv2Var.r().a).b);
                return;
            default:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((xu2) obj).d(bv2Var);
                }
                return;
        }
    }

    @Override // defpackage.xu2
    public final void e(bv2 bv2Var) {
        switch (this.a) {
            case 0:
                synchronized (((tw) this.b).a) {
                    try {
                        switch (cq.x(((tw) this.b).i)) {
                            case 0:
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                                throw new IllegalStateException("onConfigured() should not be possible in state: ".concat(cq.z(((tw) this.b).i)));
                            case 3:
                                tw twVar = (tw) this.b;
                                twVar.i = 5;
                                twVar.e = bv2Var;
                                xq4.c(3, "CaptureSession");
                                tw twVar2 = (tw) this.b;
                                twVar2.j(twVar2.f);
                                tw twVar3 = (tw) this.b;
                                twVar3.o.d().a(new s7(13, twVar3), xg4.a());
                                break;
                            case 5:
                                ((tw) this.b).e = bv2Var;
                                break;
                            case 6:
                                bv2Var.j();
                                break;
                        }
                        xq4.c(3, "CaptureSession");
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
                ((CameraCaptureSession.StateCallback) this.b).onConfigured((CameraCaptureSession) ((l11) bv2Var.r().a).b);
                return;
            default:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((xu2) obj).e(bv2Var);
                }
                return;
        }
    }

    @Override // defpackage.xu2
    public final void f(bv2 bv2Var) {
        switch (this.a) {
            case 0:
                synchronized (((tw) this.b).a) {
                    try {
                        if (cq.x(((tw) this.b).i) == 0) {
                            throw new IllegalStateException("onReady() should not be possible in state: ".concat(cq.z(((tw) this.b).i)));
                        }
                        xq4.c(3, "CaptureSession");
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
                ((CameraCaptureSession.StateCallback) this.b).onReady((CameraCaptureSession) ((l11) bv2Var.r().a).b);
                return;
            default:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((xu2) obj).f(bv2Var);
                }
                return;
        }
    }

    @Override // defpackage.xu2
    public final void g(bv2 bv2Var) {
        switch (this.a) {
            case 0:
                synchronized (((tw) this.b).a) {
                    try {
                        int i = ((tw) this.b).i;
                        if (i == 1) {
                            throw new IllegalStateException("onSessionFinished() should not be possible in state: ".concat(cq.z(i)));
                        }
                        xq4.c(3, "CaptureSession");
                        ((tw) this.b).d();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
                return;
            default:
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((xu2) obj).g(bv2Var);
                }
                return;
        }
    }

    @Override // defpackage.xu2
    public void h(bv2 bv2Var, Surface surface) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 1:
                ((CameraCaptureSession.StateCallback) obj).onSurfacePrepared((CameraCaptureSession) ((l11) bv2Var.r().a).b, surface);
                break;
            case 2:
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    ((xu2) obj2).h(bv2Var, surface);
                }
                break;
        }
    }

    private final void i(bv2 bv2Var) {
    }

    public sw(tw twVar) {
        this.a = 0;
        this.b = twVar;
    }
}
