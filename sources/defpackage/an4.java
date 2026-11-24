package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class an4 {
    public static final long a(long j, long j2) {
        int iD;
        int iF = oz2.f(j);
        int iE = oz2.e(j);
        if ((oz2.f(j2) < oz2.e(j)) && (oz2.f(j) < oz2.e(j2))) {
            if ((oz2.f(j2) <= oz2.f(j)) && (oz2.e(j) <= oz2.e(j2))) {
                iF = oz2.f(j2);
                iE = iF;
            } else {
                if ((oz2.f(j) <= oz2.f(j2)) && (oz2.e(j2) <= oz2.e(j))) {
                    iD = oz2.d(j2);
                } else {
                    int iF2 = oz2.f(j2);
                    if (iF >= oz2.e(j2) || iF2 > iF) {
                        iE = oz2.f(j2);
                    } else {
                        iF = oz2.f(j2);
                        iD = oz2.d(j2);
                    }
                }
                iE -= iD;
            }
        } else if (iE > oz2.f(j2)) {
            iF -= oz2.d(j2);
            iD = oz2.d(j2);
            iE -= iD;
        }
        return hc4.a(iF, iE);
    }
}
