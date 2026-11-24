package defpackage;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g22 {
    public static final g22 a;
    public static final /* synthetic */ g22[] b;

    static {
        g22 g22Var = new g22("DEFAULT", 0);
        a = g22Var;
        g22 g22Var2 = new g22("UNMETERED_ONLY", 1);
        g22 g22Var3 = new g22("UNMETERED_OR_DAILY", 2);
        g22 g22Var4 = new g22("FAST_IF_RADIO_AWAKE", 3);
        g22 g22Var5 = new g22("NEVER", 4);
        g22 g22Var6 = new g22("UNRECOGNIZED", 5);
        b = new g22[]{g22Var, g22Var2, g22Var3, g22Var4, g22Var5, g22Var6};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, g22Var);
        sparseArray.put(1, g22Var2);
        sparseArray.put(2, g22Var3);
        sparseArray.put(3, g22Var4);
        sparseArray.put(4, g22Var5);
        sparseArray.put(-1, g22Var6);
    }

    public static g22 valueOf(String str) {
        return (g22) Enum.valueOf(g22.class, str);
    }

    public static g22[] values() {
        return (g22[]) b.clone();
    }
}
