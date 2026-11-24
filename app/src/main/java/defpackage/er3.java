package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class er3 extends x1 {
    public static final Parcelable.Creator<er3> CREATOR = new a4(19);
    public final int a;
    public final int b;
    public final int c;
    public final int e;
    public final long f;

    public er3(int i, int i2, int i3, int i4, long j) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.e = i4;
        this.f = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.g(parcel, 1, 4);
        parcel.writeInt(this.a);
        mz3.g(parcel, 2, 4);
        parcel.writeInt(this.b);
        mz3.g(parcel, 3, 4);
        parcel.writeInt(this.c);
        mz3.g(parcel, 4, 4);
        parcel.writeInt(this.e);
        mz3.g(parcel, 5, 8);
        parcel.writeLong(this.f);
        mz3.f(parcel, iE);
    }
}
