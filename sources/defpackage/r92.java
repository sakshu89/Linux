package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r92 extends u92 implements Iterator {
    public s92 a;
    public s92 b;
    public final /* synthetic */ int c;

    public r92(s92 s92Var, s92 s92Var2, int i) {
        this.c = i;
        this.a = s92Var2;
        this.b = s92Var;
    }

    @Override // defpackage.u92
    public final void a(s92 s92Var) {
        s92 s92Var2;
        s92 s92VarB = null;
        if (this.a == s92Var && s92Var == this.b) {
            this.b = null;
            this.a = null;
        }
        s92 s92Var3 = this.a;
        if (s92Var3 == s92Var) {
            switch (this.c) {
                case 0:
                    s92Var2 = s92Var3.e;
                    break;
                default:
                    s92Var2 = s92Var3.c;
                    break;
            }
            this.a = s92Var2;
        }
        s92 s92Var4 = this.b;
        if (s92Var4 == s92Var) {
            s92 s92Var5 = this.a;
            if (s92Var4 != s92Var5 && s92Var5 != null) {
                s92VarB = b(s92Var4);
            }
            this.b = s92VarB;
        }
    }

    public final s92 b(s92 s92Var) {
        switch (this.c) {
            case 0:
                return s92Var.c;
            default:
                return s92Var.e;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        s92 s92Var = this.b;
        s92 s92Var2 = this.a;
        this.b = (s92Var == s92Var2 || s92Var2 == null) ? null : b(s92Var);
        return s92Var;
    }
}
