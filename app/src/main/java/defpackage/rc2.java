package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rc2 extends AccessibilityService.GestureResultCallback {
    public final /* synthetic */ yv a;

    public rc2(yv yvVar) {
        this.a = yvVar;
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCancelled(GestureDescription gestureDescription) {
        yv yvVar = this.a;
        if (yvVar.w() instanceof mo1) {
            yvVar.h(Boolean.FALSE);
        }
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCompleted(GestureDescription gestureDescription) {
        yv yvVar = this.a;
        if (yvVar.w() instanceof mo1) {
            yvVar.h(Boolean.TRUE);
        }
    }
}
