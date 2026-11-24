package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wf implements nh0 {
    public Context a;

    @Override // defpackage.nh0
    public void a(cn4 cn4Var) {
        o30 o30Var = new o30("EmojiCompatInitializer");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), o30Var);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new dc(this, cn4Var, threadPoolExecutor, 8));
    }

    public x80 b() {
        Context context = this.a;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        x80 x80Var = new x80();
        x80Var.a = zd0.a(ez3.a);
        int i = 1;
        z70 z70Var = new z70(i, context);
        x80Var.b = z70Var;
        int i2 = 0;
        x80Var.c = zd0.a(new ej1(z70Var, new z70(i2, z70Var)));
        c22 c22VarA = zd0.a(new z70(2, new z70(3, x80Var.b)));
        x80Var.e = c22VarA;
        tj0 tj0Var = new tj0(i);
        z70 z70Var2 = x80Var.b;
        cb2 cb2Var = new cb2(z70Var2, c22VarA, tj0Var, i2);
        c22 c22Var = x80Var.a;
        c22 c22Var2 = x80Var.c;
        x80Var.f = zd0.a(new cb2(new za0(c22Var, c22Var2, cb2Var, c22VarA, c22VarA), new l53(z70Var2, c22Var2, c22VarA, cb2Var, c22Var, c22VarA), new lc3(c22Var, c22VarA, cb2Var, c22VarA), i));
        return x80Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.List] */
    public ArrayList c() {
        ?? arrayList;
        ArrayList arrayList2 = new ArrayList();
        Context context = this.a;
        Bundle bundle = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) MlKitComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", MlKitComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (bundle == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList();
            for (String str : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new rk4(4, (String) it.next()));
        }
        return arrayList2;
    }
}
