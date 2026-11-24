package com.ibm.icu.impl.number;

import com.ibm.icu.impl.StandardPlural;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface ModifierStore {
    Modifier getModifier(Modifier.Signum signum, StandardPlural standardPlural);
}
