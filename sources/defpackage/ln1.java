package defpackage;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ln1 {
    public static final SparseArray a;
    public static final /* synthetic */ ln1[] b;

    /* JADX INFO: Fake field, exist only in values array */
    ln1 EF1;

    static {
        ln1 ln1Var = new ln1("MOBILE", 0);
        ln1 ln1Var2 = new ln1("WIFI", 1);
        ln1 ln1Var3 = new ln1("MOBILE_MMS", 2);
        ln1 ln1Var4 = new ln1("MOBILE_SUPL", 3);
        ln1 ln1Var5 = new ln1("MOBILE_DUN", 4);
        ln1 ln1Var6 = new ln1("MOBILE_HIPRI", 5);
        ln1 ln1Var7 = new ln1("WIMAX", 6);
        ln1 ln1Var8 = new ln1("BLUETOOTH", 7);
        ln1 ln1Var9 = new ln1("DUMMY", 8);
        ln1 ln1Var10 = new ln1("ETHERNET", 9);
        ln1 ln1Var11 = new ln1("MOBILE_FOTA", 10);
        ln1 ln1Var12 = new ln1("MOBILE_IMS", 11);
        ln1 ln1Var13 = new ln1("MOBILE_CBS", 12);
        ln1 ln1Var14 = new ln1("WIFI_P2P", 13);
        ln1 ln1Var15 = new ln1("MOBILE_IA", 14);
        ln1 ln1Var16 = new ln1("MOBILE_EMERGENCY", 15);
        ln1 ln1Var17 = new ln1("PROXY", 16);
        ln1 ln1Var18 = new ln1("VPN", 17);
        ln1 ln1Var19 = new ln1("NONE", 18);
        b = new ln1[]{ln1Var, ln1Var2, ln1Var3, ln1Var4, ln1Var5, ln1Var6, ln1Var7, ln1Var8, ln1Var9, ln1Var10, ln1Var11, ln1Var12, ln1Var13, ln1Var14, ln1Var15, ln1Var16, ln1Var17, ln1Var18, ln1Var19};
        SparseArray sparseArray = new SparseArray();
        a = sparseArray;
        sparseArray.put(0, ln1Var);
        sparseArray.put(1, ln1Var2);
        sparseArray.put(2, ln1Var3);
        sparseArray.put(3, ln1Var4);
        sparseArray.put(4, ln1Var5);
        sparseArray.put(5, ln1Var6);
        sparseArray.put(6, ln1Var7);
        sparseArray.put(7, ln1Var8);
        sparseArray.put(8, ln1Var9);
        sparseArray.put(9, ln1Var10);
        sparseArray.put(10, ln1Var11);
        sparseArray.put(11, ln1Var12);
        sparseArray.put(12, ln1Var13);
        sparseArray.put(13, ln1Var14);
        sparseArray.put(14, ln1Var15);
        sparseArray.put(15, ln1Var16);
        sparseArray.put(16, ln1Var17);
        sparseArray.put(17, ln1Var18);
        sparseArray.put(-1, ln1Var19);
    }

    public static ln1 valueOf(String str) {
        return (ln1) Enum.valueOf(ln1.class, str);
    }

    public static ln1[] values() {
        return (ln1[]) b.clone();
    }
}
