package com.ibm.icu.impl;

import defpackage.cq;
import defpackage.og;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UResource {

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface Array {
        int getSize();

        boolean getValue(int i, Value value);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class Sink {
        public abstract void put(Key key, Value value, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface Table {
        boolean findValue(CharSequence charSequence, Value value);

        boolean getKeyAndValue(int i, Key key, Value value);

        int getSize();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class Value {
        public abstract String getAliasString();

        public abstract Array getArray();

        public abstract ByteBuffer getBinary();

        public abstract int getInt();

        public abstract int[] getIntVector();

        public abstract String getString();

        public abstract String[] getStringArray();

        public abstract String[] getStringArrayOrStringAsArray();

        public abstract String getStringOrFirstOfArray();

        public abstract Table getTable();

        public abstract int getType();

        public abstract int getUInt();

        public abstract boolean isNoInheritanceMarker();

        public String toString() {
            int type = getType();
            if (type == 0) {
                return getString();
            }
            if (type == 1) {
                return "(binary blob)";
            }
            if (type == 2) {
                return "(table)";
            }
            if (type == 7) {
                return Integer.toString(getInt());
            }
            if (type == 8) {
                return "(array)";
            }
            if (type != 14) {
                return "???";
            }
            int[] intVector = getIntVector();
            StringBuilder sb = new StringBuilder("[");
            sb.append(intVector.length);
            sb.append("]{");
            if (intVector.length != 0) {
                sb.append(intVector[0]);
                for (int i = 1; i < intVector.length; i++) {
                    sb.append(", ");
                    sb.append(intVector[i]);
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Key implements CharSequence, Cloneable, Comparable<Key> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private byte[] bytes;
        private int length;
        private int offset;
        private String s;

        private Key(byte[] bArr, int i, int i2) {
            this.bytes = bArr;
            this.offset = i;
            this.length = i2;
        }

        private String internalSubString(int i, int i2) {
            StringBuilder sb = new StringBuilder(i2 - i);
            while (i < i2) {
                sb.append((char) this.bytes[this.offset + i]);
                i++;
            }
            return sb.toString();
        }

        private boolean regionMatches(int i, CharSequence charSequence, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.bytes[this.offset + i + i3] != charSequence.charAt(i3)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return (char) this.bytes[this.offset + i];
        }

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Key m6clone() {
            try {
                return (Key) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public int compareTo(CharSequence charSequence) {
            int length = charSequence.length();
            int i = this.length;
            if (i > length) {
                i = length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                int iCharAt = charAt(i2) - charSequence.charAt(i2);
                if (iCharAt != 0) {
                    return iCharAt;
                }
            }
            return this.length - length;
        }

        public boolean contentEquals(CharSequence charSequence) {
            if (charSequence == null) {
                return false;
            }
            if (this == charSequence) {
                return true;
            }
            int length = charSequence.length();
            int i = this.length;
            return length == i && regionMatches(0, charSequence, i);
        }

        public boolean endsWith(CharSequence charSequence) {
            int length = charSequence.length();
            int i = this.length;
            return length <= i && regionMatches(i - length, charSequence, length);
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj instanceof Key) {
                Key key = (Key) obj;
                int i = this.length;
                if (i == key.length && regionMatches(key.bytes, key.offset, i)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            if (this.length == 0) {
                return 0;
            }
            int i = this.bytes[this.offset];
            for (int i2 = 1; i2 < this.length; i2++) {
                i = (i * 37) + this.bytes[this.offset];
            }
            return i;
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.length;
        }

        public Key setBytes(byte[] bArr, int i) {
            this.bytes = bArr;
            this.offset = i;
            int i2 = 0;
            while (true) {
                this.length = i2;
                int i3 = this.length;
                if (bArr[i + i3] == 0) {
                    this.s = null;
                    return this;
                }
                i2 = i3 + 1;
            }
        }

        public Key setString(String str) {
            if (str.isEmpty()) {
                setToEmpty();
                return this;
            }
            this.bytes = new byte[str.length()];
            this.offset = 0;
            this.length = str.length();
            for (int i = 0; i < this.length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt > 127) {
                    og.i(cq.v("\"", str, "\" is not an ASCII string"));
                    return null;
                }
                this.bytes[i] = (byte) cCharAt;
            }
            this.s = str;
            return this;
        }

        public Key setToEmpty() {
            this.bytes = null;
            this.length = 0;
            this.offset = 0;
            this.s = "";
            return this;
        }

        public boolean startsWith(CharSequence charSequence) {
            int length = charSequence.length();
            return length <= this.length && regionMatches(0, charSequence, length);
        }

        @Override // java.lang.CharSequence
        public Key subSequence(int i, int i2) {
            return new Key(this.bytes, this.offset + i, i2 - i);
        }

        public String substring(int i) {
            return internalSubString(i, this.length);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            if (this.s == null) {
                this.s = internalSubString(0, this.length);
            }
            return this.s;
        }

        public String substring(int i, int i2) {
            return internalSubString(i, i2);
        }

        public Key(String str) {
            setString(str);
        }

        public Key() {
            this.s = "";
        }

        private boolean regionMatches(byte[] bArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.bytes[this.offset + i3] != bArr[i + i3]) {
                    return false;
                }
            }
            return true;
        }

        public boolean regionMatches(int i, CharSequence charSequence) {
            int length = charSequence.length();
            return length == this.length - i && regionMatches(i, charSequence, length);
        }

        @Override // java.lang.Comparable
        public int compareTo(Key key) {
            return compareTo((CharSequence) key);
        }
    }
}
