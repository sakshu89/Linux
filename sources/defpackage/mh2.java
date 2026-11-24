package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mh2 implements nh2 {
    public final List a;
    public final vs b;
    public final ch2 c;
    public j11 d = null;

    public mh2(ArrayList arrayList, ch2 ch2Var, vs vsVar) {
        this.a = Collections.unmodifiableList(new ArrayList(arrayList));
        this.b = vsVar;
        this.c = ch2Var;
    }

    @Override // defpackage.nh2
    public final Object a() {
        return null;
    }

    @Override // defpackage.nh2
    public final int b() {
        return 0;
    }

    @Override // defpackage.nh2
    public final CameraCaptureSession.StateCallback c() {
        return this.b;
    }

    @Override // defpackage.nh2
    public final List d() {
        return this.a;
    }

    @Override // defpackage.nh2
    public final j11 e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof mh2) {
            mh2 mh2Var = (mh2) obj;
            List list = mh2Var.a;
            if (Objects.equals(this.d, mh2Var.d)) {
                List list2 = this.a;
                if (list2.size() == list.size()) {
                    for (int i = 0; i < list2.size(); i++) {
                        if (((ws1) list2.get(i)).equals(list.get(i))) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.nh2
    public final Executor f() {
        return this.c;
    }

    @Override // defpackage.nh2
    public final void h(j11 j11Var) {
        this.d = j11Var;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 31;
        int i = (iHashCode << 5) - iHashCode;
        j11 j11Var = this.d;
        int iHashCode2 = (j11Var == null ? 0 : j11Var.a.a.hashCode()) ^ i;
        return (iHashCode2 << 5) - iHashCode2;
    }

    @Override // defpackage.nh2
    public final void g(CaptureRequest captureRequest) {
    }
}
