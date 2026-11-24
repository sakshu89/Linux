package defpackage;

import android.database.Cursor;
import android.util.Log;
import android.widget.Filter;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l80 extends Filter {
    public i80 a;

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        return this.a.c((Cursor) obj);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0031  */
    @Override // android.widget.Filter
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorF;
        dt2 dt2Var = (dt2) this.a;
        SearchView searchView = dt2Var.k;
        String string = charSequence == null ? "" : charSequence.toString();
        if (searchView.getVisibility() == 0 && searchView.getWindowVisibility() == 0) {
            try {
                cursorF = dt2Var.f(dt2Var.l, string);
                if (cursorF != null) {
                    cursorF.getCount();
                } else {
                    cursorF = null;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        } else {
            cursorF = null;
        }
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorF != null) {
            filterResults.count = cursorF.getCount();
            filterResults.values = cursorF;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        i80 i80Var = this.a;
        Cursor cursor = i80Var.c;
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        i80Var.b((Cursor) obj);
    }
}
