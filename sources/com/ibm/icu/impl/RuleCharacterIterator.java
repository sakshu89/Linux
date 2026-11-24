package com.ibm.icu.impl;

import com.ibm.icu.text.SymbolTable;
import com.ibm.icu.text.UTF16;
import defpackage.cq;
import defpackage.dk0;
import defpackage.og;
import java.text.ParsePosition;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class RuleCharacterIterator {
    public static final int DONE = -1;
    public static final int PARSE_ESCAPES = 2;
    public static final int PARSE_VARIABLES = 1;
    public static final int SKIP_WHITESPACE = 4;
    private String buf;
    private int bufPos;
    private boolean isEscaped;
    private ParsePosition pos;
    private SymbolTable sym;
    private String text;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Position {
        private String buf;
        private int bufPos;
        private int posIndex;
    }

    public RuleCharacterIterator(String str, SymbolTable symbolTable, ParsePosition parsePosition) {
        if (str == null || parsePosition.getIndex() > str.length()) {
            dk0.v();
            throw null;
        }
        this.text = str;
        this.sym = symbolTable;
        this.pos = parsePosition;
        this.buf = null;
    }

    private void _advance(int i) {
        String str = this.buf;
        if (str != null) {
            int i2 = this.bufPos + i;
            this.bufPos = i2;
            if (i2 == str.length()) {
                this.buf = null;
                return;
            }
            return;
        }
        ParsePosition parsePosition = this.pos;
        parsePosition.setIndex(parsePosition.getIndex() + i);
        if (this.pos.getIndex() > this.text.length()) {
            this.pos.setIndex(this.text.length());
        }
    }

    private int _current() {
        String str = this.buf;
        if (str != null) {
            return UTF16.charAt(str, this.bufPos);
        }
        int index = this.pos.getIndex();
        if (index < this.text.length()) {
            return UTF16.charAt(this.text, index);
        }
        return -1;
    }

    public boolean atEnd() {
        return this.buf == null && this.pos.getIndex() == this.text.length();
    }

    public String getCurrentBuffer() {
        String str = this.buf;
        return str != null ? str : this.text;
    }

    public int getCurrentBufferPos() {
        return this.buf != null ? this.bufPos : this.pos.getIndex();
    }

    public Position getPos(Position position) {
        if (position == null) {
            position = new Position();
        }
        position.buf = this.buf;
        position.bufPos = this.bufPos;
        position.posIndex = this.pos.getIndex();
        return position;
    }

    public boolean inVariable() {
        return this.buf != null;
    }

    public boolean isEscaped() {
        return this.isEscaped;
    }

    public void jumpahead(int i) {
        if (i < 0) {
            dk0.v();
            return;
        }
        String str = this.buf;
        if (str == null) {
            int index = this.pos.getIndex() + i;
            this.pos.setIndex(index);
            if (index <= this.text.length()) {
                return;
            }
            dk0.v();
            return;
        }
        int i2 = this.bufPos + i;
        this.bufPos = i2;
        if (i2 > str.length()) {
            dk0.v();
        } else if (this.bufPos == this.buf.length()) {
            this.buf = null;
        }
    }

    public int next(int i) {
        int i_current;
        SymbolTable symbolTable;
        this.isEscaped = false;
        while (true) {
            i_current = _current();
            _advance(UTF16.getCharCount(i_current));
            if (i_current == 36 && this.buf == null && (i & 1) != 0 && (symbolTable = this.sym) != null) {
                String str = this.text;
                String reference = symbolTable.parseReference(str, this.pos, str.length());
                if (reference == null) {
                    break;
                }
                this.bufPos = 0;
                char[] cArrLookup = this.sym.lookup(reference);
                if (cArrLookup == null) {
                    this.buf = null;
                    og.i("Undefined variable: ".concat(reference));
                    return 0;
                }
                if (cArrLookup.length == 0) {
                    this.buf = null;
                }
                this.buf = new String(cArrLookup);
            } else if ((i & 4) == 0 || !PatternProps.isWhiteSpace(i_current)) {
                if (i_current != 92 || (i & 2) == 0) {
                    break;
                    break;
                }
                int iUnescapeAndLengthAt = Utility.unescapeAndLengthAt(getCurrentBuffer(), getCurrentBufferPos());
                if (iUnescapeAndLengthAt < 0) {
                    og.i("Invalid escape");
                    return 0;
                }
                int iCpFromCodePointAndLength = Utility.cpFromCodePointAndLength(iUnescapeAndLengthAt);
                jumpahead(Utility.lengthFromCodePointAndLength(iUnescapeAndLengthAt));
                this.isEscaped = true;
                return iCpFromCodePointAndLength;
            }
        }
        return i_current;
    }

    public void setPos(Position position) {
        this.buf = position.buf;
        this.pos.setIndex(position.posIndex);
        this.bufPos = position.bufPos;
    }

    public void skipIgnored(int i) {
        if ((i & 4) == 0) {
            return;
        }
        while (true) {
            int i_current = _current();
            if (!PatternProps.isWhiteSpace(i_current)) {
                return;
            } else {
                _advance(UTF16.getCharCount(i_current));
            }
        }
    }

    public String toString() {
        int index = this.pos.getIndex();
        return cq.k(this.text.substring(0, index), "|", this.text.substring(index));
    }
}
