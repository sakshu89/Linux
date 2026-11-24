package defpackage;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uj2 extends CharacterStyle implements UpdateAppearance {
    public final tj2 a;
    public final float b;
    public final ku1 c = o44.g(new xk2(9205357640488583168L));
    public final qc0 e = o44.b(new kb(20, this));

    public uj2(tj2 tj2Var, float f) {
        this.a = tj2Var;
        this.b = f;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        ee4.a(textPaint, this.b);
        textPaint.setShader((Shader) this.e.getValue());
    }
}
