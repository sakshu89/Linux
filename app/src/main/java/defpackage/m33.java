package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class m33 extends ae4 {
    public static Class h = null;
    public static Constructor i = null;
    public static Method j = null;
    public static Method k = null;
    public static boolean l = false;
    public final Class a;
    public final Constructor b;
    public final Method c;
    public final Method d;
    public final Method e;
    public final Method f;
    public final Method g;

    public m33() throws NoSuchMethodException {
        Method methodM;
        Constructor<?> constructor;
        Method methodL;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodL = l(cls2);
            Class cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodM = m(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            methodM = null;
            constructor = null;
            methodL = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.a = cls;
        this.b = constructor;
        this.c = methodL;
        this.d = method;
        this.e = method2;
        this.f = method3;
        this.g = methodM;
    }

    public static boolean h(Object obj, String str, int i2, boolean z) throws NoSuchMethodException {
        k();
        try {
            return ((Boolean) j.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void k() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (l) {
            return;
        }
        l = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        i = constructor;
        h = cls;
        j = method2;
        k = method;
    }

    public static Method l(Class cls) {
        Class cls2 = Boolean.TYPE;
        Class cls3 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls3, cls2, cls3, cls3, cls3, FontVariationAxis[].class);
    }

    @Override // defpackage.ae4
    public final Typeface a(Context context, fp0 fp0Var, Resources resources, int i2) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        InputStream inputStreamOpenRawResource;
        gp0[] gp0VarArr = fp0Var.a;
        Method method = this.c;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        int i3 = 0;
        if (method == null) {
            k();
            try {
                Object objNewInstance2 = i.newInstance(null);
                for (gp0 gp0Var : gp0VarArr) {
                    File fileD = ce4.d(context);
                    if (fileD != null) {
                        try {
                            try {
                                inputStreamOpenRawResource = resources.openRawResource(gp0Var.f);
                                try {
                                    boolean zC = ce4.c(fileD, inputStreamOpenRawResource);
                                    if (inputStreamOpenRawResource != null) {
                                        try {
                                            inputStreamOpenRawResource.close();
                                        } catch (IOException unused) {
                                        }
                                    }
                                    if (!zC) {
                                        fileD.delete();
                                        return null;
                                    }
                                    if (!h(objNewInstance2, fileD.getPath(), gp0Var.b, gp0Var.c)) {
                                        fileD.delete();
                                        return null;
                                    }
                                    fileD.delete();
                                } catch (Throwable th) {
                                    th = th;
                                    Throwable th2 = th;
                                    if (inputStreamOpenRawResource == null) {
                                        throw th2;
                                    }
                                    try {
                                        inputStreamOpenRawResource.close();
                                        throw th2;
                                    } catch (IOException unused2) {
                                        throw th2;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStreamOpenRawResource = null;
                            }
                        } catch (RuntimeException unused3) {
                            fileD.delete();
                            return null;
                        } catch (Throwable th4) {
                            fileD.delete();
                            throw th4;
                        }
                    }
                }
                k();
                try {
                    Object objNewInstance3 = Array.newInstance((Class<?>) h, 1);
                    Array.set(objNewInstance3, 0, objNewInstance2);
                    return (Typeface) k.invoke(null, objNewInstance3);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
        try {
            objNewInstance = this.b.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused4) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            int length = gp0VarArr.length;
            while (i3 < length) {
                gp0 gp0Var2 = gp0VarArr[i3];
                m33 m33Var = this;
                Context context2 = context;
                if (m33Var.g(context2, objNewInstance, gp0Var2.a, gp0Var2.e, gp0Var2.b, gp0Var2.c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(gp0Var2.d))) {
                    i3++;
                    this = m33Var;
                    context = context2;
                } else {
                    try {
                        m33Var.f.invoke(objNewInstance, null);
                    } catch (IllegalAccessException | InvocationTargetException unused5) {
                    }
                }
            }
            m33 m33Var2 = this;
            if (m33Var2.j(objNewInstance)) {
                return m33Var2.i(objNewInstance);
            }
        }
        return null;
    }

    @Override // defpackage.ae4
    public final Typeface b(Context context, pp0[] pp0VarArr, int i2) throws IOException {
        Object objNewInstance;
        Typeface typefaceI;
        boolean zBooleanValue;
        if (pp0VarArr.length >= 1) {
            Method method = this.c;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            try {
                if (method != null) {
                    HashMap map = new HashMap();
                    for (pp0 pp0Var : pp0VarArr) {
                        if (pp0Var.f == 0) {
                            Uri uri = pp0Var.a;
                            if (!map.containsKey(uri)) {
                                map.put(uri, ce4.e(context, uri));
                            }
                        }
                    }
                    Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
                    try {
                        objNewInstance = this.b.newInstance(null);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        objNewInstance = null;
                    }
                    if (objNewInstance != null) {
                        int length = pp0VarArr.length;
                        int i3 = 0;
                        boolean z = false;
                        while (true) {
                            Method method2 = this.f;
                            if (i3 >= length) {
                                if (!z) {
                                    method2.invoke(objNewInstance, null);
                                    break;
                                }
                                if (!j(objNewInstance) || (typefaceI = i(objNewInstance)) == null) {
                                    break;
                                    break;
                                }
                                return Typeface.create(typefaceI, i2);
                            }
                            pp0 pp0Var2 = pp0VarArr[i3];
                            ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(pp0Var2.a);
                            if (byteBuffer != null) {
                                try {
                                    zBooleanValue = ((Boolean) this.d.invoke(objNewInstance, byteBuffer, Integer.valueOf(pp0Var2.b), null, Integer.valueOf(pp0Var2.c), Integer.valueOf(pp0Var2.d ? 1 : 0))).booleanValue();
                                } catch (IllegalAccessException | InvocationTargetException unused2) {
                                    zBooleanValue = false;
                                }
                                if (!zBooleanValue) {
                                    method2.invoke(objNewInstance, null);
                                    break;
                                }
                                z = true;
                            }
                            i3++;
                            z = z;
                        }
                    }
                } else {
                    int i4 = (i2 & 1) == 0 ? 400 : 700;
                    boolean z2 = (i2 & 2) != 0;
                    int i5 = Integer.MAX_VALUE;
                    pp0 pp0Var3 = null;
                    for (pp0 pp0Var4 : pp0VarArr) {
                        int iAbs = (Math.abs(pp0Var4.c - i4) * 2) + (pp0Var4.d == z2 ? 0 : 1);
                        if (pp0Var3 == null || i5 > iAbs) {
                            pp0Var3 = pp0Var4;
                            i5 = iAbs;
                        }
                    }
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(pp0Var3.a, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(pp0Var3.c).setItalic(pp0Var3.d).build();
                            parcelFileDescriptorOpenFileDescriptor.close();
                            return typefaceBuild;
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return null;
                    }
                }
            } catch (IOException | IllegalAccessException | InvocationTargetException unused3) {
            }
        }
        return null;
    }

    @Override // defpackage.ae4
    public final Typeface d(Context context, Resources resources, int i2, String str) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        InputStream inputStreamOpenRawResource;
        Method method = this.c;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method != null) {
            try {
                objNewInstance = this.b.newInstance(null);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                objNewInstance = null;
            }
            if (objNewInstance != null) {
                if (!g(context, objNewInstance, str, 0, -1, -1, null)) {
                    try {
                        this.f.invoke(objNewInstance, null);
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                } else if (j(objNewInstance)) {
                    return i(objNewInstance);
                }
            }
        } else {
            File fileD = ce4.d(context);
            try {
                if (fileD != null) {
                    try {
                        inputStreamOpenRawResource = resources.openRawResource(i2);
                        try {
                            boolean zC = ce4.c(fileD, inputStreamOpenRawResource);
                            if (inputStreamOpenRawResource != null) {
                                try {
                                    inputStreamOpenRawResource.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (!zC) {
                                fileD.delete();
                                return null;
                            }
                            Typeface typefaceCreateFromFile = Typeface.createFromFile(fileD.getPath());
                            fileD.delete();
                            return typefaceCreateFromFile;
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            if (inputStreamOpenRawResource == null) {
                                throw th2;
                            }
                            try {
                                inputStreamOpenRawResource.close();
                                throw th2;
                            } catch (IOException unused4) {
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamOpenRawResource = null;
                    }
                }
            } catch (RuntimeException unused5) {
                return null;
            } finally {
                fileD.delete();
            }
        }
        return null;
    }

    public final boolean g(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.c.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface i(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.g.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean j(Object obj) {
        try {
            return ((Boolean) this.e.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method m(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
