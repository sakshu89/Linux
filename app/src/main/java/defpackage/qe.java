package defpackage;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class qe extends Exception {
    public final Status a;

    /* JADX WARN: Illegal instructions before constructor call */
    public qe(Status status) {
        int i = status.a;
        String str = status.b;
        super(i + ": " + (str == null ? "" : str));
        this.a = status;
    }
}
