package defpackage;

import android.view.View;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class me2 implements View.OnFocusChangeListener {
    public final /* synthetic */ SearchView a;

    public me2(SearchView searchView) {
        this.a = searchView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        SearchView searchView = this.a;
        View.OnFocusChangeListener onFocusChangeListener = searchView.w0;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, z);
        }
    }
}
