package defpackage;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.WindowInsetsAnimation;
import com.google.android.gms.common.api.Status;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cu2 implements ir0, wu2, bf2, cq1 {
    public final /* synthetic */ int a;
    public Object b;
    public Object c;

    public cu2(int i) {
        this.a = i;
        switch (i) {
            case 7:
                this.b = new pm1(new Reference[16]);
                this.c = new ReferenceQueue();
                break;
            case 11:
                this.b = Collections.synchronizedMap(new WeakHashMap());
                this.c = Collections.synchronizedMap(new WeakHashMap());
                break;
            case 12:
                mu0 mu0Var = mu0.d;
                this.b = new SparseIntArray();
                this.c = mu0Var;
                break;
            default:
                this.b = new el1(19);
                this.c = new tf1(16);
                break;
        }
    }

    @Override // defpackage.bf2
    public int a(int i) {
        do {
            i = ((ye) this.c).l(i);
            if (i == -1) {
                return -1;
            }
        } while (Character.isWhitespace(((CharSequence) this.b).charAt(i)));
        return i;
    }

    @Override // defpackage.wu2
    public Object b() {
        pi piVar = (pi) this.b;
        pj pjVar = (pj) this.c;
        l92 l92Var = (l92) piVar.c;
        l92Var.getClass();
        return (Iterable) l92Var.j(new q91(23, l92Var, pjVar));
    }

    @Override // defpackage.ir0
    public void c(Object obj) {
        switch (this.a) {
            case 0:
                ((s40) this.b).accept(new kj(0, (Surface) this.c));
                break;
            case 1:
                ((lv2) this.c).b.L();
                break;
            default:
                hh1.e("Unexpected result from SurfaceRequest. Surface was provided twice.", ((kj) obj).a != 3);
                xq4.c(3, "TextureViewImpl");
                ((SurfaceTexture) this.b).release();
                f03 f03Var = ((e03) this.c).a;
                if (f03Var.j != null) {
                    f03Var.j = null;
                }
                break;
        }
    }

    @Override // defpackage.bf2
    public int d(int i) {
        do {
            i = ((ye) this.c).j(i);
            if (i == -1) {
                return -1;
            }
        } while (Character.isWhitespace(((CharSequence) this.b).charAt(i - 1)));
        return i;
    }

    @Override // defpackage.bf2
    public int e(int i) {
        CharSequence charSequence = (CharSequence) this.b;
        do {
            i = ((ye) this.c).j(i);
            if (i == -1 || i == charSequence.length()) {
                return -1;
            }
        } while (Character.isWhitespace(charSequence.charAt(i)));
        return i;
    }

    @Override // defpackage.bf2
    public int f(int i) {
        do {
            i = ((ye) this.c).l(i);
            if (i == -1 || i == 0) {
                return -1;
            }
        } while (Character.isWhitespace(((CharSequence) this.b).charAt(i - 1)));
        return i;
    }

    public void g(boolean z, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.b)) {
            map = new HashMap((Map) this.b);
        }
        synchronized (((Map) this.c)) {
            map2 = new HashMap((Map) this.c);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                dk0.t();
                return;
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((iw2) entry2.getKey()).a(new qe(status));
            }
        }
    }

    @Override // defpackage.ir0
    public void i(Throwable th) {
        switch (this.a) {
            case 0:
                hh1.e("Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th, th instanceof du2);
                ((s40) this.b).accept(new kj(1, (Surface) this.c));
                return;
            case 1:
                lv2 lv2Var = (lv2) this.c;
                l11 l11Var = (l11) this.b;
                if (((j62) l11Var.c).g) {
                    return;
                }
                int iA = ((lw) ((ArrayList) l11Var.b).get(0)).a();
                boolean z = th instanceof ty0;
                cj cjVar = lv2Var.c;
                if (z) {
                    nj njVar = new nj(iA, (ty0) th);
                    cjVar.getClass();
                    vc4.b();
                    ((zh) cjVar.a).i.accept(njVar);
                } else {
                    nj njVar2 = new nj(iA, new ty0("Failed to submit capture request", th));
                    cjVar.getClass();
                    vc4.b();
                    ((zh) cjVar.a).i.accept(njVar2);
                }
                lv2Var.b.L();
                return;
            default:
                throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th);
        }
    }

    @Override // defpackage.cq1
    public void r(et4 et4Var) {
        ((Map) ((cu2) this.c).c).remove((iw2) this.b);
    }

    public String toString() {
        switch (this.a) {
            case 8:
                return "Bounds{lower=" + ((q11) this.b) + " upper=" + ((q11) this.c) + "}";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ cu2(int i, Object obj, Object obj2, boolean z) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    public /* synthetic */ cu2(int i, boolean z) {
        this.a = i;
    }

    public cu2(b13 b13Var) {
        this.a = 14;
        this.c = new i52();
        this.b = b13Var;
        fl4.l();
    }

    public cu2(Context context) {
        this.a = 16;
        this.c = new AtomicLong(-1L);
        this.b = new re3(context, re3.i, new pw2("mlkit:vision"), lu0.b);
    }

    public /* synthetic */ cu2(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public cu2(WindowInsetsAnimation.Bounds bounds) {
        this.a = 8;
        this.b = q11.c(bounds.getLowerBound());
        this.c = q11.c(bounds.getUpperBound());
    }
}
