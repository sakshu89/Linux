package defpackage;

import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x74 extends bx3 {
    public final /* synthetic */ a g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x74(a aVar, int i) {
        super(aVar, i, null);
        this.g = aVar;
    }

    @Override // defpackage.bx3
    public final void a(x30 x30Var) {
        this.g.i.o(x30Var);
        System.currentTimeMillis();
    }

    @Override // defpackage.bx3
    public final boolean b() {
        this.g.i.o(x30.f);
        return true;
    }
}
