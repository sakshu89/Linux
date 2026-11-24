package defpackage;

import android.database.DataSetObserver;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h80 extends DataSetObserver {
    public final /* synthetic */ dt2 a;

    public h80(dt2 dt2Var) {
        this.a = dt2Var;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        dt2 dt2Var = this.a;
        dt2Var.a = true;
        dt2Var.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        dt2 dt2Var = this.a;
        dt2Var.a = false;
        dt2Var.notifyDataSetInvalidated();
    }
}
