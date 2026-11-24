package defpackage;

import android.content.Context;
import android.util.Log;
import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.impl.number.Padder;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xy implements i70, dg, fg, mp1, l12, wu3, p10, rg0 {
    public final /* synthetic */ int a;
    public static final ll b = new ll(-1.0f, -1.0f);
    public static final ll c = new ll(0.0f, -1.0f);
    public static final ll e = new ll(1.0f, -1.0f);
    public static final ll f = new ll(-1.0f, 0.0f);
    public static final ll i = new ll(0.0f, 0.0f);
    public static final ll j = new ll(1.0f, 0.0f);
    public static final ll k = new ll(-1.0f, 1.0f);
    public static final ll n = new ll(0.0f, 1.0f);
    public static final ll s = new ll(1.0f, 1.0f);
    public static final kl t = new kl(-1.0f);
    public static final kl u = new kl(0.0f);
    public static final kl v = new kl(1.0f);
    public static final jl w = new jl(-1.0f);
    public static final jl x = new jl(0.0f);
    public static final xy H = new xy(3);
    public static final /* synthetic */ xy X = new xy(4);
    public static final dk0 Y = new dk0(27);
    public static final dk0 Z = new dk0(28);
    public static final dk0 c0 = new dk0(29);
    public static final kf2 d0 = new kf2(0);
    public static final yb3 e0 = new yb3();

    public /* synthetic */ xy(int i2) {
        this.a = i2;
    }

    public static final float b(float f2, float[] fArr, float[] fArr2) {
        float f3;
        float f4;
        float f5;
        float f6;
        float fAbs = Math.abs(f2);
        float fSignum = Math.signum(f2);
        int iBinarySearch = Arrays.binarySearch(fArr, fAbs);
        if (iBinarySearch >= 0) {
            return fSignum * fArr2[iBinarySearch];
        }
        int i2 = -(iBinarySearch + 1);
        int i3 = i2 - 1;
        if (i3 >= fArr.length - 1) {
            float f7 = fArr[fArr.length - 1];
            float f8 = fArr2[fArr.length - 1];
            if (f7 == 0.0f) {
                return 0.0f;
            }
            return (f8 / f7) * f2;
        }
        if (i3 == -1) {
            float f9 = fArr[0];
            f5 = fArr2[0];
            f6 = f9;
            f4 = 0.0f;
            f3 = 0.0f;
        } else {
            float f10 = fArr[i3];
            float f11 = fArr[i2];
            f3 = fArr2[i3];
            f4 = f10;
            f5 = fArr2[i2];
            f6 = f11;
        }
        return (((f5 - f3) * Math.max(0.0f, Math.min(1.0f, f4 == f6 ? 0.0f : (fAbs - f4) / (f6 - f4)))) + f3) * fSignum;
    }

    public static final z62 c(z62 z62Var) {
        if ((z62Var != null ? z62Var.j : null) == null) {
            return z62Var;
        }
        y62 y62VarE = z62Var.e();
        y62VarE.g = null;
        return y62VarE.a();
    }

    public static final int m(int i2, long j2) {
        int i3 = q13.b;
        return ((int) (j2 >> (i2 * 15))) & 32767;
    }

    public static String n(String str) {
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = str.toLowerCase(locale);
        lowerCase.getClass();
        String strReplace = lowerCase.replace((char) 8217, PatternTokenizer.SINGLE_QUOTE);
        strReplace.getClass();
        Pattern patternCompile = Pattern.compile("[^\\p{L}\\p{N}']+");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strReplace).replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll.getClass();
        String string = cs2.V(strReplaceAll).toString();
        Pattern patternCompile2 = Pattern.compile("^(?:(?:hey|ok|okay) )?(?:linux|sonic|sonik|sonnic|sonick|sonix|zonic)\\s*");
        patternCompile2.getClass();
        string.getClass();
        String strReplaceAll2 = patternCompile2.matcher(string).replaceAll("");
        strReplaceAll2.getClass();
        return cs2.V(cs2.I(cs2.G(strReplaceAll2, "please "), " please")).toString();
    }

    public static boolean o(String str) {
        str.getClass();
        return wh2.c("shut down", "shutdown", "shut down assistant", "power down", "stop listening", "end conversation", "band karo", "assistant band karo", "close assistant", "shut down now", "shutdown now", "turn yourself off", "switch yourself off", "बंद करो", "सोनिक बंद करो", "linux बंद करो").contains(n(str)) || wh2.c("offline", "off line", "go offline", "go off line", "use offline mode", "offline mode", "go offline now", "offline now").contains(n(str));
    }

    public static boolean p(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean q(String str, boolean z) {
        str.getClass();
        String strN = n(str);
        if (z && wh2.c("pause", "stop", "pause music", "pause song", "pause the song", "pause spotify").contains(strN)) {
            return false;
        }
        return wh2.c("stop", "pause", "stop speaking", "pause speaking", "stop talking", "be quiet", "quiet", "chup", "chup karo", "ruko", "roko", "hold on", "wait", "shh", "bas", "bas karo", "shanti", "रुको", "चुप", "चुप करो", "बस करो").contains(strN);
    }

    public static long r(int i2, int i3, int i4, int i5) {
        return (((long) (i3 & 32767)) << 15) | ((long) (i2 & 32767)) | (((long) (i4 & 32767)) << 30) | (((long) (i5 & 32767)) << 45) | Long.MIN_VALUE;
    }

    public static dm1 s(FileInputStream fileInputStream) throws x70 {
        byte[] bArr;
        try {
            nz1 nz1VarO = nz1.o(fileInputStream);
            dm1 dm1Var = new dm1(false);
            jz1[] jz1VarArr = (jz1[]) Arrays.copyOf(new jz1[0], 0);
            dm1Var.b();
            if (jz1VarArr.length > 0) {
                jz1 jz1Var = jz1VarArr[0];
                throw null;
            }
            Map mapM = nz1VarO.m();
            mapM.getClass();
            for (Map.Entry entry : mapM.entrySet()) {
                String str = (String) entry.getKey();
                rz1 rz1Var = (rz1) entry.getValue();
                str.getClass();
                rz1Var.getClass();
                int iC = rz1Var.C();
                switch (iC == 0 ? -1 : kz1.a[cq.x(iC)]) {
                    case -1:
                        throw new x70("Value case is null.", null);
                    case 0:
                    default:
                        dk0.l();
                        return null;
                    case 1:
                        dm1Var.f(new iz1(str), Boolean.valueOf(rz1Var.t()));
                        break;
                    case 2:
                        dm1Var.f(new iz1(str), Float.valueOf(rz1Var.x()));
                        break;
                    case 3:
                        dm1Var.f(new iz1(str), Double.valueOf(rz1Var.w()));
                        break;
                    case 4:
                        dm1Var.f(new iz1(str), Integer.valueOf(rz1Var.y()));
                        break;
                    case 5:
                        dm1Var.f(new iz1(str), Long.valueOf(rz1Var.z()));
                        break;
                    case 6:
                        iz1 iz1Var = new iz1(str);
                        String strA = rz1Var.A();
                        strA.getClass();
                        dm1Var.f(iz1Var, strA);
                        break;
                    case 7:
                        iz1 iz1Var2 = new iz1(str);
                        w21 w21VarN = rz1Var.B().n();
                        w21VarN.getClass();
                        dm1Var.f(iz1Var2, mz.Q(w21VarN));
                        break;
                    case 8:
                        iz1 iz1Var3 = new iz1(str);
                        no noVarU = rz1Var.u();
                        int size = noVarU.size();
                        if (size == 0) {
                            bArr = x21.b;
                        } else {
                            byte[] bArr2 = new byte[size];
                            noVarU.f(bArr2, size);
                            bArr = bArr2;
                        }
                        bArr.getClass();
                        dm1Var.f(iz1Var3, bArr);
                        break;
                    case 9:
                        throw new x70("Value not set.", null);
                }
            }
            return new dm1(new LinkedHashMap(dm1Var.a()), true);
        } catch (o31 e2) {
            throw new x70("Unable to parse preferences proto.", e2);
        }
    }

    public static void t(Object obj, j43 j43Var) {
        yt0 yt0VarA;
        Map mapA = ((dm1) obj).a();
        lz1 lz1VarN = nz1.n();
        for (Map.Entry entry : mapA.entrySet()) {
            iz1 iz1Var = (iz1) entry.getKey();
            Object value = entry.getValue();
            String str = iz1Var.a;
            if (value instanceof Boolean) {
                qz1 qz1VarD = rz1.D();
                boolean zBooleanValue = ((Boolean) value).booleanValue();
                qz1VarD.c();
                rz1.q((rz1) qz1VarD.b, zBooleanValue);
                yt0VarA = qz1VarD.a();
            } else if (value instanceof Float) {
                qz1 qz1VarD2 = rz1.D();
                float fFloatValue = ((Number) value).floatValue();
                qz1VarD2.c();
                rz1.r((rz1) qz1VarD2.b, fFloatValue);
                yt0VarA = qz1VarD2.a();
            } else if (value instanceof Double) {
                qz1 qz1VarD3 = rz1.D();
                double dDoubleValue = ((Number) value).doubleValue();
                qz1VarD3.c();
                rz1.o((rz1) qz1VarD3.b, dDoubleValue);
                yt0VarA = qz1VarD3.a();
            } else if (value instanceof Integer) {
                qz1 qz1VarD4 = rz1.D();
                int iIntValue = ((Number) value).intValue();
                qz1VarD4.c();
                rz1.s((rz1) qz1VarD4.b, iIntValue);
                yt0VarA = qz1VarD4.a();
            } else if (value instanceof Long) {
                qz1 qz1VarD5 = rz1.D();
                long jLongValue = ((Number) value).longValue();
                qz1VarD5.c();
                rz1.l((rz1) qz1VarD5.b, jLongValue);
                yt0VarA = qz1VarD5.a();
            } else if (value instanceof String) {
                qz1 qz1VarD6 = rz1.D();
                qz1VarD6.c();
                rz1.m((rz1) qz1VarD6.b, (String) value);
                yt0VarA = qz1VarD6.a();
            } else if (value instanceof Set) {
                qz1 qz1VarD7 = rz1.D();
                oz1 oz1VarO = pz1.o();
                oz1VarO.c();
                pz1.l((pz1) oz1VarO.b, (Set) value);
                qz1VarD7.c();
                rz1.n((rz1) qz1VarD7.b, (pz1) oz1VarO.a());
                yt0VarA = qz1VarD7.a();
            } else {
                if (!(value instanceof byte[])) {
                    og.n("PreferencesSerializer does not support type: ".concat(value.getClass().getName()));
                    return;
                }
                qz1 qz1VarD8 = rz1.D();
                byte[] bArr = (byte[]) value;
                no noVarD = no.d(0, bArr, bArr.length);
                qz1VarD8.c();
                rz1.p((rz1) qz1VarD8.b, noVarD);
                yt0VarA = qz1VarD8.a();
            }
            lz1VarN.getClass();
            str.getClass();
            lz1VarN.c();
            nz1.l((nz1) lz1VarN.b).put(str, (rz1) yt0VarA);
        }
        nz1 nz1Var = (nz1) lz1VarN.a();
        int iA = nz1Var.a(null);
        Logger logger = kz.f;
        if (iA > 4096) {
            iA = 4096;
        }
        kz kzVar = new kz(j43Var, iA);
        nz1Var.b(kzVar);
        if (kzVar.d > 0) {
            kzVar.k();
        }
    }

    @Override // defpackage.dg, defpackage.fg
    public float a() {
        return 0.0f;
    }

    @Override // defpackage.wu3
    public dv3 d(Class cls) {
        throw new IllegalStateException("This should never be called.");
    }

    @Override // defpackage.rg0
    public qg0 e(Context context, String str, pg0 pg0Var) {
        qg0 qg0Var = new qg0();
        int iL = pg0Var.l(context, str);
        qg0Var.a = iL;
        if (iL != 0) {
            qg0Var.c = -1;
            return qg0Var;
        }
        int iQ = pg0Var.q(context, str, true);
        qg0Var.b = iQ;
        if (iQ != 0) {
            qg0Var.c = 1;
        }
        return qg0Var;
    }

    @Override // defpackage.l12
    public void f(int i2, Object obj) {
        String str;
        switch (i2) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i2 == 6 || i2 == 7 || i2 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        }
    }

    @Override // defpackage.p10
    public Object g(e72 e72Var) {
        switch (this.a) {
            case 23:
                return new q52(e72Var.d(p52.class));
            default:
                return new jk2((Context) e72Var.b(Context.class));
        }
    }

    @Override // defpackage.dg
    public void h(jc0 jc0Var, int i2, int[] iArr, z61 z61Var, int[] iArr2) {
        if (z61Var == z61.a) {
            jg1.h(i2, iArr, iArr2, false);
        } else {
            jg1.h(i2, iArr, iArr2, true);
        }
    }

    @Override // defpackage.fg
    public void i(int i2, qh1 qh1Var, int[] iArr, int[] iArr2) {
        jg1.h(i2, iArr, iArr2, false);
    }

    @Override // defpackage.wu3
    public boolean j(Class cls) {
        return false;
    }

    public String toString() {
        switch (this.a) {
            case 9:
                return "Arrangement#Center";
            case 10:
            default:
                return super.toString();
            case 11:
                return "Empty";
        }
    }

    @Override // defpackage.mp1
    public int k(int i2) {
        return i2;
    }

    @Override // defpackage.mp1
    public int l(int i2) {
        return i2;
    }
}
