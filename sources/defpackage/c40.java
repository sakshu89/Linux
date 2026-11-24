package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c40 extends x1 {
    public static final Parcelable.Creator<c40> CREATOR = new k04(3);
    public final r82 a;
    public final boolean b;
    public final boolean c;
    public final int[] e;
    public final int f;
    public final int[] i;

    public c40(r82 r82Var, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.a = r82Var;
        this.b = z;
        this.c = z2;
        this.e = iArr;
        this.f = i;
        this.i = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.a(parcel, 1, this.a, i);
        mz3.g(parcel, 2, 4);
        parcel.writeInt(this.b ? 1 : 0);
        mz3.g(parcel, 3, 4);
        parcel.writeInt(this.c ? 1 : 0);
        int[] iArr = this.e;
        if (iArr != null) {
            int iE2 = mz3.e(parcel, 4);
            parcel.writeIntArray(iArr);
            mz3.f(parcel, iE2);
        }
        mz3.g(parcel, 5, 4);
        parcel.writeInt(this.f);
        int[] iArr2 = this.i;
        if (iArr2 != null) {
            int iE3 = mz3.e(parcel, 6);
            parcel.writeIntArray(iArr2);
            mz3.f(parcel, iE3);
        }
        mz3.f(parcel, iE);
    }
}
