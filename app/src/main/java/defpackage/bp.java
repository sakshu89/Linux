package defpackage;

import com.ibm.icu.impl.locale.LanguageTag;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bp implements o21 {
    public static final x42 a = new x42("^(?:calculate|compute|solve|evaluate|whats|what is|how much is|how many is|tell me|work out|figure out)\\s+");
    public static final x42 b = new x42("(\\d+(?:\\.\\d+)?)\\s*(?:percent|%)\\s*of\\s*");
    public static final List c = nz.i(new wt1(new x42("\\bmultiplied\\s+by\\b"), "*"), new wt1(new x42("\\bdivided\\s+by\\b"), "/"), new wt1(new x42("\\bto\\s+the\\s+power\\s+of\\b"), "^"), new wt1(new x42("\\braised\\s+to\\b"), "^"), new wt1(new x42("\\bplus\\b"), "+"), new wt1(new x42("\\bminus\\b"), LanguageTag.SEP), new wt1(new x42("\\btimes\\b"), "*"), new wt1(new x42("\\bover\\b"), "/"), new wt1(new x42("\\bx\\b"), "*"), new wt1(new x42("×"), "*"), new wt1(new x42("÷"), "/"), new wt1(new x42("\\bmod\\b"), "%"), new wt1(new x42("\\bequals\\b"), ""), new wt1(new x42("="), ""));
    public static final x42 d = new x42("^[\\d.+\\-*/^%()]+$");

    @Override // defpackage.o21
    public final int a() {
        return 800;
    }

    @Override // defpackage.o21
    public final String b() {
        return "calculator";
    }

    @Override // defpackage.o21
    public final f5 c(b63 b63Var, i60 i60Var) {
        i60Var.getClass();
        String str = b63Var.c;
        x42 x42Var = a;
        boolean zA = x42Var.a(str);
        String string = cs2.V(x42Var.f(str, "")).toString();
        if (cs2.A(string)) {
            return null;
        }
        String strG = b.g(string, new j(11));
        for (wt1 wt1Var : c) {
            strG = ((x42) wt1Var.a).f(strG, (String) wt1Var.b);
        }
        Pattern patternCompile = Pattern.compile("\\s+");
        patternCompile.getClass();
        strG.getClass();
        String strReplaceAll = patternCompile.matcher(strG).replaceAll("");
        strReplaceAll.getClass();
        if (!d.e(strReplaceAll)) {
            return null;
        }
        Pattern patternCompile2 = Pattern.compile("\\d");
        patternCompile2.getClass();
        if (!patternCompile2.matcher(strReplaceAll).find()) {
            return null;
        }
        Pattern patternCompile3 = Pattern.compile("[+\\-*/^]");
        patternCompile3.getClass();
        if (!patternCompile3.matcher(strReplaceAll).find()) {
            return null;
        }
        Map mapSingletonMap = Collections.singletonMap("text", strReplaceAll);
        mapSingletonMap.getClass();
        return dp4.d(b63Var, "util.calculate", mapSingletonMap, zA ? 0.99f : 0.75f, 8);
    }
}
