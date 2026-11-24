package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mr3 extends x1 {
    public static final Parcelable.Creator<mr3> CREATOR = new a4(23);
    public final String a;
    public final List b;

    public mr3(String str, List list) {
        this.a = str;
        this.b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.b(parcel, 1, this.a);
        mz3.d(parcel, 2, this.b);
        mz3.f(parcel, iE);
    }
}
