package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t92 extends u92 implements Iterator {
    public s92 a;
    public boolean b = true;
    public final /* synthetic */ v92 c;

    public t92(v92 v92Var) {
        this.c = v92Var;
    }

    @Override // defpackage.u92
    public final void a(s92 s92Var) {
        s92 s92Var2 = this.a;
        if (s92Var == s92Var2) {
            s92 s92Var3 = s92Var2.e;
            this.a = s92Var3;
            this.b = s92Var3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.b) {
            return this.c.a != null;
        }
        s92 s92Var = this.a;
        return (s92Var == null || s92Var.c == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b) {
            this.b = false;
            this.a = this.c.a;
        } else {
            s92 s92Var = this.a;
            this.a = s92Var != null ? s92Var.c : null;
        }
        return this.a;
    }
}
