package defpackage;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kr3 extends x1 {
    public static final Parcelable.Creator<kr3> CREATOR = new a4(21);
    public final String a;
    public final Rect b;
    public final List c;
    public final String e;
    public final float f;
    public final float i;
    public final List j;

    public kr3(float f, float f2, Rect rect, String str, String str2, List list, List list2) {
        this.a = str;
        this.b = rect;
        this.c = list;
        this.e = str2;
        this.f = f;
        this.i = f2;
        this.j = list2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.b(parcel, 1, this.a);
        mz3.a(parcel, 2, this.b, i);
        mz3.d(parcel, 3, this.c);
        mz3.b(parcel, 4, this.e);
        mz3.g(parcel, 5, 4);
        parcel.writeFloat(this.f);
        mz3.g(parcel, 6, 4);
        parcel.writeFloat(this.i);
        mz3.d(parcel, 7, this.j);
        mz3.f(parcel, iE);
    }
}
