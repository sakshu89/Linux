package defpackage;

import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class le2 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ SearchView b;

    public /* synthetic */ le2(SearchView searchView, int i) {
        this.a = i;
        this.b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        SearchView searchView = this.b;
        switch (i) {
            case 0:
                searchView.m();
                break;
            default:
                i80 i80Var = searchView.A0;
                if (i80Var instanceof dt2) {
                    i80Var.b(null);
                }
                break;
        }
    }
}
