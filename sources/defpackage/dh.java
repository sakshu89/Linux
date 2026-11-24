package defpackage;

import android.os.Process;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dh extends Thread {
    public final /* synthetic */ int a = 0;

    public /* synthetic */ dh(String str) {
        super(str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                break;
            default:
                Process.setThreadPriority(19);
                synchronized (this) {
                    while (true) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
                break;
        }
        while (true) {
            try {
                ReentrantLock reentrantLock = gh.h;
                reentrantLock.lock();
                try {
                    gh ghVarB = ue4.b();
                    if (ghVarB == gh.l) {
                        gh.l = null;
                        return;
                    } else {
                        reentrantLock.unlock();
                        if (ghVarB != null) {
                            ghVarB.k();
                        }
                    }
                } finally {
                    reentrantLock.unlock();
                }
            } catch (InterruptedException unused2) {
            }
        }
    }

    public /* synthetic */ dh(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }
}
