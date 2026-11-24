package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.window.BackEvent;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class v2 {
    public static Context a(Context context, int i) {
        return context.createDeviceContext(i);
    }

    public static AccessibilityNodeInfo.AccessibilityAction b() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
    }

    public static void c(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.getBoundsInWindow(rect);
    }

    public static CharSequence d(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getContainerTitle();
    }

    public static int e(Context context) {
        return context.getDeviceId();
    }

    public static int f(Context context) {
        return context.getDeviceId();
    }

    public static boolean g(Bitmap bitmap) {
        return bitmap.hasGainmap();
    }

    public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isAccessibilityDataSensitive();
    }

    public static boolean i(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isRequestFromAccessibilityTool();
    }

    public static float j(BackEvent backEvent) {
        return backEvent.getProgress();
    }

    public static void k(AccessibilityEvent accessibilityEvent, boolean z) {
        accessibilityEvent.setAccessibilityDataSensitive(z);
    }

    public static void l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        accessibilityNodeInfo.setAccessibilityDataSensitive(z);
    }

    public static int m(BackEvent backEvent) {
        return backEvent.getSwipeEdge();
    }

    public static float n(BackEvent backEvent) {
        return backEvent.getTouchX();
    }

    public static float o(BackEvent backEvent) {
        return backEvent.getTouchY();
    }
}
