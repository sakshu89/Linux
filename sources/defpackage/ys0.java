package defpackage;

import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ys0 extends AudioManager.AudioRecordingCallback {
    public final /* synthetic */ mt0 a;
    public final /* synthetic */ zc1 b;

    public ys0(mt0 mt0Var, zc1 zc1Var) {
        this.a = mt0Var;
        this.b = zc1Var;
    }

    @Override // android.media.AudioManager.AudioRecordingCallback
    public final void onRecordingConfigChanged(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((AudioRecordingConfiguration) it.next()).isClientSilenced()) {
                this.a.j.f(this.b, ad1.b);
                return;
            }
        }
    }
}
