package defpackage;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import com.project.sonic.background.SonicTileService;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v62 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ v62(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                ((ye) obj2).k((Typeface) obj);
                break;
            case 1:
                int i2 = SonicTileService.f;
                ((SonicTileService) obj2).startActivityAndCollapse((PendingIntent) obj);
                break;
            case 2:
                int i3 = SonicTileService.f;
                ((SonicTileService) obj2).startActivityAndCollapse((Intent) obj);
                break;
            case 3:
                ((s40) ((AtomicReference) obj).get()).accept(new jj((xt2) obj2));
                break;
            case 4:
                ((lv2) obj2).f.remove((j62) obj);
                break;
            case 5:
                ty0 ty0Var = (ty0) obj;
                uf1 uf1Var = ((oj) obj2).c;
                if (uf1Var == null) {
                    og.n("One and only one callback is allowed.");
                } else {
                    ((q92) uf1Var.b).h(new h72(ty0Var));
                }
                break;
            case 6:
                py0 py0Var = (py0) obj;
                uf1 uf1Var2 = ((oj) obj2).c;
                Objects.requireNonNull(uf1Var2);
                Objects.requireNonNull(py0Var);
                q92 q92Var = (q92) uf1Var2.b;
                Uri uri = (Uri) py0Var.b;
                if (uri == null || uri.equals(Uri.EMPTY)) {
                    q92Var.h(new h72(new IllegalStateException("Camera did not return the saved photo URI")));
                } else {
                    q92Var.h(uri);
                }
                break;
            default:
                f03 f03Var = (f03) obj2;
                fu2 fu2Var = (fu2) obj;
                fu2 fu2Var2 = f03Var.h;
                if (fu2Var2 != null && fu2Var2 == fu2Var) {
                    f03Var.h = null;
                    f03Var.g = null;
                }
                rw rwVar = f03Var.l;
                if (rwVar != null) {
                    rwVar.a();
                    f03Var.l = null;
                }
                break;
        }
    }
}
