package defpackage;

import android.app.Activity;
import android.app.Notification;
import android.graphics.Insets;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class f50 {
    public static ContentCaptureSession a(View view) {
        return view.getContentCaptureSession();
    }

    public static AutofillId b(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
        return contentCaptureSession.newAutofillId(autofillId, j);
    }

    public static ViewStructure c(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
        return contentCaptureSession.newVirtualViewStructure(autofillId, j);
    }

    public static void d(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
        contentCaptureSession.notifyViewAppeared(viewStructure);
    }

    public static void e(ContentCaptureSession contentCaptureSession, AutofillId autofillId) {
        contentCaptureSession.notifyViewDisappeared(autofillId);
    }

    public static void f(ContentCaptureSession contentCaptureSession, AutofillId autofillId, String str) {
        contentCaptureSession.notifyViewTextChanged(autofillId, str);
    }

    public static void g(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
        contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
    }

    public static Insets h(int i, int i2, int i3, int i4) {
        return Insets.of(i, i2, i3, i4);
    }

    public static final void i(Activity activity, z02.a aVar) {
        activity.registerActivityLifecycleCallbacks(aVar);
    }

    public static void j(Notification.Builder builder, boolean z) {
        builder.setAllowSystemGeneratedContextualActions(z);
    }

    public static void k(Notification.Builder builder) {
        builder.setBubbleMetadata(null);
    }

    public static void l(Notification.Action.Builder builder) {
        builder.setContextual(false);
    }
}
