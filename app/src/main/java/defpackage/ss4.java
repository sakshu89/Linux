package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ss4 extends qd3 implements us4 {
    public final rs4 f(ap1 ap1Var) {
        rs4 rs4Var;
        Parcel parcelC = c();
        int i = j04.a;
        parcelC.writeStrongBinder(ap1Var);
        Parcel parcelD = d(parcelC, 1);
        IBinder strongBinder = parcelD.readStrongBinder();
        if (strongBinder == null) {
            rs4Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizer");
            rs4Var = iInterfaceQueryLocalInterface instanceof rs4 ? (rs4) iInterfaceQueryLocalInterface : new rs4(strongBinder);
        }
        parcelD.recycle();
        return rs4Var;
    }

    public final rs4 g(ap1 ap1Var, bt4 bt4Var) {
        rs4 rs4Var;
        Parcel parcelC = c();
        int i = j04.a;
        parcelC.writeStrongBinder(ap1Var);
        parcelC.writeInt(1);
        bt4Var.writeToParcel(parcelC, 0);
        Parcel parcelD = d(parcelC, 2);
        IBinder strongBinder = parcelD.readStrongBinder();
        if (strongBinder == null) {
            rs4Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizer");
            rs4Var = iInterfaceQueryLocalInterface instanceof rs4 ? (rs4) iInterfaceQueryLocalInterface : new rs4(strongBinder);
        }
        parcelD.recycle();
        return rs4Var;
    }
}
