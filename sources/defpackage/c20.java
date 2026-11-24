package defpackage;

import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c20 extends ClickableSpan {
    public final kc1 a;

    public c20(kc1 kc1Var) {
        this.a = kc1Var;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        this.a.getClass();
    }
}
