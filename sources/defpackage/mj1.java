package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mj1 extends x1 {
    public static final Parcelable.Creator<mj1> CREATOR = new a4(16);
    public final int a;
    public final int b;
    public final int c;
    public final long e;
    public final long f;
    public final String i;
    public final String j;
    public final int k;
    public final int n;

    public mj1(int i, int i2, int i3, long j, long j2, String str, String str2, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.e = j;
        this.f = j2;
        this.i = str;
        this.j = str2;
        this.k = i4;
        this.n = i5;
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
        mz3.g(parcel, 4, 8);
        parcel.writeLong(this.e);
        mz3.g(parcel, 5, 8);
        parcel.writeLong(this.f);
        mz3.b(parcel, 6, this.i);
        mz3.b(parcel, 7, this.j);
        mz3.g(parcel, 8, 4);
        parcel.writeInt(this.k);
        mz3.g(parcel, 9, 4);
        parcel.writeInt(this.n);
        mz3.f(parcel, iE);
    }
}
