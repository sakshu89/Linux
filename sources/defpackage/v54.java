package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v54 extends x1 {
    public static final Parcelable.Creator<v54> CREATOR = new k04(1);
    public final int a;
    public final int b;
    public final int c;
    public final int e;
    public final float f;

    public v54(int i, int i2, int i3, int i4, float f) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.e = i4;
        this.f = f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.g(parcel, 2, 4);
        parcel.writeInt(this.a);
        mz3.g(parcel, 3, 4);
        parcel.writeInt(this.b);
        mz3.g(parcel, 4, 4);
        parcel.writeInt(this.c);
        mz3.g(parcel, 5, 4);
        parcel.writeInt(this.e);
        mz3.g(parcel, 6, 4);
        parcel.writeFloat(this.f);
        mz3.f(parcel, iE);
    }
}
