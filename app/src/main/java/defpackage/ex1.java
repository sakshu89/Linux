package defpackage;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ex1 {
    public static volatile ex1 a;
    public static final Logger b;

    /* JADX WARN: Code duplicated, block: B:26:0x0071 A[PHI: r2
      0x0071: PHI (r2v3 ex1) = (r2v1 ex1), (r2v4 ex1) binds: [B:65:0x0147, B:25:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:35:0x0095  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00db  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:67:0x014b  */
    static {
        ex1 ex1Var;
        String property;
        ex1 d41Var = null;
        if (su0.m()) {
            for (Map.Entry entry : ca.b.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                Logger logger = Logger.getLogger(str);
                if (ca.a.add(logger)) {
                    logger.setUseParentHandlers(false);
                    logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
                    logger.addHandler(da.a);
                }
            }
            ex1Var = l6.d ? new l6() : null;
            if (ex1Var == null) {
                d41Var = ra.e ? new ra() : null;
                d41Var.getClass();
                ex1Var = d41Var;
            }
        } else if ("Conscrypt".equals(Security.getProviders()[0].getName())) {
            ex1Var = m40.d ? new m40() : null;
            if (ex1Var == null) {
                if (!"BC".equals(Security.getProviders()[0].getName())) {
                    if (am.d) {
                        ex1Var = new am();
                    } else {
                        ex1Var = null;
                    }
                    if (ex1Var == null) {
                        if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
                            if (sq1.d) {
                                ex1Var = new sq1();
                            } else {
                                ex1Var = null;
                            }
                            if (ex1Var == null) {
                                if (e41.c) {
                                    ex1Var = new e41();
                                } else {
                                    ex1Var = null;
                                }
                                if (ex1Var == null) {
                                    property = System.getProperty("java.specification.version", "unknown");
                                    property.getClass();
                                    if (Integer.parseInt(property) < 9) {
                                        Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method method = cls.getMethod("put", SSLSocket.class, cls2);
                                        Method method2 = cls.getMethod("get", SSLSocket.class);
                                        Method method3 = cls.getMethod("remove", SSLSocket.class);
                                        method.getClass();
                                        method2.getClass();
                                        method3.getClass();
                                        cls3.getClass();
                                        cls4.getClass();
                                        d41Var = new d41(method, method2, method3, cls3, cls4);
                                    }
                                    if (d41Var != null) {
                                        ex1Var = d41Var;
                                    } else {
                                        ex1Var = new ex1();
                                    }
                                }
                            }
                        } else {
                            if (e41.c) {
                                ex1Var = new e41();
                            } else {
                                ex1Var = null;
                            }
                            if (ex1Var == null) {
                                property = System.getProperty("java.specification.version", "unknown");
                                property.getClass();
                                if (Integer.parseInt(property) < 9) {
                                    Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls6 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> cls7 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> cls8 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method method4 = cls5.getMethod("put", SSLSocket.class, cls6);
                                    Method method5 = cls5.getMethod("get", SSLSocket.class);
                                    Method method6 = cls5.getMethod("remove", SSLSocket.class);
                                    method4.getClass();
                                    method5.getClass();
                                    method6.getClass();
                                    cls7.getClass();
                                    cls8.getClass();
                                    d41Var = new d41(method4, method5, method6, cls7, cls8);
                                }
                                if (d41Var != null) {
                                    ex1Var = d41Var;
                                } else {
                                    ex1Var = new ex1();
                                }
                            }
                        }
                    }
                } else if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
                    if (e41.c) {
                        ex1Var = new e41();
                    } else {
                        ex1Var = null;
                    }
                    if (ex1Var == null) {
                        property = System.getProperty("java.specification.version", "unknown");
                        property.getClass();
                        if (Integer.parseInt(property) < 9) {
                            Class<?> cls9 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                            Class<?> cls10 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                            Class<?> cls11 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                            Class<?> cls12 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                            Method method7 = cls9.getMethod("put", SSLSocket.class, cls10);
                            Method method8 = cls9.getMethod("get", SSLSocket.class);
                            Method method9 = cls9.getMethod("remove", SSLSocket.class);
                            method7.getClass();
                            method8.getClass();
                            method9.getClass();
                            cls11.getClass();
                            cls12.getClass();
                            d41Var = new d41(method7, method8, method9, cls11, cls12);
                        }
                        if (d41Var != null) {
                            ex1Var = d41Var;
                        } else {
                            ex1Var = new ex1();
                        }
                    }
                } else {
                    if (sq1.d) {
                        ex1Var = new sq1();
                    } else {
                        ex1Var = null;
                    }
                    if (ex1Var == null) {
                        if (e41.c) {
                            ex1Var = new e41();
                        } else {
                            ex1Var = null;
                        }
                        if (ex1Var == null) {
                            property = System.getProperty("java.specification.version", "unknown");
                            property.getClass();
                            if (Integer.parseInt(property) < 9) {
                                Class<?> cls13 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                Class<?> cls14 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                Class<?> cls15 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                Class<?> cls16 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                Method method10 = cls13.getMethod("put", SSLSocket.class, cls14);
                                Method method11 = cls13.getMethod("get", SSLSocket.class);
                                Method method12 = cls13.getMethod("remove", SSLSocket.class);
                                method10.getClass();
                                method11.getClass();
                                method12.getClass();
                                cls15.getClass();
                                cls16.getClass();
                                d41Var = new d41(method10, method11, method12, cls15, cls16);
                            }
                            if (d41Var != null) {
                                ex1Var = d41Var;
                            } else {
                                ex1Var = new ex1();
                            }
                        }
                    }
                }
            }
        } else if (!"BC".equals(Security.getProviders()[0].getName())) {
            if (am.d) {
                ex1Var = new am();
            } else {
                ex1Var = null;
            }
            if (ex1Var == null) {
                if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
                    if (e41.c) {
                        ex1Var = new e41();
                    } else {
                        ex1Var = null;
                    }
                    if (ex1Var == null) {
                        property = System.getProperty("java.specification.version", "unknown");
                        property.getClass();
                        if (Integer.parseInt(property) < 9) {
                            Class<?> cls17 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                            Class<?> cls18 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                            Class<?> cls19 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                            Class<?> cls110 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                            Method method13 = cls17.getMethod("put", SSLSocket.class, cls18);
                            Method method14 = cls17.getMethod("get", SSLSocket.class);
                            Method method15 = cls17.getMethod("remove", SSLSocket.class);
                            method13.getClass();
                            method14.getClass();
                            method15.getClass();
                            cls19.getClass();
                            cls110.getClass();
                            d41Var = new d41(method13, method14, method15, cls19, cls110);
                        }
                        if (d41Var != null) {
                            ex1Var = d41Var;
                        } else {
                            ex1Var = new ex1();
                        }
                    }
                } else {
                    if (sq1.d) {
                        ex1Var = new sq1();
                    } else {
                        ex1Var = null;
                    }
                    if (ex1Var == null) {
                        if (e41.c) {
                            ex1Var = new e41();
                        } else {
                            ex1Var = null;
                        }
                        if (ex1Var == null) {
                            property = System.getProperty("java.specification.version", "unknown");
                            property.getClass();
                            if (Integer.parseInt(property) < 9) {
                                Class<?> cls111 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                Class<?> cls112 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                Class<?> cls113 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                Class<?> cls114 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                Method method16 = cls111.getMethod("put", SSLSocket.class, cls112);
                                Method method17 = cls111.getMethod("get", SSLSocket.class);
                                Method method18 = cls111.getMethod("remove", SSLSocket.class);
                                method16.getClass();
                                method17.getClass();
                                method18.getClass();
                                cls113.getClass();
                                cls114.getClass();
                                d41Var = new d41(method16, method17, method18, cls113, cls114);
                            }
                            if (d41Var != null) {
                                ex1Var = d41Var;
                            } else {
                                ex1Var = new ex1();
                            }
                        }
                    }
                }
            }
        } else if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
            if (e41.c) {
                ex1Var = new e41();
            } else {
                ex1Var = null;
            }
            if (ex1Var == null) {
                property = System.getProperty("java.specification.version", "unknown");
                try {
                    property.getClass();
                    if (Integer.parseInt(property) < 9) {
                        try {
                            Class<?> cls115 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                            Class<?> cls116 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                            Class<?> cls117 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                            Class<?> cls118 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                            Method method19 = cls115.getMethod("put", SSLSocket.class, cls116);
                            Method method110 = cls115.getMethod("get", SSLSocket.class);
                            Method method111 = cls115.getMethod("remove", SSLSocket.class);
                            method19.getClass();
                            method110.getClass();
                            method111.getClass();
                            cls117.getClass();
                            cls118.getClass();
                            d41Var = new d41(method19, method110, method111, cls117, cls118);
                        } catch (ClassNotFoundException | NoSuchMethodException unused) {
                        }
                    }
                } catch (NumberFormatException unused2) {
                }
                if (d41Var != null) {
                    ex1Var = d41Var;
                } else {
                    ex1Var = new ex1();
                }
            }
        } else {
            if (sq1.d) {
                ex1Var = new sq1();
            } else {
                ex1Var = null;
            }
            if (ex1Var == null) {
                if (e41.c) {
                    ex1Var = new e41();
                } else {
                    ex1Var = null;
                }
                if (ex1Var == null) {
                    property = System.getProperty("java.specification.version", "unknown");
                    property.getClass();
                    if (Integer.parseInt(property) < 9) {
                        Class<?> cls119 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                        Class<?> cls1110 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                        Class<?> cls1111 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                        Class<?> cls1112 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                        Method method112 = cls119.getMethod("put", SSLSocket.class, cls1110);
                        Method method113 = cls119.getMethod("get", SSLSocket.class);
                        Method method114 = cls119.getMethod("remove", SSLSocket.class);
                        method112.getClass();
                        method113.getClass();
                        method114.getClass();
                        cls1111.getClass();
                        cls1112.getClass();
                        d41Var = new d41(method112, method113, method114, cls1111, cls1112);
                    }
                    if (d41Var != null) {
                        ex1Var = d41Var;
                    } else {
                        ex1Var = new ex1();
                    }
                }
            }
        }
        a = ex1Var;
        b = Logger.getLogger(rp1.class.getName());
    }

    public static void i(String str, int i, Throwable th) {
        b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public jh4 b(X509TrustManager x509TrustManager) {
        return new tk(c(x509TrustManager));
    }

    public c33 c(X509TrustManager x509TrustManager) {
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        acceptedIssuers.getClass();
        return new dl((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
    }

    public void e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        inetSocketAddress.getClass();
        socket.connect(inetSocketAddress, i);
    }

    public String f(SSLSocket sSLSocket) {
        return null;
    }

    public Object g() {
        if (b.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean h(String str) {
        str.getClass();
        return true;
    }

    public void j(Object obj, String str) {
        if (obj == null) {
            str = str.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        i(str, 5, (Throwable) obj);
    }

    public SSLContext k() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.getClass();
        return sSLContext;
    }

    public SSLSocketFactory l(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContextK = k();
            sSLContextK.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextK.getSocketFactory();
            socketFactory.getClass();
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public X509TrustManager m() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        trustManagers.getClass();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                trustManager.getClass();
                return (X509TrustManager) trustManager;
            }
        }
        String string = Arrays.toString(trustManagers);
        string.getClass();
        kf2.e("Unexpected default trust managers: ".concat(string));
        return null;
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public void a(SSLSocket sSLSocket) {
    }
}
