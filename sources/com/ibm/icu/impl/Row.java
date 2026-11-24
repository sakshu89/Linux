package com.ibm.icu.impl;

import com.ibm.icu.util.Freezable;
import defpackage.dk0;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Row<C0, C1, C2, C3, C4> implements Comparable<Row<C0, C1, C2, C3, C4>>, Cloneable, Freezable<Row<C0, C1, C2, C3, C4>> {
    protected volatile boolean frozen;
    protected Object[] items;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class R2<C0, C1> extends Row<C0, C1, C1, C1, C1> {
        public R2(C0 c0, C1 c1) {
            this.items = new Object[]{c0, c1};
        }

        @Override // com.ibm.icu.impl.Row
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo4clone() {
            return super.mo4clone();
        }

        @Override // com.ibm.icu.impl.Row, com.ibm.icu.util.Freezable
        public /* bridge */ /* synthetic */ Object cloneAsThawed() {
            return super.cloneAsThawed();
        }

        @Override // com.ibm.icu.impl.Row, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Row) obj);
        }

        @Override // com.ibm.icu.impl.Row, com.ibm.icu.util.Freezable
        public /* bridge */ /* synthetic */ Object freeze() {
            return super.freeze();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class R3<C0, C1, C2> extends Row<C0, C1, C2, C2, C2> {
        public R3(C0 c0, C1 c1, C2 c2) {
            this.items = new Object[]{c0, c1, c2};
        }

        @Override // com.ibm.icu.impl.Row
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo4clone() {
            return super.mo4clone();
        }

        @Override // com.ibm.icu.impl.Row, com.ibm.icu.util.Freezable
        public /* bridge */ /* synthetic */ Object cloneAsThawed() {
            return super.cloneAsThawed();
        }

        @Override // com.ibm.icu.impl.Row, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Row) obj);
        }

        @Override // com.ibm.icu.impl.Row, com.ibm.icu.util.Freezable
        public /* bridge */ /* synthetic */ Object freeze() {
            return super.freeze();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class R4<C0, C1, C2, C3> extends Row<C0, C1, C2, C3, C3> {
        public R4(C0 c0, C1 c1, C2 c2, C3 c3) {
            this.items = new Object[]{c0, c1, c2, c3};
        }

        @Override // com.ibm.icu.impl.Row
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo4clone() {
            return super.mo4clone();
        }

        @Override // com.ibm.icu.impl.Row, com.ibm.icu.util.Freezable
        public /* bridge */ /* synthetic */ Object cloneAsThawed() {
            return super.cloneAsThawed();
        }

        @Override // com.ibm.icu.impl.Row, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Row) obj);
        }

        @Override // com.ibm.icu.impl.Row, com.ibm.icu.util.Freezable
        public /* bridge */ /* synthetic */ Object freeze() {
            return super.freeze();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class R5<C0, C1, C2, C3, C4> extends Row<C0, C1, C2, C3, C4> {
        public R5(C0 c0, C1 c1, C2 c2, C3 c3, C4 c4) {
            this.items = new Object[]{c0, c1, c2, c3, c4};
        }

        @Override // com.ibm.icu.impl.Row
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo4clone() {
            return super.mo4clone();
        }

        @Override // com.ibm.icu.impl.Row, com.ibm.icu.util.Freezable
        public /* bridge */ /* synthetic */ Object cloneAsThawed() {
            return super.cloneAsThawed();
        }

        @Override // com.ibm.icu.impl.Row, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Row) obj);
        }

        @Override // com.ibm.icu.impl.Row, com.ibm.icu.util.Freezable
        public /* bridge */ /* synthetic */ Object freeze() {
            return super.freeze();
        }
    }

    public static <C0, C1, C2, C3, C4> R5<C0, C1, C2, C3, C4> of(C0 c0, C1 c1, C2 c2, C3 c3, C4 c4) {
        return new R5<>(c0, c1, c2, c3, c4);
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Row<C0, C1, C2, C3, C4> mo4clone() {
        if (this.frozen) {
            return this;
        }
        try {
            Row<C0, C1, C2, C3, C4> row = (Row) super.clone();
            row.items = (Object[]) this.items.clone();
            return row;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.ibm.icu.util.Freezable
    public Row<C0, C1, C2, C3, C4> cloneAsThawed() {
        try {
            Row<C0, C1, C2, C3, C4> row = (Row) super.clone();
            this.items = (Object[]) this.items.clone();
            row.frozen = false;
            return row;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Row<C0, C1, C2, C3, C4> row) {
        Object[] objArr = this.items;
        int length = objArr.length - row.items.length;
        if (length != 0) {
            return length;
        }
        int length2 = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            int i3 = i2 + 1;
            int iCheckCompare = Utility.checkCompare((Comparable) objArr[i], (Comparable) row.items[i2]);
            if (iCheckCompare != 0) {
                return iCheckCompare;
            }
            i++;
            i2 = i3;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        try {
            Row row = (Row) obj;
            Object[] objArr = this.items;
            if (objArr.length != row.items.length) {
                return false;
            }
            int length = objArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                if (!Objects.equals(objArr[i], row.items[i2])) {
                    return false;
                }
                i++;
                i2 = i3;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public C0 get0() {
        return (C0) this.items[0];
    }

    public C1 get1() {
        return (C1) this.items[1];
    }

    public C2 get2() {
        return (C2) this.items[2];
    }

    public C3 get3() {
        return (C3) this.items[3];
    }

    public C4 get4() {
        return (C4) this.items[4];
    }

    public int hashCode() {
        Object[] objArr = this.items;
        int length = objArr.length;
        for (Object obj : objArr) {
            length = (length * 37) + Utility.checkHash(obj);
        }
        return length;
    }

    @Override // com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return this.frozen;
    }

    public Row<C0, C1, C2, C3, C4> set(int i, Object obj) {
        if (this.frozen) {
            dk0.r("Attempt to modify frozen object");
            return null;
        }
        this.items[i] = obj;
        return this;
    }

    public Row<C0, C1, C2, C3, C4> set0(C0 c0) {
        return set(0, c0);
    }

    public Row<C0, C1, C2, C3, C4> set1(C1 c1) {
        return set(1, c1);
    }

    public Row<C0, C1, C2, C3, C4> set2(C2 c2) {
        return set(2, c2);
    }

    public Row<C0, C1, C2, C3, C4> set3(C3 c3) {
        return set(3, c3);
    }

    public Row<C0, C1, C2, C3, C4> set4(C4 c4) {
        return set(4, c4);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        boolean z = true;
        for (Object obj : this.items) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(obj);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.ibm.icu.util.Freezable
    public Row<C0, C1, C2, C3, C4> freeze() {
        this.frozen = true;
        return this;
    }

    public static <C0, C1, C2> R3<C0, C1, C2> of(C0 c0, C1 c1, C2 c2) {
        return new R3<>(c0, c1, c2);
    }

    public static <C0, C1, C2, C3> R4<C0, C1, C2, C3> of(C0 c0, C1 c1, C2 c2, C3 c3) {
        return new R4<>(c0, c1, c2, c3);
    }

    public static <C0, C1> R2<C0, C1> of(C0 c0, C1 c1) {
        return new R2<>(c0, c1);
    }
}
