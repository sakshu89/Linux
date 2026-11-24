package com.google.android.libraries.vision.visionkit.pipeline.alt;

import android.graphics.Bitmap;
import android.util.Log;
import defpackage.am3;
import defpackage.c10;
import defpackage.fg4;
import defpackage.pu3;
import defpackage.ut3;
import defpackage.ze3;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class NativePipelineImpl implements ze3 {
    public ut3 a;
    public a b;
    public a c;
    public a e;

    public NativePipelineImpl(a aVar, a aVar2, a aVar3, ut3 ut3Var) {
        this.b = aVar;
        this.c = aVar2;
        this.e = aVar3;
        this.a = ut3Var;
    }

    @Override // defpackage.ze3
    public final void a() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = null;
    }

    @Override // defpackage.ze3
    public native void close(long j, long j2, long j3, long j4, long j5);

    public void closeFileDescriptor(int i) {
        this.e.getClass();
        Log.w("VKP", "closeFileDescriptor called but is not available for this pipeline. Ignoring call.");
    }

    @Override // defpackage.ze3
    public native long initialize(byte[] bArr, long j, long j2, long j3, long j4, long j5);

    @Override // defpackage.ze3
    public native long initializeFrameBufferReleaseCallback(long j);

    @Override // defpackage.ze3
    public native long initializeFrameManager();

    @Override // defpackage.ze3
    public native long initializeIsolationCallback();

    @Override // defpackage.ze3
    public native long initializeResultsCallback();

    public void onReleaseAtTimestampUs(long j) {
        c10 c10Var = this.b.a;
        synchronized (c10Var) {
            ((HashMap) c10Var.b).remove(Long.valueOf(j));
        }
    }

    public void onResult(byte[] bArr) {
        try {
            am3 am3VarP = am3.p(bArr, this.a);
            a aVar = this.c;
            aVar.getClass();
            String strConcat = "Pipeline received results: ".concat(String.valueOf(am3VarP));
            if (Log.isLoggable("VisionKit", 4)) {
                fg4.a(aVar, strConcat);
            }
        } catch (pu3 e) {
            if (Log.isLoggable("VisionKit", 6)) {
                Log.e("VisionKit", "Error in result from JNI layer", e);
            }
        }
    }

    public int openFileDescriptor(String str) {
        this.e.getClass();
        Log.w("VKP", "openFileDescriptor called but is not available for this pipeline. Ignoring call.");
        return -1;
    }

    @Override // defpackage.ze3
    public native byte[] process(long j, long j2, long j3, byte[] bArr, int i, int i2, int i3, int i4);

    @Override // defpackage.ze3
    public native byte[] processBitmap(long j, long j2, Bitmap bitmap, int i, int i2, int i3, int i4);

    @Override // defpackage.ze3
    public native byte[] processYuvFrame(long j, long j2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6);

    @Override // defpackage.ze3
    public native void start(long j);

    @Override // defpackage.ze3
    public native boolean stop(long j);

    @Override // defpackage.ze3
    public native void waitUntilIdle(long j);
}
