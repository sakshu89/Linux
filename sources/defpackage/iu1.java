package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class iu1 extends or2 implements Parcelable, mm2, gr2, mm1 {
    public static final Parcelable.Creator<iu1> CREATOR = new a4(6);
    public lm2 b;

    public iu1(long j) {
        bm2 bm2VarJ = im2.j();
        lm2 lm2Var = new lm2(bm2VarJ.g(), j);
        if (!(bm2VarJ instanceof hu0)) {
            lm2Var.b = new lm2(1L, j);
        }
        this.b = lm2Var;
    }

    @Override // defpackage.nr2
    public final qr2 a() {
        return this.b;
    }

    @Override // defpackage.nr2
    public final qr2 b(qr2 qr2Var, qr2 qr2Var2, qr2 qr2Var3) {
        if (((lm2) qr2Var2).c == ((lm2) qr2Var3).c) {
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
        this.b = (lm2) qr2Var;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final long g() {
        return ((lm2) im2.t(this.b, this)).c;
    }

    @Override // defpackage.gr2
    public final Object getValue() {
        return Long.valueOf(g());
    }

    public final void h(long j) {
        bm2 bm2VarJ;
        lm2 lm2Var = (lm2) im2.h(this.b);
        if (lm2Var.c != j) {
            lm2 lm2Var2 = this.b;
            synchronized (im2.c) {
                bm2VarJ = im2.j();
                ((lm2) im2.o(lm2Var2, this, bm2VarJ, lm2Var)).c = j;
            }
            im2.n(bm2VarJ, this);
        }
    }

    @Override // defpackage.mm1
    public final void setValue(Object obj) {
        h(((Number) obj).longValue());
    }

    public final String toString() {
        return "MutableLongState(value=" + ((lm2) im2.h(this.b)).c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(g());
    }
}
