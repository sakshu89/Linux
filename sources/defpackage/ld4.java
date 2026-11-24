package defpackage;

import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ld4 {
    public static final fa a() {
        return new fa(new Paint(7));
    }

    public static final Object[] b(Object[] objArr, int i, Object obj, Object obj2) {
        Object[] objArr2 = new Object[objArr.length + 2];
        qg.i(objArr, 0, objArr2, i, 6);
        qg.g(objArr, i + 2, objArr2, i, objArr.length);
        objArr2[i] = obj;
        objArr2[i + 1] = obj2;
        return objArr2;
    }

    public static final Object[] c(int i, Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length - 2];
        qg.i(objArr, 0, objArr2, i, 6);
        qg.g(objArr, i, objArr2, i + 2, objArr.length);
        return objArr2;
    }

    public static final Object[] d(int i, Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length - 1];
        qg.i(objArr, 0, objArr2, i, 6);
        qg.g(objArr, i, objArr2, i + 1, objArr.length);
        return objArr2;
    }

    public static final int e(int i, int i2) {
        return (i >> i2) & 31;
    }
}
