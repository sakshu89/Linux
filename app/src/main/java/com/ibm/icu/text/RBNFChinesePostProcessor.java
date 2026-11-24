package com.ibm.icu.text;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class RBNFChinesePostProcessor implements RBNFPostProcessor {
    private static final String[] rulesetNames = {"%traditional", "%simplified", "%accounting", "%time"};
    private int format;
    private boolean longForm;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.ibm.icu.text.RBNFPostProcessor
    public void process(StringBuilder sb, NFRuleSet nFRuleSet) {
        String name = nFRuleSet.getName();
        int i = 0;
        while (true) {
            String[] strArr = rulesetNames;
            if (i >= strArr.length) {
                break;
            }
            if (strArr[i].equals(name)) {
                this.format = i;
                this.longForm = i == 1 || i == 3;
                break;
            }
            i++;
        }
        if (this.longForm) {
            int iIndexOf = sb.indexOf("*");
            while (iIndexOf != -1) {
                sb.delete(iIndexOf, iIndexOf + 1);
                iIndexOf = sb.indexOf("*", iIndexOf);
            }
            return;
        }
        String[][] strArr2 = {new String[]{"萬", "億", "兆", "〇"}, new String[]{"万", "亿", "兆", "〇"}, new String[]{"萬", "億", "兆", "零"}};
        String[] strArr3 = strArr2[this.format];
        for (int i2 = 0; i2 < strArr3.length - 1; i2++) {
            int iIndexOf2 = sb.indexOf(strArr3[i2]);
            if (iIndexOf2 != -1) {
                sb.insert(strArr3[i2].length() + iIndexOf2, '|');
            }
        }
        int iIndexOf3 = sb.indexOf("點");
        if (iIndexOf3 == -1) {
            iIndexOf3 = sb.length();
        }
        String str = strArr2[this.format][3];
        int i3 = 0;
        int i4 = -1;
        while (iIndexOf3 >= 0) {
            int iLastIndexOf = sb.lastIndexOf("|", iIndexOf3);
            int iLastIndexOf2 = sb.lastIndexOf(str, iIndexOf3);
            int i5 = iLastIndexOf2 > iLastIndexOf ? (iLastIndexOf2 <= 0 || sb.charAt(iLastIndexOf2 + (-1)) == '*') ? 1 : 2 : 0;
            int i6 = iLastIndexOf - 1;
            switch ((i3 * 3) + i5) {
                case 0:
                case 2:
                case 3:
                case 6:
                case 8:
                    i4 = -1;
                    i3 = i5;
                    iIndexOf3 = i6;
                    break;
                case 1:
                    i4 = iLastIndexOf2;
                    i3 = i5;
                    iIndexOf3 = i6;
                    break;
                case 4:
                    sb.delete(iLastIndexOf2 - 1, str.length() + iLastIndexOf2);
                    i3 = 0;
                    i4 = -1;
                    iIndexOf3 = i6;
                    break;
                case 5:
                    sb.delete(i4 - 1, str.length() + i4);
                    i4 = -1;
                    i3 = i5;
                    iIndexOf3 = i6;
                    break;
                case 7:
                    sb.delete(iLastIndexOf2 - 1, str.length() + iLastIndexOf2);
                    i3 = 0;
                    i4 = -1;
                    iIndexOf3 = i6;
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
        int length = sb.length();
        while (true) {
            int i7 = length - 1;
            if (i7 < 0) {
                return;
            }
            char cCharAt = sb.charAt(i7);
            if (cCharAt == '*' || cCharAt == '|') {
                sb.delete(i7, length);
            }
            length = i7;
        }
    }

    @Override // com.ibm.icu.text.RBNFPostProcessor
    public void init(RuleBasedNumberFormat ruleBasedNumberFormat, String str) {
    }
}
