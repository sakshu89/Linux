package defpackage;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class at0 extends nu2 implements hq0 {
    public final /* synthetic */ mt0 H;
    public final /* synthetic */ hd1 X;
    public final /* synthetic */ gd1 Y;
    public final /* synthetic */ JSONObject Z;
    public final /* synthetic */ String c0;
    public final /* synthetic */ hq0 d0;
    public final /* synthetic */ x00 e0;
    public an1 f;
    public final /* synthetic */ boolean f0;
    public mt0 i;
    public Object j;
    public Object k;
    public Object n;
    public String s;
    public hq0 t;
    public x00 u;
    public boolean v;
    public int w;
    public int x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at0(mt0 mt0Var, hd1 hd1Var, gd1 gd1Var, JSONObject jSONObject, String str, hq0 hq0Var, x00 x00Var, boolean z, x50 x50Var) {
        super(1, x50Var);
        this.H = mt0Var;
        this.X = hd1Var;
        this.Y = gd1Var;
        this.Z = jSONObject;
        this.c0 = str;
        this.d0 = hq0Var;
        this.e0 = x00Var;
        this.f0 = z;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        x00 x00Var = this.e0;
        boolean z = this.f0;
        return new at0(this.H, this.X, this.Y, this.Z, this.c0, this.d0, x00Var, z, (x50) obj).s(q43.a);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x014f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [an1] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [an1] */
    @Override // defpackage.pk
    public final Object s(Object obj) throws Throwable {
        mt0 mt0Var;
        gd1 gd1Var;
        JSONObject jSONObject;
        Object r14;
        hd1 hd1Var;
        x00 x00Var;
        String str;
        hq0 hq0Var;
        an1 an1Var;
        int i;
        Object r5;
        gd1 gd1Var2;
        boolean z;
        JSONObject jSONObjectPut;
        JSONObject jSONObject2;
        boolean z2;
        mt0 mt0Var2;
        Object objI;
        mt0 mt0Var3;
        JSONObject jSONObject3;
        x00 x00Var2;
        boolean z3;
        Object obj2;
        Object r6;
        String strOptString;
        q43 q43Var = q43.a;
        t70 t70Var = t70.a;
        int i2 = this.x;
        try {
            try {
                if (i2 == 0) {
                    bz3.g(obj);
                    mt0Var = this.H;
                    an1 an1Var2 = mt0Var.p;
                    hd1 hd1Var2 = this.X;
                    gd1Var = this.Y;
                    jSONObject = this.Z;
                    String str2 = this.c0;
                    hq0 hq0Var2 = this.d0;
                    x00 x00Var3 = this.e0;
                    boolean z4 = this.f0;
                    this.f = an1Var2;
                    this.i = mt0Var;
                    this.j = hd1Var2;
                    this.k = gd1Var;
                    this.n = jSONObject;
                    this.s = str2;
                    this.t = hq0Var2;
                    this.u = x00Var3;
                    this.v = z4;
                    this.w = 0;
                    this.x = 1;
                    if (an1Var2.e(this) != t70Var) {
                        r14 = z4;
                        hd1Var = hd1Var2;
                        x00Var = x00Var3;
                        str = str2;
                        hq0Var = hq0Var2;
                        an1Var = an1Var2;
                        i = 0;
                    }
                    return t70Var;
                }
                if (i2 == 1) {
                    i = this.w;
                    boolean z5 = this.v;
                    x00 x00Var4 = this.u;
                    hq0 hq0Var3 = this.t;
                    String str3 = this.s;
                    jSONObject = (JSONObject) this.n;
                    gd1 gd1Var3 = (gd1) this.k;
                    hd1 hd1Var3 = (hd1) this.j;
                    mt0Var = this.i;
                    an1 an1Var3 = this.f;
                    bz3.g(obj);
                    r14 = z5;
                    gd1Var = gd1Var3;
                    hd1Var = hd1Var3;
                    x00Var = x00Var4;
                    str = str3;
                    hq0Var = hq0Var3;
                    an1Var = an1Var3;
                } else {
                    if (i2 != 2) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    z3 = this.v;
                    x00Var2 = (x00) this.n;
                    JSONObject jSONObject4 = (JSONObject) this.k;
                    gd1 gd1Var4 = (gd1) this.j;
                    mt0Var3 = this.i;
                    an1 an1Var4 = this.f;
                    try {
                        bz3.g(obj);
                        gd1Var2 = gd1Var4;
                        jSONObject3 = jSONObject4;
                        objI = obj;
                        r5 = an1Var4;
                    } catch (Throwable th) {
                        th = th;
                        obj2 = null;
                        r6 = an1Var4;
                        r6.h(obj2);
                        throw th;
                    }
                }
                try {
                    jSONObjectPut = (JSONObject) objI;
                    z2 = z3;
                    x00Var = x00Var2;
                    jSONObject2 = jSONObject3;
                    mt0Var2 = mt0Var3;
                    z = false;
                    r5 = r5;
                    py0 py0Var = mt0Var2.X;
                    String strOptString2 = jSONObject2.optString("id");
                    strOptString2.getClass();
                    jSONObjectPut.getClass();
                    py0Var.i(jSONObjectPut, strOptString2);
                    if (!x00Var.Z() && (!z2 || mt0.b(mt0Var2))) {
                        strOptString = jSONObject2.optString("id");
                        strOptString.getClass();
                        if (dt0.v(mt0Var2, strOptString, jSONObjectPut, new Long(gd1Var2.a))) {
                            z = true;
                        }
                    }
                    if (z2 && !z) {
                        x00Var.b0(q43Var);
                    }
                    r5.h(null);
                    return q43Var;
                } catch (Throwable th2) {
                    th = th2;
                    obj2 = null;
                    r6 = r5;
                    r6.h(obj2);
                    throw th;
                }
                if (mt0Var.J && !mt0Var.v && !mt0Var.w && hd1Var.b(gd1Var)) {
                    var r20 = r14;
                    long j = gd1Var.a;
                    this.f = an1Var;
                    this.i = mt0Var;
                    this.j = gd1Var;
                    this.k = jSONObject;
                    this.n = x00Var;
                    this.s = null;
                    this.t = null;
                    this.u = null;
                    this.v = r20;
                    this.w = i;
                    this.x = 2;
                    mt0 mt0Var4 = mt0Var;
                    JSONObject jSONObject5 = jSONObject;
                    gd1Var2 = gd1Var;
                    an1 an1Var5 = an1Var;
                    objI = mt0Var4.i(jSONObject5, str, j, hq0Var, null, false, this);
                    if (objI != t70Var) {
                        mt0Var3 = mt0Var4;
                        jSONObject3 = jSONObject5;
                        r5 = an1Var5;
                        x00Var2 = x00Var;
                        z3 = r20 == true ? 1 : 0;
                        jSONObjectPut = (JSONObject) objI;
                        z2 = z3;
                        x00Var = x00Var2;
                        jSONObject2 = jSONObject3;
                        mt0Var2 = mt0Var3;
                        z = false;
                        r5 = r5;
                    }
                    return t70Var;
                }
                mt0 mt0Var5 = mt0Var;
                gd1Var2 = gd1Var;
                JSONObject jSONObject6 = jSONObject;
                var r16 = r14;
                an1 an1Var6 = an1Var;
                z = false;
                jSONObjectPut = new JSONObject().put("status", "CANCELLED").put("retryable", false).put("spoken", "");
                jSONObject2 = jSONObject6;
                r5 = an1Var6;
                z2 = r16 == true ? 1 : 0;
                mt0Var2 = mt0Var5;
                py0 py0Var2 = mt0Var2.X;
                String strOptString3 = jSONObject2.optString("id");
                strOptString3.getClass();
                jSONObjectPut.getClass();
                py0Var2.i(jSONObjectPut, strOptString3);
                if (!x00Var.Z()) {
                    strOptString = jSONObject2.optString("id");
                    strOptString.getClass();
                    if (dt0.v(mt0Var2, strOptString, jSONObjectPut, new Long(gd1Var2.a))) {
                        z = true;
                    }
                }
                if (z2) {
                    x00Var.b0(q43Var);
                }
                r5.h(null);
                return q43Var;
            } catch (Throwable th3) {
                th = th3;
                r5 = r14;
                obj2 = null;
                r6 = r5;
                r6.h(obj2);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r14 = an1Var;
        }
    }
}
