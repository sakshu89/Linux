package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import defpackage.a12;
import defpackage.db1;
import defpackage.ii0;
import defpackage.jb1;
import defpackage.kb1;
import defpackage.kf;
import defpackage.og;
import defpackage.w01;
import defpackage.z02;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements w01 {
    @Override // defpackage.w01
    public final List a() {
        return ii0.a;
    }

    @Override // defpackage.w01
    public final Object b(Context context) {
        context.getClass();
        kf kfVarO = kf.o(context);
        kfVarO.getClass();
        if (!((HashSet) kfVarO.c).contains(ProcessLifecycleInitializer.class)) {
            og.n("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
            return null;
        }
        if (!kb1.a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            applicationContext.getClass();
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new jb1());
        }
        a12 a12Var = a12.n;
        a12Var.getClass();
        a12Var.f = new Handler();
        a12Var.i.d(db1.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        applicationContext2.getClass();
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new z02(a12Var));
        return a12Var;
    }
}
