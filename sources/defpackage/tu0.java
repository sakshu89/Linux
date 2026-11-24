package defpackage;

import android.text.TextPaint;
import java.text.BreakIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tu0 implements bf2 {
    public final /* synthetic */ int a = 1;
    public final CharSequence b;
    public final Object c;

    public tu0(CharSequence charSequence) {
        this.b = charSequence;
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(charSequence.toString());
        this.c = characterInstance;
    }

    @Override // defpackage.bf2
    public int a(int i) {
        return c(i);
    }

    public final int b(int i) {
        int i2 = this.a;
        Object obj = this.c;
        switch (i2) {
            case 0:
                CharSequence charSequence = this.b;
                return ((TextPaint) obj).getTextRunCursor(charSequence, 0, charSequence.length(), false, i, 0);
            default:
                return ((BreakIterator) obj).following(i);
        }
    }

    public final int c(int i) {
        int i2 = this.a;
        Object obj = this.c;
        switch (i2) {
            case 0:
                CharSequence charSequence = this.b;
                return ((TextPaint) obj).getTextRunCursor(charSequence, 0, charSequence.length(), false, i, 2);
            default:
                return ((BreakIterator) obj).preceding(i);
        }
    }

    @Override // defpackage.bf2
    public int d(int i) {
        return b(i);
    }

    @Override // defpackage.bf2
    public int e(int i) {
        int iB = b(i);
        if (iB == -1 || b(iB) == -1) {
            return -1;
        }
        return iB;
    }

    @Override // defpackage.bf2
    public int f(int i) {
        int iC = c(i);
        if (iC == -1 || c(iC) == -1) {
            return -1;
        }
        return iC;
    }

    public tu0(CharSequence charSequence, TextPaint textPaint) {
        this.b = charSequence;
        this.c = textPaint;
    }
}
