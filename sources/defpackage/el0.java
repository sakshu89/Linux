package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class el0 extends x1 {
    public static final Parcelable.Creator<el0> CREATOR = new k04(0);
    public final String a;
    public final int b;
    public final long c;

    public el0(long j, String str) {
        this.a = str;
        this.c = j;
        this.b = -1;
    }

    public final long a() {
        long j = this.c;
        return j == -1 ? this.b : j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof el0) {
            el0 el0Var = (el0) obj;
            String str = el0Var.a;
            String str2 = this.a;
            if (((str2 != null && str2.equals(str)) || (str2 == null && str == null)) && a() == el0Var.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Long.valueOf(a())});
    }

    public final String toString() {
        q91 q91Var = new q91(14, this);
        q91Var.u(this.a, "name");
        q91Var.u(Long.valueOf(a()), "version");
        return q91Var.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.b(parcel, 1, this.a);
        mz3.g(parcel, 2, 4);
        parcel.writeInt(this.b);
        long jA = a();
        mz3.g(parcel, 3, 8);
        parcel.writeLong(jA);
        mz3.f(parcel, iE);
    }

    public el0(int i, long j, String str) {
        this.a = str;
        this.b = i;
        this.c = j;
    }
}
