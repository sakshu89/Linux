package defpackage;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jh4 {
    public static AbstractList b(List list, ks4 ks4Var) {
        return list instanceof RandomAccess ? new yp3(list, ks4Var) : new zp3(list, ks4Var);
    }

    public abstract List a(String str, List list);
}
