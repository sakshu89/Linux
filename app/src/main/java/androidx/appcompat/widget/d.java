package androidx.appcompat.widget;

import android.view.inputmethod.InputMethodManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {
    public final /* synthetic */ SearchView.SearchAutoComplete a;

    public d(SearchView.SearchAutoComplete searchAutoComplete) {
        this.a = searchAutoComplete;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SearchView.SearchAutoComplete searchAutoComplete = this.a;
        if (searchAutoComplete.j) {
            ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
            searchAutoComplete.j = false;
        }
    }
}
