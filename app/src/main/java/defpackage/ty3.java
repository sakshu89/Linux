package defpackage;

import android.os.Binder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ty3 {
    public static final Class[] a = {Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};

    public static final fh1 a(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new fh1(matcher, charSequence);
        }
        return null;
    }

    public static final boolean b(Object obj) {
        if (obj instanceof mm2) {
            mm2 mm2Var = (mm2) obj;
            if (mm2Var.c() == el1.f || mm2Var.c() == su0.k || mm2Var.c() == ak1.i) {
                Object value = mm2Var.getValue();
                if (value == null) {
                    return true;
                }
                return b(value);
            }
        } else if (!(obj instanceof rq0) || !(obj instanceof Serializable)) {
            for (int i = 0; i < 7; i++) {
                if (a[i].isInstance(obj)) {
                    return true;
                }
            }
        }
        return false;
    }
}
