package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import defpackage.dk0;
import defpackage.k53;
import defpackage.or0;
import defpackage.pi;
import defpackage.pj;
import defpackage.r23;
import defpackage.v02;
import defpackage.w02;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    public static final /* synthetic */ int a = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        r23.b(getApplicationContext());
        if (string == null) {
            dk0.n("Null backendName");
            return false;
        }
        v02 v02VarB = w02.b(i);
        byte[] bArrDecode = string2 != null ? Base64.decode(string2, 0) : null;
        pi piVar = r23.a().d;
        ((Executor) piVar.e).execute(new k53(piVar, new pj(string, bArrDecode, v02VarB), i2, new or0(6, this, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
