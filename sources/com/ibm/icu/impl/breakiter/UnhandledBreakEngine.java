package com.ibm.icu.impl.breakiter;

import com.ibm.icu.impl.CharacterIteration;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UProperty;
import com.ibm.icu.text.UnicodeSet;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UnhandledBreakEngine implements LanguageBreakEngine {
    volatile UnicodeSet fHandled = new UnicodeSet();

    @Override // com.ibm.icu.impl.breakiter.LanguageBreakEngine
    public int findBreaks(CharacterIterator characterIterator, int i, int i2, DictionaryBreakEngine.DequeI dequeI, boolean z) {
        UnicodeSet unicodeSet = this.fHandled;
        int iCurrent32 = CharacterIteration.current32(characterIterator);
        while (characterIterator.getIndex() < i2 && unicodeSet.contains(iCurrent32)) {
            CharacterIteration.next32(characterIterator);
            iCurrent32 = CharacterIteration.current32(characterIterator);
        }
        return 0;
    }

    public void handleChar(int i) {
        UnicodeSet unicodeSet = this.fHandled;
        if (unicodeSet.contains(i)) {
            return;
        }
        int intPropertyValue = UCharacter.getIntPropertyValue(i, UProperty.SCRIPT);
        UnicodeSet unicodeSet2 = new UnicodeSet();
        unicodeSet2.applyIntPropertyValue(UProperty.SCRIPT, intPropertyValue);
        unicodeSet2.addAll(unicodeSet);
        this.fHandled = unicodeSet2;
    }

    @Override // com.ibm.icu.impl.breakiter.LanguageBreakEngine
    public boolean handles(int i) {
        return this.fHandled.contains(i);
    }
}
