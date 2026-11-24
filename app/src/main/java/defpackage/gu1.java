package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gu1 extends or2 implements Parcelable, mm2, gr2, mm1 {
    public static final Parcelable.Creator<gu1> CREATOR = new a4(4);
    public jm2 b;

    public gu1(float f) {
        bm2 bm2VarJ = im2.j();
        jm2 jm2Var = new jm2(f, bm2VarJ.g());
        if (!(bm2VarJ instanceof hu0)) {
            jm2Var.b = new jm2(f, 1L);
        }
        this.b = jm2Var;
    }

    @Override // defpackage.nr2
    public final qr2 a() {
        return this.b;
    }

    @Override // defpackage.nr2
    public final qr2 b(qr2 qr2Var, qr2 qr2Var2, qr2 qr2Var3) {
        if (((jm2) qr2Var2).c == ((jm2) qr2Var3).c) {
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
        this.b = (jm2) qr2Var;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final float g() {
        return ((jm2) im2.t(this.b, this)).c;
    }

    @Override // defpackage.gr2
    public final Object getValue() {
        return Float.valueOf(g());
    }

    public final void h(float f) {
        bm2 bm2VarJ;
        jm2 jm2Var = (jm2) im2.h(this.b);
        if (jm2Var.c == f) {
            return;
        }
        jm2 jm2Var2 = this.b;
        synchronized (im2.c) {
            bm2VarJ = im2.j();
            ((jm2) im2.o(jm2Var2, this, bm2VarJ, jm2Var)).c = f;
        }
        im2.n(bm2VarJ, this);
    }

    @Override // defpackage.mm1
    public final void setValue(Object obj) {
        h(((Number) obj).floatValue());
    }

    public final String toString() {
        return "MutableFloatState(value=" + ((jm2) im2.h(this.b)).c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(g());
    }
}
