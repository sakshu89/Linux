package defpackage;

import com.ibm.icu.impl.CalendarAstronomer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tj0 implements zk0 {
    public final /* synthetic */ int a;

    public /* synthetic */ tj0(int i) {
        this.a = i;
    }

    @Override // defpackage.c22
    public final Object get() {
        switch (this.a) {
            case 0:
                return new w31(Executors.newSingleThreadExecutor());
            default:
                nr4 nr4Var = new nr4(20);
                HashMap map = new HashMap();
                Set set = Collections.EMPTY_SET;
                if (set == null) {
                    dk0.n("Null flags");
                    return null;
                }
                map.put(v02.a, new bj(30000L, CalendarAstronomer.DAY_MS, set));
                if (set == null) {
                    dk0.n("Null flags");
                    return null;
                }
                map.put(v02.c, new bj(1000L, CalendarAstronomer.DAY_MS, set));
                if (set == null) {
                    dk0.n("Null flags");
                    return null;
                }
                Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(bb2.a, bb2.b)));
                if (setUnmodifiableSet == null) {
                    dk0.n("Null flags");
                    return null;
                }
                map.put(v02.b, new bj(CalendarAstronomer.DAY_MS, CalendarAstronomer.DAY_MS, setUnmodifiableSet));
                if (map.keySet().size() >= v02.values().length) {
                    new HashMap();
                    return new aj(nr4Var, map);
                }
                og.n("Not all priorities have been configured");
                return null;
        }
    }
}
