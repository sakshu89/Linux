package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c10 implements u63 {
    public int a;
    public Object b;

    public c10(int i, tg0 tg0Var) {
        this.a = i;
        this.b = new p6((im0) new km0(i, tg0Var));
    }

    public static c10 i(Resources resources, int i, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        int i2;
        int color;
        float f;
        float f2;
        Shader.TileMode tileMode;
        Object radialGradient;
        Shader.TileMode tileMode2;
        int i3;
        TypedArray typedArrayObtainStyledAttributes;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.getClass();
        Object obj = null;
        if (!name.equals("gradient")) {
            if (name.equals("selector")) {
                return new c10(e00.b(resources, xml, attributeSetAsAttributeSet, theme).getDefaultColor(), obj);
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        String name2 = xml.getName();
        if (!name2.equals("gradient")) {
            throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
        }
        int[] iArr = m22.e;
        TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSetAsAttributeSet, iArr) : theme.obtainStyledAttributes(attributeSetAsAttributeSet, iArr, 0, 0);
        float f3 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startX") != null ? typedArrayObtainAttributes.getFloat(8, 0.0f) : 0.0f;
        float f4 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startY") != null ? typedArrayObtainAttributes.getFloat(9, 0.0f) : 0.0f;
        float f5 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endX") != null ? typedArrayObtainAttributes.getFloat(10, 0.0f) : 0.0f;
        float f6 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endY") != null ? typedArrayObtainAttributes.getFloat(11, 0.0f) : 0.0f;
        float f7 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerX") != null ? typedArrayObtainAttributes.getFloat(3, 0.0f) : 0.0f;
        float f8 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerY") != null ? typedArrayObtainAttributes.getFloat(4, 0.0f) : 0.0f;
        int i4 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "type") != null ? typedArrayObtainAttributes.getInt(2, 0) : 0;
        int color2 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startColor") != null ? typedArrayObtainAttributes.getColor(0, 0) : 0;
        boolean z = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null;
        int color3 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null ? typedArrayObtainAttributes.getColor(7, 0) : 0;
        if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endColor") != null) {
            i2 = 0;
            color = typedArrayObtainAttributes.getColor(1, 0);
        } else {
            i2 = 0;
            color = 0;
        }
        int i5 = 1;
        int i6 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "tileMode") != null ? typedArrayObtainAttributes.getInt(6, i2) : 0;
        float f9 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "gradientRadius") != null ? typedArrayObtainAttributes.getFloat(5, 0.0f) : 0.0f;
        typedArrayObtainAttributes.recycle();
        int depth = xml.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        float f10 = f9;
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next2 = xml.next();
            f = f3;
            if (next2 == i5) {
                f2 = f4;
                break;
            }
            int depth2 = xml.getDepth();
            f2 = f4;
            if (depth2 < depth && next2 == 3) {
                break;
            }
            if (next2 == 2 && depth2 <= depth && xml.getName().equals("item")) {
                int[] iArr2 = m22.f;
                if (theme == null) {
                    typedArrayObtainStyledAttributes = resources.obtainAttributes(attributeSetAsAttributeSet, iArr2);
                    i3 = 0;
                } else {
                    i3 = 0;
                    typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSetAsAttributeSet, iArr2, 0, 0);
                }
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i3);
                boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(1);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xml.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color4 = typedArrayObtainStyledAttributes.getColor(0, 0);
                float f11 = typedArrayObtainStyledAttributes.getFloat(1, 0.0f);
                typedArrayObtainStyledAttributes.recycle();
                arrayList2.add(Integer.valueOf(color4));
                arrayList.add(Float.valueOf(f11));
            }
            f3 = f;
            f4 = f2;
            i5 = 1;
        }
        zo zoVar = arrayList2.size() > 0 ? new zo(arrayList2, arrayList) : null;
        if (zoVar == null) {
            zoVar = z ? new zo(color2, color3, color) : new zo(color2, color);
        }
        if (i4 != 1) {
            if (i4 != 2) {
                int[] iArr3 = zoVar.a;
                float[] fArr = zoVar.b;
                if (i6 != 1) {
                    tileMode2 = i6 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
                } else {
                    tileMode2 = Shader.TileMode.REPEAT;
                }
                radialGradient = new LinearGradient(f, f2, f5, f6, iArr3, fArr, tileMode2);
            } else {
                radialGradient = new SweepGradient(f7, f8, zoVar.a, zoVar.b);
            }
        } else {
            if (f10 <= 0.0f) {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
            int[] iArr4 = zoVar.a;
            float[] fArr2 = zoVar.b;
            if (i6 != 1) {
                tileMode = i6 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
            } else {
                tileMode = Shader.TileMode.REPEAT;
            }
            radialGradient = new RadialGradient(f7, f8, f10, iArr4, fArr2, tileMode);
        }
        return new c10(0, radialGradient);
    }

    public void b(long j) {
        if (d(j)) {
            return;
        }
        int i = this.a;
        long[] jArrCopyOf = (long[]) this.b;
        if (i >= jArrCopyOf.length) {
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, Math.max(i + 1, jArrCopyOf.length * 2));
            this.b = jArrCopyOf;
        }
        jArrCopyOf[i] = j;
        if (i >= this.a) {
            this.a = i + 1;
        }
    }

    public boolean c() {
        return this.a >= ((String) this.b).length();
    }

    public boolean d(long j) {
        int i = this.a;
        for (int i2 = 0; i2 < i; i2++) {
            if (((long[]) this.b)[i2] == j) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.u63
    public int e() {
        return 0;
    }

    @Override // defpackage.s63
    public vd f(long j, vd vdVar, vd vdVar2, vd vdVar3) {
        return ((p6) this.b).f(j, vdVar, vdVar2, vdVar3);
    }

    @Override // defpackage.u63
    public int g() {
        return this.a;
    }

    @Override // defpackage.s63
    public vd h(long j, vd vdVar, vd vdVar2, vd vdVar3) {
        return ((p6) this.b).h(j, vdVar, vdVar2, vdVar3);
    }

    public qk0 j() throws pk0, ok0, rk0 {
        char cCharAt;
        qk0 qk0VarL = l();
        while (!c() && ((cCharAt = ((String) this.b).charAt(this.a)) == '+' || cCharAt == '-')) {
            boolean z = true;
            this.a++;
            qk0 qk0VarL2 = l();
            BigDecimal bigDecimalAdd = cCharAt == '+' ? qk0VarL.a.add(qk0VarL2.a) : qk0VarL.a.subtract(qk0VarL2.a);
            bigDecimalAdd.getClass();
            if (!qk0VarL.b && !qk0VarL2.b) {
                z = false;
            }
            qk0VarL = new qk0(bigDecimalAdd, z);
        }
        return qk0VarL;
    }

    public qk0 l() throws pk0, ok0, rk0 {
        char cCharAt;
        qk0 qk0Var;
        qk0 qk0Var2;
        qk0 qk0VarM = m();
        while (!c() && ((cCharAt = ((String) this.b).charAt(this.a)) == '*' || cCharAt == '/' || cCharAt == '%')) {
            boolean z = true;
            this.a++;
            qk0 qk0VarM2 = m();
            if (cCharAt == '*') {
                BigDecimal bigDecimalMultiply = qk0VarM.a.multiply(qk0VarM2.a);
                bigDecimalMultiply.getClass();
                if (!qk0VarM.b && !qk0VarM2.b) {
                    z = false;
                }
                qk0Var = new qk0(bigDecimalMultiply, z);
            } else if (cCharAt == '/') {
                BigDecimal bigDecimal = qk0VarM2.a;
                if (bigDecimal.signum() == 0) {
                    throw new ok0();
                }
                boolean z2 = qk0VarM.b;
                BigDecimal bigDecimal2 = qk0VarM.a;
                boolean z3 = z2 || qk0VarM2.b;
                try {
                    BigDecimal bigDecimalDivide = bigDecimal2.divide(bigDecimal);
                    bigDecimalDivide.getClass();
                    qk0Var2 = new qk0(bigDecimalDivide, z3);
                } catch (ArithmeticException unused) {
                    BigDecimal bigDecimalDivide2 = bigDecimal2.divide(bigDecimal, sk0.a);
                    bigDecimalDivide2.getClass();
                    qk0Var2 = new qk0(bigDecimalDivide2, true);
                }
                qk0VarM = qk0Var2;
            } else {
                if (qk0VarM2.a.signum() == 0) {
                    throw new ok0();
                }
                BigDecimal bigDecimalRemainder = qk0VarM.a.remainder(qk0VarM2.a);
                bigDecimalRemainder.getClass();
                if (!qk0VarM.b && !qk0VarM2.b) {
                    z = false;
                }
                qk0Var = new qk0(bigDecimalRemainder, z);
            }
            qk0VarM = qk0Var;
        }
        return qk0VarM;
    }

    public qk0 m() throws pk0, ok0, rk0 {
        qk0 qk0Var;
        String str = (String) this.b;
        if (!c() && (str.charAt(this.a) == '-' || str.charAt(this.a) == '+')) {
            boolean z = str.charAt(this.a) == '-';
            this.a++;
            qk0 qk0VarM = m();
            if (!z) {
                return qk0VarM;
            }
            BigDecimal bigDecimalNegate = qk0VarM.a.negate();
            bigDecimalNegate.getClass();
            return new qk0(bigDecimalNegate, qk0VarM.b);
        }
        if (c()) {
            throw new pk0("the expression stops in the middle");
        }
        char cCharAt = str.charAt(this.a);
        int i = this.a;
        if (cCharAt == '(') {
            this.a = i + 1;
            qk0Var = j();
            if (c() || str.charAt(this.a) != ')') {
                throw new pk0("there's a bracket that never closes");
            }
            this.a++;
        } else {
            while (!c() && (Character.isDigit(str.charAt(this.a)) || str.charAt(this.a) == '.')) {
                this.a++;
            }
            int i2 = this.a;
            if (i == i2) {
                throw new pk0(cq.v("I expected a number at \"", cs2.T(12, str.substring(this.a)), "\""));
            }
            String strSubstring = str.substring(i, i2);
            int i3 = 0;
            for (int i4 = 0; i4 < strSubstring.length(); i4++) {
                if (strSubstring.charAt(i4) == '.') {
                    i3++;
                }
            }
            if (i3 > 1 || strSubstring.equals(".")) {
                throw new pk0(cq.v("\"", strSubstring, "\" isn't a number"));
            }
            if (strSubstring.length() > 100) {
                throw new rk0("that number has more digits than I can work with");
            }
            qk0Var = new qk0(new BigDecimal(strSubstring), false);
        }
        if (c() || str.charAt(this.a) != '^') {
            return qk0Var;
        }
        this.a++;
        qk0 qk0VarM2 = m();
        try {
            try {
                int iIntValueExact = qk0VarM2.a.setScale(0, RoundingMode.UNNECESSARY).intValueExact();
                if (Math.abs(iIntValueExact) > 1000) {
                    throw new rk0(cq.h("I won't raise anything to the power of ", iIntValueExact, " — the answer would have more digits than there are stars"));
                }
                BigDecimal bigDecimal = qk0Var.a;
                boolean z2 = qk0Var.b;
                long jPrecision = ((long) bigDecimal.precision()) * ((long) Math.abs(iIntValueExact));
                if (jPrecision > 10000) {
                    throw new rk0("that answer would be about " + jPrecision + " digits long");
                }
                if (iIntValueExact >= 0) {
                    BigDecimal bigDecimalPow = bigDecimal.pow(iIntValueExact);
                    bigDecimalPow.getClass();
                    return new qk0(bigDecimalPow, z2);
                }
                if (bigDecimal.signum() == 0) {
                    throw new ok0();
                }
                BigDecimal bigDecimalPow2 = bigDecimal.pow(-iIntValueExact);
                BigDecimal bigDecimal2 = BigDecimal.ONE;
                bigDecimal2.getClass();
                bigDecimalPow2.getClass();
                if (bigDecimalPow2.signum() == 0) {
                    throw new ok0();
                }
                try {
                    BigDecimal bigDecimalDivide = bigDecimal2.divide(bigDecimalPow2);
                    bigDecimalDivide.getClass();
                    return new qk0(bigDecimalDivide, z2);
                } catch (ArithmeticException unused) {
                    BigDecimal bigDecimalDivide2 = bigDecimal2.divide(bigDecimalPow2, sk0.a);
                    bigDecimalDivide2.getClass();
                    return new qk0(bigDecimalDivide2, true);
                }
            } catch (ArithmeticException unused2) {
                throw new rk0("that power is far too large");
            }
        } catch (ArithmeticException unused3) {
            MathContext mathContext = sk0.a;
            throw new rk0("I can only raise things to whole-number powers, not ".concat(sk0.a(qk0VarM2.a)));
        }
    }

    public void n(long j) {
        int i = this.a;
        int i2 = 0;
        while (i2 < i) {
            if (j == ((long[]) this.b)[i2]) {
                int i3 = this.a - 1;
                while (i2 < i3) {
                    long[] jArr = (long[]) this.b;
                    int i4 = i2 + 1;
                    jArr[i2] = jArr[i4];
                    i2 = i4;
                }
                this.a--;
                return;
            }
            i2++;
        }
    }

    public c10(int i) {
        this.a = i;
        this.b = new HashMap();
    }

    public c10(x30 x30Var, int i) {
        jg1.d(x30Var);
        this.b = x30Var;
        this.a = i;
    }

    public /* synthetic */ c10(int i, Object obj) {
        this.b = obj;
        this.a = i;
    }
}
