package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class q34 {
    public static final qs4 a = new qs4(16);
    public static final /* synthetic */ int b = 0;

    public static void a(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0162 A[Catch: all -> 0x015f, TRY_ENTER, TryCatch #38 {all -> 0x015f, blocks: (B:88:0x013e, B:90:0x014a, B:101:0x0162, B:102:0x0167), top: B:286:0x013e }] */
    /* JADX WARN: Code duplicated, block: B:108:0x0171 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x0173 A[Catch: IllegalStateException -> 0x0159, IOException -> 0x015b, FileNotFoundException -> 0x015d, TRY_LEAVE, TryCatch #33 {FileNotFoundException -> 0x015d, IOException -> 0x015b, IllegalStateException -> 0x0159, blocks: (B:86:0x0136, B:91:0x0154, B:109:0x0173, B:107:0x0170, B:106:0x016d), top: B:293:0x0136 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x0189  */
    /* JADX WARN: Code duplicated, block: B:126:0x01b3 A[Catch: all -> 0x01c1, TRY_LEAVE, TryCatch #22 {all -> 0x01c1, blocks: (B:124:0x01a7, B:126:0x01b3, B:135:0x01c4), top: B:272:0x01a7, outer: #37 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x01c4 A[Catch: all -> 0x01c1, TRY_ENTER, TRY_LEAVE, TryCatch #22 {all -> 0x01c1, blocks: (B:124:0x01a7, B:126:0x01b3, B:135:0x01c4), top: B:272:0x01a7, outer: #37 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:150:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:151:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:160:0x0211 A[Catch: all -> 0x024f, TryCatch #32 {all -> 0x024f, blocks: (B:158:0x020b, B:160:0x0211, B:161:0x0215, B:163:0x021b), top: B:278:0x020b }] */
    /* JADX WARN: Code duplicated, block: B:163:0x021b A[Catch: all -> 0x024f, TRY_LEAVE, TryCatch #32 {all -> 0x024f, blocks: (B:158:0x020b, B:160:0x0211, B:161:0x0215, B:163:0x021b), top: B:278:0x020b }] */
    /* JADX WARN: Code duplicated, block: B:229:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:233:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:240:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:278:0x020b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:286:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:0x01f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:288:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:290:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:294:0x0220 A[EDGE_INSN: B:294:0x0220->B:165:0x0220 BREAK  A[LOOP:0: B:161:0x0215->B:295:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00eb A[Catch: all -> 0x0100, IllegalStateException -> 0x0103, IOException -> 0x0105, TRY_LEAVE, TryCatch #35 {IOException -> 0x0105, IllegalStateException -> 0x0103, blocks: (B:53:0x00e1, B:55:0x00eb, B:66:0x0107, B:67:0x010c), top: B:290:0x00e1, outer: #20 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0107 A[Catch: all -> 0x0100, IllegalStateException -> 0x0103, IOException -> 0x0105, TRY_ENTER, TryCatch #35 {IOException -> 0x0105, IllegalStateException -> 0x0103, blocks: (B:53:0x00e1, B:55:0x00eb, B:66:0x0107, B:67:0x010c), top: B:290:0x00e1, outer: #20 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x014a A[Catch: all -> 0x015f, TRY_LEAVE, TryCatch #38 {all -> 0x015f, blocks: (B:88:0x013e, B:90:0x014a, B:101:0x0162, B:102:0x0167), top: B:286:0x013e }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v25, types: [int] */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r7v44 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v47 */
    /* JADX WARN: Type inference failed for: r7v48 */
    /* JADX WARN: Type inference failed for: r7v49 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v52 */
    /* JADX WARN: Type inference failed for: r7v53 */
    /* JADX WARN: Type inference failed for: r7v54 */
    /* JADX WARN: Type inference failed for: r7v55 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v16 */
    public static void b(Context context, Executor executor, l12 l12Var, boolean z) {
        boolean z2;
        ?? E;
        byte[] bArr;
        xc0[] xc0VarArrG;
        xc0[] xc0VarArr;
        l12 l12Var2;
        xc0[] xc0VarArr2;
        byte[] bArr2;
        ?? r7;
        byte[] bArr3;
        ?? r8;
        boolean z3;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        Throwable th2;
        FileChannel channel;
        FileLock fileLockTryLock;
        byte[] bArr4;
        int i;
        ?? r9;
        boolean z4;
        ?? byteArrayOutputStream;
        ?? r10;
        sc0 sc0Var;
        ?? r11;
        String str;
        FileInputStream fileInputStreamE;
        ?? r12;
        ?? r13;
        boolean z5;
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z) {
                File file = new File(filesDir, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
                if (file.exists()) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                        try {
                            long j = dataInputStream.readLong();
                            dataInputStream.close();
                            z5 = j == packageInfo.lastUpdateTime;
                            if (z5) {
                                l12Var.f(2, null);
                            }
                        } catch (Throwable th3) {
                            try {
                                dataInputStream.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                        }
                    } catch (IOException unused) {
                        z5 = false;
                    }
                } else {
                    z5 = false;
                }
                if (z5) {
                    context.getPackageName();
                    p12.c(context, false);
                    return;
                }
            }
            context.getPackageName();
            File file2 = new File(new File("/data/misc/profiles/cur/0", packageName), "primary.prof");
            sc0 sc0Var2 = new sc0(assets, executor, l12Var, name, file2);
            byte[] bArr5 = (byte[]) sc0Var2.d;
            if (bArr5 != null) {
                if (!file2.exists()) {
                    try {
                        if (file2.createNewFile()) {
                            sc0Var2.a = true;
                            E = sc0Var2.e(assets, "dexopt/baseline.prof");
                            bArr = s34.a;
                            if (E != 0) {
                                if (Arrays.equals(bArr, en4.b(E, 4))) {
                                    throw new IllegalStateException("Invalid magic");
                                }
                                xc0VarArrG = s34.g(E, en4.b(E, 4), (String) sc0Var2.g);
                                E.close();
                                sc0Var2.h = xc0VarArrG;
                            }
                            xc0VarArr = (xc0[]) sc0Var2.h;
                            if (xc0VarArr != null) {
                                str = "dexopt/baseline.profm";
                                fileInputStreamE = sc0Var2.e(assets, "dexopt/baseline.profm");
                                r11 = str;
                                if (fileInputStreamE == null) {
                                    if (fileInputStreamE != null) {
                                        fileInputStreamE.close();
                                        r11 = str;
                                    }
                                    sc0Var = null;
                                    E = r11;
                                } else {
                                    if (Arrays.equals(s34.b, en4.b(fileInputStreamE, 4))) {
                                        throw new IllegalStateException("Invalid magic");
                                    }
                                    byte[] bArrB = en4.b(fileInputStreamE, 4);
                                    sc0Var2.h = s34.d(fileInputStreamE, bArrB, bArr5, xc0VarArr);
                                    fileInputStreamE.close();
                                    sc0Var = sc0Var2;
                                    E = bArrB;
                                }
                                if (sc0Var != null) {
                                    sc0Var2 = sc0Var;
                                }
                            }
                            l12Var2 = (l12) sc0Var2.c;
                            xc0VarArr2 = (xc0[]) sc0Var2.h;
                            bArr2 = (byte[]) sc0Var2.d;
                            r7 = E;
                            r7 = E;
                            if (xc0VarArr2 != null) {
                                byteArrayOutputStream = sc0Var2.a;
                                if (byteArrayOutputStream != 0) {
                                    og.n("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                    return;
                                }
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                byteArrayOutputStream.write(bArr);
                                byteArrayOutputStream.write(bArr2);
                                if (s34.i(byteArrayOutputStream, bArr2, xc0VarArr2)) {
                                    sc0Var2.e = byteArrayOutputStream.toByteArray();
                                    byteArrayOutputStream.close();
                                    r10 = byteArrayOutputStream;
                                    sc0Var2.h = null;
                                    r7 = r10;
                                } else {
                                    l12Var2.f(5, null);
                                    sc0Var2.h = null;
                                    byteArrayOutputStream.close();
                                    r7 = byteArrayOutputStream;
                                }
                            }
                            bArr3 = (byte[]) sc0Var2.e;
                            if (bArr3 != null) {
                                if (sc0Var2.a) {
                                    og.n("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                    return;
                                }
                                byteArrayInputStream = new ByteArrayInputStream(bArr3);
                                fileOutputStream = new FileOutputStream((File) sc0Var2.f);
                                channel = fileOutputStream.getChannel();
                                fileLockTryLock = channel.tryLock();
                                if (fileLockTryLock != null) {
                                    if (fileLockTryLock.isValid()) {
                                        bArr4 = new byte[512];
                                        while (true) {
                                            i = byteArrayInputStream.read(bArr4);
                                            if (i > 0) {
                                                break;
                                                break;
                                            }
                                            fileOutputStream.write(bArr4, 0, i);
                                        }
                                        r9 = 1;
                                        sc0Var2.f(1, null);
                                        fileLockTryLock.close();
                                        channel.close();
                                        fileOutputStream.close();
                                        byteArrayInputStream.close();
                                        sc0Var2.e = null;
                                        sc0Var2.h = null;
                                        z3 = true;
                                    }
                                }
                                throw new IOException("Unable to acquire a lock on the underlying file channel.");
                            }
                            z3 = false;
                            r9 = 1;
                            if (z3) {
                                a(packageInfo, filesDir);
                            }
                            z4 = z3;
                            r12 = r9;
                        } else {
                            sc0Var2.f(4, null);
                        }
                    } catch (IOException unused2) {
                        z2 = true;
                        sc0Var2.f(4, null);
                    }
                } else if (file2.canWrite()) {
                    sc0Var2.a = true;
                    try {
                        E = sc0Var2.e(assets, "dexopt/baseline.prof");
                    } catch (FileNotFoundException e) {
                        l12Var.f(6, e);
                        E = 0;
                    } catch (IOException e2) {
                        l12Var.f(7, e2);
                        E = 0;
                    }
                    bArr = s34.a;
                    try {
                        if (E != 0) {
                            try {
                                if (Arrays.equals(bArr, en4.b(E, 4))) {
                                    throw new IllegalStateException("Invalid magic");
                                }
                                xc0VarArrG = s34.g(E, en4.b(E, 4), (String) sc0Var2.g);
                                try {
                                    E.close();
                                } catch (IOException e3) {
                                    l12Var.f(7, e3);
                                }
                                sc0Var2.h = xc0VarArrG;
                            } catch (IOException e4) {
                                l12Var.f(7, e4);
                                try {
                                    E.close();
                                } catch (IOException e5) {
                                    l12Var.f(7, e5);
                                }
                                xc0VarArrG = null;
                            } catch (IllegalStateException e6) {
                                l12Var.f(8, e6);
                                E.close();
                                xc0VarArrG = null;
                            }
                        }
                        xc0VarArr = (xc0[]) sc0Var2.h;
                        if (xc0VarArr != null && (E = Build.VERSION.SDK_INT) >= 31) {
                            try {
                                str = "dexopt/baseline.profm";
                                fileInputStreamE = sc0Var2.e(assets, "dexopt/baseline.profm");
                                r11 = str;
                                if (fileInputStreamE == null) {
                                    try {
                                        if (Arrays.equals(s34.b, en4.b(fileInputStreamE, 4))) {
                                            throw new IllegalStateException("Invalid magic");
                                        }
                                        byte[] bArrB2 = en4.b(fileInputStreamE, 4);
                                        sc0Var2.h = s34.d(fileInputStreamE, bArrB2, bArr5, xc0VarArr);
                                        fileInputStreamE.close();
                                        sc0Var = sc0Var2;
                                        E = bArrB2;
                                    } catch (Throwable th5) {
                                        try {
                                            fileInputStreamE.close();
                                            throw th5;
                                        } catch (Throwable th6) {
                                            th5.addSuppressed(th6);
                                            throw th5;
                                        }
                                    }
                                } else {
                                    if (fileInputStreamE != null) {
                                        fileInputStreamE.close();
                                        r11 = str;
                                    }
                                    sc0Var = null;
                                    E = r11;
                                }
                            } catch (FileNotFoundException e7) {
                                l12Var.f(9, e7);
                                r11 = E;
                            } catch (IOException e8) {
                                l12Var.f(7, e8);
                                r11 = E;
                            } catch (IllegalStateException e9) {
                                sc0Var2.h = null;
                                l12Var.f(8, e9);
                                r11 = E;
                            }
                            if (sc0Var != null) {
                                sc0Var2 = sc0Var;
                            }
                        }
                        l12Var2 = (l12) sc0Var2.c;
                        xc0VarArr2 = (xc0[]) sc0Var2.h;
                        bArr2 = (byte[]) sc0Var2.d;
                        r7 = E;
                        r7 = E;
                        if (xc0VarArr2 != null && bArr2 != null) {
                            byteArrayOutputStream = sc0Var2.a;
                            if (byteArrayOutputStream != 0) {
                                og.n("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                return;
                            }
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byteArrayOutputStream.write(bArr);
                                    byteArrayOutputStream.write(bArr2);
                                    if (s34.i(byteArrayOutputStream, bArr2, xc0VarArr2)) {
                                        l12Var2.f(5, null);
                                        sc0Var2.h = null;
                                        byteArrayOutputStream.close();
                                        r7 = byteArrayOutputStream;
                                    } else {
                                        sc0Var2.e = byteArrayOutputStream.toByteArray();
                                        byteArrayOutputStream.close();
                                        r10 = byteArrayOutputStream;
                                        sc0Var2.h = null;
                                        r7 = r10;
                                    }
                                } catch (Throwable th7) {
                                    try {
                                        byteArrayOutputStream.close();
                                        throw th7;
                                    } catch (Throwable th8) {
                                        th7.addSuppressed(th8);
                                        throw th7;
                                    }
                                }
                            } catch (IOException e10) {
                                l12Var2.f(7, e10);
                                r10 = byteArrayOutputStream;
                            } catch (IllegalStateException e11) {
                                l12Var2.f(8, e11);
                                r10 = byteArrayOutputStream;
                            }
                        }
                        bArr3 = (byte[]) sc0Var2.e;
                        if (bArr3 != null) {
                            z3 = false;
                            r9 = 1;
                        } else {
                            try {
                                if (sc0Var2.a) {
                                    og.n("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                    return;
                                }
                                try {
                                    try {
                                        byteArrayInputStream = new ByteArrayInputStream(bArr3);
                                        try {
                                            try {
                                                fileOutputStream = new FileOutputStream((File) sc0Var2.f);
                                                try {
                                                    try {
                                                        channel = fileOutputStream.getChannel();
                                                        try {
                                                            fileLockTryLock = channel.tryLock();
                                                            try {
                                                                try {
                                                                    if (fileLockTryLock != null) {
                                                                        try {
                                                                            if (fileLockTryLock.isValid()) {
                                                                                bArr4 = new byte[512];
                                                                                while (true) {
                                                                                    i = byteArrayInputStream.read(bArr4);
                                                                                    if (i > 0) {
                                                                                        break;
                                                                                    } else {
                                                                                        fileOutputStream.write(bArr4, 0, i);
                                                                                    }
                                                                                }
                                                                                r9 = 1;
                                                                                sc0Var2.f(1, null);
                                                                                fileLockTryLock.close();
                                                                                channel.close();
                                                                                fileOutputStream.close();
                                                                                byteArrayInputStream.close();
                                                                                sc0Var2.e = null;
                                                                                sc0Var2.h = null;
                                                                                z3 = true;
                                                                            }
                                                                        } catch (Throwable th9) {
                                                                            th = th9;
                                                                            Throwable th10 = th;
                                                                            if (fileLockTryLock == null) {
                                                                                throw th10;
                                                                            }
                                                                            try {
                                                                                fileLockTryLock.close();
                                                                                throw th10;
                                                                            } catch (Throwable th11) {
                                                                                th10.addSuppressed(th11);
                                                                                throw th10;
                                                                            }
                                                                        }
                                                                    }
                                                                    throw new IOException("Unable to acquire a lock on the underlying file channel.");
                                                                } catch (Throwable th12) {
                                                                    th = th12;
                                                                    Throwable th13 = th;
                                                                    if (channel == null) {
                                                                        throw th13;
                                                                    }
                                                                    try {
                                                                        channel.close();
                                                                        throw th13;
                                                                    } catch (Throwable th14) {
                                                                        th13.addSuppressed(th14);
                                                                        throw th13;
                                                                    }
                                                                }
                                                            } catch (Throwable th15) {
                                                                th = th15;
                                                            }
                                                        } catch (Throwable th16) {
                                                            th = th16;
                                                        }
                                                    } catch (Throwable th17) {
                                                        th = th17;
                                                        th2 = th;
                                                        try {
                                                            fileOutputStream.close();
                                                            throw th2;
                                                        } catch (Throwable th18) {
                                                            th2.addSuppressed(th18);
                                                            throw th2;
                                                        }
                                                    }
                                                } catch (Throwable th19) {
                                                    th = th19;
                                                    th2 = th;
                                                    fileOutputStream.close();
                                                    throw th2;
                                                }
                                            } catch (Throwable th20) {
                                                th = th20;
                                                th = th;
                                                try {
                                                    byteArrayInputStream.close();
                                                    throw th;
                                                } catch (Throwable th21) {
                                                    th.addSuppressed(th21);
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th22) {
                                            th = th22;
                                            th = th;
                                            byteArrayInputStream.close();
                                            throw th;
                                        }
                                    } catch (FileNotFoundException e12) {
                                        e = e12;
                                        sc0Var2.f(6, e);
                                        r8 = r7;
                                        sc0Var2.e = null;
                                        sc0Var2.h = null;
                                        z3 = false;
                                        r9 = r8;
                                    } catch (IOException e13) {
                                        e = e13;
                                        sc0Var2.f(7, e);
                                        r8 = r7;
                                        sc0Var2.e = null;
                                        sc0Var2.h = null;
                                        z3 = false;
                                        r9 = r8;
                                    }
                                } catch (FileNotFoundException e14) {
                                    e = e14;
                                    r7 = 1;
                                    sc0Var2.f(6, e);
                                    r8 = r7;
                                    sc0Var2.e = null;
                                    sc0Var2.h = null;
                                    z3 = false;
                                    r9 = r8;
                                } catch (IOException e15) {
                                    e = e15;
                                    r7 = 1;
                                    sc0Var2.f(7, e);
                                    r8 = r7;
                                    sc0Var2.e = null;
                                    sc0Var2.h = null;
                                    z3 = false;
                                    r9 = r8;
                                }
                            } catch (Throwable th23) {
                                sc0Var2.e = null;
                                sc0Var2.h = null;
                                throw th23;
                            }
                        }
                        if (z3) {
                            a(packageInfo, filesDir);
                        }
                        z4 = z3;
                        r12 = r9;
                    } catch (Throwable th24) {
                        try {
                            E.close();
                            throw th24;
                        } catch (IOException e16) {
                            l12Var.f(7, e16);
                            throw th24;
                        }
                    }
                } else {
                    sc0Var2.f(4, null);
                }
                if (z4 || !z) {
                    r13 = 0;
                } else {
                    r13 = r12;
                }
                p12.c(context, r13);
            }
            sc0Var2.f(3, Integer.valueOf(Build.VERSION.SDK_INT));
            z2 = true;
            z4 = false;
            r12 = z2;
            if (z4) {
                r13 = 0;
            } else {
                r13 = 0;
            }
            p12.c(context, r13);
        } catch (PackageManager.NameNotFoundException e17) {
            l12Var.f(7, e17);
            p12.c(context, false);
        }
    }
}
