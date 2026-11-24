package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class o33 extends ae4 {
    public static Font g(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iJ = j(fontStyle, font.getStyle());
        for (int i2 = 1; i2 < fontFamily.getSize(); i2++) {
            Font font2 = fontFamily.getFont(i2);
            int iJ2 = j(fontStyle, font2.getStyle());
            if (iJ2 < iJ) {
                font = font2;
                iJ = iJ2;
            }
        }
        return font;
    }

    public static int j(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // defpackage.ae4
    public final Typeface a(Context context, fp0 fp0Var, Resources resources, int i) {
        try {
            FontFamily.Builder builder = null;
            for (gp0 gp0Var : fp0Var.a) {
                try {
                    Font fontBuild = new Font.Builder(resources, gp0Var.f).setWeight(gp0Var.b).setSlant(gp0Var.c ? 1 : 0).setTtcIndex(gp0Var.e).setFontVariationSettings(gp0Var.d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(g(fontFamilyBuild, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // defpackage.ae4
    public final Typeface b(Context context, pp0[] pp0VarArr, int i) {
        try {
            FontFamily fontFamilyH = h(pp0VarArr, context.getContentResolver());
            if (fontFamilyH == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(fontFamilyH).setStyle(g(fontFamilyH, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // defpackage.ae4
    public final Typeface c(Context context, List list, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily fontFamilyH = h((pp0[]) list.get(0), contentResolver);
            if (fontFamilyH == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyH);
            for (int i2 = 1; i2 < list.size(); i2++) {
                FontFamily fontFamilyH2 = h((pp0[]) list.get(i2), contentResolver);
                if (fontFamilyH2 != null) {
                    customFallbackBuilder.addCustomFallback(fontFamilyH2);
                }
            }
            return customFallbackBuilder.setStyle(g(fontFamilyH, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // defpackage.ae4
    public final Typeface d(Context context, Resources resources, int i, String str) {
        try {
            Font fontBuild = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    public final FontFamily h(pp0[] pp0VarArr, ContentResolver contentResolver) {
        Font fontBuild;
        FontFamily.Builder builder = null;
        for (pp0 pp0Var : pp0VarArr) {
            if (Objects.equals(pp0Var.a.getScheme(), "systemfont")) {
                fontBuild = i(pp0Var);
            } else {
                try {
                    Uri uri = pp0Var.a;
                    String str = pp0Var.e;
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        fontBuild = null;
                    } else {
                        try {
                            Font.Builder ttcIndex = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(pp0Var.c).setSlant(pp0Var.d ? 1 : 0).setTtcIndex(pp0Var.b);
                            if (!TextUtils.isEmpty(str)) {
                                ttcIndex.setFontVariationSettings(str);
                            }
                            fontBuild = ttcIndex.build();
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                } catch (IOException e) {
                    Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
                    fontBuild = null;
                }
            }
            if (fontBuild != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(fontBuild);
                } else {
                    builder.addFont(fontBuild);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public Font i(pp0 pp0Var) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }
}
