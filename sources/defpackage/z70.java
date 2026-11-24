package defpackage;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z70 implements zk0 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ z70(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.c22
    public final Object get() {
        int i = this.a;
        int i2 = 20;
        Object obj = this.b;
        switch (i) {
            case 0:
                return new kf((Context) ((z70) obj).b, new nr4(i2), new ak1(i2), 8, false);
            case 1:
                return obj;
            case 2:
                return new l92(new nr4(i2), new ak1(i2), ii.f, (fb2) ((z70) obj).get());
            default:
                Context context = (Context) ((c22) obj).get();
                List list = fb2.c;
                return new fb2(4, context, "com.google.android.datatransport.events");
        }
    }
}
