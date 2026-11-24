package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pb0 implements ir0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ tp b;

    public /* synthetic */ pb0(tp tpVar, int i) {
        this.a = i;
        this.b = tpVar;
    }

    @Override // defpackage.ir0
    public final void c(Object obj) {
        int i = this.a;
        tp tpVar = this.b;
        switch (i) {
            case 0:
                List list = (List) obj;
                list.getClass();
                tpVar.a(new ArrayList(list));
                break;
            default:
                try {
                    tpVar.a(obj);
                } catch (Throwable th) {
                    tpVar.b(th);
                    return;
                }
                break;
        }
    }

    @Override // defpackage.ir0
    public final void i(Throwable th) {
        int i = this.a;
        tp tpVar = this.b;
        switch (i) {
            case 0:
                if (!(th instanceof TimeoutException)) {
                    tpVar.a(Collections.EMPTY_LIST);
                } else {
                    tpVar.b(th);
                }
                break;
            default:
                tpVar.b(th);
                break;
        }
    }
}
