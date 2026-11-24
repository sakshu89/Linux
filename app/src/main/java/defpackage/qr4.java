package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class qr4 {
    public static final int a(int i, List list) {
        int i2;
        byte b;
        int i3 = ((au1) mz.D(list)).c;
        if (i > ((au1) mz.D(list)).c) {
            a11.a("Index " + i + " should be less or equal than last line's end " + i3);
        }
        int size = list.size() - 1;
        int i4 = 0;
        while (true) {
            if (i4 > size) {
                i2 = -(i4 + 1);
                break;
            }
            i2 = (i4 + size) >>> 1;
            au1 au1Var = (au1) list.get(i2);
            if (au1Var.b > i) {
                b = 1;
            } else {
                b = au1Var.c <= i ? (byte) -1 : (byte) 0;
            }
            if (b >= 0) {
                if (b <= 0) {
                    break;
                }
                size = i2 - 1;
            } else {
                i4 = i2 + 1;
            }
        }
        if (i2 >= 0 && i2 < list.size()) {
            return i2;
        }
        StringBuilder sbP = ky0.p("Found paragraph index ", i2, " should be in range [0, ");
        sbP.append(list.size());
        sbP.append(").\nDebug info: index=");
        sbP.append(i);
        sbP.append(", paragraphs=[");
        sbP.append(vc1.a(list, null, new va1(4), 31));
        sbP.append(']');
        a11.a(sbP.toString());
        return i2;
    }

    public static final int b(int i, List list) {
        byte b;
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            au1 au1Var = (au1) list.get(i3);
            if (au1Var.d > i) {
                b = 1;
            } else {
                b = au1Var.e <= i ? (byte) -1 : (byte) 0;
            }
            if (b < 0) {
                i2 = i3 + 1;
            } else {
                if (b <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final int c(ArrayList arrayList, float f) {
        byte b;
        if (f <= 0.0f) {
            return 0;
        }
        if (f >= ((au1) mz.D(arrayList)).g) {
            return arrayList.size() - 1;
        }
        int size = arrayList.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            au1 au1Var = (au1) arrayList.get(i2);
            if (au1Var.f > f) {
                b = 1;
            } else {
                b = au1Var.g <= f ? (byte) -1 : (byte) 0;
            }
            if (b < 0) {
                i = i2 + 1;
            } else {
                if (b <= 0) {
                    return i2;
                }
                size = i2 - 1;
            }
        }
        return -(i + 1);
    }

    public static final void d(ArrayList arrayList, long j, hq0 hq0Var) {
        int size = arrayList.size();
        for (int iA = a(oz2.f(j), arrayList); iA < size; iA++) {
            au1 au1Var = (au1) arrayList.get(iA);
            if (au1Var.b >= oz2.e(j)) {
                return;
            }
            if (au1Var.b != au1Var.c) {
                hq0Var.j(au1Var);
            }
        }
    }
}
