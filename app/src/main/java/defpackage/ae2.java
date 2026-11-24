package defpackage;

import android.os.Build;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.EdgeEffect;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ae2 extends zb0 implements k51, eg2, qy1, n01, h30 {
    public ha A0;
    public yd2 B0;
    public sc0 C0;
    public js1 X;
    public sa2 Y;
    public boolean Z;
    public ol1 c0;
    public un d0;
    public jf0 e0;
    public boolean f0;
    public boolean g0;
    public ne0 h0;
    public qe0 i0;
    public pe0 j0;
    public oe0 k0;
    public mm4 l0;
    public py0 m0;
    public long n0;
    public fw0 o0;
    public l01 p0;
    public long q0;
    public f9 r0;
    public ka0 s0;
    public final p6 t0;
    public final pd2 u0;
    public final ka0 v0;
    public final he2 w0;
    public final jb x0;
    public final ko0 y0;
    public final k50 z0;

    public ae2(f9 f9Var, ka0 ka0Var, ol1 ol1Var, js1 js1Var, be2 be2Var, boolean z, boolean z2) {
        sa2 sa2Var = ud2.a;
        this.X = js1Var;
        this.Y = sa2Var;
        this.Z = z;
        this.c0 = ol1Var;
        this.n0 = 9205357640488583168L;
        this.q0 = 0L;
        this.r0 = f9Var;
        this.s0 = ka0Var;
        p6 p6Var = new p6(6);
        this.t0 = p6Var;
        pd2 pd2Var = new pd2();
        pd2Var.x = z;
        I0(pd2Var);
        this.u0 = pd2Var;
        ka0 ka0Var2 = new ka0(new da0(new py0(ud2.d)));
        this.v0 = ka0Var2;
        f9 f9Var2 = this.r0;
        ka0 ka0Var3 = this.s0;
        he2 he2Var = new he2(be2Var, f9Var2, ka0Var3 == null ? ka0Var2 : ka0Var3, js1Var, z2, p6Var, this, new wd2(this, 0));
        this.w0 = he2Var;
        jb jbVar = new jb(he2Var, z);
        this.x0 = jbVar;
        ko0 ko0Var = new ko0(2, null, 10);
        I0(ko0Var);
        this.y0 = ko0Var;
        k50 k50Var = new k50(js1Var, he2Var, z2, new wd2(this, 1));
        I0(k50Var);
        this.z0 = k50Var;
        I0(new jn1(jbVar, p6Var));
        zm zmVar = new zm();
        zmVar.x = k50Var;
        I0(zmVar);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    /* JADX WARN: Code duplicated, block: B:26:0x006b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object L0(ae2 ae2Var, y50 y50Var) throws Throwable {
        ef0 ef0Var;
        ue0 ue0Var;
        s70 s70Var;
        if (y50Var instanceof ef0) {
            ef0Var = (ef0) y50Var;
            int i = ef0Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                ef0Var.i = i - Integer.MIN_VALUE;
            } else {
                ef0Var = new ef0(ae2Var, y50Var);
            }
        } else {
            ef0Var = new ef0(ae2Var, y50Var);
        }
        Object obj = ef0Var.e;
        int i2 = ef0Var.i;
        x50 x50Var = null;
        int i3 = 1;
        if (i2 == 0) {
            bz3.g(obj);
            jf0 jf0Var = ae2Var.e0;
            if (jf0Var != null) {
                ol1 ol1Var = ae2Var.c0;
                if (ol1Var != null) {
                    if0 if0Var = new if0(jf0Var);
                    ef0Var.i = 1;
                    Object objA = ol1Var.a(if0Var, ef0Var);
                    t70 t70Var = t70.a;
                    if (objA == t70Var) {
                        return t70Var;
                    }
                }
            }
            ue0Var = new ue0(0L, false);
            s70Var = (s70) ((fq0) ae2Var.t0.c).a();
            if (s70Var != null) {
                uf4.b(s70Var, null, new sc2(ue0Var, ae2Var, x50Var, i3), 3);
                return q43.a;
            }
            og.n("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
            return null;
        }
        if (i2 != 1) {
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        bz3.g(obj);
        ae2Var.e0 = null;
        ue0Var = new ue0(0L, false);
        s70Var = (s70) ((fq0) ae2Var.t0.c).a();
        if (s70Var != null) {
            uf4.b(s70Var, null, new sc2(ue0Var, ae2Var, x50Var, i3), 3);
            return q43.a;
        }
        og.n("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object M0(ae2 ae2Var, te0 te0Var, y50 y50Var) {
        ff0 ff0Var;
        ol1 ol1Var;
        jf0 jf0Var;
        te0 te0Var2;
        jf0 jf0Var2;
        if (y50Var instanceof ff0) {
            ff0Var = (ff0) y50Var;
            int i = ff0Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                ff0Var.k = i - Integer.MIN_VALUE;
            } else {
                ff0Var = new ff0(ae2Var, y50Var);
            }
        } else {
            ff0Var = new ff0(ae2Var, y50Var);
        }
        Object obj = ff0Var.i;
        int i2 = ff0Var.k;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(obj);
            jf0 jf0Var3 = ae2Var.e0;
            if (jf0Var3 != null && (ol1Var = ae2Var.c0) != null) {
                if0 if0Var = new if0(jf0Var3);
                ff0Var.e = te0Var;
                ff0Var.k = 1;
                if (ol1Var.a(if0Var, ff0Var) != t70Var) {
                }
                return t70Var;
            }
            ae2Var.e0 = jf0Var;
            long j = te0Var.a;
            return q43.a;
        }
        if (i2 == 1) {
            te0Var = ff0Var.e;
            bz3.g(obj);
        } else {
            if (i2 != 2) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            jf0Var2 = ff0Var.f;
            te0Var2 = ff0Var.e;
            bz3.g(obj);
        }
        jf0Var = jf0Var2;
        te0Var = te0Var2;
        ae2Var.e0 = jf0Var;
        long j2 = te0Var.a;
        return q43.a;
        jf0Var = new jf0();
        ol1 ol1Var2 = ae2Var.c0;
        if (ol1Var2 != null) {
            ff0Var.e = te0Var;
            ff0Var.f = jf0Var;
            ff0Var.k = 2;
            if (ol1Var2.a(jf0Var, ff0Var) != t70Var) {
                te0Var2 = te0Var;
                jf0Var2 = jf0Var;
                jf0Var = jf0Var2;
                te0Var = te0Var2;
            }
            return t70Var;
        }
        ae2Var.e0 = jf0Var;
        long j3 = te0Var.a;
        return q43.a;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0067  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object N0(ae2 ae2Var, ue0 ue0Var, y50 y50Var) throws Throwable {
        gf0 gf0Var;
        s70 s70Var;
        if (y50Var instanceof gf0) {
            gf0Var = (gf0) y50Var;
            int i = gf0Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                gf0Var.j = i - Integer.MIN_VALUE;
            } else {
                gf0Var = new gf0(ae2Var, y50Var);
            }
        } else {
            gf0Var = new gf0(ae2Var, y50Var);
        }
        Object obj = gf0Var.f;
        int i2 = gf0Var.j;
        x50 x50Var = null;
        int i3 = 1;
        if (i2 == 0) {
            bz3.g(obj);
            jf0 jf0Var = ae2Var.e0;
            if (jf0Var != null) {
                ol1 ol1Var = ae2Var.c0;
                if (ol1Var != null) {
                    kf0 kf0Var = new kf0(jf0Var);
                    gf0Var.e = ue0Var;
                    gf0Var.j = 1;
                    Object objA = ol1Var.a(kf0Var, gf0Var);
                    t70 t70Var = t70.a;
                    if (objA == t70Var) {
                        return t70Var;
                    }
                }
            }
            s70Var = (s70) ((fq0) ae2Var.t0.c).a();
            if (s70Var != null) {
                uf4.b(s70Var, null, new sc2(ue0Var, ae2Var, x50Var, i3), 3);
                return q43.a;
            }
            og.n("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
            return null;
        }
        if (i2 != 1) {
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ue0Var = gf0Var.e;
        bz3.g(obj);
        ae2Var.e0 = null;
        s70Var = (s70) ((fq0) ae2Var.t0.c).a();
        if (s70Var != null) {
            uf4.b(s70Var, null, new sc2(ue0Var, ae2Var, x50Var, i3), 3);
            return q43.a;
        }
        og.n("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        return null;
    }

    public static void R0(ae2 ae2Var, ny1 ny1Var, long j, long j2, int i) {
        if ((i & 4) != 0) {
            j2 = 0;
        }
        pe0 pe0Var = ae2Var.j0;
        if (pe0Var == null) {
            pe0Var = new pe0();
            pe0Var.a = null;
            pe0Var.b = Long.MAX_VALUE;
            pe0Var.c = false;
            ae2Var.j0 = pe0Var;
        }
        pe0Var.a = ny1Var;
        pe0Var.b = j;
        fw0 fw0Var = ae2Var.o0;
        js1 js1Var = ae2Var.X;
        if (fw0Var == null) {
            ae2Var.o0 = new fw0(js1Var);
        } else {
            fw0Var.b = js1Var;
            fw0Var.a = j2;
        }
        pe0Var.c = false;
        ae2Var.l0 = pe0Var;
    }

    @Override // defpackage.n01
    public final void A() {
        l01 l01Var = this.p0;
        if (l01Var != null) {
            l01Var.a();
            ae2 ae2Var = l01Var.a;
            if (ae2Var.f0) {
                ae2Var.S0(re0.a);
            }
            l01Var.g = null;
            m01 m01Var = l01Var.k;
            m01Var.a = 0;
            m01Var.b.clear();
        }
    }

    @Override // defpackage.dk1
    public final void A0() {
        if (this.w) {
            jc0 jc0Var = cm4.g(this).h0;
            ka0 ka0Var = this.v0;
            ka0Var.getClass();
            ka0Var.a = new da0(new py0(jc0Var));
        }
        sc0 sc0Var = this.C0;
        if (sc0Var != null) {
            sc0Var.e = cm4.g(this).h0;
        }
    }

    @Override // defpackage.dk1
    public final void B0() {
        this.f0 = false;
        O0();
        this.q0 = 0L;
    }

    /* JADX WARN: Failed to calculate best type for var: r14v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v10 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v11 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v8 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v9 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v27 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v27 ??, new type: fw0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v27 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v27 ??, new type: fw0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r22v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r22v3 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v11 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v11 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v12 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v15 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v15 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v16 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v16 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v17 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v17 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v18 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v19 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v19 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v20 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v20 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v21 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v11 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    @Override // defpackage.n01
    public final void D(defpackage.t9 r27, defpackage.hy1 r28) {
        /*
            Method dump skipped, instruction units count: 1011
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ae2.D(t9, hy1):void");
    }

    @Override // defpackage.qy1
    public final void H(gy1 gy1Var, hy1 hy1Var, long j) {
        hy1 hy1Var2;
        hy1 hy1Var3;
        hy1 hy1Var4;
        Object obj;
        Object obj2;
        boolean z;
        Object obj3;
        Object obj4;
        Object obj5;
        ae2 ae2Var = this;
        gy1 gy1Var2 = gy1Var;
        List list = gy1Var2.a;
        List list2 = gy1Var2.a;
        int size = list.size();
        int i = 0;
        while (true) {
            hy1 hy1Var5 = hy1.b;
            hy1Var2 = hy1.a;
            if (i < size) {
                ny1 ny1Var = (ny1) list.get(i);
                sa2 sa2Var = ae2Var.Y;
                int i2 = ny1Var.i;
                sa2Var.getClass();
                if (!(i2 == 2)) {
                    ae2Var.g0 = true;
                    if (!ae2Var.Z) {
                        break;
                    }
                    if (ae2Var.l0 == null) {
                        ne0 ne0Var = ae2Var.h0;
                        if (ne0Var == null) {
                            ne0Var = new ne0();
                            ne0Var.a = me0.c;
                            ne0Var.b = false;
                            ae2Var.h0 = ne0Var;
                        }
                        ae2Var.l0 = ne0Var;
                    }
                    mm4 mm4Var = ae2Var.l0;
                    if (mm4Var == null) {
                        og.i("currentDragState should not be null");
                        return;
                    }
                    if (!(mm4Var instanceof ne0)) {
                        boolean z2 = mm4Var instanceof pe0;
                        hy1 hy1Var6 = hy1.c;
                        if (z2) {
                            pe0 pe0Var = (pe0) mm4Var;
                            if (hy1Var != hy1Var2) {
                                int size2 = list.size();
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= size2) {
                                        hy1Var3 = hy1Var5;
                                        obj3 = null;
                                        break;
                                    }
                                    Object obj6 = list.get(i3);
                                    obj3 = obj6;
                                    hy1Var3 = hy1Var5;
                                    if (f31.d(((ny1) obj6).a, pe0Var.b)) {
                                        break;
                                    }
                                    i3++;
                                    hy1Var5 = hy1Var3;
                                }
                                ny1 ny1Var2 = (ny1) obj3;
                                if (ny1Var2 == null) {
                                    int size3 = list.size();
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 >= size3) {
                                            obj5 = null;
                                            break;
                                        }
                                        obj5 = list.get(i4);
                                        if (((ny1) obj5).d) {
                                            break;
                                        } else {
                                            i4++;
                                        }
                                    }
                                    ny1Var2 = (ny1) obj5;
                                    if (ny1Var2 == null) {
                                        ae2Var.P0();
                                    } else {
                                        pe0Var.b = ny1Var2.a;
                                    }
                                }
                                hy1 hy1Var7 = hy1Var3;
                                if (hy1Var != hy1Var7) {
                                    hy1Var4 = hy1Var7;
                                } else if (ny1Var2.b()) {
                                    hy1Var4 = hy1Var7;
                                    ny1 ny1Var3 = pe0Var.a;
                                    if (ny1Var3 == null) {
                                        og.i("AwaitTouchSlop.initialDown was not initialized");
                                        return;
                                    }
                                    long j2 = pe0Var.b;
                                    fw0 fw0Var = ae2Var.o0;
                                    if (fw0Var == null) {
                                        og.i("AwaitTouchSlop.touchSlopDetector was not initialized");
                                        return;
                                    }
                                    ae2Var.Q0(ny1Var3, j2, fw0Var);
                                } else if (y11.d(ny1Var2)) {
                                    int size4 = list.size();
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= size4) {
                                            obj4 = null;
                                            break;
                                        }
                                        obj4 = list.get(i5);
                                        if (((ny1) obj4).d) {
                                            break;
                                        } else {
                                            i5++;
                                        }
                                    }
                                    ny1 ny1Var4 = (ny1) obj4;
                                    if (ny1Var4 == null) {
                                        ae2Var.P0();
                                    } else {
                                        pe0Var.b = ny1Var4.a;
                                    }
                                    hy1Var4 = hy1Var7;
                                } else {
                                    float f = cf0.f((w73) ij4.a(ae2Var, l30.s), ny1Var2.i);
                                    fw0 fw0Var2 = ae2Var.o0;
                                    if (fw0Var2 == null) {
                                        og.i("Touch slop detector not initialized.");
                                        return;
                                    }
                                    hy1Var4 = hy1Var7;
                                    long jA = fw0Var2.a(ny1Var2.c, ny1Var2.g, f);
                                    if ((9223372034707292159L & jA) != 9205357640488583168L) {
                                        ny1Var2.a();
                                        ny1 ny1Var5 = pe0Var.a;
                                        ny1Var5.getClass();
                                        ae2Var.W0(ny1Var5, ny1Var2, jA);
                                        ae2Var.V0(ny1Var2, jA);
                                        long j3 = ny1Var2.a;
                                        qe0 qe0Var = ae2Var.i0;
                                        if (qe0Var == null) {
                                            qe0Var = new qe0();
                                            qe0Var.a = Long.MAX_VALUE;
                                            ae2Var.i0 = qe0Var;
                                        }
                                        qe0Var.a = j3;
                                        ae2Var.l0 = qe0Var;
                                    } else {
                                        pe0Var.c = true;
                                    }
                                }
                                if (hy1Var == hy1Var6 && pe0Var.c) {
                                    if (!ny1Var2.b()) {
                                        pe0Var.c = false;
                                        hy1Var3 = hy1Var4;
                                        break;
                                    }
                                    ny1 ny1Var6 = pe0Var.a;
                                    if (ny1Var6 == null) {
                                        og.i("AwaitTouchSlop.initialDown was not initialized");
                                        return;
                                    }
                                    long j4 = pe0Var.b;
                                    fw0 fw0Var3 = ae2Var.o0;
                                    if (fw0Var3 == null) {
                                        og.i("AwaitTouchSlop.touchSlopDetector was not initialized");
                                        return;
                                    }
                                    ae2Var.Q0(ny1Var6, j4, fw0Var3);
                                }
                                hy1Var3 = hy1Var4;
                            }
                            break;
                        }
                        hy1Var4 = hy1Var5;
                        if (mm4Var instanceof oe0) {
                            oe0 oe0Var = (oe0) mm4Var;
                            if (hy1Var == hy1Var6) {
                                int size5 = list.size();
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= size5) {
                                        z = true;
                                        break;
                                    } else {
                                        if (((ny1) list.get(i6)).b()) {
                                            z = false;
                                            break;
                                        }
                                        i6++;
                                    }
                                }
                                int size6 = list.size();
                                int i7 = 0;
                                while (true) {
                                    if (i7 < size6) {
                                        if (((ny1) list.get(i7)).d) {
                                            if (!list.isEmpty()) {
                                                if (!z) {
                                                    break;
                                                }
                                                long j5 = ((ny1) mz.x(list)).c;
                                                ny1 ny1Var7 = oe0Var.a;
                                                ny1Var7.getClass();
                                                long jD = jp1.d(j5, ny1Var7.c);
                                                ny1 ny1Var8 = oe0Var.a;
                                                if (ny1Var8 != null) {
                                                    R0(ae2Var, ny1Var8, oe0Var.b, jD, 8);
                                                    break;
                                                } else {
                                                    og.i("AwaitGesturePickup.initialDown was not initialized.");
                                                    return;
                                                }
                                            }
                                            break;
                                        }
                                        i7++;
                                    }
                                    ae2Var.P0();
                                    break;
                                }
                            }
                            hy1Var3 = hy1Var4;
                            break;
                            break;
                        }
                        if (!(mm4Var instanceof qe0)) {
                            dk0.l();
                            return;
                        }
                        qe0 qe0Var2 = (qe0) mm4Var;
                        hy1Var5 = hy1Var4;
                        if (hy1Var == hy1Var5) {
                            long j6 = qe0Var2.a;
                            int size7 = list.size();
                            int i8 = 0;
                            while (true) {
                                if (i8 >= size7) {
                                    hy1Var3 = hy1Var5;
                                    obj = null;
                                    break;
                                }
                                obj = list.get(i8);
                                hy1Var3 = hy1Var5;
                                if (f31.d(((ny1) obj).a, j6)) {
                                    break;
                                }
                                i8++;
                                hy1Var5 = hy1Var3;
                            }
                            ny1 ny1Var9 = (ny1) obj;
                            if (ny1Var9 == null) {
                                break;
                            }
                            boolean zD = y11.d(ny1Var9);
                            re0 re0Var = re0.a;
                            if (!zD) {
                                if (!ny1Var9.b()) {
                                    if (jp1.c(y11.f(ny1Var9, true)) != 0.0f) {
                                        ae2Var.V0(ny1Var9, y11.f(ny1Var9, false));
                                        ny1Var9.a();
                                        break;
                                    }
                                    break;
                                }
                                ae2Var.T0().s(re0Var);
                            } else {
                                int size8 = list.size();
                                int i9 = 0;
                                while (true) {
                                    if (i9 >= size8) {
                                        obj2 = null;
                                        break;
                                    }
                                    obj2 = list.get(i9);
                                    if (((ny1) obj2).d) {
                                        break;
                                    } else {
                                        i9++;
                                    }
                                }
                                ny1 ny1Var10 = (ny1) obj2;
                                if (ny1Var10 == null) {
                                    if (ny1Var9.b() || !y11.d(ny1Var9)) {
                                        ae2Var.T0().s(re0Var);
                                    } else {
                                        ue4.a(ae2Var.U0(), ny1Var9, 0L);
                                        float fA = ((w73) ij4.a(ae2Var, l30.s)).a();
                                        long jE = ae2Var.U0().e(se4.a(fA, fA));
                                        kb0 kb0Var = (kb0) ae2Var.U0().b;
                                        z63 z63Var = (z63) kb0Var.b;
                                        b90[] b90VarArr = z63Var.d;
                                        qg.l(0, b90VarArr.length, null, b90VarArr);
                                        z63Var.e = 0;
                                        z63 z63Var2 = (z63) kb0Var.c;
                                        b90[] b90VarArr2 = z63Var2.d;
                                        qg.l(0, b90VarArr2.length, null, b90VarArr2);
                                        z63Var2.e = 0;
                                        kb0Var.a = 0L;
                                        ae2Var.T0().s(new ue0(um4.a(jE), false));
                                        ae2Var.g0 = false;
                                    }
                                    ae2Var.P0();
                                } else {
                                    qe0Var2.a = ny1Var10.a;
                                }
                            }
                        }
                        break;
                        break;
                    }
                    ne0 ne0Var2 = (ne0) mm4Var;
                    if (!list.isEmpty() && vv2.c(gy1Var2, false)) {
                        ny1 ny1Var11 = (ny1) mz.x(list);
                        int i10 = df0.a[ne0Var2.a.ordinal()];
                        me0 me0Var = me0.b;
                        me0 me0Var2 = me0.a;
                        me0 me0Var3 = i10 == 1 ? !ae2Var.X0() ? me0Var2 : me0Var : ne0Var2.a;
                        ne0Var2.a = me0Var3;
                        if (hy1Var == hy1Var2 && me0Var3 == me0Var) {
                            ny1Var11.a();
                            ne0Var2.b = true;
                        }
                        if (hy1Var == hy1Var5) {
                            if (me0Var3 == me0Var2) {
                                R0(ae2Var, ny1Var11, ny1Var11.a, 0L, 12);
                            } else if (ne0Var2.b) {
                                ae2Var.W0(ny1Var11, ny1Var11, 0L);
                                ae2Var.V0(ny1Var11, 0L);
                                long j7 = ny1Var11.a;
                                qe0 qe0Var3 = ae2Var.i0;
                                if (qe0Var3 == null) {
                                    qe0Var3 = new qe0();
                                    qe0Var3.a = Long.MAX_VALUE;
                                    ae2Var.i0 = qe0Var3;
                                }
                                qe0Var3.a = j7;
                                ae2Var.l0 = qe0Var3;
                            }
                        }
                    }
                    hy1Var3 = hy1Var5;
                    break;
                    break;
                }
                i++;
                gy1Var2 = gy1Var;
            }
            hy1Var3 = hy1Var5;
            break;
        }
        if (ae2Var.Z) {
            if (hy1Var == hy1Var2 && gy1Var.f == 6) {
                if (ae2Var.C0 == null) {
                    ae2Var = this;
                    ae2Var.C0 = new sc0(ae2Var.w0, new q82(ViewConfiguration.get(dm4.a(ae2Var).getContext())), new v10(2, this, ae2.class, "onWheelScrollStopped", "onWheelScrollStopped-TH1AsA0(J)V", 4, 1), cm4.g(ae2Var).h0);
                }
                sc0 sc0Var = ae2Var.C0;
                if (sc0Var != null) {
                    s70 s70VarW0 = ae2Var.w0();
                    if (((yq2) sc0Var.g) == null) {
                        sc0Var.g = uf4.b(s70VarW0, null, new p0(sc0Var, null, 24), 3);
                    }
                }
            }
            sc0 sc0Var2 = ae2Var.C0;
            if (sc0Var2 == null || gy1Var.f != 6) {
                return;
            }
            int size9 = list.size();
            for (int i11 = 0; i11 < size9; i11++) {
                if (((ny1) list.get(i11)).b()) {
                    return;
                }
            }
            if (hy1Var == hy1Var2 && sc0Var2.a) {
                sc0Var2.d(gy1Var);
                int size10 = list2.size();
                for (int i12 = 0; i12 < size10; i12++) {
                    ((ny1) list2.get(i12)).a();
                }
            }
            if (hy1Var == hy1Var3 && !sc0Var2.a && sc0Var2.d(gy1Var)) {
                int size11 = list2.size();
                for (int i13 = 0; i13 < size11; i13++) {
                    ((ny1) list2.get(i13)).a();
                }
            }
        }
    }

    public final void O0() {
        jf0 jf0Var = this.e0;
        if (jf0Var != null) {
            ol1 ol1Var = this.c0;
            if (ol1Var != null) {
                ol1Var.b(new if0(jf0Var));
            }
            this.e0 = null;
        }
    }

    public final void P0() {
        ne0 ne0Var = this.h0;
        me0 me0Var = me0.c;
        if (ne0Var == null) {
            ne0Var = new ne0();
            ne0Var.a = me0Var;
            ne0Var.b = false;
            this.h0 = ne0Var;
        }
        ne0Var.a = me0Var;
        ne0Var.b = false;
        this.l0 = ne0Var;
    }

    public final void Q0(ny1 ny1Var, long j, fw0 fw0Var) {
        oe0 oe0Var = this.k0;
        if (oe0Var == null) {
            oe0Var = new oe0();
            oe0Var.a = null;
            oe0Var.b = Long.MAX_VALUE;
            this.k0 = oe0Var;
        }
        oe0Var.a = ny1Var;
        oe0Var.b = j;
        fw0Var.a = 0L;
        this.l0 = oe0Var;
    }

    public final void S0(ve0 ve0Var) {
        if ((ve0Var instanceof te0) && !this.f0) {
            this.f0 = true;
            Y0();
        }
        T0().s(ve0Var);
    }

    public final bx T0() {
        un unVar = this.d0;
        if (unVar != null) {
            return unVar;
        }
        og.i("Events channel not initialized.");
        return null;
    }

    @Override // defpackage.k51
    public final boolean U(KeyEvent keyEvent) {
        long jFloatToRawIntBits;
        if (!this.Z || ((!d51.a(h51.a(keyEvent), d51.D) && !d51.a(mp4.a(keyEvent.getKeyCode()), d51.C)) || h51.b(keyEvent) != 2 || keyEvent.isCtrlPressed())) {
            return false;
        }
        boolean z = this.w0.d == js1.a;
        k50 k50Var = this.z0;
        if (z) {
            int i = (int) (k50Var.d0 & 4294967295L);
            jFloatToRawIntBits = (((long) Float.floatToRawIntBits(0.0f)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(d51.a(mp4.a(keyEvent.getKeyCode()), d51.C) ? i : -i)));
        } else {
            int i2 = (int) (k50Var.d0 >> 32);
            jFloatToRawIntBits = (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L) | (((long) Float.floatToRawIntBits(d51.a(mp4.a(keyEvent.getKeyCode()), d51.C) ? i2 : -i2)) << 32);
        }
        uf4.b(w0(), null, new yd2(this, jFloatToRawIntBits, null, 0), 3);
        return true;
    }

    public final py0 U0() {
        py0 py0Var = this.m0;
        if (py0Var != null) {
            return py0Var;
        }
        og.i("Velocity Tracker not initialized.");
        return null;
    }

    public final void V0(ny1 ny1Var, long j) {
        long jA = cm4.f(this.a).a(0L);
        if (!jp1.b(this.n0, 9205357640488583168L) && !jp1.b(jA, this.n0)) {
            this.q0 = jp1.e(this.q0, jp1.d(jA, this.n0));
        }
        this.n0 = jA;
        ue4.a(U0(), ny1Var, this.q0);
        T0().s(new se0(j, false));
    }

    public final void W0(ny1 ny1Var, ny1 ny1Var2, long j) {
        if (this.m0 == null) {
            this.m0 = new py0(22);
        }
        ue4.a(U0(), ny1Var, 0L);
        long jD = jp1.d(ny1Var2.c, j);
        this.q0 = 0L;
        sa2 sa2Var = this.Y;
        int i = ny1Var.i;
        sa2Var.getClass();
        if (i == 2) {
            return;
        }
        if (!this.f0) {
            if (this.d0 == null) {
                this.d0 = nh4.a(Integer.MAX_VALUE, 6, null);
            }
            Y0();
        }
        this.n0 = cm4.f(this).a(0L);
        T0().s(new te0(jD));
    }

    public final boolean X0() {
        he2 he2Var = this.w0;
        if (he2Var.a.b()) {
            return true;
        }
        f9 f9Var = he2Var.b;
        if (f9Var == null) {
            return false;
        }
        xg0 xg0Var = f9Var.c;
        EdgeEffect edgeEffect = xg0Var.d;
        if (edgeEffect != null) {
            if ((Build.VERSION.SDK_INT >= 31 ? le.c(edgeEffect) : 0.0f) != 0.0f) {
                return true;
            }
        }
        EdgeEffect edgeEffect2 = xg0Var.e;
        if (edgeEffect2 != null) {
            if ((Build.VERSION.SDK_INT >= 31 ? le.c(edgeEffect2) : 0.0f) != 0.0f) {
                return true;
            }
        }
        EdgeEffect edgeEffect3 = xg0Var.f;
        if (edgeEffect3 != null) {
            if ((Build.VERSION.SDK_INT >= 31 ? le.c(edgeEffect3) : 0.0f) != 0.0f) {
                return true;
            }
        }
        EdgeEffect edgeEffect4 = xg0Var.g;
        if (edgeEffect4 != null) {
            return (Build.VERSION.SDK_INT >= 31 ? le.c(edgeEffect4) : 0.0f) != 0.0f;
        }
        return false;
    }

    public final void Y0() {
        this.f0 = true;
        if (this.d0 == null) {
            this.d0 = nh4.a(Integer.MAX_VALUE, 6, null);
        }
        uf4.b(w0(), null, new hf0(this, null), 3);
    }

    public final void Z0(f9 f9Var, ka0 ka0Var, ol1 ol1Var, js1 js1Var, be2 be2Var, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5 = true;
        if (this.Z != z) {
            this.x0.a = z;
            this.u0.x = z;
            z3 = true;
        } else {
            z3 = false;
        }
        ka0 ka0Var2 = ka0Var == null ? this.v0 : ka0Var;
        he2 he2Var = this.w0;
        if (g31.a(he2Var.a, be2Var)) {
            z4 = false;
        } else {
            he2Var.a = be2Var;
            z4 = true;
        }
        he2Var.b = f9Var;
        if (he2Var.d != js1Var) {
            he2Var.d = js1Var;
            z4 = true;
        }
        if (he2Var.e != z2) {
            he2Var.e = z2;
            z4 = true;
        }
        he2Var.c = ka0Var2;
        he2Var.f = this.t0;
        k50 k50Var = this.z0;
        k50Var.x = js1Var;
        k50Var.X = z2;
        this.r0 = f9Var;
        this.s0 = ka0Var;
        sa2 sa2Var = ud2.a;
        js1 js1Var2 = he2Var.d;
        js1 js1Var3 = js1.a;
        if (js1Var2 != js1Var3) {
            js1Var3 = js1.b;
        }
        this.Y = sa2Var;
        if (this.Z != z) {
            this.Z = z;
            if (!z) {
                O0();
                this.p0 = null;
            }
            z4 = true;
        }
        if (!g31.a(this.c0, ol1Var)) {
            O0();
            this.c0 = ol1Var;
        }
        if (this.X != js1Var3) {
            this.X = js1Var3;
        } else {
            z5 = z4;
        }
        if (z5) {
            boolean z6 = this.g0;
            re0 re0Var = re0.a;
            if (z6) {
                P0();
                if (this.f0) {
                    T0().s(re0Var);
                }
                this.m0 = null;
            }
            l01 l01Var = this.p0;
            if (l01Var != null) {
                l01Var.a();
                ae2 ae2Var = l01Var.a;
                if (ae2Var.f0) {
                    ae2Var.S0(re0Var);
                }
                l01Var.g = null;
                m01 m01Var = l01Var.k;
                m01Var.a = 0;
                m01Var.b.clear();
            }
        }
        if (z3) {
            this.A0 = null;
            this.B0 = null;
            a34.a(this);
        }
    }

    @Override // defpackage.xb0, defpackage.qy1
    public final void a() {
        h0();
        if (this.w) {
            jc0 jc0Var = cm4.g(this).h0;
            ka0 ka0Var = this.v0;
            ka0Var.getClass();
            ka0Var.a = new da0(new py0(jc0Var));
        }
        sc0 sc0Var = this.C0;
        if (sc0Var != null) {
            sc0Var.e = cm4.g(this).h0;
        }
    }

    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
        if (this.Z && (this.A0 == null || this.B0 == null)) {
            this.A0 = new ha(10, this);
            this.B0 = new yd2(this, null);
        }
        ha haVar = this.A0;
        if (haVar != null) {
            c51[] c51VarArr = mg2.a;
            og2Var.a(bg2.d, new b2(null, haVar));
        }
        yd2 yd2Var = this.B0;
        if (yd2Var != null) {
            c51[] c51VarArr2 = mg2.a;
            og2Var.a(bg2.e, yd2Var);
        }
    }

    @Override // defpackage.qy1
    public final void h0() {
        if (this.g0) {
            P0();
            if (this.f0) {
                T0().s(re0.a);
            }
            this.m0 = null;
        }
        this.g0 = false;
    }

    @Override // defpackage.k51
    public final boolean k(KeyEvent keyEvent) {
        return false;
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }
}
