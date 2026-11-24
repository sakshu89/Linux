package com.ibm.icu.impl.number.parse;

import com.ibm.icu.impl.StringSegment;
import defpackage.cq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class SeriesMatcher implements NumberParseMatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected List<NumberParseMatcher> matchers = null;
    protected boolean frozen = false;

    public void addMatcher(NumberParseMatcher numberParseMatcher) {
        if (this.matchers == null) {
            this.matchers = new ArrayList();
        }
        this.matchers.add(numberParseMatcher);
    }

    public void freeze() {
        this.frozen = true;
    }

    public int length() {
        List<NumberParseMatcher> list = this.matchers;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean match(StringSegment stringSegment, ParsedNumber parsedNumber) {
        if (this.matchers == null) {
            return false;
        }
        ParsedNumber parsedNumber2 = new ParsedNumber();
        parsedNumber2.copyFrom(parsedNumber);
        int offset = stringSegment.getOffset();
        int i = 0;
        boolean z = true;
        while (i < this.matchers.size()) {
            NumberParseMatcher numberParseMatcher = this.matchers.get(i);
            int offset2 = stringSegment.getOffset();
            boolean zMatch = stringSegment.length() != 0 ? numberParseMatcher.match(stringSegment, parsedNumber) : true;
            boolean z2 = stringSegment.getOffset() != offset2;
            boolean z3 = numberParseMatcher instanceof NumberParseMatcher.Flexible;
            if (!z2 || !z3) {
                if (z2) {
                    i++;
                    if (i < this.matchers.size()) {
                        int offset3 = stringSegment.getOffset();
                        int i2 = parsedNumber.charEnd;
                        if (offset3 != i2 && i2 > offset2) {
                            stringSegment.setOffset(i2);
                        }
                    }
                } else {
                    if (!z3) {
                        stringSegment.setOffset(offset);
                        parsedNumber.copyFrom(parsedNumber2);
                        return zMatch;
                    }
                    i++;
                }
            }
            z = zMatch;
        }
        return z;
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public void postProcess(ParsedNumber parsedNumber) {
        if (this.matchers == null) {
            return;
        }
        for (int i = 0; i < this.matchers.size(); i++) {
            this.matchers.get(i).postProcess(parsedNumber);
        }
    }

    @Override // com.ibm.icu.impl.number.parse.NumberParseMatcher
    public boolean smokeTest(StringSegment stringSegment) {
        List<NumberParseMatcher> list = this.matchers;
        if (list == null) {
            return false;
        }
        return list.get(0).smokeTest(stringSegment);
    }

    public String toString() {
        return cq.v("<SeriesMatcher ", String.valueOf(this.matchers), ">");
    }
}
