package defpackage;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class jl0 implements zy {
    public final File a;
    public final AtomicBoolean b = new AtomicBoolean(false);

    public jl0(File file) {
        this.a = file;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9, types: [jl0] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, jl0] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [jl0] */
    public static Object a(jl0 jl0Var, y50 y50Var) throws IllegalAccessException, IOException, InvocationTargetException {
        il0 il0Var;
        FileInputStream fileInputStream;
        Throwable th;
        Closeable closeable;
        dm1 dm1VarS;
        FileInputStream fileInputStream2;
        Throwable th2;
        if (y50Var instanceof il0) {
            il0Var = (il0) y50Var;
            int i = il0Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                il0Var.k = i - Integer.MIN_VALUE;
            } else {
                il0Var = new il0(jl0Var, y50Var);
            }
        } else {
            il0Var = new il0(jl0Var, y50Var);
        }
        Object obj = il0Var.i;
        var r1 = il0Var.k;
        boolean z = true;
        t70 t70Var = t70.a;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    fileInputStream2 = il0Var.f;
                    r1 = (jl0) il0Var.e;
                    try {
                        bz3.g(obj);
                        fi4.a(fileInputStream2, null);
                        return obj;
                    } catch (Throwable th3) {
                        th2 = th3;
                        try {
                            throw th2;
                        } catch (Throwable th4) {
                            fi4.a(fileInputStream2, th2);
                            throw th4;
                        }
                    }
                }
                if (r1 != 2) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                closeable = (Closeable) il0Var.e;
                try {
                    bz3.g(obj);
                    fi4.a(closeable, null);
                    return obj;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        throw th;
                    } catch (Throwable th6) {
                        fi4.a(closeable, th);
                        throw th6;
                    }
                }
            }
            bz3.g(obj);
            if (jl0Var.b.get()) {
                og.n("This scope has already been closed.");
                return null;
            }
            try {
                FileInputStream fileInputStream3 = new FileInputStream(jl0Var.a);
                try {
                    il0Var.e = jl0Var;
                    il0Var.f = fileInputStream3;
                    il0Var.k = 1;
                    dm1 dm1VarS2 = xy.s(fileInputStream3);
                    if (dm1VarS2 != t70Var) {
                        fileInputStream2 = fileInputStream3;
                        obj = dm1VarS2;
                        fi4.a(fileInputStream2, null);
                        return obj;
                    }
                    return t70Var;
                } catch (Throwable th7) {
                    r1 = jl0Var;
                    fileInputStream2 = fileInputStream3;
                    th2 = th7;
                    throw th2;
                }
            } catch (FileNotFoundException unused) {
                if (jl0Var.a.exists()) {
                    return new dm1(z);
                }
                fileInputStream = new FileInputStream(jl0Var.a);
                try {
                    il0Var.e = fileInputStream;
                    il0Var.f = null;
                    il0Var.k = 2;
                    dm1VarS = xy.s(fileInputStream);
                    if (dm1VarS != t70Var) {
                        obj = dm1VarS;
                        closeable = fileInputStream;
                        fi4.a(closeable, null);
                        return obj;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    closeable = fileInputStream;
                    throw th;
                }
            }
        } catch (FileNotFoundException unused2) {
            jl0Var = r1;
            if (jl0Var.a.exists()) {
                return new dm1(z);
            }
            fileInputStream = new FileInputStream(jl0Var.a);
            il0Var.e = fileInputStream;
            il0Var.f = null;
            il0Var.k = 2;
            dm1VarS = xy.s(fileInputStream);
            if (dm1VarS != t70Var) {
                obj = dm1VarS;
                closeable = fileInputStream;
                fi4.a(closeable, null);
                return obj;
            }
            return t70Var;
        }
    }

    @Override // defpackage.zy
    public final void close() {
        this.b.set(true);
    }
}
