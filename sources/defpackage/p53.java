package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p53 {
    public final kh2 a;
    public final r53 b;
    public final fj c;
    public final List d;
    public boolean e = false;
    public boolean f = false;

    public p53(kh2 kh2Var, r53 r53Var, fj fjVar, List list) {
        this.a = kh2Var;
        this.b = r53Var;
        this.c = fjVar;
        this.d = list;
    }

    public final String toString() {
        return "UseCaseAttachInfo{mSessionConfig=" + this.a + ", mUseCaseConfig=" + this.b + ", mStreamSpec=" + this.c + ", mCaptureTypes=" + this.d + ", mAttached=" + this.e + ", mActive=" + this.f + '}';
    }
}
