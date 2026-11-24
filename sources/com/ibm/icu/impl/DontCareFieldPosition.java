package com.ibm.icu.impl;

import java.text.FieldPosition;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class DontCareFieldPosition extends FieldPosition {
    public static final DontCareFieldPosition INSTANCE = new DontCareFieldPosition();

    private DontCareFieldPosition() {
        super(-913028704);
    }

    @Override // java.text.FieldPosition
    public void setBeginIndex(int i) {
    }

    @Override // java.text.FieldPosition
    public void setEndIndex(int i) {
    }
}
