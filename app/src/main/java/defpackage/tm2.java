package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tm2 implements Parcelable.ClassLoaderCreator {
    public final /* synthetic */ int a;

    public /* synthetic */ tm2(int i) {
        this.a = i;
    }

    public static um2 a(Parcel parcel, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = tm2.class.getClassLoader();
        }
        int i = parcel.readInt();
        if (i == 0) {
            return new um2();
        }
        rw1 rw1VarG = sl2.b.g();
        for (int i2 = 0; i2 < i; i2++) {
            rw1VarG.add(parcel.readValue(classLoader));
        }
        return new um2(rw1VarG.d());
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                return a(parcel, null);
            default:
                return new ue2(parcel, null);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new um2[i];
            default:
                return new ue2[i];
        }
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.a) {
            case 0:
                return a(parcel, classLoader);
            default:
                return new ue2(parcel, classLoader);
        }
    }
}
