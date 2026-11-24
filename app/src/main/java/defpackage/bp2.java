package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bp2 extends VoiceInteractionSession {
    @Override // android.service.voice.VoiceInteractionSession
    public final void onShow(Bundle bundle, int i) {
        super.onShow(bundle, i);
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.project.sonic.extra.FROM_ENABLED_WAKE")) {
            z = true;
        }
        try {
            l11 l11Var = vg.a;
            Context context = getContext();
            context.getClass();
            startAssistantActivity(vg.a(context, z));
        } catch (Exception e) {
            Log.e("SonicVoiceSession", "Failed to launch MainActivity on assist", e);
        }
        hide();
    }
}
