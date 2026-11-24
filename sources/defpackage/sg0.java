package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sg0 {
    public static final nr4 b;
    public static Boolean d = null;
    public static String e = null;
    public static boolean f = false;
    public static int g = -1;
    public static Boolean h;
    public static final y74 k;
    public static po4 l;
    public static qp4 m;
    public final Context a;
    public static final ThreadLocal i = new ThreadLocal();
    public static final oc j = new oc(7);
    public static final xy c = new xy(24);

    static {
        int i2 = 23;
        k = new y74(i2);
        b = new nr4(i2);
    }

    public sg0(Context context) {
        this.a = context;
    }

    public static int a(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (sr4.a(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e2) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e2.getMessage())));
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0192 A[Catch: all -> 0x00c5, og0 -> 0x00c8, RemoteException -> 0x00cb, TryCatch #14 {RemoteException -> 0x00cb, og0 -> 0x00c8, all -> 0x00c5, blocks: (B:49:0x00b6, B:57:0x00e3, B:59:0x00eb, B:61:0x00f3, B:62:0x00fa, B:56:0x00ce, B:68:0x0101, B:75:0x0111, B:76:0x011a, B:77:0x011b, B:78:0x0124, B:82:0x0129, B:85:0x012c, B:87:0x0134, B:89:0x0147, B:91:0x014f, B:98:0x018c, B:100:0x0192, B:101:0x019b, B:102:0x01a2, B:92:0x0160, B:93:0x0167, B:96:0x016b, B:97:0x017c, B:103:0x01a3, B:104:0x01aa, B:105:0x01ab, B:106:0x01b4, B:114:0x01c5), top: B:159:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:101:0x019b A[Catch: all -> 0x00c5, og0 -> 0x00c8, RemoteException -> 0x00cb, TryCatch #14 {RemoteException -> 0x00cb, og0 -> 0x00c8, all -> 0x00c5, blocks: (B:49:0x00b6, B:57:0x00e3, B:59:0x00eb, B:61:0x00f3, B:62:0x00fa, B:56:0x00ce, B:68:0x0101, B:75:0x0111, B:76:0x011a, B:77:0x011b, B:78:0x0124, B:82:0x0129, B:85:0x012c, B:87:0x0134, B:89:0x0147, B:91:0x014f, B:98:0x018c, B:100:0x0192, B:101:0x019b, B:102:0x01a2, B:92:0x0160, B:93:0x0167, B:96:0x016b, B:97:0x017c, B:103:0x01a3, B:104:0x01aa, B:105:0x01ab, B:106:0x01b4, B:114:0x01c5), top: B:159:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x01a3 A[Catch: all -> 0x00c5, og0 -> 0x00c8, RemoteException -> 0x00cb, TryCatch #14 {RemoteException -> 0x00cb, og0 -> 0x00c8, all -> 0x00c5, blocks: (B:49:0x00b6, B:57:0x00e3, B:59:0x00eb, B:61:0x00f3, B:62:0x00fa, B:56:0x00ce, B:68:0x0101, B:75:0x0111, B:76:0x011a, B:77:0x011b, B:78:0x0124, B:82:0x0129, B:85:0x012c, B:87:0x0134, B:89:0x0147, B:91:0x014f, B:98:0x018c, B:100:0x0192, B:101:0x019b, B:102:0x01a2, B:92:0x0160, B:93:0x0167, B:96:0x016b, B:97:0x017c, B:103:0x01a3, B:104:0x01aa, B:105:0x01ab, B:106:0x01b4, B:114:0x01c5), top: B:159:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x01ab A[Catch: all -> 0x00c5, og0 -> 0x00c8, RemoteException -> 0x00cb, TryCatch #14 {RemoteException -> 0x00cb, og0 -> 0x00c8, all -> 0x00c5, blocks: (B:49:0x00b6, B:57:0x00e3, B:59:0x00eb, B:61:0x00f3, B:62:0x00fa, B:56:0x00ce, B:68:0x0101, B:75:0x0111, B:76:0x011a, B:77:0x011b, B:78:0x0124, B:82:0x0129, B:85:0x012c, B:87:0x0134, B:89:0x0147, B:91:0x014f, B:98:0x018c, B:100:0x0192, B:101:0x019b, B:102:0x01a2, B:92:0x0160, B:93:0x0167, B:96:0x016b, B:97:0x017c, B:103:0x01a3, B:104:0x01aa, B:105:0x01ab, B:106:0x01b4, B:114:0x01c5), top: B:159:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:131:0x0216  */
    /* JADX WARN: Code duplicated, block: B:132:0x021c  */
    /* JADX WARN: Code duplicated, block: B:135:0x0225  */
    /* JADX WARN: Code duplicated, block: B:140:0x0236 A[Catch: all -> 0x01ce, TryCatch #8 {all -> 0x01ce, blocks: (B:115:0x01c6, B:116:0x01cd, B:124:0x01dc, B:126:0x01fa, B:128:0x0208, B:138:0x022e, B:139:0x0235, B:121:0x01d3, B:122:0x01d4, B:123:0x01db, B:140:0x0236, B:141:0x0249, B:142:0x024a, B:143:0x0274), top: B:164:0x0045, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:160:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x005b A[Catch: all -> 0x0275, TRY_LEAVE, TryCatch #12 {all -> 0x0275, blocks: (B:7:0x0041, B:18:0x005b), top: B:168:0x0041 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x006f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0078 A[Catch: all -> 0x01b5, TryCatch #10 {all -> 0x01b5, blocks: (B:24:0x0072, B:26:0x0078, B:27:0x007a), top: B:166:0x0072 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x007d A[Catch: all -> 0x0102, og0 -> 0x0107, RemoteException -> 0x010c, TRY_ENTER, TryCatch #13 {RemoteException -> 0x010c, og0 -> 0x0107, all -> 0x0102, blocks: (B:23:0x0071, B:29:0x007d, B:32:0x0085, B:36:0x008b, B:38:0x0093, B:40:0x0097, B:41:0x00a5), top: B:159:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0083  */
    /* JADX WARN: Code duplicated, block: B:36:0x008b A[Catch: all -> 0x0102, og0 -> 0x0107, RemoteException -> 0x010c, TRY_ENTER, TryCatch #13 {RemoteException -> 0x010c, og0 -> 0x0107, all -> 0x0102, blocks: (B:23:0x0071, B:29:0x007d, B:32:0x0085, B:36:0x008b, B:38:0x0093, B:40:0x0097, B:41:0x00a5), top: B:159:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x011b A[Catch: all -> 0x00c5, og0 -> 0x00c8, RemoteException -> 0x00cb, TryCatch #14 {RemoteException -> 0x00cb, og0 -> 0x00c8, all -> 0x00c5, blocks: (B:49:0x00b6, B:57:0x00e3, B:59:0x00eb, B:61:0x00f3, B:62:0x00fa, B:56:0x00ce, B:68:0x0101, B:75:0x0111, B:76:0x011a, B:77:0x011b, B:78:0x0124, B:82:0x0129, B:85:0x012c, B:87:0x0134, B:89:0x0147, B:91:0x014f, B:98:0x018c, B:100:0x0192, B:101:0x019b, B:102:0x01a2, B:92:0x0160, B:93:0x0167, B:96:0x016b, B:97:0x017c, B:103:0x01a3, B:104:0x01aa, B:105:0x01ab, B:106:0x01b4, B:114:0x01c5), top: B:159:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x012c A[Catch: all -> 0x00c5, og0 -> 0x00c8, RemoteException -> 0x00cb, TryCatch #14 {RemoteException -> 0x00cb, og0 -> 0x00c8, all -> 0x00c5, blocks: (B:49:0x00b6, B:57:0x00e3, B:59:0x00eb, B:61:0x00f3, B:62:0x00fa, B:56:0x00ce, B:68:0x0101, B:75:0x0111, B:76:0x011a, B:77:0x011b, B:78:0x0124, B:82:0x0129, B:85:0x012c, B:87:0x0134, B:89:0x0147, B:91:0x014f, B:98:0x018c, B:100:0x0192, B:101:0x019b, B:102:0x01a2, B:92:0x0160, B:93:0x0167, B:96:0x016b, B:97:0x017c, B:103:0x01a3, B:104:0x01aa, B:105:0x01ab, B:106:0x01b4, B:114:0x01c5), top: B:159:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0134 A[Catch: all -> 0x00c5, og0 -> 0x00c8, RemoteException -> 0x00cb, TryCatch #14 {RemoteException -> 0x00cb, og0 -> 0x00c8, all -> 0x00c5, blocks: (B:49:0x00b6, B:57:0x00e3, B:59:0x00eb, B:61:0x00f3, B:62:0x00fa, B:56:0x00ce, B:68:0x0101, B:75:0x0111, B:76:0x011a, B:77:0x011b, B:78:0x0124, B:82:0x0129, B:85:0x012c, B:87:0x0134, B:89:0x0147, B:91:0x014f, B:98:0x018c, B:100:0x0192, B:101:0x019b, B:102:0x01a2, B:92:0x0160, B:93:0x0167, B:96:0x016b, B:97:0x017c, B:103:0x01a3, B:104:0x01aa, B:105:0x01ab, B:106:0x01b4, B:114:0x01c5), top: B:159:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0147 A[Catch: all -> 0x00c5, og0 -> 0x00c8, RemoteException -> 0x00cb, TryCatch #14 {RemoteException -> 0x00cb, og0 -> 0x00c8, all -> 0x00c5, blocks: (B:49:0x00b6, B:57:0x00e3, B:59:0x00eb, B:61:0x00f3, B:62:0x00fa, B:56:0x00ce, B:68:0x0101, B:75:0x0111, B:76:0x011a, B:77:0x011b, B:78:0x0124, B:82:0x0129, B:85:0x012c, B:87:0x0134, B:89:0x0147, B:91:0x014f, B:98:0x018c, B:100:0x0192, B:101:0x019b, B:102:0x01a2, B:92:0x0160, B:93:0x0167, B:96:0x016b, B:97:0x017c, B:103:0x01a3, B:104:0x01aa, B:105:0x01ab, B:106:0x01b4, B:114:0x01c5), top: B:159:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x014f A[Catch: all -> 0x00c5, og0 -> 0x00c8, RemoteException -> 0x00cb, TryCatch #14 {RemoteException -> 0x00cb, og0 -> 0x00c8, all -> 0x00c5, blocks: (B:49:0x00b6, B:57:0x00e3, B:59:0x00eb, B:61:0x00f3, B:62:0x00fa, B:56:0x00ce, B:68:0x0101, B:75:0x0111, B:76:0x011a, B:77:0x011b, B:78:0x0124, B:82:0x0129, B:85:0x012c, B:87:0x0134, B:89:0x0147, B:91:0x014f, B:98:0x018c, B:100:0x0192, B:101:0x019b, B:102:0x01a2, B:92:0x0160, B:93:0x0167, B:96:0x016b, B:97:0x017c, B:103:0x01a3, B:104:0x01aa, B:105:0x01ab, B:106:0x01b4, B:114:0x01c5), top: B:159:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0160 A[Catch: all -> 0x00c5, og0 -> 0x00c8, RemoteException -> 0x00cb, TryCatch #14 {RemoteException -> 0x00cb, og0 -> 0x00c8, all -> 0x00c5, blocks: (B:49:0x00b6, B:57:0x00e3, B:59:0x00eb, B:61:0x00f3, B:62:0x00fa, B:56:0x00ce, B:68:0x0101, B:75:0x0111, B:76:0x011a, B:77:0x011b, B:78:0x0124, B:82:0x0129, B:85:0x012c, B:87:0x0134, B:89:0x0147, B:91:0x014f, B:98:0x018c, B:100:0x0192, B:101:0x019b, B:102:0x01a2, B:92:0x0160, B:93:0x0167, B:96:0x016b, B:97:0x017c, B:103:0x01a3, B:104:0x01aa, B:105:0x01ab, B:106:0x01b4, B:114:0x01c5), top: B:159:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0168  */
    /* JADX WARN: Code duplicated, block: B:96:0x016b A[Catch: all -> 0x00c5, og0 -> 0x00c8, RemoteException -> 0x00cb, TryCatch #14 {RemoteException -> 0x00cb, og0 -> 0x00c8, all -> 0x00c5, blocks: (B:49:0x00b6, B:57:0x00e3, B:59:0x00eb, B:61:0x00f3, B:62:0x00fa, B:56:0x00ce, B:68:0x0101, B:75:0x0111, B:76:0x011a, B:77:0x011b, B:78:0x0124, B:82:0x0129, B:85:0x012c, B:87:0x0134, B:89:0x0147, B:91:0x014f, B:98:0x018c, B:100:0x0192, B:101:0x019b, B:102:0x01a2, B:92:0x0160, B:93:0x0167, B:96:0x016b, B:97:0x017c, B:103:0x01a3, B:104:0x01aa, B:105:0x01ab, B:106:0x01b4, B:114:0x01c5), top: B:159:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x017c A[Catch: all -> 0x00c5, og0 -> 0x00c8, RemoteException -> 0x00cb, TryCatch #14 {RemoteException -> 0x00cb, og0 -> 0x00c8, all -> 0x00c5, blocks: (B:49:0x00b6, B:57:0x00e3, B:59:0x00eb, B:61:0x00f3, B:62:0x00fa, B:56:0x00ce, B:68:0x0101, B:75:0x0111, B:76:0x011a, B:77:0x011b, B:78:0x0124, B:82:0x0129, B:85:0x012c, B:87:0x0134, B:89:0x0147, B:91:0x014f, B:98:0x018c, B:100:0x0192, B:101:0x019b, B:102:0x01a2, B:92:0x0160, B:93:0x0167, B:96:0x016b, B:97:0x017c, B:103:0x01a3, B:104:0x01aa, B:105:0x01ab, B:106:0x01b4, B:114:0x01c5), top: B:159:0x0071 }] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:63:0x00fb
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static defpackage.sg0 c(android.content.Context r22, defpackage.rg0 r23, java.lang.String r24) {
        /*
            Method dump skipped, instruction units count: 673
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sg0.c(android.content.Context, rg0, java.lang.String):sg0");
    }

    /* JADX WARN: Code duplicated, block: B:101:0x017f  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b0 A[Catch: all -> 0x0037, TryCatch #11 {all -> 0x0037, blocks: (B:9:0x0027, B:11:0x0033, B:51:0x00b9, B:16:0x003c, B:18:0x0043, B:20:0x0049, B:25:0x0050, B:27:0x0054, B:30:0x005d, B:32:0x0065, B:35:0x006c, B:42:0x0098, B:43:0x00a0, B:38:0x0073, B:40:0x0079, B:41:0x008a, B:46:0x00a3, B:49:0x00a6, B:50:0x00b0, B:17:0x003f), top: B:147:0x0027, inners: #0 }] */
    public static int d(Context context, String str, boolean z) {
        Throwable th;
        RemoteException remoteException;
        int i2;
        Cursor cursor;
        try {
            synchronized (sg0.class) {
                Boolean bool = d;
                boolean z2 = true;
                Cursor cursor2 = null;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteModule$DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            try {
                                ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                                if (classLoader == ClassLoader.getSystemClassLoader()) {
                                    bool = Boolean.FALSE;
                                } else if (classLoader != null) {
                                    try {
                                        f(classLoader);
                                    } catch (og0 unused) {
                                    }
                                    bool = Boolean.TRUE;
                                } else {
                                    if (!g(context)) {
                                        return 0;
                                    }
                                    if (f) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    } else {
                                        Boolean bool2 = Boolean.TRUE;
                                        if (bool2.equals(null)) {
                                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                                            bool = Boolean.FALSE;
                                        } else {
                                            try {
                                                int iE = e(context, str, z, true);
                                                String str2 = e;
                                                if (str2 != null && !str2.isEmpty()) {
                                                    ClassLoader classLoaderE = yy3.e();
                                                    if (classLoaderE == null) {
                                                        if (Build.VERSION.SDK_INT >= 29) {
                                                            rj.b();
                                                            String str3 = e;
                                                            jg1.d(str3);
                                                            classLoaderE = rj.a(str3, ClassLoader.getSystemClassLoader());
                                                        } else {
                                                            String str4 = e;
                                                            jg1.d(str4);
                                                            classLoaderE = new h04(str4, ClassLoader.getSystemClassLoader());
                                                        }
                                                    }
                                                    f(classLoaderE);
                                                    declaredField.set(null, classLoaderE);
                                                    d = bool2;
                                                    return iE;
                                                }
                                                return iE;
                                            } catch (og0 unused2) {
                                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                                bool = Boolean.FALSE;
                                            }
                                        }
                                    }
                                }
                                d = bool;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e2.toString());
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return e(context, str, z, false);
                    } catch (og0 e3) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e3.getMessage());
                        return 0;
                    }
                }
                po4 po4VarH = h(context);
                try {
                    if (po4VarH == null) {
                        return 0;
                    }
                    try {
                        Parcel parcelB = po4VarH.b(po4VarH.c(), 6);
                        int i3 = parcelB.readInt();
                        parcelB.recycle();
                        if (i3 >= 3) {
                            ThreadLocal threadLocal = i;
                            jl4 jl4Var = (jl4) threadLocal.get();
                            if (jl4Var != null && (cursor = jl4Var.a) != null) {
                                return cursor.getInt(0);
                            }
                            Cursor cursor3 = (Cursor) ap1.g(po4VarH.i(new ap1(context), str, z, ((Long) j.get()).longValue()));
                            if (cursor3 != null) {
                                try {
                                    if (cursor3.moveToFirst()) {
                                        i2 = cursor3.getInt(0);
                                        if (i2 > 0) {
                                            jl4 jl4Var2 = (jl4) threadLocal.get();
                                            if (jl4Var2 == null || jl4Var2.a != null) {
                                                z2 = false;
                                            } else {
                                                jl4Var2.a = cursor3;
                                            }
                                            cursor2 = z2 ? null : cursor3;
                                        }
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                    }
                                } catch (RemoteException e4) {
                                    remoteException = e4;
                                    cursor2 = cursor3;
                                    Log.w("DynamiteModule", "Failed to retrieve remote module version: " + remoteException.getMessage());
                                    if (cursor2 == null) {
                                        return 0;
                                    }
                                    cursor2.close();
                                    return 0;
                                } catch (Throwable th3) {
                                    th = th3;
                                    cursor2 = cursor3;
                                    if (cursor2 == null) {
                                        throw th;
                                    }
                                    cursor2.close();
                                    throw th;
                                }
                            }
                            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                            if (cursor3 == null) {
                                return 0;
                            }
                            cursor3.close();
                            return 0;
                        }
                        if (i3 == 2) {
                            Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                            ap1 ap1Var = new ap1(context);
                            Parcel parcelC = po4VarH.c();
                            i04.c(parcelC, ap1Var);
                            parcelC.writeString(str);
                            parcelC.writeInt(z ? 1 : 0);
                            Parcel parcelB2 = po4VarH.b(parcelC, 5);
                            i2 = parcelB2.readInt();
                            parcelB2.recycle();
                        } else {
                            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                            ap1 ap1Var2 = new ap1(context);
                            Parcel parcelC2 = po4VarH.c();
                            i04.c(parcelC2, ap1Var2);
                            parcelC2.writeString(str);
                            parcelC2.writeInt(z ? 1 : 0);
                            Parcel parcelB3 = po4VarH.b(parcelC2, 3);
                            i2 = parcelB3.readInt();
                            parcelB3.recycle();
                        }
                        return i2;
                    } catch (RemoteException e5) {
                        remoteException = e5;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Throwable th5) {
            try {
                jg1.d(context);
                throw th5;
            } catch (Exception e6) {
                Log.e("CrashUtils", "Error adding exception to DropBox!", e6);
                throw th5;
            }
        }
    }

    public static int e(Context context, String str, boolean z, boolean z2) throws Throwable {
        Throwable th;
        Exception exc;
        boolean z3;
        Cursor cursor = null;
        try {
            try {
                boolean z4 = true;
                Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) j.get()).longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            boolean z5 = false;
                            int i2 = cursorQuery.getInt(0);
                            if (i2 > 0) {
                                synchronized (sg0.class) {
                                    try {
                                        e = cursorQuery.getString(2);
                                        int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                        if (columnIndex >= 0) {
                                            g = cursorQuery.getInt(columnIndex);
                                        }
                                        int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader2");
                                        if (columnIndex2 >= 0) {
                                            z3 = cursorQuery.getInt(columnIndex2) != 0;
                                            f = z3;
                                        } else {
                                            z3 = false;
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                                jl4 jl4Var = (jl4) i.get();
                                if (jl4Var == null || jl4Var.a != null) {
                                    z4 = false;
                                } else {
                                    jl4Var.a = cursorQuery;
                                }
                                cursor = z4 ? null : cursorQuery;
                                z5 = z3;
                            } else {
                                cursor = cursorQuery;
                            }
                            if (z2 && z5) {
                                throw new og0("forcing fallback to container DynamiteLoader impl");
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return i2;
                            if (exc instanceof og0) {
                                throw exc;
                            }
                            throw new og0("V2 version check failed: " + exc.getMessage(), exc);
                        }
                    } catch (Exception e2) {
                        exc = e2;
                    } catch (Throwable th3) {
                        cursor = cursorQuery;
                        th = th3;
                        if (cursor == null) {
                            throw th;
                        }
                        cursor.close();
                        throw th;
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new og0("Failed to connect to dynamite module ContentResolver.");
            } catch (Exception e3) {
                exc = e3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void f(ClassLoader classLoader) throws og0 {
        try {
            qp4 qp4Var = null;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                qp4Var = iInterfaceQueryLocalInterface instanceof qp4 ? (qp4) iInterfaceQueryLocalInterface : new qp4(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2", 1);
            }
            m = qp4Var;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new og0("Failed to instantiate dynamite loader", e2);
        }
    }

    public static boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(h)) {
            return true;
        }
        boolean z = false;
        if (h == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (nu0.b.b(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z = true;
            }
            h = Boolean.valueOf(z);
            if (z && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                f = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    public static po4 h(Context context) {
        po4 po4Var;
        synchronized (sg0.class) {
            po4 po4Var2 = l;
            if (po4Var2 != null) {
                return po4Var2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    po4Var = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    po4Var = iInterfaceQueryLocalInterface instanceof po4 ? (po4) iInterfaceQueryLocalInterface : new po4(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader", 1);
                }
                if (po4Var != null) {
                    l = po4Var;
                    return po4Var;
                }
            } catch (Exception e2) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e2.getMessage());
            }
            return null;
        }
    }

    public final IBinder b(String str) {
        try {
            return (IBinder) this.a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new og0("Failed to instantiate module class: ".concat(str), e2);
        }
    }
}
