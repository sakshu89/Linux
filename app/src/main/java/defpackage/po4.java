package defpackage;

import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class po4 extends qd3 {
    public final ly0 f(ap1 ap1Var, String str, int i) {
        Parcel parcelC = c();
        i04.c(parcelC, ap1Var);
        parcelC.writeString(str);
        parcelC.writeInt(i);
        Parcel parcelB = b(parcelC, 2);
        ly0 ly0VarF = ap1.f(parcelB.readStrongBinder());
        parcelB.recycle();
        return ly0VarF;
    }

    public final ly0 g(ap1 ap1Var, String str, int i, ap1 ap1Var2) {
        Parcel parcelC = c();
        i04.c(parcelC, ap1Var);
        parcelC.writeString(str);
        parcelC.writeInt(i);
        i04.c(parcelC, ap1Var2);
        Parcel parcelB = b(parcelC, 8);
        ly0 ly0VarF = ap1.f(parcelB.readStrongBinder());
        parcelB.recycle();
        return ly0VarF;
    }

    public final ly0 h(ap1 ap1Var, String str, int i) {
        Parcel parcelC = c();
        i04.c(parcelC, ap1Var);
        parcelC.writeString(str);
        parcelC.writeInt(i);
        Parcel parcelB = b(parcelC, 4);
        ly0 ly0VarF = ap1.f(parcelB.readStrongBinder());
        parcelB.recycle();
        return ly0VarF;
    }

    public final ly0 i(ap1 ap1Var, String str, boolean z, long j) {
        Parcel parcelC = c();
        i04.c(parcelC, ap1Var);
        parcelC.writeString(str);
        parcelC.writeInt(z ? 1 : 0);
        parcelC.writeLong(j);
        Parcel parcelB = b(parcelC, 7);
        ly0 ly0VarF = ap1.f(parcelB.readStrongBinder());
        parcelB.recycle();
        return ly0VarF;
    }
}
