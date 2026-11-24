package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nk0 implements o21 {
    public static final x42 a;
    public static final List b;
    public static final x42 c;
    public static final ArrayList d;
    public static final ArrayList e;
    public static final ArrayList f;
    public static final ArrayList g;

    static {
        y74 y74Var = new y74(12);
        y42 y42Var = y42.IGNORE_CASE;
        a = new x42("^(?:(?:(?:hey|ok|okay|hi|hello|yo)\\s+)?(?:sonic|sonics|sonic's|sonik|sonnic|sonick|sonix|zonic)\\b[\\s,!.?:;—-]*)?(?:(?:please|can you|could you|would you|will you|i want you to|i need you to|i want to|i would like to|let's|lets|kindly|just|now)\\s+)*", y42Var);
        List listI = nz.i("first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth");
        b = listI;
        c = new x42(cq.v("^(?:search|find|look\\s+up)\\s+(?:for\\s+)?(.+?)\\s+on\\s+youtube\\s+and\\s+(?:click|tap|select|play|open)\\s+(?:on\\s+)?(?:the\\s+)?(", mz.C(listI, "|", null, null, null, 62), "|[1-9][0-9]?(?:st|nd|rd|th)?|100)(?:\\s+(?:video|result))?(?:\\s+please)?[.!?]?$"), y42Var);
        d = y74.r(y74Var, "^open\\s+youtube\\s+(?:and\\s+)?search\\s+for\\s+(.+?)\\s+and\\s+play(?:\\s+the\\s+first\\s+video)?(?:\\s+please)?[.!?]?$", "^open\\s+youtube\\s+(?:and\\s+)?play\\s+(?:the\\s+)?first\\s+video\\s+of\\s+(.+)$");
        e = y74.r(y74Var, "^play\\s+(.+?)\\s+on\\s+youtube(?:\\s+please)?[.!?]?$", "^open\\s+youtube\\s+and\\s+play\\s+(.+)$", "^youtube\\s+play\\s+(.+)$");
        f = y74.r(y74Var, "^(?:search|find|look\\s+up|show\\s+me)\\s+(?:for\\s+)?(.+?)\\s+on\\s+youtube(?:\\s+please)?[.!?]?$", "^open\\s+youtube\\s+and\\s+(?:search|look\\s+up)\\s+(?:for\\s+)?(.+)$", "^search\\s+youtube\\s+(?:for\\s+)?(.+)$", "^open\\s+youtube\\s+for\\s+(.+)$", "^youtube\\s+search\\s+(?:for\\s+)?(.+)$");
        g = y74.r(y74Var, "^(?:search|find|google|look\\s+up|show\\s+me)\\s+(?:for\\s+)?(.+?)\\s+on\\s+(?:google|the\\s+web|the\\s+internet|internet)(?:\\s+please)?[.!?]?$", "^(?:search|look\\s+up)\\s+google\\s+for\\s+(.+)$", "^google\\s+(.+)$", "^(?:search\\s+)?the\\s+web\\s+for\\s+(.+)$");
    }

    @Override // defpackage.o21
    public final int a() {
        return 850;
    }

    @Override // defpackage.o21
    public final String b() {
        return "explicit_web_search";
    }

    @Override // defpackage.o21
    public final f5 c(b63 b63Var, i60 i60Var) {
        i60Var.getClass();
        return y74.w(b63Var);
    }
}
