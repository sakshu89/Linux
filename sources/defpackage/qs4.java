package defpackage;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.ibm.icu.impl.number.Padder;
import java.text.Normalizer;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class qs4 implements i70, dm, mo, ao1, l12, p10, eq1 {
    public static qs4 b;
    public static final /* synthetic */ qs4 c = new qs4(1);
    public static final qs4 e = new qs4(2);
    public static final qs4 f = new qs4(3);
    public static final /* synthetic */ qs4 i = new qs4(4);
    public static final qs4 j = new qs4(5);
    public static final kf2 k = new kf2(12);
    public static final qs4 n = new qs4(7);
    public final /* synthetic */ int a;

    public /* synthetic */ qs4(int i2) {
        this.a = i2;
    }

    public static final void c(qs4 qs4Var, qc1 qc1Var, String str, String str2) {
        str.getClass();
        String strQuote = Pattern.quote(str);
        strQuote.getClass();
        qc1Var.add(new wt1(new x42("\\b" + strQuote + "\\b"), str2));
    }

    public static final String e(String str) {
        Set set = ue.f;
        String strReplace = js2.i(js2.i(js2.i(js2.i(str, "ph", "f"), "ck", "k"), "qu", "k"), "ch", "k").replace('c', 'k');
        strReplace.getClass();
        String strReplace2 = strReplace.replace('q', 'k');
        strReplace2.getClass();
        String strReplace3 = strReplace2.replace('g', 'j');
        strReplace3.getClass();
        String strReplace4 = strReplace3.replace('v', 'w');
        strReplace4.getClass();
        String strI = js2.i(js2.i(js2.i(js2.i(js2.i(js2.i(strReplace4, "aa", "a"), "ee", "i"), "oo", "u"), "ai", "e"), "ay", "e"), "ae", "e");
        Pattern patternCompile = Pattern.compile("([a-z])\\1+");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strI).replaceAll("$1");
        strReplaceAll.getClass();
        return cs2.I(strReplaceAll, "e");
    }

    public static final yc h(int i2, String str) {
        WeakHashMap weakHashMap = tb3.v;
        return new yc(i2, str);
    }

    public static final i63 l(int i2, String str) {
        WeakHashMap weakHashMap = tb3.v;
        return new i63(new v11(0, 0, 0, 0), str);
    }

    public static int n(String str, int i2, String str2) {
        int iMin;
        str2.getClass();
        if (str.equals(str2)) {
            return 0;
        }
        if (Math.abs(str.length() - str2.length()) > i2) {
            return i2 + 1;
        }
        if (str.length() == 0) {
            return str2.length();
        }
        if (str2.length() == 0) {
            return str.length();
        }
        int length = str2.length() + 1;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = i3;
        }
        int[] iArr2 = new int[str2.length() + 1];
        int length2 = str.length();
        if (1 <= length2) {
            iArr = iArr2;
            int[] iArr3 = iArr;
            int i4 = 1;
            while (true) {
                iArr[0] = i4;
                int length3 = str2.length();
                if (1 <= length3) {
                    int i5 = 1;
                    iMin = i4;
                    while (true) {
                        int i6 = i5 - 1;
                        int iMin2 = Math.min(Math.min(iArr[i6] + 1, iArr3[i5] + 1), iArr3[i6] + (str.charAt(i4 + (-1)) == str2.charAt(i6) ? 0 : 1));
                        iArr[i5] = iMin2;
                        iMin = Math.min(iMin, iMin2);
                        if (i5 == length3) {
                            break;
                        }
                        i5++;
                    }
                } else {
                    iMin = i4;
                }
                if (iMin > i2) {
                    return i2 + 1;
                }
                if (i4 != length2) {
                    i4++;
                    int[] iArr4 = iArr;
                    iArr = iArr3;
                    iArr3 = iArr4;
                }
            }
        }
        return iArr[str2.length()];
    }

    public static String o(String str) {
        String str2 = str;
        str2.getClass();
        int i2 = 0;
        while (i2 < str2.length()) {
            char cCharAt = str2.charAt(i2);
            if (2304 <= cCharAt && cCharAt < 2432) {
                String strI = str;
                for (Map.Entry entry : bh1.c(new wt1("खोलिए", "kholiye"), new wt1("खोलिये", "kholiye"), new wt1("खोलें", "kholen"), new wt1("खोला", "khola"), new wt1("खोलो", "kholo"), new wt1("खोलह", "kholah"), new wt1("खोल", "khol"), new wt1("कॉल", "call"), new wt1("फोन", "phone"), new wt1("बंद", "band"), new wt1("चालू", "chalu"), new wt1("बजाओ", "bajao"), new wt1("चलाओ", "chalao"), new wt1("भेजो", "bhejo"), new wt1("भेज", "bhej"), new wt1("लगाओ", "lagao"), new wt1("बताओ", "batao"), new wt1("दिखाओ", "dikhao"), new wt1("करो", "karo"), new wt1("कर", "kar"), new wt1("दो", "do"), new wt1("रोको", "roko"), new wt1("रुको", "ruko"), new wt1("आवाज", "awaaz"), new wt1("मैसेज", "message"), new wt1("फोटो", "photo"), new wt1("कैमरा", "camera"), new wt1("अलार्म", "alarm"), new wt1("यूट्यूब", "youtube"), new wt1("फ्लैशलाइट", "flashlight"), new wt1("टॉर्च", "torch"), new wt1("मम्मी", "mummy"), new wt1("पापा", "papa"), new wt1("भाई", "bhai"), new wt1("बहन", "behen")).entrySet()) {
                    strI = js2.i(strI, (String) entry.getKey(), (String) entry.getValue());
                }
                return strI;
            }
            i2++;
            str2 = str;
        }
        return str;
    }

    public static String r(String str) {
        try {
            String strNormalize = Normalizer.normalize(n61.a.d(str), Normalizer.Form.NFD);
            strNormalize.getClass();
            Pattern patternCompile = Pattern.compile("\\p{M}+");
            patternCompile.getClass();
            String strReplaceAll = patternCompile.matcher(strNormalize).replaceAll("");
            strReplaceAll.getClass();
            return s(strReplaceAll);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String s(String str) {
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFC);
        strNormalize.getClass();
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, strNormalize, locale);
        StringBuilder sb = new StringBuilder();
        strO.codePoints().forEach(new x31(4, sb));
        String string = cs2.V(sb.toString()).toString();
        Pattern patternCompile = Pattern.compile("\\s+");
        patternCompile.getClass();
        string.getClass();
        String strReplaceAll = patternCompile.matcher(string).replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll.getClass();
        return strReplaceAll;
    }

    public static synchronized void t() {
        if (b == null) {
            b = new qs4(0);
        }
    }

    @Override // defpackage.ao1
    public boolean a(dk1 dk1Var) {
        return false;
    }

    @Override // defpackage.mo
    public byte[] b(int i2, byte[] bArr, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return bArr2;
    }

    @Override // defpackage.ao1
    public int d() {
        return 8;
    }

    @Override // defpackage.p10
    public Object g(e72 e72Var) {
        switch (this.a) {
            case 22:
                return new yj1();
            default:
                return new xy(0);
        }
    }

    @Override // defpackage.ao1
    public void i(n71 n71Var, long j2, pw0 pw0Var, int i2, boolean z) {
        zn1 zn1Var = n71Var.o0;
        co1 co1Var = zn1Var.d;
        r72 r72Var = co1.v0;
        zn1Var.d.a1(co1.z0, co1Var.S0(j2), pw0Var, 1, z);
    }

    @Override // defpackage.ao1
    public boolean j(n71 n71Var) {
        cg2 cg2VarW = n71Var.w();
        boolean z = false;
        if (cg2VarW != null && cg2VarW.e) {
            z = true;
        }
        return !z;
    }

    @Override // defpackage.dm
    public long k(iz izVar, int i2) {
        return ((gz2) izVar.e).i(i2);
    }

    public void m(pi0 pi0Var) {
        pi0Var.a(kn4.class, bd4.a);
        pi0Var.a(jr4.class, ik4.a);
        pi0Var.a(ln4.class, dd4.a);
        pi0Var.a(sn4.class, gd4.a);
        pi0Var.a(qn4.class, ed4.a);
        pi0Var.a(rn4.class, id4.a);
        pi0Var.a(zl4.class, qa4.a);
        pi0Var.a(yl4.class, oa4.a);
        pi0Var.a(xm4.class, gc4.a);
        pi0Var.a(wq4.class, fj4.a);
        pi0Var.a(xl4.class, ma4.a);
        pi0Var.a(wl4.class, ka4.a);
        pi0Var.a(yo4.class, ag4.a);
        pi0Var.a(fs4.class, rb4.a);
        pi0Var.a(tm4.class, xb4.a);
        pi0Var.a(lm4.class, pb4.a);
        pi0Var.a(zo4.class, cg4.a);
        pi0Var.a(qq4.class, zi4.a);
        pi0Var.a(uq4.class, bj4.a);
        pi0Var.a(pq4.class, xi4.a);
        pi0Var.a(wn4.class, sd4.a);
        pi0Var.a(es4.class, d94.a);
        pi0Var.a(xn4.class, ud4.a);
        pi0Var.a(hp4.class, sg4.a);
        pi0Var.a(kp4.class, yg4.a);
        pi0Var.a(jp4.class, wg4.a);
        pi0Var.a(ip4.class, ug4.a);
        pi0Var.a(wp4.class, qh4.a);
        pi0Var.a(xp4.class, sh4.a);
        pi0Var.a(zp4.class, wh4.a);
        pi0Var.a(yp4.class, uh4.a);
        pi0Var.a(vn4.class, rd4.a);
        pi0Var.a(aq4.class, xh4.a);
        pi0Var.a(bq4.class, ai4.a);
        pi0Var.a(cq4.class, ci4.a);
        pi0Var.a(dq4.class, ei4.a);
        pi0Var.a(hq4.class, ji4.a);
        pi0Var.a(gq4.class, li4.a);
        pi0Var.a(vp4.class, ih4.a);
        pi0Var.a(bn4.class, qc4.a);
        pi0Var.a(tp4.class, mh4.a);
        pi0Var.a(pp4.class, kh4.a);
        pi0Var.a(up4.class, oh4.a);
        pi0Var.a(vq4.class, dj4.a);
        pi0Var.a(rr4.class, qk4.a);
        pi0Var.a(el4.class, n94.a);
        pi0Var.a(bl4.class, j94.a);
        pi0Var.a(al4.class, h94.a);
        pi0Var.a(cl4.class, l94.a);
        pi0Var.a(hl4.class, r94.a);
        pi0Var.a(gl4.class, p94.a);
        pi0Var.a(il4.class, t94.a);
        pi0Var.a(pl4.class, v94.a);
        pi0Var.a(ql4.class, x94.a);
        pi0Var.a(rl4.class, ba4.a);
        pi0Var.a(sl4.class, da4.a);
        pi0Var.a(k54.class, v84.a);
        pi0Var.a(o54.class, z84.a);
        pi0Var.a(m54.class, x84.a);
        pi0Var.a(zm4.class, mc4.a);
        pi0Var.a(am4.class, sa4.a);
        pi0Var.a(k24.class, s54.a);
        pi0Var.a(i24.class, x54.a);
        pi0Var.a(jm4.class, lb4.a);
        pi0Var.a(o24.class, z54.a);
        pi0Var.a(m24.class, b64.a);
        pi0Var.a(k34.class, x64.a);
        pi0Var.a(i34.class, z64.a);
        pi0Var.a(s24.class, d64.a);
        pi0Var.a(q24.class, f64.a);
        pi0Var.a(y34.class, j74.a);
        pi0Var.a(u34.class, l74.a);
        pi0Var.a(g44.class, r74.a);
        pi0Var.a(e44.class, t74.a);
        pi0Var.a(i54.class, r84.a);
        pi0Var.a(f54.class, t84.a);
        pi0Var.a(k44.class, v74.a);
        pi0Var.a(i44.class, z74.a);
        pi0Var.a(o44.class, b84.a);
        pi0Var.a(m44.class, d84.a);
        pi0Var.a(zr4.class, lj4.a);
        pi0Var.a(sr4.class, ua4.a);
        pi0Var.a(wr4.class, qd4.a);
        pi0Var.a(vr4.class, od4.a);
        pi0Var.a(tr4.class, tb4.a);
        pi0Var.a(yr4.class, jj4.a);
        pi0Var.a(xr4.class, hj4.a);
        pi0Var.a(as4.class, nj4.a);
        pi0Var.a(ur4.class, ic4.a);
        pi0Var.a(ds4.class, tk4.a);
        pi0Var.a(cs4.class, uk4.a);
        pi0Var.a(bs4.class, sk4.a);
        pi0Var.a(yq4.class, rj4.a);
        pi0Var.a(ym4.class, kc4.a);
        pi0Var.a(cn4.class, sc4.a);
        pi0Var.a(yk4.class, f94.a);
        pi0Var.a(um4.class, ac4.a);
        pi0Var.a(an4.class, oc4.a);
        pi0Var.a(km4.class, nb4.a);
        pi0Var.a(cm4.class, xa4.a);
        pi0Var.a(dm4.class, za4.a);
        pi0Var.a(bm4.class, va4.a);
        pi0Var.a(em4.class, bb4.a);
        pi0Var.a(un4.class, md4.a);
        pi0Var.a(tn4.class, kd4.a);
        pi0Var.a(g24.class, q54.a);
        pi0Var.a(or4.class, mk4.a);
        pi0Var.a(qr4.class, pk4.a);
        pi0Var.a(pr4.class, ok4.a);
        pi0Var.a(wk4.class, b94.a);
        pi0Var.a(vl4.class, ja4.a);
        pi0Var.a(ul4.class, ha4.a);
        pi0Var.a(tl4.class, fa4.a);
        pi0Var.a(vo4.class, rf4.a);
        pi0Var.a(xo4.class, vf4.a);
        pi0Var.a(wo4.class, tf4.a);
        pi0Var.a(wh2.class, t64.a);
        pi0Var.a(ah2.class, v64.a);
        pi0Var.a(ap4.class, eg4.a);
        pi0Var.a(dp4.class, kg4.a);
        pi0Var.a(bp4.class, gg4.a);
        pi0Var.a(cp4.class, ig4.a);
        pi0Var.a(o34.class, b74.a);
        pi0Var.a(m34.class, d74.a);
        pi0Var.a(dr4.class, bk4.a);
        pi0Var.a(cr4.class, zj4.a);
        pi0Var.a(kr4.class, jk4.a);
        pi0Var.a(mr4.class, lk4.a);
        pi0Var.a(lp4.class, ah4.a);
        pi0Var.a(op4.class, gh4.a);
        pi0Var.a(mp4.class, ch4.a);
        pi0Var.a(np4.class, eh4.a);
        pi0Var.a(wm4.class, ec4.a);
        pi0Var.a(c44.class, n74.a);
        pi0Var.a(a44.class, p74.a);
        pi0Var.a(vm4.class, cc4.a);
        pi0Var.a(mm4.class, vb4.a);
        pi0Var.a(ep4.class, mg4.a);
        pi0Var.a(gp4.class, qg4.a);
        pi0Var.a(fp4.class, og4.a);
        pi0Var.a(s34.class, f74.a);
        pi0Var.a(q34.class, h74.a);
        pi0Var.a(ko4.class, xe4.a);
        pi0Var.a(lo4.class, ze4.a);
        pi0Var.a(mo4.class, bf4.a);
        pi0Var.a(a34.class, l64.a);
        pi0Var.a(y24.class, n64.a);
        pi0Var.a(ho4.class, re4.a);
        pi0Var.a(io4.class, te4.a);
        pi0Var.a(jo4.class, ve4.a);
        pi0Var.a(w24.class, h64.a);
        pi0Var.a(u24.class, j64.a);
        pi0Var.a(no4.class, df4.a);
        pi0Var.a(oo4.class, ff4.a);
        pi0Var.a(qo4.class, hf4.a);
        pi0Var.a(ro4.class, jf4.a);
        pi0Var.a(e34.class, p64.a);
        pi0Var.a(c34.class, r64.a);
        pi0Var.a(bh1.class, sj4.a);
        pi0Var.a(ar4.class, uj4.a);
        pi0Var.a(dn4.class, uc4.a);
        pi0Var.a(fn4.class, yc4.a);
        pi0Var.a(en4.class, wc4.a);
        pi0Var.a(gn4.class, ad4.a);
        pi0Var.a(iq4.class, ni4.a);
        pi0Var.a(jq4.class, pi4.a);
        pi0Var.a(w44.class, j84.a);
        pi0Var.a(u44.class, l84.a);
        pi0Var.a(er4.class, ck4.a);
        pi0Var.a(eq4.class, gi4.a);
        pi0Var.a(fq4.class, ii4.a);
        pi0Var.a(s44.class, f84.a);
        pi0Var.a(q44.class, h84.a);
        pi0Var.a(br4.class, vj4.a);
        pi0Var.a(go4.class, be4.a);
        pi0Var.a(fo4.class, pe4.a);
        pi0Var.a(do4.class, le4.a);
        pi0Var.a(co4.class, je4.a);
        pi0Var.a(tu0.class, me4.a);
        pi0Var.a(eo4.class, ne4.a);
        pi0Var.a(bo4.class, he4.a);
        pi0Var.a(yn4.class, zd4.a);
        pi0Var.a(ao4.class, fe4.a);
        pi0Var.a(zn4.class, de4.a);
        pi0Var.a(to4.class, nf4.a);
        pi0Var.a(hm4.class, hb4.a);
        pi0Var.a(so4.class, lf4.a);
        pi0Var.a(uo4.class, pf4.a);
        pi0Var.a(gm4.class, fb4.a);
        pi0Var.a(im4.class, jb4.a);
        pi0Var.a(xq4.class, pj4.a);
        pi0Var.a(lq4.class, ri4.a);
        pi0Var.a(hr4.class, gk4.a);
        pi0Var.a(nq4.class, vi4.a);
        pi0Var.a(mq4.class, ti4.a);
        pi0Var.a(fr4.class, ek4.a);
        pi0Var.a(a54.class, n84.a);
        pi0Var.a(y44.class, p84.a);
        pi0Var.a(gr4.class, fk4.a);
        pi0Var.a(fm4.class, db4.a);
    }

    public Signature[] p(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    @Override // defpackage.eq1
    public void q(Exception exc) {
        Log.e("OptionalModuleUtils", "Failed to request modules install request", exc);
    }

    public String toString() {
        switch (this.a) {
            case 13:
                return "Metadata{mIsReversedHorizontal=false, mIsReversedVertical=false, mLocation=null}";
            case 18:
                return "ReusedSlotId";
            default:
                return super.toString();
        }
    }

    @Override // defpackage.l12
    public void f(int i2, Object obj) {
    }
}
