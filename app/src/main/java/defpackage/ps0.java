package defpackage;

import com.ibm.icu.impl.CalendarAstronomer;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ps0 {
    public final ms0 a;
    public final f0 b;
    public final an1 c;
    public List d;
    public long e;
    public long f;

    public ps0(ms0 ms0Var, f0 f0Var) {
        ms0Var.getClass();
        f0Var.getClass();
        this.a = ms0Var;
        this.b = f0Var;
        this.c = new an1();
        this.d = ii0.a;
        this.f = -1L;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x030a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x030c A[Catch: all -> 0x013f, TryCatch #6 {all -> 0x013f, blocks: (B:129:0x039f, B:131:0x03a3, B:133:0x03b3, B:132:0x03a7, B:79:0x0284, B:94:0x02cb, B:96:0x02d1, B:98:0x02d6, B:99:0x02eb, B:101:0x02f1, B:103:0x02fe, B:104:0x0302, B:97:0x02d4, B:107:0x030c, B:109:0x0314, B:113:0x0320, B:114:0x032b, B:116:0x0331, B:118:0x033e, B:119:0x0342, B:121:0x0348, B:122:0x0356, B:125:0x0362, B:73:0x0238, B:75:0x024d, B:61:0x01f1, B:63:0x01f5, B:65:0x01fb, B:69:0x020d, B:35:0x0131, B:57:0x01cf), top: B:178:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x0314 A[Catch: all -> 0x013f, TryCatch #6 {all -> 0x013f, blocks: (B:129:0x039f, B:131:0x03a3, B:133:0x03b3, B:132:0x03a7, B:79:0x0284, B:94:0x02cb, B:96:0x02d1, B:98:0x02d6, B:99:0x02eb, B:101:0x02f1, B:103:0x02fe, B:104:0x0302, B:97:0x02d4, B:107:0x030c, B:109:0x0314, B:113:0x0320, B:114:0x032b, B:116:0x0331, B:118:0x033e, B:119:0x0342, B:121:0x0348, B:122:0x0356, B:125:0x0362, B:73:0x0238, B:75:0x024d, B:61:0x01f1, B:63:0x01f5, B:65:0x01fb, B:69:0x020d, B:35:0x0131, B:57:0x01cf), top: B:178:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x031c  */
    /* JADX WARN: Code duplicated, block: B:124:0x035f  */
    /* JADX WARN: Code duplicated, block: B:127:0x0397  */
    /* JADX WARN: Code duplicated, block: B:128:0x0398  */
    /* JADX WARN: Code duplicated, block: B:131:0x03a3 A[Catch: all -> 0x013f, TryCatch #6 {all -> 0x013f, blocks: (B:129:0x039f, B:131:0x03a3, B:133:0x03b3, B:132:0x03a7, B:79:0x0284, B:94:0x02cb, B:96:0x02d1, B:98:0x02d6, B:99:0x02eb, B:101:0x02f1, B:103:0x02fe, B:104:0x0302, B:97:0x02d4, B:107:0x030c, B:109:0x0314, B:113:0x0320, B:114:0x032b, B:116:0x0331, B:118:0x033e, B:119:0x0342, B:121:0x0348, B:122:0x0356, B:125:0x0362, B:73:0x0238, B:75:0x024d, B:61:0x01f1, B:63:0x01f5, B:65:0x01fb, B:69:0x020d, B:35:0x0131, B:57:0x01cf), top: B:178:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x03a7 A[Catch: all -> 0x013f, TryCatch #6 {all -> 0x013f, blocks: (B:129:0x039f, B:131:0x03a3, B:133:0x03b3, B:132:0x03a7, B:79:0x0284, B:94:0x02cb, B:96:0x02d1, B:98:0x02d6, B:99:0x02eb, B:101:0x02f1, B:103:0x02fe, B:104:0x0302, B:97:0x02d4, B:107:0x030c, B:109:0x0314, B:113:0x0320, B:114:0x032b, B:116:0x0331, B:118:0x033e, B:119:0x0342, B:121:0x0348, B:122:0x0356, B:125:0x0362, B:73:0x0238, B:75:0x024d, B:61:0x01f1, B:63:0x01f5, B:65:0x01fb, B:69:0x020d, B:35:0x0131, B:57:0x01cf), top: B:178:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x03da  */
    /* JADX WARN: Code duplicated, block: B:139:0x03eb A[Catch: all -> 0x03fb, TryCatch #4 {all -> 0x03fb, blocks: (B:137:0x03e1, B:139:0x03eb, B:144:0x03fe, B:146:0x0402, B:149:0x0423, B:150:0x042d, B:151:0x0433, B:152:0x044f, B:154:0x0455, B:156:0x0462, B:157:0x0466, B:159:0x046c, B:160:0x047a), top: B:175:0x03e1 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x03fe A[Catch: all -> 0x03fb, TryCatch #4 {all -> 0x03fb, blocks: (B:137:0x03e1, B:139:0x03eb, B:144:0x03fe, B:146:0x0402, B:149:0x0423, B:150:0x042d, B:151:0x0433, B:152:0x044f, B:154:0x0455, B:156:0x0462, B:157:0x0466, B:159:0x046c, B:160:0x047a), top: B:175:0x03e1 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0402 A[Catch: all -> 0x03fb, TryCatch #4 {all -> 0x03fb, blocks: (B:137:0x03e1, B:139:0x03eb, B:144:0x03fe, B:146:0x0402, B:149:0x0423, B:150:0x042d, B:151:0x0433, B:152:0x044f, B:154:0x0455, B:156:0x0462, B:157:0x0466, B:159:0x046c, B:160:0x047a), top: B:175:0x03e1 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x0421 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:151:0x0433 A[Catch: all -> 0x03fb, TryCatch #4 {all -> 0x03fb, blocks: (B:137:0x03e1, B:139:0x03eb, B:144:0x03fe, B:146:0x0402, B:149:0x0423, B:150:0x042d, B:151:0x0433, B:152:0x044f, B:154:0x0455, B:156:0x0462, B:157:0x0466, B:159:0x046c, B:160:0x047a), top: B:175:0x03e1 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x0455 A[Catch: all -> 0x03fb, TryCatch #4 {all -> 0x03fb, blocks: (B:137:0x03e1, B:139:0x03eb, B:144:0x03fe, B:146:0x0402, B:149:0x0423, B:150:0x042d, B:151:0x0433, B:152:0x044f, B:154:0x0455, B:156:0x0462, B:157:0x0466, B:159:0x046c, B:160:0x047a), top: B:175:0x03e1 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x046c A[Catch: all -> 0x03fb, TryCatch #4 {all -> 0x03fb, blocks: (B:137:0x03e1, B:139:0x03eb, B:144:0x03fe, B:146:0x0402, B:149:0x0423, B:150:0x042d, B:151:0x0433, B:152:0x044f, B:154:0x0455, B:156:0x0462, B:157:0x0466, B:159:0x046c, B:160:0x047a), top: B:175:0x03e1 }] */
    /* JADX WARN: Code duplicated, block: B:160:0x047a A[Catch: all -> 0x03fb, TRY_LEAVE, TryCatch #4 {all -> 0x03fb, blocks: (B:137:0x03e1, B:139:0x03eb, B:144:0x03fe, B:146:0x0402, B:149:0x0423, B:150:0x042d, B:151:0x0433, B:152:0x044f, B:154:0x0455, B:156:0x0462, B:157:0x0466, B:159:0x046c, B:160:0x047a), top: B:175:0x03e1 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x0462 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x044f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:56:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:60:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:63:0x01f5 A[Catch: all -> 0x013f, TryCatch #6 {all -> 0x013f, blocks: (B:129:0x039f, B:131:0x03a3, B:133:0x03b3, B:132:0x03a7, B:79:0x0284, B:94:0x02cb, B:96:0x02d1, B:98:0x02d6, B:99:0x02eb, B:101:0x02f1, B:103:0x02fe, B:104:0x0302, B:97:0x02d4, B:107:0x030c, B:109:0x0314, B:113:0x0320, B:114:0x032b, B:116:0x0331, B:118:0x033e, B:119:0x0342, B:121:0x0348, B:122:0x0356, B:125:0x0362, B:73:0x0238, B:75:0x024d, B:61:0x01f1, B:63:0x01f5, B:65:0x01fb, B:69:0x020d, B:35:0x0131, B:57:0x01cf), top: B:178:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x020c  */
    /* JADX WARN: Code duplicated, block: B:71:0x022d  */
    /* JADX WARN: Code duplicated, block: B:72:0x022e  */
    /* JADX WARN: Code duplicated, block: B:75:0x024d A[Catch: all -> 0x013f, TryCatch #6 {all -> 0x013f, blocks: (B:129:0x039f, B:131:0x03a3, B:133:0x03b3, B:132:0x03a7, B:79:0x0284, B:94:0x02cb, B:96:0x02d1, B:98:0x02d6, B:99:0x02eb, B:101:0x02f1, B:103:0x02fe, B:104:0x0302, B:97:0x02d4, B:107:0x030c, B:109:0x0314, B:113:0x0320, B:114:0x032b, B:116:0x0331, B:118:0x033e, B:119:0x0342, B:121:0x0348, B:122:0x0356, B:125:0x0362, B:73:0x0238, B:75:0x024d, B:61:0x01f1, B:63:0x01f5, B:65:0x01fb, B:69:0x020d, B:35:0x0131, B:57:0x01cf), top: B:178:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x027c  */
    /* JADX WARN: Code duplicated, block: B:78:0x027e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:81:0x028e  */
    /* JADX WARN: Code duplicated, block: B:83:0x029e  */
    /* JADX WARN: Code duplicated, block: B:84:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:88:0x02bf A[ADDED_TO_REGION] */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(boolean z, y50 y50Var) {
        ns0 ns0Var;
        an1 an1Var;
        Object obj;
        an1 an1Var2;
        an1 an1Var3;
        boolean z2;
        int i;
        Object objI;
        an1 an1Var4;
        Object obj2;
        int i2;
        boolean z3;
        int i3;
        long jLongValue;
        Object obj3;
        long jCurrentTimeMillis;
        Object objF;
        an1 an1Var5;
        int i4;
        long j;
        Set set;
        Object objH;
        Set set2;
        Object obj4;
        an1 an1Var6;
        String str;
        String str2;
        Object objG;
        String str3;
        Object obj5;
        long j2;
        long j3;
        long j4;
        an1 an1Var7;
        Set set3;
        Object obj6;
        long j5;
        String str4;
        f0 f0Var;
        int i5;
        Object obj7;
        Set set4;
        long j6;
        Object objG2;
        int i6;
        long j7;
        int i7;
        Set set5;
        an1 an1Var8;
        Set set6;
        int i8;
        f0 f0Var2;
        boolean z4;
        long j8;
        long j9;
        int i9;
        an1 an1Var9;
        String str5;
        long j10;
        Set set7;
        String str6;
        int i10;
        int i11;
        long j11;
        Object objC;
        int i12;
        int i13;
        Object obj8;
        long j12;
        int i14;
        long j13;
        Object pd1Var;
        an1 an1Var10;
        an1 an1Var11;
        i72 i72Var;
        Object h72Var;
        long j14;
        String str7;
        long j15;
        an1 an1Var12;
        Set set8;
        Object obj9;
        an1 an1Var13;
        ArrayList arrayList;
        h72 h72Var2;
        if (y50Var instanceof ns0) {
            ns0Var = (ns0) y50Var;
            int i15 = ns0Var.Y;
            if ((i15 & Integer.MIN_VALUE) != 0) {
                ns0Var.Y = i15 - Integer.MIN_VALUE;
            } else {
                ns0Var = new ns0(this, y50Var);
            }
        } else {
            ns0Var = new ns0(this, y50Var);
        }
        Object objI2 = ns0Var.H;
        int i16 = ns0Var.Y;
        String str8 = "No compatible Gemini Live models are available for this key";
        f0 f0Var3 = this.b;
        Object obj10 = t70.a;
        try {
            switch (i16) {
                case 0:
                    bz3.g(objI2);
                    an1Var3 = this.c;
                    ns0Var.f = an1Var3;
                    z2 = z;
                    ns0Var.e = z2;
                    ns0Var.n = 0;
                    ns0Var.Y = 1;
                    if (an1Var3.e(ns0Var) != obj10) {
                        i = 0;
                        ns0Var.f = an1Var3;
                        ns0Var.e = z2;
                        ns0Var.n = i;
                        ns0Var.s = 0;
                        ns0Var.Y = 2;
                        objI = f0Var3.i(ns0Var);
                        if (objI != obj10) {
                            int i17 = i;
                            an1Var4 = an1Var3;
                            obj2 = objI;
                            i2 = i17;
                            z3 = z2;
                            i3 = 0;
                            try {
                                jLongValue = ((Number) obj2).longValue();
                                obj3 = obj10;
                                jCurrentTimeMillis = System.currentTimeMillis();
                                ns0Var.f = an1Var4;
                                ns0Var.e = z3;
                                ns0Var.n = i2;
                                ns0Var.s = i3;
                                ns0Var.u = jLongValue;
                                ns0Var.v = jCurrentTimeMillis;
                                ns0Var.Y = 3;
                                objF = f0Var3.f("gemini_live", ns0Var);
                                if (objF != obj3) {
                                    an1Var5 = an1Var4;
                                    i4 = i2;
                                    j = jLongValue;
                                    set = (Set) objF;
                                    ns0Var.f = an1Var5;
                                    ns0Var.i = set;
                                    ns0Var.e = z3;
                                    ns0Var.n = i4;
                                    ns0Var.s = i3;
                                    ns0Var.u = j;
                                    ns0Var.v = jCurrentTimeMillis;
                                    ns0Var.Y = 4;
                                    objH = f0Var3.h("gemini_live", ns0Var);
                                    if (objH != obj3) {
                                        set2 = set;
                                        obj4 = objH;
                                        an1Var6 = an1Var5;
                                        str = (String) obj4;
                                        if (str != null || set2.contains(str)) {
                                            str = null;
                                        } else {
                                            x42 x42Var = od1.a;
                                            if (od1.b(nz.h(str)).isEmpty()) {
                                                str = null;
                                            }
                                        }
                                        ns0Var.f = an1Var6;
                                        str2 = str8;
                                        ns0Var.i = set2;
                                        ns0Var.j = str;
                                        ns0Var.e = z3;
                                        ns0Var.n = i4;
                                        ns0Var.s = i3;
                                        ns0Var.u = j;
                                        ns0Var.v = jCurrentTimeMillis;
                                        ns0Var.w = jCurrentTimeMillis;
                                        ns0Var.Y = 5;
                                        objG = f0Var3.g("gemini_live", ns0Var);
                                        if (objG == obj3) {
                                            str3 = str;
                                            obj5 = objG;
                                            j2 = jCurrentTimeMillis;
                                            j3 = j;
                                            j4 = j2;
                                            an1Var7 = an1Var6;
                                            long jLongValue2 = ((Number) obj5).longValue();
                                            set3 = set2;
                                            obj6 = obj3;
                                            j5 = j2 - jLongValue2;
                                            if (this.f == j3) {
                                                j6 = this.e;
                                                ns0Var.f = an1Var7;
                                                ns0Var.i = set3;
                                                ns0Var.j = str3;
                                                ns0Var.e = z3;
                                                ns0Var.n = i4;
                                                ns0Var.s = i3;
                                                ns0Var.u = j3;
                                                ns0Var.v = j4;
                                                ns0Var.w = j6;
                                                ns0Var.x = j5;
                                                ns0Var.Y = 6;
                                                str4 = str3;
                                                f0Var = f0Var3;
                                                objG2 = f0Var.g("gemini_live", ns0Var);
                                                i6 = i3;
                                                obj7 = obj6;
                                                if (objG2 == obj7) {
                                                    return obj7;
                                                }
                                                j7 = j6;
                                                i7 = i6;
                                                set5 = set3;
                                                an1Var10 = an1Var7;
                                                if (j7 > ((Number) objG2).longValue()) {
                                                    Set set9 = set5;
                                                    f0Var2 = f0Var;
                                                    set6 = set9;
                                                    long j16 = j3;
                                                    z4 = z3;
                                                    j8 = j16;
                                                    i8 = i7;
                                                    j9 = j4;
                                                    i9 = 1;
                                                    an1Var9 = an1Var10;
                                                } else {
                                                    set4 = set5;
                                                    i5 = i7;
                                                    an1Var8 = an1Var10;
                                                }
                                                str5 = str4;
                                                if (!!z4 || i9 != 0 || str5 == null || 0 > j5 || j5 >= CalendarAstronomer.DAY_MS) {
                                                    if (z4) {
                                                        j10 = j5;
                                                    } else {
                                                        j10 = j5;
                                                        if (this.f == j8) {
                                                            j13 = j9 - this.e;
                                                            if (0 > j13 && j13 < CalendarAstronomer.DAY_MS) {
                                                                List list = this.d;
                                                                ArrayList arrayList2 = new ArrayList();
                                                                for (Object obj11 : list) {
                                                                    if (!set6.contains((String) obj11)) {
                                                                        arrayList2.add(obj11);
                                                                    }
                                                                }
                                                                if (arrayList2.isEmpty()) {
                                                                    pd1Var = new h72(new IllegalStateException(str2));
                                                                    an1Var13 = an1Var9;
                                                                } else {
                                                                    pd1Var = new pd1(j8, arrayList2);
                                                                    an1Var13 = an1Var9;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    String str9 = str2;
                                                    set7 = set6;
                                                    str6 = str9;
                                                    l2 l2Var = new l2(this, (x50) null, 3);
                                                    ns0Var.f = an1Var9;
                                                    ns0Var.i = set7;
                                                    ns0Var.j = str5;
                                                    ns0Var.e = z4;
                                                    ns0Var.n = i4;
                                                    ns0Var.s = i8;
                                                    ns0Var.u = j8;
                                                    ns0Var.v = j9;
                                                    ns0Var.t = i9;
                                                    i10 = i4;
                                                    i11 = i9;
                                                    j11 = j10;
                                                    ns0Var.w = j11;
                                                    ns0Var.Y = 7;
                                                    objC = xc4.c(8000L, l2Var, ns0Var);
                                                    if (objC == obj7) {
                                                        return obj7;
                                                    }
                                                    i12 = i8;
                                                    i13 = i10;
                                                    obj8 = objC;
                                                    j12 = j11;
                                                    i14 = i11;
                                                    an1Var11 = an1Var9;
                                                    i72Var = (i72) obj8;
                                                    if (i72Var != null) {
                                                        h72Var = i72Var.a;
                                                    } else {
                                                        h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                                    }
                                                    ns0Var.f = an1Var11;
                                                    ns0Var.i = set7;
                                                    ns0Var.j = h72Var;
                                                    ns0Var.k = str5;
                                                    ns0Var.e = z4;
                                                    ns0Var.n = i13;
                                                    ns0Var.s = i12;
                                                    ns0Var.u = j8;
                                                    ns0Var.v = j9;
                                                    ns0Var.t = i14;
                                                    ns0Var.w = j12;
                                                    ns0Var.Y = 8;
                                                    objI2 = f0Var2.i(ns0Var);
                                                    if (objI2 == obj7) {
                                                        return obj7;
                                                    }
                                                    j14 = j9;
                                                    str7 = str5;
                                                    j15 = j8;
                                                    an1Var12 = an1Var11;
                                                    set8 = set7;
                                                    obj9 = h72Var;
                                                    try {
                                                        if (((Number) objI2).longValue() != j15) {
                                                            h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                                        } else {
                                                            if (obj9 instanceof h72) {
                                                                Throwable thA = i72.a(obj9);
                                                                thA.getClass();
                                                                boolean zContains = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA));
                                                                if (str7 == null && zContains) {
                                                                    pd1Var = new pd1(j15, nz.h(str7));
                                                                } else {
                                                                    h72Var2 = new h72(thA);
                                                                }
                                                            } else {
                                                                x42 x42Var2 = od1.a;
                                                                bz3.g(obj9);
                                                                List listB = od1.b((List) obj9);
                                                                this.d = listB;
                                                                this.f = j15;
                                                                this.e = j14;
                                                                arrayList = new ArrayList();
                                                                for (Object obj12 : listB) {
                                                                    if (!set8.contains((String) obj12)) {
                                                                        arrayList.add(obj12);
                                                                    }
                                                                }
                                                                if (arrayList.isEmpty()) {
                                                                    h72Var2 = new h72(new IllegalStateException(str6));
                                                                } else {
                                                                    pd1Var = new pd1(j15, arrayList);
                                                                }
                                                            }
                                                            an1Var13 = an1Var12;
                                                        }
                                                        pd1Var = h72Var2;
                                                        an1Var13 = an1Var12;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        an1Var = an1Var12;
                                                        obj = null;
                                                        an1Var2 = an1Var;
                                                        an1Var2.h(obj);
                                                        throw th;
                                                    }
                                                } else {
                                                    List listT = mz.t(mz.G(nz.h(str5), this.f == j8 ? this.d : ii0.a));
                                                    ArrayList arrayList3 = new ArrayList();
                                                    for (Object obj13 : listT) {
                                                        if (!set6.contains((String) obj13)) {
                                                            arrayList3.add(obj13);
                                                        }
                                                    }
                                                    pd1Var = new pd1(j8, arrayList3);
                                                    an1Var13 = an1Var9;
                                                }
                                                an1Var13.h(null);
                                                return pd1Var;
                                            }
                                            str4 = str3;
                                            f0Var = f0Var3;
                                            i5 = i3;
                                            obj7 = obj6;
                                            set4 = set3;
                                            an1Var8 = an1Var7;
                                            f0 f0Var4 = f0Var;
                                            set6 = set4;
                                            i8 = i5;
                                            f0Var2 = f0Var4;
                                            long j17 = j3;
                                            z4 = z3;
                                            j8 = j17;
                                            j9 = j4;
                                            i9 = 0;
                                            an1Var9 = an1Var8;
                                            str5 = str4;
                                            if (!z4) {
                                                if (z4) {
                                                    j10 = j5;
                                                    if (this.f == j8) {
                                                        j13 = j9 - this.e;
                                                        if (0 > j13) {
                                                        }
                                                    }
                                                } else {
                                                    j10 = j5;
                                                }
                                                String str10 = str2;
                                                set7 = set6;
                                                str6 = str10;
                                                l2 l2Var2 = new l2(this, (x50) null, 3);
                                                ns0Var.f = an1Var9;
                                                ns0Var.i = set7;
                                                ns0Var.j = str5;
                                                ns0Var.e = z4;
                                                ns0Var.n = i4;
                                                ns0Var.s = i8;
                                                ns0Var.u = j8;
                                                ns0Var.v = j9;
                                                ns0Var.t = i9;
                                                i10 = i4;
                                                i11 = i9;
                                                j11 = j10;
                                                ns0Var.w = j11;
                                                ns0Var.Y = 7;
                                                objC = xc4.c(8000L, l2Var2, ns0Var);
                                                if (objC == obj7) {
                                                    return obj7;
                                                }
                                                i12 = i8;
                                                i13 = i10;
                                                obj8 = objC;
                                                j12 = j11;
                                                i14 = i11;
                                                an1Var11 = an1Var9;
                                                i72Var = (i72) obj8;
                                                if (i72Var != null) {
                                                    h72Var = i72Var.a;
                                                } else {
                                                    h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                                }
                                                ns0Var.f = an1Var11;
                                                ns0Var.i = set7;
                                                ns0Var.j = h72Var;
                                                ns0Var.k = str5;
                                                ns0Var.e = z4;
                                                ns0Var.n = i13;
                                                ns0Var.s = i12;
                                                ns0Var.u = j8;
                                                ns0Var.v = j9;
                                                ns0Var.t = i14;
                                                ns0Var.w = j12;
                                                ns0Var.Y = 8;
                                                objI2 = f0Var2.i(ns0Var);
                                                if (objI2 == obj7) {
                                                    return obj7;
                                                }
                                                j14 = j9;
                                                str7 = str5;
                                                j15 = j8;
                                                an1Var12 = an1Var11;
                                                set8 = set7;
                                                obj9 = h72Var;
                                                if (((Number) objI2).longValue() != j15) {
                                                    h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                                } else {
                                                    if (obj9 instanceof h72) {
                                                        Throwable thA2 = i72.a(obj9);
                                                        thA2.getClass();
                                                        boolean zContains2 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA2));
                                                        if (str7 == null) {
                                                        }
                                                        h72Var2 = new h72(thA2);
                                                    } else {
                                                        x42 x42Var3 = od1.a;
                                                        bz3.g(obj9);
                                                        List listB2 = od1.b((List) obj9);
                                                        this.d = listB2;
                                                        this.f = j15;
                                                        this.e = j14;
                                                        arrayList = new ArrayList();
                                                        while (r0.hasNext()) {
                                                            if (!set8.contains((String) obj12)) {
                                                                arrayList.add(obj12);
                                                            }
                                                        }
                                                        if (arrayList.isEmpty()) {
                                                            h72Var2 = new h72(new IllegalStateException(str6));
                                                        } else {
                                                            pd1Var = new pd1(j15, arrayList);
                                                        }
                                                    }
                                                    an1Var13 = an1Var12;
                                                }
                                                pd1Var = h72Var2;
                                                an1Var13 = an1Var12;
                                            } else {
                                                if (z4) {
                                                    j10 = j5;
                                                    if (this.f == j8) {
                                                        j13 = j9 - this.e;
                                                        if (0 > j13) {
                                                        }
                                                    }
                                                } else {
                                                    j10 = j5;
                                                }
                                                String str11 = str2;
                                                set7 = set6;
                                                str6 = str11;
                                                l2 l2Var3 = new l2(this, (x50) null, 3);
                                                ns0Var.f = an1Var9;
                                                ns0Var.i = set7;
                                                ns0Var.j = str5;
                                                ns0Var.e = z4;
                                                ns0Var.n = i4;
                                                ns0Var.s = i8;
                                                ns0Var.u = j8;
                                                ns0Var.v = j9;
                                                ns0Var.t = i9;
                                                i10 = i4;
                                                i11 = i9;
                                                j11 = j10;
                                                ns0Var.w = j11;
                                                ns0Var.Y = 7;
                                                objC = xc4.c(8000L, l2Var3, ns0Var);
                                                if (objC == obj7) {
                                                    return obj7;
                                                }
                                                i12 = i8;
                                                i13 = i10;
                                                obj8 = objC;
                                                j12 = j11;
                                                i14 = i11;
                                                an1Var11 = an1Var9;
                                                i72Var = (i72) obj8;
                                                if (i72Var != null) {
                                                    h72Var = i72Var.a;
                                                } else {
                                                    h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                                }
                                                ns0Var.f = an1Var11;
                                                ns0Var.i = set7;
                                                ns0Var.j = h72Var;
                                                ns0Var.k = str5;
                                                ns0Var.e = z4;
                                                ns0Var.n = i13;
                                                ns0Var.s = i12;
                                                ns0Var.u = j8;
                                                ns0Var.v = j9;
                                                ns0Var.t = i14;
                                                ns0Var.w = j12;
                                                ns0Var.Y = 8;
                                                objI2 = f0Var2.i(ns0Var);
                                                if (objI2 == obj7) {
                                                    return obj7;
                                                }
                                                j14 = j9;
                                                str7 = str5;
                                                j15 = j8;
                                                an1Var12 = an1Var11;
                                                set8 = set7;
                                                obj9 = h72Var;
                                                if (((Number) objI2).longValue() != j15) {
                                                    h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                                } else {
                                                    if (obj9 instanceof h72) {
                                                        Throwable thA3 = i72.a(obj9);
                                                        thA3.getClass();
                                                        boolean zContains3 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA3));
                                                        if (str7 == null) {
                                                        }
                                                        h72Var2 = new h72(thA3);
                                                    } else {
                                                        x42 x42Var4 = od1.a;
                                                        bz3.g(obj9);
                                                        List listB3 = od1.b((List) obj9);
                                                        this.d = listB3;
                                                        this.f = j15;
                                                        this.e = j14;
                                                        arrayList = new ArrayList();
                                                        while (r0.hasNext()) {
                                                            if (!set8.contains((String) obj12)) {
                                                                arrayList.add(obj12);
                                                            }
                                                        }
                                                        if (arrayList.isEmpty()) {
                                                            h72Var2 = new h72(new IllegalStateException(str6));
                                                        } else {
                                                            pd1Var = new pd1(j15, arrayList);
                                                        }
                                                    }
                                                    an1Var13 = an1Var12;
                                                }
                                                pd1Var = h72Var2;
                                                an1Var13 = an1Var12;
                                            }
                                            an1Var13.h(null);
                                            return pd1Var;
                                        }
                                    }
                                }
                                return obj3;
                            } catch (Throwable th2) {
                                th = th2;
                                an1Var = an1Var4;
                                obj = null;
                                an1Var2 = an1Var;
                                an1Var2.h(obj);
                                throw th;
                            }
                        }
                    }
                    return obj10;
                case 1:
                    int i18 = ns0Var.n;
                    z2 = ns0Var.e;
                    an1 an1Var14 = ns0Var.f;
                    bz3.g(objI2);
                    i = i18;
                    an1Var3 = an1Var14;
                    ns0Var.f = an1Var3;
                    ns0Var.e = z2;
                    ns0Var.n = i;
                    ns0Var.s = 0;
                    ns0Var.Y = 2;
                    objI = f0Var3.i(ns0Var);
                    if (objI != obj10) {
                        int i19 = i;
                        an1Var4 = an1Var3;
                        obj2 = objI;
                        i2 = i19;
                        z3 = z2;
                        i3 = 0;
                        jLongValue = ((Number) obj2).longValue();
                        obj3 = obj10;
                        jCurrentTimeMillis = System.currentTimeMillis();
                        ns0Var.f = an1Var4;
                        ns0Var.e = z3;
                        ns0Var.n = i2;
                        ns0Var.s = i3;
                        ns0Var.u = jLongValue;
                        ns0Var.v = jCurrentTimeMillis;
                        ns0Var.Y = 3;
                        objF = f0Var3.f("gemini_live", ns0Var);
                        if (objF != obj3) {
                            an1Var5 = an1Var4;
                            i4 = i2;
                            j = jLongValue;
                            set = (Set) objF;
                            ns0Var.f = an1Var5;
                            ns0Var.i = set;
                            ns0Var.e = z3;
                            ns0Var.n = i4;
                            ns0Var.s = i3;
                            ns0Var.u = j;
                            ns0Var.v = jCurrentTimeMillis;
                            ns0Var.Y = 4;
                            objH = f0Var3.h("gemini_live", ns0Var);
                            if (objH != obj3) {
                                set2 = set;
                                obj4 = objH;
                                an1Var6 = an1Var5;
                                str = (String) obj4;
                                if (str != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                ns0Var.f = an1Var6;
                                str2 = str8;
                                ns0Var.i = set2;
                                ns0Var.j = str;
                                ns0Var.e = z3;
                                ns0Var.n = i4;
                                ns0Var.s = i3;
                                ns0Var.u = j;
                                ns0Var.v = jCurrentTimeMillis;
                                ns0Var.w = jCurrentTimeMillis;
                                ns0Var.Y = 5;
                                objG = f0Var3.g("gemini_live", ns0Var);
                                if (objG == obj3) {
                                    str3 = str;
                                    obj5 = objG;
                                    j2 = jCurrentTimeMillis;
                                    j3 = j;
                                    j4 = j2;
                                    an1Var7 = an1Var6;
                                    long jLongValue3 = ((Number) obj5).longValue();
                                    set3 = set2;
                                    obj6 = obj3;
                                    j5 = j2 - jLongValue3;
                                    if (this.f == j3) {
                                        j6 = this.e;
                                        ns0Var.f = an1Var7;
                                        ns0Var.i = set3;
                                        ns0Var.j = str3;
                                        ns0Var.e = z3;
                                        ns0Var.n = i4;
                                        ns0Var.s = i3;
                                        ns0Var.u = j3;
                                        ns0Var.v = j4;
                                        ns0Var.w = j6;
                                        ns0Var.x = j5;
                                        ns0Var.Y = 6;
                                        str4 = str3;
                                        f0Var = f0Var3;
                                        objG2 = f0Var.g("gemini_live", ns0Var);
                                        i6 = i3;
                                        obj7 = obj6;
                                        if (objG2 == obj7) {
                                            return obj7;
                                        }
                                        j7 = j6;
                                        i7 = i6;
                                        set5 = set3;
                                        an1Var10 = an1Var7;
                                        if (j7 > ((Number) objG2).longValue()) {
                                            Set set10 = set5;
                                            f0Var2 = f0Var;
                                            set6 = set10;
                                            long j18 = j3;
                                            z4 = z3;
                                            j8 = j18;
                                            i8 = i7;
                                            j9 = j4;
                                            i9 = 1;
                                            an1Var9 = an1Var10;
                                        } else {
                                            set4 = set5;
                                            i5 = i7;
                                            an1Var8 = an1Var10;
                                        }
                                        str5 = str4;
                                        if (!z4) {
                                            if (z4) {
                                                j10 = j5;
                                                if (this.f == j8) {
                                                    j13 = j9 - this.e;
                                                    if (0 > j13) {
                                                    }
                                                }
                                            } else {
                                                j10 = j5;
                                            }
                                            String str12 = str2;
                                            set7 = set6;
                                            str6 = str12;
                                            l2 l2Var4 = new l2(this, (x50) null, 3);
                                            ns0Var.f = an1Var9;
                                            ns0Var.i = set7;
                                            ns0Var.j = str5;
                                            ns0Var.e = z4;
                                            ns0Var.n = i4;
                                            ns0Var.s = i8;
                                            ns0Var.u = j8;
                                            ns0Var.v = j9;
                                            ns0Var.t = i9;
                                            i10 = i4;
                                            i11 = i9;
                                            j11 = j10;
                                            ns0Var.w = j11;
                                            ns0Var.Y = 7;
                                            objC = xc4.c(8000L, l2Var4, ns0Var);
                                            if (objC == obj7) {
                                                return obj7;
                                            }
                                            i12 = i8;
                                            i13 = i10;
                                            obj8 = objC;
                                            j12 = j11;
                                            i14 = i11;
                                            an1Var11 = an1Var9;
                                            i72Var = (i72) obj8;
                                            if (i72Var != null) {
                                                h72Var = i72Var.a;
                                            } else {
                                                h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                            }
                                            ns0Var.f = an1Var11;
                                            ns0Var.i = set7;
                                            ns0Var.j = h72Var;
                                            ns0Var.k = str5;
                                            ns0Var.e = z4;
                                            ns0Var.n = i13;
                                            ns0Var.s = i12;
                                            ns0Var.u = j8;
                                            ns0Var.v = j9;
                                            ns0Var.t = i14;
                                            ns0Var.w = j12;
                                            ns0Var.Y = 8;
                                            objI2 = f0Var2.i(ns0Var);
                                            if (objI2 == obj7) {
                                                return obj7;
                                            }
                                            j14 = j9;
                                            str7 = str5;
                                            j15 = j8;
                                            an1Var12 = an1Var11;
                                            set8 = set7;
                                            obj9 = h72Var;
                                            if (((Number) objI2).longValue() != j15) {
                                                h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                            } else {
                                                if (obj9 instanceof h72) {
                                                    Throwable thA4 = i72.a(obj9);
                                                    thA4.getClass();
                                                    boolean zContains4 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA4));
                                                    if (str7 == null) {
                                                    }
                                                    h72Var2 = new h72(thA4);
                                                } else {
                                                    x42 x42Var5 = od1.a;
                                                    bz3.g(obj9);
                                                    List listB4 = od1.b((List) obj9);
                                                    this.d = listB4;
                                                    this.f = j15;
                                                    this.e = j14;
                                                    arrayList = new ArrayList();
                                                    while (r0.hasNext()) {
                                                        if (!set8.contains((String) obj12)) {
                                                            arrayList.add(obj12);
                                                        }
                                                    }
                                                    if (arrayList.isEmpty()) {
                                                        h72Var2 = new h72(new IllegalStateException(str6));
                                                    } else {
                                                        pd1Var = new pd1(j15, arrayList);
                                                    }
                                                }
                                                an1Var13 = an1Var12;
                                            }
                                            pd1Var = h72Var2;
                                            an1Var13 = an1Var12;
                                            break;
                                        } else {
                                            if (z4) {
                                                j10 = j5;
                                                if (this.f == j8) {
                                                    j13 = j9 - this.e;
                                                    if (0 > j13) {
                                                    }
                                                }
                                            } else {
                                                j10 = j5;
                                            }
                                            String str13 = str2;
                                            set7 = set6;
                                            str6 = str13;
                                            l2 l2Var5 = new l2(this, (x50) null, 3);
                                            ns0Var.f = an1Var9;
                                            ns0Var.i = set7;
                                            ns0Var.j = str5;
                                            ns0Var.e = z4;
                                            ns0Var.n = i4;
                                            ns0Var.s = i8;
                                            ns0Var.u = j8;
                                            ns0Var.v = j9;
                                            ns0Var.t = i9;
                                            i10 = i4;
                                            i11 = i9;
                                            j11 = j10;
                                            ns0Var.w = j11;
                                            ns0Var.Y = 7;
                                            objC = xc4.c(8000L, l2Var5, ns0Var);
                                            if (objC == obj7) {
                                                return obj7;
                                            }
                                            i12 = i8;
                                            i13 = i10;
                                            obj8 = objC;
                                            j12 = j11;
                                            i14 = i11;
                                            an1Var11 = an1Var9;
                                            i72Var = (i72) obj8;
                                            if (i72Var != null) {
                                                h72Var = i72Var.a;
                                            } else {
                                                h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                            }
                                            ns0Var.f = an1Var11;
                                            ns0Var.i = set7;
                                            ns0Var.j = h72Var;
                                            ns0Var.k = str5;
                                            ns0Var.e = z4;
                                            ns0Var.n = i13;
                                            ns0Var.s = i12;
                                            ns0Var.u = j8;
                                            ns0Var.v = j9;
                                            ns0Var.t = i14;
                                            ns0Var.w = j12;
                                            ns0Var.Y = 8;
                                            objI2 = f0Var2.i(ns0Var);
                                            if (objI2 == obj7) {
                                                return obj7;
                                            }
                                            j14 = j9;
                                            str7 = str5;
                                            j15 = j8;
                                            an1Var12 = an1Var11;
                                            set8 = set7;
                                            obj9 = h72Var;
                                            if (((Number) objI2).longValue() != j15) {
                                                h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                            } else {
                                                if (obj9 instanceof h72) {
                                                    Throwable thA5 = i72.a(obj9);
                                                    thA5.getClass();
                                                    boolean zContains5 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA5));
                                                    if (str7 == null) {
                                                    }
                                                    h72Var2 = new h72(thA5);
                                                } else {
                                                    x42 x42Var6 = od1.a;
                                                    bz3.g(obj9);
                                                    List listB5 = od1.b((List) obj9);
                                                    this.d = listB5;
                                                    this.f = j15;
                                                    this.e = j14;
                                                    arrayList = new ArrayList();
                                                    while (r0.hasNext()) {
                                                        if (!set8.contains((String) obj12)) {
                                                            arrayList.add(obj12);
                                                        }
                                                    }
                                                    if (arrayList.isEmpty()) {
                                                        h72Var2 = new h72(new IllegalStateException(str6));
                                                    } else {
                                                        pd1Var = new pd1(j15, arrayList);
                                                    }
                                                }
                                                an1Var13 = an1Var12;
                                            }
                                            pd1Var = h72Var2;
                                            an1Var13 = an1Var12;
                                            break;
                                        }
                                        an1Var13.h(null);
                                        return pd1Var;
                                    }
                                    str4 = str3;
                                    f0Var = f0Var3;
                                    i5 = i3;
                                    obj7 = obj6;
                                    set4 = set3;
                                    an1Var8 = an1Var7;
                                    f0 f0Var5 = f0Var;
                                    set6 = set4;
                                    i8 = i5;
                                    f0Var2 = f0Var5;
                                    long j19 = j3;
                                    z4 = z3;
                                    j8 = j19;
                                    j9 = j4;
                                    i9 = 0;
                                    an1Var9 = an1Var8;
                                    str5 = str4;
                                    if (!z4) {
                                        if (z4) {
                                            j10 = j5;
                                            if (this.f == j8) {
                                                j13 = j9 - this.e;
                                                if (0 > j13) {
                                                }
                                            }
                                        } else {
                                            j10 = j5;
                                        }
                                        String str14 = str2;
                                        set7 = set6;
                                        str6 = str14;
                                        l2 l2Var6 = new l2(this, (x50) null, 3);
                                        ns0Var.f = an1Var9;
                                        ns0Var.i = set7;
                                        ns0Var.j = str5;
                                        ns0Var.e = z4;
                                        ns0Var.n = i4;
                                        ns0Var.s = i8;
                                        ns0Var.u = j8;
                                        ns0Var.v = j9;
                                        ns0Var.t = i9;
                                        i10 = i4;
                                        i11 = i9;
                                        j11 = j10;
                                        ns0Var.w = j11;
                                        ns0Var.Y = 7;
                                        objC = xc4.c(8000L, l2Var6, ns0Var);
                                        if (objC == obj7) {
                                            return obj7;
                                        }
                                        i12 = i8;
                                        i13 = i10;
                                        obj8 = objC;
                                        j12 = j11;
                                        i14 = i11;
                                        an1Var11 = an1Var9;
                                        i72Var = (i72) obj8;
                                        if (i72Var != null) {
                                            h72Var = i72Var.a;
                                        } else {
                                            h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                        }
                                        ns0Var.f = an1Var11;
                                        ns0Var.i = set7;
                                        ns0Var.j = h72Var;
                                        ns0Var.k = str5;
                                        ns0Var.e = z4;
                                        ns0Var.n = i13;
                                        ns0Var.s = i12;
                                        ns0Var.u = j8;
                                        ns0Var.v = j9;
                                        ns0Var.t = i14;
                                        ns0Var.w = j12;
                                        ns0Var.Y = 8;
                                        objI2 = f0Var2.i(ns0Var);
                                        if (objI2 == obj7) {
                                            return obj7;
                                        }
                                        j14 = j9;
                                        str7 = str5;
                                        j15 = j8;
                                        an1Var12 = an1Var11;
                                        set8 = set7;
                                        obj9 = h72Var;
                                        if (((Number) objI2).longValue() != j15) {
                                            h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                        } else {
                                            if (obj9 instanceof h72) {
                                                Throwable thA6 = i72.a(obj9);
                                                thA6.getClass();
                                                boolean zContains6 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA6));
                                                if (str7 == null) {
                                                }
                                                h72Var2 = new h72(thA6);
                                            } else {
                                                x42 x42Var7 = od1.a;
                                                bz3.g(obj9);
                                                List listB6 = od1.b((List) obj9);
                                                this.d = listB6;
                                                this.f = j15;
                                                this.e = j14;
                                                arrayList = new ArrayList();
                                                while (r0.hasNext()) {
                                                    if (!set8.contains((String) obj12)) {
                                                        arrayList.add(obj12);
                                                    }
                                                }
                                                if (arrayList.isEmpty()) {
                                                    h72Var2 = new h72(new IllegalStateException(str6));
                                                } else {
                                                    pd1Var = new pd1(j15, arrayList);
                                                }
                                            }
                                            an1Var13 = an1Var12;
                                        }
                                        pd1Var = h72Var2;
                                        an1Var13 = an1Var12;
                                        break;
                                    } else {
                                        if (z4) {
                                            j10 = j5;
                                            if (this.f == j8) {
                                                j13 = j9 - this.e;
                                                if (0 > j13) {
                                                }
                                            }
                                        } else {
                                            j10 = j5;
                                        }
                                        String str15 = str2;
                                        set7 = set6;
                                        str6 = str15;
                                        l2 l2Var7 = new l2(this, (x50) null, 3);
                                        ns0Var.f = an1Var9;
                                        ns0Var.i = set7;
                                        ns0Var.j = str5;
                                        ns0Var.e = z4;
                                        ns0Var.n = i4;
                                        ns0Var.s = i8;
                                        ns0Var.u = j8;
                                        ns0Var.v = j9;
                                        ns0Var.t = i9;
                                        i10 = i4;
                                        i11 = i9;
                                        j11 = j10;
                                        ns0Var.w = j11;
                                        ns0Var.Y = 7;
                                        objC = xc4.c(8000L, l2Var7, ns0Var);
                                        if (objC == obj7) {
                                            return obj7;
                                        }
                                        i12 = i8;
                                        i13 = i10;
                                        obj8 = objC;
                                        j12 = j11;
                                        i14 = i11;
                                        an1Var11 = an1Var9;
                                        i72Var = (i72) obj8;
                                        if (i72Var != null) {
                                            h72Var = i72Var.a;
                                        } else {
                                            h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                        }
                                        ns0Var.f = an1Var11;
                                        ns0Var.i = set7;
                                        ns0Var.j = h72Var;
                                        ns0Var.k = str5;
                                        ns0Var.e = z4;
                                        ns0Var.n = i13;
                                        ns0Var.s = i12;
                                        ns0Var.u = j8;
                                        ns0Var.v = j9;
                                        ns0Var.t = i14;
                                        ns0Var.w = j12;
                                        ns0Var.Y = 8;
                                        objI2 = f0Var2.i(ns0Var);
                                        if (objI2 == obj7) {
                                            return obj7;
                                        }
                                        j14 = j9;
                                        str7 = str5;
                                        j15 = j8;
                                        an1Var12 = an1Var11;
                                        set8 = set7;
                                        obj9 = h72Var;
                                        if (((Number) objI2).longValue() != j15) {
                                            h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                        } else {
                                            if (obj9 instanceof h72) {
                                                Throwable thA7 = i72.a(obj9);
                                                thA7.getClass();
                                                boolean zContains7 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA7));
                                                if (str7 == null) {
                                                }
                                                h72Var2 = new h72(thA7);
                                            } else {
                                                x42 x42Var8 = od1.a;
                                                bz3.g(obj9);
                                                List listB7 = od1.b((List) obj9);
                                                this.d = listB7;
                                                this.f = j15;
                                                this.e = j14;
                                                arrayList = new ArrayList();
                                                while (r0.hasNext()) {
                                                    if (!set8.contains((String) obj12)) {
                                                        arrayList.add(obj12);
                                                    }
                                                }
                                                if (arrayList.isEmpty()) {
                                                    h72Var2 = new h72(new IllegalStateException(str6));
                                                } else {
                                                    pd1Var = new pd1(j15, arrayList);
                                                }
                                            }
                                            an1Var13 = an1Var12;
                                        }
                                        pd1Var = h72Var2;
                                        an1Var13 = an1Var12;
                                        break;
                                    }
                                    an1Var13.h(null);
                                    return pd1Var;
                                }
                            }
                        }
                        return obj3;
                    }
                    return obj10;
                case 2:
                    str8 = "No compatible Gemini Live models are available for this key";
                    int i20 = ns0Var.s;
                    int i21 = ns0Var.n;
                    boolean z5 = ns0Var.e;
                    an1 an1Var15 = ns0Var.f;
                    try {
                        bz3.g(objI2);
                        i2 = i21;
                        z3 = z5;
                        an1Var4 = an1Var15;
                        i3 = i20;
                        obj2 = objI2;
                        jLongValue = ((Number) obj2).longValue();
                        obj3 = obj10;
                        jCurrentTimeMillis = System.currentTimeMillis();
                        ns0Var.f = an1Var4;
                        ns0Var.e = z3;
                        ns0Var.n = i2;
                        ns0Var.s = i3;
                        ns0Var.u = jLongValue;
                        ns0Var.v = jCurrentTimeMillis;
                        ns0Var.Y = 3;
                        objF = f0Var3.f("gemini_live", ns0Var);
                        if (objF != obj3) {
                            an1Var5 = an1Var4;
                            i4 = i2;
                            j = jLongValue;
                            set = (Set) objF;
                            ns0Var.f = an1Var5;
                            ns0Var.i = set;
                            ns0Var.e = z3;
                            ns0Var.n = i4;
                            ns0Var.s = i3;
                            ns0Var.u = j;
                            ns0Var.v = jCurrentTimeMillis;
                            ns0Var.Y = 4;
                            objH = f0Var3.h("gemini_live", ns0Var);
                            if (objH != obj3) {
                                set2 = set;
                                obj4 = objH;
                                an1Var6 = an1Var5;
                                str = (String) obj4;
                                if (str != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                ns0Var.f = an1Var6;
                                str2 = str8;
                                ns0Var.i = set2;
                                ns0Var.j = str;
                                ns0Var.e = z3;
                                ns0Var.n = i4;
                                ns0Var.s = i3;
                                ns0Var.u = j;
                                ns0Var.v = jCurrentTimeMillis;
                                ns0Var.w = jCurrentTimeMillis;
                                ns0Var.Y = 5;
                                objG = f0Var3.g("gemini_live", ns0Var);
                                if (objG == obj3) {
                                    str3 = str;
                                    obj5 = objG;
                                    j2 = jCurrentTimeMillis;
                                    j3 = j;
                                    j4 = j2;
                                    an1Var7 = an1Var6;
                                    long jLongValue4 = ((Number) obj5).longValue();
                                    set3 = set2;
                                    obj6 = obj3;
                                    j5 = j2 - jLongValue4;
                                    if (this.f == j3) {
                                        j6 = this.e;
                                        ns0Var.f = an1Var7;
                                        ns0Var.i = set3;
                                        ns0Var.j = str3;
                                        ns0Var.e = z3;
                                        ns0Var.n = i4;
                                        ns0Var.s = i3;
                                        ns0Var.u = j3;
                                        ns0Var.v = j4;
                                        ns0Var.w = j6;
                                        ns0Var.x = j5;
                                        ns0Var.Y = 6;
                                        str4 = str3;
                                        f0Var = f0Var3;
                                        objG2 = f0Var.g("gemini_live", ns0Var);
                                        i6 = i3;
                                        obj7 = obj6;
                                        if (objG2 == obj7) {
                                            return obj7;
                                        }
                                        j7 = j6;
                                        i7 = i6;
                                        set5 = set3;
                                        an1Var10 = an1Var7;
                                        if (j7 > ((Number) objG2).longValue()) {
                                            Set set11 = set5;
                                            f0Var2 = f0Var;
                                            set6 = set11;
                                            long j110 = j3;
                                            z4 = z3;
                                            j8 = j110;
                                            i8 = i7;
                                            j9 = j4;
                                            i9 = 1;
                                            an1Var9 = an1Var10;
                                        } else {
                                            set4 = set5;
                                            i5 = i7;
                                            an1Var8 = an1Var10;
                                        }
                                        str5 = str4;
                                        if (!z4) {
                                            if (z4) {
                                                j10 = j5;
                                                if (this.f == j8) {
                                                    j13 = j9 - this.e;
                                                    if (0 > j13) {
                                                    }
                                                }
                                            } else {
                                                j10 = j5;
                                            }
                                            String str16 = str2;
                                            set7 = set6;
                                            str6 = str16;
                                            l2 l2Var8 = new l2(this, (x50) null, 3);
                                            ns0Var.f = an1Var9;
                                            ns0Var.i = set7;
                                            ns0Var.j = str5;
                                            ns0Var.e = z4;
                                            ns0Var.n = i4;
                                            ns0Var.s = i8;
                                            ns0Var.u = j8;
                                            ns0Var.v = j9;
                                            ns0Var.t = i9;
                                            i10 = i4;
                                            i11 = i9;
                                            j11 = j10;
                                            ns0Var.w = j11;
                                            ns0Var.Y = 7;
                                            objC = xc4.c(8000L, l2Var8, ns0Var);
                                            if (objC == obj7) {
                                                return obj7;
                                            }
                                            i12 = i8;
                                            i13 = i10;
                                            obj8 = objC;
                                            j12 = j11;
                                            i14 = i11;
                                            an1Var11 = an1Var9;
                                            i72Var = (i72) obj8;
                                            if (i72Var != null) {
                                                h72Var = i72Var.a;
                                            } else {
                                                h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                            }
                                            ns0Var.f = an1Var11;
                                            ns0Var.i = set7;
                                            ns0Var.j = h72Var;
                                            ns0Var.k = str5;
                                            ns0Var.e = z4;
                                            ns0Var.n = i13;
                                            ns0Var.s = i12;
                                            ns0Var.u = j8;
                                            ns0Var.v = j9;
                                            ns0Var.t = i14;
                                            ns0Var.w = j12;
                                            ns0Var.Y = 8;
                                            objI2 = f0Var2.i(ns0Var);
                                            if (objI2 == obj7) {
                                                return obj7;
                                            }
                                            j14 = j9;
                                            str7 = str5;
                                            j15 = j8;
                                            an1Var12 = an1Var11;
                                            set8 = set7;
                                            obj9 = h72Var;
                                            if (((Number) objI2).longValue() != j15) {
                                                h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                            } else {
                                                if (obj9 instanceof h72) {
                                                    Throwable thA8 = i72.a(obj9);
                                                    thA8.getClass();
                                                    boolean zContains8 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA8));
                                                    if (str7 == null) {
                                                    }
                                                    h72Var2 = new h72(thA8);
                                                } else {
                                                    x42 x42Var9 = od1.a;
                                                    bz3.g(obj9);
                                                    List listB8 = od1.b((List) obj9);
                                                    this.d = listB8;
                                                    this.f = j15;
                                                    this.e = j14;
                                                    arrayList = new ArrayList();
                                                    while (r0.hasNext()) {
                                                        if (!set8.contains((String) obj12)) {
                                                            arrayList.add(obj12);
                                                        }
                                                    }
                                                    if (arrayList.isEmpty()) {
                                                        h72Var2 = new h72(new IllegalStateException(str6));
                                                    } else {
                                                        pd1Var = new pd1(j15, arrayList);
                                                    }
                                                }
                                                an1Var13 = an1Var12;
                                            }
                                            pd1Var = h72Var2;
                                            an1Var13 = an1Var12;
                                            break;
                                        } else {
                                            if (z4) {
                                                j10 = j5;
                                                if (this.f == j8) {
                                                    j13 = j9 - this.e;
                                                    if (0 > j13) {
                                                    }
                                                }
                                            } else {
                                                j10 = j5;
                                            }
                                            String str17 = str2;
                                            set7 = set6;
                                            str6 = str17;
                                            l2 l2Var9 = new l2(this, (x50) null, 3);
                                            ns0Var.f = an1Var9;
                                            ns0Var.i = set7;
                                            ns0Var.j = str5;
                                            ns0Var.e = z4;
                                            ns0Var.n = i4;
                                            ns0Var.s = i8;
                                            ns0Var.u = j8;
                                            ns0Var.v = j9;
                                            ns0Var.t = i9;
                                            i10 = i4;
                                            i11 = i9;
                                            j11 = j10;
                                            ns0Var.w = j11;
                                            ns0Var.Y = 7;
                                            objC = xc4.c(8000L, l2Var9, ns0Var);
                                            if (objC == obj7) {
                                                return obj7;
                                            }
                                            i12 = i8;
                                            i13 = i10;
                                            obj8 = objC;
                                            j12 = j11;
                                            i14 = i11;
                                            an1Var11 = an1Var9;
                                            i72Var = (i72) obj8;
                                            if (i72Var != null) {
                                                h72Var = i72Var.a;
                                            } else {
                                                h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                            }
                                            ns0Var.f = an1Var11;
                                            ns0Var.i = set7;
                                            ns0Var.j = h72Var;
                                            ns0Var.k = str5;
                                            ns0Var.e = z4;
                                            ns0Var.n = i13;
                                            ns0Var.s = i12;
                                            ns0Var.u = j8;
                                            ns0Var.v = j9;
                                            ns0Var.t = i14;
                                            ns0Var.w = j12;
                                            ns0Var.Y = 8;
                                            objI2 = f0Var2.i(ns0Var);
                                            if (objI2 == obj7) {
                                                return obj7;
                                            }
                                            j14 = j9;
                                            str7 = str5;
                                            j15 = j8;
                                            an1Var12 = an1Var11;
                                            set8 = set7;
                                            obj9 = h72Var;
                                            if (((Number) objI2).longValue() != j15) {
                                                h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                            } else {
                                                if (obj9 instanceof h72) {
                                                    Throwable thA9 = i72.a(obj9);
                                                    thA9.getClass();
                                                    boolean zContains9 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA9));
                                                    if (str7 == null) {
                                                    }
                                                    h72Var2 = new h72(thA9);
                                                } else {
                                                    x42 x42Var10 = od1.a;
                                                    bz3.g(obj9);
                                                    List listB9 = od1.b((List) obj9);
                                                    this.d = listB9;
                                                    this.f = j15;
                                                    this.e = j14;
                                                    arrayList = new ArrayList();
                                                    while (r0.hasNext()) {
                                                        if (!set8.contains((String) obj12)) {
                                                            arrayList.add(obj12);
                                                        }
                                                    }
                                                    if (arrayList.isEmpty()) {
                                                        h72Var2 = new h72(new IllegalStateException(str6));
                                                    } else {
                                                        pd1Var = new pd1(j15, arrayList);
                                                    }
                                                }
                                                an1Var13 = an1Var12;
                                            }
                                            pd1Var = h72Var2;
                                            an1Var13 = an1Var12;
                                            break;
                                        }
                                        an1Var13.h(null);
                                        return pd1Var;
                                    }
                                    str4 = str3;
                                    f0Var = f0Var3;
                                    i5 = i3;
                                    obj7 = obj6;
                                    set4 = set3;
                                    an1Var8 = an1Var7;
                                    f0 f0Var6 = f0Var;
                                    set6 = set4;
                                    i8 = i5;
                                    f0Var2 = f0Var6;
                                    long j111 = j3;
                                    z4 = z3;
                                    j8 = j111;
                                    j9 = j4;
                                    i9 = 0;
                                    an1Var9 = an1Var8;
                                    str5 = str4;
                                    if (!z4) {
                                        if (z4) {
                                            j10 = j5;
                                            if (this.f == j8) {
                                                j13 = j9 - this.e;
                                                if (0 > j13) {
                                                }
                                            }
                                        } else {
                                            j10 = j5;
                                        }
                                        String str18 = str2;
                                        set7 = set6;
                                        str6 = str18;
                                        l2 l2Var10 = new l2(this, (x50) null, 3);
                                        ns0Var.f = an1Var9;
                                        ns0Var.i = set7;
                                        ns0Var.j = str5;
                                        ns0Var.e = z4;
                                        ns0Var.n = i4;
                                        ns0Var.s = i8;
                                        ns0Var.u = j8;
                                        ns0Var.v = j9;
                                        ns0Var.t = i9;
                                        i10 = i4;
                                        i11 = i9;
                                        j11 = j10;
                                        ns0Var.w = j11;
                                        ns0Var.Y = 7;
                                        objC = xc4.c(8000L, l2Var10, ns0Var);
                                        if (objC == obj7) {
                                            return obj7;
                                        }
                                        i12 = i8;
                                        i13 = i10;
                                        obj8 = objC;
                                        j12 = j11;
                                        i14 = i11;
                                        an1Var11 = an1Var9;
                                        i72Var = (i72) obj8;
                                        if (i72Var != null) {
                                            h72Var = i72Var.a;
                                        } else {
                                            h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                        }
                                        ns0Var.f = an1Var11;
                                        ns0Var.i = set7;
                                        ns0Var.j = h72Var;
                                        ns0Var.k = str5;
                                        ns0Var.e = z4;
                                        ns0Var.n = i13;
                                        ns0Var.s = i12;
                                        ns0Var.u = j8;
                                        ns0Var.v = j9;
                                        ns0Var.t = i14;
                                        ns0Var.w = j12;
                                        ns0Var.Y = 8;
                                        objI2 = f0Var2.i(ns0Var);
                                        if (objI2 == obj7) {
                                            return obj7;
                                        }
                                        j14 = j9;
                                        str7 = str5;
                                        j15 = j8;
                                        an1Var12 = an1Var11;
                                        set8 = set7;
                                        obj9 = h72Var;
                                        if (((Number) objI2).longValue() != j15) {
                                            h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                        } else {
                                            if (obj9 instanceof h72) {
                                                Throwable thA10 = i72.a(obj9);
                                                thA10.getClass();
                                                boolean zContains10 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA10));
                                                if (str7 == null) {
                                                }
                                                h72Var2 = new h72(thA10);
                                            } else {
                                                x42 x42Var11 = od1.a;
                                                bz3.g(obj9);
                                                List listB10 = od1.b((List) obj9);
                                                this.d = listB10;
                                                this.f = j15;
                                                this.e = j14;
                                                arrayList = new ArrayList();
                                                while (r0.hasNext()) {
                                                    if (!set8.contains((String) obj12)) {
                                                        arrayList.add(obj12);
                                                    }
                                                }
                                                if (arrayList.isEmpty()) {
                                                    h72Var2 = new h72(new IllegalStateException(str6));
                                                } else {
                                                    pd1Var = new pd1(j15, arrayList);
                                                }
                                            }
                                            an1Var13 = an1Var12;
                                        }
                                        pd1Var = h72Var2;
                                        an1Var13 = an1Var12;
                                        break;
                                    } else {
                                        if (z4) {
                                            j10 = j5;
                                            if (this.f == j8) {
                                                j13 = j9 - this.e;
                                                if (0 > j13) {
                                                }
                                            }
                                        } else {
                                            j10 = j5;
                                        }
                                        String str19 = str2;
                                        set7 = set6;
                                        str6 = str19;
                                        l2 l2Var11 = new l2(this, (x50) null, 3);
                                        ns0Var.f = an1Var9;
                                        ns0Var.i = set7;
                                        ns0Var.j = str5;
                                        ns0Var.e = z4;
                                        ns0Var.n = i4;
                                        ns0Var.s = i8;
                                        ns0Var.u = j8;
                                        ns0Var.v = j9;
                                        ns0Var.t = i9;
                                        i10 = i4;
                                        i11 = i9;
                                        j11 = j10;
                                        ns0Var.w = j11;
                                        ns0Var.Y = 7;
                                        objC = xc4.c(8000L, l2Var11, ns0Var);
                                        if (objC == obj7) {
                                            return obj7;
                                        }
                                        i12 = i8;
                                        i13 = i10;
                                        obj8 = objC;
                                        j12 = j11;
                                        i14 = i11;
                                        an1Var11 = an1Var9;
                                        i72Var = (i72) obj8;
                                        if (i72Var != null) {
                                            h72Var = i72Var.a;
                                        } else {
                                            h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                        }
                                        ns0Var.f = an1Var11;
                                        ns0Var.i = set7;
                                        ns0Var.j = h72Var;
                                        ns0Var.k = str5;
                                        ns0Var.e = z4;
                                        ns0Var.n = i13;
                                        ns0Var.s = i12;
                                        ns0Var.u = j8;
                                        ns0Var.v = j9;
                                        ns0Var.t = i14;
                                        ns0Var.w = j12;
                                        ns0Var.Y = 8;
                                        objI2 = f0Var2.i(ns0Var);
                                        if (objI2 == obj7) {
                                            return obj7;
                                        }
                                        j14 = j9;
                                        str7 = str5;
                                        j15 = j8;
                                        an1Var12 = an1Var11;
                                        set8 = set7;
                                        obj9 = h72Var;
                                        if (((Number) objI2).longValue() != j15) {
                                            h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                        } else {
                                            if (obj9 instanceof h72) {
                                                Throwable thA11 = i72.a(obj9);
                                                thA11.getClass();
                                                boolean zContains11 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA11));
                                                if (str7 == null) {
                                                }
                                                h72Var2 = new h72(thA11);
                                            } else {
                                                x42 x42Var12 = od1.a;
                                                bz3.g(obj9);
                                                List listB11 = od1.b((List) obj9);
                                                this.d = listB11;
                                                this.f = j15;
                                                this.e = j14;
                                                arrayList = new ArrayList();
                                                while (r0.hasNext()) {
                                                    if (!set8.contains((String) obj12)) {
                                                        arrayList.add(obj12);
                                                    }
                                                }
                                                if (arrayList.isEmpty()) {
                                                    h72Var2 = new h72(new IllegalStateException(str6));
                                                } else {
                                                    pd1Var = new pd1(j15, arrayList);
                                                }
                                            }
                                            an1Var13 = an1Var12;
                                        }
                                        pd1Var = h72Var2;
                                        an1Var13 = an1Var12;
                                        break;
                                    }
                                    an1Var13.h(null);
                                    return pd1Var;
                                }
                            }
                        }
                        return obj3;
                    } catch (Throwable th3) {
                        th = th3;
                        an1Var = an1Var15;
                        obj = null;
                        an1Var2 = an1Var;
                        an1Var2.h(obj);
                        throw th;
                    }
                case 3:
                    str8 = "No compatible Gemini Live models are available for this key";
                    long j20 = ns0Var.v;
                    j = ns0Var.u;
                    int i22 = ns0Var.s;
                    int i23 = ns0Var.n;
                    z3 = ns0Var.e;
                    an1 an1Var16 = ns0Var.f;
                    try {
                        bz3.g(objI2);
                        obj3 = obj10;
                        i3 = i22;
                        i4 = i23;
                        objF = objI2;
                        jCurrentTimeMillis = j20;
                        an1Var5 = an1Var16;
                        set = (Set) objF;
                        ns0Var.f = an1Var5;
                        ns0Var.i = set;
                        ns0Var.e = z3;
                        ns0Var.n = i4;
                        ns0Var.s = i3;
                        ns0Var.u = j;
                        ns0Var.v = jCurrentTimeMillis;
                        ns0Var.Y = 4;
                        objH = f0Var3.h("gemini_live", ns0Var);
                        if (objH != obj3) {
                            set2 = set;
                            obj4 = objH;
                            an1Var6 = an1Var5;
                            str = (String) obj4;
                            if (str != null) {
                                str = null;
                            } else {
                                str = null;
                            }
                            ns0Var.f = an1Var6;
                            str2 = str8;
                            ns0Var.i = set2;
                            ns0Var.j = str;
                            ns0Var.e = z3;
                            ns0Var.n = i4;
                            ns0Var.s = i3;
                            ns0Var.u = j;
                            ns0Var.v = jCurrentTimeMillis;
                            ns0Var.w = jCurrentTimeMillis;
                            ns0Var.Y = 5;
                            objG = f0Var3.g("gemini_live", ns0Var);
                            if (objG == obj3) {
                                str3 = str;
                                obj5 = objG;
                                j2 = jCurrentTimeMillis;
                                j3 = j;
                                j4 = j2;
                                an1Var7 = an1Var6;
                                long jLongValue5 = ((Number) obj5).longValue();
                                set3 = set2;
                                obj6 = obj3;
                                j5 = j2 - jLongValue5;
                                if (this.f == j3) {
                                    j6 = this.e;
                                    ns0Var.f = an1Var7;
                                    ns0Var.i = set3;
                                    ns0Var.j = str3;
                                    ns0Var.e = z3;
                                    ns0Var.n = i4;
                                    ns0Var.s = i3;
                                    ns0Var.u = j3;
                                    ns0Var.v = j4;
                                    ns0Var.w = j6;
                                    ns0Var.x = j5;
                                    ns0Var.Y = 6;
                                    str4 = str3;
                                    f0Var = f0Var3;
                                    objG2 = f0Var.g("gemini_live", ns0Var);
                                    i6 = i3;
                                    obj7 = obj6;
                                    if (objG2 == obj7) {
                                        return obj7;
                                    }
                                    j7 = j6;
                                    i7 = i6;
                                    set5 = set3;
                                    an1Var10 = an1Var7;
                                    if (j7 > ((Number) objG2).longValue()) {
                                        Set set12 = set5;
                                        f0Var2 = f0Var;
                                        set6 = set12;
                                        long j112 = j3;
                                        z4 = z3;
                                        j8 = j112;
                                        i8 = i7;
                                        j9 = j4;
                                        i9 = 1;
                                        an1Var9 = an1Var10;
                                    } else {
                                        set4 = set5;
                                        i5 = i7;
                                        an1Var8 = an1Var10;
                                    }
                                    str5 = str4;
                                    if (!z4) {
                                        if (z4) {
                                            j10 = j5;
                                            if (this.f == j8) {
                                                j13 = j9 - this.e;
                                                if (0 > j13) {
                                                }
                                            }
                                        } else {
                                            j10 = j5;
                                        }
                                        String str110 = str2;
                                        set7 = set6;
                                        str6 = str110;
                                        l2 l2Var12 = new l2(this, (x50) null, 3);
                                        ns0Var.f = an1Var9;
                                        ns0Var.i = set7;
                                        ns0Var.j = str5;
                                        ns0Var.e = z4;
                                        ns0Var.n = i4;
                                        ns0Var.s = i8;
                                        ns0Var.u = j8;
                                        ns0Var.v = j9;
                                        ns0Var.t = i9;
                                        i10 = i4;
                                        i11 = i9;
                                        j11 = j10;
                                        ns0Var.w = j11;
                                        ns0Var.Y = 7;
                                        objC = xc4.c(8000L, l2Var12, ns0Var);
                                        if (objC == obj7) {
                                            return obj7;
                                        }
                                        i12 = i8;
                                        i13 = i10;
                                        obj8 = objC;
                                        j12 = j11;
                                        i14 = i11;
                                        an1Var11 = an1Var9;
                                        i72Var = (i72) obj8;
                                        if (i72Var != null) {
                                            h72Var = i72Var.a;
                                        } else {
                                            h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                        }
                                        ns0Var.f = an1Var11;
                                        ns0Var.i = set7;
                                        ns0Var.j = h72Var;
                                        ns0Var.k = str5;
                                        ns0Var.e = z4;
                                        ns0Var.n = i13;
                                        ns0Var.s = i12;
                                        ns0Var.u = j8;
                                        ns0Var.v = j9;
                                        ns0Var.t = i14;
                                        ns0Var.w = j12;
                                        ns0Var.Y = 8;
                                        objI2 = f0Var2.i(ns0Var);
                                        if (objI2 == obj7) {
                                            return obj7;
                                        }
                                        j14 = j9;
                                        str7 = str5;
                                        j15 = j8;
                                        an1Var12 = an1Var11;
                                        set8 = set7;
                                        obj9 = h72Var;
                                        if (((Number) objI2).longValue() != j15) {
                                            h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                        } else {
                                            if (obj9 instanceof h72) {
                                                Throwable thA12 = i72.a(obj9);
                                                thA12.getClass();
                                                boolean zContains12 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA12));
                                                if (str7 == null) {
                                                }
                                                h72Var2 = new h72(thA12);
                                            } else {
                                                x42 x42Var13 = od1.a;
                                                bz3.g(obj9);
                                                List listB12 = od1.b((List) obj9);
                                                this.d = listB12;
                                                this.f = j15;
                                                this.e = j14;
                                                arrayList = new ArrayList();
                                                while (r0.hasNext()) {
                                                    if (!set8.contains((String) obj12)) {
                                                        arrayList.add(obj12);
                                                    }
                                                }
                                                if (arrayList.isEmpty()) {
                                                    h72Var2 = new h72(new IllegalStateException(str6));
                                                } else {
                                                    pd1Var = new pd1(j15, arrayList);
                                                }
                                            }
                                            an1Var13 = an1Var12;
                                        }
                                        pd1Var = h72Var2;
                                        an1Var13 = an1Var12;
                                        break;
                                    } else {
                                        if (z4) {
                                            j10 = j5;
                                            if (this.f == j8) {
                                                j13 = j9 - this.e;
                                                if (0 > j13) {
                                                }
                                            }
                                        } else {
                                            j10 = j5;
                                        }
                                        String str111 = str2;
                                        set7 = set6;
                                        str6 = str111;
                                        l2 l2Var13 = new l2(this, (x50) null, 3);
                                        ns0Var.f = an1Var9;
                                        ns0Var.i = set7;
                                        ns0Var.j = str5;
                                        ns0Var.e = z4;
                                        ns0Var.n = i4;
                                        ns0Var.s = i8;
                                        ns0Var.u = j8;
                                        ns0Var.v = j9;
                                        ns0Var.t = i9;
                                        i10 = i4;
                                        i11 = i9;
                                        j11 = j10;
                                        ns0Var.w = j11;
                                        ns0Var.Y = 7;
                                        objC = xc4.c(8000L, l2Var13, ns0Var);
                                        if (objC == obj7) {
                                            return obj7;
                                        }
                                        i12 = i8;
                                        i13 = i10;
                                        obj8 = objC;
                                        j12 = j11;
                                        i14 = i11;
                                        an1Var11 = an1Var9;
                                        i72Var = (i72) obj8;
                                        if (i72Var != null) {
                                            h72Var = i72Var.a;
                                        } else {
                                            h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                        }
                                        ns0Var.f = an1Var11;
                                        ns0Var.i = set7;
                                        ns0Var.j = h72Var;
                                        ns0Var.k = str5;
                                        ns0Var.e = z4;
                                        ns0Var.n = i13;
                                        ns0Var.s = i12;
                                        ns0Var.u = j8;
                                        ns0Var.v = j9;
                                        ns0Var.t = i14;
                                        ns0Var.w = j12;
                                        ns0Var.Y = 8;
                                        objI2 = f0Var2.i(ns0Var);
                                        if (objI2 == obj7) {
                                            return obj7;
                                        }
                                        j14 = j9;
                                        str7 = str5;
                                        j15 = j8;
                                        an1Var12 = an1Var11;
                                        set8 = set7;
                                        obj9 = h72Var;
                                        if (((Number) objI2).longValue() != j15) {
                                            h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                        } else {
                                            if (obj9 instanceof h72) {
                                                Throwable thA13 = i72.a(obj9);
                                                thA13.getClass();
                                                boolean zContains13 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA13));
                                                if (str7 == null) {
                                                }
                                                h72Var2 = new h72(thA13);
                                            } else {
                                                x42 x42Var14 = od1.a;
                                                bz3.g(obj9);
                                                List listB13 = od1.b((List) obj9);
                                                this.d = listB13;
                                                this.f = j15;
                                                this.e = j14;
                                                arrayList = new ArrayList();
                                                while (r0.hasNext()) {
                                                    if (!set8.contains((String) obj12)) {
                                                        arrayList.add(obj12);
                                                    }
                                                }
                                                if (arrayList.isEmpty()) {
                                                    h72Var2 = new h72(new IllegalStateException(str6));
                                                } else {
                                                    pd1Var = new pd1(j15, arrayList);
                                                }
                                            }
                                            an1Var13 = an1Var12;
                                        }
                                        pd1Var = h72Var2;
                                        an1Var13 = an1Var12;
                                        break;
                                    }
                                    an1Var13.h(null);
                                    return pd1Var;
                                }
                                str4 = str3;
                                f0Var = f0Var3;
                                i5 = i3;
                                obj7 = obj6;
                                set4 = set3;
                                an1Var8 = an1Var7;
                                f0 f0Var7 = f0Var;
                                set6 = set4;
                                i8 = i5;
                                f0Var2 = f0Var7;
                                long j113 = j3;
                                z4 = z3;
                                j8 = j113;
                                j9 = j4;
                                i9 = 0;
                                an1Var9 = an1Var8;
                                str5 = str4;
                                if (!z4) {
                                    if (z4) {
                                        j10 = j5;
                                        if (this.f == j8) {
                                            j13 = j9 - this.e;
                                            if (0 > j13) {
                                            }
                                        }
                                    } else {
                                        j10 = j5;
                                    }
                                    String str112 = str2;
                                    set7 = set6;
                                    str6 = str112;
                                    l2 l2Var14 = new l2(this, (x50) null, 3);
                                    ns0Var.f = an1Var9;
                                    ns0Var.i = set7;
                                    ns0Var.j = str5;
                                    ns0Var.e = z4;
                                    ns0Var.n = i4;
                                    ns0Var.s = i8;
                                    ns0Var.u = j8;
                                    ns0Var.v = j9;
                                    ns0Var.t = i9;
                                    i10 = i4;
                                    i11 = i9;
                                    j11 = j10;
                                    ns0Var.w = j11;
                                    ns0Var.Y = 7;
                                    objC = xc4.c(8000L, l2Var14, ns0Var);
                                    if (objC == obj7) {
                                        return obj7;
                                    }
                                    i12 = i8;
                                    i13 = i10;
                                    obj8 = objC;
                                    j12 = j11;
                                    i14 = i11;
                                    an1Var11 = an1Var9;
                                    i72Var = (i72) obj8;
                                    if (i72Var != null) {
                                        h72Var = i72Var.a;
                                    } else {
                                        h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                    }
                                    ns0Var.f = an1Var11;
                                    ns0Var.i = set7;
                                    ns0Var.j = h72Var;
                                    ns0Var.k = str5;
                                    ns0Var.e = z4;
                                    ns0Var.n = i13;
                                    ns0Var.s = i12;
                                    ns0Var.u = j8;
                                    ns0Var.v = j9;
                                    ns0Var.t = i14;
                                    ns0Var.w = j12;
                                    ns0Var.Y = 8;
                                    objI2 = f0Var2.i(ns0Var);
                                    if (objI2 == obj7) {
                                        return obj7;
                                    }
                                    j14 = j9;
                                    str7 = str5;
                                    j15 = j8;
                                    an1Var12 = an1Var11;
                                    set8 = set7;
                                    obj9 = h72Var;
                                    if (((Number) objI2).longValue() != j15) {
                                        h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                    } else {
                                        if (obj9 instanceof h72) {
                                            Throwable thA14 = i72.a(obj9);
                                            thA14.getClass();
                                            boolean zContains14 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA14));
                                            if (str7 == null) {
                                            }
                                            h72Var2 = new h72(thA14);
                                        } else {
                                            x42 x42Var15 = od1.a;
                                            bz3.g(obj9);
                                            List listB14 = od1.b((List) obj9);
                                            this.d = listB14;
                                            this.f = j15;
                                            this.e = j14;
                                            arrayList = new ArrayList();
                                            while (r0.hasNext()) {
                                                if (!set8.contains((String) obj12)) {
                                                    arrayList.add(obj12);
                                                }
                                            }
                                            if (arrayList.isEmpty()) {
                                                h72Var2 = new h72(new IllegalStateException(str6));
                                            } else {
                                                pd1Var = new pd1(j15, arrayList);
                                            }
                                        }
                                        an1Var13 = an1Var12;
                                    }
                                    pd1Var = h72Var2;
                                    an1Var13 = an1Var12;
                                    break;
                                } else {
                                    if (z4) {
                                        j10 = j5;
                                        if (this.f == j8) {
                                            j13 = j9 - this.e;
                                            if (0 > j13) {
                                            }
                                        }
                                    } else {
                                        j10 = j5;
                                    }
                                    String str113 = str2;
                                    set7 = set6;
                                    str6 = str113;
                                    l2 l2Var15 = new l2(this, (x50) null, 3);
                                    ns0Var.f = an1Var9;
                                    ns0Var.i = set7;
                                    ns0Var.j = str5;
                                    ns0Var.e = z4;
                                    ns0Var.n = i4;
                                    ns0Var.s = i8;
                                    ns0Var.u = j8;
                                    ns0Var.v = j9;
                                    ns0Var.t = i9;
                                    i10 = i4;
                                    i11 = i9;
                                    j11 = j10;
                                    ns0Var.w = j11;
                                    ns0Var.Y = 7;
                                    objC = xc4.c(8000L, l2Var15, ns0Var);
                                    if (objC == obj7) {
                                        return obj7;
                                    }
                                    i12 = i8;
                                    i13 = i10;
                                    obj8 = objC;
                                    j12 = j11;
                                    i14 = i11;
                                    an1Var11 = an1Var9;
                                    i72Var = (i72) obj8;
                                    if (i72Var != null) {
                                        h72Var = i72Var.a;
                                    } else {
                                        h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                    }
                                    ns0Var.f = an1Var11;
                                    ns0Var.i = set7;
                                    ns0Var.j = h72Var;
                                    ns0Var.k = str5;
                                    ns0Var.e = z4;
                                    ns0Var.n = i13;
                                    ns0Var.s = i12;
                                    ns0Var.u = j8;
                                    ns0Var.v = j9;
                                    ns0Var.t = i14;
                                    ns0Var.w = j12;
                                    ns0Var.Y = 8;
                                    objI2 = f0Var2.i(ns0Var);
                                    if (objI2 == obj7) {
                                        return obj7;
                                    }
                                    j14 = j9;
                                    str7 = str5;
                                    j15 = j8;
                                    an1Var12 = an1Var11;
                                    set8 = set7;
                                    obj9 = h72Var;
                                    if (((Number) objI2).longValue() != j15) {
                                        h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                    } else {
                                        if (obj9 instanceof h72) {
                                            Throwable thA15 = i72.a(obj9);
                                            thA15.getClass();
                                            boolean zContains15 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA15));
                                            if (str7 == null) {
                                            }
                                            h72Var2 = new h72(thA15);
                                        } else {
                                            x42 x42Var16 = od1.a;
                                            bz3.g(obj9);
                                            List listB15 = od1.b((List) obj9);
                                            this.d = listB15;
                                            this.f = j15;
                                            this.e = j14;
                                            arrayList = new ArrayList();
                                            while (r0.hasNext()) {
                                                if (!set8.contains((String) obj12)) {
                                                    arrayList.add(obj12);
                                                }
                                            }
                                            if (arrayList.isEmpty()) {
                                                h72Var2 = new h72(new IllegalStateException(str6));
                                            } else {
                                                pd1Var = new pd1(j15, arrayList);
                                            }
                                        }
                                        an1Var13 = an1Var12;
                                    }
                                    pd1Var = h72Var2;
                                    an1Var13 = an1Var12;
                                    break;
                                }
                                an1Var13.h(null);
                                return pd1Var;
                            }
                        }
                        return obj3;
                    } catch (Throwable th4) {
                        th = th4;
                        an1Var = an1Var16;
                        obj = null;
                        an1Var2 = an1Var;
                        an1Var2.h(obj);
                        throw th;
                    }
                case 4:
                    str8 = "No compatible Gemini Live models are available for this key";
                    long j21 = ns0Var.v;
                    j = ns0Var.u;
                    int i24 = ns0Var.s;
                    int i25 = ns0Var.n;
                    z3 = ns0Var.e;
                    Set set13 = ns0Var.i;
                    an1 an1Var17 = ns0Var.f;
                    try {
                        bz3.g(objI2);
                        set2 = set13;
                        an1Var6 = an1Var17;
                        obj3 = obj10;
                        i3 = i24;
                        i4 = i25;
                        obj4 = objI2;
                        jCurrentTimeMillis = j21;
                        str = (String) obj4;
                        if (str != null) {
                            str = null;
                        } else {
                            str = null;
                        }
                        ns0Var.f = an1Var6;
                        str2 = str8;
                        ns0Var.i = set2;
                        ns0Var.j = str;
                        ns0Var.e = z3;
                        ns0Var.n = i4;
                        ns0Var.s = i3;
                        ns0Var.u = j;
                        ns0Var.v = jCurrentTimeMillis;
                        ns0Var.w = jCurrentTimeMillis;
                        ns0Var.Y = 5;
                        objG = f0Var3.g("gemini_live", ns0Var);
                        if (objG == obj3) {
                            return obj3;
                        }
                        str3 = str;
                        obj5 = objG;
                        j2 = jCurrentTimeMillis;
                        j3 = j;
                        j4 = j2;
                        an1Var7 = an1Var6;
                        long jLongValue6 = ((Number) obj5).longValue();
                        set3 = set2;
                        obj6 = obj3;
                        j5 = j2 - jLongValue6;
                        if (this.f == j3) {
                            j6 = this.e;
                            ns0Var.f = an1Var7;
                            ns0Var.i = set3;
                            ns0Var.j = str3;
                            ns0Var.e = z3;
                            ns0Var.n = i4;
                            ns0Var.s = i3;
                            ns0Var.u = j3;
                            ns0Var.v = j4;
                            ns0Var.w = j6;
                            ns0Var.x = j5;
                            ns0Var.Y = 6;
                            str4 = str3;
                            f0Var = f0Var3;
                            objG2 = f0Var.g("gemini_live", ns0Var);
                            i6 = i3;
                            obj7 = obj6;
                            if (objG2 == obj7) {
                                return obj7;
                            }
                            j7 = j6;
                            i7 = i6;
                            set5 = set3;
                            an1Var10 = an1Var7;
                            if (j7 > ((Number) objG2).longValue()) {
                                Set set14 = set5;
                                f0Var2 = f0Var;
                                set6 = set14;
                                long j114 = j3;
                                z4 = z3;
                                j8 = j114;
                                i8 = i7;
                                j9 = j4;
                                i9 = 1;
                                an1Var9 = an1Var10;
                            } else {
                                set4 = set5;
                                i5 = i7;
                                an1Var8 = an1Var10;
                            }
                            str5 = str4;
                            if (!z4) {
                                if (z4) {
                                    j10 = j5;
                                    if (this.f == j8) {
                                        j13 = j9 - this.e;
                                        if (0 > j13) {
                                        }
                                    }
                                } else {
                                    j10 = j5;
                                }
                                String str114 = str2;
                                set7 = set6;
                                str6 = str114;
                                l2 l2Var16 = new l2(this, (x50) null, 3);
                                ns0Var.f = an1Var9;
                                ns0Var.i = set7;
                                ns0Var.j = str5;
                                ns0Var.e = z4;
                                ns0Var.n = i4;
                                ns0Var.s = i8;
                                ns0Var.u = j8;
                                ns0Var.v = j9;
                                ns0Var.t = i9;
                                i10 = i4;
                                i11 = i9;
                                j11 = j10;
                                ns0Var.w = j11;
                                ns0Var.Y = 7;
                                objC = xc4.c(8000L, l2Var16, ns0Var);
                                if (objC == obj7) {
                                    return obj7;
                                }
                                i12 = i8;
                                i13 = i10;
                                obj8 = objC;
                                j12 = j11;
                                i14 = i11;
                                an1Var11 = an1Var9;
                                i72Var = (i72) obj8;
                                if (i72Var != null) {
                                    h72Var = i72Var.a;
                                } else {
                                    h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                }
                                ns0Var.f = an1Var11;
                                ns0Var.i = set7;
                                ns0Var.j = h72Var;
                                ns0Var.k = str5;
                                ns0Var.e = z4;
                                ns0Var.n = i13;
                                ns0Var.s = i12;
                                ns0Var.u = j8;
                                ns0Var.v = j9;
                                ns0Var.t = i14;
                                ns0Var.w = j12;
                                ns0Var.Y = 8;
                                objI2 = f0Var2.i(ns0Var);
                                if (objI2 == obj7) {
                                    return obj7;
                                }
                                j14 = j9;
                                str7 = str5;
                                j15 = j8;
                                an1Var12 = an1Var11;
                                set8 = set7;
                                obj9 = h72Var;
                                if (((Number) objI2).longValue() != j15) {
                                    h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                } else {
                                    if (obj9 instanceof h72) {
                                        Throwable thA16 = i72.a(obj9);
                                        thA16.getClass();
                                        boolean zContains16 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA16));
                                        if (str7 == null) {
                                        }
                                        h72Var2 = new h72(thA16);
                                    } else {
                                        x42 x42Var17 = od1.a;
                                        bz3.g(obj9);
                                        List listB16 = od1.b((List) obj9);
                                        this.d = listB16;
                                        this.f = j15;
                                        this.e = j14;
                                        arrayList = new ArrayList();
                                        while (r0.hasNext()) {
                                            if (!set8.contains((String) obj12)) {
                                                arrayList.add(obj12);
                                            }
                                        }
                                        if (arrayList.isEmpty()) {
                                            h72Var2 = new h72(new IllegalStateException(str6));
                                        } else {
                                            pd1Var = new pd1(j15, arrayList);
                                        }
                                    }
                                    an1Var13 = an1Var12;
                                }
                                pd1Var = h72Var2;
                                an1Var13 = an1Var12;
                                break;
                            } else {
                                if (z4) {
                                    j10 = j5;
                                    if (this.f == j8) {
                                        j13 = j9 - this.e;
                                        if (0 > j13) {
                                        }
                                    }
                                } else {
                                    j10 = j5;
                                }
                                String str115 = str2;
                                set7 = set6;
                                str6 = str115;
                                l2 l2Var17 = new l2(this, (x50) null, 3);
                                ns0Var.f = an1Var9;
                                ns0Var.i = set7;
                                ns0Var.j = str5;
                                ns0Var.e = z4;
                                ns0Var.n = i4;
                                ns0Var.s = i8;
                                ns0Var.u = j8;
                                ns0Var.v = j9;
                                ns0Var.t = i9;
                                i10 = i4;
                                i11 = i9;
                                j11 = j10;
                                ns0Var.w = j11;
                                ns0Var.Y = 7;
                                objC = xc4.c(8000L, l2Var17, ns0Var);
                                if (objC == obj7) {
                                    return obj7;
                                }
                                i12 = i8;
                                i13 = i10;
                                obj8 = objC;
                                j12 = j11;
                                i14 = i11;
                                an1Var11 = an1Var9;
                                i72Var = (i72) obj8;
                                if (i72Var != null) {
                                    h72Var = i72Var.a;
                                } else {
                                    h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                                }
                                ns0Var.f = an1Var11;
                                ns0Var.i = set7;
                                ns0Var.j = h72Var;
                                ns0Var.k = str5;
                                ns0Var.e = z4;
                                ns0Var.n = i13;
                                ns0Var.s = i12;
                                ns0Var.u = j8;
                                ns0Var.v = j9;
                                ns0Var.t = i14;
                                ns0Var.w = j12;
                                ns0Var.Y = 8;
                                objI2 = f0Var2.i(ns0Var);
                                if (objI2 == obj7) {
                                    return obj7;
                                }
                                j14 = j9;
                                str7 = str5;
                                j15 = j8;
                                an1Var12 = an1Var11;
                                set8 = set7;
                                obj9 = h72Var;
                                if (((Number) objI2).longValue() != j15) {
                                    h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                                } else {
                                    if (obj9 instanceof h72) {
                                        Throwable thA17 = i72.a(obj9);
                                        thA17.getClass();
                                        boolean zContains17 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA17));
                                        if (str7 == null) {
                                        }
                                        h72Var2 = new h72(thA17);
                                    } else {
                                        x42 x42Var18 = od1.a;
                                        bz3.g(obj9);
                                        List listB17 = od1.b((List) obj9);
                                        this.d = listB17;
                                        this.f = j15;
                                        this.e = j14;
                                        arrayList = new ArrayList();
                                        while (r0.hasNext()) {
                                            if (!set8.contains((String) obj12)) {
                                                arrayList.add(obj12);
                                            }
                                        }
                                        if (arrayList.isEmpty()) {
                                            h72Var2 = new h72(new IllegalStateException(str6));
                                        } else {
                                            pd1Var = new pd1(j15, arrayList);
                                        }
                                    }
                                    an1Var13 = an1Var12;
                                }
                                pd1Var = h72Var2;
                                an1Var13 = an1Var12;
                                break;
                            }
                            an1Var13.h(null);
                            return pd1Var;
                        }
                        str4 = str3;
                        f0Var = f0Var3;
                        i5 = i3;
                        obj7 = obj6;
                        set4 = set3;
                        an1Var8 = an1Var7;
                        f0 f0Var8 = f0Var;
                        set6 = set4;
                        i8 = i5;
                        f0Var2 = f0Var8;
                        long j115 = j3;
                        z4 = z3;
                        j8 = j115;
                        j9 = j4;
                        i9 = 0;
                        an1Var9 = an1Var8;
                        str5 = str4;
                        if (!z4) {
                            if (z4) {
                                j10 = j5;
                                if (this.f == j8) {
                                    j13 = j9 - this.e;
                                    if (0 > j13) {
                                    }
                                }
                            } else {
                                j10 = j5;
                            }
                            String str116 = str2;
                            set7 = set6;
                            str6 = str116;
                            l2 l2Var18 = new l2(this, (x50) null, 3);
                            ns0Var.f = an1Var9;
                            ns0Var.i = set7;
                            ns0Var.j = str5;
                            ns0Var.e = z4;
                            ns0Var.n = i4;
                            ns0Var.s = i8;
                            ns0Var.u = j8;
                            ns0Var.v = j9;
                            ns0Var.t = i9;
                            i10 = i4;
                            i11 = i9;
                            j11 = j10;
                            ns0Var.w = j11;
                            ns0Var.Y = 7;
                            objC = xc4.c(8000L, l2Var18, ns0Var);
                            if (objC == obj7) {
                                return obj7;
                            }
                            i12 = i8;
                            i13 = i10;
                            obj8 = objC;
                            j12 = j11;
                            i14 = i11;
                            an1Var11 = an1Var9;
                            i72Var = (i72) obj8;
                            if (i72Var != null) {
                                h72Var = i72Var.a;
                            } else {
                                h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                            }
                            ns0Var.f = an1Var11;
                            ns0Var.i = set7;
                            ns0Var.j = h72Var;
                            ns0Var.k = str5;
                            ns0Var.e = z4;
                            ns0Var.n = i13;
                            ns0Var.s = i12;
                            ns0Var.u = j8;
                            ns0Var.v = j9;
                            ns0Var.t = i14;
                            ns0Var.w = j12;
                            ns0Var.Y = 8;
                            objI2 = f0Var2.i(ns0Var);
                            if (objI2 == obj7) {
                                return obj7;
                            }
                            j14 = j9;
                            str7 = str5;
                            j15 = j8;
                            an1Var12 = an1Var11;
                            set8 = set7;
                            obj9 = h72Var;
                            if (((Number) objI2).longValue() != j15) {
                                h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                            } else {
                                if (obj9 instanceof h72) {
                                    Throwable thA18 = i72.a(obj9);
                                    thA18.getClass();
                                    boolean zContains18 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA18));
                                    if (str7 == null) {
                                    }
                                    h72Var2 = new h72(thA18);
                                } else {
                                    x42 x42Var19 = od1.a;
                                    bz3.g(obj9);
                                    List listB18 = od1.b((List) obj9);
                                    this.d = listB18;
                                    this.f = j15;
                                    this.e = j14;
                                    arrayList = new ArrayList();
                                    while (r0.hasNext()) {
                                        if (!set8.contains((String) obj12)) {
                                            arrayList.add(obj12);
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        h72Var2 = new h72(new IllegalStateException(str6));
                                    } else {
                                        pd1Var = new pd1(j15, arrayList);
                                    }
                                }
                                an1Var13 = an1Var12;
                            }
                            pd1Var = h72Var2;
                            an1Var13 = an1Var12;
                            break;
                        } else {
                            if (z4) {
                                j10 = j5;
                                if (this.f == j8) {
                                    j13 = j9 - this.e;
                                    if (0 > j13) {
                                    }
                                }
                            } else {
                                j10 = j5;
                            }
                            String str117 = str2;
                            set7 = set6;
                            str6 = str117;
                            l2 l2Var19 = new l2(this, (x50) null, 3);
                            ns0Var.f = an1Var9;
                            ns0Var.i = set7;
                            ns0Var.j = str5;
                            ns0Var.e = z4;
                            ns0Var.n = i4;
                            ns0Var.s = i8;
                            ns0Var.u = j8;
                            ns0Var.v = j9;
                            ns0Var.t = i9;
                            i10 = i4;
                            i11 = i9;
                            j11 = j10;
                            ns0Var.w = j11;
                            ns0Var.Y = 7;
                            objC = xc4.c(8000L, l2Var19, ns0Var);
                            if (objC == obj7) {
                                return obj7;
                            }
                            i12 = i8;
                            i13 = i10;
                            obj8 = objC;
                            j12 = j11;
                            i14 = i11;
                            an1Var11 = an1Var9;
                            i72Var = (i72) obj8;
                            if (i72Var != null) {
                                h72Var = i72Var.a;
                            } else {
                                h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                            }
                            ns0Var.f = an1Var11;
                            ns0Var.i = set7;
                            ns0Var.j = h72Var;
                            ns0Var.k = str5;
                            ns0Var.e = z4;
                            ns0Var.n = i13;
                            ns0Var.s = i12;
                            ns0Var.u = j8;
                            ns0Var.v = j9;
                            ns0Var.t = i14;
                            ns0Var.w = j12;
                            ns0Var.Y = 8;
                            objI2 = f0Var2.i(ns0Var);
                            if (objI2 == obj7) {
                                return obj7;
                            }
                            j14 = j9;
                            str7 = str5;
                            j15 = j8;
                            an1Var12 = an1Var11;
                            set8 = set7;
                            obj9 = h72Var;
                            if (((Number) objI2).longValue() != j15) {
                                h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                            } else {
                                if (obj9 instanceof h72) {
                                    Throwable thA19 = i72.a(obj9);
                                    thA19.getClass();
                                    boolean zContains19 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA19));
                                    if (str7 == null) {
                                    }
                                    h72Var2 = new h72(thA19);
                                } else {
                                    x42 x42Var110 = od1.a;
                                    bz3.g(obj9);
                                    List listB19 = od1.b((List) obj9);
                                    this.d = listB19;
                                    this.f = j15;
                                    this.e = j14;
                                    arrayList = new ArrayList();
                                    while (r0.hasNext()) {
                                        if (!set8.contains((String) obj12)) {
                                            arrayList.add(obj12);
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        h72Var2 = new h72(new IllegalStateException(str6));
                                    } else {
                                        pd1Var = new pd1(j15, arrayList);
                                    }
                                }
                                an1Var13 = an1Var12;
                            }
                            pd1Var = h72Var2;
                            an1Var13 = an1Var12;
                            break;
                        }
                        an1Var13.h(null);
                        return pd1Var;
                    } catch (Throwable th5) {
                        th = th5;
                        an1Var = an1Var17;
                        obj = null;
                        an1Var2 = an1Var;
                        an1Var2.h(obj);
                        throw th;
                    }
                case 5:
                    long j22 = ns0Var.w;
                    j4 = ns0Var.v;
                    long j23 = ns0Var.u;
                    int i26 = ns0Var.s;
                    int i27 = ns0Var.n;
                    boolean z6 = ns0Var.e;
                    String str20 = (String) ns0Var.j;
                    Set set15 = ns0Var.i;
                    an1 an1Var18 = ns0Var.f;
                    bz3.g(objI2);
                    i3 = i26;
                    j2 = j22;
                    i4 = i27;
                    set2 = set15;
                    an1Var7 = an1Var18;
                    z3 = z6;
                    obj5 = objI2;
                    str2 = "No compatible Gemini Live models are available for this key";
                    str3 = str20;
                    obj3 = obj10;
                    j3 = j23;
                    long jLongValue7 = ((Number) obj5).longValue();
                    set3 = set2;
                    obj6 = obj3;
                    j5 = j2 - jLongValue7;
                    if (this.f == j3) {
                        j6 = this.e;
                        ns0Var.f = an1Var7;
                        ns0Var.i = set3;
                        ns0Var.j = str3;
                        ns0Var.e = z3;
                        ns0Var.n = i4;
                        ns0Var.s = i3;
                        ns0Var.u = j3;
                        ns0Var.v = j4;
                        ns0Var.w = j6;
                        ns0Var.x = j5;
                        ns0Var.Y = 6;
                        str4 = str3;
                        f0Var = f0Var3;
                        objG2 = f0Var.g("gemini_live", ns0Var);
                        i6 = i3;
                        obj7 = obj6;
                        if (objG2 == obj7) {
                            return obj7;
                        }
                        j7 = j6;
                        i7 = i6;
                        set5 = set3;
                        an1Var10 = an1Var7;
                        if (j7 > ((Number) objG2).longValue()) {
                            Set set16 = set5;
                            f0Var2 = f0Var;
                            set6 = set16;
                            long j116 = j3;
                            z4 = z3;
                            j8 = j116;
                            i8 = i7;
                            j9 = j4;
                            i9 = 1;
                            an1Var9 = an1Var10;
                        } else {
                            set4 = set5;
                            i5 = i7;
                            an1Var8 = an1Var10;
                        }
                        str5 = str4;
                        if (!z4) {
                            if (z4) {
                                j10 = j5;
                                if (this.f == j8) {
                                    j13 = j9 - this.e;
                                    if (0 > j13) {
                                    }
                                }
                            } else {
                                j10 = j5;
                            }
                            String str118 = str2;
                            set7 = set6;
                            str6 = str118;
                            l2 l2Var110 = new l2(this, (x50) null, 3);
                            ns0Var.f = an1Var9;
                            ns0Var.i = set7;
                            ns0Var.j = str5;
                            ns0Var.e = z4;
                            ns0Var.n = i4;
                            ns0Var.s = i8;
                            ns0Var.u = j8;
                            ns0Var.v = j9;
                            ns0Var.t = i9;
                            i10 = i4;
                            i11 = i9;
                            j11 = j10;
                            ns0Var.w = j11;
                            ns0Var.Y = 7;
                            objC = xc4.c(8000L, l2Var110, ns0Var);
                            if (objC == obj7) {
                                return obj7;
                            }
                            i12 = i8;
                            i13 = i10;
                            obj8 = objC;
                            j12 = j11;
                            i14 = i11;
                            an1Var11 = an1Var9;
                            i72Var = (i72) obj8;
                            if (i72Var != null) {
                                h72Var = i72Var.a;
                            } else {
                                h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                            }
                            ns0Var.f = an1Var11;
                            ns0Var.i = set7;
                            ns0Var.j = h72Var;
                            ns0Var.k = str5;
                            ns0Var.e = z4;
                            ns0Var.n = i13;
                            ns0Var.s = i12;
                            ns0Var.u = j8;
                            ns0Var.v = j9;
                            ns0Var.t = i14;
                            ns0Var.w = j12;
                            ns0Var.Y = 8;
                            objI2 = f0Var2.i(ns0Var);
                            if (objI2 == obj7) {
                                return obj7;
                            }
                            j14 = j9;
                            str7 = str5;
                            j15 = j8;
                            an1Var12 = an1Var11;
                            set8 = set7;
                            obj9 = h72Var;
                            if (((Number) objI2).longValue() != j15) {
                                h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                            } else {
                                if (obj9 instanceof h72) {
                                    Throwable thA110 = i72.a(obj9);
                                    thA110.getClass();
                                    boolean zContains110 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA110));
                                    if (str7 == null) {
                                    }
                                    h72Var2 = new h72(thA110);
                                } else {
                                    x42 x42Var111 = od1.a;
                                    bz3.g(obj9);
                                    List listB110 = od1.b((List) obj9);
                                    this.d = listB110;
                                    this.f = j15;
                                    this.e = j14;
                                    arrayList = new ArrayList();
                                    while (r0.hasNext()) {
                                        if (!set8.contains((String) obj12)) {
                                            arrayList.add(obj12);
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        h72Var2 = new h72(new IllegalStateException(str6));
                                    } else {
                                        pd1Var = new pd1(j15, arrayList);
                                    }
                                }
                                an1Var13 = an1Var12;
                            }
                            pd1Var = h72Var2;
                            an1Var13 = an1Var12;
                            break;
                        } else {
                            if (z4) {
                                j10 = j5;
                                if (this.f == j8) {
                                    j13 = j9 - this.e;
                                    if (0 > j13) {
                                    }
                                }
                            } else {
                                j10 = j5;
                            }
                            String str119 = str2;
                            set7 = set6;
                            str6 = str119;
                            l2 l2Var111 = new l2(this, (x50) null, 3);
                            ns0Var.f = an1Var9;
                            ns0Var.i = set7;
                            ns0Var.j = str5;
                            ns0Var.e = z4;
                            ns0Var.n = i4;
                            ns0Var.s = i8;
                            ns0Var.u = j8;
                            ns0Var.v = j9;
                            ns0Var.t = i9;
                            i10 = i4;
                            i11 = i9;
                            j11 = j10;
                            ns0Var.w = j11;
                            ns0Var.Y = 7;
                            objC = xc4.c(8000L, l2Var111, ns0Var);
                            if (objC == obj7) {
                                return obj7;
                            }
                            i12 = i8;
                            i13 = i10;
                            obj8 = objC;
                            j12 = j11;
                            i14 = i11;
                            an1Var11 = an1Var9;
                            i72Var = (i72) obj8;
                            if (i72Var != null) {
                                h72Var = i72Var.a;
                            } else {
                                h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                            }
                            ns0Var.f = an1Var11;
                            ns0Var.i = set7;
                            ns0Var.j = h72Var;
                            ns0Var.k = str5;
                            ns0Var.e = z4;
                            ns0Var.n = i13;
                            ns0Var.s = i12;
                            ns0Var.u = j8;
                            ns0Var.v = j9;
                            ns0Var.t = i14;
                            ns0Var.w = j12;
                            ns0Var.Y = 8;
                            objI2 = f0Var2.i(ns0Var);
                            if (objI2 == obj7) {
                                return obj7;
                            }
                            j14 = j9;
                            str7 = str5;
                            j15 = j8;
                            an1Var12 = an1Var11;
                            set8 = set7;
                            obj9 = h72Var;
                            if (((Number) objI2).longValue() != j15) {
                                h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                            } else {
                                if (obj9 instanceof h72) {
                                    Throwable thA111 = i72.a(obj9);
                                    thA111.getClass();
                                    boolean zContains111 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA111));
                                    if (str7 == null) {
                                    }
                                    h72Var2 = new h72(thA111);
                                } else {
                                    x42 x42Var112 = od1.a;
                                    bz3.g(obj9);
                                    List listB111 = od1.b((List) obj9);
                                    this.d = listB111;
                                    this.f = j15;
                                    this.e = j14;
                                    arrayList = new ArrayList();
                                    while (r0.hasNext()) {
                                        if (!set8.contains((String) obj12)) {
                                            arrayList.add(obj12);
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        h72Var2 = new h72(new IllegalStateException(str6));
                                    } else {
                                        pd1Var = new pd1(j15, arrayList);
                                    }
                                }
                                an1Var13 = an1Var12;
                            }
                            pd1Var = h72Var2;
                            an1Var13 = an1Var12;
                            break;
                        }
                        an1Var13.h(null);
                        return pd1Var;
                    }
                    str4 = str3;
                    f0Var = f0Var3;
                    i5 = i3;
                    obj7 = obj6;
                    set4 = set3;
                    an1Var8 = an1Var7;
                    f0 f0Var9 = f0Var;
                    set6 = set4;
                    i8 = i5;
                    f0Var2 = f0Var9;
                    long j117 = j3;
                    z4 = z3;
                    j8 = j117;
                    j9 = j4;
                    i9 = 0;
                    an1Var9 = an1Var8;
                    str5 = str4;
                    if (!z4) {
                        if (z4) {
                            j10 = j5;
                            if (this.f == j8) {
                                j13 = j9 - this.e;
                                if (0 > j13) {
                                }
                            }
                        } else {
                            j10 = j5;
                        }
                        String str1110 = str2;
                        set7 = set6;
                        str6 = str1110;
                        l2 l2Var112 = new l2(this, (x50) null, 3);
                        ns0Var.f = an1Var9;
                        ns0Var.i = set7;
                        ns0Var.j = str5;
                        ns0Var.e = z4;
                        ns0Var.n = i4;
                        ns0Var.s = i8;
                        ns0Var.u = j8;
                        ns0Var.v = j9;
                        ns0Var.t = i9;
                        i10 = i4;
                        i11 = i9;
                        j11 = j10;
                        ns0Var.w = j11;
                        ns0Var.Y = 7;
                        objC = xc4.c(8000L, l2Var112, ns0Var);
                        if (objC == obj7) {
                            return obj7;
                        }
                        i12 = i8;
                        i13 = i10;
                        obj8 = objC;
                        j12 = j11;
                        i14 = i11;
                        an1Var11 = an1Var9;
                        i72Var = (i72) obj8;
                        if (i72Var != null) {
                            h72Var = i72Var.a;
                        } else {
                            h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                        }
                        ns0Var.f = an1Var11;
                        ns0Var.i = set7;
                        ns0Var.j = h72Var;
                        ns0Var.k = str5;
                        ns0Var.e = z4;
                        ns0Var.n = i13;
                        ns0Var.s = i12;
                        ns0Var.u = j8;
                        ns0Var.v = j9;
                        ns0Var.t = i14;
                        ns0Var.w = j12;
                        ns0Var.Y = 8;
                        objI2 = f0Var2.i(ns0Var);
                        if (objI2 == obj7) {
                            return obj7;
                        }
                        j14 = j9;
                        str7 = str5;
                        j15 = j8;
                        an1Var12 = an1Var11;
                        set8 = set7;
                        obj9 = h72Var;
                        if (((Number) objI2).longValue() != j15) {
                            h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                        } else {
                            if (obj9 instanceof h72) {
                                Throwable thA112 = i72.a(obj9);
                                thA112.getClass();
                                boolean zContains112 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA112));
                                if (str7 == null) {
                                }
                                h72Var2 = new h72(thA112);
                            } else {
                                x42 x42Var113 = od1.a;
                                bz3.g(obj9);
                                List listB112 = od1.b((List) obj9);
                                this.d = listB112;
                                this.f = j15;
                                this.e = j14;
                                arrayList = new ArrayList();
                                while (r0.hasNext()) {
                                    if (!set8.contains((String) obj12)) {
                                        arrayList.add(obj12);
                                    }
                                }
                                if (arrayList.isEmpty()) {
                                    h72Var2 = new h72(new IllegalStateException(str6));
                                } else {
                                    pd1Var = new pd1(j15, arrayList);
                                }
                            }
                            an1Var13 = an1Var12;
                        }
                        pd1Var = h72Var2;
                        an1Var13 = an1Var12;
                        break;
                    } else {
                        if (z4) {
                            j10 = j5;
                            if (this.f == j8) {
                                j13 = j9 - this.e;
                                if (0 > j13) {
                                }
                            }
                        } else {
                            j10 = j5;
                        }
                        String str1111 = str2;
                        set7 = set6;
                        str6 = str1111;
                        l2 l2Var113 = new l2(this, (x50) null, 3);
                        ns0Var.f = an1Var9;
                        ns0Var.i = set7;
                        ns0Var.j = str5;
                        ns0Var.e = z4;
                        ns0Var.n = i4;
                        ns0Var.s = i8;
                        ns0Var.u = j8;
                        ns0Var.v = j9;
                        ns0Var.t = i9;
                        i10 = i4;
                        i11 = i9;
                        j11 = j10;
                        ns0Var.w = j11;
                        ns0Var.Y = 7;
                        objC = xc4.c(8000L, l2Var113, ns0Var);
                        if (objC == obj7) {
                            return obj7;
                        }
                        i12 = i8;
                        i13 = i10;
                        obj8 = objC;
                        j12 = j11;
                        i14 = i11;
                        an1Var11 = an1Var9;
                        i72Var = (i72) obj8;
                        if (i72Var != null) {
                            h72Var = i72Var.a;
                        } else {
                            h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                        }
                        ns0Var.f = an1Var11;
                        ns0Var.i = set7;
                        ns0Var.j = h72Var;
                        ns0Var.k = str5;
                        ns0Var.e = z4;
                        ns0Var.n = i13;
                        ns0Var.s = i12;
                        ns0Var.u = j8;
                        ns0Var.v = j9;
                        ns0Var.t = i14;
                        ns0Var.w = j12;
                        ns0Var.Y = 8;
                        objI2 = f0Var2.i(ns0Var);
                        if (objI2 == obj7) {
                            return obj7;
                        }
                        j14 = j9;
                        str7 = str5;
                        j15 = j8;
                        an1Var12 = an1Var11;
                        set8 = set7;
                        obj9 = h72Var;
                        if (((Number) objI2).longValue() != j15) {
                            h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                        } else {
                            if (obj9 instanceof h72) {
                                Throwable thA113 = i72.a(obj9);
                                thA113.getClass();
                                boolean zContains113 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA113));
                                if (str7 == null) {
                                }
                                h72Var2 = new h72(thA113);
                            } else {
                                x42 x42Var114 = od1.a;
                                bz3.g(obj9);
                                List listB113 = od1.b((List) obj9);
                                this.d = listB113;
                                this.f = j15;
                                this.e = j14;
                                arrayList = new ArrayList();
                                while (r0.hasNext()) {
                                    if (!set8.contains((String) obj12)) {
                                        arrayList.add(obj12);
                                    }
                                }
                                if (arrayList.isEmpty()) {
                                    h72Var2 = new h72(new IllegalStateException(str6));
                                } else {
                                    pd1Var = new pd1(j15, arrayList);
                                }
                            }
                            an1Var13 = an1Var12;
                        }
                        pd1Var = h72Var2;
                        an1Var13 = an1Var12;
                        break;
                    }
                    an1Var13.h(null);
                    return pd1Var;
                case 6:
                    long j24 = ns0Var.x;
                    long j25 = ns0Var.w;
                    long j26 = ns0Var.v;
                    long j27 = ns0Var.u;
                    i7 = ns0Var.s;
                    int i28 = ns0Var.n;
                    boolean z7 = ns0Var.e;
                    str4 = (String) ns0Var.j;
                    set5 = ns0Var.i;
                    an1 an1Var19 = ns0Var.f;
                    bz3.g(objI2);
                    j7 = j25;
                    j5 = j24;
                    an1Var10 = an1Var19;
                    z3 = z7;
                    objG2 = objI2;
                    str2 = "No compatible Gemini Live models are available for this key";
                    f0Var = f0Var3;
                    i4 = i28;
                    obj7 = obj10;
                    j3 = j27;
                    j4 = j26;
                    if (j7 > ((Number) objG2).longValue()) {
                        Set set17 = set5;
                        f0Var2 = f0Var;
                        set6 = set17;
                        long j118 = j3;
                        z4 = z3;
                        j8 = j118;
                        i8 = i7;
                        j9 = j4;
                        i9 = 1;
                        an1Var9 = an1Var10;
                    } else {
                        set4 = set5;
                        i5 = i7;
                        an1Var8 = an1Var10;
                        f0 f0Var10 = f0Var;
                        set6 = set4;
                        i8 = i5;
                        f0Var2 = f0Var10;
                        long j119 = j3;
                        z4 = z3;
                        j8 = j119;
                        j9 = j4;
                        i9 = 0;
                        an1Var9 = an1Var8;
                    }
                    str5 = str4;
                    if (!z4) {
                        if (z4) {
                            j10 = j5;
                            if (this.f == j8) {
                                j13 = j9 - this.e;
                                if (0 > j13) {
                                }
                            }
                        } else {
                            j10 = j5;
                        }
                        String str1112 = str2;
                        set7 = set6;
                        str6 = str1112;
                        l2 l2Var114 = new l2(this, (x50) null, 3);
                        ns0Var.f = an1Var9;
                        ns0Var.i = set7;
                        ns0Var.j = str5;
                        ns0Var.e = z4;
                        ns0Var.n = i4;
                        ns0Var.s = i8;
                        ns0Var.u = j8;
                        ns0Var.v = j9;
                        ns0Var.t = i9;
                        i10 = i4;
                        i11 = i9;
                        j11 = j10;
                        ns0Var.w = j11;
                        ns0Var.Y = 7;
                        objC = xc4.c(8000L, l2Var114, ns0Var);
                        if (objC == obj7) {
                            return obj7;
                        }
                        i12 = i8;
                        i13 = i10;
                        obj8 = objC;
                        j12 = j11;
                        i14 = i11;
                        an1Var11 = an1Var9;
                        i72Var = (i72) obj8;
                        if (i72Var != null) {
                            h72Var = i72Var.a;
                        } else {
                            h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                        }
                        ns0Var.f = an1Var11;
                        ns0Var.i = set7;
                        ns0Var.j = h72Var;
                        ns0Var.k = str5;
                        ns0Var.e = z4;
                        ns0Var.n = i13;
                        ns0Var.s = i12;
                        ns0Var.u = j8;
                        ns0Var.v = j9;
                        ns0Var.t = i14;
                        ns0Var.w = j12;
                        ns0Var.Y = 8;
                        objI2 = f0Var2.i(ns0Var);
                        if (objI2 == obj7) {
                            return obj7;
                        }
                        j14 = j9;
                        str7 = str5;
                        j15 = j8;
                        an1Var12 = an1Var11;
                        set8 = set7;
                        obj9 = h72Var;
                        if (((Number) objI2).longValue() != j15) {
                            h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                        } else {
                            if (obj9 instanceof h72) {
                                Throwable thA114 = i72.a(obj9);
                                thA114.getClass();
                                boolean zContains114 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA114));
                                if (str7 == null) {
                                }
                                h72Var2 = new h72(thA114);
                            } else {
                                x42 x42Var115 = od1.a;
                                bz3.g(obj9);
                                List listB114 = od1.b((List) obj9);
                                this.d = listB114;
                                this.f = j15;
                                this.e = j14;
                                arrayList = new ArrayList();
                                while (r0.hasNext()) {
                                    if (!set8.contains((String) obj12)) {
                                        arrayList.add(obj12);
                                    }
                                }
                                if (arrayList.isEmpty()) {
                                    h72Var2 = new h72(new IllegalStateException(str6));
                                } else {
                                    pd1Var = new pd1(j15, arrayList);
                                }
                            }
                            an1Var13 = an1Var12;
                        }
                        pd1Var = h72Var2;
                        an1Var13 = an1Var12;
                        break;
                    } else {
                        if (z4) {
                            j10 = j5;
                            if (this.f == j8) {
                                j13 = j9 - this.e;
                                if (0 > j13) {
                                }
                            }
                        } else {
                            j10 = j5;
                        }
                        String str1113 = str2;
                        set7 = set6;
                        str6 = str1113;
                        l2 l2Var115 = new l2(this, (x50) null, 3);
                        ns0Var.f = an1Var9;
                        ns0Var.i = set7;
                        ns0Var.j = str5;
                        ns0Var.e = z4;
                        ns0Var.n = i4;
                        ns0Var.s = i8;
                        ns0Var.u = j8;
                        ns0Var.v = j9;
                        ns0Var.t = i9;
                        i10 = i4;
                        i11 = i9;
                        j11 = j10;
                        ns0Var.w = j11;
                        ns0Var.Y = 7;
                        objC = xc4.c(8000L, l2Var115, ns0Var);
                        if (objC == obj7) {
                            return obj7;
                        }
                        i12 = i8;
                        i13 = i10;
                        obj8 = objC;
                        j12 = j11;
                        i14 = i11;
                        an1Var11 = an1Var9;
                        i72Var = (i72) obj8;
                        if (i72Var != null) {
                            h72Var = i72Var.a;
                        } else {
                            h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                        }
                        ns0Var.f = an1Var11;
                        ns0Var.i = set7;
                        ns0Var.j = h72Var;
                        ns0Var.k = str5;
                        ns0Var.e = z4;
                        ns0Var.n = i13;
                        ns0Var.s = i12;
                        ns0Var.u = j8;
                        ns0Var.v = j9;
                        ns0Var.t = i14;
                        ns0Var.w = j12;
                        ns0Var.Y = 8;
                        objI2 = f0Var2.i(ns0Var);
                        if (objI2 == obj7) {
                            return obj7;
                        }
                        j14 = j9;
                        str7 = str5;
                        j15 = j8;
                        an1Var12 = an1Var11;
                        set8 = set7;
                        obj9 = h72Var;
                        if (((Number) objI2).longValue() != j15) {
                            h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                        } else {
                            if (obj9 instanceof h72) {
                                Throwable thA115 = i72.a(obj9);
                                thA115.getClass();
                                boolean zContains115 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA115));
                                if (str7 == null) {
                                }
                                h72Var2 = new h72(thA115);
                            } else {
                                x42 x42Var116 = od1.a;
                                bz3.g(obj9);
                                List listB115 = od1.b((List) obj9);
                                this.d = listB115;
                                this.f = j15;
                                this.e = j14;
                                arrayList = new ArrayList();
                                while (r0.hasNext()) {
                                    if (!set8.contains((String) obj12)) {
                                        arrayList.add(obj12);
                                    }
                                }
                                if (arrayList.isEmpty()) {
                                    h72Var2 = new h72(new IllegalStateException(str6));
                                } else {
                                    pd1Var = new pd1(j15, arrayList);
                                }
                            }
                            an1Var13 = an1Var12;
                        }
                        pd1Var = h72Var2;
                        an1Var13 = an1Var12;
                        break;
                    }
                    an1Var13.h(null);
                    return pd1Var;
                case 7:
                    long j28 = ns0Var.w;
                    int i29 = ns0Var.t;
                    j9 = ns0Var.v;
                    long j29 = ns0Var.u;
                    i12 = ns0Var.s;
                    i13 = ns0Var.n;
                    z4 = ns0Var.e;
                    String str21 = (String) ns0Var.j;
                    Set set18 = ns0Var.i;
                    an1 an1Var20 = ns0Var.f;
                    bz3.g(objI2);
                    f0Var2 = f0Var3;
                    str5 = str21;
                    an1Var11 = an1Var20;
                    obj8 = objI2;
                    set7 = set18;
                    str6 = "No compatible Gemini Live models are available for this key";
                    i14 = i29;
                    j12 = j28;
                    obj7 = obj10;
                    j8 = j29;
                    i72Var = (i72) obj8;
                    if (i72Var != null) {
                        h72Var = i72Var.a;
                    } else {
                        h72Var = new h72(new SocketTimeoutException("Gemini Live model discovery timed out"));
                    }
                    ns0Var.f = an1Var11;
                    ns0Var.i = set7;
                    ns0Var.j = h72Var;
                    ns0Var.k = str5;
                    ns0Var.e = z4;
                    ns0Var.n = i13;
                    ns0Var.s = i12;
                    ns0Var.u = j8;
                    ns0Var.v = j9;
                    ns0Var.t = i14;
                    ns0Var.w = j12;
                    ns0Var.Y = 8;
                    objI2 = f0Var2.i(ns0Var);
                    if (objI2 == obj7) {
                        return obj7;
                    }
                    j14 = j9;
                    str7 = str5;
                    j15 = j8;
                    an1Var12 = an1Var11;
                    set8 = set7;
                    obj9 = h72Var;
                    if (((Number) objI2).longValue() != j15) {
                        if (obj9 instanceof h72) {
                            Throwable thA116 = i72.a(obj9);
                            thA116.getClass();
                            boolean zContains116 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA116));
                            if (str7 == null) {
                            }
                            h72Var2 = new h72(thA116);
                        } else {
                            x42 x42Var117 = od1.a;
                            bz3.g(obj9);
                            List listB116 = od1.b((List) obj9);
                            this.d = listB116;
                            this.f = j15;
                            this.e = j14;
                            arrayList = new ArrayList();
                            while (r0.hasNext()) {
                                if (!set8.contains((String) obj12)) {
                                    arrayList.add(obj12);
                                }
                            }
                            if (arrayList.isEmpty()) {
                                h72Var2 = new h72(new IllegalStateException(str6));
                            } else {
                                pd1Var = new pd1(j15, arrayList);
                            }
                        }
                        an1Var13 = an1Var12;
                        an1Var13.h(null);
                        return pd1Var;
                    }
                    h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                    pd1Var = h72Var2;
                    an1Var13 = an1Var12;
                    an1Var13.h(null);
                    return pd1Var;
                case 8:
                    j14 = ns0Var.v;
                    j15 = ns0Var.u;
                    str7 = ns0Var.k;
                    obj9 = ns0Var.j;
                    set8 = ns0Var.i;
                    an1 an1Var21 = ns0Var.f;
                    try {
                        bz3.g(objI2);
                        str6 = "No compatible Gemini Live models are available for this key";
                        an1Var12 = an1Var21;
                        if (((Number) objI2).longValue() != j15) {
                            if (obj9 instanceof h72) {
                                Throwable thA117 = i72.a(obj9);
                                thA117.getClass();
                                boolean zContains117 = wh2.c(w30.b, w30.c, w30.s).contains(oj4.b(thA117));
                                if (str7 == null) {
                                }
                                h72Var2 = new h72(thA117);
                            } else {
                                x42 x42Var118 = od1.a;
                                bz3.g(obj9);
                                List listB117 = od1.b((List) obj9);
                                this.d = listB117;
                                this.f = j15;
                                this.e = j14;
                                arrayList = new ArrayList();
                                while (r0.hasNext()) {
                                    if (!set8.contains((String) obj12)) {
                                        arrayList.add(obj12);
                                    }
                                }
                                if (arrayList.isEmpty()) {
                                    h72Var2 = new h72(new IllegalStateException(str6));
                                } else {
                                    pd1Var = new pd1(j15, arrayList);
                                }
                            }
                            an1Var13 = an1Var12;
                            an1Var13.h(null);
                            return pd1Var;
                        }
                        h72Var2 = new h72(new IllegalStateException("Gemini key changed during model discovery"));
                        pd1Var = h72Var2;
                        an1Var13 = an1Var12;
                        an1Var13.h(null);
                        return pd1Var;
                    } catch (Throwable th6) {
                        th = th6;
                        obj = null;
                        an1Var2 = an1Var21;
                        an1Var2.h(obj);
                        throw th;
                    }
                default:
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        } catch (Throwable th7) {
            th = th7;
            an1Var = objI2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00da  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ed A[Catch: all -> 0x00f5, TryCatch #0 {all -> 0x00f5, blocks: (B:62:0x012a, B:45:0x00de, B:47:0x00ed, B:58:0x0107, B:52:0x00f8, B:57:0x0103, B:41:0x00c3, B:37:0x00ab), top: B:67:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f8 A[Catch: all -> 0x00f5, TryCatch #0 {all -> 0x00f5, blocks: (B:62:0x012a, B:45:0x00de, B:47:0x00ed, B:58:0x0107, B:52:0x00f8, B:57:0x0103, B:41:0x00c3, B:37:0x00ab), top: B:67:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:57:0x0103 A[Catch: all -> 0x00f5, TryCatch #0 {all -> 0x00f5, blocks: (B:62:0x012a, B:45:0x00de, B:47:0x00ed, B:58:0x0107, B:52:0x00f8, B:57:0x0103, B:41:0x00c3, B:37:0x00ab), top: B:67:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0129  */
    /* JADX WARN: Code duplicated, block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object b(String str, long j, y50 y50Var) throws Throwable {
        os0 os0Var;
        an1 an1Var;
        long j2;
        String str2;
        int i;
        int i2;
        int i3;
        String str3;
        String str4;
        Object objG;
        String str5;
        int i4;
        long j3;
        long jLongValue;
        Object objK;
        long j4;
        Throwable th;
        if (y50Var instanceof os0) {
            os0Var = (os0) y50Var;
            int i5 = os0Var.u;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                os0Var.u = i5 - Integer.MIN_VALUE;
            } else {
                os0Var = new os0(this, y50Var);
            }
        } else {
            os0Var = new os0(this, y50Var);
        }
        os0 os0Var2 = os0Var;
        Object obj = os0Var2.s;
        int i6 = os0Var2.u;
        f0 f0Var = this.b;
        Object obj2 = null;
        t70 t70Var = t70.a;
        try {
            if (i6 == 0) {
                bz3.g(obj);
                os0Var2.e = str;
                an1Var = this.c;
                os0Var2.f = an1Var;
                j2 = j;
                os0Var2.j = j2;
                os0Var2.k = 0;
                os0Var2.u = 1;
                if (an1Var.e(os0Var2) != t70Var) {
                    str2 = str;
                    i = 0;
                }
                return t70Var;
            }
            if (i6 != 1) {
                if (i6 == 2) {
                    int i7 = os0Var2.n;
                    int i8 = os0Var2.k;
                    long j5 = os0Var2.j;
                    an1 an1Var2 = os0Var2.f;
                    String str6 = os0Var2.e;
                    try {
                        bz3.g(obj);
                        i2 = i8;
                        an1Var = an1Var2;
                        i3 = i7;
                        str3 = str6;
                        j2 = j5;
                        str4 = (String) obj;
                        os0Var2.e = str3;
                        os0Var2.f = an1Var;
                        os0Var2.i = str4;
                        os0Var2.j = j2;
                        os0Var2.k = i2;
                        os0Var2.n = i3;
                        os0Var2.u = 3;
                        objG = f0Var.g("gemini_live", os0Var2);
                        if (objG != t70Var) {
                            return t70Var;
                        }
                        str5 = str4;
                        obj = objG;
                        i4 = i2;
                        j3 = j2;
                        jLongValue = ((Number) obj).longValue();
                        if (this.f == j3) {
                            j4 = this.e;
                            if (j4 > 0) {
                                jLongValue = j4;
                            } else if (g31.a(str5, str3)) {
                                jLongValue = System.currentTimeMillis();
                            } else {
                                jLongValue = System.currentTimeMillis();
                            }
                        } else if (g31.a(str5, str3)) {
                            jLongValue = System.currentTimeMillis();
                        } else {
                            jLongValue = System.currentTimeMillis();
                        }
                        f0 f0Var2 = this.b;
                        os0Var2.e = null;
                        os0Var2.f = an1Var;
                        os0Var2.i = null;
                        os0Var2.j = j3;
                        os0Var2.k = i4;
                        os0Var2.n = i3;
                        os0Var2.u = 4;
                        objK = f0Var2.k("gemini_live", str3, jLongValue, j3, os0Var2);
                        if (objK == t70Var) {
                            return t70Var;
                        }
                        obj = objK;
                    } catch (Throwable th2) {
                        th = th2;
                        an1Var = an1Var2;
                    }
                } else if (i6 == 3) {
                    int i9 = os0Var2.n;
                    i4 = os0Var2.k;
                    j3 = os0Var2.j;
                    str5 = os0Var2.i;
                    an1 an1Var3 = os0Var2.f;
                    str3 = os0Var2.e;
                    try {
                        bz3.g(obj);
                        i3 = i9;
                        an1Var = an1Var3;
                        jLongValue = ((Number) obj).longValue();
                        if (this.f == j3) {
                            j4 = this.e;
                            if (j4 > 0) {
                                jLongValue = j4;
                            } else if (g31.a(str5, str3) || jLongValue <= 0) {
                                jLongValue = System.currentTimeMillis();
                            }
                        } else if (g31.a(str5, str3)) {
                            jLongValue = System.currentTimeMillis();
                        } else {
                            jLongValue = System.currentTimeMillis();
                        }
                        f0 f0Var3 = this.b;
                        os0Var2.e = null;
                        os0Var2.f = an1Var;
                        os0Var2.i = null;
                        os0Var2.j = j3;
                        os0Var2.k = i4;
                        os0Var2.n = i3;
                        os0Var2.u = 4;
                        objK = f0Var3.k("gemini_live", str3, jLongValue, j3, os0Var2);
                        if (objK == t70Var) {
                            return t70Var;
                        }
                        obj = objK;
                    } catch (Throwable th3) {
                        th = th3;
                        an1Var = an1Var3;
                    }
                } else {
                    if (i6 != 4) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    an1Var = os0Var2.f;
                    try {
                        bz3.g(obj);
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                an1Var.h(obj2);
                throw th;
            }
            int i10 = os0Var2.k;
            j2 = os0Var2.j;
            an1 an1Var4 = os0Var2.f;
            str2 = os0Var2.e;
            bz3.g(obj);
            i = i10;
            an1Var = an1Var4;
            Boolean bool = (Boolean) obj;
            bool.getClass();
            an1Var.h(null);
            return bool;
            os0Var2.e = str2;
            os0Var2.f = an1Var;
            os0Var2.j = j2;
            os0Var2.k = i;
            os0Var2.n = 0;
            os0Var2.u = 2;
            Object objH = f0Var.h("gemini_live", os0Var2);
            if (objH != t70Var) {
                i2 = i;
                obj = objH;
                i3 = 0;
                str3 = str2;
                str4 = (String) obj;
                os0Var2.e = str3;
                os0Var2.f = an1Var;
                os0Var2.i = str4;
                os0Var2.j = j2;
                os0Var2.k = i2;
                os0Var2.n = i3;
                os0Var2.u = 3;
                objG = f0Var.g("gemini_live", os0Var2);
                if (objG != t70Var) {
                    str5 = str4;
                    obj = objG;
                    i4 = i2;
                    j3 = j2;
                    jLongValue = ((Number) obj).longValue();
                    if (this.f == j3) {
                        j4 = this.e;
                        if (j4 > 0) {
                            jLongValue = j4;
                        } else if (g31.a(str5, str3)) {
                            jLongValue = System.currentTimeMillis();
                        } else {
                            jLongValue = System.currentTimeMillis();
                        }
                    } else if (g31.a(str5, str3)) {
                        jLongValue = System.currentTimeMillis();
                    } else {
                        jLongValue = System.currentTimeMillis();
                    }
                    f0 f0Var4 = this.b;
                    os0Var2.e = null;
                    os0Var2.f = an1Var;
                    os0Var2.i = null;
                    os0Var2.j = j3;
                    os0Var2.k = i4;
                    os0Var2.n = i3;
                    os0Var2.u = 4;
                    objK = f0Var4.k("gemini_live", str3, jLongValue, j3, os0Var2);
                    if (objK == t70Var) {
                        return t70Var;
                    }
                    obj = objK;
                    Boolean bool2 = (Boolean) obj;
                    bool2.getClass();
                    an1Var.h(null);
                    return bool2;
                }
            }
            return t70Var;
        } catch (Throwable th5) {
            th = th5;
            obj2 = null;
        }
    }
}
