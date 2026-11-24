package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import defpackage.dk0;
import defpackage.k53;
import defpackage.pi;
import defpackage.pj;
import defpackage.r23;
import defpackage.t5;
import defpackage.v02;
import defpackage.w02;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        r23.b(context);
        if (queryParameter == null) {
            dk0.n("Null backendName");
            return;
        }
        v02 v02VarB = w02.b(iIntValue);
        byte[] bArrDecode = queryParameter2 != null ? Base64.decode(queryParameter2, 0) : null;
        pi piVar = r23.a().d;
        ((Executor) piVar.e).execute(new k53(piVar, new pj(queryParameter, bArrDecode, v02VarB), i, t5.b));
    }
}
