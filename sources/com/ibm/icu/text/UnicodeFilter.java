package com.ibm.icu.text;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class UnicodeFilter implements UnicodeMatcher {
    @Deprecated
    public UnicodeFilter() {
    }

    public abstract boolean contains(int i);

    @Override // com.ibm.icu.text.UnicodeMatcher
    public int matches(Replaceable replaceable, int[] iArr, int i, boolean z) {
        int i2 = iArr[0];
        if (i2 < i) {
            int iChar32At = replaceable.char32At(i2);
            if (contains(iChar32At)) {
                iArr[0] = UTF16.getCharCount(iChar32At) + iArr[0];
                return 2;
            }
        }
        int i3 = iArr[0];
        if (i3 <= i || !contains(replaceable.char32At(i3))) {
            return (z && iArr[0] == i) ? 1 : 0;
        }
        int i4 = iArr[0] - 1;
        iArr[0] = i4;
        if (i4 >= 0) {
            iArr[0] = i4 - (UTF16.getCharCount(replaceable.char32At(i4)) - 1);
        }
        return 2;
    }
}
