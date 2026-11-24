package defpackage;

import com.ibm.icu.text.BreakIterator;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rc0 implements o21 {
    public static final x42 A;
    public static final List B;
    public static final x42 d = new x42("^(?:(?:(?:turn|switch)\\s+)?(?:on|off|enable|disable|start|stop|activate|deactivate|toggle|jala|jalao|jale|bujha|bujhao|band|chalu|shuru|suru|सुरू|चालू)\\s+(?:(?:the|my|मेरी|मेरा)\\s+)?(?:flashlight|flash light|torch|flash)|(?:(?:turn|switch)\\s+)?(?:(?:the|my|मेरी|मेरा)\\s+)?(?:flashlight|flash light|torch|flash)(?:\\s+(?:(?:turn|switch)\\s+)?(?:on|off|enable|disable|start|stop|activate|deactivate|toggle|jala|jalao|jale|bujha|bujhao|band|chalu|shuru|suru|सुरू|चालू))?)$");
    public static final x42 e = new x42("\\b(toggle)\\b");
    public static final x42 f;
    public static final x42 g;
    public static final x42 h;
    public static final x42 i;
    public static final x42 j;
    public static final x42 k;
    public static final x42 l;
    public static final x42 m;
    public static final x42 n;
    public static final x42 o;
    public static final x42 p;
    public static final x42 q;
    public static final x42 r;
    public static final x42 s;
    public static final x42 t;
    public static final x42 u;
    public static final x42 v;
    public static final x42 w;
    public static final x42 x;
    public static final x42 y;
    public static final x42 z;
    public final e40 a;
    public final String b;
    public final int c;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        f = new x42("\\b(switch\\s+to|go\\s+to|open|navigate\\s+to)\\b", y42Var);
        g = new x42("(?:(?:and|now|then)\\s+)?(?:(?:turn|switch)\\s+(?:it|this|that)\\s+(?:back\\s+)?(?:on|off)|(?:enable|disable|activate|deactivate)\\s+(?:it|this|that))(?:\\s+again)?", y42Var);
        h = new x42("\\b(?:turn|switch)\\s+(?:[\\p{L}\\p{N}\\p{Pd}]+\\s+){0,4}?(on|off)\\b", y42Var);
        i = new x42("(?:^|\\s|\\b)(on|enable|start|activate|jala|jalao|chalao|jale|chalu|shuru|suru|surcha|सुरू|चालू|connect)(?:\\s|\\b|$)", y42Var);
        j = new x42("(?:^|\\s|\\b)(off|disable|deactivate|stop|bujha|bujhao|band|बंद|disconnect)(?:\\s|\\b|$)", y42Var);
        k = new x42("\\b(volume|sound|audio)\\b");
        l = new x42("(?:volume|sound)\\D{0,12}?(\\d{1,3})|(?:^|\\s)(\\d{1,3})\\s*(?:percent|%)\\s*volume");
        m = new x42("brightness\\D{0,12}?(\\d{1,3})|(\\d{1,3})\\s*(?:percent|%)\\s*brightness");
        n = new x42("\\b(?:maximum|max|full|100%?)\\s+(?:screen\\s+)?brightness\\b|\\b(?:screen\\s+)?brightness\\s+(?:to\\s+)?(?:100%?|max|maximum|full)\\b");
        o = new x42("\\b(?:minimum|min|lowest|0%?)\\s+(?:screen\\s+)?brightness\\b|\\b(?:screen\\s+)?brightness\\s+(?:to\\s+)?(?:0%?|min|minimum|lowest)\\b");
        p = new x42("\\b(?:increase|turn\\s+up|raise|make\\s+brighter|brighter)\\s+(?:the\\s+)?(?:screen\\s+)?brightness\\b|\\b(?:make\\s+)?screen\\s+brighter\\b|\\bbrighter\\b");
        q = new x42("\\b(?:decrease|turn\\s+down|lower|dim|make\\s+dimmer|dimmer)\\s+(?:the\\s+)?(?:screen\\s+)?brightness\\b|\\b(?:dim|make\\s+dimmer)\\s+(?:the\\s+)?screen\\b|\\bdimmer\\b");
        r = new x42("\\b(unmute|un mute)\\b");
        s = new x42("\\b(mute|silence)\\b", y42Var);
        t = new x42("^(?:wake\\s+up(?:\\s+sonic)?|sonic\\s+wake\\s+up|wake\\s+sonic)$", y42Var);
        u = new x42("\\b(up|increase|raise|louder|higher|more|badha|badhao)\\b");
        v = new x42("\\b(down|decrease|lower|quieter|softer|less|reduce|ghata|ghatao)\\b");
        w = new x42("\\b(louder|quieter|softer|turn it up|turn it down)\\b");
        x = new x42("\\b(battery|charge level|charging|how much charge)\\b");
        y = new x42("\\block\\b.*\\b(phone|screen|device|mobile)\\b|\\block\\s*(?:it)?$|^lock$");
        z = new x42("\\b(screenshot|screen shot|capture(?: the)? screen|screen capture)\\b");
        A = new x42("\\b(?:open|show|go to|launch)\\s+(?:the\\s+)?settings\\b|^settings$");
        B = nz.i(new wt1(new x42("(?:^|\\s|\\b)(wi[\\s\\p{Pd}]*fi|wireless network|वायफाय|वाईफाई)(?:\\s|\\b|$)", y42Var), "wifi"), new wt1(new x42("(?:^|\\s|\\b)(blue[\\s\\p{Pd}]*tooth|ब्लूटूथ)(?:\\s|\\b|$)", y42Var), "bluetooth"), new wt1(new x42("\\b(airplane|aeroplane|flight)\\s*mode\\b"), "airplane"), new wt1(new x42("\\b(mobile data|cellular data|data usage)\\b"), "mobile_data"), new wt1(new x42("\\b(hotspot|tethering)\\b"), "hotspot"), new wt1(new x42("\\bnfc\\b"), "nfc"), new wt1(new x42("\\b(location|gps)\\s+(?:settings|services|on|off)\\b"), "location"), new wt1(new x42("\\bnotification\\s+settings\\b"), "notifications"), new wt1(new x42("\\baccessibility\\s+settings\\b"), "accessibility"), new wt1(new x42("\\b(storage|space)\\s+settings\\b"), "storage"), new wt1(new x42("\\bsecurity\\s+settings\\b"), "security"), new wt1(new x42("\\bdeveloper\\s+(?:options|settings)\\b"), "developer"), new wt1(new x42("\\b(date|time)\\s+settings\\b"), "date_time"), new wt1(new x42("\\b(app|application)\\s+settings\\b"), "apps"), new wt1(new x42("\\bsound\\s+settings\\b"), "sound"), new wt1(new x42("\\bdisplay\\s+settings\\b"), "display"));
    }

    public rc0(e40 e40Var) {
        e40Var.getClass();
        this.a = e40Var;
        this.b = "device";
        this.c = BreakIterator.WORD_IDEO_LIMIT;
    }

    public static Boolean d(String str) {
        h21 h21VarB;
        h21 h21VarB2;
        fh1 fh1Var = (fh1) zg2.e(x42.c(h, str));
        if (fh1Var != null) {
            return Boolean.valueOf(js2.f((String) ((dh1) fh1Var.a()).get(1), "on"));
        }
        fh1 fh1Var2 = (fh1) zg2.e(x42.c(i, str));
        int i2 = -1;
        int i3 = (fh1Var2 == null || (h21VarB2 = fh1Var2.b()) == null) ? -1 : h21VarB2.a;
        fh1 fh1Var3 = (fh1) zg2.e(x42.c(j, str));
        if (fh1Var3 != null && (h21VarB = fh1Var3.b()) != null) {
            i2 = h21VarB.a;
        }
        if (i3 >= 0 || i2 >= 0) {
            return Boolean.valueOf(i3 > i2);
        }
        return null;
    }

    @Override // defpackage.o21
    public final int a() {
        return this.c;
    }

    @Override // defpackage.o21
    public final String b() {
        return this.b;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x023e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0252  */
    /* JADX WARN: Code duplicated, block: B:109:0x025a  */
    /* JADX WARN: Code duplicated, block: B:110:0x025c  */
    /* JADX WARN: Code duplicated, block: B:112:0x0264  */
    /* JADX WARN: Code duplicated, block: B:115:0x0291  */
    /* JADX WARN: Code duplicated, block: B:119:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:121:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:122:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:124:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:125:0x02cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:127:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:142:0x0301  */
    /* JADX WARN: Code duplicated, block: B:143:0x0303  */
    /* JADX WARN: Code duplicated, block: B:145:0x0306  */
    /* JADX WARN: Code duplicated, block: B:147:0x030e  */
    /* JADX WARN: Code duplicated, block: B:149:0x0316  */
    /* JADX WARN: Code duplicated, block: B:150:0x0318  */
    /* JADX WARN: Code duplicated, block: B:152:0x0320  */
    /* JADX WARN: Code duplicated, block: B:153:0x0322 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:154:0x0324  */
    /* JADX WARN: Code duplicated, block: B:155:0x0327  */
    /* JADX WARN: Code duplicated, block: B:170:0x0355  */
    /* JADX WARN: Code duplicated, block: B:171:0x0357  */
    /* JADX WARN: Code duplicated, block: B:172:0x0359  */
    /* JADX WARN: Code duplicated, block: B:185:0x037b  */
    /* JADX WARN: Code duplicated, block: B:190:0x0389  */
    /* JADX WARN: Code duplicated, block: B:192:0x03a1 A[LOOP:0: B:113:0x0279->B:192:0x03a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:195:0x03c0 A[EDGE_INSN: B:195:0x03c0->B:197:0x03d2 BREAK  A[LOOP:0: B:113:0x0279->B:192:0x03a1]] */
    /* JADX WARN: Code duplicated, block: B:196:0x03d0 A[EDGE_INSN: B:196:0x03d0->B:197:0x03d2 BREAK  A[LOOP:0: B:113:0x0279->B:192:0x03a1]] */
    /* JADX WARN: Code duplicated, block: B:198:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:206:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:208:0x03f6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:210:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:211:0x03fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:212:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:213:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:218:0x03ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:219:0x02a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0138  */
    /* JADX WARN: Code duplicated, block: B:61:0x015b  */
    /* JADX WARN: Code duplicated, block: B:63:0x015e  */
    /* JADX WARN: Code duplicated, block: B:65:0x016f  */
    /* JADX WARN: Code duplicated, block: B:66:0x017e  */
    /* JADX WARN: Code duplicated, block: B:68:0x0186  */
    /* JADX WARN: Code duplicated, block: B:69:0x0195  */
    /* JADX WARN: Code duplicated, block: B:77:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:79:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:80:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:82:0x01db  */
    /* JADX WARN: Code duplicated, block: B:83:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x0201  */
    /* JADX WARN: Code duplicated, block: B:88:0x0204  */
    /* JADX WARN: Code duplicated, block: B:90:0x020e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0210  */
    /* JADX WARN: Code duplicated, block: B:97:0x0227  */
    /* JADX WARN: Code duplicated, block: B:99:0x0236  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.o21
    public final f5 c(b63 b63Var, i60 i60Var) {
        boolean z2;
        String lowerCase;
        fh1 fh1VarB;
        Integer numA;
        int iIntValue;
        String lowerCase2;
        Boolean boolD;
        boolean zA;
        Iterator it;
        boolean zHasNext;
        String str;
        f5 f5Var;
        e40 e40Var;
        boolean z3;
        b63 b63Var2;
        f5 f5VarD;
        Boolean boolD2;
        boolean zBooleanValue;
        d40 d40VarA;
        String str2;
        x42 x42Var;
        String str3;
        boolean zA2;
        x42 x42Var2;
        String str4;
        String str5;
        Boolean bool;
        String str6;
        d40 d40VarA2;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        d40 d40VarA3;
        Boolean bool5;
        Integer numA2;
        int iIntValue2;
        i60Var.getClass();
        String string = cs2.V(b63Var.a).toString();
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, string, locale);
        Pattern patternCompile = Pattern.compile("^(?:type|write|enter|input|draft)\\b", 66);
        patternCompile.getClass();
        Pattern patternCompile2 = Pattern.compile("\\b(?:type|write|input|draft|लिखो|लिहो|लिखें|टाइप|લખો|ટાઇપ|টাইপ|டைப்|લીહો)\\s*(?:kar|karo|कर|करो)?$", 66);
        patternCompile2.getClass();
        f5 f5Var2 = null;
        if (patternCompile.matcher(strO).find() || patternCompile2.matcher(strO).find()) {
            return null;
        }
        String str7 = b63Var.c;
        String lowerCase3 = str7.toLowerCase(locale);
        lowerCase3.getClass();
        f5 f5VarD2 = t.a(cs2.V(lowerCase3).toString()) ? dp4.d(b63Var, "assistant.wake_up", null, 0.99f, 10) : null;
        if (f5VarD2 == null) {
            boolean zE = d.e(dp4.b(str7));
            x42 x42Var3 = e;
            if (!zE) {
                f5VarD2 = null;
            } else if (x42Var3.a(str7)) {
                f5VarD2 = dp4.d(b63Var, "device.flashlight.toggle", null, 0.99f, 10);
            } else if (j.a(str7)) {
                f5VarD2 = dp4.d(b63Var, "device.flashlight.off", null, 0.99f, 10);
            } else {
                f5VarD2 = i.a(str7) ? dp4.d(b63Var, "device.flashlight.on", null, 0.99f, 10) : dp4.d(b63Var, "device.flashlight.toggle", null, 0.75f, 10);
            }
            if (f5VarD2 == null) {
                fh1 fh1VarB2 = x42.b(l, str7);
                if (fh1VarB2 != null && (numA2 = dp4.a(fh1VarB2)) != null && (iIntValue2 = numA2.intValue()) >= 0 && iIntValue2 < 101) {
                    Map mapSingletonMap = Collections.singletonMap("level_percent", String.valueOf(iIntValue2));
                    mapSingletonMap.getClass();
                    f5VarD2 = dp4.d(b63Var, "device.volume.set", mapSingletonMap, 0.99f, 8);
                } else if (r.a(str7)) {
                    f5VarD2 = dp4.d(b63Var, "device.volume.up", null, 0.75f, 10);
                } else {
                    if (s.a(str7)) {
                        f5VarD2 = dp4.d(b63Var, "device.volume.mute", null, 0.99f, 10);
                    } else {
                        boolean zA3 = k.a(str7);
                        z2 = false;
                        if (zA3 || w.a(str7)) {
                            if (u.a(str7)) {
                                f5VarD2 = dp4.d(b63Var, "device.volume.up", null, zA3 ? 0.99f : 0.75f, 10);
                            } else if (v.a(str7)) {
                                f5VarD2 = dp4.d(b63Var, "device.volume.down", null, zA3 ? 0.99f : 0.75f, 10);
                            } else if (zA3 || cs2.N(str7, new char[]{' '}, 6).size() > 2) {
                                f5VarD2 = null;
                            } else {
                                Map mapSingletonMap2 = Collections.singletonMap("settings_page", "sound");
                                mapSingletonMap2.getClass();
                                f5VarD2 = dp4.d(b63Var, "device.settings.open", mapSingletonMap2, 0.75f, 8);
                            }
                        } else if (zA3) {
                            f5VarD2 = null;
                        } else {
                            f5VarD2 = null;
                        }
                    }
                    if (f5VarD2 == null) {
                        lowerCase = str7.toLowerCase(locale);
                        lowerCase.getClass();
                        if (n.a(lowerCase)) {
                            Map mapSingletonMap3 = Collections.singletonMap("level_percent", "100");
                            mapSingletonMap3.getClass();
                            f5VarD2 = dp4.d(b63Var, "device.brightness.set", mapSingletonMap3, 0.99f, 8);
                        } else if (o.a(lowerCase)) {
                            Map mapSingletonMap4 = Collections.singletonMap("level_percent", "0");
                            mapSingletonMap4.getClass();
                            f5VarD2 = dp4.d(b63Var, "device.brightness.set", mapSingletonMap4, 0.99f, 8);
                        } else {
                            fh1VarB = x42.b(m, lowerCase);
                            if (fh1VarB == null && (numA = dp4.a(fh1VarB)) != null && (iIntValue = numA.intValue()) >= 0 && iIntValue < 101) {
                                Map mapSingletonMap5 = Collections.singletonMap("level_percent", String.valueOf(iIntValue));
                                mapSingletonMap5.getClass();
                                f5VarD2 = dp4.d(b63Var, "device.brightness.set", mapSingletonMap5, 0.99f, 8);
                            } else if (p.a(lowerCase)) {
                                Map mapSingletonMap6 = Collections.singletonMap("direction", "up");
                                mapSingletonMap6.getClass();
                                f5VarD2 = dp4.d(b63Var, "device.brightness.set", mapSingletonMap6, 0.99f, 8);
                            } else if (q.a(lowerCase)) {
                                Map mapSingletonMap7 = Collections.singletonMap("direction", "down");
                                mapSingletonMap7.getClass();
                                f5VarD2 = dp4.d(b63Var, "device.brightness.set", mapSingletonMap7, 0.99f, 8);
                            } else if (cs2.n(lowerCase, "brightness", z2)) {
                                Map mapSingletonMap8 = Collections.singletonMap("settings_page", "display");
                                mapSingletonMap8.getClass();
                                f5VarD2 = dp4.d(b63Var, "device.settings.open", mapSingletonMap8, 0.75f, 8);
                            } else {
                                f5VarD2 = null;
                            }
                        }
                        if (f5VarD2 == null) {
                            if (!x.a(str7)) {
                                f5VarD2 = null;
                            } else if (!cs2.n(str7, "settings", false) || cs2.n(str7, "saver", false)) {
                                Map mapSingletonMap9 = Collections.singletonMap("settings_page", "battery");
                                mapSingletonMap9.getClass();
                                f5VarD2 = dp4.d(b63Var, "device.settings.open", mapSingletonMap9, 0.99f, 8);
                            } else {
                                f5VarD2 = dp4.d(b63Var, "device.battery.status", null, 0.99f, 10);
                            }
                            if (f5VarD2 == null) {
                                if (y.a(str7) || cs2.n(str7, "unlock", false)) {
                                    f5VarD2 = null;
                                } else {
                                    f5VarD2 = dp4.d(b63Var, "device.lock", null, 0.99f, 10);
                                }
                                if (f5VarD2 == null) {
                                    if (z.a(str7)) {
                                        f5VarD2 = dp4.d(b63Var, "device.screenshot", null, 0.99f, 10);
                                    } else {
                                        f5VarD2 = null;
                                    }
                                    if (f5VarD2 == null) {
                                        lowerCase2 = str7.toLowerCase(locale);
                                        lowerCase2.getClass();
                                        boolD = d(lowerCase2);
                                        zA = x42Var3.a(str7);
                                        it = B.iterator();
                                        while (true) {
                                            zHasNext = it.hasNext();
                                            str = "device.wifi.enable";
                                            f5Var = f5Var2;
                                            e40Var = this.a;
                                            z3 = zA;
                                            if (zHasNext) {
                                                b63Var2 = b63Var;
                                                if (A.a(str7)) {
                                                    f5VarD = f5Var;
                                                    break;
                                                }
                                                Map mapSingletonMap10 = Collections.singletonMap("settings_page", "general");
                                                mapSingletonMap10.getClass();
                                                f5VarD = dp4.d(b63Var2, "device.settings.open", mapSingletonMap10, 0.99f, 8);
                                                break;
                                            }
                                            wt1 wt1Var = (wt1) it.next();
                                            x42Var = (x42) wt1Var.a;
                                            str3 = (String) wt1Var.b;
                                            if (x42Var.a(str7)) {
                                                zA2 = g31.a(str3, "wifi");
                                                x42Var2 = f;
                                                if (zA2) {
                                                    str4 = str7;
                                                    bool4 = Boolean.TRUE;
                                                    if (g31.a(boolD, bool4)) {
                                                        str5 = "device.wifi.enable";
                                                    } else if (g31.a(boolD, Boolean.FALSE)) {
                                                        str5 = "device.wifi.disable";
                                                    } else if (z3) {
                                                        str5 = "device.wifi.toggle";
                                                    } else {
                                                        str6 = "device.wifi.settings";
                                                        if (!x42Var2.a(lowerCase2) && !cs2.n(lowerCase2, "settings", false) && !cs2.n(lowerCase2, "open", false) && (d40VarA3 = e40Var.a()) != null && d40VarA3.a.equals("bluetooth") && (bool5 = d40VarA3.b) != null) {
                                                            if (bool5.equals(bool4)) {
                                                                str6 = "device.wifi.enable";
                                                            } else {
                                                                str6 = "device.wifi.disable";
                                                            }
                                                        }
                                                        str5 = str6;
                                                    }
                                                } else {
                                                    str4 = str7;
                                                    if (g31.a(str3, "bluetooth")) {
                                                        bool = Boolean.TRUE;
                                                        if (g31.a(boolD, bool)) {
                                                            str5 = "device.bluetooth.enable";
                                                        } else if (g31.a(boolD, Boolean.FALSE)) {
                                                            str5 = "device.bluetooth.disable";
                                                        } else if (z3) {
                                                            str5 = "device.bluetooth.toggle";
                                                        } else {
                                                            str6 = "device.bluetooth.settings";
                                                            if (!x42Var2.a(lowerCase2) && !cs2.n(lowerCase2, "settings", false) && !cs2.n(lowerCase2, "open", false) && (d40VarA2 = e40Var.a()) != null && d40VarA2.a.equals("wifi") && (bool2 = d40VarA2.b) != null) {
                                                                if (bool2.equals(bool)) {
                                                                    str6 = "device.bluetooth.enable";
                                                                } else {
                                                                    str6 = "device.bluetooth.disable";
                                                                }
                                                            }
                                                            str5 = str6;
                                                        }
                                                    } else {
                                                        str5 = "device.settings.open";
                                                    }
                                                }
                                                if (!str5.equals("device.wifi.enable") || str5.equals("device.bluetooth.enable")) {
                                                    bool3 = Boolean.TRUE;
                                                } else {
                                                    bool3 = (str5.equals("device.wifi.disable") || str5.equals("device.bluetooth.disable")) ? Boolean.FALSE : f5Var;
                                                }
                                                if (g31.a(str3, "wifi") || g31.a(str3, "bluetooth")) {
                                                    e40Var.b(str3, bool3);
                                                }
                                                Map mapSingletonMap11 = Collections.singletonMap("settings_page", str3);
                                                mapSingletonMap11.getClass();
                                                b63Var2 = b63Var;
                                                f5VarD = dp4.d(b63Var2, str5, mapSingletonMap11, 0.99f, 8);
                                                str7 = str4;
                                                break;
                                            }
                                            f5Var2 = f5Var;
                                            zA = z3;
                                        }
                                        if (f5VarD == null) {
                                            return f5VarD;
                                        }
                                        if (g.e(str7) || (boolD2 = d(str7)) == null) {
                                            return f5Var;
                                        }
                                        zBooleanValue = boolD2.booleanValue();
                                        d40VarA = e40Var.a();
                                        if (d40VarA == null) {
                                            return f5Var;
                                        }
                                        str2 = d40VarA.a;
                                        if (str2.equals("wifi")) {
                                            if (!zBooleanValue) {
                                                str = "device.wifi.disable";
                                            }
                                        } else if (zBooleanValue) {
                                            str = "device.bluetooth.enable";
                                        } else {
                                            str = "device.bluetooth.disable";
                                        }
                                        e40Var.b(str2, boolD2);
                                        Map mapSingletonMap12 = Collections.singletonMap("settings_page", str2);
                                        mapSingletonMap12.getClass();
                                        return dp4.d(b63Var2, str, mapSingletonMap12, 0.9f, 8);
                                    }
                                }
                            }
                        }
                    }
                }
                z2 = false;
                if (f5VarD2 == null) {
                    lowerCase = str7.toLowerCase(locale);
                    lowerCase.getClass();
                    if (n.a(lowerCase)) {
                        Map mapSingletonMap13 = Collections.singletonMap("level_percent", "100");
                        mapSingletonMap13.getClass();
                        f5VarD2 = dp4.d(b63Var, "device.brightness.set", mapSingletonMap13, 0.99f, 8);
                    } else if (o.a(lowerCase)) {
                        Map mapSingletonMap14 = Collections.singletonMap("level_percent", "0");
                        mapSingletonMap14.getClass();
                        f5VarD2 = dp4.d(b63Var, "device.brightness.set", mapSingletonMap14, 0.99f, 8);
                    } else {
                        fh1VarB = x42.b(m, lowerCase);
                        if (fh1VarB == null) {
                            if (p.a(lowerCase)) {
                                Map mapSingletonMap15 = Collections.singletonMap("direction", "up");
                                mapSingletonMap15.getClass();
                                f5VarD2 = dp4.d(b63Var, "device.brightness.set", mapSingletonMap15, 0.99f, 8);
                            } else if (q.a(lowerCase)) {
                                Map mapSingletonMap16 = Collections.singletonMap("direction", "down");
                                mapSingletonMap16.getClass();
                                f5VarD2 = dp4.d(b63Var, "device.brightness.set", mapSingletonMap16, 0.99f, 8);
                            } else if (cs2.n(lowerCase, "brightness", z2)) {
                                Map mapSingletonMap17 = Collections.singletonMap("settings_page", "display");
                                mapSingletonMap17.getClass();
                                f5VarD2 = dp4.d(b63Var, "device.settings.open", mapSingletonMap17, 0.75f, 8);
                            } else {
                                f5VarD2 = null;
                            }
                        } else if (p.a(lowerCase)) {
                            Map mapSingletonMap18 = Collections.singletonMap("direction", "up");
                            mapSingletonMap18.getClass();
                            f5VarD2 = dp4.d(b63Var, "device.brightness.set", mapSingletonMap18, 0.99f, 8);
                        } else if (q.a(lowerCase)) {
                            Map mapSingletonMap19 = Collections.singletonMap("direction", "down");
                            mapSingletonMap19.getClass();
                            f5VarD2 = dp4.d(b63Var, "device.brightness.set", mapSingletonMap19, 0.99f, 8);
                        } else if (cs2.n(lowerCase, "brightness", z2)) {
                            Map mapSingletonMap110 = Collections.singletonMap("settings_page", "display");
                            mapSingletonMap110.getClass();
                            f5VarD2 = dp4.d(b63Var, "device.settings.open", mapSingletonMap110, 0.75f, 8);
                        } else {
                            f5VarD2 = null;
                        }
                    }
                    if (f5VarD2 == null) {
                        if (!x.a(str7)) {
                            f5VarD2 = null;
                        } else if (cs2.n(str7, "settings", false)) {
                            Map mapSingletonMap20 = Collections.singletonMap("settings_page", "battery");
                            mapSingletonMap20.getClass();
                            f5VarD2 = dp4.d(b63Var, "device.settings.open", mapSingletonMap20, 0.99f, 8);
                        } else {
                            Map mapSingletonMap21 = Collections.singletonMap("settings_page", "battery");
                            mapSingletonMap21.getClass();
                            f5VarD2 = dp4.d(b63Var, "device.settings.open", mapSingletonMap21, 0.99f, 8);
                        }
                        if (f5VarD2 == null) {
                            if (y.a(str7)) {
                                f5VarD2 = null;
                            } else {
                                f5VarD2 = dp4.d(b63Var, "device.lock", null, 0.99f, 10);
                            }
                            if (f5VarD2 == null) {
                                if (z.a(str7)) {
                                    f5VarD2 = null;
                                } else {
                                    f5VarD2 = dp4.d(b63Var, "device.screenshot", null, 0.99f, 10);
                                }
                                if (f5VarD2 == null) {
                                    lowerCase2 = str7.toLowerCase(locale);
                                    lowerCase2.getClass();
                                    boolD = d(lowerCase2);
                                    zA = x42Var3.a(str7);
                                    it = B.iterator();
                                    while (true) {
                                        zHasNext = it.hasNext();
                                        str = "device.wifi.enable";
                                        f5Var = f5Var2;
                                        e40Var = this.a;
                                        z3 = zA;
                                        if (zHasNext) {
                                            b63Var2 = b63Var;
                                            if (A.a(str7)) {
                                                f5VarD = f5Var;
                                                break;
                                            }
                                            Map mapSingletonMap111 = Collections.singletonMap("settings_page", "general");
                                            mapSingletonMap111.getClass();
                                            f5VarD = dp4.d(b63Var2, "device.settings.open", mapSingletonMap111, 0.99f, 8);
                                            break;
                                        }
                                        wt1 wt1Var2 = (wt1) it.next();
                                        x42Var = (x42) wt1Var2.a;
                                        str3 = (String) wt1Var2.b;
                                        if (x42Var.a(str7)) {
                                            zA2 = g31.a(str3, "wifi");
                                            x42Var2 = f;
                                            if (zA2) {
                                                str4 = str7;
                                                bool4 = Boolean.TRUE;
                                                if (g31.a(boolD, bool4)) {
                                                    str5 = "device.wifi.enable";
                                                } else if (g31.a(boolD, Boolean.FALSE)) {
                                                    str5 = "device.wifi.disable";
                                                } else if (z3) {
                                                    str5 = "device.wifi.toggle";
                                                } else {
                                                    str6 = "device.wifi.settings";
                                                    if (!x42Var2.a(lowerCase2)) {
                                                        if (bool5.equals(bool4)) {
                                                            str6 = "device.wifi.enable";
                                                        } else {
                                                            str6 = "device.wifi.disable";
                                                        }
                                                    }
                                                    str5 = str6;
                                                }
                                            } else {
                                                str4 = str7;
                                                if (g31.a(str3, "bluetooth")) {
                                                    bool = Boolean.TRUE;
                                                    if (g31.a(boolD, bool)) {
                                                        str5 = "device.bluetooth.enable";
                                                    } else if (g31.a(boolD, Boolean.FALSE)) {
                                                        str5 = "device.bluetooth.disable";
                                                    } else if (z3) {
                                                        str5 = "device.bluetooth.toggle";
                                                    } else {
                                                        str6 = "device.bluetooth.settings";
                                                        if (!x42Var2.a(lowerCase2)) {
                                                            if (bool2.equals(bool)) {
                                                                str6 = "device.bluetooth.enable";
                                                            } else {
                                                                str6 = "device.bluetooth.disable";
                                                            }
                                                        }
                                                        str5 = str6;
                                                    }
                                                } else {
                                                    str5 = "device.settings.open";
                                                }
                                            }
                                            if (str5.equals("device.wifi.enable")) {
                                                bool3 = Boolean.TRUE;
                                            } else {
                                                bool3 = Boolean.TRUE;
                                            }
                                            if (g31.a(str3, "wifi")) {
                                                e40Var.b(str3, bool3);
                                            } else {
                                                e40Var.b(str3, bool3);
                                            }
                                            Map mapSingletonMap112 = Collections.singletonMap("settings_page", str3);
                                            mapSingletonMap112.getClass();
                                            b63Var2 = b63Var;
                                            f5VarD = dp4.d(b63Var2, str5, mapSingletonMap112, 0.99f, 8);
                                            str7 = str4;
                                            break;
                                        }
                                        f5Var2 = f5Var;
                                        zA = z3;
                                    }
                                    if (f5VarD == null) {
                                        return f5VarD;
                                    }
                                    if (g.e(str7)) {
                                        return f5Var;
                                    }
                                    zBooleanValue = boolD2.booleanValue();
                                    d40VarA = e40Var.a();
                                    if (d40VarA == null) {
                                        return f5Var;
                                    }
                                    str2 = d40VarA.a;
                                    if (str2.equals("wifi")) {
                                        if (!zBooleanValue) {
                                            str = "device.wifi.disable";
                                        }
                                    } else if (zBooleanValue) {
                                        str = "device.bluetooth.enable";
                                    } else {
                                        str = "device.bluetooth.disable";
                                    }
                                    e40Var.b(str2, boolD2);
                                    Map mapSingletonMap113 = Collections.singletonMap("settings_page", str2);
                                    mapSingletonMap113.getClass();
                                    return dp4.d(b63Var2, str, mapSingletonMap113, 0.9f, 8);
                                }
                            }
                        }
                    }
                }
            }
        }
        return f5VarD2;
    }

    public rc0() {
        this(new e40());
    }
}
