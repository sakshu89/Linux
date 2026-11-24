package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.impl.locale.LanguageTag;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ce4 {
    public static final void a(ek1 ek1Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(2064964257);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.h(w10Var) ? 32 : 16;
        }
        int i3 = 0;
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            b(ek1Var, w10Var, x20Var, ((i2 << 3) & 896) | (i2 & 14) | 48);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new gc(ek1Var, w10Var, i, i3);
        }
    }

    public static final void b(ek1 ek1Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(771959668);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.h(null) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.h(w10Var) ? 256 : 128;
        }
        int i3 = 0;
        int i4 = 1;
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            Object objL = x20Var.L();
            xy xyVar = r20.a;
            if (objL == xyVar) {
                ku1 ku1Var = new ku1(null, el1.f);
                x20Var.g0(ku1Var);
                objL = ku1Var;
            }
            mm1 mm1Var = (mm1) objL;
            Object objL2 = x20Var.L();
            if (objL2 == xyVar) {
                objL2 = new hc(mm1Var, i3);
                x20Var.g0(objL2);
            }
            kj4.a(mx2.b.a(f((fq0) objL2, x20Var, 0)), yi4.b(-291176396, new ic(ek1Var, mm1Var, w10Var, i3), x20Var), x20Var, 56);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new gc(ek1Var, w10Var, i, i4);
        }
    }

    public static boolean c(File file, InputStream inputStream) throws Throwable {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i != -1) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    }
                    fileOutputStream2.close();
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return true;
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static File d(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + LanguageTag.SEP + Process.myTid() + LanguageTag.SEP;
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, str + i);
            try {
                if (file.createNewFile()) {
                    return file;
                }
            } catch (IOException unused) {
            }
        }
        return null;
    }

    public static MappedByteBuffer e(Context context, Uri uri) {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return null;
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return map;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                    throw th3;
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                    throw th3;
                }
            }
        } catch (IOException unused) {
        }
    }

    public static final fc f(fq0 fq0Var, x20 x20Var, int i) {
        View view = (View) x20Var.j(AndroidCompositionLocals_androidKt.f);
        boolean zF = x20Var.f(view);
        Object objL = x20Var.L();
        Object obj = r20.a;
        if (zF || objL == obj) {
            objL = new fc(view, null, fq0Var);
            x20Var.g0(objL);
        }
        fc fcVar = (fc) objL;
        boolean zH = x20Var.h(fcVar);
        Object objL2 = x20Var.L();
        if (zH || objL2 == obj) {
            objL2 = new xb(fcVar, 3);
            x20Var.g0(objL2);
        }
        bz3.a(fcVar, (hq0) objL2, x20Var);
        return fcVar;
    }
}
