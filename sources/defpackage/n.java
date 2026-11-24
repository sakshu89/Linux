package defpackage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public final Map a;
    public final f0 b;
    public final ip1 c;
    public final ge d;

    public n(Map map, f0 f0Var, ip1 ip1Var) {
        map.getClass();
        f0Var.getClass();
        ip1Var.getClass();
        this.a = map;
        this.b = f0Var;
        this.c = ip1Var;
        this.d = new ge();
    }

    public static final void b(String str, StringBuilder sb) {
        sb.append(str.length());
        sb.append(':');
        sb.append(str);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(y50 y50Var) {
        k kVar;
        c cVar;
        if (y50Var instanceof k) {
            kVar = (k) y50Var;
            int i = kVar.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                kVar.i = i - Integer.MIN_VALUE;
            } else {
                kVar = new k(this, y50Var);
            }
        } else {
            kVar = new k(this, y50Var);
        }
        Object objC = kVar.e;
        int i2 = kVar.i;
        if (i2 == 0) {
            bz3.g(objC);
            kVar.i = 1;
            objC = rn4.c(this.b.b, kVar);
            t70 t70Var = t70.a;
            if (objC == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(objC);
        }
        o oVar = (o) objC;
        return (oVar.a && (cVar = (c) this.a.get(oVar.b)) != null) ? cVar : this.c;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0240 A[ADDED_TO_REGION, DONT_GENERATE, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:103:0x0242 A[Catch: all -> 0x028c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:96:0x0222, B:103:0x0242, B:107:0x024a, B:108:0x026b, B:110:0x0277), top: B:139:0x0222 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0277 A[Catch: all -> 0x028c, TRY_LEAVE, TryCatch #1 {, blocks: (B:96:0x0222, B:103:0x0242, B:107:0x024a, B:108:0x026b, B:110:0x0277), top: B:139:0x0222 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:124:0x02cd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:125:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:127:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:132:0x0310  */
    /* JADX WARN: Code duplicated, block: B:138:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0222 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x008f  */
    /* JADX WARN: Code duplicated, block: B:32:0x009e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x009f  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00eb A[LOOP:1: B:38:0x00e5->B:40:0x00eb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:46:0x014c  */
    /* JADX WARN: Code duplicated, block: B:48:0x014f A[ADDED_TO_REGION, DONT_GENERATE, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:50:0x0151 A[Catch: all -> 0x0180, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:43:0x0131, B:50:0x0151, B:54:0x015f, B:57:0x017a, B:62:0x0183), top: B:138:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x017a A[Catch: all -> 0x0180, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:43:0x0131, B:50:0x0151, B:54:0x015f, B:57:0x017a, B:62:0x0183), top: B:138:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0183 A[Catch: all -> 0x0180, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:43:0x0131, B:50:0x0151, B:54:0x015f, B:57:0x017a, B:62:0x0183), top: B:138:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0193  */
    /* JADX WARN: Code duplicated, block: B:68:0x019d  */
    /* JADX WARN: Code duplicated, block: B:71:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:74:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:76:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:85:0x01e4 A[PHI: r1 r7 r9
      0x01e4: PHI (r1v36 h) = (r1v23 h), (r1v38 h) binds: [B:86:0x01e6, B:83:0x01e1] A[DONT_GENERATE, DONT_INLINE]
      0x01e4: PHI (r7v9 long) = (r7v5 long), (r7v10 long) binds: [B:86:0x01e6, B:83:0x01e1] A[DONT_GENERATE, DONT_INLINE]
      0x01e4: PHI (r9v6 java.lang.String) = (r9v2 java.lang.String), (r9v7 java.lang.String) binds: [B:86:0x01e6, B:83:0x01e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:89:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:92:0x0206 A[PHI: r1 r4 r7 r9
      0x0206: PHI (r1v39 java.lang.Object) = (r1v35 java.lang.Object), (r1v1 java.lang.Object) binds: [B:90:0x0202, B:16:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x0206: PHI (r4v27 h) = (r4v23 h), (r4v28 h) binds: [B:90:0x0202, B:16:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x0206: PHI (r7v12 long) = (r7v7 long), (r7v14 long) binds: [B:90:0x0202, B:16:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x0206: PHI (r9v9 java.lang.String) = (r9v5 java.lang.String), (r9v19 java.lang.String) binds: [B:90:0x0202, B:16:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:94:0x0210  */
    /* JADX WARN: Code duplicated, block: B:99:0x023d  */
    public final Object c(d dVar, y50 y50Var) throws NoSuchAlgorithmException {
        l lVar;
        d dVar2;
        Object objA;
        c cVar;
        Object objI;
        d dVar3;
        Object objD;
        c cVar2;
        long jLongValue;
        StringBuilder sb;
        String strR;
        ge geVar;
        String lowerCase;
        fe feVar;
        long jLongValue2;
        long j;
        LinkedHashMap linkedHashMap;
        Object objD2;
        String str;
        h hVar;
        String str2;
        e eVar;
        h hVar2;
        Object objA2;
        Object objA3;
        ge geVar2;
        String str3;
        String lowerCase2;
        if (y50Var instanceof l) {
            lVar = (l) y50Var;
            int i = lVar.u;
            if ((i & Integer.MIN_VALUE) != 0) {
                lVar.u = i - Integer.MIN_VALUE;
            } else {
                lVar = new l(this, y50Var);
            }
        } else {
            lVar = new l(this, y50Var);
        }
        Object objI2 = lVar.s;
        Object obj = t70.a;
        String str4 = null;
        switch (lVar.u) {
            case 0:
                bz3.g(objI2);
                dVar2 = dVar;
                lVar.e = dVar2;
                lVar.u = 1;
                objA = a(lVar);
                if (objA != obj) {
                    cVar = (c) objA;
                    if (!cVar.b()) {
                        f0 f0Var = this.b;
                        lVar.e = dVar2;
                        lVar.f = cVar;
                        lVar.u = 3;
                        objI = f0Var.i(lVar);
                        if (objI != obj) {
                            dVar3 = dVar2;
                            objI2 = objI;
                            cVar2 = cVar;
                            jLongValue = ((Number) objI2).longValue();
                            String id = cVar2.getId();
                            sb = new StringBuilder();
                            b(id, sb);
                            b(String.valueOf(jLongValue), sb);
                            b(dVar3.a, sb);
                            b(dVar3.b, sb);
                            b(String.valueOf(dVar3.d), sb);
                            for (h0 h0Var : dVar3.c) {
                                b(h0Var.a.name(), sb);
                                b(h0Var.b, sb);
                            }
                            String string = sb.toString();
                            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                            byte[] bytes = string.getBytes(px.a);
                            bytes.getClass();
                            byte[] bArrDigest = messageDigest.digest(bytes);
                            bArrDigest.getClass();
                            strR = qg.r(bArrDigest, "", new j(0), 30);
                            geVar = this.d;
                            geVar.getClass();
                            synchronized (((LinkedHashMap) geVar.d)) {
                                String string2 = cs2.V(strR).toString();
                                Locale locale = Locale.ROOT;
                                locale.getClass();
                                lowerCase = string2.toLowerCase(locale);
                                lowerCase.getClass();
                                if (lowerCase.length() <= 0) {
                                    lowerCase = null;
                                }
                                if (lowerCase == null && (feVar = (fe) ((LinkedHashMap) geVar.d).get(lowerCase)) != null) {
                                    jLongValue2 = ((Number) ((fq0) geVar.c).a()).longValue() - feVar.b;
                                    j = geVar.a;
                                    linkedHashMap = (LinkedHashMap) geVar.d;
                                    if (jLongValue2 >= j) {
                                        linkedHashMap.remove(lowerCase);
                                        str4 = null;
                                    } else {
                                        linkedHashMap.remove(lowerCase);
                                        ((LinkedHashMap) geVar.d).put(lowerCase, feVar);
                                        str4 = feVar.a;
                                    }
                                }
                            }
                            if (str4 != null) {
                                return new f(str4, cVar2.getId());
                            }
                            lVar.e = dVar3;
                            lVar.f = cVar2;
                            lVar.i = strR;
                            lVar.n = jLongValue;
                            lVar.u = 4;
                            objD2 = d(cVar2, dVar3, lVar);
                            if (objD2 != obj) {
                                str = strR;
                                objI2 = objD2;
                                hVar = (h) objI2;
                                if (hVar instanceof e) {
                                    eVar = (e) hVar;
                                    if (!eVar.c && eVar.d) {
                                        lVar.e = null;
                                        lVar.f = null;
                                        lVar.i = str;
                                        lVar.j = eVar;
                                        lVar.n = jLongValue;
                                        lVar.u = 5;
                                        Object objA4 = cVar2.a(dVar3, lVar);
                                        if (objA4 != obj) {
                                            str2 = str;
                                            hVar2 = hVar;
                                            objI2 = objA4;
                                            hVar = (h) objI2;
                                            if (hVar != null) {
                                                hVar2 = hVar;
                                            }
                                            if (hVar2 instanceof f) {
                                                if ((hVar2 instanceof e) && ((e) hVar2).d) {
                                                    f0 f0Var2 = this.b;
                                                    lVar.e = null;
                                                    lVar.f = null;
                                                    lVar.i = null;
                                                    lVar.j = null;
                                                    lVar.k = hVar2;
                                                    lVar.n = jLongValue;
                                                    lVar.u = 8;
                                                    f0Var2.getClass();
                                                    String string3 = LocalDate.now().toString();
                                                    string3.getClass();
                                                    objA2 = rq1.a(g0.a(f0Var2.a), new y(string3, null, 0), lVar);
                                                    if (objA2 != t70.a) {
                                                        objA2 = q43.a;
                                                    }
                                                    if (objA2 == obj) {
                                                    }
                                                }
                                                return hVar2;
                                            }
                                            f0 f0Var3 = this.b;
                                            lVar.e = null;
                                            lVar.f = null;
                                            lVar.i = str2;
                                            lVar.j = null;
                                            lVar.k = hVar2;
                                            lVar.n = jLongValue;
                                            lVar.u = 6;
                                            objI2 = f0Var3.i(lVar);
                                            if (objI2 != obj) {
                                                if (((Number) objI2).longValue() == jLongValue) {
                                                    geVar2 = this.d;
                                                    str3 = ((f) hVar2).a;
                                                    geVar2.getClass();
                                                    str2.getClass();
                                                    synchronized (((LinkedHashMap) geVar2.d)) {
                                                        String string4 = cs2.V(str2).toString();
                                                        Locale locale2 = Locale.ROOT;
                                                        locale2.getClass();
                                                        lowerCase2 = string4.toLowerCase(locale2);
                                                        lowerCase2.getClass();
                                                        if (lowerCase2.length() <= 0) {
                                                            lowerCase2 = null;
                                                        }
                                                        if (lowerCase2 == null && !cs2.A(str3)) {
                                                            ((LinkedHashMap) geVar2.d).remove(lowerCase2);
                                                            ((LinkedHashMap) geVar2.d).put(lowerCase2, new fe(((Number) ((fq0) geVar2.c).a()).longValue(), str3));
                                                            while (((LinkedHashMap) geVar2.d).size() > geVar2.b) {
                                                                LinkedHashMap linkedHashMap2 = (LinkedHashMap) geVar2.d;
                                                                Set setKeySet = linkedHashMap2.keySet();
                                                                setKeySet.getClass();
                                                                linkedHashMap2.remove(mz.w(setKeySet));
                                                            }
                                                        }
                                                    }
                                                }
                                                f0 f0Var4 = this.b;
                                                lVar.e = null;
                                                lVar.f = null;
                                                lVar.i = null;
                                                lVar.j = null;
                                                lVar.k = hVar2;
                                                lVar.n = jLongValue;
                                                lVar.u = 7;
                                                f0Var4.getClass();
                                                String string5 = LocalDate.now().toString();
                                                string5.getClass();
                                                objA3 = rq1.a(g0.a(f0Var4.a), new y(string5, null, 0), lVar);
                                                if (objA3 != t70.a) {
                                                    objA3 = q43.a;
                                                }
                                                if (objA3 == obj) {
                                                    return hVar2;
                                                }
                                            }
                                        }
                                    }
                                }
                                str2 = str;
                                hVar2 = hVar;
                                if (hVar2 instanceof f) {
                                    if (hVar2 instanceof e) {
                                        f0 f0Var5 = this.b;
                                        lVar.e = null;
                                        lVar.f = null;
                                        lVar.i = null;
                                        lVar.j = null;
                                        lVar.k = hVar2;
                                        lVar.n = jLongValue;
                                        lVar.u = 8;
                                        f0Var5.getClass();
                                        String string6 = LocalDate.now().toString();
                                        string6.getClass();
                                        objA2 = rq1.a(g0.a(f0Var5.a), new y(string6, null, 0), lVar);
                                        if (objA2 != t70.a) {
                                            objA2 = q43.a;
                                        }
                                        if (objA2 == obj) {
                                        }
                                    }
                                    return hVar2;
                                }
                                f0 f0Var6 = this.b;
                                lVar.e = null;
                                lVar.f = null;
                                lVar.i = str2;
                                lVar.j = null;
                                lVar.k = hVar2;
                                lVar.n = jLongValue;
                                lVar.u = 6;
                                objI2 = f0Var6.i(lVar);
                                if (objI2 != obj) {
                                    if (((Number) objI2).longValue() == jLongValue) {
                                        geVar2 = this.d;
                                        str3 = ((f) hVar2).a;
                                        geVar2.getClass();
                                        str2.getClass();
                                        synchronized (((LinkedHashMap) geVar2.d)) {
                                            String string7 = cs2.V(str2).toString();
                                            Locale locale3 = Locale.ROOT;
                                            locale3.getClass();
                                            lowerCase2 = string7.toLowerCase(locale3);
                                            lowerCase2.getClass();
                                            if (lowerCase2.length() <= 0) {
                                                lowerCase2 = null;
                                            }
                                            if (lowerCase2 == null) {
                                                ((LinkedHashMap) geVar2.d).remove(lowerCase2);
                                                ((LinkedHashMap) geVar2.d).put(lowerCase2, new fe(((Number) ((fq0) geVar2.c).a()).longValue(), str3));
                                                while (((LinkedHashMap) geVar2.d).size() > geVar2.b) {
                                                    LinkedHashMap linkedHashMap3 = (LinkedHashMap) geVar2.d;
                                                    Set setKeySet2 = linkedHashMap3.keySet();
                                                    setKeySet2.getClass();
                                                    linkedHashMap3.remove(mz.w(setKeySet2));
                                                }
                                            }
                                        }
                                    }
                                    f0 f0Var7 = this.b;
                                    lVar.e = null;
                                    lVar.f = null;
                                    lVar.i = null;
                                    lVar.j = null;
                                    lVar.k = hVar2;
                                    lVar.n = jLongValue;
                                    lVar.u = 7;
                                    f0Var7.getClass();
                                    String string8 = LocalDate.now().toString();
                                    string8.getClass();
                                    objA3 = rq1.a(g0.a(f0Var7.a), new y(string8, null, 0), lVar);
                                    if (objA3 != t70.a) {
                                        objA3 = q43.a;
                                    }
                                    if (objA3 == obj) {
                                        return hVar2;
                                    }
                                }
                            }
                        }
                    } else {
                        lVar.e = null;
                        lVar.f = null;
                        lVar.u = 2;
                        objD = d(cVar, dVar2, lVar);
                        if (objD == obj) {
                            return objD;
                        }
                    }
                }
                return obj;
            case 1:
                d dVar4 = lVar.e;
                bz3.g(objI2);
                objA = objI2;
                dVar2 = dVar4;
                cVar = (c) objA;
                if (!cVar.b()) {
                    f0 f0Var8 = this.b;
                    lVar.e = dVar2;
                    lVar.f = cVar;
                    lVar.u = 3;
                    objI = f0Var8.i(lVar);
                    if (objI != obj) {
                        dVar3 = dVar2;
                        objI2 = objI;
                        cVar2 = cVar;
                        jLongValue = ((Number) objI2).longValue();
                        String id2 = cVar2.getId();
                        sb = new StringBuilder();
                        b(id2, sb);
                        b(String.valueOf(jLongValue), sb);
                        b(dVar3.a, sb);
                        b(dVar3.b, sb);
                        b(String.valueOf(dVar3.d), sb);
                        while (r1.hasNext()) {
                            b(h0Var.a.name(), sb);
                            b(h0Var.b, sb);
                        }
                        String string9 = sb.toString();
                        MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-256");
                        byte[] bytes2 = string9.getBytes(px.a);
                        bytes2.getClass();
                        byte[] bArrDigest2 = messageDigest2.digest(bytes2);
                        bArrDigest2.getClass();
                        strR = qg.r(bArrDigest2, "", new j(0), 30);
                        geVar = this.d;
                        geVar.getClass();
                        synchronized (((LinkedHashMap) geVar.d)) {
                            String string10 = cs2.V(strR).toString();
                            Locale locale4 = Locale.ROOT;
                            locale4.getClass();
                            lowerCase = string10.toLowerCase(locale4);
                            lowerCase.getClass();
                            if (lowerCase.length() <= 0) {
                                lowerCase = null;
                            }
                            if (lowerCase == null) {
                                jLongValue2 = ((Number) ((fq0) geVar.c).a()).longValue() - feVar.b;
                                j = geVar.a;
                                linkedHashMap = (LinkedHashMap) geVar.d;
                                if (jLongValue2 >= j) {
                                    linkedHashMap.remove(lowerCase);
                                    str4 = null;
                                } else {
                                    linkedHashMap.remove(lowerCase);
                                    ((LinkedHashMap) geVar.d).put(lowerCase, feVar);
                                    str4 = feVar.a;
                                }
                            }
                            if (str4 != null) {
                                return new f(str4, cVar2.getId());
                            }
                            lVar.e = dVar3;
                            lVar.f = cVar2;
                            lVar.i = strR;
                            lVar.n = jLongValue;
                            lVar.u = 4;
                            objD2 = d(cVar2, dVar3, lVar);
                            if (objD2 != obj) {
                                str = strR;
                                objI2 = objD2;
                                hVar = (h) objI2;
                                if (hVar instanceof e) {
                                    eVar = (e) hVar;
                                    if (!eVar.c) {
                                    }
                                }
                                str2 = str;
                                hVar2 = hVar;
                                if (hVar2 instanceof f) {
                                    if (hVar2 instanceof e) {
                                        f0 f0Var9 = this.b;
                                        lVar.e = null;
                                        lVar.f = null;
                                        lVar.i = null;
                                        lVar.j = null;
                                        lVar.k = hVar2;
                                        lVar.n = jLongValue;
                                        lVar.u = 8;
                                        f0Var9.getClass();
                                        String string11 = LocalDate.now().toString();
                                        string11.getClass();
                                        objA2 = rq1.a(g0.a(f0Var9.a), new y(string11, null, 0), lVar);
                                        if (objA2 != t70.a) {
                                            objA2 = q43.a;
                                        }
                                        if (objA2 == obj) {
                                        }
                                    }
                                    return hVar2;
                                }
                                f0 f0Var10 = this.b;
                                lVar.e = null;
                                lVar.f = null;
                                lVar.i = str2;
                                lVar.j = null;
                                lVar.k = hVar2;
                                lVar.n = jLongValue;
                                lVar.u = 6;
                                objI2 = f0Var10.i(lVar);
                                if (objI2 != obj) {
                                    if (((Number) objI2).longValue() == jLongValue) {
                                        geVar2 = this.d;
                                        str3 = ((f) hVar2).a;
                                        geVar2.getClass();
                                        str2.getClass();
                                        synchronized (((LinkedHashMap) geVar2.d)) {
                                            String string12 = cs2.V(str2).toString();
                                            Locale locale5 = Locale.ROOT;
                                            locale5.getClass();
                                            lowerCase2 = string12.toLowerCase(locale5);
                                            lowerCase2.getClass();
                                            if (lowerCase2.length() <= 0) {
                                                lowerCase2 = null;
                                            }
                                            if (lowerCase2 == null) {
                                                ((LinkedHashMap) geVar2.d).remove(lowerCase2);
                                                ((LinkedHashMap) geVar2.d).put(lowerCase2, new fe(((Number) ((fq0) geVar2.c).a()).longValue(), str3));
                                                while (((LinkedHashMap) geVar2.d).size() > geVar2.b) {
                                                    LinkedHashMap linkedHashMap4 = (LinkedHashMap) geVar2.d;
                                                    Set setKeySet3 = linkedHashMap4.keySet();
                                                    setKeySet3.getClass();
                                                    linkedHashMap4.remove(mz.w(setKeySet3));
                                                }
                                            }
                                        }
                                    }
                                    f0 f0Var11 = this.b;
                                    lVar.e = null;
                                    lVar.f = null;
                                    lVar.i = null;
                                    lVar.j = null;
                                    lVar.k = hVar2;
                                    lVar.n = jLongValue;
                                    lVar.u = 7;
                                    f0Var11.getClass();
                                    String string13 = LocalDate.now().toString();
                                    string13.getClass();
                                    objA3 = rq1.a(g0.a(f0Var11.a), new y(string13, null, 0), lVar);
                                    if (objA3 != t70.a) {
                                        objA3 = q43.a;
                                    }
                                    if (objA3 == obj) {
                                        return hVar2;
                                    }
                                }
                            }
                        }
                    }
                    break;
                } else {
                    lVar.e = null;
                    lVar.f = null;
                    lVar.u = 2;
                    objD = d(cVar, dVar2, lVar);
                    if (objD == obj) {
                        return objD;
                    }
                }
                return obj;
            case 2:
                bz3.g(objI2);
                return objI2;
            case 3:
                cVar = lVar.f;
                d dVar5 = lVar.e;
                bz3.g(objI2);
                dVar3 = dVar5;
                cVar2 = cVar;
                jLongValue = ((Number) objI2).longValue();
                String id3 = cVar2.getId();
                sb = new StringBuilder();
                b(id3, sb);
                b(String.valueOf(jLongValue), sb);
                b(dVar3.a, sb);
                b(dVar3.b, sb);
                b(String.valueOf(dVar3.d), sb);
                while (r1.hasNext()) {
                    b(h0Var.a.name(), sb);
                    b(h0Var.b, sb);
                }
                String string14 = sb.toString();
                MessageDigest messageDigest3 = MessageDigest.getInstance("SHA-256");
                byte[] bytes3 = string14.getBytes(px.a);
                bytes3.getClass();
                byte[] bArrDigest3 = messageDigest3.digest(bytes3);
                bArrDigest3.getClass();
                strR = qg.r(bArrDigest3, "", new j(0), 30);
                geVar = this.d;
                geVar.getClass();
                synchronized (((LinkedHashMap) geVar.d)) {
                    String string15 = cs2.V(strR).toString();
                    Locale locale6 = Locale.ROOT;
                    locale6.getClass();
                    lowerCase = string15.toLowerCase(locale6);
                    lowerCase.getClass();
                    if (lowerCase.length() <= 0) {
                        lowerCase = null;
                    }
                    if (lowerCase == null) {
                        jLongValue2 = ((Number) ((fq0) geVar.c).a()).longValue() - feVar.b;
                        j = geVar.a;
                        linkedHashMap = (LinkedHashMap) geVar.d;
                        if (jLongValue2 >= j) {
                            linkedHashMap.remove(lowerCase);
                            str4 = null;
                        } else {
                            linkedHashMap.remove(lowerCase);
                            ((LinkedHashMap) geVar.d).put(lowerCase, feVar);
                            str4 = feVar.a;
                        }
                    }
                    if (str4 != null) {
                        return new f(str4, cVar2.getId());
                    }
                    lVar.e = dVar3;
                    lVar.f = cVar2;
                    lVar.i = strR;
                    lVar.n = jLongValue;
                    lVar.u = 4;
                    objD2 = d(cVar2, dVar3, lVar);
                    if (objD2 != obj) {
                        str = strR;
                        objI2 = objD2;
                        hVar = (h) objI2;
                        if (hVar instanceof e) {
                            eVar = (e) hVar;
                            if (!eVar.c) {
                            }
                        }
                        str2 = str;
                        hVar2 = hVar;
                        if (hVar2 instanceof f) {
                            if (hVar2 instanceof e) {
                                f0 f0Var12 = this.b;
                                lVar.e = null;
                                lVar.f = null;
                                lVar.i = null;
                                lVar.j = null;
                                lVar.k = hVar2;
                                lVar.n = jLongValue;
                                lVar.u = 8;
                                f0Var12.getClass();
                                String string16 = LocalDate.now().toString();
                                string16.getClass();
                                objA2 = rq1.a(g0.a(f0Var12.a), new y(string16, null, 0), lVar);
                                if (objA2 != t70.a) {
                                    objA2 = q43.a;
                                }
                                if (objA2 == obj) {
                                }
                            }
                            return hVar2;
                        }
                        f0 f0Var13 = this.b;
                        lVar.e = null;
                        lVar.f = null;
                        lVar.i = str2;
                        lVar.j = null;
                        lVar.k = hVar2;
                        lVar.n = jLongValue;
                        lVar.u = 6;
                        objI2 = f0Var13.i(lVar);
                        if (objI2 != obj) {
                            if (((Number) objI2).longValue() == jLongValue) {
                                geVar2 = this.d;
                                str3 = ((f) hVar2).a;
                                geVar2.getClass();
                                str2.getClass();
                                synchronized (((LinkedHashMap) geVar2.d)) {
                                    String string17 = cs2.V(str2).toString();
                                    Locale locale7 = Locale.ROOT;
                                    locale7.getClass();
                                    lowerCase2 = string17.toLowerCase(locale7);
                                    lowerCase2.getClass();
                                    if (lowerCase2.length() <= 0) {
                                        lowerCase2 = null;
                                    }
                                    if (lowerCase2 == null) {
                                        ((LinkedHashMap) geVar2.d).remove(lowerCase2);
                                        ((LinkedHashMap) geVar2.d).put(lowerCase2, new fe(((Number) ((fq0) geVar2.c).a()).longValue(), str3));
                                        while (((LinkedHashMap) geVar2.d).size() > geVar2.b) {
                                            LinkedHashMap linkedHashMap5 = (LinkedHashMap) geVar2.d;
                                            Set setKeySet4 = linkedHashMap5.keySet();
                                            setKeySet4.getClass();
                                            linkedHashMap5.remove(mz.w(setKeySet4));
                                        }
                                    }
                                }
                            }
                            f0 f0Var14 = this.b;
                            lVar.e = null;
                            lVar.f = null;
                            lVar.i = null;
                            lVar.j = null;
                            lVar.k = hVar2;
                            lVar.n = jLongValue;
                            lVar.u = 7;
                            f0Var14.getClass();
                            String string18 = LocalDate.now().toString();
                            string18.getClass();
                            objA3 = rq1.a(g0.a(f0Var14.a), new y(string18, null, 0), lVar);
                            if (objA3 != t70.a) {
                                objA3 = q43.a;
                            }
                            if (objA3 == obj) {
                                return hVar2;
                            }
                        }
                        break;
                    }
                    return obj;
                }
            case 4:
                jLongValue = lVar.n;
                str = lVar.i;
                cVar2 = lVar.f;
                dVar3 = lVar.e;
                bz3.g(objI2);
                hVar = (h) objI2;
                if (hVar instanceof e) {
                    eVar = (e) hVar;
                    if (!eVar.c) {
                    }
                    break;
                }
                str2 = str;
                hVar2 = hVar;
                if (hVar2 instanceof f) {
                    if (hVar2 instanceof e) {
                        f0 f0Var15 = this.b;
                        lVar.e = null;
                        lVar.f = null;
                        lVar.i = null;
                        lVar.j = null;
                        lVar.k = hVar2;
                        lVar.n = jLongValue;
                        lVar.u = 8;
                        f0Var15.getClass();
                        String string19 = LocalDate.now().toString();
                        string19.getClass();
                        objA2 = rq1.a(g0.a(f0Var15.a), new y(string19, null, 0), lVar);
                        if (objA2 != t70.a) {
                            objA2 = q43.a;
                        }
                        if (objA2 == obj) {
                        }
                    }
                    return hVar2;
                }
                f0 f0Var16 = this.b;
                lVar.e = null;
                lVar.f = null;
                lVar.i = str2;
                lVar.j = null;
                lVar.k = hVar2;
                lVar.n = jLongValue;
                lVar.u = 6;
                objI2 = f0Var16.i(lVar);
                if (objI2 != obj) {
                    if (((Number) objI2).longValue() == jLongValue) {
                        geVar2 = this.d;
                        str3 = ((f) hVar2).a;
                        geVar2.getClass();
                        str2.getClass();
                        synchronized (((LinkedHashMap) geVar2.d)) {
                            String string110 = cs2.V(str2).toString();
                            Locale locale8 = Locale.ROOT;
                            locale8.getClass();
                            lowerCase2 = string110.toLowerCase(locale8);
                            lowerCase2.getClass();
                            if (lowerCase2.length() <= 0) {
                                lowerCase2 = null;
                            }
                            if (lowerCase2 == null) {
                                ((LinkedHashMap) geVar2.d).remove(lowerCase2);
                                ((LinkedHashMap) geVar2.d).put(lowerCase2, new fe(((Number) ((fq0) geVar2.c).a()).longValue(), str3));
                                while (((LinkedHashMap) geVar2.d).size() > geVar2.b) {
                                    LinkedHashMap linkedHashMap6 = (LinkedHashMap) geVar2.d;
                                    Set setKeySet5 = linkedHashMap6.keySet();
                                    setKeySet5.getClass();
                                    linkedHashMap6.remove(mz.w(setKeySet5));
                                }
                            }
                        }
                    }
                    f0 f0Var17 = this.b;
                    lVar.e = null;
                    lVar.f = null;
                    lVar.i = null;
                    lVar.j = null;
                    lVar.k = hVar2;
                    lVar.n = jLongValue;
                    lVar.u = 7;
                    f0Var17.getClass();
                    String string111 = LocalDate.now().toString();
                    string111.getClass();
                    objA3 = rq1.a(g0.a(f0Var17.a), new y(string111, null, 0), lVar);
                    if (objA3 != t70.a) {
                        objA3 = q43.a;
                    }
                    if (objA3 == obj) {
                        return hVar2;
                    }
                }
                return obj;
            case 5:
                jLongValue = lVar.n;
                hVar2 = lVar.j;
                str2 = lVar.i;
                bz3.g(objI2);
                hVar = (h) objI2;
                if (hVar != null) {
                    hVar2 = hVar;
                }
                if (hVar2 instanceof f) {
                    if (hVar2 instanceof e) {
                        f0 f0Var18 = this.b;
                        lVar.e = null;
                        lVar.f = null;
                        lVar.i = null;
                        lVar.j = null;
                        lVar.k = hVar2;
                        lVar.n = jLongValue;
                        lVar.u = 8;
                        f0Var18.getClass();
                        String string112 = LocalDate.now().toString();
                        string112.getClass();
                        objA2 = rq1.a(g0.a(f0Var18.a), new y(string112, null, 0), lVar);
                        if (objA2 != t70.a) {
                            objA2 = q43.a;
                        }
                        if (objA2 == obj) {
                        }
                    }
                    return hVar2;
                }
                f0 f0Var19 = this.b;
                lVar.e = null;
                lVar.f = null;
                lVar.i = str2;
                lVar.j = null;
                lVar.k = hVar2;
                lVar.n = jLongValue;
                lVar.u = 6;
                objI2 = f0Var19.i(lVar);
                if (objI2 != obj) {
                    if (((Number) objI2).longValue() == jLongValue) {
                        geVar2 = this.d;
                        str3 = ((f) hVar2).a;
                        geVar2.getClass();
                        str2.getClass();
                        synchronized (((LinkedHashMap) geVar2.d)) {
                            String string113 = cs2.V(str2).toString();
                            Locale locale9 = Locale.ROOT;
                            locale9.getClass();
                            lowerCase2 = string113.toLowerCase(locale9);
                            lowerCase2.getClass();
                            if (lowerCase2.length() <= 0) {
                                lowerCase2 = null;
                            }
                            if (lowerCase2 == null) {
                                ((LinkedHashMap) geVar2.d).remove(lowerCase2);
                                ((LinkedHashMap) geVar2.d).put(lowerCase2, new fe(((Number) ((fq0) geVar2.c).a()).longValue(), str3));
                                while (((LinkedHashMap) geVar2.d).size() > geVar2.b) {
                                    LinkedHashMap linkedHashMap7 = (LinkedHashMap) geVar2.d;
                                    Set setKeySet6 = linkedHashMap7.keySet();
                                    setKeySet6.getClass();
                                    linkedHashMap7.remove(mz.w(setKeySet6));
                                }
                            }
                        }
                    }
                    f0 f0Var110 = this.b;
                    lVar.e = null;
                    lVar.f = null;
                    lVar.i = null;
                    lVar.j = null;
                    lVar.k = hVar2;
                    lVar.n = jLongValue;
                    lVar.u = 7;
                    f0Var110.getClass();
                    String string114 = LocalDate.now().toString();
                    string114.getClass();
                    objA3 = rq1.a(g0.a(f0Var110.a), new y(string114, null, 0), lVar);
                    if (objA3 != t70.a) {
                        objA3 = q43.a;
                    }
                    if (objA3 == obj) {
                        return hVar2;
                    }
                }
                return obj;
            case 6:
                jLongValue = lVar.n;
                hVar2 = lVar.k;
                str2 = lVar.i;
                bz3.g(objI2);
                if (((Number) objI2).longValue() == jLongValue) {
                    geVar2 = this.d;
                    str3 = ((f) hVar2).a;
                    geVar2.getClass();
                    str2.getClass();
                    synchronized (((LinkedHashMap) geVar2.d)) {
                        String string115 = cs2.V(str2).toString();
                        Locale locale10 = Locale.ROOT;
                        locale10.getClass();
                        lowerCase2 = string115.toLowerCase(locale10);
                        lowerCase2.getClass();
                        if (lowerCase2.length() <= 0) {
                            lowerCase2 = null;
                        }
                        if (lowerCase2 == null) {
                            ((LinkedHashMap) geVar2.d).remove(lowerCase2);
                            ((LinkedHashMap) geVar2.d).put(lowerCase2, new fe(((Number) ((fq0) geVar2.c).a()).longValue(), str3));
                            while (((LinkedHashMap) geVar2.d).size() > geVar2.b) {
                                LinkedHashMap linkedHashMap8 = (LinkedHashMap) geVar2.d;
                                Set setKeySet7 = linkedHashMap8.keySet();
                                setKeySet7.getClass();
                                linkedHashMap8.remove(mz.w(setKeySet7));
                            }
                        }
                    }
                }
                f0 f0Var111 = this.b;
                lVar.e = null;
                lVar.f = null;
                lVar.i = null;
                lVar.j = null;
                lVar.k = hVar2;
                lVar.n = jLongValue;
                lVar.u = 7;
                f0Var111.getClass();
                String string116 = LocalDate.now().toString();
                string116.getClass();
                objA3 = rq1.a(g0.a(f0Var111.a), new y(string116, null, 0), lVar);
                if (objA3 != t70.a) {
                    objA3 = q43.a;
                }
                if (objA3 == obj) {
                    return obj;
                }
                return hVar2;
            case 7:
                h hVar3 = lVar.k;
                bz3.g(objI2);
                return hVar3;
            case 8:
                h hVar4 = lVar.k;
                bz3.g(objI2);
                return hVar4;
            default:
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(c cVar, d dVar, y50 y50Var) {
        m mVar;
        if (y50Var instanceof m) {
            mVar = (m) y50Var;
            int i = mVar.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                mVar.k = i - Integer.MIN_VALUE;
            } else {
                mVar = new m(this, y50Var);
            }
        } else {
            mVar = new m(this, y50Var);
        }
        Object objE = mVar.i;
        int i2 = mVar.k;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(objE);
            mVar.e = cVar;
            mVar.f = dVar;
            mVar.k = 1;
            objE = cVar.e(mVar);
            if (objE != t70Var) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                bz3.g(objE);
                return objE;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        dVar = mVar.f;
        cVar = mVar.e;
        bz3.g(objE);
        d32 d32Var = (d32) objE;
        if (g31.a(d32Var, a32.a)) {
            mVar.e = null;
            mVar.f = null;
            mVar.k = 2;
            Object objC = cVar.c(dVar, mVar);
            return objC == t70Var ? t70Var : objC;
        }
        if (d32Var instanceof c32) {
            c32 c32Var = (c32) d32Var;
            h52 h52Var = c32Var.b;
            String str = c32Var.a;
            return new g(h52Var != null ? ky0.k(str, ". ", h52Var.a(), "?") : str.concat(", so I can't answer that."), h52Var);
        }
        if (d32Var instanceof z22) {
            return new g("I need another permission before I can do that.", null);
        }
        if (!(d32Var instanceof b32)) {
            dk0.l();
            return null;
        }
        String lowerCase = ((b32) d32Var).a.name().toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        return new g("That provider needs a " + lowerCase + " plan.", null);
    }

    public final void e() {
        ge geVar = this.d;
        synchronized (((LinkedHashMap) geVar.d)) {
            ((LinkedHashMap) geVar.d).clear();
        }
    }
}
