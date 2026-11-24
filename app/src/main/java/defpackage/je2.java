package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class je2 implements o21 {
    public static final x42 a = new x42("^(?:(?:(?:hey|ok|okay|hi|hello|yo)\\s+)?(?:sonic|sonics|sonic's|sonik|sonnic|sonick|sonix|zonic)\\b[\\s,!.?:;—-]*)?(?:(?:please|can you|could you)\\s+)?(?:type|enter|write|input)\\s+(.+?)\\s+(?:in|into|on)\\s+(?:the\\s+)?(.+?)(?:\\s+please)?$", y42.IGNORE_CASE);

    @Override // defpackage.o21
    public final int a() {
        return 1010;
    }

    @Override // defpackage.o21
    public final String b() {
        return "search_input";
    }

    @Override // defpackage.o21
    public final f5 c(b63 b63Var, i60 i60Var) {
        i60Var.getClass();
        return k24.a(b63Var);
    }
}
