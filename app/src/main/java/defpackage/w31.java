package defpackage;

import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w31 implements Executor {
    public static volatile w31 c;
    public final /* synthetic */ int a;
    public final Object b;

    public w31(int i) {
        this.a = i;
        switch (i) {
            case 2:
                we3 we3Var = new we3(Looper.getMainLooper());
                Looper.getMainLooper();
                this.b = we3Var;
                break;
            default:
                this.b = Executors.newFixedThreadPool(2, new pt(2));
                break;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.a) {
            case 0:
                ((ExecutorService) this.b).execute(runnable);
                break;
            case 1:
                ((Executor) this.b).execute(new w92(runnable, 0));
                break;
            default:
                ((we3) this.b).post(runnable);
                break;
        }
    }

    public w31(ExecutorService executorService) {
        this.a = 1;
        this.b = executorService;
    }
}
