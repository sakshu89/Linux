package defpackage;

import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ay {
    public static final List a = nz.i("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine");
    public static final Set b = wh2.c('.', '?', '!');

    public static String a(String str) {
        String string = cs2.X(str).toString();
        Set set = b;
        string.getClass();
        return mz.s(string.length() == 0 ? null : Character.valueOf(string.charAt(string.length() + (-1))), set) ? string : ky0.j(string, ".");
    }
}
