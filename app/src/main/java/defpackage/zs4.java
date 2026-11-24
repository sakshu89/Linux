package defpackage;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zs4 extends x1 {
    public static final Parcelable.Creator<zs4> CREATOR = new k04(11);
    public final String a;
    public final Rect b;
    public final List c;
    public final String e;
    public final List f;
    public final float i;
    public final float j;

    public zs4(float f, float f2, Rect rect, String str, String str2, ArrayList arrayList, ArrayList arrayList2) {
        this.a = str;
        this.b = rect;
        this.c = arrayList;
        this.e = str2;
        this.f = arrayList2;
        this.i = f;
        this.j = f2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.b(parcel, 1, this.a);
        mz3.a(parcel, 2, this.b, i);
        mz3.d(parcel, 3, this.c);
        mz3.b(parcel, 4, this.e);
        mz3.d(parcel, 5, this.f);
        mz3.g(parcel, 6, 4);
        parcel.writeFloat(this.i);
        mz3.g(parcel, 7, 4);
        parcel.writeFloat(this.j);
        mz3.f(parcel, iE);
    }
}
