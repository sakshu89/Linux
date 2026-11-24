package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qc3 implements rb1, er0 {
    public final /* synthetic */ a30 a;

    public qc3(a30 a30Var) {
        this.a = a30Var;
    }

    @Override // defpackage.er0
    public final rq0 a() {
        return new gr0(1, this.a, a30.class, "scheduleFrameEndCallback", "scheduleFrameEndCallback(Lkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/CancellationHandle;", 0, 0);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof rb1) && (obj instanceof er0)) {
            return a().equals(((er0) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }
}
