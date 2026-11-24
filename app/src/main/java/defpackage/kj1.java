package defpackage;

import com.ibm.icu.impl.locale.LanguageTag;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kj1 implements r53 {
    public final zl1 a;

    public kj1() {
        zl1 zl1VarM = zl1.m();
        zl1VarM.v(r53.Q, new as());
        zl1VarM.v(wy0.r, 34);
        zl1VarM.v(yv2.N, lj1.class);
        zl1VarM.v(yv2.M, lj1.class.getCanonicalName() + LanguageTag.SEP + UUID.randomUUID());
        this.a = zl1VarM;
    }

    @Override // defpackage.r53
    public final t53 j() {
        return t53.i;
    }

    @Override // defpackage.x22
    public final s30 n() {
        return this.a;
    }
}
