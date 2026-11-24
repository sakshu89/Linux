package defpackage;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qa3 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ qa3(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
        this.f = obj4;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x002d  */
    @Override // java.lang.Runnable
    public final void run() {
        String str;
        q04 q04VarL;
        switch (this.a) {
            case 0:
                sa3.i((View) this.b, (xa3) this.c, (cu2) this.e);
                ((ValueAnimator) this.f).start();
                return;
            default:
                ns4 ns4Var = (ns4) this.b;
                t9 t9Var = (t9) this.c;
                jn4 jn4Var = (jn4) this.e;
                String str2 = (String) this.f;
                lj1 lj1Var = (lj1) t9Var.c;
                lj1Var.c = jn4Var;
                jr4 jr4Var = (jr4) lj1Var.b;
                if (jr4Var != null) {
                    str = jr4Var.d;
                    if (hi4.c(str)) {
                        str = "NA";
                    } else {
                        jg1.d(str);
                    }
                } else {
                    str = "NA";
                }
                i52 i52Var = new i52();
                i52Var.a = ns4Var.a;
                i52Var.b = ns4Var.b;
                synchronized (ns4.class) {
                    q04VarL = ns4.k;
                    if (q04VarL == null) {
                        oe1 oe1Var = new oe1(new pe1(Resources.getSystem().getConfiguration().getLocales()));
                        Object[] objArrCopyOf = new Object[4];
                        int i = 0;
                        int i2 = 0;
                        while (i < oe1Var.a.a.size()) {
                            Locale locale = oe1Var.a.a.get(i);
                            l11 l11Var = t00.a;
                            String languageTag = locale.toLanguageTag();
                            languageTag.getClass();
                            int i3 = i2 + 1;
                            int length = objArrCopyOf.length;
                            if (length < i3) {
                                int i4 = length + (length >> 1) + 1;
                                if (i4 < i3) {
                                    int iHighestOneBit = Integer.highestOneBit(i2);
                                    i4 = iHighestOneBit + iHighestOneBit;
                                }
                                if (i4 < 0) {
                                    i4 = Integer.MAX_VALUE;
                                }
                                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
                            }
                            objArrCopyOf[i2] = languageTag;
                            i++;
                            i2 = i3;
                        }
                        q04VarL = nz3.l(i2, objArrCopyOf);
                        ns4.k = q04VarL;
                    }
                }
                i52Var.e = q04VarL;
                i52Var.h = Boolean.TRUE;
                i52Var.d = str;
                i52Var.c = str2;
                i52Var.f = ns4Var.f.c() ? (String) ns4Var.f.a() : ns4Var.d.a();
                i52Var.j = 10;
                i52Var.k = Integer.valueOf(ns4Var.h);
                t9Var.e = i52Var;
                ns4Var.c.a(t9Var);
                return;
        }
    }
}
