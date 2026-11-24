package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.KeyEvent;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class pd3 {
    public static final void a(ax2 ax2Var, Context context, final boolean z, final String str, final long j) {
        if (oz2.c(j) || str.length() == 0) {
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        final Context context2 = context;
        List list = (List) o34.a.j(context2);
        if (list.isEmpty()) {
            return;
        }
        yl1 yl1Var = ax2Var.a;
        yl1 yl1Var2 = ax2Var.a;
        nx2 nx2Var = nx2.b;
        yl1Var.a(nx2Var);
        int size = list.size();
        int i = 0;
        while (i < size) {
            final ResolveInfo resolveInfo = (ResolveInfo) list.get(i);
            yl1Var2.a(new jx2(new b12(i), resolveInfo.loadLabel(packageManager).toString(), 0, new hq0() { // from class: c12
                @Override // defpackage.hq0
                public final Object j(Object obj) {
                    o34.b.l(context2, resolveInfo, Boolean.valueOf(z), str, new oz2(j));
                    ((ox2) obj).close();
                    return q43.a;
                }
            }));
            i++;
            context2 = context;
        }
        yl1Var2.a(nx2Var);
    }

    public static ek1 b(ek1 ek1Var, ol1 ol1Var, k82 k82Var, boolean z, m82 m82Var, fq0 fq0Var, int i) {
        ek1 ek1VarA;
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            m82Var = null;
        }
        m82 m82Var2 = m82Var;
        if (k82Var != null) {
            ek1VarA = new iy(ol1Var, k82Var, false, z2, null, m82Var2, fq0Var);
        } else if (k82Var == null) {
            ek1VarA = new iy(ol1Var, null, false, z2, null, m82Var2, fq0Var);
        } else if (ol1Var != null) {
            m30 m30Var = zz0.a;
            ek1VarA = new a01(ol1Var, k82Var).c(new iy(ol1Var, null, false, z2, null, m82Var2, fq0Var));
        } else {
            ek1VarA = gj4.a(bk1.a, new jy(k82Var, z2, m82Var2, fq0Var));
        }
        return ek1Var.c(ek1VarA);
    }

    public static ek1 c(ek1 ek1Var, boolean z, String str, m82 m82Var, fq0 fq0Var, int i) {
        if ((i & 1) != 0) {
            z = true;
        }
        return ek1Var.c(new iy(null, null, true, z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : m82Var, fq0Var));
    }

    public static final boolean d(KeyEvent keyEvent) {
        long jA = h51.a(keyEvent);
        int i = d51.F;
        return d51.a(jA, d51.h) || d51.a(jA, d51.r) || d51.a(jA, d51.E) || d51.a(jA, d51.q);
    }
}
