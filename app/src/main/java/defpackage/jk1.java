package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jk1 extends x1 {
    public static final Parcelable.Creator<jk1> CREATOR = new a4(7);
    public final boolean a;
    public final int b;

    public jk1(boolean z, int i) {
        this.a = z;
        this.b = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.g(parcel, 1, 4);
        parcel.writeInt(this.a ? 1 : 0);
        mz3.g(parcel, 2, 4);
        parcel.writeInt(this.b);
        mz3.f(parcel, iE);
    }
}
