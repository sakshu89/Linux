package defpackage;

import android.os.BadParcelableException;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class hl3 {
    public static final /* synthetic */ int a = 0;

    static {
        hl3.class.getClassLoader();
    }

    public static void a(Parcel parcel) {
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail > 0) {
            throw new BadParcelableException(ky0.h(iDataAvail, "Parcel data not fully consumed, unread size: "));
        }
    }
}
