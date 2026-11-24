package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qe3 extends x1 {
    public static final Parcelable.Creator<qe3> CREATOR = new a4(15);
    public final int a;
    public final x30 b;
    public final xe3 c;

    public qe3(int i, x30 x30Var, xe3 xe3Var) {
        this.a = i;
        this.b = x30Var;
        this.c = xe3Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.g(parcel, 1, 4);
        parcel.writeInt(this.a);
        mz3.a(parcel, 2, this.b, i);
        mz3.a(parcel, 3, this.c, i);
        mz3.f(parcel, iE);
    }
}
