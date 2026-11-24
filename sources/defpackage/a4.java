package defpackage;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a4 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    public /* synthetic */ a4(int i) {
        this.a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        boolean zF = false;
        int iH = 0;
        int iH2 = 0;
        int iH3 = 0;
        int iH4 = 0;
        int iH5 = 0;
        int iH6 = 0;
        boolean zF2 = false;
        int iH7 = 0;
        int iH8 = 0;
        PendingIntent pendingIntent = null;
        String strB = null;
        String strB2 = null;
        String strB3 = null;
        Account account = null;
        x30 x30Var = null;
        ArrayList arrayListD = null;
        Intent intent = null;
        PendingIntent pendingIntent2 = null;
        ArrayList arrayListD2 = null;
        switch (this.a) {
            case 0:
                parcel.getClass();
                return new b4(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
            case 1:
                return new ra0(parcel.readInt());
            case 2:
                parcel.getClass();
                Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                parcelable.getClass();
                return new p21((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 3:
                return new ParcelImpl(parcel);
            case 4:
                return new gu1(parcel.readFloat());
            case 5:
                return new hu1(parcel.readInt());
            case 6:
                return new iu1(parcel.readLong());
            case 7:
                int iL = kz3.l(parcel);
                int iH9 = 0;
                while (parcel.dataPosition() < iL) {
                    int i = parcel.readInt();
                    char c = (char) i;
                    if (c == 1) {
                        zF = kz3.f(parcel, i);
                    } else if (c != 2) {
                        kz3.k(parcel, i);
                    } else {
                        iH9 = kz3.h(parcel, i);
                    }
                }
                kz3.e(parcel, iL);
                return new jk1(zF, iH9);
            case 8:
                int iL2 = kz3.l(parcel);
                while (parcel.dataPosition() < iL2) {
                    int i2 = parcel.readInt();
                    char c2 = (char) i2;
                    if (c2 == 1) {
                        iH8 = kz3.h(parcel, i2);
                    } else if (c2 != 2) {
                        kz3.k(parcel, i2);
                    } else {
                        arrayListD2 = kz3.d(parcel, i2, mj1.CREATOR);
                    }
                }
                kz3.e(parcel, iL2);
                return new ow2(iH8, arrayListD2);
            case 9:
                int iL3 = kz3.l(parcel);
                while (parcel.dataPosition() < iL3) {
                    int i3 = parcel.readInt();
                    if (((char) i3) != 1) {
                        kz3.k(parcel, i3);
                    } else {
                        pendingIntent2 = (PendingIntent) kz3.a(parcel, i3, PendingIntent.CREATOR);
                    }
                }
                kz3.e(parcel, iL3);
                return new kk1(pendingIntent2);
            case 10:
                int iL4 = kz3.l(parcel);
                int iH10 = 0;
                while (parcel.dataPosition() < iL4) {
                    int i4 = parcel.readInt();
                    char c3 = (char) i4;
                    if (c3 == 1) {
                        iH7 = kz3.h(parcel, i4);
                    } else if (c3 == 2) {
                        iH10 = kz3.h(parcel, i4);
                    } else if (c3 != 3) {
                        kz3.k(parcel, i4);
                    } else {
                        intent = (Intent) kz3.a(parcel, i4, Intent.CREATOR);
                    }
                }
                kz3.e(parcel, iL4);
                return new sd3(iH7, iH10, intent);
            case 11:
                int iL5 = kz3.l(parcel);
                long jI = 0;
                int iH11 = 0;
                String strB4 = null;
                String strB5 = null;
                String strB6 = null;
                String strB7 = null;
                Uri uri = null;
                String strB8 = null;
                String strB9 = null;
                ArrayList arrayListD3 = null;
                String strB10 = null;
                String strB11 = null;
                while (parcel.dataPosition() < iL5) {
                    int i5 = parcel.readInt();
                    switch ((char) i5) {
                        case 1:
                            iH11 = kz3.h(parcel, i5);
                            break;
                        case 2:
                            strB4 = kz3.b(parcel, i5);
                            break;
                        case 3:
                            strB5 = kz3.b(parcel, i5);
                            break;
                        case 4:
                            strB6 = kz3.b(parcel, i5);
                            break;
                        case 5:
                            strB7 = kz3.b(parcel, i5);
                            break;
                        case 6:
                            uri = (Uri) kz3.a(parcel, i5, Uri.CREATOR);
                            break;
                        case 7:
                            strB8 = kz3.b(parcel, i5);
                            break;
                        case '\b':
                            jI = kz3.i(parcel, i5);
                            break;
                        case '\t':
                            strB9 = kz3.b(parcel, i5);
                            break;
                        case '\n':
                            arrayListD3 = kz3.d(parcel, i5, Scope.CREATOR);
                            break;
                        case 11:
                            strB10 = kz3.b(parcel, i5);
                            break;
                        case '\f':
                            strB11 = kz3.b(parcel, i5);
                            break;
                        default:
                            kz3.k(parcel, i5);
                            break;
                    }
                }
                kz3.e(parcel, iL5);
                return new GoogleSignInAccount(iH11, strB4, strB5, strB6, strB7, uri, strB8, jI, strB9, arrayListD3, strB10, strB11);
            case 12:
                int iL6 = kz3.l(parcel);
                String strB12 = null;
                String strB13 = null;
                while (parcel.dataPosition() < iL6) {
                    int i6 = parcel.readInt();
                    char c4 = (char) i6;
                    if (c4 == 1) {
                        arrayListD = kz3.d(parcel, i6, el0.CREATOR);
                    } else if (c4 == 2) {
                        zF2 = kz3.f(parcel, i6);
                    } else if (c4 == 3) {
                        strB12 = kz3.b(parcel, i6);
                    } else if (c4 != 4) {
                        kz3.k(parcel, i6);
                    } else {
                        strB13 = kz3.b(parcel, i6);
                    }
                }
                kz3.e(parcel, iL6);
                return new re(arrayListD, zF2, strB12, strB13);
            case 13:
                int iL7 = kz3.l(parcel);
                boolean zF3 = false;
                while (parcel.dataPosition() < iL7) {
                    int i7 = parcel.readInt();
                    char c5 = (char) i7;
                    if (c5 == 1) {
                        iH6 = kz3.h(parcel, i7);
                    } else if (c5 != 2) {
                        kz3.k(parcel, i7);
                    } else {
                        zF3 = kz3.f(parcel, i7);
                    }
                }
                kz3.e(parcel, iL7);
                return new lk1(iH6, zF3);
            case 14:
                int iL8 = kz3.l(parcel);
                ArrayList<String> arrayList = null;
                String strB14 = null;
                while (parcel.dataPosition() < iL8) {
                    int i8 = parcel.readInt();
                    char c6 = (char) i8;
                    if (c6 == 1) {
                        int iJ = kz3.j(parcel, i8);
                        int iDataPosition = parcel.dataPosition();
                        if (iJ == 0) {
                            arrayList = null;
                        } else {
                            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                            parcel.setDataPosition(iDataPosition + iJ);
                            arrayList = arrayListCreateStringArrayList;
                        }
                    } else if (c6 != 2) {
                        kz3.k(parcel, i8);
                    } else {
                        strB14 = kz3.b(parcel, i8);
                    }
                }
                kz3.e(parcel, iL8);
                return new me3(strB14, arrayList);
            case 15:
                int iL9 = kz3.l(parcel);
                xe3 xe3Var = null;
                while (parcel.dataPosition() < iL9) {
                    int i9 = parcel.readInt();
                    char c7 = (char) i9;
                    if (c7 == 1) {
                        iH5 = kz3.h(parcel, i9);
                    } else if (c7 == 2) {
                        x30Var = (x30) kz3.a(parcel, i9, x30.CREATOR);
                    } else if (c7 != 3) {
                        kz3.k(parcel, i9);
                    } else {
                        xe3Var = (xe3) kz3.a(parcel, i9, xe3.CREATOR);
                    }
                }
                kz3.e(parcel, iL9);
                return new qe3(iH5, x30Var, xe3Var);
            case 16:
                int iL10 = kz3.l(parcel);
                long jI2 = 0;
                long jI3 = 0;
                int iH12 = -1;
                int iH13 = 0;
                int iH14 = 0;
                int iH15 = 0;
                int iH16 = 0;
                String strB15 = null;
                String strB16 = null;
                while (parcel.dataPosition() < iL10) {
                    int i10 = parcel.readInt();
                    switch ((char) i10) {
                        case 1:
                            iH13 = kz3.h(parcel, i10);
                            break;
                        case 2:
                            iH14 = kz3.h(parcel, i10);
                            break;
                        case 3:
                            iH15 = kz3.h(parcel, i10);
                            break;
                        case 4:
                            jI2 = kz3.i(parcel, i10);
                            break;
                        case 5:
                            jI3 = kz3.i(parcel, i10);
                            break;
                        case 6:
                            strB15 = kz3.b(parcel, i10);
                            break;
                        case 7:
                            strB16 = kz3.b(parcel, i10);
                            break;
                        case '\b':
                            iH16 = kz3.h(parcel, i10);
                            break;
                        case '\t':
                            iH12 = kz3.h(parcel, i10);
                            break;
                        default:
                            kz3.k(parcel, i10);
                            break;
                    }
                }
                kz3.e(parcel, iL10);
                return new mj1(iH13, iH14, iH15, jI2, jI3, strB15, strB16, iH16, iH12);
            case 17:
                int iL11 = kz3.l(parcel);
                int iH17 = 0;
                GoogleSignInAccount googleSignInAccount = null;
                while (parcel.dataPosition() < iL11) {
                    int i11 = parcel.readInt();
                    char c8 = (char) i11;
                    if (c8 == 1) {
                        iH4 = kz3.h(parcel, i11);
                    } else if (c8 == 2) {
                        account = (Account) kz3.a(parcel, i11, Account.CREATOR);
                    } else if (c8 == 3) {
                        iH17 = kz3.h(parcel, i11);
                    } else if (c8 != 4) {
                        kz3.k(parcel, i11);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) kz3.a(parcel, i11, GoogleSignInAccount.CREATOR);
                    }
                }
                kz3.e(parcel, iL11);
                return new ve3(iH4, account, iH17, googleSignInAccount);
            case 18:
                int iL12 = kz3.l(parcel);
                int iH18 = 0;
                boolean zF4 = false;
                boolean zF5 = false;
                IBinder iBinder = null;
                x30 x30Var2 = null;
                while (parcel.dataPosition() < iL12) {
                    int i12 = parcel.readInt();
                    char c9 = (char) i12;
                    if (c9 == 1) {
                        iH18 = kz3.h(parcel, i12);
                    } else if (c9 == 2) {
                        int iJ2 = kz3.j(parcel, i12);
                        int iDataPosition2 = parcel.dataPosition();
                        if (iJ2 == 0) {
                            iBinder = null;
                        } else {
                            IBinder strongBinder = parcel.readStrongBinder();
                            parcel.setDataPosition(iDataPosition2 + iJ2);
                            iBinder = strongBinder;
                        }
                    } else if (c9 == 3) {
                        x30Var2 = (x30) kz3.a(parcel, i12, x30.CREATOR);
                    } else if (c9 == 4) {
                        zF4 = kz3.f(parcel, i12);
                    } else if (c9 != 5) {
                        kz3.k(parcel, i12);
                    } else {
                        zF5 = kz3.f(parcel, i12);
                    }
                }
                kz3.e(parcel, iL12);
                return new xe3(iH18, iBinder, x30Var2, zF4, zF5);
            case 19:
                int iL13 = kz3.l(parcel);
                long jI4 = 0;
                int iH19 = 0;
                int iH20 = 0;
                int iH21 = 0;
                int iH22 = 0;
                while (parcel.dataPosition() < iL13) {
                    int i13 = parcel.readInt();
                    char c10 = (char) i13;
                    if (c10 == 1) {
                        iH19 = kz3.h(parcel, i13);
                    } else if (c10 == 2) {
                        iH20 = kz3.h(parcel, i13);
                    } else if (c10 == 3) {
                        iH21 = kz3.h(parcel, i13);
                    } else if (c10 == 4) {
                        iH22 = kz3.h(parcel, i13);
                    } else if (c10 != 5) {
                        kz3.k(parcel, i13);
                    } else {
                        jI4 = kz3.i(parcel, i13);
                    }
                }
                kz3.e(parcel, iL13);
                return new er3(iH19, iH20, iH21, iH22, jI4);
            case 20:
                int iL14 = kz3.l(parcel);
                String strB17 = null;
                Rect rect = null;
                ArrayList arrayListD4 = null;
                String strB18 = null;
                ArrayList arrayListD5 = null;
                while (parcel.dataPosition() < iL14) {
                    int i14 = parcel.readInt();
                    char c11 = (char) i14;
                    if (c11 == 1) {
                        strB17 = kz3.b(parcel, i14);
                    } else if (c11 == 2) {
                        rect = (Rect) kz3.a(parcel, i14, Rect.CREATOR);
                    } else if (c11 == 3) {
                        arrayListD4 = kz3.d(parcel, i14, Point.CREATOR);
                    } else if (c11 == 4) {
                        strB18 = kz3.b(parcel, i14);
                    } else if (c11 != 5) {
                        kz3.k(parcel, i14);
                    } else {
                        arrayListD5 = kz3.d(parcel, i14, lr3.CREATOR);
                    }
                }
                kz3.e(parcel, iL14);
                return new jr3(strB17, rect, arrayListD4, strB18, arrayListD5);
            case 21:
                int iL15 = kz3.l(parcel);
                float fG = 0.0f;
                float fG2 = 0.0f;
                Rect rect2 = null;
                String strB19 = null;
                String strB20 = null;
                ArrayList arrayListD6 = null;
                ArrayList arrayListD7 = null;
                while (parcel.dataPosition() < iL15) {
                    int i15 = parcel.readInt();
                    switch ((char) i15) {
                        case 1:
                            strB19 = kz3.b(parcel, i15);
                            break;
                        case 2:
                            rect2 = (Rect) kz3.a(parcel, i15, Rect.CREATOR);
                            break;
                        case 3:
                            arrayListD6 = kz3.d(parcel, i15, Point.CREATOR);
                            break;
                        case 4:
                            strB20 = kz3.b(parcel, i15);
                            break;
                        case 5:
                            fG = kz3.g(parcel, i15);
                            break;
                        case 6:
                            fG2 = kz3.g(parcel, i15);
                            break;
                        case 7:
                            arrayListD7 = kz3.d(parcel, i15, or3.CREATOR);
                            break;
                        default:
                            kz3.k(parcel, i15);
                            break;
                    }
                }
                kz3.e(parcel, iL15);
                return new kr3(fG, fG2, rect2, strB19, strB20, arrayListD6, arrayListD7);
            case 22:
                int iL16 = kz3.l(parcel);
                float fG3 = 0.0f;
                float fG4 = 0.0f;
                Rect rect3 = null;
                String strB21 = null;
                String strB22 = null;
                ArrayList arrayListD8 = null;
                ArrayList arrayListD9 = null;
                while (parcel.dataPosition() < iL16) {
                    int i16 = parcel.readInt();
                    switch ((char) i16) {
                        case 1:
                            strB21 = kz3.b(parcel, i16);
                            break;
                        case 2:
                            rect3 = (Rect) kz3.a(parcel, i16, Rect.CREATOR);
                            break;
                        case 3:
                            arrayListD8 = kz3.d(parcel, i16, Point.CREATOR);
                            break;
                        case 4:
                            strB22 = kz3.b(parcel, i16);
                            break;
                        case 5:
                            arrayListD9 = kz3.d(parcel, i16, kr3.CREATOR);
                            break;
                        case 6:
                            fG3 = kz3.g(parcel, i16);
                            break;
                        case 7:
                            fG4 = kz3.g(parcel, i16);
                            break;
                        default:
                            kz3.k(parcel, i16);
                            break;
                    }
                }
                kz3.e(parcel, iL16);
                return new lr3(fG3, fG4, rect3, strB21, strB22, arrayListD8, arrayListD9);
            case 23:
                int iL17 = kz3.l(parcel);
                ArrayList arrayListD10 = null;
                while (parcel.dataPosition() < iL17) {
                    int i17 = parcel.readInt();
                    char c12 = (char) i17;
                    if (c12 == 1) {
                        strB3 = kz3.b(parcel, i17);
                    } else if (c12 != 2) {
                        kz3.k(parcel, i17);
                    } else {
                        arrayListD10 = kz3.d(parcel, i17, jr3.CREATOR);
                    }
                }
                kz3.e(parcel, iL17);
                return new mr3(strB3, arrayListD10);
            case 24:
                int iL18 = kz3.l(parcel);
                boolean zF6 = false;
                int iH23 = 0;
                boolean zF7 = false;
                String strB23 = null;
                String strB24 = null;
                String strB25 = null;
                String strB26 = null;
                while (parcel.dataPosition() < iL18) {
                    int i18 = parcel.readInt();
                    switch ((char) i18) {
                        case 1:
                            strB23 = kz3.b(parcel, i18);
                            break;
                        case 2:
                            strB24 = kz3.b(parcel, i18);
                            break;
                        case 3:
                            strB25 = kz3.b(parcel, i18);
                            break;
                        case 4:
                            zF6 = kz3.f(parcel, i18);
                            break;
                        case 5:
                            iH23 = kz3.h(parcel, i18);
                            break;
                        case 6:
                            strB26 = kz3.b(parcel, i18);
                            break;
                        case 7:
                            zF7 = kz3.f(parcel, i18);
                            break;
                        default:
                            kz3.k(parcel, i18);
                            break;
                    }
                }
                kz3.e(parcel, iL18);
                return new nr3(strB23, strB24, strB25, zF6, iH23, strB26, zF7);
            case 25:
                int iL19 = kz3.l(parcel);
                float fG5 = 0.0f;
                float fG6 = 0.0f;
                String strB27 = null;
                Rect rect4 = null;
                ArrayList arrayListD11 = null;
                while (parcel.dataPosition() < iL19) {
                    int i19 = parcel.readInt();
                    char c13 = (char) i19;
                    if (c13 == 1) {
                        strB27 = kz3.b(parcel, i19);
                    } else if (c13 == 2) {
                        rect4 = (Rect) kz3.a(parcel, i19, Rect.CREATOR);
                    } else if (c13 == 3) {
                        arrayListD11 = kz3.d(parcel, i19, Point.CREATOR);
                    } else if (c13 == 4) {
                        fG5 = kz3.g(parcel, i19);
                    } else if (c13 != 5) {
                        kz3.k(parcel, i19);
                    } else {
                        fG6 = kz3.g(parcel, i19);
                    }
                }
                kz3.e(parcel, iL19);
                return new or3(strB27, rect4, arrayListD11, fG5, fG6);
            case 26:
                int iL20 = kz3.l(parcel);
                while (parcel.dataPosition() < iL20) {
                    int i20 = parcel.readInt();
                    char c14 = (char) i20;
                    if (c14 == 1) {
                        iH3 = kz3.h(parcel, i20);
                    } else if (c14 != 2) {
                        kz3.k(parcel, i20);
                    } else {
                        strB2 = kz3.b(parcel, i20);
                    }
                }
                kz3.e(parcel, iL20);
                return new Scope(iH3, strB2);
            case 27:
                int iL21 = kz3.l(parcel);
                int iH24 = 0;
                int iH25 = 0;
                int iH26 = 0;
                boolean zF8 = false;
                boolean zF9 = false;
                while (parcel.dataPosition() < iL21) {
                    int i21 = parcel.readInt();
                    char c15 = (char) i21;
                    if (c15 == 1) {
                        iH24 = kz3.h(parcel, i21);
                    } else if (c15 == 2) {
                        zF8 = kz3.f(parcel, i21);
                    } else if (c15 == 3) {
                        zF9 = kz3.f(parcel, i21);
                    } else if (c15 == 4) {
                        iH25 = kz3.h(parcel, i21);
                    } else if (c15 != 5) {
                        kz3.k(parcel, i21);
                    } else {
                        iH26 = kz3.h(parcel, i21);
                    }
                }
                kz3.e(parcel, iL21);
                return new r82(iH24, iH25, iH26, zF8, zF9);
            case 28:
                int iL22 = kz3.l(parcel);
                PendingIntent pendingIntent3 = null;
                x30 x30Var3 = null;
                while (parcel.dataPosition() < iL22) {
                    int i22 = parcel.readInt();
                    char c16 = (char) i22;
                    if (c16 == 1) {
                        iH2 = kz3.h(parcel, i22);
                    } else if (c16 == 2) {
                        strB = kz3.b(parcel, i22);
                    } else if (c16 == 3) {
                        pendingIntent3 = (PendingIntent) kz3.a(parcel, i22, PendingIntent.CREATOR);
                    } else if (c16 != 4) {
                        kz3.k(parcel, i22);
                    } else {
                        x30Var3 = (x30) kz3.a(parcel, i22, x30.CREATOR);
                    }
                }
                kz3.e(parcel, iL22);
                return new Status(iH2, strB, pendingIntent3, x30Var3);
            default:
                int iL23 = kz3.l(parcel);
                int iH27 = 0;
                String strB28 = null;
                while (parcel.dataPosition() < iL23) {
                    int i23 = parcel.readInt();
                    char c17 = (char) i23;
                    if (c17 == 1) {
                        iH = kz3.h(parcel, i23);
                    } else if (c17 == 2) {
                        iH27 = kz3.h(parcel, i23);
                    } else if (c17 == 3) {
                        pendingIntent = (PendingIntent) kz3.a(parcel, i23, PendingIntent.CREATOR);
                    } else if (c17 != 4) {
                        kz3.k(parcel, i23);
                    } else {
                        strB28 = kz3.b(parcel, i23);
                    }
                }
                kz3.e(parcel, iL23);
                return new x30(iH, iH27, pendingIntent, strB28);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new b4[i];
            case 1:
                return new ra0[i];
            case 2:
                return new p21[i];
            case 3:
                return new ParcelImpl[i];
            case 4:
                return new gu1[i];
            case 5:
                return new hu1[i];
            case 6:
                return new iu1[i];
            case 7:
                return new jk1[i];
            case 8:
                return new ow2[i];
            case 9:
                return new kk1[i];
            case 10:
                return new sd3[i];
            case 11:
                return new GoogleSignInAccount[i];
            case 12:
                return new re[i];
            case 13:
                return new lk1[i];
            case 14:
                return new me3[i];
            case 15:
                return new qe3[i];
            case 16:
                return new mj1[i];
            case 17:
                return new ve3[i];
            case 18:
                return new xe3[i];
            case 19:
                return new er3[i];
            case 20:
                return new jr3[i];
            case 21:
                return new kr3[i];
            case 22:
                return new lr3[i];
            case 23:
                return new mr3[i];
            case 24:
                return new nr3[i];
            case 25:
                return new or3[i];
            case 26:
                return new Scope[i];
            case 27:
                return new r82[i];
            case 28:
                return new Status[i];
            default:
                return new x30[i];
        }
    }
}
