package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class qd3 implements IInterface {
    public final /* synthetic */ int a;
    public final IBinder b;
    public final String c;

    public /* synthetic */ qd3(IBinder iBinder, String str, int i) {
        this.a = i;
        this.b = iBinder;
        this.c = str;
    }

    public void a(Parcel parcel, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.b.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.b;
    }

    public Parcel b(Parcel parcel, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.b.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }

    public Parcel c() {
        int i = this.a;
        String str = this.c;
        switch (i) {
            case 1:
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken(str);
                return parcelObtain;
            default:
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain2.writeInterfaceToken(str);
                return parcelObtain2;
        }
    }

    public Parcel d(Parcel parcel, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.b.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }

    public void e(Parcel parcel, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.b.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
