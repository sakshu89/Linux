package defpackage;

import android.content.Context;
import android.view.PointerIcon;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c8 {
    public static final c8 a = new c8();

    public final void a(View view, ly1 ly1Var) {
        Context context = view.getContext();
        PointerIcon systemIcon = ly1Var instanceof va ? PointerIcon.getSystemIcon(context, ((va) ly1Var).b) : PointerIcon.getSystemIcon(context, 1000);
        if (g31.a(view.getPointerIcon(), systemIcon)) {
            return;
        }
        view.setPointerIcon(systemIcon);
    }
}
