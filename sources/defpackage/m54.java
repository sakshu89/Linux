package defpackage;

import android.os.LocaleList;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LocaleSpan;
import android.text.style.RelativeSizeSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class m54 {
    public static final Object a = new Object();

    public static final float a(long j, float f, jc0 jc0Var) {
        float fC;
        long jB = b03.b(j);
        if (c03.a(jB, 4294967296L)) {
            if (jc0Var.l() <= 1.05d) {
                return jc0Var.d0(j);
            }
            fC = b03.c(j) / b03.c(jc0Var.l0(f));
        } else {
            if (!c03.a(jB, 8589934592L)) {
                return Float.NaN;
            }
            fC = b03.c(j);
        }
        return fC * f;
    }

    public static final void b(Spannable spannable, long j, int i, int i2) {
        if (j != 16) {
            spannable.setSpan(new ForegroundColorSpan(ki4.g(j)), i, i2, 33);
        }
    }

    public static final void c(Spannable spannable, long j, jc0 jc0Var, int i, int i2) {
        long jB = b03.b(j);
        if (c03.a(jB, 4294967296L)) {
            spannable.setSpan(new AbsoluteSizeSpan(hh1.f(jc0Var.d0(j)), false), i, i2, 33);
        } else if (c03.a(jB, 8589934592L)) {
            spannable.setSpan(new RelativeSizeSpan(b03.c(j)), i, i2, 33);
        }
    }

    public static final void d(Spannable spannable, ne1 ne1Var, int i, int i2) {
        if (ne1Var != null) {
            ArrayList arrayList = new ArrayList(nz.d(ne1Var));
            Iterator it = ne1Var.a.iterator();
            while (it.hasNext()) {
                arrayList.add(((me1) it.next()).a);
            }
            Locale[] localeArr = (Locale[]) arrayList.toArray(new Locale[0]);
            spannable.setSpan(new LocaleSpan(new LocaleList((Locale[]) Arrays.copyOf(localeArr, localeArr.length))), i, i2, 33);
        }
    }
}
