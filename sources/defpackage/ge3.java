package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ge3 extends ud3 implements ou0, pu0 {
    public static final rd3 i = ie3.a;
    public final Context b;
    public final Handler c;
    public final rd3 d;
    public final Set e;
    public final lj1 f;
    public nk2 g;
    public k02 h;

    public ge3(Context context, we3 we3Var, lj1 lj1Var) {
        super("com.google.android.gms.signin.internal.ISignInCallbacks", 0);
        this.b = context;
        this.c = we3Var;
        this.f = lj1Var;
        this.e = (Set) lj1Var.b;
        this.d = i;
    }

    @Override // defpackage.ou0
    public final void a(int i2) {
        k02 k02Var = this.h;
        wd3 wd3Var = (wd3) ((qu0) k02Var.i).j.get((se) k02Var.a);
        if (wd3Var != null) {
            if (wd3Var.i) {
                wd3Var.p(new x30(17));
            } else {
                wd3Var.a(i2);
            }
        }
    }

    @Override // defpackage.pu0
    public final void b(x30 x30Var) {
        this.h.b(x30Var);
    }

    @Override // defpackage.ou0
    public final void c() {
        GoogleSignInAccount googleSignInAccountA;
        nk2 nk2Var = this.g;
        nk2Var.getClass();
        boolean z = false;
        try {
            nk2Var.z.getClass();
            Account account = new Account("<<default account>>", "com.google");
            if ("<<default account>>".equals(account.name)) {
                Context context = nk2Var.c;
                ReentrantLock reentrantLock = vr2.c;
                jg1.d(context);
                ReentrantLock reentrantLock2 = vr2.c;
                reentrantLock2.lock();
                try {
                    if (vr2.d == null) {
                        vr2.d = new vr2(context.getApplicationContext());
                    }
                    vr2 vr2Var = vr2.d;
                    reentrantLock2.unlock();
                    String strA = vr2Var.a("defaultGoogleSignInAccount");
                    if (!TextUtils.isEmpty(strA)) {
                        String strA2 = vr2Var.a("googleSignInAccount:" + strA);
                        if (strA2 != null) {
                            try {
                                googleSignInAccountA = GoogleSignInAccount.a(strA2);
                            } catch (JSONException unused) {
                                googleSignInAccountA = null;
                            }
                        }
                    }
                    googleSignInAccountA = null;
                } catch (Throwable th) {
                    reentrantLock2.unlock();
                    throw th;
                }
            } else {
                googleSignInAccountA = null;
            }
            Integer num = nk2Var.B;
            jg1.d(num);
            ve3 ve3Var = new ve3(2, account, num.intValue(), googleSignInAccountA);
            le3 le3Var = (le3) nk2Var.p();
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeInterfaceToken(le3Var.c);
            int i2 = be3.a;
            parcelObtain.writeInt(1);
            int iE = mz3.e(parcelObtain, 20293);
            mz3.g(parcelObtain, 1, 4);
            parcelObtain.writeInt(1);
            mz3.a(parcelObtain, 2, ve3Var, 0);
            mz3.f(parcelObtain, iE);
            parcelObtain.writeStrongBinder(this);
            le3Var.a(parcelObtain, 12);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                this.c.post(new or0(10, this, new qe3(1, new x30(8, null), null), z));
            } catch (RemoteException unused2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // defpackage.ud3
    public final boolean d(int i2, Parcel parcel, Parcel parcel2) {
        boolean z = false;
        switch (i2) {
            case 3:
                be3.b(parcel);
                break;
            case 4:
                be3.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                be3.b(parcel);
                break;
            case 7:
                be3.b(parcel);
                break;
            case 8:
                qe3 qe3Var = (qe3) be3.a(parcel, qe3.CREATOR);
                be3.b(parcel);
                this.c.post(new or0(10, this, qe3Var, z));
                break;
            case 9:
                be3.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
