package com.google.mlkit.vision.text.bundled.common;

import android.content.Context;
import android.os.RemoteException;
import defpackage.af3;
import defpackage.ap1;
import defpackage.hr3;
import defpackage.jg1;
import defpackage.ly0;
import defpackage.nr3;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class BundledTextRecognizerCreator extends hr3 {
    public BundledTextRecognizerCreator() {
        super("com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
    }

    @Override // defpackage.ir3
    public af3 newTextRecognizer(ly0 ly0Var) throws RemoteException {
        throw new RemoteException("Please use newTextRecognizerWithOptions instead.");
    }

    @Override // defpackage.ir3
    public af3 newTextRecognizerWithOptions(ly0 ly0Var, nr3 nr3Var) {
        Context context = (Context) ap1.g(ly0Var);
        jg1.d(context);
        return new af3(context, nr3Var.a, nr3Var.c, nr3Var.i, nr3Var.j);
    }
}
