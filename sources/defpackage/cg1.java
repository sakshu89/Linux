package defpackage;

import android.content.Intent;
import com.project.sonic.MainActivity;
import com.project.sonic.background.SonicVoiceService;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cg1 implements nm0, er0 {
    public final /* synthetic */ MainActivity a;

    public cg1(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    @Override // defpackage.er0
    public final rq0 a() {
        return new p4(2, 12, MainActivity.class, this.a, "handle", "handle(Lcom/project/sonic/ui/UiEffect;)Ljava/lang/Object;");
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof nm0) && (obj instanceof er0)) {
            return a().equals(((er0) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    @Override // defpackage.nm0
    public final Object n(Object obj, x50 x50Var) throws Exception {
        h43 h43Var = (h43) obj;
        Set set = MainActivity.m0;
        boolean zA = g31.a(h43Var, e43.a);
        MainActivity mainActivity = this.a;
        if (zA) {
            mainActivity.startService(new Intent(mainActivity, (Class<?>) SonicVoiceService.class).setAction("com.project.sonic.PAUSE_AMBIENT"));
        } else if (h43Var instanceof c43) {
            Intent intent = new Intent(mainActivity, (Class<?>) SonicVoiceService.class);
            c43 c43Var = (c43) h43Var;
            if (c43Var.a) {
                if (c43Var.b) {
                    intent.setAction("com.project.sonic.ACTIVATE_LIVE");
                }
                try {
                    mainActivity.startForegroundService(intent);
                } catch (Exception unused) {
                    mainActivity.w("Couldn't start Live audio. Check microphone permission.");
                }
            } else {
                mainActivity.startService(intent.setAction("com.project.sonic.STOP_AMBIENT"));
            }
        } else if (h43Var instanceof f43) {
            List list = ((f43) h43Var).a;
            if (!list.isEmpty()) {
                mainActivity.k0.x(list.toArray(new String[0]));
            }
        } else if (h43Var instanceof d43) {
            d43 d43Var = (d43) h43Var;
            mainActivity.u(d43Var.a, d43Var.b);
        } else {
            if (!(h43Var instanceof g43)) {
                dk0.l();
                return null;
            }
            mainActivity.w(((g43) h43Var).a);
        }
        return q43.a;
    }
}
