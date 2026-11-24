package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y6 implements sy {
    public final z6 a;

    public y6(z6 z6Var) {
        this.a = z6Var;
    }

    public final void a(oy oyVar) {
        ClipboardManager clipboardManager = this.a.a;
        if (oyVar != null) {
            clipboardManager.setPrimaryClip(oyVar.a);
        } else if (Build.VERSION.SDK_INT >= 28) {
            clipboardManager.clearPrimaryClip();
        } else {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
        }
    }
}
