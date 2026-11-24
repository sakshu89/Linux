package defpackage;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i3 extends AccessibilityNodeProvider {
    public final l11 a;

    public i3(l11 l11Var) {
        this.a = l11Var;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        ((x7) this.a.c).b(i, new h3(accessibilityNodeInfo), str, bundle);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        h3 h3VarS = this.a.s(i);
        if (h3VarS == null) {
            return null;
        }
        return h3VarS.a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i) {
        this.a.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i) {
        h3 h3VarS;
        l11 l11Var = this.a;
        x7 x7Var = (x7) l11Var.c;
        if (i == 1) {
            int i2 = x7Var.v;
            h3VarS = i2 == Integer.MIN_VALUE ? null : l11Var.s(i2);
        } else if (i == 2) {
            h3VarS = l11Var.s(x7Var.u);
        } else {
            og.i(ky0.h(i, "Unknown focus type: "));
        }
        if (h3VarS == null) {
            return null;
        }
        return h3VarS.a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:143:0x0246  */
    /* JADX WARN: Code duplicated, block: B:18:0x0056  */
    /* JADX WARN: Code duplicated, block: B:20:0x005c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0060  */
    /* JADX WARN: Code duplicated, block: B:237:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:239:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:240:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:243:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:244:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:247:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:248:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:251:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:252:0x03da  */
    /* JADX WARN: Code duplicated, block: B:255:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:256:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:259:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:260:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:267:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:276:0x0405  */
    /* JADX WARN: Code duplicated, block: B:278:0x040d  */
    /* JADX WARN: Code duplicated, block: B:281:0x0418  */
    /* JADX WARN: Code duplicated, block: B:284:0x041d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:291:0x043e  */
    /* JADX WARN: Code duplicated, block: B:293:0x0457  */
    /* JADX WARN: Code duplicated, block: B:296:0x045c  */
    /* JADX WARN: Code duplicated, block: B:301:0x0476  */
    /* JADX WARN: Code duplicated, block: B:304:0x047f  */
    /* JADX WARN: Code duplicated, block: B:308:0x0486  */
    /* JADX WARN: Code duplicated, block: B:310:0x0490  */
    /* JADX WARN: Code duplicated, block: B:313:0x0495 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:351:0x0515  */
    /* JADX WARN: Code duplicated, block: B:354:0x051f  */
    /* JADX WARN: Code duplicated, block: B:357:0x0524 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:359:0x0528  */
    /* JADX WARN: Code duplicated, block: B:360:0x052d  */
    /* JADX WARN: Code duplicated, block: B:362:0x053b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:363:0x053d  */
    /* JADX WARN: Code duplicated, block: B:366:0x0544  */
    /* JADX WARN: Code duplicated, block: B:368:0x054c  */
    /* JADX WARN: Code duplicated, block: B:374:0x0569  */
    /* JADX WARN: Code duplicated, block: B:376:0x056d  */
    /* JADX WARN: Code duplicated, block: B:378:0x0575  */
    /* JADX WARN: Code duplicated, block: B:379:0x0577  */
    /* JADX WARN: Code duplicated, block: B:381:0x057b  */
    /* JADX WARN: Code duplicated, block: B:383:0x0581  */
    /* JADX WARN: Code duplicated, block: B:384:0x0583  */
    /* JADX WARN: Code duplicated, block: B:387:0x0588  */
    /* JADX WARN: Code duplicated, block: B:448:0x0676 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:449:0x0678  */
    /* JADX WARN: Code duplicated, block: B:451:0x0686  */
    /* JADX WARN: Code duplicated, block: B:452:0x0688  */
    /* JADX WARN: Code duplicated, block: B:456:0x068e  */
    /* JADX WARN: Code duplicated, block: B:458:0x0694  */
    /* JADX WARN: Code duplicated, block: B:461:0x06a2  */
    /* JADX WARN: Code duplicated, block: B:466:0x06b0  */
    /* JADX WARN: Code duplicated, block: B:478:0x06c7  */
    /* JADX WARN: Code duplicated, block: B:483:0x06de  */
    /* JADX WARN: Code duplicated, block: B:490:0x06f0  */
    /* JADX WARN: Code duplicated, block: B:492:0x06f4  */
    /* JADX WARN: Code duplicated, block: B:494:0x0706  */
    /* JADX WARN: Code duplicated, block: B:496:0x070a  */
    /* JADX WARN: Code duplicated, block: B:508:0x0776  */
    /* JADX WARN: Code duplicated, block: B:510:0x077c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:511:0x077e  */
    /* JADX WARN: Code duplicated, block: B:512:0x0780  */
    /* JADX WARN: Code duplicated, block: B:515:0x0787  */
    /* JADX WARN: Code duplicated, block: B:516:0x078c  */
    /* JADX WARN: Code duplicated, block: B:519:0x0794  */
    /* JADX WARN: Code duplicated, block: B:521:0x079c  */
    /* JADX WARN: Code duplicated, block: B:533:0x07bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:534:0x07bf  */
    /* JADX WARN: Code duplicated, block: B:535:0x07c1  */
    /* JADX WARN: Code duplicated, block: B:538:0x07c5  */
    /* JADX WARN: Code duplicated, block: B:539:0x07c7  */
    /* JADX WARN: Code duplicated, block: B:542:0x07dc  */
    /* JADX WARN: Code duplicated, block: B:544:0x07e3  */
    /* JADX WARN: Code duplicated, block: B:546:0x07f6  */
    /* JADX WARN: Code duplicated, block: B:554:0x0811  */
    /* JADX WARN: Code duplicated, block: B:6:0x0027  */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x02df, code lost:
    
        if (((java.lang.Boolean) r0.e(java.lang.Float.valueOf(r2), java.lang.Float.valueOf(r5))).booleanValue() == true) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:557:0x01b3, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:22:0x0060, please report this as an issue */
    /* JADX WARN: Switch 'out' block B:6:0x0027 for B:37:0x0082 already processed. Defaulting to fallback option. */
    /* JADX WARN: Switch 'out' block B:6:0x0027 for B:38:0x0085 already processed. Defaulting to fallback option. */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean performAction(int r19, int r20, android.os.Bundle r21) {
        /*
            Method dump skipped, instruction units count: 2160
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i3.performAction(int, int, android.os.Bundle):boolean");
    }
}
