package defpackage;

import android.content.Context;
import android.view.View;
import com.project.sonic.R;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n9 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ n9(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        switch (this.a) {
            case 0:
                o9 o9Var = (o9) this.b;
                Context context = view.getContext();
                if (!o9Var.d) {
                    context.getApplicationContext().registerComponentCallbacks(o9Var.e);
                    o9Var.d = true;
                }
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) throws IllegalAccessException, InvocationTargetException {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                o9 o9Var = (o9) obj;
                Context context = view.getContext();
                if (o9Var.d) {
                    context.getApplicationContext().unregisterComponentCallbacks(o9Var.e);
                    o9Var.d = false;
                }
                break;
            case 1:
                a1 a1Var = (a1) obj;
                for (Object obj2 : zg2.c(a1Var.getParent(), x73.k)) {
                    if (obj2 instanceof View) {
                        View view2 = (View) obj2;
                        view2.getClass();
                        Object tag = view2.getTag(R.id.is_pooling_container_tag);
                        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
                        if (bool != null ? bool.booleanValue() : false) {
                            break;
                        }
                    }
                }
                pc3 pc3Var = a1Var.c;
                if (pc3Var != null) {
                    pc3Var.a();
                }
                a1Var.c = null;
                a1Var.requestLayout();
                break;
            default:
                view.removeOnAttachStateChangeListener(this);
                ((yq2) obj).e(null);
                break;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }
}
