package defpackage;

import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class zv0 {
    public static /* bridge */ /* synthetic */ boolean A(Object obj) {
        return obj instanceof JoinOrSplitGesture;
    }

    public static /* bridge */ /* synthetic */ boolean B(Object obj) {
        return obj instanceof DeleteGesture;
    }

    public static /* bridge */ /* synthetic */ boolean C(Object obj) {
        return obj instanceof SelectRangeGesture;
    }

    public static /* bridge */ /* synthetic */ boolean D(Object obj) {
        return obj instanceof DeleteRangeGesture;
    }

    public static /* bridge */ /* synthetic */ DeleteGesture j(Object obj) {
        return (DeleteGesture) obj;
    }

    public static /* bridge */ /* synthetic */ DeleteRangeGesture k(Object obj) {
        return (DeleteRangeGesture) obj;
    }

    public static /* bridge */ /* synthetic */ HandwritingGesture l(Object obj) {
        return (HandwritingGesture) obj;
    }

    public static /* bridge */ /* synthetic */ InsertGesture m(Object obj) {
        return (InsertGesture) obj;
    }

    public static /* bridge */ /* synthetic */ JoinOrSplitGesture n(Object obj) {
        return (JoinOrSplitGesture) obj;
    }

    public static /* bridge */ /* synthetic */ RemoveSpaceGesture o(Object obj) {
        return (RemoveSpaceGesture) obj;
    }

    public static /* bridge */ /* synthetic */ SelectGesture p(Object obj) {
        return (SelectGesture) obj;
    }

    public static /* bridge */ /* synthetic */ SelectRangeGesture q(Object obj) {
        return (SelectRangeGesture) obj;
    }

    public static /* bridge */ /* synthetic */ boolean w(Object obj) {
        return obj instanceof RemoveSpaceGesture;
    }

    public static /* bridge */ /* synthetic */ HandwritingGesture z(Object obj) {
        return (HandwritingGesture) obj;
    }
}
