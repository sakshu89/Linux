package com.ibm.icu.text;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UnicodeSetIterator {
    public static final int IS_STRING = -1;
    public int codepoint;
    public int codepointEnd;
    private int endElement;
    private int nextElement;
    private UnicodeSet set;
    public String string;
    private int endRange = 0;
    private int range = 0;
    private Iterator<String> stringIterator = null;

    public UnicodeSetIterator() {
        reset(new UnicodeSet());
    }

    private void loadRange(int i) {
        this.nextElement = this.set.getRangeStart(i);
        this.endElement = this.set.getRangeEnd(i);
    }

    public String getString() {
        int i = this.codepoint;
        return i != -1 ? UTF16.valueOf(i) : this.string;
    }

    public boolean next() {
        int i = this.nextElement;
        if (i <= this.endElement) {
            this.nextElement = i + 1;
            this.codepointEnd = i;
            this.codepoint = i;
            return true;
        }
        int i2 = this.range;
        if (i2 < this.endRange) {
            int i3 = i2 + 1;
            this.range = i3;
            loadRange(i3);
            int i4 = this.nextElement;
            this.nextElement = i4 + 1;
            this.codepointEnd = i4;
            this.codepoint = i4;
            return true;
        }
        Iterator<String> it = this.stringIterator;
        if (it == null) {
            return false;
        }
        this.codepoint = -1;
        this.string = it.next();
        if (!this.stringIterator.hasNext()) {
            this.stringIterator = null;
        }
        return true;
    }

    public boolean nextRange() {
        int i = this.nextElement;
        int i2 = this.endElement;
        if (i <= i2) {
            this.codepointEnd = i2;
            this.codepoint = i;
            this.nextElement = i2 + 1;
            return true;
        }
        int i3 = this.range;
        if (i3 < this.endRange) {
            int i4 = i3 + 1;
            this.range = i4;
            loadRange(i4);
            int i5 = this.endElement;
            this.codepointEnd = i5;
            this.codepoint = this.nextElement;
            this.nextElement = i5 + 1;
            return true;
        }
        Iterator<String> it = this.stringIterator;
        if (it == null) {
            return false;
        }
        this.codepoint = -1;
        this.string = it.next();
        if (!this.stringIterator.hasNext()) {
            this.stringIterator = null;
        }
        return true;
    }

    public void reset() {
        int rangeCount = this.set.getRangeCount() - 1;
        this.endRange = rangeCount;
        this.range = 0;
        this.endElement = -1;
        this.nextElement = 0;
        if (rangeCount >= 0) {
            loadRange(0);
        }
        if (this.set.hasStrings()) {
            this.stringIterator = this.set.strings.iterator();
        } else {
            this.stringIterator = null;
        }
    }

    public UnicodeSetIterator skipToStrings() {
        this.range = this.endRange;
        this.endElement = -1;
        this.nextElement = 0;
        return this;
    }

    public UnicodeSetIterator(UnicodeSet unicodeSet) {
        reset(unicodeSet);
    }

    public void reset(UnicodeSet unicodeSet) {
        this.set = unicodeSet;
        reset();
    }
}
