package defpackage;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kn1 {
    public static final SparseArray a;
    public static final /* synthetic */ kn1[] b;

    /* JADX INFO: Fake field, exist only in values array */
    kn1 EF1;

    static {
        kn1 kn1Var = new kn1("UNKNOWN_MOBILE_SUBTYPE", 0);
        kn1 kn1Var2 = new kn1("GPRS", 1);
        kn1 kn1Var3 = new kn1("EDGE", 2);
        kn1 kn1Var4 = new kn1("UMTS", 3);
        kn1 kn1Var5 = new kn1("CDMA", 4);
        kn1 kn1Var6 = new kn1("EVDO_0", 5);
        kn1 kn1Var7 = new kn1("EVDO_A", 6);
        kn1 kn1Var8 = new kn1("RTT", 7);
        kn1 kn1Var9 = new kn1("HSDPA", 8);
        kn1 kn1Var10 = new kn1("HSUPA", 9);
        kn1 kn1Var11 = new kn1("HSPA", 10);
        kn1 kn1Var12 = new kn1("IDEN", 11);
        kn1 kn1Var13 = new kn1("EVDO_B", 12);
        kn1 kn1Var14 = new kn1("LTE", 13);
        kn1 kn1Var15 = new kn1("EHRPD", 14);
        kn1 kn1Var16 = new kn1("HSPAP", 15);
        kn1 kn1Var17 = new kn1("GSM", 16);
        kn1 kn1Var18 = new kn1("TD_SCDMA", 17);
        kn1 kn1Var19 = new kn1("IWLAN", 18);
        kn1 kn1Var20 = new kn1("LTE_CA", 19);
        b = new kn1[]{kn1Var, kn1Var2, kn1Var3, kn1Var4, kn1Var5, kn1Var6, kn1Var7, kn1Var8, kn1Var9, kn1Var10, kn1Var11, kn1Var12, kn1Var13, kn1Var14, kn1Var15, kn1Var16, kn1Var17, kn1Var18, kn1Var19, kn1Var20, new kn1("COMBINED", 20)};
        SparseArray sparseArray = new SparseArray();
        a = sparseArray;
        sparseArray.put(0, kn1Var);
        sparseArray.put(1, kn1Var2);
        sparseArray.put(2, kn1Var3);
        sparseArray.put(3, kn1Var4);
        sparseArray.put(4, kn1Var5);
        sparseArray.put(5, kn1Var6);
        sparseArray.put(6, kn1Var7);
        sparseArray.put(7, kn1Var8);
        sparseArray.put(8, kn1Var9);
        sparseArray.put(9, kn1Var10);
        sparseArray.put(10, kn1Var11);
        sparseArray.put(11, kn1Var12);
        sparseArray.put(12, kn1Var13);
        sparseArray.put(13, kn1Var14);
        sparseArray.put(14, kn1Var15);
        sparseArray.put(15, kn1Var16);
        sparseArray.put(16, kn1Var17);
        sparseArray.put(17, kn1Var18);
        sparseArray.put(18, kn1Var19);
        sparseArray.put(19, kn1Var20);
    }

    public static kn1 valueOf(String str) {
        return (kn1) Enum.valueOf(kn1.class, str);
    }

    public static kn1[] values() {
        return (kn1[]) b.clone();
    }
}
