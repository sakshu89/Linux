package defpackage;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l10 implements ViewTreeObserver.OnDrawListener, Runnable, Executor {
    public final long a = SystemClock.uptimeMillis() + 10000;
    public Runnable b;
    public boolean c;
    public final /* synthetic */ n10 e;

    public l10(n10 n10Var) {
        this.e = n10Var;
    }

    public final void a(View view) {
        if (this.c) {
            return;
        }
        this.c = true;
        view.getViewTreeObserver().addOnDrawListener(this);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        this.b = runnable;
        View decorView = this.e.getWindow().getDecorView();
        decorView.getClass();
        if (!this.c) {
            decorView.postOnAnimation(new s7(15, this));
        } else if (g31.a(Looper.myLooper(), Looper.getMainLooper())) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z;
        Runnable runnable = this.b;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.a) {
                this.c = false;
                this.e.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.b = null;
        eq0 eq0Var = (eq0) this.e.j.getValue();
        synchronized (eq0Var.a) {
            z = eq0Var.b;
        }
        if (z) {
            this.c = false;
            this.e.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
