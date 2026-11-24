package defpackage;

import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import android.util.Size;
import com.ibm.icu.impl.locale.LanguageTag;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yr implements tk0, q53 {
    public final /* synthetic */ int a;
    public final zl1 b;

    public yr(zl1 zl1Var, int i) {
        Object objF;
        Object objF2;
        this.a = i;
        Object objF3 = null;
        switch (i) {
            case 3:
                this.b = zl1Var;
                try {
                    objF = zl1Var.f(yv2.N);
                    break;
                } catch (IllegalArgumentException unused) {
                    objF = null;
                }
                Class cls = (Class) objF;
                if (cls != null && !cls.equals(g02.class)) {
                    dk0.j("Invalid target class configuration for ", this, ": ", cls);
                    throw null;
                }
                this.b.v(r53.W, t53.b);
                zl1 zl1Var2 = this.b;
                zl1Var2.v(yv2.N, g02.class);
                try {
                    objF3 = zl1Var2.f(yv2.M);
                    break;
                } catch (IllegalArgumentException unused2) {
                }
                if (objF3 == null) {
                    this.b.v(yv2.M, g02.class.getCanonicalName() + LanguageTag.SEP + UUID.randomUUID());
                }
                Object objF4 = -1;
                try {
                    objF4 = zl1Var.f(xy0.C);
                    break;
                } catch (IllegalArgumentException unused3) {
                }
                if (((Integer) objF4).intValue() == -1) {
                    zl1Var.v(xy0.C, 2);
                    return;
                }
                return;
            default:
                this.b = zl1Var;
                try {
                    objF2 = zl1Var.f(yv2.N);
                    break;
                } catch (IllegalArgumentException unused4) {
                    objF2 = null;
                }
                Class cls2 = (Class) objF2;
                if (cls2 != null && !cls2.equals(ry0.class)) {
                    dk0.j("Invalid target class configuration for ", this, ": ", cls2);
                    throw null;
                }
                this.b.v(r53.W, t53.a);
                zl1 zl1Var3 = this.b;
                zl1Var3.v(yv2.N, ry0.class);
                try {
                    objF3 = zl1Var3.f(yv2.M);
                    break;
                } catch (IllegalArgumentException unused5) {
                }
                if (objF3 == null) {
                    this.b.v(yv2.M, ry0.class.getCanonicalName() + LanguageTag.SEP + UUID.randomUUID());
                    return;
                }
                return;
        }
    }

    public static yr e(s30 s30Var) {
        yr yrVar = new yr(1);
        s30Var.c(new qq(2, yrVar, s30Var));
        return yrVar;
    }

    @Override // defpackage.tk0
    public final zl1 a() {
        switch (this.a) {
            case 0:
                throw null;
            case 1:
                throw null;
            case 2:
                return this.b;
            default:
                return this.b;
        }
    }

    @Override // defpackage.q53
    public r53 b() {
        int i = this.a;
        zl1 zl1Var = this.b;
        switch (i) {
            case 2:
                return new sy0(gs1.l(zl1Var));
            default:
                return new h02(gs1.l(zl1Var));
        }
    }

    public ry0 c() {
        Object objF;
        Object objF2;
        Object objF3;
        Object objF4;
        bi biVar = sy0.f;
        zl1 zl1Var = this.b;
        zl1Var.getClass();
        try {
            objF = zl1Var.f(biVar);
        } catch (IllegalArgumentException unused) {
            objF = null;
        }
        Integer num = (Integer) objF;
        if (num != null) {
            zl1Var.v(wy0.r, num);
        } else {
            oy0 oy0Var = ry0.z;
            try {
                objF2 = zl1Var.f(sy0.i);
            } catch (IllegalArgumentException unused2) {
                objF2 = null;
            }
            if (Objects.equals(objF2, 1)) {
                zl1Var.v(wy0.r, 4101);
                zl1Var.v(wy0.y, ig0.c);
            } else {
                zl1Var.v(wy0.r, 256);
            }
        }
        sy0 sy0Var = new sy0(gs1.l(zl1Var));
        xy0.s(sy0Var);
        ry0 ry0Var = new ry0(sy0Var);
        try {
            objF3 = zl1Var.f(xy0.D);
        } catch (IllegalArgumentException unused3) {
            objF3 = null;
        }
        Size size = (Size) objF3;
        if (size != null) {
            ry0Var.s = new Rational(size.getWidth(), size.getHeight());
        }
        bi biVar2 = v31.K;
        Object objB = xg4.b();
        try {
            objB = zl1Var.f(biVar2);
        } catch (IllegalArgumentException unused4) {
        }
        hh1.d((Executor) objB, "The IO executor can't be null");
        bi biVar3 = sy0.c;
        if (zl1Var.a.containsKey(biVar3)) {
            Integer num2 = (Integer) zl1Var.f(biVar3);
            if (num2 == null || !(num2.intValue() == 0 || num2.intValue() == 1 || num2.intValue() == 3 || num2.intValue() == 2)) {
                dk0.y(num2, "The flash mode is not allowed to set: ");
                return null;
            }
            if (num2.intValue() == 3) {
                try {
                    objF4 = zl1Var.f(sy0.t);
                } catch (IllegalArgumentException unused5) {
                    objF4 = null;
                }
                if (objF4 == null) {
                    og.i("The flash mode is not allowed to set to FLASH_MODE_SCREEN without setting ScreenFlash");
                    return null;
                }
            }
        }
        return ry0Var;
    }

    public q82 d() {
        return new q82(gs1.l(this.b));
    }

    public void f(CaptureRequest.Key key, Object obj) {
        this.b.u(zr.M(key), r30.b, obj);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public yr(int i) {
        this(zl1.m(), 3);
        this.a = i;
        switch (i) {
            case 1:
                this.b = zl1.m();
                break;
            case 2:
                this(zl1.m(), 2);
                break;
            case 3:
                break;
            default:
                this.b = zl1.m();
                break;
        }
    }
}
