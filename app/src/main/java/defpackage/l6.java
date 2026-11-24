package defpackage;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l6 extends ex1 {
    public static final boolean d;
    public final ArrayList c;

    static {
        d = su0.m() && Build.VERSION.SDK_INT >= 29;
    }

    public l6() {
        int i = 0;
        List listO = qg.o(new xm2[]{(!su0.m() || Build.VERSION.SDK_INT < 29) ? null : new m6(), new tb0(wb.f), new tb0(o40.a), new tb0(cm.a)});
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
    public final boolean h(String str) {
        str.getClass();
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
