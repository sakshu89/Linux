package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zo0 implements nh0 {
    public final Context a;
    public final yo0 b;
    public final qs4 c;
    public final Object d = new Object();
    public Handler e;
    public ThreadPoolExecutor f;
    public ThreadPoolExecutor g;
    public cn4 h;

    public zo0(Context context, yo0 yo0Var) {
        hh1.d(context, "Context cannot be null");
        this.a = context.getApplicationContext();
        this.b = yo0Var;
        this.c = ap0.d;
    }

    @Override // defpackage.nh0
    public final void a(cn4 cn4Var) {
        synchronized (this.d) {
            this.h = cn4Var;
        }
        synchronized (this.d) {
            try {
                if (this.h == null) {
                    return;
                }
                if (this.f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new o30("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.g = threadPoolExecutor;
                    this.f = threadPoolExecutor;
                }
                this.f.execute(new s7(21, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.d) {
            try {
                this.h = null;
                Handler handler = this.e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.e = null;
                ThreadPoolExecutor threadPoolExecutor = this.g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f = null;
                this.g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final pp0 c() {
        try {
            qs4 qs4Var = this.c;
            Context context = this.a;
            yo0 yo0Var = this.b;
            qs4Var.getClass();
            ArrayList arrayList = new ArrayList(1);
            Object obj = new Object[]{yo0Var}[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            c10 c10VarA = xo0.a(context, Collections.unmodifiableList(arrayList));
            int i = c10VarA.a;
            if (i != 0) {
                og.p(cq.h("fetchFonts failed (", i, ")"));
                return null;
            }
            pp0[] pp0VarArr = (pp0[]) ((List) c10VarA.b).get(0);
            if (pp0VarArr != null && pp0VarArr.length != 0) {
                return pp0VarArr[0];
            }
            og.p("fetchFonts failed (empty result)");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("provider not found", e);
        }
    }
}
