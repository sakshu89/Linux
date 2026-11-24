package androidx.profileinstaller;

import android.content.Context;
import android.view.Choreographer;
import defpackage.m12;
import defpackage.su0;
import defpackage.w01;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements w01 {
    @Override // defpackage.w01
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // defpackage.w01
    public final Object b(Context context) {
        Choreographer.getInstance().postFrameCallback(new m12(this, context.getApplicationContext()));
        return new su0(17);
    }
}
