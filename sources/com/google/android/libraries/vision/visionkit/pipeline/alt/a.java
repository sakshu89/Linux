package com.google.android.libraries.vision.visionkit.pipeline.alt;

import android.graphics.Bitmap;
import android.util.Log;
import defpackage.ak1;
import defpackage.am3;
import defpackage.bv3;
import defpackage.c10;
import defpackage.fg4;
import defpackage.ge;
import defpackage.il3;
import defpackage.np3;
import defpackage.og;
import defpackage.pp3;
import defpackage.pu3;
import defpackage.ul3;
import defpackage.ut3;
import defpackage.ze3;
import defpackage.zt3;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public final c10 a;
    public final ze3 b;
    public long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final ut3 h;

    public a(il3 il3Var) {
        ut3 ut3VarD;
        ut3 ut3Var = ut3.b;
        if (ut3Var == null) {
            synchronized (ut3.class) {
                try {
                    ut3VarD = ut3.b;
                    if (ut3VarD == null) {
                        bv3 bv3Var = bv3.c;
                        ut3VarD = zt3.d();
                        ut3.b = ut3VarD;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ut3Var = ut3VarD;
        }
        if (ut3Var == null) {
            bv3 bv3Var2 = bv3.c;
            ut3Var = ut3.c;
        }
        if (il3Var.t()) {
            this.b = new ak1(21);
        } else if (il3Var.s()) {
            this.b = new NativePipelineImpl(this, this, this, ut3Var);
        } else {
            NativePipelineImpl nativePipelineImpl = new NativePipelineImpl(this, this, this, ut3Var);
            System.loadLibrary("mlkit_google_ocr_pipeline");
            this.b = nativePipelineImpl;
        }
        if (il3Var.u()) {
            this.a = new c10(il3Var.o());
        } else {
            this.a = new c10(10);
        }
        this.h = ut3Var;
        long jInitializeFrameManager = this.b.initializeFrameManager();
        this.d = jInitializeFrameManager;
        long jInitializeFrameBufferReleaseCallback = this.b.initializeFrameBufferReleaseCallback(jInitializeFrameManager);
        this.e = jInitializeFrameBufferReleaseCallback;
        long jInitializeResultsCallback = this.b.initializeResultsCallback();
        this.f = jInitializeResultsCallback;
        long jInitializeIsolationCallback = this.b.initializeIsolationCallback();
        this.g = jInitializeIsolationCallback;
        this.c = this.b.initialize(il3Var.b(), jInitializeFrameBufferReleaseCallback, jInitializeResultsCallback, jInitializeIsolationCallback, 0L, 0L);
    }

    public final pp3 a(ge geVar) {
        if (this.c == 0) {
            og.n("Pipeline has been closed or was not initialized");
            return null;
        }
        c10 c10Var = this.a;
        long j = geVar.a;
        synchronized (c10Var) {
            if (((HashMap) c10Var.b).size() == c10Var.a) {
                String str = "Buffer is full. Drop frame " + j;
                if (Log.isLoggable("VisionKit", 5)) {
                    Log.w("VisionKit", fg4.a(c10Var, str));
                }
            } else {
                ((HashMap) c10Var.b).put(Long.valueOf(j), geVar);
                ze3 ze3Var = this.b;
                long j2 = this.c;
                long j3 = this.d;
                long j4 = geVar.a;
                byte[] bArr = (byte[]) geVar.c;
                ul3 ul3Var = (ul3) geVar.d;
                byte[] bArrProcess = ze3Var.process(j2, j3, j4, bArr, ul3Var.a, ul3Var.b, 1, geVar.b - 1);
                if (bArrProcess != null) {
                    try {
                        return pp3.d(am3.p(bArrProcess, this.h));
                    } catch (pu3 e) {
                        throw new IllegalStateException("Could not parse results", e);
                    }
                }
            }
        }
        return np3.a;
    }

    public final pp3 b(long j, Bitmap bitmap, int i) {
        if (this.c == 0) {
            og.n("Pipeline has been closed or was not initialized");
            return null;
        }
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            og.i("Unsupported bitmap config ".concat(String.valueOf(bitmap.getConfig())));
            return null;
        }
        byte[] bArrProcessBitmap = this.b.processBitmap(this.c, j, bitmap, bitmap.getWidth(), bitmap.getHeight(), 0, i - 1);
        if (bArrProcessBitmap == null) {
            return np3.a;
        }
        try {
            return pp3.d(am3.p(bArrProcessBitmap, this.h));
        } catch (pu3 e) {
            throw new IllegalStateException("Could not parse results", e);
        }
    }

    public final pp3 c(long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.c == 0) {
            og.n("Pipeline has been closed or was not initialized");
            return null;
        }
        if (!byteBuffer.isDirect() || !byteBuffer2.isDirect() || !byteBuffer3.isDirect()) {
            og.n("Byte buffers are not direct.");
            return null;
        }
        byte[] bArrProcessYuvFrame = this.b.processYuvFrame(this.c, j, byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3, i4, i5, i6 - 1);
        if (bArrProcessYuvFrame == null) {
            return np3.a;
        }
        try {
            return pp3.d(am3.p(bArrProcessYuvFrame, this.h));
        } catch (pu3 e) {
            throw new IllegalStateException("Could not parse results", e);
        }
    }
}
