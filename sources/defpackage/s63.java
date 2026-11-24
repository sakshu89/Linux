package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface s63 {
    long a(vd vdVar, vd vdVar2, vd vdVar3);

    vd f(long j, vd vdVar, vd vdVar2, vd vdVar3);

    vd h(long j, vd vdVar, vd vdVar2, vd vdVar3);

    boolean isInfinite();

    default vd k(vd vdVar, vd vdVar2, vd vdVar3) {
        return f(a(vdVar, vdVar2, vdVar3), vdVar, vdVar2, vdVar3);
    }
}
