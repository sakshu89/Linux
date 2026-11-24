package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nr3 extends x1 {
    public static final Parcelable.Creator<nr3> CREATOR = new a4(24);
    public final String a;
    public final String b;
    public final String c;
    public final boolean e;
    public final int f;
    public final String i;
    public final boolean j;

    public nr3(String str, String str2, String str3, boolean z, int i, String str4, boolean z2) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.i = str4;
        this.f = i;
        this.e = z;
        this.j = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.b(parcel, 1, this.a);
        mz3.b(parcel, 2, this.b);
        mz3.b(parcel, 3, this.c);
        mz3.g(parcel, 4, 4);
        parcel.writeInt(this.e ? 1 : 0);
        mz3.g(parcel, 5, 4);
        parcel.writeInt(this.f);
        mz3.b(parcel, 6, this.i);
        mz3.g(parcel, 7, 4);
        parcel.writeInt(this.j ? 1 : 0);
        mz3.f(parcel, iE);
    }
}
