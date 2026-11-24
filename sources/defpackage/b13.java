package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Set;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b13 implements pi0 {
    public Object a;
    public Object b;
    public Object c;

    public b13(int i) {
        switch (i) {
            case 5:
                this.a = new HashMap();
                this.b = new HashMap();
                this.c = r41.d;
                break;
            default:
                this.a = new WeakHashMap();
                this.b = new WeakHashMap();
                this.c = new WeakHashMap();
                break;
        }
    }

    @Override // defpackage.pi0
    public /* bridge */ /* synthetic */ pi0 a(Class cls, vo1 vo1Var) {
        ((HashMap) this.a).put(cls, vo1Var);
        ((HashMap) this.b).remove(cls);
        return this;
    }

    public Object b() {
        Object objRemoveLast;
        synchronized (this.b) {
            objRemoveLast = ((ArrayDeque) this.a).removeLast();
        }
        return objRemoveLast;
    }

    public void c(zy0 zy0Var) throws Exception {
        Object objB;
        vy0 vy0VarM = zy0Var.m();
        ls lsVar = vy0VarM instanceof ms ? ((ms) vy0VarM).a : null;
        if ((lsVar.o() != is.i && lsVar.o() != is.e) || lsVar.j() != hs.f || lsVar.k() != js.e) {
            ((kf2) this.c).getClass();
            zy0Var.close();
            return;
        }
        synchronized (this.b) {
            try {
                objB = ((ArrayDeque) this.a).size() >= 3 ? b() : null;
                ((ArrayDeque) this.a).addFirst(zy0Var);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (((kf2) this.c) == null || objB == null) {
            return;
        }
        ((zy0) objB).close();
    }

    public Drawable d(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.b;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : s62.c().d((Context) this.a, resourceId);
    }

    public Typeface e(int i, int i2, ye yeVar) throws Exception {
        int i3 = 0;
        int resourceId = ((TypedArray) this.b).getResourceId(i, 0);
        if (resourceId != 0) {
            if (((TypedValue) this.c) == null) {
                this.c = new TypedValue();
            }
            Context context = (Context) this.a;
            TypedValue typedValue = (TypedValue) this.c;
            ThreadLocal threadLocal = w62.a;
            if (!context.isRestricted()) {
                Resources resources = context.getResources();
                resources.getValue(resourceId, typedValue, true);
                CharSequence charSequence = typedValue.string;
                if (charSequence == null) {
                    throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(resourceId) + "\" (" + Integer.toHexString(resourceId) + ") is not a Font: " + typedValue);
                }
                String string = charSequence.toString();
                if (!string.startsWith("res/")) {
                    yeVar.a(-3);
                    return null;
                }
                int i4 = typedValue.assetCookie;
                tf1 tf1Var = l33.b;
                Typeface typeface = (Typeface) tf1Var.a(l33.b(resources, resourceId, string, i4, i2));
                if (typeface != null) {
                    new Handler(Looper.getMainLooper()).post(new v62(i3, yeVar, typeface));
                    return typeface;
                }
                try {
                    if (string.toLowerCase().endsWith(".xml")) {
                        ep0 ep0VarA = zn4.a(resources.getXml(resourceId), resources);
                        if (ep0VarA != null) {
                            return l33.a(context, ep0VarA, resources, resourceId, string, typedValue.assetCookie, i2, yeVar, true);
                        }
                        Log.e("ResourcesCompat", "Failed to find font-family tag");
                        yeVar.a(-3);
                        return null;
                    }
                    int i5 = typedValue.assetCookie;
                    Typeface typefaceD = l33.a.d(context, resources, resourceId, string);
                    if (typefaceD != null) {
                        tf1Var.b(l33.b(resources, resourceId, string, i5, i2), typefaceD);
                    }
                    if (typefaceD != null) {
                        new Handler(Looper.getMainLooper()).post(new v62(i3, yeVar, typefaceD));
                    } else {
                        yeVar.a(-3);
                    }
                    return typefaceD;
                } catch (IOException e) {
                    Log.e("ResourcesCompat", "Failed to read xml resource ".concat(string), e);
                    yeVar.a(-3);
                    return null;
                } catch (XmlPullParserException e2) {
                    Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(string), e2);
                    yeVar.a(-3);
                    return null;
                }
            }
        }
        return null;
    }

    public q23 f(qi0 qi0Var, b23 b23Var) {
        Set set = (Set) this.a;
        if (set.contains(qi0Var)) {
            return new q23((pj) this.b, qi0Var, b23Var, (r23) this.c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", qi0Var, set));
    }

    public boolean g() {
        if (((gr2) this.a).getValue() != this.c) {
            return true;
        }
        b13 b13Var = (b13) this.b;
        return b13Var != null && b13Var.g();
    }

    public void h() {
        ((TypedArray) this.b).recycle();
    }

    public b13(Context context, TypedArray typedArray) {
        this.a = context;
        this.b = typedArray;
    }

    public b13(t33 t33Var, b13 b13Var) {
        this.a = t33Var;
        this.b = b13Var;
        this.c = t33Var.a;
    }
}
