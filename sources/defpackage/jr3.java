package defpackage;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jr3 extends x1 {
    public static final Parcelable.Creator<jr3> CREATOR = new a4(20);
    public final String a;
    public final Rect b;
    public final List c;
    public final String e;
    public final List f;

    public jr3(String str, Rect rect, List list, String str2, List list2) {
        this.a = str;
        this.b = rect;
        this.c = list;
        this.e = str2;
        this.f = list2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.b(parcel, 1, this.a);
        mz3.a(parcel, 2, this.b, i);
        mz3.d(parcel, 3, this.c);
        mz3.b(parcel, 4, this.e);
        mz3.d(parcel, 5, this.f);
        mz3.f(parcel, iE);
    }
}
