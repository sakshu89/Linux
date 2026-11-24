package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xf4 extends x1 {
    public static final Parcelable.Creator<xf4> CREATOR = new k04(2);
    public Bundle a;
    public el0[] b;
    public int c;
    public c40 e;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        Bundle bundle = this.a;
        if (bundle != null) {
            int iE2 = mz3.e(parcel, 1);
            parcel.writeBundle(bundle);
            mz3.f(parcel, iE2);
        }
        mz3.c(parcel, 2, this.b, i);
        int i2 = this.c;
        mz3.g(parcel, 3, 4);
        parcel.writeInt(i2);
        mz3.a(parcel, 4, this.e, i);
        mz3.f(parcel, iE);
    }
}
