package defpackage;

import android.os.SystemClock;
import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n7 extends k61 implements fq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ r7 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n7(r7 r7Var, int i) {
        super(0);
        this.b = i;
        this.c = r7Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int actionMasked;
        int i = this.b;
        r7 r7Var = this.c;
        switch (i) {
            case 0:
                MotionEvent motionEvent = r7Var.c1;
                if (motionEvent != null && ((actionMasked = motionEvent.getActionMasked()) == 7 || actionMasked == 9)) {
                    r7Var.d1 = SystemClock.uptimeMillis();
                    r7Var.post(r7Var.i1);
                }
                return q43.a;
            default:
                return r7Var.get_viewTreeOwners();
        }
    }
}
