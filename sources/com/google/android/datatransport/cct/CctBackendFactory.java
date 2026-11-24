package com.google.android.datatransport.cct;

import android.content.Context;
import defpackage.ci;
import defpackage.p23;
import defpackage.vw;
import defpackage.y70;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CctBackendFactory {
    public p23 create(y70 y70Var) {
        Context context = ((ci) y70Var).a;
        ci ciVar = (ci) y70Var;
        return new vw(context, ciVar.b, ciVar.c);
    }
}
