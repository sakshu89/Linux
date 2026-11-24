package defpackage;

import com.ibm.icu.impl.number.Padder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rp2 implements o21 {
    public static final x42 A;
    public static final x42 b;
    public static final mz2 c;
    public static final mz2 d;
    public static final x42 e;
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
    public final xv1 a;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        b = new x42("\\s+(?:in|on|from|of)\\s+(?:(?:the|these|those)\\s+)?spotify(?:\\s+(?:search\\s+)?results)?(?:\\s+please)?$", y42Var);
        c = new mz2();
        d = new mz2(ii0.a);
        e = new x42("['’‘]");
        f = new x42("(?<!\\S)(?:\"(.+?)\"|“(.+?)”|'(.+?)')(?=\\s|[,.!?]|$)");
        g = new x42("^(?:the\\s+)?(?:music\\s+)?video\\s+(?:for|of)\\s+(.+)$");
        h = new x42("^(.+?)\\s+(?:music\\s+)?video(?:\\s+(by\\s+.+))?$");
        i = new x42("^(?:(?:play|click|tap|choose|select)\\s+(?:on\\s+)?)?(?:the\\s+)?(?:result|option|number|no\\.?|choice)?\\s*(first|second|third|fourth|fifth|one|two|three|four|five|1st|2nd|3rd|4th|5th|[1-9])(?:\\s+(?:song|track|result|option|choice|one))?$", y42Var);
        j = new x42("^(?:click|tap|press|select|choose|open|play)\\s+(?:on\\s+)?(?:the\\s+)?(?:first|second|third|fourth|fifth|one|two|three|four|five|1st|2nd|3rd|4th|5th|top|[1-9])\\s+(?:result|video|chat|conversation|contact|item)(?:\\s+.*)?$");
        k = new x42("^(?:open|launch|start)\\s+(?:the\\s+)?spotify(?:\\s+app)?(?:\\s+only)?\\s+(?:and\\s+)?(?:then\\s+)?(.+)$");
        l = new x42("^(?:(?:on|in|from|using)\\s+)?(?:the\\s+)?spotify(?:\\s+app)?(?:\\s+only)?\\s+(.+)$");
        m = new x42("^(.+?)\\s+(?:on|in|from|using)\\s+(?:the\\s+)?spotify(?:\\s+app)?(?:\\s+only)?$");
        n = new x42("^(?:search|find)\\s+(?:the\\s+)?spotify(?:\\s+app)?(?:\\s+only)?\\s+(?:for\\s+)?(.+)$");
        o = new x42("^((?:pause|resume|unpause|continue|stop|next|previous)(?:\\s+(?:the\\s+)?(?:song|track|music|playback))?)\\s+(?:the\\s+)?spotify(?:\\s+app)?(?:\\s+only)?$");
        p = new x42("^(?:do\\s+not|don\\s+t|dont|never)\\s+(?:play|pause|resume|stop|search|open|launch|next|previous)\\b.*\\bspotify(?:\\s+app)?$");
        q = new x42("^(?:do\\s+not|don\\s+t|dont|never)\\s+(?:play|pause|resume|stop|search|next|previous)\\b");
        r = new x42("\\s+and\\s+(?:then\\s+)?play(?:\\s+(?:it|that|the\\s+song|the\\s+track))?$");
        s = new x42("^(?:play|search\\s+and\\s+play|find\\s+and\\s+play)\\s+(.+)$");
        t = new x42("^(?:search|find|look\\s+up)\\s+(?:for\\s+)?(.+)$");
        u = new x42("^spotify\\s+(?:par|pe)\\s+(.+?)\\s+(?:chalao|bajao|play(?:\\s+karo)?)$");
        v = new x42("^pause(?:\\s+(?:the\\s+)?(?:music|song|track|playback))?$");
        w = new x42("^(?:resume|unpause|continue|play)(?:\\s+(?:the\\s+)?(?:music|playback))?$");
        x = new x42("^(?:(?:play|go to)\\s+(?:the\\s+)?)?next(?:\\s+(?:song|track|one))?$");
        y = new x42("^(?:(?:play|go to)\\s+(?:the\\s+)?)?previous(?:\\s+(?:song|track|one))?$");
        z = new x42("^stop(?:\\s+(?:the\\s+)?(?:music|song|track|playback|playing))?$");
        A = new x42("^(?:what is playing|whats playing|what s playing|what song is playing)$");
    }

    public rp2(xv1 xv1Var) {
        xv1Var.getClass();
        this.a = xv1Var;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:34:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:41:0x0116  */
    /* JADX WARN: Code duplicated, block: B:59:0x016b  */
    public static f5 d(b63 b63Var, String str, boolean z2) {
        fh1 fh1VarD;
        String string;
        String str2;
        Object next;
        String string2;
        String str3;
        str.getClass();
        String string3 = cs2.V(str).toString();
        String string4 = cs2.V(cs2.G(string3, "the song ")).toString();
        Pattern patternCompile = Pattern.compile("\\s+(?:song|track|music|audio)\\s+(?:ko|pe|par|karo|bhej\\s+do)$", 66);
        patternCompile.getClass();
        string4.getClass();
        String strReplaceAll = patternCompile.matcher(string4).replaceAll("");
        strReplaceAll.getClass();
        Pattern patternCompile2 = Pattern.compile("\\s+song\\s+ko$", 66);
        patternCompile2.getClass();
        String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll("");
        strReplaceAll2.getClass();
        Pattern patternCompile3 = Pattern.compile("\\s+(?:ko|la|pe|par)$", 66);
        patternCompile3.getClass();
        String strReplaceAll3 = patternCompile3.matcher(strReplaceAll2).replaceAll("");
        strReplaceAll3.getClass();
        String string5 = cs2.V(strReplaceAll3).toString();
        if (!cs2.A(string5)) {
            string3 = string5;
        }
        String str4 = null;
        if (cs2.A(string3)) {
            return null;
        }
        List listH = zg2.h(zg2.f(x42.c(f, b63Var.a), new xn2(2)));
        fh1 fh1VarD2 = h.d(string3);
        if (fh1VarD2 != null) {
            Object obj = ((dh1) fh1VarD2.a()).get(1);
            Object obj2 = ((dh1) fh1VarD2.a()).get(2);
            if (cs2.A((String) obj2)) {
                obj2 = null;
            }
            String str5 = (String) obj2;
            String strConcat = str5 != null ? Padder.FALLBACK_PADDING_STRING.concat(str5) : null;
            string = cs2.V(obj + (strConcat != null ? strConcat : "")).toString();
            if (string == null) {
                fh1VarD = g.d(string3);
                if (fh1VarD != null || (str2 = (String) ((dh1) fh1VarD.a()).get(1)) == null || (string = cs2.V(str2).toString()) == null || !e(string3, string, listH)) {
                    string = null;
                }
            } else {
                if (js2.e(string, " by", false) || !e(string3, string, listH)) {
                    string = null;
                }
                if (string == null) {
                    fh1VarD = g.d(string3);
                    if (fh1VarD != null) {
                        string = null;
                    } else {
                        string = null;
                    }
                }
            }
        } else {
            fh1VarD = g.d(string3);
            if (fh1VarD != null) {
                string = null;
            } else {
                string = null;
            }
        }
        if (string != null) {
            string3 = string;
        }
        Iterator it = listH.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            str3 = (String) next;
            if (string3.equals(str3)) {
                break;
            }
        } while (!js2.k(string3, str3 + " by ", false));
        String str6 = (String) next;
        int iD = cs2.D(string3, 6, " by ");
        if (str6 != null) {
            string2 = cs2.V(cs2.G(cs2.G(string3, str6), " by ")).toString();
            if (cs2.A(string2)) {
                string2 = null;
            }
        } else {
            string2 = null;
        }
        String string6 = (str6 != null || iD <= 0) ? null : cs2.V(string3.substring(0, iD)).toString();
        if (str6 == null && iD > 0) {
            String string7 = cs2.V(string3.substring(iD + 4)).toString();
            if (!cs2.A(string7)) {
                str4 = string7;
            }
        }
        rg1 rg1Var = new rg1();
        rg1Var.put("provider_app", "spotify");
        if (str6 == null) {
            str6 = string3;
        }
        rg1Var.put("media_title", str6);
        rg1Var.put("query", string3);
        if (string != null) {
            rg1Var.put("media_kind", "video");
        }
        if (string2 != null) {
        }
        if (string6 != null) {
        }
        if (str4 != null) {
        }
        if (z2) {
            rg1Var.put("search_only", "true");
        }
        return dp4.d(b63Var, "media.play.provider", rg1Var.b(), 0.9f, 8);
    }

    public static final boolean e(String str, String str2, List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (cs2.n(str, (String) obj, false)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            if (!cs2.n(str2, (String) obj2, false)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.o21
    public final int a() {
        return 900;
    }

    @Override // defpackage.o21
    public final String b() {
        return "spotify";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x0235  */
    /* JADX WARN: Code duplicated, block: B:102:0x0238 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x023a  */
    /* JADX WARN: Code duplicated, block: B:104:0x023c A[PHI: r21
      0x023c: PHI (r21v2 java.lang.String) = (r21v1 java.lang.String), (r21v3 java.lang.String) binds: [B:107:0x026b, B:103:0x023a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:105:0x023e  */
    /* JADX WARN: Code duplicated, block: B:106:0x023f A[PHI: r11
      0x023f: PHI (r11v7 fh1) = (r11v6 fh1), (r11v11 fh1) binds: [B:101:0x0236, B:105:0x023e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:109:0x026e  */
    /* JADX WARN: Code duplicated, block: B:111:0x027e  */
    /* JADX WARN: Code duplicated, block: B:114:0x0292 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:115:0x0293  */
    /* JADX WARN: Code duplicated, block: B:125:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:126:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:127:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:130:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:133:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:136:0x0308  */
    /* JADX WARN: Code duplicated, block: B:139:0x0311  */
    /* JADX WARN: Code duplicated, block: B:142:0x031a  */
    /* JADX WARN: Code duplicated, block: B:145:0x0323  */
    /* JADX WARN: Code duplicated, block: B:148:0x032c  */
    /* JADX WARN: Code duplicated, block: B:151:0x0336  */
    /* JADX WARN: Code duplicated, block: B:154:0x033f  */
    /* JADX WARN: Code duplicated, block: B:157:0x0348  */
    /* JADX WARN: Code duplicated, block: B:160:0x0351  */
    /* JADX WARN: Code duplicated, block: B:163:0x035a  */
    /* JADX WARN: Code duplicated, block: B:166:0x0363  */
    /* JADX WARN: Code duplicated, block: B:169:0x036d  */
    /* JADX WARN: Code duplicated, block: B:170:0x036f  */
    /* JADX WARN: Code duplicated, block: B:173:0x0379  */
    /* JADX WARN: Code duplicated, block: B:176:0x0383  */
    /* JADX WARN: Code duplicated, block: B:177:0x0386  */
    /* JADX WARN: Code duplicated, block: B:180:0x0390  */
    /* JADX WARN: Code duplicated, block: B:183:0x039a  */
    /* JADX WARN: Code duplicated, block: B:184:0x039c  */
    /* JADX WARN: Code duplicated, block: B:187:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:188:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:193:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:194:0x03be  */
    /* JADX WARN: Code duplicated, block: B:195:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:197:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:199:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:202:0x03df  */
    /* JADX WARN: Code duplicated, block: B:208:0x042c  */
    /* JADX WARN: Code duplicated, block: B:210:0x043a  */
    /* JADX WARN: Code duplicated, block: B:213:0x044d  */
    /* JADX WARN: Code duplicated, block: B:215:0x0457  */
    /* JADX WARN: Code duplicated, block: B:216:0x0475  */
    /* JADX WARN: Code duplicated, block: B:219:0x047f  */
    /* JADX WARN: Code duplicated, block: B:222:0x0499  */
    /* JADX WARN: Code duplicated, block: B:223:0x04af  */
    /* JADX WARN: Code duplicated, block: B:225:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:226:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:228:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:229:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:231:0x04fe  */
    /* JADX WARN: Code duplicated, block: B:232:0x0512  */
    /* JADX WARN: Code duplicated, block: B:234:0x051a  */
    /* JADX WARN: Code duplicated, block: B:237:0x0549  */
    /* JADX WARN: Code duplicated, block: B:238:0x0555  */
    /* JADX WARN: Code duplicated, block: B:240:0x055f  */
    /* JADX WARN: Code duplicated, block: B:241:0x0562  */
    /* JADX WARN: Code duplicated, block: B:243:0x056a  */
    /* JADX WARN: Code duplicated, block: B:244:0x056d  */
    /* JADX WARN: Code duplicated, block: B:246:0x0575  */
    /* JADX WARN: Code duplicated, block: B:247:0x0578  */
    /* JADX WARN: Code duplicated, block: B:249:0x0580  */
    /* JADX WARN: Code duplicated, block: B:250:0x0583  */
    /* JADX WARN: Code duplicated, block: B:252:0x058b  */
    /* JADX WARN: Code duplicated, block: B:253:0x058e  */
    /* JADX WARN: Code duplicated, block: B:255:0x0596  */
    /* JADX WARN: Code duplicated, block: B:256:0x0599  */
    /* JADX WARN: Code duplicated, block: B:258:0x059c  */
    /* JADX WARN: Code duplicated, block: B:259:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:261:0x05bb  */
    /* JADX WARN: Code duplicated, block: B:262:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:264:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:266:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:267:0x05e8  */
    /* JADX WARN: Code duplicated, block: B:269:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:270:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:273:0x05fd A[LOOP:0: B:206:0x0426->B:273:0x05fd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:275:0x05fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0124  */
    /* JADX WARN: Code duplicated, block: B:63:0x0154  */
    /* JADX WARN: Code duplicated, block: B:78:0x0183  */
    /* JADX WARN: Code duplicated, block: B:79:0x0185  */
    /* JADX WARN: Code duplicated, block: B:87:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:89:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:90:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:92:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:93:0x0211  */
    /* JADX WARN: Code duplicated, block: B:95:0x021d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0225  */
    /* JADX WARN: Code duplicated, block: B:99:0x022d  */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00bc, code lost:
    
        if (r3.equals("tisra") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c6, code lost:
    
        if (r3.equals("pehla") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d0, code lost:
    
        if (r3.equals("pahla") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00da, code lost:
    
        if (r3.equals("dusra") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e4, code lost:
    
        if (r3.equals("पहले") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ee, code lost:
    
        if (r3.equals("पहली") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f8, code lost:
    
        if (r3.equals("पहला") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0102, code lost:
    
        if (r3.equals("teesra") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010c, code lost:
    
        if (r3.equals("doosra") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0116, code lost:
    
        if (r3.equals("पहिले") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0120, code lost:
    
        if (r3.equals("पहिलं") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x012d, code lost:
    
        if (r3.equals("दूसरे") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0136, code lost:
    
        if (r3.equals("दूसरी") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x013f, code lost:
    
        if (r3.equals("दूसरा") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0148, code lost:
    
        if (r3.equals("दुसरे") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0151, code lost:
    
        if (r3.equals("दुसरं") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x015d, code lost:
    
        if (r3.equals("तीसरे") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0166, code lost:
    
        if (r3.equals("तीसरी") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x016f, code lost:
    
        if (r3.equals("तीसरा") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0178, code lost:
    
        if (r3.equals("तिसरे") != true) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0181, code lost:
    
        if (r3.equals("तिसरं") != true) goto L78;
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v40 int, still in use, count: 1, list:
      (r6v40 int) from 0x02e6: SWITCH (r6v40 int)
     case 49: goto B:139:0x0311
     case 50: goto B:136:0x0308
     case 51: goto B:133:0x02ff
     case 52: goto B:130:0x02f6
     case 53: goto B:127:0x02ed
     default: goto B:126:0x02e9 A[RegionRef:SW:125] (LINE:743)
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
    	at jadx.core.utils.InsnRemover.removeAllMarked(InsnRemover.java:276)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:354)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v40 int, still in use, count: 1, list:
      (r6v40 int) from 0x02e6: SWITCH (r6v40 int)
     case 49: goto B:139:0x0311
     case 50: goto B:136:0x0308
     case 51: goto B:133:0x02ff
     case 52: goto B:130:0x02f6
     case 53: goto B:127:0x02ed
     default: goto B:126:0x02e9 A[RegionRef:SW:125] (LINE:743)
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:124:0x02e3. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Instruction removed from duplicated block: B:225:0x04b8, please report this as an issue */
    @Override // defpackage.o21
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.f5 c(defpackage.b63 r26, defpackage.i60 r27) {
        /*
            Method dump skipped, instruction units count: 1708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rp2.c(b63, i60):f5");
    }
}
