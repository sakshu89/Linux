package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public /* synthetic */ Object i;
    public final /* synthetic */ boolean j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(mm1 mm1Var, boolean z, x50 x50Var) {
        super(2, x50Var);
        this.f = 7;
        this.i = mm1Var;
        this.j = z;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                ((d0) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 1:
                ((d0) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 2:
                ((d0) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 3:
                ((d0) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 4:
                ((d0) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 5:
                ((d0) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 6:
                return ((d0) q((x50) obj2, (Boolean) obj)).s(q43Var);
            default:
                ((d0) q((x50) obj2, (s70) obj)).s(q43Var);
                return q43Var;
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        switch (this.f) {
            case 0:
                d0 d0Var = new d0(this.j, x50Var, 0);
                d0Var.i = obj;
                return d0Var;
            case 1:
                d0 d0Var2 = new d0(this.j, x50Var, 1);
                d0Var2.i = obj;
                return d0Var2;
            case 2:
                d0 d0Var3 = new d0(this.j, x50Var, 2);
                d0Var3.i = obj;
                return d0Var3;
            case 3:
                d0 d0Var4 = new d0(this.j, x50Var, 3);
                d0Var4.i = obj;
                return d0Var4;
            case 4:
                d0 d0Var5 = new d0(this.j, x50Var, 4);
                d0Var5.i = obj;
                return d0Var5;
            case 5:
                d0 d0Var6 = new d0(this.j, x50Var, 5);
                d0Var6.i = obj;
                return d0Var6;
            case 6:
                d0 d0Var7 = new d0(this.j, x50Var, 6);
                d0Var7.i = obj;
                return d0Var7;
            default:
                return new d0((mm1) this.i, this.j, x50Var);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        boolean z = this.j;
        q43 q43Var = q43.a;
        Object obj2 = this.i;
        switch (i) {
            case 0:
                dm1 dm1Var = (dm1) obj2;
                bz3.g(obj);
                dm1Var.e(f0.d, Boolean.valueOf(z));
                dm1Var.e(f0.e, z ? "gemini" : "offline");
                return q43Var;
            case 1:
                bz3.g(obj);
                iz1 iz1Var = j5.c;
                ((dm1) obj2).e(j5.g, Boolean.valueOf(z));
                return q43Var;
            case 2:
                bz3.g(obj);
                iz1 iz1Var2 = j5.c;
                ((dm1) obj2).e(j5.k, Boolean.valueOf(z));
                return q43Var;
            case 3:
                bz3.g(obj);
                iz1 iz1Var3 = j5.c;
                ((dm1) obj2).e(j5.l, Boolean.valueOf(z));
                return q43Var;
            case 4:
                bz3.g(obj);
                iz1 iz1Var4 = j5.c;
                ((dm1) obj2).e(j5.j, Boolean.valueOf(z));
                return q43Var;
            case 5:
                bz3.g(obj);
                ((dm1) obj2).e(j5.h, Boolean.valueOf(z));
                return q43Var;
            case 6:
                bz3.g(obj);
                return Boolean.valueOf(g31.a((Boolean) obj2, Boolean.valueOf(z)));
            default:
                mm1 mm1Var = (mm1) obj2;
                bz3.g(obj);
                if (((b02) mm1Var.getValue()) != null) {
                    mm1Var.setValue(null);
                }
                return q43Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d0(boolean z, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = z;
    }
}
