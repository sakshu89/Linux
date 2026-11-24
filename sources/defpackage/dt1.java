package defpackage;

import android.content.Context;
import android.provider.Settings;
import android.view.WindowManager;
import com.ibm.icu.lang.UCharacter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dt1 {
    public final Context a;
    public final bh b;
    public final WindowManager c;
    public zg0 d;
    public rn2 e;

    public dt1(Context context, bh bhVar) {
        bhVar.getClass();
        this.a = context;
        this.b = bhVar;
        Object systemService = context.getSystemService("window");
        systemService.getClass();
        this.c = (WindowManager) systemService;
    }

    public final jb a() {
        jb jbVar = new jb(this.d != null, this.e);
        b(false);
        return jbVar;
    }

    public final void b(boolean z) {
        zg0 zg0Var = this.d;
        if (zg0Var != null) {
            try {
                zg0Var.e.cancel();
                this.c.removeView(zg0Var);
            } catch (Throwable unused) {
            }
        }
        this.d = null;
        if (z) {
            this.e = null;
        }
    }

    public final void c(jb jbVar) {
        jbVar.getClass();
        rn2 rn2Var = (rn2) jbVar.b;
        if (jbVar.a && rn2Var != null && ((ah) this.b.a.getValue()) == ah.a) {
            d(rn2Var);
        }
    }

    public final void d(rn2 rn2Var) {
        Object h72Var;
        rn2Var.getClass();
        Context context = this.a;
        if (!Settings.canDrawOverlays(context) || ((ah) this.b.a.getValue()) != ah.a) {
            b(true);
            return;
        }
        zg0 zg0Var = this.d;
        if (zg0Var == null) {
            zg0 zg0Var2 = new zg0(context);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2038, UCharacter.UnicodeBlock.ZANABAZAR_SQUARE_ID, -3);
            layoutParams.gravity = 17;
            try {
                this.c.addView(zg0Var2, layoutParams);
                zg0Var2.e.start();
                h72Var = zg0Var2;
            } catch (Throwable th) {
                h72Var = new h72(th);
            }
            boolean z = h72Var instanceof h72;
            Object obj = h72Var;
            if (z) {
                obj = null;
            }
            zg0Var = (zg0) obj;
            this.d = zg0Var;
            if (zg0Var == null) {
                return;
            }
        }
        if (zg0Var.b != rn2Var) {
            zg0Var.b = rn2Var;
            zg0Var.e.setDuration(rn2Var.a() ? 500L : 1000L);
            zg0Var.invalidate();
        }
        this.e = rn2Var;
    }
}
