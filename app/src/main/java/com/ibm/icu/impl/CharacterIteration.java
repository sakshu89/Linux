package com.ibm.icu.impl;

import com.ibm.icu.text.UTF16;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CharacterIteration {
    public static final int DONE32 = Integer.MAX_VALUE;

    private CharacterIteration() {
    }

    public static int current32(CharacterIterator characterIterator) {
        char cCurrent = characterIterator.current();
        if (cCurrent >= 55296) {
            if (UTF16.isLeadSurrogate(cCurrent)) {
                char next = characterIterator.next();
                characterIterator.previous();
                if (UTF16.isTrailSurrogate(next)) {
                    return (next - UTF16.TRAIL_SURROGATE_MIN_VALUE) + ((cCurrent - 55296) << 10) + 65536;
                }
            } else if (cCurrent == 65535 && characterIterator.getIndex() >= characterIterator.getEndIndex()) {
                return Integer.MAX_VALUE;
            }
        }
        return cCurrent;
    }

    public static int next32(CharacterIterator characterIterator) {
        char next;
        char cCurrent = characterIterator.current();
        if (cCurrent >= 55296 && cCurrent <= 56319 && ((next = characterIterator.next()) < 56320 || next > 57343)) {
            characterIterator.previous();
        }
        int next2 = characterIterator.next();
        if (next2 >= 55296) {
            next2 = nextTrail32(characterIterator, next2);
        }
        if (next2 >= 65536 && next2 != Integer.MAX_VALUE) {
            characterIterator.previous();
        }
        return next2;
    }

    public static int nextTrail32(CharacterIterator characterIterator, int i) {
        if (i == 65535 && characterIterator.getIndex() >= characterIterator.getEndIndex()) {
            return Integer.MAX_VALUE;
        }
        if (i <= 56319) {
            char next = characterIterator.next();
            if (UTF16.isTrailSurrogate(next)) {
                return (next - UTF16.TRAIL_SURROGATE_MIN_VALUE) + ((i - 55296) << 10) + 65536;
            }
            characterIterator.previous();
        }
        return i;
    }

    public static int previous32(CharacterIterator characterIterator) {
        if (characterIterator.getIndex() <= characterIterator.getBeginIndex()) {
            return Integer.MAX_VALUE;
        }
        char cPrevious = characterIterator.previous();
        if (UTF16.isTrailSurrogate(cPrevious) && characterIterator.getIndex() > characterIterator.getBeginIndex()) {
            char cPrevious2 = characterIterator.previous();
            if (UTF16.isLeadSurrogate(cPrevious2)) {
                return (cPrevious - UTF16.TRAIL_SURROGATE_MIN_VALUE) + ((cPrevious2 - 55296) << 10) + 65536;
            }
            characterIterator.next();
        }
        return cPrevious;
    }
}
