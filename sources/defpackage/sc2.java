package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.content.Intent;
import android.view.View;
import com.project.sonic.background.SonicVoiceService;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sc2 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public int i;
    public Object j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sc2(u93 u93Var, int i, String str, x50 x50Var) {
        super(2, x50Var);
        this.f = 15;
        this.j = u93Var;
        this.i = i;
        this.k = str;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) throws Throwable {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 1:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 2:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 3:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 4:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 5:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 6:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 7:
                return ((sc2) q((x50) obj2, (nm0) obj)).s(q43Var);
            case 8:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 9:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 10:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 11:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 12:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 13:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 14:
                return ((sc2) q((x50) obj2, obj)).s(q43Var);
            case 15:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 16:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
            case 17:
                ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
                return t70.a;
            default:
                return ((sc2) q((x50) obj2, (s70) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.k;
        switch (i) {
            case 0:
                return new sc2((AccessibilityService) this.j, (GestureDescription) obj2, x50Var, 0);
            case 1:
                return new sc2((ue0) this.j, (ae2) obj2, x50Var, 1);
            case 2:
                return new sc2((oj2) this.j, (String) obj2, x50Var, 2);
            case 3:
                return new sc2((oj2) this.j, (l82) obj2, x50Var, 3);
            case 4:
                return new sc2((oj2) this.j, (b60) obj2, x50Var, 4);
            case 5:
                return new sc2((sj2) this.j, (l61) obj2, x50Var, 5);
            case 6:
                return new sc2((p6) obj2, x50Var, 6);
            case 7:
                sc2 sc2Var = new sc2((in2) obj2, x50Var, 7);
                sc2Var.j = obj;
                return sc2Var;
            case 8:
                return new sc2((so2) this.j, (ho2) obj2, x50Var, 8);
            case 9:
                return new sc2((so2) this.j, (Map) obj2, x50Var, 9);
            case 10:
                return new sc2((Intent) this.j, (SonicVoiceService) obj2, x50Var, 10);
            case 11:
                return new sc2((ux) this.j, (pd) obj2, x50Var, 11);
            case 12:
                return new sc2((f41) this.j, (zz1) obj2, x50Var, 12);
            case 13:
                return new sc2((List) this.j, (ea1) obj2, x50Var, 13);
            case 14:
                sc2 sc2Var2 = new sc2((nm0) obj2, x50Var, 14);
                sc2Var2.j = obj;
                return sc2Var2;
            case 15:
                return new sc2((u93) this.j, this.i, (String) obj2, x50Var);
            case 16:
                return new sc2((f42) this.j, (View) obj2, x50Var, 16);
            case 17:
                return new sc2((hr2) this.j, (ok1) obj2, x50Var, 17);
            default:
                return new sc2((bd3) this.j, (lj1) obj2, x50Var, 18);
        }
    }

    /* JADX WARN: Code duplicated, block: B:220:0x041f A[PHI: r0 r1
      0x041f: PHI (r0v53 p0) = (r0v59 p0), (r0v66 p0) binds: [B:218:0x041c, B:214:0x03e3] A[DONT_GENERATE, DONT_INLINE]
      0x041f: PHI (r1v48 java.lang.Object) = (r1v51 java.lang.Object), (r1v52 java.lang.Object) binds: [B:218:0x041c, B:214:0x03e3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:248:0x0496  */
    /* JADX WARN: Code duplicated, block: B:250:0x049a  */
    /* JADX WARN: Code duplicated, block: B:251:0x049d  */
    /* JADX WARN: Code duplicated, block: B:321:0x05a4 A[Catch: we2 -> 0x0563, CancellationException -> 0x062c, TryCatch #4 {CancellationException -> 0x062c, we2 -> 0x0563, blocks: (B:300:0x055e, B:305:0x056c, B:324:0x05af, B:325:0x05b6, B:329:0x05c8, B:331:0x05fe, B:333:0x0604, B:336:0x0610, B:306:0x0570, B:321:0x05a4, B:307:0x0574, B:313:0x0585, B:315:0x058d, B:318:0x0599, B:310:0x057b), top: B:372:0x0552 }] */
    /* JADX WARN: Code duplicated, block: B:323:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:324:0x05af A[Catch: we2 -> 0x0563, CancellationException -> 0x062c, TryCatch #4 {CancellationException -> 0x062c, we2 -> 0x0563, blocks: (B:300:0x055e, B:305:0x056c, B:324:0x05af, B:325:0x05b6, B:329:0x05c8, B:331:0x05fe, B:333:0x0604, B:336:0x0610, B:306:0x0570, B:321:0x05a4, B:307:0x0574, B:313:0x0585, B:315:0x058d, B:318:0x0599, B:310:0x057b), top: B:372:0x0552 }] */
    /* JADX WARN: Code duplicated, block: B:327:0x05c3  */
    /* JADX WARN: Code duplicated, block: B:328:0x05c6  */
    /* JADX WARN: Code duplicated, block: B:333:0x0604 A[Catch: we2 -> 0x0563, CancellationException -> 0x062c, TryCatch #4 {CancellationException -> 0x062c, we2 -> 0x0563, blocks: (B:300:0x055e, B:305:0x056c, B:324:0x05af, B:325:0x05b6, B:329:0x05c8, B:331:0x05fe, B:333:0x0604, B:336:0x0610, B:306:0x0570, B:321:0x05a4, B:307:0x0574, B:313:0x0585, B:315:0x058d, B:318:0x0599, B:310:0x057b), top: B:372:0x0552 }] */
    /* JADX WARN: Code duplicated, block: B:336:0x0610 A[Catch: we2 -> 0x0563, CancellationException -> 0x062c, TRY_LEAVE, TryCatch #4 {CancellationException -> 0x062c, we2 -> 0x0563, blocks: (B:300:0x055e, B:305:0x056c, B:324:0x05af, B:325:0x05b6, B:329:0x05c8, B:331:0x05fe, B:333:0x0604, B:336:0x0610, B:306:0x0570, B:321:0x05a4, B:307:0x0574, B:313:0x0585, B:315:0x058d, B:318:0x0599, B:310:0x057b), top: B:372:0x0552 }] */
    /* JADX WARN: Code duplicated, block: B:416:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:417:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:423:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0427, code lost:
    
        if (r0.e(r1, r38) == r8) goto L222;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:221:0x0427 -> B:223:0x042b). Please report as a decompilation issue!!! */
    @Override // defpackage.pk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1780
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sc2.s(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sc2(Object obj, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.k = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sc2(Object obj, Object obj2, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = obj;
        this.k = obj2;
    }
}
