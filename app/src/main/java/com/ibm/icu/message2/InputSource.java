package com.ibm.icu.message2;

import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class InputSource {
    final String buffer;
    private int cursor;
    private int lastReadCursor = -1;
    private int lastReadCount = 0;

    public InputSource(String str) {
        if (str == null) {
            og.i("Input string should not be null");
            throw null;
        }
        this.buffer = str;
        this.cursor = 0;
    }

    public boolean atEnd() {
        return this.cursor >= this.buffer.length();
    }

    public void backup(int i) {
        this.cursor -= i;
    }

    public int getPosition() {
        return this.cursor;
    }

    public void gotoPosition(int i) {
        this.cursor = i;
    }

    public int peekChar() {
        if (atEnd()) {
            return -1;
        }
        return this.buffer.charAt(this.cursor);
    }

    public int readCodePoint() {
        int i = this.lastReadCursor;
        int i2 = this.cursor;
        if (i != i2) {
            this.lastReadCursor = i2;
            this.lastReadCount = 1;
        } else {
            int i3 = this.lastReadCount + 1;
            this.lastReadCount = i3;
            if (i3 >= 10) {
                og.p("Stuck in a loop!");
                return 0;
            }
        }
        if (atEnd()) {
            return -1;
        }
        String str = this.buffer;
        int i4 = this.cursor;
        this.cursor = i4 + 1;
        char cCharAt = str.charAt(i4);
        if (Character.isHighSurrogate(cCharAt) && !atEnd()) {
            String str2 = this.buffer;
            int i5 = this.cursor;
            this.cursor = i5 + 1;
            char cCharAt2 = str2.charAt(i5);
            if (Character.isLowSurrogate(cCharAt2)) {
                return Character.toCodePoint(cCharAt, cCharAt2);
            }
            this.cursor--;
        }
        return cCharAt;
    }

    public void skip(int i) {
        this.cursor += i;
    }
}
