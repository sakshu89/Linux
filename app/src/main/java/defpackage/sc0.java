package defpackage;

import android.content.res.AssetManager;
import android.os.Build;
import android.view.ViewConfiguration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sc0 {
    public boolean a;
    public final Object b;
    public final Object c;
    public final Serializable d;
    public Object e;
    public final Object f;
    public Object g;
    public Object h;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public sc0(AssetManager assetManager, Executor executor, l12 l12Var, String str, File file) {
        ?? r1;
        this.a = false;
        this.b = executor;
        this.c = l12Var;
        this.g = str;
        this.f = file;
        int i = Build.VERSION.SDK_INT;
        if (i < 31) {
            switch (i) {
                case 26:
                    r1 = u34.d;
                    break;
                case 27:
                    r1 = u34.c;
                    break;
                case 28:
                case 29:
                case 30:
                    r1 = u34.b;
                    break;
                default:
                    r1 = 0;
                    break;
            }
        } else {
            r1 = u34.a;
        }
        this.d = r1;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    public static final Object a(sc0 sc0Var, he2 he2Var, vk1 vk1Var, float f, float f2, y50 y50Var) {
        wk1 wk1Var;
        q42 q42Var;
        float f3;
        he2 he2Var2;
        sc0Var.getClass();
        if (y50Var instanceof wk1) {
            wk1Var = (wk1) y50Var;
            int i = wk1Var.n;
            if ((i & Integer.MIN_VALUE) != 0) {
                wk1Var.n = i - Integer.MIN_VALUE;
            } else {
                wk1Var = new wk1(sc0Var, y50Var);
            }
        } else {
            wk1Var = new wk1(sc0Var, y50Var);
        }
        wk1 wk1Var2 = wk1Var;
        Object obj = wk1Var2.j;
        int i2 = wk1Var2.n;
        s70 s70Var = null;
        Object obj2 = q43.a;
        Object obj3 = t70.a;
        if (i2 == 0) {
            bz3.g(obj);
            t42 t42Var = new t42();
            t42Var.a = vk1Var;
            sc0Var.h(vk1Var);
            vk1 vk1VarG = g((un) sc0Var.f);
            if (vk1VarG != null) {
                sc0Var.h(vk1VarG);
                t42Var.a = ((vk1) t42Var.a).a(vk1VarG);
            }
            q42 q42Var2 = new q42();
            float fG = he2Var.g(he2Var.e(((vk1) t42Var.a).a));
            q42Var2.a = fG;
            if (!pr4.a(fG)) {
                t42 t42Var2 = new t42();
                t42Var2.a = ke4.a(0.0f, 30);
                xk1 xk1Var = new xk1(q42Var2, t42Var2, t42Var, f, sc0Var, f2, he2Var, null);
                wk1Var2.e = he2Var;
                wk1Var2.f = q42Var2;
                wk1Var2.i = f2;
                wk1Var2.n = 1;
                if (sc0Var.i(he2Var, xk1Var, wk1Var2) != obj3) {
                    q42Var = q42Var2;
                    f3 = f2;
                    he2Var2 = he2Var;
                }
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                bz3.g(obj);
                return obj2;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        f3 = wk1Var2.i;
        q42Var = wk1Var2.f;
        he2Var2 = wk1Var2.e;
        bz3.g(obj);
        q91 q91Var = (q91) sc0Var.h;
        long jA = se4.a(((z63) q91Var.b).b(Float.MAX_VALUE), ((z63) q91Var.c).b(Float.MAX_VALUE));
        if (jA == 0) {
            float fD = he2Var2.d(Math.signum(q42Var.a)) * Math.min(Math.abs(q42Var.a) / 100.0f, f3) * 1000.0f;
            if (fD == 0.0f) {
                jA = 0;
            } else {
                jA = he2Var2.d == js1.b ? se4.a(fD, 0.0f) : se4.a(0.0f, fD);
            }
        }
        long j = jA;
        v10 v10Var = (v10) sc0Var.d;
        x50 x50Var = null;
        wk1Var2.e = null;
        wk1Var2.f = null;
        wk1Var2.n = 2;
        ae2 ae2Var = (ae2) v10Var.a;
        s70 s70Var2 = (s70) ((fq0) ae2Var.t0.c).a();
        if (s70Var2 != null) {
            s70Var = s70Var2;
        } else {
            og.n("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        uf4.b(s70Var, null, new yd2(ae2Var, j, x50Var, 1), 3);
        return obj2 == obj3 ? obj3 : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public static final Object b(sc0 sc0Var, t42 t42Var, q42 q42Var, he2 he2Var, t42 t42Var2, long j, y50 y50Var) {
        yk1 yk1Var;
        q42 q42Var2;
        he2 he2Var2;
        t42 t42Var3;
        boolean z;
        if (y50Var instanceof yk1) {
            yk1Var = (yk1) y50Var;
            int i = yk1Var.s;
            if ((i & Integer.MIN_VALUE) != 0) {
                yk1Var.s = i - Integer.MIN_VALUE;
            } else {
                yk1Var = new yk1(y50Var);
            }
        } else {
            yk1Var = new yk1(y50Var);
        }
        Object objC = yk1Var.n;
        int i2 = yk1Var.s;
        x50 x50Var = null;
        if (i2 == 0) {
            bz3.g(objC);
            if (j < 0) {
                return Boolean.FALSE;
            }
            l2 l2Var = new l2(sc0Var, x50Var, 13);
            yk1Var.e = sc0Var;
            yk1Var.f = t42Var;
            yk1Var.i = q42Var;
            yk1Var.j = he2Var;
            yk1Var.k = t42Var2;
            yk1Var.s = 1;
            objC = xc4.c(j, l2Var, yk1Var);
            t70 t70Var = t70.a;
            if (objC == t70Var) {
                return t70Var;
            }
            q42Var2 = q42Var;
            he2Var2 = he2Var;
            t42Var3 = t42Var2;
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            t42 t42Var4 = yk1Var.k;
            he2 he2Var3 = yk1Var.j;
            q42Var2 = yk1Var.i;
            t42 t42Var5 = yk1Var.f;
            sc0 sc0Var2 = yk1Var.e;
            bz3.g(objC);
            t42Var3 = t42Var4;
            he2Var2 = he2Var3;
            t42Var = t42Var5;
            sc0Var = sc0Var2;
        }
        vk1 vk1Var = (vk1) objC;
        if (vk1Var != null) {
            boolean z2 = ((vk1) t42Var.a).c;
            long j2 = vk1Var.a;
            t42Var.a = new vk1(j2, vk1Var.b, z2);
            q42Var2.a = he2Var2.i(he2Var2.e(j2));
            t42Var3.a = ke4.a(0.0f, 30);
            sc0Var.h(vk1Var);
            z = !pr4.a(q42Var2.a);
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static vk1 g(un unVar) {
        vk1 vk1Var = null;
        yg2 yg2VarA = ah2.a(new rp0((Object) new kb(13, unVar), (x50) (0 == true ? 1 : 0), 2));
        while (yg2VarA.hasNext()) {
            vk1 vk1VarA = (vk1) yg2VarA.next();
            if (vk1Var != null) {
                vk1VarA = vk1Var.a(vk1VarA);
            }
            vk1Var = vk1VarA;
        }
        return vk1Var;
    }

    public float c(fe2 fe2Var, float f) {
        he2 he2Var = (he2) this.b;
        long jH = he2Var.h(he2Var.d(f));
        he2 he2Var2 = fe2Var.a;
        return he2Var.g(he2Var.e(he2Var2.c(he2Var2.k, jH, 1)));
    }

    public boolean d(gy1 gy1Var) {
        long j;
        q82 q82Var = (q82) this.c;
        jc0 jc0Var = (jc0) this.e;
        ViewConfiguration viewConfiguration = (ViewConfiguration) q82Var.a;
        int i = Build.VERSION.SDK_INT;
        float f = -(i > 26 ? viewConfiguration.getScaledVerticalScrollFactor() : jc0Var.x(64.0f));
        float f2 = -(i > 26 ? viewConfiguration.getScaledHorizontalScrollFactor() : jc0Var.x(64.0f));
        List list = gy1Var.a;
        jp1 jp1Var = new jp1(0L);
        int size = list.size();
        boolean zC = false;
        int i2 = 0;
        while (true) {
            j = jp1Var.a;
            if (i2 >= size) {
                break;
            }
            jp1Var = new jp1(jp1.e(j, ((ny1) list.get(i2)).j));
            i2++;
        }
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) * f2)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) * f)) & 4294967295L);
        he2 he2Var = (he2) this.b;
        float fI = he2Var.i(he2Var.e(jFloatToRawIntBits));
        if (fI != 0.0f) {
            be2 be2Var = he2Var.a;
            zC = fI > 0.0f ? be2Var.c() : be2Var.a();
        }
        return zC ? !(((un) this.f).s(new vk1(jFloatToRawIntBits, ((ny1) mz.x(gy1Var.a)).b, false)) instanceof lx) : this.a;
    }

    public FileInputStream e(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message == null) {
                return null;
            }
            message.contains("compressed");
            return null;
        }
    }

    public void f(int i, Serializable serializable) {
        ((Executor) this.b).execute(new gq(i, 6, this, serializable));
    }

    public void h(vk1 vk1Var) {
        q91 q91Var = (q91) this.h;
        long j = vk1Var.b;
        long j2 = vk1Var.a;
        ((z63) q91Var.b).a(Float.intBitsToFloat((int) (j2 >> 32)), j);
        ((z63) q91Var.c).a(Float.intBitsToFloat((int) (j2 & 4294967295L)), j);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object i(he2 he2Var, xk1 xk1Var, y50 y50Var) throws Throwable {
        zk1 zk1Var;
        if (y50Var instanceof zk1) {
            zk1Var = (zk1) y50Var;
            int i = zk1Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                zk1Var.i = i - Integer.MIN_VALUE;
            } else {
                zk1Var = new zk1(this, y50Var);
            }
        } else {
            zk1Var = new zk1(this, y50Var);
        }
        Object obj = zk1Var.e;
        int i2 = zk1Var.i;
        x50 x50Var = null;
        if (i2 == 0) {
            bz3.g(obj);
            this.a = true;
            p0 p0Var = new p0(he2Var, xk1Var, x50Var, 25);
            zk1Var.i = 1;
            et2 et2Var = new et2(zk1Var, zk1Var.f());
            Object objB = ee4.b(et2Var, true, et2Var, p0Var);
            t70 t70Var = t70.a;
            if (objB == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(obj);
        }
        this.a = false;
        return q43.a;
    }

    public sc0(he2 he2Var, q82 q82Var, v10 v10Var, jc0 jc0Var) {
        this.b = he2Var;
        this.c = q82Var;
        this.d = v10Var;
        this.e = jc0Var;
        this.f = nh4.a(Integer.MAX_VALUE, 6, null);
        this.h = new q91(8);
    }
}
