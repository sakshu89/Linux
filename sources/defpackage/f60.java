package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f60 extends nu2 implements vq0 {
    public final /* synthetic */ int f = 1;
    public int i;
    public Object j;
    public Object k;
    public Object n;
    public Object s;
    public final /* synthetic */ Object t;
    public final /* synthetic */ Serializable u;
    public final /* synthetic */ Object v;
    public final /* synthetic */ Object w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f60(x00 x00Var, h60 h60Var, Locale locale, x00 x00Var2, hq0 hq0Var, l11 l11Var, x50 x50Var) {
        super(2, x50Var);
        this.n = x00Var;
        this.t = h60Var;
        this.u = locale;
        this.s = x00Var2;
        this.v = hq0Var;
        this.w = l11Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        s70 s70Var = (s70) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                break;
        }
        return ((f60) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.w;
        Object obj3 = this.v;
        Serializable serializable = this.u;
        Object obj4 = this.t;
        switch (i) {
            case 0:
                f60 f60Var = new f60((x00) this.n, (h60) obj4, (Locale) serializable, (x00) this.s, (hq0) obj3, (l11) obj2, x50Var);
                f60Var.k = obj;
                return f60Var;
            default:
                return new f60((qq2) obj4, (String) serializable, (String) obj3, (dq2) obj2, x50Var);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:104:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:113:0x0212  */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x015b A[Catch: all -> 0x0045, RuntimeException -> 0x0163, TRY_LEAVE, TryCatch #0 {all -> 0x0045, blocks: (B:9:0x003e, B:44:0x00eb, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:53:0x0103, B:55:0x0109, B:58:0x0116, B:60:0x011c, B:62:0x0122, B:64:0x012e, B:66:0x0136, B:69:0x013d, B:71:0x0145, B:73:0x0149, B:76:0x0155, B:77:0x015b, B:79:0x0163), top: B:117:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x01e5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [nq2] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0204 -> B:110:0x0207). Please report as a decompilation issue!!! */
    @Override // defpackage.pk
    public final Object s(Object obj) throws Throwable {
        h60 h60Var;
        x00 x00Var;
        t42 t42Var;
        Object obj2;
        t42 t42Var2;
        sp spVarC;
        e60 e60Var;
        Object objD;
        nq2 nq2Var;
        Object objC;
        AccessibilityNodeInfo accessibilityNodeInfo;
        ro1 ro1Var;
        List list;
        Object fq2Var;
        Object fq2Var2;
        int i = this.f;
        t70 t70Var = t70.a;
        Object obj3 = this.t;
        Object obj4 = this.w;
        Serializable serializable = this.u;
        ?? r8 = 2;
        Object obj5 = this.v;
        switch (i) {
            case 0:
                x00 x00Var2 = (x00) this.s;
                h60 h60Var2 = (h60) obj3;
                x00 x00Var3 = (x00) this.n;
                s70 s70Var = (s70) this.k;
                int i2 = this.i;
                if (i2 == 0) {
                    bz3.g(obj);
                    if (tl4.d(s70Var) && !x00Var3.Z()) {
                        t42Var2 = new t42();
                        spVarC = pn2.c(h60Var2.a, false, (Locale) serializable, 1);
                        h60Var = h60Var2;
                        e60Var = new e60((hq0) obj5, (l11) obj4, x00Var2, h60Var, x00Var3, t42Var2);
                        x00Var = x00Var3;
                        this.k = s70Var;
                        this.j = t42Var2;
                        this.i = 1;
                        if (spVarC.a(e60Var, this) == t70Var) {
                            return t70Var;
                        }
                        t42Var = t42Var2;
                        if (!x00Var2.Z()) {
                            obj2 = t42Var.a;
                            if (obj2 instanceof s83) {
                            }
                        }
                        if (!x00Var.Z()) {
                            x00Var.b0(null);
                        }
                    }
                    return q43.a;
                }
                if (i2 == 1) {
                    t42Var = (t42) this.j;
                    bz3.g(obj);
                    h60Var = h60Var2;
                    x00Var = x00Var3;
                    if (!x00Var2.Z()) {
                        obj2 = t42Var.a;
                        if ((obj2 instanceof s83) && !(obj2 instanceof y83)) {
                            this.k = s70Var;
                            this.j = null;
                            this.i = 2;
                            if (bm4.b(150L, this) == t70Var) {
                                return t70Var;
                            }
                        }
                        return q43.a;
                    }
                    if (!x00Var.Z()) {
                        x00Var.b0(null);
                    }
                    return q43.a;
                }
                if (i2 != 2) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(obj);
                h60Var = h60Var2;
                x00Var = x00Var3;
                x00Var3 = x00Var;
                h60Var2 = h60Var;
                if (tl4.d(s70Var)) {
                    t42Var2 = new t42();
                    spVarC = pn2.c(h60Var2.a, false, (Locale) serializable, 1);
                    h60Var = h60Var2;
                    e60Var = new e60((hq0) obj5, (l11) obj4, x00Var2, h60Var, x00Var3, t42Var2);
                    x00Var = x00Var3;
                    this.k = s70Var;
                    this.j = t42Var2;
                    this.i = 1;
                    if (spVarC.a(e60Var, this) == t70Var) {
                        return t70Var;
                    }
                    t42Var = t42Var2;
                    if (!x00Var2.Z()) {
                        obj2 = t42Var.a;
                        if (obj2 instanceof s83) {
                        }
                    }
                    if (!x00Var.Z()) {
                        x00Var.b0(null);
                    }
                }
                return q43.a;
            default:
                String str = (String) obj5;
                String str2 = (String) serializable;
                dq2 dq2Var = (dq2) obj4;
                qq2 qq2Var = (qq2) obj3;
                r2 r2Var = qq2Var.a;
                int i3 = this.i;
                try {
                    if (i3 == 0) {
                        bz3.g(obj);
                        this.i = 1;
                        objD = qq2.d(qq2Var, str2, str, this);
                        if (objD == t70Var) {
                            return t70Var;
                        }
                    } else {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                og.n("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ro1Var = (ro1) this.s;
                            accessibilityNodeInfo = (AccessibilityNodeInfo) this.n;
                            list = (List) this.k;
                            nq2Var = (nq2) this.j;
                            try {
                                bz3.g(obj);
                                objC = obj;
                                if (((g5) objC).i || r2Var.l() || !r2Var.k("com.spotify.music")) {
                                    fq2Var2 = new fq2("Spotify or the selected track changed before video activation");
                                } else {
                                    if (g31.a(ro1Var != null ? ro1Var.a : null, "com.spotify.music")) {
                                        Set set = cq2.a;
                                        if (!cq2.h(str2, str, ro1Var.c, ro1Var.d)) {
                                            fq2Var2 = new fq2("Spotify or the selected track changed before video activation");
                                        } else if (accessibilityNodeInfo.refresh() && qq2.e(accessibilityNodeInfo, nq2Var) && qq2.b(qq2Var, accessibilityNodeInfo).equals(dq2Var.b) && (dq2Var.c.equals("player") || list.isEmpty())) {
                                            fq2Var2 = accessibilityNodeInfo.performAction(16) ? eq2.a : new fq2("Spotify did not accept its native video control");
                                        } else {
                                            fq2Var2 = new fq2("Spotify's video control changed before activation");
                                        }
                                    } else {
                                        fq2Var2 = new fq2("Spotify or the selected track changed before video activation");
                                    }
                                }
                            } catch (RuntimeException unused) {
                                fq2Var2 = new fq2("Spotify's video control became unavailable");
                            }
                            nq2Var.close();
                            return fq2Var2;
                        }
                        bz3.g(obj);
                        objD = obj;
                    }
                    mq2 mq2Var = (mq2) objD;
                    if (mq2Var instanceof kq2) {
                        return new fq2(((kq2) mq2Var).a);
                    }
                    mq2Var.getClass();
                    nq2 nq2Var2 = ((lq2) mq2Var).a;
                    try {
                        if (nq2Var2.a.equals(dq2Var.a)) {
                            List listA = qq2.a(qq2Var, nq2Var2, "switch to video");
                            List listA2 = qq2.a(qq2Var, nq2Var2, "switch to audio");
                            if (listA.isEmpty() && listA2.size() == 1) {
                                fq2Var = gq2.a;
                            } else {
                                if (dq2Var.c.equals("player")) {
                                    listA = qq2.c(qq2Var, nq2Var2, str2);
                                }
                                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) mz.I(listA);
                                if (accessibilityNodeInfo2 != null) {
                                    ro1 ro1VarE = qq2Var.b.e("com.spotify.music");
                                    j5 j5Var = qq2Var.c;
                                    this.j = nq2Var2;
                                    this.k = listA2;
                                    this.n = accessibilityNodeInfo2;
                                    this.s = ro1VarE;
                                    this.i = 2;
                                    objC = rn4.c(j5Var.b, this);
                                    if (objC == t70Var) {
                                        return t70Var;
                                    }
                                    nq2Var = nq2Var2;
                                    accessibilityNodeInfo = accessibilityNodeInfo2;
                                    ro1Var = ro1VarE;
                                    list = listA2;
                                    if (((g5) objC).i) {
                                        fq2Var2 = new fq2("Spotify or the selected track changed before video activation");
                                    } else {
                                        fq2Var2 = new fq2("Spotify or the selected track changed before video activation");
                                    }
                                    nq2Var.close();
                                    return fq2Var2;
                                }
                                fq2Var = new fq2("Spotify's video control changed before activation");
                            }
                        } else {
                            fq2Var = new fq2("Spotify's window changed before video activation");
                        }
                        nq2Var2.close();
                        return fq2Var;
                    } catch (RuntimeException unused2) {
                        nq2Var = nq2Var2;
                        fq2Var2 = new fq2("Spotify's video control became unavailable");
                    } catch (Throwable th) {
                        th = th;
                        r8 = nq2Var2;
                        r8.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f60(qq2 qq2Var, String str, String str2, dq2 dq2Var, x50 x50Var) {
        super(2, x50Var);
        this.t = qq2Var;
        this.u = str;
        this.v = str2;
        this.w = dq2Var;
    }
}
