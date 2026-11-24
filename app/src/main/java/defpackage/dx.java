package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dx implements hr0 {
    public final j70 a;
    public final int b;
    public final nn c;

    public dx(j70 j70Var, int i, nn nnVar) {
        this.a = j70Var;
        this.b = i;
        this.c = nnVar;
    }

    @Override // defpackage.mm0
    public Object a(nm0 nm0Var, x50 x50Var) {
        Object objC = tl4.c(new r0(nm0Var, this, null, 3), x50Var);
        return objC == t70.a ? objC : q43.a;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    @Override // defpackage.hr0
    public final mm0 b(j70 j70Var, int i, nn nnVar) {
        j70 j70Var2 = this.a;
        j70 j70VarR = j70Var.r(j70Var2);
        nn nnVar2 = nn.a;
        nn nnVar3 = this.c;
        int i2 = this.b;
        if (nnVar == nnVar2) {
            if (i2 != -3) {
                if (i == -3) {
                    i = i2;
                } else if (i2 != -2) {
                    if (i == -2) {
                        i = i2;
                    } else {
                        i += i2;
                        if (i < 0) {
                            i = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            nnVar = nnVar3;
        }
        return (g31.a(j70VarR, j70Var2) && i == i2 && nnVar == nnVar3) ? this : e(j70VarR, i, nnVar);
    }

    public String c() {
        return null;
    }

    public abstract Object d(j12 j12Var, x50 x50Var);

    public abstract dx e(j70 j70Var, int i, nn nnVar);

    public mm0 f() {
        return null;
    }

    public bx g(s70 s70Var) {
        int i = this.b;
        if (i == -3) {
            i = -2;
        }
        vq0 p0Var = new p0(this, null, 9);
        j12 j12Var = new j12(ql4.b(s70Var, this.a), nh4.a(i, 4, this.c));
        j12Var.u0(v70.c, j12Var, p0Var);
        return j12Var;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strC = c();
        if (strC != null) {
            arrayList.add(strC);
        }
        gi0 gi0Var = gi0.a;
        j70 j70Var = this.a;
        if (j70Var != gi0Var) {
            arrayList.add("context=" + j70Var);
        }
        int i = this.b;
        if (i != -3) {
            arrayList.add("capacity=" + i);
        }
        nn nnVar = nn.a;
        nn nnVar2 = this.c;
        if (nnVar2 != nnVar) {
            arrayList.add("onBufferOverflow=" + nnVar2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return ky0.n(sb, mz.C(arrayList, ", ", null, null, null, 62), ']');
    }
}
