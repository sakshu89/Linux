package defpackage;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class we3 extends Handler {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public we3(Looper looper, int i) {
        super(looper);
        switch (i) {
            case 3:
                super(looper);
                Looper.getMainLooper();
                break;
            default:
                Looper.getMainLooper();
                break;
        }
    }
}
