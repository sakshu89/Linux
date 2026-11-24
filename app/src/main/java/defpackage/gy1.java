package defpackage;

import android.os.Build;
import android.view.MotionEvent;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gy1 {
    public final List a;
    public final l11 b;
    public final int c;
    public final int d;
    public final int e;
    public int f;

    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    public gy1(List list, l11 l11Var) {
        MotionEvent motionEventA;
        this.a = list;
        this.b = l11Var;
        int i = 0;
        this.c = (Build.VERSION.SDK_INT < 29 || (motionEventA = a()) == null) ? 0 : motionEventA.getClassification();
        MotionEvent motionEventA2 = a();
        this.d = motionEventA2 != null ? motionEventA2.getButtonState() : 0;
        MotionEvent motionEventA3 = a();
        this.e = motionEventA3 != null ? motionEventA3.getMetaState() : 0;
        MotionEvent motionEventA4 = a();
        if (motionEventA4 != null) {
            int actionMasked = motionEventA4.getActionMasked();
            if (actionMasked == 0) {
                i = 1;
            } else if (actionMasked == 1) {
                i = 2;
            } else if (actionMasked != 2) {
                switch (actionMasked) {
                    case 5:
                        i = 1;
                        break;
                    case 6:
                        i = 2;
                        break;
                    case 7:
                        i = 3;
                        break;
                    case 8:
                        i = 6;
                        break;
                    case 9:
                        i = 4;
                        break;
                    case 10:
                        i = 5;
                        break;
                }
            } else {
                i = 3;
            }
        } else {
            int size = list.size();
            while (true) {
                if (i < size) {
                    ny1 ny1Var = (ny1) list.get(i);
                    if (y11.d(ny1Var)) {
                        i = 2;
                    } else if (y11.b(ny1Var)) {
                        i = 1;
                    } else {
                        i++;
                    }
                } else {
                    i = 3;
                }
            }
        }
        this.f = i;
    }

    public final MotionEvent a() {
        l11 l11Var = this.b;
        if (l11Var != null) {
            return (MotionEvent) ((q91) l11Var.c).c;
        }
        return null;
    }
}
