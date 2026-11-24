package com.ibm.icu.impl;

import com.ibm.icu.impl.URLHandler;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.mc1;
import defpackage.og;
import defpackage.z33;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class URLHandler {
    private static final boolean DEBUG = ICUDebug.enabled("URLHandler");
    public static final String PROPNAME = "urlhandler.props";
    private static final Map<String, Method> handlers;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class FileURLHandler extends URLHandler {
        File file;

        public FileURLHandler(URL url) {
            try {
                this.file = new File(url.toURI());
            } catch (URISyntaxException unused) {
            }
            File file = this.file;
            if (file == null || !file.exists()) {
                if (URLHandler.DEBUG) {
                    ky0.y("file does not exist - ", url.toString(), System.err);
                }
                dk0.v();
                throw null;
            }
        }

        private void process(URLVisitor uRLVisitor, boolean z, boolean z2, String str, File[] fileArr) {
            FileURLHandler fileURLHandler;
            URLVisitor uRLVisitor2;
            boolean z3;
            boolean z4;
            if (fileArr != null) {
                int i = 0;
                while (i < fileArr.length) {
                    File file = fileArr[i];
                    if (!file.isDirectory()) {
                        fileURLHandler = this;
                        uRLVisitor2 = uRLVisitor;
                        z3 = z;
                        z4 = z2;
                        String name = file.getName();
                        if (!z4) {
                            name = ky0.j(str, name);
                        }
                        uRLVisitor2.visit(name);
                    } else if (z) {
                        fileURLHandler = this;
                        uRLVisitor2 = uRLVisitor;
                        z3 = z;
                        z4 = z2;
                        fileURLHandler.process(uRLVisitor2, z3, z4, cq.k(str, file.getName(), "/"), file.listFiles());
                    } else {
                        fileURLHandler = this;
                        uRLVisitor2 = uRLVisitor;
                        z3 = z;
                        z4 = z2;
                    }
                    i++;
                    this = fileURLHandler;
                    uRLVisitor = uRLVisitor2;
                    z = z3;
                    z2 = z4;
                }
            }
        }

        @Override // com.ibm.icu.impl.URLHandler
        public void guide(URLVisitor uRLVisitor, boolean z, boolean z2) {
            boolean zIsDirectory = this.file.isDirectory();
            File file = this.file;
            if (zIsDirectory) {
                process(uRLVisitor, z, z2, "/", file.listFiles());
            } else {
                uRLVisitor.visit(file.getName());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class JarURLHandler extends URLHandler {
        JarFile jarFile;
        String prefix;

        public JarURLHandler(URL url) {
            String string;
            int iIndexOf;
            try {
                String path = url.getPath();
                this.prefix = path;
                int iLastIndexOf = path.lastIndexOf("!/");
                if (iLastIndexOf >= 0) {
                    this.prefix = this.prefix.substring(iLastIndexOf + 2);
                }
                if (!url.getProtocol().equals("jar") && (iIndexOf = (string = url.toString()).indexOf(":")) != -1) {
                    url = new URL("jar".concat(string.substring(iIndexOf)));
                }
                this.jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
            } catch (Exception e) {
                if (URLHandler.DEBUG) {
                    System.err.println("icurb jar error: ".concat(String.valueOf(e)));
                }
                og.i(cq.j("jar error: ", e.getMessage()));
                throw null;
            }
        }

        @Override // com.ibm.icu.impl.URLHandler
        public void guide(URLVisitor uRLVisitor, boolean z, boolean z2) {
            String strSubstring;
            int iLastIndexOf;
            try {
                Enumeration<JarEntry> enumerationEntries = this.jarFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                    if (!jarEntryNextElement.isDirectory()) {
                        String name = jarEntryNextElement.getName();
                        if (name.startsWith(this.prefix) && ((iLastIndexOf = (strSubstring = name.substring(this.prefix.length())).lastIndexOf(47)) <= 0 || z)) {
                            if (z2 && iLastIndexOf != -1) {
                                strSubstring = strSubstring.substring(iLastIndexOf + 1);
                            }
                            uRLVisitor.visit(strSubstring);
                        }
                    }
                }
            } catch (Exception e) {
                if (URLHandler.DEBUG) {
                    System.err.println("icurb jar error: ".concat(String.valueOf(e)));
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface URLVisitor {
        void visit(String str);
    }

    static {
        final HashMap map = new HashMap();
        final Class[] clsArr = {URL.class};
        try {
            InputStream resourceAsStream = ClassLoaderUtil.getClassLoader(URLHandler.class).getResourceAsStream(PROPNAME);
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        bufferedReader.lines().map(new mc1(5)).filter(new z33()).forEach(new Consumer() { // from class: a43
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                URLHandler.lambda$static$1(clsArr, map, (String) obj);
                            }
                        });
                        bufferedReader.close();
                        inputStreamReader.close();
                        if (resourceAsStream != null) {
                            resourceAsStream.close();
                        }
                        handlers = map;
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        } catch (Throwable th7) {
            if (DEBUG) {
                System.err.println(th7);
            }
        }
    }

    public static URLHandler get(URL url) {
        if (url == null) {
            return null;
        }
        Method method = handlers.get(url.getProtocol());
        if (method != null) {
            try {
                URLHandler uRLHandler = (URLHandler) method.invoke(null, url);
                if (uRLHandler != null) {
                    return uRLHandler;
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                if (DEBUG) {
                    System.err.println(e);
                }
            }
        }
        return getDefault(url);
    }

    public static URLHandler getDefault(URL url) {
        String protocol = url.getProtocol();
        try {
            if (protocol.equals("file")) {
                return new FileURLHandler(url);
            }
            if (protocol.equals("jar") || protocol.equals("wsjar")) {
                return new JarURLHandler(url);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(String str) {
        return (str.isEmpty() || str.startsWith("#")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$1(Class[] clsArr, Map map, String str) {
        int iIndexOf = str.indexOf(61);
        if (iIndexOf == -1) {
            if (DEBUG) {
                System.err.println("bad urlhandler line: '" + str + "'");
                return;
            }
            return;
        }
        try {
            map.put(str.substring(0, iIndexOf).trim(), Class.forName(str.substring(iIndexOf + 1).trim()).getDeclaredMethod("get", clsArr));
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
            if (DEBUG) {
                System.err.println(e);
            }
        }
    }

    public void guide(URLVisitor uRLVisitor, boolean z) {
        guide(uRLVisitor, z, true);
    }

    public abstract void guide(URLVisitor uRLVisitor, boolean z, boolean z2);
}
