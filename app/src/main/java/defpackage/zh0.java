package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zh0 {
    public int a = 1;
    public final ij1 b;
    public ij1 c;
    public ij1 d;
    public int e;
    public int f;

    public zh0(ij1 ij1Var) {
        this.b = ij1Var;
        this.c = ij1Var;
    }

    public final void a() {
        this.a = 1;
        this.c = this.b;
        this.f = 0;
    }

    public final boolean b() {
        gj1 gj1VarB = this.c.b.b();
        int iA = gj1VarB.a(6);
        return !(iA == 0 || ((ByteBuffer) gj1VarB.e).get(iA + gj1VarB.a) == 0) || this.e == 65039;
    }
}
