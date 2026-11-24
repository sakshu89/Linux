package com.project.sonic.voiceinteraction;

import android.content.Intent;
import android.speech.RecognitionService;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class SonicRecognitionService extends RecognitionService {
    @Override // android.speech.RecognitionService
    public final void onStartListening(Intent intent, RecognitionService.Callback callback) {
        if (callback != null) {
            try {
                callback.error(5);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.speech.RecognitionService
    public final void onCancel(RecognitionService.Callback callback) {
    }

    @Override // android.speech.RecognitionService
    public final void onStopListening(RecognitionService.Callback callback) {
    }
}
