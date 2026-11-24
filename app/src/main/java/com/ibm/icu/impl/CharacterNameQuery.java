package com.ibm.icu.impl;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class CharacterNameQuery {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    boolean is1180;
    StringBuilder skeleton = new StringBuilder(120);

    public CharacterNameQuery(CharSequence charSequence) {
        int i = 0;
        while (i < charSequence.length()) {
            if (this.skeleton.length() >= this.skeleton.capacity()) {
                this.skeleton.setLength(0);
                break;
            }
            if (charSequence.charAt(i) != ' ' && charSequence.charAt(i) != '_') {
                if (charSequence.charAt(i) == '-') {
                    boolean z = true;
                    boolean z2 = i != 0 && i != charSequence.length() - 1 && isASCIILetterOrDigit(charSequence.charAt(i + (-1))) && isASCIILetterOrDigit(charSequence.charAt(i + 1));
                    if (z2 && Character.toUpperCase(charSequence.charAt(i + 1)) == 'E' && "HANGULJUNGSEONGO".contentEquals(this.skeleton)) {
                        for (int i2 = i + 2; i2 < charSequence.length(); i2++) {
                            if (charSequence.charAt(i2) != ' ' && charSequence.charAt(i2) != '_') {
                                z = false;
                            }
                        }
                    } else {
                        z = false;
                    }
                    if (!z2 || z) {
                        this.skeleton.append(charSequence.charAt(i));
                    }
                } else {
                    this.skeleton.append(Character.toUpperCase(charSequence.charAt(i)));
                }
            }
            i++;
        }
        this.is1180 = "HANGULJUNGSEONGO-E".contentEquals(this.skeleton);
    }

    private static boolean isASCIILetterOrDigit(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (c < 'a' || c > 'z') {
            return c >= '0' && c <= '9';
        }
        return true;
    }

    public Matcher matcher() {
        return new Matcher(this, 0);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Matcher {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        char lastChar;
        private CharacterNameQuery query;
        private int skeletonIterator;

        private Matcher(CharacterNameQuery characterNameQuery) {
            this.lastChar = ' ';
            this.query = characterNameQuery;
            this.skeletonIterator = 0;
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0047  */
        /* JADX WARN: Code duplicated, block: B:23:0x0057 A[RETURN] */
        public boolean consistentWith(char c) {
            StringBuilder sb;
            int i;
            if (this.skeletonIterator == this.query.skeleton.length()) {
                return false;
            }
            if (c == ' ') {
                if (this.lastChar == '-') {
                    StringBuilder sb2 = this.query.skeleton;
                    int i2 = this.skeletonIterator;
                    this.skeletonIterator = i2 + 1;
                    if (sb2.charAt(i2) != this.lastChar) {
                        return false;
                    }
                }
                this.lastChar = c;
                return true;
            }
            if (c != '-') {
                StringBuilder sb3 = this.query.skeleton;
                int i3 = this.skeletonIterator;
                this.skeletonIterator = i3 + 1;
                if (sb3.charAt(i3) != c) {
                    return false;
                }
                this.lastChar = c;
                return true;
            }
            if (this.lastChar != ' ') {
                CharacterNameQuery characterNameQuery = this.query;
                if (characterNameQuery.is1180 && this.skeletonIterator == characterNameQuery.skeleton.length() - 2) {
                    sb = this.query.skeleton;
                    i = this.skeletonIterator;
                    this.skeletonIterator = i + 1;
                    if (sb.charAt(i) != c) {
                        return false;
                    }
                }
            } else {
                sb = this.query.skeleton;
                i = this.skeletonIterator;
                this.skeletonIterator = i + 1;
                if (sb.charAt(i) != c) {
                    return false;
                }
            }
            this.lastChar = c;
            return true;
        }

        public boolean matches() {
            return this.skeletonIterator == this.query.skeleton.length();
        }

        public CharSequence remainingSignificantCharacters() {
            StringBuilder sb = this.query.skeleton;
            return sb.subSequence(this.skeletonIterator, sb.length());
        }

        public /* synthetic */ Matcher(CharacterNameQuery characterNameQuery, int i) {
            this(characterNameQuery);
        }

        public boolean consistentWith(CharSequence charSequence) {
            for (int i = 0; i < charSequence.length(); i++) {
                if (!consistentWith(charSequence.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
