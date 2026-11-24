package defpackage;

import android.util.ArrayMap;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hq extends es {
    public final /* synthetic */ int a = 0;
    public Object b;
    public Object c;

    public hq(tp tpVar, ut utVar) {
        this.b = tpVar;
        this.c = utVar;
    }

    @Override // defpackage.es
    public void a(int i) {
        switch (this.a) {
            case 0:
                for (es esVar : (HashSet) this.b) {
                    try {
                        ((Executor) ((ArrayMap) this.c).get(esVar)).execute(new ne(esVar, i, 1));
                    } catch (RejectedExecutionException e) {
                        xq4.b("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCancelled.", e);
                    }
                }
                break;
        }
    }

    @Override // defpackage.es
    public final void b(int i, ls lsVar) {
        switch (this.a) {
            case 0:
                for (es esVar : (HashSet) this.b) {
                    try {
                        ((Executor) ((ArrayMap) this.c).get(esVar)).execute(new gq(i, 1, esVar, lsVar));
                    } catch (RejectedExecutionException e) {
                        xq4.b("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCompleted.", e);
                    }
                }
                break;
            default:
                ((tp) this.b).a(null);
                ((ut) this.c).k(this);
                break;
        }
    }

    @Override // defpackage.es
    public void c(int i, el1 el1Var) {
        switch (this.a) {
            case 0:
                for (es esVar : (HashSet) this.b) {
                    try {
                        ((Executor) ((ArrayMap) this.c).get(esVar)).execute(new gq(i, 0, esVar, el1Var));
                    } catch (RejectedExecutionException e) {
                        xq4.b("Camera2CameraControlImp", "Executor rejected to invoke onCaptureFailed.", e);
                    }
                }
                break;
        }
    }

    public /* synthetic */ hq() {
    }
}
