package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import defpackage.cq;
import defpackage.og;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class SelectFormat extends Format {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 2993154333257524984L;
    private transient MessagePattern msgPattern;
    private String pattern = null;

    public SelectFormat(String str) {
        applyPattern(str);
    }

    public static int findSubMessage(MessagePattern messagePattern, int i, String str) {
        int iCountParts = messagePattern.countParts();
        int i2 = 0;
        do {
            int i3 = i + 1;
            MessagePattern.Part part = messagePattern.getPart(i);
            if (part.getType() == MessagePattern.Part.Type.ARG_LIMIT) {
                return i2;
            }
            if (messagePattern.partSubstringMatches(part, str)) {
                return i3;
            }
            if (i2 == 0 && messagePattern.partSubstringMatches(part, PluralRules.KEYWORD_OTHER)) {
                i2 = i3;
            }
            i = messagePattern.getLimitPartIndex(i3) + 1;
        } while (i < iCountParts);
        return i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        String str = this.pattern;
        if (str != null) {
            applyPattern(str);
        }
    }

    private void reset() {
        this.pattern = null;
        MessagePattern messagePattern = this.msgPattern;
        if (messagePattern != null) {
            messagePattern.clear();
        }
    }

    public void applyPattern(String str) {
        this.pattern = str;
        if (this.msgPattern == null) {
            this.msgPattern = new MessagePattern();
        }
        try {
            this.msgPattern.parseSelectStyle(str);
        } catch (RuntimeException e) {
            reset();
            throw e;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MessagePattern messagePattern = this.msgPattern;
        MessagePattern messagePattern2 = ((SelectFormat) obj).msgPattern;
        if (messagePattern == null) {
            return messagePattern2 == null;
        }
        return messagePattern.equals(messagePattern2);
    }

    public final String format(String str) {
        int index;
        StringBuilder sb = null;
        if (!PatternProps.isIdentifier(str)) {
            og.i("Invalid formatting argument.");
            return null;
        }
        MessagePattern messagePattern = this.msgPattern;
        if (messagePattern == null || messagePattern.countParts() == 0) {
            og.n("Invalid format error.");
            return null;
        }
        int iFindSubMessage = findSubMessage(this.msgPattern, 0, str);
        boolean zJdkAposMode = this.msgPattern.jdkAposMode();
        MessagePattern messagePattern2 = this.msgPattern;
        if (!zJdkAposMode) {
            return this.msgPattern.getPatternString().substring(this.msgPattern.getPart(iFindSubMessage).getLimit(), this.msgPattern.getPatternIndex(messagePattern2.getLimitPartIndex(iFindSubMessage)));
        }
        int limit = messagePattern2.getPart(iFindSubMessage).getLimit();
        while (true) {
            iFindSubMessage++;
            MessagePattern.Part part = this.msgPattern.getPart(iFindSubMessage);
            MessagePattern.Part.Type type = part.getType();
            index = part.getIndex();
            if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                break;
            }
            if (type == MessagePattern.Part.Type.SKIP_SYNTAX) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) this.pattern, limit, index);
                limit = part.getLimit();
            } else if (type == MessagePattern.Part.Type.ARG_START) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) this.pattern, limit, index);
                iFindSubMessage = this.msgPattern.getLimitPartIndex(iFindSubMessage);
                limit = this.msgPattern.getPart(iFindSubMessage).getLimit();
                MessagePattern.appendReducedApostrophes(this.pattern, index, limit, sb);
            }
        }
        String str2 = this.pattern;
        if (sb == null) {
            return str2.substring(limit, index);
        }
        sb.append((CharSequence) str2, limit, index);
        return sb.toString();
    }

    public int hashCode() {
        String str = this.pattern;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    public String toPattern() {
        return this.pattern;
    }

    public String toString() {
        return cq.v("pattern='", this.pattern, "'");
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof String) {
            stringBuffer.append(format((String) obj));
            return stringBuffer;
        }
        og.i(cq.v("'", String.valueOf(obj), "' is not a String"));
        return null;
    }
}
