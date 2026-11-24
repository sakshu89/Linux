package defpackage;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bq1 {
    public final Runnable a;
    public final hg b = new hg();
    public vp1 c;
    public final OnBackInvokedCallback d;
    public OnBackInvokedDispatcher e;
    public boolean f;
    public boolean g;

    public bq1(Runnable runnable) {
        this.a = runnable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            this.d = i >= 34 ? new yp1(new wp1(this, 0), new wp1(this, 1), new xp1(this, 0), new xp1(this, 1)) : new me(new xp1(this, 2), 1);
        }
    }

    public final void a() {
        Object objPrevious;
        if (this.c == null) {
            hg hgVar = this.b;
            ListIterator<E> listIterator = hgVar.listIterator(hgVar.size());
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!((vp1) objPrevious).a);
        }
        this.c = null;
    }

    public final void b() {
        Object objPrevious;
        vp1 vp1Var = this.c;
        if (vp1Var == null) {
            hg hgVar = this.b;
            ListIterator listIterator = hgVar.listIterator(hgVar.a());
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!((vp1) objPrevious).a);
            vp1Var = (vp1) objPrevious;
        }
        this.c = null;
        if (vp1Var != null) {
            vp1Var.a();
        } else {
            this.a.run();
        }
    }

    public final void c(boolean z) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.e;
        if (onBackInvokedDispatcher == null || (onBackInvokedCallback = this.d) == null) {
            return;
        }
        if (z && !this.f) {
            f3.i(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f = true;
        } else {
            if (z || !this.f) {
                return;
            }
            f3.j(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f = false;
        }
    }

    public final void d() {
        boolean z = this.g;
        boolean z2 = false;
        hg hgVar = this.b;
        if (hgVar == null || !hgVar.isEmpty()) {
            Iterator it = hgVar.iterator();
            while (it.hasNext()) {
                if (((vp1) it.next()).a) {
                    z2 = true;
                    break;
                }
            }
        }
        this.g = z2;
        if (z2 == z || Build.VERSION.SDK_INT < 33) {
            return;
        }
        c(z2);
    }
}
