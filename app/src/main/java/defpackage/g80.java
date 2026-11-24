package defpackage;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g80 extends ContentObserver {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g80(dt2 dt2Var) {
        super(new Handler());
        this.b = dt2Var;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        switch (this.a) {
            case 0:
                return true;
            default:
                return super.deliverSelfNotifications();
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Cursor cursor;
        switch (this.a) {
            case 0:
                dt2 dt2Var = (dt2) this.b;
                if (dt2Var.b && (cursor = dt2Var.c) != null && !cursor.isClosed()) {
                    dt2Var.a = dt2Var.c.requery();
                    break;
                }
                break;
            default:
                super.onChange(z);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g80(un unVar, Handler handler) {
        super(handler);
        this.b = unVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        switch (this.a) {
            case 1:
                ((un) this.b).s(q43.a);
                break;
            default:
                super.onChange(z, uri);
                break;
        }
    }
}
