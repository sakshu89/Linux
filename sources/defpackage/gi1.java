package defpackage;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gi1 implements bl2 {
    public static final x42 i = new x42("\\b(?:ad|advertisement|sponsored)\\b", y42.IGNORE_CASE);
    public final n21 a;
    public final ii1 b;
    public final nb2 c;
    public final xv1 d;
    public final up2 e;
    public final qq2 f;
    public final Set g;
    public final l82 h;

    public gi1(n21 n21Var, ii1 ii1Var, nb2 nb2Var, xv1 xv1Var, up2 up2Var, qq2 qq2Var) {
        n21Var.getClass();
        ii1Var.getClass();
        nb2Var.getClass();
        xv1Var.getClass();
        up2Var.getClass();
        qq2Var.getClass();
        this.a = n21Var;
        this.b = ii1Var;
        this.c = nb2Var;
        this.d = xv1Var;
        this.e = up2Var;
        this.f = qq2Var;
        this.g = wh2.c(new w3("media.play.provider"), new w3("spotify.search"));
        this.h = l82.a;
    }

    public static hl2 o(String str, String str2) {
        return new hl2(str, str2, new c73(str2), null, false, 24);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [xv1] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Iterable, java.util.List] */
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
    public static final gl2 q(gi1 gi1Var, String str, String str2, String str3, boolean z, f5 f5Var, String str4, r3 r3Var) {
        String str5;
        Map mapSingletonMap;
        ?? r14 = gi1Var.d;
        ?? L = mz.L(r3Var.d, 4);
        if (L.isEmpty()) {
            List listL = mz.L(r3Var.b, 4);
            L = new ArrayList(nz.d(listL));
            Iterator it = listL.iterator();
            while (it.hasNext()) {
                L.add(new xv2((String) it.next(), null, null));
            }
        }
        r14.c(str, str2, str3, L);
        wv1 wv1VarB = r14.b();
        wv1VarB.getClass();
        String str6 = wv1VarB.g;
        ArrayList arrayList = new ArrayList(nz.d(L));
        int i2 = 0;
        for (Object obj : L) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                nz.n();
                throw null;
            }
            xv2 xv2Var = (xv2) obj;
            arrayList.add(new zx(xv2Var.a, String.valueOf(i3), xv2Var.b, bh1.c(new wt1("select_visible_result", "true"), new wt1("spotify_search_id", str6))));
            i2 = i3;
        }
        if (z && L.size() == 1) {
            str5 = "I found this Spotify track. Say first for its music video.";
        } else if (z) {
            str5 = "Which Spotify music video? Say its number.";
        } else {
            str5 = L.size() == 1 ? "I found this Spotify song. Say first to play it." : "Which Spotify song? Say its number.";
        }
        Map map = f5Var.b;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (!wh2.c("ordinal", "spotify_search_id", "search_only").contains((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMapE = bh1.e(linkedHashMap, bh1.c(new wt1("media_title", str4), new wt1("query", str), new wt1("provider_app", "spotify")));
        if (z) {
            mapSingletonMap = Collections.singletonMap("media_kind", "video");
            mapSingletonMap.getClass();
        } else {
            mapSingletonMap = ji0.a;
        }
        return new gl2(str5, new yx(str5, "ordinal", arrayList, "media.play.provider", bh1.e(linkedHashMapE, mapSingletonMap)));
    }

    public static final void r(o42 o42Var, t42 t42Var, boolean z, String str, t42 t42Var2, String str2, s3 s3Var) {
        o42Var.a = true;
        String str3 = s3Var.b;
        if (str3 != null) {
            str = str3;
        } else if (z) {
            str = null;
        }
        t42Var.a = str;
        String str4 = s3Var.c;
        if (str4 != null) {
            str2 = str4;
        } else if (z) {
            str2 = null;
        }
        t42Var2.a = str2;
    }

    public static final boolean s(o42 o42Var, t42 t42Var, t42 t42Var2, xv2 xv2Var, ro1 ro1Var, ro1 ro1Var2) {
        if (!o42Var.a) {
            return false;
        }
        String str = (String) t42Var.a;
        if (str != null && !cs2.A(str)) {
            Set set = cq2.a;
            if (!cq2.k(ro1Var2, str, (String) t42Var2.a)) {
                if (xv2Var == null) {
                    return false;
                }
                if (!cq2.j(str) && !cq2.i((String) t42Var2.a)) {
                    return false;
                }
                if (!g31.a(ro1Var2 != null ? ro1Var2.a : null, "com.spotify.music")) {
                    return false;
                }
                boolean z = ro1Var2.f;
                String str2 = ro1Var2.d;
                String str3 = ro1Var2.c;
                if (!z || cq2.j(str3) || !cq2.c(str, str3) || cq2.f(str2) || !cq2.b((String) t42Var2.a, str2)) {
                    return false;
                }
                if (cq2.j(str) && t(ro1Var2, ro1Var) && ro1Var != null && ro1Var.f) {
                    return false;
                }
            }
        } else if (ro1Var2 == null || !ro1Var2.a.equals("com.spotify.music") || !ro1Var2.f || t(ro1Var2, ro1Var)) {
            return false;
        }
        return true;
    }

    public static boolean t(ro1 ro1Var, ro1 ro1Var2) {
        if (!g31.a(ro1Var != null ? ro1Var.a : null, "com.spotify.music")) {
            return false;
        }
        if (!g31.a(ro1Var2 != null ? ro1Var2.a : null, "com.spotify.music")) {
            return false;
        }
        String str = ro1Var.c;
        String strM = str != null ? cq2.m(str) : null;
        if (strM == null) {
            strM = "";
        }
        String str2 = ro1Var2.c;
        String strM2 = str2 != null ? cq2.m(str2) : null;
        if (strM2 == null) {
            strM2 = "";
        }
        if (cs2.A(strM) || !strM.equals(strM2)) {
            return false;
        }
        String str3 = ro1Var.d;
        String strL = str3 != null ? cq2.l(str3) : null;
        if (strL == null) {
            strL = "";
        }
        String str4 = ro1Var2.d;
        String strL2 = str4 != null ? cq2.l(str4) : null;
        return strL.equals(strL2 != null ? strL2 : "");
    }

    public static String u(String str, String str2) {
        if (str2 == null || cs2.A(str2)) {
            return n61.a.d(str);
        }
        String strConcat = " by ".concat(str2);
        n61 n61Var = n61.a;
        if (!js2.e(str, strConcat, true)) {
            str = str.concat(strConcat);
        }
        return n61Var.d(str);
    }

    @Override // defpackage.bl2
    public final Object a(f5 f5Var, x50 x50Var) {
        String strO;
        String strC;
        String strC2 = f5Var.c("provider_app");
        if (strC2 != null) {
            Locale locale = Locale.ROOT;
            strO = cq.o(locale, strC2, locale);
        } else {
            strO = null;
        }
        if (!g31.a(strO, "spotify") || g31.a(f5Var.c("search_only"), "true") || g31.a(f5Var.c("select_visible_result"), "true") || g31.a(f5Var.c("media_kind"), "video") || ((strC = f5Var.c("media_title")) == null && (strC = f5Var.c("query")) == null)) {
            return null;
        }
        ro1 ro1VarE = this.b.e("com.spotify.music");
        Set set = cq2.a;
        if (!cq2.k(ro1VarE, strC, f5Var.c("artist"))) {
            return new c73("Spotify hasn't reported the requested song playing");
        }
        ro1VarE.getClass();
        return new d73("spotify.playback", ro1VarE.a());
    }

    @Override // defpackage.bl2
    public final Set b() {
        return this.g;
    }

    @Override // defpackage.bl2
    public final String d() {
        return "media.provider";
    }

    @Override // defpackage.bl2
    public final String e() {
        return "Plays requested Spotify songs and available music videos, or searches another music app.";
    }

    @Override // defpackage.bl2
    public final void f() {
        this.d.a();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0045  */
    @Override // defpackage.bl2
    public final Object h(f5 f5Var, cl2 cl2Var, x50 x50Var) {
        String string;
        String str;
        String strO;
        Map mapSingletonMap;
        String string2;
        String string3;
        f5 f5VarA = f5Var;
        String strC = f5VarA.c("query");
        if (strC == null) {
            strC = f5VarA.c("media_title");
        }
        if (strC != null && (string = cs2.V(strC).toString()) != null) {
            String str2 = !cs2.A(string) ? string : null;
            if (str2 != null) {
                String strC2 = f5VarA.c("media_title");
                if (strC2 == null || (string3 = cs2.V(strC2).toString()) == null) {
                    str = str2;
                } else {
                    if (cs2.A(string3)) {
                        string3 = null;
                    }
                    if (string3 == null) {
                        str = str2;
                    } else {
                        str = string3;
                    }
                }
                String strC3 = f5VarA.c("artist");
                String str3 = (strC3 == null || (string2 = cs2.V(strC3).toString()) == null || cs2.A(string2)) ? null : string2;
                String strC4 = f5VarA.c("provider_app");
                if (strC4 != null) {
                    Locale locale = Locale.ROOT;
                    strO = cq.o(locale, strC4, locale);
                } else {
                    strO = "spotify";
                }
                if (g31.a(f5VarA.a, "spotify.search") || g31.a(f5VarA.c("search_only"), "true")) {
                    Map map = f5VarA.b;
                    if (map.isEmpty()) {
                        mapSingletonMap = Collections.singletonMap("search_only", "true");
                        mapSingletonMap.getClass();
                    } else {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
                        linkedHashMap.put("search_only", "true");
                        mapSingletonMap = linkedHashMap;
                    }
                    f5VarA = f5.a(f5VarA, null, mapSingletonMap, 29);
                }
                f5 f5Var2 = f5VarA;
                if (strO.equals("spotify")) {
                    return p(f5Var2, (y50) x50Var, str2, str, str3);
                }
                Intent intent = new Intent("android.intent.action.SEARCH");
                intent.putExtra("query", u(str2, str3));
                intent.setFlags(268435456);
                return this.a.a(intent, strO) instanceof p61 ? new hl2(ky0.l("Opened ", strO, " for ", str2, ", Boss."), "App handoff dispatched", new c73("Search intent launched"), null, false, 24) : new fl2(cq.v("Couldn't open ", strO, "."), "Launch failed", null, false, 12);
            }
        }
        return new fl2("What song would you like me to play?", "Missing media title", null, false, 4);
    }

    @Override // defpackage.bl2
    public final Object i(y50 y50Var) {
        return a32.a;
    }

    @Override // defpackage.bl2
    public final String j(f5 f5Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final List k() {
        return ii0.a;
    }

    @Override // defpackage.bl2
    public final l82 l() {
        return this.h;
    }

    @Override // defpackage.bl2
    public final String m() {
        return "Music provider handoff";
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object n(String str, ro1 ro1Var, boolean z, y50 y50Var) throws Throwable {
        ci1 ci1Var;
        if (y50Var instanceof ci1) {
            ci1Var = (ci1) y50Var;
            int i2 = ci1Var.j;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                ci1Var.j = i2 - Integer.MIN_VALUE;
            } else {
                ci1Var = new ci1(this, y50Var);
            }
        } else {
            ci1Var = new ci1(this, y50Var);
        }
        Object objF = ci1Var.f;
        int i3 = ci1Var.j;
        if (i3 == 0) {
            bz3.g(objF);
            if (!z) {
                return new il2(cq.v("Playing ", str, " on Spotify."), new d73("spotify.playback", ro1Var.a()), null, null, 12);
            }
            String str2 = ro1Var.c;
            if (str2 == null) {
                str2 = str;
            }
            String str3 = ro1Var.d;
            ci1Var.e = str;
            ci1Var.j = 1;
            objF = this.f.f(str2, str3, ci1Var);
            t70 t70Var = t70.a;
            if (objF == t70Var) {
                return t70Var;
            }
        } else {
            if (i3 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str = ci1Var.e;
            bz3.g(objF);
        }
        tq2 tq2Var = (tq2) objF;
        if (tq2Var instanceof sq2) {
            return new il2(cq.v("Playing the music video for ", str, " on Spotify."), new d73("spotify.video", ((sq2) tq2Var).a), null, null, 12);
        }
        if (tq2Var instanceof rq2) {
            return o("The track is selected, but I couldn't confirm its Spotify music video.", ((rq2) tq2Var).a);
        }
        dk0.l();
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0535  */
    /* JADX WARN: Code duplicated, block: B:127:0x053d  */
    /* JADX WARN: Code duplicated, block: B:129:0x0540  */
    /* JADX WARN: Code duplicated, block: B:137:0x0553  */
    /* JADX WARN: Code duplicated, block: B:139:0x056d  */
    /* JADX WARN: Code duplicated, block: B:142:0x057a  */
    /* JADX WARN: Code duplicated, block: B:145:0x0582  */
    /* JADX WARN: Code duplicated, block: B:147:0x0588  */
    /* JADX WARN: Code duplicated, block: B:149:0x058c  */
    /* JADX WARN: Code duplicated, block: B:153:0x05c8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:154:0x05c9  */
    /* JADX WARN: Code duplicated, block: B:156:0x05d3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:157:0x05d5  */
    /* JADX WARN: Code duplicated, block: B:158:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:161:0x05df  */
    /* JADX WARN: Code duplicated, block: B:163:0x05e3  */
    /* JADX WARN: Code duplicated, block: B:167:0x060e  */
    /* JADX WARN: Code duplicated, block: B:170:0x0618  */
    /* JADX WARN: Code duplicated, block: B:173:0x0633  */
    /* JADX WARN: Code duplicated, block: B:176:0x0639 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:177:0x063b  */
    /* JADX WARN: Code duplicated, block: B:178:0x063d  */
    /* JADX WARN: Code duplicated, block: B:181:0x06c2  */
    /* JADX WARN: Code duplicated, block: B:182:0x06c5  */
    /* JADX WARN: Code duplicated, block: B:185:0x06f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:186:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:187:0x06f8  */
    /* JADX WARN: Code duplicated, block: B:189:0x0721  */
    /* JADX WARN: Code duplicated, block: B:191:0x0725  */
    /* JADX WARN: Code duplicated, block: B:193:0x0735  */
    /* JADX WARN: Code duplicated, block: B:195:0x073d  */
    /* JADX WARN: Code duplicated, block: B:197:0x0741  */
    /* JADX WARN: Code duplicated, block: B:199:0x0745  */
    /* JADX WARN: Code duplicated, block: B:240:0x095c A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:243:0x097e  */
    /* JADX WARN: Code duplicated, block: B:245:0x0984  */
    /* JADX WARN: Code duplicated, block: B:247:0x09b0  */
    /* JADX WARN: Code duplicated, block: B:250:0x0a03  */
    /* JADX WARN: Code duplicated, block: B:252:0x0a0f  */
    /* JADX WARN: Code duplicated, block: B:255:0x0a16  */
    /* JADX WARN: Code duplicated, block: B:258:0x0a31  */
    /* JADX WARN: Code duplicated, block: B:262:0x0a8f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0319 A[PHI: r3
      0x0319: PHI (r3v5 java.lang.String) = (r3v4 java.lang.String), (r3v12 java.lang.String) binds: [B:42:0x030f, B:46:0x0317] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:71:0x0376  */
    /* JADX WARN: Code duplicated, block: B:7:0x001f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v20, types: [int] */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r24v12 */
    /* JADX WARN: Type inference failed for: r24v16 */
    /* JADX WARN: Type inference failed for: r24v22 */
    /* JADX WARN: Type inference failed for: r24v31 */
    /* JADX WARN: Type inference failed for: r24v32 */
    /* JADX WARN: Type inference failed for: r64v0, types: [gi1] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:262:0x0a8f -> B:263:0x0ab1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object p(defpackage.f5 r65, defpackage.y50 r66, java.lang.String r67, java.lang.String r68, java.lang.String r69) {
        /*
            Method dump skipped, instruction units count: 3090
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gi1.p(f5, y50, java.lang.String, java.lang.String, java.lang.String):java.lang.Object");
    }

    @Override // defpackage.bl2
    public final void g() {
    }
}
