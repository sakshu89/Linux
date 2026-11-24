package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l20 {
    public final List a;

    public l20(List list) {
        this.a = list;
    }

    public final boolean a() {
        List list = this.a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((m20) list.get(i)).getClass();
        }
        return false;
    }
}
