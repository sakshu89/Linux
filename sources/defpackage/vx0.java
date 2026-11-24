package defpackage;

import com.ibm.icu.lang.UCharacterEnums;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vx0 implements fp2 {
    public final yn a;
    public int b;
    public int c;
    public int e;
    public int f;
    public int i;

    public vx0(yn ynVar) {
        ynVar.getClass();
        this.a = ynVar;
    }

    @Override // defpackage.fp2
    public final u03 d() {
        return this.a.d();
    }

    @Override // defpackage.fp2
    public final long f(long j, ln lnVar) throws IOException {
        int i;
        int i2;
        do {
            int i3 = this.f;
            yn ynVar = this.a;
            if (i3 == 0) {
                ynVar.skip(this.i);
                this.i = 0;
                if ((this.c & 4) == 0) {
                    i = this.e;
                    int iT = z53.t(ynVar);
                    this.f = iT;
                    this.b = iT;
                    int i4 = ynVar.readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                    this.c = ynVar.readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                    Logger logger = wx0.e;
                    if (logger.isLoggable(Level.FINE)) {
                        oo ooVar = ix0.a;
                        logger.fine(ix0.a(true, this.e, this.b, i4, this.c));
                    }
                    i2 = ynVar.readInt() & Integer.MAX_VALUE;
                    this.e = i2;
                    if (i4 != 9) {
                        throw new IOException(i4 + " != TYPE_CONTINUATION");
                    }
                }
            } else {
                long jF = ynVar.f(Math.min(8192L, i3), lnVar);
                if (jF != -1) {
                    this.f -= (int) jF;
                    return jF;
                }
            }
            return -1L;
        } while (i2 == i);
        dk0.h("TYPE_CONTINUATION streamId changed");
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
