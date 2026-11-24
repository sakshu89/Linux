package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ud3 extends Binder implements IInterface {
    public final /* synthetic */ int a;

    public ud3(String str, int i) {
        this.a = i;
        switch (i) {
            case 1:
                attachInterface(this, str);
                break;
            default:
                attachInterface(this, str);
                break;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        int i = this.a;
        return this;
    }

    public abstract boolean d(int i, Parcel parcel, Parcel parcel2);

    public boolean e(int i, Parcel parcel, Parcel parcel2) {
        return false;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (this.a) {
            case 0:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i, parcel, parcel2, i2)) {
                    return true;
                }
                return d(i, parcel, parcel2);
            case 1:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i, parcel, parcel2, i2)) {
                    return true;
                }
                return e(i, parcel, parcel2);
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
