package defpackage;

import java.util.Enumeration;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zj0 implements Enumeration {
    public final /* synthetic */ int a;
    public int b;

    @Override // java.util.Enumeration
    public final boolean hasMoreElements() {
        switch (this.a) {
            case 0:
                int i = this.b;
                lk0[] lk0VarArr = ck0.c;
                return i < 4;
            default:
                int i2 = this.b;
                lk0[] lk0VarArr2 = ck0.c;
                return i2 < 4;
        }
    }

    @Override // java.util.Enumeration
    public final Object nextElement() {
        switch (this.a) {
            case 0:
                HashMap map = new HashMap();
                for (lk0 lk0Var : ck0.d[this.b]) {
                    map.put(lk0Var.b, lk0Var);
                }
                this.b++;
                return map;
            default:
                this.b++;
                return new HashMap();
        }
    }
}
