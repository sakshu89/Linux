package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class at4 extends x1 {
    public static final Parcelable.Creator<at4> CREATOR = new k04(12);
    public final String a;
    public final List b;

    public at4(String str, ArrayList arrayList) {
        this.a = str;
        this.b = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.b(parcel, 1, this.a);
        mz3.d(parcel, 2, this.b);
        mz3.f(parcel, iE);
    }
}
