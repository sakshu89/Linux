package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ga3 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public final /* synthetic */ ja3 i;
    public final /* synthetic */ String j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ga3(ja3 ja3Var, String str, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.i = ja3Var;
        this.j = str;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        s70 s70Var = (s70) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                break;
        }
        return ((ga3) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        String str = this.j;
        ja3 ja3Var = this.i;
        switch (i) {
            case 0:
                return new ga3(ja3Var, str, x50Var, 0);
            default:
                return new ga3(ja3Var, str, x50Var, 1);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        x40 x40Var = x40.a;
        String str = this.j;
        ja3 ja3Var = this.i;
        switch (i) {
            case 0:
                bz3.g(obj);
                b50 b50Var = ja3Var.a;
                b50Var.getClass();
                str.getClass();
                try {
                    return b50Var.f(str);
                } catch (SecurityException unused) {
                    return x40Var;
                }
            default:
                bz3.g(obj);
                b50 b50Var2 = ja3Var.a;
                b50Var2.getClass();
                try {
                    return b50Var2.f(str);
                } catch (SecurityException unused2) {
                    return x40Var;
                }
        }
    }
}
