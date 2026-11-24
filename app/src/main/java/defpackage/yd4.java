package defpackage;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yd4 extends ud3 implements IInterface {
    public final int b;

    public yd4(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData", 1);
        if (bArr.length == 25) {
            this.b = Arrays.hashCode(bArr);
        } else {
            dk0.v();
            throw null;
        }
    }

    public static byte[] f(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            og.m(e);
            return null;
        }
    }

    @Override // defpackage.ud3
    public final boolean e(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            ap1 ap1Var = new ap1(g());
            parcel2.writeNoException();
            i04.c(parcel2, ap1Var);
            return true;
        }
        if (i != 2) {
            return false;
        }
        parcel2.writeNoException();
        parcel2.writeInt(this.b);
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof yd4)) {
            try {
                yd4 yd4Var = (yd4) obj;
                if (yd4Var.b == this.b) {
                    return Arrays.equals(g(), (byte[]) ap1.g(new ap1(yd4Var.g())));
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public abstract byte[] g();

    public final int hashCode() {
        return this.b;
    }
}
