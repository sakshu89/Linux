package defpackage;

import com.ibm.icu.impl.DayPeriodRules;
import com.ibm.icu.impl.links.LinkHandlingUtilities;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.Output;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y90 implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ y90(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return DayPeriodRules.lambda$deduplicateDayPeriodRulesData$0((DayPeriodRules.DayPeriod[]) obj2, (List) obj);
            case 1:
                return LinkHandlingUtilities.lambda$joinListEscaping$1((UnicodeSet) obj2, (String) obj);
            default:
                return LinkHandlingUtilities.UrlInternals.lambda$fullEscape$1((Output) obj2, (Map.Entry) obj);
        }
    }
}
