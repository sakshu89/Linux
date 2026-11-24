package defpackage;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ij1 {
    public final SparseArray a;
    public q33 b;

    public ij1(int i) {
        this.a = new SparseArray(i);
    }

    public final void a(q33 q33Var, int i, int i2) {
        int iA = q33Var.a(i);
        SparseArray sparseArray = this.a;
        ij1 ij1Var = sparseArray == null ? null : (ij1) sparseArray.get(iA);
        if (ij1Var == null) {
            ij1Var = new ij1(1);
            sparseArray.put(q33Var.a(i), ij1Var);
        }
        if (i2 > i) {
            ij1Var.a(q33Var, i + 1, i2);
        } else {
            ij1Var.b = q33Var;
        }
    }
}
