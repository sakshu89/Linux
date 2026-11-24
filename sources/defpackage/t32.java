package defpackage;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t32 extends b72 {
    public final String a;
    public final long b;
    public final i32 c;

    public t32(String str, long j, i32 i32Var) {
        this.a = str;
        this.b = j;
        this.c = i32Var;
    }

    @Override // defpackage.b72
    public final long c() {
        return this.b;
    }

    @Override // defpackage.b72
    public final ji1 e() {
        String str = this.a;
        if (str != null) {
            Pattern pattern = ji1.c;
            try {
                return gr4.a(str);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    @Override // defpackage.b72
    public final yn j() {
        return this.c;
    }
}
