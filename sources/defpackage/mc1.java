package defpackage;

import com.ibm.icu.impl.ValidIdentifiers;
import com.ibm.icu.impl.links.LinkHandlingUtilities;
import com.ibm.icu.segmenter.Segment;
import com.ibm.icu.util.MeasureUnit;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.MatchResult;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mc1 implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ mc1(int i) {
        this.a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return LinkHandlingUtilities.lambda$cleanList$2((String) obj);
            case 1:
                return LinkHandlingUtilities.unescape((String) obj);
            case 2:
                return LinkHandlingUtilities.lambda$appendCheckingPercent$5((MatchResult) obj);
            case 3:
                return MeasureUnit.lambda$addUnit$0((String) obj);
            case 4:
                return ((Segment) obj).getSubSequence();
            case 5:
                return ((String) obj).trim();
            case 6:
                return ValidIdentifiers.ValiditySet.lambda$new$0((String) obj);
            case 7:
                LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
                HashSet hashSet = new HashSet(linkedHashSet.size());
                for (Object obj2 : linkedHashSet) {
                    Objects.requireNonNull(obj2);
                    hashSet.add(obj2);
                }
                return Collections.unmodifiableSet(hashSet);
            default:
                return ((Map.Entry) obj).toString();
        }
    }
}
