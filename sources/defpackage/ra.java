package defpackage;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ra extends ex1 {
    public static final boolean e;
    public final ArrayList c;
    public final yy d;

    static {
        boolean z = false;
        if (su0.m() && Build.VERSION.SDK_INT < 30) {
            z = true;
        }
        e = z;
    }

    public ra() throws NoSuchMethodException {
        zq2 zq2Var;
        Method method;
        Method method2;
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketImpl"));
            Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketFactoryImpl"));
            Class.forName("com.android.org.conscrypt".concat(".SSLParametersImpl"));
            zq2Var = new zq2(cls);
        } catch (Exception e2) {
            ex1.a.getClass();
            ex1.i("unable to load android socket classes", 5, e2);
            zq2Var = null;
        }
        int i = 0;
        List listO = qg.o(new xm2[]{zq2Var, new tb0(wb.f), new tb0(o40.a), new tb0(cm.a)});
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) listO;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            if (((xm2) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.c = arrayList;
        try {
            Class<?> cls2 = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls2.getMethod("get", null);
            method2 = cls2.getMethod("open", String.class);
            method = cls2.getMethod("warnIfOpen", null);
            method3 = method4;
        } catch (Exception unused) {
            method = null;
            method2 = null;
        }
        this.d = new yy(method3, method2, method);
    }

    @Override // defpackage.ex1
    public final jh4 b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        w6 w6Var = x509TrustManagerExtensions != null ? new w6(x509TrustManager, x509TrustManagerExtensions) : null;
        return w6Var != null ? w6Var : new tk(c(x509TrustManager));
    }

    @Override // defpackage.ex1
    public final c33 c(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new qa(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // defpackage.ex1
    public final void d(SSLSocket sSLSocket, String str, List list) {
        Object obj;
        list.getClass();
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        int i = 0;
        do {
            if (i >= size) {
                obj = null;
                break;
            } else {
                obj = arrayList.get(i);
                i++;
            }
        } while (!((xm2) obj).c(sSLSocket));
        xm2 xm2Var = (xm2) obj;
        if (xm2Var != null) {
            xm2Var.d(sSLSocket, str, list);
        }
    }

    @Override // defpackage.ex1
    public final void e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        inetSocketAddress.getClass();
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            throw new IOException("Exception in connect", e2);
        }
    }

    @Override // defpackage.ex1
    public final String f(SSLSocket sSLSocket) {
        Object obj;
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        int i = 0;
        do {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
        } while (!((xm2) obj).c(sSLSocket));
        xm2 xm2Var = (xm2) obj;
        if (xm2Var != null) {
            return xm2Var.a(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.ex1
    public final Object g() {
        yy yyVar = this.d;
        yyVar.getClass();
        Method method = yyVar.a;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, null);
                Method method2 = yyVar.b;
                method2.getClass();
                method2.invoke(objInvoke, "response.body().close()");
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // defpackage.ex1
    public final boolean h(String str) {
        str.getClass();
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    @Override // defpackage.ex1
    public final void j(Object obj, String str) {
        yy yyVar = this.d;
        yyVar.getClass();
        if (obj != null) {
            try {
                Method method = yyVar.c;
                method.getClass();
                method.invoke(obj, null);
                return;
            } catch (Exception unused) {
            }
        }
        ex1.i(str, 5, null);
    }
}
