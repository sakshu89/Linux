package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xe3 extends x1 {
    public static final Parcelable.Creator<xe3> CREATOR = new a4(18);
    public final int a;
    public final IBinder b;
    public final x30 c;
    public final boolean e;
    public final boolean f;

    public xe3(int i, IBinder iBinder, x30 x30Var, boolean z, boolean z2) {
        this.a = i;
        this.b = iBinder;
        this.c = x30Var;
        this.e = z;
        this.f = z2;
    }

    public final boolean equals(Object obj) {
        Object ft4Var;
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            if (!(obj instanceof xe3)) {
                return false;
            }
            xe3 xe3Var = (xe3) obj;
            if (!this.c.equals(xe3Var.c)) {
                return false;
            }
            Object ft4Var2 = null;
            IBinder iBinder = this.b;
            if (iBinder == null) {
                ft4Var = null;
            } else {
                int i = q3.b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                ft4Var = iInterfaceQueryLocalInterface instanceof jy0 ? (jy0) iInterfaceQueryLocalInterface : new ft4(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            IBinder iBinder2 = xe3Var.b;
            if (iBinder2 != null) {
                int i2 = q3.b;
                IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                ft4Var2 = iInterfaceQueryLocalInterface2 instanceof jy0 ? (jy0) iInterfaceQueryLocalInterface2 : new ft4(iBinder2, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            if (!sr4.a(ft4Var, ft4Var2)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.g(parcel, 1, 4);
        parcel.writeInt(this.a);
        IBinder iBinder = this.b;
        if (iBinder != null) {
            int iE2 = mz3.e(parcel, 2);
            parcel.writeStrongBinder(iBinder);
            mz3.f(parcel, iE2);
        }
        mz3.a(parcel, 3, this.c, i);
        mz3.g(parcel, 4, 4);
        parcel.writeInt(this.e ? 1 : 0);
        mz3.g(parcel, 5, 4);
        parcel.writeInt(this.f ? 1 : 0);
        mz3.f(parcel, iE);
    }
}
