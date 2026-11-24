package defpackage;

import com.project.sonic.MainActivity;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ag1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ MainActivity b;

    public /* synthetic */ ag1(MainActivity mainActivity, int i) {
        this.a = i;
        this.b = mainActivity;
    }

    public final void a(Object obj) {
        Object value;
        rn2 rn2Var;
        Object value2;
        boolean z;
        Object value3;
        int i = this.a;
        MainActivity mainActivity = this.b;
        switch (i) {
            case 0:
                Map map = (Map) obj;
                Set set = MainActivity.m0;
                map.getClass();
                so2 so2VarQ = mainActivity.q();
                jr2 jr2Var = so2VarQ.n;
                if (so2VarQ.b.g.e.a.getValue() instanceof pv1) {
                    uf4.b(gb4.c(so2VarQ), null, new sc2(so2VarQ, map, (x50) null, 9), 3);
                    break;
                } else {
                    Boolean bool = (Boolean) map.get("android.permission.RECORD_AUDIO");
                    if (so2VarQ.t) {
                        so2VarQ.t = false;
                        if (g31.a(bool, Boolean.TRUE)) {
                            do {
                                value2 = jr2Var.getValue();
                            } while (!jr2Var.h(value2, eo2.a((eo2) value2, so2VarQ.n(), "TAP TO SPEAK", "", null, null, ii0.a, null, null, false, false, false, false, false, null, 0L, 32656)));
                            if (!so2VarQ.o()) {
                                so2VarQ.q.s(new ho2(false));
                            } else {
                                so2VarQ.h(true);
                            }
                            break;
                        } else if (g31.a(bool, Boolean.FALSE)) {
                            do {
                                value = jr2Var.getValue();
                                rn2Var = rn2.t;
                            } while (!jr2Var.h(value, eo2.a((eo2) value, rn2Var, so2.m(rn2Var), "Without the microphone I can't hear you, but you can still type.", null, null, null, null, null, false, false, false, false, false, null, 0L, 32752)));
                        } else if (bool != null) {
                            dk0.l();
                            break;
                        }
                    }
                }
                break;
            default:
                Map map2 = (Map) obj;
                Set set2 = MainActivity.m0;
                map2.getClass();
                sj2 sj2VarS = mainActivity.s();
                if (map2.isEmpty()) {
                    z = false;
                } else {
                    Iterator it = map2.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                        } else if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                            z = true;
                        }
                    }
                }
                sj2VarS.e();
                jr2 jr2Var2 = sj2VarS.f;
                do {
                    value3 = jr2Var2.getValue();
                } while (!jr2Var2.h(value3, qj2.a((qj2) value3, null, null, false, false, z, null, 47)));
                break;
        }
    }
}
