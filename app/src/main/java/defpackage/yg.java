package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.project.sonic.voiceinteraction.SonicVoiceInteractionService;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yg {
    public final Context a;
    public final j5 b;
    public SonicVoiceInteractionService c;

    public yg(Context context, j5 j5Var) {
        j5Var.getClass();
        this.a = context;
        this.b = j5Var;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(y50 y50Var) {
        xg xgVar;
        if (y50Var instanceof xg) {
            xgVar = (xg) y50Var;
            int i = xgVar.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                xgVar.i = i - Integer.MIN_VALUE;
            } else {
                xgVar = new xg(this, y50Var);
            }
        } else {
            xgVar = new xg(this, y50Var);
        }
        Object objC = xgVar.e;
        int i2 = xgVar.i;
        boolean z = true;
        if (i2 == 0) {
            bz3.g(objC);
            xgVar.i = 1;
            objC = rn4.c(this.b.b, xgVar);
            t70 t70Var = t70.a;
            if (objC == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(objC);
        }
        if (!((g5) objC).c) {
            return Boolean.FALSE;
        }
        SonicVoiceInteractionService sonicVoiceInteractionService = this.c;
        if (sonicVoiceInteractionService != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean("com.project.sonic.extra.FROM_ENABLED_WAKE", true);
                sonicVoiceInteractionService.showSession(bundle, 0);
                return Boolean.TRUE;
            } catch (RuntimeException e) {
                new Integer(Log.w("SonicAssistant", "Assistant session is unavailable", e));
            }
        }
        try {
            Context context = this.a;
            context.startActivity(vg.a(context, true));
        } catch (RuntimeException e2) {
            Log.w("SonicAssistant", "Wake foreground handoff is unavailable", e2);
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
