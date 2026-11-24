package defpackage;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d3 {
    public static final d3 c;
    public static final d3 d;
    public static final d3 e;
    public static final d3 f;
    public static final d3 g;
    public static final d3 h;
    public static final d3 i;
    public static final d3 j;
    public final Object a;
    public final int b;

    static {
        new d3(null, 1, null, null);
        new d3(null, 2, null, null);
        new d3(null, 4, null, null);
        new d3(null, 8, null, null);
        new d3(null, 16, null, null);
        new d3(null, 32, null, null);
        c = new d3(null, 64, null, null);
        d = new d3(null, 128, null, null);
        new d3(null, 256, null, j3.class);
        new d3(null, 512, null, j3.class);
        new d3(null, 1024, null, k3.class);
        new d3(null, 2048, null, k3.class);
        e = new d3(null, 4096, null, null);
        f = new d3(null, 8192, null, null);
        new d3(null, 16384, null, null);
        new d3(null, 32768, null, null);
        new d3(null, 65536, null, null);
        new d3(null, Normalizer.INPUT_IS_FCD, null, o3.class);
        new d3(null, ArabicShaping.TASHKEEL_BEGIN, null, null);
        new d3(null, ArabicShaping.TASHKEEL_RESIZE, null, null);
        new d3(null, 1048576, null, null);
        new d3(null, ArabicShaping.SEEN_TWOCELL_NEAR, null, p3.class);
        new d3(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null);
        new d3(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, m3.class);
        g = new d3(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null);
        h = new d3(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null);
        i = new d3(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null);
        j = new d3(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null);
        int i2 = Build.VERSION.SDK_INT;
        new d3(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null);
        new d3(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null);
        new d3(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null);
        new d3(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null);
        new d3(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null);
        new d3(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, n3.class);
        new d3(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, l3.class);
        new d3(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null);
        new d3(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null);
        new d3(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null);
        new d3(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null);
        new d3(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null);
        new d3(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null);
        new d3(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null);
        new d3(i2 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null);
        new d3(i2 >= 34 ? v2.b() : null, R.id.accessibilityActionScrollInDirection, null, null);
    }

    public d3(Object obj, int i2, CharSequence charSequence, Class cls) {
        this.b = i2;
        if (obj == null) {
            this.a = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
        } else {
            this.a = obj;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d3)) {
            return false;
        }
        Object obj2 = ((d3) obj).a;
        Object obj3 = this.a;
        if (obj3 == null) {
            return obj2 == null;
        }
        return obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String strC = h3.c(this.b);
        if (strC.equals("ACTION_UNKNOWN")) {
            Object obj = this.a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                strC = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(strC);
        return sb.toString();
    }

    public d3(int i2, String str) {
        this(null, i2, str, null);
    }
}
