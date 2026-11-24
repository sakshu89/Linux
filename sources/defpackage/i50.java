package defpackage;

import android.media.AudioRecord;
import android.os.SystemClock;
import android.util.Base64;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i50 extends nu2 implements vq0 {
    public final /* synthetic */ int f = 0;
    public long i;
    public int j;
    public /* synthetic */ Object k;
    public Object n;
    public final /* synthetic */ Object s;
    public final /* synthetic */ Object t;
    public final /* synthetic */ Object u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i50(sx1 sx1Var, String str, long j, oz2 oz2Var, ny2 ny2Var, mp1 mp1Var, x50 x50Var) {
        super(2, x50Var);
        this.k = sx1Var;
        this.n = str;
        this.i = j;
        this.s = oz2Var;
        this.t = ny2Var;
        this.u = mp1Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                return ((i50) q((x50) obj2, (fe2) obj)).s(q43Var);
            case 1:
                return ((i50) q((x50) obj2, (s70) obj)).s(q43Var);
            default:
                return ((i50) q((x50) obj2, (s70) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.u;
        Object obj3 = this.t;
        Object obj4 = this.s;
        switch (i) {
            case 0:
                i50 i50Var = new i50((i53) this.n, (k50) obj4, (cn) obj3, this.i, (f41) obj2, x50Var);
                i50Var.k = obj;
                return i50Var;
            case 1:
                i50 i50Var2 = new i50((mt0) obj4, (AudioRecord) obj3, (zc1) obj2, x50Var);
                i50Var2.k = obj;
                return i50Var2;
            default:
                return new i50((sx1) this.k, (String) this.n, this.i, (oz2) obj4, (ny2) obj3, (mp1) obj2, x50Var);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        byte[] bArr;
        long j;
        x32 x32Var;
        long j2;
        Boolean boolValueOf;
        Object objD;
        int i = 1;
        x50 x50Var = null;
        switch (this.f) {
            case 0:
                cn cnVar = (cn) this.t;
                k50 k50Var = (k50) this.s;
                i53 i53Var = (i53) this.n;
                t70 t70Var = t70.a;
                int i2 = this.j;
                if (i2 == 0) {
                    bz3.g(obj);
                    fe2 fe2Var = (fe2) this.k;
                    i53Var.e = k50.I0(k50Var, cnVar, this.i);
                    e2 e2Var = new e2(k50Var, i53Var, (f41) this.u, fe2Var);
                    ek ekVar = new ek(k50Var, i53Var, cnVar, 3);
                    this.j = 1;
                    if (i53Var.a(e2Var, ekVar, this) == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i2 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                }
                return q43.a;
            case 1:
                s70 s70Var = (s70) this.k;
                t70 t70Var2 = t70.a;
                int i3 = this.j;
                if (i3 == 0) {
                    bz3.g(obj);
                    bArr = new byte[640];
                    j = 0;
                } else {
                    if (i3 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    j = this.i;
                    bArr = (byte[]) this.n;
                    bz3.g(obj);
                }
                while (tl4.d(s70Var) && !((mt0) this.s).w) {
                    int i4 = ((AudioRecord) this.t).read(bArr, 0, bArr.length, 0);
                    if (!((mt0) this.s).w && ((mt0) this.s).j.a((zc1) this.u)) {
                        if (i4 < 0) {
                            og.n("Microphone stream stopped.");
                        } else if (i4 == 0) {
                            this.k = s70Var;
                            this.n = bArr;
                            this.i = j;
                            this.j = i;
                            if (bm4.b(10L, this) == t70Var2) {
                                return t70Var2;
                            }
                        } else {
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            if (jElapsedRealtime - j >= 250) {
                                ((mt0) this.s).j.b((zc1) this.u);
                                j = jElapsedRealtime;
                            }
                            if (!((mt0) this.s).w && ((mt0) this.s).j.a((zc1) this.u) && (x32Var = ((mt0) this.s).r) != null) {
                                synchronized (x32Var) {
                                    j2 = x32Var.p;
                                }
                                if (j2 < 256000) {
                                    bd1 bd1Var = ((mt0) this.s).j;
                                    zc1 zc1Var = (zc1) this.u;
                                    synchronized (bd1Var) {
                                        if (bd1Var.a(zc1Var)) {
                                            String strEncodeToString = Base64.encodeToString(Arrays.copyOf(bArr, i4), 2);
                                            strEncodeToString.getClass();
                                            String string = new JSONObject().put("realtimeInput", new JSONObject().put("audio", new JSONObject().put("mimeType", "audio/pcm;rate=16000").put("data", strEncodeToString))).toString();
                                            string.getClass();
                                            boolValueOf = Boolean.valueOf(x32Var.g(string));
                                        } else {
                                            boolValueOf = null;
                                        }
                                        break;
                                    }
                                    if (boolValueOf != null) {
                                        if (boolValueOf.booleanValue()) {
                                            i = 1;
                                        } else {
                                            og.n("Check failed.");
                                        }
                                    }
                                } else {
                                    og.n("Connection is too slow for real-time audio.");
                                }
                            }
                        }
                        return null;
                    }
                    return q43.a;
                }
                return q43.a;
            default:
                q43 q43Var = q43.a;
                mp1 mp1Var = (mp1) this.u;
                String str = (String) this.n;
                ny2 ny2Var = (ny2) this.t;
                t70 t70Var3 = t70.a;
                int i5 = this.j;
                if (i5 == 0) {
                    bz3.g(obj);
                    sx1 sx1Var = (sx1) this.k;
                    long j3 = this.i;
                    this.j = 1;
                    sx1Var.getClass();
                    objD = (str.length() == 0 || oz2.c(j3)) ? null : uf4.d(sx1Var.a, new aa(sx1Var, new rx1(j3, null, sx1Var, str), x50Var, 7), this);
                    if (objD == t70Var3) {
                        return t70Var3;
                    }
                } else {
                    if (i5 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(obj);
                    objD = obj;
                }
                oz2 oz2Var = (oz2) objD;
                if (oz2Var != null) {
                    long j4 = oz2Var.a;
                    long jA = hc4.a(mp1Var.k((int) (j4 >> 32)), mp1Var.k((int) (j4 & 4294967295L)));
                    if (!oz2.a(jA, (oz2) this.s) && g31.a(ny2Var.n().a.b, str) && mp1Var == ny2Var.b) {
                        ny2Var.c.j(ny2.e(ny2Var.n().a, jA));
                        ny2Var.w = new oz2(jA);
                    }
                }
                return q43Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i50(mt0 mt0Var, AudioRecord audioRecord, zc1 zc1Var, x50 x50Var) {
        super(2, x50Var);
        this.s = mt0Var;
        this.t = audioRecord;
        this.u = zc1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i50(i53 i53Var, k50 k50Var, cn cnVar, long j, f41 f41Var, x50 x50Var) {
        super(2, x50Var);
        this.n = i53Var;
        this.s = k50Var;
        this.t = cnVar;
        this.i = j;
        this.u = f41Var;
    }
}
