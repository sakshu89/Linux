package defpackage;

import android.content.Context;
import android.view.GestureDetector;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kk {
    public final /* synthetic */ int a;
    public int b;
    public boolean c;
    public final Serializable d;
    public final Object e;

    public kk(Context context, k7 k7Var) {
        this.a = 1;
        this.d = k7Var;
        this.b = 0;
        this.e = new GestureDetector(context, new o01(this));
    }

    public String toString() {
        switch (this.a) {
            case 0:
                StringBuilder sb = new StringBuilder(128);
                sb.append("BackStackEntry{");
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                if (this.b >= 0) {
                    sb.append(" #");
                    sb.append(this.b);
                }
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public kk(lq lqVar) {
        this.a = 0;
        lqVar.getClass();
        this.d = new ArrayList();
        this.b = -1;
        this.e = lqVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public kk(py0 py0Var, el0[] el0VarArr, boolean z, int i) {
        this.a = 2;
        this.e = py0Var;
        this.d = el0VarArr;
        boolean z2 = false;
        if (el0VarArr != 0 && z) {
            z2 = true;
        }
        this.c = z2;
        this.b = i;
    }
}
