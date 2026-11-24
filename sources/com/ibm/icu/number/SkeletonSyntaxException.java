package com.ibm.icu.number;

import defpackage.cq;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class SkeletonSyntaxException extends IllegalArgumentException {
    private static final long serialVersionUID = 7733971331648360554L;

    public SkeletonSyntaxException(String str, CharSequence charSequence) {
        super(cq.l("Syntax error in skeleton string: ", str, ": ", String.valueOf(charSequence)));
    }

    public SkeletonSyntaxException(String str, CharSequence charSequence, Throwable th) {
        super(cq.l("Syntax error in skeleton string: ", str, ": ", String.valueOf(charSequence)), th);
    }
}
