package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zh4 extends x1 {
    public static final Parcelable.Creator<zh4> CREATOR = new k04(4);
    public final rp4[] a;
    public final v54 b;
    public final v54 c;
    public final v54 e;
    public final String f;
    public final float i;
    public final String j;
    public final int k;
    public final boolean n;
    public final int s;
    public final int t;

    public zh4(rp4[] rp4VarArr, v54 v54Var, v54 v54Var2, v54 v54Var3, String str, float f, String str2, int i, boolean z, int i2, int i3) {
        this.a = rp4VarArr;
        this.b = v54Var;
        this.c = v54Var2;
        this.e = v54Var3;
        this.f = str;
        this.i = f;
        this.j = str2;
        this.k = i;
        this.n = z;
        this.s = i2;
        this.t = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.c(parcel, 2, this.a, i);
        mz3.a(parcel, 3, this.b, i);
        mz3.a(parcel, 4, this.c, i);
        mz3.a(parcel, 5, this.e, i);
        mz3.b(parcel, 6, this.f);
        mz3.g(parcel, 7, 4);
        parcel.writeFloat(this.i);
        mz3.b(parcel, 8, this.j);
        mz3.g(parcel, 9, 4);
        parcel.writeInt(this.k);
        mz3.g(parcel, 10, 4);
        parcel.writeInt(this.n ? 1 : 0);
        mz3.g(parcel, 11, 4);
        parcel.writeInt(this.s);
        mz3.g(parcel, 12, 4);
        parcel.writeInt(this.t);
        mz3.f(parcel, iE);
    }
}
