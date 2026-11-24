package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ng4 {
    public static boolean a(zt ztVar, String str) throws v01 {
        if ("robolectric".equals(Build.FINGERPRINT)) {
            return true;
        }
        try {
            int[] iArr = (int[]) ztVar.b(str).a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                for (int i : iArr) {
                    if (i == 0) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ds e) {
            throw new v01(new su(e));
        }
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
