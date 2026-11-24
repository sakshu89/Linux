package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tl0 extends dk1 implements f71 {
    public float H;
    public ed0 x;

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        int iJ;
        int iH;
        int iG;
        int i;
        if (!q40.d(j) || this.x == ed0.a) {
            iJ = q40.j(j);
            iH = q40.h(j);
        } else {
            int iRound = Math.round(q40.h(j) * this.H);
            int iJ2 = q40.j(j);
            iJ = q40.h(j);
            if (iRound < iJ2) {
                iRound = iJ2;
            }
            if (iRound <= iJ) {
                iJ = iRound;
            }
            iH = iJ;
        }
        if (!q40.c(j) || this.x == ed0.b) {
            int i2 = q40.i(j);
            int iG2 = q40.g(j);
            iG = i2;
            i = iG2;
        } else {
            int iRound2 = Math.round(q40.g(j) * this.H);
            int i3 = q40.i(j);
            iG = q40.g(j);
            if (iRound2 < i3) {
                iRound2 = i3;
            }
            if (iRound2 <= iG) {
                iG = iRound2;
            }
            i = iG;
        }
        zw1 zw1VarE = jh1Var.e(r40.a(iJ, iH, iG, i));
        return qh1Var.j0(zw1VarE.a, zw1VarE.b, ji0.a, new sl0(zw1VarE, 0));
    }
}
