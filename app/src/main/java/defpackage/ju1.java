package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ju1 implements Parcelable.ClassLoaderCreator {
    public final /* synthetic */ int a;

    public /* synthetic */ ju1(int i) {
        this.a = i;
    }

    public static ku1 a(Parcel parcel, ClassLoader classLoader) {
        om2 om2Var;
        if (classLoader == null) {
            classLoader = ju1.class.getClassLoader();
        }
        Object value = parcel.readValue(classLoader);
        int i = parcel.readInt();
        if (i == 0) {
            om2Var = el1.f;
        } else if (i == 1) {
            om2Var = su0.k;
        } else {
            if (i != 2) {
                og.n(cq.h("Unsupported MutableState policy ", i, " was restored"));
                return null;
            }
            om2Var = ak1.i;
        }
        return new ku1(value, om2Var);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                return a(parcel, null);
            default:
                if (parcel.readParcelable(null) == null) {
                    return m0.b;
                }
                og.n("superState must be null");
                return null;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new ku1[i];
            default:
                return new m0[i];
        }
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.a) {
            case 0:
                return a(parcel, classLoader);
            default:
                if (parcel.readParcelable(classLoader) == null) {
                    return m0.b;
                }
                og.n("superState must be null");
                return null;
        }
    }
}
