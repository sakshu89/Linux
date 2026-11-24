package defpackage;

import com.ibm.icu.lang.UCharacter;
import java.util.function.IntPredicate;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class te implements IntPredicate {
    public final /* synthetic */ int a;

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        String str;
        switch (this.a) {
            case 0:
                return Character.isLetter(i) && Character.UnicodeScript.of(i) != Character.UnicodeScript.LATIN;
            case 1:
                n61 n61Var = n61.a;
                if (n61.b(i)) {
                    return true;
                }
                if (UCharacter.isDigit(i) && (48 > i || i >= 58)) {
                    return true;
                }
                switch (i) {
                    case 1548:
                    case 1644:
                        str = ",";
                        break;
                    case 1563:
                        str = ";";
                        break;
                    case 1567:
                    case 43761:
                        str = "?";
                        break;
                    case 1642:
                        str = "%";
                        break;
                    case 1643:
                    case 1748:
                    case 2404:
                    case 2405:
                    case 7294:
                    case 7295:
                    case 43760:
                    case 44011:
                        str = ".";
                        break;
                    default:
                        str = null;
                        break;
                }
                return str != null;
            case 2:
                return UCharacter.isLetter(i);
            default:
                return n61.b(i);
        }
    }

    public /* synthetic */ te(int i) {
        this.a = i;
    }
}
