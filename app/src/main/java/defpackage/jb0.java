package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jb0 {
    public static final bz1 a;

    static {
        a = new bz1((14 & 1) == 0, xe2.a, true);
    }

    public static final void a(ox2 ox2Var, cx2 cx2Var, x20 x20Var, int i) {
        x20 x20Var2;
        Context context;
        x20Var.X(1904307118);
        int i2 = (x20Var.f(ox2Var) ? 4 : 2) | i | (x20Var.h(cx2Var) ? 32 : 16);
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            if (Build.VERSION.SDK_INT >= 28) {
                x20Var.W(-1009482584);
                context = (Context) x20Var.j(AndroidCompositionLocals_androidKt.b);
                x20Var.p(false);
            } else {
                x20Var.W(-1009433480);
                x20Var.p(false);
                context = null;
            }
            boolean zH = x20Var.h(cx2Var) | ((i2 & 14) == 4) | x20Var.h(context);
            Object objL = x20Var.L();
            if (zH || objL == r20.a) {
                objL = new e2(cx2Var, context, ox2Var, 6);
                x20Var.g0(objL);
            }
            x20Var2 = x20Var;
            v50.b(null, null, (hq0) objL, x20Var2, 0, 3);
        } else {
            x20Var2 = x20Var;
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new km(i, 5, ox2Var, cx2Var);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x021e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0227  */
    /* JADX WARN: Code duplicated, block: B:113:0x024a  */
    /* JADX WARN: Code duplicated, block: B:192:0x0472  */
    /* JADX WARN: Code duplicated, block: B:211:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:212:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:217:0x050d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:218:0x050f  */
    /* JADX WARN: Code duplicated, block: B:219:0x0517  */
    /* JADX WARN: Code duplicated, block: B:225:0x0530 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:226:0x0532  */
    /* JADX WARN: Code duplicated, block: B:227:0x053a  */
    /* JADX WARN: Code duplicated, block: B:230:0x054a  */
    /* JADX WARN: Code duplicated, block: B:231:0x054d  */
    public static final void b(final int i, long j, x20 x20Var, final int i2) throws XmlPullParserException, IOException {
        TypedValue typedValue;
        int i3;
        int i4;
        Object obj;
        Object p9Var;
        tt1 mlVar;
        Object nlVar;
        TypedArray typedArray;
        boolean z;
        long jB;
        int i5;
        int i6;
        int i7;
        TypedArray typedArrayObtainStyledAttributes;
        int i8;
        TypedArray typedArrayObtainStyledAttributes2;
        int i9;
        int i10;
        char c;
        int i11;
        Shader shader;
        int i12;
        hn cn2Var;
        Shader shader2;
        int i13;
        hn cn2Var2;
        int i14;
        ColorStateList colorStateListA;
        final long j2 = j;
        x20Var.X(-1240244237);
        int i15 = (i2 & 6) == 0 ? i2 | (x20Var.d(i) ? 4 : 2) : i2;
        if ((i2 & 48) == 0) {
            i15 |= x20Var.e(j2) ? 32 : 16;
        }
        int i16 = i15;
        if (x20Var.O(i16 & 1, (i16 & 19) != 18)) {
            z12 z12Var = AndroidCompositionLocals_androidKt.b;
            Context context = (Context) x20Var.j(z12Var);
            boolean zF = x20Var.f(context) | ((i16 & 14) == 4);
            Object objL = x20Var.L();
            if (zF || objL == r20.a) {
                objL = Integer.valueOf(context.obtainStyledAttributes(new int[]{i}).getResourceId(0, -1));
                x20Var.g0(objL);
            }
            int iIntValue = ((Number) objL).intValue();
            if (iIntValue == -1) {
                a42 a42VarR = x20Var.r();
                if (a42VarR != null) {
                    final int i17 = 1;
                    a42VarR.d = new vq0() { // from class: hb0
                        @Override // defpackage.vq0
                        public final Object e(Object obj2, Object obj3) throws XmlPullParserException, IOException {
                            int i18 = i17;
                            q43 q43Var = q43.a;
                            int i19 = i2;
                            long j3 = j2;
                            int i20 = i;
                            x20 x20Var2 = (x20) obj2;
                            ((Integer) obj3).getClass();
                            switch (i18) {
                                case 0:
                                    jb0.b(i20, j3, x20Var2, ny3.c(i19 | 1));
                                    break;
                                default:
                                    jb0.b(i20, j3, x20Var2, ny3.c(i19 | 1));
                                    break;
                            }
                            return q43Var;
                        }
                    };
                    return;
                }
                return;
            }
            Context context2 = (Context) x20Var.j(z12Var);
            Resources resources = (Resources) x20Var.j(AndroidCompositionLocals_androidKt.c);
            q62 q62Var = (q62) x20Var.j(AndroidCompositionLocals_androidKt.e);
            synchronized (q62Var) {
                typedValue = (TypedValue) q62Var.a.b(iIntValue);
                if (typedValue == null) {
                    typedValue = new TypedValue();
                    resources.getValue(iIntValue, typedValue, true);
                    ml1 ml1Var = q62Var.a;
                    int iD = ml1Var.d(iIntValue);
                    i3 = 32;
                    Object[] objArr = ml1Var.c;
                    Object obj2 = objArr[iD];
                    ml1Var.b[iD] = iIntValue;
                    objArr[iD] = typedValue;
                } else {
                    i3 = 32;
                }
            }
            CharSequence charSequence = typedValue.string;
            if (charSequence == null || !cs2.r(charSequence, ".xml")) {
                i4 = i16;
                x20Var.W(-1771643000);
                boolean zF2 = x20Var.f(context2.getTheme()) | x20Var.f(charSequence) | x20Var.d(iIntValue);
                Object objL2 = x20Var.L();
                if (zF2 || objL2 == r20.a) {
                    obj = null;
                    try {
                        Drawable drawable = resources.getDrawable(iIntValue, null);
                        drawable.getClass();
                        p9Var = new p9(((BitmapDrawable) drawable).getBitmap());
                        x20Var.g0(p9Var);
                    } catch (Exception e) {
                        throw new b10("Error attempting to load resource: " + ((Object) charSequence), e);
                    }
                } else {
                    p9Var = objL2;
                    obj = null;
                }
                mlVar = new ml((p9) p9Var);
                x20Var.p(false);
            } else {
                x20Var.W(-1771798434);
                Resources.Theme theme = context2.getTheme();
                int i18 = typedValue.changingConfigurations;
                iz0 iz0Var = (iz0) x20Var.j(AndroidCompositionLocals_androidKt.d);
                hz0 hz0Var = new hz0(theme, iIntValue);
                WeakReference weakReference = (WeakReference) iz0Var.a.get(hz0Var);
                gz0 gz0Var = weakReference != null ? (gz0) weakReference.get() : null;
                if (gz0Var == null) {
                    XmlResourceParser xml = resources.getXml(iIntValue);
                    int next = xml.next();
                    while (next != 2 && next != 1) {
                        next = xml.next();
                    }
                    if (next != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                    if (!g31.a(xml.getName(), "vector")) {
                        og.i("Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG, WEBP");
                        return;
                    }
                    AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                    uc ucVar = new uc(xml);
                    int[] iArr = ba0.a;
                    TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSetAsAttributeSet, iArr) : theme.obtainStyledAttributes(attributeSetAsAttributeSet, iArr, 0, 0);
                    ucVar.c(typedArrayObtainAttributes.getChangingConfigurations());
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
                        typedArray = typedArrayObtainAttributes;
                        z = typedArray.getBoolean(5, false);
                    } else {
                        typedArray = typedArrayObtainAttributes;
                        z = false;
                    }
                    ucVar.c(typedArray.getChangingConfigurations());
                    float fB = ucVar.b(typedArray, "viewportWidth", 7, 0.0f);
                    float fB2 = ucVar.b(typedArray, "viewportHeight", 8, 0.0f);
                    if (fB <= 0.0f) {
                        throw new XmlPullParserException(typedArray.getPositionDescription() + "<VectorGraphic> tag requires viewportWidth > 0");
                    }
                    if (fB2 <= 0.0f) {
                        throw new XmlPullParserException(typedArray.getPositionDescription() + "<VectorGraphic> tag requires viewportHeight > 0");
                    }
                    float dimension = typedArray.getDimension(3, 0.0f);
                    ucVar.c(typedArray.getChangingConfigurations());
                    float dimension2 = typedArray.getDimension(2, 0.0f);
                    ucVar.c(typedArray.getChangingConfigurations());
                    if (typedArray.hasValue(1)) {
                        TypedValue typedValue2 = new TypedValue();
                        typedArray.getValue(1, typedValue2);
                        if (typedValue2.type == 2) {
                            jB = sz.g;
                            i4 = i16;
                        } else {
                            if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
                                TypedValue typedValue3 = new TypedValue();
                                typedArray.getValue(1, typedValue3);
                                int i19 = typedValue3.type;
                                if (i19 == 2) {
                                    throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue3);
                                }
                                if (i19 < 28 || i19 > 31) {
                                    Resources resources2 = typedArray.getResources();
                                    i4 = i16;
                                    int resourceId = typedArray.getResourceId(1, 0);
                                    ThreadLocal threadLocal = e00.a;
                                    try {
                                        colorStateListA = e00.a(resources2, resources2.getXml(resourceId), theme);
                                    } catch (Exception e2) {
                                        Log.e("CSLCompat", "Failed to inflate ColorStateList.", e2);
                                        colorStateListA = null;
                                    }
                                } else {
                                    colorStateListA = ColorStateList.valueOf(typedValue3.data);
                                    i4 = i16;
                                }
                                ucVar.c(typedArray.getChangingConfigurations());
                                if (colorStateListA != null) {
                                    jB = ki4.b(colorStateListA.getDefaultColor());
                                } else {
                                    jB = sz.g;
                                }
                            } else {
                                i4 = i16;
                            }
                            colorStateListA = null;
                            ucVar.c(typedArray.getChangingConfigurations());
                            if (colorStateListA != null) {
                                jB = ki4.b(colorStateListA.getDefaultColor());
                            } else {
                                jB = sz.g;
                            }
                        }
                    } else {
                        i4 = i16;
                        jB = sz.g;
                    }
                    int i20 = typedArray.getInt(6, -1);
                    ucVar.c(typedArray.getChangingConfigurations());
                    if (i20 == -1) {
                        i5 = 5;
                    } else if (i20 == 3) {
                        i5 = 3;
                    } else if (i20 == 5) {
                        i5 = 5;
                    } else if (i20 != 9) {
                        switch (i20) {
                            case 14:
                                i5 = 13;
                                break;
                            case 15:
                                i5 = 14;
                                break;
                            case 16:
                                i5 = 12;
                                break;
                            default:
                                i5 = 5;
                                break;
                        }
                    } else {
                        i5 = 9;
                    }
                    float f = dimension / resources.getDisplayMetrics().density;
                    float f2 = dimension2 / resources.getDisplayMetrics().density;
                    typedArray.recycle();
                    ArrayList arrayList = new ArrayList();
                    ez0 ez0Var = new ez0(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, UCharacterProperty.MAX_SCRIPT);
                    arrayList.add(ez0Var);
                    int i21 = 0;
                    while (true) {
                        i6 = i5;
                        if (xml.getEventType() == 1 || (xml.getDepth() < 1 && xml.getEventType() == 3)) {
                        }
                        List listA = ii0.a;
                        XmlPullParser xmlPullParser = ucVar.a;
                        o4 o4Var = ucVar.c;
                        XmlResourceParser xmlResourceParser = xml;
                        int eventType = xmlPullParser.getEventType();
                        int i22 = i18;
                        if (eventType == 2) {
                            String name = xmlPullParser.getName();
                            if (name != null) {
                                int iHashCode = name.hashCode();
                                if (iHashCode != -1649314686) {
                                    if (iHashCode != 3433509) {
                                        if (iHashCode == 98629247 && name.equals("group")) {
                                            int[] iArr2 = ba0.b;
                                            TypedArray typedArrayObtainAttributes2 = theme == null ? resources.obtainAttributes(attributeSetAsAttributeSet, iArr2) : theme.obtainStyledAttributes(attributeSetAsAttributeSet, iArr2, 0, 0);
                                            ucVar.c(typedArrayObtainAttributes2.getChangingConfigurations());
                                            float fB3 = ucVar.b(typedArrayObtainAttributes2, "rotation", 5, 0.0f);
                                            float f3 = typedArrayObtainAttributes2.getFloat(1, 0.0f);
                                            ucVar.c(typedArrayObtainAttributes2.getChangingConfigurations());
                                            float f4 = typedArrayObtainAttributes2.getFloat(2, 0.0f);
                                            ucVar.c(typedArrayObtainAttributes2.getChangingConfigurations());
                                            float fB4 = ucVar.b(typedArrayObtainAttributes2, "scaleX", 3, 1.0f);
                                            float fB5 = ucVar.b(typedArrayObtainAttributes2, "scaleY", 4, 1.0f);
                                            float fB6 = ucVar.b(typedArrayObtainAttributes2, "translateX", 6, 0.0f);
                                            float fB7 = ucVar.b(typedArrayObtainAttributes2, "translateY", 7, 0.0f);
                                            String string = typedArrayObtainAttributes2.getString(0);
                                            ucVar.c(typedArrayObtainAttributes2.getChangingConfigurations());
                                            String str = string == null ? "" : string;
                                            typedArrayObtainAttributes2.recycle();
                                            int i23 = o63.a;
                                            arrayList.add(new ez0(str, fB3, f3, f4, fB4, fB5, fB6, fB7, listA, 512));
                                        }
                                    } else if (name.equals("path")) {
                                        int[] iArr3 = ba0.c;
                                        if (theme == null) {
                                            typedArrayObtainStyledAttributes2 = resources.obtainAttributes(attributeSetAsAttributeSet, iArr3);
                                            i8 = 0;
                                        } else {
                                            i8 = 0;
                                            typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSetAsAttributeSet, iArr3, 0, 0);
                                        }
                                        ucVar.c(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") == null) {
                                            og.i("No path data available");
                                            return;
                                        }
                                        String string2 = typedArrayObtainStyledAttributes2.getString(i8);
                                        ucVar.c(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                                        String str2 = string2 == null ? "" : string2;
                                        String string3 = typedArrayObtainStyledAttributes2.getString(2);
                                        ucVar.c(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                                        if (string3 == null) {
                                            int i24 = o63.a;
                                        } else {
                                            listA = o4.a(o4Var, string3);
                                        }
                                        List list = listA;
                                        c10 c10VarA = ucVar.a(typedArrayObtainStyledAttributes2, theme, "fillColor", 1);
                                        float fB8 = ucVar.b(typedArrayObtainStyledAttributes2, "fillAlpha", 12, 1.0f);
                                        int i25 = !vd4.e(ucVar.a, "strokeLineCap") ? -1 : typedArrayObtainStyledAttributes2.getInt(8, -1);
                                        ucVar.c(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                                        if (i25 == 0) {
                                            i9 = 0;
                                        } else if (i25 == 1) {
                                            i9 = 1;
                                        } else if (i25 != 2) {
                                            i9 = 0;
                                        } else {
                                            i9 = 2;
                                        }
                                        int i26 = !vd4.e(ucVar.a, "strokeLineJoin") ? -1 : typedArrayObtainStyledAttributes2.getInt(9, -1);
                                        ucVar.c(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                                        if (i26 != 0) {
                                            if (i26 == 1) {
                                                i10 = 1;
                                            } else if (i26 == 2) {
                                                i10 = 2;
                                            }
                                            float fB9 = ucVar.b(typedArrayObtainStyledAttributes2, "strokeMiterLimit", 10, 4.0f);
                                            c10 c10VarA2 = ucVar.a(typedArrayObtainStyledAttributes2, theme, "strokeColor", 3);
                                            float fB10 = ucVar.b(typedArrayObtainStyledAttributes2, "strokeAlpha", 11, 1.0f);
                                            float fB11 = ucVar.b(typedArrayObtainStyledAttributes2, "strokeWidth", 4, 1.0f);
                                            float fB12 = ucVar.b(typedArrayObtainStyledAttributes2, "trimPathEnd", 6, 1.0f);
                                            float fB13 = ucVar.b(typedArrayObtainStyledAttributes2, "trimPathOffset", 7, 0.0f);
                                            float fB14 = ucVar.b(typedArrayObtainStyledAttributes2, "trimPathStart", 5, 0.0f);
                                            if (vd4.e(ucVar.a, "fillType")) {
                                                c = '\r';
                                                i11 = typedArrayObtainStyledAttributes2.getInt(13, 0);
                                            } else {
                                                c = '\r';
                                                i11 = 0;
                                            }
                                            ucVar.c(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                                            typedArrayObtainStyledAttributes2.recycle();
                                            shader = (Shader) c10VarA.b;
                                            i12 = c10VarA.a;
                                            if (shader == null && i12 == 0) {
                                                cn2Var = null;
                                            } else if (shader != null) {
                                                cn2Var = new in(shader);
                                            } else {
                                                cn2Var = new cn2(ki4.b(i12));
                                            }
                                            shader2 = (Shader) c10VarA2.b;
                                            i13 = c10VarA2.a;
                                            if (shader2 == null && i13 == 0) {
                                                cn2Var2 = null;
                                            } else if (shader2 != null) {
                                                cn2Var2 = new in(shader2);
                                            } else {
                                                cn2Var2 = new cn2(ki4.b(i13));
                                            }
                                            if (i11 == 0) {
                                                i14 = 0;
                                            } else {
                                                i14 = 1;
                                            }
                                            ((ez0) arrayList.get(arrayList.size() - 1)).j.add(new r63(str2, list, i14, cn2Var, fB8, cn2Var2, fB10, fB11, i9, i10, fB9, fB14, fB12, fB13));
                                        }
                                        i10 = 0;
                                        float fB15 = ucVar.b(typedArrayObtainStyledAttributes2, "strokeMiterLimit", 10, 4.0f);
                                        c10 c10VarA3 = ucVar.a(typedArrayObtainStyledAttributes2, theme, "strokeColor", 3);
                                        float fB16 = ucVar.b(typedArrayObtainStyledAttributes2, "strokeAlpha", 11, 1.0f);
                                        float fB17 = ucVar.b(typedArrayObtainStyledAttributes2, "strokeWidth", 4, 1.0f);
                                        float fB18 = ucVar.b(typedArrayObtainStyledAttributes2, "trimPathEnd", 6, 1.0f);
                                        float fB19 = ucVar.b(typedArrayObtainStyledAttributes2, "trimPathOffset", 7, 0.0f);
                                        float fB110 = ucVar.b(typedArrayObtainStyledAttributes2, "trimPathStart", 5, 0.0f);
                                        if (vd4.e(ucVar.a, "fillType")) {
                                            c = '\r';
                                            i11 = 0;
                                        } else {
                                            c = '\r';
                                            i11 = typedArrayObtainStyledAttributes2.getInt(13, 0);
                                        }
                                        ucVar.c(typedArrayObtainStyledAttributes2.getChangingConfigurations());
                                        typedArrayObtainStyledAttributes2.recycle();
                                        shader = (Shader) c10VarA.b;
                                        i12 = c10VarA.a;
                                        if (shader == null) {
                                            cn2Var = null;
                                        } else if (shader != null) {
                                            cn2Var = new in(shader);
                                        } else {
                                            cn2Var = new cn2(ki4.b(i12));
                                        }
                                        shader2 = (Shader) c10VarA3.b;
                                        i13 = c10VarA3.a;
                                        if (shader2 == null) {
                                            cn2Var2 = null;
                                        } else if (shader2 != null) {
                                            cn2Var2 = new in(shader2);
                                        } else {
                                            cn2Var2 = new cn2(ki4.b(i13));
                                        }
                                        if (i11 == 0) {
                                            i14 = 0;
                                        } else {
                                            i14 = 1;
                                        }
                                        ((ez0) arrayList.get(arrayList.size() - 1)).j.add(new r63(str2, list, i14, cn2Var, fB8, cn2Var2, fB16, fB17, i9, i10, fB15, fB110, fB18, fB19));
                                    }
                                } else if (name.equals("clip-path")) {
                                    int[] iArr4 = ba0.d;
                                    if (theme == null) {
                                        typedArrayObtainStyledAttributes = resources.obtainAttributes(attributeSetAsAttributeSet, iArr4);
                                        i7 = 0;
                                    } else {
                                        i7 = 0;
                                        typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSetAsAttributeSet, iArr4, 0, 0);
                                    }
                                    ucVar.c(typedArrayObtainStyledAttributes.getChangingConfigurations());
                                    String string4 = typedArrayObtainStyledAttributes.getString(i7);
                                    ucVar.c(typedArrayObtainStyledAttributes.getChangingConfigurations());
                                    String str3 = string4 == null ? "" : string4;
                                    String string5 = typedArrayObtainStyledAttributes.getString(1);
                                    ucVar.c(typedArrayObtainStyledAttributes.getChangingConfigurations());
                                    if (string5 == null) {
                                        int i27 = o63.a;
                                    } else {
                                        listA = o4.a(o4Var, string5);
                                    }
                                    List list2 = listA;
                                    typedArrayObtainStyledAttributes.recycle();
                                    arrayList.add(new ez0(str3, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, list2, 512));
                                    i21++;
                                }
                            }
                        } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            int i28 = 0;
                            for (int i29 = i21 + 1; i28 < i29; i29 = i29) {
                                ez0 ez0Var2 = (ez0) arrayList.remove(arrayList.size() - 1);
                                ((ez0) arrayList.get(arrayList.size() - 1)).j.add(new n63(ez0Var2.a, ez0Var2.b, ez0Var2.c, ez0Var2.d, ez0Var2.e, ez0Var2.f, ez0Var2.g, ez0Var2.h, ez0Var2.i, ez0Var2.j));
                                i28++;
                            }
                            i21 = 0;
                        }
                        xmlResourceParser.next();
                        i5 = i6;
                        xml = xmlResourceParser;
                        i18 = i22;
                    }
                    int i30 = i18 | ucVar.b;
                    while (arrayList.size() > 1) {
                        ez0 ez0Var3 = (ez0) arrayList.remove(arrayList.size() - 1);
                        ((ez0) arrayList.get(arrayList.size() - 1)).j.add(new n63(ez0Var3.a, ez0Var3.b, ez0Var3.c, ez0Var3.d, ez0Var3.e, ez0Var3.f, ez0Var3.g, ez0Var3.h, ez0Var3.i, ez0Var3.j));
                    }
                    gz0 gz0Var2 = new gz0(new fz0("", f, f2, fB, fB2, new n63(ez0Var.a, ez0Var.b, ez0Var.c, ez0Var.d, ez0Var.e, ez0Var.f, ez0Var.g, ez0Var.h, ez0Var.i, ez0Var.j), jB, i6, z), i30);
                    iz0Var.a.put(hz0Var, new WeakReference(gz0Var2));
                    gz0Var = gz0Var2;
                } else {
                    i4 = i16;
                }
                fz0 fz0Var = gz0Var.a;
                jc0 jc0Var = (jc0) x20Var.j(l30.h);
                boolean zE = x20Var.e((((long) Float.floatToRawIntBits(fz0Var.j)) << i3) | (((long) Float.floatToRawIntBits(jc0Var.b())) & 4294967295L));
                Object objL3 = x20Var.L();
                if (zE || objL3 == r20.a) {
                    kv0 kv0Var = new kv0();
                    qe4.a(kv0Var, fz0Var.f);
                    long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(jc0Var.x(fz0Var.b))) << i3) | (((long) Float.floatToRawIntBits(jc0Var.x(fz0Var.c))) & 4294967295L);
                    float fIntBitsToFloat = fz0Var.d;
                    float fIntBitsToFloat2 = fz0Var.e;
                    if (Float.isNaN(fIntBitsToFloat)) {
                        fIntBitsToFloat = Float.intBitsToFloat((int) (jFloatToRawIntBits >> i3));
                    }
                    if (Float.isNaN(fIntBitsToFloat2)) {
                        fIntBitsToFloat2 = Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L));
                    }
                    long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << i3) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
                    q63 q63Var = new q63(kv0Var);
                    String str4 = fz0Var.a;
                    long j3 = fz0Var.g;
                    nl nlVar2 = j3 != 16 ? new nl(fz0Var.h, j3) : null;
                    boolean z2 = fz0Var.i;
                    q63Var.e.setValue(new xk2(jFloatToRawIntBits));
                    q63Var.f.setValue(Boolean.valueOf(z2));
                    k63 k63Var = q63Var.g;
                    k63Var.g.setValue(nlVar2);
                    k63Var.i.setValue(new xk2(jFloatToRawIntBits2));
                    k63Var.c = str4;
                    x20Var.g0(q63Var);
                    objL3 = q63Var;
                }
                mlVar = (q63) objL3;
                x20Var.p(false);
                obj = null;
            }
            boolean z3 = (i4 & 112) == i3;
            Object objL4 = x20Var.L();
            if (z3 || objL4 == r20.a) {
                if (j == 16) {
                    nlVar = obj;
                    j2 = j;
                } else {
                    j2 = j;
                    nlVar = new nl(5, j2);
                }
                x20Var.g0(nlVar);
                objL4 = nlVar;
            } else {
                j2 = j;
            }
            gm.a(w44.g(bk1.a, s50.e).c(new ut1(mlVar, (nl) objL4)), x20Var, 0);
        } else {
            x20Var.R();
        }
        a42 a42VarR2 = x20Var.r();
        if (a42VarR2 != null) {
            final int i31 = 0;
            a42VarR2.d = new vq0() { // from class: hb0
                @Override // defpackage.vq0
                public final Object e(Object obj3, Object obj4) throws XmlPullParserException, IOException {
                    int i110 = i31;
                    q43 q43Var = q43.a;
                    int i111 = i2;
                    long j4 = j2;
                    int i210 = i;
                    x20 x20Var2 = (x20) obj3;
                    ((Integer) obj4).getClass();
                    switch (i110) {
                        case 0:
                            jb0.b(i210, j4, x20Var2, ny3.c(i111 | 1));
                            break;
                        default:
                            jb0.b(i210, j4, x20Var2, ny3.c(i111 | 1));
                            break;
                    }
                    return q43Var;
                }
            };
        }
    }

    public static final void c(ox2 ox2Var, dx2 dx2Var, fq0 fq0Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(-2040393164);
        int i3 = 4;
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? x20Var.f(ox2Var) : x20Var.h(ox2Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? x20Var.f(dx2Var) : x20Var.h(dx2Var) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.h(fq0Var) ? 256 : 128;
        }
        boolean z = false;
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            boolean z2 = (i2 & 112) == 32 || ((i2 & 64) != 0 && x20Var.f(dx2Var));
            Object objL = x20Var.L();
            xy xyVar = r20.a;
            if (z2 || objL == xyVar) {
                objL = new lg1(new q82(new zb(5, dx2Var, fq0Var)));
                x20Var.g0(objL);
            }
            lg1 lg1Var = (lg1) objL;
            if ((i2 & 14) == 4 || ((i2 & 8) != 0 && x20Var.h(ox2Var))) {
                z = true;
            }
            Object objL2 = x20Var.L();
            if (z || objL2 == xyVar) {
                objL2 = new kb(6, ox2Var);
                x20Var.g0(objL2);
            }
            fb.a(lg1Var, (fq0) objL2, a, yi4.b(1315155414, new km(i3, dx2Var, ox2Var), x20Var), x20Var, 3456, 0);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new mb(ox2Var, dx2Var, fq0Var, i, 5);
        }
    }

    public static final void d(ek1 ek1Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(1392105195);
        int i3 = 2;
        if ((i & 6) == 0) {
            i2 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.h(w10Var) ? 32 : 16;
        }
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            cf4.a(ek1Var, mx2.a, w10Var, x20Var, ((i2 << 6) & 7168) | (i2 & 14) | 432);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new gc(ek1Var, w10Var, i, i3);
        }
    }
}
