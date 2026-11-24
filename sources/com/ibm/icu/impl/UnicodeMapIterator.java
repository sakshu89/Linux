package com.ibm.icu.impl;

import com.ibm.icu.text.UTF16;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UnicodeMapIterator<T> {
    public static int IS_STRING = -1;
    public int codepoint;
    public int codepointEnd;
    protected int endElement;
    private UnicodeMap<T> map;
    protected int nextElement;
    public String string;
    public T value;
    private int endRange = 0;
    private int range = 0;
    private Iterator<String> stringIterator = null;

    public UnicodeMapIterator() {
        reset(new UnicodeMap<>());
    }

    public String getString() {
        int i = this.codepoint;
        return i != IS_STRING ? UTF16.valueOf(i) : this.string;
    }

    public T loadRange(int i) {
        this.nextElement = this.map.getRangeStart(i);
        this.endElement = this.map.getRangeEnd(i);
        T rangeValue = this.map.getRangeValue(i);
        this.value = rangeValue;
        return rangeValue;
    }

    public boolean next() {
        int i;
        int i2 = this.nextElement;
        if (i2 <= this.endElement) {
            this.nextElement = i2 + 1;
            this.codepointEnd = i2;
            this.codepoint = i2;
            return true;
        }
        do {
            int i3 = this.range;
            if (i3 >= this.endRange) {
                Iterator<String> it = this.stringIterator;
                if (it == null) {
                    return false;
                }
                this.codepoint = IS_STRING;
                this.string = it.next();
                if (!this.stringIterator.hasNext()) {
                    this.stringIterator = null;
                }
                return true;
            }
            i = i3 + 1;
            this.range = i;
        } while (loadRange(i) == null);
        int i4 = this.nextElement;
        this.nextElement = i4 + 1;
        this.codepointEnd = i4;
        this.codepoint = i4;
        return true;
    }

    public boolean nextRange() {
        int i;
        int i2 = this.nextElement;
        int i3 = this.endElement;
        if (i2 <= i3) {
            this.codepointEnd = i3;
            this.codepoint = i2;
            this.nextElement = i3 + 1;
            return true;
        }
        do {
            int i4 = this.range;
            if (i4 >= this.endRange) {
                Iterator<String> it = this.stringIterator;
                if (it == null) {
                    return false;
                }
                this.codepoint = IS_STRING;
                this.string = it.next();
                if (!this.stringIterator.hasNext()) {
                    this.stringIterator = null;
                }
                return true;
            }
            i = i4 + 1;
            this.range = i;
        } while (loadRange(i) == null);
        int i5 = this.endElement;
        this.codepointEnd = i5;
        this.codepoint = this.nextElement;
        this.nextElement = i5 + 1;
        return true;
    }

    public UnicodeMapIterator<T> reset() {
        this.endRange = this.map.getRangeCount() - 1;
        this.nextElement = 0;
        this.endElement = -1;
        this.range = -1;
        this.stringIterator = null;
        Set<String> nonRangeStrings = this.map.getNonRangeStrings();
        if (nonRangeStrings != null) {
            Iterator<String> it = nonRangeStrings.iterator();
            this.stringIterator = it;
            if (!it.hasNext()) {
                this.stringIterator = null;
            }
        }
        this.value = null;
        return this;
    }

    public UnicodeMapIterator(UnicodeMap<T> unicodeMap) {
        reset(unicodeMap);
    }

    public void reset(UnicodeMap<T> unicodeMap) {
        this.map = unicodeMap;
        reset();
    }
}
