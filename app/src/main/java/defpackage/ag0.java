package defpackage;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ag0 extends qq1 {
    public final qs4 H;
    public final qs4 X;
    public int w = -1;
    public int x = -1;

    public ag0(qs4 qs4Var, qs4 qs4Var2) {
        this.H = qs4Var;
        this.X = qs4Var2;
    }

    @Override // defpackage.qq1
    public final ji m(ig0 ig0Var) {
        Map map = Collections.EMPTY_MAP;
        ji jiVarM = super.m(ig0Var);
        this.w = ur0.h();
        this.x = ur0.h();
        return jiVarM;
    }

    public final void u(long j, Surface surface, xt2 xt2Var, SurfaceTexture surfaceTexture, SurfaceTexture surfaceTexture2) {
        ur0.d((AtomicBoolean) this.c, true);
        ur0.c((Thread) this.f);
        HashMap map = (HashMap) this.e;
        hh1.e("The surface is not registered.", map.containsKey(surface));
        vi viVarC = (vi) map.get(surface);
        Objects.requireNonNull(viVarC);
        if (viVarC == ur0.j) {
            viVarC = c(surface);
            if (viVarC == null) {
                return;
            } else {
                map.put(surface, viVarC);
            }
        }
        vi viVar = viVarC;
        EGLSurface eGLSurface = viVar.a;
        if (surface != ((Surface) this.s)) {
            o(eGLSurface);
            this.s = surface;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        v(viVar, xt2Var, surfaceTexture, this.H, this.w);
        v(viVar, xt2Var, surfaceTexture2, this.X, this.x);
        EGLExt.eglPresentationTimeANDROID((EGLDisplay) this.i, eGLSurface, j);
        if (EGL14.eglSwapBuffers((EGLDisplay) this.i, eGLSurface)) {
            return;
        }
        xq4.d("DualOpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        r(surface, false);
    }

    public final void v(vi viVar, xt2 xt2Var, SurfaceTexture surfaceTexture, qs4 qs4Var, int i) {
        t(i);
        int i2 = viVar.b;
        int i3 = viVar.c;
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glScissor(0, 0, i2, i3);
        float[] fArr = new float[16];
        surfaceTexture.getTransformMatrix(fArr);
        float[] fArr2 = new float[16];
        Matrix.multiplyMM(fArr2, 0, fArr, 0, xt2Var.f, 0);
        sr0 sr0Var = (sr0) this.u;
        sr0Var.getClass();
        if (sr0Var instanceof tr0) {
            GLES20.glUniformMatrix4fv(((tr0) sr0Var).f, 1, false, fArr2, 0);
            ur0.b("glUniformMatrix4fv");
        }
        qs4Var.getClass();
        Size size = new Size((int) (i2 * 1.0f), (int) (i3 * 1.0f));
        Size size2 = new Size(i2, i3);
        float[] fArr3 = new float[16];
        Matrix.setIdentityM(fArr3, 0);
        float[] fArr4 = new float[16];
        Matrix.setIdentityM(fArr4, 0);
        float[] fArr5 = new float[16];
        Matrix.setIdentityM(fArr5, 0);
        Matrix.scaleM(fArr3, 0, size.getWidth() / size2.getWidth(), size.getHeight() / size2.getHeight(), 1.0f);
        Matrix.translateM(fArr4, 0, 0.0f, 0.0f, 0.0f);
        Matrix.multiplyMM(fArr5, 0, fArr3, 0, fArr4, 0);
        GLES20.glUniformMatrix4fv(sr0Var.b, 1, false, fArr5, 0);
        ur0.b("glUniformMatrix4fv");
        GLES20.glUniform1f(sr0Var.c, 1.0f);
        ur0.b("glUniform1f");
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 771);
        GLES20.glDrawArrays(5, 0, 4);
        ur0.b("glDrawArrays");
        GLES20.glDisable(3042);
    }
}
