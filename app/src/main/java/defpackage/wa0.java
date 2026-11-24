package defpackage;

import android.content.res.Resources;
import android.os.Handler;
import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wa0 implements Runnable {
    public final /* synthetic */ int a = 1;
    public Object b;
    public Object c;
    public Object e;

    public wa0(ya0 ya0Var, pj pjVar, hi hiVar) {
        this.b = ya0Var;
        this.c = pjVar;
        this.e = hiVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        String str;
        js4 js4Var;
        switch (this.a) {
            case 0:
                ya0 ya0Var = (ya0) this.b;
                pj pjVar = (pj) this.c;
                String str2 = pjVar.a;
                hi hiVar = (hi) this.e;
                Logger logger = ya0.f;
                try {
                    p23 p23VarA = ya0Var.c.a(str2);
                    if (p23VarA == null) {
                        String str3 = "Transport backend '" + str2 + "' is not registered";
                        logger.warning(str3);
                        new IllegalArgumentException(str3);
                    } else {
                        ya0Var.e.o(new kf(ya0Var, pjVar, ((vw) p23VarA).a(hiVar), 9));
                    }
                    return;
                } catch (Exception e) {
                    logger.warning("Error scheduling event " + e.getMessage());
                    return;
                }
            case 1:
                try {
                    objCall = ((bp0) this.b).call();
                    break;
                } catch (Exception unused) {
                    objCall = null;
                }
                ((Handler) this.e).post(new or0(8, (vg0) this.c, objCall));
                return;
            default:
                nk4 nk4Var = (nk4) this.b;
                cu2 cu2Var = (cu2) this.c;
                pd4 pd4Var = pd4.INPUT_IMAGE_CONSTRUCTION;
                String str4 = (String) this.e;
                b13 b13Var = (b13) cu2Var.b;
                b13Var.b = pd4Var;
                bi4 bi4Var = (bi4) b13Var.a;
                if (bi4Var != null) {
                    str = bi4Var.d;
                    int i = w34.a;
                    if (str == null || str.isEmpty()) {
                        str = "NA";
                    }
                } else {
                    str = "NA";
                }
                i52 i52Var = new i52();
                i52Var.a = nk4Var.a;
                i52Var.b = nk4Var.b;
                synchronized (nk4.class) {
                    js4Var = nk4.j;
                    if (js4Var == null) {
                        oe1 oe1Var = new oe1(new pe1(Resources.getSystem().getConfiguration().getLocales()));
                        Object[] objArrCopyOf = new Object[4];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < oe1Var.a.a.size()) {
                            Locale locale = oe1Var.a.a.get(i2);
                            l11 l11Var = t00.a;
                            String languageTag = locale.toLanguageTag();
                            languageTag.getClass();
                            int i4 = i3 + 1;
                            int length = objArrCopyOf.length;
                            if (length < i4) {
                                int i5 = length + (length >> 1) + 1;
                                if (i5 < i4) {
                                    int iHighestOneBit = Integer.highestOneBit(i3);
                                    i5 = iHighestOneBit + iHighestOneBit;
                                }
                                if (i5 < 0) {
                                    i5 = Integer.MAX_VALUE;
                                }
                                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i5);
                            }
                            objArrCopyOf[i3] = languageTag;
                            i2++;
                            i3 = i4;
                        }
                        kl4 kl4Var = mn4.b;
                        js4Var = i3 == 0 ? js4.f : new js4(i3, objArrCopyOf);
                        nk4.j = js4Var;
                    }
                }
                i52Var.e = js4Var;
                i52Var.h = Boolean.TRUE;
                i52Var.d = str;
                i52Var.c = str4;
                i52Var.f = nk4Var.f.c() ? (String) nk4Var.f.a() : nk4Var.d.a();
                i52Var.j = 10;
                i52Var.k = Integer.valueOf(nk4Var.h);
                cu2Var.c = i52Var;
                nk4Var.c.a(cu2Var);
                return;
        }
    }

    public /* synthetic */ wa0() {
    }

    public /* synthetic */ wa0(nk4 nk4Var, cu2 cu2Var, String str) {
        this.b = nk4Var;
        this.c = cu2Var;
        this.e = str;
    }
}
