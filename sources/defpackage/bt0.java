package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bt0 extends nu2 implements vq0 {
    public final /* synthetic */ int f = 2;
    public Object i;
    public int j;
    public Object k;
    public Object n;
    public Object s;
    public Object t;
    public /* synthetic */ Object u;
    public final /* synthetic */ Object v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt0(hd1 hd1Var, mt0 mt0Var, JSONObject jSONObject, p6 p6Var, s70 s70Var, x00 x00Var, hq0 hq0Var, x50 x50Var) {
        super(2, x50Var);
        this.k = hd1Var;
        this.n = mt0Var;
        this.s = jSONObject;
        this.t = p6Var;
        this.u = s70Var;
        this.v = x00Var;
        this.i = hq0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) throws Throwable {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                return ((bt0) q((x50) obj2, (s70) obj)).s(q43Var);
            case 1:
                ((bt0) q((x50) obj2, (nm0) obj)).s(q43Var);
                return t70.a;
            default:
                return ((bt0) q((x50) obj2, (nm0) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.v;
        switch (i) {
            case 0:
                return new bt0((hd1) this.k, (mt0) this.n, (JSONObject) this.s, (p6) this.t, (s70) this.u, (x00) obj2, (hq0) this.i, x50Var);
            case 1:
                bt0 bt0Var = new bt0((fq0) obj2, x50Var);
                bt0Var.u = obj;
                return bt0Var;
            default:
                bt0 bt0Var2 = new bt0((ContentResolver) this.s, (Uri) this.t, (g80) this.u, (un) obj2, (Context) this.i, x50Var);
                bt0Var2.n = obj;
                return bt0Var2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:243:0x01d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:0x01f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:245:0x01f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:246:0x01df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:248:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x01af A[Catch: all -> 0x01d4, TryCatch #10 {all -> 0x01d4, blocks: (B:71:0x019a, B:73:0x01af, B:75:0x01b9, B:77:0x01c3), top: B:234:0x019a }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01b9 A[Catch: all -> 0x01d4, TryCatch #10 {all -> 0x01d4, blocks: (B:71:0x019a, B:73:0x01af, B:75:0x01b9, B:77:0x01c3), top: B:234:0x019a }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01c3 A[Catch: all -> 0x01d4, TRY_LEAVE, TryCatch #10 {all -> 0x01d4, blocks: (B:71:0x019a, B:73:0x01af, B:75:0x01b9, B:77:0x01c3), top: B:234:0x019a }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:87:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:89:0x01e6 A[LOOP:1: B:234:0x019a->B:89:0x01e6, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [x50] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x024c -> B:113:0x024e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:130:0x0273 -> B:114:0x0252). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0092 -> B:19:0x005b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:243:0x01d1
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1070
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bt0.s(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt0(fq0 fq0Var, x50 x50Var) {
        super(2, x50Var);
        this.v = fq0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt0(ContentResolver contentResolver, Uri uri, g80 g80Var, un unVar, Context context, x50 x50Var) {
        super(2, x50Var);
        this.s = contentResolver;
        this.t = uri;
        this.u = g80Var;
        this.v = unVar;
        this.i = context;
    }
}
