package defpackage;

import java.io.Serializable;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gj0 extends h1 implements fj0, RandomAccess, Serializable {
    public final Enum[] a;

    public gj0(Enum[] enumArr) {
        this.a = enumArr;
    }

    @Override // defpackage.y0
    public final int a() {
        return this.a.length;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0015  */
    @Override // defpackage.y0, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        Enum r2;
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r3 = (Enum) obj;
        int iOrdinal = r3.ordinal();
        if (iOrdinal >= 0) {
            Enum[] enumArr = this.a;
            if (iOrdinal < enumArr.length) {
                r2 = enumArr[iOrdinal];
            } else {
                r2 = null;
            }
        } else {
            r2 = null;
        }
        return r2 == r3;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArr = this.a;
        int length = enumArr.length;
        if (i >= 0 && i < length) {
            return enumArr[i];
        }
        og.o(ky0.i("index: ", i, length, ", size: "));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0016  */
    @Override // defpackage.h1, java.util.List
    public final int indexOf(Object obj) {
        Enum r3;
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r4 = (Enum) obj;
        int iOrdinal = r4.ordinal();
        if (iOrdinal >= 0) {
            Enum[] enumArr = this.a;
            if (iOrdinal < enumArr.length) {
                r3 = enumArr[iOrdinal];
            } else {
                r3 = null;
            }
        } else {
            r3 = null;
        }
        if (r3 == r4) {
            return iOrdinal;
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0016  */
    @Override // defpackage.h1, java.util.List
    public final int lastIndexOf(Object obj) {
        Enum r3;
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r4 = (Enum) obj;
        int iOrdinal = r4.ordinal();
        if (iOrdinal >= 0) {
            Enum[] enumArr = this.a;
            if (iOrdinal < enumArr.length) {
                r3 = enumArr[iOrdinal];
            } else {
                r3 = null;
            }
        } else {
            r3 = null;
        }
        if (r3 == r4) {
            return iOrdinal;
        }
        return -1;
    }
}
