package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class tr4 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(dk1 dk1Var, fq0 fq0Var) {
        fp1 fp1Var = dk1Var.j;
        if (fp1Var == null) {
            fp1Var = new fp1((ep1) dk1Var);
            dk1Var.j = fp1Var;
        }
        lt1 snapshotObserver = ((r7) cm4.h(dk1Var)).getSnapshotObserver();
        snapshotObserver.a.c(fp1Var, j7.n0, fq0Var);
    }
}
