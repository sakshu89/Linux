package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class hr3 extends pk3 implements ir3 {
    public static ir3 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
        return iInterfaceQueryLocalInterface instanceof ir3 ? (ir3) iInterfaceQueryLocalInterface : new gr3(iBinder);
    }

    @Override // defpackage.pk3
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            ly0 ly0VarF = ap1.f(parcel.readStrongBinder());
            hl3.a(parcel);
            IInterface iInterfaceNewTextRecognizer = newTextRecognizer(ly0VarF);
            parcel2.writeNoException();
            if (iInterfaceNewTextRecognizer == null) {
                parcel2.writeStrongBinder(null);
                return true;
            }
            parcel2.writeStrongBinder(((pk3) iInterfaceNewTextRecognizer).asBinder());
            return true;
        }
        if (i != 2) {
            return false;
        }
        ly0 ly0VarF2 = ap1.f(parcel.readStrongBinder());
        Parcelable.Creator<nr3> creator = nr3.CREATOR;
        int i2 = hl3.a;
        nr3 nr3VarCreateFromParcel = parcel.readInt() == 0 ? null : creator.createFromParcel(parcel);
        hl3.a(parcel);
        IInterface iInterfaceNewTextRecognizerWithOptions = newTextRecognizerWithOptions(ly0VarF2, nr3VarCreateFromParcel);
        parcel2.writeNoException();
        if (iInterfaceNewTextRecognizerWithOptions == null) {
            parcel2.writeStrongBinder(null);
            return true;
        }
        parcel2.writeStrongBinder(((pk3) iInterfaceNewTextRecognizerWithOptions).asBinder());
        return true;
    }
}
