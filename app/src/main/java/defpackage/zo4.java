package defpackage;

import android.view.inputmethod.ExtractedText;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zo4 {
    public static final ExtractedText a(ty2 ty2Var) {
        ExtractedText extractedText = new ExtractedText();
        String str = ty2Var.a.b;
        extractedText.text = str;
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = str.length();
        extractedText.partialStartOffset = -1;
        long j = ty2Var.b;
        extractedText.selectionStart = oz2.f(j);
        extractedText.selectionEnd = oz2.e(j);
        extractedText.flags = !cs2.o(ty2Var.a.b, '\n') ? 1 : 0;
        return extractedText;
    }
}
