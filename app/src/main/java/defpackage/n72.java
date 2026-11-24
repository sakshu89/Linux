package defpackage;

import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n72 {
    public final HashSet a = new HashSet();

    public final void a() {
        if (pc4.a == null) {
            pc4.a = Looper.getMainLooper().getThread();
        }
        if (Thread.currentThread() != pc4.a) {
            og.n("Must be called on the Main thread.");
            return;
        }
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            dk0.t();
        }
    }
}
