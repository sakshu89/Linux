package defpackage;

import android.content.Context;
import android.graphics.Insets;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class e3 {
    public static Context a(Context context, String str) {
        return context.createAttributionContext(str);
    }

    public static Icon b(Uri uri) {
        return Icon.createWithAdaptiveBitmapContentUri(uri);
    }

    public static String c(Context context) {
        return context.getAttributionTag();
    }

    public static CharSequence d(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getStateDescription();
    }

    public static Insets e(DisplayCutout displayCutout) {
        return displayCutout.getWaterfallInsets();
    }

    public static void f(Window window) {
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 256);
        window.setDecorFitsSystemWindows(false);
    }

    public static void g(Window window) {
        window.setDecorFitsSystemWindows(false);
    }

    public static void h(View view) {
        view.setImportantForContentCapture(1);
    }

    public static void i(EditorInfo editorInfo, CharSequence charSequence) {
        editorInfo.setInitialSurroundingSubText(charSequence, 0);
    }

    public static void j(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setStateDescription(charSequence);
    }
}
