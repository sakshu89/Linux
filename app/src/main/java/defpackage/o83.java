package defpackage;

import com.ibm.icu.impl.locale.LanguageTag;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o83 extends up0 {
    public final String b;
    public int c;

    public o83(ut utVar) {
        super(utVar);
        this.b = "virtual-" + utVar.c() + LanguageTag.SEP + UUID.randomUUID().toString();
    }

    @Override // defpackage.up0, defpackage.ut
    public final int a() {
        return f(0);
    }

    @Override // defpackage.up0, defpackage.ut
    public final String c() {
        return this.b;
    }

    @Override // defpackage.up0, defpackage.ut
    public final int f(int i) {
        return z13.g(this.a.f(i) - this.c);
    }
}
