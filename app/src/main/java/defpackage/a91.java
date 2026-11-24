package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a91 {
    public final Object a;
    public final c91 b;
    public int d;
    public a91 e;
    public boolean f;
    public int c = -1;
    public final ku1 g = o44.g(null);

    public a91(Object obj, c91 c91Var) {
        this.a = obj;
        this.b = c91Var;
    }

    public final a91 a() {
        if (this.f) {
            c11.c("Pin should not be called on an already disposed item ");
        }
        if (this.d == 0) {
            this.b.a.add(this);
            a91 a91Var = (a91) this.g.getValue();
            if (a91Var != null) {
                a91Var.a();
            } else {
                a91Var = null;
            }
            this.e = a91Var;
        }
        this.d++;
        return this;
    }

    public final void b() {
        if (this.f) {
            return;
        }
        if (this.d <= 0) {
            c11.c("Release should only be called once");
        }
        int i = this.d - 1;
        this.d = i;
        if (i == 0) {
            this.b.a.remove(this);
            a91 a91Var = this.e;
            if (a91Var != null) {
                a91Var.b();
            }
            this.e = null;
        }
    }
}
