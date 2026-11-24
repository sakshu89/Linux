package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rg implements xg2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ rg(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.xg2
    public final Iterator iterator() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return new e1((Object[]) obj);
            case 1:
                return ((Iterable) obj).iterator();
            default:
                return (Iterator) obj;
        }
    }
}
