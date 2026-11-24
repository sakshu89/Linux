package defpackage;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sd3 extends x1 {
    public static final Parcelable.Creator<sd3> CREATOR = new a4(10);
    public final int a;
    public final int b;
    public final Intent c;

    public sd3(int i, int i2, Intent intent) {
        this.a = i;
        this.b = i2;
        this.c = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.g(parcel, 1, 4);
        parcel.writeInt(this.a);
        mz3.g(parcel, 2, 4);
        parcel.writeInt(this.b);
        mz3.a(parcel, 3, this.c, i);
        mz3.f(parcel, iE);
    }
}
