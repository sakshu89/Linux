package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class mx1 extends CancellationException {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mx1(String str, int i) {
        super(str);
        this.a = i;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        switch (this.a) {
            case 0:
                setStackTrace(ah2.a);
                break;
            case 1:
                setStackTrace(wh2.a);
                break;
            default:
                setStackTrace(i34.a);
                break;
        }
        return this;
    }
}
