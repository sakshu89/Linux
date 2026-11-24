package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class de {
    public static final de a;
    public static final de b;
    public static final de c;
    public static final de e;
    public static final de f;
    public static final de i;
    public static final de j;
    public static final /* synthetic */ de[] k;

    static {
        de deVar = new de("Paragraph", 0);
        a = deVar;
        de deVar2 = new de("Span", 1);
        b = deVar2;
        de deVar3 = new de("VerbatimTts", 2);
        c = deVar3;
        de deVar4 = new de("Url", 3);
        e = deVar4;
        de deVar5 = new de("Link", 4);
        f = deVar5;
        de deVar6 = new de("Clickable", 5);
        i = deVar6;
        de deVar7 = new de("String", 6);
        j = deVar7;
        k = new de[]{deVar, deVar2, deVar3, deVar4, deVar5, deVar6, deVar7};
    }

    public static de valueOf(String str) {
        return (de) Enum.valueOf(de.class, str);
    }

    public static de[] values() {
        return (de[]) k.clone();
    }
}
