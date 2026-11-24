package defpackage;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class sk0 {
    public static final MathContext a = new MathContext(16, RoundingMode.HALF_UP);

    public static String a(BigDecimal bigDecimal) {
        BigDecimal bigDecimal2 = bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
        if (bigDecimal2.scale() < 0) {
            bigDecimal2 = bigDecimal2.setScale(0);
        }
        String plainString = bigDecimal2.toPlainString();
        plainString.getClass();
        return plainString;
    }
}
