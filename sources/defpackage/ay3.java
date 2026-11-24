package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ay3 implements g63 {
    public final /* synthetic */ int a;
    public boolean b = false;
    public boolean c = false;
    public fl0 d;
    public final wo1 e;

    public /* synthetic */ ay3(wo1 wo1Var, int i) {
        this.a = i;
        this.e = wo1Var;
    }

    @Override // defpackage.g63
    public final g63 b(String str) {
        int i = this.a;
        wo1 wo1Var = this.e;
        switch (i) {
            case 0:
                if (this.b) {
                    throw new ri0("Cannot encode a second value in the ValueEncoderContext");
                }
                this.b = true;
                ((tx3) wo1Var).b(this.d, str, this.c);
                return this;
            default:
                if (this.b) {
                    throw new ri0("Cannot encode a second value in the ValueEncoderContext");
                }
                this.b = true;
                ((x14) wo1Var).b(this.d, str, this.c);
                return this;
        }
    }

    @Override // defpackage.g63
    public final g63 c(boolean z) {
        int i = this.a;
        wo1 wo1Var = this.e;
        switch (i) {
            case 0:
                if (this.b) {
                    throw new ri0("Cannot encode a second value in the ValueEncoderContext");
                }
                this.b = true;
                ((tx3) wo1Var).c(this.d, z ? 1 : 0, this.c);
                return this;
            default:
                if (this.b) {
                    throw new ri0("Cannot encode a second value in the ValueEncoderContext");
                }
                this.b = true;
                ((x14) wo1Var).c(this.d, z ? 1 : 0, this.c);
                return this;
        }
    }
}
