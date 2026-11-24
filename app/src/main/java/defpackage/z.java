package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z(int i, x50 x50Var, int i2) {
        super(i, x50Var);
        this.f = i2;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                ((z) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 1:
                return ((z) q((x50) obj2, (fr2) obj)).s(q43Var);
            case 2:
                ((z) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 3:
                Object obj3 = ((mx) obj).a;
                z zVar = new z(2, (x50) obj2, 3);
                zVar.i = obj3;
                return zVar.s(q43Var);
            case 4:
                return ((z) q((x50) obj2, (c42) obj)).s(q43Var);
            default:
                return ((z) q((x50) obj2, (kk2) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = 2;
        switch (this.f) {
            case 0:
                z zVar = new z(i, x50Var, 0);
                zVar.i = obj;
                return zVar;
            case 1:
                z zVar2 = new z(i, x50Var, 1);
                zVar2.i = obj;
                return zVar2;
            case 2:
                z zVar3 = new z(i, x50Var, i);
                zVar3.i = obj;
                return zVar3;
            case 3:
                z zVar4 = new z(i, x50Var, 3);
                zVar4.i = ((mx) obj).a;
                return zVar4;
            case 4:
                z zVar5 = new z(i, x50Var, 4);
                zVar5.i = obj;
                return zVar5;
            default:
                z zVar6 = new z(i, x50Var, 5);
                zVar6.i = obj;
                return zVar6;
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                dm1 dm1Var = (dm1) this.i;
                bz3.g(obj);
                dm1Var.e(f0.f, "v1beta");
                return q43Var;
            case 1:
                bz3.g(obj);
                return Boolean.valueOf(!(((fr2) this.i) instanceof wl0));
            case 2:
                dm1 dm1Var2 = (dm1) this.i;
                bz3.g(obj);
                dm1Var2.b();
                dm1Var2.a.clear();
                return q43Var;
            case 3:
                Object obj2 = this.i;
                bz3.g(obj);
                return new mx(obj2);
            case 4:
                bz3.g(obj);
                return Boolean.valueOf(((c42) this.i) == c42.a);
            default:
                bz3.g(obj);
                return Boolean.valueOf(((kk2) this.i) != kk2.a);
        }
    }
}
