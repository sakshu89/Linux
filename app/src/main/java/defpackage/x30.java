package defpackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x30 extends x1 {
    public final int a;
    public final int b;
    public final PendingIntent c;
    public final String e;
    public static final x30 f = new x30(0);
    public static final Parcelable.Creator<x30> CREATOR = new a4(29);

    public x30(int i, int i2, PendingIntent pendingIntent, String str) {
        this.a = i;
        this.b = i2;
        this.c = pendingIntent;
        this.e = str;
    }

    public static String a(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return cq.h("UNKNOWN_ERROR_CODE(", i, ")");
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x30)) {
            return false;
        }
        x30 x30Var = (x30) obj;
        return this.b == x30Var.b && sr4.a(this.c, x30Var.c) && sr4.a(this.e, x30Var.e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.c, this.e});
    }

    public final String toString() {
        q91 q91Var = new q91(14, this);
        q91Var.u(a(this.b), "statusCode");
        q91Var.u(this.c, "resolution");
        q91Var.u(this.e, "message");
        return q91Var.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.g(parcel, 1, 4);
        parcel.writeInt(this.a);
        mz3.g(parcel, 2, 4);
        parcel.writeInt(this.b);
        mz3.a(parcel, 3, this.c, i);
        mz3.b(parcel, 4, this.e);
        mz3.f(parcel, iE);
    }

    public x30(int i) {
        this(1, i, null, null);
    }

    public x30(int i, PendingIntent pendingIntent) {
        this(1, i, pendingIntent, null);
    }
}
