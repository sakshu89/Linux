package defpackage;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pp1 implements HostnameVerifier {
    public static final pp1 a = new pp1();

    public static List a(X509Certificate x509Certificate, int i) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                ArrayList arrayList = new ArrayList();
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && g31.a(list.get(0), Integer.valueOf(i)) && (obj = list.get(1)) != null) {
                        arrayList.add((String) obj);
                    }
                }
                return arrayList;
            }
        } catch (CertificateParsingException unused) {
        }
        return ii0.a;
    }

    public static boolean b(String str) {
        long j;
        int length = str.length();
        int length2 = str.length();
        if (length2 < 0) {
            og.g(cq.h("endIndex < beginIndex: ", length2, " < 0"));
            return false;
        }
        if (length2 > str.length()) {
            StringBuilder sbP = ky0.p("endIndex > string.length: ", length2, " > ");
            sbP.append(str.length());
            throw new IllegalArgumentException(sbP.toString().toString());
        }
        long j2 = 0;
        int i = 0;
        while (i < length2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                j2++;
            } else {
                if (cCharAt < 2048) {
                    j = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    j = 3;
                } else {
                    int i2 = i + 1;
                    char cCharAt2 = i2 < length2 ? str.charAt(i2) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j2++;
                        i = i2;
                    } else {
                        j2 += 4;
                        i += 2;
                    }
                }
                j2 += j;
            }
            i++;
        }
        return length == ((int) j2);
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00de  */
    public static boolean c(String str, X509Certificate x509Certificate) {
        boolean zEquals;
        int length;
        str.getClass();
        if (z53.f.e(str)) {
            String strB = no4.b(str);
            List listA = a(x509Certificate, 7);
            if (!listA.isEmpty()) {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    if (g31.a(strB, no4.b((String) it.next()))) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (b(str)) {
            Locale locale = Locale.US;
            str = cq.o(locale, str, locale);
        }
        List<String> listA2 = a(x509Certificate, 2);
        if (!listA2.isEmpty()) {
            for (String strO : listA2) {
                if (str.length() == 0 || js2.k(str, ".", false) || js2.e(str, "..", false) || strO == null || strO.length() == 0 || js2.k(strO, ".", false) || js2.e(strO, "..", false)) {
                    zEquals = false;
                } else {
                    String strConcat = !js2.e(str, ".", false) ? str.concat(".") : str;
                    if (!js2.e(strO, ".", false)) {
                        strO = strO.concat(".");
                    }
                    if (b(strO)) {
                        Locale locale2 = Locale.US;
                        strO = cq.o(locale2, strO, locale2);
                    }
                    if (!cs2.n(strO, "*", false)) {
                        zEquals = strConcat.equals(strO);
                    } else if (!js2.k(strO, "*.", false) || cs2.x(strO, '*', 1, 4) != -1 || strConcat.length() < strO.length() || "*.".equals(strO)) {
                        zEquals = false;
                    } else {
                        String strSubstring = strO.substring(1);
                        if (js2.e(strConcat, strSubstring, false) && ((length = strConcat.length() - strSubstring.length()) <= 0 || cs2.C(strConcat, '.', length - 1, 4) == -1)) {
                            zEquals = true;
                        } else {
                            zEquals = false;
                        }
                    }
                }
                if (zEquals) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        str.getClass();
        sSLSession.getClass();
        if (b(str)) {
            try {
                Certificate certificate = sSLSession.getPeerCertificates()[0];
                certificate.getClass();
                return c(str, (X509Certificate) certificate);
            } catch (SSLException unused) {
            }
        }
        return false;
    }
}
