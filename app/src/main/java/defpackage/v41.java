package defpackage;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v41 implements wo1, g63 {
    public final boolean a = true;
    public final JsonWriter b;
    public final Map c;
    public final Map d;
    public final vo1 e;
    public final boolean f;

    public v41(Writer writer, Map map, Map map2, vo1 vo1Var, boolean z) {
        this.b = new JsonWriter(writer);
        this.c = map;
        this.d = map2;
        this.e = vo1Var;
        this.f = z;
    }

    @Override // defpackage.wo1
    public final wo1 a(fl0 fl0Var, Object obj) throws IOException {
        f(obj, fl0Var.a);
        return this;
    }

    @Override // defpackage.g63
    public final g63 b(String str) throws IOException {
        g();
        this.b.value(str);
        return this;
    }

    @Override // defpackage.g63
    public final g63 c(boolean z) throws IOException {
        g();
        this.b.value(z);
        return this;
    }

    @Override // defpackage.wo1
    public final wo1 d(fl0 fl0Var, long j) throws IOException {
        String str = fl0Var.a;
        g();
        JsonWriter jsonWriter = this.b;
        jsonWriter.name(str);
        g();
        jsonWriter.value(j);
        return this;
    }

    public final v41 e(Object obj) throws IOException {
        JsonWriter jsonWriter = this.b;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    e(it.next());
                }
                jsonWriter.endArray();
                return this;
            }
            if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        f(entry.getValue(), (String) key);
                    } catch (ClassCastException e) {
                        throw new ri0(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            vo1 vo1Var = (vo1) this.c.get(obj.getClass());
            if (vo1Var != null) {
                jsonWriter.beginObject();
                vo1Var.a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            f63 f63Var = (f63) this.d.get(obj.getClass());
            if (f63Var != null) {
                f63Var.a(obj, this);
                return this;
            }
            if (obj instanceof Enum) {
                String strName = ((Enum) obj).name();
                g();
                jsonWriter.value(strName);
                return this;
            }
            jsonWriter.beginObject();
            this.e.a(obj, this);
            jsonWriter.endObject();
            return this;
        }
        if (obj instanceof byte[]) {
            g();
            jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        jsonWriter.beginArray();
        int i = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            while (i < length) {
                jsonWriter.value(iArr[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                long j = jArr[i];
                g();
                jsonWriter.value(j);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                jsonWriter.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                jsonWriter.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            Number[] numberArr = (Number[]) obj;
            int length5 = numberArr.length;
            while (i < length5) {
                e(numberArr[i]);
                i++;
            }
        } else {
            Object[] objArr = (Object[]) obj;
            int length6 = objArr.length;
            while (i < length6) {
                e(objArr[i]);
                i++;
            }
        }
        jsonWriter.endArray();
        return this;
    }

    public final v41 f(Object obj, String str) throws IOException {
        boolean z = this.f;
        JsonWriter jsonWriter = this.b;
        if (z) {
            if (obj == null) {
                return this;
            }
            g();
            jsonWriter.name(str);
            e(obj);
            return this;
        }
        g();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        e(obj);
        return this;
    }

    public final void g() {
        if (this.a) {
            return;
        }
        og.n("Parent context used since this context was created. Cannot use this context anymore.");
    }
}
