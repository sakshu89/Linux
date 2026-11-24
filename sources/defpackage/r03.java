package defpackage;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r03 implements o21 {
    public static final x42 a = new x42("^(?:(?:hey|ok|okay)\\s+)?(?:sonic|sonik)\\b\\s*[,.:]?\\s*");
    public static final x42 b = new x42("^remind\\s+me\\s+(?:to\\s+)?(.+?)\\s+(?:at|by|on)\\s+(.+)$");
    public static final x42 c = new x42("^remind\\s+me\\s+(?:to\\s+)?(.+?)\\s+in\\s+(.+)$");
    public static final x42 d = new x42("^remind\\s+me\\s+(?:to\\s+|about\\s+)?(.+)$");
    public static final x42 e = new x42("(?:\\b(?:set|start|add|create|begin|chalu|laga|lagao|karo|do)\\b.*\\b(?:timer|countdown)\\b|\\b(?:timer|countdown)\\b|(?:(?:\\d+|one|an?)(?:\\s+|-)(?:seconds?|secs?|minutes?|mins?|hours?|hrs?|ghante?|ghanta)\\b.*\\b(?:timer|countdown)\\b))", y42.IGNORE_CASE);
    public static final x42 f = new x42("^(?:(?:set|add|create|schedule)\\b.*\\balarm\\b|alarm(?:\\s|$)|wake\\s+me(?:\\s+up)?(?:\\s|$))");
    public static final x42 g = new x42("\\b(?:cancel|stop|delete|remove|dismiss|disable|not|dont|don't|nahi|nahin|nako|naka|mat|band)\\b");
    public static final x42 h = new x42("(?:(?:\\d{1,2}(?:[:.]\\d{1,2})?|[ap]\\.?\\s*m\\.?|at|for|the|me|my|mujhe|mala|morning|evening|night|afternoon|subah|shaam|sham|raat|ratri|sakali|sakaali|sandhyakali|sayankali|oclock|baje|vajta|ka|ki|ke|ko|cha|chi|che)\\s*)+");
    public static final x42 i = new x42("(?:(?:set|lagao|laga|lav|lava|laav|karo|kar|do|please|chahiye|hava|pahije)\\s*)*");
    public static final x42 j = new x42("\\b(my (?:calendar|schedule|agenda)|whats on my (?:calendar|schedule|agenda)|calendar today|todays (?:events|schedule|meetings)|any meetings today|whats my (?:day|schedule) look like)\\b");
    public static final x42 k = new x42("\\b(add .* to (?:my )?calendar|create an? event|schedule a (?:meeting|call|event)|new calendar event|put .* on my calendar)\\b");

    @Override // defpackage.o21
    public final int a() {
        return 800;
    }

    @Override // defpackage.o21
    public final String b() {
        return "time";
    }

    /* JADX WARN: Code duplicated, block: B:14:0x007a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0082  */
    /* JADX WARN: Code duplicated, block: B:18:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:20:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:23:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:24:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:26:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:28:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:31:0x00f5  */
    @Override // defpackage.o21
    public final f5 c(b63 b63Var, i60 i60Var) {
        fh1 fh1VarA;
        fh1 fh1VarA2;
        f5 f5VarD;
        String strB;
        String strB2;
        Integer numC;
        rg1 rg1Var;
        float f2;
        f5 f5VarD2;
        i60Var.getClass();
        x42 x42Var = s03.a;
        String str = b63Var.b;
        str.getClass();
        String string = cs2.V(a.f(s03.a(str), "")).toString();
        fh1 fh1VarA3 = b63Var.a(b);
        if (fh1VarA3 != null) {
            String strB3 = dp4.b((String) ((dh1) fh1VarA3.a()).get(1));
            String strB4 = s03.b((String) ((dh1) fh1VarA3.a()).get(2));
            if (cs2.A(strB3)) {
                fh1VarA = b63Var.a(c);
                if (fh1VarA != null) {
                    strB2 = dp4.b((String) ((dh1) fh1VarA.a()).get(1));
                    numC = s03.c((String) ((dh1) fh1VarA.a()).get(2));
                    if (cs2.A(strB2)) {
                        fh1VarA2 = b63Var.a(d);
                        if (fh1VarA2 != null) {
                            strB = dp4.b((String) ((dh1) fh1VarA2.a()).get(1));
                            if (cs2.A(strB)) {
                                f5VarD = null;
                            } else {
                                Map mapSingletonMap = Collections.singletonMap("label", strB);
                                mapSingletonMap.getClass();
                                f5VarD = dp4.d(b63Var, "time.reminder.create", mapSingletonMap, 0.75f, 8);
                            }
                        } else {
                            f5VarD = null;
                        }
                    } else {
                        rg1Var = new rg1();
                        rg1Var.put("label", strB2);
                        if (numC != null) {
                            rg1Var.put("duration_seconds", String.valueOf(numC.intValue()));
                        }
                        rg1 rg1VarB = rg1Var.b();
                        if (numC != null) {
                            f2 = 0.9f;
                        } else {
                            f2 = 0.75f;
                        }
                        f5VarD = dp4.d(b63Var, "time.reminder.create", rg1VarB, f2, 8);
                    }
                } else {
                    fh1VarA2 = b63Var.a(d);
                    if (fh1VarA2 != null) {
                        strB = dp4.b((String) ((dh1) fh1VarA2.a()).get(1));
                        if (cs2.A(strB)) {
                            Map mapSingletonMap2 = Collections.singletonMap("label", strB);
                            mapSingletonMap2.getClass();
                            f5VarD = dp4.d(b63Var, "time.reminder.create", mapSingletonMap2, 0.75f, 8);
                        } else {
                            f5VarD = null;
                        }
                    } else {
                        f5VarD = null;
                    }
                }
            } else {
                rg1 rg1Var2 = new rg1();
                rg1Var2.put("label", strB3);
                if (strB4 != null) {
                    rg1Var2.put("date_time", strB4);
                }
                f5VarD = dp4.d(b63Var, "time.reminder.create", rg1Var2.b(), strB4 != null ? 0.9f : 0.75f, 8);
            }
        } else {
            fh1VarA = b63Var.a(c);
            if (fh1VarA != null) {
                strB2 = dp4.b((String) ((dh1) fh1VarA.a()).get(1));
                numC = s03.c((String) ((dh1) fh1VarA.a()).get(2));
                if (cs2.A(strB2)) {
                    rg1Var = new rg1();
                    rg1Var.put("label", strB2);
                    if (numC != null) {
                        rg1Var.put("duration_seconds", String.valueOf(numC.intValue()));
                    }
                    rg1 rg1VarB2 = rg1Var.b();
                    if (numC != null) {
                        f2 = 0.9f;
                    } else {
                        f2 = 0.75f;
                    }
                    f5VarD = dp4.d(b63Var, "time.reminder.create", rg1VarB2, f2, 8);
                } else {
                    fh1VarA2 = b63Var.a(d);
                    if (fh1VarA2 != null) {
                        strB = dp4.b((String) ((dh1) fh1VarA2.a()).get(1));
                        if (cs2.A(strB)) {
                            Map mapSingletonMap3 = Collections.singletonMap("label", strB);
                            mapSingletonMap3.getClass();
                            f5VarD = dp4.d(b63Var, "time.reminder.create", mapSingletonMap3, 0.75f, 8);
                        } else {
                            f5VarD = null;
                        }
                    } else {
                        f5VarD = null;
                    }
                }
            } else {
                fh1VarA2 = b63Var.a(d);
                if (fh1VarA2 != null) {
                    strB = dp4.b((String) ((dh1) fh1VarA2.a()).get(1));
                    if (cs2.A(strB)) {
                        Map mapSingletonMap4 = Collections.singletonMap("label", strB);
                        mapSingletonMap4.getClass();
                        f5VarD = dp4.d(b63Var, "time.reminder.create", mapSingletonMap4, 0.75f, 8);
                    } else {
                        f5VarD = null;
                    }
                } else {
                    f5VarD = null;
                }
            }
        }
        if (f5VarD == null) {
            boolean zA = e.a(string);
            x42 x42Var2 = g;
            if (!zA || x42Var2.a(string)) {
                f5VarD = null;
            } else {
                Integer numC2 = s03.c(str);
                rg1 rg1Var3 = new rg1();
                if (numC2 != null) {
                    rg1Var3.put("duration_seconds", String.valueOf(numC2.intValue()));
                }
                f5VarD = dp4.d(b63Var, "time.timer.set", rg1Var3.b(), numC2 != null ? 0.99f : 0.75f, 8);
            }
            if (f5VarD == null) {
                if (x42Var2.a(string)) {
                    f5VarD2 = null;
                } else {
                    if (!f.a(string)) {
                        Pattern patternCompile = Pattern.compile("\\balarm\\b");
                        patternCompile.getClass();
                        Matcher matcher = patternCompile.matcher(string);
                        matcher.getClass();
                        fh1 fh1VarA4 = ty3.a(matcher, 0, string);
                        if (fh1VarA4 != null) {
                            String string2 = cs2.V(string.substring(0, fh1VarA4.b().a)).toString();
                            String string3 = cs2.V(string.substring(fh1VarA4.b().b + 1)).toString();
                            if (string2.length() <= 0 || !h.e(string2) || !i.e(string3)) {
                            }
                        }
                        f5VarD2 = null;
                    }
                    Pattern patternCompile2 = Pattern.compile("\\bin\\s+.+\\b(?:seconds?|secs?|minutes?|mins?|hours?|hrs?)\\b");
                    patternCompile2.getClass();
                    String strB5 = patternCompile2.matcher(string).find() ? null : s03.b(str);
                    rg1 rg1Var4 = new rg1();
                    if (strB5 != null) {
                        rg1Var4.put("date_time", strB5);
                    }
                    f5VarD2 = dp4.d(b63Var, "time.alarm.set", rg1Var4.b(), strB5 != null ? 0.99f : 0.75f, 8);
                }
                if (f5VarD2 != null) {
                    return f5VarD2;
                }
                if (k.a(string)) {
                    return dp4.d(b63Var, "calendar.create", null, 0.9f, 10);
                }
                if (j.a(string)) {
                    return dp4.d(b63Var, "calendar.today", null, 0.9f, 10);
                }
                return null;
            }
        }
        return f5VarD;
    }
}
