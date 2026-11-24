package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class av {
    public final ArrayList a;
    public final ArrayList b;
    public final boolean c;
    public final boolean d;

    public av(ArrayList arrayList, ArrayList arrayList2, boolean z, boolean z2) {
        this.a = arrayList;
        this.b = arrayList2;
        this.c = z;
        this.d = z2;
    }

    public final boolean a(boolean z) {
        boolean z2 = this.c;
        ArrayList arrayList = this.b;
        if (z) {
            return !arrayList.isEmpty() || z2;
        }
        if (!arrayList.isEmpty() || z2) {
            return false;
        }
        return !this.a.isEmpty() || this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof av)) {
            return false;
        }
        av avVar = (av) obj;
        return this.a.equals(avVar.a) && this.b.equals(avVar.b) && this.c == avVar.c && this.d == avVar.d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.d) + ky0.e((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, this.c);
    }

    public final String toString() {
        return "Evidence(start=" + this.a + ", stop=" + this.b + ", recordingIndicator=" + this.c + ", review=" + this.d + ")";
    }
}
