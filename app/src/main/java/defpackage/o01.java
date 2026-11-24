package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o01 implements GestureDetector.OnGestureListener {
    public final /* synthetic */ kk a;

    public o01(kk kkVar) {
        this.a = kkVar;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        kk kkVar = this.a;
        k7 k7Var = (k7) kkVar.d;
        if (!kkVar.c) {
            int i = kkVar.b;
            if (i == 1) {
                if (Math.abs(f) > Math.abs(f2)) {
                    ((do0) k7Var.c.getFocusOwner()).g(f > 0.0f ? 1 : 2, false);
                    return true;
                }
            } else if (i == 2 && Math.abs(f2) > Math.abs(f)) {
                ((do0) k7Var.c.getFocusOwner()).g(f2 > 0.0f ? 1 : 2, false);
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }
}
