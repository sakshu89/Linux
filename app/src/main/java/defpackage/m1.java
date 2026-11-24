package defpackage;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m1 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Collection b;

    public /* synthetic */ m1(int i, Collection collection) {
        this.a = i;
        this.b = collection;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        boolean zContains;
        int i = this.a;
        Collection<?> collection = this.b;
        switch (i) {
            case 0:
                zContains = collection.contains(obj);
                break;
            case 1:
                zContains = collection.contains(obj);
                break;
            default:
                zContains = ((List) obj).retainAll(collection);
                break;
        }
        return Boolean.valueOf(zContains);
    }
}
