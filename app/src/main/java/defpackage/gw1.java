package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gw1 extends hw1 implements j30 {
    public static final gw1 e = new gw1(x23.e, 0);

    public final gw1 b(z12 z12Var, h63 h63Var) {
        c10 c10VarU = this.a.u(z12Var.hashCode(), 0, z12Var, h63Var);
        return c10VarU == null ? this : new gw1((x23) c10VarU.b, this.b + c10VarU.a);
    }

    @Override // defpackage.hw1, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof z12) {
            return super.containsKey((z12) obj);
        }
        return false;
    }

    @Override // defpackage.hw1, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof h63) {
            return super.containsValue((h63) obj);
        }
        return false;
    }

    @Override // defpackage.hw1, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof z12) {
            return (h63) super.get((z12) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof z12) ? obj2 : (h63) super.getOrDefault((z12) obj, (h63) obj2);
    }
}
