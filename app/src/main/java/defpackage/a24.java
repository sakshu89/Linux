package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.text.latin.ModuleDescriptor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a24 implements xj4 {
    public final Context a;
    public final qz2 b;
    public boolean c;
    public boolean d;
    public final ns4 e;
    public rs4 f;

    public a24(Context context, qz2 qz2Var, ns4 ns4Var) {
        this.a = context;
        this.b = qz2Var;
        this.e = ns4Var;
    }

    @Override // defpackage.xj4
    public final uw2 a(k11 k11Var) throws uj1 {
        ap1 ap1Var;
        if (this.f == null) {
            zzb();
        }
        rs4 rs4Var = this.f;
        jg1.d(rs4Var);
        if (!this.c) {
            try {
                rs4Var.e(rs4Var.c(), 1);
                this.c = true;
            } catch (RemoteException e) {
                throw new uj1("Failed to init text recognizer ".concat(this.b.b()), e);
            }
        }
        int i = k11Var.d;
        int i2 = k11Var.b;
        int i3 = k11Var.c;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i4 = k11Var.d;
        at4 at4VarCreateFromParcel = null;
        if (i4 != -1) {
            if (i4 != 17) {
                if (i4 == 35) {
                    ap1Var = new ap1(null);
                } else if (i4 != 842094169) {
                    throw new uj1(ky0.h(k11Var.d, "Unsupported image format: "), 3);
                }
            }
            jg1.d(null);
            throw null;
        }
        Bitmap bitmap = k11Var.a;
        jg1.d(bitmap);
        ap1Var = new ap1(bitmap);
        try {
            Parcel parcelC = rs4Var.c();
            int i5 = j04.a;
            parcelC.writeStrongBinder(ap1Var);
            parcelC.writeInt(1);
            int iE = mz3.e(parcelC, 20293);
            mz3.g(parcelC, 1, 4);
            parcelC.writeInt(i);
            mz3.g(parcelC, 2, 4);
            parcelC.writeInt(i2);
            mz3.g(parcelC, 3, 4);
            parcelC.writeInt(i3);
            mz3.g(parcelC, 4, 4);
            parcelC.writeInt(0);
            mz3.g(parcelC, 5, 8);
            parcelC.writeLong(jElapsedRealtime);
            mz3.f(parcelC, iE);
            Parcel parcelD = rs4Var.d(parcelC, 3);
            Parcelable.Creator<at4> creator = at4.CREATOR;
            if (parcelD.readInt() != 0) {
                at4VarCreateFromParcel = creator.createFromParcel(parcelD);
            }
            parcelD.recycle();
            return new uw2(at4VarCreateFromParcel);
        } catch (RemoteException e2) {
            throw new uj1("Failed to run text recognizer ".concat(this.b.b()), e2);
        }
    }

    @Override // defpackage.xj4
    public final void b() {
        rs4 rs4Var = this.f;
        if (rs4Var != null) {
            try {
                rs4Var.e(rs4Var.c(), 2);
            } catch (RemoteException e) {
                Log.e("DecoupledTextDelegate", "Failed to release text recognizer ".concat(this.b.b()), e);
            }
            this.f = null;
        }
        this.c = false;
    }

    @Override // defpackage.xj4
    public final void zzb() throws uj1 {
        rs4 rs4VarF;
        ns4 ns4Var = this.e;
        Context context = this.a;
        qz2 qz2Var = this.b;
        if (this.f != null) {
            return;
        }
        try {
            boolean zA = qz2Var.a();
            IInterface ss4Var = null;
            String str = ModuleDescriptor.MODULE_ID;
            if (zA) {
                xy xyVar = sg0.c;
                if (true != qz2Var.a()) {
                    str = "com.google.android.gms.vision.ocr";
                }
                IBinder iBinderB = sg0.c(context, xyVar, str).b("com.google.mlkit.vision.text.bundled.common.BundledTextRecognizerCreator");
                int i = ts4.b;
                if (iBinderB != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
                    ss4Var = iInterfaceQueryLocalInterface instanceof us4 ? (us4) iInterfaceQueryLocalInterface : new ss4(iBinderB, "com.google.mlkit.vision.text.aidls.ITextRecognizerCreator", 2);
                }
                rs4VarF = ((ss4) ss4Var).g(new ap1(context), new bt4(qz2Var.b, "optional-module-text-latin", null, true, 1, "en", false));
            } else {
                nr4 nr4Var = sg0.b;
                if (true != qz2Var.a()) {
                    str = "com.google.android.gms.vision.ocr";
                }
                IBinder iBinderB2 = sg0.c(context, nr4Var, str).b("com.google.android.gms.vision.text.mlkit.TextRecognizerCreator");
                int i2 = ts4.b;
                if (iBinderB2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = iBinderB2.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
                    ss4Var = iInterfaceQueryLocalInterface2 instanceof us4 ? (us4) iInterfaceQueryLocalInterface2 : new ss4(iBinderB2, "com.google.mlkit.vision.text.aidls.ITextRecognizerCreator", 2);
                }
                rs4VarF = ((ss4) ss4Var).f(new ap1(context));
            }
            this.f = rs4VarF;
            ns4Var.b(new jb(qz2Var.a(), in4.NO_ERROR), jn4.ON_DEVICE_TEXT_LOAD);
        } catch (RemoteException e) {
            ns4Var.b(new jb(qz2Var.a(), in4.OPTIONAL_MODULE_INIT_ERROR), jn4.ON_DEVICE_TEXT_LOAD);
            throw new uj1("Failed to create text recognizer ".concat(qz2Var.b()), e);
        } catch (og0 e2) {
            ns4Var.b(new jb(qz2Var.a(), in4.OPTIONAL_MODULE_NOT_AVAILABLE), jn4.ON_DEVICE_TEXT_LOAD);
            if (qz2Var.a()) {
                throw new uj1(cq.l("Failed to load text module ", qz2Var.b(), ". ", e2.getMessage()), e2);
            }
            if (!this.d) {
                ds1.b(context, qz2Var.a() ? ds1.a : new el0[]{ds1.b});
                this.d = true;
            }
            throw new uj1("Waiting for the text optional module to be downloaded. Please wait.", 14);
        }
    }
}
