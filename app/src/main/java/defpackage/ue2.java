package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ue2 extends m0 {
    public static final Parcelable.Creator<ue2> CREATOR = new tm2(1);
    public boolean c;

    public ue2(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.c = ((Boolean) parcel.readValue(null)).booleanValue();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SearchView.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" isIconified=");
        return ky0.o(sb, this.c, "}");
    }

    @Override // defpackage.m0, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(Boolean.valueOf(this.c));
    }
}
