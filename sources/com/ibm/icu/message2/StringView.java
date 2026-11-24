package com.ibm.icu.message2;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class StringView implements CharSequence {
    final int offset;
    final String text;

    public StringView(String str, int i) {
        this.offset = i;
        this.text = str;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.text.charAt(i + this.offset);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.text.length() - this.offset;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        String str = this.text;
        int i3 = this.offset;
        return str.subSequence(i + i3, i2 + i3);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.text.substring(this.offset);
    }

    public StringView(String str) {
        this(str, 0);
    }
}
