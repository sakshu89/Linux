package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uc {
    public final XmlPullParser a;
    public int b = 0;
    public final o4 c;

    public uc(XmlResourceParser xmlResourceParser) {
        this.a = xmlResourceParser;
        o4 o4Var = new o4();
        o4Var.b = new float[64];
        this.c = o4Var;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    public final c10 a(TypedArray typedArray, Resources.Theme theme, String str, int i) {
        c10 c10Var;
        if (vd4.e(this.a, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i2 = typedValue.type;
            if (i2 < 28 || i2 > 31) {
                try {
                    c10Var = c10.i(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
                } catch (Exception e) {
                    Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
                    c10Var = null;
                }
                if (c10Var == null) {
                    c10Var = new c10(0, (Object) null);
                }
            } else {
                c10Var = new c10(typedValue.data, (Object) null);
            }
        } else {
            c10Var = new c10(0, (Object) null);
        }
        c(typedArray.getChangingConfigurations());
        return c10Var;
    }

    public final float b(TypedArray typedArray, String str, int i, float f) {
        if (vd4.e(this.a, str)) {
            f = typedArray.getFloat(i, f);
        }
        c(typedArray.getChangingConfigurations());
        return f;
    }

    public final void c(int i) {
        this.b = i | this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uc)) {
            return false;
        }
        uc ucVar = (uc) obj;
        return g31.a(this.a, ucVar.a) && this.b == ucVar.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidVectorParser(xmlParser=");
        sb.append(this.a);
        sb.append(", config=");
        return ky0.m(sb, this.b, ')');
    }
}
