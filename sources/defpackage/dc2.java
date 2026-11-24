package defpackage;

import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dc2 {
    public static final List e;
    public static final Set f;
    public static final Set g;
    public static final x42 h;
    public static final x42 i;
    public static final x42 j;
    public static final x42 k;
    public static final x42 l;
    public static final x42 m;
    public final cc2 a;
    public final Integer b;
    public final String c;
    public final String d;

    static {
        List listI = nz.i("first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth");
        e = listI;
        f = wh2.c("next", "previous", "last", "this", "current", "playing", "pause", "resume", "like", "dislike", "subscribe", "like this", "dislike this", "close", "close this", "skip", "skip this");
        String strV = cq.v("(?:topmost|top|", mz.C(listI, "|", null, null, null, 62), "|[1-9][0-9]?(?:st|nd|rd|th)?|100)");
        g = wh2.c("com.android.chrome", "com.google.android.googlequicksearchbox");
        y42 y42Var = y42.IGNORE_CASE;
        h = new x42("\\s+(?:on|in|from)\\s+(?:the\\s+)?(whatsapp|youtube|google|screen|app)$", y42Var);
        i = new x42(cq.v("^(?:the\\s+)?(", strV, ")\\s+(?:(?:search|youtube|whatsapp)\\s+)?((?:chat|conversation|contact|short(?:s| video)?|video|result|item|one))$"), y42Var);
        j = new x42(cq.v("^((?:chat|conversation|contact|short(?:s| video)?|video|result|item|one))\\s+(?:number\\s+)?(", strV, ")$"), y42Var);
        k = new x42("^(chat|conversation|contact|short(?:s| video)?|video|result|item)\\s+(?:(?:named|called|titled)\\s+)?(.+)$", y42Var);
        l = new x42("^video\\s+(?:player|editor|recorder|converter|downloader)(?:\\s+(?:app|application))?$", y42Var);
        m = new x42("^(.+?)\\s+(chat|conversation|contact|short(?:s| video)?|video|result|item)$", y42Var);
    }

    public dc2(cc2 cc2Var, Integer num, String str, String str2, int i2) {
        num = (i2 & 2) != 0 ? null : num;
        str = (i2 & 4) != 0 ? null : str;
        str2 = (i2 & 8) != 0 ? null : str2;
        this.a = cc2Var;
        this.b = num;
        this.c = str;
        this.d = str2;
    }

    public final boolean a(String str) {
        String str2 = this.d;
        if (g31.a(str2, "com.google.android.googlequicksearchbox")) {
            return g.contains(str);
        }
        x42 x42Var = ie2.a;
        return ie2.j(str2, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dc2)) {
            return false;
        }
        dc2 dc2Var = (dc2) obj;
        return this.a == dc2Var.a && g31.a(this.b, dc2Var.b) && g31.a(this.c, dc2Var.c) && g31.a(this.d, dc2Var.d);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "ScreenResultTarget(kind=" + this.a + ", position=" + this.b + ", name=" + this.c + ", packageName=" + this.d + ")";
    }
}
