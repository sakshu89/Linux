package defpackage;

import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.lang.UCharacter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class in2 {
    public final he1 a;
    public final ll2 b;
    public final aw1 c;
    public final u30 d;
    public final d62 e;
    public final k72 f;
    public final a60 g;
    public final n h;
    public final f40 i;
    public final j5 j;
    public final e40 k;
    public final bh l;

    public in2(he1 he1Var, ll2 ll2Var, aw1 aw1Var, u30 u30Var, d62 d62Var, k72 k72Var, a60 a60Var, n nVar, f40 f40Var, j5 j5Var, e40 e40Var, bh bhVar) {
        he1Var.getClass();
        ll2Var.getClass();
        aw1Var.getClass();
        u30Var.getClass();
        d62Var.getClass();
        k72Var.getClass();
        a60Var.getClass();
        nVar.getClass();
        f40Var.getClass();
        j5Var.getClass();
        e40Var.getClass();
        bhVar.getClass();
        this.a = he1Var;
        this.b = ll2Var;
        this.c = aw1Var;
        this.d = u30Var;
        this.e = d62Var;
        this.f = k72Var;
        this.g = a60Var;
        this.h = nVar;
        this.i = f40Var;
        this.j = j5Var;
        this.k = e40Var;
        this.l = bhVar;
    }

    public static final boolean a(in2 in2Var, f5 f5Var) {
        String strC;
        String strC2;
        String strC3;
        in2Var.getClass();
        String str = f5Var.a;
        if (!g31.a(str, "message.whatsapp.draft") && !g31.a(str, "message.sms.send") && !g31.a(str, "message.compose.choose_channel") && !g31.a(str, "message.draft")) {
            if (!g31.a(str, "call.contact")) {
            }
        }
        String strC4 = f5Var.c("contact_name");
        boolean z = ((strC4 == null || cs2.A(strC4)) && ((strC = f5Var.c("phone_number")) == null || cs2.A(strC)) && ((strC2 = f5Var.c("recipients")) == null || cs2.A(strC2))) ? false : true;
        String strC5 = f5Var.c("message_body");
        return z && ((strC5 != null && !cs2.A(strC5)) || ((strC3 = f5Var.c("text")) != null && !cs2.A(strC3)));
    }

    public static final Object b(in2 in2Var, nm0 nm0Var, nu2 nu2Var) {
        e40 e40Var = in2Var.k;
        synchronized (e40Var) {
            e40Var.b = null;
        }
        Object objK = in2Var.k(nm0Var, new l5("", e33.k, "There's nothing waiting on me.", null, null, null, null, null, null, null, "resume called with no pending interaction", 2040), null, nu2Var);
        return objK == t70.a ? objK : q43.a;
    }

    public static final Object c(in2 in2Var, nm0 nm0Var, qv1 qv1Var, String str, nu2 nu2Var) {
        Object next;
        Map map;
        a60 a60Var = in2Var.g;
        a60Var.b();
        yx yxVar = qv1Var.c;
        a92 a92VarB = he1.b(in2Var.a, str, (i60) a60Var.c.getValue(), 8);
        y82 y82Var = a92VarB instanceof y82 ? (y82) a92VarB : null;
        f5 f5Var = y82Var != null ? y82Var.a : null;
        List list = yxVar.c;
        Map map2 = yxVar.e;
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!g31.a(((zx) next).b, str));
        zx zxVar = (zx) next;
        Map map3 = zxVar != null ? zxVar.d : null;
        Map map4 = ji0.a;
        if (map3 == null) {
            map3 = map4;
        }
        Map map5 = f5Var != null ? f5Var.b : null;
        if (map5 != null) {
            map4 = map5;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map4.entrySet()) {
            String str2 = (String) entry.getKey();
            if (g31.a(str2, "contact_name") || g31.a(str2, "message_body") || g31.a(str2, "recipients") || g31.a(str2, "phone_number")) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            String str3 = (String) entry2.getKey();
            if (!map3.containsKey(str3) && !map2.containsKey(str3)) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        String str4 = yxVar.d;
        LinkedHashMap linkedHashMapE = bh1.e(bh1.e(map2, linkedHashMap2), map3);
        String str5 = yxVar.b;
        if (linkedHashMapE.isEmpty()) {
            Map mapSingletonMap = Collections.singletonMap(str5, str);
            mapSingletonMap.getClass();
            map = mapSingletonMap;
        } else {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(linkedHashMapE);
            linkedHashMap3.put(str5, str);
            map = linkedHashMap3;
        }
        Object objI = in2Var.i(nm0Var, new f5(str4, map, 1.0f, q21.e, qv1Var.a.e), qv1Var.d, nu2Var);
        return objI == t70.a ? objI : q43.a;
    }

    public static final Object d(in2 in2Var, nm0 nm0Var, rv1 rv1Var, nu2 nu2Var) {
        in2Var.g.b();
        boolean z = rv1Var instanceof ov1;
        t70 t70Var = t70.a;
        if (z) {
            Object objI = in2Var.i(nm0Var, ((ov1) rv1Var).a, true, nu2Var);
            if (objI == t70Var) {
                return objI;
            }
        } else if (rv1Var instanceof qv1) {
            qv1 qv1Var = (qv1) rv1Var;
            Object objO = in2Var.o(nm0Var, qv1Var.a.e, qv1Var, null, nu2Var);
            if (objO == t70Var) {
                return objO;
            }
        } else {
            if (!(rv1Var instanceof pv1)) {
                dk0.l();
                return null;
            }
            pv1 pv1Var = (pv1) rv1Var;
            f5 f5Var = pv1Var.a;
            Object objK = in2Var.k(nm0Var, new l5(f5Var.e, e33.j, "Tap allow on the permission prompt and I'll carry on.", f5Var, pv1Var.b, null, null, null, new e52(pv1Var.c, "Allow"), null, null, 3808), rv1Var, nu2Var);
            if (objK == t70Var) {
                return objK;
            }
        }
        return q43.a;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object e(in2 in2Var, nm0 nm0Var, String str, c63 c63Var, List list, y50 y50Var) {
        hn2 hn2Var;
        if (y50Var instanceof hn2) {
            hn2Var = (hn2) y50Var;
            int i = hn2Var.s;
            if ((i & Integer.MIN_VALUE) != 0) {
                hn2Var.s = i - Integer.MIN_VALUE;
            } else {
                hn2Var = new hn2(in2Var, y50Var);
            }
        } else {
            hn2Var = new hn2(in2Var, y50Var);
        }
        Object objC = hn2Var.k;
        int i2 = hn2Var.s;
        q43 q43Var = q43.a;
        Object obj = t70.a;
        if (i2 == 0) {
            bz3.g(objC);
            j5 j5Var = in2Var.j;
            hn2Var.e = nm0Var;
            hn2Var.f = str;
            hn2Var.i = c63Var;
            hn2Var.j = list;
            hn2Var.s = 1;
            objC = rn4.c(j5Var.b, hn2Var);
            if (objC != obj) {
            }
            return obj;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                bz3.g(objC);
                return q43Var;
            }
            if (i2 == 3) {
                bz3.g(objC);
                return q43Var;
            }
            if (i2 == 4) {
                bz3.g(objC);
                return q43Var;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        list = hn2Var.j;
        c63Var = hn2Var.i;
        str = hn2Var.f;
        nm0Var = hn2Var.e;
        bz3.g(objC);
        l61 l61Var = ((g5) objC).h;
        xy xyVar = l61.c;
        a92 a92VarA = in2Var.a.a(str, c63Var, (i60) in2Var.g.c.getValue(), list);
        if (a92VarA instanceof y82) {
            f5 f5Var = ((y82) a92VarA).a;
            hn2Var.e = null;
            hn2Var.f = null;
            hn2Var.i = null;
            hn2Var.j = null;
            hn2Var.s = 2;
            if (in2Var.i(nm0Var, f5Var, false, hn2Var) == obj) {
                return obj;
            }
            return q43Var;
        }
        if (a92VarA instanceof x82) {
            String str2 = ((x82) a92VarA).a;
            hn2Var.e = null;
            hn2Var.f = null;
            hn2Var.i = null;
            hn2Var.j = null;
            hn2Var.s = 3;
            if (in2Var.h(nm0Var, str2, hn2Var) == obj) {
                return obj;
            }
            return q43Var;
        }
        if (!(a92VarA instanceof z82)) {
            dk0.l();
            return null;
        }
        String str3 = ((z82) a92VarA).a;
        hn2Var.e = null;
        hn2Var.f = null;
        hn2Var.i = null;
        hn2Var.j = null;
        hn2Var.s = 4;
        if (in2Var.h(nm0Var, str3, hn2Var) == obj) {
            return obj;
        }
        return q43Var;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00df A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x00e0  */
    public final Object f(nm0 nm0Var, f5 f5Var, bl2 bl2Var, d32 d32Var, en2 en2Var) {
        String strConcat;
        h52 h52Var;
        h52 e52Var;
        Object objK;
        String str = f5Var.e;
        if (d32Var.equals(a32.a)) {
            strConcat = bl2Var.m().concat(" is ready.");
        } else if (d32Var instanceof z22) {
            strConcat = "I still need permission for that, and I've already asked once.";
        } else if (d32Var instanceof c32) {
            strConcat = ((c32) d32Var).a;
            Set setC = wh2.c('.', '!', '?');
            String string = cs2.X(strConcat).toString();
            string.getClass();
            if (!mz.s(string.length() == 0 ? null : Character.valueOf(string.charAt(string.length() - 1)), setC)) {
                strConcat = strConcat.concat(".");
            }
        } else {
            if (!(d32Var instanceof b32)) {
                dk0.l();
                return null;
            }
            String lowerCase = ((b32) d32Var).a.name().toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            strConcat = "That's part of the " + lowerCase + " plan.";
        }
        String strD = bl2Var.d();
        if (!(d32Var instanceof c32)) {
            if (d32Var instanceof z22) {
                e52Var = new e52(((z22) d32Var).a, "Open permissions");
            } else {
                h52Var = null;
            }
            objK = k(nm0Var, new l5(str, e33.e, strConcat, f5Var, strD, null, null, null, h52Var, null, hc4.b(d32Var), 1760), null, en2Var);
            if (objK == t70.a) {
                return objK;
            }
            return q43.a;
        }
        e52Var = ((c32) d32Var).b;
        h52Var = e52Var;
        objK = k(nm0Var, new l5(str, e33.e, strConcat, f5Var, strD, null, null, null, h52Var, null, hc4.b(d32Var), 1760), null, en2Var);
        if (objK == t70.a) {
            return objK;
        }
        return q43.a;
    }

    public final Object g(nm0 nm0Var, String str, rv1 rv1Var, y50 y50Var) {
        e40 e40Var = this.k;
        synchronized (e40Var) {
            e40Var.b = null;
        }
        bl2 bl2VarA = this.b.a(rv1Var.getIntent().a);
        if (bl2VarA != null) {
            bl2VarA.f();
        }
        Object objK = k(nm0Var, new l5(str, e33.k, "Okay, dropped it.", rv1Var.getIntent(), null, null, null, null, null, null, cq.j("cancelled pending ", u42.a(rv1Var.getClass()).b()), 2032), null, y50Var);
        return objK == t70.a ? objK : q43.a;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0125  */
    /* JADX WARN: Code duplicated, block: B:62:0x0159  */
    /* JADX WARN: Code duplicated, block: B:64:0x015d  */
    /* JADX WARN: Code duplicated, block: B:67:0x018e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0192  */
    /* JADX WARN: Code duplicated, block: B:71:0x01c2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:72:0x01c3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object h(nm0 nm0Var, String str, y50 y50Var) {
        dn2 dn2Var;
        String str2;
        nm0 nm0Var2;
        ArrayList arrayList;
        nm0 nm0Var3;
        String str3;
        h eVar;
        String str4;
        l5 l5Var;
        l5 l5Var2;
        l5 l5Var3;
        q43 q43Var = q43.a;
        if (y50Var instanceof dn2) {
            dn2Var = (dn2) y50Var;
            int i = dn2Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                dn2Var.k = i - Integer.MIN_VALUE;
            } else {
                dn2Var = new dn2(this, y50Var);
            }
        } else {
            dn2Var = new dn2(this, y50Var);
        }
        Object obj = dn2Var.i;
        Object obj2 = t70.a;
        int i2 = dn2Var.k;
        try {
            try {
                if (i2 == 0) {
                    bz3.g(obj);
                    e40 e40Var = this.k;
                    synchronized (e40Var) {
                        e40Var.b = null;
                    }
                    Object obj3 = b5.a;
                    dn2Var.e = nm0Var;
                    dn2Var.f = str;
                    dn2Var.k = 1;
                    if (nm0Var.n(obj3, dn2Var) != obj2) {
                        str2 = str;
                        nm0Var2 = nm0Var;
                    }
                    return obj2;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            bz3.g(obj);
                            return q43Var;
                        }
                        if (i2 == 4) {
                            bz3.g(obj);
                            return q43Var;
                        }
                        if (i2 == 5) {
                            bz3.g(obj);
                            return q43Var;
                        }
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    str3 = dn2Var.f;
                    nm0Var3 = dn2Var.e;
                    try {
                        bz3.g(obj);
                        eVar = (h) obj;
                    } catch (Throwable th) {
                        th = th;
                        eVar = new e("I couldn't reach the answer for that.", cq.k(u42.a(th.getClass()).b(), ": ", th.getMessage()), true, true);
                    }
                    str4 = str3;
                    if (eVar instanceof f) {
                        f fVar = (f) eVar;
                        l5Var3 = new l5(str4, e33.s, fVar.a, null, null, null, null, null, null, null, cq.j("provider=", fVar.b), 2040);
                        dn2Var.e = null;
                        dn2Var.f = null;
                        dn2Var.k = 3;
                        if (k(nm0Var3, l5Var3, null, dn2Var) != obj2) {
                            return obj2;
                        }
                        return q43Var;
                    }
                    if (eVar instanceof g) {
                        g gVar = (g) eVar;
                        l5Var2 = new l5(str4, e33.e, gVar.a, null, null, null, null, null, gVar.b, null, "no provider available", 1784);
                        dn2Var.e = null;
                        dn2Var.f = null;
                        dn2Var.k = 4;
                        if (k(nm0Var3, l5Var2, null, dn2Var) != obj2) {
                            return obj2;
                        }
                        return q43Var;
                    }
                    if (eVar instanceof e) {
                        dk0.l();
                        return null;
                    }
                    e eVar2 = (e) eVar;
                    l5Var = new l5(str4, e33.c, eVar2.a, null, null, null, null, null, null, null, eVar2.b, 2040);
                    dn2Var.e = null;
                    dn2Var.f = null;
                    dn2Var.k = 5;
                    if (k(nm0Var3, l5Var, null, dn2Var) != obj2) {
                        return obj2;
                    }
                    return q43Var;
                }
                String str5 = dn2Var.f;
                nm0Var2 = dn2Var.e;
                bz3.g(obj);
                str2 = str5;
                n nVar = this.h;
                d dVar = new d(str2, arrayList, 10);
                dn2Var.e = nm0Var2;
                dn2Var.f = str2;
                dn2Var.k = 2;
                Object objC = nVar.c(dVar, dn2Var);
                if (objC != obj2) {
                    nm0Var3 = nm0Var2;
                    str3 = str2;
                    obj = objC;
                    eVar = (h) obj;
                    str4 = str3;
                    if (eVar instanceof f) {
                        f fVar2 = (f) eVar;
                        l5Var3 = new l5(str4, e33.s, fVar2.a, null, null, null, null, null, null, null, cq.j("provider=", fVar2.b), 2040);
                        dn2Var.e = null;
                        dn2Var.f = null;
                        dn2Var.k = 3;
                        if (k(nm0Var3, l5Var3, null, dn2Var) != obj2) {
                            return q43Var;
                        }
                    } else if (eVar instanceof g) {
                        g gVar2 = (g) eVar;
                        l5Var2 = new l5(str4, e33.e, gVar2.a, null, null, null, null, null, gVar2.b, null, "no provider available", 1784);
                        dn2Var.e = null;
                        dn2Var.f = null;
                        dn2Var.k = 4;
                        if (k(nm0Var3, l5Var2, null, dn2Var) != obj2) {
                            return q43Var;
                        }
                    } else {
                        if (eVar instanceof e) {
                            dk0.l();
                            return null;
                        }
                        e eVar3 = (e) eVar;
                        l5Var = new l5(str4, e33.c, eVar3.a, null, null, null, null, null, null, null, eVar3.b, 2040);
                        dn2Var.e = null;
                        dn2Var.f = null;
                        dn2Var.k = 5;
                        if (k(nm0Var3, l5Var, null, dn2Var) != obj2) {
                            return q43Var;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                nm0Var3 = nm0Var2;
                str3 = str2;
                eVar = new e("I couldn't reach the answer for that.", cq.k(u42.a(th.getClass()).b(), ": ", th.getMessage()), true, true);
            }
            Iterable iterable = (Iterable) this.g.g.a.getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj4 : iterable) {
                if (((l5) obj4).b == e33.s) {
                    arrayList2.add(obj4);
                }
            }
            List<l5> listM = mz.M(3, arrayList2);
            arrayList = new ArrayList();
            for (l5 l5Var4 : listM) {
                rz.q(nz.i(new h0(i.a, l5Var4.a), new h0(i.b, l5Var4.c)), arrayList);
            }
            return obj2;
        } catch (CancellationException e) {
            throw e;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:105:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:107:0x0206  */
    /* JADX WARN: Code duplicated, block: B:110:0x0245  */
    /* JADX WARN: Code duplicated, block: B:112:0x024d  */
    /* JADX WARN: Code duplicated, block: B:114:0x0253  */
    /* JADX WARN: Code duplicated, block: B:117:0x028a  */
    /* JADX WARN: Code duplicated, block: B:120:0x0294  */
    /* JADX WARN: Code duplicated, block: B:124:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:126:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:129:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:131:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:134:0x032a  */
    /* JADX WARN: Code duplicated, block: B:136:0x0350  */
    /* JADX WARN: Code duplicated, block: B:162:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:164:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:166:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:167:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:169:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:174:0x0435  */
    /* JADX WARN: Code duplicated, block: B:177:0x0453  */
    /* JADX WARN: Code duplicated, block: B:180:0x0462  */
    /* JADX WARN: Code duplicated, block: B:182:0x0467  */
    /* JADX WARN: Code duplicated, block: B:186:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:189:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:192:0x051b  */
    /* JADX WARN: Code duplicated, block: B:195:0x0535  */
    /* JADX WARN: Code duplicated, block: B:198:0x0546  */
    /* JADX WARN: Code duplicated, block: B:200:0x054a  */
    /* JADX WARN: Code duplicated, block: B:202:0x0563  */
    /* JADX WARN: Code duplicated, block: B:205:0x0584  */
    /* JADX WARN: Code duplicated, block: B:208:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:210:0x05af  */
    /* JADX WARN: Code duplicated, block: B:213:0x05cc  */
    /* JADX WARN: Code duplicated, block: B:215:0x05d0  */
    /* JADX WARN: Code duplicated, block: B:218:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:220:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:222:0x060d  */
    /* JADX WARN: Code duplicated, block: B:225:0x0631  */
    /* JADX WARN: Code duplicated, block: B:228:0x0644  */
    /* JADX WARN: Code duplicated, block: B:235:0x0659  */
    /* JADX WARN: Code duplicated, block: B:247:0x0682  */
    /* JADX WARN: Code duplicated, block: B:250:0x069e  */
    /* JADX WARN: Code duplicated, block: B:251:0x06a1  */
    /* JADX WARN: Code duplicated, block: B:254:0x06aa  */
    /* JADX WARN: Code duplicated, block: B:255:0x06ad  */
    /* JADX WARN: Code duplicated, block: B:262:0x072f  */
    /* JADX WARN: Code duplicated, block: B:268:0x0776 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:269:0x0777 A[PHI: r19
      0x0777: PHI (r19v9 q43) = 
      (r13v0 q43)
      (r19v3 q43)
      (r19v3 q43)
      (r19v3 q43)
      (r19v3 q43)
      (r19v3 q43)
      (r19v3 q43)
      (r19v3 q43)
      (r19v3 q43)
      (r19v5 q43)
      (r19v7 q43)
      (r19v10 q43)
      (r19v10 q43)
      (r19v10 q43)
      (r19v10 q43)
      (r19v10 q43)
      (r19v10 q43)
      (r19v10 q43)
     binds: [B:267:0x0774, B:170:0x0429, B:132:0x0326, B:127:0x02cd, B:122:0x02a6, B:115:0x0286, B:108:0x0241, B:103:0x01f9, B:97:0x01c7, B:184:0x04c3, B:263:0x0754, B:257:0x070e, B:260:0x072c, B:223:0x062d, B:216:0x05e9, B:211:0x05c8, B:206:0x05a2, B:203:0x0580] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0030  */
    /* JADX WARN: Code duplicated, block: B:90:0x019a  */
    /* JADX WARN: Code duplicated, block: B:91:0x019c  */
    /* JADX WARN: Code duplicated, block: B:94:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:96:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:99:0x01cb  */
    /* JADX WARN: Instruction removed from duplicated block: B:166:0x03ad, please report this as an issue */
    public final Object i(nm0 nm0Var, f5 f5Var, boolean z, y50 y50Var) {
        en2 en2Var;
        boolean zS;
        Object obj;
        nm0 nm0Var2;
        f5 f5Var2;
        g5 g5Var;
        int i;
        String str;
        a60 a60Var;
        String str2;
        f5 f5Var3;
        ll2 ll2Var;
        bl2 bl2VarA;
        Object c5Var;
        nm0 nm0Var3;
        f5 f5Var4;
        int i2;
        bl2 bl2Var;
        g5 g5Var2;
        Object c5Var2;
        nm0 nm0Var4;
        int i3;
        String strC;
        String strC2;
        String strC3;
        Integer numB;
        int iIntValue;
        wt1 wt1Var;
        l5 l5Var;
        rv1 qv1Var;
        String strC4;
        l5 l5Var2;
        f5 f5VarA;
        String strC5;
        l5 l5Var3;
        l5 l5Var4;
        rv1 rv1VarA;
        Object objK;
        l5 l5Var5;
        String str3;
        boolean z2;
        cl2 cl2Var;
        q03 q03Var;
        q03 q03Var2;
        en2 en2Var2;
        d32 b32Var;
        Object objI;
        cl2 cl2Var2;
        boolean z3;
        bl2 bl2Var2;
        nm0 nm0Var5;
        int i4;
        Object obj2;
        f5 f5Var5;
        d32 d32Var;
        boolean z4;
        nm0 nm0Var6;
        en2 en2Var3;
        ew1 ew1VarA;
        String strJ;
        String strConcat;
        l82 l82VarL;
        String str4;
        l5 l5Var6;
        String strK;
        rv1 ov1Var;
        ArrayList arrayList;
        boolean z5;
        nm0 nm0Var7;
        en2 en2Var4;
        ew1 ew1VarA2;
        en2 en2Var5;
        ArrayList arrayList2;
        boolean z6 = z;
        aw1 aw1Var = this.c;
        u30 u30Var = this.d;
        ll2 ll2Var2 = this.b;
        a60 a60Var2 = this.g;
        q43 q43Var = q43.a;
        if (y50Var instanceof en2) {
            en2Var = (en2) y50Var;
            int i5 = en2Var.v;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                en2Var.v = i5 - Integer.MIN_VALUE;
            } else {
                en2Var = new en2(this, y50Var);
            }
        } else {
            en2Var = new en2(this, y50Var);
        }
        Object obj3 = en2Var.t;
        Object obj4 = t70.a;
        switch (en2Var.v) {
            case 0:
                bz3.g(obj3);
                String str5 = f5Var.a;
                if (g31.a(str5, "device.wifi.settings") || g31.a(str5, "device.bluetooth.settings") || g31.a(str5, "device.wifi.enable") || g31.a(str5, "device.wifi.disable") || g31.a(str5, "device.wifi.toggle") || g31.a(str5, "device.bluetooth.enable") || g31.a(str5, "device.bluetooth.disable") || g31.a(str5, "device.bluetooth.toggle")) {
                    zS = true;
                } else {
                    zS = g31.a(str5, "device.settings.open") ? mz.s(f5Var.c("settings_page"), wh2.c("wifi", "bluetooth")) : false;
                }
                if (!zS) {
                    e40 e40Var = this.k;
                    synchronized (e40Var) {
                        e40Var.b = null;
                    }
                }
                try {
                    f5 f5VarA2 = m61.a(f5Var);
                    j5 j5Var = this.j;
                    en2Var.e = nm0Var;
                    en2Var.f = f5VarA2;
                    en2Var.n = z6;
                    en2Var.v = 2;
                    Object objC = rn4.c(j5Var.b, en2Var);
                    if (objC != obj4) {
                        obj = objC;
                        nm0Var2 = nm0Var;
                        f5Var2 = f5VarA2;
                        g5Var = (g5) obj;
                        if (g5Var.h == l61.f) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        str = f5Var2.a;
                        a60Var = a60Var2;
                        str2 = f5Var2.e;
                        if (g31.a(str, "meta.cancel")) {
                            rv1VarA = a60Var.a();
                            en2Var.e = null;
                            en2Var.f = null;
                            en2Var.i = null;
                            en2Var.j = null;
                            en2Var.n = z6;
                            en2Var.s = i;
                            if (rv1VarA != null) {
                                en2Var.v = 3;
                                if (g(nm0Var2, str2, rv1VarA, en2Var) != obj4) {
                                    return q43Var;
                                }
                            } else {
                                en2Var.v = 4;
                                objK = k(nm0Var2, new l5(f5Var2.e, e33.k, "Nothing running to stop.", f5Var2, null, null, null, null, null, null, null, 4080), null, en2Var);
                                if (objK != obj4) {
                                    objK = q43Var;
                                }
                                if (objK != obj4) {
                                    return q43Var;
                                }
                            }
                        } else {
                            f5Var3 = f5Var2;
                            if (g31.a(str, "assistant.wake_up")) {
                                this.l.a();
                                a60Var.b();
                                l5Var4 = new l5(f5Var3.e, e33.a, "", f5Var3, null, null, null, null, null, null, "Restored ACTIVE mode", 2032);
                                en2Var.e = null;
                                en2Var.f = null;
                                en2Var.i = null;
                                en2Var.n = z6;
                                en2Var.s = i;
                                en2Var.v = 5;
                                if (k(nm0Var2, l5Var4, null, en2Var) != obj4) {
                                    return q43Var;
                                }
                            } else if (g31.a(str, "meta.chat")) {
                                if (f5Var3.d == q21.c) {
                                    l5Var3 = new l5(f5Var3.e, e33.s, "", null, null, null, null, null, null, null, "Live conversational turn handled via BIDI session", 2040);
                                    en2Var.e = null;
                                    en2Var.f = null;
                                    en2Var.i = null;
                                    en2Var.n = z6;
                                    en2Var.s = i;
                                    en2Var.v = 6;
                                    if (k(nm0Var2, l5Var3, null, en2Var) != obj4) {
                                        return q43Var;
                                    }
                                } else {
                                    strC5 = f5Var3.c("query");
                                    if (strC5 != null) {
                                        str2 = strC5;
                                    }
                                    en2Var.e = null;
                                    en2Var.f = null;
                                    en2Var.i = null;
                                    en2Var.n = z6;
                                    en2Var.s = i;
                                    en2Var.v = 7;
                                    if (h(nm0Var2, str2, en2Var) != obj4) {
                                        return q43Var;
                                    }
                                }
                            } else if (g31.a(str, "message.compose.choose_channel")) {
                                f5VarA = f5.a(f5Var3, "message.whatsapp.draft", null, 30);
                                en2Var.e = null;
                                en2Var.f = null;
                                en2Var.i = null;
                                en2Var.n = z6;
                                en2Var.s = i;
                                en2Var.v = 8;
                                if (i(nm0Var2, f5VarA, z6, en2Var) != obj4) {
                                    return q43Var;
                                }
                            } else if (wh2.c(new w3("message.sms.send"), new w3("message.sms.confirm_send")).contains(new w3(str))) {
                                l5Var2 = new l5(f5Var3.e, e33.e, "SONIC messaging supports WhatsApp only.", f5Var3, null, null, null, null, null, null, "SMS transport is unsupported", 2032);
                                en2Var.e = null;
                                en2Var.f = null;
                                en2Var.i = null;
                                en2Var.n = z6;
                                en2Var.s = i;
                                en2Var.v = 9;
                                if (k(nm0Var2, l5Var2, null, en2Var) != obj4) {
                                    return q43Var;
                                }
                            } else {
                                if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.sms.send"), new w3("message.draft")).contains(new w3(str))) {
                                    strC = f5Var3.c("contact_name");
                                    if ((strC != null || cs2.A(strC)) && (((strC2 = f5Var3.c("phone_number")) == null || cs2.A(strC2)) && ((strC3 = f5Var3.c("recipients")) == null || cs2.A(strC3)))) {
                                        numB = f5Var3.b("recipient_count");
                                        if (numB != null) {
                                            iIntValue = numB.intValue();
                                        } else {
                                            iIntValue = 0;
                                        }
                                        if (iIntValue > 1) {
                                            wt1Var = new wt1("recipients", "Which " + f5Var3.b("recipient_count") + " people? Say their names separated by 'and'.");
                                        } else {
                                            wt1Var = new wt1("contact_name", "Who should I send the message to?");
                                        }
                                    } else {
                                        String strC6 = f5Var3.c("message_body");
                                        wt1Var = ((strC6 == null || cs2.A(strC6)) && ((strC4 = f5Var3.c("text")) == null || cs2.A(strC4))) ? new wt1("message_body", "What should the message say?") : null;
                                    }
                                    if (wt1Var != null) {
                                        String str6 = (String) wt1Var.b;
                                        yx yxVar = new yx(str6, (String) wt1Var.a, ii0.a, f5Var3.a, f5Var3.b);
                                        l5Var = new l5(f5Var3.e, e33.f, str6, f5Var3, null, null, null, null, null, null, null, 4080);
                                        qv1Var = new qv1(f5Var3, "message.details", yxVar, false);
                                        en2Var.e = null;
                                        en2Var.f = null;
                                        en2Var.i = null;
                                        en2Var.j = null;
                                        en2Var.k = null;
                                        en2Var.n = z6;
                                        en2Var.s = i;
                                        en2Var.v = 10;
                                        if (k(nm0Var2, l5Var, qv1Var, en2Var) == obj4) {
                                            return q43Var;
                                        }
                                    }
                                }
                                ll2Var = ll2Var2;
                                bl2VarA = ll2Var.a(str);
                                if (bl2VarA == null) {
                                    c5Var2 = new c5(f5Var3, null);
                                    en2Var.e = nm0Var2;
                                    en2Var.f = f5Var3;
                                    en2Var.i = null;
                                    en2Var.j = null;
                                    en2Var.n = z6;
                                    en2Var.s = i;
                                    en2Var.v = 11;
                                    if (nm0Var2.n(c5Var2, en2Var) != obj4) {
                                        int i6 = i;
                                        nm0Var4 = nm0Var2;
                                        i3 = i6;
                                        String str7 = f5Var3.e;
                                        String str8 = f5Var3.a;
                                        e33 e33Var = e33.n;
                                        if (i3 != 0) {
                                            str3 = "Main samajh toh gaya, par kar nahi sakta — SONIC mein abhi tak yeh nahi hai.";
                                        } else {
                                            str3 = "I understood that, but I can't do it — nothing in SONIC handles it yet.";
                                        }
                                        String str9 = str3;
                                        l5Var5 = new l5(str7, e33Var, str9, f5Var3, null, cq.v("No registered skill claims ", str8, "."), null, null, null, null, "unclaimed action " + str8 + "; " + ((l1) ll2Var.c.keySet()).a() + " actions registered", 1984);
                                        en2Var.e = null;
                                        en2Var.f = null;
                                        en2Var.i = null;
                                        en2Var.j = null;
                                        en2Var.n = z6;
                                        en2Var.s = i3;
                                        en2Var.v = 12;
                                        if (k(nm0Var4, l5Var5, null, en2Var) == obj4) {
                                            return q43Var;
                                        }
                                    }
                                } else {
                                    c5Var = new c5(f5Var3, bl2VarA.d());
                                    en2Var.e = nm0Var2;
                                    en2Var.f = f5Var3;
                                    en2Var.i = g5Var;
                                    en2Var.j = bl2VarA;
                                    en2Var.n = z6;
                                    en2Var.s = i;
                                    en2Var.v = 13;
                                    if (nm0Var2.n(c5Var, en2Var) != obj4) {
                                        nm0Var3 = nm0Var2;
                                        f5Var4 = f5Var3;
                                        i2 = i;
                                        bl2Var = bl2VarA;
                                        g5Var2 = g5Var;
                                        z2 = z6;
                                        cl2Var = new cl2(g5Var2.b, g5Var2.a, this.i.a(), g5Var2.h.b, z2, (i60) a60Var.c.getValue());
                                        q03Var = g5Var2.b;
                                        bl2Var.g();
                                        q03Var2 = q03.a;
                                        if (q03Var.ordinal() >= 0) {
                                            en2Var.e = nm0Var3;
                                            en2Var.f = f5Var4;
                                            en2Var.i = g5Var2;
                                            en2Var.j = bl2Var;
                                            en2Var.k = cl2Var;
                                            en2Var.n = z2;
                                            en2Var.s = i2;
                                            en2Var.v = 15;
                                            objI = bl2Var.i(en2Var);
                                            if (objI != obj4) {
                                                cl2Var2 = cl2Var;
                                                z3 = z2;
                                                bl2Var2 = bl2Var;
                                                nm0Var5 = nm0Var3;
                                                i4 = i2;
                                                obj2 = objI;
                                                f5Var5 = f5Var4;
                                                d32Var = (d32) obj2;
                                                if (g31.a(d32Var, a32.a)) {
                                                    z4 = z3;
                                                    nm0Var6 = nm0Var5;
                                                    en2Var3 = en2Var;
                                                    ew1VarA = aw1Var.a(bl2Var2.m().concat(" needs a permission first — I'll ask now."), bl2Var2.c(f5Var5));
                                                    if (ew1VarA instanceof bw1) {
                                                        arrayList = ((bw1) ew1VarA).a;
                                                        en2Var3.e = null;
                                                        en2Var3.f = null;
                                                        en2Var3.i = null;
                                                        en2Var3.j = null;
                                                        en2Var3.k = null;
                                                        en2Var3.n = z4;
                                                        en2Var3.s = i4;
                                                        en2Var3.v = 20;
                                                        if (n(nm0Var6, f5Var5, bl2Var2, arrayList, z4, en2Var3) != obj4) {
                                                            return q43Var;
                                                        }
                                                    } else {
                                                        l82 l82VarL2 = bl2Var2.l();
                                                        l82 l82Var = g5Var2.a;
                                                        u30Var.getClass();
                                                        l82VarL2.getClass();
                                                        if (!z4 && (l82VarL2 == l82.e || l82VarL2.ordinal() >= l82Var.ordinal())) {
                                                            strJ = bl2Var2.j(f5Var5);
                                                            if (strJ != null || (strConcat = cs2.V(strJ).toString()) == null) {
                                                                strConcat = bl2Var2.m().concat(": go ahead?");
                                                            } else {
                                                                if (strConcat.length() <= 0) {
                                                                    strConcat = null;
                                                                }
                                                                if (strConcat == null) {
                                                                    strConcat = bl2Var2.m().concat(": go ahead?");
                                                                } else if (!cs2.o("?.!", cs2.B(strConcat))) {
                                                                    strConcat = strConcat.concat("?");
                                                                }
                                                            }
                                                            l82VarL = bl2Var2.l();
                                                            l82VarL.getClass();
                                                            if (t30.a[l82VarL.ordinal()] == 1) {
                                                                str4 = "This one can't be undone.";
                                                            } else {
                                                                str4 = null;
                                                            }
                                                            String str10 = f5Var5.e;
                                                            e33 e33Var2 = e33.i;
                                                            if (str4 == null) {
                                                                strK = strConcat;
                                                            } else {
                                                                strK = cq.k(strConcat, Padder.FALLBACK_PADDING_STRING, str4);
                                                            }
                                                            l5Var6 = new l5(str10, e33Var2, strK, f5Var5, bl2Var2.d(), null, null, null, null, null, "risk=" + bl2Var2.l() + ", threshold=" + g5Var2.a, 2016);
                                                            ov1Var = new ov1(f5Var5, bl2Var2.d(), strConcat, bl2Var2.l());
                                                            en2Var3.e = null;
                                                            en2Var3.f = null;
                                                            en2Var3.i = null;
                                                            en2Var3.j = null;
                                                            en2Var3.k = null;
                                                            en2Var3.n = z4;
                                                            en2Var3.s = i4;
                                                            en2Var3.v = 21;
                                                            if (k(nm0Var6, l5Var6, ov1Var, en2Var3) != obj4) {
                                                                return q43Var;
                                                            }
                                                        } else {
                                                            en2Var3.e = null;
                                                            en2Var3.f = null;
                                                            en2Var3.i = null;
                                                            en2Var3.j = null;
                                                            en2Var3.k = null;
                                                            en2Var3.n = z4;
                                                            en2Var3.s = i4;
                                                            en2Var3.v = 22;
                                                            if (j(nm0Var6, f5Var5, bl2Var2, cl2Var2, z4, en2Var3) != obj4) {
                                                                return q43Var;
                                                            }
                                                        }
                                                    }
                                                } else if (d32Var instanceof z22) {
                                                    ew1VarA2 = aw1Var.a(bl2Var2.m().concat(" needs a permission first — I'll ask now."), ((z22) d32Var).a);
                                                    if (ew1VarA2 instanceof bw1) {
                                                        arrayList2 = ((bw1) ew1VarA2).a;
                                                        en2Var.e = null;
                                                        en2Var.f = null;
                                                        en2Var.i = null;
                                                        en2Var.j = null;
                                                        en2Var.k = null;
                                                        en2Var.n = z3;
                                                        en2Var.s = i4;
                                                        en2Var.v = 16;
                                                        if (n(nm0Var5, f5Var5, bl2Var2, arrayList2, z3, en2Var) != obj4) {
                                                            return q43Var;
                                                        }
                                                    } else {
                                                        boolean z7 = z3;
                                                        en2Var5 = en2Var;
                                                        en2Var5.e = null;
                                                        en2Var5.f = null;
                                                        en2Var5.i = null;
                                                        en2Var5.j = null;
                                                        en2Var5.k = null;
                                                        en2Var5.n = z7;
                                                        en2Var5.s = i4;
                                                        en2Var5.v = 17;
                                                        if (f(nm0Var5, f5Var5, bl2Var2, d32Var, en2Var5) != obj4) {
                                                            return q43Var;
                                                        }
                                                    }
                                                } else {
                                                    z5 = z3;
                                                    nm0Var7 = nm0Var5;
                                                    en2Var4 = en2Var;
                                                    if (d32Var instanceof c32) {
                                                        en2Var4.e = null;
                                                        en2Var4.f = null;
                                                        en2Var4.i = null;
                                                        en2Var4.j = null;
                                                        en2Var4.k = null;
                                                        en2Var4.n = z5;
                                                        en2Var4.s = i4;
                                                        en2Var4.v = 18;
                                                        if (f(nm0Var7, f5Var5, bl2Var2, d32Var, en2Var4) != obj4) {
                                                            return q43Var;
                                                        }
                                                    } else {
                                                        if (d32Var instanceof b32) {
                                                            dk0.l();
                                                            return null;
                                                        }
                                                        en2Var4.e = null;
                                                        en2Var4.f = null;
                                                        en2Var4.i = null;
                                                        en2Var4.j = null;
                                                        en2Var4.k = null;
                                                        en2Var4.n = z5;
                                                        en2Var4.s = i4;
                                                        en2Var4.v = 19;
                                                        if (f(nm0Var7, f5Var5, bl2Var2, d32Var, en2Var4) != obj4) {
                                                            return q43Var;
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            en2Var2 = en2Var;
                                            bl2Var.g();
                                            b32Var = new b32(q03Var2);
                                            en2Var2.e = null;
                                            en2Var2.f = null;
                                            en2Var2.i = null;
                                            en2Var2.j = null;
                                            en2Var2.k = null;
                                            en2Var2.n = z2;
                                            en2Var2.s = i2;
                                            en2Var2.v = 14;
                                            if (f(nm0Var3, f5Var4, bl2Var, b32Var, en2Var2) != obj4) {
                                                return q43Var;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (g53 e) {
                    en2 en2Var6 = en2Var;
                    bl2 bl2VarA2 = ll2Var2.a(f5Var.a);
                    en2Var6.e = null;
                    en2Var6.f = null;
                    en2Var6.n = z6;
                    en2Var6.v = 1;
                    if (p(nm0Var, f5Var, e, bl2VarA2, en2Var6) == obj4) {
                    }
                }
                return obj4;
            case 1:
                bz3.g(obj3);
                return q43Var;
            case 2:
                z6 = en2Var.n;
                f5 f5Var6 = en2Var.f;
                nm0Var2 = en2Var.e;
                bz3.g(obj3);
                f5Var2 = f5Var6;
                q43Var = q43Var;
                obj = obj3;
                g5Var = (g5) obj;
                if (g5Var.h == l61.f) {
                    i = 1;
                } else {
                    i = 0;
                }
                str = f5Var2.a;
                a60Var = a60Var2;
                str2 = f5Var2.e;
                if (g31.a(str, "meta.cancel")) {
                    rv1VarA = a60Var.a();
                    en2Var.e = null;
                    en2Var.f = null;
                    en2Var.i = null;
                    en2Var.j = null;
                    en2Var.n = z6;
                    en2Var.s = i;
                    if (rv1VarA != null) {
                        en2Var.v = 3;
                        if (g(nm0Var2, str2, rv1VarA, en2Var) != obj4) {
                            return obj4;
                        }
                        return q43Var;
                    }
                    en2Var.v = 4;
                    objK = k(nm0Var2, new l5(f5Var2.e, e33.k, "Nothing running to stop.", f5Var2, null, null, null, null, null, null, null, 4080), null, en2Var);
                    if (objK != obj4) {
                        objK = q43Var;
                    }
                    if (objK != obj4) {
                        return obj4;
                    }
                    return q43Var;
                }
                f5Var3 = f5Var2;
                if (g31.a(str, "assistant.wake_up")) {
                    this.l.a();
                    a60Var.b();
                    l5Var4 = new l5(f5Var3.e, e33.a, "", f5Var3, null, null, null, null, null, null, "Restored ACTIVE mode", 2032);
                    en2Var.e = null;
                    en2Var.f = null;
                    en2Var.i = null;
                    en2Var.n = z6;
                    en2Var.s = i;
                    en2Var.v = 5;
                    if (k(nm0Var2, l5Var4, null, en2Var) != obj4) {
                        return obj4;
                    }
                    return q43Var;
                }
                if (g31.a(str, "meta.chat")) {
                    if (f5Var3.d == q21.c) {
                        l5Var3 = new l5(f5Var3.e, e33.s, "", null, null, null, null, null, null, null, "Live conversational turn handled via BIDI session", 2040);
                        en2Var.e = null;
                        en2Var.f = null;
                        en2Var.i = null;
                        en2Var.n = z6;
                        en2Var.s = i;
                        en2Var.v = 6;
                        if (k(nm0Var2, l5Var3, null, en2Var) != obj4) {
                            return obj4;
                        }
                        return q43Var;
                    }
                    strC5 = f5Var3.c("query");
                    if (strC5 != null) {
                        str2 = strC5;
                    }
                    en2Var.e = null;
                    en2Var.f = null;
                    en2Var.i = null;
                    en2Var.n = z6;
                    en2Var.s = i;
                    en2Var.v = 7;
                    if (h(nm0Var2, str2, en2Var) != obj4) {
                        return obj4;
                    }
                    return q43Var;
                }
                if (g31.a(str, "message.compose.choose_channel")) {
                    f5VarA = f5.a(f5Var3, "message.whatsapp.draft", null, 30);
                    en2Var.e = null;
                    en2Var.f = null;
                    en2Var.i = null;
                    en2Var.n = z6;
                    en2Var.s = i;
                    en2Var.v = 8;
                    if (i(nm0Var2, f5VarA, z6, en2Var) != obj4) {
                        return obj4;
                    }
                    return q43Var;
                }
                if (wh2.c(new w3("message.sms.send"), new w3("message.sms.confirm_send")).contains(new w3(str))) {
                    l5Var2 = new l5(f5Var3.e, e33.e, "SONIC messaging supports WhatsApp only.", f5Var3, null, null, null, null, null, null, "SMS transport is unsupported", 2032);
                    en2Var.e = null;
                    en2Var.f = null;
                    en2Var.i = null;
                    en2Var.n = z6;
                    en2Var.s = i;
                    en2Var.v = 9;
                    if (k(nm0Var2, l5Var2, null, en2Var) != obj4) {
                        return obj4;
                    }
                    return q43Var;
                }
                if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.sms.send"), new w3("message.draft")).contains(new w3(str))) {
                    strC = f5Var3.c("contact_name");
                    if (strC != null) {
                        numB = f5Var3.b("recipient_count");
                        if (numB != null) {
                            iIntValue = numB.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        if (iIntValue > 1) {
                            wt1Var = new wt1("recipients", "Which " + f5Var3.b("recipient_count") + " people? Say their names separated by 'and'.");
                        } else {
                            wt1Var = new wt1("contact_name", "Who should I send the message to?");
                        }
                    } else {
                        numB = f5Var3.b("recipient_count");
                        if (numB != null) {
                            iIntValue = numB.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        if (iIntValue > 1) {
                            wt1Var = new wt1("recipients", "Which " + f5Var3.b("recipient_count") + " people? Say their names separated by 'and'.");
                        } else {
                            wt1Var = new wt1("contact_name", "Who should I send the message to?");
                        }
                    }
                    if (wt1Var != null) {
                        String str11 = (String) wt1Var.b;
                        yx yxVar2 = new yx(str11, (String) wt1Var.a, ii0.a, f5Var3.a, f5Var3.b);
                        l5Var = new l5(f5Var3.e, e33.f, str11, f5Var3, null, null, null, null, null, null, null, 4080);
                        qv1Var = new qv1(f5Var3, "message.details", yxVar2, false);
                        en2Var.e = null;
                        en2Var.f = null;
                        en2Var.i = null;
                        en2Var.j = null;
                        en2Var.k = null;
                        en2Var.n = z6;
                        en2Var.s = i;
                        en2Var.v = 10;
                        if (k(nm0Var2, l5Var, qv1Var, en2Var) == obj4) {
                            return q43Var;
                        }
                    }
                    return obj4;
                }
                ll2Var = ll2Var2;
                bl2VarA = ll2Var.a(str);
                if (bl2VarA == null) {
                    c5Var2 = new c5(f5Var3, null);
                    en2Var.e = nm0Var2;
                    en2Var.f = f5Var3;
                    en2Var.i = null;
                    en2Var.j = null;
                    en2Var.n = z6;
                    en2Var.s = i;
                    en2Var.v = 11;
                    if (nm0Var2.n(c5Var2, en2Var) != obj4) {
                        int i7 = i;
                        nm0Var4 = nm0Var2;
                        i3 = i7;
                        String str12 = f5Var3.e;
                        String str13 = f5Var3.a;
                        e33 e33Var3 = e33.n;
                        if (i3 != 0) {
                            str3 = "Main samajh toh gaya, par kar nahi sakta — SONIC mein abhi tak yeh nahi hai.";
                        } else {
                            str3 = "I understood that, but I can't do it — nothing in SONIC handles it yet.";
                        }
                        String str14 = str3;
                        l5Var5 = new l5(str12, e33Var3, str14, f5Var3, null, cq.v("No registered skill claims ", str13, "."), null, null, null, null, "unclaimed action " + str13 + "; " + ((l1) ll2Var.c.keySet()).a() + " actions registered", 1984);
                        en2Var.e = null;
                        en2Var.f = null;
                        en2Var.i = null;
                        en2Var.j = null;
                        en2Var.n = z6;
                        en2Var.s = i3;
                        en2Var.v = 12;
                        if (k(nm0Var4, l5Var5, null, en2Var) == obj4) {
                            return q43Var;
                        }
                    }
                } else {
                    c5Var = new c5(f5Var3, bl2VarA.d());
                    en2Var.e = nm0Var2;
                    en2Var.f = f5Var3;
                    en2Var.i = g5Var;
                    en2Var.j = bl2VarA;
                    en2Var.n = z6;
                    en2Var.s = i;
                    en2Var.v = 13;
                    if (nm0Var2.n(c5Var, en2Var) != obj4) {
                        nm0Var3 = nm0Var2;
                        f5Var4 = f5Var3;
                        i2 = i;
                        bl2Var = bl2VarA;
                        g5Var2 = g5Var;
                        z2 = z6;
                        cl2Var = new cl2(g5Var2.b, g5Var2.a, this.i.a(), g5Var2.h.b, z2, (i60) a60Var.c.getValue());
                        q03Var = g5Var2.b;
                        bl2Var.g();
                        q03Var2 = q03.a;
                        if (q03Var.ordinal() >= 0) {
                            en2Var.e = nm0Var3;
                            en2Var.f = f5Var4;
                            en2Var.i = g5Var2;
                            en2Var.j = bl2Var;
                            en2Var.k = cl2Var;
                            en2Var.n = z2;
                            en2Var.s = i2;
                            en2Var.v = 15;
                            objI = bl2Var.i(en2Var);
                            if (objI != obj4) {
                                cl2Var2 = cl2Var;
                                z3 = z2;
                                bl2Var2 = bl2Var;
                                nm0Var5 = nm0Var3;
                                i4 = i2;
                                obj2 = objI;
                                f5Var5 = f5Var4;
                                d32Var = (d32) obj2;
                                if (g31.a(d32Var, a32.a)) {
                                    z4 = z3;
                                    nm0Var6 = nm0Var5;
                                    en2Var3 = en2Var;
                                    ew1VarA = aw1Var.a(bl2Var2.m().concat(" needs a permission first — I'll ask now."), bl2Var2.c(f5Var5));
                                    if (ew1VarA instanceof bw1) {
                                        arrayList = ((bw1) ew1VarA).a;
                                        en2Var3.e = null;
                                        en2Var3.f = null;
                                        en2Var3.i = null;
                                        en2Var3.j = null;
                                        en2Var3.k = null;
                                        en2Var3.n = z4;
                                        en2Var3.s = i4;
                                        en2Var3.v = 20;
                                        if (n(nm0Var6, f5Var5, bl2Var2, arrayList, z4, en2Var3) != obj4) {
                                            return q43Var;
                                        }
                                    } else {
                                        l82 l82VarL3 = bl2Var2.l();
                                        l82 l82Var2 = g5Var2.a;
                                        u30Var.getClass();
                                        l82VarL3.getClass();
                                        if (z4) {
                                            strJ = bl2Var2.j(f5Var5);
                                            if (strJ != null) {
                                                strConcat = bl2Var2.m().concat(": go ahead?");
                                            } else {
                                                strConcat = bl2Var2.m().concat(": go ahead?");
                                            }
                                            l82VarL = bl2Var2.l();
                                            l82VarL.getClass();
                                            if (t30.a[l82VarL.ordinal()] == 1) {
                                                str4 = "This one can't be undone.";
                                            } else {
                                                str4 = null;
                                            }
                                            String str15 = f5Var5.e;
                                            e33 e33Var4 = e33.i;
                                            if (str4 == null) {
                                                strK = strConcat;
                                            } else {
                                                strK = cq.k(strConcat, Padder.FALLBACK_PADDING_STRING, str4);
                                            }
                                            l5Var6 = new l5(str15, e33Var4, strK, f5Var5, bl2Var2.d(), null, null, null, null, null, "risk=" + bl2Var2.l() + ", threshold=" + g5Var2.a, 2016);
                                            ov1Var = new ov1(f5Var5, bl2Var2.d(), strConcat, bl2Var2.l());
                                            en2Var3.e = null;
                                            en2Var3.f = null;
                                            en2Var3.i = null;
                                            en2Var3.j = null;
                                            en2Var3.k = null;
                                            en2Var3.n = z4;
                                            en2Var3.s = i4;
                                            en2Var3.v = 21;
                                            if (k(nm0Var6, l5Var6, ov1Var, en2Var3) != obj4) {
                                                return q43Var;
                                            }
                                        }
                                        en2Var3.e = null;
                                        en2Var3.f = null;
                                        en2Var3.i = null;
                                        en2Var3.j = null;
                                        en2Var3.k = null;
                                        en2Var3.n = z4;
                                        en2Var3.s = i4;
                                        en2Var3.v = 22;
                                        if (j(nm0Var6, f5Var5, bl2Var2, cl2Var2, z4, en2Var3) != obj4) {
                                            return q43Var;
                                        }
                                    }
                                } else if (d32Var instanceof z22) {
                                    ew1VarA2 = aw1Var.a(bl2Var2.m().concat(" needs a permission first — I'll ask now."), ((z22) d32Var).a);
                                    if (ew1VarA2 instanceof bw1) {
                                        arrayList2 = ((bw1) ew1VarA2).a;
                                        en2Var.e = null;
                                        en2Var.f = null;
                                        en2Var.i = null;
                                        en2Var.j = null;
                                        en2Var.k = null;
                                        en2Var.n = z3;
                                        en2Var.s = i4;
                                        en2Var.v = 16;
                                        if (n(nm0Var5, f5Var5, bl2Var2, arrayList2, z3, en2Var) != obj4) {
                                            return q43Var;
                                        }
                                    } else {
                                        boolean z8 = z3;
                                        en2Var5 = en2Var;
                                        en2Var5.e = null;
                                        en2Var5.f = null;
                                        en2Var5.i = null;
                                        en2Var5.j = null;
                                        en2Var5.k = null;
                                        en2Var5.n = z8;
                                        en2Var5.s = i4;
                                        en2Var5.v = 17;
                                        if (f(nm0Var5, f5Var5, bl2Var2, d32Var, en2Var5) != obj4) {
                                            return q43Var;
                                        }
                                    }
                                } else {
                                    z5 = z3;
                                    nm0Var7 = nm0Var5;
                                    en2Var4 = en2Var;
                                    if (d32Var instanceof c32) {
                                        en2Var4.e = null;
                                        en2Var4.f = null;
                                        en2Var4.i = null;
                                        en2Var4.j = null;
                                        en2Var4.k = null;
                                        en2Var4.n = z5;
                                        en2Var4.s = i4;
                                        en2Var4.v = 18;
                                        if (f(nm0Var7, f5Var5, bl2Var2, d32Var, en2Var4) != obj4) {
                                            return q43Var;
                                        }
                                    } else {
                                        if (d32Var instanceof b32) {
                                            dk0.l();
                                            return null;
                                        }
                                        en2Var4.e = null;
                                        en2Var4.f = null;
                                        en2Var4.i = null;
                                        en2Var4.j = null;
                                        en2Var4.k = null;
                                        en2Var4.n = z5;
                                        en2Var4.s = i4;
                                        en2Var4.v = 19;
                                        if (f(nm0Var7, f5Var5, bl2Var2, d32Var, en2Var4) != obj4) {
                                            return q43Var;
                                        }
                                    }
                                }
                            }
                        } else {
                            en2Var2 = en2Var;
                            bl2Var.g();
                            b32Var = new b32(q03Var2);
                            en2Var2.e = null;
                            en2Var2.f = null;
                            en2Var2.i = null;
                            en2Var2.j = null;
                            en2Var2.k = null;
                            en2Var2.n = z2;
                            en2Var2.s = i2;
                            en2Var2.v = 14;
                            if (f(nm0Var3, f5Var4, bl2Var, b32Var, en2Var2) != obj4) {
                                return q43Var;
                            }
                        }
                    }
                }
                return obj4;
            case 3:
            case 4:
                bz3.g(obj3);
                return q43Var;
            case 5:
                bz3.g(obj3);
                return q43Var;
            case 6:
                bz3.g(obj3);
                return q43Var;
            case 7:
                bz3.g(obj3);
                return q43Var;
            case 8:
                bz3.g(obj3);
                return q43Var;
            case 9:
                bz3.g(obj3);
                return q43Var;
            case 10:
                bz3.g(obj3);
                return q43Var;
            case 11:
                i3 = en2Var.s;
                z6 = en2Var.n;
                f5Var3 = en2Var.f;
                nm0Var4 = en2Var.e;
                bz3.g(obj3);
                ll2Var = ll2Var2;
                q43Var = q43Var;
                String str16 = f5Var3.e;
                String str17 = f5Var3.a;
                e33 e33Var5 = e33.n;
                if (i3 != 0) {
                    str3 = "Main samajh toh gaya, par kar nahi sakta — SONIC mein abhi tak yeh nahi hai.";
                } else {
                    str3 = "I understood that, but I can't do it — nothing in SONIC handles it yet.";
                }
                String str18 = str3;
                l5Var5 = new l5(str16, e33Var5, str18, f5Var3, null, cq.v("No registered skill claims ", str17, "."), null, null, null, null, "unclaimed action " + str17 + "; " + ((l1) ll2Var.c.keySet()).a() + " actions registered", 1984);
                en2Var.e = null;
                en2Var.f = null;
                en2Var.i = null;
                en2Var.j = null;
                en2Var.n = z6;
                en2Var.s = i3;
                en2Var.v = 12;
                if (k(nm0Var4, l5Var5, null, en2Var) == obj4) {
                    return obj4;
                }
                return q43Var;
            case 12:
                bz3.g(obj3);
                return q43Var;
            case 13:
                i2 = en2Var.s;
                z6 = en2Var.n;
                bl2 bl2Var3 = en2Var.j;
                g5 g5Var3 = en2Var.i;
                f5 f5Var7 = en2Var.f;
                nm0 nm0Var8 = en2Var.e;
                bz3.g(obj3);
                bl2Var = bl2Var3;
                g5Var2 = g5Var3;
                f5Var4 = f5Var7;
                a60Var = a60Var2;
                q43Var = q43Var;
                nm0Var3 = nm0Var8;
                z2 = z6;
                cl2Var = new cl2(g5Var2.b, g5Var2.a, this.i.a(), g5Var2.h.b, z2, (i60) a60Var.c.getValue());
                q03Var = g5Var2.b;
                bl2Var.g();
                q03Var2 = q03.a;
                if (q03Var.ordinal() >= 0) {
                    en2Var.e = nm0Var3;
                    en2Var.f = f5Var4;
                    en2Var.i = g5Var2;
                    en2Var.j = bl2Var;
                    en2Var.k = cl2Var;
                    en2Var.n = z2;
                    en2Var.s = i2;
                    en2Var.v = 15;
                    objI = bl2Var.i(en2Var);
                    if (objI != obj4) {
                        cl2Var2 = cl2Var;
                        z3 = z2;
                        bl2Var2 = bl2Var;
                        nm0Var5 = nm0Var3;
                        i4 = i2;
                        obj2 = objI;
                        f5Var5 = f5Var4;
                        d32Var = (d32) obj2;
                        if (g31.a(d32Var, a32.a)) {
                            z4 = z3;
                            nm0Var6 = nm0Var5;
                            en2Var3 = en2Var;
                            ew1VarA = aw1Var.a(bl2Var2.m().concat(" needs a permission first — I'll ask now."), bl2Var2.c(f5Var5));
                            if (ew1VarA instanceof bw1) {
                                arrayList = ((bw1) ew1VarA).a;
                                en2Var3.e = null;
                                en2Var3.f = null;
                                en2Var3.i = null;
                                en2Var3.j = null;
                                en2Var3.k = null;
                                en2Var3.n = z4;
                                en2Var3.s = i4;
                                en2Var3.v = 20;
                                if (n(nm0Var6, f5Var5, bl2Var2, arrayList, z4, en2Var3) != obj4) {
                                    return q43Var;
                                }
                            } else {
                                l82 l82VarL4 = bl2Var2.l();
                                l82 l82Var3 = g5Var2.a;
                                u30Var.getClass();
                                l82VarL4.getClass();
                                if (z4) {
                                    strJ = bl2Var2.j(f5Var5);
                                    if (strJ != null) {
                                        strConcat = bl2Var2.m().concat(": go ahead?");
                                    } else {
                                        strConcat = bl2Var2.m().concat(": go ahead?");
                                    }
                                    l82VarL = bl2Var2.l();
                                    l82VarL.getClass();
                                    if (t30.a[l82VarL.ordinal()] == 1) {
                                        str4 = "This one can't be undone.";
                                    } else {
                                        str4 = null;
                                    }
                                    String str19 = f5Var5.e;
                                    e33 e33Var6 = e33.i;
                                    if (str4 == null) {
                                        strK = strConcat;
                                    } else {
                                        strK = cq.k(strConcat, Padder.FALLBACK_PADDING_STRING, str4);
                                    }
                                    l5Var6 = new l5(str19, e33Var6, strK, f5Var5, bl2Var2.d(), null, null, null, null, null, "risk=" + bl2Var2.l() + ", threshold=" + g5Var2.a, 2016);
                                    ov1Var = new ov1(f5Var5, bl2Var2.d(), strConcat, bl2Var2.l());
                                    en2Var3.e = null;
                                    en2Var3.f = null;
                                    en2Var3.i = null;
                                    en2Var3.j = null;
                                    en2Var3.k = null;
                                    en2Var3.n = z4;
                                    en2Var3.s = i4;
                                    en2Var3.v = 21;
                                    if (k(nm0Var6, l5Var6, ov1Var, en2Var3) != obj4) {
                                        return q43Var;
                                    }
                                }
                                en2Var3.e = null;
                                en2Var3.f = null;
                                en2Var3.i = null;
                                en2Var3.j = null;
                                en2Var3.k = null;
                                en2Var3.n = z4;
                                en2Var3.s = i4;
                                en2Var3.v = 22;
                                if (j(nm0Var6, f5Var5, bl2Var2, cl2Var2, z4, en2Var3) != obj4) {
                                    return q43Var;
                                }
                            }
                        } else if (d32Var instanceof z22) {
                            ew1VarA2 = aw1Var.a(bl2Var2.m().concat(" needs a permission first — I'll ask now."), ((z22) d32Var).a);
                            if (ew1VarA2 instanceof bw1) {
                                arrayList2 = ((bw1) ew1VarA2).a;
                                en2Var.e = null;
                                en2Var.f = null;
                                en2Var.i = null;
                                en2Var.j = null;
                                en2Var.k = null;
                                en2Var.n = z3;
                                en2Var.s = i4;
                                en2Var.v = 16;
                                if (n(nm0Var5, f5Var5, bl2Var2, arrayList2, z3, en2Var) != obj4) {
                                    return q43Var;
                                }
                            } else {
                                boolean z9 = z3;
                                en2Var5 = en2Var;
                                en2Var5.e = null;
                                en2Var5.f = null;
                                en2Var5.i = null;
                                en2Var5.j = null;
                                en2Var5.k = null;
                                en2Var5.n = z9;
                                en2Var5.s = i4;
                                en2Var5.v = 17;
                                if (f(nm0Var5, f5Var5, bl2Var2, d32Var, en2Var5) != obj4) {
                                    return q43Var;
                                }
                            }
                        } else {
                            z5 = z3;
                            nm0Var7 = nm0Var5;
                            en2Var4 = en2Var;
                            if (d32Var instanceof c32) {
                                en2Var4.e = null;
                                en2Var4.f = null;
                                en2Var4.i = null;
                                en2Var4.j = null;
                                en2Var4.k = null;
                                en2Var4.n = z5;
                                en2Var4.s = i4;
                                en2Var4.v = 18;
                                if (f(nm0Var7, f5Var5, bl2Var2, d32Var, en2Var4) != obj4) {
                                    return q43Var;
                                }
                            } else {
                                if (d32Var instanceof b32) {
                                    dk0.l();
                                    return null;
                                }
                                en2Var4.e = null;
                                en2Var4.f = null;
                                en2Var4.i = null;
                                en2Var4.j = null;
                                en2Var4.k = null;
                                en2Var4.n = z5;
                                en2Var4.s = i4;
                                en2Var4.v = 19;
                                if (f(nm0Var7, f5Var5, bl2Var2, d32Var, en2Var4) != obj4) {
                                    return q43Var;
                                }
                            }
                        }
                    }
                } else {
                    en2Var2 = en2Var;
                    bl2Var.g();
                    b32Var = new b32(q03Var2);
                    en2Var2.e = null;
                    en2Var2.f = null;
                    en2Var2.i = null;
                    en2Var2.j = null;
                    en2Var2.k = null;
                    en2Var2.n = z2;
                    en2Var2.s = i2;
                    en2Var2.v = 14;
                    if (f(nm0Var3, f5Var4, bl2Var, b32Var, en2Var2) != obj4) {
                        return q43Var;
                    }
                }
                return obj4;
            case 14:
                bz3.g(obj3);
                return q43Var;
            case 15:
                int i8 = en2Var.s;
                boolean z10 = en2Var.n;
                cl2 cl2Var3 = en2Var.k;
                bl2 bl2Var4 = en2Var.j;
                g5 g5Var4 = en2Var.i;
                f5 f5Var8 = en2Var.f;
                nm0Var5 = en2Var.e;
                bz3.g(obj3);
                aw1Var = aw1Var;
                bl2Var2 = bl2Var4;
                g5Var2 = g5Var4;
                q43Var = q43Var;
                z3 = z10;
                cl2Var2 = cl2Var3;
                f5Var5 = f5Var8;
                i4 = i8;
                obj2 = obj3;
                d32Var = (d32) obj2;
                if (g31.a(d32Var, a32.a)) {
                    if (d32Var instanceof z22) {
                        ew1VarA2 = aw1Var.a(bl2Var2.m().concat(" needs a permission first — I'll ask now."), ((z22) d32Var).a);
                        if (ew1VarA2 instanceof bw1) {
                            arrayList2 = ((bw1) ew1VarA2).a;
                            en2Var.e = null;
                            en2Var.f = null;
                            en2Var.i = null;
                            en2Var.j = null;
                            en2Var.k = null;
                            en2Var.n = z3;
                            en2Var.s = i4;
                            en2Var.v = 16;
                            if (n(nm0Var5, f5Var5, bl2Var2, arrayList2, z3, en2Var) != obj4) {
                                return obj4;
                            }
                            return q43Var;
                        }
                        boolean z11 = z3;
                        en2Var5 = en2Var;
                        en2Var5.e = null;
                        en2Var5.f = null;
                        en2Var5.i = null;
                        en2Var5.j = null;
                        en2Var5.k = null;
                        en2Var5.n = z11;
                        en2Var5.s = i4;
                        en2Var5.v = 17;
                        if (f(nm0Var5, f5Var5, bl2Var2, d32Var, en2Var5) != obj4) {
                            return obj4;
                        }
                        return q43Var;
                    }
                    z5 = z3;
                    nm0Var7 = nm0Var5;
                    en2Var4 = en2Var;
                    if (d32Var instanceof c32) {
                        en2Var4.e = null;
                        en2Var4.f = null;
                        en2Var4.i = null;
                        en2Var4.j = null;
                        en2Var4.k = null;
                        en2Var4.n = z5;
                        en2Var4.s = i4;
                        en2Var4.v = 18;
                        if (f(nm0Var7, f5Var5, bl2Var2, d32Var, en2Var4) != obj4) {
                            return obj4;
                        }
                        return q43Var;
                    }
                    if (d32Var instanceof b32) {
                        dk0.l();
                        return null;
                    }
                    en2Var4.e = null;
                    en2Var4.f = null;
                    en2Var4.i = null;
                    en2Var4.j = null;
                    en2Var4.k = null;
                    en2Var4.n = z5;
                    en2Var4.s = i4;
                    en2Var4.v = 19;
                    if (f(nm0Var7, f5Var5, bl2Var2, d32Var, en2Var4) != obj4) {
                        return obj4;
                    }
                    return q43Var;
                }
                z4 = z3;
                nm0Var6 = nm0Var5;
                en2Var3 = en2Var;
                ew1VarA = aw1Var.a(bl2Var2.m().concat(" needs a permission first — I'll ask now."), bl2Var2.c(f5Var5));
                if (ew1VarA instanceof bw1) {
                    arrayList = ((bw1) ew1VarA).a;
                    en2Var3.e = null;
                    en2Var3.f = null;
                    en2Var3.i = null;
                    en2Var3.j = null;
                    en2Var3.k = null;
                    en2Var3.n = z4;
                    en2Var3.s = i4;
                    en2Var3.v = 20;
                    if (n(nm0Var6, f5Var5, bl2Var2, arrayList, z4, en2Var3) != obj4) {
                        return obj4;
                    }
                    return q43Var;
                }
                l82 l82VarL5 = bl2Var2.l();
                l82 l82Var4 = g5Var2.a;
                u30Var.getClass();
                l82VarL5.getClass();
                if (z4) {
                    strJ = bl2Var2.j(f5Var5);
                    if (strJ != null) {
                        strConcat = bl2Var2.m().concat(": go ahead?");
                    } else {
                        strConcat = bl2Var2.m().concat(": go ahead?");
                    }
                    l82VarL = bl2Var2.l();
                    l82VarL.getClass();
                    if (t30.a[l82VarL.ordinal()] == 1) {
                        str4 = "This one can't be undone.";
                    } else {
                        str4 = null;
                    }
                    String str110 = f5Var5.e;
                    e33 e33Var7 = e33.i;
                    if (str4 == null) {
                        strK = strConcat;
                    } else {
                        strK = cq.k(strConcat, Padder.FALLBACK_PADDING_STRING, str4);
                    }
                    l5Var6 = new l5(str110, e33Var7, strK, f5Var5, bl2Var2.d(), null, null, null, null, null, "risk=" + bl2Var2.l() + ", threshold=" + g5Var2.a, 2016);
                    ov1Var = new ov1(f5Var5, bl2Var2.d(), strConcat, bl2Var2.l());
                    en2Var3.e = null;
                    en2Var3.f = null;
                    en2Var3.i = null;
                    en2Var3.j = null;
                    en2Var3.k = null;
                    en2Var3.n = z4;
                    en2Var3.s = i4;
                    en2Var3.v = 21;
                    if (k(nm0Var6, l5Var6, ov1Var, en2Var3) != obj4) {
                        return obj4;
                    }
                    return q43Var;
                }
                en2Var3.e = null;
                en2Var3.f = null;
                en2Var3.i = null;
                en2Var3.j = null;
                en2Var3.k = null;
                en2Var3.n = z4;
                en2Var3.s = i4;
                en2Var3.v = 22;
                if (j(nm0Var6, f5Var5, bl2Var2, cl2Var2, z4, en2Var3) != obj4) {
                    return obj4;
                }
                return q43Var;
            case 16:
                bz3.g(obj3);
                return q43Var;
            case 17:
                bz3.g(obj3);
                return q43Var;
            case 18:
                bz3.g(obj3);
                return q43Var;
            case 19:
                bz3.g(obj3);
                return q43Var;
            case 20:
                bz3.g(obj3);
                return q43Var;
            case 21:
                bz3.g(obj3);
                return q43Var;
            case 22:
                bz3.g(obj3);
                return q43Var;
            default:
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:102:0x030c  */
    /* JADX WARN: Code duplicated, block: B:106:0x0358  */
    /* JADX WARN: Code duplicated, block: B:115:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:131:0x047a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:147:0x037f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x0359 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:46:0x011b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0142  */
    /* JADX WARN: Code duplicated, block: B:60:0x016e  */
    /* JADX WARN: Code duplicated, block: B:62:0x01ab A[PHI: r0
      0x01ab: PHI (r0v62 java.lang.Object) = (r0v59 java.lang.Object), (r0v65 java.lang.Object) binds: [B:77:0x0252, B:61:0x01a9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:63:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:64:0x01af A[PHI: r10
      0x01af: PHI (r10v16 java.lang.Object) = (r10v13 java.lang.Object), (r10v13 java.lang.Object), (r10v14 java.lang.Object), (r10v17 java.lang.Object) binds: [B:112:0x03da, B:87:0x02c0, B:82:0x0285, B:63:0x01ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:65:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:69:0x0217 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:72:0x022e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0236 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:79:0x0256  */
    /* JADX WARN: Code duplicated, block: B:81:0x025a  */
    /* JADX WARN: Code duplicated, block: B:84:0x0289  */
    /* JADX WARN: Code duplicated, block: B:86:0x028f  */
    /* JADX WARN: Code duplicated, block: B:89:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Code duplicated, block: B:91:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:93:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:95:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:98:0x02f6  */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x01b7, please report this as an issue */
    /* JADX WARN: Type inference failed for: r7v10, types: [bl2, cl2, f5, jl2, nm0] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v4 */
    public final Object j(nm0 nm0Var, f5 f5Var, bl2 bl2Var, cl2 cl2Var, boolean z, y50 y50Var) throws Throwable {
        fn2 fn2Var;
        bl2 bl2Var2;
        cl2 cl2Var2;
        long j;
        boolean z2;
        nm0 nm0Var2;
        f5 f5Var2;
        boolean z3;
        Object r7;
        Object objH;
        bl2 bl2Var3;
        cl2 cl2Var3;
        l5 l5Var;
        jl2 jl2Var;
        Object d5Var;
        boolean z4;
        jl2 jl2Var2;
        nm0 nm0Var3;
        cl2 cl2Var4;
        bl2 bl2Var4;
        f5 f5Var3;
        long j2;
        Object objA;
        Object obj;
        Throwable th;
        String str;
        String strK;
        List list;
        ArrayList arrayList;
        Iterator it;
        int i;
        String str2;
        Object next;
        int i2;
        String strValueOf;
        String str3;
        String string;
        Object objK;
        String str4;
        rv1 ov1Var;
        f5 f5Var4 = f5Var;
        if (y50Var instanceof fn2) {
            fn2Var = (fn2) y50Var;
            int i3 = fn2Var.v;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                fn2Var.v = i3 - Integer.MIN_VALUE;
            } else {
                fn2Var = new fn2(this, y50Var);
            }
        } else {
            fn2Var = new fn2(this, y50Var);
        }
        fn2 fn2Var2 = fn2Var;
        Object obj2 = fn2Var2.t;
        int i4 = fn2Var2.v;
        e33 e33Var = e33.c;
        t70 t70Var = t70.a;
        Object obj3 = q43.a;
        rv1 rv1Var = null;
        try {
            try {
                switch (i4) {
                    case 0:
                        bz3.g(obj2);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        Object y4Var = new y4(bl2Var.d(), f5Var4.a);
                        fn2Var2.e = nm0Var;
                        fn2Var2.f = f5Var4;
                        bl2Var2 = bl2Var;
                        fn2Var2.i = bl2Var2;
                        cl2Var2 = cl2Var;
                        fn2Var2.j = cl2Var2;
                        fn2Var2.n = z;
                        fn2Var2.s = jCurrentTimeMillis;
                        fn2Var2.v = 1;
                        if (nm0Var.n(y4Var, fn2Var2) != t70Var) {
                            j = jCurrentTimeMillis;
                            z2 = z;
                            nm0Var2 = nm0Var;
                            try {
                                fn2Var2.e = nm0Var2;
                                fn2Var2.f = f5Var4;
                                fn2Var2.i = bl2Var2;
                                fn2Var2.j = cl2Var2;
                                fn2Var2.n = z2;
                                fn2Var2.s = j;
                                fn2Var2.v = 2;
                                objH = bl2Var2.h(f5Var4, cl2Var2, fn2Var2);
                                if (objH != t70Var) {
                                    cl2 cl2Var5 = cl2Var2;
                                    bl2Var3 = bl2Var2;
                                    cl2Var3 = cl2Var5;
                                    f5Var2 = f5Var4;
                                    z3 = z2;
                                    obj2 = objH;
                                    try {
                                        jl2Var = (jl2) obj2;
                                        if (jl2Var instanceof hl2) {
                                            d5Var = new d5(bl2Var3.d());
                                            fn2Var2.e = nm0Var2;
                                            fn2Var2.f = f5Var2;
                                            fn2Var2.i = bl2Var3;
                                            fn2Var2.j = cl2Var3;
                                            fn2Var2.k = jl2Var;
                                            fn2Var2.n = z3;
                                            fn2Var2.s = j;
                                            fn2Var2.v = 5;
                                            if (nm0Var2.n(d5Var, fn2Var2) != t70Var) {
                                                z4 = z3;
                                                jl2Var2 = jl2Var;
                                                nm0Var3 = nm0Var2;
                                                cl2Var4 = cl2Var3;
                                                bl2Var4 = bl2Var3;
                                                f5Var3 = f5Var2;
                                                j2 = j;
                                                try {
                                                    fn2Var2.e = nm0Var3;
                                                    fn2Var2.f = f5Var3;
                                                    fn2Var2.i = bl2Var4;
                                                    fn2Var2.j = null;
                                                    fn2Var2.k = jl2Var2;
                                                    fn2Var2.n = z4;
                                                    fn2Var2.s = j2;
                                                    fn2Var2.v = 6;
                                                    objA = this.f.a(bl2Var4, f5Var3, cl2Var4, (hl2) jl2Var2, f73.a, fn2Var2);
                                                    if (objA != t70Var) {
                                                        obj2 = objA;
                                                        j = j2;
                                                        nm0Var2 = nm0Var3;
                                                        jl2Var = (jl2) obj2;
                                                        z3 = z4;
                                                        f5Var2 = f5Var3;
                                                        bl2Var3 = bl2Var4;
                                                    }
                                                } catch (Throwable unused) {
                                                    j = j2;
                                                    nm0Var2 = nm0Var3;
                                                    jl2Var = jl2Var2;
                                                    f5Var2 = f5Var3;
                                                    z3 = z4;
                                                }
                                            }
                                        }
                                        System.currentTimeMillis();
                                        fn2Var2.e = null;
                                        fn2Var2.f = null;
                                        fn2Var2.i = null;
                                        fn2Var2.j = null;
                                        fn2Var2.k = null;
                                        fn2Var2.n = z3;
                                        fn2Var2.s = j;
                                        fn2Var2.v = 7;
                                        if (jl2Var instanceof il2) {
                                            String str5 = f5Var2.e;
                                            il2 il2Var = (il2) jl2Var;
                                            String str6 = il2Var.a;
                                            String strD = bl2Var3.d();
                                            String str7 = il2Var.d;
                                            d73 d73Var = il2Var.b;
                                            objK = k(nm0Var2, new l5(str5, e33.a, str6, f5Var2, strD, str7, null, d73Var, null, il2Var.c, cq.l("verified: ", d73Var.a, " → ", d73Var.b), UCharacter.UnicodeBlock.ZNAMENNY_MUSICAL_NOTATION_ID), null, fn2Var2);
                                            if (objK == t70Var) {
                                                obj = t70Var;
                                            } else {
                                                obj = t70Var;
                                                objK = obj3;
                                            }
                                        } else if (jl2Var instanceof hl2) {
                                            String str8 = f5Var2.e;
                                            str4 = f5Var2.a;
                                            hl2 hl2Var = (hl2) jl2Var;
                                            boolean z5 = hl2Var.e;
                                            String str9 = hl2Var.a;
                                            String strD2 = bl2Var3.d();
                                            String str10 = hl2Var.b;
                                            e73 e73Var = hl2Var.c;
                                            l5 l5Var2 = new l5(str8, e33.b, str9, f5Var2, strD2, null, str10, e73Var, hl2Var.d, null, "unverified: " + e73Var, 1568);
                                            if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.whatsapp.send")).contains(new w3(str4)) || !z5) {
                                                if (g31.a(str4, "message.sms.send") && z5) {
                                                    ov1Var = new ov1(f5.a(f5Var2, "message.sms.confirm_send", null, 30), bl2Var3.d(), "Send this SMS?", bl2Var3.l());
                                                }
                                                objK = k(nm0Var2, l5Var2, rv1Var, fn2Var2);
                                                if (objK == t70Var) {
                                                    obj = t70Var;
                                                } else {
                                                    obj = t70Var;
                                                    objK = obj3;
                                                }
                                            } else {
                                                ov1Var = new ov1(f5.a(f5Var2, "message.whatsapp.send", null, 30), bl2Var3.d(), "Send this WhatsApp message?", bl2Var3.l());
                                            }
                                            rv1Var = ov1Var;
                                            objK = k(nm0Var2, l5Var2, rv1Var, fn2Var2);
                                            if (objK == t70Var) {
                                                obj = t70Var;
                                            } else {
                                                obj = t70Var;
                                                objK = obj3;
                                            }
                                        } else if (jl2Var instanceof fl2) {
                                            fl2 fl2Var = (fl2) jl2Var;
                                            obj = t70Var;
                                            objK = k(nm0Var2, new l5(f5Var2.e, e33Var, fl2Var.a, f5Var2, bl2Var3.d(), null, null, null, fl2Var.c, null, fl2Var.b, 1760), null, fn2Var2);
                                            if (objK != obj) {
                                                objK = obj3;
                                            }
                                        } else {
                                            obj = t70Var;
                                            th = null;
                                            if (jl2Var instanceof el2) {
                                                el2 el2Var = (el2) jl2Var;
                                                objK = k(nm0Var2, new l5(f5Var2.e, e33.e, el2Var.a, f5Var2, bl2Var3.d(), null, null, null, el2Var.c, null, hc4.b(el2Var.b), 1760), null, fn2Var2);
                                                if (objK != obj) {
                                                    objK = obj3;
                                                }
                                            } else {
                                                if (!(jl2Var instanceof gl2)) {
                                                    dk0.l();
                                                    return null;
                                                }
                                                str = f5Var2.e;
                                                List list2 = ay.a;
                                                gl2 gl2Var = (gl2) jl2Var;
                                                yx yxVar = gl2Var.b;
                                                strK = gl2Var.a;
                                                list = yxVar.c;
                                                if (list.isEmpty()) {
                                                    str2 = str;
                                                } else {
                                                    arrayList = new ArrayList(nz.d(list));
                                                    it = list.iterator();
                                                    i = 0;
                                                    while (it.hasNext()) {
                                                        next = it.next();
                                                        i2 = i + 1;
                                                        if (i < 0) {
                                                            Throwable th2 = th;
                                                            nz.n();
                                                            throw th2;
                                                        }
                                                        zx zxVar = (zx) next;
                                                        Throwable th3 = th;
                                                        strValueOf = (String) mz.z(i, ay.a);
                                                        if (strValueOf == null) {
                                                            strValueOf = String.valueOf(i2);
                                                        }
                                                        str3 = zxVar.a;
                                                        str3.getClass();
                                                        String str11 = str;
                                                        Pattern patternCompile = Pattern.compile("\\s*\\((?:from|feat\\.?|featuring|with|original\\s+motion|soundtrack|remix|lofi|live|reloaded|from\\s+the\\s+movie)\\b[^)]*\\)", 66);
                                                        patternCompile.getClass();
                                                        String strReplaceAll = patternCompile.matcher(str3).replaceAll("");
                                                        strReplaceAll.getClass();
                                                        String str12 = strK;
                                                        Iterator it2 = it;
                                                        Pattern patternCompile2 = Pattern.compile("\\s*[-–—]\\s*(?:from|feat\\.?|featuring|with|original\\s+motion|soundtrack|remix|lofi|reloaded|from\\s+the\\s+movie)\\b.*$", 66);
                                                        patternCompile2.getClass();
                                                        String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll("");
                                                        strReplaceAll2.getClass();
                                                        string = cs2.V(strReplaceAll2).toString();
                                                        if (!cs2.A(string)) {
                                                            str3 = string;
                                                        }
                                                        arrayList.add(strValueOf + ", " + ay.a(str3));
                                                        it = it2;
                                                        i = i2;
                                                        th = th3;
                                                        strK = str12;
                                                        str = str11;
                                                    }
                                                    str2 = str;
                                                    strK = cq.k(ay.a(strK), Padder.FALLBACK_PADDING_STRING, mz.C(arrayList, Padder.FALLBACK_PADDING_STRING, null, null, null, 62));
                                                }
                                                objK = k(nm0Var2, new l5(str2, e33.f, strK, f5Var2, bl2Var3.d(), null, null, null, null, null, cq.j("awaiting slot ", yxVar.b), 1984), new qv1(f5Var2, bl2Var3.d(), yxVar, z3), fn2Var2);
                                                if (objK != obj) {
                                                    objK = obj3;
                                                }
                                            }
                                        }
                                        if (objK == obj) {
                                            return obj;
                                        }
                                        return obj3;
                                    } catch (g53 e) {
                                        e = e;
                                        bl2Var2 = bl2Var3;
                                        r7 = 0;
                                        fn2Var2.e = r7;
                                        fn2Var2.f = r7;
                                        fn2Var2.i = r7;
                                        fn2Var2.j = r7;
                                        fn2Var2.k = r7;
                                        fn2Var2.n = z3;
                                        fn2Var2.s = j;
                                        fn2Var2.v = 3;
                                        if (p(nm0Var2, f5Var2, e, bl2Var2, fn2Var2) == t70Var) {
                                            return t70Var;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        bl2Var2 = bl2Var3;
                                        l5Var = new l5(f5Var2.e, e33Var, cq.v("Something went wrong inside ", bl2Var2.m(), ", so I stopped."), f5Var2, bl2Var2.d(), null, null, null, null, null, cq.k(u42.a(th.getClass()).b(), ": ", th.getMessage()), 2016);
                                        fn2Var2.e = null;
                                        fn2Var2.f = null;
                                        fn2Var2.i = null;
                                        fn2Var2.j = null;
                                        fn2Var2.k = null;
                                        fn2Var2.n = z3;
                                        fn2Var2.s = j;
                                        fn2Var2.v = 4;
                                        if (k(nm0Var2, l5Var, null, fn2Var2) == t70Var) {
                                            return t70Var;
                                        }
                                    }
                                }
                            } catch (g53 e2) {
                                e = e2;
                                r7 = 0;
                                f5Var2 = f5Var4;
                                z3 = z2;
                                fn2Var2.e = r7;
                                fn2Var2.f = r7;
                                fn2Var2.i = r7;
                                fn2Var2.j = r7;
                                fn2Var2.k = r7;
                                fn2Var2.n = z3;
                                fn2Var2.s = j;
                                fn2Var2.v = 3;
                                if (p(nm0Var2, f5Var2, e, bl2Var2, fn2Var2) == t70Var) {
                                    return t70Var;
                                }
                                return obj3;
                            } catch (Throwable th5) {
                                th = th5;
                                f5Var2 = f5Var4;
                                z3 = z2;
                                l5Var = new l5(f5Var2.e, e33Var, cq.v("Something went wrong inside ", bl2Var2.m(), ", so I stopped."), f5Var2, bl2Var2.d(), null, null, null, null, null, cq.k(u42.a(th.getClass()).b(), ": ", th.getMessage()), 2016);
                                fn2Var2.e = null;
                                fn2Var2.f = null;
                                fn2Var2.i = null;
                                fn2Var2.j = null;
                                fn2Var2.k = null;
                                fn2Var2.n = z3;
                                fn2Var2.s = j;
                                fn2Var2.v = 4;
                                if (k(nm0Var2, l5Var, null, fn2Var2) == t70Var) {
                                    return t70Var;
                                }
                                return obj3;
                            }
                        }
                        return t70Var;
                    case 1:
                        j = fn2Var2.s;
                        boolean z6 = fn2Var2.n;
                        cl2 cl2Var6 = fn2Var2.j;
                        bl2Var2 = fn2Var2.i;
                        f5 f5Var5 = fn2Var2.f;
                        nm0Var2 = fn2Var2.e;
                        bz3.g(obj2);
                        cl2Var2 = cl2Var6;
                        f5Var4 = f5Var5;
                        z2 = z6;
                        fn2Var2.e = nm0Var2;
                        fn2Var2.f = f5Var4;
                        fn2Var2.i = bl2Var2;
                        fn2Var2.j = cl2Var2;
                        fn2Var2.n = z2;
                        fn2Var2.s = j;
                        fn2Var2.v = 2;
                        objH = bl2Var2.h(f5Var4, cl2Var2, fn2Var2);
                        if (objH != t70Var) {
                            cl2 cl2Var7 = cl2Var2;
                            bl2Var3 = bl2Var2;
                            cl2Var3 = cl2Var7;
                            f5Var2 = f5Var4;
                            z3 = z2;
                            obj2 = objH;
                            jl2Var = (jl2) obj2;
                            if (jl2Var instanceof hl2) {
                                d5Var = new d5(bl2Var3.d());
                                fn2Var2.e = nm0Var2;
                                fn2Var2.f = f5Var2;
                                fn2Var2.i = bl2Var3;
                                fn2Var2.j = cl2Var3;
                                fn2Var2.k = jl2Var;
                                fn2Var2.n = z3;
                                fn2Var2.s = j;
                                fn2Var2.v = 5;
                                if (nm0Var2.n(d5Var, fn2Var2) != t70Var) {
                                    z4 = z3;
                                    jl2Var2 = jl2Var;
                                    nm0Var3 = nm0Var2;
                                    cl2Var4 = cl2Var3;
                                    bl2Var4 = bl2Var3;
                                    f5Var3 = f5Var2;
                                    j2 = j;
                                    fn2Var2.e = nm0Var3;
                                    fn2Var2.f = f5Var3;
                                    fn2Var2.i = bl2Var4;
                                    fn2Var2.j = null;
                                    fn2Var2.k = jl2Var2;
                                    fn2Var2.n = z4;
                                    fn2Var2.s = j2;
                                    fn2Var2.v = 6;
                                    objA = this.f.a(bl2Var4, f5Var3, cl2Var4, (hl2) jl2Var2, f73.a, fn2Var2);
                                    if (objA != t70Var) {
                                        obj2 = objA;
                                        j = j2;
                                        nm0Var2 = nm0Var3;
                                        jl2Var = (jl2) obj2;
                                        z3 = z4;
                                        f5Var2 = f5Var3;
                                        bl2Var3 = bl2Var4;
                                    }
                                }
                            }
                            System.currentTimeMillis();
                            fn2Var2.e = null;
                            fn2Var2.f = null;
                            fn2Var2.i = null;
                            fn2Var2.j = null;
                            fn2Var2.k = null;
                            fn2Var2.n = z3;
                            fn2Var2.s = j;
                            fn2Var2.v = 7;
                            if (jl2Var instanceof il2) {
                                String str13 = f5Var2.e;
                                il2 il2Var2 = (il2) jl2Var;
                                String str14 = il2Var2.a;
                                String strD3 = bl2Var3.d();
                                String str15 = il2Var2.d;
                                d73 d73Var2 = il2Var2.b;
                                objK = k(nm0Var2, new l5(str13, e33.a, str14, f5Var2, strD3, str15, null, d73Var2, null, il2Var2.c, cq.l("verified: ", d73Var2.a, " → ", d73Var2.b), UCharacter.UnicodeBlock.ZNAMENNY_MUSICAL_NOTATION_ID), null, fn2Var2);
                                if (objK == t70Var) {
                                    obj = t70Var;
                                } else {
                                    obj = t70Var;
                                    objK = obj3;
                                }
                            } else if (jl2Var instanceof hl2) {
                                String str16 = f5Var2.e;
                                str4 = f5Var2.a;
                                hl2 hl2Var2 = (hl2) jl2Var;
                                boolean z7 = hl2Var2.e;
                                String str17 = hl2Var2.a;
                                String strD4 = bl2Var3.d();
                                String str18 = hl2Var2.b;
                                e73 e73Var2 = hl2Var2.c;
                                l5 l5Var3 = new l5(str16, e33.b, str17, f5Var2, strD4, null, str18, e73Var2, hl2Var2.d, null, "unverified: " + e73Var2, 1568);
                                if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.whatsapp.send")).contains(new w3(str4))) {
                                    if (g31.a(str4, "message.sms.send")) {
                                        ov1Var = new ov1(f5.a(f5Var2, "message.sms.confirm_send", null, 30), bl2Var3.d(), "Send this SMS?", bl2Var3.l());
                                        rv1Var = ov1Var;
                                    }
                                } else if (g31.a(str4, "message.sms.send")) {
                                    ov1Var = new ov1(f5.a(f5Var2, "message.sms.confirm_send", null, 30), bl2Var3.d(), "Send this SMS?", bl2Var3.l());
                                    rv1Var = ov1Var;
                                }
                                objK = k(nm0Var2, l5Var3, rv1Var, fn2Var2);
                                if (objK == t70Var) {
                                    obj = t70Var;
                                } else {
                                    obj = t70Var;
                                    objK = obj3;
                                }
                            } else if (jl2Var instanceof fl2) {
                                fl2 fl2Var2 = (fl2) jl2Var;
                                obj = t70Var;
                                objK = k(nm0Var2, new l5(f5Var2.e, e33Var, fl2Var2.a, f5Var2, bl2Var3.d(), null, null, null, fl2Var2.c, null, fl2Var2.b, 1760), null, fn2Var2);
                                if (objK != obj) {
                                    objK = obj3;
                                }
                            } else {
                                obj = t70Var;
                                th = null;
                                if (jl2Var instanceof el2) {
                                    el2 el2Var2 = (el2) jl2Var;
                                    objK = k(nm0Var2, new l5(f5Var2.e, e33.e, el2Var2.a, f5Var2, bl2Var3.d(), null, null, null, el2Var2.c, null, hc4.b(el2Var2.b), 1760), null, fn2Var2);
                                    if (objK != obj) {
                                        objK = obj3;
                                    }
                                } else {
                                    if (!(jl2Var instanceof gl2)) {
                                        dk0.l();
                                        return null;
                                    }
                                    str = f5Var2.e;
                                    List list3 = ay.a;
                                    gl2 gl2Var2 = (gl2) jl2Var;
                                    yx yxVar2 = gl2Var2.b;
                                    strK = gl2Var2.a;
                                    list = yxVar2.c;
                                    if (list.isEmpty()) {
                                        str2 = str;
                                    } else {
                                        arrayList = new ArrayList(nz.d(list));
                                        it = list.iterator();
                                        i = 0;
                                        while (it.hasNext()) {
                                            next = it.next();
                                            i2 = i + 1;
                                            if (i < 0) {
                                                Throwable th6 = th;
                                                nz.n();
                                                throw th6;
                                            }
                                            zx zxVar2 = (zx) next;
                                            Throwable th7 = th;
                                            strValueOf = (String) mz.z(i, ay.a);
                                            if (strValueOf == null) {
                                                strValueOf = String.valueOf(i2);
                                            }
                                            str3 = zxVar2.a;
                                            str3.getClass();
                                            String str19 = str;
                                            Pattern patternCompile3 = Pattern.compile("\\s*\\((?:from|feat\\.?|featuring|with|original\\s+motion|soundtrack|remix|lofi|live|reloaded|from\\s+the\\s+movie)\\b[^)]*\\)", 66);
                                            patternCompile3.getClass();
                                            String strReplaceAll3 = patternCompile3.matcher(str3).replaceAll("");
                                            strReplaceAll3.getClass();
                                            String str110 = strK;
                                            Iterator it3 = it;
                                            Pattern patternCompile4 = Pattern.compile("\\s*[-–—]\\s*(?:from|feat\\.?|featuring|with|original\\s+motion|soundtrack|remix|lofi|reloaded|from\\s+the\\s+movie)\\b.*$", 66);
                                            patternCompile4.getClass();
                                            String strReplaceAll4 = patternCompile4.matcher(strReplaceAll3).replaceAll("");
                                            strReplaceAll4.getClass();
                                            string = cs2.V(strReplaceAll4).toString();
                                            if (!cs2.A(string)) {
                                                str3 = string;
                                            }
                                            arrayList.add(strValueOf + ", " + ay.a(str3));
                                            it = it3;
                                            i = i2;
                                            th = th7;
                                            strK = str110;
                                            str = str19;
                                        }
                                        str2 = str;
                                        strK = cq.k(ay.a(strK), Padder.FALLBACK_PADDING_STRING, mz.C(arrayList, Padder.FALLBACK_PADDING_STRING, null, null, null, 62));
                                    }
                                    objK = k(nm0Var2, new l5(str2, e33.f, strK, f5Var2, bl2Var3.d(), null, null, null, null, null, cq.j("awaiting slot ", yxVar2.b), 1984), new qv1(f5Var2, bl2Var3.d(), yxVar2, z3), fn2Var2);
                                    if (objK != obj) {
                                        objK = obj3;
                                    }
                                }
                            }
                            if (objK == obj) {
                                return obj;
                            }
                            return obj3;
                        }
                        return t70Var;
                    case 2:
                        j = fn2Var2.s;
                        z3 = fn2Var2.n;
                        cl2 cl2Var8 = fn2Var2.j;
                        bl2Var2 = fn2Var2.i;
                        f5 f5Var6 = fn2Var2.f;
                        nm0Var2 = fn2Var2.e;
                        try {
                            bz3.g(obj2);
                            f5Var2 = f5Var6;
                            bl2Var3 = bl2Var2;
                            cl2Var3 = cl2Var8;
                            jl2Var = (jl2) obj2;
                            if (jl2Var instanceof hl2) {
                                d5Var = new d5(bl2Var3.d());
                                fn2Var2.e = nm0Var2;
                                fn2Var2.f = f5Var2;
                                fn2Var2.i = bl2Var3;
                                fn2Var2.j = cl2Var3;
                                fn2Var2.k = jl2Var;
                                fn2Var2.n = z3;
                                fn2Var2.s = j;
                                fn2Var2.v = 5;
                                if (nm0Var2.n(d5Var, fn2Var2) != t70Var) {
                                    z4 = z3;
                                    jl2Var2 = jl2Var;
                                    nm0Var3 = nm0Var2;
                                    cl2Var4 = cl2Var3;
                                    bl2Var4 = bl2Var3;
                                    f5Var3 = f5Var2;
                                    j2 = j;
                                    fn2Var2.e = nm0Var3;
                                    fn2Var2.f = f5Var3;
                                    fn2Var2.i = bl2Var4;
                                    fn2Var2.j = null;
                                    fn2Var2.k = jl2Var2;
                                    fn2Var2.n = z4;
                                    fn2Var2.s = j2;
                                    fn2Var2.v = 6;
                                    objA = this.f.a(bl2Var4, f5Var3, cl2Var4, (hl2) jl2Var2, f73.a, fn2Var2);
                                    if (objA != t70Var) {
                                        obj2 = objA;
                                        j = j2;
                                        nm0Var2 = nm0Var3;
                                        jl2Var = (jl2) obj2;
                                        z3 = z4;
                                        f5Var2 = f5Var3;
                                        bl2Var3 = bl2Var4;
                                    }
                                }
                                return t70Var;
                            }
                            System.currentTimeMillis();
                            fn2Var2.e = null;
                            fn2Var2.f = null;
                            fn2Var2.i = null;
                            fn2Var2.j = null;
                            fn2Var2.k = null;
                            fn2Var2.n = z3;
                            fn2Var2.s = j;
                            fn2Var2.v = 7;
                            if (jl2Var instanceof il2) {
                                String str111 = f5Var2.e;
                                il2 il2Var3 = (il2) jl2Var;
                                String str112 = il2Var3.a;
                                String strD5 = bl2Var3.d();
                                String str113 = il2Var3.d;
                                d73 d73Var3 = il2Var3.b;
                                objK = k(nm0Var2, new l5(str111, e33.a, str112, f5Var2, strD5, str113, null, d73Var3, null, il2Var3.c, cq.l("verified: ", d73Var3.a, " → ", d73Var3.b), UCharacter.UnicodeBlock.ZNAMENNY_MUSICAL_NOTATION_ID), null, fn2Var2);
                                if (objK == t70Var) {
                                    obj = t70Var;
                                } else {
                                    obj = t70Var;
                                    objK = obj3;
                                }
                            } else if (jl2Var instanceof hl2) {
                                String str114 = f5Var2.e;
                                str4 = f5Var2.a;
                                hl2 hl2Var3 = (hl2) jl2Var;
                                boolean z8 = hl2Var3.e;
                                String str115 = hl2Var3.a;
                                String strD6 = bl2Var3.d();
                                String str116 = hl2Var3.b;
                                e73 e73Var3 = hl2Var3.c;
                                l5 l5Var4 = new l5(str114, e33.b, str115, f5Var2, strD6, null, str116, e73Var3, hl2Var3.d, null, "unverified: " + e73Var3, 1568);
                                if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.whatsapp.send")).contains(new w3(str4))) {
                                    if (g31.a(str4, "message.sms.send")) {
                                        ov1Var = new ov1(f5.a(f5Var2, "message.sms.confirm_send", null, 30), bl2Var3.d(), "Send this SMS?", bl2Var3.l());
                                        rv1Var = ov1Var;
                                    }
                                } else if (g31.a(str4, "message.sms.send")) {
                                    ov1Var = new ov1(f5.a(f5Var2, "message.sms.confirm_send", null, 30), bl2Var3.d(), "Send this SMS?", bl2Var3.l());
                                    rv1Var = ov1Var;
                                }
                                objK = k(nm0Var2, l5Var4, rv1Var, fn2Var2);
                                if (objK == t70Var) {
                                    obj = t70Var;
                                } else {
                                    obj = t70Var;
                                    objK = obj3;
                                }
                            } else if (jl2Var instanceof fl2) {
                                fl2 fl2Var3 = (fl2) jl2Var;
                                obj = t70Var;
                                objK = k(nm0Var2, new l5(f5Var2.e, e33Var, fl2Var3.a, f5Var2, bl2Var3.d(), null, null, null, fl2Var3.c, null, fl2Var3.b, 1760), null, fn2Var2);
                                if (objK != obj) {
                                    objK = obj3;
                                }
                            } else {
                                obj = t70Var;
                                th = null;
                                if (jl2Var instanceof el2) {
                                    el2 el2Var3 = (el2) jl2Var;
                                    objK = k(nm0Var2, new l5(f5Var2.e, e33.e, el2Var3.a, f5Var2, bl2Var3.d(), null, null, null, el2Var3.c, null, hc4.b(el2Var3.b), 1760), null, fn2Var2);
                                    if (objK != obj) {
                                        objK = obj3;
                                    }
                                } else {
                                    if (!(jl2Var instanceof gl2)) {
                                        dk0.l();
                                        return null;
                                    }
                                    str = f5Var2.e;
                                    List list4 = ay.a;
                                    gl2 gl2Var3 = (gl2) jl2Var;
                                    yx yxVar3 = gl2Var3.b;
                                    strK = gl2Var3.a;
                                    list = yxVar3.c;
                                    if (list.isEmpty()) {
                                        str2 = str;
                                    } else {
                                        arrayList = new ArrayList(nz.d(list));
                                        it = list.iterator();
                                        i = 0;
                                        while (it.hasNext()) {
                                            next = it.next();
                                            i2 = i + 1;
                                            if (i < 0) {
                                                Throwable th8 = th;
                                                nz.n();
                                                throw th8;
                                            }
                                            zx zxVar3 = (zx) next;
                                            Throwable th9 = th;
                                            strValueOf = (String) mz.z(i, ay.a);
                                            if (strValueOf == null) {
                                                strValueOf = String.valueOf(i2);
                                            }
                                            str3 = zxVar3.a;
                                            str3.getClass();
                                            String str117 = str;
                                            Pattern patternCompile5 = Pattern.compile("\\s*\\((?:from|feat\\.?|featuring|with|original\\s+motion|soundtrack|remix|lofi|live|reloaded|from\\s+the\\s+movie)\\b[^)]*\\)", 66);
                                            patternCompile5.getClass();
                                            String strReplaceAll5 = patternCompile5.matcher(str3).replaceAll("");
                                            strReplaceAll5.getClass();
                                            String str118 = strK;
                                            Iterator it4 = it;
                                            Pattern patternCompile6 = Pattern.compile("\\s*[-–—]\\s*(?:from|feat\\.?|featuring|with|original\\s+motion|soundtrack|remix|lofi|reloaded|from\\s+the\\s+movie)\\b.*$", 66);
                                            patternCompile6.getClass();
                                            String strReplaceAll6 = patternCompile6.matcher(strReplaceAll5).replaceAll("");
                                            strReplaceAll6.getClass();
                                            string = cs2.V(strReplaceAll6).toString();
                                            if (!cs2.A(string)) {
                                                str3 = string;
                                            }
                                            arrayList.add(strValueOf + ", " + ay.a(str3));
                                            it = it4;
                                            i = i2;
                                            th = th9;
                                            strK = str118;
                                            str = str117;
                                        }
                                        str2 = str;
                                        strK = cq.k(ay.a(strK), Padder.FALLBACK_PADDING_STRING, mz.C(arrayList, Padder.FALLBACK_PADDING_STRING, null, null, null, 62));
                                    }
                                    objK = k(nm0Var2, new l5(str2, e33.f, strK, f5Var2, bl2Var3.d(), null, null, null, null, null, cq.j("awaiting slot ", yxVar3.b), 1984), new qv1(f5Var2, bl2Var3.d(), yxVar3, z3), fn2Var2);
                                    if (objK != obj) {
                                        objK = obj3;
                                    }
                                }
                            }
                            if (objK == obj) {
                                return obj;
                            }
                            return obj3;
                        } catch (g53 e3) {
                            e = e3;
                            f5Var2 = f5Var6;
                            r7 = 0;
                            fn2Var2.e = r7;
                            fn2Var2.f = r7;
                            fn2Var2.i = r7;
                            fn2Var2.j = r7;
                            fn2Var2.k = r7;
                            fn2Var2.n = z3;
                            fn2Var2.s = j;
                            fn2Var2.v = 3;
                            if (p(nm0Var2, f5Var2, e, bl2Var2, fn2Var2) == t70Var) {
                                return t70Var;
                            }
                            return obj3;
                        } catch (Throwable th10) {
                            th = th10;
                            f5Var2 = f5Var6;
                            l5Var = new l5(f5Var2.e, e33Var, cq.v("Something went wrong inside ", bl2Var2.m(), ", so I stopped."), f5Var2, bl2Var2.d(), null, null, null, null, null, cq.k(u42.a(th.getClass()).b(), ": ", th.getMessage()), 2016);
                            fn2Var2.e = null;
                            fn2Var2.f = null;
                            fn2Var2.i = null;
                            fn2Var2.j = null;
                            fn2Var2.k = null;
                            fn2Var2.n = z3;
                            fn2Var2.s = j;
                            fn2Var2.v = 4;
                            if (k(nm0Var2, l5Var, null, fn2Var2) == t70Var) {
                                return t70Var;
                            }
                            return obj3;
                        }
                    case 3:
                        bz3.g(obj2);
                        return obj3;
                    case 4:
                        bz3.g(obj2);
                        return obj3;
                    case 5:
                        j = fn2Var2.s;
                        z4 = fn2Var2.n;
                        jl2Var2 = fn2Var2.k;
                        cl2 cl2Var9 = fn2Var2.j;
                        bl2 bl2Var5 = fn2Var2.i;
                        f5 f5Var7 = fn2Var2.f;
                        nm0 nm0Var4 = fn2Var2.e;
                        bz3.g(obj2);
                        cl2Var4 = cl2Var9;
                        bl2Var4 = bl2Var5;
                        f5Var3 = f5Var7;
                        nm0Var3 = nm0Var4;
                        j2 = j;
                        fn2Var2.e = nm0Var3;
                        fn2Var2.f = f5Var3;
                        fn2Var2.i = bl2Var4;
                        fn2Var2.j = null;
                        fn2Var2.k = jl2Var2;
                        fn2Var2.n = z4;
                        fn2Var2.s = j2;
                        fn2Var2.v = 6;
                        objA = this.f.a(bl2Var4, f5Var3, cl2Var4, (hl2) jl2Var2, f73.a, fn2Var2);
                        if (objA != t70Var) {
                            obj2 = objA;
                            j = j2;
                            nm0Var2 = nm0Var3;
                            jl2Var = (jl2) obj2;
                            z3 = z4;
                            f5Var2 = f5Var3;
                            bl2Var3 = bl2Var4;
                            System.currentTimeMillis();
                            fn2Var2.e = null;
                            fn2Var2.f = null;
                            fn2Var2.i = null;
                            fn2Var2.j = null;
                            fn2Var2.k = null;
                            fn2Var2.n = z3;
                            fn2Var2.s = j;
                            fn2Var2.v = 7;
                            if (jl2Var instanceof il2) {
                                String str119 = f5Var2.e;
                                il2 il2Var4 = (il2) jl2Var;
                                String str1110 = il2Var4.a;
                                String strD7 = bl2Var3.d();
                                String str1111 = il2Var4.d;
                                d73 d73Var4 = il2Var4.b;
                                objK = k(nm0Var2, new l5(str119, e33.a, str1110, f5Var2, strD7, str1111, null, d73Var4, null, il2Var4.c, cq.l("verified: ", d73Var4.a, " → ", d73Var4.b), UCharacter.UnicodeBlock.ZNAMENNY_MUSICAL_NOTATION_ID), null, fn2Var2);
                                if (objK == t70Var) {
                                    obj = t70Var;
                                } else {
                                    obj = t70Var;
                                    objK = obj3;
                                }
                            } else if (jl2Var instanceof hl2) {
                                String str1112 = f5Var2.e;
                                str4 = f5Var2.a;
                                hl2 hl2Var4 = (hl2) jl2Var;
                                boolean z9 = hl2Var4.e;
                                String str1113 = hl2Var4.a;
                                String strD8 = bl2Var3.d();
                                String str1114 = hl2Var4.b;
                                e73 e73Var4 = hl2Var4.c;
                                l5 l5Var5 = new l5(str1112, e33.b, str1113, f5Var2, strD8, null, str1114, e73Var4, hl2Var4.d, null, "unverified: " + e73Var4, 1568);
                                if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.whatsapp.send")).contains(new w3(str4))) {
                                    if (g31.a(str4, "message.sms.send")) {
                                        ov1Var = new ov1(f5.a(f5Var2, "message.sms.confirm_send", null, 30), bl2Var3.d(), "Send this SMS?", bl2Var3.l());
                                        rv1Var = ov1Var;
                                    }
                                } else if (g31.a(str4, "message.sms.send")) {
                                    ov1Var = new ov1(f5.a(f5Var2, "message.sms.confirm_send", null, 30), bl2Var3.d(), "Send this SMS?", bl2Var3.l());
                                    rv1Var = ov1Var;
                                }
                                objK = k(nm0Var2, l5Var5, rv1Var, fn2Var2);
                                if (objK == t70Var) {
                                    obj = t70Var;
                                } else {
                                    obj = t70Var;
                                    objK = obj3;
                                }
                            } else if (jl2Var instanceof fl2) {
                                fl2 fl2Var4 = (fl2) jl2Var;
                                obj = t70Var;
                                objK = k(nm0Var2, new l5(f5Var2.e, e33Var, fl2Var4.a, f5Var2, bl2Var3.d(), null, null, null, fl2Var4.c, null, fl2Var4.b, 1760), null, fn2Var2);
                                if (objK != obj) {
                                    objK = obj3;
                                }
                            } else {
                                obj = t70Var;
                                th = null;
                                if (jl2Var instanceof el2) {
                                    el2 el2Var4 = (el2) jl2Var;
                                    objK = k(nm0Var2, new l5(f5Var2.e, e33.e, el2Var4.a, f5Var2, bl2Var3.d(), null, null, null, el2Var4.c, null, hc4.b(el2Var4.b), 1760), null, fn2Var2);
                                    if (objK != obj) {
                                        objK = obj3;
                                    }
                                } else {
                                    if (!(jl2Var instanceof gl2)) {
                                        dk0.l();
                                        return null;
                                    }
                                    str = f5Var2.e;
                                    List list5 = ay.a;
                                    gl2 gl2Var4 = (gl2) jl2Var;
                                    yx yxVar4 = gl2Var4.b;
                                    strK = gl2Var4.a;
                                    list = yxVar4.c;
                                    if (list.isEmpty()) {
                                        str2 = str;
                                    } else {
                                        arrayList = new ArrayList(nz.d(list));
                                        it = list.iterator();
                                        i = 0;
                                        while (it.hasNext()) {
                                            next = it.next();
                                            i2 = i + 1;
                                            if (i < 0) {
                                                Throwable th11 = th;
                                                nz.n();
                                                throw th11;
                                            }
                                            zx zxVar4 = (zx) next;
                                            Throwable th12 = th;
                                            strValueOf = (String) mz.z(i, ay.a);
                                            if (strValueOf == null) {
                                                strValueOf = String.valueOf(i2);
                                            }
                                            str3 = zxVar4.a;
                                            str3.getClass();
                                            String str1115 = str;
                                            Pattern patternCompile7 = Pattern.compile("\\s*\\((?:from|feat\\.?|featuring|with|original\\s+motion|soundtrack|remix|lofi|live|reloaded|from\\s+the\\s+movie)\\b[^)]*\\)", 66);
                                            patternCompile7.getClass();
                                            String strReplaceAll7 = patternCompile7.matcher(str3).replaceAll("");
                                            strReplaceAll7.getClass();
                                            String str1116 = strK;
                                            Iterator it5 = it;
                                            Pattern patternCompile8 = Pattern.compile("\\s*[-–—]\\s*(?:from|feat\\.?|featuring|with|original\\s+motion|soundtrack|remix|lofi|reloaded|from\\s+the\\s+movie)\\b.*$", 66);
                                            patternCompile8.getClass();
                                            String strReplaceAll8 = patternCompile8.matcher(strReplaceAll7).replaceAll("");
                                            strReplaceAll8.getClass();
                                            string = cs2.V(strReplaceAll8).toString();
                                            if (!cs2.A(string)) {
                                                str3 = string;
                                            }
                                            arrayList.add(strValueOf + ", " + ay.a(str3));
                                            it = it5;
                                            i = i2;
                                            th = th12;
                                            strK = str1116;
                                            str = str1115;
                                        }
                                        str2 = str;
                                        strK = cq.k(ay.a(strK), Padder.FALLBACK_PADDING_STRING, mz.C(arrayList, Padder.FALLBACK_PADDING_STRING, null, null, null, 62));
                                    }
                                    objK = k(nm0Var2, new l5(str2, e33.f, strK, f5Var2, bl2Var3.d(), null, null, null, null, null, cq.j("awaiting slot ", yxVar4.b), 1984), new qv1(f5Var2, bl2Var3.d(), yxVar4, z3), fn2Var2);
                                    if (objK != obj) {
                                        objK = obj3;
                                    }
                                }
                            }
                            if (objK == obj) {
                                return obj;
                            }
                            return obj3;
                        }
                        return t70Var;
                    case 6:
                        j = fn2Var2.s;
                        z4 = fn2Var2.n;
                        jl2Var2 = fn2Var2.k;
                        bl2Var4 = fn2Var2.i;
                        f5Var3 = fn2Var2.f;
                        nm0Var2 = fn2Var2.e;
                        try {
                            bz3.g(obj2);
                            jl2Var = (jl2) obj2;
                            z3 = z4;
                            f5Var2 = f5Var3;
                        } catch (Throwable unused2) {
                            jl2Var = jl2Var2;
                            f5Var2 = f5Var3;
                            z3 = z4;
                        }
                        bl2Var3 = bl2Var4;
                        System.currentTimeMillis();
                        fn2Var2.e = null;
                        fn2Var2.f = null;
                        fn2Var2.i = null;
                        fn2Var2.j = null;
                        fn2Var2.k = null;
                        fn2Var2.n = z3;
                        fn2Var2.s = j;
                        fn2Var2.v = 7;
                        if (jl2Var instanceof il2) {
                            String str1117 = f5Var2.e;
                            il2 il2Var5 = (il2) jl2Var;
                            String str1118 = il2Var5.a;
                            String strD9 = bl2Var3.d();
                            String str1119 = il2Var5.d;
                            d73 d73Var5 = il2Var5.b;
                            objK = k(nm0Var2, new l5(str1117, e33.a, str1118, f5Var2, strD9, str1119, null, d73Var5, null, il2Var5.c, cq.l("verified: ", d73Var5.a, " → ", d73Var5.b), UCharacter.UnicodeBlock.ZNAMENNY_MUSICAL_NOTATION_ID), null, fn2Var2);
                            if (objK == t70Var) {
                                obj = t70Var;
                            } else {
                                obj = t70Var;
                                objK = obj3;
                            }
                        } else if (jl2Var instanceof hl2) {
                            String str11110 = f5Var2.e;
                            str4 = f5Var2.a;
                            hl2 hl2Var5 = (hl2) jl2Var;
                            boolean z10 = hl2Var5.e;
                            String str11111 = hl2Var5.a;
                            String strD10 = bl2Var3.d();
                            String str11112 = hl2Var5.b;
                            e73 e73Var5 = hl2Var5.c;
                            l5 l5Var6 = new l5(str11110, e33.b, str11111, f5Var2, strD10, null, str11112, e73Var5, hl2Var5.d, null, "unverified: " + e73Var5, 1568);
                            if (wh2.c(new w3("message.whatsapp.draft"), new w3("message.whatsapp.send")).contains(new w3(str4))) {
                                if (g31.a(str4, "message.sms.send")) {
                                    ov1Var = new ov1(f5.a(f5Var2, "message.sms.confirm_send", null, 30), bl2Var3.d(), "Send this SMS?", bl2Var3.l());
                                    rv1Var = ov1Var;
                                }
                            } else if (g31.a(str4, "message.sms.send")) {
                                ov1Var = new ov1(f5.a(f5Var2, "message.sms.confirm_send", null, 30), bl2Var3.d(), "Send this SMS?", bl2Var3.l());
                                rv1Var = ov1Var;
                            }
                            objK = k(nm0Var2, l5Var6, rv1Var, fn2Var2);
                            if (objK == t70Var) {
                                obj = t70Var;
                            } else {
                                obj = t70Var;
                                objK = obj3;
                            }
                        } else if (jl2Var instanceof fl2) {
                            fl2 fl2Var5 = (fl2) jl2Var;
                            obj = t70Var;
                            objK = k(nm0Var2, new l5(f5Var2.e, e33Var, fl2Var5.a, f5Var2, bl2Var3.d(), null, null, null, fl2Var5.c, null, fl2Var5.b, 1760), null, fn2Var2);
                            if (objK != obj) {
                                objK = obj3;
                            }
                        } else {
                            obj = t70Var;
                            th = null;
                            if (jl2Var instanceof el2) {
                                el2 el2Var5 = (el2) jl2Var;
                                objK = k(nm0Var2, new l5(f5Var2.e, e33.e, el2Var5.a, f5Var2, bl2Var3.d(), null, null, null, el2Var5.c, null, hc4.b(el2Var5.b), 1760), null, fn2Var2);
                                if (objK != obj) {
                                    objK = obj3;
                                }
                            } else {
                                if (!(jl2Var instanceof gl2)) {
                                    dk0.l();
                                    return null;
                                }
                                str = f5Var2.e;
                                List list6 = ay.a;
                                gl2 gl2Var5 = (gl2) jl2Var;
                                yx yxVar5 = gl2Var5.b;
                                strK = gl2Var5.a;
                                list = yxVar5.c;
                                if (list.isEmpty()) {
                                    str2 = str;
                                } else {
                                    arrayList = new ArrayList(nz.d(list));
                                    it = list.iterator();
                                    i = 0;
                                    while (it.hasNext()) {
                                        next = it.next();
                                        i2 = i + 1;
                                        if (i < 0) {
                                            Throwable th13 = th;
                                            nz.n();
                                            throw th13;
                                        }
                                        zx zxVar5 = (zx) next;
                                        Throwable th14 = th;
                                        strValueOf = (String) mz.z(i, ay.a);
                                        if (strValueOf == null) {
                                            strValueOf = String.valueOf(i2);
                                        }
                                        str3 = zxVar5.a;
                                        str3.getClass();
                                        String str11113 = str;
                                        Pattern patternCompile9 = Pattern.compile("\\s*\\((?:from|feat\\.?|featuring|with|original\\s+motion|soundtrack|remix|lofi|live|reloaded|from\\s+the\\s+movie)\\b[^)]*\\)", 66);
                                        patternCompile9.getClass();
                                        String strReplaceAll9 = patternCompile9.matcher(str3).replaceAll("");
                                        strReplaceAll9.getClass();
                                        String str11114 = strK;
                                        Iterator it6 = it;
                                        Pattern patternCompile10 = Pattern.compile("\\s*[-–—]\\s*(?:from|feat\\.?|featuring|with|original\\s+motion|soundtrack|remix|lofi|reloaded|from\\s+the\\s+movie)\\b.*$", 66);
                                        patternCompile10.getClass();
                                        String strReplaceAll10 = patternCompile10.matcher(strReplaceAll9).replaceAll("");
                                        strReplaceAll10.getClass();
                                        string = cs2.V(strReplaceAll10).toString();
                                        if (!cs2.A(string)) {
                                            str3 = string;
                                        }
                                        arrayList.add(strValueOf + ", " + ay.a(str3));
                                        it = it6;
                                        i = i2;
                                        th = th14;
                                        strK = str11114;
                                        str = str11113;
                                    }
                                    str2 = str;
                                    strK = cq.k(ay.a(strK), Padder.FALLBACK_PADDING_STRING, mz.C(arrayList, Padder.FALLBACK_PADDING_STRING, null, null, null, 62));
                                }
                                objK = k(nm0Var2, new l5(str2, e33.f, strK, f5Var2, bl2Var3.d(), null, null, null, null, null, cq.j("awaiting slot ", yxVar5.b), 1984), new qv1(f5Var2, bl2Var3.d(), yxVar5, z3), fn2Var2);
                                if (objK != obj) {
                                    objK = obj3;
                                }
                            }
                        }
                        if (objK == obj) {
                            return obj;
                        }
                        return obj3;
                    case 7:
                        bz3.g(obj2);
                        return obj3;
                    default:
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
            } catch (CancellationException e4) {
                throw e4;
            }
        } catch (CancellationException e5) {
            throw e5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00aa  */
    public final Object k(nm0 nm0Var, l5 l5Var, rv1 rv1Var, x50 x50Var) {
        Object value;
        f5 f5Var;
        String str;
        String strC;
        a60 a60Var = this.g;
        if (rv1Var != null) {
            a60Var.c(rv1Var);
        } else {
            a60Var.b();
        }
        a60Var.getClass();
        e33 e33Var = l5Var.b;
        jr2 jr2Var = a60Var.f;
        do {
            value = jr2Var.getValue();
        } while (!jr2Var.h(value, mz.M(50, mz.F((List) value, l5Var))));
        e33 e33Var2 = e33.b;
        e33 e33Var3 = e33.a;
        if ((e33Var == e33Var3 || e33Var == e33Var2) && (f5Var = l5Var.d) != null) {
            jr2 jr2Var2 = a60Var.c;
            i60 i60Var = (i60) jr2Var2.getValue();
            String strC2 = f5Var.c("contact_name");
            String str2 = f5Var.a;
            String strC3 = f5Var.c("phone_number");
            String strC4 = f5Var.c("query");
            if (strC4 == null) {
                strC4 = f5Var.c("place");
            }
            String strC5 = f5Var.c("url");
            int i = i60Var.a + 1;
            if (g31.a(str2, "meta.chat") || g31.a(str2, "meta.about") || g31.a(str2, "meta.cancel")) {
                str2 = i60Var.b;
            }
            String str3 = str2;
            String str4 = strC2 == null ? strC3 != null ? null : i60Var.c : strC2;
            if (strC3 != null) {
                str = strC3;
            } else if (strC2 != null) {
                str = null;
            } else {
                strC3 = i60Var.d;
                str = strC3;
            }
            if ((e33Var == e33Var3 || e33Var == e33Var2) && (strC = f5Var.c("app_name")) != null) {
                int i2 = 0;
                for (int i3 = 0; i3 < strC.length(); i3++) {
                    if (strC.charAt(i3) == '.') {
                        i2++;
                    }
                }
                if (i2 < 1 || cs2.o(strC, ' ')) {
                    strC = null;
                }
            } else {
                strC = null;
            }
            if (strC == null) {
                strC = i60Var.e;
            }
            String str5 = strC;
            if (strC4 == null) {
                strC4 = i60Var.g;
            }
            String str6 = strC4;
            if (strC5 == null) {
                strC5 = i60Var.h;
            }
            jr2Var2.j(null, new i60(i, str3, str4, str, str5, i60Var.f, str6, strC5));
        }
        Object objN = nm0Var.n(new z4(l5Var, rv1Var), x50Var);
        return objN == t70.a ? objN : q43.a;
    }

    public final l90 l(String str, c63 c63Var, List list) {
        str.getClass();
        list.getClass();
        return new l90(1, new z9(str, this, c63Var, list, null, 6));
    }

    public final boolean m() {
        return this.g.a() != null;
    }

    public final Object n(nm0 nm0Var, f5 f5Var, bl2 bl2Var, ArrayList arrayList, boolean z, en2 en2Var) {
        Object objK = k(nm0Var, new l5(f5Var.e, e33.j, bl2Var.m().concat(" needs a permission first — I'll ask now."), f5Var, bl2Var.d(), null, null, null, new e52(arrayList, "Allow"), null, "requesting ".concat(mz.C(arrayList, null, null, null, null, 63)), 1760), new pv1(f5Var, bl2Var.d(), arrayList, z), en2Var);
        return objK == t70.a ? objK : q43.a;
    }

    public final Object o(nm0 nm0Var, String str, qv1 qv1Var, Integer num, nu2 nu2Var) {
        String str2;
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = str.toLowerCase(locale);
        lowerCase.getClass();
        boolean zContains = wh2.c("sonic", "hey sonic", "ok sonic", "okay sonic", "sonik").contains(cs2.V(lowerCase).toString());
        String str3 = qv1Var.c.b;
        if (zContains) {
            str2 = "";
        } else if (num != null && num.intValue() > 0) {
            str2 = "Please choose a number between 1 and " + num + ".";
        } else if (wh2.c("contact_name", "recipients").contains(str3)) {
            str2 = "Please repeat the contact name.";
        } else if (g31.a(str3, "message_body")) {
            str2 = "What should the message say?";
        } else {
            str2 = wh2.c("media_title", "query").contains(str3) ? "Which song?" : "Please repeat the option number.";
        }
        String str4 = str2;
        f5 f5Var = qv1Var.a;
        String str5 = qv1Var.b;
        List list = ay.a;
        Object objK = k(nm0Var, new l5(str, e33.f, str4, f5Var, str5, null, null, null, null, null, cq.j("re-asked slot ", str3), 1984), qv1Var, nu2Var);
        return objK == t70.a ? objK : q43.a;
    }

    public final Object p(nm0 nm0Var, f5 f5Var, g53 g53Var, bl2 bl2Var, y50 y50Var) {
        if (bl2Var != null) {
            bl2Var.f();
        }
        this.g.b();
        Object objK = k(nm0Var, new l5(f5Var.e, e33.c, "I couldn't convert that text to English letters, so I haven't entered or sent it. Please dictate it in English letters.", f5Var, bl2Var != null ? bl2Var.d() : null, null, null, null, null, null, cq.j("Outbound text conversion failed: ", g53Var.getMessage()), 2016), null, y50Var);
        return objK == t70.a ? objK : q43.a;
    }
}
