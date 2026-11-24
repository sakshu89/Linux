package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class eb3 extends lb3 {
    public static boolean i = false;
    public static Method j;
    public static Class k;
    public static Field l;
    public static Field m;
    public final WindowInsets c;
    public q11[] d;
    public q11 e;
    public pb3 f;
    public q11 g;
    public int h;

    public eb3(pb3 pb3Var, WindowInsets windowInsets) {
        super(pb3Var);
        this.e = null;
        this.c = windowInsets;
    }

    public static boolean A(int i2, int i3) {
        return (i2 & 6) == (i3 & 6);
    }

    private q11 t(int i2, boolean z) {
        q11 q11VarA = q11.e;
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i2 & i3) != 0) {
                q11VarA = q11.a(q11VarA, u(i3, z));
            }
        }
        return q11VarA;
    }

    private q11 v() {
        pb3 pb3Var = this.f;
        return pb3Var != null ? pb3Var.a.i() : q11.e;
    }

    private q11 w(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            dk0.r("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            return null;
        }
        if (!i) {
            y();
        }
        Method method = j;
        if (method != null && k != null && l != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) l.get(m.get(objInvoke));
                if (rect != null) {
                    return q11.b(rect.left, rect.top, rect.right, rect.bottom);
                }
                return null;
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
        }
        return null;
    }

    private static void y() {
        try {
            j = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            k = cls;
            l = cls.getDeclaredField("mVisibleInsets");
            m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            l.setAccessible(true);
            m.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
        }
        i = true;
    }

    @Override // defpackage.lb3
    public void d(View view) {
        q11 q11VarW = w(view);
        if (q11VarW == null) {
            q11VarW = q11.e;
        }
        z(q11VarW);
    }

    @Override // defpackage.lb3
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        eb3 eb3Var = (eb3) obj;
        return Objects.equals(this.g, eb3Var.g) && A(this.h, eb3Var.h);
    }

    @Override // defpackage.lb3
    public q11 f(int i2) {
        return t(i2, false);
    }

    @Override // defpackage.lb3
    public q11 g(int i2) {
        return t(i2, true);
    }

    @Override // defpackage.lb3
    public final q11 k() {
        if (this.e == null) {
            WindowInsets windowInsets = this.c;
            this.e = q11.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.e;
    }

    @Override // defpackage.lb3
    public boolean n() {
        return this.c.isRound();
    }

    @Override // defpackage.lb3
    public boolean o(int i2) {
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i2 & i3) != 0 && !x(i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.lb3
    public void p(q11[] q11VarArr) {
        this.d = q11VarArr;
    }

    @Override // defpackage.lb3
    public void q(pb3 pb3Var) {
        this.f = pb3Var;
    }

    @Override // defpackage.lb3
    public void s(int i2) {
        this.h = i2;
    }

    public q11 u(int i2, boolean z) {
        q11 q11VarI;
        int i3;
        q11 q11Var = q11.e;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 8) {
                    q11[] q11VarArr = this.d;
                    q11VarI = q11VarArr != null ? q11VarArr[qf4.b(8)] : null;
                    if (q11VarI != null) {
                        return q11VarI;
                    }
                    q11 q11VarK = k();
                    q11 q11VarV = v();
                    int i4 = q11VarK.d;
                    if (i4 > q11VarV.d) {
                        return q11.b(0, 0, 0, i4);
                    }
                    q11 q11Var2 = this.g;
                    if (q11Var2 != null && !q11Var2.equals(q11Var) && (i3 = this.g.d) > q11VarV.d) {
                        return q11.b(0, 0, 0, i3);
                    }
                } else {
                    if (i2 == 16) {
                        return j();
                    }
                    if (i2 == 32) {
                        return h();
                    }
                    if (i2 == 64) {
                        return l();
                    }
                    if (i2 == 128) {
                        pb3 pb3Var = this.f;
                        md0 md0VarE = pb3Var != null ? pb3Var.a.e() : e();
                        if (md0VarE != null) {
                            int i5 = Build.VERSION.SDK_INT;
                            return q11.b(i5 >= 28 ? p50.h(md0VarE.a) : 0, i5 >= 28 ? p50.j(md0VarE.a) : 0, i5 >= 28 ? p50.i(md0VarE.a) : 0, i5 >= 28 ? p50.g(md0VarE.a) : 0);
                        }
                    }
                }
            } else {
                if (z) {
                    q11 q11VarV2 = v();
                    q11 q11VarI2 = i();
                    return q11.b(Math.max(q11VarV2.a, q11VarI2.a), 0, Math.max(q11VarV2.c, q11VarI2.c), Math.max(q11VarV2.d, q11VarI2.d));
                }
                if ((this.h & 2) == 0) {
                    q11 q11VarK2 = k();
                    pb3 pb3Var2 = this.f;
                    q11VarI = pb3Var2 != null ? pb3Var2.a.i() : null;
                    int iMin = q11VarK2.d;
                    if (q11VarI != null) {
                        iMin = Math.min(iMin, q11VarI.d);
                    }
                    return q11.b(q11VarK2.a, 0, q11VarK2.c, iMin);
                }
            }
        } else {
            if (z) {
                return q11.b(0, Math.max(v().b, k().b), 0, 0);
            }
            if ((this.h & 4) == 0) {
                return q11.b(0, k().b, 0, 0);
            }
        }
        return q11Var;
    }

    public boolean x(int i2) {
        if (i2 != 1 && i2 != 2) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 8 && i2 != 128) {
                return true;
            }
        }
        return !u(i2, false).equals(q11.e);
    }

    public void z(q11 q11Var) {
        this.g = q11Var;
    }
}
