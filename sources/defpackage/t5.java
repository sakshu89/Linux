package defpackage;

import android.os.Trace;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t5 implements Runnable {
    public static final t5 b = new t5(0);
    public final /* synthetic */ int a;

    public t5(py0 py0Var, int i) {
        this.a = 1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                int i = AlarmManagerSchedulerBroadcastReceiver.a;
                return;
            case 1:
                return;
            case 2:
                try {
                    int i2 = s13.a;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (oh0.d()) {
                        oh0.a().e();
                        break;
                    }
                    return;
                } finally {
                    int i3 = s13.a;
                    Trace.endSection();
                }
            default:
                return;
        }
    }

    public /* synthetic */ t5(int i) {
        this.a = i;
    }

    private final void a() {
    }

    private final void b() {
    }
}
