package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hf0 extends nu2 implements vq0 {
    public final /* synthetic */ int f = 1;
    public t42 i;
    public t42 j;
    public int k;
    public /* synthetic */ Object n;
    public final /* synthetic */ ae2 s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hf0(t42 t42Var, ae2 ae2Var, x50 x50Var) {
        super(2, x50Var);
        this.j = t42Var;
        this.s = ae2Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                return ((hf0) q((x50) obj2, (hq0) obj)).s(q43Var);
            default:
                return ((hf0) q((x50) obj2, (s70) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        ae2 ae2Var = this.s;
        switch (i) {
            case 0:
                hf0 hf0Var = new hf0(this.j, ae2Var, x50Var);
                hf0Var.n = obj;
                return hf0Var;
            default:
                hf0 hf0Var2 = new hf0(ae2Var, x50Var);
                hf0Var2.n = obj;
                return hf0Var2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005e A[PHI: r7
      0x005e: PHI (r7v15 s70) = (r7v7 s70), (r7v10 s70), (r7v10 s70), (r7v10 s70), (r7v13 s70), (r7v16 s70) binds: [B:19:0x0056, B:49:0x00db, B:51:0x00e8, B:45:0x00d4, B:31:0x0089, B:12:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x0064  */
    /* JADX WARN: Code duplicated, block: B:24:0x006d  */
    /* JADX WARN: Code duplicated, block: B:27:0x007d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0081  */
    /* JADX WARN: Code duplicated, block: B:32:0x008b  */
    /* JADX WARN: Code duplicated, block: B:35:0x009d  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c7 A[Catch: CancellationException -> 0x00d7, TryCatch #2 {CancellationException -> 0x00d7, blocks: (B:42:0x00c1, B:44:0x00c7, B:48:0x00d9, B:50:0x00dd), top: B:90:0x00c1 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d9 A[Catch: CancellationException -> 0x00d7, TryCatch #2 {CancellationException -> 0x00d7, blocks: (B:42:0x00c1, B:44:0x00c7, B:48:0x00d9, B:50:0x00dd), top: B:90:0x00c1 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00dd A[Catch: CancellationException -> 0x00d7, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x00d7, blocks: (B:42:0x00c1, B:44:0x00c7, B:48:0x00d9, B:50:0x00dd), top: B:90:0x00c1 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:66:0x0120  */
    /* JADX WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0089 -> B:20:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d4 -> B:20:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00db -> B:20:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00e8 -> B:20:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00f6 -> B:12:0x002f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0142 -> B:80:0x0143). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0146 -> B:82:0x0148). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:56:0x00f9
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hf0.s(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hf0(ae2 ae2Var, x50 x50Var) {
        super(2, x50Var);
        this.s = ae2Var;
    }
}
