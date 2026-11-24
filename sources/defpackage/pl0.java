package defpackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pl0 extends jl0 {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(Object obj, y50 y50Var) throws IllegalAccessException, IOException, InvocationTargetException {
        ol0 ol0Var;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (y50Var instanceof ol0) {
            ol0Var = (ol0) y50Var;
            int i = ol0Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                ol0Var.k = i - Integer.MIN_VALUE;
            } else {
                ol0Var = new ol0(this, y50Var);
            }
        } else {
            ol0Var = new ol0(this, y50Var);
        }
        Object obj2 = ol0Var.i;
        int i2 = ol0Var.k;
        q43 q43Var = q43.a;
        if (i2 == 0) {
            bz3.g(obj2);
            if (this.b.get()) {
                og.n("This scope has already been closed.");
                return null;
            }
            FileOutputStream fileOutputStream3 = new FileOutputStream(this.a);
            try {
                j43 j43Var = new j43(fileOutputStream3);
                ol0Var.e = fileOutputStream3;
                ol0Var.f = fileOutputStream3;
                ol0Var.k = 1;
                xy.t(obj, j43Var);
                t70 t70Var = t70.a;
                if (q43Var == t70Var) {
                    return t70Var;
                }
                fileOutputStream2 = fileOutputStream3;
                fileOutputStream = fileOutputStream2;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream3;
                throw th;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            fileOutputStream2 = ol0Var.f;
            fileOutputStream = ol0Var.e;
            try {
                bz3.g(obj2);
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    fi4.a(fileOutputStream, th);
                    throw th3;
                }
            }
        }
        fileOutputStream2.getFD().sync();
        fi4.a(fileOutputStream, null);
        return q43Var;
    }
}
