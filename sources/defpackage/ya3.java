package defpackage;

import android.graphics.Rect;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ya3 extends db3 {
    public static Field d = null;
    public static boolean e = false;
    public static Constructor f = null;
    public static boolean g = false;
    public WindowInsets c;

    public ya3() {
        this.c = h();
    }

    private static WindowInsets h() {
        if (!e) {
            try {
                d = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException unused) {
            }
            e = true;
        }
        Field field = d;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException unused2) {
            }
        }
        if (!g) {
            try {
                f = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException unused3) {
            }
            g = true;
        }
        Constructor constructor = f;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException unused4) {
            }
        }
        return null;
    }

    @Override // defpackage.db3
    public pb3 b() {
        a();
        pb3 pb3VarB = pb3.b(this.c, null);
        q11[] q11VarArr = this.b;
        lb3 lb3Var = pb3VarB.a;
        lb3Var.p(q11VarArr);
        lb3Var.r(null);
        return pb3VarB;
    }

    @Override // defpackage.db3
    public void f(q11 q11Var) {
        WindowInsets windowInsets = this.c;
        if (windowInsets != null) {
            this.c = windowInsets.replaceSystemWindowInsets(q11Var.a, q11Var.b, q11Var.c, q11Var.d);
        }
    }

    public ya3(pb3 pb3Var) {
        super(pb3Var);
        this.c = pb3Var.a();
    }
}
