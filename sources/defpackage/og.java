package defpackage;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.ibm.icu.util.ICUException;
import java.util.ConcurrentModificationException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class og implements dr0, f02, zv, ae0, tg0 {
    public final /* synthetic */ int a;

    public /* synthetic */ og(int i) {
        this.a = i;
    }

    public static /* synthetic */ void d() {
        throw new ConcurrentModificationException();
    }

    public static /* synthetic */ void e(int i, StringBuilder sb) {
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void f(long j, String str) {
        throw new IllegalArgumentException((str + j).toString());
    }

    public static /* synthetic */ void g(Object obj) {
        throw new IllegalArgumentException(obj.toString());
    }

    public static /* synthetic */ void h(Object obj, String str) {
        throw new IllegalStateException((str + obj).toString());
    }

    public static /* synthetic */ void i(String str) {
        throw new IllegalArgumentException(str);
    }

    public static /* synthetic */ void j(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + obj4 + obj5);
    }

    public static /* synthetic */ void k() {
        throw new b10();
    }

    public static /* synthetic */ void l(long j, String str) {
        throw new IllegalArgumentException(str + j);
    }

    public static /* synthetic */ void m(Object obj) {
        throw new AssertionError(obj);
    }

    public static /* synthetic */ void n(String str) {
        throw new IllegalStateException(str);
    }

    public static /* synthetic */ void o(String str) {
        throw new IndexOutOfBoundsException(str);
    }

    public static /* synthetic */ void p(String str) {
        throw new RuntimeException(str);
    }

    public static /* synthetic */ void q(String str) {
        throw new ICUException(str);
    }

    @Override // defpackage.f02
    public void a(fu2 fu2Var) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(fu2Var.b.getWidth(), fu2Var.b.getHeight());
        surfaceTexture.detachFromGLContext();
        Surface surface = new Surface(surfaceTexture);
        fu2Var.a(surface, xg4.a(), new tu(0, surface, surfaceTexture));
    }

    @Override // defpackage.dr0
    public Object apply(Object obj) {
        switch (this.a) {
            case 9:
                return Boolean.TRUE;
            case 10:
                return null;
            case 11:
            default:
                return Boolean.FALSE;
            case 12:
                return Boolean.valueOf(((List) obj).contains(Boolean.TRUE));
        }
    }

    @Override // defpackage.ae0
    public double c(double d) {
        switch (this.a) {
            case 18:
                double d2 = d < 0.0d ? -d : d;
                return Math.copySign(d2 >= 0.0031308049535603718d ? (Math.pow(d2, 0.4166666666666667d) - 0.05213270142180095d) / 0.9478672985781991d : d2 / 0.07739938080495357d, d);
            case 19:
                double d3 = d < 0.0d ? -d : d;
                return Math.copySign(d3 >= 0.04045d ? Math.pow((0.9478672985781991d * d3) + 0.05213270142180095d, 2.4d) : d3 * 0.07739938080495357d, d);
            case 20:
                float[] fArr = d00.a;
                return d00.b(d00.c, d);
            case 21:
                float[] fArr2 = d00.a;
                return d00.a(d00.c, d);
            case 22:
                float[] fArr3 = d00.a;
                return d00.d(d00.d, d);
            default:
                float[] fArr4 = d00.a;
                return d00.c(d00.d, d);
        }
    }

    @Override // defpackage.zv
    public void cancel() {
    }

    @Override // defpackage.tg0
    public float b(float f) {
        return f;
    }
}
