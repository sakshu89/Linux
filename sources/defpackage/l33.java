package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import com.ibm.icu.impl.number.Padder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class l33 {
    public static final ae4 a;
    public static final tf1 b;
    public static Paint c;

    static {
        Trace.beginSection(hd4.e("TypefaceCompat static init"));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            a = new p33();
        } else if (i >= 29) {
            a = new o33();
        } else if (i >= 28) {
            a = new n33();
        } else {
            a = new m33();
        }
        b = new tf1(16);
        c = null;
        Trace.endSection();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Typeface a(Context context, ep0 ep0Var, Resources resources, int i, String str, int i2, int i3, ye yeVar, boolean z) {
        Typeface typefaceA;
        Typeface typefaceBuild;
        FontFamily fontFamilyBuild;
        int i4 = 0;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (ep0Var instanceof hp0) {
            hp0 hp0Var = (hp0) ep0Var;
            String str2 = hp0Var.d;
            typefaceA = null;
            int i5 = 1;
            if (TextUtils.isEmpty(str2) || (typefaceBuild = c(str2)) == null) {
                ArrayList arrayList = hp0Var.a;
                if (arrayList.size() != 1) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= arrayList.size()) {
                                int i7 = 0;
                                Typeface.CustomFallbackBuilder customFallbackBuilderB = null;
                                while (true) {
                                    if (i7 < arrayList.size()) {
                                        yo0 yo0Var = (yo0) arrayList.get(i7);
                                        if (i7 == arrayList.size() - 1 && TextUtils.isEmpty(yo0Var.f)) {
                                            customFallbackBuilderB.setSystemFallback(yo0Var.e);
                                        } else {
                                            String str3 = yo0Var.e;
                                            String str4 = yo0Var.f;
                                            Font fontD = d(c(str3));
                                            if (fontD == null) {
                                                Log.w("TypefaceCompat", "Unable identify the primary font for " + yo0Var.e + ". Falling back to provider font.");
                                            } else {
                                                if (TextUtils.isEmpty(str4)) {
                                                    try {
                                                        k33.j();
                                                        k33.o();
                                                        fontFamilyBuild = bv0.g(ln2.b(fontD).setFontVariationSettings(str4).build()).build();
                                                    } catch (IOException unused) {
                                                        Log.e("TypefaceCompat", "Failed to clone Font instance. Fall back to provider font.");
                                                    }
                                                } else {
                                                    fontFamilyBuild = bv0.x(fontD).build();
                                                }
                                                if (customFallbackBuilderB == null) {
                                                    customFallbackBuilderB = k33.b(fontFamilyBuild);
                                                } else {
                                                    customFallbackBuilderB.addCustomFallback(fontFamilyBuild);
                                                }
                                                i7++;
                                            }
                                        }
                                    }
                                    typefaceBuild = customFallbackBuilderB.build();
                                    break;
                                }
                            }
                            if (c(((yo0) arrayList.get(i6)).e) != null) {
                                i6++;
                            }
                            typefaceBuild = null;
                            break;
                        }
                    }
                    typefaceBuild = null;
                    break;
                }
                typefaceBuild = c(((yo0) arrayList.get(0)).e);
            }
            if (typefaceBuild != null) {
                if (yeVar != null) {
                    new Handler(Looper.getMainLooper()).post(new v62(i4, yeVar, typefaceBuild));
                }
                b.b(b(resources, i, str, i2, i3), typefaceBuild);
                return typefaceBuild;
            }
            Object[] objArr3 = !z ? yeVar != null : hp0Var.c != 0;
            int i8 = z ? hp0Var.b : -1;
            Handler handler = new Handler(Looper.getMainLooper());
            py0 py0Var = new py0(19, (boolean) (objArr2 == true ? 1 : 0));
            py0Var.b = yeVar;
            ArrayList arrayList2 = hp0Var.a;
            uj0 uj0Var = new uj0(handler, 1);
            l11 l11Var = new l11(7, py0Var, uj0Var);
            if (objArr3 != true) {
                String strA = dp0.a(i3, arrayList2);
                Typeface typeface = (Typeface) dp0.a.a(strA);
                if (typeface != null) {
                    uj0Var.execute(new or0(i5, py0Var, typeface));
                    typefaceA = typeface;
                } else {
                    vg0 vg0Var = new vg0(1, l11Var);
                    synchronized (dp0.c) {
                        try {
                            pk2 pk2Var = dp0.d;
                            ArrayList arrayList3 = (ArrayList) pk2Var.get(strA);
                            if (arrayList3 != null) {
                                arrayList3.add(vg0Var);
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                arrayList4.add(vg0Var);
                                pk2Var.put(strA, arrayList4);
                                bp0 bp0Var = new bp0(strA, context, arrayList2, i3, 1);
                                ThreadPoolExecutor threadPoolExecutor = dp0.b;
                                vg0 vg0Var2 = new vg0(2, strA);
                                Handler handler2 = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
                                wa0 wa0Var = new wa0();
                                wa0Var.b = bp0Var;
                                wa0Var.c = vg0Var2;
                                wa0Var.e = handler2;
                                threadPoolExecutor.execute(wa0Var);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } else {
                if (arrayList2.size() > 1) {
                    og.i("Fallbacks with blocking fetches are not supported for performance reasons");
                    return null;
                }
                yo0 yo0Var2 = (yo0) arrayList2.get(0);
                tf1 tf1Var = dp0.a;
                ArrayList arrayList5 = new ArrayList(1);
                Object obj = new Object[]{yo0Var2}[0];
                Objects.requireNonNull(obj);
                arrayList5.add(obj);
                String strA2 = dp0.a(i3, Collections.unmodifiableList(arrayList5));
                Typeface typeface2 = (Typeface) dp0.a.a(strA2);
                if (typeface2 != null) {
                    uj0Var.execute(new or0(i5, py0Var, typeface2));
                    typefaceA = typeface2;
                } else if (i8 == -1) {
                    ArrayList arrayList6 = new ArrayList(1);
                    Object obj2 = new Object[]{yo0Var2}[0];
                    Objects.requireNonNull(obj2);
                    arrayList6.add(obj2);
                    cp0 cp0VarB = dp0.b(strA2, context, Collections.unmodifiableList(arrayList6), i3);
                    l11Var.C(cp0VarB);
                    typefaceA = cp0VarB.a;
                } else {
                    try {
                        try {
                            try {
                                cp0 cp0Var = (cp0) dp0.b.submit(new bp0(strA2, context, yo0Var2, i3, 0)).get(i8, TimeUnit.MILLISECONDS);
                                l11Var.C(cp0Var);
                                typefaceA = cp0Var.a;
                            } catch (TimeoutException unused2) {
                                throw new InterruptedException("timeout");
                            }
                        } catch (InterruptedException e) {
                            throw e;
                        } catch (ExecutionException e2) {
                            throw new RuntimeException(e2);
                        }
                    } catch (InterruptedException unused3) {
                        ((uj0) l11Var.c).execute(new t5((py0) l11Var.b, -3));
                    }
                }
            }
        } else {
            typefaceA = a.a(context, (fp0) ep0Var, resources, i3);
            if (yeVar != null) {
                if (typefaceA != null) {
                    new Handler(Looper.getMainLooper()).post(new v62(objArr == true ? 1 : 0, yeVar, typefaceA));
                } else {
                    yeVar.a(-3);
                }
            }
        }
        if (typefaceA != null) {
            b.b(b(resources, i, str, i2, i3), typefaceA);
        }
        return typefaceA;
    }

    public static String b(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }

    public static Typeface c(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }

    public static Font d(Typeface typeface) {
        if (c == null) {
            c = new Paint();
        }
        c.setTextSize(10.0f);
        c.setTypeface(typeface);
        PositionedGlyphs positionedGlyphsShapeTextRun = TextRunShaper.shapeTextRun((CharSequence) Padder.FALLBACK_PADDING_STRING, 0, 1, 0, 1, 0.0f, 0.0f, false, c);
        if (positionedGlyphsShapeTextRun.glyphCount() == 0) {
            return null;
        }
        return positionedGlyphsShapeTextRun.getFont(0);
    }
}
