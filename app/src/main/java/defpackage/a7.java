package defpackage;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import android.view.ScrollCaptureTarget;
import android.view.autofill.AutofillId;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a7 {
    public static /* synthetic */ void D() {
    }

    public static /* bridge */ /* synthetic */ ScrollCaptureSession d(Object obj) {
        return (ScrollCaptureSession) obj;
    }

    public static /* synthetic */ ScrollCaptureTarget e(r7 r7Var, Rect rect, Point point, ScrollCaptureCallback scrollCaptureCallback) {
        return new ScrollCaptureTarget(r7Var, rect, point, scrollCaptureCallback);
    }

    public static /* synthetic */ ViewTranslationRequest.Builder j(AutofillId autofillId, long j) {
        return new ViewTranslationRequest.Builder(autofillId, j);
    }

    public static /* bridge */ /* synthetic */ ViewTranslationResponse l(Object obj) {
        return (ViewTranslationResponse) obj;
    }

    public static /* synthetic */ void o() {
    }
}
