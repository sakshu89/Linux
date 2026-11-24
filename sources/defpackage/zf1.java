package defpackage;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import com.project.sonic.MainActivity;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zf1 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ MainActivity b;

    public /* synthetic */ zf1(MainActivity mainActivity, int i) {
        this.a = i;
        this.b = mainActivity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        boolean z = false;
        q43 q43Var = q43.a;
        Object[] objArr = 0;
        MainActivity mainActivity = this.b;
        switch (i) {
            case 0:
                np2 np2Var = (np2) obj;
                Set set = MainActivity.m0;
                np2Var.getClass();
                if (mainActivity.f0 == null) {
                    g31.f("permissions");
                    throw null;
                }
                f52 f52VarD = zv1.d(np2Var);
                mainActivity.u(f52VarD.a, f52VarD.b);
                return q43Var;
            case 1:
                np2 np2Var2 = (np2) obj;
                Set set2 = MainActivity.m0;
                np2Var2.getClass();
                if (mainActivity.f0 == null) {
                    g31.f("permissions");
                    throw null;
                }
                f52 f52VarD2 = zv1.d(np2Var2);
                mainActivity.u(f52VarD2.a, f52VarD2.b);
                return q43Var;
            case 2:
                String str = (String) obj;
                Set set3 = MainActivity.m0;
                str.getClass();
                Intent intent = new Intent(str);
                ResolveInfo resolveInfoResolveActivity = mainActivity.getPackageManager().resolveActivity(intent, 65536);
                ActivityInfo activityInfo = resolveInfoResolveActivity != null ? resolveInfoResolveActivity.activityInfo : null;
                String str2 = activityInfo != null ? activityInfo.permission : null;
                if (activityInfo != null && activityInfo.exported && activityInfo.enabled) {
                    ApplicationInfo applicationInfo = activityInfo.applicationInfo;
                    if (applicationInfo.enabled && (applicationInfo.flags & 129) != 0 && (str2 == null || cs2.A(str2) || al4.a(mainActivity, str2) == 0)) {
                        try {
                            intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                            mainActivity.startActivity(intent);
                            z = true;
                        } catch (ActivityNotFoundException | SecurityException unused) {
                        }
                    }
                }
                return Boolean.valueOf(z);
            default:
                b60 b60Var = (b60) obj;
                Set set4 = MainActivity.m0;
                b60Var.getClass();
                mainActivity.q().h(false);
                oj2 oj2VarR = mainActivity.r();
                uf4.b(gb4.c(oj2VarR), null, new sc2((Object) oj2VarR, (Object) b60Var, (x50) (objArr == true ? 1 : 0), 4), 3);
                return q43Var;
        }
    }
}
