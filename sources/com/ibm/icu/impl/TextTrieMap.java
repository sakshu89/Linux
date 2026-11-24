package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.UnicodeSet;
import defpackage.og;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class TextTrieMap<V> {
    boolean _ignoreCase;
    private TextTrieMap<V>.Node _root = new Node(this, 0);

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CharIterator implements Iterator<Character> {
        private boolean _ignoreCase;
        private int _nextIdx;
        private Character _remainingChar;
        private int _startIdx;
        private CharSequence _text;

        public CharIterator(CharSequence charSequence, int i, boolean z) {
            this._text = charSequence;
            this._startIdx = i;
            this._nextIdx = i;
            this._ignoreCase = z;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return (this._nextIdx == this._text.length() && this._remainingChar == null) ? false : true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Character next() {
            if (this._nextIdx == this._text.length() && this._remainingChar == null) {
                return null;
            }
            Character ch = this._remainingChar;
            if (ch != null) {
                this._remainingChar = null;
                return ch;
            }
            boolean z = this._ignoreCase;
            CharSequence charSequence = this._text;
            if (!z) {
                Character chValueOf = Character.valueOf(charSequence.charAt(this._nextIdx));
                this._nextIdx++;
                return chValueOf;
            }
            int iFoldCase = UCharacter.foldCase(Character.codePointAt(charSequence, this._nextIdx), true);
            this._nextIdx = Character.charCount(iFoldCase) + this._nextIdx;
            char[] chars = Character.toChars(iFoldCase);
            Character chValueOf2 = Character.valueOf(chars[0]);
            if (chars.length == 2) {
                this._remainingChar = Character.valueOf(chars[1]);
            }
            return chValueOf2;
        }

        public int nextIndex() {
            return this._nextIdx;
        }

        public int processedLength() {
            if (this._remainingChar == null) {
                return this._nextIdx - this._startIdx;
            }
            og.n("In the middle of surrogate pair");
            return 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove() not supported");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Output {
        public int matchLength;
        public boolean partialMatch;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface ResultHandler<V> {
        boolean handlePrefixMatch(int i, Iterator<V> it);
    }

    public TextTrieMap(boolean z) {
        this._ignoreCase = z;
    }

    public static /* bridge */ /* synthetic */ char[] b(char[] cArr, int i) {
        return subArray(cArr, 0, i);
    }

    private synchronized void find(TextTrieMap<V>.Node node, CharIterator charIterator, ResultHandler<V> resultHandler, Output output) {
        Iterator<V> itValues = node.values();
        if (itValues == null || resultHandler.handlePrefixMatch(charIterator.processedLength(), itValues)) {
            TextTrieMap<V>.Node nodeFindMatch = node.findMatch(charIterator, output);
            if (nodeFindMatch != null) {
                find(nodeFindMatch, charIterator, resultHandler, output);
            }
        }
    }

    private static char[] subArray(char[] cArr, int i, int i2) {
        if (i == 0 && i2 == cArr.length) {
            return cArr;
        }
        int i3 = i2 - i;
        char[] cArr2 = new char[i3];
        System.arraycopy(cArr, i, cArr2, 0, i3);
        return cArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static char[] toCharArray(CharSequence charSequence) {
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = charSequence.charAt(i);
        }
        return cArr;
    }

    public Iterator<V> get(CharSequence charSequence, int i, Output output) {
        LongestMatchHandler longestMatchHandler = new LongestMatchHandler(0);
        find(charSequence, i, longestMatchHandler, output);
        if (output != null) {
            output.matchLength = longestMatchHandler.getMatchLength();
        }
        return longestMatchHandler.getMatches();
    }

    public TextTrieMap<V> put(CharSequence charSequence, V v) {
        this._root.add(new CharIterator(charSequence, 0, this._ignoreCase), v);
        return this;
    }

    public void putLeadCodePoints(UnicodeSet unicodeSet) {
        this._root.putLeadCodePoints(unicodeSet);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class LongestMatchHandler<V> implements ResultHandler<V> {
        private int length;
        private Iterator<V> matches;

        private LongestMatchHandler() {
            this.matches = null;
            this.length = 0;
        }

        public int getMatchLength() {
            return this.length;
        }

        public Iterator<V> getMatches() {
            return this.matches;
        }

        @Override // com.ibm.icu.impl.TextTrieMap.ResultHandler
        public boolean handlePrefixMatch(int i, Iterator<V> it) {
            if (i <= this.length) {
                return true;
            }
            this.length = i;
            this.matches = it;
            return true;
        }

        public /* synthetic */ LongestMatchHandler(int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class Node {
        private List<TextTrieMap<V>.Node> _children;
        private char[] _text;
        private List<V> _values;

        private Node(char[] cArr, List<V> list, List<TextTrieMap<V>.Node> list2) {
            this._text = cArr;
            this._values = list;
            this._children = list2;
        }

        private void add(char[] cArr, int i, V v) {
            if (cArr.length == i) {
                this._values = addValue(this._values, v);
                return;
            }
            List<TextTrieMap<V>.Node> list = this._children;
            if (list == null) {
                this._children = new LinkedList();
                this._children.add(new Node(TextTrieMap.subArray(cArr, i), addValue(null, v), null));
                return;
            }
            ListIterator<TextTrieMap<V>.Node> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                TextTrieMap<V>.Node next = listIterator.next();
                char c = cArr[i];
                char c2 = next._text[0];
                if (c < c2) {
                    listIterator.previous();
                    break;
                }
                if (c == c2) {
                    int iLenMatches = next.lenMatches(cArr, i);
                    if (iLenMatches == next._text.length) {
                        next.add(cArr, i + iLenMatches, v);
                        return;
                    } else {
                        next.split(iLenMatches);
                        next.add(cArr, i + iLenMatches, v);
                        return;
                    }
                }
            }
            listIterator.add(new Node(TextTrieMap.subArray(cArr, i), addValue(null, v), null));
        }

        private List<V> addValue(List<V> list, V v) {
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(v);
            return list;
        }

        private int lenMatches(char[] cArr, int i) {
            int length = cArr.length - i;
            char[] cArr2 = this._text;
            if (cArr2.length < length) {
                length = cArr2.length;
            }
            int i2 = 0;
            while (i2 < length && this._text[i2] == cArr[i + i2]) {
                i2++;
            }
            return i2;
        }

        private boolean matchFollowing(CharIterator charIterator, Output output) {
            for (int i = 1; i < this._text.length; i++) {
                if (!charIterator.hasNext()) {
                    if (output != null) {
                        output.partialMatch = true;
                    }
                    return false;
                }
                if (charIterator.next().charValue() != this._text[i]) {
                    return false;
                }
            }
            return true;
        }

        private void split(int i) {
            char[] cArrSubArray = TextTrieMap.subArray(this._text, i);
            this._text = TextTrieMap.b(this._text, i);
            Node node = new Node(cArrSubArray, this._values, this._children);
            this._values = null;
            LinkedList linkedList = new LinkedList();
            this._children = linkedList;
            linkedList.add(node);
        }

        public int charCount() {
            char[] cArr = this._text;
            if (cArr == null) {
                return 0;
            }
            return cArr.length;
        }

        public TextTrieMap<V>.Node findMatch(CharIterator charIterator, Output output) {
            if (this._children == null) {
                return null;
            }
            if (!charIterator.hasNext()) {
                if (output != null) {
                    output.partialMatch = true;
                }
                return null;
            }
            Character next = charIterator.next();
            for (TextTrieMap<V>.Node node : this._children) {
                if (next.charValue() < node._text[0]) {
                    break;
                }
                if (next.charValue() == node._text[0]) {
                    if (node.matchFollowing(charIterator, output)) {
                        return node;
                    }
                }
            }
            return null;
        }

        public void putLeadCodePoints(UnicodeSet unicodeSet) {
            List<TextTrieMap<V>.Node> list = this._children;
            if (list == null) {
                return;
            }
            for (TextTrieMap<V>.Node node : list) {
                char c = node._text[0];
                if (!UCharacter.isHighSurrogate(c)) {
                    unicodeSet.add(c);
                } else if (node.charCount() >= 2) {
                    unicodeSet.add(Character.codePointAt(node._text, 0));
                } else {
                    List<TextTrieMap<V>.Node> list2 = node._children;
                    if (list2 != null) {
                        Iterator<TextTrieMap<V>.Node> it = list2.iterator();
                        while (it.hasNext()) {
                            unicodeSet.add(Character.toCodePoint(c, it.next()._text[0]));
                        }
                    }
                }
            }
        }

        public Iterator<V> values() {
            List<V> list = this._values;
            if (list == null) {
                return null;
            }
            return list.iterator();
        }

        private Node() {
        }

        public /* synthetic */ Node(TextTrieMap textTrieMap, int i) {
            this();
        }

        public void add(CharIterator charIterator, V v) {
            StringBuilder sb = new StringBuilder();
            while (charIterator.hasNext()) {
                sb.append(charIterator.next());
            }
            add(TextTrieMap.toCharArray(sb), 0, v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static char[] subArray(char[] cArr, int i) {
        if (i == 0) {
            return cArr;
        }
        int length = cArr.length - i;
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, i, cArr2, 0, length);
        return cArr2;
    }

    public Iterator<V> get(CharSequence charSequence, int i) {
        return get(charSequence, i, null);
    }

    public Iterator<V> get(String str) {
        return get(str, 0);
    }

    public void find(CharSequence charSequence, int i, ResultHandler<V> resultHandler) {
        find(charSequence, i, resultHandler, (Output) null);
    }

    private void find(CharSequence charSequence, int i, ResultHandler<V> resultHandler, Output output) {
        find(this._root, new CharIterator(charSequence, i, this._ignoreCase), resultHandler, output);
    }

    public void find(CharSequence charSequence, ResultHandler<V> resultHandler) {
        find(charSequence, 0, resultHandler, (Output) null);
    }
}
