package defpackage;

import com.ibm.icu.text.BreakIterator;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dx1 implements o21 {
    public static final x42 a = new x42("^(?:where am i|whats my location|what is my location|my current location|current location|where are we)\\??$");
    public static final List b = nz.i(new x42("^(?:find|show|search(?:\\s+for)?|look for|any|locate)\\s+(?:me\\s+)?(.+?)\\s+(?:near|nearby|around|close to)\\s*(?:me|here|us)?$"), new x42("^(?:nearby|nearest|closest)\\s+(.+)$"), new x42("^(.+?)\\s+near\\s+(?:me|here)$"));
    public static final List c = nz.i(new x42("^(?:navigate|directions|route)\\s+(?:me\\s+)?(?:to\\s+)?(.+)$"), new x42("^(?:take|get|guide)\\s+me\\s+to\\s+(.+)$"), new x42("^how\\s+do\\s+i\\s+get\\s+to\\s+(.+)$"), new x42("^(?:drive|walk|cycle)\\s+to\\s+(.+)$"), new x42("^show\\s+me\\s+the\\s+way\\s+to\\s+(.+)$"));

    @Override // defpackage.o21
    public final int a() {
        return BreakIterator.WORD_IDEO_LIMIT;
    }

    @Override // defpackage.o21
    public final String b() {
        return "places";
    }

    @Override // defpackage.o21
    public final f5 c(b63 b63Var, i60 i60Var) {
        String str;
        String strB;
        String str2;
        String strB2;
        i60Var.getClass();
        if (a.a(b63Var.c)) {
            return dp4.d(b63Var, "maps.whereami", null, 0.99f, 10);
        }
        Iterator it = b.iterator();
        while (it.hasNext()) {
            fh1 fh1VarA = b63Var.a((x42) it.next());
            if (fh1VarA != null && (str2 = (String) ((dh1) fh1VarA.a()).get(1)) != null && (strB2 = dp4.b(str2)) != null && !cs2.A(strB2)) {
                Map mapSingletonMap = Collections.singletonMap("place", strB2);
                mapSingletonMap.getClass();
                return dp4.d(b63Var, "maps.nearby", mapSingletonMap, 0.9f, 8);
            }
        }
        Iterator it2 = c.iterator();
        while (it2.hasNext()) {
            fh1 fh1VarA2 = b63Var.a((x42) it2.next());
            if (fh1VarA2 != null && (str = (String) ((dh1) fh1VarA2.a()).get(1)) != null && (strB = dp4.b(str)) != null && !cs2.A(strB)) {
                Map mapSingletonMap2 = Collections.singletonMap("place", strB);
                mapSingletonMap2.getClass();
                return dp4.d(b63Var, "maps.navigate", mapSingletonMap2, 0.9f, 8);
            }
        }
        return null;
    }
}
