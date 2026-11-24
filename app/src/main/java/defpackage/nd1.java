package defpackage;

import com.ibm.icu.impl.number.Padder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nd1 {
    public static final x42 e = new x42("[\\p{L}\\p{M}\\p{N}]+");
    public final fq0 a = new e4(20);
    public final hg b = new hg();
    public String c = "";
    public boolean d = true;

    public static boolean a(String str, String str2) {
        return cs2.n(cq.v(Padder.FALLBACK_PADDING_STRING, str, Padder.FALLBACK_PADDING_STRING), Padder.FALLBACK_PADDING_STRING + str2 + Padder.FALLBACK_PADDING_STRING, false);
    }

    public static String c(String str) {
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = str.toLowerCase(locale);
        lowerCase.getClass();
        return zg2.d(x42.c(e, lowerCase), Padder.FALLBACK_PADDING_STRING, new va1(2), 30);
    }

    /* JADX WARN: Code duplicated, block: B:89:0x01f7 A[Catch: all -> 0x001a, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0016, B:11:0x001d, B:12:0x003d, B:14:0x0043, B:16:0x0062, B:18:0x0069, B:26:0x008c, B:34:0x00ac, B:79:0x0189, B:81:0x0190, B:83:0x01c6, B:96:0x0216, B:99:0x0223, B:101:0x0229, B:111:0x025d, B:104:0x0236, B:105:0x023f, B:109:0x024c, B:110:0x0255, B:98:0x021e, B:84:0x01cf, B:86:0x01d5, B:88:0x01ee, B:89:0x01f7, B:91:0x01fd, B:93:0x0203, B:94:0x020c, B:38:0x00bb, B:40:0x00d6, B:54:0x0107, B:55:0x0117, B:57:0x011d, B:59:0x0138, B:73:0x016d, B:62:0x0145, B:63:0x014a, B:65:0x0150, B:67:0x0160, B:70:0x0167, B:71:0x016a, B:44:0x00e3, B:45:0x00e8, B:47:0x00ee, B:49:0x00fe, B:52:0x0103, B:53:0x0106, B:29:0x0094, B:31:0x009b, B:21:0x0074, B:23:0x007b), top: B:116:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x020c A[Catch: all -> 0x001a, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0016, B:11:0x001d, B:12:0x003d, B:14:0x0043, B:16:0x0062, B:18:0x0069, B:26:0x008c, B:34:0x00ac, B:79:0x0189, B:81:0x0190, B:83:0x01c6, B:96:0x0216, B:99:0x0223, B:101:0x0229, B:111:0x025d, B:104:0x0236, B:105:0x023f, B:109:0x024c, B:110:0x0255, B:98:0x021e, B:84:0x01cf, B:86:0x01d5, B:88:0x01ee, B:89:0x01f7, B:91:0x01fd, B:93:0x0203, B:94:0x020c, B:38:0x00bb, B:40:0x00d6, B:54:0x0107, B:55:0x0117, B:57:0x011d, B:59:0x0138, B:73:0x016d, B:62:0x0145, B:63:0x014a, B:65:0x0150, B:67:0x0160, B:70:0x0167, B:71:0x016a, B:44:0x00e3, B:45:0x00e8, B:47:0x00ee, B:49:0x00fe, B:52:0x0103, B:53:0x0106, B:29:0x0094, B:31:0x009b, B:21:0x0074, B:23:0x007b), top: B:116:0x0009 }] */
    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized Map b(String str, String str2) {
        int i;
        int i2;
        int i3;
        Long l;
        int i4;
        int i5;
        str2.getClass();
        String strC = c(str);
        if (cs2.A(strC)) {
            return ji0.a;
        }
        String strC2 = c(str2);
        char c = ' ';
        int i6 = 0;
        Set setQ = mz.Q(cs2.N(strC, new char[]{' '}, 6));
        hg hgVar = this.b;
        ArrayList arrayList = new ArrayList();
        for (Object obj : hgVar) {
            char c2 = c;
            int i7 = i6;
            if (((Number) this.a.a()).longValue() - ((md1) obj).b <= 15000) {
                arrayList.add(obj);
            }
            c = c2;
            i6 = i7;
        }
        char c3 = c;
        int i8 = i6;
        if (arrayList.isEmpty()) {
            i = i8;
            break;
        }
        int size = arrayList.size();
        int i9 = i8;
        while (true) {
            if (i9 >= size) {
                i = i8;
                break;
            }
            Object obj2 = arrayList.get(i9);
            i9++;
            if (((md1) obj2).a.equals(strC)) {
                i = 1;
                break;
            }
        }
        if (arrayList.isEmpty()) {
            i2 = i8;
            break;
        }
        int size2 = arrayList.size();
        int i10 = i8;
        while (true) {
            if (i10 >= size2) {
                i2 = i8;
                break;
            }
            Object obj3 = arrayList.get(i10);
            i10++;
            if (a(((md1) obj3).a, strC)) {
                i2 = 1;
                break;
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            String str3 = ((md1) it.next()).a;
            char[] cArr = new char[1];
            cArr[i8] = c3;
            Set setQ2 = mz.Q(cs2.N(str3, cArr, 6));
            Set set = setQ;
            if ((set instanceof Collection) && set.isEmpty()) {
                i3 = i8;
            } else {
                Iterator it2 = set.iterator();
                i3 = i8;
                while (it2.hasNext()) {
                    if (setQ2.contains((String) it2.next()) && (i3 = i3 + 1) < 0) {
                        nz.m();
                        throw null;
                    }
                }
            }
            Long lValueOf = Long.valueOf((((long) i3) * 100) / ((long) setQ.size()));
            while (it.hasNext()) {
                String str4 = ((md1) it.next()).a;
                char[] cArr2 = new char[1];
                cArr2[i8] = c3;
                Set setQ3 = mz.Q(cs2.N(str4, cArr2, 6));
                Set set2 = setQ;
                if ((set2 instanceof Collection) && set2.isEmpty()) {
                    i4 = i8;
                    i5 = i4;
                } else {
                    Iterator it3 = set2.iterator();
                    i4 = i8;
                    while (it3.hasNext()) {
                        int i11 = i8;
                        if (setQ3.contains((String) it3.next()) && (i4 = i4 + 1) < 0) {
                            nz.m();
                            throw null;
                        }
                        i8 = i11;
                    }
                    i5 = i8;
                }
                Long lValueOf2 = Long.valueOf((((long) i4) * 100) / ((long) setQ.size()));
                if (lValueOf.compareTo(lValueOf2) < 0) {
                    lValueOf = lValueOf2;
                }
                i8 = i5;
            }
            l = lValueOf;
        } else {
            l = null;
        }
        boolean z = i8;
        long jLongValue = l != null ? l.longValue() : 0L;
        rg1 rg1Var = new rg1();
        rg1Var.put("inputFragments", 1L);
        rg1Var.put("inputCharacters", Long.valueOf(str.length()));
        char[] cArr3 = new char[1];
        cArr3[z ? 1 : 0] = c3;
        rg1Var.put("inputWords", Long.valueOf(cs2.N(strC, cArr3, 6).size()));
        if (strC.equals(strC2)) {
        } else if (!cs2.A(strC2)) {
            if (js2.k(strC, strC2 + Padder.FALLBACK_PADDING_STRING, z)) {
            } else if (cs2.A(strC2) && a(strC2, strC)) {
            }
        } else if (cs2.A(strC2)) {
        }
        if (i != 0) {
            rg1Var.put("inputExactRecentOutput", 1L);
        } else if (i2 != 0) {
            rg1Var.put("inputContainedInRecentOutput", 1L);
        }
        if (arrayList.isEmpty()) {
        } else if (jLongValue == 0) {
        } else if (setQ.size() < 3 || jLongValue < 80) {
        }
        return rg1Var.b();
    }

    public final synchronized void d(String str) {
        try {
            if (cs2.A(str)) {
                return;
            }
            if (this.d) {
                this.c = "";
            }
            Set set = mt0.b0;
            this.c = cs2.U(4000, co4.b(this.c, str));
            if (!this.d && !this.b.isEmpty()) {
                this.b.removeLast();
            }
            this.b.addLast(new md1(((Number) this.a.a()).longValue(), c(this.c)));
            this.d = false;
            while (true) {
                hg hgVar = this.b;
                if (hgVar.c <= 3) {
                    return;
                } else {
                    hgVar.removeFirst();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
