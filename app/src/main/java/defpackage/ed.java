package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ed implements oh1 {
    public final ld a;
    public boolean b;

    public ed(ld ldVar) {
        this.a = ldVar;
    }

    @Override // defpackage.oh1
    public final int a(z21 z21Var, List list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int iF = ((jh1) list.get(0)).f(i);
        int i2 = 1;
        int size = list.size() - 1;
        if (1 <= size) {
            while (true) {
                int iF2 = ((jh1) list.get(i2)).f(i);
                if (iF2 > iF) {
                    iF = iF2;
                }
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        return iF;
    }

    @Override // defpackage.oh1
    public final int c(z21 z21Var, List list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int iC0 = ((jh1) list.get(0)).c0(i);
        int i2 = 1;
        int size = list.size() - 1;
        if (1 <= size) {
            while (true) {
                int iC1 = ((jh1) list.get(i2)).c0(i);
                if (iC1 > iC0) {
                    iC0 = iC1;
                }
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        return iC0;
    }

    @Override // defpackage.oh1
    public final ph1 f(qh1 qh1Var, List list, long j) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i = 0; i < size; i++) {
            zw1 zw1VarE = ((jh1) list.get(i)).e(j);
            iMax = Math.max(iMax, zw1VarE.a);
            iMax2 = Math.max(iMax2, zw1VarE.b);
            arrayList.add(zw1VarE);
        }
        boolean zS = qh1Var.s();
        ld ldVar = this.a;
        if (zS) {
            this.b = true;
            ldVar.a.setValue(new l21((((long) iMax2) & 4294967295L) | (((long) iMax) << 32)));
        } else if (!this.b) {
            ldVar.a.setValue(new l21((((long) iMax2) & 4294967295L) | (((long) iMax) << 32)));
        }
        return qh1Var.j0(iMax, iMax2, ji0.a, new db(1, arrayList));
    }

    @Override // defpackage.oh1
    public final int g(z21 z21Var, List list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int iE0 = ((jh1) list.get(0)).e0(i);
        int i2 = 1;
        int size = list.size() - 1;
        if (1 <= size) {
            while (true) {
                int iE1 = ((jh1) list.get(i2)).e0(i);
                if (iE1 > iE0) {
                    iE0 = iE1;
                }
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        return iE0;
    }

    @Override // defpackage.oh1
    public final int i(z21 z21Var, List list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int iV = ((jh1) list.get(0)).V(i);
        int i2 = 1;
        int size = list.size() - 1;
        if (1 <= size) {
            while (true) {
                int iV2 = ((jh1) list.get(i2)).V(i);
                if (iV2 > iV) {
                    iV = iV2;
                }
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        return iV;
    }
}
