package defpackage;

import com.project.sonic.ui.camera.CaptureActivity;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hw extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public /* synthetic */ boolean j;
    public int k;
    public Object n;
    public final /* synthetic */ Object s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hw(CaptureActivity captureActivity, boolean z, x50 x50Var) {
        super(2, x50Var);
        this.f = 0;
        this.s = captureActivity;
        this.j = z;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                return ((hw) q((x50) obj2, (s70) obj)).s(q43Var);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return ((hw) q((x50) obj2, bool)).s(q43Var);
            default:
                Boolean bool2 = (Boolean) obj;
                bool2.booleanValue();
                return ((hw) q((x50) obj2, bool2)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.s;
        switch (i) {
            case 0:
                return new hw((CaptureActivity) obj2, this.j, x50Var);
            case 1:
                hw hwVar = new hw((w90) obj2, this.k, x50Var, 1);
                hwVar.j = ((Boolean) obj).booleanValue();
                return hwVar;
            default:
                hw hwVar2 = new hw((w90) obj2, this.k, x50Var, 2);
                hwVar2.j = ((Boolean) obj).booleanValue();
                return hwVar2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:86:0x0138 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x013a A[Catch: Exception -> 0x01b0, TRY_ENTER, TryCatch #0 {Exception -> 0x01b0, blocks: (B:60:0x00e2, B:108:0x018c, B:109:0x018e, B:63:0x00ed, B:101:0x0178, B:66:0x00f8, B:90:0x0150, B:87:0x013a, B:91:0x0152, B:92:0x0155, B:94:0x0158, B:98:0x016d, B:102:0x017b, B:103:0x017e, B:105:0x0181, B:110:0x019e, B:111:0x01a1, B:112:0x01a2, B:113:0x01a5, B:69:0x0100, B:70:0x0104, B:80:0x011f, B:73:0x010b, B:75:0x010f, B:77:0x0113, B:114:0x01a6, B:115:0x01ab, B:116:0x01ac, B:117:0x01af), top: B:121:0x00d6 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x014f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x014d -> B:90:0x0150). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hw.s(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hw(w90 w90Var, int i, x50 x50Var, int i2) {
        super(2, x50Var);
        this.f = i2;
        this.s = w90Var;
        this.k = i;
    }
}
