package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oc extends ThreadLocal {
    public final /* synthetic */ int a;

    public /* synthetic */ oc(int i) {
        this.a = i;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.a) {
            case 0:
                Choreographer choreographer = Choreographer.getInstance();
                Looper looperMyLooper = Looper.myLooper();
                if (looperMyLooper != null) {
                    qc qcVar = new qc(choreographer, go4.a(looperMyLooper));
                    return pl4.c(qcVar, qcVar.u);
                }
                og.n("no Looper on this thread");
                return null;
            case 1:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(z53.e);
                return simpleDateFormat;
            case 2:
                return new SimpleDateFormat("yyyy:MM:dd", Locale.US);
            case 3:
                return new SimpleDateFormat("HH:mm:ss", Locale.US);
            case 4:
                return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
            case 5:
                return new Random();
            case 6:
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    return xg4.c();
                }
                if (Looper.myLooper() != null) {
                    return new xv0(new Handler(Looper.myLooper()));
                }
                return null;
            default:
                return 0L;
        }
    }
}
