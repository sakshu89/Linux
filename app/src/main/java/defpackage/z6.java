package defpackage;

import android.content.ClipboardManager;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z6 implements ty {
    public final ClipboardManager a;

    public z6(Context context) {
        Object systemService = context.getSystemService("clipboard");
        systemService.getClass();
        this.a = (ClipboardManager) systemService;
    }
}
