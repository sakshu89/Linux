package com.ibm.icu.impl;

import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.CharsTrie;
import com.ibm.icu.util.CodePointMap;
import com.ibm.icu.util.CodePointTrie;
import com.ibm.icu.util.ICUUncheckedIOException;
import defpackage.kf2;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiProps {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BIT_BASIC_EMOJI = 6;
    private static final int BIT_EMOJI = 0;
    private static final int BIT_EMOJI_COMPONENT = 4;
    private static final int BIT_EMOJI_MODIFIER = 2;
    private static final int BIT_EMOJI_MODIFIER_BASE = 3;
    private static final int BIT_EMOJI_PRESENTATION = 1;
    private static final int BIT_EXTENDED_PICTOGRAPHIC = 5;
    private static final int DATA_FORMAT = 1164799850;
    private static final int IX_BASIC_EMOJI_TRIE_OFFSET = 4;
    private static final int IX_CPTRIE_OFFSET = 0;
    private static final int IX_RGI_EMOJI_ZWJ_SEQUENCE_TRIE_OFFSET = 9;
    private CodePointTrie.Fast8 cpTrie;
    private String[] stringTries = new String[6];
    private static final IsAcceptable IS_ACCEPTABLE = new IsAcceptable(0);
    public static final EmojiProps INSTANCE = new EmojiProps();
    private static final byte[] bitFlags = {0, 1, 2, 3, 4, -1, -1, 5, 6, -1, -1, -1, -1, -1, 6};

    private EmojiProps() {
        this.cpTrie = null;
        ByteBuffer requiredData = ICUBinary.getRequiredData("uemoji.icu");
        try {
            ICUBinary.readHeaderAndDataVersion(requiredData, DATA_FORMAT, IS_ACCEPTABLE);
            int iPosition = requiredData.position();
            int i = requiredData.getInt();
            int i2 = i / 4;
            if (i2 <= 9) {
                throw new ICUUncheckedIOException("Emoji properties data: not enough indexes");
            }
            int[] iArr = new int[i2];
            iArr[0] = i;
            for (int i3 = 1; i3 < i2; i3++) {
                iArr[i3] = requiredData.getInt();
            }
            int i4 = iArr[0];
            int i5 = iArr[1];
            this.cpTrie = CodePointTrie.Fast8.fromBinary(requiredData);
            ICUBinary.skipBytes(requiredData, i5 - (requiredData.position() - iPosition));
            int i6 = 4;
            ICUBinary.skipBytes(requiredData, iArr[4] - i5);
            while (i6 <= 9) {
                int i7 = iArr[i6];
                int i8 = i6 + 1;
                int i9 = iArr[i8];
                if (i9 > i7) {
                    this.stringTries[getStringTrieIndex(i6)] = ICUBinary.getString(requiredData, (i9 - i7) / 2, 0);
                }
                i6 = i8;
            }
        } catch (IOException e) {
            kf2.h(e);
            throw null;
        }
    }

    private static int getStringTrieIndex(int i) {
        return i - 4;
    }

    public UnicodeSet addPropertyStarts(UnicodeSet unicodeSet) {
        CodePointMap.Range range = new CodePointMap.Range();
        for (int end = 0; this.cpTrie.getRange(end, null, range); end = range.getEnd() + 1) {
            unicodeSet.add(end);
        }
        return unicodeSet;
    }

    public void addStrings(int i, UnicodeSet unicodeSet) {
        int i2;
        if (i < 65 || 71 < i) {
            return;
        }
        if (i == 71) {
            i2 = 70;
            i = 65;
        } else {
            i2 = i;
        }
        while (i <= i2) {
            String str = this.stringTries[i - 65];
            if (str != null) {
                Iterator<CharsTrie.Entry> itIterator2 = new CharsTrie(str, 0).iterator2();
                while (itIterator2.hasNext()) {
                    unicodeSet.add(itIterator2.next().chars);
                }
            }
            i++;
        }
    }

    public boolean hasBinaryProperty(CharSequence charSequence, int i) {
        int i2;
        int length = charSequence.length();
        if (length != 0 && i >= 65 && 71 >= i) {
            if (i == 71) {
                i2 = 70;
                i = 65;
            } else {
                i2 = i;
            }
            while (i <= i2) {
                String str = this.stringTries[i - 65];
                if (str != null && new CharsTrie(str, 0).next(charSequence, 0, length).hasValue()) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class IsAcceptable implements ICUBinary.Authenticate {
        public /* synthetic */ IsAcceptable(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            return bArr[0] == 1;
        }

        private IsAcceptable() {
        }
    }

    public boolean hasBinaryProperty(int i, int i2) {
        byte b;
        return i2 >= 57 && 71 >= i2 && (b = bitFlags[i2 - 57]) >= 0 && ((this.cpTrie.get(i) >> b) & 1) != 0;
    }
}
