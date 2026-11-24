package defpackage;

import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.text.latin.ModuleDescriptor;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qz2 {
    public static final qz2 c = new qz2();
    public final AtomicReference a = new AtomicReference();
    public final String b = "taser_tflite_gocrlatin_mbv2_scriptid_aksara_layout_gcn_mobile";

    public final boolean a() {
        AtomicReference atomicReference = this.a;
        if (atomicReference.get() != null) {
            return ((Boolean) atomicReference.get()).booleanValue();
        }
        boolean z = sg0.a(tj1.c().b(), ModuleDescriptor.MODULE_ID) > 0;
        atomicReference.set(Boolean.valueOf(z));
        return z;
    }

    public final String b() {
        return true != a() ? "play-services-mlkit-text-recognition" : "text-recognition";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof qz2) {
            return sr4.a(null, null);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{null});
    }
}
