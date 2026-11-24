package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class b72 implements Closeable {
    public abstract long c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        z53.d(j());
    }

    public abstract ji1 e();

    public abstract yn j();

    public final String o() throws IllegalAccessException, IOException, InvocationTargetException {
        Charset charsetA;
        yn ynVarJ = j();
        try {
            ji1 ji1VarE = e();
            if (ji1VarE == null || (charsetA = ji1VarE.a(px.a)) == null) {
                charsetA = px.a;
            }
            String strJ = ynVarJ.J(z53.s(ynVarJ, charsetA));
            ynVarJ.close();
            return strJ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                fi4.a(ynVarJ, th);
                throw th2;
            }
        }
    }
}
