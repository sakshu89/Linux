package com.google.android.libraries.vision.visionkit.pipeline;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidAssetUtil {
    public static synchronized void a(Context context) {
        nativeInitializeAssetManager(context, context.getCacheDir().getAbsolutePath());
    }

    private static native boolean nativeInitializeAssetManager(Context context, String str);
}
