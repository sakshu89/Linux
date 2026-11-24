package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zb4 extends qd3 implements yf4 {
    public final z94 f(ap1 ap1Var, nn4 nn4Var) {
        z94 z94Var;
        Parcel parcelC = c();
        int i = j04.a;
        parcelC.writeStrongBinder(ap1Var);
        parcelC.writeInt(1);
        nn4Var.writeToParcel(parcelC, 0);
        Parcel parcelD = d(parcelC, 1);
        IBinder strongBinder = parcelD.readStrongBinder();
        if (strongBinder == null) {
            z94Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
            z94Var = iInterfaceQueryLocalInterface instanceof z94 ? (z94) iInterfaceQueryLocalInterface : new z94(strongBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer", 2);
        }
        parcelD.recycle();
        return z94Var;
    }
}
