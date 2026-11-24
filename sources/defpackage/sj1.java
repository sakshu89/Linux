package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sj1 extends dk1 implements h30, f71 {
    public LinkedHashMap x;

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        float f = ((de0) ij4.a(this, u21.c)).a;
        if (f < 0.0f) {
            f = 0.0f;
        }
        zw1 zw1VarE = jh1Var.e(j);
        boolean z = this.w && !Float.isNaN(f) && de0.a(f, 0.0f) > 0;
        int iR = !Float.isNaN(f) ? qh1Var.R(f) : 0;
        int iMax = zw1VarE.a;
        if (z) {
            iMax = Math.max(iMax, iR);
        }
        int iMax2 = zw1VarE.b;
        if (z) {
            iMax2 = Math.max(iMax2, iR);
        }
        if (z) {
            LinkedHashMap linkedHashMap = this.x;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap(2);
                this.x = linkedHashMap;
            }
            j73 j73Var = u21.b;
            int iRound = Math.round((iR - zw1VarE.a) / 2.0f);
            if (iRound < 0) {
                iRound = 0;
            }
            linkedHashMap.put(j73Var, Integer.valueOf(iRound));
            qw0 qw0Var = u21.a;
            int iRound2 = Math.round((iR - zw1VarE.b) / 2.0f);
            linkedHashMap.put(qw0Var, Integer.valueOf(iRound2 >= 0 ? iRound2 : 0));
        }
        Map map = this.x;
        if (map == null) {
            map = ji0.a;
        }
        return qh1Var.j0(iMax, iMax2, map, new u11(iMax, zw1VarE, iMax2));
    }
}
