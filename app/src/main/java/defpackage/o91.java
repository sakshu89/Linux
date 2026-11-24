package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o91 extends dk1 implements eg2 {
    public j91 H;
    public js1 X;
    public boolean Y;
    public ed2 Z;
    public final l91 c0 = new l91(this, 0);
    public l91 d0;
    public fq0 x;

    public o91(fq0 fq0Var, j91 j91Var, js1 js1Var, boolean z) {
        this.x = fq0Var;
        this.H = j91Var;
        this.X = js1Var;
        this.Y = z;
        I0();
    }

    public final void I0() {
        this.Z = new ed2(new m91(this, 0), new m91(this, 1));
        this.d0 = this.Y ? new l91(this, 1) : null;
    }

    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
        c51[] c51VarArr = mg2.a;
        ng2 ng2Var = kg2.m;
        c51[] c51VarArr2 = mg2.a;
        c51 c51Var = c51VarArr2[6];
        og2Var.a(ng2Var, Boolean.TRUE);
        og2Var.a(kg2.L, this.c0);
        js1 js1Var = this.X;
        ed2 ed2Var = this.Z;
        if (js1Var == js1.a) {
            if (ed2Var == null) {
                g31.f("scrollAxisRange");
                throw null;
            }
            ng2 ng2Var2 = kg2.v;
            c51 c51Var2 = c51VarArr2[13];
            og2Var.a(ng2Var2, ed2Var);
        } else {
            if (ed2Var == null) {
                g31.f("scrollAxisRange");
                throw null;
            }
            ng2 ng2Var3 = kg2.u;
            c51 c51Var3 = c51VarArr2[12];
            og2Var.a(ng2Var3, ed2Var);
        }
        l91 l91Var = this.d0;
        if (l91Var != null) {
            og2Var.a(bg2.f, new b2(null, l91Var));
        }
        og2Var.a(bg2.C, new b2(null, new h6(21, new m91(this, 2))));
        j91 j91Var = this.H;
        j91Var.getClass();
        lz lzVar = new lz(((Number) j91Var.a.getValue()).intValue(), 1);
        ng2 ng2Var4 = kg2.f;
        c51 c51Var4 = c51VarArr2[23];
        og2Var.a(ng2Var4, lzVar);
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }
}
