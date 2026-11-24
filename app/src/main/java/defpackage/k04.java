package defpackage;

import android.accounts.Account;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k04 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    public /* synthetic */ k04(int i) {
        this.a = i;
    }

    public static void a(cu0 cu0Var, Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        int i2 = cu0Var.a;
        mz3.g(parcel, 1, 4);
        parcel.writeInt(i2);
        int i3 = cu0Var.b;
        mz3.g(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = cu0Var.c;
        mz3.g(parcel, 3, 4);
        parcel.writeInt(i4);
        mz3.b(parcel, 4, cu0Var.e);
        IBinder iBinder = cu0Var.f;
        if (iBinder != null) {
            int iE2 = mz3.e(parcel, 5);
            parcel.writeStrongBinder(iBinder);
            mz3.f(parcel, iE2);
        }
        mz3.c(parcel, 6, cu0Var.i, i);
        Bundle bundle = cu0Var.j;
        if (bundle != null) {
            int iE3 = mz3.e(parcel, 7);
            parcel.writeBundle(bundle);
            mz3.f(parcel, iE3);
        }
        mz3.a(parcel, 8, cu0Var.k, i);
        mz3.c(parcel, 10, cu0Var.n, i);
        mz3.c(parcel, 11, cu0Var.s, i);
        boolean z = cu0Var.t;
        mz3.g(parcel, 12, 4);
        parcel.writeInt(z ? 1 : 0);
        int i5 = cu0Var.u;
        mz3.g(parcel, 13, 4);
        parcel.writeInt(i5);
        boolean z2 = cu0Var.v;
        mz3.g(parcel, 14, 4);
        parcel.writeInt(z2 ? 1 : 0);
        mz3.b(parcel, 15, cu0Var.w);
        mz3.f(parcel, iE);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iH = 0;
        String strB = null;
        switch (this.a) {
            case 0:
                int iL = kz3.l(parcel);
                long jI = -1;
                while (parcel.dataPosition() < iL) {
                    int i = parcel.readInt();
                    char c = (char) i;
                    if (c == 1) {
                        strB = kz3.b(parcel, i);
                    } else if (c == 2) {
                        iH = kz3.h(parcel, i);
                    } else if (c != 3) {
                        kz3.k(parcel, i);
                    } else {
                        jI = kz3.i(parcel, i);
                    }
                }
                kz3.e(parcel, iL);
                return new el0(iH, jI, strB);
            case 1:
                int iL2 = kz3.l(parcel);
                float fG = 0.0f;
                int iH2 = 0;
                int iH3 = 0;
                int iH4 = 0;
                int iH5 = 0;
                while (parcel.dataPosition() < iL2) {
                    int i2 = parcel.readInt();
                    char c2 = (char) i2;
                    if (c2 == 2) {
                        iH2 = kz3.h(parcel, i2);
                    } else if (c2 == 3) {
                        iH3 = kz3.h(parcel, i2);
                    } else if (c2 == 4) {
                        iH4 = kz3.h(parcel, i2);
                    } else if (c2 == 5) {
                        iH5 = kz3.h(parcel, i2);
                    } else if (c2 != 6) {
                        kz3.k(parcel, i2);
                    } else {
                        fG = kz3.g(parcel, i2);
                    }
                }
                kz3.e(parcel, iL2);
                return new v54(iH2, iH3, iH4, iH5, fG);
            case 2:
                int iL3 = kz3.l(parcel);
                Bundle bundle = null;
                el0[] el0VarArr = null;
                c40 c40Var = null;
                while (parcel.dataPosition() < iL3) {
                    int i3 = parcel.readInt();
                    char c3 = (char) i3;
                    if (c3 == 1) {
                        int iJ = kz3.j(parcel, i3);
                        int iDataPosition = parcel.dataPosition();
                        if (iJ == 0) {
                            bundle = null;
                        } else {
                            Bundle bundle2 = parcel.readBundle();
                            parcel.setDataPosition(iDataPosition + iJ);
                            bundle = bundle2;
                        }
                    } else if (c3 == 2) {
                        el0VarArr = (el0[]) kz3.c(parcel, i3, el0.CREATOR);
                    } else if (c3 == 3) {
                        iH = kz3.h(parcel, i3);
                    } else if (c3 != 4) {
                        kz3.k(parcel, i3);
                    } else {
                        c40Var = (c40) kz3.a(parcel, i3, c40.CREATOR);
                    }
                }
                kz3.e(parcel, iL3);
                xf4 xf4Var = new xf4();
                xf4Var.a = bundle;
                xf4Var.b = el0VarArr;
                xf4Var.c = iH;
                xf4Var.e = c40Var;
                return xf4Var;
            case 3:
                int iL4 = kz3.l(parcel);
                boolean zF = false;
                boolean zF2 = false;
                int iH6 = 0;
                r82 r82Var = null;
                int[] iArr = null;
                int[] iArr2 = null;
                while (parcel.dataPosition() < iL4) {
                    int i4 = parcel.readInt();
                    switch ((char) i4) {
                        case 1:
                            r82Var = (r82) kz3.a(parcel, i4, r82.CREATOR);
                            break;
                        case 2:
                            zF = kz3.f(parcel, i4);
                            break;
                        case 3:
                            zF2 = kz3.f(parcel, i4);
                            break;
                        case 4:
                            int iJ2 = kz3.j(parcel, i4);
                            int iDataPosition2 = parcel.dataPosition();
                            if (iJ2 != 0) {
                                int[] iArrCreateIntArray = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition2 + iJ2);
                                iArr = iArrCreateIntArray;
                            } else {
                                iArr = null;
                            }
                            break;
                        case 5:
                            iH6 = kz3.h(parcel, i4);
                            break;
                        case 6:
                            int iJ3 = kz3.j(parcel, i4);
                            int iDataPosition3 = parcel.dataPosition();
                            if (iJ3 != 0) {
                                int[] iArrCreateIntArray2 = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition3 + iJ3);
                                iArr2 = iArrCreateIntArray2;
                            } else {
                                iArr2 = null;
                            }
                            break;
                        default:
                            kz3.k(parcel, i4);
                            break;
                    }
                }
                kz3.e(parcel, iL4);
                return new c40(r82Var, zF, zF2, iArr, iH6, iArr2);
            case 4:
                int iL5 = kz3.l(parcel);
                float fG2 = 0.0f;
                int iH7 = 0;
                boolean zF3 = false;
                int iH8 = 0;
                int iH9 = 0;
                rp4[] rp4VarArr = null;
                v54 v54Var = null;
                v54 v54Var2 = null;
                v54 v54Var3 = null;
                String strB2 = null;
                String strB3 = null;
                while (parcel.dataPosition() < iL5) {
                    int i5 = parcel.readInt();
                    switch ((char) i5) {
                        case 2:
                            rp4VarArr = (rp4[]) kz3.c(parcel, i5, rp4.CREATOR);
                            break;
                        case 3:
                            v54Var = (v54) kz3.a(parcel, i5, v54.CREATOR);
                            break;
                        case 4:
                            v54Var2 = (v54) kz3.a(parcel, i5, v54.CREATOR);
                            break;
                        case 5:
                            v54Var3 = (v54) kz3.a(parcel, i5, v54.CREATOR);
                            break;
                        case 6:
                            strB2 = kz3.b(parcel, i5);
                            break;
                        case 7:
                            fG2 = kz3.g(parcel, i5);
                            break;
                        case '\b':
                            strB3 = kz3.b(parcel, i5);
                            break;
                        case '\t':
                            iH7 = kz3.h(parcel, i5);
                            break;
                        case '\n':
                            zF3 = kz3.f(parcel, i5);
                            break;
                        case 11:
                            iH8 = kz3.h(parcel, i5);
                            break;
                        case '\f':
                            iH9 = kz3.h(parcel, i5);
                            break;
                        default:
                            kz3.k(parcel, i5);
                            break;
                    }
                }
                kz3.e(parcel, iL5);
                return new zh4(rp4VarArr, v54Var, v54Var2, v54Var3, strB2, fG2, strB3, iH7, zF3, iH8, iH9);
            case 5:
                int iL6 = kz3.l(parcel);
                Bundle bundle3 = new Bundle();
                Scope[] scopeArr = cu0.x;
                el0[] el0VarArr2 = cu0.H;
                el0[] el0VarArr3 = el0VarArr2;
                int iH10 = 0;
                int iH11 = 0;
                int iH12 = 0;
                boolean zF4 = false;
                int iH13 = 0;
                boolean zF5 = false;
                String strB4 = null;
                IBinder iBinder = null;
                Account account = null;
                String strB5 = null;
                while (parcel.dataPosition() < iL6) {
                    int i6 = parcel.readInt();
                    switch ((char) i6) {
                        case 1:
                            iH10 = kz3.h(parcel, i6);
                            break;
                        case 2:
                            iH11 = kz3.h(parcel, i6);
                            break;
                        case 3:
                            iH12 = kz3.h(parcel, i6);
                            break;
                        case 4:
                            strB4 = kz3.b(parcel, i6);
                            break;
                        case 5:
                            int iJ4 = kz3.j(parcel, i6);
                            int iDataPosition4 = parcel.dataPosition();
                            if (iJ4 != 0) {
                                IBinder strongBinder = parcel.readStrongBinder();
                                parcel.setDataPosition(iDataPosition4 + iJ4);
                                iBinder = strongBinder;
                            } else {
                                iBinder = null;
                            }
                            break;
                        case 6:
                            scopeArr = (Scope[]) kz3.c(parcel, i6, Scope.CREATOR);
                            break;
                        case 7:
                            int iJ5 = kz3.j(parcel, i6);
                            int iDataPosition5 = parcel.dataPosition();
                            if (iJ5 != 0) {
                                Bundle bundle4 = parcel.readBundle();
                                parcel.setDataPosition(iDataPosition5 + iJ5);
                                bundle3 = bundle4;
                            } else {
                                bundle3 = null;
                            }
                            break;
                        case '\b':
                            account = (Account) kz3.a(parcel, i6, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            kz3.k(parcel, i6);
                            break;
                        case '\n':
                            el0VarArr2 = (el0[]) kz3.c(parcel, i6, el0.CREATOR);
                            break;
                        case 11:
                            el0VarArr3 = (el0[]) kz3.c(parcel, i6, el0.CREATOR);
                            break;
                        case '\f':
                            zF4 = kz3.f(parcel, i6);
                            break;
                        case '\r':
                            iH13 = kz3.h(parcel, i6);
                            break;
                        case 14:
                            zF5 = kz3.f(parcel, i6);
                            break;
                        case 15:
                            strB5 = kz3.b(parcel, i6);
                            break;
                    }
                }
                kz3.e(parcel, iL6);
                return new cu0(iH10, iH11, iH12, strB4, iBinder, scopeArr, bundle3, account, el0VarArr2, el0VarArr3, zF4, iH13, zF5, strB5);
            case 6:
                int iL7 = kz3.l(parcel);
                while (parcel.dataPosition() < iL7) {
                    kz3.k(parcel, parcel.readInt());
                }
                kz3.e(parcel, iL7);
                return new ll4();
            case 7:
                int iL8 = kz3.l(parcel);
                while (parcel.dataPosition() < iL8) {
                    int i7 = parcel.readInt();
                    if (((char) i7) != 2) {
                        kz3.k(parcel, i7);
                    } else {
                        strB = kz3.b(parcel, i7);
                    }
                }
                kz3.e(parcel, iL8);
                return new nn4(strB);
            case 8:
                int iL9 = kz3.l(parcel);
                float fG3 = 0.0f;
                boolean zF6 = false;
                ll4[] ll4VarArr = null;
                v54 v54Var4 = null;
                v54 v54Var5 = null;
                String strB6 = null;
                String strB7 = null;
                while (parcel.dataPosition() < iL9) {
                    int i8 = parcel.readInt();
                    switch ((char) i8) {
                        case 2:
                            ll4VarArr = (ll4[]) kz3.c(parcel, i8, ll4.CREATOR);
                            break;
                        case 3:
                            v54Var4 = (v54) kz3.a(parcel, i8, v54.CREATOR);
                            break;
                        case 4:
                            v54Var5 = (v54) kz3.a(parcel, i8, v54.CREATOR);
                            break;
                        case 5:
                            strB6 = kz3.b(parcel, i8);
                            break;
                        case 6:
                            fG3 = kz3.g(parcel, i8);
                            break;
                        case 7:
                            strB7 = kz3.b(parcel, i8);
                            break;
                        case '\b':
                            zF6 = kz3.f(parcel, i8);
                            break;
                        default:
                            kz3.k(parcel, i8);
                            break;
                    }
                }
                kz3.e(parcel, iL9);
                return new rp4(ll4VarArr, v54Var4, v54Var5, strB6, fG3, strB7, zF6);
            case 9:
                int iL10 = kz3.l(parcel);
                String strB8 = null;
                Rect rect = null;
                ArrayList arrayListD = null;
                String strB9 = null;
                ArrayList arrayListD2 = null;
                while (parcel.dataPosition() < iL10) {
                    int i9 = parcel.readInt();
                    char c4 = (char) i9;
                    if (c4 == 1) {
                        strB8 = kz3.b(parcel, i9);
                    } else if (c4 == 2) {
                        rect = (Rect) kz3.a(parcel, i9, Rect.CREATOR);
                    } else if (c4 == 3) {
                        arrayListD = kz3.d(parcel, i9, Point.CREATOR);
                    } else if (c4 == 4) {
                        strB9 = kz3.b(parcel, i9);
                    } else if (c4 != 5) {
                        kz3.k(parcel, i9);
                    } else {
                        arrayListD2 = kz3.d(parcel, i9, zs4.CREATOR);
                    }
                }
                kz3.e(parcel, iL10);
                return new vs4(strB8, rect, arrayListD, strB9, arrayListD2);
            case 10:
                int iL11 = kz3.l(parcel);
                float fG4 = 0.0f;
                float fG5 = 0.0f;
                Rect rect2 = null;
                String strB10 = null;
                String strB11 = null;
                ArrayList arrayListD3 = null;
                ArrayList arrayListD4 = null;
                while (parcel.dataPosition() < iL11) {
                    int i10 = parcel.readInt();
                    switch ((char) i10) {
                        case 1:
                            strB10 = kz3.b(parcel, i10);
                            break;
                        case 2:
                            rect2 = (Rect) kz3.a(parcel, i10, Rect.CREATOR);
                            break;
                        case 3:
                            arrayListD3 = kz3.d(parcel, i10, Point.CREATOR);
                            break;
                        case 4:
                            strB11 = kz3.b(parcel, i10);
                            break;
                        case 5:
                            fG4 = kz3.g(parcel, i10);
                            break;
                        case 6:
                            fG5 = kz3.g(parcel, i10);
                            break;
                        case 7:
                            arrayListD4 = kz3.d(parcel, i10, ct4.CREATOR);
                            break;
                        default:
                            kz3.k(parcel, i10);
                            break;
                    }
                }
                kz3.e(parcel, iL11);
                return new ys4(fG4, fG5, rect2, strB10, strB11, arrayListD3, arrayListD4);
            case 11:
                int iL12 = kz3.l(parcel);
                float fG6 = 0.0f;
                float fG7 = 0.0f;
                Rect rect3 = null;
                String strB12 = null;
                String strB13 = null;
                ArrayList arrayListD5 = null;
                ArrayList arrayListD6 = null;
                while (parcel.dataPosition() < iL12) {
                    int i11 = parcel.readInt();
                    switch ((char) i11) {
                        case 1:
                            strB12 = kz3.b(parcel, i11);
                            break;
                        case 2:
                            rect3 = (Rect) kz3.a(parcel, i11, Rect.CREATOR);
                            break;
                        case 3:
                            arrayListD5 = kz3.d(parcel, i11, Point.CREATOR);
                            break;
                        case 4:
                            strB13 = kz3.b(parcel, i11);
                            break;
                        case 5:
                            arrayListD6 = kz3.d(parcel, i11, ys4.CREATOR);
                            break;
                        case 6:
                            fG6 = kz3.g(parcel, i11);
                            break;
                        case 7:
                            fG7 = kz3.g(parcel, i11);
                            break;
                        default:
                            kz3.k(parcel, i11);
                            break;
                    }
                }
                kz3.e(parcel, iL12);
                return new zs4(fG6, fG7, rect3, strB12, strB13, arrayListD5, arrayListD6);
            case 12:
                int iL13 = kz3.l(parcel);
                ArrayList arrayListD7 = null;
                while (parcel.dataPosition() < iL13) {
                    int i12 = parcel.readInt();
                    char c5 = (char) i12;
                    if (c5 == 1) {
                        strB = kz3.b(parcel, i12);
                    } else if (c5 != 2) {
                        kz3.k(parcel, i12);
                    } else {
                        arrayListD7 = kz3.d(parcel, i12, vs4.CREATOR);
                    }
                }
                kz3.e(parcel, iL13);
                return new at4(strB, arrayListD7);
            case 13:
                int iL14 = kz3.l(parcel);
                boolean zF7 = false;
                int iH14 = 0;
                boolean zF8 = false;
                String strB14 = null;
                String strB15 = null;
                String strB16 = null;
                String strB17 = null;
                while (parcel.dataPosition() < iL14) {
                    int i13 = parcel.readInt();
                    switch ((char) i13) {
                        case 1:
                            strB14 = kz3.b(parcel, i13);
                            break;
                        case 2:
                            strB15 = kz3.b(parcel, i13);
                            break;
                        case 3:
                            strB16 = kz3.b(parcel, i13);
                            break;
                        case 4:
                            zF7 = kz3.f(parcel, i13);
                            break;
                        case 5:
                            iH14 = kz3.h(parcel, i13);
                            break;
                        case 6:
                            strB17 = kz3.b(parcel, i13);
                            break;
                        case 7:
                            zF8 = kz3.f(parcel, i13);
                            break;
                        default:
                            kz3.k(parcel, i13);
                            break;
                    }
                }
                kz3.e(parcel, iL14);
                return new bt4(strB14, strB15, strB16, zF7, iH14, strB17, zF8);
            default:
                int iL15 = kz3.l(parcel);
                float fG8 = 0.0f;
                float fG9 = 0.0f;
                String strB18 = null;
                Rect rect4 = null;
                ArrayList arrayListD8 = null;
                while (parcel.dataPosition() < iL15) {
                    int i14 = parcel.readInt();
                    char c6 = (char) i14;
                    if (c6 == 1) {
                        strB18 = kz3.b(parcel, i14);
                    } else if (c6 == 2) {
                        rect4 = (Rect) kz3.a(parcel, i14, Rect.CREATOR);
                    } else if (c6 == 3) {
                        arrayListD8 = kz3.d(parcel, i14, Point.CREATOR);
                    } else if (c6 == 4) {
                        fG8 = kz3.g(parcel, i14);
                    } else if (c6 != 5) {
                        kz3.k(parcel, i14);
                    } else {
                        fG9 = kz3.g(parcel, i14);
                    }
                }
                kz3.e(parcel, iL15);
                return new ct4(strB18, rect4, arrayListD8, fG8, fG9);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new el0[i];
            case 1:
                return new v54[i];
            case 2:
                return new xf4[i];
            case 3:
                return new c40[i];
            case 4:
                return new zh4[i];
            case 5:
                return new cu0[i];
            case 6:
                return new ll4[i];
            case 7:
                return new nn4[i];
            case 8:
                return new rp4[i];
            case 9:
                return new vs4[i];
            case 10:
                return new ys4[i];
            case 11:
                return new zs4[i];
            case 12:
                return new at4[i];
            case 13:
                return new bt4[i];
            default:
                return new ct4[i];
        }
    }
}
