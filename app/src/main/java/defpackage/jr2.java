package defpackage;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jr2 extends z1 implements mm0, hr0, hr2, km1 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(jr2.class, Object.class, "_state$volatile");
    public static final /* synthetic */ long j = zj.a.objectFieldOffset(jr2.class.getDeclaredField("_state$volatile"));
    private volatile /* synthetic */ Object _state$volatile;
    public int f;

    public jr2(Object obj) {
        this._state$volatile = obj;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00e4 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:14:0x0034, B:31:0x007a, B:33:0x0082, B:36:0x0089, B:37:0x008d, B:39:0x0090, B:49:0x00b1, B:52:0x00c1, B:53:0x00dd, B:59:0x00ed, B:56:0x00e4, B:58:0x00ea, B:41:0x0096, B:45:0x009d, B:21:0x004b), top: B:66:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x00ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:? A[LOOP:0: B:53:0x00dd->B:73:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [kr2] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [a2] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [kr2] */
    /* JADX WARN: Type inference failed for: r1v7, types: [kr2] */
    /* JADX WARN: Type inference failed for: r1v8, types: [kr2] */
    /* JADX WARN: Type inference failed for: r8v1, types: [z1] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [jr2] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, jr2] */
    /* JADX WARN: Type inference failed for: r8v7, types: [jr2] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00c0 -> B:31:0x007a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.mm0
    public final java.lang.Object a(defpackage.nm0 r14, defpackage.x50 r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jr2.a(nm0, x50):java.lang.Object");
    }

    @Override // defpackage.hr0
    public final mm0 b(j70 j70Var, int i2, nn nnVar) {
        return (((i2 < 0 || i2 >= 2) && i2 != -2) || nnVar != nn.b) ? s44.d(this, j70Var, i2, nnVar) : this;
    }

    @Override // defpackage.z1
    public final a2 d() {
        return new kr2();
    }

    @Override // defpackage.z1
    public final a2[] e() {
        return new kr2[2];
    }

    @Override // defpackage.hr2
    public final Object getValue() {
        i.getClass();
        Object objectVolatile = zj.a.getObjectVolatile(this, j);
        if (objectVolatile == s24.a) {
            return null;
        }
        return objectVolatile;
    }

    public final boolean h(Object obj, Object obj2) {
        py0 py0Var = s24.a;
        if (obj == null) {
            obj = py0Var;
        }
        if (obj2 == null) {
            obj2 = py0Var;
        }
        return j(obj, obj2);
    }

    public final void i(Object obj) {
        if (obj == null) {
            obj = s24.a;
        }
        j(null, obj);
    }

    public final boolean j(Object obj, Object obj2) {
        int i2;
        a2[] a2VarArr;
        py0 py0Var;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !g31.a(obj3, obj)) {
                return false;
            }
            if (g31.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i3 = this.f;
            if ((i3 & 1) != 0) {
                this.f = i3 + 2;
                return true;
            }
            int i4 = i3 + 1;
            this.f = i4;
            a2[] a2VarArr2 = this.a;
            while (true) {
                kr2[] kr2VarArr = (kr2[]) a2VarArr2;
                if (kr2VarArr != null) {
                    for (kr2 kr2Var : kr2VarArr) {
                        if (kr2Var != null) {
                            AtomicReference atomicReference = kr2Var.a;
                            while (true) {
                                Object obj4 = atomicReference.get();
                                if (obj4 == null || obj4 == (py0Var = o54.b)) {
                                    break;
                                }
                                py0 py0Var2 = o54.a;
                                if (obj4 != py0Var2) {
                                    do {
                                        if (atomicReference.compareAndSet(obj4, py0Var2)) {
                                            ((yv) obj4).h(q43.a);
                                            break;
                                        }
                                    } while (atomicReference.get() == obj4);
                                } else {
                                    do {
                                        if (atomicReference.compareAndSet(obj4, py0Var)) {
                                            break;
                                        }
                                    } while (atomicReference.get() == obj4);
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i2 = this.f;
                    if (i2 == i4) {
                        this.f = i4 + 1;
                        return true;
                    }
                    a2VarArr = this.a;
                }
                a2VarArr2 = a2VarArr;
                i4 = i2;
            }
        }
    }

    @Override // defpackage.nm0
    public final Object n(Object obj, x50 x50Var) {
        i(obj);
        return q43.a;
    }
}
