package defpackage;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qn1 extends y50 {
    public String e;
    public Locale f;
    public String i;
    public /* synthetic */ Object j;
    public final /* synthetic */ sn1 k;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qn1(sn1 sn1Var, y50 y50Var) {
        super(y50Var);
        this.k = sn1Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        this.j = obj;
        this.n |= Integer.MIN_VALUE;
        return this.k.b(null, null, null, this);
    }
}
