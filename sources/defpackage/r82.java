package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r82 extends x1 {
    public static final Parcelable.Creator<r82> CREATOR = new a4(27);
    public final int a;
    public final boolean b;
    public final boolean c;
    public final int e;
    public final int f;

    public r82(int i, int i2, int i3, boolean z, boolean z2) {
        this.a = i;
        this.b = z;
        this.c = z2;
        this.e = i2;
        this.f = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.g(parcel, 1, 4);
        parcel.writeInt(this.a);
        mz3.g(parcel, 2, 4);
        parcel.writeInt(this.b ? 1 : 0);
        mz3.g(parcel, 3, 4);
        parcel.writeInt(this.c ? 1 : 0);
        mz3.g(parcel, 4, 4);
        parcel.writeInt(this.e);
        mz3.g(parcel, 5, 4);
        parcel.writeInt(this.f);
        mz3.f(parcel, iE);
    }
}
