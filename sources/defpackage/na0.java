package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class na0 implements bw0 {
    public final /* synthetic */ int a;
    public final View b;

    public /* synthetic */ na0(View view, int i) {
        this.a = i;
        this.b = view;
    }

    @Override // defpackage.bw0
    public final void a() {
        int i = this.a;
        View view = this.b;
        switch (i) {
            case 0:
                u73.a(view, 9);
                break;
            default:
                u73.a((r7) view, 9);
                break;
        }
    }
}
