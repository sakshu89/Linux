package defpackage;

import android.hardware.camera2.params.InputConfiguration;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class h11 {
    public final InputConfiguration a;

    public h11(Object obj) {
        this.a = (InputConfiguration) obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h11)) {
            return false;
        }
        return Objects.equals(this.a, ((h11) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString();
    }
}
