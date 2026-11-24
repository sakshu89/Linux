package defpackage;

import android.view.View;
import android.view.translation.ViewTranslationCallback;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a8 implements ViewTranslationCallback {
    public static final a8 a = new a8();

    public final boolean onClearTranslation(View view) {
        fq0 fq0Var;
        view.getClass();
        q8 contentCaptureManager$ui = ((r7) view).getContentCaptureManager$ui();
        contentCaptureManager$ui.getClass();
        contentCaptureManager$ui.i = n8.a;
        c21 c21VarC = contentCaptureManager$ui.c();
        Object[] objArr = c21VarC.c;
        long[] jArr = c21VarC.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        gm1 gm1Var = ((ig2) objArr[(i << 3) + i3]).a.d.a;
                        Object objG = gm1Var.g(kg2.C);
                        if (objG == null) {
                            objG = null;
                        }
                        if (objG != null) {
                            Object objG2 = gm1Var.g(bg2.n);
                            b2 b2Var = (b2) (objG2 != null ? objG2 : null);
                            if (b2Var != null && (fq0Var = (fq0) b2Var.b) != null) {
                            }
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    public final boolean onHideTranslation(View view) {
        hq0 hq0Var;
        view.getClass();
        q8 contentCaptureManager$ui = ((r7) view).getContentCaptureManager$ui();
        contentCaptureManager$ui.getClass();
        contentCaptureManager$ui.i = n8.a;
        c21 c21VarC = contentCaptureManager$ui.c();
        Object[] objArr = c21VarC.c;
        long[] jArr = c21VarC.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        gm1 gm1Var = ((ig2) objArr[(i << 3) + i3]).a.d.a;
                        Object objG = gm1Var.g(kg2.C);
                        if (objG == null) {
                            objG = null;
                        }
                        if (g31.a(objG, Boolean.TRUE)) {
                            Object objG2 = gm1Var.g(bg2.m);
                            b2 b2Var = (b2) (objG2 != null ? objG2 : null);
                            if (b2Var != null && (hq0Var = (hq0) b2Var.b) != null) {
                            }
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    public final boolean onShowTranslation(View view) {
        hq0 hq0Var;
        view.getClass();
        q8 contentCaptureManager$ui = ((r7) view).getContentCaptureManager$ui();
        contentCaptureManager$ui.getClass();
        contentCaptureManager$ui.i = n8.b;
        c21 c21VarC = contentCaptureManager$ui.c();
        Object[] objArr = c21VarC.c;
        long[] jArr = c21VarC.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        gm1 gm1Var = ((ig2) objArr[(i << 3) + i3]).a.d.a;
                        Object objG = gm1Var.g(kg2.C);
                        if (objG == null) {
                            objG = null;
                        }
                        if (g31.a(objG, Boolean.FALSE)) {
                            Object objG2 = gm1Var.g(bg2.m);
                            b2 b2Var = (b2) (objG2 != null ? objG2 : null);
                            if (b2Var != null && (hq0Var = (hq0) b2Var.b) != null) {
                            }
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }
}
