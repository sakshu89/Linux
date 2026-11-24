package defpackage;

import java.io.FileOutputStream;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ol0 extends y50 {
    public FileOutputStream e;
    public FileOutputStream f;
    public /* synthetic */ Object i;
    public final /* synthetic */ pl0 j;
    public int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ol0(pl0 pl0Var, y50 y50Var) {
        super(y50Var);
        this.j = pl0Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        this.i = obj;
        this.k |= Integer.MIN_VALUE;
        return this.j.b(null, this);
    }
}
