package defpackage;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ue3 extends ud3 implements IInterface {
    public final /* synthetic */ iw2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ue3(iw2 iw2Var) {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallCallbacks", 0);
        this.b = iw2Var;
    }

    @Override // defpackage.ud3
    public final boolean d(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            be3.b(parcel);
            dk0.p();
            return false;
        }
        if (i == 2) {
            Status status = (Status) be3.a(parcel, Status.CREATOR);
            lk1 lk1Var = (lk1) be3.a(parcel, lk1.CREATOR);
            be3.b(parcel);
            int i2 = status.a;
            iw2 iw2Var = this.b;
            if (i2 <= 0) {
                iw2Var.a.g(lk1Var);
            } else {
                iw2Var.a(status.c != null ? new n62(status) : new qe(status));
            }
            return true;
        }
        if (i == 3) {
            be3.b(parcel);
            dk0.p();
            return false;
        }
        if (i != 4) {
            return false;
        }
        be3.b(parcel);
        dk0.p();
        return false;
    }
}
