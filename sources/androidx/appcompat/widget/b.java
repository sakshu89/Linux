package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b implements View.OnKeyListener {
    public final /* synthetic */ SearchView a;

    public b(SearchView searchView) {
        this.a = searchView;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        SearchView searchView = this.a;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.H;
        if (searchView.I0 != null) {
            if (!searchAutoComplete.isPopupShowing() || searchAutoComplete.getListSelection() == -1) {
                if (TextUtils.getTrimmedLength(searchAutoComplete.getText()) != 0 && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i == 66) {
                    view.cancelLongPress();
                    searchView.getContext().startActivity(searchView.d(null, "android.intent.action.SEARCH", null, searchAutoComplete.getText().toString()));
                    return true;
                }
            } else if (searchView.I0 != null && searchView.A0 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
                if (i == 66 || i == 84 || i == 61) {
                    searchView.h(searchAutoComplete.getListSelection());
                    return true;
                }
                if (i == 21 || i == 22) {
                    searchAutoComplete.setSelection(i == 21 ? 0 : searchAutoComplete.length());
                    searchAutoComplete.setListSelection(0);
                    searchAutoComplete.clearListSelection();
                    searchAutoComplete.a();
                    return true;
                }
                if (i == 19) {
                    searchAutoComplete.getListSelection();
                    return false;
                }
            }
        }
        return false;
    }
}
