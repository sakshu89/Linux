package defpackage;

import android.os.Build;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import com.project.sonic.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class lp4 {
    public static boolean a = false;
    public static Method b;

    public static boolean a(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int iIndexOfKey;
        int i = u73.a;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList2 = t73.d;
            t73 t73Var = (t73) view.getTag(R.id.tag_unhandled_key_event_manager);
            WeakReference weakReference = null;
            if (t73Var == null) {
                t73Var = new t73();
                t73Var.a = null;
                t73Var.b = null;
                t73Var.c = null;
                view.setTag(R.id.tag_unhandled_key_event_manager, t73Var);
            }
            WeakReference weakReference2 = t73Var.c;
            if (weakReference2 == null || weakReference2.get() != keyEvent) {
                t73Var.c = new WeakReference(keyEvent);
                if (t73Var.b == null) {
                    t73Var.b = new SparseArray();
                }
                SparseArray sparseArray = t73Var.b;
                if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
                    sparseArray.removeAt(iIndexOfKey);
                }
                if (weakReference == null) {
                    weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
                }
                if (weakReference != null) {
                    View view2 = (View) weakReference.get();
                    if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(R.id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
                        return true;
                    }
                    arrayList.get(size).getClass();
                    dk0.t();
                    return false;
                }
            }
        }
        return false;
    }
}
