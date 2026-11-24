package defpackage;

import android.content.Context;
import android.os.LocaleList;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sx1 {
    public final j70 a;
    public final Context b;
    public final hf2 c;
    public final ne1 d;
    public TextClassifier f;
    public final an1 e = new an1();
    public final ku1 g = o44.g(null);
    public final Object h = new Object();

    public sx1(j70 j70Var, Context context, hf2 hf2Var, ne1 ne1Var) {
        this.a = j70Var;
        this.b = context;
        this.c = hf2Var;
        this.d = ne1Var;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public static final Object a(sx1 sx1Var, CharSequence charSequence, long j, TextClassifier textClassifier, y50 y50Var) throws Throwable {
        qx1 qx1Var;
        long j2;
        CharSequence charSequence2;
        TextClassifier textClassifier2;
        an1 an1Var;
        Object obj;
        Object obj2;
        TextClassification textClassificationClassifyText;
        long j3;
        CharSequence charSequence3;
        an1 an1Var2 = sx1Var.e;
        ku1 ku1Var = sx1Var.g;
        if (y50Var instanceof qx1) {
            qx1Var = (qx1) y50Var;
            int i = qx1Var.s;
            if ((i & Integer.MIN_VALUE) != 0) {
                qx1Var.s = i - Integer.MIN_VALUE;
            } else {
                qx1Var = new qx1(sx1Var, y50Var);
            }
        } else {
            qx1Var = new qx1(sx1Var, y50Var);
        }
        Object obj3 = qx1Var.k;
        int i2 = qx1Var.s;
        q43 q43Var = q43.a;
        t70 t70Var = t70.a;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    j2 = qx1Var.j;
                    an1Var = qx1Var.i;
                    textClassifier2 = (TextClassifier) qx1Var.f;
                    charSequence2 = qx1Var.e;
                    bz3.g(obj3);
                } else {
                    if (i2 != 2) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    j3 = qx1Var.j;
                    an1Var2 = qx1Var.i;
                    textClassificationClassifyText = (TextClassification) qx1Var.f;
                    charSequence3 = qx1Var.e;
                    bz3.g(obj3);
                }
                try {
                    ku1Var.setValue(new yw2(charSequence3, j3, textClassificationClassifyText));
                    return q43Var;
                } finally {
                    an1Var2.h(null);
                }
            }
            bz3.g(obj3);
            qx1Var.e = charSequence;
            qx1Var.f = textClassifier;
            qx1Var.i = an1Var2;
            j2 = j;
            qx1Var.j = j2;
            qx1Var.s = 1;
            if (an1Var2.e(qx1Var) == t70Var) {
                return t70Var;
            }
            charSequence2 = charSequence;
            textClassifier2 = textClassifier;
            an1Var = an1Var2;
            yw2 yw2Var = (yw2) ku1Var.getValue();
            if (yw2Var != null) {
                try {
                    sr2 sr2Var = ux1.a;
                    if (oz2.b(j2, yw2Var.b) && g31.a(charSequence2, yw2Var.a)) {
                        an1Var.h(null);
                        return q43Var;
                    }
                    obj2 = null;
                } catch (Throwable th) {
                    th = th;
                    obj = null;
                    an1Var.h(obj);
                    throw th;
                }
            } else {
                obj2 = null;
            }
            an1Var.h(obj2);
            c2.p();
            textClassificationClassifyText = textClassifier2.classifyText(c2.f(charSequence2, oz2.f(j2), oz2.e(j2)).setDefaultLocales(sx1Var.b()).build());
            qx1Var.e = charSequence2;
            qx1Var.f = textClassificationClassifyText;
            qx1Var.i = an1Var2;
            qx1Var.j = j2;
            qx1Var.s = 2;
            if (an1Var2.e(qx1Var) == t70Var) {
                return t70Var;
            }
            j3 = j2;
            charSequence3 = charSequence2;
            ku1Var.setValue(new yw2(charSequence3, j3, textClassificationClassifyText));
            return q43Var;
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
    }

    public final LocaleList b() {
        ne1 ne1Var = this.d;
        if (ne1Var == null) {
            return new LocaleList(((me1) gx1.a.n().a.get(0)).a);
        }
        ArrayList arrayList = new ArrayList(nz.d(ne1Var));
        Iterator it = ne1Var.a.iterator();
        while (it.hasNext()) {
            arrayList.add(((me1) it.next()).a);
        }
        Locale[] localeArr = (Locale[]) arrayList.toArray(new Locale[0]);
        return new LocaleList((Locale[]) Arrays.copyOf(localeArr, localeArr.length));
    }
}
