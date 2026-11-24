package defpackage;

import android.view.View;
import com.project.sonic.R;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class g31 {
    public static final float[] a = new float[91];

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int b(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int c(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static final uy1 d(View view) {
        uy1 uy1Var = (uy1) view.getTag(R.id.pooling_container_listener_holder_tag);
        if (uy1Var != null) {
            return uy1Var;
        }
        uy1 uy1Var2 = new uy1();
        view.setTag(R.id.pooling_container_listener_holder_tag, uy1Var2);
        return uy1Var2;
    }

    public static void e(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
    }

    public static void f(String str) {
        b10 b10Var = new b10(cq.v("lateinit property ", str, " has not been initialized"));
        e(b10Var, g31.class.getName());
        throw b10Var;
    }
}
