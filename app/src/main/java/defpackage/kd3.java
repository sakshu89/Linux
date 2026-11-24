package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class kd3 {
    public static final x42 a;
    public static final x42 b;
    public static final x42 c;
    public static final x42 d;
    public static final x42 e;
    public static final x42 f;
    public static final x42 g;
    public static final x42 h;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        a = new x42("\\s+[–—-]\\s+Go to channel\\b", y42Var);
        b = new x42("\\s+[–—-]\\s+(?:[0-9]+(?::[0-9]{2}){1,2}|[0-9]+\\s+(?:hours?|minutes?|seconds?)(?:\\s*,?\\s*(?:and\\s+)?[0-9]+\\s+(?:hours?|minutes?|seconds?))*)$", y42Var);
        c = new x42("\\s+[–—-]\\s+(?:[0-9]+(?::[0-9]{2}){1,2}|[0-9]+\\s+(?:hours?|minutes?|seconds?)(?:\\s*,?\\s*(?:and\\s+)?[0-9]+\\s+(?:hours?|minutes?|seconds?))*)(?=\\s+[–—-])", y42Var);
        d = new x42("\\s+[–—-]\\s+play video\\s*$", y42Var);
        e = new x42("\\s+[–—-]\\s+play shorts?\\s*[.!]?\\s*$", y42Var);
        f = new x42("\\s+[–—-]\\s+[0-9][0-9,.]*\\s*(?:k|m|b|lakh|crore)?\\s+views\\s+[–—-]\\s+play shorts?\\s*[.!]?\\s*$", y42Var);
        g = new x42("\\b(?:views|verified)\\b|\\b(?:seconds?|minutes?|hours?|days?|weeks?|months?|years?)\\s+ago\\b", y42Var);
        h = new x42(".+,\\s*(?:[0-9]+(?::[0-9]{2}){1,2}|[0-9]+\\s+(?:hours?|minutes?|seconds?)(?:\\s*,?\\s*(?:and\\s+)?[0-9]+\\s+(?:hours?|minutes?|seconds?))*)", y42Var);
    }

    public static String a(String str) {
        fh1 fh1VarB;
        str.getClass();
        String string = cs2.V(str).toString();
        fh1 fh1VarB2 = x42.b(a, string);
        if (fh1VarB2 != null) {
            String string2 = cs2.X(string.substring(0, fh1VarB2.b().a)).toString();
            fh1 fh1VarB3 = x42.b(b, string2);
            if (fh1VarB3 != null) {
                string2 = string2.substring(0, fh1VarB3.b().a);
            }
            return cs2.V(string2).toString();
        }
        boolean zA = d.a(string);
        x42 x42Var = e;
        if (zA || x42Var.a(string)) {
            zt0 zt0Var = new zt0(x42.c(c, string));
            Object obj = null;
            while (zt0Var.hasNext()) {
                Object next = zt0Var.next();
                if (g.a(string.substring(((fh1) next).b().b + 1))) {
                    obj = next;
                }
            }
            fh1 fh1Var = (fh1) obj;
            if (fh1Var != null) {
                return cs2.V(string.substring(0, fh1Var.b().a)).toString();
            }
            if (x42Var.a(string) && (fh1VarB = x42.b(f, string)) != null) {
                return cs2.V(string.substring(0, fh1VarB.b().a)).toString();
            }
        }
        int iD = cs2.D(string, 2, " by ");
        if (iD > 0) {
            return h.e(string.substring(iD + 4)) ? cs2.V(string.substring(0, iD)).toString() : string;
        }
        return string;
    }
}
