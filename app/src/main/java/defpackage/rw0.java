package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rw0 {
    public int a;
    public float b;
    public final Object c;

    public rw0(ez2 ez2Var) {
        this.c = ez2Var;
        this.a = -1;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    public float a(int i, boolean z, boolean z2, boolean z3) {
        boolean z4;
        ez2 ez2Var = (ez2) this.c;
        int i2 = 1;
        if (z) {
            int iA = op4.a(ez2Var.f, i, z);
            int lineStart = ez2Var.f.getLineStart(iA);
            int iF = ez2Var.f(iA);
            if (i == lineStart || i == iF) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            z4 = false;
        }
        int i3 = i * 4;
        if (!z3) {
            i2 = z4 ? 2 : 3;
        } else if (z4) {
            i2 = 0;
        }
        int i4 = i3 + i2;
        if (this.a == i4) {
            return this.b;
        }
        float fH = z3 ? ez2Var.h(i, z) : ez2Var.i(i, z);
        if (z2) {
            this.a = i4;
            this.b = fH;
        }
        return fH;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object b(float f, y50 y50Var) {
        c52 c52Var;
        if (y50Var instanceof c52) {
            c52Var = (c52) y50Var;
            int i = c52Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52Var.i = i - Integer.MIN_VALUE;
            } else {
                c52Var = new c52(this, y50Var);
            }
        } else {
            c52Var = new c52(this, y50Var);
        }
        Object objE = c52Var.e;
        int i2 = c52Var.i;
        if (i2 == 0) {
            bz3.g(objE);
            i20 i20Var = (i20) this.c;
            Float f2 = new Float(f);
            c52Var.i = 1;
            objE = i20Var.e(f2, c52Var);
            t70 t70Var = t70.a;
            if (objE == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(objE);
        }
        this.b += ((Number) objE).floatValue();
        return q43.a;
    }

    public rw0(int i, i20 i20Var) {
        this.a = i;
        this.c = i20Var;
    }
}
