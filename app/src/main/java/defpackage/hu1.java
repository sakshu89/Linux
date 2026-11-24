package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hu1 extends or2 implements Parcelable, mm2, gr2, mm1 {
    public static final Parcelable.Creator<hu1> CREATOR = new a4(5);
    public km2 b;

    public hu1(int i) {
        bm2 bm2VarJ = im2.j();
        km2 km2Var = new km2(i, bm2VarJ.g());
        if (!(bm2VarJ instanceof hu0)) {
            km2Var.b = new km2(i, 1L);
        }
        this.b = km2Var;
    }

    @Override // defpackage.nr2
    public final qr2 a() {
        return this.b;
    }

    @Override // defpackage.nr2
    public final qr2 b(qr2 qr2Var, qr2 qr2Var2, qr2 qr2Var3) {
        if (((km2) qr2Var2).c == ((km2) qr2Var3).c) {
            return qr2Var2;
        }
        return null;
    }

    @Override // defpackage.mm2
    public final om2 c() {
        return su0.k;
    }

    @Override // defpackage.nr2
    public final void d(qr2 qr2Var) {
        qr2Var.getClass();
        this.b = (km2) qr2Var;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int g() {
        return ((km2) im2.t(this.b, this)).c;
    }

    @Override // defpackage.gr2
    public final Object getValue() {
        return Integer.valueOf(g());
    }

    public final void h(int i) {
        bm2 bm2VarJ;
        km2 km2Var = (km2) im2.h(this.b);
        if (km2Var.c != i) {
            km2 km2Var2 = this.b;
            synchronized (im2.c) {
                bm2VarJ = im2.j();
                ((km2) im2.o(km2Var2, this, bm2VarJ, km2Var)).c = i;
            }
            im2.n(bm2VarJ, this);
        }
    }

    @Override // defpackage.mm1
    public final void setValue(Object obj) {
        h(((Number) obj).intValue());
    }

    public final String toString() {
        return "MutableIntState(value=" + ((km2) im2.h(this.b)).c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(g());
    }
}
