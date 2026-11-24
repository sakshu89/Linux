package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import defpackage.a4;
import defpackage.ky0;
import defpackage.mz3;
import defpackage.q91;
import defpackage.sr4;
import defpackage.x1;
import defpackage.x30;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class Status extends x1 implements ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new a4(28);
    public final int a;
    public final String b;
    public final PendingIntent c;
    public final x30 e;

    public Status(int i, String str, PendingIntent pendingIntent, x30 x30Var) {
        this.a = i;
        this.b = str;
        this.c = pendingIntent;
        this.e = x30Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.a == status.a && sr4.a(this.b, status.b) && sr4.a(this.c, status.c) && sr4.a(this.e, status.e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), this.b, this.c, this.e});
    }

    public final String toString() {
        q91 q91Var = new q91(14, this);
        String strH = this.b;
        if (strH == null) {
            int i = this.a;
            switch (i) {
                case -1:
                    strH = "SUCCESS_CACHE";
                    break;
                case 0:
                    strH = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    strH = ky0.h(i, "unknown status code: ");
                    break;
                case 2:
                    strH = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    strH = "SERVICE_DISABLED";
                    break;
                case 4:
                    strH = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    strH = "INVALID_ACCOUNT";
                    break;
                case 6:
                    strH = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    strH = "NETWORK_ERROR";
                    break;
                case 8:
                    strH = "INTERNAL_ERROR";
                    break;
                case 10:
                    strH = "DEVELOPER_ERROR";
                    break;
                case 13:
                    strH = "ERROR";
                    break;
                case 14:
                    strH = "INTERRUPTED";
                    break;
                case 15:
                    strH = "TIMEOUT";
                    break;
                case 16:
                    strH = "CANCELED";
                    break;
                case 17:
                    strH = "API_NOT_CONNECTED";
                    break;
                case 18:
                    strH = "DEAD_CLIENT";
                    break;
                case 19:
                    strH = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    strH = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    strH = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    strH = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        q91Var.u(strH, "statusCode");
        q91Var.u(this.c, "resolution");
        return q91Var.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.g(parcel, 1, 4);
        parcel.writeInt(this.a);
        mz3.b(parcel, 2, this.b);
        mz3.a(parcel, 3, this.c, i);
        mz3.a(parcel, 4, this.e, i);
        mz3.f(parcel, iE);
    }
}
