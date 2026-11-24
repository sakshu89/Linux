package com.ibm.icu.message2;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface Function {
    @Deprecated
    FormattedPlaceholder format(Object obj, Map<String, ?> map);

    @Deprecated
    String formatToString(Object obj, Map<String, ?> map);

    @Deprecated
    default List<String> matches(Object obj, List<String> list, Map<String, ?> map) {
        return null;
    }
}
