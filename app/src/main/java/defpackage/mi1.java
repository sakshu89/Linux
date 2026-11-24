package defpackage;

import java.io.Closeable;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mi1 implements Closeable {
    public final /* synthetic */ int a;
    public final boolean b;
    public final ln c;
    public final Object e;
    public final Closeable f;

    public mi1(boolean z, int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = z;
                ln lnVar = new ln();
                this.c = lnVar;
                Inflater inflater = new Inflater(true);
                this.e = inflater;
                this.f = new u01(new i32(lnVar), inflater);
                break;
            default:
                this.b = z;
                ln lnVar2 = new ln();
                this.c = lnVar2;
                Deflater deflater = new Deflater(-1, true);
                this.e = deflater;
                this.f = new ub0(lnVar2, deflater);
                break;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.a) {
            case 0:
                ((ub0) this.f).close();
                break;
            default:
                ((u01) this.f).close();
                break;
        }
    }
}
