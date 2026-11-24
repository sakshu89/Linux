package defpackage;

import com.ibm.icu.text.DateTimePatternGenerator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yh2 {
    public int a;
    public final int[] b = new int[10];

    public final int a() {
        return (this.a & 128) != 0 ? this.b[7] : DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
    }

    public final void b(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.b;
            if (i >= iArr.length) {
                return;
            }
            this.a = (1 << i) | this.a;
            iArr[i] = i2;
        }
    }
}
