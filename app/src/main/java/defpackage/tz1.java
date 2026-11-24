package defpackage;

import android.os.Trace;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tz1 implements e91 {
    public long H;
    public boolean X;
    public final /* synthetic */ a50 Y;
    public final int a;
    public final kf b;
    public final hq0 c;
    public q40 e;
    public us2 f;
    public a81 i;
    public boolean j;
    public boolean k;
    public boolean n;
    public Object s;
    public boolean t;
    public sz1 u;
    public boolean v;
    public long w;
    public long x;

    public tz1(a50 a50Var, int i, kf kfVar, j jVar) {
        this.Y = a50Var;
        this.a = i;
        this.b = kfVar;
        this.c = jVar;
        int i2 = mk1.b;
        this.H = System.nanoTime() - mk1.a;
    }

    @Override // defpackage.e91
    public final void a() {
        this.v = true;
    }

    public final void b() {
        a81 a81Var = this.i;
        if (a81Var != null) {
            switch (a81Var.a) {
                case 0:
                    break;
                default:
                    t71 t71VarB = a81Var.b();
                    if ((t71VarB != null ? t71VarB.f : null) != null) {
                        b81.c(a81Var.b, a81Var.c);
                    }
                    break;
            }
        }
        this.i = null;
        us2 us2Var = this.f;
        if (us2Var != null) {
            us2Var.a();
        }
        this.f = null;
        this.u = null;
    }

    public final boolean c(hb hbVar) {
        boolean zD;
        if (!this.Y.b) {
            return false;
        }
        if (this.v) {
            Trace.beginSection("compose:lazy:prefetch:execute:urgent");
            try {
                zD = d(hbVar);
                Trace.endSection();
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } else {
            zD = d(hbVar);
        }
        ge4.a(-1L, "compose:lazy:prefetch:execute:item");
        return zD;
    }

    @Override // defpackage.e91
    public final void cancel() {
        if (this.k) {
            return;
        }
        this.k = true;
        b();
    }

    /* JADX WARN: Failed to calculate best type for var: r15v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v3 ??, new type: long
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
    /* JADX WARN: Failed to calculate best type for var: r15v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v3 ??, new type: long
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
    /* JADX WARN: Failed to calculate best type for var: r15v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v4 ??, new type: long
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
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v3 ??, new type: char
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
    public final boolean d(defpackage.hb r26) {
        /*
            Method dump skipped, instruction units count: 876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tz1.d(hb):boolean");
    }

    public final boolean e() {
        a81 a81Var;
        return this.n || ((a81Var = this.i) != null && a81Var.c());
    }

    public final void f(Object obj, Object obj2, xj xjVar) {
        a81 a81Var;
        a81 a81Var2 = this.i;
        int i = 0;
        int i2 = 1;
        if (a81Var2 == null) {
            a50 a50Var = this.Y;
            vq0 vq0VarA = ((v81) a50Var.c).a(this.a, obj, obj2);
            b81 b81VarA = ((ws2) a50Var.d).a();
            if (b81VarA.a.H()) {
                b81VarA.k(obj, vq0VarA, true);
                a81Var = new a81(b81VarA, obj, i2);
            } else {
                a81Var = new a81(b81VarA, obj, i);
            }
            a81Var2 = a81Var;
            this.i = a81Var2;
            this.s = obj;
        }
        this.X = false;
        while (!a81Var2.c() && !this.X) {
            qq qqVar = new qq(5, this, xjVar);
            switch (a81Var2.a) {
                case 0:
                    break;
                default:
                    t71 t71VarB = a81Var2.b();
                    kv1 kv1Var = t71VarB != null ? t71VarB.f : null;
                    if (kv1Var != null && !kv1Var.c()) {
                        b81 b81Var = a81Var2.b;
                        bm2 bm2VarA = i44.a();
                        hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
                        bm2 bm2VarB = i44.b(bm2VarA);
                        try {
                            n71 n71Var = b81Var.a;
                            n71Var.X = true;
                            try {
                                kv1Var.e(qqVar);
                                n71Var.X = false;
                                i44.e(bm2VarA, bm2VarB, hq0VarE);
                            } catch (Throwable th) {
                                t71VarB.getClass();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            i44.e(bm2VarA, bm2VarB, hq0VarE);
                            throw th2;
                        }
                    }
                    break;
            }
        }
        h();
        boolean z = this.X;
        long j = this.x;
        if (z) {
            xjVar.b = xj.a(j, xjVar.b);
        } else {
            xjVar.a = xj.a(j, xjVar.a);
        }
    }

    public final boolean g(long j, long j2) {
        if (this.v) {
            j2 = 0;
        }
        return j > j2;
    }

    public final void h() {
        long j;
        int i = mk1.b;
        long jNanoTime = System.nanoTime() - mk1.a;
        long j2 = this.H;
        long jC = 0;
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            if (jNanoTime == j2) {
                xy xyVar = eg0.a;
            } else {
                long j3 = j2 < 0 ? eg0.c : eg0.b;
                jC = ((-(j3 >> 1)) << 1) + ((long) (((int) j3) & 1));
                int i2 = gg0.a;
            }
        } else if ((1 | (jNanoTime - 1)) == Long.MAX_VALUE) {
            jC = jNanoTime < 0 ? eg0.c : eg0.b;
        } else {
            long j4 = jNanoTime - j2;
            long j5 = (~(j4 ^ j2)) & (j4 ^ jNanoTime);
            hg0 hg0Var = hg0.NANOSECONDS;
            if (j5 < 0) {
                hg0 hg0Var2 = hg0.MILLISECONDS;
                if (hg0Var.compareTo(hg0Var2) < 0) {
                    long j6 = (jNanoTime / 1000000) - (j2 / 1000000);
                    long j7 = (jNanoTime % 1000000) - (j2 % 1000000);
                    xy xyVar2 = eg0.a;
                    long jC2 = ym4.c(j6, hg0Var2);
                    long jC3 = ym4.c(j7, hg0Var);
                    int i3 = ((int) jC2) & 1;
                    if (i3 != (((int) jC3) & 1)) {
                        jC = i3 == 1 ? eg0.a(jC2 >> 1, jC3 >> 1) : eg0.a(jC3 >> 1, jC2 >> 1);
                    } else if (i3 == 0) {
                        long j8 = (jC2 >> 1) + (jC3 >> 1);
                        if (-4611686018426999999L > j8 || j8 >= 4611686018427000000L) {
                            jC = ym4.b(j8 / 1000000);
                        } else {
                            jC = j8 << 1;
                            int i4 = gg0.a;
                        }
                    } else {
                        long jA = ym4.a(jC2 >> 1, jC3 >> 1);
                        if (jA == 9223372036854759646L) {
                            og.i("Summing infinite durations of different signs yields an undefined result.");
                            return;
                        }
                        if (jA == 4611686018427387903L || jA == -4611686018427387903L) {
                            jC = ym4.b(jA);
                        } else if (-4611686018426L > jA || jA >= 4611686018427L) {
                            jC = ym4.b(ky3.d(jA, -4611686018427387903L, 4611686018427387903L));
                        } else {
                            jC = (jA * 1000000) << 1;
                            int i5 = gg0.a;
                        }
                    }
                } else {
                    long j9 = j4 < 0 ? eg0.c : eg0.b;
                    jC = ((-(j9 >> 1)) << 1) + ((long) (((int) j9) & 1));
                    int i6 = gg0.a;
                }
            } else {
                jC = ym4.c(j4, hg0Var);
            }
        }
        long j10 = jC >> 1;
        xy xyVar3 = eg0.a;
        if ((((int) jC) & 1) == 0) {
            j = j10;
        } else if (j10 > 9223372036854L) {
            j = Long.MAX_VALUE;
        } else {
            j = j10 < -9223372036854L ? Long.MIN_VALUE : j10 * 1000000;
        }
        this.x = j;
        long j11 = this.w - j;
        this.w = j11;
        this.H = jNanoTime;
        ge4.a(j11, "compose:lazy:prefetch:available_time_nanos");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HandleAndRequestImpl { index = ");
        sb.append(this.a);
        sb.append(", constraints = ");
        sb.append(this.e);
        sb.append(", isComposed = ");
        sb.append(e());
        sb.append(", isMeasured = ");
        sb.append(this.j);
        sb.append(", isCanceled = ");
        return ky0.o(sb, this.k, " }");
    }
}
