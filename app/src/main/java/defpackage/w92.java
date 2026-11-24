package defpackage;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w92 implements Runnable {
    public final /* synthetic */ int a;
    public final Runnable b;

    public /* synthetic */ w92(Runnable runnable, int i) {
        this.a = i;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        Runnable runnable = this.b;
        switch (i) {
            case 0:
                try {
                    runnable.run();
                } catch (Exception e) {
                    Log.e("TransportRuntime.".concat("Executor"), "Background execution failure.", e);
                    return;
                }
                break;
            case 1:
                runnable.run();
                break;
            case 2:
                Deque deque = (Deque) yj1.b.get();
                jg1.d(deque);
                deque.add(runnable);
                if (deque.size() <= 1) {
                    do {
                        runnable.run();
                        deque.removeFirst();
                        runnable = (Runnable) deque.peekFirst();
                    } while (runnable != null);
                }
                break;
            default:
                yj1.b.set(new ArrayDeque());
                runnable.run();
                break;
        }
    }
}
