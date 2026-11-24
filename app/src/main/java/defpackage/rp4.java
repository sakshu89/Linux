package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rp4 extends x1 {
    public static final Parcelable.Creator<rp4> CREATOR = new k04(8);
    public final ll4[] a;
    public final v54 b;
    public final v54 c;
    public final String e;
    public final float f;
    public final String i;
    public final boolean j;

    public rp4(ll4[] ll4VarArr, v54 v54Var, v54 v54Var2, String str, float f, String str2, boolean z) {
        this.a = ll4VarArr;
        this.b = v54Var;
        this.c = v54Var2;
        this.e = str;
        this.f = f;
        this.i = str2;
        this.j = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.c(parcel, 2, this.a, i);
        mz3.a(parcel, 3, this.b, i);
        mz3.a(parcel, 4, this.c, i);
        mz3.b(parcel, 5, this.e);
        mz3.g(parcel, 6, 4);
        parcel.writeFloat(this.f);
        mz3.b(parcel, 7, this.i);
        mz3.g(parcel, 8, 4);
        parcel.writeInt(this.j ? 1 : 0);
        mz3.f(parcel, iE);
    }
}
