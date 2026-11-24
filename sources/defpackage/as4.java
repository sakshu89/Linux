package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class as4 {
    public static void a(long j, ln lnVar, int i, ArrayList arrayList, int i2, int i3, ArrayList arrayList2) {
        int i4;
        int i5;
        ArrayList arrayList3;
        long j2;
        int i6;
        int i7 = i;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i2 >= i3) {
            og.i("Failed requirement.");
            return;
        }
        for (int i8 = i2; i8 < i3; i8++) {
            if (((oo) arrayList4.get(i8)).c() < i7) {
                og.i("Failed requirement.");
                return;
            }
        }
        oo ooVar = (oo) arrayList.get(i2);
        oo ooVar2 = (oo) arrayList4.get(i3 - 1);
        if (i7 == ooVar.c()) {
            int iIntValue = ((Number) arrayList5.get(i2)).intValue();
            int i9 = i2 + 1;
            oo ooVar3 = (oo) arrayList4.get(i9);
            i4 = i9;
            i5 = iIntValue;
            ooVar = ooVar3;
        } else {
            i4 = i2;
            i5 = -1;
        }
        if (ooVar.f(i7) == ooVar2.f(i7)) {
            int iMin = Math.min(ooVar.c(), ooVar2.c());
            int i10 = 0;
            for (int i11 = i7; i11 < iMin && ooVar.f(i11) == ooVar2.f(i11); i11++) {
                i10++;
            }
            long j3 = (lnVar.b / 4) + j + 2 + ((long) i10) + 1;
            lnVar.K(-i10);
            lnVar.K(i5);
            int i12 = i7 + i10;
            while (i7 < i12) {
                lnVar.K(ooVar.f(i7) & 255);
                i7++;
            }
            if (i4 + 1 == i3) {
                if (i12 == ((oo) arrayList4.get(i4)).c()) {
                    lnVar.K(((Number) arrayList5.get(i4)).intValue());
                    return;
                } else {
                    og.n("Check failed.");
                    return;
                }
            }
            ln lnVar2 = new ln();
            lnVar.K(((int) ((lnVar2.b / 4) + j3)) * (-1));
            a(j3, lnVar2, i12, arrayList4, i4, i3, arrayList5);
            lnVar.D(lnVar2);
            return;
        }
        int i13 = 1;
        for (int i14 = i4 + 1; i14 < i3; i14++) {
            if (((oo) arrayList4.get(i14 - 1)).f(i7) != ((oo) arrayList4.get(i14)).f(i7)) {
                i13++;
            }
        }
        long j4 = (lnVar.b / 4) + j + 2 + ((long) (i13 * 2));
        lnVar.K(i13);
        lnVar.K(i5);
        for (int i15 = i4; i15 < i3; i15++) {
            int iF = ((oo) arrayList4.get(i15)).f(i7);
            if (i15 == i4 || iF != ((oo) arrayList4.get(i15 - 1)).f(i7)) {
                lnVar.K(iF & 255);
            }
        }
        ln lnVar3 = new ln();
        int i16 = i4;
        while (i16 < i3) {
            byte bF = ((oo) arrayList4.get(i16)).f(i7);
            int i17 = i16 + 1;
            int i18 = i17;
            while (true) {
                if (i18 >= i3) {
                    i18 = i3;
                    break;
                } else if (bF != ((oo) arrayList4.get(i18)).f(i7)) {
                    break;
                } else {
                    i18++;
                }
            }
            if (i17 == i18 && i7 + 1 == ((oo) arrayList4.get(i16)).c()) {
                lnVar.K(((Number) arrayList5.get(i16)).intValue());
                arrayList3 = arrayList5;
                j2 = j4;
                i6 = i18;
            } else {
                lnVar.K(((int) ((lnVar3.b / 4) + j4)) * (-1));
                arrayList3 = arrayList5;
                j2 = j4;
                i6 = i18;
                a(j2, lnVar3, i7 + 1, arrayList, i16, i6, arrayList3);
                arrayList4 = arrayList;
            }
            j4 = j2;
            i16 = i6;
            arrayList5 = arrayList3;
        }
        lnVar.D(lnVar3);
    }
}
