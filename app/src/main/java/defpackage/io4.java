package defpackage;

import android.view.inputmethod.HandwritingGesture;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class io4 {
    public static int a(HandwritingGesture handwritingGesture, x0 x0Var) {
        String fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        x0Var.j(new r00(fallbackText, 1));
        return 5;
    }

    public static void b(long j, be beVar, boolean z, x0 x0Var) {
        if (z) {
            int i = oz2.c;
            int iCharCount = (int) (j >> 32);
            int iCharCount2 = (int) (j & 4294967295L);
            int iCodePointBefore = iCharCount > 0 ? Character.codePointBefore(beVar, iCharCount) : 10;
            int iCodePointAt = iCharCount2 < beVar.b.length() ? Character.codePointAt(beVar, iCharCount2) : 10;
            if (jo4.i(iCodePointBefore) && (jo4.h(iCodePointAt) || jo4.g(iCodePointAt))) {
                do {
                    iCharCount -= Character.charCount(iCodePointBefore);
                    if (iCharCount == 0) {
                        break;
                    } else {
                        iCodePointBefore = Character.codePointBefore(beVar, iCharCount);
                    }
                } while (jo4.i(iCodePointBefore));
                j = hc4.a(iCharCount, iCharCount2);
            } else if (jo4.i(iCodePointAt) && (jo4.h(iCodePointBefore) || jo4.g(iCodePointBefore))) {
                do {
                    iCharCount2 += Character.charCount(iCodePointAt);
                    if (iCharCount2 == beVar.b.length()) {
                        break;
                    } else {
                        iCodePointAt = Character.codePointAt(beVar, iCharCount2);
                    }
                } while (jo4.i(iCodePointAt));
                j = hc4.a(iCharCount, iCharCount2);
            }
        }
        int i2 = (int) (4294967295L & j);
        x0Var.j(new aw0(new fh0[]{new vh2(i2, i2), new ec0(oz2.d(j), 0)}));
    }
}
