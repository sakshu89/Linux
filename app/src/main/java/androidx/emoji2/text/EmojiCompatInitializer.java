package androidx.emoji2.text;

import android.content.Context;
import androidx.lifecycle.ProcessLifecycleInitializer;
import defpackage.ap0;
import defpackage.kf;
import defpackage.ob1;
import defpackage.oh0;
import defpackage.ph0;
import defpackage.qb1;
import defpackage.w01;
import defpackage.wf;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements w01 {
    @Override // defpackage.w01
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // defpackage.w01
    public final Object b(Context context) {
        Object objK;
        wf wfVar = new wf();
        wfVar.a = context.getApplicationContext();
        ap0 ap0Var = new ap0(wfVar);
        ap0Var.b = 1;
        if (oh0.k == null) {
            synchronized (oh0.j) {
                try {
                    if (oh0.k == null) {
                        oh0.k = new oh0(ap0Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        kf kfVarO = kf.o(context);
        kfVarO.getClass();
        synchronized (kf.i) {
            try {
                objK = ((HashMap) kfVarO.b).get(ProcessLifecycleInitializer.class);
                if (objK == null) {
                    objK = kfVarO.k(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        qb1 qb1VarF = ((ob1) objK).f();
        qb1VarF.a(new ph0(this, qb1VarF));
        return Boolean.TRUE;
    }
}
