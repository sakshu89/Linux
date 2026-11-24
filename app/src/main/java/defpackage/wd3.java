package defpackage;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wd3 implements ou0, pu0 {
    public final je b;
    public final se c;
    public final cu2 d;
    public final int g;
    public final ge3 h;
    public boolean i;
    public final /* synthetic */ qu0 m;
    public final LinkedList a = new LinkedList();
    public final HashSet e = new HashSet();
    public final HashMap f = new HashMap();
    public final ArrayList j = new ArrayList();
    public x30 k = null;
    public int l = 0;

    public wd3(qu0 qu0Var, re3 re3Var) {
        this.m = qu0Var;
        Looper looper = qu0Var.m.getLooper();
        kf kfVarA = re3Var.a();
        lj1 lj1Var = new lj1((String) kfVarA.c, (String) kfVarA.e, (pg) kfVarA.b);
        rd3 rd3Var = (rd3) re3Var.c.b;
        jg1.d(rd3Var);
        je jeVarA = rd3Var.a(re3Var.a, looper, lj1Var, re3Var.d, this, this);
        String str = re3Var.b;
        if (str != null && (jeVarA instanceof a)) {
            ((a) jeVarA).r = str;
        }
        if (str != null && (jeVarA instanceof ko1)) {
            ky0.x(jeVarA);
            throw null;
        }
        this.b = jeVarA;
        this.c = re3Var.e;
        this.d = new cu2(11);
        this.g = re3Var.f;
        if (!jeVarA.j()) {
            this.h = null;
            return;
        }
        Context context = qu0Var.e;
        we3 we3Var = qu0Var.m;
        kf kfVarA2 = re3Var.a();
        this.h = new ge3(context, we3Var, new lj1((String) kfVarA2.c, (String) kfVarA2.e, (pg) kfVarA2.b));
    }

    @Override // defpackage.ou0
    public final void a(int i) {
        Looper looperMyLooper = Looper.myLooper();
        we3 we3Var = this.m.m;
        if (looperMyLooper == we3Var.getLooper()) {
            i(i);
        } else {
            we3Var.post(new mh0(this, i));
        }
    }

    @Override // defpackage.pu0
    public final void b(x30 x30Var) {
        o(x30Var, null);
    }

    @Override // defpackage.ou0
    public final void c() {
        Looper looperMyLooper = Looper.myLooper();
        we3 we3Var = this.m.m;
        if (looperMyLooper == we3Var.getLooper()) {
            h();
        } else {
            we3Var.post(new o7(10, this));
        }
    }

    public final void d(x30 x30Var) {
        HashSet hashSet = this.e;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else if (it.next() != null) {
            dk0.t();
        } else {
            if (sr4.a(x30Var, x30.f)) {
                this.b.f();
            }
            throw null;
        }
    }

    public final void e(Status status) {
        jg1.a(this.m.m);
        f(status, null, false);
    }

    public final void f(Status status, Exception exc, boolean z) {
        jg1.a(this.m.m);
        if ((status == null) == (exc == null)) {
            og.i("Status XOR exception should be null");
            return;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ce3 ce3Var = (ce3) it.next();
            if (!z || ce3Var.a == 2) {
                if (status != null) {
                    ce3Var.c(status);
                } else {
                    ce3Var.d(exc);
                }
                it.remove();
            }
        }
    }

    public final void g() {
        LinkedList linkedList = this.a;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ce3 ce3Var = (ce3) arrayList.get(i);
            if (!this.b.isConnected()) {
                return;
            }
            if (k(ce3Var)) {
                linkedList.remove(ce3Var);
            }
        }
    }

    public final void h() {
        qu0 qu0Var = this.m;
        jg1.a(qu0Var.m);
        this.k = null;
        d(x30.f);
        we3 we3Var = qu0Var.m;
        if (this.i) {
            se seVar = this.c;
            we3Var.removeMessages(11, seVar);
            we3Var.removeMessages(9, seVar);
            this.i = false;
        }
        Iterator it = this.f.values().iterator();
        if (it.hasNext()) {
            throw null;
        }
        g();
        j();
    }

    public final void i(int i) {
        qu0 qu0Var = this.m;
        we3 we3Var = qu0Var.m;
        jg1.a(qu0Var.m);
        this.k = null;
        this.i = true;
        String strH = this.b.h();
        cu2 cu2Var = this.d;
        cu2Var.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (strH != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(strH);
        }
        cu2Var.g(true, new Status(20, sb.toString(), null, null));
        se seVar = this.c;
        we3Var.sendMessageDelayed(Message.obtain(we3Var, 9, seVar), 5000L);
        we3Var.sendMessageDelayed(Message.obtain(we3Var, 11, seVar), 120000L);
        ((SparseIntArray) qu0Var.g.b).clear();
        Iterator it = this.f.values().iterator();
        while (it.hasNext()) {
            ((fe3) it.next()).getClass();
        }
    }

    public final void j() {
        qu0 qu0Var = this.m;
        we3 we3Var = qu0Var.m;
        se seVar = this.c;
        we3Var.removeMessages(12, seVar);
        we3Var.sendMessageDelayed(we3Var.obtainMessage(12, seVar), qu0Var.a);
    }

    public final boolean k(ce3 ce3Var) {
        el0 el0Var;
        if (ce3Var == null) {
            cu2 cu2Var = this.d;
            je jeVar = this.b;
            ce3Var.f(cu2Var, jeVar.j());
            try {
                ce3Var.e(this);
                return true;
            } catch (DeadObjectException unused) {
                a(1);
                jeVar.b("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        el0[] el0VarArrB = ce3Var.b(this);
        if (el0VarArrB == null || el0VarArrB.length == 0) {
            el0Var = null;
            break;
        }
        el0[] el0VarArrE = this.b.e();
        if (el0VarArrE == null) {
            el0VarArrE = new el0[0];
        }
        ng ngVar = new ng(el0VarArrE.length);
        for (el0 el0Var2 : el0VarArrE) {
            ngVar.put(el0Var2.a, Long.valueOf(el0Var2.a()));
        }
        int length = el0VarArrB.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                el0Var = null;
                break;
            }
            el0Var = el0VarArrB[i];
            Long l = (Long) ngVar.get(el0Var.a);
            if (l == null || l.longValue() < el0Var.a()) {
                break;
            }
            i++;
        }
        if (el0Var == null) {
            cu2 cu2Var2 = this.d;
            je jeVar2 = this.b;
            ce3Var.f(cu2Var2, jeVar2.j());
            try {
                ce3Var.e(this);
                return true;
            } catch (DeadObjectException unused2) {
                a(1);
                jeVar2.b("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        Log.w("GoogleApiManager", this.b.getClass().getName() + " could not execute call because it requires feature (" + el0Var.a + ", " + el0Var.a() + ").");
        if (!this.m.n || !ce3Var.a(this)) {
            ce3Var.d(new f53(el0Var));
            return true;
        }
        xd3 xd3Var = new xd3(this.c, el0Var);
        int iIndexOf = this.j.indexOf(xd3Var);
        ArrayList arrayList = this.j;
        if (iIndexOf >= 0) {
            xd3 xd3Var2 = (xd3) arrayList.get(iIndexOf);
            this.m.m.removeMessages(15, xd3Var2);
            we3 we3Var = this.m.m;
            we3Var.sendMessageDelayed(Message.obtain(we3Var, 15, xd3Var2), 5000L);
        } else {
            arrayList.add(xd3Var);
            we3 we3Var2 = this.m.m;
            we3Var2.sendMessageDelayed(Message.obtain(we3Var2, 15, xd3Var), 5000L);
            we3 we3Var3 = this.m.m;
            we3Var3.sendMessageDelayed(Message.obtain(we3Var3, 16, xd3Var), 120000L);
            x30 x30Var = new x30(2, null);
            if (!l(x30Var)) {
                this.m.b(x30Var, this.g);
            }
        }
        return false;
    }

    public final boolean l(x30 x30Var) {
        synchronized (qu0.q) {
        }
        return false;
    }

    public final void m() {
        qu0 qu0Var = this.m;
        jg1.a(qu0Var.m);
        je jeVar = this.b;
        if (jeVar.isConnected() || jeVar.d()) {
            return;
        }
        try {
            cu2 cu2Var = qu0Var.g;
            Context context = qu0Var.e;
            SparseIntArray sparseIntArray = (SparseIntArray) cu2Var.b;
            jg1.d(context);
            int iC = jeVar.c();
            int iB = ((SparseIntArray) cu2Var.b).get(iC, -1);
            if (iB == -1) {
                iB = 0;
                int i = 0;
                while (true) {
                    if (i >= sparseIntArray.size()) {
                        iB = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i);
                    if (iKeyAt > iC && sparseIntArray.get(iKeyAt) == 0) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (iB == -1) {
                    iB = ((mu0) cu2Var.c).b(context, iC);
                }
                sparseIntArray.put(iC, iB);
            }
            if (iB != 0) {
                x30 x30Var = new x30(iB, null);
                Log.w("GoogleApiManager", "The service for " + jeVar.getClass().getName() + " is not available: " + x30Var.toString());
                o(x30Var, null);
                return;
            }
            k02 k02Var = new k02(qu0Var, jeVar, this.c);
            if (jeVar.j()) {
                ge3 ge3Var = this.h;
                jg1.d(ge3Var);
                Handler handler = ge3Var.c;
                lj1 lj1Var = ge3Var.f;
                nk2 nk2Var = ge3Var.g;
                if (nk2Var != null) {
                    nk2Var.m();
                }
                lj1Var.g = Integer.valueOf(System.identityHashCode(ge3Var));
                ge3Var.g = (nk2) ge3Var.d.a(ge3Var.b, handler.getLooper(), lj1Var, (ok2) lj1Var.f, ge3Var, ge3Var);
                ge3Var.h = k02Var;
                Set set = ge3Var.e;
                if (set == null || set.isEmpty()) {
                    handler.post(new o7(12, ge3Var));
                } else {
                    nk2 nk2Var2 = ge3Var.g;
                    nk2Var2.getClass();
                    nk2Var2.g(new q82(nk2Var2));
                }
            }
            try {
                jeVar.g(k02Var);
            } catch (SecurityException e) {
                o(new x30(10), e);
            }
        } catch (IllegalStateException e2) {
            o(new x30(10), e2);
        }
    }

    public final void n(ce3 ce3Var) {
        jg1.a(this.m.m);
        boolean zIsConnected = this.b.isConnected();
        LinkedList linkedList = this.a;
        if (zIsConnected) {
            if (k(ce3Var)) {
                j();
                return;
            } else {
                linkedList.add(ce3Var);
                return;
            }
        }
        linkedList.add(ce3Var);
        x30 x30Var = this.k;
        if (x30Var == null || x30Var.b == 0 || x30Var.c == null) {
            m();
        } else {
            o(x30Var, null);
        }
    }

    public final void o(x30 x30Var, RuntimeException runtimeException) {
        nk2 nk2Var;
        jg1.a(this.m.m);
        ge3 ge3Var = this.h;
        if (ge3Var != null && (nk2Var = ge3Var.g) != null) {
            nk2Var.m();
        }
        jg1.a(this.m.m);
        this.k = null;
        ((SparseIntArray) this.m.g.b).clear();
        d(x30Var);
        if ((this.b instanceof te3) && x30Var.b != 24) {
            qu0 qu0Var = this.m;
            qu0Var.b = true;
            we3 we3Var = qu0Var.m;
            we3Var.sendMessageDelayed(we3Var.obtainMessage(19), 300000L);
        }
        if (x30Var.b == 4) {
            e(qu0.p);
            return;
        }
        if (this.a.isEmpty()) {
            this.k = x30Var;
            return;
        }
        qu0 qu0Var2 = this.m;
        if (runtimeException != null) {
            jg1.a(qu0Var2.m);
            f(null, runtimeException, false);
            return;
        }
        boolean z = qu0Var2.n;
        se seVar = this.c;
        if (!z) {
            e(qu0.c(seVar, x30Var));
            return;
        }
        f(qu0.c(seVar, x30Var), null, true);
        if (this.a.isEmpty() || l(x30Var) || this.m.b(x30Var, this.g)) {
            return;
        }
        if (x30Var.b == 18) {
            this.i = true;
        }
        if (!this.i) {
            e(qu0.c(this.c, x30Var));
            return;
        }
        qu0 qu0Var3 = this.m;
        se seVar2 = this.c;
        we3 we3Var2 = qu0Var3.m;
        we3Var2.sendMessageDelayed(Message.obtain(we3Var2, 9, seVar2), 5000L);
    }

    public final void p(x30 x30Var) {
        jg1.a(this.m.m);
        je jeVar = this.b;
        jeVar.b("onSignInFailed for " + jeVar.getClass().getName() + " with " + String.valueOf(x30Var));
        o(x30Var, null);
    }

    public final void q() {
        jg1.a(this.m.m);
        Status status = qu0.o;
        e(status);
        this.d.g(false, status);
        for (xc1 xc1Var : (xc1[]) this.f.keySet().toArray(new xc1[0])) {
            n(new oe3(null, new iw2()));
        }
        d(new x30(4));
        je jeVar = this.b;
        if (jeVar.isConnected()) {
            jeVar.i(new wj1(21, this));
        }
    }
}
