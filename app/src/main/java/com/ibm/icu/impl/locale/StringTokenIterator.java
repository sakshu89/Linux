package com.ibm.icu.impl.locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class StringTokenIterator {
    private String _dlms;
    private boolean _done;
    private int _end;
    private int _start;
    private String _text;
    private String _token;

    public StringTokenIterator(String str, String str2) {
        this._text = str;
        this._dlms = str2;
        setStart(0);
    }

    private int nextDelimiter(int i) {
        loop0: while (i < this._text.length()) {
            char cCharAt = this._text.charAt(i);
            for (int i2 = 0; i2 < this._dlms.length(); i2++) {
                if (cCharAt == this._dlms.charAt(i2)) {
                    break loop0;
                }
            }
            i++;
        }
        return i;
    }

    public String current() {
        return this._token;
    }

    public int currentEnd() {
        return this._end;
    }

    public int currentStart() {
        return this._start;
    }

    public String first() {
        setStart(0);
        return this._token;
    }

    public boolean hasNext() {
        return this._end < this._text.length();
    }

    public boolean isDone() {
        return this._done;
    }

    public String next() {
        boolean zHasNext = hasNext();
        int i = this._end;
        if (zHasNext) {
            int i2 = i + 1;
            this._start = i2;
            int iNextDelimiter = nextDelimiter(i2);
            this._end = iNextDelimiter;
            this._token = this._text.substring(this._start, iNextDelimiter);
        } else {
            this._start = i;
            this._token = null;
            this._done = true;
        }
        return this._token;
    }

    public StringTokenIterator setStart(int i) {
        if (i > this._text.length()) {
            throw new IndexOutOfBoundsException();
        }
        this._start = i;
        int iNextDelimiter = nextDelimiter(i);
        this._end = iNextDelimiter;
        this._token = this._text.substring(this._start, iNextDelimiter);
        this._done = false;
        return this;
    }

    public StringTokenIterator setText(String str) {
        this._text = str;
        setStart(0);
        return this;
    }
}
