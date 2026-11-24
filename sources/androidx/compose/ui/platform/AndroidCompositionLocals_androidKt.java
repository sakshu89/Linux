package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import com.project.sonic.R;
import defpackage.a22;
import defpackage.a42;
import defpackage.ba2;
import defpackage.bw0;
import defpackage.bz3;
import defpackage.ca2;
import defpackage.da2;
import defpackage.f7;
import defpackage.f8;
import defpackage.h6;
import defpackage.h8;
import defpackage.hq0;
import defpackage.i10;
import defpackage.i8;
import defpackage.ie1;
import defpackage.iz0;
import defpackage.j7;
import defpackage.k8;
import defpackage.kj4;
import defpackage.l30;
import defpackage.l8;
import defpackage.le1;
import defpackage.m30;
import defpackage.m8;
import defpackage.na0;
import defpackage.na2;
import defpackage.og;
import defpackage.q43;
import defpackage.q62;
import defpackage.q91;
import defpackage.r20;
import defpackage.r7;
import defpackage.sd0;
import defpackage.sr2;
import defpackage.tc;
import defpackage.td0;
import defpackage.vq0;
import defpackage.wn1;
import defpackage.x20;
import defpackage.yi4;
import defpackage.z12;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidCompositionLocals_androidKt {
    public static final m30 a = new m30(f8.c);
    public static final sr2 b = new sr2(f8.e);
    public static final m30 c = new m30(j7.f);
    public static final sr2 d = new sr2(f8.f);
    public static final sr2 e = new sr2(f8.i);
    public static final sr2 f = new sr2(f8.j);

    public static final void a(r7 r7Var, vq0 vq0Var, x20 x20Var, int i) {
        boolean z;
        x20Var.X(-520299287);
        int i2 = (x20Var.h(r7Var) ? 4 : 2) | i | (x20Var.h(vq0Var) ? 32 : 16);
        int i3 = 1;
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            Context context = r7Var.getContext();
            Object objL = x20Var.L();
            Object obj = r20.a;
            if (objL == obj) {
                objL = new tc();
                x20Var.g0(objL);
            }
            tc tcVar = (tc) objL;
            f7 viewTreeOwners = r7Var.getViewTreeOwners();
            if (viewTreeOwners == null) {
                og.n("Called when the ViewTreeOwnersAvailability is not yet in Available state");
                return;
            }
            na2 na2Var = viewTreeOwners.b;
            Object objL2 = x20Var.L();
            if (objL2 == obj) {
                Object parent = r7Var.getParent();
                parent.getClass();
                View view = (View) parent;
                Object tag = view.getTag(R.id.compose_view_saveable_id_tag);
                LinkedHashMap linkedHashMap = null;
                String strValueOf = tag instanceof String ? (String) tag : null;
                if (strValueOf == null) {
                    strValueOf = String.valueOf(view.getId());
                }
                String str = ba2.class.getSimpleName() + ':' + strValueOf;
                q91 q91VarB = na2Var.b();
                Bundle bundleX = q91VarB.x(str);
                if (bundleX != null) {
                    linkedHashMap = new LinkedHashMap();
                    for (String str2 : bundleX.keySet()) {
                        ArrayList parcelableArrayList = bundleX.getParcelableArrayList(str2);
                        parcelableArrayList.getClass();
                        linkedHashMap.put(str2, parcelableArrayList);
                    }
                }
                j7 j7Var = j7.Y;
                sr2 sr2Var = da2.a;
                ca2 ca2Var = new ca2(linkedHashMap, j7Var);
                try {
                    q91VarB.F(str, new i10(i3, ca2Var));
                    z = true;
                } catch (IllegalArgumentException unused) {
                    z = false;
                }
                Object sd0Var = new sd0(ca2Var, new td0(z, q91VarB, str));
                x20Var.g0(sd0Var);
                objL2 = sd0Var;
            }
            Object obj2 = (sd0) objL2;
            boolean zH = x20Var.h(obj2);
            Object objL3 = x20Var.L();
            if (zH || objL3 == obj) {
                objL3 = new h6(5, obj2);
                x20Var.g0(objL3);
            }
            bz3.a(q43.a, (hq0) objL3, x20Var);
            Object objL4 = x20Var.L();
            if (objL4 == obj) {
                objL4 = (Build.VERSION.SDK_INT < 31 || !((Vibrator) context.getSystemService(Vibrator.class)).areAllPrimitivesSupported(1, 7, 2)) ? new wn1() : new na0(r7Var.getView(), 0);
                x20Var.g0(objL4);
            }
            bw0 bw0Var = (bw0) objL4;
            Configuration configuration = r7Var.getConfiguration();
            Object objL5 = x20Var.L();
            if (objL5 == obj) {
                objL5 = new iz0();
                x20Var.g0(objL5);
            }
            iz0 iz0Var = (iz0) objL5;
            Object objL6 = x20Var.L();
            Object obj3 = objL6;
            if (objL6 == obj) {
                Configuration configuration2 = new Configuration();
                if (configuration != null) {
                    configuration2.setTo(configuration);
                }
                x20Var.g0(configuration2);
                obj3 = configuration2;
            }
            Configuration configuration3 = (Configuration) obj3;
            Object objL7 = x20Var.L();
            if (objL7 == obj) {
                objL7 = new l8(configuration3, iz0Var);
                x20Var.g0(objL7);
            }
            l8 l8Var = (l8) objL7;
            boolean zH2 = x20Var.h(context);
            Object objL8 = x20Var.L();
            if (zH2 || objL8 == obj) {
                objL8 = new k8(0, context, l8Var);
                x20Var.g0(objL8);
            }
            bz3.a(iz0Var, (hq0) objL8, x20Var);
            Object objL9 = x20Var.L();
            if (objL9 == obj) {
                objL9 = new q62();
                x20Var.g0(objL9);
            }
            q62 q62Var = (q62) objL9;
            Object objL10 = x20Var.L();
            if (objL10 == obj) {
                objL10 = new m8(q62Var);
                x20Var.g0(objL10);
            }
            m8 m8Var = (m8) objL10;
            boolean zH3 = x20Var.h(context);
            Object objL11 = x20Var.L();
            if (zH3 || objL11 == obj) {
                objL11 = new k8(1, context, m8Var);
                x20Var.g0(objL11);
            }
            bz3.a(q62Var, (hq0) objL11, x20Var);
            z12 z12Var = l30.v;
            kj4.b(new a22[]{a.a(r7Var.getConfiguration()), b.a(context), ie1.a.a(viewTreeOwners.a), le1.a.a(na2Var), da2.a.a(obj2), f.a(r7Var.getView()), d.a(iz0Var), e.a(q62Var), z12Var.a(Boolean.valueOf(((Boolean) x20Var.j(z12Var)).booleanValue() | r7Var.getScrollCaptureInProgress$ui())), l30.l.a(bw0Var)}, yi4.b(1059770793, new h8(r7Var, tcVar, vq0Var), x20Var), x20Var, 56);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new i8(r7Var, vq0Var, i);
        }
    }

    public static final void b(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }

    public static final z12 getLocalLifecycleOwner() {
        return ie1.a;
    }
}
