package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class wb implements xm2 {
    public static final y74 f = new y74(8);
    public final Class a;
    public final Method b;
    public final Method c;
    public final Method d;
    public final Method e;

    public wb(Class cls) throws NoSuchMethodException {
        this.a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        declaredMethod.getClass();
        this.b = declaredMethod;
        this.c = cls.getMethod("setHostname", String.class);
        this.d = cls.getMethod("getAlpnSelectedProtocol", null);
        this.e = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // defpackage.xm2
    public final String a(SSLSocket sSLSocket) {
        if (this.a.isInstance(sSLSocket)) {
            try {
                byte[] bArr = (byte[]) this.d.invoke(sSLSocket, null);
                if (bArr != null) {
                    return new String(bArr, px.a);
                }
            } catch (IllegalAccessException e) {
                og.m(e);
                return null;
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (!(cause instanceof NullPointerException) || !g31.a(((NullPointerException) cause).getMessage(), "ssl == null")) {
                    og.m(e2);
                    return null;
                }
            }
        }
        return null;
    }

    @Override // defpackage.xm2
    public final boolean b() {
        boolean z = ra.e;
        return ra.e;
    }

    @Override // defpackage.xm2
    public final boolean c(SSLSocket sSLSocket) {
        return this.a.isInstance(sSLSocket);
    }

    @Override // defpackage.xm2
    public final void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
        if (this.a.isInstance(sSLSocket)) {
            try {
                this.b.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.c.invoke(sSLSocket, str);
                }
                Method method = this.e;
                ex1 ex1Var = ex1.a;
                method.invoke(sSLSocket, su0.l(list));
            } catch (IllegalAccessException e) {
                og.m(e);
            } catch (InvocationTargetException e2) {
                og.m(e2);
            }
        }
    }
}
