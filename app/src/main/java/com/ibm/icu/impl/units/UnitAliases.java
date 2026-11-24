package com.ibm.icu.impl.units;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.IllegalIcuArgumentException;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UnitAliases {
    private final Map<String, String> mapAliasToReplacement;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Alias {
        public final String alias;
        public final String replacement;

        public Alias(String str, String str2) {
            this.alias = str;
            this.replacement = str2;
        }
    }

    public UnitAliases() {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "metadata");
        AllAliasSink allAliasSink = new AllAliasSink(0);
        iCUResourceBundle.getAllChildrenWithFallback("alias/unit", allAliasSink);
        this.mapAliasToReplacement = allAliasSink.getAliasMap();
    }

    public List<Alias> getAliases() {
        ArrayList arrayList = new ArrayList(this.mapAliasToReplacement.size());
        for (Map.Entry<String, String> entry : this.mapAliasToReplacement.entrySet()) {
            arrayList.add(new Alias(entry.getKey(), entry.getValue()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String getReplacement(String str) {
        return this.mapAliasToReplacement.get(str);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class AllAliasSink extends UResource.Sink {
        private final Map<String, String> mapAliasToReplacement;

        private AllAliasSink() {
            this.mapAliasToReplacement = new HashMap();
        }

        public Map<String, String> getAliasMap() {
            return Collections.unmodifiableMap(this.mapAliasToReplacement);
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            String string = key.toString();
            if (!value.getTable().findValue("replacement", value)) {
                throw new IllegalIcuArgumentException(cq.j("No replacement found for alias: ", string));
            }
            this.mapAliasToReplacement.put(string, value.toString());
        }

        public /* synthetic */ AllAliasSink(int i) {
            this();
        }
    }
}
