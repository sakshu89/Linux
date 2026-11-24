package defpackage;

import android.graphics.text.LineBreakConfig;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.inputmethod.EditorBoundsInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class c3 {
    public static /* synthetic */ LineBreakConfig.Builder c() {
        return new LineBreakConfig.Builder();
    }

    public static /* bridge */ /* synthetic */ DynamicRangeProfiles g(Object obj) {
        return (DynamicRangeProfiles) obj;
    }

    public static /* synthetic */ BoringLayout i(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, BoringLayout.Metrics metrics, boolean z, TextUtils.TruncateAt truncateAt, int i2) {
        return new BoringLayout(charSequence, textPaint, i, alignment, 1.0f, 0.0f, metrics, z, truncateAt, i2, true);
    }

    public static /* synthetic */ EditorBoundsInfo.Builder l() {
        return new EditorBoundsInfo.Builder();
    }

    public static /* synthetic */ IndexOutOfBoundsException o(int i) {
        return new IndexOutOfBoundsException(i);
    }
}
