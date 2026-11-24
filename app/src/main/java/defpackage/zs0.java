package defpackage;

import java.util.LinkedHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zs0 extends nu2 implements hq0 {
    public final /* synthetic */ x00 H;
    public final /* synthetic */ hd1 X;
    public final /* synthetic */ JSONObject Y;
    public final /* synthetic */ hq0 Z;
    public final /* synthetic */ f5 c0;
    public an1 f;
    public mt0 i;
    public Object j;
    public gd1 k;
    public JSONObject n;
    public hq0 s;
    public f5 t;
    public int u;
    public int v;
    public final /* synthetic */ mt0 w;
    public final /* synthetic */ gd1 x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zs0(mt0 mt0Var, gd1 gd1Var, x00 x00Var, hd1 hd1Var, JSONObject jSONObject, hq0 hq0Var, f5 f5Var, x50 x50Var) {
        super(1, x50Var);
        this.w = mt0Var;
        this.x = gd1Var;
        this.H = x00Var;
        this.X = hd1Var;
        this.Y = jSONObject;
        this.Z = hq0Var;
        this.c0 = f5Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        hq0 hq0Var = this.Z;
        f5 f5Var = this.c0;
        return new zs0(this.w, this.x, this.H, this.X, this.Y, hq0Var, f5Var, (x50) obj).s(q43.a);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x014f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0155  */
    /* JADX WARN: Code duplicated, block: B:67:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // defpackage.pk
    public final Object s(Object obj) throws Throwable {
        hd1 hd1Var;
        gd1 gd1Var;
        mt0 mt0Var;
        JSONObject jSONObject;
        hq0 hq0Var;
        f5 f5Var;
        an1 an1Var;
        int i;
        an1 an1Var2;
        JSONObject jSONObjectPut;
        mt0 mt0Var2;
        Object objI;
        mt0 mt0Var3;
        gd1 gd1Var2;
        q91 q91Var;
        long j;
        String strOptString;
        jr2 jr2Var;
        Object value;
        ym ymVar;
        Object value2;
        t70 t70Var = t70.a;
        int i2 = this.v;
        try {
            if (i2 == 0) {
                bz3.g(obj);
                mt0 mt0Var4 = this.w;
                an1 an1Var3 = mt0Var4.p;
                hd1Var = this.X;
                gd1 gd1Var3 = this.x;
                JSONObject jSONObject2 = this.Y;
                hq0 hq0Var2 = this.Z;
                f5 f5Var2 = this.c0;
                this.f = an1Var3;
                this.i = mt0Var4;
                this.j = hd1Var;
                this.k = gd1Var3;
                this.n = jSONObject2;
                this.s = hq0Var2;
                this.t = f5Var2;
                this.u = 0;
                this.v = 1;
                if (an1Var3.e(this) != t70Var) {
                    gd1Var = gd1Var3;
                    mt0Var = mt0Var4;
                    jSONObject = jSONObject2;
                    hq0Var = hq0Var2;
                    f5Var = f5Var2;
                    an1Var = an1Var3;
                    i = 0;
                }
                return t70Var;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                gd1Var2 = (gd1) this.j;
                mt0 mt0Var5 = this.i;
                an1Var2 = this.f;
                try {
                    bz3.g(obj);
                    an1Var = an1Var2;
                    mt0Var3 = mt0Var5;
                    objI = obj;
                    jSONObjectPut = (JSONObject) objI;
                    gd1Var = gd1Var2;
                    mt0Var2 = mt0Var3;
                    an1Var2 = an1Var;
                    q91Var = mt0Var2.A;
                    j = gd1Var.a;
                    jSONObjectPut.getClass();
                    synchronized (q91Var) {
                        ((LinkedHashMap) q91Var.b).put(Long.valueOf(j), jSONObjectPut);
                    }
                    an1Var2.h(null);
                    strOptString = jSONObjectPut.optString("spoken");
                    jr2Var = this.w.k;
                    do {
                        value = jr2Var.getValue();
                        strOptString.getClass();
                    } while (!jr2Var.h(value, ee1.a((ee1) value, false, null, strOptString, null, 55)));
                    if (!mt0.c(this.w, this.x.b) && (this.H.Z() || !mt0.b(this.w))) {
                        jr2 jr2Var2 = this.w.k;
                        do {
                            value2 = jr2Var2.getValue();
                        } while (!jr2Var2.h(value2, ee1.a((ee1) value2, false, null, null, "The action result is shown here. Gemini will speak it when Live reconnects.", 47)));
                        this.H.b0(q43.a);
                    } else if (!this.w.v && this.X.b(this.x) && !cs2.A(strOptString) && (ymVar = this.w.I) != null) {
                        ymVar.a();
                    }
                    return q43.a;
                } catch (Throwable th) {
                    th = th;
                    an1Var2.h(null);
                    throw th;
                }
            }
            i = this.u;
            f5 f5Var3 = this.t;
            hq0 hq0Var3 = this.s;
            JSONObject jSONObject3 = this.n;
            gd1 gd1Var4 = this.k;
            hd1Var = (hd1) this.j;
            mt0 mt0Var6 = this.i;
            an1Var = this.f;
            bz3.g(obj);
            f5Var = f5Var3;
            jSONObject = jSONObject3;
            hq0Var = hq0Var3;
            mt0Var = mt0Var6;
            gd1Var = gd1Var4;
            if (!mt0Var.v && !mt0Var.w && hd1Var.b(gd1Var)) {
                jSONObject.getClass();
                JSONObject jSONObject4 = jSONObject;
                String str = gd1Var.b;
                long j2 = gd1Var.a;
                this.f = an1Var;
                this.i = mt0Var;
                this.j = gd1Var;
                this.k = null;
                this.n = null;
                this.s = null;
                this.t = null;
                this.u = i;
                this.v = 2;
                mt0 mt0Var7 = mt0Var;
                objI = mt0Var7.i(jSONObject4, str, j2, hq0Var, f5Var, true, this);
                if (objI != t70Var) {
                    mt0Var3 = mt0Var7;
                    gd1Var2 = gd1Var;
                    jSONObjectPut = (JSONObject) objI;
                    gd1Var = gd1Var2;
                    mt0Var2 = mt0Var3;
                }
                return t70Var;
            }
            mt0 mt0Var8 = mt0Var;
            jSONObjectPut = new JSONObject().put("status", "CANCELLED").put("retryable", false).put("spoken", "");
            mt0Var2 = mt0Var8;
            an1Var2 = an1Var;
            q91Var = mt0Var2.A;
            j = gd1Var.a;
            jSONObjectPut.getClass();
            synchronized (q91Var) {
                ((LinkedHashMap) q91Var.b).put(Long.valueOf(j), jSONObjectPut);
                an1Var2.h(null);
                strOptString = jSONObjectPut.optString("spoken");
                jr2Var = this.w.k;
                do {
                    value = jr2Var.getValue();
                    strOptString.getClass();
                } while (!jr2Var.h(value, ee1.a((ee1) value, false, null, strOptString, null, 55)));
                if (!mt0.c(this.w, this.x.b)) {
                    if (!this.w.v) {
                        ymVar.a();
                    }
                } else if (!this.w.v) {
                    ymVar.a();
                }
                return q43.a;
            }
        } catch (Throwable th2) {
            th = th2;
            an1Var2 = an1Var;
            an1Var2.h(null);
            throw th;
        }
    }
}
