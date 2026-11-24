package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class he1 {
    public static final x42 c = new x42("^(?:flashlight|torch)\\s+(?:turn\\s+)?(?:on|off|chalu|band|bandh)$");
    public static final x42 d = new x42("^(?:call|dial|phone)\\s+(.+?)(?:\\s+(?:ko|se))?$|^(.+?)\\s+(?:ko|se)\\s+(?:call|dial|phone)$");
    public static final x42 e = new x42("(?:^|\\s)(?:not|dont|don t|never|mat|nahi|मत|नहीं|नको|नका|नाही)(?:\\s|$)");
    public static final Set f = wh2.c("what", "whats", "who", "whos", "why", "how", "when", "where", "which", "whose", "kya", "kaun", "kaise", "kab", "kahan", "kyun");
    public static final Set g = wh2.c("hi", "hello", "hey", "hola", "namaste", "namastey", "pranam");
    public static final List h = nz.i("good morning", "good afternoon", "good evening", "good night", "how are you", "how's it going", "howdy", "suprabhat", "shubh sandhya");
    public static final Set i = wh2.c("is", "are", "was", "were", "do", "does", "did", "can", "could", "should", "would", "will");
    public static final List j = nz.i("tell me", "explain", "describe", "summarise", "summarize", "translate", "write", "draft", "help me understand", "give me", "suggest", "recommend", "compare", "define", "what if", "can you", "could you", "do you know", "would you", "will you");
    public static final List k = nz.i("can i", "is it", "should i", "do i", "am i", "will it", "could i", "is coffee", "is mango", "are there", "was it", "if i");
    public final mz2 a;
    public final List b;

    public he1(Set set, mz2 mz2Var) {
        set.getClass();
        mz2Var.getClass();
        this.a = mz2Var;
        this.b = mz.K(set, new i2(9, new lo0(17)));
    }

    public static /* synthetic */ a92 b(he1 he1Var, String str, i60 i60Var, int i2) {
        if ((i2 & 4) != 0) {
            i60Var = i60.i;
        }
        return he1Var.a(str, c63.b, i60Var, ii0.a);
    }

    public final a92 a(String str, c63 c63Var, i60 i60Var, List list) {
        str.getClass();
        c63Var.getClass();
        i60Var.getClass();
        list.getClass();
        a92 a92VarC = c(str, c63Var, i60Var);
        if ((a92VarC instanceof y82) && ((y82) a92VarC).a.c >= 0.9f) {
            return a92VarC;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!cs2.A(str2)) {
                a92 a92VarC2 = c(str2, c63Var, i60Var);
                if ((a92VarC2 instanceof y82) && ((y82) a92VarC2).a.c >= 0.9f) {
                    return a92VarC2;
                }
            }
        }
        return a92VarC;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a4  */
    public final a92 c(String str, c63 c63Var, i60 i60Var) {
        a92 z82Var;
        a92 x82Var;
        String str2;
        String str3;
        Object next;
        System.currentTimeMillis();
        b63 b63VarA = this.a.a(str);
        String str4 = b63VarA.a;
        List list = b63VarA.d;
        String str5 = b63VarA.c;
        if (cs2.A(str5)) {
            return new z82(str);
        }
        Iterator it = this.b.iterator();
        while (true) {
            z82Var = null;
            if (!it.hasNext()) {
                x82Var = null;
                break;
            }
            f5 f5VarC = ((o21) it.next()).c(b63VarA, i60Var);
            if (f5VarC != null) {
                x82Var = new y82(f5VarC);
                break;
            }
        }
        if (x82Var == null) {
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                fh1 fh1VarD = d.d(str5);
                if (fh1VarD != null) {
                    Iterator it2 = mz.u(1, fh1VarD.a()).iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                    } while (cs2.A((String) next));
                    str2 = (String) next;
                    if (str2 == null) {
                        str2 = null;
                    } else {
                        if (e.a(str2)) {
                            str2 = null;
                        }
                        if (str2 != null) {
                            Pattern patternCompile = Pattern.compile("(?:^|\\s)(?:कॉल|फोन)(?:\\s|$)");
                            patternCompile.getClass();
                            str4.getClass();
                            if (patternCompile.matcher(str4).find()) {
                                str2 = null;
                            }
                        } else {
                            str2 = null;
                        }
                    }
                } else {
                    str2 = null;
                }
                q21 q21Var = q21.a;
                if (str2 != null && !cs2.A(str2)) {
                    Map mapSingletonMap = Collections.singletonMap("contact_name", cs2.V(str2).toString());
                    mapSingletonMap.getClass();
                    arrayList.add(new f5("call.contact", mapSingletonMap, 0.85f, q21Var, b63VarA.a));
                }
                if (c.e(str5)) {
                    if (!list.isEmpty()) {
                        Iterator it3 = list.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                str3 = "device.flashlight.on";
                                break;
                            }
                            if (wh2.c("off", "band", "bandh").contains((String) it3.next())) {
                                str3 = "device.flashlight.off";
                                break;
                            }
                        }
                    } else {
                        str3 = "device.flashlight.on";
                        break;
                    }
                    arrayList.add(new f5(str3, ji0.a, 0.9f, q21Var, b63VarA.a));
                }
                if (arrayList.size() == 1) {
                    z82Var = new y82((f5) mz.x(arrayList));
                } else if (arrayList.size() > 1) {
                    z82Var = new z82(str4);
                }
            }
            x82Var = z82Var;
        }
        if (x82Var == null) {
            if (cs2.s(cs2.X(str4).toString(), '?')) {
                x82Var = new x82(b63VarA.b);
            } else {
                String str6 = (String) mz.y(list);
                if (str6 != null) {
                    if (!f.contains(str6) && !g.contains(str6) && !b63VarA.b(h)) {
                        c63Var.getClass();
                        c63 c63Var2 = c63.c;
                        if ((c63Var == c63Var2 || !i.contains(str6)) && !b63VarA.b(j) && !b63VarA.b(k) && (c63Var == c63Var2 || list.size() < 7)) {
                        }
                    }
                    x82Var = new x82(b63VarA.b);
                }
                x82Var = new z82(str);
            }
        }
        System.currentTimeMillis();
        return x82Var;
    }
}
