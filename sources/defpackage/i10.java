package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i10 implements la2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ i10(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.la2
    public final Bundle a() {
        wt1[] wt1VarArr;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Bundle bundle = new Bundle();
                m10 m10Var = ((n10) obj).n;
                m10Var.getClass();
                LinkedHashMap linkedHashMap = m10Var.b;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(m10Var.d));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(m10Var.g));
                return bundle;
            case 1:
                Map mapD = ((ca2) obj).d();
                Bundle bundle2 = new Bundle();
                for (Map.Entry entry : mapD.entrySet()) {
                    String str = (String) entry.getKey();
                    List list = (List) entry.getValue();
                    bundle2.putParcelableArrayList(str, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
                }
                return bundle2;
            default:
                cj cjVar = (cj) obj;
                for (Map.Entry entry2 : bh1.h((LinkedHashMap) cjVar.f).entrySet()) {
                    cjVar.E(((jr2) entry2.getValue()).getValue(), (String) entry2.getKey());
                }
                for (Map.Entry entry3 : bh1.h((LinkedHashMap) cjVar.c).entrySet()) {
                    cjVar.E(((la2) entry3.getValue()).a(), (String) entry3.getKey());
                }
                LinkedHashMap linkedHashMap2 = (LinkedHashMap) cjVar.b;
                if (linkedHashMap2.isEmpty()) {
                    wt1VarArr = new wt1[0];
                } else {
                    ArrayList arrayList = new ArrayList(linkedHashMap2.size());
                    for (Map.Entry entry4 : linkedHashMap2.entrySet()) {
                        arrayList.add(new wt1((String) entry4.getKey(), entry4.getValue()));
                    }
                    wt1VarArr = (wt1[]) arrayList.toArray(new wt1[0]);
                }
                return bg4.a((wt1[]) Arrays.copyOf(wt1VarArr, wt1VarArr.length));
        }
    }
}
