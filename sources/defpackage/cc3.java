package defpackage;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cc3 implements lb1 {
    public final /* synthetic */ w50 a;
    public final /* synthetic */ sc b;
    public final /* synthetic */ f42 c;
    public final /* synthetic */ t42 e;
    public final /* synthetic */ View f;

    public cc3(w50 w50Var, sc scVar, f42 f42Var, t42 t42Var, View view) {
        this.a = w50Var;
        this.b = scVar;
        this.c = f42Var;
        this.e = t42Var;
        this.f = view;
    }

    @Override // defpackage.lb1
    public final void j(ob1 ob1Var, db1 db1Var) throws IllegalAccessException, InvocationTargetException {
        boolean z;
        wv wvVarY = null;
        switch (bc3.a[db1Var.ordinal()]) {
            case 1:
                uf4.b(this.a, null, new cd(this.e, this.c, ob1Var, this, this.f, (x50) null), 1);
                return;
            case 2:
                sc scVar = this.b;
                if (scVar != null) {
                    a50 a50Var = (a50) scVar.c;
                    synchronized (a50Var.c) {
                        try {
                            synchronized (a50Var.c) {
                                z = a50Var.b;
                            }
                            if (!z) {
                                ArrayList arrayList = (ArrayList) a50Var.d;
                                a50Var.d = (ArrayList) a50Var.e;
                                a50Var.e = arrayList;
                                a50Var.b = true;
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    ((x50) arrayList.get(i)).h(q43.a);
                                }
                                arrayList.clear();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                f42 f42Var = this.c;
                synchronized (f42Var.c) {
                    if (f42Var.t) {
                        f42Var.t = false;
                        wvVarY = f42Var.y();
                    }
                    break;
                }
                if (wvVarY != null) {
                    ((yv) wvVarY).h(q43.a);
                    return;
                }
                return;
            case 3:
                f42 f42Var2 = this.c;
                synchronized (f42Var2.c) {
                    f42Var2.t = true;
                }
                return;
            case 4:
                this.c.x();
                return;
            case 5:
            case 6:
            case 7:
                return;
            default:
                dk0.l();
                return;
        }
    }
}
