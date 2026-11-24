package defpackage;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import com.project.sonic.R;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class i80 extends BaseAdapter implements Filterable {
    public boolean a;
    public boolean b;
    public Cursor c;
    public int d;
    public g80 e;
    public h80 f;
    public l80 g;

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.c;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                g80 g80Var = this.e;
                if (g80Var != null) {
                    cursor2.unregisterContentObserver(g80Var);
                }
                h80 h80Var = this.f;
                if (h80Var != null) {
                    cursor2.unregisterDataSetObserver(h80Var);
                }
            }
            this.c = cursor;
            if (cursor != null) {
                g80 g80Var2 = this.e;
                if (g80Var2 != null) {
                    cursor.registerContentObserver(g80Var2);
                }
                h80 h80Var2 = this.f;
                if (h80Var2 != null) {
                    cursor.registerDataSetObserver(h80Var2);
                }
                this.d = cursor.getColumnIndexOrThrow("_id");
                this.a = true;
                notifyDataSetChanged();
            } else {
                this.d = -1;
                this.a = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String c(Cursor cursor);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (!this.a || (cursor = this.c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.a) {
            return null;
        }
        this.c.moveToPosition(i);
        if (view == null) {
            dt2 dt2Var = (dt2) this;
            view = dt2Var.j.inflate(dt2Var.i, viewGroup, false);
        }
        a(view, this.c);
        return view;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.g == null) {
            l80 l80Var = new l80();
            l80Var.a = this;
            this.g = l80Var;
        }
        return this.g;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        Cursor cursor;
        if (!this.a || (cursor = this.c) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.c;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        Cursor cursor;
        if (this.a && (cursor = this.c) != null && cursor.moveToPosition(i)) {
            return this.c.getLong(this.d);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.a) {
            og.n("this should only be called when the cursor is valid");
            return null;
        }
        if (!this.c.moveToPosition(i)) {
            og.n(ky0.h(i, "couldn't move cursor to position "));
            return null;
        }
        if (view == null) {
            dt2 dt2Var = (dt2) this;
            view = dt2Var.j.inflate(dt2Var.h, viewGroup, false);
            view.setTag(new ct2(view));
            ((ImageView) view.findViewById(R.id.edit_query)).setImageResource(dt2Var.o);
        }
        a(view, this.c);
        return view;
    }
}
