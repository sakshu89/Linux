package defpackage;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ab1 {
    public static final l11 b = new l11("LibraryVersion", 24);
    public static final ab1 c = new ab1();
    public final ConcurrentHashMap a = new ConcurrentHashMap();

    public final String a(String str) throws Throwable {
        IOException e;
        String str2;
        InputStream resourceAsStream;
        String str3;
        String str4;
        l11 l11Var = b;
        jg1.c(str, "Please provide a valid libraryName");
        ConcurrentHashMap concurrentHashMap = this.a;
        if (concurrentHashMap.containsKey(str)) {
            return (String) concurrentHashMap.get(str);
        }
        Properties properties = new Properties();
        InputStream inputStream = null;
        property = null;
        String property = null;
        InputStream inputStream2 = null;
        try {
            try {
                resourceAsStream = ab1.class.getResourceAsStream("/" + str + ".properties");
                try {
                    if (resourceAsStream != null) {
                        properties.load(resourceAsStream);
                        property = properties.getProperty("version", null);
                        String str5 = str + " version is " + property;
                        if (Log.isLoggable((String) l11Var.b, 2) && (str4 = (String) l11Var.c) != null) {
                            str4.concat(str5);
                        }
                    } else {
                        String strConcat = "Failed to get app version for libraryName: " + str;
                        if (Log.isLoggable((String) l11Var.b, 5)) {
                            String str6 = (String) l11Var.c;
                            if (str6 != null) {
                                strConcat = str6.concat(strConcat);
                            }
                            Log.w("LibraryVersion", strConcat);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    inputStream = resourceAsStream;
                    str2 = null;
                    String strConcat2 = "Failed to get app version for libraryName: " + str;
                    if (Log.isLoggable((String) l11Var.b, 6)) {
                        String str7 = (String) l11Var.c;
                        if (str7 != null) {
                            strConcat2 = str7.concat(strConcat2);
                        }
                        Log.e("LibraryVersion", strConcat2, e);
                    }
                    InputStream inputStream3 = inputStream;
                    property = str2;
                    resourceAsStream = inputStream3;
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = resourceAsStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
            str2 = null;
        }
        if (resourceAsStream != null) {
            try {
                resourceAsStream.close();
            } catch (IOException unused2) {
            }
        }
        if (property == null) {
            if (Log.isLoggable((String) l11Var.b, 3) && (str3 = (String) l11Var.c) != null) {
                str3.concat(".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            }
            property = "UNKNOWN";
        }
        concurrentHashMap.put(str, property);
        return property;
    }
}
