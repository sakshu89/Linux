package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import defpackage.a4;
import defpackage.jg1;
import defpackage.mz3;
import defpackage.x1;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class Scope extends x1 implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new a4(26);
    public final int a;
    public final String b;

    public Scope(int i, String str) {
        jg1.c(str, "scopeUri must not be null or empty");
        this.a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.b.equals(((Scope) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.g(parcel, 1, 4);
        parcel.writeInt(this.a);
        mz3.b(parcel, 2, this.b);
        mz3.f(parcel, iE);
    }
}
