package defpackage;

import android.os.Trace;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import java.io.File;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ta extends k61 implements fq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ta(int i, Object obj) {
        super(0);
        this.b = i;
        this.c = obj;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x007c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x007e A[LOOP:0: B:13:0x0049->B:23:0x007e, LOOP_END] */
    @Override // defpackage.fq0
    public final Object a() {
        g30 g30Var;
        y61 y61Var = null;
        boolean z = false;
        switch (this.b) {
            case 0:
                tl4.b(((ua) this.c).c, null);
                return q43.a;
            case 1:
                return q43.a;
            case 2:
                j23 j23Var = (j23) this.c;
                Object objC = j23Var.c();
                si0 si0Var = si0.c;
                if (objC == si0Var && j23Var.d.getValue() == si0Var) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 3:
                Object obj = kl0.d;
                File file = (File) this.c;
                synchronized (obj) {
                    kl0.c.remove(file.getAbsolutePath());
                }
                return q43.a;
            case 4:
                ((ko0) this.c).K0();
                return q43.a;
            case 5:
                return (List) this.c;
            case 6:
                try {
                    return (List) ((fq0) this.c).a();
                } catch (SSLPeerUnverifiedException unused) {
                    return ii0.a;
                }
            case 7:
                Object systemService = ((View) ((kf) this.c).b).getContext().getSystemService("input_method");
                systemService.getClass();
                return (InputMethodManager) systemService;
            case 8:
                r71 r71Var = ((n71) this.c).p0;
                r71Var.p.h0 = true;
                sf1 sf1Var = r71Var.q;
                if (sf1Var != null) {
                    sf1Var.Z = true;
                }
                return q43.a;
            case 9:
                t71 t71Var = (t71) this.c;
                if (!((Boolean) t71Var.g.getValue()).booleanValue() && (g30Var = t71Var.c) != null) {
                    g30Var.l();
                }
                return q43.a;
            case 10:
                mg1 mg1Var = (mg1) ((sb1) this.c).a.b;
                if (!mg1Var.b) {
                    if (mg1Var.c) {
                        ez1.a("ManagedValuesStore tried to enter composition twice. Did you attempt to install the same store multiple times or into two compositions?");
                    }
                    mg1Var.a();
                    mg1Var.c = true;
                }
                return q43.a;
            case 11:
                return (s70) ((p6) this.c).e;
            case 12:
                return ((jn1) this.c).I0();
            case 13:
                yy1 yy1Var = (yy1) this.c;
                y61 parentLayoutCoordinates = yy1Var.getParentLayoutCoordinates();
                if (parentLayoutCoordinates != null && parentLayoutCoordinates.B()) {
                    y61Var = parentLayoutCoordinates;
                }
                if (y61Var != null && yy1Var.m38getPopupContentSizebOM6tXw() != null) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 14:
                File file2 = (File) ((h7) this.c).a();
                String name = file2.getName();
                name.getClass();
                int iC = cs2.C(name, '.', 0, 6);
                if (!(iC != -1 ? name.substring(iC + 1, name.length()) : "").equals("preferences_pb")) {
                    dk0.i("File extension for file: ", file2, " does not match required extension for Preferences file: preferences_pb");
                    return null;
                }
                File absoluteFile = file2.getAbsoluteFile();
                absoluteFile.getClass();
                return absoluteFile;
            case 15:
                n42 n42Var = (n42) this.c;
                n42Var.g = null;
                Trace.beginSection("OnPositionedDispatch");
                try {
                    n42Var.a();
                    return q43.a;
                } finally {
                    Trace.endSection();
                }
            case 16:
                b81 b81VarA = ((ws2) this.c).a();
                n71 n71Var = b81VarA.a;
                if (b81VarA.w != ((pm1) ((wl1) n71Var.o()).b).c) {
                    gm1 gm1Var = b81VarA.i;
                    Object[] objArr = gm1Var.c;
                    long[] jArr = gm1Var.a;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i = 0;
                        while (true) {
                            long j = jArr[i];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i2 = 8 - ((~(i - length)) >>> 31);
                                for (int i3 = 0; i3 < i2; i3++) {
                                    if ((255 & j) < 128) {
                                        ((t71) objArr[(i << 3) + i3]).d = true;
                                    }
                                    j >>= 8;
                                }
                                if (i2 == 8) {
                                    if (i != length) {
                                        i++;
                                    }
                                }
                            } else if (i != length) {
                                i++;
                            }
                        }
                    }
                    if (n71Var.n != null) {
                        if (!n71Var.p0.e) {
                            n71.T(n71Var, false, 7);
                        }
                    } else if (!n71Var.q()) {
                        n71.V(n71Var, false, 7);
                    }
                }
                return q43.a;
            case 17:
                return new BaseInputConnection(((zy2) this.c).a, false);
            default:
                q63 q63Var = (q63) this.c;
                q43 q43Var = q43.a;
                q63Var.h.setValue(q43Var);
                return q43Var;
        }
    }
}
