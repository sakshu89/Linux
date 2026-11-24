package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class me3 extends x1 {
    public static final Parcelable.Creator<me3> CREATOR = new a4(14);
    public final List a;
    public final String b;

    public me3(String str, ArrayList arrayList) {
        this.a = arrayList;
        this.b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        List<String> list = this.a;
        if (list != null) {
            int iE2 = mz3.e(parcel, 1);
            parcel.writeStringList(list);
            mz3.f(parcel, iE2);
        }
        mz3.b(parcel, 2, this.b);
        mz3.f(parcel, iE);
    }
}
