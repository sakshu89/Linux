package defpackage;

import android.hardware.camera2.TotalCaptureResult;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kr implements nr {
    public final /* synthetic */ mr a;

    public kr(mr mrVar) {
        this.a = mrVar;
    }

    @Override // defpackage.nr
    public final boolean a() {
        ArrayList arrayList = this.a.h;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (((nr) obj).a()) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.nr
    public final wc1 b(TotalCaptureResult totalCaptureResult) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.a.h;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList.add(((nr) obj).b(totalCaptureResult));
        }
        uc1 uc1Var = new uc1(new ArrayList(arrayList), true, xg4.a());
        og ogVar = new og(12);
        return oz3.g(uc1Var, new q82(ogVar), xg4.a());
    }

    @Override // defpackage.nr
    public final void c() {
        ArrayList arrayList = this.a.h;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((nr) obj).c();
        }
    }
}
