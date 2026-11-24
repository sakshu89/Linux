package defpackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nl0 implements zy {
    public final File a;
    public final uk2 b;
    public final ta c;
    public final AtomicBoolean d;
    public final an1 e;

    public nl0(File file, uk2 uk2Var, ta taVar) {
        uk2Var.getClass();
        this.a = file;
        this.b = uk2Var;
        this.c = taVar;
        this.d = new AtomicBoolean(false);
        this.e = new an1();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0073  */
    /* JADX WARN: Code duplicated, block: B:53:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [j90] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final Object a(j90 j90Var, y50 y50Var) throws Throwable {
        ll0 ll0Var;
        Throwable th;
        jl0 jl0Var;
        nl0 nl0Var;
        boolean z;
        ?? r8;
        if (y50Var instanceof ll0) {
            ll0Var = (ll0) y50Var;
            int i = ll0Var.n;
            if ((i & Integer.MIN_VALUE) != 0) {
                ll0Var.n = i - Integer.MIN_VALUE;
            } else {
                ll0Var = new ll0(this, y50Var);
            }
        } else {
            ll0Var = new ll0(this, y50Var);
        }
        ?? r9 = ll0Var.j;
        int i2 = ll0Var.n;
        try {
            if (i2 == 0) {
                bz3.g(r9);
                if (this.d.get()) {
                    og.n("StorageConnection has already been disposed.");
                    return null;
                }
                boolean zF = this.e.f();
                jl0 jl0Var2 = new jl0(this.a);
                try {
                    Boolean boolValueOf = Boolean.valueOf(zF);
                    ll0Var.e = this;
                    ll0Var.f = jl0Var2;
                    ll0Var.i = zF;
                    ll0Var.n = 1;
                    Object objC = j90Var.c(jl0Var2, boolValueOf, ll0Var);
                    t70 t70Var = t70.a;
                    if (objC == t70Var) {
                        return t70Var;
                    }
                    nl0Var = this;
                    z = zF ? 1 : 0;
                    r8 = objC;
                    jl0Var = jl0Var2;
                    jl0Var.close();
                    th = null;
                    if (th != null) {
                        throw th;
                    }
                    if (z) {
                        nl0Var.e.h(null);
                    }
                    return r8;
                } catch (Throwable th2) {
                    th = th2;
                    jl0Var = jl0Var2;
                    r9 = zF;
                    jl0Var.close();
                    throw th;
                }
            }
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z = ll0Var.i;
            jl0Var = ll0Var.f;
            nl0Var = ll0Var.e;
            try {
                bz3.g(r9);
                r8 = r9;
                try {
                    jl0Var.close();
                    th = null;
                } catch (Throwable th3) {
                    th = th3;
                }
                if (th != null) {
                    if (z) {
                        nl0Var.e.h(null);
                    }
                    return r8;
                }
                try {
                    throw th;
                } catch (Throwable th4) {
                    th = th4;
                    r9 = z;
                    this = nl0Var;
                }
            } catch (Throwable th5) {
                r9 = z ? 1 : 0;
                this = nl0Var;
                th = th5;
                try {
                    jl0Var.close();
                    throw th;
                } catch (Throwable th6) {
                    gn4.a(th, th6);
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
        if (r9 != 0) {
            this.e.h(null);
        }
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00d8 A[Catch: all -> 0x0114, IOException -> 0x0116, TRY_ENTER, TryCatch #1 {all -> 0x0114, blocks: (B:43:0x00d8, B:45:0x00de, B:46:0x00e0, B:48:0x00f3, B:49:0x0113, B:56:0x011f, B:65:0x012e, B:67:0x0134, B:68:0x0137, B:63:0x012c, B:62:0x0129, B:33:0x009b, B:34:0x00b7), top: B:75:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00de A[Catch: all -> 0x0114, IOException -> 0x0116, TRY_LEAVE, TryCatch #1 {all -> 0x0114, blocks: (B:43:0x00d8, B:45:0x00de, B:46:0x00e0, B:48:0x00f3, B:49:0x0113, B:56:0x011f, B:65:0x012e, B:67:0x0134, B:68:0x0137, B:63:0x012c, B:62:0x0129, B:33:0x009b, B:34:0x00b7), top: B:75:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x011f A[Catch: all -> 0x0114, IOException -> 0x0116, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0114, blocks: (B:43:0x00d8, B:45:0x00de, B:46:0x00e0, B:48:0x00f3, B:49:0x0113, B:56:0x011f, B:65:0x012e, B:67:0x0134, B:68:0x0137, B:63:0x012c, B:62:0x0129, B:33:0x009b, B:34:0x00b7), top: B:75:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [an1, int] */
    public final Object b(v90 v90Var, y50 y50Var) {
        ml0 ml0Var;
        File file;
        an1 an1Var;
        vq0 vq0Var;
        pl0 pl0Var;
        Throwable th;
        pl0 pl0Var2;
        nl0 nl0Var;
        File file2;
        if (y50Var instanceof ml0) {
            ml0Var = (ml0) y50Var;
            int i = ml0Var.s;
            if ((i & Integer.MIN_VALUE) != 0) {
                ml0Var.s = i - Integer.MIN_VALUE;
            } else {
                ml0Var = new ml0(this, y50Var);
            }
        } else {
            ml0Var = new ml0(this, y50Var);
        }
        Object obj = ml0Var.k;
        ?? r2 = ml0Var.s;
        t70 t70Var = t70.a;
        try {
            try {
                try {
                    try {
                        if (r2 == 0) {
                            bz3.g(obj);
                            if (this.d.get()) {
                                og.n("StorageConnection has already been disposed.");
                                return null;
                            }
                            File file3 = this.a;
                            File parentFile = file3.getCanonicalFile().getParentFile();
                            if (parentFile != null) {
                                parentFile.mkdirs();
                                if (!parentFile.isDirectory()) {
                                    throw new IOException("Unable to create parent directories of " + file3);
                                }
                            }
                            ml0Var.e = this;
                            ml0Var.f = v90Var;
                            an1 an1Var2 = this.e;
                            ml0Var.i = an1Var2;
                            ml0Var.s = 1;
                            if (an1Var2.e(ml0Var) != t70Var) {
                                an1Var = an1Var2;
                                vq0Var = v90Var;
                            }
                            return t70Var;
                        }
                        if (r2 != 1) {
                            if (r2 != 2) {
                                og.n("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            pl0Var2 = ml0Var.j;
                            File file4 = (File) ml0Var.i;
                            an1Var = (an1) ml0Var.f;
                            nl0Var = ml0Var.e;
                            try {
                                bz3.g(obj);
                                file2 = file4;
                                try {
                                    pl0Var2.close();
                                    th = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                                if (th == null) {
                                    throw th;
                                }
                                if (file2.exists()) {
                                    try {
                                        Files.move(file2.toPath(), nl0Var.a.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                    } catch (IOException unused) {
                                        throw new IOException("Unable to rename " + file2 + " to " + nl0Var.a + ". This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
                                    }
                                }
                                an1Var.h(null);
                                return q43.a;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    pl0Var2.close();
                                } catch (Throwable th4) {
                                    gn4.a(th, th4);
                                }
                                throw th;
                            }
                        }
                        an1 an1Var3 = (an1) ml0Var.i;
                        vq0 vq0Var2 = (vq0) ml0Var.f;
                        nl0 nl0Var2 = ml0Var.e;
                        bz3.g(obj);
                        an1Var = an1Var3;
                        this = nl0Var2;
                        vq0Var = vq0Var2;
                        ml0Var.e = this;
                        ml0Var.f = an1Var;
                        ml0Var.i = file;
                        ml0Var.j = pl0Var;
                        ml0Var.s = 2;
                        if (vq0Var.e(pl0Var, ml0Var) != t70Var) {
                            nl0Var = this;
                            file2 = file;
                            pl0Var2 = pl0Var;
                            pl0Var2.close();
                            th = null;
                            if (th == null) {
                                throw th;
                            }
                            if (file2.exists()) {
                                Files.move(file2.toPath(), nl0Var.a.toPath(), StandardCopyOption.REPLACE_EXISTING);
                            }
                            an1Var.h(null);
                            return q43.a;
                        }
                        return t70Var;
                    } catch (Throwable th5) {
                        th = th5;
                        pl0Var2 = pl0Var;
                        pl0Var2.close();
                        throw th;
                    }
                    pl0Var = new pl0(file);
                } catch (IOException e) {
                    e = e;
                    if (file.exists()) {
                        file.delete();
                    }
                    throw e;
                }
                file = new File(this.a.getAbsolutePath() + ".tmp");
            } catch (Throwable th6) {
                r2.h(null);
                throw th6;
            }
        } catch (IOException e2) {
            e = e2;
            file = v90Var;
        }
    }

    @Override // defpackage.zy
    public final void close() {
        this.d.set(true);
        this.c.a();
    }
}
