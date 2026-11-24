package defpackage;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.view.ContextMenu;
import android.view.View;
import com.ibm.icu.impl.number.Padder;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class cd0 implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, ComponentCallbacks, View.OnCreateContextMenuListener, ob1, h83, cw0, na2 {
    public static final Object x = null;
    public final int a = -1;
    public final String b = UUID.randomUUID().toString();
    public final lq c = new lq();
    public final boolean e = true;
    public final eb1 f = eb1.f;
    public qb1 i;
    public q91 j;
    public final ArrayList k;
    public final uf1 n;
    public final bd0 s;
    public final boolean t;
    public int u;
    public boolean v;
    public boolean w;

    public cd0() {
        new pl1();
        new AtomicInteger();
        this.k = new ArrayList();
        this.n = new uf1(20, this);
        this.i = new qb1(this, true);
        this.j = new q91(new ma2(this, new kb(17, this)));
        ArrayList arrayList = this.k;
        uf1 uf1Var = this.n;
        if (!arrayList.contains(uf1Var)) {
            if (this.a >= 0) {
                cd0 cd0Var = (cd0) uf1Var.b;
                ((ma2) cd0Var.j.b).a();
                c44.c(cd0Var);
            } else {
                arrayList.add(uf1Var);
            }
        }
        new o7(1, this);
        new ad0(this);
        this.s = new bd0(this);
        this.t = true;
        this.u = -1;
        new q82(this);
    }

    @Override // defpackage.cw0
    public final b80 a() {
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Override // defpackage.na2
    public final q91 b() {
        return (q91) this.j.c;
    }

    @Override // defpackage.h83
    public final g83 c() {
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final lq d() {
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // defpackage.ob1
    public final qb1 f() {
        return this.i;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        String str;
        if (this.v) {
            return;
        }
        if (lq.n(3)) {
            toString();
        }
        if (this.w) {
            return;
        }
        this.w = true;
        this.v = true;
        if (this.u >= 0) {
            lq lqVarD = d();
            int i = this.u;
            if (i < 0) {
                og.i(ky0.h(i, "Bad id: "));
                return;
            }
            synchronized (((ArrayList) lqVarD.e)) {
            }
            this.u = -1;
            return;
        }
        kk kkVar = new kk(d());
        dq0 dq0Var = new dq0();
        dq0Var.a = 3;
        dq0Var.b = this;
        ((ArrayList) kkVar.d).add(dq0Var);
        dq0Var.c = 0;
        dq0Var.d = 0;
        dq0Var.e = 0;
        dq0Var.f = 0;
        lq lqVar = (lq) kkVar.e;
        if (kkVar.c) {
            og.n("commit already called");
            return;
        }
        if (lq.n(2)) {
            kkVar.toString();
            PrintWriter printWriter = new PrintWriter(new ye1());
            ArrayList arrayList = (ArrayList) kkVar.d;
            printWriter.print("  ");
            printWriter.print("mName=");
            printWriter.print((String) null);
            printWriter.print(" mIndex=");
            printWriter.print(kkVar.b);
            printWriter.print(" mCommitted=");
            printWriter.println(kkVar.c);
            if (!arrayList.isEmpty()) {
                printWriter.print("  ");
                printWriter.println("Operations:");
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    dq0 dq0Var2 = (dq0) arrayList.get(i2);
                    switch (dq0Var2.a) {
                        case 0:
                            str = "NULL";
                            break;
                        case 1:
                            str = "ADD";
                            break;
                        case 2:
                            str = "REPLACE";
                            break;
                        case 3:
                            str = "REMOVE";
                            break;
                        case 4:
                            str = "HIDE";
                            break;
                        case 5:
                            str = "SHOW";
                            break;
                        case 6:
                            str = "DETACH";
                            break;
                        case 7:
                            str = "ATTACH";
                            break;
                        case 8:
                            str = "SET_PRIMARY_NAV";
                            break;
                        case 9:
                            str = "UNSET_PRIMARY_NAV";
                            break;
                        case 10:
                            str = "OP_SET_MAX_LIFECYCLE";
                            break;
                        default:
                            str = "cmd=" + dq0Var2.a;
                            break;
                    }
                    printWriter.print("  ");
                    printWriter.print("  Op #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.print(str);
                    printWriter.print(Padder.FALLBACK_PADDING_STRING);
                    printWriter.println(dq0Var2.b);
                    if (dq0Var2.c != 0 || dq0Var2.d != 0) {
                        printWriter.print("  ");
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(dq0Var2.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(dq0Var2.d));
                    }
                    if (dq0Var2.e != 0 || dq0Var2.f != 0) {
                        printWriter.print("  ");
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(dq0Var2.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(dq0Var2.f));
                    }
                }
            }
            printWriter.close();
        }
        kkVar.c = true;
        kkVar.b = -1;
        synchronized (((ArrayList) lqVar.e)) {
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.b);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }
}
