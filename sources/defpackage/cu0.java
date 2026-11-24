package defpackage;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cu0 extends x1 {
    public final int a;
    public final int b;
    public final int c;
    public String e;
    public IBinder f;
    public Scope[] i;
    public Bundle j;
    public Account k;
    public el0[] n;
    public el0[] s;
    public final boolean t;
    public final int u;
    public boolean v;
    public final String w;
    public static final Parcelable.Creator<cu0> CREATOR = new k04(5);
    public static final Scope[] x = new Scope[0];
    public static final el0[] H = new el0[0];

    public cu0(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, el0[] el0VarArr, el0[] el0VarArr2, boolean z, int i4, boolean z2, String str2) {
        Account account2;
        Scope[] scopeArr2 = scopeArr == null ? x : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        el0[] el0VarArr3 = H;
        el0[] el0VarArr4 = el0VarArr == null ? el0VarArr3 : el0VarArr;
        el0VarArr3 = el0VarArr2 != null ? el0VarArr2 : el0VarArr3;
        this.a = i;
        this.b = i2;
        this.c = i3;
        if ("com.google.android.gms".equals(str)) {
            this.e = "com.google.android.gms";
        } else {
            this.e = str;
        }
        if (i < 2) {
            account2 = null;
            if (iBinder != null) {
                int i5 = q3.b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                jy0 ft4Var = iInterfaceQueryLocalInterface instanceof jy0 ? (jy0) iInterfaceQueryLocalInterface : new ft4(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    try {
                        ft4 ft4Var2 = (ft4) ft4Var;
                        Parcel parcelB = ft4Var2.b(ft4Var2.c(), 2);
                        Account account3 = (Account) i04.a(parcelB, Account.CREATOR);
                        parcelB.recycle();
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        account2 = account3;
                    } catch (RemoteException unused) {
                        Log.w("AccountAccessor", "Remote account accessor probably died");
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                    }
                } catch (Throwable th) {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                    throw th;
                }
            }
        } else {
            this.f = iBinder;
            account2 = account;
        }
        this.k = account2;
        this.i = scopeArr2;
        this.j = bundle2;
        this.n = el0VarArr4;
        this.s = el0VarArr3;
        this.t = z;
        this.u = i4;
        this.v = z2;
        this.w = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        k04.a(this, parcel, i);
    }
}
