package defpackage;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pz1 extends yt0 {
    private static final pz1 DEFAULT_INSTANCE;
    private static volatile mu1 PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private w21 strings_ = x12.e;

    static {
        pz1 pz1Var = new pz1();
        DEFAULT_INSTANCE = pz1Var;
        yt0.j(pz1.class, pz1Var);
    }

    public static void l(pz1 pz1Var, Iterable iterable) {
        w21 w21Var = pz1Var.strings_;
        if (!((x12) w21Var).a) {
            x12 x12Var = (x12) w21Var;
            int i = x12Var.c;
            pz1Var.strings_ = x12Var.d(i == 0 ? 10 : i * 2);
        }
        RandomAccess randomAccess = pz1Var.strings_;
        Charset charset = x21.a;
        if (iterable instanceof ka1) {
            List listE = ((ka1) iterable).e();
            if (randomAccess != null) {
                dk0.t();
                return;
            }
            ((x12) randomAccess).getClass();
            Iterator it = listE.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                if (next instanceof no) {
                    throw null;
                }
                if (!(next instanceof byte[])) {
                    throw null;
                }
                byte[] bArr = (byte[]) next;
                no.d(0, bArr, bArr.length);
                throw null;
            }
            return;
        }
        if (iterable instanceof u02) {
            ((x12) randomAccess).addAll((Collection) iterable);
            return;
        }
        if ((randomAccess instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) randomAccess).ensureCapacity(((Collection) iterable).size() + ((x12) randomAccess).c);
        }
        x12 x12Var2 = (x12) randomAccess;
        int i2 = x12Var2.c;
        for (Object obj : iterable) {
            if (obj == null) {
                String str = "Element at index " + (x12Var2.c - i2) + " is null.";
                for (int i3 = x12Var2.c - 1; i3 >= i2; i3--) {
                    x12Var2.remove(i3);
                }
                dk0.n(str);
                return;
            }
            x12Var2.add(obj);
        }
    }

    public static pz1 m() {
        return DEFAULT_INSTANCE;
    }

    public static oz1 o() {
        return (oz1) ((wt0) DEFAULT_INSTANCE.c(5));
    }

    @Override // defpackage.yt0
    public final Object c(int i) {
        mu1 xt0Var;
        switch (cq.x(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new v22(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new pz1();
            case 4:
                return new oz1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                mu1 mu1Var = PARSER;
                if (mu1Var != null) {
                    return mu1Var;
                }
                synchronized (pz1.class) {
                    try {
                        xt0Var = PARSER;
                        if (xt0Var == null) {
                            xt0Var = new xt0();
                            PARSER = xt0Var;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return xt0Var;
            default:
                dk0.p();
                return null;
        }
    }

    public final w21 n() {
        return this.strings_;
    }
}
