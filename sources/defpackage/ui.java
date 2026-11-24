package defpackage;

import android.graphics.Rect;
import android.util.Size;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ui {
    public final UUID a;
    public final int b;
    public final int c;
    public final Rect d;
    public final Size e;
    public final int f;
    public final boolean g;

    public ui(UUID uuid, int i, int i2, Rect rect, Size size, int i3, boolean z) {
        if (uuid == null) {
            dk0.n("Null getUuid");
            throw null;
        }
        this.a = uuid;
        this.b = i;
        this.c = i2;
        if (rect == null) {
            dk0.n("Null getCropRect");
            throw null;
        }
        this.d = rect;
        if (size == null) {
            dk0.n("Null getSize");
            throw null;
        }
        this.e = size;
        this.f = i3;
        this.g = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ui)) {
            return false;
        }
        ui uiVar = (ui) obj;
        return this.a.equals(uiVar.a) && this.b == uiVar.b && this.c == uiVar.c && this.d.equals(uiVar.d) && this.e.equals(uiVar.e) && this.f == uiVar.f && this.g == uiVar.g;
    }

    public final int hashCode() {
        return (((this.g ? 1231 : 1237) ^ ((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f) * 1000003)) * 1000003) ^ 1237;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OutConfig{getUuid=");
        sb.append(this.a);
        sb.append(", getTargets=");
        sb.append(this.b);
        sb.append(", getFormat=");
        sb.append(this.c);
        sb.append(", getCropRect=");
        sb.append(this.d);
        sb.append(", getSize=");
        sb.append(this.e);
        sb.append(", getRotationDegrees=");
        sb.append(this.f);
        sb.append(", isMirroring=");
        return ky0.o(sb, this.g, ", shouldRespectInputCropRect=false}");
    }
}
