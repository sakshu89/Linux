package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class kz3 {
    public static Parcelable a(Parcel parcel, int i, Parcelable.Creator creator) {
        int iJ = j(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iJ);
        return parcelable;
    }

    public static String b(Parcel parcel, int i) {
        int iJ = j(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iJ);
        return string;
    }

    public static Object[] c(Parcel parcel, int i, Parcelable.Creator creator) {
        int iJ = j(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iJ);
        return objArrCreateTypedArray;
    }

    public static ArrayList d(Parcel parcel, int i, Parcelable.Creator creator) {
        int iJ = j(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iJ);
        return arrayListCreateTypedArrayList;
    }

    public static void e(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new b10(ky0.h(i, "Overread allowed size end="), parcel);
        }
    }

    public static boolean f(Parcel parcel, int i) {
        m(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static float g(Parcel parcel, int i) {
        m(parcel, i, 4);
        return parcel.readFloat();
    }

    public static int h(Parcel parcel, int i) {
        m(parcel, i, 4);
        return parcel.readInt();
    }

    public static long i(Parcel parcel, int i) {
        m(parcel, i, 8);
        return parcel.readLong();
    }

    public static int j(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    public static void k(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + j(parcel, i));
    }

    public static int l(Parcel parcel) {
        int i = parcel.readInt();
        int iJ = j(parcel, i);
        char c = (char) i;
        int iDataPosition = parcel.dataPosition();
        if (c != 20293) {
            throw new b10("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i))), parcel);
        }
        int i2 = iJ + iDataPosition;
        if (i2 < iDataPosition || i2 > parcel.dataSize()) {
            throw new b10(ky0.i("Size read is invalid start=", iDataPosition, i2, " end="), parcel);
        }
        return i2;
    }

    public static void m(Parcel parcel, int i, int i2) {
        int iJ = j(parcel, i);
        if (iJ == i2) {
            return;
        }
        throw new b10(cq.n(cq.p("Expected size ", i2, " got ", iJ, " (0x"), Integer.toHexString(iJ), ")"), parcel);
    }
}
