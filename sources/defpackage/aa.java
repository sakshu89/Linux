package defpackage;

import android.graphics.Rect;
import android.view.ScrollCaptureSession;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class aa extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public Object j;
    public Object k;
    public final /* synthetic */ Object n;
    public final /* synthetic */ Object s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ aa(Object obj, Object obj2, Object obj3, Object obj4, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = obj;
        this.k = obj2;
        this.n = obj3;
        this.s = obj4;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) throws Throwable {
        int i = this.f;
        t70 t70Var = t70.a;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                ((aa) q((x50) obj2, (ua) obj)).s(q43Var);
                return t70Var;
            case 1:
                return ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
            case 2:
                return ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
            case 3:
                return ((aa) q((x50) obj2, (kk2) obj)).s(q43Var);
            case 4:
                return ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
            case 5:
                return ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
            case 6:
                ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
                return t70Var;
            case 7:
                return ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
            case 8:
                return ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
            case 9:
                return ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
            case 10:
                return ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
            case 11:
                return ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
            case 12:
                return ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
            case 13:
                return ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
            case 14:
                return ((aa) q((x50) obj2, (nm0) obj)).s(q43Var);
            case 15:
                return ((aa) q((x50) obj2, (nm0) obj)).s(q43Var);
            case 16:
                return ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
            default:
                return ((aa) q((x50) obj2, (s70) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.s;
        Object obj3 = this.n;
        switch (i) {
            case 0:
                aa aaVar = new aa((hq0) this.k, (ba) obj3, (pa1) obj2, x50Var, 0);
                aaVar.j = obj;
                return aaVar;
            case 1:
                return new aa(this.j, (bd) this.k, (mm1) obj3, (mm1) obj2, x50Var, 1);
            case 2:
                return new aa((j20) this.j, (ScrollCaptureSession) this.k, (Rect) obj3, (Consumer) obj2, x50Var, 2);
            case 3:
                aa aaVar2 = new aa((mm0) this.k, (jr2) obj3, (Float) obj2, x50Var, 3);
                aaVar2.j = obj;
                return aaVar2;
            case 4:
                return new aa((er2) this.j, (mm0) this.k, (jr2) obj3, (Float) obj2, x50Var, 4);
            case 5:
                return new aa((mt0) obj3, (x00) obj2, x50Var, 5);
            case 6:
                aa aaVar3 = new aa((mm1) obj3, (s01) obj2, x50Var, 6);
                aaVar3.j = obj;
                return aaVar3;
            case 7:
                return new aa((sx1) obj3, (vq0) obj2, x50Var, 7);
            case 8:
                return new aa((an1) obj3, (vq0) obj2, x50Var, 8);
            case 9:
                aa aaVar4 = new aa((qb1) this.k, (eb1) obj3, (vq0) obj2, x50Var, 9);
                aaVar4.j = obj;
                return aaVar4;
            case 10:
                aa aaVar5 = new aa((p42) obj3, (gu1) obj2, x50Var, 10);
                aaVar5.j = obj;
                return aaVar5;
            case 11:
                return new aa((xb2) obj3, (xj1) obj2, x50Var, 11);
            case 12:
                return new aa((vc2) this.j, (f5) this.k, (sv1) obj3, (fc2) obj2, x50Var, 12);
            case 13:
                aa aaVar6 = new aa((hq0) this.k, (AtomicReference) obj3, (vq0) obj2, x50Var, 13);
                aaVar6.j = obj;
                return aaVar6;
            case 14:
                aa aaVar7 = new aa((in2) obj3, (String) obj2, x50Var, 14);
                aaVar7.j = obj;
                return aaVar7;
            case 15:
                aa aaVar8 = new aa((in2) obj3, (Map) obj2, x50Var, 15);
                aaVar8.j = obj;
                return aaVar8;
            case 16:
                aa aaVar9 = new aa((ry1) this.k, (wq0) obj3, (v60) obj2, x50Var, 16);
                aaVar9.j = obj;
                return aaVar9;
            default:
                return new aa((String) this.j, (String) this.k, (bd3) obj3, (String) obj2, x50Var, 17);
        }
    }

    /* JADX WARN: Code duplicated, block: B:342:0x0635  */
    /* JADX WARN: Code duplicated, block: B:345:0x0641  */
    /* JADX WARN: Code duplicated, block: B:529:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:530:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v215 */
    /* JADX WARN: Type inference failed for: r0v216 */
    /* JADX WARN: Type inference failed for: r0v92, types: [vq0] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v33, types: [an1] */
    /* JADX WARN: Type inference failed for: r1v39, types: [an1] */
    /* JADX WARN: Type inference failed for: r1v64, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v68 */
    /* JADX WARN: Type inference failed for: r1v91 */
    /* JADX WARN: Type inference failed for: r1v92 */
    /* JADX WARN: Type inference failed for: r1v93 */
    /* JADX WARN: Type inference failed for: r1v95 */
    /* JADX WARN: Type inference failed for: r1v96 */
    /* JADX WARN: Type inference failed for: r2v51, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:344:0x063f -> B:348:0x0663). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:346:0x0660 -> B:348:0x0663). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.pk
    public final java.lang.Object s(java.lang.Object r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aa.s(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ aa(Object obj, Object obj2, Object obj3, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.k = obj;
        this.n = obj2;
        this.s = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ aa(Object obj, Object obj2, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.n = obj;
        this.s = obj2;
    }
}
