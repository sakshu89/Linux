package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface qh1 extends z21 {
    ph1 O(int i, int i2, Map map, hq0 hq0Var, hq0 hq0Var2);

    default ph1 j0(int i, int i2, Map map, hq0 hq0Var) {
        return O(i, i2, map, null, hq0Var);
    }
}
