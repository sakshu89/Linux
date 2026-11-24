package defpackage;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w7 extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ x7 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w7(x7 x7Var, int i) {
        super(1);
        this.b = i;
        this.c = x7Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.b;
        x7 x7Var = this.c;
        switch (i) {
            case 0:
                View view = x7Var.e;
                return Boolean.valueOf(view.getParent().requestSendAccessibilityEvent(view, (AccessibilityEvent) obj));
            default:
                jd2 jd2Var = (jd2) obj;
                if (jd2Var.b.contains(jd2Var)) {
                    lt1 snapshotObserver = x7Var.e.getSnapshotObserver();
                    snapshotObserver.a.c(jd2Var, x7Var.w0, new h7(1, jd2Var, x7Var));
                }
                return q43.a;
        }
    }
}
