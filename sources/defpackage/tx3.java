package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tx3 implements wo1 {
    public static final Charset f = Charset.forName("UTF-8");
    public static final fl0 g = new fl0("key", ky0.r(ky0.q(qx3.class, new fx3(1))));
    public static final fl0 h = new fl0("value", ky0.r(ky0.q(qx3.class, new fx3(2))));
    public static final r41 i = r41.c;
    public OutputStream a;
    public final HashMap b;
    public final HashMap c;
    public final vo1 d;
    public final ay3 e = new ay3(this, 0);

    public tx3(ByteArrayOutputStream byteArrayOutputStream, HashMap map, HashMap map2, vo1 vo1Var) {
        this.a = byteArrayOutputStream;
        this.b = map;
        this.c = map2;
        this.d = vo1Var;
    }

    public static int f(fl0 fl0Var) {
        qx3 qx3Var = (qx3) ((Annotation) fl0Var.b.get(qx3.class));
        if (qx3Var != null) {
            return qx3Var.zza();
        }
        throw new ri0("Field has no @Protobuf config");
    }

    @Override // defpackage.wo1
    public final wo1 a(fl0 fl0Var, Object obj) {
        b(fl0Var, obj, true);
        return this;
    }

    public final void b(fl0 fl0Var, Object obj, boolean z) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return;
            }
            h((f(fl0Var) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f);
            h(bytes.length);
            this.a.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                b(fl0Var, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                g(i, fl0Var, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (z && dDoubleValue == 0.0d) {
                return;
            }
            h((f(fl0Var) << 3) | 1);
            this.a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(dDoubleValue).array());
            return;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (z && fFloatValue == 0.0f) {
                return;
            }
            h((f(fl0Var) << 3) | 5);
            this.a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
            return;
        }
        if (obj instanceof Number) {
            e(fl0Var, ((Number) obj).longValue(), z);
            return;
        }
        if (obj instanceof Boolean) {
            c(fl0Var, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return;
            }
            h((f(fl0Var) << 3) | 2);
            h(bArr.length);
            this.a.write(bArr);
            return;
        }
        vo1 vo1Var = (vo1) this.b.get(obj.getClass());
        if (vo1Var != null) {
            g(vo1Var, fl0Var, obj, z);
            return;
        }
        f63 f63Var = (f63) this.c.get(obj.getClass());
        if (f63Var != null) {
            ay3 ay3Var = this.e;
            ay3Var.b = false;
            ay3Var.d = fl0Var;
            ay3Var.c = z;
            f63Var.a(obj, ay3Var);
            return;
        }
        if (obj instanceof mx3) {
            c(fl0Var, ((mx3) obj).zza(), true);
        } else if (obj instanceof Enum) {
            c(fl0Var, ((Enum) obj).ordinal(), true);
        } else {
            g(this.d, fl0Var, obj, z);
        }
    }

    public final void c(fl0 fl0Var, int i2, boolean z) {
        if (z && i2 == 0) {
            return;
        }
        qx3 qx3Var = (qx3) ((Annotation) fl0Var.b.get(qx3.class));
        if (qx3Var == null) {
            throw new ri0("Field has no @Protobuf config");
        }
        int iOrdinal = qx3Var.zzb().ordinal();
        if (iOrdinal == 0) {
            h(qx3Var.zza() << 3);
            h(i2);
        } else if (iOrdinal == 1) {
            h(qx3Var.zza() << 3);
            h((i2 + i2) ^ (i2 >> 31));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            h((qx3Var.zza() << 3) | 5);
            this.a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i2).array());
        }
    }

    @Override // defpackage.wo1
    public final /* synthetic */ wo1 d(fl0 fl0Var, long j) throws IOException {
        e(fl0Var, j, true);
        return this;
    }

    public final void e(fl0 fl0Var, long j, boolean z) throws IOException {
        if (z && j == 0) {
            return;
        }
        qx3 qx3Var = (qx3) ((Annotation) fl0Var.b.get(qx3.class));
        if (qx3Var == null) {
            throw new ri0("Field has no @Protobuf config");
        }
        int iOrdinal = qx3Var.zzb().ordinal();
        if (iOrdinal == 0) {
            h(qx3Var.zza() << 3);
            i(j);
        } else if (iOrdinal == 1) {
            h(qx3Var.zza() << 3);
            i((j >> 63) ^ (j + j));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            h((qx3Var.zza() << 3) | 1);
            this.a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j).array());
        }
    }

    public final void g(vo1 vo1Var, fl0 fl0Var, Object obj, boolean z) throws IOException {
        kx3 kx3Var = new kx3(0);
        kx3Var.b = 0L;
        try {
            OutputStream outputStream = this.a;
            this.a = kx3Var;
            try {
                vo1Var.a(obj, this);
                this.a = outputStream;
                long j = kx3Var.b;
                kx3Var.close();
                if (z && j == 0) {
                    return;
                }
                h((f(fl0Var) << 3) | 2);
                i(j);
                vo1Var.a(obj, this);
            } catch (Throwable th) {
                this.a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                kx3Var.close();
            } catch (Throwable th3) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                } catch (Exception unused) {
                }
            }
            throw th2;
        }
    }

    public final void h(int i2) throws IOException {
        while (true) {
            long j = i2 & (-128);
            OutputStream outputStream = this.a;
            if (j == 0) {
                outputStream.write(i2 & 127);
                return;
            } else {
                outputStream.write((i2 & 127) | 128);
                i2 >>>= 7;
            }
        }
    }

    public final void i(long j) throws IOException {
        while (true) {
            long j2 = (-128) & j;
            OutputStream outputStream = this.a;
            if (j2 == 0) {
                outputStream.write(((int) j) & 127);
                return;
            } else {
                outputStream.write((((int) j) & 127) | 128);
                j >>>= 7;
            }
        }
    }
}
