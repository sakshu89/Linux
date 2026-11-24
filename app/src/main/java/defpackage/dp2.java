package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.project.sonic.R;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dp2 {
    public static final long a = ki4.c(4287877119L);

    public static final void a(ek1 ek1Var, x20 x20Var, int i) {
        x20Var.X(-960200219);
        if (x20Var.O(i & 1, (i & 19) != 18)) {
            Resources resources = ((Context) x20Var.j(AndroidCompositionLocals_androidKt.b)).getResources();
            boolean zF = x20Var.f(resources);
            Object objL = x20Var.L();
            Object obj = r20.a;
            if (zF || objL == obj) {
                objL = BitmapFactory.decodeResource(resources, R.drawable.sonic_mountains);
                x20Var.g0(objL);
            }
            Object obj2 = (Bitmap) objL;
            boolean zF2 = x20Var.f(resources);
            Object objL2 = x20Var.L();
            if (zF2 || objL2 == obj) {
                objL2 = BitmapFactory.decodeResource(resources, R.drawable.sonic_water);
                x20Var.g0(objL2);
            }
            Object obj3 = (Bitmap) objL2;
            Object objA = sz3.a(x20Var);
            Object objL3 = x20Var.L();
            if (objL3 == obj) {
                objL3 = new ar2();
                x20Var.g0(objL3);
            }
            Object obj4 = (ar2) objL3;
            Object objL4 = x20Var.L();
            if (objL4 == obj) {
                objL4 = new Paint(3);
                x20Var.g0(objL4);
            }
            Object obj5 = (Paint) objL4;
            boolean zH = x20Var.h(obj2) | x20Var.f(objA) | x20Var.h(obj4) | x20Var.h(obj5) | x20Var.h(obj3);
            Object objL5 = x20Var.L();
            if (zH || objL5 == obj) {
                Object w9Var = new w9(obj2, objA, obj4, obj5, obj3, 3);
                x20Var.g0(w9Var);
                objL5 = w9Var;
            }
            gm.a(az3.b(ek1Var, (hq0) objL5), x20Var, 0);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ha(ek1Var, i, 14);
        }
    }
}
