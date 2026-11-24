package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jw {
    public final List a;

    public jw(List list) {
        if (list == null || list.isEmpty()) {
            og.i("Cannot set an empty CaptureStage list.");
            throw null;
        }
        this.a = Collections.unmodifiableList(new ArrayList(list));
    }
}
