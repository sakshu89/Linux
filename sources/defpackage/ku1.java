package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ku1 extends or2 implements Parcelable, mm2 {
    public static final Parcelable.Creator<ku1> CREATOR = new ju1(0);
    public final om2 b;
    public nm2 c;

    public ku1(Object obj, om2 om2Var) {
        this.b = om2Var;
        bm2 bm2VarJ = im2.j();
        nm2 nm2Var = new nm2(bm2VarJ.g(), obj);
        if (!(bm2VarJ instanceof hu0)) {
            nm2Var.b = new nm2(1L, obj);
        }
        this.c = nm2Var;
    }

    @Override // defpackage.nr2
    public final qr2 a() {
        return this.c;
    }

    @Override // defpackage.nr2
    public final qr2 b(qr2 qr2Var, qr2 qr2Var2, qr2 qr2Var3) {
        if (this.b.b(((nm2) qr2Var2).c, ((nm2) qr2Var3).c)) {
            return qr2Var2;
        }
        return null;
    }

    @Override // defpackage.mm2
    public final om2 c() {
        return this.b;
    }

    @Override // defpackage.nr2
    public final void d(qr2 qr2Var) {
        qr2Var.getClass();
        this.c = (nm2) qr2Var;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // defpackage.gr2
    public final Object getValue() {
        return ((nm2) im2.t(this.c, this)).c;
    }

    @Override // defpackage.mm1
    public final void setValue(Object obj) {
        bm2 bm2VarJ;
        nm2 nm2Var = (nm2) im2.h(this.c);
        if (this.b.b(nm2Var.c, obj)) {
            return;
        }
        nm2 nm2Var2 = this.c;
        synchronized (im2.c) {
            bm2VarJ = im2.j();
            ((nm2) im2.o(nm2Var2, this, bm2VarJ, nm2Var)).c = obj;
        }
        im2.n(bm2VarJ, this);
    }

    public final String toString() {
        return "MutableState(value=" + ((nm2) im2.h(this.c)).c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeValue(getValue());
        el1 el1Var = el1.f;
        om2 om2Var = this.b;
        if (g31.a(om2Var, el1Var)) {
            i2 = 0;
        } else if (g31.a(om2Var, su0.k)) {
            i2 = 1;
        } else {
            if (!g31.a(om2Var, ak1.i)) {
                og.n("Only known types of MutableState's SnapshotMutationPolicy are supported");
                return;
            }
            i2 = 2;
        }
        parcel.writeInt(i2);
    }
}
