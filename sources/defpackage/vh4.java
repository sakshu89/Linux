package defpackage;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class vh4 {
    public static final ek1 a(ek1 ek1Var, yj2 yj2Var) {
        return pz3.c(ek1Var, 0.0f, yj2Var, 518143);
    }

    public static String b(AbstractList abstractList) {
        Iterator it = abstractList.iterator();
        StringBuilder sb = new StringBuilder();
        try {
            if (it.hasNext()) {
                Object next = it.next();
                Objects.requireNonNull(next);
                sb.append(next instanceof CharSequence ? (CharSequence) next : next.toString());
                while (it.hasNext()) {
                    sb.append((CharSequence) "\n");
                    Object next2 = it.next();
                    Objects.requireNonNull(next2);
                    sb.append(next2 instanceof CharSequence ? (CharSequence) next2 : next2.toString());
                }
            }
            return sb.toString();
        } catch (IOException e) {
            og.m(e);
            return null;
        }
    }
}
