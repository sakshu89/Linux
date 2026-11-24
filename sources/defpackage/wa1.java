package defpackage;

import android.graphics.Rect;
import android.os.LocaleList;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wa1 {
    public final View a;
    public final l11 b;
    public ua1 e;
    public ny2 f;
    public w73 g;
    public Rect l;
    public final qa1 m;
    public hq0 c = new va1(0);
    public hq0 d = new va1(1);
    public ty2 h = new ty2(4, oz2.b, "");
    public kz0 i = kz0.g;
    public final ArrayList j = new ArrayList();
    public final f81 k = yp4.a(new kb(11, this));

    public wa1(View view, y9 y9Var, l11 l11Var) {
        this.a = view;
        this.b = l11Var;
        this.m = new qa1(y9Var, l11Var);
    }

    public final i42 a(EditorInfo editorInfo) {
        int i;
        int i2;
        ty2 ty2Var = this.h;
        String str = ty2Var.a.b;
        long j = ty2Var.b;
        kz0 kz0Var = this.i;
        int i3 = kz0Var.e;
        int i4 = kz0Var.d;
        boolean z = kz0Var.a;
        if (i3 == 1) {
            i = z ? 6 : 0;
        } else if (i3 == 0) {
            i = 1;
        } else if (i3 == 2) {
            i = 2;
        } else if (i3 == 6) {
            i = 5;
        } else if (i3 == 5) {
            i = 7;
        } else if (i3 == 3) {
            i = 3;
        } else if (i3 == 4) {
            i = 4;
        } else {
            if (i3 != 7) {
                og.n("invalid ImeAction");
                return null;
            }
        }
        editorInfo.imeOptions = i;
        ne1 ne1Var = kz0Var.f;
        if (g31.a(ne1Var, ne1.c)) {
            editorInfo.hintLocales = null;
        } else {
            ArrayList arrayList = new ArrayList(nz.d(ne1Var));
            Iterator it = ne1Var.a.iterator();
            while (it.hasNext()) {
                arrayList.add(((me1) it.next()).a);
            }
            Locale[] localeArr = (Locale[]) arrayList.toArray(new Locale[0]);
            editorInfo.hintLocales = new LocaleList((Locale[]) Arrays.copyOf(localeArr, localeArr.length));
        }
        if (i4 == 1) {
            i2 = 1;
        } else if (i4 == 2) {
            editorInfo.imeOptions |= Integer.MIN_VALUE;
            i2 = 1;
        } else if (i4 == 3) {
            i2 = 2;
        } else if (i4 == 4) {
            i2 = 3;
        } else if (i4 == 5) {
            i2 = 17;
        } else if (i4 == 6) {
            i2 = 33;
        } else if (i4 == 7) {
            i2 = 129;
        } else if (i4 == 8) {
            i2 = 18;
        } else {
            if (i4 != 9) {
                og.n("Invalid Keyboard Type");
                return null;
            }
            i2 = 8194;
        }
        editorInfo.inputType = i2;
        if (!z && (i2 & 1) == 1) {
            editorInfo.inputType = 131072 | i2;
            if (kz0Var.e == 1) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        int i5 = editorInfo.inputType;
        if ((i5 & 1) == 1) {
            int i6 = kz0Var.b;
            if (i6 == 1) {
                editorInfo.inputType = i5 | 4096;
            } else if (i6 == 2) {
                editorInfo.inputType = i5 | 8192;
            } else if (i6 == 3) {
                editorInfo.inputType = i5 | 16384;
            }
            if (kz0Var.c) {
                editorInfo.inputType |= 32768;
            }
        }
        int i7 = oz2.c;
        editorInfo.initialSelStart = (int) (j >> 32);
        editorInfo.initialSelEnd = (int) (j & 4294967295L);
        bn4.a(editorInfo, str);
        editorInfo.imeOptions |= 33554432;
        if (!ns2.a || i4 == 7 || i4 == 8) {
            bn4.b(editorInfo, false);
        } else {
            bn4.b(editorInfo, true);
            editorInfo.setSupportedHandwritingGestures(nz.i(u9.n(), u9.z(), u9.x(), u9.y(), u9.A(), u9.B(), u9.C()));
            editorInfo.setSupportedHandwritingGesturePreviews(wh2.c(u9.n(), u9.z(), u9.x(), u9.y()));
        }
        ra1 ra1Var = sa1.a;
        if (oh0.d()) {
            oh0.a().i(editorInfo);
        }
        i42 i42Var = new i42(this.h, new uf1(26, this), this.i.c, this.e, this.f, this.g);
        this.j.add(new WeakReference(i42Var));
        return i42Var;
    }
}
