package defpackage;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rn1 extends y50 {
    public Locale e;
    public /* synthetic */ Object f;
    public final /* synthetic */ sn1 i;
    public int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rn1(sn1 sn1Var, y50 y50Var) {
        super(y50Var);
        this.i = sn1Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        this.f = obj;
        this.j |= Integer.MIN_VALUE;
        return this.i.d(null, this);
    }
}
