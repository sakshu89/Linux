package defpackage;

import android.view.MotionEvent;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class s24 {
    public static final py0 a;
    public static final py0 b;

    static {
        int i = 16;
        a = new py0(i, "NULL");
        b = new py0(i, "UNINITIALIZED");
    }

    public static final boolean a(gy1 gy1Var) {
        MotionEvent motionEventA;
        List list = gy1Var.a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((ny1) list.get(i)).i != 2) {
                MotionEvent motionEventA2 = gy1Var.a();
                if ((motionEventA2 == null || !motionEventA2.isFromSource(8194)) && ((motionEventA = gy1Var.a()) == null || !motionEventA.isFromSource(1048584))) {
                    return false;
                }
            }
        }
        return true;
    }
}
