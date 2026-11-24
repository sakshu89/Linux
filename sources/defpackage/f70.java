package defpackage;

import android.view.autofill.AutofillValue;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f70 extends zb0 implements eg2 {
    public a23 X;
    public ty2 Y;
    public ua1 Z;
    public boolean c0;
    public boolean d0;
    public mp1 e0;
    public ny2 f0;
    public kz0 g0;
    public fo0 h0;

    public static void L0(ua1 ua1Var, String str, boolean z) {
        if (z) {
            bz2 bz2Var = ua1Var.e;
            q60 q60Var = ua1Var.v;
            if (bz2Var == null) {
                int length = str.length();
                q60Var.j(new ty2(4, hc4.a(length, length), str));
            } else {
                ty2 ty2VarL = ua1Var.d.l(nz.i(new dc0(), new r00(str, 1)));
                bz2Var.a(null, ty2VarL);
                q60Var.j(ty2VarL);
            }
        }
    }

    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
        boolean z = this.d0;
        be beVar = this.Y.a;
        c51[] c51VarArr = mg2.a;
        ng2 ng2Var = kg2.D;
        c51[] c51VarArr2 = mg2.a;
        c51 c51Var = c51VarArr2[18];
        og2Var.a(ng2Var, beVar);
        be beVar2 = this.X.a;
        ng2 ng2Var2 = kg2.E;
        c51 c51Var2 = c51VarArr2[19];
        og2Var.a(ng2Var2, beVar2);
        long j = this.Y.b;
        ng2 ng2Var3 = kg2.F;
        c51 c51Var3 = c51VarArr2[20];
        og2Var.a(ng2Var3, new oz2(j));
        r8 r8Var = nr4.c;
        ng2 ng2Var4 = kg2.r;
        c51 c51Var4 = c51VarArr2[9];
        og2Var.a(ng2Var4, r8Var);
        i9 i9Var = new i9(AutofillValue.forText(this.Y.a));
        ng2 ng2Var5 = kg2.s;
        c51 c51Var5 = c51VarArr2[10];
        og2Var.a(ng2Var5, i9Var);
        og2Var.a(bg2.h, new b2(null, new e70(this, 0)));
        int i = this.g0.d;
        if (i == 6) {
            n50.a.getClass();
            s8 s8Var = m50.c;
            ng2 ng2Var6 = kg2.q;
            c51 c51Var6 = c51VarArr2[8];
            og2Var.a(ng2Var6, s8Var);
        } else if (i == 7 || i == 8) {
            n50.a.getClass();
            s8 s8Var2 = m50.b;
            ng2 ng2Var7 = kg2.q;
            c51 c51Var7 = c51VarArr2[8];
            og2Var.a(ng2Var7, s8Var2);
        } else if (i == 4) {
            n50.a.getClass();
            s8 s8Var3 = m50.d;
            ng2 ng2Var8 = kg2.q;
            c51 c51Var8 = c51VarArr2[8];
            og2Var.a(ng2Var8, s8Var3);
        }
        boolean z2 = this.c0;
        q43 q43Var = q43.a;
        if (!z2) {
            og2Var.a(kg2.i, q43Var);
        }
        if (z) {
            og2Var.a(kg2.J, q43Var);
        }
        boolean z3 = this.c0;
        ng2 ng2Var9 = kg2.M;
        c51 c51Var9 = c51VarArr2[26];
        og2Var.a(ng2Var9, Boolean.valueOf(z3));
        int i2 = 1;
        mg2.a(og2Var, new e70(this, i2));
        int i3 = 2;
        if (z3) {
            og2Var.a(bg2.k, new b2(null, new e70(this, i3)));
            og2Var.a(bg2.o, new b2(null, new e70(this, og2Var)));
        }
        og2Var.a(bg2.j, new b2(null, new xv(i2, this)));
        int i4 = this.g0.e;
        d70 d70Var = new d70(this, 6);
        og2Var.a(kg2.G, new jz0(i4));
        og2Var.a(bg2.p, new b2(null, d70Var));
        og2Var.a(bg2.b, new b2(null, new d70(this, 7)));
        og2Var.a(bg2.c, new b2(null, new d70(this, 1)));
        if (!oz2.c(this.Y.b) && !z) {
            og2Var.a(bg2.q, new b2(null, new d70(this, 2)));
            if (this.c0) {
                og2Var.a(bg2.r, new b2(null, new d70(this, 3)));
            }
        }
        if (this.c0) {
            og2Var.a(bg2.s, new b2(null, new d70(this, 5)));
        }
    }

    @Override // defpackage.eg2
    public final boolean k0() {
        return true;
    }
}
