package defpackage;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import com.project.sonic.R;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ne2 implements View.OnLayoutChangeListener {
    public final /* synthetic */ SearchView a;

    public ne2(SearchView searchView) {
        this.a = searchView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        SearchView searchView = this.a;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.H;
        View view2 = searchView.j0;
        if (view2.getWidth() > 1) {
            Resources resources = searchView.getContext().getResources();
            int paddingLeft = searchView.d0.getPaddingLeft();
            Rect rect = new Rect();
            boolean z = j83.a;
            int i9 = u73.a;
            boolean z2 = searchView.getLayoutDirection() == 1;
            int dimensionPixelSize = searchView.y0 ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) : 0;
            searchAutoComplete.getDropDownBackground().getPadding(rect);
            int i10 = rect.left;
            searchAutoComplete.setDropDownHorizontalOffset(z2 ? -i10 : paddingLeft - (i10 + dimensionPixelSize));
            searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }
}
