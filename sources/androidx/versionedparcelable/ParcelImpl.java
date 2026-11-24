package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.a4;
import defpackage.h73;
import defpackage.i73;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a4(3);
    public final i73 a;

    public ParcelImpl(Parcel parcel) {
        this.a = new h73(parcel).g();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new h73(parcel).i(this.a);
    }
}
