package defpackage;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ke2 implements TextWatcher {
    public final /* synthetic */ SearchView a;

    public ke2(SearchView searchView) {
        this.a = searchView;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        SearchView searchView = this.a;
        Editable text = searchView.H.getText();
        searchView.H0 = text;
        boolean zIsEmpty = TextUtils.isEmpty(text);
        searchView.p(!zIsEmpty);
        int i4 = 8;
        if (searchView.G0 && !searchView.z0 && zIsEmpty) {
            searchView.g0.setVisibility(8);
            i4 = 0;
        }
        searchView.i0.setVisibility(i4);
        searchView.l();
        searchView.o();
        charSequence.toString();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
