package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class re extends x1 {
    public static final Parcelable.Creator<re> CREATOR = new a4(12);
    public final List a;
    public final boolean b;
    public final String c;
    public final String e;

    public re(ArrayList arrayList, boolean z, String str, String str2) {
        jg1.d(arrayList);
        this.a = arrayList;
        this.b = z;
        this.c = str;
        this.e = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof re)) {
            return false;
        }
        re reVar = (re) obj;
        return this.b == reVar.b && sr4.a(this.a, reVar.a) && sr4.a(this.c, reVar.c) && sr4.a(this.e, reVar.e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.b), this.a, this.c, this.e});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.d(parcel, 1, this.a);
        mz3.g(parcel, 2, 4);
        parcel.writeInt(this.b ? 1 : 0);
        mz3.b(parcel, 3, this.c);
        mz3.b(parcel, 4, this.e);
        mz3.f(parcel, iE);
    }
}
