package defpackage;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z9 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public Object j;
    public Object k;
    public /* synthetic */ Object n;
    public final /* synthetic */ Object s;
    public final /* synthetic */ Object t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z9(ry1 ry1Var, wq0 wq0Var, hq0 hq0Var, zz1 zz1Var, x50 x50Var) {
        super(2, x50Var);
        this.f = 8;
        this.k = ry1Var;
        this.s = wq0Var;
        this.n = hq0Var;
        this.t = zz1Var;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0224  */
    /* JADX WARN: Code duplicated, block: B:104:0x025a  */
    /* JADX WARN: Code duplicated, block: B:113:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:117:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:119:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:134:0x0314  */
    /* JADX WARN: Code duplicated, block: B:136:0x031a  */
    /* JADX WARN: Code duplicated, block: B:138:0x032a  */
    /* JADX WARN: Code duplicated, block: B:141:0x034b  */
    /* JADX WARN: Code duplicated, block: B:146:0x036d  */
    /* JADX WARN: Code duplicated, block: B:147:0x0375  */
    /* JADX WARN: Code duplicated, block: B:148:0x037c  */
    /* JADX WARN: Code duplicated, block: B:150:0x0382  */
    /* JADX WARN: Code duplicated, block: B:153:0x038a  */
    /* JADX WARN: Code duplicated, block: B:157:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:159:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:162:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:164:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:172:0x03da  */
    /* JADX WARN: Code duplicated, block: B:173:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:176:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:179:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:181:0x0406  */
    /* JADX WARN: Code duplicated, block: B:210:0x052a  */
    /* JADX WARN: Code duplicated, block: B:212:0x0531  */
    /* JADX WARN: Code duplicated, block: B:228:0x0603 A[LOOP:0: B:226:0x05fd->B:228:0x0603, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:231:0x0728  */
    /* JADX WARN: Code duplicated, block: B:232:0x072d  */
    /* JADX WARN: Code duplicated, block: B:234:0x0737  */
    /* JADX WARN: Code duplicated, block: B:235:0x0740  */
    /* JADX WARN: Code duplicated, block: B:237:0x0746  */
    /* JADX WARN: Code duplicated, block: B:239:0x074e  */
    /* JADX WARN: Code duplicated, block: B:242:0x0753  */
    /* JADX WARN: Code duplicated, block: B:244:0x0756  */
    /* JADX WARN: Code duplicated, block: B:245:0x0760  */
    /* JADX WARN: Code duplicated, block: B:247:0x0763 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:257:0x0797  */
    /* JADX WARN: Code duplicated, block: B:259:0x079d  */
    /* JADX WARN: Code duplicated, block: B:260:0x07a4  */
    /* JADX WARN: Code duplicated, block: B:263:0x07b7 A[LOOP:1: B:261:0x07b1->B:263:0x07b7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:267:0x07db  */
    /* JADX WARN: Code duplicated, block: B:272:0x07fb  */
    /* JADX WARN: Code duplicated, block: B:273:0x0814  */
    /* JADX WARN: Code duplicated, block: B:275:0x081a  */
    /* JADX WARN: Code duplicated, block: B:276:0x0822  */
    /* JADX WARN: Code duplicated, block: B:279:0x0836  */
    /* JADX WARN: Code duplicated, block: B:288:0x0871  */
    /* JADX WARN: Code duplicated, block: B:289:0x088a  */
    /* JADX WARN: Code duplicated, block: B:291:0x0890  */
    /* JADX WARN: Code duplicated, block: B:292:0x0898  */
    /* JADX WARN: Code duplicated, block: B:294:0x089f  */
    /* JADX WARN: Code duplicated, block: B:300:0x08b3  */
    /* JADX WARN: Code duplicated, block: B:302:0x08c1  */
    /* JADX WARN: Code duplicated, block: B:304:0x08d0  */
    /* JADX WARN: Code duplicated, block: B:361:0x0a3b  */
    /* JADX WARN: Code duplicated, block: B:363:0x0a3f  */
    /* JADX WARN: Code duplicated, block: B:366:0x0a59  */
    /* JADX WARN: Code duplicated, block: B:368:0x0a5e  */
    /* JADX WARN: Code duplicated, block: B:371:0x0a9d  */
    /* JADX WARN: Code duplicated, block: B:374:0x0aa3  */
    /* JADX WARN: Code duplicated, block: B:390:0x0adc  */
    /* JADX WARN: Code duplicated, block: B:399:0x07f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:400:0x07f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:402:0x07d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:404:0x086a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:405:0x084d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:409:0x082f A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:417:0x017f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:418:0x017f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:419:0x0178 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:429:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:430:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0136  */
    /* JADX WARN: Code duplicated, block: B:61:0x0146  */
    /* JADX WARN: Code duplicated, block: B:64:0x0150  */
    /* JADX WARN: Code duplicated, block: B:66:0x015c  */
    /* JADX WARN: Code duplicated, block: B:69:0x0175 A[LOOP:6: B:62:0x014a->B:69:0x0175, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x0189  */
    /* JADX WARN: Code duplicated, block: B:76:0x0196  */
    /* JADX WARN: Code duplicated, block: B:78:0x019a  */
    /* JADX WARN: Code duplicated, block: B:94:0x0201  */
    /* JADX WARN: Code duplicated, block: B:96:0x0205  */
    /* JADX WARN: Code duplicated, block: B:98:0x0214  */
    /* JADX WARN: Code duplicated, block: B:99:0x0219  */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x034f, code lost:
    
        if (r12.a(r0, r3) != false) goto L123;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:66:0x015c, please report this as an issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object v(java.lang.Object r94) {
        /*
            Method dump skipped, instruction units count: 2850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z9.v(java.lang.Object):java.lang.Object");
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) throws Throwable {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                ((z9) q((x50) obj2, (s70) obj)).s(q43Var);
                return t70.a;
            case 1:
                return ((z9) q((x50) obj2, (s70) obj)).s(q43Var);
            case 2:
                return ((z9) q((x50) obj2, (s70) obj)).s(q43Var);
            case 3:
                return ((z9) q((x50) obj2, obj)).s(q43Var);
            case 4:
                return ((z9) q((x50) obj2, (i12) obj)).s(q43Var);
            case 5:
                return ((z9) q((x50) obj2, (s70) obj)).s(q43Var);
            case 6:
                return ((z9) q((x50) obj2, (nm0) obj)).s(q43Var);
            case 7:
                return ((z9) q((x50) obj2, (s70) obj)).s(q43Var);
            default:
                return ((z9) q((x50) obj2, (s70) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.t;
        Object obj3 = this.s;
        switch (i) {
            case 0:
                z9 z9Var = new z9((ua) this.k, (hq0) this.n, (ba) obj3, (pa1) obj2, x50Var, 0);
                z9Var.j = obj;
                return z9Var;
            case 1:
                return new z9((ua1) this.j, (mm1) this.k, (xy2) this.n, (ny2) obj3, (kz0) obj2, x50Var, 1);
            case 2:
                return new z9((wm) this.j, (ty2) this.k, (ua1) this.n, (hz2) obj3, (mp1) obj2, x50Var, 2);
            case 3:
                z9 z9Var2 = new z9((List) obj3, (ArrayList) obj2, x50Var);
                z9Var2.n = obj;
                return z9Var2;
            case 4:
                z9 z9Var3 = new z9((qb1) this.k, (eb1) this.n, (j70) obj3, (g32) obj2, x50Var, 4);
                z9Var3.j = obj;
                return z9Var3;
            case 5:
                z9 z9Var4 = new z9((f42) this.n, (e42) obj3, (sc) obj2, x50Var);
                z9Var4.j = obj;
                return z9Var4;
            case 6:
                z9 z9Var5 = new z9((String) this.k, (in2) this.n, (c63) obj3, (List) obj2, x50Var, 6);
                z9Var5.j = obj;
                return z9Var5;
            case 7:
                return new z9((qq2) this.j, (String) this.k, (String) this.n, (o42) obj3, (o42) obj2, x50Var, 7);
            default:
                z9 z9Var6 = new z9((ry1) this.k, (wq0) obj3, (hq0) this.n, (zz1) obj2, x50Var);
                z9Var6.j = obj;
                return z9Var6;
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0271 A[Catch: all -> 0x027d, LOOP:1: B:119:0x026f->B:120:0x0271, LOOP_END, TryCatch #9 {all -> 0x027d, blocks: (B:114:0x025e, B:115:0x0264, B:117:0x0269, B:118:0x026a, B:120:0x0271, B:123:0x0281, B:141:0x02c8, B:142:0x02c9, B:116:0x0265), top: B:268:0x025e, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x029c  */
    /* JADX WARN: Code duplicated, block: B:126:0x029e  */
    /* JADX WARN: Code duplicated, block: B:131:0x02ad A[Catch: all -> 0x02b0, TryCatch #1 {all -> 0x02b0, blocks: (B:129:0x02a9, B:131:0x02ad, B:134:0x02b3), top: B:257:0x02a9 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x02d8 A[Catch: all -> 0x02db, TryCatch #8 {all -> 0x02db, blocks: (B:145:0x02d4, B:147:0x02d8, B:150:0x02de), top: B:266:0x02d4 }] */
    /* JADX WARN: Code duplicated, block: B:257:0x02a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:262:0x0265 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:266:0x02d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00ee A[Catch: all -> 0x00c2, RuntimeException -> 0x0170, TRY_ENTER, TryCatch #7 {RuntimeException -> 0x0170, blocks: (B:27:0x009c, B:29:0x00ae, B:31:0x00b4, B:33:0x00ba, B:38:0x00c6, B:40:0x00cc, B:42:0x00d2, B:44:0x00d8, B:46:0x00ee, B:48:0x00f2, B:50:0x00f8, B:52:0x010e, B:54:0x0116, B:56:0x011a, B:58:0x0120, B:60:0x0126, B:62:0x0130, B:63:0x013d, B:65:0x0145, B:67:0x0152, B:68:0x0158, B:71:0x0162), top: B:260:0x009c, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x010e A[Catch: all -> 0x00c2, RuntimeException -> 0x0170, TryCatch #7 {RuntimeException -> 0x0170, blocks: (B:27:0x009c, B:29:0x00ae, B:31:0x00b4, B:33:0x00ba, B:38:0x00c6, B:40:0x00cc, B:42:0x00d2, B:44:0x00d8, B:46:0x00ee, B:48:0x00f2, B:50:0x00f8, B:52:0x010e, B:54:0x0116, B:56:0x011a, B:58:0x0120, B:60:0x0126, B:62:0x0130, B:63:0x013d, B:65:0x0145, B:67:0x0152, B:68:0x0158, B:71:0x0162), top: B:260:0x009c, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0116 A[Catch: all -> 0x00c2, RuntimeException -> 0x0170, TryCatch #7 {RuntimeException -> 0x0170, blocks: (B:27:0x009c, B:29:0x00ae, B:31:0x00b4, B:33:0x00ba, B:38:0x00c6, B:40:0x00cc, B:42:0x00d2, B:44:0x00d8, B:46:0x00ee, B:48:0x00f2, B:50:0x00f8, B:52:0x010e, B:54:0x0116, B:56:0x011a, B:58:0x0120, B:60:0x0126, B:62:0x0130, B:63:0x013d, B:65:0x0145, B:67:0x0152, B:68:0x0158, B:71:0x0162), top: B:260:0x009c, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0158 A[Catch: all -> 0x00c2, RuntimeException -> 0x0170, TRY_LEAVE, TryCatch #7 {RuntimeException -> 0x0170, blocks: (B:27:0x009c, B:29:0x00ae, B:31:0x00b4, B:33:0x00ba, B:38:0x00c6, B:40:0x00cc, B:42:0x00d2, B:44:0x00d8, B:46:0x00ee, B:48:0x00f2, B:50:0x00f8, B:52:0x010e, B:54:0x0116, B:56:0x011a, B:58:0x0120, B:60:0x0126, B:62:0x0130, B:63:0x013d, B:65:0x0145, B:67:0x0152, B:68:0x0158, B:71:0x0162), top: B:260:0x009c, outer: #3 }] */
    @Override // defpackage.pk
    public final Object s(Object obj) throws Throwable {
        List list;
        Iterator it;
        f41 f41VarC;
        jr2 jr2Var;
        pw1 pw1Var;
        pw1 pw1Var2;
        zq zqVar;
        f42 f42Var;
        List listD;
        int size;
        int i;
        r0 r0Var;
        f42 f42Var2;
        f42 f42Var3;
        iq2 iq2Var;
        iq2 iq2Var2;
        int i2 = 2;
        int i3 = 1;
        x50 x50Var = null;
        switch (this.f) {
            case 0:
                ba baVar = (ba) this.s;
                ua uaVar = (ua) this.k;
                t70 t70Var = t70.a;
                int i4 = this.i;
                try {
                    if (i4 != 0) {
                        if (i4 != 1) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        bz3.g(obj);
                        throw new b10();
                    }
                    bz3.g(obj);
                    s70 s70Var = (s70) this.j;
                    ra1 ra1Var = sa1.a;
                    View view = uaVar.a;
                    ra1Var.getClass();
                    l11 l11Var = new l11(view);
                    wa1 wa1Var = new wa1(uaVar.a, new y9((pa1) this.t), l11Var);
                    if (ns2.a) {
                        uf4.b(s70Var, null, new p0(baVar, l11Var, x50Var, i2), 3);
                    }
                    hq0 hq0Var = (hq0) this.n;
                    if (hq0Var != null) {
                        hq0Var.j(wa1Var);
                    }
                    baVar.c = wa1Var;
                    this.i = 1;
                    uaVar.a(wa1Var, this);
                    return t70Var;
                } catch (Throwable th) {
                    baVar.c = null;
                    throw th;
                }
            case 1:
                ua1 ua1Var = (ua1) this.j;
                t70 t70Var2 = t70.a;
                int i5 = this.i;
                try {
                    if (i5 == 0) {
                        bz3.g(obj);
                        l90 l90Var = new l90(i3, new bt0(new hc((mm1) this.k, i2), null));
                        ix ixVar = new ix(ua1Var, (xy2) this.n, (ny2) this.s, (kz0) this.t, 1);
                        this.i = 1;
                        if (l90Var.a(ixVar, this) == t70Var2) {
                            return t70Var2;
                        }
                    } else {
                        if (i5 != 1) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        bz3.g(obj);
                    }
                    hl4.e(ua1Var);
                    return q43.a;
                } catch (Throwable th2) {
                    hl4.e(ua1Var);
                    throw th2;
                }
            case 2:
                q43 q43Var = q43.a;
                t70 t70Var3 = t70.a;
                int i6 = this.i;
                if (i6 == 0) {
                    bz3.g(obj);
                    wm wmVar = (wm) this.j;
                    ty2 ty2Var = (ty2) this.k;
                    ux2 ux2Var = ((ua1) this.n).a;
                    gz2 gz2Var = ((hz2) this.s).a;
                    mp1 mp1Var = (mp1) this.t;
                    this.i = 1;
                    int iL = mp1Var.l(oz2.e(ty2Var.b));
                    Object objA = wmVar.a(iL < gz2Var.a.a.b.length() ? gz2Var.b(iL) : iL != 0 ? gz2Var.b(iL - 1) : new l42(0.0f, 0.0f, 1.0f, (int) (xx2.a(ux2Var.b, ux2Var.g, ux2Var.h, xx2.a, 1) & 4294967295L)), this);
                    if (objA != t70Var3) {
                        objA = q43Var;
                    }
                    if (objA == t70Var3) {
                        return t70Var3;
                    }
                } else {
                    if (i6 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43Var;
            case 3:
                int i7 = this.i;
                if (i7 == 0) {
                    bz3.g(obj);
                    obj = this.n;
                    List list2 = (List) this.s;
                    list = (ArrayList) this.t;
                    it = list2.iterator();
                } else if (i7 == 1) {
                    Object obj2 = this.j;
                    Iterator it2 = (Iterator) this.k;
                    List list3 = (List) this.n;
                    bz3.g(obj);
                    if (((Boolean) obj).booleanValue()) {
                        list3.add(new a90(1, null));
                        this.n = list3;
                        this.k = it2;
                        this.j = null;
                        this.i = 2;
                        throw null;
                    }
                    obj = obj2;
                    it = it2;
                    list = list3;
                } else {
                    if (i7 != 2) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    it = (Iterator) this.k;
                    list = (List) this.n;
                    bz3.g(obj);
                }
                if (!it.hasNext()) {
                    return obj;
                }
                if (it.next() != null) {
                    dk0.t();
                    return null;
                }
                this.n = list;
                this.k = it;
                this.j = obj;
                this.i = 1;
                throw null;
            case 4:
                t70 t70Var4 = t70.a;
                int i8 = this.i;
                if (i8 == 0) {
                    bz3.g(obj);
                    i12 i12Var = (i12) this.j;
                    qb1 qb1Var = (qb1) this.k;
                    eb1 eb1Var = (eb1) this.n;
                    r0 r0Var2 = new r0((j70) this.s, (g32) this.t, i12Var, null, 8);
                    this.i = 1;
                    if (az3.d(qb1Var, eb1Var, r0Var2, this) == t70Var4) {
                        return t70Var4;
                    }
                } else {
                    if (i8 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43.a;
            case 5:
                t70 t70Var5 = t70.a;
                int i9 = this.i;
                if (i9 != 0) {
                    if (i9 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    zqVar = (zq) this.k;
                    f41VarC = (f41) this.j;
                    try {
                        bz3.g(obj);
                        zqVar.a();
                        f42Var3 = (f42) this.n;
                        synchronized (f42Var3.c) {
                            try {
                                if (f42Var3.d == f41VarC) {
                                    f42Var3.d = null;
                                }
                                f42Var3.y();
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                        jr2 jr2Var2 = f42.z;
                        y74.s(((f42) this.n).y);
                        return q43.a;
                    } catch (Throwable th4) {
                        th = th4;
                        Throwable th5 = th;
                        zqVar.a();
                        f42Var2 = (f42) this.n;
                        synchronized (f42Var2.c) {
                            try {
                                if (f42Var2.d == f41VarC) {
                                    f42Var2.d = null;
                                }
                                f42Var2.y();
                                jr2 jr2Var3 = f42.z;
                                y74.s(((f42) this.n).y);
                                throw th5;
                            } catch (Throwable th6) {
                                throw th6;
                            }
                        }
                    }
                }
                bz3.g(obj);
                f41VarC = hp4.c(((s70) this.j).o());
                f42 f42Var4 = (f42) this.n;
                synchronized (f42Var4.c) {
                    Throwable th7 = f42Var4.e;
                    if (th7 != null) {
                        throw th7;
                    }
                    if (((c42) f42Var4.u.getValue()).compareTo(c42.b) <= 0) {
                        throw new IllegalStateException("Recomposer shut down");
                    }
                    if (f42Var4.d != null) {
                        throw new IllegalStateException("Recomposer already running");
                    }
                    f42Var4.d = f41VarC;
                    f42Var4.y();
                }
                int i10 = 8;
                ha haVar = new ha(i10, (f42) this.n);
                im2.e(im2.a);
                synchronized (im2.c) {
                    im2.h = mz.F(im2.h, haVar);
                }
                zq zqVar2 = new zq(i10, haVar);
                jr2 jr2Var4 = f42.z;
                fl4 fl4Var = ((f42) this.n).y;
                try {
                    do {
                        jr2Var = f42.z;
                        pw1Var = (pw1) jr2Var.getValue();
                        xy xyVar = xy.H;
                        hw1 hw1Var = pw1Var.c;
                        if (hw1Var.containsKey(fl4Var)) {
                            pw1Var2 = pw1Var;
                        } else if (pw1Var.isEmpty()) {
                            pw1Var2 = new pw1(fl4Var, fl4Var, hw1Var.a(fl4Var, new oc1(xyVar, xyVar)));
                        } else {
                            Object obj3 = pw1Var.b;
                            Object obj4 = hw1Var.get(obj3);
                            obj4.getClass();
                            pw1Var2 = new pw1(pw1Var.a, fl4Var, hw1Var.a(obj3, new oc1(((oc1) obj4).a, fl4Var)).a(fl4Var, new oc1(obj3, xyVar)));
                        }
                        if (pw1Var != pw1Var2) {
                        }
                        f42Var = (f42) this.n;
                        synchronized (f42Var.c) {
                            listD = f42Var.D();
                        }
                        size = listD.size();
                        for (i = 0; i < size; i++) {
                            ((g30) listD.get(i)).t();
                        }
                        r0Var = new r0((e42) this.s, (sc) this.t, x50Var, 13);
                        this.j = f41VarC;
                        this.k = zqVar2;
                        this.i = 1;
                        if (tl4.c(r0Var, this) == t70Var5) {
                            return t70Var5;
                        }
                        zqVar = zqVar2;
                        zqVar.a();
                        f42Var3 = (f42) this.n;
                        synchronized (f42Var3.c) {
                            if (f42Var3.d == f41VarC) {
                                f42Var3.d = null;
                            }
                            f42Var3.y();
                            jr2 jr2Var5 = f42.z;
                            y74.s(((f42) this.n).y);
                            return q43.a;
                        }
                    } while (!jr2Var.h(pw1Var, pw1Var2));
                    f42Var = (f42) this.n;
                    synchronized (f42Var.c) {
                        listD = f42Var.D();
                        size = listD.size();
                        while (i < size) {
                            ((g30) listD.get(i)).t();
                        }
                        r0Var = new r0((e42) this.s, (sc) this.t, x50Var, 13);
                        this.j = f41VarC;
                        this.k = zqVar2;
                        this.i = 1;
                        if (tl4.c(r0Var, this) == t70Var5) {
                            return t70Var5;
                        }
                        zqVar = zqVar2;
                        zqVar.a();
                        f42Var3 = (f42) this.n;
                        synchronized (f42Var3.c) {
                            if (f42Var3.d == f41VarC) {
                                f42Var3.d = null;
                            }
                            f42Var3.y();
                            jr2 jr2Var6 = f42.z;
                            y74.s(((f42) this.n).y);
                            return q43.a;
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    zqVar = zqVar2;
                    Throwable th9 = th;
                    zqVar.a();
                    f42Var2 = (f42) this.n;
                    synchronized (f42Var2.c) {
                        if (f42Var2.d == f41VarC) {
                            f42Var2.d = null;
                        }
                        f42Var2.y();
                    }
                    jr2 jr2Var7 = f42.z;
                    y74.s(((f42) this.n).y);
                    throw th9;
                }
            case 6:
                return v(obj);
            case 7:
                o42 o42Var = (o42) this.s;
                String str = (String) this.k;
                qq2 qq2Var = (qq2) this.j;
                t70 t70Var6 = t70.a;
                int i11 = this.i;
                if (i11 == 0) {
                    bz3.g(obj);
                    String str2 = (String) this.n;
                    this.i = 1;
                    obj = qq2.d(qq2Var, str, str2, this);
                    if (obj == t70Var6) {
                        return t70Var6;
                    }
                } else {
                    if (i11 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                mq2 mq2Var = (mq2) obj;
                if (mq2Var instanceof kq2) {
                    iq2Var = new iq2(new rq2(((kq2) mq2Var).a), null, 2);
                } else {
                    mq2Var.getClass();
                    nq2 nq2Var = ((lq2) mq2Var).a;
                    try {
                        try {
                            List listA = qq2.a(qq2Var, nq2Var, "switch to video");
                            jq2 jq2Var = nq2Var.a;
                            List listA2 = qq2.a(qq2Var, nq2Var, "switch to audio");
                            if (listA.size() > 1 || listA2.size() > 1 || !(listA.isEmpty() || listA2.isEmpty())) {
                                iq2Var = new iq2(new rq2("Spotify exposed more than one video-mode control"), null, 2);
                            } else {
                                if (listA2.size() != 1 || !listA.isEmpty()) {
                                    if (o42Var.a && listA.size() == 1) {
                                        iq2Var2 = new iq2(null, new dq2(jq2Var, qq2.b(qq2Var, (AccessibilityNodeInfo) mz.H(listA)), "switch to video"), 1);
                                    } else if (((o42) this.t).a && !o42Var.a && listA.isEmpty() && listA2.isEmpty()) {
                                        ArrayList arrayListC = qq2.c(qq2Var, nq2Var, str);
                                        if (arrayListC.size() > 1) {
                                            iq2Var = new iq2(new rq2("Spotify exposed more than one current-player bar"), null, 2);
                                        } else {
                                            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) mz.I(arrayListC);
                                            iq2Var2 = new iq2(null, accessibilityNodeInfo != null ? new dq2(jq2Var, qq2.b(qq2Var, accessibilityNodeInfo), "player") : null, 1);
                                        }
                                    } else {
                                        iq2Var2 = new iq2(null, null, 3);
                                    }
                                    return iq2Var2;
                                }
                                ro1 ro1Var = nq2Var.e;
                                if (!ro1Var.f) {
                                    if (o42Var.a) {
                                        if (((o42) this.t).a) {
                                            iq2Var2 = new iq2(null, null, 3);
                                        } else {
                                            iq2Var2 = new iq2(null, null, 3);
                                        }
                                    } else if (((o42) this.t).a) {
                                        iq2Var2 = new iq2(null, null, 3);
                                    } else {
                                        iq2Var2 = new iq2(null, null, 3);
                                    }
                                    return iq2Var2;
                                }
                                iq2Var = new iq2(new sq2(ro1Var.a().concat("; native Switch to audio control visible")), null, 2);
                            }
                        } finally {
                            nq2Var.close();
                        }
                    } catch (RuntimeException unused) {
                        iq2Var = new iq2(new rq2("Spotify's video controls became unavailable"), null, 2);
                    }
                }
                return iq2Var;
            default:
                t70 t70Var7 = t70.a;
                int i12 = this.i;
                if (i12 == 0) {
                    bz3.g(obj);
                    s70 s70Var2 = (s70) this.j;
                    ry1 ry1Var = (ry1) this.k;
                    sv2 sv2Var = new sv2(s70Var2, (wq0) this.s, (hq0) this.n, (zz1) this.t, null);
                    this.i = 1;
                    if (ao4.b(ry1Var, sv2Var, this) == t70Var7) {
                        return t70Var7;
                    }
                } else {
                    if (i12 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z9(f42 f42Var, e42 e42Var, sc scVar, x50 x50Var) {
        super(2, x50Var);
        this.f = 5;
        this.n = f42Var;
        this.s = e42Var;
        this.t = scVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z9(Object obj, Object obj2, Object obj3, Object obj4, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.k = obj;
        this.n = obj2;
        this.s = obj3;
        this.t = obj4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z9(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = obj;
        this.k = obj2;
        this.n = obj3;
        this.s = obj4;
        this.t = obj5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z9(List list, ArrayList arrayList, x50 x50Var) {
        super(2, x50Var);
        this.f = 3;
        this.s = list;
        this.t = arrayList;
    }
}
