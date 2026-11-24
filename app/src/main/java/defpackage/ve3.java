package defpackage;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ve3 extends x1 {
    public static final Parcelable.Creator<ve3> CREATOR = new a4(17);
    public final int a;
    public final Account b;
    public final int c;
    public final GoogleSignInAccount e;

    public ve3(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.a = i;
        this.b = account;
        this.c = i2;
        this.e = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.g(parcel, 1, 4);
        parcel.writeInt(this.a);
        mz3.a(parcel, 2, this.b, i);
        mz3.g(parcel, 3, 4);
        parcel.writeInt(this.c);
        mz3.a(parcel, 4, this.e, i);
        mz3.f(parcel, iE);
    }
}
