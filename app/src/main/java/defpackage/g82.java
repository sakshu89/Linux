package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.project.sonic.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g82 extends ViewGroup {
    public final int a;
    public final ArrayList b;
    public final ArrayList c;
    public final q91 e;
    public int f;

    public g82(Context context) {
        super(context);
        this.a = 5;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.c = arrayList2;
        this.e = new q91(22);
        setClipChildren(false);
        h82 h82Var = new h82(context);
        addView(h82Var);
        arrayList.add(h82Var);
        arrayList2.add(h82Var);
        this.f = 1;
        setTag(R.id.hide_in_inspector_tag, Boolean.TRUE);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
