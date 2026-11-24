package defpackage;

import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r10 implements d22 {
    public static final r10 b = new r10(0);
    public static final r10 c = new r10(1);
    public final /* synthetic */ int a;

    public /* synthetic */ r10(int i) {
        this.a = i;
    }

    @Override // defpackage.d22
    public final Object get() {
        switch (this.a) {
            case 0:
                return Collections.EMPTY_SET;
            default:
                return null;
        }
    }
}
