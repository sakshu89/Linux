package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import defpackage.b24;
import defpackage.bx3;
import defpackage.cu0;
import defpackage.dk0;
import defpackage.el0;
import defpackage.hx3;
import defpackage.jb;
import defpackage.je;
import defpackage.jg1;
import defpackage.jy0;
import defpackage.lj1;
import defpackage.mu0;
import defpackage.nu0;
import defpackage.o7;
import defpackage.og;
import defpackage.ou0;
import defpackage.pu0;
import defpackage.py0;
import defpackage.qd3;
import defpackage.qk;
import defpackage.rm4;
import defpackage.sq4;
import defpackage.u54;
import defpackage.wd3;
import defpackage.wj1;
import defpackage.wy3;
import defpackage.x30;
import defpackage.x34;
import defpackage.x74;
import defpackage.xf4;
import defpackage.ye3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements je {
    public static final el0[] x = new el0[0];
    public volatile String a;
    public jb b;
    public final Context c;
    public final sq4 d;
    public final wy3 e;
    public final Object f;
    public final Object g;
    public hx3 h;
    public qk i;
    public IInterface j;
    public final ArrayList k;
    public x34 l;
    public int m;
    public final py0 n;
    public final wj1 o;
    public final int p;
    public final String q;
    public volatile String r;
    public x30 s;
    public boolean t;
    public volatile xf4 u;
    public final AtomicInteger v;
    public final Set w;

    public a(Context context, Looper looper, int i, lj1 lj1Var, ou0 ou0Var, pu0 pu0Var) {
        synchronized (sq4.g) {
            try {
                if (sq4.h == null) {
                    sq4.h = new sq4(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        sq4 sq4Var = sq4.h;
        Object obj = mu0.c;
        jg1.d(ou0Var);
        jg1.d(pu0Var);
        py0 py0Var = new py0(24, ou0Var);
        wj1 wj1Var = new wj1(22, pu0Var);
        String str = (String) lj1Var.e;
        this.a = null;
        this.f = new Object();
        this.g = new Object();
        this.k = new ArrayList();
        this.m = 1;
        this.s = null;
        this.t = false;
        this.u = null;
        this.v = new AtomicInteger(0);
        jg1.e(context, "Context must not be null");
        this.c = context;
        jg1.e(looper, "Looper must not be null");
        jg1.e(sq4Var, "Supervisor must not be null");
        this.d = sq4Var;
        this.e = new wy3(this, looper);
        this.p = i;
        this.n = py0Var;
        this.o = wj1Var;
        this.q = str;
        Set set = (Set) lj1Var.c;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                og.n("Expanding scopes is not permitted, use implied scopes instead");
                throw null;
            }
        }
        this.w = set;
    }

    public static /* bridge */ /* synthetic */ boolean t(a aVar, int i, int i2, IInterface iInterface) {
        synchronized (aVar.f) {
            try {
                if (aVar.m != i) {
                    return false;
                }
                aVar.u(i2, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.je
    public final Set a() {
        return j() ? this.w : Collections.EMPTY_SET;
    }

    @Override // defpackage.je
    public final void b(String str) {
        this.a = str;
        m();
    }

    @Override // defpackage.je
    public final boolean d() {
        boolean z;
        synchronized (this.f) {
            int i = this.m;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    @Override // defpackage.je
    public final el0[] e() {
        xf4 xf4Var = this.u;
        if (xf4Var == null) {
            return null;
        }
        return xf4Var.b;
    }

    @Override // defpackage.je
    public final void f() {
        if (!isConnected() || this.b == null) {
            og.p("Failed to connect when checking package");
        }
    }

    @Override // defpackage.je
    public final void g(qk qkVar) {
        this.i = qkVar;
        u(2, null);
    }

    @Override // defpackage.je
    public final String h() {
        return this.a;
    }

    @Override // defpackage.je
    public final void i(wj1 wj1Var) {
        ((wd3) wj1Var.b).m.m.post(new o7(11, wj1Var));
    }

    @Override // defpackage.je
    public final boolean isConnected() {
        boolean z;
        synchronized (this.f) {
            z = this.m == 4;
        }
        return z;
    }

    @Override // defpackage.je
    public boolean j() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.je
    public final void k(jy0 jy0Var, Set set) {
        Bundle bundleO = o();
        String str = this.r;
        int i = nu0.a;
        Scope[] scopeArr = cu0.x;
        Bundle bundle = new Bundle();
        int i2 = this.p;
        el0[] el0VarArr = cu0.H;
        cu0 cu0Var = new cu0(6, i2, i, null, null, scopeArr, bundle, null, el0VarArr, el0VarArr, true, 0, false, str);
        cu0Var.e = this.c.getPackageName();
        cu0Var.j = bundleO;
        if (set != null) {
            cu0Var.i = (Scope[]) set.toArray(new Scope[0]);
        }
        if (j()) {
            cu0Var.k = new Account("<<default account>>", "com.google");
            if (jy0Var != 0) {
                cu0Var.f = ((qd3) jy0Var).b;
            }
        }
        cu0Var.n = x;
        cu0Var.s = n();
        if (this instanceof ye3) {
            cu0Var.v = true;
        }
        try {
            synchronized (this.g) {
                try {
                    hx3 hx3Var = this.h;
                    if (hx3Var != null) {
                        hx3Var.a(new b24(this, this.v.get()), cu0Var);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i3 = this.v.get();
            wy3 wy3Var = this.e;
            wy3Var.sendMessage(wy3Var.obtainMessage(6, i3, 3));
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i4 = this.v.get();
            u54 u54Var = new u54(this, 8, null, null);
            wy3 wy3Var2 = this.e;
            wy3Var2.sendMessage(wy3Var2.obtainMessage(1, i4, -1, u54Var));
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i5 = this.v.get();
            u54 u54Var2 = new u54(this, 8, null, null);
            wy3 wy3Var3 = this.e;
            wy3Var3.sendMessage(wy3Var3.obtainMessage(1, i5, -1, u54Var2));
        }
    }

    public abstract IInterface l(IBinder iBinder);

    public final void m() {
        this.v.incrementAndGet();
        synchronized (this.k) {
            try {
                int size = this.k.size();
                int i = 0;
                while (true) {
                    ArrayList arrayList = this.k;
                    if (i < size) {
                        bx3 bx3Var = (bx3) arrayList.get(i);
                        synchronized (bx3Var) {
                            bx3Var.a = null;
                        }
                        i++;
                    } else {
                        arrayList.clear();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.g) {
            this.h = null;
        }
        u(1, null);
    }

    public el0[] n() {
        return x;
    }

    public Bundle o() {
        return new Bundle();
    }

    public final IInterface p() {
        IInterface iInterface;
        synchronized (this.f) {
            try {
                if (this.m == 5) {
                    throw new DeadObjectException();
                }
                if (!isConnected()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.j;
                jg1.e(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String q();

    public abstract String r();

    public boolean s() {
        return c() >= 211700000;
    }

    public final void u(int i, IInterface iInterface) {
        jb jbVar;
        if ((i == 4) != (iInterface != null)) {
            dk0.v();
            return;
        }
        synchronized (this.f) {
            try {
                this.m = i;
                this.j = iInterface;
                if (i == 1) {
                    x34 x34Var = this.l;
                    if (x34Var != null) {
                        sq4 sq4Var = this.d;
                        String str = (String) this.b.b;
                        jg1.d(str);
                        this.b.getClass();
                        if (this.q == null) {
                            this.c.getClass();
                        }
                        sq4Var.a(str, x34Var, this.b.a);
                        this.l = null;
                    }
                } else if (i == 2 || i == 3) {
                    x34 x34Var2 = this.l;
                    if (x34Var2 != null && (jbVar = this.b) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + ((String) jbVar.b) + " on com.google.android.gms");
                        sq4 sq4Var2 = this.d;
                        String str2 = (String) this.b.b;
                        jg1.d(str2);
                        this.b.getClass();
                        if (this.q == null) {
                            this.c.getClass();
                        }
                        sq4Var2.a(str2, x34Var2, this.b.a);
                        this.v.incrementAndGet();
                    }
                    x34 x34Var3 = new x34(this, this.v.get());
                    this.l = x34Var3;
                    String strR = r();
                    boolean zS = s();
                    this.b = new jb(strR, zS);
                    if (zS && c() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf((String) this.b.b)));
                    }
                    sq4 sq4Var3 = this.d;
                    String str3 = (String) this.b.b;
                    jg1.d(str3);
                    this.b.getClass();
                    String name = this.q;
                    if (name == null) {
                        name = this.c.getClass().getName();
                    }
                    if (!sq4Var3.b(new rm4(str3, this.b.a), x34Var3, name)) {
                        Log.w("GmsClient", "unable to connect to service: " + ((String) this.b.b) + " on com.google.android.gms");
                        int i2 = this.v.get();
                        x74 x74Var = new x74(this, 16);
                        wy3 wy3Var = this.e;
                        wy3Var.sendMessage(wy3Var.obtainMessage(7, i2, -1, x74Var));
                    }
                } else if (i == 4) {
                    jg1.d(iInterface);
                    System.currentTimeMillis();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
