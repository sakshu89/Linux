package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zz {
    public static final zz a;
    public static final zz b;
    public static final zz c;
    public static final zz e;
    public static final zz f;
    public static final /* synthetic */ zz[] i;

    /* JADX INFO: Fake field, exist only in values array */
    zz EF1;

    static {
        zz zzVar = new zz("Background", 0);
        zz zzVar2 = new zz("Error", 1);
        zz zzVar3 = new zz("ErrorContainer", 2);
        zz zzVar4 = new zz("InverseOnSurface", 3);
        zz zzVar5 = new zz("InversePrimary", 4);
        zz zzVar6 = new zz("InverseSurface", 5);
        zz zzVar7 = new zz("OnBackground", 6);
        zz zzVar8 = new zz("OnError", 7);
        zz zzVar9 = new zz("OnErrorContainer", 8);
        zz zzVar10 = new zz("OnPrimary", 9);
        a = zzVar10;
        zz zzVar11 = new zz("OnPrimaryContainer", 10);
        zz zzVar12 = new zz("OnPrimaryFixed", 11);
        zz zzVar13 = new zz("OnPrimaryFixedVariant", 12);
        zz zzVar14 = new zz("OnSecondary", 13);
        zz zzVar15 = new zz("OnSecondaryContainer", 14);
        zz zzVar16 = new zz("OnSecondaryFixed", 15);
        zz zzVar17 = new zz("OnSecondaryFixedVariant", 16);
        zz zzVar18 = new zz("OnSurface", 17);
        b = zzVar18;
        zz zzVar19 = new zz("OnSurfaceVariant", 18);
        c = zzVar19;
        zz zzVar20 = new zz("OnTertiary", 19);
        zz zzVar21 = new zz("OnTertiaryContainer", 20);
        zz zzVar22 = new zz("OnTertiaryFixed", 21);
        zz zzVar23 = new zz("OnTertiaryFixedVariant", 22);
        zz zzVar24 = new zz("Outline", 23);
        zz zzVar25 = new zz("OutlineVariant", 24);
        e = zzVar25;
        zz zzVar26 = new zz("Primary", 25);
        f = zzVar26;
        i = new zz[]{zzVar, zzVar2, zzVar3, zzVar4, zzVar5, zzVar6, zzVar7, zzVar8, zzVar9, zzVar10, zzVar11, zzVar12, zzVar13, zzVar14, zzVar15, zzVar16, zzVar17, zzVar18, zzVar19, zzVar20, zzVar21, zzVar22, zzVar23, zzVar24, zzVar25, zzVar26, new zz("PrimaryContainer", 26), new zz("PrimaryFixed", 27), new zz("PrimaryFixedDim", 28), new zz("Scrim", 29), new zz("Secondary", 30), new zz("SecondaryContainer", 31), new zz("SecondaryFixed", 32), new zz("SecondaryFixedDim", 33), new zz("Surface", 34), new zz("SurfaceBright", 35), new zz("SurfaceContainer", 36), new zz("SurfaceContainerHigh", 37), new zz("SurfaceContainerHighest", 38), new zz("SurfaceContainerLow", 39), new zz("SurfaceContainerLowest", 40), new zz("SurfaceDim", 41), new zz("SurfaceTint", 42), new zz("SurfaceVariant", 43), new zz("Tertiary", 44), new zz("TertiaryContainer", 45), new zz("TertiaryFixed", 46), new zz("TertiaryFixedDim", 47)};
    }

    public static zz valueOf(String str) {
        return (zz) Enum.valueOf(zz.class, str);
    }

    public static zz[] values() {
        return (zz[]) i.clone();
    }
}
