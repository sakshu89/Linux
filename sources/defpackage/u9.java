package defpackage;

import android.text.GraphemeClusterSegmentFinder;
import android.text.SegmentFinder;
import android.text.TextPaint;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class u9 {
    public static /* bridge */ /* synthetic */ Class A() {
        return JoinOrSplitGesture.class;
    }

    public static /* bridge */ /* synthetic */ Class B() {
        return InsertGesture.class;
    }

    public static /* bridge */ /* synthetic */ Class C() {
        return RemoveSpaceGesture.class;
    }

    public static /* synthetic */ GraphemeClusterSegmentFinder l(CharSequence charSequence, TextPaint textPaint) {
        return new GraphemeClusterSegmentFinder(charSequence, textPaint);
    }

    public static /* bridge */ /* synthetic */ SegmentFinder m(Object obj) {
        return (SegmentFinder) obj;
    }

    public static /* bridge */ /* synthetic */ Class n() {
        return SelectGesture.class;
    }

    public static /* synthetic */ void o() {
    }

    public static /* bridge */ /* synthetic */ boolean s(Object obj) {
        return obj instanceof SelectGesture;
    }

    public static /* bridge */ /* synthetic */ Class x() {
        return SelectRangeGesture.class;
    }

    public static /* bridge */ /* synthetic */ Class y() {
        return DeleteRangeGesture.class;
    }

    public static /* bridge */ /* synthetic */ Class z() {
        return DeleteGesture.class;
    }
}
