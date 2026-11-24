package com.project.sonic.voiceinteraction;

import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.service.voice.VoiceInteractionSessionService;
import defpackage.bp2;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class SonicVoiceSessionService extends VoiceInteractionSessionService {
    @Override // android.service.voice.VoiceInteractionSessionService
    public final VoiceInteractionSession onNewSession(Bundle bundle) {
        return new bp2(this);
    }
}
